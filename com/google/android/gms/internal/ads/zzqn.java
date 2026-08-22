package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes.dex */
public final class zzqn extends Exception {
    public final int zza;
    public final boolean zzb;
    public final zzz zzc;

    public zzqn(int i, zzz zzzVar, boolean z) {
        super(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "AudioTrack write failed: "));
        this.zzb = z;
        this.zza = i;
        this.zzc = zzzVar;
    }
}
