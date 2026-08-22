package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzhak implements zzhbm {
    private static final zzhaq zza = new zzhai();
    private final zzhaq zzb;

    public zzhak() {
        zzgza zzgzaVarZza = zzgza.zza();
        int i = zzhbc.zza;
        zzhaj zzhajVar = new zzhaj(zzgzaVarZza, zza);
        byte[] bArr = zzgzu.zzb;
        this.zzb = zzhajVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbm
    public final zzhbl zza(Class cls) {
        int i = zzhbn.zza;
        if (!zzgzh.class.isAssignableFrom(cls)) {
            int i2 = zzhbc.zza;
        }
        zzhap zzhapVarZzb = this.zzb.zzb(cls);
        if (zzhapVarZzb.zzb()) {
            int i3 = zzhbc.zza;
            return zzhaw.zzc(zzhbn.zzm(), zzgyu.zza(), zzhapVarZzb.zza());
        }
        int i4 = zzhbc.zza;
        return zzhav.zzm(cls, zzhapVarZzb, zzhaz.zza(), zzhag.zza(), zzhbn.zzm(), zzhapVarZzb.zzc() + (-1) != 1 ? zzgyu.zza() : null, zzhao.zza());
    }
}
