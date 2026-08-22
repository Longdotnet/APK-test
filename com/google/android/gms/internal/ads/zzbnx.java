package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzbnx implements zzcao {
    final /* synthetic */ zzboh zza;
    final /* synthetic */ zzfhj zzb;
    final /* synthetic */ zzboi zzc;

    public zzbnx(zzboi zzboiVar, zzboh zzbohVar, zzfhj zzfhjVar) {
        this.zza = zzbohVar;
        this.zzb = zzfhjVar;
        Objects.requireNonNull(zzboiVar);
        this.zzc = zzboiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcao
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine (success): Trying to acquire lock");
        zzboi zzboiVar = this.zzc;
        synchronized (zzboiVar.zza) {
            try {
                com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine (success): Lock acquired");
                zzboiVar.zzi = 0;
                if (zzboiVar.zzh != null && this.zza != zzboiVar.zzh) {
                    com.google.android.gms.ads.internal.util.zze.zza("New JS engine is loaded, marking previous one as destroyable.");
                    zzboiVar.zzh.zzb();
                }
                zzboiVar.zzh = this.zza;
                if (((Boolean) zzbex.zzd.zze()).booleanValue() && zzboiVar.zze != null) {
                    zzfhx zzfhxVar = zzboiVar.zze;
                    zzfhj zzfhjVar = this.zzb;
                    zzfhjVar.zzg(true);
                    zzfhxVar.zzc(zzfhjVar.zzm());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine (success): Lock released");
    }
}
