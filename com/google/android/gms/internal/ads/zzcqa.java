package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzcqa implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzcqa(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3) {
        this.zza = zzhhaVar2;
        this.zzb = zzhhaVar3;
    }

    public static zzcqa zza(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3) {
        return new zzcqa(zzhhaVar, zzhhaVar2, zzhhaVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        return true == Boolean.valueOf(zzcpy.zza()).booleanValue() ? ((zzegu) this.zza).zzb() : ((zzeiu) this.zzb).zzb();
    }
}
