package com.google.firebase.auth.internal;

import android.content.Context;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;

/* JADX INFO: loaded from: classes.dex */
public final class zzap implements OnFailureListener, OnSuccessListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ TaskCompletionSource zza;
    public final /* synthetic */ Context zzb;

    public /* synthetic */ zzap(TaskCompletionSource taskCompletionSource, Context context, int i) {
        this.$r8$classId = i;
        this.zza = taskCompletionSource;
        this.zzb = context;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        switch (this.$r8$classId) {
            case 0:
                this.zza.setException(exc);
                zzax.zze(this.zzb);
                break;
            case 1:
            default:
                this.zza.setException(exc);
                zzax.zze(this.zzb);
                break;
            case 2:
                this.zza.setException(exc);
                zzax.zze(this.zzb);
                break;
        }
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        switch (this.$r8$classId) {
            case 1:
                this.zza.setResult((AuthResult) obj);
                zzax.zze(this.zzb);
                break;
            case 2:
            default:
                this.zza.setResult((AuthResult) obj);
                zzax.zze(this.zzb);
                break;
            case 3:
                this.zza.setResult((AuthResult) obj);
                zzax.zze(this.zzb);
                break;
        }
    }
}
