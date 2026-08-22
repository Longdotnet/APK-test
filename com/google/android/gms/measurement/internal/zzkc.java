package com.google.android.gms.measurement.internal;

import android.os.Looper;
import com.facebook.AccessTokenCache;
import com.google.android.gms.internal.measurement.zzby;
import com.google.firebase.auth.zzz;

/* JADX INFO: loaded from: classes.dex */
public final class zzkc extends zzf {
    public final AccessTokenCache zza;
    public final zzka zzb;
    public final zzz zzc;
    public zzby zzd;

    public zzkc(zzfr zzfrVar) {
        super(zzfrVar);
        this.zza = new AccessTokenCache(this, 25);
        this.zzb = new zzka(this);
        this.zzc = new zzz(this);
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final boolean zzf() {
        return false;
    }

    public final void zzm$2() {
        zzg();
        if (this.zzd == null) {
            this.zzd = new zzby(Looper.getMainLooper());
        }
    }
}
