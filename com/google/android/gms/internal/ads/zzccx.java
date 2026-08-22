package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class zzccx {
    private long zza;

    public final long zza(ByteBuffer byteBuffer) {
        zzart zzartVar;
        zzars zzarsVar;
        long j = this.zza;
        if (j > 0) {
            return j;
        }
        try {
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.flip();
            Iterator it = new zzaro(new zzccw(byteBufferDuplicate), zzcda.zzb).zzd().iterator();
            while (true) {
                zzartVar = null;
                if (!it.hasNext()) {
                    zzarsVar = null;
                    break;
                }
                zzarq zzarqVar = (zzarq) it.next();
                if (zzarqVar instanceof zzars) {
                    zzarsVar = (zzars) zzarqVar;
                    break;
                }
            }
            for (zzarq zzarqVar2 : zzarsVar.zzd()) {
                if (zzarqVar2 instanceof zzart) {
                    zzartVar = (zzart) zzarqVar2;
                    break;
                }
            }
            long jZzc = (zzartVar.zzc() * 1000) / zzartVar.zzd();
            this.zza = jZzc;
            return jZzc;
        } catch (IOException | RuntimeException unused) {
            return 0L;
        }
    }
}
