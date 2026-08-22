package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.os.Build;
import android.os.HandlerThread;
import android.os.Trace;
import android.view.Surface;

/* JADX INFO: loaded from: classes.dex */
public final class zzsn implements zztd {
    private final zzfwh zza;
    private final zzfwh zzb;

    public zzsn(int i) {
        zzsl zzslVar = new zzsl(i);
        zzsm zzsmVar = new zzsm(i);
        this.zza = zzslVar;
        this.zzb = zzsmVar;
    }

    public static /* synthetic */ HandlerThread zza(int i) {
        return new HandlerThread(zzsp.zzt(i, "ExoPlayer:MediaCodecAsyncAdapter:"));
    }

    public static /* synthetic */ HandlerThread zzb(int i) {
        return new HandlerThread(zzsp.zzt(i, "ExoPlayer:MediaCodecQueueingThread:"));
    }

    public final zzsp zzc(zztc zztcVar) throws Exception {
        MediaCodec mediaCodecCreateByCodecName;
        zzti zztiVar = zztcVar.zza;
        String str = zztiVar.zza;
        zzsp zzspVar = null;
        try {
            Trace.beginSection("createCodec:" + str);
            mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            try {
                zzsp zzspVar2 = new zzsp(mediaCodecCreateByCodecName, zza(((zzsl) this.zza).zza), new zzst(mediaCodecCreateByCodecName, zzb(((zzsm) this.zzb).zza)), zztcVar.zzf, null);
                try {
                    Trace.endSection();
                    Surface surface = zztcVar.zzd;
                    int i = 0;
                    if (surface == null && zztiVar.zzh && Build.VERSION.SDK_INT >= 35) {
                        i = 8;
                    }
                    zzsp.zzh(zzspVar2, zztcVar.zzb, surface, null, i);
                    return zzspVar2;
                } catch (Exception e) {
                    e = e;
                    zzspVar = zzspVar2;
                    if (zzspVar != null) {
                        zzspVar.zzm();
                    } else if (mediaCodecCreateByCodecName != null) {
                        mediaCodecCreateByCodecName.release();
                    }
                    throw e;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            mediaCodecCreateByCodecName = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zztd
    public final /* bridge */ /* synthetic */ zztf zzd(zztc zztcVar) {
        throw null;
    }
}
