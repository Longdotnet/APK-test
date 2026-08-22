package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzaha extends zzahf {
    public final String zza;
    public final String zzb;
    public final String zzc;

    public zzaha(String str, String str2, String str3) {
        super("COMM");
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaha.class == obj.getClass()) {
            zzaha zzahaVar = (zzaha) obj;
            if (Objects.equals(this.zzb, zzahaVar.zzb) && Objects.equals(this.zza, zzahaVar.zza) && Objects.equals(this.zzc, zzahaVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zzb.hashCode() + ((this.zza.hashCode() + 527) * 31);
        String str = this.zzc;
        return (iHashCode * 31) + (str != null ? str.hashCode() : 0);
    }

    @Override // com.google.android.gms.internal.ads.zzahf
    public final String toString() {
        return this.zzf + ": language=" + this.zza + ", description=" + this.zzb + ", text=" + this.zzc;
    }
}
