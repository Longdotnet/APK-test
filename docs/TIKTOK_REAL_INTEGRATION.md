# Real TikTok Integration

This project includes a real third-party TikTok integration using TikTok Login Kit (OAuth 2.0) and the official TikTok Display API.

It is deliberately separated from the synthetic follower-farm simulator:

```text
REAL TIKTOK ACCOUNT
       │
       ▼
TikTok Login Kit OAuth
       │
       ▼
server-side access/refresh token
       │
       ├── GET /v2/user/info/
       │      └── follower_count / following_count / likes_count / video_count
       │
       └── POST /v2/video/list/
              └── view / like / comment / share metrics
                     │
                     ▼
             Audience-vs-Reach Audit
```

No real TikTok account creation, follow automation, CAPTCHA bypass, private API signing, or fake-engagement delivery is performed.

## Why this is the real-world pain validation layer

The simulator can model a scenario such as `10,000 followers delivered`, but that alone is synthetic. The official TikTok integration lets the project measure the connected creator account's actual TikTok statistics and recent-video reach.

The audit reports metrics including:

- follower count
- following count
- total likes
- public video count
- average recent views
- median recent views
- recent view-to-follower ratio
- recent interaction-per-view ratio

A low view-to-follower ratio is reported only as an **audience-vs-reach mismatch signal**. It is not treated as proof that followers are fake.

## TikTok Developer setup

1. Create an app at TikTok for Developers.
2. Add Login Kit and the TikTok API/Display API product.
3. Configure a Web redirect URI pointing to this backend callback:

```text
https://YOUR_DEPLOYED_HOST/api/tiktok/oauth/callback
```

For Web Login Kit, the redirect URI must be an absolute HTTPS URI registered in the TikTok Developer Portal.

4. Request the scopes required by the experiment:

```text
user.info.basic
user.info.profile
user.info.stats
video.list
```

`user.info.stats` is needed for follower/following/likes/video counts. `video.list` is needed for recent public video metrics. Additional scopes may require TikTok app review/approval, and the TikTok user must authorize the scopes.

## Configuration

Do not commit real credentials to GitHub. Prefer environment variables:

```text
TikTok__ClientKey=YOUR_CLIENT_KEY
TikTok__ClientSecret=YOUR_CLIENT_SECRET
TikTok__RedirectUri=https://YOUR_DEPLOYED_HOST/api/tiktok/oauth/callback
TikTok__Scopes=user.info.basic,user.info.profile,user.info.stats,video.list
```

The repository's `appsettings.json` contains empty placeholders only.

## Run the real integration

Check configuration:

```http
GET /api/tiktok/config
```

Start OAuth in a browser:

```http
GET /api/tiktok/oauth/start
```

TikTok handles login and consent, then redirects to:

```text
/api/tiktok/oauth/callback
```

The callback exchanges the authorization code server-side and stores the access/refresh token in memory. Tokens and the client secret are never returned by the API.

List connected accounts:

```http
GET /api/tiktok/connections
```

Read the authorized account's real profile statistics:

```http
GET /api/tiktok/accounts/{openId}/profile
```

Read up to 20 recent public videos and their actual TikTok metrics:

```http
GET /api/tiktok/accounts/{openId}/videos?maxCount=20
```

Run the pain-point audit:

```http
GET /api/tiktok/accounts/{openId}/audit?maxCount=20
```

## Token handling

Access and refresh tokens are kept server-side in the current in-memory MVP. The client automatically refreshes an access token shortly before expiry when the refresh token is still valid.

For production/research deployment, replace the in-memory token store with encrypted persistent storage and separate application secrets from source/config files.

## Official TikTok endpoints used

```text
Authorization:
https://www.tiktok.com/v2/auth/authorize/

Token exchange / refresh:
https://open.tiktokapis.com/v2/oauth/token/

User profile:
https://open.tiktokapis.com/v2/user/info/

Recent videos:
https://open.tiktokapis.com/v2/video/list/
```

References:

- https://developers.tiktok.com/docs/en/login-kit-overview
- https://developers.tiktok.com/docs/en/oauth-user-access-token-management
- https://developers.tiktok.com/docs/en/tiktok-api-v2-get-user-info
- https://developers.tiktok.com/docs/en/tiktok-api-v2-video-list
