package com.google.firebase.auth.internal;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.internal.p002firebaseauthapi.zzzy;
import com.google.firebase.FirebaseApp;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbi {
    public volatile int zza;
    public final zzam zzb;
    public volatile boolean zzc;

    public zzbi(FirebaseApp firebaseApp) {
        Context applicationContext = firebaseApp.getApplicationContext();
        zzam zzamVar = new zzam(firebaseApp);
        this.zzc = false;
        this.zza = 0;
        this.zzb = zzamVar;
        BackgroundDetector.initialize((Application) applicationContext.getApplicationContext());
        BackgroundDetector.getInstance().addListener(new zzbh(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzg() {
        return this.zza > 0 && !this.zzc;
    }

    public final void zzc() {
        this.zzb.zzb();
    }

    public final void zzd(int i) {
        if (i > 0 && this.zza == 0) {
            this.zza = i;
            if (zzg()) {
                this.zzb.zzc();
            }
        } else if (i == 0 && this.zza != 0) {
            this.zzb.zzb();
        }
        this.zza = i;
    }

    public final void zze(zzzy zzzyVar) {
        if (zzzyVar == null) {
            return;
        }
        long jZzb = zzzyVar.zzb();
        if (jZzb <= 0) {
            jZzb = 3600;
        }
        long jZzc = zzzyVar.zzc();
        zzam zzamVar = this.zzb;
        zzamVar.zza = (jZzb * 1000) + jZzc;
        zzamVar.zzb = -1L;
        if (zzg()) {
            this.zzb.zzc();
        }
    }
}
