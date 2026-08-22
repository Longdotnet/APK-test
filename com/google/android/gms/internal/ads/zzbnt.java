package com.google.android.gms.internal.ads;

import androidx.core.internal.view.Oteb.nYVxXTZQ;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class zzbnt implements zzbkf {
    final /* synthetic */ long zza;
    final /* synthetic */ zzboh zzb;
    final /* synthetic */ zzbnd zzc;
    final /* synthetic */ zzboi zzd;

    public zzbnt(zzboi zzboiVar, long j, zzboh zzbohVar, zzbnd zzbndVar) {
        this.zza = j;
        this.zzb = zzbohVar;
        this.zzc = zzbndVar;
        Objects.requireNonNull(zzboiVar);
        this.zzd = zzboiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final void zza(Object obj, Map map) {
        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
        com.google.android.gms.ads.internal.util.zze.zza("onGmsg /jsLoaded. JsLoaded latency is " + (System.currentTimeMillis() - this.zza) + " ms.");
        com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > /jsLoaded handler: Trying to acquire lock");
        zzboi zzboiVar = this.zzd;
        synchronized (zzboiVar.zza) {
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > /jsLoaded handler: Lock acquired");
            zzboh zzbohVar = this.zzb;
            if (zzbohVar.zze() != -1 && zzbohVar.zze() != 1) {
                zzboiVar.zzi = 0;
                zzbnd zzbndVar = this.zzc;
                zzbndVar.zzq("/log", zzbke.zzg);
                zzbndVar.zzq(nYVxXTZQ.kxVGIjiZzed, zzbke.zzo);
                zzbohVar.zzi(zzbndVar);
                zzboiVar.zzh = zzbohVar;
                com.google.android.gms.ads.internal.util.zze.zza(oKjScaD.shDpBA);
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > /jsLoaded handler: Lock released");
                return;
            }
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > /jsLoaded handler: Lock released, the promise is already settled");
        }
    }
}
