package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public final class zziw {
    final Context zza;
    zzdj zzb;
    zzfwh zzc;
    zzfwh zzd;
    zzfwh zze;
    zzfwh zzf;
    zzfwh zzg;
    zzfve zzh;
    Looper zzi;
    int zzj;
    zze zzk;
    int zzl;
    boolean zzm;
    zzmi zzn;
    zzmh zzo;
    long zzp;
    long zzq;
    boolean zzr;
    boolean zzs;
    String zzt;
    zzig zzu;

    public zziw(final Context context, zzcem zzcemVar) {
        zzip zzipVar = new zzip(zzcemVar);
        zziq zziqVar = new zziq(context);
        zzfwh zzfwhVar = new zzfwh() { // from class: com.google.android.gms.internal.ads.zzir
            @Override // com.google.android.gms.internal.ads.zzfwh
            public final Object zza() {
                return new zzyu(context);
            }
        };
        zzfwh zzfwhVar2 = new zzfwh() { // from class: com.google.android.gms.internal.ads.zzis
            @Override // com.google.android.gms.internal.ads.zzfwh
            public final Object zza() {
                return new zzij();
            }
        };
        zzit zzitVar = new zzit(context);
        zzfve zzfveVar = new zzfve() { // from class: com.google.android.gms.internal.ads.zziu
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                return new zzot((zzdj) obj);
            }
        };
        context.getClass();
        this.zza = context;
        this.zzc = zzipVar;
        this.zzd = zziqVar;
        this.zze = zzfwhVar;
        this.zzf = zzfwhVar2;
        this.zzg = zzitVar;
        this.zzh = zzfveVar;
        this.zzi = zzex.zzz();
        this.zzk = zze.zza;
        this.zzl = 1;
        this.zzm = true;
        this.zzn = zzmi.zzb;
        this.zzo = zzmh.zza;
        this.zzu = new zzig(0.97f, 1.03f, 1000L, 1.0E-7f, zzex.zzs(20L), zzex.zzs(500L), 0.999f, null);
        this.zzb = zzdj.zza;
        this.zzp = 500L;
        this.zzq = 2000L;
        this.zzr = true;
        this.zzt = "";
        this.zzj = -1000;
        if (Build.VERSION.SDK_INT >= 35) {
            int i = zzim.zza;
        }
    }

    public static /* synthetic */ zzvg zza(Context context) {
        return new zzuu(context, new zzadq());
    }
}
