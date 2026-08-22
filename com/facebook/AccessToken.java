package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.internal.view.Oteb.nYVxXTZQ;
import androidx.fragment.app.FragmentState;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.facebook.internal.Validate;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class AccessToken implements Parcelable {
    public final String applicationId;
    public final Date dataAccessExpirationTime;
    public final Set declinedPermissions;
    public final Set expiredPermissions;
    public final Date expires;
    public final String graphDomain;
    public final Date lastRefresh;
    public final Set permissions;
    public final AccessTokenSource source;
    public final String token;
    public final String userId;
    public static final Date DEFAULT_EXPIRATION_TIME = new Date(Long.MAX_VALUE);
    public static final Date DEFAULT_LAST_REFRESH_TIME = new Date();
    public static final AccessTokenSource DEFAULT_ACCESS_TOKEN_SOURCE = AccessTokenSource.FACEBOOK_APPLICATION_WEB;
    public static final Parcelable.Creator<AccessToken> CREATOR = new FragmentState.AnonymousClass1(20);

    public AccessToken(String accessToken, String applicationId, String userId, Collection collection, Collection collection2, Collection collection3, AccessTokenSource accessTokenSource, Date date, Date date2, Date date3, String str) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Validate.notEmpty(accessToken, "accessToken");
        Validate.notEmpty(applicationId, "applicationId");
        Validate.notEmpty(userId, "userId");
        Date date4 = DEFAULT_EXPIRATION_TIME;
        this.expires = date == null ? date4 : date;
        Set setUnmodifiableSet = Collections.unmodifiableSet(collection != null ? new HashSet(collection) : new HashSet());
        Intrinsics.checkNotNullExpressionValue(setUnmodifiableSet, "unmodifiableSet(if (permissions != null) HashSet(permissions) else HashSet())");
        this.permissions = setUnmodifiableSet;
        Set setUnmodifiableSet2 = Collections.unmodifiableSet(collection2 != null ? new HashSet(collection2) : new HashSet());
        Intrinsics.checkNotNullExpressionValue(setUnmodifiableSet2, "unmodifiableSet(\n            if (declinedPermissions != null) HashSet(declinedPermissions) else HashSet())");
        this.declinedPermissions = setUnmodifiableSet2;
        Set setUnmodifiableSet3 = Collections.unmodifiableSet(collection3 != null ? new HashSet(collection3) : new HashSet());
        Intrinsics.checkNotNullExpressionValue(setUnmodifiableSet3, "unmodifiableSet(\n            if (expiredPermissions != null) HashSet(expiredPermissions) else HashSet())");
        this.expiredPermissions = setUnmodifiableSet3;
        this.token = accessToken;
        accessTokenSource = accessTokenSource == null ? DEFAULT_ACCESS_TOKEN_SOURCE : accessTokenSource;
        if (str != null && str.equals("instagram")) {
            int iOrdinal = accessTokenSource.ordinal();
            if (iOrdinal == 1) {
                accessTokenSource = AccessTokenSource.INSTAGRAM_APPLICATION_WEB;
            } else if (iOrdinal == 4) {
                accessTokenSource = AccessTokenSource.INSTAGRAM_WEB_VIEW;
            } else if (iOrdinal == 5) {
                accessTokenSource = AccessTokenSource.INSTAGRAM_CUSTOM_CHROME_TAB;
            }
        }
        this.source = accessTokenSource;
        this.lastRefresh = date2 == null ? DEFAULT_LAST_REFRESH_TIME : date2;
        this.applicationId = applicationId;
        this.userId = userId;
        this.dataAccessExpirationTime = (date3 == null || date3.getTime() == 0) ? date4 : date3;
        this.graphDomain = str == null ? "facebook" : str;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        boolean zAreEqual;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccessToken)) {
            return false;
        }
        AccessToken accessToken = (AccessToken) obj;
        if (Intrinsics.areEqual(this.expires, accessToken.expires) && Intrinsics.areEqual(this.permissions, accessToken.permissions) && Intrinsics.areEqual(this.declinedPermissions, accessToken.declinedPermissions) && Intrinsics.areEqual(this.expiredPermissions, accessToken.expiredPermissions) && Intrinsics.areEqual(this.token, accessToken.token) && this.source == accessToken.source && Intrinsics.areEqual(this.lastRefresh, accessToken.lastRefresh) && Intrinsics.areEqual(this.applicationId, accessToken.applicationId) && Intrinsics.areEqual(this.userId, accessToken.userId) && Intrinsics.areEqual(this.dataAccessExpirationTime, accessToken.dataAccessExpirationTime)) {
            String str = this.graphDomain;
            String str2 = accessToken.graphDomain;
            if (str == null) {
                zAreEqual = str2 == null;
            } else {
                zAreEqual = Intrinsics.areEqual(str, str2);
            }
            if (zAreEqual) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.dataAccessExpirationTime.hashCode() + CoroutineAdapterKt$$ExternalSyntheticLambda0.m(CoroutineAdapterKt$$ExternalSyntheticLambda0.m((this.lastRefresh.hashCode() + ((this.source.hashCode() + CoroutineAdapterKt$$ExternalSyntheticLambda0.m((this.expiredPermissions.hashCode() + ((this.declinedPermissions.hashCode() + ((this.permissions.hashCode() + ((this.expires.hashCode() + 527) * 31)) * 31)) * 31)) * 31, 31, this.token)) * 31)) * 31, 31, this.applicationId), 31, this.userId)) * 31;
        String str = this.graphDomain;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final JSONObject toJSONObject$facebook_core_release() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", 1);
        jSONObject.put("token", this.token);
        jSONObject.put("expires_at", this.expires.getTime());
        jSONObject.put("permissions", new JSONArray((Collection) this.permissions));
        jSONObject.put("declined_permissions", new JSONArray((Collection) this.declinedPermissions));
        jSONObject.put("expired_permissions", new JSONArray((Collection) this.expiredPermissions));
        jSONObject.put("last_refresh", this.lastRefresh.getTime());
        jSONObject.put(FirebaseAnalytics.Param.SOURCE, this.source.name());
        jSONObject.put("application_id", this.applicationId);
        jSONObject.put("user_id", this.userId);
        jSONObject.put("data_access_expiration_time", this.dataAccessExpirationTime.getTime());
        String str = this.graphDomain;
        if (str != null) {
            jSONObject.put("graph_domain", str);
        }
        return jSONObject;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{AccessToken token:ACCESS_TOKEN_REMOVED permissions:[");
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        synchronized (FacebookSdk.loggingBehaviors) {
        }
        sb.append(TextUtils.join(", ", this.permissions));
        sb.append("]}");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "builder.toString()");
        return string;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, nYVxXTZQ.KeO);
        parcel.writeLong(this.expires.getTime());
        parcel.writeStringList(new ArrayList(this.permissions));
        parcel.writeStringList(new ArrayList(this.declinedPermissions));
        parcel.writeStringList(new ArrayList(this.expiredPermissions));
        parcel.writeString(this.token);
        parcel.writeString(this.source.name());
        parcel.writeLong(this.lastRefresh.getTime());
        parcel.writeString(this.applicationId);
        parcel.writeString(this.userId);
        parcel.writeLong(this.dataAccessExpirationTime.getTime());
        parcel.writeString(this.graphDomain);
    }

    public AccessToken(Parcel parcel) {
        AccessTokenSource accessTokenSourceValueOf;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.expires = new Date(parcel.readLong());
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        Set setUnmodifiableSet = Collections.unmodifiableSet(new HashSet(arrayList));
        Intrinsics.checkNotNullExpressionValue(setUnmodifiableSet, "unmodifiableSet(HashSet(permissionsList))");
        this.permissions = setUnmodifiableSet;
        arrayList.clear();
        parcel.readStringList(arrayList);
        Set setUnmodifiableSet2 = Collections.unmodifiableSet(new HashSet(arrayList));
        Intrinsics.checkNotNullExpressionValue(setUnmodifiableSet2, "unmodifiableSet(HashSet(permissionsList))");
        this.declinedPermissions = setUnmodifiableSet2;
        arrayList.clear();
        parcel.readStringList(arrayList);
        Set setUnmodifiableSet3 = Collections.unmodifiableSet(new HashSet(arrayList));
        Intrinsics.checkNotNullExpressionValue(setUnmodifiableSet3, "unmodifiableSet(HashSet(permissionsList))");
        this.expiredPermissions = setUnmodifiableSet3;
        String string = parcel.readString();
        Validate.notNullOrEmpty(string, "token");
        this.token = string;
        String string2 = parcel.readString();
        if (string2 != null) {
            accessTokenSourceValueOf = AccessTokenSource.valueOf(string2);
        } else {
            accessTokenSourceValueOf = DEFAULT_ACCESS_TOKEN_SOURCE;
        }
        this.source = accessTokenSourceValueOf;
        this.lastRefresh = new Date(parcel.readLong());
        String string3 = parcel.readString();
        Validate.notNullOrEmpty(string3, "applicationId");
        this.applicationId = string3;
        String string4 = parcel.readString();
        Validate.notNullOrEmpty(string4, "userId");
        this.userId = string4;
        this.dataAccessExpirationTime = new Date(parcel.readLong());
        this.graphDomain = parcel.readString();
    }
}
