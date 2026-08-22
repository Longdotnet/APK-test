package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzflb implements Runnable {
    final /* synthetic */ zzfld zza;

    public zzflb(zzfld zzfldVar) {
        Objects.requireNonNull(zzfldVar);
        this.zza = zzfldVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzI();
    }
}
