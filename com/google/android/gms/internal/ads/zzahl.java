package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzahl extends zzahf {
    public final String zza;
    public final String zzb;

    public zzahl(String str, String str2, String str3) {
        super(str);
        this.zza = str2;
        this.zzb = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzahl.class == obj.getClass()) {
            zzahl zzahlVar = (zzahl) obj;
            if (this.zzf.equals(zzahlVar.zzf) && Objects.equals(this.zza, zzahlVar.zza) && Objects.equals(this.zzb, zzahlVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zzf.hashCode() + 527;
        String str = this.zza;
        return this.zzb.hashCode() + (((iHashCode * 31) + (str != null ? str.hashCode() : 0)) * 31);
    }

    @Override // com.google.android.gms.internal.ads.zzahf
    public final String toString() {
        return this.zzf + ": url=" + this.zzb;
    }
}
