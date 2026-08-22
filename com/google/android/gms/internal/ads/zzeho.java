package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzeho implements zzeds {
    private final Context zza;
    private final Executor zzb;
    private final zzdos zzc;

    public zzeho(Context context, Executor executor, zzdos zzdosVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzdosVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeds
    public final /* bridge */ /* synthetic */ Object zza(zzfcn zzfcnVar, zzfca zzfcaVar, zzedp zzedpVar) {
        zzdoo zzdooVarZzd = this.zzc.zzd(new zzcrq(zzfcnVar, zzfcaVar, zzedpVar.zza), new zzdop(new zzehn(this, zzedpVar, zzfcaVar)));
        zzdooVarZzd.zzd().zzo(new zzcmg((zzfdu) zzedpVar.zzb), this.zzb);
        ((zzefd) zzedpVar.zzc).zzc(zzdooVarZzd.zzn());
        return zzdooVarZzd.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzeds
    public final void zzb(zzfcn zzfcnVar, zzfca zzfcaVar, zzedp zzedpVar) {
        try {
            zzfcw zzfcwVar = zzfcnVar.zza.zza;
            if (zzfcwVar.zzo.zza == 3) {
                ((zzfdu) zzedpVar.zzb).zzr(this.zza, zzfcwVar.zzd, zzfcaVar.zzv.toString(), (zzbpw) zzedpVar.zzc);
            } else {
                ((zzfdu) zzedpVar.zzb).zzq(this.zza, zzfcwVar.zzd, zzfcaVar.zzv.toString(), (zzbpw) zzedpVar.zzc);
            }
        } catch (Exception e) {
            String str = zzedpVar.zza;
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Fail to load ad from adapter ".concat(String.valueOf(str)), e);
        }
    }
}
