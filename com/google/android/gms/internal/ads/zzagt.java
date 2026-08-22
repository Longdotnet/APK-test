package com.google.android.gms.internal.ads;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzagt implements zzau {
    public final int zza;
    public final String zzb;
    public final String zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final byte[] zzh;

    public zzagt(int i, String str, String str2, int i2, int i3, int i4, int i5, byte[] bArr) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = i2;
        this.zze = i3;
        this.zzf = i4;
        this.zzg = i5;
        this.zzh = bArr;
    }

    public static zzagt zzb(zzen zzenVar) {
        int iZzg = zzenVar.zzg();
        String strZze = zzay.zze(zzenVar.zzB(zzenVar.zzg(), StandardCharsets.US_ASCII));
        String strZzB = zzenVar.zzB(zzenVar.zzg(), StandardCharsets.UTF_8);
        int iZzg2 = zzenVar.zzg();
        int iZzg3 = zzenVar.zzg();
        int iZzg4 = zzenVar.zzg();
        int iZzg5 = zzenVar.zzg();
        int iZzg6 = zzenVar.zzg();
        byte[] bArr = new byte[iZzg6];
        zzenVar.zzH(bArr, 0, iZzg6);
        return new zzagt(iZzg, strZze, strZzB, iZzg2, iZzg3, iZzg4, iZzg5, bArr);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzagt.class == obj.getClass()) {
            zzagt zzagtVar = (zzagt) obj;
            if (this.zza == zzagtVar.zza && this.zzb.equals(zzagtVar.zzb) && this.zzc.equals(zzagtVar.zzc) && this.zzd == zzagtVar.zzd && this.zze == zzagtVar.zze && this.zzf == zzagtVar.zzf && this.zzg == zzagtVar.zzg && Arrays.equals(this.zzh, zzagtVar.zzh)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zza + 527;
        int iHashCode = this.zzb.hashCode() + (i * 31);
        int iHashCode2 = this.zzc.hashCode() + (iHashCode * 31);
        byte[] bArr = this.zzh;
        return Arrays.hashCode(bArr) + (((((((((iHashCode2 * 31) + this.zzd) * 31) + this.zze) * 31) + this.zzf) * 31) + this.zzg) * 31);
    }

    public final String toString() {
        return "Picture: mimeType=" + this.zzb + ", description=" + this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzau
    public final void zza(zzar zzarVar) {
        zzarVar.zza(this.zzh, this.zza);
    }
}
