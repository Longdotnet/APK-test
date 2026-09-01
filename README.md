# TikTok Follower-Farm Research Platform

A .NET 10 research project that combines two layers:

1. **Real TikTok integration** through TikTok Login Kit OAuth + official Display API to read an authorized creator account's real profile and recent-video metrics.
2. **Closed follower-farm simulator** that models account creation, inventory, workers, campaigns, failures, refill, and replenishment without creating real TikTok bot accounts or delivering fake engagement.

The real-data layer validates the pain point. The simulator explains the system mechanics behind the pain point.

## Research question

A creator may observe a mismatch such as:

```text
Followers: 10,000
Recent video views: a few hundred
```

Follower count alone does not prove audience quality. This project therefore measures real TikTok follower/reach/engagement data for an authorized account, then compares those observations with controlled synthetic follower-farm experiments.

A low view-to-follower ratio is treated as an **audience-vs-reach mismatch signal**, never as proof that followers are fake.

## Architecture

```text
                         ┌───────────────────────────────┐
                         │      REAL TIKTOK ACCOUNT      │
                         └───────────────┬───────────────┘
                                         │ user consent
                                         ▼
                              TikTok Login Kit OAuth
                                         │
                                         ▼
                           Official TikTok Display API
                              │                    │
                              ▼                    ▼
                       /v2/user/info/       /v2/video/list/
                              │                    │
                              └─────────┬──────────┘
                                        ▼
                              Audience-vs-Reach Audit
                                        │
                                        │ real observations
                                        ▼
                    ┌─────────────────────────────────────┐
                    │       CLOSED RESEARCH SIMULATOR     │
                    └──────────────────┬──────────────────┘
                                       │
                        Account Creation Campaign
                                       │
                                       ▼
                               Identity Factory
                                       │
                                       ▼
                              Creation Job Queue
                                       │
                                       ▼
                           AccountCreation Workers
                                       │
                              ┌────────┴────────┐
                              ▼                 ▼
                     RegistrationProvider  EmailProvider
                              │                 │
                              └────────┬────────┘
                                       ▼
                                Account Inventory
                                       │
                                       ▼
                                  Account Pool
                                       │
                                       ▼
                                 Follow Campaign
                                       │
                                       ▼
                                  Follow Workers
                                       │
                                       ▼
                              Simulator SocialProvider
                                       │
                                       ▼
                              Risk / Health / Refill
```

## Real TikTok integration

The project includes `TikTokOfficialClient`, which uses TikTok's current official OAuth and Display API flow.

Implemented endpoints:

```text
GET /api/tiktok/config
GET /api/tiktok/oauth/start
GET /api/tiktok/oauth/callback
GET /api/tiktok/connections
GET /api/tiktok/accounts/{openId}/profile
GET /api/tiktok/accounts/{openId}/videos?maxCount=20
GET /api/tiktok/accounts/{openId}/audit?maxCount=20
```

The real integration reads, when the app has the required approved scopes and the user consents:

- display name / username / avatar / profile link
- follower count
- following count
- total received likes
- public video count
- recent video view count
- recent video like count
- recent video comment count
- recent video share count

The audit computes:

- average recent views
- median recent views
- view-to-follower ratio
- recent interaction-per-view ratio
- descriptive mismatch observations

It does not label an account as fake based on these ratios alone.

### TikTok Developer configuration

Create an app in TikTok for Developers, add Login Kit and the TikTok API/Display API product, then register your Web callback URI:

```text
https://YOUR_DEPLOYED_HOST/api/tiktok/oauth/callback
```

Recommended scopes for the experiment:

```text
user.info.basic
user.info.profile
user.info.stats
video.list
```

`user.info.stats` is required for follower/following/likes/video counts. `video.list` is required for recent public videos. Additional scopes may require TikTok app review/approval, and the user must authorize them.

Prefer environment variables instead of committing credentials:

```text
TikTok__ClientKey=YOUR_CLIENT_KEY
TikTok__ClientSecret=YOUR_CLIENT_SECRET
TikTok__RedirectUri=https://YOUR_DEPLOYED_HOST/api/tiktok/oauth/callback
TikTok__Scopes=user.info.basic,user.info.profile,user.info.stats,video.list
```

The checked-in `appsettings.json` contains empty credential placeholders only.

Full setup guide: `docs/TIKTOK_REAL_INTEGRATION.md`.

## Account Factory simulator

The synthetic account factory is an asynchronous research pipeline rather than a simple insertion loop:

```text
CreationCampaign
    ↓
RegistrationIdentity × N
    ↓
AccountCreationJob × N
    ↓
Channel<AccountCreationJob>
    ↓
AccountCreationWorker pool
    ↓
Registration + verification simulation
    ↓
SimAccount
    ↓
Account Pool
```

Creation jobs use this state machine:

```text
IdentityReady
      ↓
RegistrationStarted
      ↓
WaitingVerification
      ↓
VerificationReceived
      ↓
Registered
```

Failure paths end in `Failed` or `Blocked`.

Each synthetic account tracks:

- provider/source
- synthetic external username
- region
- opaque synthetic password reference
- synthetic session state
- health score
- risk score
- action counters
- created / verified / activated timestamps
- cooldown and health-check timestamps

## Provider abstractions

### Social providers

`ISocialProvider` separates campaign orchestration from platform-specific behavior.

| Provider | Platform | Mode | Follow mutation |
|---|---|---|---|
| `simulator` | Simulator | Simulation | local synthetic mutation |
| `tiktok` | TikTok | ReadOnly | blocked |

The `tiktok` social provider only normalizes TikTok profile targets. It is intentionally separate from `TikTokOfficialClient`, which performs authorized official read analytics.

### Registration providers

| Provider | Platform | Mode | Account creation |
|---|---|---|---|
| `simulator-registration` | Simulator | Simulation | local synthetic accounts |
| `tiktok-registration` | TikTok | ReadOnly | blocked |

The real TikTok integration does **not** mass-register accounts. `tiktok-registration` remains a capability boundary.

### Email providers

| Provider | Mode | Behavior |
|---|---|---|
| `simulator-mail` | Simulation | reserved `example.invalid` addresses + synthetic verification artifacts |

No real temporary-email provider is contacted by the simulator.

## Follow Campaign simulator

A follow campaign selects eligible synthetic inventory, creates one job per requested synthetic delivery, and lets background workers execute through `ISocialProvider`.

Example:

```http
POST /api/campaigns
Content-Type: application/json

{
  "provider": "simulator",
  "target": "demo_target",
  "quantity": 1000,
  "startingFollowers": 100
}
```

Synthetic failures can place accounts into cooldown, limited, or disabled states. Refill jobs use previously unused eligible inventory to replace missing simulated delivery.

## Automatic replenishment

The replenishment service maintains a target synthetic inventory size.

```text
Minimum active = 10,000
Current active = 8,400
Missing        = 1,600

→ AccountCreationCampaign(quantity=1,600)
```

Request example:

```http
POST /api/account-factory/replenish
Content-Type: application/json

{
  "minimumActive": 10000,
  "batchSize": 2000,
  "provider": "simulator-registration",
  "emailProvider": "simulator-mail",
  "region": "VN"
}
```

## Configuration

`src/FollowerFarmSimulator/appsettings.json` contains non-secret defaults:

```json
{
  "AccountFactory": {
    "Workers": 8
  },
  "TikTok": {
    "ClientKey": "",
    "ClientSecret": "",
    "RedirectUri": "",
    "Scopes": "user.info.basic,user.info.profile,user.info.stats,video.list"
  }
}
```

Never commit real TikTok credentials.

## Run

```bash
cd src/FollowerFarmSimulator
dotnet run
```

Use `src/FollowerFarmSimulator/FollowerFarmSimulator.http` from Visual Studio or Rider.

### Real-data demo

```text
1. Configure TikTok Developer credentials.
2. Open GET /api/tiktok/oauth/start in a browser.
3. Authorize the app on TikTok.
4. Read the `openId` returned by the callback.
5. GET /api/tiktok/accounts/{openId}/audit?maxCount=20
```

### Synthetic experiment demo

```text
1. POST /api/account-factory/campaigns to create synthetic inventory.
2. GET /api/account-factory/stats.
3. POST /api/campaigns to simulate follower delivery.
4. GET /api/campaigns/{id} and target stats.
5. Refill failures and observe inventory burn/replenishment.
```

## Security and safety boundary

The real TikTok layer uses user-authorized official OAuth access/refresh tokens and official TikTok APIs. It does not collect TikTok passwords.

The project does **not** implement:

- automated mass creation of real TikTok accounts
- TikTok password harvesting
- private TikTok API request signing
- browser anti-detection for account creation or engagement
- CAPTCHA solving or OTP bypass
- proxy/fingerprint/device evasion
- real fake follow/like/comment delivery
- SMM-provider ordering for fake engagement

OAuth client secrets and refresh tokens are server-side only. The current MVP stores OAuth tokens in memory; a deployed research version should replace that with encrypted persistent storage.

## Current limitations

- TikTok Developer app credentials and approval are required to exercise the real integration.
- Extra TikTok scopes may require review before follower/video metrics are available.
- OAuth connections are currently in memory and disappear after restart.
- Simulator state is also in memory.
- The mismatch heuristic is descriptive and intentionally does not claim to detect fake followers with certainty.

## Next phases

1. Persist OAuth connections, metrics snapshots, simulator accounts, jobs, campaigns, and events in SQL Server/PostgreSQL.
2. Encrypt refresh tokens at rest and add connection revocation.
3. Store daily TikTok metric snapshots to measure follower growth versus real reach over time.
4. Add time-series charts for follower count, median views, engagement, inventory burn, refill, and creation throughput.
5. Compare real account observations with reproducible seeded simulator experiments.
6. Add a dashboard that clearly separates `REAL TIKTOK DATA` from `SIMULATED FARM DATA`.
7. Add graph-based coordinated-behavior detection as a defensive research module.
8. Add load tests for 100K-1M synthetic identities/accounts.
