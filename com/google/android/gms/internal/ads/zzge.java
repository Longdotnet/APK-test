package com.google.android.gms.internal.ads;

import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public final class zzge extends zzgc {
    private Uri zza;
    private byte[] zzb;
    private int zzc;
    private int zzd;
    private boolean zze;
    private final zzgd zzf;

    public zzge(byte[] bArr) {
        zzgd zzgdVar = new zzgd(bArr);
        super(false);
        this.zzf = zzgdVar;
        zzdd.zzd(bArr.length > 0);
    }

    @Override // com.google.android.gms.internal.ads.zzl
    public final int zza(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.zzd;
        if (i3 == 0) {
            return -1;
        }
        int iMin = Math.min(i2, i3);
        byte[] bArr2 = this.zzb;
        zzdd.zzb(bArr2);
        System.arraycopy(bArr2, this.zzc, bArr, i, iMin);
        this.zzc += iMin;
        this.zzd -= iMin;
        zzg(iMin);
        return iMin;
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final long zzb(zzgo zzgoVar) throws zzgk {
        zzi(zzgoVar);
        this.zza = zzgoVar.zza;
        byte[] bArr = this.zzf.zza;
        this.zzb = bArr;
        long j = zzgoVar.zze;
        int length = bArr.length;
        if (j > length) {
            throw new zzgk(2008);
        }
        int i = (int) j;
        this.zzc = i;
        int i2 = length - i;
        this.zzd = i2;
        long j2 = zzgoVar.zzf;
        if (j2 != -1) {
            this.zzd = (int) Math.min(i2, j2);
        }
        this.zze = true;
        zzj(zzgoVar);
        return j2 != -1 ? j2 : this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final Uri zzc() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final void zzd() {
        if (this.zze) {
            this.zze = false;
            zzh();
        }
        this.zza = null;
        this.zzb = null;
    }
}
