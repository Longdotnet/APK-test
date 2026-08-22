package com.google.firebase.auth.internal;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.safetynet.SafetyNetApi$AttestationResponse;
import com.google.android.gms.safetynet.SafetyNetApi$zza;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: loaded from: classes.dex */
public final class zza implements OnFailureListener, OnSuccessListener {
    public final /* synthetic */ FirebaseAuth zza;
    public final /* synthetic */ zzbm zzb;
    public final /* synthetic */ Activity zzc;
    public final /* synthetic */ TaskCompletionSource zzd;
    public final /* synthetic */ zzf zze;

    public zza(zzf zzfVar, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, zzbm zzbmVar, Activity activity) {
        this.zze = zzfVar;
        this.zzd = taskCompletionSource;
        this.zza = firebaseAuth;
        this.zzb = zzbmVar;
        this.zzc = activity;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        Log.e(zzf.zza, "Problem retrieving SafetyNet Token: ".concat(String.valueOf(exc.getMessage())));
        TaskCompletionSource taskCompletionSource = this.zzd;
        this.zze.zze(this.zza, this.zzb, this.zzc, taskCompletionSource);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        SafetyNetApi$AttestationResponse safetyNetApi$AttestationResponse = (SafetyNetApi$AttestationResponse) obj;
        boolean zZza = zzbf.zza(safetyNetApi$AttestationResponse);
        TaskCompletionSource taskCompletionSource = this.zzd;
        if (zZza) {
            taskCompletionSource.setResult(new zze(((SafetyNetApi$zza) safetyNetApi$AttestationResponse.getResult()).getJwsResult(), null));
        } else {
            this.zze.zze(this.zza, this.zzb, this.zzc, taskCompletionSource);
        }
    }

    public zza(zzf zzfVar, FirebaseAuth firebaseAuth, zzbm zzbmVar, Activity activity, TaskCompletionSource taskCompletionSource) {
        this.zze = zzfVar;
        this.zza = firebaseAuth;
        this.zzb = zzbmVar;
        this.zzc = activity;
        this.zzd = taskCompletionSource;
    }
}
