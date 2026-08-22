package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.media.Spatializer$OnSpatializerStateChangedListener;
import android.os.Handler;
import android.os.Looper;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class zzym {
    private final Spatializer zza;
    private final boolean zzb;
    private final Handler zzc;
    private final Spatializer$OnSpatializerStateChangedListener zzd;

    /* JADX WARN: Type inference failed for: r1v3, types: [com.google.android.gms.internal.ads.zzyk] */
    public zzym(Context context, zzyu zzyuVar) {
        AudioManager audioManagerZzc = context == null ? null : zzcj.zzc(context);
        if (audioManagerZzc == null || zzex.zzN(context)) {
            this.zza = null;
            this.zzb = false;
            this.zzc = null;
            this.zzd = null;
            return;
        }
        Spatializer spatializer = audioManagerZzc.getSpatializer();
        this.zza = spatializer;
        this.zzb = spatializer.getImmersiveAudioLevel() != 0;
        zzyl zzylVar = new zzyl(this, zzyuVar);
        this.zzd = zzylVar;
        Looper looperMyLooper = Looper.myLooper();
        zzdd.zzb(looperMyLooper);
        final Handler handler = new Handler(looperMyLooper);
        this.zzc = handler;
        spatializer.addOnSpatializerStateChangedListener(new Executor() { // from class: com.google.android.gms.internal.ads.zzyk
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        }, zzylVar);
    }

    public final void zza() {
        Spatializer$OnSpatializerStateChangedListener spatializer$OnSpatializerStateChangedListener;
        Handler handler;
        Spatializer spatializer = this.zza;
        if (spatializer == null || (spatializer$OnSpatializerStateChangedListener = this.zzd) == null || (handler = this.zzc) == null) {
            return;
        }
        spatializer.removeOnSpatializerStateChangedListener(spatializer$OnSpatializerStateChangedListener);
        handler.removeCallbacksAndMessages(null);
    }

    public final boolean zzb(zze zzeVar, zzz zzzVar) {
        int i;
        String str = zzzVar.zzo;
        if (Objects.equals(str, "audio/eac3-joc")) {
            i = zzzVar.zzG;
            if (i == 16) {
                i = 12;
            }
        } else if (Objects.equals(str, "audio/iamf")) {
            i = zzzVar.zzG;
            if (i == -1) {
                i = 6;
            }
        } else if (Objects.equals(str, "audio/ac4")) {
            i = zzzVar.zzG;
            if (i == 18 || i == 21) {
                i = 24;
            }
        } else {
            i = zzzVar.zzG;
        }
        int iZzi = zzex.zzi(i);
        if (iZzi == 0) {
            return false;
        }
        AudioFormat.Builder channelMask = new AudioFormat.Builder().setEncoding(2).setChannelMask(iZzi);
        int i2 = zzzVar.zzH;
        if (i2 != -1) {
            channelMask.setSampleRate(i2);
        }
        Spatializer spatializer = this.zza;
        spatializer.getClass();
        return zzc$$ExternalSyntheticApiModelOutline1.m((Object) spatializer).canBeSpatialized(zzeVar.zza().zza, channelMask.build());
    }

    public final boolean zzc() {
        Spatializer spatializer = this.zza;
        spatializer.getClass();
        return zzc$$ExternalSyntheticApiModelOutline1.m((Object) spatializer).isAvailable();
    }

    public final boolean zzd() {
        Spatializer spatializer = this.zza;
        spatializer.getClass();
        return zzc$$ExternalSyntheticApiModelOutline1.m((Object) spatializer).isEnabled();
    }

    public final boolean zze() {
        return this.zzb;
    }
}
