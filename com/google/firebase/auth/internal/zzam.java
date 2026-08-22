package com.google.firebase.auth.internal;

import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.tasks.zzc;
import com.google.firebase.FirebaseApp;
import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;
import kotlin.coroutines.jvm.internal.DEXi.JuorMn;

/* JADX INFO: loaded from: classes2.dex */
public final class zzam {
    public static final Logger zzg = new Logger(JuorMn.IUwZvGHlhTbAi, "FirebaseAuth:");
    public volatile long zza;
    public volatile long zzb;
    public final long zzc;
    public final HandlerThread zzd;
    public final Handler zze;
    public final Runnable zzf;
    public final FirebaseApp zzh;

    public zzam(FirebaseApp firebaseApp) {
        zzg.v("Initializing TokenRefresher", new Object[0]);
        com.google.android.gms.common.internal.zzah.checkNotNull(firebaseApp);
        this.zzh = firebaseApp;
        HandlerThread handlerThread = new HandlerThread("TokenRefresher", 10);
        this.zzd = handlerThread;
        handlerThread.start();
        this.zze = new com.google.android.gms.internal.p002firebaseauthapi.zzg(handlerThread.getLooper());
        this.zzf = new zzc(this, firebaseApp.getName());
        this.zzc = 300000L;
    }

    public final void zzb() {
        this.zze.removeCallbacks(this.zzf);
    }

    public final void zzc() {
        zzg.v("Scheduling refresh for " + (this.zza - this.zzc), new Object[0]);
        zzb();
        this.zzb = Math.max((this.zza - System.currentTimeMillis()) - this.zzc, 0L) / 1000;
        this.zze.postDelayed(this.zzf, this.zzb * 1000);
    }

    public final void zzd() {
        long j;
        int i = (int) this.zzb;
        if (i == 30 || i == 60 || i == 120 || i == 240 || i == 480) {
            long j2 = this.zzb;
            j = j2 + j2;
        } else {
            j = i != 960 ? 30L : 960L;
        }
        this.zzb = j;
        this.zza = (this.zzb * 1000) + System.currentTimeMillis();
        zzg.v(BarcodeFormat$EnumUnboxingLocalUtility.m(this.zza, "Scheduling refresh for "), new Object[0]);
        this.zze.postDelayed(this.zzf, this.zzb * 1000);
    }
}
