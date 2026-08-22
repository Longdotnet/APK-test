package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public final class zzart extends zzhga {
    private Date zzg;
    private Date zzh;
    private long zzi;
    private long zzj;
    private double zzk;
    private float zzl;
    private zzhgk zzm;
    private long zzn;

    public zzart() {
        super("mvhd");
        this.zzk = 1.0d;
        this.zzl = 1.0f;
        this.zzm = zzhgk.zza;
    }

    public final String toString() {
        return "MovieHeaderBox[creationTime=" + this.zzg + ";modificationTime=" + this.zzh + ";timescale=" + this.zzi + ";duration=" + this.zzj + ";rate=" + this.zzk + ";volume=" + this.zzl + ";matrix=" + this.zzm + ";nextTrackId=" + this.zzn + "]";
    }

    public final long zzc() {
        return this.zzj;
    }

    public final long zzd() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzhfy
    public final void zze(ByteBuffer byteBuffer) {
        zzh(byteBuffer);
        if (zzg() == 1) {
            this.zzg = zzhgf.zza(zzarp.zzf(byteBuffer));
            this.zzh = zzhgf.zza(zzarp.zzf(byteBuffer));
            this.zzi = zzarp.zze(byteBuffer);
            this.zzj = zzarp.zzf(byteBuffer);
        } else {
            this.zzg = zzhgf.zza(zzarp.zze(byteBuffer));
            this.zzh = zzhgf.zza(zzarp.zze(byteBuffer));
            this.zzi = zzarp.zze(byteBuffer);
            this.zzj = zzarp.zze(byteBuffer);
        }
        this.zzk = zzarp.zzb(byteBuffer);
        byte[] bArr = new byte[2];
        byteBuffer.get(bArr);
        this.zzl = ((short) ((bArr[1] & 255) | ((short) (65280 & (bArr[0] << 8))))) / 256.0f;
        zzarp.zzd(byteBuffer);
        zzarp.zze(byteBuffer);
        zzarp.zze(byteBuffer);
        this.zzm = new zzhgk(zzarp.zzb(byteBuffer), zzarp.zzb(byteBuffer), zzarp.zzb(byteBuffer), zzarp.zzb(byteBuffer), zzarp.zza(byteBuffer), zzarp.zza(byteBuffer), zzarp.zza(byteBuffer), zzarp.zzb(byteBuffer), zzarp.zzb(byteBuffer));
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        this.zzn = zzarp.zze(byteBuffer);
    }
}
