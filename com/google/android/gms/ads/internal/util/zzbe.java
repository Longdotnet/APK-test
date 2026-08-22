package com.google.android.gms.ads.internal.util;

import androidx.loader.app.gv.DYYbQc;
import com.google.android.gms.common.internal.zzah;
import com.google.firebase.auth.zzz;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbe {
    public final String zza;
    public final double zzb;
    public final double zzc;
    public final double zzd;
    public final int zze;

    public zzbe(String str, double d, double d2, double d3, int i) {
        this.zza = str;
        this.zzc = d;
        this.zzb = d2;
        this.zzd = d3;
        this.zze = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbe)) {
            return false;
        }
        zzbe zzbeVar = (zzbe) obj;
        return zzah.equal(this.zza, zzbeVar.zza) && this.zzb == zzbeVar.zzb && this.zzc == zzbeVar.zzc && this.zze == zzbeVar.zze && Double.compare(this.zzd, zzbeVar.zzd) == 0;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, Double.valueOf(this.zzb), Double.valueOf(this.zzc), Double.valueOf(this.zzd), Integer.valueOf(this.zze)});
    }

    public final String toString() {
        zzz zzzVar = new zzz(this);
        zzzVar.add(this.zza, "name");
        zzzVar.add(Double.valueOf(this.zzc), "minBound");
        zzzVar.add(Double.valueOf(this.zzb), DYYbQc.JWeUukiXIT);
        zzzVar.add(Double.valueOf(this.zzd), "percent");
        zzzVar.add(Integer.valueOf(this.zze), "count");
        return zzzVar.toString();
    }
}
