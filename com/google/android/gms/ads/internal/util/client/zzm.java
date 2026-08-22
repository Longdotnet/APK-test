package com.google.android.gms.ads.internal.util.client;

/* JADX INFO: loaded from: classes.dex */
public final class zzm extends zzw {
    public final int zza;
    public final int zzb;
    public final boolean zzc;

    public zzm(int i, int i2, boolean z) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = z;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzw) {
            zzw zzwVar = (zzw) obj;
            if (this.zza == ((zzm) zzwVar).zza) {
                zzm zzmVar = (zzm) zzwVar;
                if (this.zzb == zzmVar.zzb && this.zzc == zzmVar.zzc) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return (true != this.zzc ? 1237 : 1231) ^ ((((this.zza ^ 1000003) * 1000003) ^ this.zzb) * 1000003);
    }

    public final String toString() {
        return "OfflineAdConfig{impressionPrerequisite=" + this.zza + ", clickPrerequisite=" + this.zzb + ", notificationFlowEnabled=" + this.zzc + "}";
    }
}
