package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class zzdhv implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzdhv(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzdhv zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzdhv(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzddx((Context) this.zza.zzb(), new HashSet(), ((zzcrr) this.zzb).zzc());
    }
}
