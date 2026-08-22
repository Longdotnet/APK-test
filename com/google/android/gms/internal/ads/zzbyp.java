package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbyp {
    static zzbyp zzi;

    public static synchronized zzbyp zzb(Context context) {
        try {
            zzbyp zzbypVar = zzi;
            if (zzbypVar != null) {
                return zzbypVar;
            }
            Context applicationContext = context.getApplicationContext();
            zzbde.zza(applicationContext);
            com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
            com.google.android.gms.ads.internal.util.zzj zzjVar = (com.google.android.gms.ads.internal.util.zzj) zzvVar.zzi.zzi();
            zzjVar.zzp(applicationContext);
            zzbyh zzbyhVar = new zzbyh(null);
            zzbyhVar.zzb(applicationContext);
            zzbyhVar.zzc(zzvVar.zzl);
            zzbyhVar.zza(zzjVar);
            zzbyhVar.zzd(zzvVar.zzB);
            zzbyp zzbypVarZze = zzbyhVar.zze();
            zzi = zzbypVarZze;
            ((zzbyb) ((zzbyi) zzbypVarZze).zzc.zzb()).zza();
            zzbyt zzbytVar = (zzbyt) ((zzbyi) zzi).zzh.zzb();
            zzbcv zzbcvVar = zzbde.zzaJ;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
            if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
                HashMap mapZzw = com.google.android.gms.ads.internal.util.zzs.zzw((String) zzbdVar.zzd.zzb(zzbde.zzaK));
                Iterator it = mapZzw.keySet().iterator();
                while (it.hasNext()) {
                    zzbytVar.zzc((String) it.next());
                }
                zzbytVar.zzd(new zzbyr(zzbytVar, mapZzw));
            }
            return zzi;
        } catch (Throwable th) {
            throw th;
        }
    }

    public abstract zzbyf zza();
}
