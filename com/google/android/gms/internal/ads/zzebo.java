package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import com.google.android.gms.ads.internal.gMU.QTaELkFI;

/* JADX INFO: loaded from: classes2.dex */
final class zzebo extends zzebs {
    private final String zza;
    private final String zzb;
    private final Drawable zzc;

    public zzebo(String str, String str2, Drawable drawable) {
        this.zza = str;
        if (str2 == null) {
            throw new NullPointerException("Null imageUrl");
        }
        this.zzb = str2;
        this.zzc = drawable;
    }

    public final boolean equals(Object obj) {
        Drawable drawable;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzebs) {
            zzebs zzebsVar = (zzebs) obj;
            String str = this.zza;
            if (str != null ? str.equals(zzebsVar.zzb()) : zzebsVar.zzb() == null) {
                if (this.zzb.equals(zzebsVar.zzc()) && ((drawable = this.zzc) != null ? drawable.equals(zzebsVar.zza()) : zzebsVar.zza() == null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zza;
        int iHashCode = (((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.zzb.hashCode();
        Drawable drawable = this.zzc;
        return (iHashCode * 1000003) ^ (drawable != null ? drawable.hashCode() : 0);
    }

    @Override // com.google.android.gms.internal.ads.zzebs
    public final Drawable zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzebs
    public final String zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzebs
    public final String zzc() {
        return this.zzb;
    }

    public final String toString() {
        return "OfflineAdAssets{advertiserName=" + this.zza + ", imageUrl=" + this.zzb + QTaELkFI.sRIfVCKwz + String.valueOf(this.zzc) + "}";
    }
}
