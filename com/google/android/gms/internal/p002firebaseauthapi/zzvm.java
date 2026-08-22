package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzaj;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzvm extends zzyb {
    private final zzrs zza;

    public zzvm(String str, String str2) {
        super(3);
        zzah.checkNotEmpty(str, "email cannot be null or empty");
        this.zza = new zzrs(str, str2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyd
    public final String zza() {
        return "fetchSignInMethodsForEmail";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyb
    public final void zzb() {
        List listZzb;
        if (this.zzl.zzb() == null) {
            listZzb = zzal.zzg();
        } else {
            listZzb = this.zzl.zzb();
            zzah.checkNotNull(listZzb);
        }
        zzm(new zzaj(listZzb));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyd
    public final void zzc(TaskCompletionSource taskCompletionSource, zzxb zzxbVar) {
        this.zzv = new zzya(this, taskCompletionSource);
        zzxbVar.zzk(this.zza, this.zzc);
    }
}
