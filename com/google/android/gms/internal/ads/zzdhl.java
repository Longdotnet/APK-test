package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzdhl implements zzbkf {
    private final WeakReference zza;
    private final zzfjy zzb;
    private final com.google.android.gms.ads.internal.util.client.zzv zzc;
    private final zzfhu zzd;

    public /* synthetic */ zzdhl(zzdhn zzdhnVar, zzfjy zzfjyVar, com.google.android.gms.ads.internal.util.client.zzv zzvVar, zzfhu zzfhuVar, zzdhm zzdhmVar) {
        this.zza = new WeakReference(zzdhnVar);
        this.zzb = zzfjyVar;
        this.zzc = zzvVar;
        this.zzd = zzfhuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final void zza(Object obj, Map map) {
        zzdhn zzdhnVar = (zzdhn) this.zza.get();
        String str = (String) map.get("u");
        if (zzdhnVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.zzb.zzd(str, this.zzc, this.zzd, zzdhnVar.zzD);
    }
}
