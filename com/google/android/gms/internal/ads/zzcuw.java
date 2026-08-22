package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
final class zzcuw implements zzcxm, zzcwt {
    private final zzfca zza;

    public zzcuw(Context context, zzfca zzfcaVar, zzbtv zzbtvVar) {
        this.zza = zzfcaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcwt
    public final void zzdj(Context context) {
    }

    @Override // com.google.android.gms.internal.ads.zzcwt
    public final void zzdl(Context context) {
    }

    @Override // com.google.android.gms.internal.ads.zzcwt
    public final void zzdm(Context context) {
    }

    @Override // com.google.android.gms.internal.ads.zzcxm
    public final void zzu() {
        zzbtw zzbtwVar = this.zza.zzad;
        if (zzbtwVar == null || !zzbtwVar.zza) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        String str = zzbtwVar.zzb;
        if (str.isEmpty()) {
            return;
        }
        arrayList.add(str);
    }
}
