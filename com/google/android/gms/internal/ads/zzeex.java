package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes.dex */
public final class zzeex implements zzeds {
    private final Context zza;
    private final zzcpx zzb;
    private View zzc;
    private zzbpz zzd;

    public zzeex(Context context, zzcpx zzcpxVar) {
        this.zza = context;
        this.zzb = zzcpxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeds
    public final Object zza(zzfcn zzfcnVar, final zzfca zzfcaVar, final zzedp zzedpVar) throws zzfdd {
        final View view;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzij)).booleanValue() && zzfcaVar.zzag) {
            try {
                view = (View) ObjectWrapper.unwrap(this.zzd.zze());
                boolean zZzf = this.zzd.zzf();
                if (view == null) {
                    throw new zzfdd(new Exception("BannerRtbAdapterWrapper interscrollerView should not be null"));
                }
                if (zZzf) {
                    try {
                        view = (View) zzgdn.zzn(zzgdn.zzh(null), new zzgcu() { // from class: com.google.android.gms.internal.ads.zzeeu
                            @Override // com.google.android.gms.internal.ads.zzgcu
                            public final ListenableFuture zza(Object obj) {
                                return zzgdn.zzh(zzcqm.zza(this.zza.zza, view, zzfcaVar));
                            }
                        }, zzcaf.zzf).get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new zzfdd(e);
                    }
                }
            } catch (RemoteException e2) {
                throw new zzfdd(e2);
            }
        } else {
            view = this.zzc;
        }
        zzcot zzcotVarZza = this.zzb.zza(new zzcrq(zzfcnVar, zzfcaVar, zzedpVar.zza), new zzcoz(view, null, new zzcqy() { // from class: com.google.android.gms.internal.ads.zzeet
            @Override // com.google.android.gms.internal.ads.zzcqy
            public final com.google.android.gms.ads.internal.client.zzed zza() throws zzfdd {
                try {
                    return ((zzbrp) zzedpVar.zzb).zze();
                } catch (RemoteException e3) {
                    throw new zzfdd(e3);
                }
            }
        }, (zzfcb) zzfcaVar.zzu.get(0)));
        zzcotVarZza.zzh().zza(view);
        ((zzefd) zzedpVar.zzc).zzc(zzcotVarZza.zzj());
        return zzcotVarZza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeds
    public final void zzb(zzfcn zzfcnVar, zzfca zzfcaVar, zzedp zzedpVar) throws zzfdd {
        try {
            zzbrp zzbrpVar = (zzbrp) zzedpVar.zzb;
            zzbrpVar.zzq(zzfcaVar.zzZ);
            zzeew zzeewVar = null;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzij)).booleanValue() && zzfcaVar.zzag) {
                String str = zzfcaVar.zzU;
                String string = zzfcaVar.zzv.toString();
                zzfcw zzfcwVar = zzfcnVar.zza.zza;
                zzbrpVar.zzk(str, string, zzfcwVar.zzd, new ObjectWrapper(this.zza), new zzeev(this, zzedpVar, zzeewVar), (zzbpw) zzedpVar.zzc, zzfcwVar.zze);
                return;
            }
            String str2 = zzfcaVar.zzU;
            String string2 = zzfcaVar.zzv.toString();
            zzfcw zzfcwVar2 = zzfcnVar.zza.zza;
            zzbrpVar.zzj(str2, string2, zzfcwVar2.zzd, new ObjectWrapper(this.zza), new zzeev(this, zzedpVar, zzeewVar), (zzbpw) zzedpVar.zzc, zzfcwVar2.zze);
        } catch (RemoteException e) {
            throw new zzfdd(e);
        }
    }
}
