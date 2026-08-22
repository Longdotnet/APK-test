package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzie {
    public final String zza;
    public final zzz zzb;
    public final zzz zzc;
    public final int zzd;
    public final int zze;

    public zzie(String str, zzz zzzVar, zzz zzzVar2, int i, int i2) {
        boolean z = true;
        if (i != 0) {
            if (i2 == 0) {
                i2 = 0;
            } else {
                z = false;
            }
        }
        zzdd.zzd(z);
        zzdd.zzc(str);
        this.zza = str;
        this.zzb = zzzVar;
        zzzVar2.getClass();
        this.zzc = zzzVar2;
        this.zzd = i;
        this.zze = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzie.class == obj.getClass()) {
            zzie zzieVar = (zzie) obj;
            if (this.zzd == zzieVar.zzd && this.zze == zzieVar.zze && this.zza.equals(zzieVar.zza) && this.zzb.equals(zzieVar.zzb) && this.zzc.equals(zzieVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzd + 527;
        String str = this.zza;
        int iHashCode = str.hashCode() + (((i * 31) + this.zze) * 31);
        int iHashCode2 = this.zzb.hashCode() + (iHashCode * 31);
        return this.zzc.hashCode() + (iHashCode2 * 31);
    }
}
