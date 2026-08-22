package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzhga extends zzhfy implements zzarq {
    private int zzg;

    public zzhga(String str) {
        super("mvhd");
    }

    public final int zzg() {
        if (!this.zzb) {
            zzf();
        }
        return this.zzg;
    }

    public final long zzh(ByteBuffer byteBuffer) {
        this.zzg = zzarp.zzc(byteBuffer.get());
        zzarp.zzd(byteBuffer);
        byteBuffer.get();
        return 4L;
    }
}
