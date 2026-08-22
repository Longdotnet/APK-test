package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzadi implements zzaeu {
    public final int zza;
    public final int[] zzb;
    public final long[] zzc;
    public final long[] zzd;
    public final long[] zze;
    private final long zzf;

    public zzadi(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.zzb = iArr;
        this.zzc = jArr;
        this.zzd = jArr2;
        this.zze = jArr3;
        int length = iArr.length;
        this.zza = length;
        if (length <= 0) {
            this.zzf = 0L;
        } else {
            int i = length - 1;
            this.zzf = jArr2[i] + jArr3[i];
        }
    }

    public final String toString() {
        long[] jArr = this.zzd;
        long[] jArr2 = this.zze;
        long[] jArr3 = this.zzc;
        String string = Arrays.toString(this.zzb);
        String string2 = Arrays.toString(jArr3);
        String string3 = Arrays.toString(jArr2);
        String string4 = Arrays.toString(jArr);
        StringBuilder sb = new StringBuilder("ChunkIndex(length=");
        sb.append(this.zza);
        sb.append(", sizes=");
        sb.append(string);
        sb.append(", offsets=");
        sb.append(string2);
        sb.append(", timeUs=");
        sb.append(string3);
        sb.append(", durationsUs=");
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(sb, string4, ")");
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final long zza() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final zzaes zzg(long j) {
        long[] jArr = this.zze;
        int iZzd = zzex.zzd(jArr, j, true, true);
        long j2 = jArr[iZzd];
        long[] jArr2 = this.zzc;
        zzaev zzaevVar = new zzaev(j2, jArr2[iZzd]);
        if (zzaevVar.zzb >= j || iZzd == this.zza - 1) {
            return new zzaes(zzaevVar, zzaevVar);
        }
        int i = iZzd + 1;
        return new zzaes(zzaevVar, new zzaev(jArr[i], jArr2[i]));
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final boolean zzh() {
        return true;
    }
}
