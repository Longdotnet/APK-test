package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
final class zzdyq implements zzcza {
    private final Context zza;
    private final zzbyo zzb;

    public zzdyq(Context context, zzbyo zzbyoVar) {
        this.zza = context;
        this.zzb = zzbyoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcza
    public final void zzdn(zzbvq zzbvqVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzcza
    public final void zzdo(zzfcn zzfcnVar) {
        String str = zzfcnVar.zzb.zzb.zze;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        zzbyo zzbyoVar = this.zzb;
        Context context = this.zza;
        zzbyoVar.zzm(context, zzfcnVar.zza.zza.zzd);
        zzbyoVar.zzi(context, str);
    }
}
