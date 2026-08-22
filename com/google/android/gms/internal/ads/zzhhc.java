package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzhhc {
    private final List zza;
    private final List zzb;

    public /* synthetic */ zzhhc(int i, int i2, zzhhb zzhhbVar) {
        this.zza = zzhgo.zzc(i);
        this.zzb = zzhgo.zzc(i2);
    }

    public final zzhhc zza(zzhha zzhhaVar) {
        this.zzb.add(zzhhaVar);
        return this;
    }

    public final zzhhc zzb(zzhha zzhhaVar) {
        this.zza.add(zzhhaVar);
        return this;
    }

    public final zzhhd zzc() {
        return new zzhhd(this.zza, this.zzb, null);
    }
}
