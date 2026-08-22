package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgoy implements zzgpb {
    private final zzgxe zza;
    private final zzguf zzb;

    private zzgoy(zzguf zzgufVar, zzgxe zzgxeVar) {
        this.zzb = zzgufVar;
        this.zza = zzgxeVar;
    }

    public static zzgoy zza(zzguf zzgufVar) {
        return new zzgoy(zzgufVar, zzgpj.zza(zzgufVar.zzi()));
    }

    public static zzgoy zzb(zzguf zzgufVar) {
        return new zzgoy(zzgufVar, zzgpj.zzb(zzgufVar.zzi()));
    }

    public final zzguf zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgpb
    public final zzgxe zzd() {
        return this.zza;
    }
}
