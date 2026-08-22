package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgmz implements zzgfa {
    final String zza;
    final Class zzb;
    final zzgtz zzc;

    public zzgmz(String str, Class cls, zzgtz zzgtzVar, zzhba zzhbaVar) {
        this.zza = str;
        this.zzb = cls;
        this.zzc = zzgtzVar;
    }

    public static zzgfa zzd(String str, Class cls, zzgtz zzgtzVar, zzhba zzhbaVar) {
        return new zzgmz(str, cls, zzgtzVar, zzhbaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgfa
    public final zzgub zza(zzgxz zzgxzVar) {
        zzgud zzgudVarZza = zzguf.zza();
        zzgudVarZza.zzb(this.zza);
        zzgudVarZza.zzc(zzgxzVar);
        zzgudVarZza.zza(zzgvf.RAW);
        zzgox zzgoxVar = (zzgox) zzgny.zzc().zzd(zzgno.zzb().zza(zzgny.zzc().zzb(zzgoy.zza((zzguf) zzgudVarZza.zzbr())), null), zzgox.class, zzgey.zza());
        zzgty zzgtyVarZza = zzgub.zza();
        zzgtyVarZza.zzb(zzgoxVar.zzg());
        zzgtyVarZza.zzc(zzgoxVar.zze());
        zzgtyVarZza.zza(zzgoxVar.zzb());
        return (zzgub) zzgtyVarZza.zzbr();
    }

    @Override // com.google.android.gms.internal.ads.zzgfa
    public final Class zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgfa
    public final Object zzc(zzgxz zzgxzVar) {
        return zzgnv.zza().zzb(zzgny.zzc().zza(zzgox.zza(this.zza, zzgxzVar, this.zzc, zzgvf.RAW, null), zzgey.zza()), this.zzb);
    }
}
