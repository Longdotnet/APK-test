package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Trace;
import android.view.Surface;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
final class zzsp implements zztf {
    private final MediaCodec zza;
    private final zzsv zzb;
    private final zztg zzc;
    private final zztb zzd;
    private boolean zze;
    private int zzf = 0;

    public /* synthetic */ zzsp(MediaCodec mediaCodec, HandlerThread handlerThread, zztg zztgVar, zztb zztbVar, zzso zzsoVar) {
        this.zza = mediaCodec;
        this.zzb = new zzsv(handlerThread);
        this.zzc = zztgVar;
        this.zzd = zztbVar;
    }

    public static /* bridge */ /* synthetic */ void zzh(zzsp zzspVar, MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i) {
        zztb zztbVar;
        zzsv zzsvVar = zzspVar.zzb;
        MediaCodec mediaCodec = zzspVar.zza;
        zzsvVar.zzf(mediaCodec);
        Trace.beginSection("configureCodec");
        mediaCodec.configure(mediaFormat, surface, (MediaCrypto) null, i);
        Trace.endSection();
        zzspVar.zzc.zzh();
        Trace.beginSection("startCodec");
        mediaCodec.start();
        Trace.endSection();
        if (Build.VERSION.SDK_INT >= 35 && (zztbVar = zzspVar.zzd) != null) {
            zztbVar.zza(mediaCodec);
        }
        zzspVar.zzf = 1;
    }

    public static String zzt(int i, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (i == 1) {
            sb.append("Audio");
        } else if (i == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i);
            sb.append(")");
        }
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zztf
    public final int zza() {
        this.zzc.zzc();
        return this.zzb.zza();
    }

    @Override // com.google.android.gms.internal.ads.zztf
    public final int zzb(MediaCodec.BufferInfo bufferInfo) {
        this.zzc.zzc();
        return this.zzb.zzb(bufferInfo);
    }

    @Override // com.google.android.gms.internal.ads.zztf
    public final MediaFormat zzc() {
        return this.zzb.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zztf
    public final ByteBuffer zzf(int i) {
        return this.zza.getInputBuffer(i);
    }

    @Override // com.google.android.gms.internal.ads.zztf
    public final ByteBuffer zzg(int i) {
        return this.zza.getOutputBuffer(i);
    }

    @Override // com.google.android.gms.internal.ads.zztf
    public final void zzi() {
        this.zza.detachOutputSurface();
    }

    @Override // com.google.android.gms.internal.ads.zztf
    public final void zzj() {
        this.zzc.zzb();
        MediaCodec mediaCodec = this.zza;
        mediaCodec.flush();
        this.zzb.zze();
        mediaCodec.start();
    }

    @Override // com.google.android.gms.internal.ads.zztf
    public final void zzk(int i, int i2, int i3, long j, int i4) {
        this.zzc.zzd(i, 0, i3, j, i4);
    }

    @Override // com.google.android.gms.internal.ads.zztf
    public final void zzl(int i, int i2, zzhp zzhpVar, long j, int i3) {
        this.zzc.zze(i, 0, zzhpVar, j, i3);
    }

    @Override // com.google.android.gms.internal.ads.zztf
    public final void zzm() {
        zztb zztbVar;
        zztb zztbVar2;
        try {
            try {
                if (this.zzf == 1) {
                    this.zzc.zzg();
                    this.zzb.zzh();
                }
                this.zzf = 2;
            } finally {
                if (!this.zze) {
                    int i = Build.VERSION.SDK_INT;
                    if (i >= 30 && i < 33) {
                        this.zza.stop();
                    }
                    if (i >= 35 && (zztbVar2 = this.zzd) != null) {
                        zztbVar2.zzc(this.zza);
                    }
                    this.zza.release();
                    this.zze = true;
                }
            }
        } catch (Throwable th) {
            if (Build.VERSION.SDK_INT >= 35 && (zztbVar = this.zzd) != null) {
                zztbVar.zzc(this.zza);
            }
            this.zza.release();
            this.zze = true;
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zztf
    public final void zzn(int i, long j) {
        this.zza.releaseOutputBuffer(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zztf
    public final void zzo(int i, boolean z) {
        this.zza.releaseOutputBuffer(i, false);
    }

    @Override // com.google.android.gms.internal.ads.zztf
    public final void zzp(Surface surface) {
        this.zza.setOutputSurface(surface);
    }

    @Override // com.google.android.gms.internal.ads.zztf
    public final void zzq(Bundle bundle) {
        this.zzc.zzf(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zztf
    public final void zzr(int i) {
        this.zza.setVideoScalingMode(i);
    }

    @Override // com.google.android.gms.internal.ads.zztf
    public final boolean zzs(zzte zzteVar) {
        this.zzb.zzg(zzteVar);
        return true;
    }
}
