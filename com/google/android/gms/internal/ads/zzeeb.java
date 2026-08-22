package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzeeb implements zzeds {
    private final Context zza;
    private final zzcog zzb;
    private final Executor zzc;

    public zzeeb(Context context, zzcog zzcogVar, Executor executor) {
        this.zza = context;
        this.zzb = zzcogVar;
        this.zzc = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzeds
    public final /* bridge */ /* synthetic */ Object zza(zzfcn zzfcnVar, zzfca zzfcaVar, zzedp zzedpVar) {
        zzcod zzcodVarZza = this.zzb.zza(new zzcrq(zzfcnVar, zzfcaVar, zzedpVar.zza), new zzdff(new zzeea(this, zzedpVar, zzfcaVar), null), new zzcoe(zzfcaVar.zzaa));
        zzcodVarZza.zzd().zzo(new zzcmg((zzfdu) zzedpVar.zzb), this.zzc);
        ((zzefd) zzedpVar.zzc).zzc(zzcodVarZza.zzk());
        return zzcodVarZza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeds
    public final void zzb(zzfcn zzfcnVar, zzfca zzfcaVar, zzedp zzedpVar) throws zzfdd {
        zzfdu zzfduVar = (zzfdu) zzedpVar.zzb;
        zzfcw zzfcwVar = zzfcnVar.zza.zza;
        String string = zzfcaVar.zzv.toString();
        zzfduVar.zzl(this.zza, zzfcwVar.zzd, string, (zzbpw) zzedpVar.zzc);
    }
}
