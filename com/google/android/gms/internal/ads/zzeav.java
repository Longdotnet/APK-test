package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzeav implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzeav(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzeav zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzeav(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzeau(((zzebg) this.zza).zzb(), ((zzchi) this.zzb).zzb());
    }
}
