package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.work.WorkContinuation;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.internal.zah;
import com.google.android.gms.common.internal.zap;
import com.google.android.gms.internal.p002firebaseauthapi.zzxc;
import com.google.android.gms.internal.p002firebaseauthapi.zzxo;
import com.google.android.gms.internal.p002firebaseauthapi.zzyz;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi$AttestationResponse;
import com.google.android.gms.safetynet.SafetyNetApi$zza;
import com.google.android.gms.safetynet.SafetyNetClient;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.zxing.oned.UPCAWriter;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzf {
    public static final String zza = "zzf";
    public static final zzf zzb = new zzf();

    public static zzf zzb() {
        return zzb;
    }

    public final void zze(FirebaseAuth firebaseAuth, zzbm zzbmVar, Activity activity, TaskCompletionSource taskCompletionSource) {
        com.google.android.gms.tasks.zzw zzwVarForException;
        zzbmVar.zzg(firebaseAuth.getApp().getApplicationContext(), firebaseAuth);
        com.google.android.gms.common.internal.zzah.checkNotNull(activity);
        TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
        if (zzax.zza().zzg(activity, taskCompletionSource2)) {
            Intent intent = new Intent("com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
            intent.setClass(activity, RecaptchaActivity.class);
            intent.setPackage(activity.getPackageName());
            intent.putExtra("com.google.firebase.auth.KEY_API_KEY", firebaseAuth.getApp().getOptions().getApiKey());
            if (!TextUtils.isEmpty(firebaseAuth.getTenantId())) {
                intent.putExtra("com.google.firebase.auth.KEY_TENANT_ID", firebaseAuth.getTenantId());
            }
            intent.putExtra("com.google.firebase.auth.internal.CLIENT_VERSION", zzxo.zza().zzb());
            intent.putExtra("com.google.firebase.auth.internal.FIREBASE_APP_NAME", firebaseAuth.getApp().getName());
            activity.startActivity(intent);
            zzwVarForException = taskCompletionSource2.zza;
        } else {
            zzwVarForException = WorkContinuation.forException(zzxc.zza(new Status(17057, "reCAPTCHA flow already in progress")));
        }
        UPCAWriter uPCAWriter = new UPCAWriter(taskCompletionSource);
        zzwVarForException.getClass();
        zzwVarForException.addOnSuccessListener(TaskExecutors.MAIN_THREAD, uPCAWriter);
        zzwVarForException.addOnFailureListener(new Fragment.AnonymousClass7(taskCompletionSource, 28));
    }

    public final Task zza(FirebaseAuth firebaseAuth, String str, Activity activity, boolean z) {
        SafetyNetClient safetyNetClient;
        zzw zzwVar = (zzw) firebaseAuth.getFirebaseAuthSettings();
        if (z) {
            Context applicationContext = firebaseAuth.getApp().getApplicationContext();
            Api api = SafetyNet.API;
            safetyNetClient = new SafetyNetClient(applicationContext, SafetyNet.API, null, new ApiExceptionMapper());
        } else {
            safetyNetClient = null;
        }
        zzbm zzbmVarZzc = zzbm.zzc();
        if (zzyz.zzg(firebaseAuth.getApp()) || zzwVar.zze()) {
            return WorkContinuation.forResult(new zze(null, null));
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        Task taskZzb = zzbmVarZzc.zzb();
        if (taskZzb != null) {
            if (taskZzb.isSuccessful()) {
                return WorkContinuation.forResult(new zze(null, (String) taskZzb.getResult()));
            }
            String str2 = zza;
            Log.e(str2, "Error in previous reCAPTCHA flow: ".concat(String.valueOf(taskZzb.getException().getMessage())));
            Log.e(str2, "Continuing with application verification as normal");
        }
        if (safetyNetClient == null || zzwVar.zzc()) {
            zze(firebaseAuth, zzbmVarZzc, activity, taskCompletionSource);
        } else {
            FirebaseApp app = firebaseAuth.getApp();
            byte[] bytes = new byte[0];
            if (str != null) {
                try {
                    bytes = str.getBytes("UTF-8");
                } catch (UnsupportedEncodingException e) {
                    Log.e(zza, "Failed to getBytes with exception: ".concat(String.valueOf(e.getMessage())));
                }
            }
            PendingResult<SafetyNetApi$zza> pendingResultZza = com.google.android.gms.internal.safetynet.zzk.zza(safetyNetClient.asGoogleApiClient(), bytes, app.getOptions().getApiKey());
            zah zahVar = new zah(new SafetyNetApi$AttestationResponse());
            TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
            pendingResultZza.addStatusListener(new zap(pendingResultZza, taskCompletionSource2, zahVar));
            zza zzaVar = new zza(this, taskCompletionSource, firebaseAuth, zzbmVarZzc, activity);
            com.google.android.gms.tasks.zzw zzwVar2 = taskCompletionSource2.zza;
            zzwVar2.getClass();
            zzwVar2.addOnSuccessListener(TaskExecutors.MAIN_THREAD, zzaVar);
            zzwVar2.addOnFailureListener(new zza(this, firebaseAuth, zzbmVarZzc, activity, taskCompletionSource));
        }
        return taskCompletionSource.zza;
    }
}
