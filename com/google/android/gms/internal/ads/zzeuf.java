package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzeuf {
    private final Context zza;
    private final Set zzb;
    private final Executor zzc;
    private final zzfhu zzd;
    private final zzdsj zze;
    private long zzf = 0;
    private int zzg = 0;

    public zzeuf(Context context, Executor executor, Set set, zzfhu zzfhuVar, zzdsj zzdsjVar) {
        this.zza = context;
        this.zzc = executor;
        this.zzb = set;
        this.zzd = zzfhuVar;
        this.zze = zzdsjVar;
    }

    public static void zzb(zzeuf zzeufVar, long j, zzeuc zzeucVar, Bundle bundle) {
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        zzvVar.zzl.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
        if (((Boolean) zzbfg.zza.zze()).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zza("Signal runtime (ms) : " + zzfwg.zzc(zzeucVar.getClass().getCanonicalName()) + " = " + jElapsedRealtime);
        }
        zzbcv zzbcvVar = zzbde.zzcq;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzcw)).booleanValue()) {
                synchronized (zzeufVar) {
                    bundle.putLong("sig" + zzeucVar.zza(), jElapsedRealtime);
                }
            }
        }
        if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzco)).booleanValue()) {
            zzdsi zzdsiVarZza = zzeufVar.zze.zza();
            zzdsiVarZza.zzb("action", "lat_ms");
            zzdsiVarZza.zzb("lat_grp", "sig_lat_grp");
            zzdsiVarZza.zzb("lat_id", String.valueOf(zzeucVar.zza()));
            zzdsiVarZza.zzb("clat_ms", String.valueOf(jElapsedRealtime));
            if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzcp)).booleanValue()) {
                synchronized (zzeufVar) {
                    zzeufVar.zzg++;
                }
                zzdsiVarZza.zzb("seq_num", zzvVar.zzi.zzh().zzd());
                synchronized (zzeufVar) {
                    try {
                        if (zzeufVar.zzg == zzeufVar.zzb.size() && zzeufVar.zzf != 0) {
                            zzeufVar.zzg = 0;
                            zzvVar.zzl.getClass();
                            String strValueOf = String.valueOf(SystemClock.elapsedRealtime() - zzeufVar.zzf);
                            if (zzeucVar.zza() <= 39 || zzeucVar.zza() >= 52) {
                                zzdsiVarZza.zzb("lat_clsg", strValueOf);
                            } else {
                                zzdsiVarZza.zzb("lat_gmssg", strValueOf);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            zzdsiVarZza.zzk();
        }
    }

    public final ListenableFuture zza(final Object obj, final Bundle bundle, final boolean z) {
        zzfhj zzfhjVarZza = zzfhi.zza(this.zza, 8);
        zzfhjVarZza.zzi();
        Set<zzeuc> set = this.zzb;
        final ArrayList arrayList = new ArrayList(set.size());
        List arrayList2 = new ArrayList();
        zzbcv zzbcvVar = zzbde.zzmg;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        boolean zIsEmpty = ((String) zzbdVar.zzd.zzb(zzbcvVar)).isEmpty();
        zzbdc zzbdcVar = zzbdVar.zzd;
        if (!zIsEmpty) {
            arrayList2 = Arrays.asList(((String) zzbdcVar.zzb(zzbcvVar)).split(","));
        }
        List list = arrayList2;
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        zzvVar.zzl.getClass();
        this.zzf = SystemClock.elapsedRealtime();
        final Bundle bundle2 = new Bundle();
        if (((Boolean) zzbdcVar.zzb(zzbde.zzcq)).booleanValue() && bundle != null) {
            zzvVar.zzl.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (obj instanceof zzcva) {
                bundle.putLong(zzdrr.CLIENT_SIGNALS_START.zza(), jCurrentTimeMillis);
            } else {
                bundle.putLong(zzdrr.GMS_SIGNALS_START.zza(), jCurrentTimeMillis);
            }
        }
        for (final zzeuc zzeucVar : set) {
            if (!list.contains(String.valueOf(zzeucVar.zza()))) {
                com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                final long jElapsedRealtime = SystemClock.elapsedRealtime();
                ListenableFuture listenableFutureZzb = zzeucVar.zzb();
                listenableFutureZzb.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeud
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzeuf.zzb(this.zza, jElapsedRealtime, zzeucVar, bundle2);
                    }
                }, zzcaf.zzg);
                arrayList.add(listenableFutureZzb);
            }
        }
        ListenableFuture listenableFutureZza = zzgdn.zzb(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzeue
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Object obj2;
                Bundle bundle3;
                Iterator it = arrayList.iterator();
                while (true) {
                    obj2 = obj;
                    if (!it.hasNext()) {
                        break;
                    }
                    zzeub zzeubVar = (zzeub) ((ListenableFuture) it.next()).get();
                    if (zzeubVar != null) {
                        boolean z2 = z;
                        zzeubVar.zzb(obj2);
                        if (z2) {
                            zzeubVar.zza(obj2);
                        }
                    }
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcq)).booleanValue() && (bundle3 = bundle) != null) {
                    Bundle bundle4 = bundle2;
                    com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    if (obj2 instanceof zzcva) {
                        bundle3.putLong(zzdrr.CLIENT_SIGNALS_END.zza(), jCurrentTimeMillis2);
                        bundle3.putBundle("client_sig_latency_key", bundle4);
                    } else {
                        bundle3.putLong(zzdrr.zzi.zza(), jCurrentTimeMillis2);
                        bundle3.putBundle("gms_sig_latency_key", bundle4);
                    }
                }
                return obj2;
            }
        }, this.zzc);
        if (zzfhx.zza()) {
            zzfht.zza(listenableFutureZza, this.zzd, zzfhjVarZza);
        }
        return listenableFutureZza;
    }
}
