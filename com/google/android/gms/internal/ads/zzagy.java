package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzagy extends zzahf {
    public final String zza;
    public final int zzb;
    public final int zzc;
    public final long zzd;
    public final long zze;
    private final zzahf[] zzg;

    public zzagy(String str, int i, int i2, long j, long j2, zzahf[] zzahfVarArr) {
        super("CHAP");
        this.zza = str;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = j;
        this.zze = j2;
        this.zzg = zzahfVarArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzagy.class == obj.getClass()) {
            zzagy zzagyVar = (zzagy) obj;
            if (this.zzb == zzagyVar.zzb && this.zzc == zzagyVar.zzc && this.zzd == zzagyVar.zzd && this.zze == zzagyVar.zze && Objects.equals(this.zza, zzagyVar.zza) && Arrays.equals(this.zzg, zzagyVar.zzg)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb + 527;
        String str = this.zza;
        long j = this.zze;
        return str.hashCode() + (((((((i * 31) + this.zzc) * 31) + ((int) this.zzd)) * 31) + ((int) j)) * 31);
    }
}
