package com.google.firebase.auth.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.safetynet.SafetyNetApi$AttestationResponse;
import com.google.android.gms.safetynet.SafetyNetApi$zza;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbf {
    public static final String zza = "zzbf";

    public static boolean zza(SafetyNetApi$AttestationResponse safetyNetApi$AttestationResponse) {
        if (safetyNetApi$AttestationResponse == null || TextUtils.isEmpty(((SafetyNetApi$zza) safetyNetApi$AttestationResponse.getResult()).getJwsResult())) {
            Log.e(zza, "No SafetyNet AttestationResponse passed.");
            return false;
        }
        zzbe zzbeVarZza = zzbe.zza(((SafetyNetApi$zza) safetyNetApi$AttestationResponse.getResult()).getJwsResult());
        if (zzbeVarZza == null) {
            Log.e(zza, "Unable to parse SafetyNet AttestationResponse");
            return false;
        }
        if (!zzbeVarZza.zzc()) {
            Log.e(zza, "SafetyNet Attestation fails basic integrity.");
            return false;
        }
        if (TextUtils.isEmpty(zzbeVarZza.zzb())) {
            return true;
        }
        Log.e(zza, "SafetyNet Attestation has advice: \n".concat(String.valueOf(zzbeVarZza.zzb())));
        return false;
    }
}
