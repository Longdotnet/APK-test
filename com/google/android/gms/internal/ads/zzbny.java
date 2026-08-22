package com.google.android.gms.internal.ads;

import com.google.android.gms.common.stats.ZnFR.FKidOcdAYt;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class zzbny implements zzcam {
    final /* synthetic */ zzboh zza;
    final /* synthetic */ zzfhj zzb;
    final /* synthetic */ zzboi zzc;

    public zzbny(zzboi zzboiVar, zzboh zzbohVar, zzfhj zzfhjVar) {
        this.zza = zzbohVar;
        this.zzb = zzfhjVar;
        Objects.requireNonNull(zzboiVar);
        this.zzc = zzboiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zza() {
        com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine (failure): Trying to acquire lock");
        zzboi zzboiVar = this.zzc;
        synchronized (zzboiVar.zza) {
            try {
                com.google.android.gms.ads.internal.util.zze.zza(FKidOcdAYt.cBFsNLLZCNyjWbm);
                zzboiVar.zzi = 1;
                com.google.android.gms.ads.internal.util.zze.zza("Failed loading new engine. Marking new engine destroyable.");
                this.zza.zzb();
                if (((Boolean) zzbex.zzd.zze()).booleanValue() && zzboiVar.zze != null) {
                    zzfhx zzfhxVar = zzboiVar.zze;
                    zzfhj zzfhjVar = this.zzb;
                    zzfhjVar.zzc("Failed loading new engine");
                    zzfhjVar.zzg(false);
                    zzfhxVar.zzc(zzfhjVar.zzm());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine (failure): Lock released");
    }
}
