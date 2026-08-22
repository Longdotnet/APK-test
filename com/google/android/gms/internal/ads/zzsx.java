package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.os.Build;
import android.os.Trace;
import android.view.Surface;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzsx implements zztd {
    private final Context zza;

    @Deprecated
    public zzsx() {
        this.zza = null;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x008d  */
    @Override // com.google.android.gms.internal.ads.zztd
    public final zztf zzd(zztc zztcVar) throws Throwable {
        Context context;
        int i = Build.VERSION.SDK_INT;
        if (i >= 31 || ((context = this.zza) != null && i >= 28 && context.getPackageManager().hasSystemFeature("com.amazon.hardware.tv_screen"))) {
            int iZzb = zzay.zzb(zztcVar.zzc.zzo);
            zzea.zze("DMCodecAdapterFactory", "Creating an asynchronous MediaCodec adapter for track type ".concat(zzex.zzD(iZzb)));
            return new zzsn(iZzb).zzc(zztcVar);
        }
        MediaCodec mediaCodec = null;
        try {
            zzti zztiVar = zztcVar.zza;
            String str = zztiVar.zza;
            Trace.beginSection("createCodec:".concat(str));
            MediaCodec mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            Trace.endSection();
            try {
                Trace.beginSection("configureCodec");
                Surface surface = zztcVar.zzd;
                int i2 = 0;
                if (surface == null && zztiVar.zzh && i >= 35) {
                    i2 = 8;
                }
                mediaCodecCreateByCodecName.configure(zztcVar.zzb, surface, (MediaCrypto) null, i2);
                Trace.endSection();
                Trace.beginSection("startCodec");
                mediaCodecCreateByCodecName.start();
                Trace.endSection();
                return new zzue(mediaCodecCreateByCodecName, zztcVar.zzf, null);
            } catch (IOException e) {
                e = e;
                mediaCodec = mediaCodecCreateByCodecName;
                if (mediaCodec != null) {
                    mediaCodec.release();
                }
                throw e;
            } catch (RuntimeException e2) {
                e = e2;
                mediaCodec = mediaCodecCreateByCodecName;
                if (mediaCodec != null) {
                    mediaCodec.release();
                }
                throw e;
            }
        } catch (IOException e3) {
            e = e3;
        } catch (RuntimeException e4) {
            e = e4;
        }
    }

    public zzsx(Context context, zzfwh zzfwhVar, zzfwh zzfwhVar2) {
        this.zza = context;
    }
}
