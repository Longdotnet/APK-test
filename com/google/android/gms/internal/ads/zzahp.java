package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzahp implements zzau {
    public final float zza;
    public final int zzb;

    public zzahp(float f, int i) {
        this.zza = f;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzahp.class == obj.getClass()) {
            zzahp zzahpVar = (zzahp) obj;
            if (this.zza == zzahpVar.zza && this.zzb == zzahpVar.zzb) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Float.floatToIntBits(this.zza) + 527) * 31) + this.zzb;
    }

    public final String toString() {
        return "smta: captureFrameRate=" + this.zza + ", svcTemporalLayerCount=" + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzau
    public final /* synthetic */ void zza(zzar zzarVar) {
    }
}
