package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.util.Strings;
import com.google.firebase.auth.zzz;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class FirebaseOptions {
    private static final String API_KEY_RESOURCE_NAME = "google_api_key";
    private static final String APP_ID_RESOURCE_NAME = "google_app_id";
    private static final String DATABASE_URL_RESOURCE_NAME = "firebase_database_url";
    private static final String GA_TRACKING_ID_RESOURCE_NAME = "ga_trackingId";
    private static final String GCM_SENDER_ID_RESOURCE_NAME = "gcm_defaultSenderId";
    private static final String PROJECT_ID_RESOURCE_NAME = "project_id";
    private static final String STORAGE_BUCKET_RESOURCE_NAME = "google_storage_bucket";
    private final String apiKey;
    private final String applicationId;
    private final String databaseUrl;
    private final String gaTrackingId;
    private final String gcmSenderId;
    private final String projectId;
    private final String storageBucket;

    public static final class Builder {
        private String apiKey;
        private String applicationId;
        private String databaseUrl;
        private String gaTrackingId;
        private String gcmSenderId;
        private String projectId;
        private String storageBucket;

        public Builder() {
        }

        public FirebaseOptions build() {
            return new FirebaseOptions(this.applicationId, this.apiKey, this.databaseUrl, this.gaTrackingId, this.gcmSenderId, this.storageBucket, this.projectId);
        }

        public Builder setApiKey(String str) {
            zzah.checkNotEmpty(str, "ApiKey must be set.");
            this.apiKey = str;
            return this;
        }

        public Builder setApplicationId(String str) {
            zzah.checkNotEmpty(str, "ApplicationId must be set.");
            this.applicationId = str;
            return this;
        }

        public Builder setDatabaseUrl(String str) {
            this.databaseUrl = str;
            return this;
        }

        public Builder setGaTrackingId(String str) {
            this.gaTrackingId = str;
            return this;
        }

        public Builder setGcmSenderId(String str) {
            this.gcmSenderId = str;
            return this;
        }

        public Builder setProjectId(String str) {
            this.projectId = str;
            return this;
        }

        public Builder setStorageBucket(String str) {
            this.storageBucket = str;
            return this;
        }

        public Builder(FirebaseOptions firebaseOptions) {
            this.applicationId = firebaseOptions.applicationId;
            this.apiKey = firebaseOptions.apiKey;
            this.databaseUrl = firebaseOptions.databaseUrl;
            this.gaTrackingId = firebaseOptions.gaTrackingId;
            this.gcmSenderId = firebaseOptions.gcmSenderId;
            this.storageBucket = firebaseOptions.storageBucket;
            this.projectId = firebaseOptions.projectId;
        }
    }

    public static FirebaseOptions fromResource(Context context) {
        zzz zzzVar = new zzz(context);
        String string = zzzVar.getString(APP_ID_RESOURCE_NAME);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new FirebaseOptions(string, zzzVar.getString(API_KEY_RESOURCE_NAME), zzzVar.getString(DATABASE_URL_RESOURCE_NAME), zzzVar.getString(GA_TRACKING_ID_RESOURCE_NAME), zzzVar.getString(GCM_SENDER_ID_RESOURCE_NAME), zzzVar.getString(STORAGE_BUCKET_RESOURCE_NAME), zzzVar.getString(PROJECT_ID_RESOURCE_NAME));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FirebaseOptions)) {
            return false;
        }
        FirebaseOptions firebaseOptions = (FirebaseOptions) obj;
        return zzah.equal(this.applicationId, firebaseOptions.applicationId) && zzah.equal(this.apiKey, firebaseOptions.apiKey) && zzah.equal(this.databaseUrl, firebaseOptions.databaseUrl) && zzah.equal(this.gaTrackingId, firebaseOptions.gaTrackingId) && zzah.equal(this.gcmSenderId, firebaseOptions.gcmSenderId) && zzah.equal(this.storageBucket, firebaseOptions.storageBucket) && zzah.equal(this.projectId, firebaseOptions.projectId);
    }

    public String getApiKey() {
        return this.apiKey;
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    public String getDatabaseUrl() {
        return this.databaseUrl;
    }

    public String getGaTrackingId() {
        return this.gaTrackingId;
    }

    public String getGcmSenderId() {
        return this.gcmSenderId;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public String getStorageBucket() {
        return this.storageBucket;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.applicationId, this.apiKey, this.databaseUrl, this.gaTrackingId, this.gcmSenderId, this.storageBucket, this.projectId});
    }

    public String toString() {
        zzz zzzVar = new zzz(this);
        zzzVar.add(this.applicationId, "applicationId");
        zzzVar.add(this.apiKey, "apiKey");
        zzzVar.add(this.databaseUrl, "databaseUrl");
        zzzVar.add(this.gcmSenderId, "gcmSenderId");
        zzzVar.add(this.storageBucket, "storageBucket");
        zzzVar.add(this.projectId, "projectId");
        return zzzVar.toString();
    }

    private FirebaseOptions(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int i = Strings.$r8$clinit;
        zzah.checkState(true ^ (str == null || str.trim().isEmpty()), "ApplicationId must be set.");
        this.applicationId = str;
        this.apiKey = str2;
        this.databaseUrl = str3;
        this.gaTrackingId = str4;
        this.gcmSenderId = str5;
        this.storageBucket = str6;
        this.projectId = str7;
    }
}
