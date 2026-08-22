package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzegh implements zzeds {
    private final Context zza;
    private final zzdhb zzb;
    private zzbqf zzc;
    private final VersionInfoParcel zzd;

    public zzegh(Context context, zzdhb zzdhbVar, VersionInfoParcel versionInfoParcel) {
        this.zza = context;
        this.zzb = zzdhbVar;
        this.zzd = versionInfoParcel;
    }

    @Override // com.google.android.gms.internal.ads.zzeds
    public final /* bridge */ /* synthetic */ Object zza(zzfcn zzfcnVar, zzfca zzfcaVar, zzedp zzedpVar) throws zzehf {
        ArrayList arrayList = zzfcnVar.zza.zza.zzg;
        if (!arrayList.contains(Integer.toString(6))) {
            throw new zzehf(2, "Unified must be used for RTB.");
        }
        zzdit zzditVarZzt = zzdit.zzt(this.zzc);
        if (!arrayList.contains(Integer.toString(zzditVarZzt.zzc()))) {
            throw new zzehf(1, "No corresponding native ad listener");
        }
        zzdiv zzdivVarZze = this.zzb.zze(new zzcrq(zzfcnVar, zzfcaVar, zzedpVar.zza), new zzdjf(zzditVarZzt), new zzdky(null, null, this.zzc));
        ((zzefd) zzedpVar.zzc).zzc(zzdivVarZze.zzj());
        return zzdivVarZze.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeds
    public final void zzb(zzfcn zzfcnVar, zzfca zzfcaVar, zzedp zzedpVar) throws zzfdd {
        try {
            zzbrp zzbrpVar = (zzbrp) zzedpVar.zzb;
            zzbrpVar.zzq(zzfcaVar.zzZ);
            zzegg zzeggVar = null;
            if (this.zzd.clientJarVersion < ((Integer) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzbT)).intValue()) {
                zzbrpVar.zzm(zzfcaVar.zzU, zzfcaVar.zzv.toString(), zzfcnVar.zza.zza.zzd, new ObjectWrapper(this.zza), new zzegf(this, zzedpVar, zzeggVar), (zzbpw) zzedpVar.zzc);
                return;
            }
            String str = zzfcaVar.zzU;
            String string = zzfcaVar.zzv.toString();
            zzfcw zzfcwVar = zzfcnVar.zza.zza;
            zzbrpVar.zzn(str, string, zzfcwVar.zzd, new ObjectWrapper(this.zza), new zzegf(this, zzedpVar, zzeggVar), (zzbpw) zzedpVar.zzc, zzfcwVar.zzi);
        } catch (RemoteException e) {
            throw new zzfdd(e);
        }
    }
}
