package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzafc {
    private final byte[] zza = new byte[10];
    private boolean zzb;
    private int zzc;
    private long zzd;
    private int zze;
    private int zzf;
    private int zzg;

    public final void zza(zzafb zzafbVar, zzafa zzafaVar) {
        if (this.zzc > 0) {
            zzafbVar.zzt(this.zzd, this.zze, this.zzf, this.zzg, zzafaVar);
            this.zzc = 0;
        }
    }

    public final void zzb() {
        this.zzb = false;
        this.zzc = 0;
    }

    public final void zzc(zzafb zzafbVar, long j, int i, int i2, int i3, zzafa zzafaVar) {
        zzdd.zzg(this.zzg <= i2 + i3, "TrueHD chunk samples must be contiguous in the sample queue.");
        if (this.zzb) {
            int i4 = this.zzc;
            int i5 = i4 + 1;
            this.zzc = i5;
            if (i4 == 0) {
                this.zzd = j;
                this.zze = i;
                this.zzf = 0;
            }
            this.zzf += i2;
            this.zzg = i3;
            if (i5 >= 16) {
                zza(zzafbVar, zzafaVar);
            }
        }
    }

    public final void zzd(zzadw zzadwVar) {
        if (this.zzb) {
            return;
        }
        byte[] bArr = this.zza;
        zzadwVar.zzh(bArr, 0, 10);
        zzadwVar.zzj();
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111 && (bArr[7] & 254) == 186) {
            this.zzb = true;
        }
    }
}
