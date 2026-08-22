package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.Surface;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class zzue implements zztf {
    private final MediaCodec zza;
    private final zztb zzb;

    public /* synthetic */ zzue(MediaCodec mediaCodec, zztb zztbVar, zzud zzudVar) {
        this.zza = mediaCodec;
        this.zzb = zztbVar;
        if (Build.VERSION.SDK_INT < 35 || zztbVar == null) {
            return;
        }
        zztbVar.zza(mediaCodec);
    }

    @Override // com.google.android.gms.internal.ads.zztf
    public final int zza() {
        return this.zza.dequeueInputBuffer(0L);
    }

    @Override // com.google.android.gms.internal.ads.zztf
    public final int zzb(MediaCodec.BufferInfo bufferInfo) {
        int iDequeueOutputBuffer;
        do {
            iDequeueOutputBuffer = this.zza.dequeueOutputBuffer(bufferInfo, 0L);
        } while (iDequeueOutputBuffer == -3);
        return iDequeueOutputBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zztf
    public final MediaFormat zzc() {
        return this.zza.getOutputFormat();
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
        this.zza.flush();
    }

    @Override // com.google.android.gms.internal.ads.zztf
    public final void zzk(int i, int i2, int i3, long j, int i4) {
        this.zza.queueInputBuffer(i, 0, i3, j, i4);
    }

    @Override // com.google.android.gms.internal.ads.zztf
    public final void zzl(int i, int i2, zzhp zzhpVar, long j, int i3) {
        this.zza.queueSecureInputBuffer(i, 0, zzhpVar.zza(), j, i3);
    }

    @Override // com.google.android.gms.internal.ads.zztf
    public final void zzm() {
        zztb zztbVar;
        try {
            int i = Build.VERSION.SDK_INT;
            if (i >= 30 && i < 33) {
                this.zza.stop();
            }
            if (i >= 35 && this.zzb != null) {
            }
        } finally {
            if (Build.VERSION.SDK_INT >= 35 && (zztbVar = this.zzb) != null) {
                zztbVar.zzc(this.zza);
            }
            this.zza.release();
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
        this.zza.setParameters(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zztf
    public final void zzr(int i) {
        this.zza.setVideoScalingMode(i);
    }

    @Override // com.google.android.gms.internal.ads.zztf
    public final /* synthetic */ boolean zzs(zzte zzteVar) {
        return false;
    }
}
