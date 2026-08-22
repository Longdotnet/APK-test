package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzeik implements zzeds {
    private final Context zza;
    private final Executor zzb;
    private final zzdos zzc;

    public zzeik(Context context, Executor executor, zzdos zzdosVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzdosVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zze(zzfcn zzfcnVar, zzfca zzfcaVar, zzedp zzedpVar) {
        try {
            ((zzfdu) zzedpVar.zzb).zzk(zzfcnVar.zza.zza.zzd, zzfcaVar.zzv.toString());
        } catch (Exception e) {
            String str = zzedpVar.zza;
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Fail to load ad from adapter ".concat(String.valueOf(str)), e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeds
    public final /* bridge */ /* synthetic */ Object zza(zzfcn zzfcnVar, zzfca zzfcaVar, zzedp zzedpVar) {
        zzdoo zzdooVarZzd = this.zzc.zzd(new zzcrq(zzfcnVar, zzfcaVar, zzedpVar.zza), new zzdop(new zzeii(this, zzedpVar, zzfcaVar)));
        zzdooVarZzd.zzd().zzo(new zzcmg((zzfdu) zzedpVar.zzb), this.zzb);
        zzcxf zzcxfVarZze = zzdooVarZzd.zze();
        zzcvw zzcvwVarZzb = zzdooVarZzd.zzb();
        ((zzefe) zzedpVar.zzc).zzc(new zzeij(this, zzdooVarZzd.zza(), zzcvwVarZzb, zzcxfVarZze, zzdooVarZzd.zzg()));
        return zzdooVarZzd.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzeds
    public final void zzb(zzfcn zzfcnVar, zzfca zzfcaVar, zzedp zzedpVar) throws zzfdd {
        zzfdu zzfduVar = (zzfdu) zzedpVar.zzb;
        if (zzfduVar.zzC()) {
            zze(zzfcnVar, zzfcaVar, zzedpVar);
            return;
        }
        zzeih zzeihVar = new zzeih(this, zzfcnVar, zzfcaVar, zzedpVar);
        zzcxi zzcxiVar = zzedpVar.zzc;
        ((zzefe) zzcxiVar).zzd(zzeihVar);
        Context context = this.zza;
        zzfcw zzfcwVar = zzfcnVar.zza.zza;
        String string = zzfcaVar.zzv.toString();
        zzfduVar.zzh(context, zzfcwVar.zzd, null, (zzbwn) zzcxiVar, string);
    }
}
