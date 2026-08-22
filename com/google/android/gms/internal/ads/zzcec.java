package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzcec implements zzgj {
    private final zzgj zza;
    private final long zzb;
    private final zzgj zzc;
    private long zzd;
    private Uri zze;

    public zzcec(zzgj zzgjVar, int i, zzgj zzgjVar2) {
        this.zza = zzgjVar;
        this.zzb = i;
        this.zzc = zzgjVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzl
    public final int zza(byte[] bArr, int i, int i2) {
        int i3;
        long j = this.zzd;
        long j2 = this.zzb;
        if (j < j2) {
            int iZza = this.zza.zza(bArr, i, (int) Math.min(i2, j2 - j));
            long j3 = this.zzd + ((long) iZza);
            this.zzd = j3;
            i3 = iZza;
            j = j3;
        } else {
            i3 = 0;
        }
        if (j < j2) {
            return i3;
        }
        int iZza2 = this.zzc.zza(bArr, i + i3, i2 - i3);
        int i4 = i3 + iZza2;
        this.zzd += (long) iZza2;
        return i4;
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final long zzb(zzgo zzgoVar) {
        zzgo zzgoVar2;
        Uri uri = zzgoVar.zza;
        this.zze = uri;
        long j = zzgoVar.zze;
        long j2 = this.zzb;
        zzgo zzgoVar3 = null;
        if (j >= j2) {
            zzgoVar2 = null;
        } else {
            long j3 = zzgoVar.zzf;
            long j4 = j2 - j;
            zzgoVar2 = new zzgo(uri, j, j3 != -1 ? Math.min(j3, j4) : j4, null);
        }
        long j5 = zzgoVar.zzf;
        if (j5 == -1 || j + j5 > j2) {
            zzgoVar3 = new zzgo(uri, Math.max(j2, j), j5 != -1 ? Math.min(j5, (j + j5) - j2) : -1L, null);
        }
        long jZzb = zzgoVar2 != null ? this.zza.zzb(zzgoVar2) : 0L;
        long jZzb2 = zzgoVar3 != null ? this.zzc.zzb(zzgoVar3) : 0L;
        this.zzd = j;
        if (jZzb == -1 || jZzb2 == -1) {
            return -1L;
        }
        return jZzb + jZzb2;
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final Uri zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final void zzd() {
        this.zza.zzd();
        this.zzc.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final Map zze() {
        return zzfyt.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final void zzf(zzhj zzhjVar) {
    }
}
