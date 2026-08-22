package com.google.android.gms.internal.ads;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzdhk implements zzbkf {
    private final WeakReference zza;
    private final WeakReference zzb;

    public zzdhk(zzdhn zzdhnVar, View view, zzdhm zzdhmVar) {
        this.zza = new WeakReference(zzdhnVar);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zznn)).booleanValue()) {
            this.zzb = new WeakReference(view);
        } else {
            this.zzb = new WeakReference(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final void zza(Object obj, Map map) {
        zzdhn zzdhnVar = (zzdhn) this.zza.get();
        if (zzdhnVar == null) {
            return;
        }
        zzdhnVar.zzg.zza();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zznn)).booleanValue()) {
            zzdhnVar.zzE.zza((View) this.zzb.get(), zzdhnVar.zzj);
        }
    }
}
