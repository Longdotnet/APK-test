# SMM Panel Simulator

A sandbox-only SMM panel simulator built with .NET 10. It models the order lifecycle used by follower-delivery panels without sending automation, follow requests, or engagement to TikTok.

## Safety boundary

The target `https://www.tiktok.com/@longgmilk` is used only as input data. `Smm.Api` parses the URL into the handle `longgmilk`, then sends simulated delivery requests only to `FakeTikTok.Api`.

There is intentionally no TikTok client, browser automation, credential handling, proxy support, device farm, or real follower-delivery implementation in this repository.

## V0.1 architecture

```text
Client
  |
  v
Smm.Api :5080
  |  create order / manual delivery
  v
FakeTikTok.Api :5081
  |  in-memory sandbox profile
  v
@longgmilk follower counter
```

Projects:

- `Smm.Domain` - service/order entities and state transitions.
- `Smm.Application` - order use cases, target parsing, repository/client contracts.
- `Smm.Infrastructure` - in-memory repositories and HTTP adapter to FakeTikTok.
- `Smm.Api` - panel API.
- `FakeTikTok.Api` - local sandbox that owns fake profiles and follower counts.

## Run with Docker

```bash
docker compose up --build
```

- SMM API: `http://localhost:5080`
- FakeTikTok API: `http://localhost:5081`

`FakeTikTok.Api` starts with this profile:

```text
@longgmilk
followers: 0
```

## Demo flow

### 1. Check the sandbox profile

```bash
curl http://localhost:5081/api/profiles/longgmilk
```

### 2. Create a 10,000 follower simulation order

```bash
curl -X POST http://localhost:5080/api/orders \
  -H "Content-Type: application/json" \
  -d '{
    "serviceId": 1,
    "target": "https://www.tiktok.com/@longgmilk",
    "quantity": 10000
  }'
```

Copy the returned order `id`.

### 3. Deliver the first batch

```bash
curl -X POST http://localhost:5080/api/orders/ORDER_ID/deliver \
  -H "Content-Type: application/json" \
  -d '{ "quantity": 2500 }'
```

Repeat four times. The order progresses from `Pending` to `Processing`, then `Completed` at 10,000 delivered.

### 4. Verify FakeTikTok only

```bash
curl http://localhost:5081/api/profiles/longgmilk
```

Expected after full simulated delivery:

```json
{
  "username": "longgmilk",
  "followerCount": 10000
}
```

The real TikTok profile is never fetched or modified.

## API summary

### Smm.Api

| Method | Route | Purpose |
|---|---|---|
| GET | `/api/services` | List simulator services |
| GET | `/api/orders` | List orders |
| GET | `/api/orders/{id}` | Get one order |
| POST | `/api/orders` | Create an order |
| POST | `/api/orders/{id}/deliver` | Manually simulate a delivery batch |

### FakeTikTok.Api

| Method | Route | Purpose |
|---|---|---|
| GET | `/api/profiles` | List fake profiles |
| GET | `/api/profiles/{username}` | Get fake profile |
| POST | `/api/profiles` | Create fake profile |
| POST | `/api/profiles/{username}/followers/simulate` | Add sandbox followers, idempotently |

## Next milestones

V0.2 will add an internal queue, background worker, account-pool simulation and timed batch delivery. V0.3 can add a mock provider API and provider-order lifecycle. Drop/refill, wallet, pricing, routing and chaos testing remain later phases.
