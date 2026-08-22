package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzvu extends zzyy {
    private final zzbm zza;

    public zzvu(zzyw zzywVar, zzbm zzbmVar) {
        super(zzywVar);
        this.zza = zzbmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzyy
    public final boolean equals(Object obj) {
        if (super.equals(obj) && (obj instanceof zzvu)) {
            return this.zza.equals(((zzvu) obj).zza);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzyy
    public final int hashCode() {
        return this.zza.hashCode() + (super.hashCode() * 31);
    }

    @Override // com.google.android.gms.internal.ads.zzyy, com.google.android.gms.internal.ads.zzzb
    public final zzz zza(int i) {
        return this.zza.zzb(zzd().zze(i));
    }

    @Override // com.google.android.gms.internal.ads.zzyy, com.google.android.gms.internal.ads.zzyw
    public final zzz zzb() {
        return this.zza.zzb(zzd().zzf());
    }

    @Override // com.google.android.gms.internal.ads.zzyy, com.google.android.gms.internal.ads.zzzb
    public final zzbm zzc() {
        return this.zza;
    }
}
