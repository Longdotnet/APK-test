package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.os.Build;
import androidx.lifecycle.hSi.sgtsHsWT;

/* JADX INFO: loaded from: classes2.dex */
public final class zzqu {
    private final Context zza;
    private Boolean zzb;

    public zzqu() {
        this(null);
    }

    public zzqu(Context context) {
        this.zza = context == null ? null : context.getApplicationContext();
    }

    public final zzps zza(zzz zzzVar, zze zzeVar) {
        int i;
        boolean zBooleanValue;
        boolean z;
        zzzVar.getClass();
        zzeVar.getClass();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29 && (i = zzzVar.zzH) != -1) {
            Context context = this.zza;
            Boolean bool = this.zzb;
            boolean z2 = false;
            if (bool != null) {
                zBooleanValue = bool.booleanValue();
            } else {
                if (context != null) {
                    String parameters = zzcj.zzc(context).getParameters("offloadVariableRateSupported");
                    if (parameters != null && parameters.equals(sgtsHsWT.UqlGpWAYyAa)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.zzb = Boolean.valueOf(z);
                } else {
                    this.zzb = Boolean.FALSE;
                }
                zBooleanValue = this.zzb.booleanValue();
            }
            String str = zzzVar.zzo;
            str.getClass();
            int iZza = zzay.zza(str, zzzVar.zzk);
            if (iZza != 0 && i2 >= zzex.zzh(iZza)) {
                int iZzi = zzex.zzi(zzzVar.zzG);
                if (iZzi != 0) {
                    try {
                        AudioFormat audioFormatZzx = zzex.zzx(i, iZzi, iZza);
                        if (i2 >= 31) {
                            int playbackOffloadSupport = AudioManager.getPlaybackOffloadSupport(audioFormatZzx, zzeVar.zza().zza);
                            if (playbackOffloadSupport == 0) {
                                return zzps.zza;
                            }
                            zzpq zzpqVar = new zzpq();
                            if (i2 > 32 && playbackOffloadSupport == 2) {
                                z2 = true;
                            }
                            zzpqVar.zza(true);
                            zzpqVar.zzb(z2);
                            zzpqVar.zzc(zBooleanValue);
                            return zzpqVar.zzd();
                        }
                        if (!AudioManager.isOffloadedPlaybackSupported(audioFormatZzx, zzeVar.zza().zza)) {
                            return zzps.zza;
                        }
                        zzpq zzpqVar2 = new zzpq();
                        zzpqVar2.zza(true);
                        zzpqVar2.zzc(zBooleanValue);
                        return zzpqVar2.zzd();
                    } catch (IllegalArgumentException unused) {
                        return zzps.zza;
                    }
                }
                return zzps.zza;
            }
            return zzps.zza;
        }
        return zzps.zza;
    }
}
