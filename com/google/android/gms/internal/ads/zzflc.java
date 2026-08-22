package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.DefaultClock;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzflc implements Runnable {
    final /* synthetic */ zzfld zza;

    public zzflc(zzfld zzfldVar) {
        Objects.requireNonNull(zzfldVar);
        this.zza = zzfldVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfld zzfldVar = this.zza;
        if (zzfldVar.zzp != null) {
            zzfkl zzfklVar = zzfldVar.zzp;
            ((DefaultClock) zzfldVar.zzq).getClass();
            zzfklVar.zzj(System.currentTimeMillis(), zzfldVar.zzr, zzfldVar.zze.zzd, zzfldVar.zzD());
        }
    }
}
