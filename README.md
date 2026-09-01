# SMM Panel Simulator

A .NET 10 simulator for studying an SMM-panel order lifecycle without implementing real-platform follower automation.

## Target service model

The value supplied in an order, for example `https://www.tiktok.com/@longgmilk`, is a profile URL/label used to extract the handle `longgmilk`.

The service that actually receives simulator delivery calls is **not hard-coded to that hostname**. It is configured separately:

```json
{
  "TargetService": {
    "BaseUrl": "http://localhost:5081"
  }
}
```

or with Docker:

```bash
TARGET_SERVICE_BASE_URL=http://your-service:8080 docker compose up --build
```

This lets the panel talk to a service you control (local service, staging service, hosts/DNS-mapped environment, etc.) as long as it implements the small simulation contract below.

## TargetService contract

```text
GET  /api/profiles/{handle}
POST /api/profiles/{handle}/followers/simulate
```

Example POST body:

```json
{
  "quantity": 2500,
  "operationId": "order:<id>:delivered:0:amount:2500"
}
```

Expected profile response:

```json
{
  "username": "longgmilk",
  "followerCount": 2500
}
```

`operationId` is used for idempotency so a retry does not double-apply the same simulated delivery.

## Included sandbox target

The repository still includes `FakeTikTok.Api` as a ready-to-run implementation of the TargetService contract. It is only a default local sandbox and can be replaced by your own service without changing `Smm.Api`.

```text
Client
  |
  v
Smm.Api :5080
  |
  | ITargetServiceClient
  v
Configured TargetService
  |
  +-- default: FakeTikTok.Api :5081
  +-- optional: your own simulator service
```

The included sandbox seeds:

```text
@longgmilk
followers: 0
```

## Run default local setup

```bash
docker compose up --build
```

- SMM API: `http://localhost:5080`
- Included sandbox TargetService: `http://localhost:5081`

## Demo

### 1. Create a 10,000 follower simulation order

```bash
curl -X POST http://localhost:5080/api/orders \
  -H "Content-Type: application/json" \
  -d '{
    "serviceId": 1,
    "target": "https://www.tiktok.com/@longgmilk",
    "quantity": 10000
  }'
```

### 2. Apply a simulated batch

```bash
curl -X POST http://localhost:5080/api/orders/ORDER_ID/deliver \
  -H "Content-Type: application/json" \
  -d '{ "quantity": 2500 }'
```

Repeat until the order reaches `Completed`.

### 3. Check the configured target service

With the included sandbox:

```bash
curl http://localhost:5081/api/profiles/longgmilk
```

## Projects

- `Smm.Domain` - service/order entities and state transitions.
- `Smm.Application` - order use cases, target parsing, repositories and target-service contract.
- `Smm.Infrastructure` - in-memory repositories and `TargetServiceClient` HTTP adapter.
- `Smm.Api` - panel API.
- `FakeTikTok.Api` - optional local implementation of the target simulation contract.

## V0.1 boundaries

This version models order state and follower counters on a service that implements the explicit `/followers/simulate` contract. It contains no browser automation, credential handling, proxy/device-farm code, or implementation for manipulating a third-party social platform.

## Next milestone

V0.2: internal queue, background worker, fake account pool and timed batch delivery against the configured TargetService.
