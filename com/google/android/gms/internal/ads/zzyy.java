package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public class zzyy implements zzyw {
    private final zzyw zza;

    public zzyy(zzyw zzywVar) {
        this.zza = zzywVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzyy) {
            return this.zza.equals(((zzyy) obj).zza);
        }
        return false;
    }

    public int hashCode() {
        return this.zza.hashCode();
    }

    @Override // com.google.android.gms.internal.ads.zzzb
    public zzz zza(int i) {
        return this.zza.zza(i);
    }

    @Override // com.google.android.gms.internal.ads.zzyw
    public zzz zzb() {
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzzb
    public zzbm zzc() {
        return this.zza.zzc();
    }

    public final zzyw zzd() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzzb
    public final int zze(int i) {
        return this.zza.zze(i);
    }

    @Override // com.google.android.gms.internal.ads.zzyw
    public final int zzf() {
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzzb
    public final int zzg(int i) {
        return this.zza.zzg(i);
    }

    @Override // com.google.android.gms.internal.ads.zzzb
    public final int zzh() {
        return this.zza.zzh();
    }
}
