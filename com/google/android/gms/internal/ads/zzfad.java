package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import androidx.loader.app.gv.DYYbQc;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzfad implements zzelo {
    private final Context zza;
    private final Executor zzb;
    private final zzche zzc;
    private final zzeky zzd;
    private final zzfbd zze;
    private zzbdz zzf;
    private final zzfhx zzg;
    private final zzfcu zzh;
    private ListenableFuture zzi;

    public zzfad(Context context, Executor executor, zzche zzcheVar, zzeky zzekyVar, zzfbd zzfbdVar, zzfcu zzfcuVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcheVar;
        this.zzd = zzekyVar;
        this.zzh = zzfcuVar;
        this.zze = zzfbdVar;
        this.zzg = zzcheVar.zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzelo
    public final boolean zza() {
        ListenableFuture listenableFuture = this.zzi;
        return (listenableFuture == null || listenableFuture.isDone()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzelo
    public final boolean zzb(com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzelm zzelmVar, zzeln zzelnVar) {
        zzdgf zzdgfVarZzf;
        zzfhu zzfhuVar;
        if (str == null) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzg(DYYbQc.NRm);
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzezx
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzd.zzdD(zzfdx.zzd(6, null, null));
                }
            });
            return false;
        }
        if (zza()) {
            return false;
        }
        zzbcv zzbcvVar = zzbde.zzjp;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() && zzmVar.zzf) {
            this.zzc.zzk().zzo(true);
        }
        com.google.android.gms.ads.internal.client.zzr zzrVar = ((zzezw) zzelmVar).zza;
        Pair pair = new Pair(zzdrr.PUBLIC_API_CALL.zza(), Long.valueOf(zzmVar.zzz));
        String strZza = zzdrr.DYNAMITE_ENTER.zza();
        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
        Bundle bundleZza = zzdrt.zza(pair, new Pair(strZza, Long.valueOf(System.currentTimeMillis())));
        zzfcu zzfcuVar = this.zzh;
        zzfcuVar.zzu(str);
        zzfcuVar.zzt(zzrVar);
        zzfcuVar.zzJ(zzmVar);
        zzfcuVar.zzB(bundleZza);
        Context context = this.zza;
        zzfcw zzfcwVarZzL = zzfcuVar.zzL();
        zzfhj zzfhjVarZzb = zzfhi.zzb(context, zzfht.zzf(zzfcwVarZzL), 4, zzmVar);
        if (((Boolean) zzbdVar.zzd.zzb(zzbde.zziC)).booleanValue()) {
            zzdge zzdgeVarZzf = this.zzc.zzf();
            zzcvf zzcvfVar = new zzcvf();
            zzcvfVar.zzf(context);
            zzcvfVar.zzk(zzfcwVarZzL);
            zzdgeVarZzf.zze(zzcvfVar.zzl());
            zzdbu zzdbuVar = new zzdbu();
            zzeky zzekyVar = this.zzd;
            Executor executor = this.zzb;
            zzdbuVar.zzj(zzekyVar, executor);
            zzdbuVar.zzk(zzekyVar, executor);
            zzdgeVarZzf.zzd(zzdbuVar.zzn());
            zzdgeVarZzf.zzc(new zzejh(this.zzf));
            zzdgfVarZzf = zzdgeVarZzf.zzf();
        } else {
            zzdbu zzdbuVar2 = new zzdbu();
            zzfbd zzfbdVar = this.zze;
            if (zzfbdVar != null) {
                Executor executor2 = this.zzb;
                zzdbuVar2.zze(zzfbdVar, executor2);
                zzdbuVar2.zzf(zzfbdVar, executor2);
                zzdbuVar2.zzb(zzfbdVar, executor2);
            }
            zzdge zzdgeVarZzf2 = this.zzc.zzf();
            zzcvf zzcvfVar2 = new zzcvf();
            zzcvfVar2.zzf(context);
            zzcvfVar2.zzk(zzfcwVarZzL);
            zzdgeVarZzf2.zze(zzcvfVar2.zzl());
            zzeky zzekyVar2 = this.zzd;
            Executor executor3 = this.zzb;
            zzdbuVar2.zzj(zzekyVar2, executor3);
            zzdbuVar2.zze(zzekyVar2, executor3);
            zzdbuVar2.zzf(zzekyVar2, executor3);
            zzdbuVar2.zzb(zzekyVar2, executor3);
            zzdbuVar2.zza(zzekyVar2, executor3);
            zzdbuVar2.zzl(zzekyVar2, executor3);
            zzdbuVar2.zzk(zzekyVar2, executor3);
            zzdbuVar2.zzi(zzekyVar2, executor3);
            zzdbuVar2.zzc(zzekyVar2, executor3);
            zzdgeVarZzf2.zzd(zzdbuVar2.zzn());
            zzdgeVarZzf2.zzc(new zzejh(this.zzf));
            zzdgfVarZzf = zzdgeVarZzf2.zzf();
        }
        zzdgf zzdgfVar = zzdgfVarZzf;
        if (((Boolean) zzbex.zzc.zze()).booleanValue()) {
            zzfhu zzfhuVarZze = zzdgfVar.zze();
            zzfhuVarZze.zzi(4);
            zzfhuVarZze.zzb(zzmVar.zzp);
            zzfhuVarZze.zzf(zzmVar.zzm);
            zzfhuVar = zzfhuVarZze;
        } else {
            zzfhuVar = null;
        }
        zzcse zzcseVarZza = zzdgfVar.zza();
        ListenableFuture listenableFutureZzh = zzcseVarZza.zzh(zzcseVarZza.zzi());
        this.zzi = listenableFutureZzh;
        zzgdn.zzr(listenableFutureZzh, new zzfac(this, zzelnVar, zzfhuVar, zzfhjVarZzb, zzdgfVar), this.zzb);
        return true;
    }

    public final void zzi(zzbdz zzbdzVar) {
        this.zzf = zzbdzVar;
    }
}
