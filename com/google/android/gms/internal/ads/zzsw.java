package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
final class zzsw extends zzhs {
    private long zzg;
    private int zzh;
    private int zzi;

    public zzsw() {
        super(2, 0);
        this.zzi = 32;
    }

    @Override // com.google.android.gms.internal.ads.zzhs, com.google.android.gms.internal.ads.zzhm
    public final void zzb() {
        super.zzb();
        this.zzh = 0;
    }

    public final int zzm() {
        return this.zzh;
    }

    public final long zzn() {
        return this.zzg;
    }

    public final void zzo(int i) {
        this.zzi = i;
    }

    public final boolean zzp(zzhs zzhsVar) {
        ByteBuffer byteBuffer;
        zzdd.zzd(!zzhsVar.zzd(1073741824));
        zzdd.zzd(!zzhsVar.zzd(268435456));
        zzdd.zzd(!zzhsVar.zzd(4));
        if (zzq()) {
            if (this.zzh >= this.zzi) {
                return false;
            }
            ByteBuffer byteBuffer2 = zzhsVar.zzc;
            if (byteBuffer2 != null && (byteBuffer = this.zzc) != null) {
                if (byteBuffer2.remaining() + byteBuffer.position() > 3072000) {
                    return false;
                }
            }
        }
        int i = this.zzh;
        this.zzh = i + 1;
        if (i == 0) {
            this.zze = zzhsVar.zze;
            if (zzhsVar.zzd(1)) {
                zzc(1);
            }
        }
        ByteBuffer byteBuffer3 = zzhsVar.zzc;
        if (byteBuffer3 != null) {
            zzj(byteBuffer3.remaining());
            this.zzc.put(byteBuffer3);
        }
        this.zzg = zzhsVar.zze;
        return true;
    }

    public final boolean zzq() {
        return this.zzh > 0;
    }
}
