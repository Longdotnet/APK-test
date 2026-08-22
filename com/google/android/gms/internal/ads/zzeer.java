package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import okio.AsyncTimeout;

/* JADX INFO: loaded from: classes.dex */
public final class zzeer implements zzeds {
    private final Context zza;
    private final zzcpx zzb;
    private final Executor zzc;

    public zzeer(Context context, zzcpx zzcpxVar, Executor executor) {
        this.zza = context;
        this.zzb = zzcpxVar;
        this.zzc = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzeds
    public final Object zza(zzfcn zzfcnVar, final zzfca zzfcaVar, zzedp zzedpVar) throws zzfdd {
        final View viewZza;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzij)).booleanValue() && zzfcaVar.zzag) {
            zzbpz zzbpzVarZzc = ((zzfdu) zzedpVar.zzb).zzc();
            if (zzbpzVarZzc == null) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("getInterscrollerAd should not be null after loadInterscrollerAd loaded ad.");
                throw new zzfdd(new Exception("getInterscrollerAd should not be null after loadInterscrollerAd loaded ad."));
            }
            try {
                viewZza = (View) ObjectWrapper.unwrap(zzbpzVarZzc.zze());
                boolean zZzf = zzbpzVarZzc.zzf();
                if (viewZza == null) {
                    throw new zzfdd(new Exception("BannerAdapterWrapper interscrollerView should not be null"));
                }
                if (zZzf) {
                    try {
                        viewZza = (View) zzgdn.zzn(zzgdn.zzh(null), new zzgcu() { // from class: com.google.android.gms.internal.ads.zzeep
                            @Override // com.google.android.gms.internal.ads.zzgcu
                            public final ListenableFuture zza(Object obj) {
                                return zzgdn.zzh(zzcqm.zza(this.zza.zza, viewZza, zzfcaVar));
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
            viewZza = ((zzfdu) zzedpVar.zzb).zza();
        }
        zzcpx zzcpxVar = this.zzb;
        zzcrq zzcrqVar = new zzcrq(zzfcnVar, zzfcaVar, zzedpVar.zza);
        final zzfdu zzfduVar = (zzfdu) zzedpVar.zzb;
        Objects.requireNonNull(zzfduVar);
        zzcot zzcotVarZza = zzcpxVar.zza(zzcrqVar, new zzcoz(viewZza, null, new zzcqy() { // from class: com.google.android.gms.internal.ads.zzeeq
            @Override // com.google.android.gms.internal.ads.zzcqy
            public final com.google.android.gms.ads.internal.client.zzed zza() {
                return zzfduVar.zzb();
            }
        }, (zzfcb) zzfcaVar.zzu.get(0)));
        zzcotVarZza.zzh().zza(viewZza);
        zzcotVarZza.zzd().zzo(new zzcmg(zzfduVar), this.zzc);
        ((zzefd) zzedpVar.zzc).zzc(zzcotVarZza.zzk());
        return zzcotVarZza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeds
    public final void zzb(zzfcn zzfcnVar, zzfca zzfcaVar, zzedp zzedpVar) throws zzfdd {
        com.google.android.gms.ads.internal.client.zzr zzrVarZza;
        zzfcw zzfcwVar = zzfcnVar.zza.zza;
        com.google.android.gms.ads.internal.client.zzr zzrVar = zzfcwVar.zze;
        boolean z = zzrVar.zzn;
        int i = zzrVar.zzb;
        int i2 = zzrVar.zze;
        if (z) {
            Context context = this.zza;
            AdSize adSize = new AdSize(i2, i);
            adSize.zzf = true;
            adSize.zzg = i;
            zzrVarZza = new com.google.android.gms.ads.internal.client.zzr(context, adSize);
        } else {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzij)).booleanValue() && zzfcaVar.zzag) {
                Context context2 = this.zza;
                AdSize adSize2 = new AdSize(i2, i);
                adSize2.zzh = true;
                adSize2.zzi = i;
                zzrVarZza = new com.google.android.gms.ads.internal.client.zzr(context2, adSize2);
            } else {
                zzrVarZza = zzfdc.zza(this.zza, zzfcaVar.zzu);
            }
        }
        com.google.android.gms.ads.internal.client.zzr zzrVar2 = zzrVarZza;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzij)).booleanValue() && zzfcaVar.zzag) {
            ((zzfdu) zzedpVar.zzb).zzn(this.zza, zzrVar2, zzfcwVar.zzd, zzfcaVar.zzv.toString(), AsyncTimeout.Companion.zzm(zzfcaVar.zzs), (zzbpw) zzedpVar.zzc);
        } else {
            ((zzfdu) zzedpVar.zzb).zzm(this.zza, zzrVar2, zzfcwVar.zzd, zzfcaVar.zzv.toString(), AsyncTimeout.Companion.zzm(zzfcaVar.zzs), (zzbpw) zzedpVar.zzc);
        }
    }
}
