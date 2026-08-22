package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public final class zzavm implements zzavp {
    private static zzavm zzb;
    private final Context zzc;
    private final zzfpv zzd;
    private final zzfqc zze;
    private final zzfqe zzf;
    private final zzawr zzg;
    private final zzfoi zzh;
    private final Executor zzi;
    private final zzfqb zzj;
    private final zzaxg zzl;
    private final zzawy zzm;
    private final zzawp zzn;
    private volatile boolean zzp;
    private volatile boolean zzq;
    private final int zzr;
    volatile long zza = 0;
    private final Object zzo = new Object();
    private final CountDownLatch zzk = new CountDownLatch(1);

    public zzavm(Context context, zzfoi zzfoiVar, zzfpv zzfpvVar, zzfqc zzfqcVar, zzfqe zzfqeVar, zzawr zzawrVar, Executor executor, zzfod zzfodVar, int i, zzaxg zzaxgVar, zzawy zzawyVar, zzawp zzawpVar) {
        this.zzq = false;
        this.zzc = context;
        this.zzh = zzfoiVar;
        this.zzd = zzfpvVar;
        this.zze = zzfqcVar;
        this.zzf = zzfqeVar;
        this.zzg = zzawrVar;
        this.zzi = executor;
        this.zzr = i;
        this.zzl = zzaxgVar;
        this.zzm = zzawyVar;
        this.zzn = zzawpVar;
        this.zzq = false;
        this.zzj = new zzavk(this, zzfodVar);
    }

    public static synchronized zzavm zza(Context context, zzarx zzarxVar, boolean z) {
        zzfoj zzfojVarZzc;
        zzfojVarZzc = zzfok.zzc();
        zzfojVarZzc.zza(zzarxVar.zzf());
        zzfojVarZzc.zzg(zzarxVar.zzi());
        return zzs(context, Executors.newCachedThreadPool(), zzfojVarZzc.zzh(), z);
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00d6 A[Catch: all -> 0x009e, zzgzw -> 0x00a1, TryCatch #0 {zzgzw -> 0x00a1, blocks: (B:6:0x0021, B:8:0x0033, B:12:0x0039, B:13:0x0045, B:15:0x0053, B:17:0x0061, B:20:0x006e, B:32:0x00a4, B:36:0x00bd, B:42:0x00d6, B:43:0x00e3, B:45:0x00e9, B:47:0x00f1, B:48:0x00f3, B:39:0x00c7, B:40:0x00ce, B:23:0x0075, B:25:0x008b, B:49:0x00fd, B:50:0x010a, B:51:0x0117), top: B:58:0x0021, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00fd A[Catch: all -> 0x009e, zzgzw -> 0x00a1, TryCatch #0 {zzgzw -> 0x00a1, blocks: (B:6:0x0021, B:8:0x0033, B:12:0x0039, B:13:0x0045, B:15:0x0053, B:17:0x0061, B:20:0x006e, B:32:0x00a4, B:36:0x00bd, B:42:0x00d6, B:43:0x00e3, B:45:0x00e9, B:47:0x00f1, B:48:0x00f3, B:39:0x00c7, B:40:0x00ce, B:23:0x0075, B:25:0x008b, B:49:0x00fd, B:50:0x010a, B:51:0x0117), top: B:58:0x0021, outer: #2 }] */
    public static void zzj(zzavm zzavmVar) {
        String str;
        String strZzj;
        int length;
        boolean zZza;
        long jCurrentTimeMillis = System.currentTimeMillis();
        zzfpu zzfpuVarZzu = zzavmVar.zzu(1);
        if (zzfpuVarZzu != null) {
            String strZzk = zzfpuVarZzu.zza().zzk();
            strZzj = zzfpuVarZzu.zza().zzj();
            str = strZzk;
        } else {
            str = null;
            strZzj = null;
        }
        try {
            try {
                Context context = zzavmVar.zzc;
                int i = zzavmVar.zzr;
                zzfoi zzfoiVar = zzavmVar.zzh;
                zzfpz zzfpzVarZza = zzfos.zza(context, 1, i, str, strZzj, "1", zzfoiVar);
                byte[] bArr = zzfpzVarZza.zzb;
                if (bArr == null || (length = bArr.length) == 0) {
                    zzfoiVar.zzd(5009, System.currentTimeMillis() - jCurrentTimeMillis);
                } else {
                    try {
                        zzayp zzaypVarZzb = zzayp.zzb(zzgxz.zzv(bArr, 0, length), zzgyr.zza());
                        if (zzaypVarZzb.zzc().zzk().isEmpty() || zzaypVarZzb.zzc().zzj().isEmpty() || zzaypVarZzb.zzd().zzA().length == 0) {
                            zzavmVar.zzh.zzd(5010, System.currentTimeMillis() - jCurrentTimeMillis);
                        } else {
                            zzfpu zzfpuVarZzu2 = zzavmVar.zzu(1);
                            if (zzfpuVarZzu2 != null) {
                                zzays zzaysVarZza = zzfpuVarZzu2.zza();
                                if (zzaypVarZzb.zzc().zzk().equals(zzaysVarZza.zzk()) && zzaypVarZzb.zzc().zzj().equals(zzaysVarZza.zzj())) {
                                    zzavmVar.zzh.zzd(5010, System.currentTimeMillis() - jCurrentTimeMillis);
                                }
                            }
                            zzfqb zzfqbVar = zzavmVar.zzj;
                            int i2 = zzfpzVarZza.zzc;
                            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcD)).booleanValue()) {
                                zZza = zzavmVar.zzd.zza(zzaypVarZzb, zzfqbVar);
                            } else if (i2 == 3) {
                                zZza = zzavmVar.zze.zza(zzaypVarZzb);
                            } else if (i2 == 4) {
                                zZza = zzavmVar.zze.zzb(zzaypVarZzb, zzfqbVar);
                            } else {
                                zzavmVar.zzh.zzd(4009, System.currentTimeMillis() - jCurrentTimeMillis);
                            }
                            if (zZza) {
                                zzfpu zzfpuVarZzu3 = zzavmVar.zzu(1);
                                if (zzfpuVarZzu3 != null) {
                                    if (zzavmVar.zzf.zzc(zzfpuVarZzu3)) {
                                        zzavmVar.zzq = true;
                                    }
                                    zzavmVar.zza = System.currentTimeMillis() / 1000;
                                }
                            } else {
                                zzavmVar.zzh.zzd(4009, System.currentTimeMillis() - jCurrentTimeMillis);
                            }
                        }
                    } catch (NullPointerException unused) {
                        zzavmVar.zzh.zzd(2030, System.currentTimeMillis() - jCurrentTimeMillis);
                    }
                }
            } finally {
                zzavmVar.zzk.countDown();
            }
        } catch (zzgzw e) {
            zzavmVar.zzh.zzc(4002, System.currentTimeMillis() - jCurrentTimeMillis, e);
        }
    }

    private static synchronized zzavm zzs(Context context, Executor executor, zzfok zzfokVar, boolean z) {
        try {
            if (zzb == null) {
                zzfoi zzfoiVarZza = zzfoi.zza(context, executor, z);
                zzbcv zzbcvVar = zzbde.zzdG;
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
                zzawa zzawaVarZzc = ((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() ? zzawa.zzc(context) : null;
                zzaxg zzaxgVarZzd = ((Boolean) zzbdVar.zzd.zzb(zzbde.zzdH)).booleanValue() ? zzaxg.zzd(context, executor) : null;
                zzawy zzawyVar = ((Boolean) zzbdVar.zzd.zzb(zzbde.zzcV)).booleanValue() ? new zzawy() : null;
                zzawp zzawpVar = ((Boolean) zzbdVar.zzd.zzb(zzbde.zzdd)).booleanValue() ? new zzawp() : null;
                zzfoz zzfozVarZzc = zzfoz.zzc(context, executor, zzfoiVarZza, zzfokVar);
                zzawq zzawqVar = new zzawq(context);
                zzawr zzawrVar = new zzawr(zzfokVar, zzfozVarZzc, new zzaxe(context, zzawqVar), zzawqVar, zzawaVarZzc, zzaxgVarZzd, zzawyVar, zzawpVar);
                int iZzb = zzfpi.zzb(context, zzfoiVarZza);
                zzfod zzfodVar = new zzfod();
                zzavm zzavmVar = new zzavm(context, zzfoiVarZza, new zzfpv(context, iZzb), new zzfqc(context, iZzb, new zzavj(zzfoiVarZza), ((Boolean) zzbdVar.zzd.zzb(zzbde.zzcF)).booleanValue()), new zzfqe(context, zzawrVar, zzfoiVarZza, zzfodVar, false), zzawrVar, executor, zzfodVar, iZzb, zzaxgVarZzd, zzawyVar, zzawpVar);
                zzb = zzavmVar;
                zzavmVar.zzm();
                zzb.zzp();
            }
        } catch (Throwable th) {
            throw th;
        }
        return zzb;
    }

    private final void zzt() {
        zzaxg zzaxgVar = this.zzl;
        if (zzaxgVar != null) {
            zzaxgVar.zzh();
        }
    }

    private final zzfpu zzu(int i) {
        if (zzfpi.zza(this.zzr)) {
            return ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcD)).booleanValue() ? this.zze.zzc(1) : this.zzd.zzc(1);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final String zzd(Context context, String str, View view) {
        return zze(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final String zze(Context context, String str, View view, Activity activity) {
        zzt();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcV)).booleanValue()) {
            this.zzm.zzi();
        }
        zzp();
        zzfol zzfolVarZza = this.zzf.zza();
        if (zzfolVarZza == null) {
            return "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strZza = zzfolVarZza.zza(context, null, str, view, activity);
        this.zzh.zzf(5000, System.currentTimeMillis() - jCurrentTimeMillis, strZza, null);
        return strZza;
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final String zzf(Context context) {
        zzt();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcV)).booleanValue()) {
            this.zzm.zzj();
        }
        zzp();
        zzfol zzfolVarZza = this.zzf.zza();
        if (zzfolVarZza == null) {
            return "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strZzc = zzfolVarZza.zzc(context, null);
        this.zzh.zzf(5001, System.currentTimeMillis() - jCurrentTimeMillis, strZzc, null);
        return strZzc;
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final String zzg(Context context) {
        return "19";
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final String zzh(Context context, View view, Activity activity) {
        zzt();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcV)).booleanValue()) {
            this.zzm.zzk(context, view);
        }
        zzp();
        zzfol zzfolVarZza = this.zzf.zza();
        if (zzfolVarZza == null) {
            return "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strZzb = zzfolVarZza.zzb(context, null, view, activity);
        this.zzh.zzf(5002, System.currentTimeMillis() - jCurrentTimeMillis, strZzb, null);
        return strZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final void zzk(MotionEvent motionEvent) {
        zzfol zzfolVarZza = this.zzf.zza();
        if (zzfolVarZza != null) {
            try {
                zzfolVarZza.zzd(null, motionEvent);
            } catch (zzfqd e) {
                this.zzh.zzc(e.zza(), -1L, e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final void zzl(int i, int i2, int i3) {
        DisplayMetrics displayMetrics;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzmt)).booleanValue() || (displayMetrics = this.zzc.getResources().getDisplayMetrics()) == null) {
            return;
        }
        float f = i;
        float f2 = displayMetrics.density;
        float f3 = i2;
        MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, 0, f * f2, f3 * f2, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        zzk(motionEventObtain);
        motionEventObtain.recycle();
        float f4 = displayMetrics.density;
        MotionEvent motionEventObtain2 = MotionEvent.obtain(0L, 0L, 2, f * f4, f3 * f4, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        zzk(motionEventObtain2);
        motionEventObtain2.recycle();
        float f5 = displayMetrics.density;
        MotionEvent motionEventObtain3 = MotionEvent.obtain(0L, i3, 1, f * f5, f3 * f5, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        zzk(motionEventObtain3);
        motionEventObtain3.recycle();
    }

    public final synchronized void zzm() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        zzfpu zzfpuVarZzu = zzu(1);
        if (zzfpuVarZzu == null) {
            this.zzh.zzd(4013, System.currentTimeMillis() - jCurrentTimeMillis);
        } else if (this.zzf.zzc(zzfpuVarZzu)) {
            this.zzq = true;
            this.zzk.countDown();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final void zzn(StackTraceElement[] stackTraceElementArr) {
        zzawp zzawpVar = this.zzn;
        if (zzawpVar != null) {
            zzawpVar.zzb(Arrays.asList(stackTraceElementArr));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final void zzo(View view) {
        this.zzg.zzd(view);
    }

    public final void zzp() {
        if (this.zzp) {
            return;
        }
        synchronized (this.zzo) {
            try {
                if (!this.zzp) {
                    if ((System.currentTimeMillis() / 1000) - this.zza < 3600) {
                        return;
                    }
                    zzfpu zzfpuVarZzb = this.zzf.zzb();
                    if ((zzfpuVarZzb == null || zzfpuVarZzb.zzd(3600L)) && zzfpi.zza(this.zzr)) {
                        this.zzi.execute(new zzavl(this));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized boolean zzr() {
        return this.zzq;
    }
}
