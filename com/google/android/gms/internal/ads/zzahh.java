package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzahh extends zzahf {
    public final String zza;
    public final String zzb;
    public final String zzc;

    public zzahh(String str, String str2, String str3) {
        super("----");
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzahh.class == obj.getClass()) {
            zzahh zzahhVar = (zzahh) obj;
            if (Objects.equals(this.zzb, zzahhVar.zzb) && Objects.equals(this.zza, zzahhVar.zza) && Objects.equals(this.zzc, zzahhVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zza.hashCode() + 527;
        int iHashCode2 = this.zzb.hashCode() + (iHashCode * 31);
        return this.zzc.hashCode() + (iHashCode2 * 31);
    }

    @Override // com.google.android.gms.internal.ads.zzahf
    public final String toString() {
        return this.zzf + ": domain=" + this.zza + ", description=" + this.zzb;
    }
}
