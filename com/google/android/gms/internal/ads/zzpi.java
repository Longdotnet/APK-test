package com.google.android.gms.internal.ads;

import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.Build;
import com.google.android.datatransport.runtime.synchronization.JDyk.FETmZwrVHuasmL;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
final class zzpi {
    public static final zzpi zza;
    public final int zzb;
    public final int zzc;
    private final zzfyv zzd;

    static {
        zzpi zzpiVar;
        if (Build.VERSION.SDK_INT >= 33) {
            zzfyu zzfyuVar = new zzfyu();
            for (int i = 1; i <= 10; i++) {
                zzfyuVar.zzf(Integer.valueOf(zzex.zzi(i)));
            }
            zzpiVar = new zzpi(2, zzfyuVar.zzi());
        } else {
            zzpiVar = new zzpi(2, 10);
        }
        zza = zzpiVar;
    }

    public zzpi(int i, int i2) {
        this.zzb = i;
        this.zzc = i2;
        this.zzd = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzpi)) {
            return false;
        }
        zzpi zzpiVar = (zzpi) obj;
        return this.zzb == zzpiVar.zzb && this.zzc == zzpiVar.zzc && Objects.equals(this.zzd, zzpiVar.zzd);
    }

    public final int hashCode() {
        zzfyv zzfyvVar = this.zzd;
        return (((this.zzb * 31) + this.zzc) * 31) + (zzfyvVar == null ? 0 : zzfyvVar.hashCode());
    }

    public final int zza(int i, zze zzeVar) {
        if (this.zzd != null) {
            return this.zzc;
        }
        if (Build.VERSION.SDK_INT < 29) {
            Integer num = (Integer) zzpj.zzb.getOrDefault(Integer.valueOf(this.zzb), 0);
            num.getClass();
            return num.intValue();
        }
        int i2 = this.zzb;
        for (int i3 = 10; i3 > 0; i3--) {
            int iZzi = zzex.zzi(i3);
            if (iZzi != 0 && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i2).setSampleRate(i).setChannelMask(iZzi).build(), zzeVar.zza().zza)) {
                return i3;
            }
        }
        return 0;
    }

    public final boolean zzb(int i) {
        zzfyv zzfyvVar = this.zzd;
        if (zzfyvVar == null) {
            return i <= this.zzc;
        }
        int iZzi = zzex.zzi(i);
        if (iZzi == 0) {
            return false;
        }
        return zzfyvVar.contains(Integer.valueOf(iZzi));
    }

    public zzpi(int i, Set set) {
        this.zzb = i;
        zzfyv zzfyvVarZzl = zzfyv.zzl(set);
        this.zzd = zzfyvVarZzl;
        zzgaw it = zzfyvVarZzl.iterator();
        int iMax = 0;
        while (it.hasNext()) {
            iMax = Math.max(iMax, Integer.bitCount(((Integer) it.next()).intValue()));
        }
        this.zzc = iMax;
    }

    public final String toString() {
        return FETmZwrVHuasmL.NtQ + this.zzb + ", maxChannelCount=" + this.zzc + ", channelMasks=" + String.valueOf(this.zzd) + "]";
    }
}
