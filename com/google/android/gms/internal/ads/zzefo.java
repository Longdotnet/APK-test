package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Executor;
import okio.AsyncTimeout;

/* JADX INFO: loaded from: classes.dex */
public final class zzefo implements zzeds {
    private final Context zza;
    private final zzdgf zzb;
    private final VersionInfoParcel zzc;
    private final Executor zzd;

    public zzefo(Context context, VersionInfoParcel versionInfoParcel, zzdgf zzdgfVar, Executor executor) {
        this.zza = context;
        this.zzc = versionInfoParcel;
        this.zzb = zzdgfVar;
        this.zzd = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzeds
    public final /* bridge */ /* synthetic */ Object zza(zzfcn zzfcnVar, zzfca zzfcaVar, zzedp zzedpVar) {
        zzdfc zzdfcVarZzd = this.zzb.zzd(new zzcrq(zzfcnVar, zzfcaVar, zzedpVar.zza), new zzdff(new zzefn(this, zzedpVar, zzfcaVar), null));
        zzdfcVarZzd.zzd().zzo(new zzcmg((zzfdu) zzedpVar.zzb), this.zzd);
        ((zzefd) zzedpVar.zzc).zzc(zzdfcVarZzd.zzk());
        return zzdfcVarZzd.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzeds
    public final void zzb(zzfcn zzfcnVar, zzfca zzfcaVar, zzedp zzedpVar) throws zzfdd {
        zzfdu zzfduVar = (zzfdu) zzedpVar.zzb;
        zzfcw zzfcwVar = zzfcnVar.zza.zza;
        String string = zzfcaVar.zzv.toString();
        String strZzm = AsyncTimeout.Companion.zzm(zzfcaVar.zzs);
        zzfduVar.zzo(this.zza, zzfcwVar.zzd, string, strZzm, (zzbpw) zzedpVar.zzc);
    }
}
