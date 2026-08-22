package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzagz extends zzahf {
    public final String zza;
    public final boolean zzb;
    public final boolean zzc;
    public final String[] zzd;
    private final zzahf[] zze;

    public zzagz(String str, boolean z, boolean z2, String[] strArr, zzahf[] zzahfVarArr) {
        super("CTOC");
        this.zza = str;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = strArr;
        this.zze = zzahfVarArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzagz.class == obj.getClass()) {
            zzagz zzagzVar = (zzagz) obj;
            if (this.zzb == zzagzVar.zzb && this.zzc == zzagzVar.zzc && Objects.equals(this.zza, zzagzVar.zza) && Arrays.equals(this.zzd, zzagzVar.zzd) && Arrays.equals(this.zze, zzagzVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (this.zzb ? 1 : 0) + 527;
        String str = this.zza;
        return str.hashCode() + (((i * 31) + (this.zzc ? 1 : 0)) * 31);
    }
}
