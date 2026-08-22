package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.Api;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzi implements Api.ApiOptions.Optional {
    public final int zza;
    public final String zzb;

    public /* synthetic */ zzi(int i, String str, byte[] bArr) {
        this.zza = i;
        this.zzb = str;
    }

    public static zzh zza() {
        return new zzh(null);
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzi)) {
            return false;
        }
        zzi zziVar = (zzi) obj;
        return this.zza == zziVar.zza && com.google.android.gms.common.internal.zzah.equal(this.zzb, zziVar.zzb);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zza), this.zzb});
    }
}
