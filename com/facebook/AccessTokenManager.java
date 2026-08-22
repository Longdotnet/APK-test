package com.facebook;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContentInfo;
import androidx.core.view.ContentInfoCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.google.android.gms.appset.vSSa.iafHZUfOuHNwvy;
import com.google.android.gms.games.provider.NtJ.wsbWxekY;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Headers;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public final class AccessTokenManager {
    public static final GraphRequest.Companion Companion = new GraphRequest.Companion(1);
    public static AccessTokenManager instanceField;
    public final AccessTokenCache accessTokenCache;
    public AccessToken currentAccessTokenField;
    public final LocalBroadcastManager localBroadcastManager;
    public final AtomicBoolean tokenRefreshInProgress = new AtomicBoolean(false);
    public Date lastAttemptedTokenExtendDate = new Date(0);

    public final class RefreshResult implements ContentInfoCompat.BuilderCompat, ContentInfoCompat.Compat {
        public final /* synthetic */ int $r8$classId;
        public Object accessToken;
        public Object dataAccessExpirationTime;
        public int expiresAt;
        public int expiresIn;
        public Comparable graphDomain;

        public /* synthetic */ RefreshResult(int i) {
            this.$r8$classId = i;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public ContentInfoCompat build() {
            return new ContentInfoCompat(new RefreshResult(this));
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ClipData getClip() {
            return (ClipData) this.accessToken;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getFlags() {
            return this.expiresIn;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getSource() {
            return this.expiresAt;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ContentInfo getWrapped() {
            return null;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setExtras(Bundle bundle) {
            this.dataAccessExpirationTime = bundle;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setFlags(int i) {
            this.expiresIn = i;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setLinkUri(Uri uri) {
            this.graphDomain = uri;
        }

        public RefreshResult(RefreshResult refreshResult) {
            this.$r8$classId = 2;
            ClipData clipData = (ClipData) refreshResult.accessToken;
            clipData.getClass();
            this.accessToken = clipData;
            int i = refreshResult.expiresAt;
            if (i < 0) {
                Locale locale = Locale.US;
                throw new IllegalArgumentException("source is out of range of [0, 5] (too low)");
            }
            if (i > 5) {
                Locale locale2 = Locale.US;
                throw new IllegalArgumentException("source is out of range of [0, 5] (too high)");
            }
            this.expiresAt = i;
            int i2 = refreshResult.expiresIn;
            if ((i2 & 1) == i2) {
                this.expiresIn = i2;
                this.graphDomain = (Uri) refreshResult.graphDomain;
                this.dataAccessExpirationTime = (Bundle) refreshResult.dataAccessExpirationTime;
            } else {
                throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i2) + ", but only 0x" + Integer.toHexString(1) + " are allowed");
            }
        }

        public String toString() {
            String strValueOf;
            String str;
            switch (this.$r8$classId) {
                case 2:
                    StringBuilder sb = new StringBuilder("ContentInfoCompat{clip=");
                    sb.append(((ClipData) this.accessToken).getDescription());
                    sb.append(", source=");
                    int i = this.expiresAt;
                    if (i == 0) {
                        strValueOf = "SOURCE_APP";
                    } else if (i == 1) {
                        strValueOf = iafHZUfOuHNwvy.xcNAsC;
                    } else if (i == 2) {
                        strValueOf = "SOURCE_INPUT_METHOD";
                    } else if (i == 3) {
                        strValueOf = "SOURCE_DRAG_AND_DROP";
                    } else if (i != 4) {
                        strValueOf = i != 5 ? String.valueOf(i) : "SOURCE_PROCESS_TEXT";
                    } else {
                        strValueOf = "SOURCE_AUTOFILL";
                    }
                    sb.append(strValueOf);
                    sb.append(", flags=");
                    int i2 = this.expiresIn;
                    sb.append((i2 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i2));
                    Uri uri = (Uri) this.graphDomain;
                    if (uri == null) {
                        str = "";
                    } else {
                        str = wsbWxekY.ZvCZWYBAVHQvWS + uri.toString().length() + ")";
                    }
                    sb.append(str);
                    return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(sb, ((Bundle) this.dataAccessExpirationTime) != null ? ", hasExtras" : "", "}");
                default:
                    return super.toString();
            }
        }
    }

    public AccessTokenManager(LocalBroadcastManager localBroadcastManager, AccessTokenCache accessTokenCache) {
        this.localBroadcastManager = localBroadcastManager;
        this.accessTokenCache = accessTokenCache;
    }

    public final void refreshCurrentAccessTokenImpl() {
        String str;
        String str2;
        int i = 0;
        AccessToken accessToken = this.currentAccessTokenField;
        if (accessToken != null && this.tokenRefreshInProgress.compareAndSet(false, true)) {
            this.lastAttemptedTokenExtendDate = new Date();
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = new HashSet();
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            RefreshResult refreshResult = new RefreshResult(i);
            AccessTokenManager$$ExternalSyntheticLambda1 accessTokenManager$$ExternalSyntheticLambda1 = new AccessTokenManager$$ExternalSyntheticLambda1(atomicBoolean, hashSet, hashSet2, hashSet3, 0);
            HttpMethod httpMethod = HttpMethod.GET;
            Bundle bundle = new Bundle();
            bundle.putString("fields", "permission,status");
            String str3 = GraphRequest.MIME_BOUNDARY;
            GraphRequest graphRequestNewGraphPathRequest = GraphRequest.Companion.newGraphPathRequest(accessToken, "me/permissions", accessTokenManager$$ExternalSyntheticLambda1);
            graphRequestNewGraphPathRequest.parameters = bundle;
            graphRequestNewGraphPathRequest.httpMethod = httpMethod;
            AccessTokenManager$$ExternalSyntheticLambda2 accessTokenManager$$ExternalSyntheticLambda2 = new AccessTokenManager$$ExternalSyntheticLambda2(refreshResult, i);
            String str4 = accessToken.graphDomain;
            if (str4 == null) {
                str4 = "facebook";
            }
            int i2 = (str4.equals("instagram") ? new GraphRequest.Companion(3) : new GraphRequest.Companion(2)).$r8$classId;
            Bundle bundle2 = new Bundle();
            switch (i2) {
                case 2:
                    str = "fb_extend_sso_token";
                    break;
                default:
                    str = "ig_refresh_token";
                    break;
            }
            bundle2.putString("grant_type", str);
            bundle2.putString("client_id", accessToken.applicationId);
            bundle2.putString("fields", "access_token,expires_at,expires_in,data_access_expiration_time,graph_domain");
            switch (i2) {
                case 2:
                    str2 = "oauth/access_token";
                    break;
                default:
                    str2 = "refresh_access_token";
                    break;
            }
            GraphRequest graphRequestNewGraphPathRequest2 = GraphRequest.Companion.newGraphPathRequest(accessToken, str2, accessTokenManager$$ExternalSyntheticLambda2);
            graphRequestNewGraphPathRequest2.parameters = bundle2;
            graphRequestNewGraphPathRequest2.httpMethod = httpMethod;
            GraphRequestBatch graphRequestBatch = new GraphRequestBatch(graphRequestNewGraphPathRequest, graphRequestNewGraphPathRequest2);
            AccessTokenManager$$ExternalSyntheticLambda3 accessTokenManager$$ExternalSyntheticLambda3 = new AccessTokenManager$$ExternalSyntheticLambda3(refreshResult, accessToken, atomicBoolean, hashSet, hashSet2, hashSet3, this);
            ArrayList arrayList = graphRequestBatch.callbacks;
            if (!arrayList.contains(accessTokenManager$$ExternalSyntheticLambda3)) {
                arrayList.add(accessTokenManager$$ExternalSyntheticLambda3);
            }
            Validate.notEmptyAndContainsNoNulls(graphRequestBatch);
            new GraphRequestAsyncTask(graphRequestBatch).executeOnExecutor(FacebookSdk.getExecutor(), new Void[0]);
        }
    }

    public final void sendCurrentAccessTokenChangedBroadcastIntent(AccessToken accessToken, AccessToken accessToken2) {
        Intent intent = new Intent(FacebookSdk.getApplicationContext(), (Class<?>) CurrentAccessTokenExpirationBroadcastReceiver.class);
        intent.setAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN", accessToken);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN", accessToken2);
        this.localBroadcastManager.sendBroadcast(intent);
    }

    public final void setCurrentAccessToken(AccessToken accessToken, boolean z) {
        boolean zEquals;
        AccessToken accessToken2 = this.currentAccessTokenField;
        this.currentAccessTokenField = accessToken;
        this.tokenRefreshInProgress.set(false);
        this.lastAttemptedTokenExtendDate = new Date(0L);
        if (z) {
            SharedPreferences sharedPreferences = (SharedPreferences) this.accessTokenCache.sharedPreferences;
            if (accessToken != null) {
                try {
                    sharedPreferences.edit().putString("com.facebook.AccessTokenManager.CachedAccessToken", accessToken.toJSONObject$facebook_core_release().toString()).apply();
                } catch (JSONException unused) {
                }
            } else {
                sharedPreferences.edit().remove("com.facebook.AccessTokenManager.CachedAccessToken").apply();
                Utility.clearFacebookCookies(FacebookSdk.getApplicationContext());
            }
        }
        if (accessToken2 == null) {
            zEquals = accessToken == null;
        } else {
            zEquals = accessToken2.equals(accessToken);
        }
        if (zEquals) {
            return;
        }
        sendCurrentAccessTokenChangedBroadcastIntent(accessToken2, accessToken);
        Context applicationContext = FacebookSdk.getApplicationContext();
        Date date = AccessToken.DEFAULT_EXPIRATION_TIME;
        AccessToken currentAccessToken = Headers.Companion.getCurrentAccessToken();
        AlarmManager alarmManager = (AlarmManager) applicationContext.getSystemService("alarm");
        if (Headers.Companion.isCurrentAccessTokenActive()) {
            if ((currentAccessToken == null ? null : currentAccessToken.expires) == null || alarmManager == null) {
                return;
            }
            Intent intent = new Intent(applicationContext, (Class<?>) CurrentAccessTokenExpirationBroadcastReceiver.class);
            intent.setAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
            try {
                alarmManager.set(1, currentAccessToken.expires.getTime(), PendingIntent.getBroadcast(applicationContext, 0, intent, 67108864));
            } catch (Exception unused2) {
            }
        }
    }
}
