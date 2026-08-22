package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzcmg implements zzcwt {
    private final zzfdu zza;

    public zzcmg(zzfdu zzfduVar) {
        this.zza = zzfduVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcwt
    public final void zzdj(Context context) {
        try {
            this.zza.zzg();
        } catch (zzfdd e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Cannot invoke onDestroy for the mediation adapter.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwt
    public final void zzdl(Context context) {
        try {
            this.zza.zzt();
        } catch (zzfdd e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Cannot invoke onPause for the mediation adapter.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwt
    public final void zzdm(Context context) {
        try {
            zzfdu zzfduVar = this.zza;
            zzfduVar.zzu();
            if (context != null) {
                zzfduVar.zzs(context);
            }
        } catch (zzfdd e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Cannot invoke onResume for the mediation adapter.", e);
        }
    }
}
