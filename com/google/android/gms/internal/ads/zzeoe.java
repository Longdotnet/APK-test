package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzeoe implements zzeuc {
    private final zzgdy zza;
    private final Context zzb;

    public zzeoe(zzgdy zzgdyVar, Context context) {
        this.zza = zzgdyVar;
        this.zzb = context;
    }

    public static zzeof zzc(zzeoe zzeoeVar) {
        int iZzj;
        int streamMaxVolume;
        AudioManager audioManager = (AudioManager) zzeoeVar.zzb.getSystemService("audio");
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        float fZza = zzvVar.zzj.zza();
        boolean zZze = zzvVar.zzj.zze();
        if (audioManager == null) {
            return new zzeof(-1, false, false, -1, -1, -1, -1, -1, fZza, zZze, true);
        }
        int mode = audioManager.getMode();
        boolean zIsMusicActive = audioManager.isMusicActive();
        boolean zIsSpeakerphoneOn = audioManager.isSpeakerphoneOn();
        int streamVolume = audioManager.getStreamVolume(3);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzlu)).booleanValue()) {
            iZzj = zzvVar.zzg.zzj(audioManager);
            streamMaxVolume = audioManager.getStreamMaxVolume(3);
        } else {
            iZzj = -1;
            streamMaxVolume = -1;
        }
        return new zzeof(mode, zIsMusicActive, zIsSpeakerphoneOn, streamVolume, iZzj, streamMaxVolume, audioManager.getRingerMode(), audioManager.getStreamVolume(2), fZza, zZze, false);
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 13;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeod
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzeoe.zzc(this.zza);
            }
        });
    }
}
