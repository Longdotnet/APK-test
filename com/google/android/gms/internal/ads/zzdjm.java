package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdjm implements zzhgr {
    private final zzdjf zza;

    private zzdjm(zzdjf zzdjfVar) {
        this.zza = zzdjfVar;
    }

    public static zzdit zzc(zzdjf zzdjfVar) {
        zzdit zzditVarZza = zzdjfVar.zza();
        zzhgz.zzb(zzditVarZza);
        return zzditVarZza;
    }

    public static zzdjm zzd(zzdjf zzdjfVar) {
        return new zzdjm(zzdjfVar);
    }

    public final zzdit zza() {
        return zzc(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        return zzc(this.zza);
    }
}
