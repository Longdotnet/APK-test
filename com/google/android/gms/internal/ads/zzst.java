package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
final class zzst implements zztg {
    private static final ArrayDeque zza = new ArrayDeque();
    private static final Object zzb = new Object();
    private final MediaCodec zzc;
    private final HandlerThread zzd;
    private Handler zze;
    private final AtomicReference zzf;
    private final zzdm zzg;
    private boolean zzh;

    public zzst(MediaCodec mediaCodec, HandlerThread handlerThread) {
        zzdm zzdmVar = new zzdm(zzdj.zza);
        this.zzc = mediaCodec;
        this.zzd = handlerThread;
        this.zzg = zzdmVar;
        this.zzf = new AtomicReference();
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0075  */
    /* JADX WARN: Code duplicated, block: B:43:0x0080 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:47:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static /* bridge */ /* synthetic */ void zza(zzst zzstVar, Message message) {
        zzss zzssVar;
        ArrayDeque arrayDeque;
        int i = message.what;
        zzss zzssVar2 = null;
        if (i != 1) {
            if (i == 2) {
                zzssVar = (zzss) message.obj;
                int i2 = zzssVar.zza;
                MediaCodec.CryptoInfo cryptoInfo = zzssVar.zzd;
                long j = zzssVar.zze;
                int i3 = zzssVar.zzf;
                try {
                    synchronized (zzb) {
                        zzstVar.zzc.queueSecureInputBuffer(i2, 0, cryptoInfo, j, i3);
                    }
                } catch (RuntimeException e) {
                    zzsq.zza(zzstVar.zzf, null, e);
                }
            } else if (i == 3) {
                zzstVar.zzg.zzf();
            } else if (i != 4) {
                zzsq.zza(zzstVar.zzf, null, new IllegalStateException(String.valueOf(message.what)));
            } else {
                try {
                    zzstVar.zzc.setParameters((Bundle) message.obj);
                } catch (RuntimeException e2) {
                    zzsq.zza(zzstVar.zzf, null, e2);
                }
            }
            if (zzssVar2 != null) {
                arrayDeque = zza;
                synchronized (arrayDeque) {
                    arrayDeque.add(zzssVar2);
                }
            }
        }
        zzssVar = (zzss) message.obj;
        try {
            zzstVar.zzc.queueInputBuffer(zzssVar.zza, 0, zzssVar.zzc, zzssVar.zze, zzssVar.zzf);
        } catch (RuntimeException e3) {
            zzsq.zza(zzstVar.zzf, null, e3);
        }
        zzssVar2 = zzssVar;
        if (zzssVar2 != null) {
            arrayDeque = zza;
            synchronized (arrayDeque) {
                arrayDeque.add(zzssVar2);
            }
        }
    }

    private static zzss zzi() {
        ArrayDeque arrayDeque = zza;
        synchronized (arrayDeque) {
            try {
                if (arrayDeque.isEmpty()) {
                    return new zzss();
                }
                return (zzss) arrayDeque.removeFirst();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static byte[] zzj(byte[] bArr, byte[] bArr2) {
        int length;
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < (length = bArr.length)) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    private static int[] zzk(int[] iArr, int[] iArr2) {
        int length;
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < (length = iArr.length)) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        System.arraycopy(iArr, 0, iArr2, 0, length);
        return iArr2;
    }

    @Override // com.google.android.gms.internal.ads.zztg
    public final void zzb() {
        if (this.zzh) {
            try {
                Handler handler = this.zze;
                if (handler == null) {
                    throw null;
                }
                handler.removeCallbacksAndMessages(null);
                zzdm zzdmVar = this.zzg;
                zzdmVar.zzd();
                Handler handler2 = this.zze;
                if (handler2 == null) {
                    throw null;
                }
                handler2.obtainMessage(3).sendToTarget();
                zzdmVar.zza();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zztg
    public final void zzc() {
        RuntimeException runtimeException = (RuntimeException) this.zzf.getAndSet(null);
        if (runtimeException != null) {
            throw runtimeException;
        }
    }

    @Override // com.google.android.gms.internal.ads.zztg
    public final void zzd(int i, int i2, int i3, long j, int i4) {
        zzc();
        zzss zzssVarZzi = zzi();
        zzssVarZzi.zza(i, 0, i3, j, i4);
        Handler handler = this.zze;
        String str = zzex.zza;
        handler.obtainMessage(1, zzssVarZzi).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zztg
    public final void zze(int i, int i2, zzhp zzhpVar, long j, int i3) {
        zzc();
        zzss zzssVarZzi = zzi();
        zzssVarZzi.zza(i, 0, 0, j, i3);
        MediaCodec.CryptoInfo cryptoInfo = zzssVarZzi.zzd;
        cryptoInfo.numSubSamples = zzhpVar.zzf;
        cryptoInfo.numBytesOfClearData = zzk(zzhpVar.zzd, cryptoInfo.numBytesOfClearData);
        cryptoInfo.numBytesOfEncryptedData = zzk(zzhpVar.zze, cryptoInfo.numBytesOfEncryptedData);
        byte[] bArrZzj = zzj(zzhpVar.zzb, cryptoInfo.key);
        bArrZzj.getClass();
        cryptoInfo.key = bArrZzj;
        byte[] bArrZzj2 = zzj(zzhpVar.zza, cryptoInfo.iv);
        bArrZzj2.getClass();
        cryptoInfo.iv = bArrZzj2;
        cryptoInfo.mode = zzhpVar.zzc;
        if (Build.VERSION.SDK_INT >= 24) {
            zzhn$$ExternalSyntheticApiModelOutline0.m78m();
            cryptoInfo.setPattern(zzhn$$ExternalSyntheticApiModelOutline0.m(zzhpVar.zzg, zzhpVar.zzh));
        }
        Handler handler = this.zze;
        String str = zzex.zza;
        handler.obtainMessage(2, zzssVarZzi).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zztg
    public final void zzf(Bundle bundle) {
        zzc();
        Handler handler = this.zze;
        String str = zzex.zza;
        handler.obtainMessage(4, bundle).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zztg
    public final void zzg() {
        if (this.zzh) {
            zzb();
            this.zzd.quit();
        }
        this.zzh = false;
    }

    @Override // com.google.android.gms.internal.ads.zztg
    public final void zzh() {
        if (this.zzh) {
            return;
        }
        HandlerThread handlerThread = this.zzd;
        handlerThread.start();
        this.zze = new zzsr(this, handlerThread.getLooper());
        this.zzh = true;
    }
}
