package com.google.android.gms.internal.safetynet;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.HarmfulAppsData;
import com.google.android.gms.safetynet.SafeBrowsingData;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi$zza;
import com.google.android.gms.safetynet.SafetyNetApi$zzc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class zzk {
    private static final String TAG = "zzk";

    public static class zza implements SafetyNetApi$zza {
        private final Status zzad;
        private final com.google.android.gms.safetynet.zza zzae;

        public zza(Status status, com.google.android.gms.safetynet.zza zzaVar) {
            this.zzad = status;
            this.zzae = zzaVar;
        }

        @Override // com.google.android.gms.safetynet.SafetyNetApi$zza
        public final String getJwsResult() {
            com.google.android.gms.safetynet.zza zzaVar = this.zzae;
            if (zzaVar == null) {
                return null;
            }
            return zzaVar.zze;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzad;
        }
    }

    public static abstract class zzb extends com.google.android.gms.internal.safetynet.zzf<SafetyNetApi$zza> {
        protected com.google.android.gms.internal.safetynet.zzg zzaf;

        public zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzaf = new zzs(this);
        }

        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        public /* synthetic */ Result createFailedResult(Status status) {
            return new zza(status, null);
        }
    }

    public static abstract class zzc extends com.google.android.gms.internal.safetynet.zzf<SafetyNetApi$zzc> {
        protected com.google.android.gms.internal.safetynet.zzg zzaf;

        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzaf = new zzt(this);
        }

        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        public /* synthetic */ Result createFailedResult(Status status) {
            return new zzj(status, false);
        }
    }

    public static abstract class zzd extends com.google.android.gms.internal.safetynet.zzf<Object> {
        protected final com.google.android.gms.internal.safetynet.zzg zzaf;

        public zzd(GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzaf = new zzu(this);
        }

        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        public /* synthetic */ Result createFailedResult(Status status) {
            return new zzg(status, null);
        }
    }

    public static abstract class zze extends com.google.android.gms.internal.safetynet.zzf<Object> {
        protected com.google.android.gms.internal.safetynet.zzg zzaf;

        public zze(GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzaf = new zzv(this);
        }

        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        public /* synthetic */ Result createFailedResult(Status status) {
            return new zzh(status, null);
        }
    }

    public static abstract class zzf extends com.google.android.gms.internal.safetynet.zzf<Object> {
        protected com.google.android.gms.internal.safetynet.zzg zzaf;

        public zzf(GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzaf = new zzw(this);
        }

        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        public /* synthetic */ Result createFailedResult(Status status) {
            return new zzi(status, null);
        }
    }

    public static class zzg implements Result {
        private final Status zzad;
        private final com.google.android.gms.safetynet.zzd zzal;

        public zzg(Status status, com.google.android.gms.safetynet.zzd zzdVar) {
            this.zzad = status;
            this.zzal = zzdVar;
        }

        public final List<HarmfulAppsData> getHarmfulAppsList() {
            com.google.android.gms.safetynet.zzd zzdVar = this.zzal;
            return zzdVar == null ? Collections.emptyList() : Arrays.asList(zzdVar.zzg);
        }

        public final int getHoursSinceLastScanWithHarmfulApp() {
            com.google.android.gms.safetynet.zzd zzdVar = this.zzal;
            if (zzdVar == null) {
                return -1;
            }
            return zzdVar.zzh;
        }

        public final long getLastScanTimeMs() {
            com.google.android.gms.safetynet.zzd zzdVar = this.zzal;
            if (zzdVar == null) {
                return 0L;
            }
            return zzdVar.zzf;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzad;
        }
    }

    public static class zzh implements Result {
        private final Status zzad;
        private final com.google.android.gms.safetynet.zzf zzam;

        public zzh(Status status, com.google.android.gms.safetynet.zzf zzfVar) {
            this.zzad = status;
            this.zzam = zzfVar;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzad;
        }

        public final String getTokenResult() {
            com.google.android.gms.safetynet.zzf zzfVar = this.zzam;
            if (zzfVar == null) {
                return null;
            }
            return zzfVar.zzj;
        }
    }

    public static class zzi implements Result {
        private Status zzad;
        private final SafeBrowsingData zzan;
        private String zzm;
        private long zzp;
        private byte[] zzq;

        public zzi(Status status, SafeBrowsingData safeBrowsingData) {
            this.zzad = status;
            this.zzan = safeBrowsingData;
            this.zzm = null;
            if (safeBrowsingData != null) {
                this.zzm = safeBrowsingData.zzm;
                this.zzp = safeBrowsingData.zzp;
                this.zzq = safeBrowsingData.zzq;
            } else if (status.isSuccess()) {
                this.zzad = new Status(8);
            }
        }

        public final List<com.google.firebase.auth.zzr> getDetectedThreats() {
            ArrayList arrayList = new ArrayList();
            String str = this.zzm;
            if (str == null) {
                return arrayList;
            }
            try {
                JSONArray jSONArray = new JSONObject(str).getJSONArray("matches");
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        Integer.parseInt(jSONArray.getJSONObject(i).getString("threat_type"));
                        arrayList.add(new com.google.firebase.auth.zzr(4));
                    } catch (NumberFormatException | JSONException unused) {
                    }
                }
            } catch (JSONException unused2) {
            }
            return arrayList;
        }

        public final long getLastUpdateTimeMs() {
            return this.zzp;
        }

        public final String getMetadata() {
            return this.zzm;
        }

        public final byte[] getState() {
            return this.zzq;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzad;
        }
    }

    public static class zzj implements SafetyNetApi$zzc {
        private Status zzad;
        private boolean zzao;

        public zzj() {
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzad;
        }

        @Override // com.google.android.gms.safetynet.SafetyNetApi$zzc
        public final boolean isVerifyAppsEnabled() {
            Status status = this.zzad;
            if (status == null || !status.isSuccess()) {
                return false;
            }
            return this.zzao;
        }

        public zzj(Status status, boolean z) {
            this.zzad = status;
            this.zzao = z;
        }
    }

    public static PendingResult<Object> zza(GoogleApiClient googleApiClient, String str, int i, String str2, int... iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException("Null threatTypes in lookupUri");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Null or empty uri in lookupUri");
        }
        return googleApiClient.enqueue(new zzn(googleApiClient, iArr, i, str, str2));
    }

    public PendingResult<SafetyNetApi$zza> attest(GoogleApiClient googleApiClient, byte[] bArr) {
        return zza(googleApiClient, bArr, null);
    }

    public PendingResult<SafetyNetApi$zzc> enableVerifyApps(GoogleApiClient googleApiClient) {
        return googleApiClient.enqueue(new zzp(this, googleApiClient));
    }

    public PendingResult<SafetyNetApi$zzc> isVerifyAppsEnabled(GoogleApiClient googleApiClient) {
        return googleApiClient.enqueue(new zzo(this, googleApiClient));
    }

    public PendingResult<Object> listHarmfulApps(GoogleApiClient googleApiClient) {
        return googleApiClient.enqueue(new zzq(this, googleApiClient));
    }

    public PendingResult<Object> lookupUri(GoogleApiClient googleApiClient, String str, String str2, int... iArr) {
        return zza(googleApiClient, str, 1, str2, iArr);
    }

    public PendingResult<Object> verifyWithRecaptcha(GoogleApiClient googleApiClient, String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Null or empty site key in verifyWithRecaptcha");
        }
        return googleApiClient.enqueue(new zzr(this, googleApiClient, str));
    }

    public static PendingResult<SafetyNetApi$zza> zza(GoogleApiClient googleApiClient, byte[] bArr, String str) {
        return googleApiClient.enqueue(new zzl(googleApiClient, bArr, str));
    }

    public boolean isVerifyAppsEnabled(Context context) {
        GoogleApiClient googleApiClientBuild = new GoogleApiClient.Builder(context).addApi(SafetyNet.API).build();
        try {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            boolean z = false;
            if (!googleApiClientBuild.blockingConnect(3L, timeUnit).isSuccess()) {
                googleApiClientBuild.disconnect();
                return false;
            }
            SafetyNetApi$zzc safetyNetApi$zzc = (SafetyNetApi$zzc) isVerifyAppsEnabled(googleApiClientBuild).await(3L, timeUnit);
            if (safetyNetApi$zzc != null && safetyNetApi$zzc.isVerifyAppsEnabled()) {
                z = true;
            }
            googleApiClientBuild.disconnect();
            return z;
        } catch (Throwable th) {
            if (googleApiClientBuild != null) {
                googleApiClientBuild.disconnect();
            }
            throw th;
        }
    }

    public PendingResult<Object> lookupUri(GoogleApiClient googleApiClient, List<Integer> list, String str) {
        if (list == null) {
            throw new IllegalArgumentException("Null threatTypes in lookupUri");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Null or empty uri in lookupUri");
        }
        return googleApiClient.enqueue(new zzm(this, googleApiClient, list, str, null));
    }
}
