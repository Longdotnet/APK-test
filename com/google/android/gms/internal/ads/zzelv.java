package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzelv implements zzelo {
    private final zzfcu zza;
    private final zzche zzb;
    private final Context zzc;
    private final zzell zzd;
    private final zzfhx zze;
    private zzcrp zzf;

    public zzelv(zzche zzcheVar, Context context, zzell zzellVar, zzfcu zzfcuVar) {
        this.zzb = zzcheVar;
        this.zzc = context;
        this.zzd = zzellVar;
        this.zza = zzfcuVar;
        this.zze = zzcheVar.zzy();
        zzfcuVar.zzw(zzellVar.zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzelo
    public final boolean zza() {
        zzcrp zzcrpVar = this.zzf;
        return zzcrpVar != null && zzcrpVar.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzelo
    public final boolean zzb(com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzelm zzelmVar, zzeln zzelnVar) {
        zzfhu zzfhuVar;
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        com.google.android.gms.ads.internal.util.zzs zzsVar = zzvVar.zzd;
        Context context = this.zzc;
        if (com.google.android.gms.ads.internal.util.zzs.zzI(context) && zzmVar.zzs == null) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Failed to load the ad because app ID is missing.");
            this.zzb.zzA().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzelq
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzd.zza().zzdD(zzfdx.zzd(4, null, null));
                }
            });
            return false;
        }
        if (str == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Ad unit ID should not be null for NativeAdLoader.");
            this.zzb.zzA().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzelr
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzd.zza().zzdD(zzfdx.zzd(6, null, null));
                }
            });
            return false;
        }
        boolean z = zzmVar.zzf;
        zzfdt.zza(context, z);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjp)).booleanValue() && z) {
            this.zzb.zzk().zzo(true);
        }
        int i3 = ((zzelp) zzelmVar).zza;
        zzvVar.zzl.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strZza = zzdrr.PUBLIC_API_CALL.zza();
        Long lValueOf = Long.valueOf(jCurrentTimeMillis);
        Bundle bundleZza = zzdrt.zza(new Pair(strZza, lValueOf), new Pair(zzdrr.DYNAMITE_ENTER.zza(), lValueOf));
        zzfcu zzfcuVar = this.zza;
        zzfcuVar.zzJ(zzmVar);
        zzfcuVar.zzB(bundleZza);
        zzfcuVar.zzD(i3);
        zzfcw zzfcwVarZzL = zzfcuVar.zzL();
        zzfhj zzfhjVarZzb = zzfhi.zzb(context, zzfht.zzf(zzfcwVarZzL), 8, zzmVar);
        com.google.android.gms.ads.internal.client.zzco zzcoVar = zzfcwVarZzL.zzn;
        if (zzcoVar != null) {
            this.zzd.zzd().zzm(zzcoVar);
        }
        zzche zzcheVar = this.zzb;
        zzdha zzdhaVarZzg = zzcheVar.zzg();
        zzcvf zzcvfVar = new zzcvf();
        zzcvfVar.zzf(context);
        zzcvfVar.zzk(zzfcwVarZzL);
        zzdhaVarZzg.zzf(zzcvfVar.zzl());
        zzdbu zzdbuVar = new zzdbu();
        zzell zzellVar = this.zzd;
        zzdbuVar.zzk(zzellVar.zzd(), zzcheVar.zzA());
        zzdhaVarZzg.zze(zzdbuVar.zzn());
        zzdhaVarZzg.zzd(zzellVar.zzc());
        zzdhaVarZzg.zzc(new zzcop(null));
        zzdhb zzdhbVarZzg = zzdhaVarZzg.zzg();
        if (((Boolean) zzbex.zzc.zze()).booleanValue()) {
            zzfhu zzfhuVarZzf = zzdhbVarZzg.zzf();
            zzfhuVarZzf.zzi(8);
            zzfhuVarZzf.zzb(zzmVar.zzp);
            zzfhuVarZzf.zzf(zzmVar.zzm);
            zzfhuVar = zzfhuVarZzf;
        } else {
            zzfhuVar = null;
        }
        zzcheVar.zzx().zzc(1);
        zzgdy zzgdyVarZzc = zzffu.zzc();
        ScheduledExecutorService scheduledExecutorServiceZzB = zzcheVar.zzB();
        zzcse zzcseVarZza = zzdhbVarZzg.zza();
        zzcrp zzcrpVar = new zzcrp(zzgdyVarZzc, scheduledExecutorServiceZzB, zzcseVarZza.zzh(zzcseVarZza.zzi()));
        this.zzf = zzcrpVar;
        zzcrpVar.zze(new zzelu(this, zzelnVar, zzfhuVar, zzfhjVarZzb, zzdhbVarZzg));
        return true;
    }
}
