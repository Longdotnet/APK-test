package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzfbn implements zzelo {
    private final Context zza;
    private final Executor zzb;
    private final zzche zzc;
    private final zzfbd zzd;
    private final zzezr zze;
    private final zzfco zzf;
    private final zzfhx zzg;
    private final zzfcu zzh;
    private ListenableFuture zzi;

    public zzfbn(Context context, Executor executor, zzche zzcheVar, zzezr zzezrVar, zzfbd zzfbdVar, zzfcu zzfcuVar, zzfco zzfcoVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcheVar;
        this.zze = zzezrVar;
        this.zzd = zzfbdVar;
        this.zzh = zzfcuVar;
        this.zzf = zzfcoVar;
        this.zzg = zzcheVar.zzy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzdor zzk(zzezp zzezpVar) {
        zzdor zzdorVarZzh = this.zzc.zzh();
        zzcvf zzcvfVar = new zzcvf();
        zzcvfVar.zzf(this.zza);
        zzcvfVar.zzk(((zzfbl) zzezpVar).zza);
        zzcvfVar.zzj(this.zzf);
        zzdorVarZzh.zzd(zzcvfVar.zzl());
        zzdorVarZzh.zzc(new zzdbu().zzn());
        return zzdorVarZzh;
    }

    @Override // com.google.android.gms.internal.ads.zzelo
    public final boolean zza() {
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0066  */
    @Override // com.google.android.gms.internal.ads.zzelo
    public final boolean zzb(com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzelm zzelmVar, zzeln zzelnVar) {
        zzfhu zzfhuVarZzg;
        zzbwj zzbwjVar = new zzbwj(zzmVar, str);
        String str2 = zzbwjVar.zzb;
        if (str2 == null) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Ad unit ID should not be null for rewarded video ad.");
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfbg
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzd.zzdD(zzfdx.zzd(6, null, null));
                }
            });
        } else {
            ListenableFuture listenableFuture = this.zzi;
            if (listenableFuture == null || listenableFuture.isDone()) {
                if (((Boolean) zzbex.zzc.zze()).booleanValue()) {
                    zzezr zzezrVar = this.zze;
                    if (zzezrVar.zzd() != null) {
                        zzfhuVarZzg = ((zzdos) zzezrVar.zzd()).zzg();
                        zzfhuVarZzg.zzi(5);
                        com.google.android.gms.ads.internal.client.zzm zzmVar2 = zzbwjVar.zza;
                        zzfhuVarZzg.zzb(zzmVar2.zzp);
                        zzfhuVarZzg.zzf(zzmVar2.zzm);
                    } else {
                        zzfhuVarZzg = null;
                    }
                } else {
                    zzfhuVarZzg = null;
                }
                Context context = this.zza;
                com.google.android.gms.ads.internal.client.zzm zzmVar3 = zzbwjVar.zza;
                boolean z = zzmVar3.zzf;
                zzfdt.zza(context, z);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjp)).booleanValue() && z) {
                    this.zzc.zzk().zzo(true);
                }
                Pair pair = new Pair(zzdrr.PUBLIC_API_CALL.zza(), Long.valueOf(zzmVar3.zzz));
                String strZza = zzdrr.DYNAMITE_ENTER.zza();
                com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                Bundle bundleZza = zzdrt.zza(pair, new Pair(strZza, Long.valueOf(System.currentTimeMillis())));
                zzfcu zzfcuVar = this.zzh;
                zzfcuVar.zzu(str2);
                zzfcuVar.zzt(new com.google.android.gms.ads.internal.client.zzr("reward_mb", 0, 0, true, 0, 0, null, false, false, false, false, false, false, false, false));
                zzfcuVar.zzJ(zzmVar3);
                zzfcuVar.zzB(bundleZza);
                zzfcw zzfcwVarZzL = zzfcuVar.zzL();
                zzfhj zzfhjVarZzb = zzfhi.zzb(context, zzfht.zzf(zzfcwVarZzL), 5, zzmVar3);
                zzfbl zzfblVar = new zzfbl(null);
                zzfblVar.zza = zzfcwVarZzL;
                ListenableFuture listenableFutureZzc = this.zze.zzc(new zzezs(zzfblVar, null), new zzezq() { // from class: com.google.android.gms.internal.ads.zzfbh
                    @Override // com.google.android.gms.internal.ads.zzezq
                    public final zzcvd zza(zzezp zzezpVar) {
                        return this.zza.zzk(zzezpVar);
                    }
                }, null);
                this.zzi = listenableFutureZzc;
                zzgdn.zzr(listenableFutureZzc, new zzfbk(this, zzelnVar, zzfhuVarZzg, zzfhjVarZzb, zzfblVar), this.zzb);
                return true;
            }
        }
        return false;
    }

    public final void zzj(int i) {
        this.zzh.zzq().zza(i);
    }
}
