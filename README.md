# Direct Follower Farm Research Simulator

A provider-aware .NET 10 research simulator for studying the architecture, failure modes, inventory economics, replenishment behavior, and detection surface of coordinated fake-engagement systems.

The project models the architecture commonly seen in mass-account/follower-farm tooling while keeping all mutation inside a closed simulator. TikTok exists only as a read-only capability boundary.

## Architecture

```text
                     Account Creation Campaign
                              │
                              ▼
                        Identity Factory
                              │
                              ▼
                       Creation Job Queue
                              │
                              ▼
                    AccountFactory Workers
                              │
                 ┌────────────┴────────────┐
                 ▼                         ▼
        RegistrationProvider         EmailProvider
                 │                         │
                 └────────────┬────────────┘
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
                        Follow Job Queue
                              │
                              ▼
                         Follow Workers
                              │
                              ▼
                        SocialProvider
                              │
                ┌─────────────┴─────────────┐
                ▼                           ▼
          simulator                    tiktok
       local mutation                read-only
                │
                ▼
                    Risk / Health Engine
                              │
                              ▼
                    Delivery / Refill Metrics
```

## What is implemented

### Account Factory

The account factory is no longer a direct `for` loop that inserts accounts. It has a dedicated asynchronous pipeline:

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

### Account inventory

Each generated account tracks:

- provider/source
- synthetic external username
- region
- opaque password reference (never a real password)
- synthetic session state
- health score
- risk score
- action counters
- created / verified / activated timestamps
- cooldown and health-check timestamps

### Follow Campaign Engine

A follow campaign selects eligible synthetic inventory, creates one job per requested delivery, and lets background workers execute the jobs through `ISocialProvider`.

Refill jobs use previously unused eligible inventory to replace simulated failures.

### Automatic Replenishment

The replenishment service checks active inventory against a minimum threshold.

Example:

```text
Minimum active = 10,000
Current active = 8,400
Missing        = 1,600
Batch size     = 2,000

→ create AccountCreationCampaign(quantity=1,600)
```

This connects account-factory economics with campaign delivery.

## Provider model

### Social providers

`ISocialProvider` exposes:

- `Key`
- `Platform`
- `Mode`
- `SupportsMutatingEngagement`
- `NormalizeTarget(...)`
- `FollowAsync(...)`

Current providers:

| Provider | Platform | Mode | Mutation |
|---|---|---|---|
| `simulator` | Simulator | Simulation | local simulation only |
| `tiktok` | TikTok | ReadOnly | blocked |

The TikTok social adapter can normalize:

```text
@longgmilk
longgmilk
https://www.tiktok.com/@longgmilk
```

but cannot execute follow/like/comment actions.

### Registration providers

`IRegistrationProvider` separates account creation from the creation worker.

Current providers:

| Provider | Platform | Mode | Account creation |
|---|---|---|---|
| `simulator-registration` | Simulator | Simulation | local synthetic accounts |
| `tiktok-registration` | TikTok | ReadOnly | blocked |

`tiktok-registration` deliberately performs no network call, browser automation, login, registration, verification handling, or private API action.

### Email providers

`IEmailProvider` abstracts mailbox creation and verification delivery.

Current provider:

| Provider | Mode | Behavior |
|---|---|---|
| `simulator-mail` | Simulation | uses reserved `example.invalid` addresses and synthetic verification tokens |

No Gmail, Mail.tm, Kopeechka, temporary-email service, or real mailbox is contacted.

## Configuration

`src/FollowerFarmSimulator/appsettings.json`:

```json
{
  "AccountFactory": {
    "Workers": 8
  }
}
```

The account-factory worker count can be changed without changing source code.

## Run

```bash
cd src/FollowerFarmSimulator
dotnet run
```

Use `src/FollowerFarmSimulator/FollowerFarmSimulator.http` from Visual Studio / Rider.

## Demo: account creation → inventory → follow campaign

### 1. Inspect provider capabilities

```http
GET /api/account-factory/providers
GET /api/providers
```

### 2. Create 1,000 synthetic accounts through the factory pipeline

```http
POST /api/account-factory/campaigns
Content-Type: application/json

{
  "provider": "simulator-registration",
  "emailProvider": "simulator-mail",
  "region": "VN",
  "quantity": 1000
}
```

### 3. Watch creation progress

```http
GET /api/account-factory/campaigns/{creationCampaignId}
GET /api/account-factory/stats
GET /api/account-factory/jobs/recent?take=50
```

### 4. Maintain a minimum inventory

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

### 5. Use the resulting account pool in a local follow simulation

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

### 6. Inspect/refill delivery

```http
GET /api/campaigns/{campaignId}
POST /api/campaigns/{campaignId}/refill
GET /api/targets/simulator/demo_target
```

## TikTok capability boundary

The architecture can carry TikTok as a third-party platform without permitting fake-engagement or mass-registration mutation.

Account creation request:

```http
POST /api/account-factory/campaigns
Content-Type: application/json

{
  "provider": "tiktok-registration",
  "emailProvider": "simulator-mail",
  "region": "VN",
  "quantity": 1000
}
```

Expected result:

```text
Platform    TikTok
Status      Blocked
Jobs        0
Reason      provider is read-only
```

Follow request:

```http
POST /api/campaigns
Content-Type: application/json

{
  "provider": "tiktok",
  "target": "https://www.tiktok.com/@longgmilk",
  "quantity": 1000
}
```

The target is normalized, but no follow jobs are created.

## Simulation outcomes

Registration and verification have configurable-in-code synthetic failure distributions so experiments include rejected registrations, verification timeouts, provider errors, and challenge states.

Follow jobs currently simulate approximately:

| Result | Probability | Effect |
|---|---:|---|
| success | 93% | synthetic follower delivered |
| cooldown | 3% | account temporarily unavailable |
| limited | 2.5% | account moved to limited state |
| disabled | 1.5% | account removed from usable inventory |

These values are research parameters, not measurements or claims about TikTok.

## Safety boundary

This repository does **not** implement:

- automated TikTok account registration
- real TikTok credentials or sessions
- private TikTok API calls or request signing
- real email/phone verification automation
- CAPTCHA solving or OTP bypass
- proxy rotation or fingerprint/device evasion
- undetected browser automation
- real follow/like/comment delivery
- SMM-provider ordering for fake engagement

The simulator deliberately models the orchestration architecture without enabling those real-world abuse mechanisms.

## Next research phases

1. Persist accounts, identities, creation jobs, follow jobs, campaigns, and event history in SQL Server/PostgreSQL.
2. Add deterministic random seeds so experiments are reproducible.
3. Add configurable registration/follow provider profiles from configuration.
4. Add time-series metrics: creation throughput, inventory burn rate, campaign throughput, failure/refill rate.
5. Add a dashboard for creation state, account health, inventory lifecycle, and campaigns.
6. Add automatic periodic replenishment policies rather than request-triggered replenishment only.
7. Add graph-based coordinated-behavior detection as a defensive research module.
8. Add load tests for 100K-1M synthetic identities/accounts.
9. Add read-only/official platform metadata adapters where a platform explicitly supports them.
