package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzetb implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzetb(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzetb zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzetb(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzesz((String) this.zza.zzb(), ((Integer) this.zzb.zzb()).intValue());
    }
}
