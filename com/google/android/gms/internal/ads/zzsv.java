package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.collection.CircularIntArray;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
final class zzsv extends MediaCodec.Callback {
    private final HandlerThread zzb;
    private Handler zzc;
    private MediaFormat zzh;
    private MediaFormat zzi;
    private MediaCodec.CodecException zzj;
    private MediaCodec.CryptoException zzk;
    private long zzl;
    private boolean zzm;
    private IllegalStateException zzn;
    private zzte zzo;
    private final Object zza = new Object();
    private final CircularIntArray zzd = new CircularIntArray();
    private final CircularIntArray zze = new CircularIntArray();
    private final ArrayDeque zzf = new ArrayDeque();
    private final ArrayDeque zzg = new ArrayDeque();

    public zzsv(HandlerThread handlerThread) {
        this.zzb = handlerThread;
    }

    public static /* synthetic */ void zzd(zzsv zzsvVar) {
        Object obj = zzsvVar.zza;
        synchronized (obj) {
            try {
                if (zzsvVar.zzm) {
                    return;
                }
                long j = zzsvVar.zzl - 1;
                zzsvVar.zzl = j;
                if (j > 0) {
                    return;
                }
                if (j >= 0) {
                    zzsvVar.zzj();
                    return;
                }
                IllegalStateException illegalStateException = new IllegalStateException();
                synchronized (obj) {
                    zzsvVar.zzn = illegalStateException;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void zzi(MediaFormat mediaFormat) {
        this.zze.addLast(-2);
        this.zzg.add(mediaFormat);
    }

    private final void zzj() {
        ArrayDeque arrayDeque = this.zzg;
        if (!arrayDeque.isEmpty()) {
            this.zzi = (MediaFormat) arrayDeque.getLast();
        }
        CircularIntArray circularIntArray = this.zzd;
        circularIntArray.mTail = circularIntArray.mHead;
        CircularIntArray circularIntArray2 = this.zze;
        circularIntArray2.mTail = circularIntArray2.mHead;
        this.zzf.clear();
        arrayDeque.clear();
    }

    private final void zzk() {
        IllegalStateException illegalStateException = this.zzn;
        if (illegalStateException != null) {
            this.zzn = null;
            throw illegalStateException;
        }
        MediaCodec.CodecException codecException = this.zzj;
        if (codecException != null) {
            this.zzj = null;
            throw codecException;
        }
        MediaCodec.CryptoException cryptoException = this.zzk;
        if (cryptoException == null) {
            return;
        }
        this.zzk = null;
        throw cryptoException;
    }

    private final boolean zzl() {
        return this.zzl > 0 || this.zzm;
    }

    @Override // android.media.MediaCodec.Callback
    public final void onCryptoError(MediaCodec mediaCodec, MediaCodec.CryptoException cryptoException) {
        synchronized (this.zza) {
            this.zzk = cryptoException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.zza) {
            this.zzj = codecException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
        synchronized (this.zza) {
            try {
                this.zzd.addLast(i);
                zzte zzteVar = this.zzo;
                if (zzteVar != null) {
                    zztp zztpVar = ((zztm) zzteVar).zza;
                    if (zztpVar.zzo != null) {
                        zztpVar.zzo.zza();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.zza) {
            try {
                MediaFormat mediaFormat = this.zzi;
                if (mediaFormat != null) {
                    zzi(mediaFormat);
                    this.zzi = null;
                }
                this.zze.addLast(i);
                this.zzf.add(bufferInfo);
                zzte zzteVar = this.zzo;
                if (zzteVar != null) {
                    zztp zztpVar = ((zztm) zzteVar).zza;
                    if (zztpVar.zzo != null) {
                        zztpVar.zzo.zza();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.zza) {
            zzi(mediaFormat);
            this.zzi = null;
        }
    }

    public final int zza() {
        synchronized (this.zza) {
            try {
                zzk();
                int i = -1;
                if (zzl()) {
                    return -1;
                }
                CircularIntArray circularIntArray = this.zzd;
                int i2 = circularIntArray.mHead;
                int i3 = circularIntArray.mTail;
                if (!(i2 == i3)) {
                    if (i2 == i3) {
                        throw new ArrayIndexOutOfBoundsException();
                    }
                    i = circularIntArray.mElements[i2];
                    circularIntArray.mHead = (i2 + 1) & circularIntArray.mCapacityBitmask;
                }
                return i;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int zzb(MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.zza) {
            try {
                zzk();
                if (zzl()) {
                    return -1;
                }
                CircularIntArray circularIntArray = this.zze;
                int i = circularIntArray.mHead;
                int i2 = circularIntArray.mTail;
                if (i == i2) {
                    return -1;
                }
                if (i == i2) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                int i3 = circularIntArray.mElements[i];
                circularIntArray.mHead = (i + 1) & circularIntArray.mCapacityBitmask;
                if (i3 >= 0) {
                    zzdd.zzb(this.zzh);
                    MediaCodec.BufferInfo bufferInfo2 = (MediaCodec.BufferInfo) this.zzf.remove();
                    bufferInfo.set(bufferInfo2.offset, bufferInfo2.size, bufferInfo2.presentationTimeUs, bufferInfo2.flags);
                } else if (i3 == -2) {
                    this.zzh = (MediaFormat) this.zzg.remove();
                    i3 = -2;
                }
                return i3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final MediaFormat zzc() {
        MediaFormat mediaFormat;
        synchronized (this.zza) {
            try {
                mediaFormat = this.zzh;
                if (mediaFormat == null) {
                    throw new IllegalStateException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return mediaFormat;
    }

    public final void zze() {
        synchronized (this.zza) {
            this.zzl++;
            Handler handler = this.zzc;
            String str = zzex.zza;
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzsu
                @Override // java.lang.Runnable
                public final void run() {
                    zzsv.zzd(this.zza);
                }
            });
        }
    }

    public final void zzf(MediaCodec mediaCodec) {
        zzdd.zzf(this.zzc == null);
        HandlerThread handlerThread = this.zzb;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        mediaCodec.setCallback(this, handler);
        this.zzc = handler;
    }

    public final void zzg(zzte zzteVar) {
        synchronized (this.zza) {
            this.zzo = zzteVar;
        }
    }

    public final void zzh() {
        synchronized (this.zza) {
            this.zzm = true;
            this.zzb.quit();
            zzj();
        }
    }
}
