package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.ProfileCache;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.internal.ads.zzarv;
import com.google.android.gms.internal.ads.zzarx;
import com.google.android.gms.internal.ads.zzavi;
import com.google.android.gms.internal.ads.zzavm;
import com.google.android.gms.internal.ads.zzavp;
import com.google.android.gms.internal.ads.zzavr;
import com.google.android.gms.internal.ads.zzavt;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbdc;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzfoi;
import com.google.android.gms.internal.ads.zzfpi;
import com.google.android.gms.internal.ads.zzfqc;
import com.google.android.gms.internal.ads.zzgdn;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzk implements Runnable, zzavp {
    public static final long zzc = System.currentTimeMillis();
    public boolean zza;
    public final boolean zzg;
    public final boolean zzh;
    public final ExecutorService zzi;
    public final zzfoi zzj;
    public Context zzk;
    public final Context zzl;
    public VersionInfoParcel zzm;
    public final VersionInfoParcel zzn;
    public final boolean zzo;
    public int zzp;
    public final Vector zzd = new Vector();
    public final AtomicReference zze = new AtomicReference();
    public final AtomicReference zzf = new AtomicReference();
    public final CountDownLatch zzb = new CountDownLatch(1);

    public zzk(Context context, VersionInfoParcel versionInfoParcel) {
        this.zzk = context;
        this.zzl = context;
        this.zzm = versionInfoParcel;
        this.zzn = versionInfoParcel;
        ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool();
        this.zzi = executorServiceNewCachedThreadPool;
        zzbcv zzbcvVar = zzbde.zzcH;
        zzbd zzbdVar = zzbd.zza;
        boolean zBooleanValue = ((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue();
        this.zzo = zBooleanValue;
        this.zzj = zzfoi.zza(context, executorServiceNewCachedThreadPool, zBooleanValue);
        zzbcv zzbcvVar2 = zzbde.zzcE;
        zzbdc zzbdcVar = zzbdVar.zzd;
        this.zzg = ((Boolean) zzbdcVar.zzb(zzbcvVar2)).booleanValue();
        this.zzh = ((Boolean) zzbdcVar.zzb(zzbde.zzcI)).booleanValue();
        if (((Boolean) zzbdcVar.zzb(zzbde.zzcG)).booleanValue()) {
            this.zzp = 2;
        } else {
            this.zzp = 1;
        }
        if (!((Boolean) zzbdcVar.zzb(zzbde.zzdK)).booleanValue()) {
            this.zza = zzi();
        }
        if (((Boolean) zzbdcVar.zzb(zzbde.zzdE)).booleanValue()) {
            zzcaf.zza.execute(this);
            return;
        }
        zzf zzfVar = zzbb.zzb.zzc;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            zzcaf.zza.execute(this);
        } else {
            run();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        CountDownLatch countDownLatch = this.zzb;
        try {
            zzbcv zzbcvVar = zzbde.zzdK;
            zzbd zzbdVar = zzbd.zza;
            if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
                this.zza = zzi();
            }
            boolean z = this.zzm.isClientJar;
            boolean z2 = false;
            if (!((Boolean) zzbdVar.zzd.zzb(zzbde.zzbj)).booleanValue() && z) {
                z2 = true;
            }
            if (((!this.zzg || this.zza) ? this.zzp : 1) == 1) {
                zzs(z2);
                if (this.zzp == 2) {
                    this.zzi.execute(new zzi(this, z2, 0));
                }
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                try {
                    Context context = this.zzk;
                    VersionInfoParcel versionInfoParcel = this.zzm;
                    boolean z3 = this.zzo;
                    zzarv zzarvVarZza = zzarx.zza();
                    zzarvVarZza.zza(z2);
                    zzarvVarZza.zzb(versionInfoParcel.afmaVersion);
                    zzarx zzarxVar = (zzarx) zzarvVarZza.zzbr();
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                    zzavm zzavmVarZza = zzavm.zza(context, zzarxVar, z3);
                    this.zzf.set(zzavmVarZza);
                    if (this.zzh && !zzavmVarZza.zzr()) {
                        this.zzp = 1;
                        zzs(z2);
                    }
                } catch (NullPointerException e) {
                    this.zzp = 1;
                    zzs(z2);
                    this.zzj.zzc(2031, System.currentTimeMillis() - jCurrentTimeMillis, e);
                }
            }
            countDownLatch.countDown();
            this.zzk = null;
            this.zzm = null;
        } catch (Throwable th) {
            countDownLatch.countDown();
            this.zzk = null;
            this.zzm = null;
            throw th;
        }
    }

    public final String zzb(Context context) {
        zzavp zzavpVarZzq;
        if (!zzj() || (zzavpVarZzq = zzq()) == null) {
            return "";
        }
        zzr();
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        return zzavpVarZzq.zzf(context);
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final String zzd(Context context, String str, View view) {
        return zze(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final String zze(Context context, String str, View view, Activity activity) {
        if (!zzj()) {
            return "";
        }
        zzavp zzavpVarZzq = zzq();
        if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzld)).booleanValue()) {
            zzs zzsVar = zzv.zza.zzd;
            zzs.zzK(view, 4);
        }
        if (zzavpVarZzq == null) {
            return "";
        }
        zzr();
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        return zzavpVarZzq.zze(context, str, view, activity);
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final String zzf(Context context) {
        return zzb(context);
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final String zzg(Context context) {
        try {
            return (String) zzgdn.zzj(new zzh(this, context, 0, false), this.zzi).get(((Integer) zzbd.zza.zzd.zzb(zzbde.zzcY)).intValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException unused) {
            return Integer.toString(17);
        } catch (TimeoutException unused2) {
            return zzavi.zza(context, this.zzn.afmaVersion, zzc, true);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final String zzh(Context context, View view, Activity activity) {
        zzbcv zzbcvVar = zzbde.zzlc;
        zzbd zzbdVar = zzbd.zza;
        boolean zBooleanValue = ((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue();
        zzbdc zzbdcVar = zzbdVar.zzd;
        if (!zBooleanValue) {
            zzavp zzavpVarZzq = zzq();
            if (((Boolean) zzbdcVar.zzb(zzbde.zzld)).booleanValue()) {
                zzs zzsVar = zzv.zza.zzd;
                zzs.zzK(view, 2);
            }
            return zzavpVarZzq != null ? zzavpVarZzq.zzh(context, view, activity) : "";
        }
        if (!zzj()) {
            return "";
        }
        zzavp zzavpVarZzq2 = zzq();
        if (((Boolean) zzbdcVar.zzb(zzbde.zzld)).booleanValue()) {
            zzs zzsVar2 = zzv.zza.zzd;
            zzs.zzK(view, 2);
        }
        return zzavpVarZzq2 != null ? zzavpVarZzq2.zzh(context, view, activity) : "";
    }

    public final boolean zzi() {
        Context context = this.zzk;
        ProfileCache profileCache = new ProfileCache(this);
        return new zzfqc(this.zzk, zzfpi.zzb(context, this.zzj), profileCache, ((Boolean) zzbd.zza.zzd.zzb(zzbde.zzcF)).booleanValue()).zzd(1);
    }

    public final boolean zzj() {
        try {
            this.zzb.await();
            return true;
        } catch (InterruptedException e) {
            int i = zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Interrupted during GADSignals creation.", e);
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final void zzk(MotionEvent motionEvent) {
        zzavp zzavpVarZzq = zzq();
        if (zzavpVarZzq == null) {
            this.zzd.add(new Object[]{motionEvent});
        } else {
            zzr();
            zzavpVarZzq.zzk(motionEvent);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final void zzl(int i, int i2, int i3) {
        zzavp zzavpVarZzq = zzq();
        if (zzavpVarZzq == null) {
            this.zzd.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        } else {
            zzr();
            zzavpVarZzq.zzl(i, i2, i3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final void zzn(StackTraceElement[] stackTraceElementArr) {
        zzavp zzavpVarZzq;
        zzavp zzavpVarZzq2;
        if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzde)).booleanValue()) {
            if (this.zzb.getCount() != 0 || (zzavpVarZzq2 = zzq()) == null) {
                return;
            }
            zzavpVarZzq2.zzn(stackTraceElementArr);
            return;
        }
        if (!zzj() || (zzavpVarZzq = zzq()) == null) {
            return;
        }
        zzavpVarZzq.zzn(stackTraceElementArr);
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final void zzo(View view) {
        zzavp zzavpVarZzq = zzq();
        if (zzavpVarZzq != null) {
            zzavpVarZzq.zzo(view);
        }
    }

    public final zzavp zzq() {
        return ((!this.zzg || this.zza) ? this.zzp : 1) == 2 ? (zzavp) this.zzf.get() : (zzavp) this.zze.get();
    }

    public final void zzr() {
        Vector<Object[]> vector = this.zzd;
        zzavp zzavpVarZzq = zzq();
        if (vector.isEmpty() || zzavpVarZzq == null) {
            return;
        }
        for (Object[] objArr : vector) {
            int length = objArr.length;
            if (length == 1) {
                zzavpVarZzq.zzk((MotionEvent) objArr[0]);
            } else if (length == 3) {
                zzavpVarZzq.zzl(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
            }
        }
        vector.clear();
    }

    public final void zzs(boolean z) {
        String str = this.zzm.afmaVersion;
        Context context = this.zzk;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        zzarv zzarvVarZza = zzarx.zza();
        zzarvVarZza.zza(z);
        zzarvVarZza.zzb(str);
        this.zze.set(zzavt.zzt(context, new zzavr((zzarx) zzarvVarZza.zzbr())));
    }
}
