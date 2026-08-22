package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.stats.ZnFR.FKidOcdAYt;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.internal.zzo;

/* JADX INFO: loaded from: classes2.dex */
final class zzww extends zzyb {
    private final zzre zza;

    public zzww(String str, String str2) {
        super(4);
        zzah.checkNotEmpty(str, FKidOcdAYt.azzREqAdroQe);
        this.zza = new zzre(str, str2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyd
    public final String zza() {
        return "verifyPasswordResetCode";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyb
    public final void zzb() {
        if (new zzo(this.zzm).getOperation() != 0) {
            zzl(new Status(FirebaseError.ERROR_INTERNAL_ERROR));
        } else {
            zzm(this.zzm.zzc());
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyd
    public final void zzc(TaskCompletionSource taskCompletionSource, zzxb zzxbVar) {
        this.zzv = new zzya(this, taskCompletionSource);
        zzxbVar.zzd(this.zza, this.zzc);
    }
}
