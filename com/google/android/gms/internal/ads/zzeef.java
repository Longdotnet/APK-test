package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public final class zzeef implements zzeds {
    private final Context zza;
    private final zzcog zzb;

    public zzeef(Context context, zzcog zzcogVar) {
        this.zza = context;
        this.zzb = zzcogVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeds
    public final /* bridge */ /* synthetic */ Object zza(zzfcn zzfcnVar, zzfca zzfcaVar, zzedp zzedpVar) {
        zzefm zzefmVar = new zzefm(zzfcaVar, (zzbrp) zzedpVar.zzb, AdFormat.APP_OPEN_AD);
        zzcod zzcodVarZza = this.zzb.zza(new zzcrq(zzfcnVar, zzfcaVar, zzedpVar.zza), new zzdff(zzefmVar, null), new zzcoe(zzfcaVar.zzaa));
        zzefmVar.zzc(zzcodVarZza.zzc());
        ((zzefd) zzedpVar.zzc).zzc(zzcodVarZza.zzj());
        return zzcodVarZza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeds
    public final void zzb(zzfcn zzfcnVar, zzfca zzfcaVar, zzedp zzedpVar) throws zzfdd {
        try {
            zzbrp zzbrpVar = (zzbrp) zzedpVar.zzb;
            zzbrpVar.zzq(zzfcaVar.zzZ);
            zzbrpVar.zzi(zzfcaVar.zzU, zzfcaVar.zzv.toString(), zzfcnVar.zza.zza.zzd, new ObjectWrapper(this.zza), new zzeed(zzedpVar, null), (zzbpw) zzedpVar.zzc);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.zze.zzb("Remote exception loading an app open RTB ad", e);
            throw new zzfdd(e);
        }
    }
}
