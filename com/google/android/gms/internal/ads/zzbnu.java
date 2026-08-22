package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzbnu implements zzbkf {
    final /* synthetic */ zzbnd zza;
    final /* synthetic */ com.google.android.gms.ads.internal.util.zzby zzb;
    final /* synthetic */ zzboi zzc;

    public zzbnu(zzboi zzboiVar, zzavu zzavuVar, zzbnd zzbndVar, com.google.android.gms.ads.internal.util.zzby zzbyVar) {
        this.zza = zzbndVar;
        this.zzb = zzbyVar;
        Objects.requireNonNull(zzboiVar);
        this.zzc = zzboiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final void zza(Object obj, Map map) {
        com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > /requestReload handler: Trying to acquire lock");
        zzboi zzboiVar = this.zzc;
        synchronized (zzboiVar.zza) {
            try {
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > /requestReload handler: Lock acquired");
                com.google.android.gms.ads.internal.util.client.zzo.zzi("JS Engine is requesting an update");
                if (zzboiVar.zzi == 0) {
                    com.google.android.gms.ads.internal.util.client.zzo.zzi("Starting reload.");
                    zzboiVar.zzi = 2;
                    zzboiVar.zzd(null);
                }
                this.zza.zzr("/requestReload", (zzbkf) this.zzb.zza);
            } catch (Throwable th) {
                throw th;
            }
        }
        com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > /requestReload handler: Lock released");
    }
}
