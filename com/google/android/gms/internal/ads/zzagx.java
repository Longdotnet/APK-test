package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzagx extends zzahf {
    public final byte[] zza;

    public zzagx(String str, byte[] bArr) {
        super(str);
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzagx.class == obj.getClass()) {
            zzagx zzagxVar = (zzagx) obj;
            if (this.zzf.equals(zzagxVar.zzf) && Arrays.equals(this.zza, zzagxVar.zza)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zzf.hashCode() + 527;
        return Arrays.hashCode(this.zza) + (iHashCode * 31);
    }
}
