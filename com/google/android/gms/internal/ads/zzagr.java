package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzagr implements zzau {
    public final String zza;
    public final String zzb;
    public final long zzc;
    public final long zzd;
    public final byte[] zze;
    private int zzf;

    static {
        zzx zzxVar = new zzx();
        zzxVar.zzah("application/id3");
        zzxVar.zzan();
        zzx zzxVar2 = new zzx();
        zzxVar2.zzah("application/x-scte35");
        zzxVar2.zzan();
    }

    public zzagr(String str, String str2, long j, long j2, byte[] bArr) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = j;
        this.zzd = j2;
        this.zze = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzagr.class == obj.getClass()) {
            zzagr zzagrVar = (zzagr) obj;
            if (this.zzc == zzagrVar.zzc && this.zzd == zzagrVar.zzd && Objects.equals(this.zza, zzagrVar.zza) && Objects.equals(this.zzb, zzagrVar.zzb) && Arrays.equals(this.zze, zzagrVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzf;
        if (i != 0) {
            return i;
        }
        int iHashCode = this.zza.hashCode() + 527;
        int iHashCode2 = this.zzb.hashCode() + (iHashCode * 31);
        long j = this.zzc;
        long j2 = this.zzd;
        int iHashCode3 = Arrays.hashCode(this.zze) + (((((iHashCode2 * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) j2)) * 31);
        this.zzf = iHashCode3;
        return iHashCode3;
    }

    public final String toString() {
        return "EMSG: scheme=" + this.zza + ", id=" + this.zzd + ", durationMs=" + this.zzc + ", value=" + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzau
    public final /* synthetic */ void zza(zzar zzarVar) {
    }
}
