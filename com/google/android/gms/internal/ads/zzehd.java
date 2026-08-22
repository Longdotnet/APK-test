package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class zzehd {
    private final zzfdo zza;
    private final zzdpw zzb;
    private final zzdsj zzc;

    public zzehd(zzfdo zzfdoVar, zzdpw zzdpwVar, zzdsj zzdsjVar) {
        this.zza = zzfdoVar;
        this.zzb = zzdpwVar;
        this.zzc = zzdsjVar;
    }

    public final void zza(zzfcd zzfcdVar, zzfca zzfcaVar, int i, zzedq zzedqVar, long j) {
        zzdpv zzdpvVarZza;
        zzdsi zzdsiVarZza = this.zzc.zza();
        zzdsiVarZza.zzd(zzfcdVar);
        zzdsiVarZza.zzc(zzfcaVar);
        zzdsiVarZza.zzb("action", "adapter_status");
        zzdsiVarZza.zzb("adapter_l", String.valueOf(j));
        zzdsiVarZza.zzb("sc", Integer.toString(i));
        if (zzedqVar != null) {
            zzdsiVarZza.zzb("arec", Integer.toString(zzedqVar.zzb().zza));
            String strZza = this.zza.zza(zzedqVar.getMessage());
            if (strZza != null) {
                zzdsiVarZza.zzb("areec", strZza);
            }
        }
        zzdpw zzdpwVar = this.zzb;
        Iterator it = zzfcaVar.zzt.iterator();
        do {
            if (!it.hasNext()) {
                zzdpvVarZza = null;
                break;
            }
            zzdpvVarZza = zzdpwVar.zza((String) it.next());
        } while (zzdpvVarZza == null);
        if (zzdpvVarZza != null) {
            zzdsiVarZza.zzb("ancn", zzdpvVarZza.zza);
            zzbse zzbseVar = zzdpvVarZza.zzb;
            if (zzbseVar != null) {
                zzdsiVarZza.zzb("adapter_v", zzbseVar.toString());
            }
            zzbse zzbseVar2 = zzdpvVarZza.zzc;
            if (zzbseVar2 != null) {
                zzdsiVarZza.zzb("adapter_sv", zzbseVar2.toString());
            }
        }
        zzdsiVarZza.zzj();
    }
}
