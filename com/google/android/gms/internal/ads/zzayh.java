package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class zzayh extends zzayk {
    private final View zzh;

    public zzayh(zzawx zzawxVar, String str, String str2, zzast zzastVar, int i, int i2, View view) {
        super(zzawxVar, "h7NW4UTeHoapcAfHjNS1jSIEsdu+S9XbBUhqH3zqKlRoFqG3FEF52d6iyzd+cmzU", "UQVAYGHTy6RzP6i5dxbs04Nz2BVdis2XDzzm3D3JwpQ=", zzastVar, i, 57);
        this.zzh = view;
    }

    @Override // com.google.android.gms.internal.ads.zzayk
    public final void zza() {
        View view = this.zzh;
        if (view != null) {
            zzbcv zzbcvVar = zzbde.zzdI;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
            Boolean bool = (Boolean) zzbdVar.zzd.zzb(zzbcvVar);
            Boolean bool2 = (Boolean) zzbdVar.zzd.zzb(zzbde.zzlt);
            zzaxb zzaxbVar = new zzaxb((String) this.zze.invoke(null, view, this.zza.zzb().getResources().getDisplayMetrics(), bool, bool2));
            zzato zzatoVarZza = zzatp.zza();
            zzatoVarZza.zzb(zzaxbVar.zza.longValue());
            zzatoVarZza.zzd(zzaxbVar.zzb.longValue());
            zzatoVarZza.zze(zzaxbVar.zzc.longValue());
            if (bool2.booleanValue()) {
                zzatoVarZza.zzc(zzaxbVar.zze.longValue());
            }
            if (bool.booleanValue()) {
                zzatoVarZza.zza(zzaxbVar.zzd.longValue());
            }
            this.zzd.zzW((zzatp) zzatoVarZza.zzbr());
        }
    }
}
