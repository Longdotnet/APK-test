# Direct Follower Farm Research Simulator

A provider-aware research simulator for studying the architecture, failure modes, inventory economics, and detection surface of coordinated fake-engagement systems.

The project now separates the farm core from platform adapters so the architecture can model a third-party platform such as TikTok **without implementing real fake-engagement actions**.

## Architecture

```text
Synthetic Account Factory
        ↓
    Account Pool
        ↓
  Campaign Engine
        ↓
   Provider Router
        │
        ├── simulator  → mutable local simulation
        │
        └── tiktok     → target/read-only adapter
        ↓
      Job Queue
        ↓
  Background Workers
        ↓
 Risk / Health Engine
        ↓
 Delivery + Refill Metrics
```

The key refactor is `ISocialProvider`: campaign, queue and workers no longer depend directly on a concrete simulator implementation.

## Provider model

Every provider exposes:

- `Key`
- `Platform`
- `Mode`
- `SupportsMutatingEngagement`
- `NormalizeTarget(...)`
- `FollowAsync(...)`

Current providers:

| Provider | Platform | Mode | Mutating engagement |
|---|---|---|---|
| `simulator` | Simulator | Simulation | Yes, local state only |
| `tiktok` | TikTok | ReadOnly | No |

The TikTok adapter accepts either:

```text
@longgmilk
longgmilk
https://www.tiktok.com/@longgmilk
```

and normalizes them to:

```text
username: longgmilk
canonicalTarget: https://www.tiktok.com/@longgmilk
```

It does not log in to TikTok and does not execute follow/like/comment actions.

## Safety boundary

This repository does **not** implement:

- automated TikTok account registration
- TikTok credentials/session handling
- private TikTok API calls
- browser automation for fake engagement
- CAPTCHA or OTP bypass
- proxy/fingerprint evasion
- real follow/like/comment delivery
- SMM-provider ordering for fake engagement

When a campaign uses `provider: "tiktok"`, the target is validated and normalized, but the campaign is returned with `Blocked` status and an explicit capability reason.

## Research questions this MVP can answer

- How many synthetic accounts are required to deliver a campaign of N followers?
- How does account health degrade as jobs are executed?
- How many accounts move into cooldown, limited, or disabled states?
- What delivery rate is achieved under configurable simulated failure rates?
- How many refill jobs are needed to reach the requested campaign quantity?
- How does worker concurrency affect queue throughput?
- How can the same campaign core support platform-specific adapters without hard-coding TikTok?
- How should capability gates prevent a read-only provider from executing mutation jobs?

## Tech

- .NET 10
- ASP.NET Core Minimal API
- `BackgroundService` worker pool
- `System.Threading.Channels` in-memory queue
- dependency-injected provider adapters
- concurrent in-memory state for the first MVP

## Run

```bash
cd src/FollowerFarmSimulator
dotnet run
```

Use `src/FollowerFarmSimulator/FollowerFarmSimulator.http` from Visual Studio / Rider.

## Demo flow

### 1. Inspect providers

```http
GET /api/providers
```

### 2. Validate/normalize a TikTok target

```http
POST /api/providers/tiktok/normalize-target
Content-Type: application/json

{
  "target": "https://www.tiktok.com/@longgmilk"
}
```

### 3. Generate synthetic account inventory

```http
POST /api/accounts/generate
Content-Type: application/json

{ "count": 10000 }
```

### 4. Start a local direct-follow simulation

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

The campaign allocates eligible synthetic accounts and creates one local simulated follow job per account. Eight background workers consume the queue concurrently.

### 5. Exercise the TikTok integration boundary

```http
POST /api/campaigns
Content-Type: application/json

{
  "provider": "tiktok",
  "target": "https://www.tiktok.com/@longgmilk",
  "quantity": 1000
}
```

Expected behavior:

```text
Platform        TikTok
CanonicalTarget https://www.tiktok.com/@longgmilk
Status          Blocked
BlockReason     provider is read-only
Jobs            0
```

This demonstrates that the same campaign model can carry a real third-party target while the provider capability boundary prevents fake-engagement execution.

### 6. Inspect simulated delivery

```http
GET /api/campaigns/{campaignId}
GET /api/targets/simulator/demo_target
```

### 7. Refill simulated failures

```http
POST /api/campaigns/{campaignId}/refill
```

## Current simulated outcome distribution

Each local simulator follow action currently has an approximate outcome distribution:

| Result | Probability | Effect |
|---|---:|---|
| success | 93% | synthetic follower delivered |
| cooldown | 3% | synthetic account temporarily unavailable |
| limited | 2.5% | synthetic account moved to limited state |
| disabled | 1.5% | synthetic account removed from usable inventory |

These values are research parameters, not claims about TikTok's real systems.

## Account lifecycle

```text
NEW
 ↓
ACTIVE ───────────────┐
 ↓                    │
COOLDOWN ─────────────┘
 ↓
LIMITED
 ↓
DISABLED
```

Each synthetic account tracks health score, risk score, daily action count, last action time, cooldown expiry and lifecycle state.

## Provider-aware roadmap

1. Persist accounts, jobs, campaigns, targets and provider metadata in PostgreSQL/SQL Server.
2. Add deterministic seeded simulation scenarios for repeatable experiments.
3. Add configurable simulated provider profiles and retention/drop models.
4. Add campaign time-series metrics and throughput charts.
5. Add automatic synthetic inventory replenishment.
6. Add graph-based coordinated-behavior detection to study how a defender could identify a follower farm.
7. Add read-only/official platform metadata adapters where supported by platform APIs.
8. Add load tests for 100K–1M synthetic accounts.

Real-platform adapters that automate fake engagement or evade platform safeguards remain out of scope.
