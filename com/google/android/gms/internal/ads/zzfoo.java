package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzfoo extends zzfok {
    private final String zza;
    private final boolean zzb;
    private final boolean zzc;
    private final long zzd;
    private final long zze;

    public /* synthetic */ zzfoo(String str, boolean z, boolean z2, boolean z3, long j, boolean z4, long j2, zzfon zzfonVar) {
        this.zza = str;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = j;
        this.zze = j2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfok) {
            zzfok zzfokVar = (zzfok) obj;
            if (this.zza.equals(zzfokVar.zzd()) && this.zzb == zzfokVar.zzh() && this.zzc == zzfokVar.zzg()) {
                zzfokVar.zzf();
                if (this.zzd == zzfokVar.zzb()) {
                    zzfokVar.zze();
                    if (this.zze == zzfokVar.zza()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((((this.zza.hashCode() ^ 1000003) * 1000003) ^ (true != this.zzb ? 1237 : 1231)) * 1000003) ^ (true != this.zzc ? 1237 : 1231)) * 1000003) ^ 1237) * 1000003) ^ ((int) this.zzd)) * 1000003) ^ 1237) * 1000003) ^ ((int) this.zze);
    }

    public final String toString() {
        return "AdShield2Options{clientVersion=" + this.zza + ", shouldGetAdvertisingId=" + this.zzb + ", isGooglePlayServicesAvailable=" + this.zzc + ", enableQuerySignalsTimeout=false, querySignalsTimeoutMs=" + this.zzd + ", enableQuerySignalsCache=false, querySignalsCacheTtlSeconds=" + this.zze + "}";
    }

    @Override // com.google.android.gms.internal.ads.zzfok
    public final long zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzfok
    public final long zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzfok
    public final String zzd() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzfok
    public final boolean zze() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzfok
    public final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzfok
    public final boolean zzg() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzfok
    public final boolean zzh() {
        return this.zzb;
    }
}
