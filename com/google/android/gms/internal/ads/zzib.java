package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzib {
    private final zzfwh zza;
    private final Handler zzb;
    private zzia zzc;
    private zze zzd;
    private int zzf;
    private zzch zzh;
    private float zzg = 1.0f;
    private int zze = 0;

    public zzib(final Context context, Looper looper, zzia zziaVar) {
        this.zza = zzfwl.zza(new zzfwh() { // from class: com.google.android.gms.internal.ads.zzhz
            @Override // com.google.android.gms.internal.ads.zzfwh
            public final Object zza() {
                return zzcj.zzc(context);
            }
        });
        this.zzc = zziaVar;
        this.zzb = new Handler(looper);
    }

    public static /* synthetic */ void zzc(zzib zzibVar, int i) {
        if (i == -3 || i == -2) {
            if (i != -2) {
                zzibVar.zzh(4);
                return;
            } else {
                zzibVar.zzg(0);
                zzibVar.zzh(3);
                return;
            }
        }
        if (i == -1) {
            zzibVar.zzg(-1);
            zzibVar.zzf();
            zzibVar.zzh(1);
        } else if (i != 1) {
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m23m(i, "Unknown focus change type: ", "AudioFocusManager");
        } else {
            zzibVar.zzh(2);
            zzibVar.zzg(1);
        }
    }

    private final void zzf() {
        int i = this.zze;
        if (i == 1 || i == 0 || this.zzh == null) {
            return;
        }
        zzcj.zza((AudioManager) this.zza.zza(), this.zzh);
    }

    private final void zzg(int i) {
        zzia zziaVar = this.zzc;
        if (zziaVar != null) {
            zziaVar.zza(i);
        }
    }

    private final void zzh(int i) {
        if (this.zze == i) {
            return;
        }
        this.zze = i;
        float f = i == 4 ? 0.2f : 1.0f;
        if (this.zzg != f) {
            this.zzg = f;
            zzia zziaVar = this.zzc;
            if (zziaVar != null) {
                zziaVar.zzb(f);
            }
        }
    }

    public final float zza() {
        return this.zzg;
    }

    public final int zzb(boolean z, int i) {
        if (i == 1 || this.zzf != 1) {
            zzf();
            zzh(0);
            return 1;
        }
        if (!z) {
            int i2 = this.zze;
            if (i2 != 1) {
                return i2 != 3 ? 1 : 0;
            }
            return -1;
        }
        if (this.zze == 2) {
            return 1;
        }
        if (this.zzh == null) {
            zzce zzceVar = new zzce(1);
            zze zzeVar = this.zzd;
            zzeVar.getClass();
            zzceVar.zza(zzeVar);
            zzceVar.zzb(new AudioManager.OnAudioFocusChangeListener() { // from class: com.google.android.gms.internal.ads.zzhy
                @Override // android.media.AudioManager.OnAudioFocusChangeListener
                public final void onAudioFocusChange(int i3) {
                    zzib.zzc(this.zza, i3);
                }
            }, this.zzb);
            this.zzh = zzceVar.zzc();
        }
        if (zzcj.zzb((AudioManager) this.zza.zza(), this.zzh) == 1) {
            zzh(2);
            return 1;
        }
        zzh(1);
        return -1;
    }

    public final void zzd() {
        this.zzc = null;
        zzf();
        zzh(0);
    }

    public final void zze(zze zzeVar) {
        if (Objects.equals(this.zzd, zzeVar)) {
            return;
        }
        this.zzd = zzeVar;
        this.zzf = zzeVar == null ? 0 : 1;
    }
}
