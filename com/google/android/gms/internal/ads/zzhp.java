package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class zzhp {
    public byte[] zza;
    public byte[] zzb;
    public int zzc;
    public int[] zzd;
    public int[] zze;
    public int zzf;
    public int zzg;
    public int zzh;
    private final MediaCodec.CryptoInfo zzi;
    private final zzhn zzj;

    public zzhp() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.zzi = cryptoInfo;
        this.zzj = Build.VERSION.SDK_INT >= 24 ? new zzhn(cryptoInfo, null) : null;
    }

    public final MediaCodec.CryptoInfo zza() {
        return this.zzi;
    }

    public final void zzb(int i) {
        if (i == 0) {
            return;
        }
        if (this.zzd == null) {
            int[] iArr = new int[1];
            this.zzd = iArr;
            this.zzi.numBytesOfClearData = iArr;
        }
        int[] iArr2 = this.zzd;
        iArr2[0] = iArr2[0] + i;
    }

    public final void zzc(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        this.zzf = i;
        this.zzd = iArr;
        this.zze = iArr2;
        this.zzb = bArr;
        this.zza = bArr2;
        this.zzc = i2;
        this.zzg = i3;
        this.zzh = i4;
        MediaCodec.CryptoInfo cryptoInfo = this.zzi;
        cryptoInfo.numSubSamples = i;
        cryptoInfo.numBytesOfClearData = iArr;
        cryptoInfo.numBytesOfEncryptedData = iArr2;
        cryptoInfo.key = bArr;
        cryptoInfo.iv = bArr2;
        cryptoInfo.mode = i2;
        if (Build.VERSION.SDK_INT >= 24) {
            zzhn zzhnVar = this.zzj;
            zzhnVar.getClass();
            zzhn.zza(zzhnVar, i3, i4);
        }
    }
}
