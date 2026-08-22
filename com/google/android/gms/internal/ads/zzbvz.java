package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzbvz extends zzbwb {
    private final String zza;
    private final int zzb;

    public zzbvz(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbvz)) {
            return false;
        }
        zzbvz zzbvzVar = (zzbvz) obj;
        if (com.google.android.gms.common.internal.zzah.equal(this.zza, zzbvzVar.zza)) {
            if (com.google.android.gms.common.internal.zzah.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzbvzVar.zzb))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbwc
    public final int zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbwc
    public final String zzc() {
        return this.zza;
    }
}
