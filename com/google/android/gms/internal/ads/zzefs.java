package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public final class zzefs implements zzeds {
    private final Context zza;
    private final zzdgf zzb;

    public zzefs(Context context, zzdgf zzdgfVar) {
        this.zza = context;
        this.zzb = zzdgfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeds
    public final /* bridge */ /* synthetic */ Object zza(zzfcn zzfcnVar, zzfca zzfcaVar, zzedp zzedpVar) {
        zzefm zzefmVar = new zzefm(zzfcaVar, (zzbrp) zzedpVar.zzb, AdFormat.INTERSTITIAL);
        zzdfc zzdfcVarZzd = this.zzb.zzd(new zzcrq(zzfcnVar, zzfcaVar, zzedpVar.zza), new zzdff(zzefmVar, null));
        zzefmVar.zzc(zzdfcVarZzd.zzc());
        ((zzefd) zzedpVar.zzc).zzc(zzdfcVarZzd.zzj());
        return zzdfcVarZzd.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzeds
    public final void zzb(zzfcn zzfcnVar, zzfca zzfcaVar, zzedp zzedpVar) throws zzfdd {
        try {
            zzbrp zzbrpVar = (zzbrp) zzedpVar.zzb;
            zzbrpVar.zzq(zzfcaVar.zzZ);
            zzbrpVar.zzl(zzfcaVar.zzU, zzfcaVar.zzv.toString(), zzfcnVar.zza.zza.zzd, new ObjectWrapper(this.zza), new zzefq(this, zzedpVar, null), (zzbpw) zzedpVar.zzc);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.zze.zzb("Remote exception loading a interstitial RTB ad", e);
            throw new zzfdd(e);
        }
    }
}
