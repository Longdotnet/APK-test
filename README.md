# Direct Follower Farm Simulator

A local-only research simulator for studying the architecture, failure modes, inventory economics, and detection surface of coordinated fake-engagement systems **without connecting to TikTok or any real social platform**.

## Scope

This project models the same high-level components commonly found in abusive follower farms:

```text
Synthetic Account Factory
        ↓
    Account Pool
        ↓
  Campaign Engine
        ↓
      Job Queue
        ↓
  Background Workers
        ↓
 Simulated Provider
        ↓
 Risk / Health Engine
        ↓
 Delivery + Refill Metrics
```

The provider is intentionally in-memory only. The repository does **not** implement real platform registration, credential handling, CAPTCHA/OTP bypass, proxy/fingerprint evasion, browser automation, private TikTok APIs, or real follow/like/comment actions.

## Research questions this MVP can answer

- How many synthetic accounts are required to deliver a campaign of N followers?
- How does account health degrade as jobs are executed?
- How many accounts move into cooldown, limited, or disabled states?
- What delivery rate is achieved under configurable simulated failure rates?
- How many refill jobs are needed to reach the requested campaign quantity?
- How does worker concurrency affect queue throughput?

## Tech

- .NET 10
- ASP.NET Core Minimal API
- `BackgroundService` worker pool
- `System.Threading.Channels` in-memory queue
- Concurrent in-memory state for the first MVP

## Run

```bash
cd src/FollowerFarmSimulator
dotnet run
```

Use `src/FollowerFarmSimulator/FollowerFarmSimulator.http` from Visual Studio / Rider, or call the API manually.

## Demo flow

### 1. Generate synthetic account inventory

```http
POST /api/accounts/generate
Content-Type: application/json

{ "count": 10000 }
```

### 2. Check account-pool health

```http
GET /api/accounts/stats
```

### 3. Start a direct-follow simulation

```http
POST /api/campaigns
Content-Type: application/json

{
  "target": "demo_target",
  "quantity": 1000,
  "startingFollowers": 100
}
```

The campaign allocates eligible synthetic accounts and creates one simulated follow job per account. Eight background workers consume the queue concurrently.

### 4. Inspect delivery

```http
GET /api/campaigns/{campaignId}
GET /api/targets/demo_target
```

### 5. Refill failures

```http
POST /api/campaigns/{campaignId}/refill
```

Refill uses previously unused eligible synthetic accounts and creates replacement jobs for the missing delivery.

## Current simulated outcome distribution

Each local follow action currently has an approximate outcome distribution:

| Result | Probability | Effect |
|---|---:|---|
| success | 93% | follower delivered |
| cooldown | 3% | account temporarily unavailable |
| limited | 2.5% | account moved to limited state |
| disabled | 1.5% | account removed from usable inventory |

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

Each account tracks:

- health score
- risk score
- daily action count
- last action time
- cooldown expiry
- current lifecycle state

## Next research phases

1. Persist accounts, jobs, campaigns and event history in PostgreSQL/SQL Server.
2. Add deterministic seeded simulation scenarios for repeatable experiments.
3. Add configurable provider profiles and retention/drop models.
4. Add campaign time-series metrics and throughput charts.
5. Add a replenishment simulator when active inventory falls below a threshold.
6. Add graph-based coordinated-behavior detection to study how a defender could identify a follower farm.
7. Add load tests for 100K–1M synthetic accounts.

## Safety boundary

The project is intentionally designed as a closed simulator. Real-platform adapters that automate fake engagement or evade platform safeguards are out of scope.
