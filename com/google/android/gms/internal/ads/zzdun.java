package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.auth.api.LNi.xPQrbOSWiEdU;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdun {
    private final long zzd;
    private final Context zzf;
    private final WeakReference zzg;
    private final zzdpz zzh;
    private final Executor zzi;
    private final Executor zzj;
    private final ScheduledExecutorService zzk;
    private final zzdsu zzl;
    private final VersionInfoParcel zzm;
    private final zzddc zzo;
    private final zzfhx zzp;
    private boolean zza = false;
    private boolean zzb = false;
    private boolean zzc = false;
    private final zzcak zze = new zzcak();
    private final Map zzn = new ConcurrentHashMap();
    private boolean zzq = true;

    public zzdun(Executor executor, Context context, WeakReference weakReference, Executor executor2, zzdpz zzdpzVar, ScheduledExecutorService scheduledExecutorService, zzdsu zzdsuVar, VersionInfoParcel versionInfoParcel, zzddc zzddcVar, zzfhx zzfhxVar) {
        this.zzh = zzdpzVar;
        this.zzf = context;
        this.zzg = weakReference;
        this.zzi = executor2;
        this.zzk = scheduledExecutorService;
        this.zzj = executor;
        this.zzl = zzdsuVar;
        this.zzm = versionInfoParcel;
        this.zzo = zzddcVar;
        this.zzp = zzfhxVar;
        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
        this.zzd = SystemClock.elapsedRealtime();
        zzv("com.google.android.gms.ads.MobileAds", false, "", 0);
    }

    public static /* synthetic */ Object zzf(zzdun zzdunVar, zzfhj zzfhjVar) {
        zzdunVar.zze.zzc(Boolean.TRUE);
        zzfhjVar.zzg(true);
        zzdunVar.zzp.zzc(zzfhjVar.zzm());
        return null;
    }

    public static void zzi(zzdun zzdunVar, Object obj, zzcak zzcakVar, String str, long j, zzfhj zzfhjVar) {
        synchronized (obj) {
            try {
                if (!zzcakVar.isDone()) {
                    com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                    zzdunVar.zzv(str, false, "Timeout.", (int) (SystemClock.elapsedRealtime() - j));
                    zzdunVar.zzl.zzb(str, "timeout");
                    zzdunVar.zzo.zzb(str, "timeout");
                    zzfhx zzfhxVar = zzdunVar.zzp;
                    zzfhjVar.zzc("Timeout");
                    zzfhjVar.zzg(false);
                    zzfhxVar.zzc(zzfhjVar.zzm());
                    zzcakVar.zzc(Boolean.FALSE);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* synthetic */ void zzj(zzdun zzdunVar) {
        zzdunVar.zzl.zze();
        zzdunVar.zzo.zze();
        zzdunVar.zzb = true;
    }

    public static void zzl(zzdun zzdunVar) {
        synchronized (zzdunVar) {
            try {
                if (zzdunVar.zzc) {
                    return;
                }
                com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                zzdunVar.zzv("com.google.android.gms.ads.MobileAds", false, "Timeout.", (int) (SystemClock.elapsedRealtime() - zzdunVar.zzd));
                zzdunVar.zzl.zzb("com.google.android.gms.ads.MobileAds", "timeout");
                zzdunVar.zzo.zzb("com.google.android.gms.ads.MobileAds", "timeout");
                zzdunVar.zze.zzd(new Exception());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void zzo(final zzdun zzdunVar, String str) {
        Context context = zzdunVar.zzf;
        int i = 5;
        final zzfhj zzfhjVarZza = zzfhi.zza(context, 5);
        zzfhjVarZza.zzi();
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str).getJSONObject("initializer_settings").getJSONObject("config");
            Iterator itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                final String str2 = (String) itKeys.next();
                final zzfhj zzfhjVarZza2 = zzfhi.zza(context, i);
                zzfhjVarZza2.zzi();
                zzfhjVarZza2.zzd(str2);
                final Object obj = new Object();
                final zzcak zzcakVar = new zzcak();
                ListenableFuture listenableFutureZzo = zzgdn.zzo(zzcakVar, ((Long) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzca)).longValue(), TimeUnit.SECONDS, zzdunVar.zzk);
                zzdunVar.zzl.zzc(str2);
                zzdunVar.zzo.zzc(str2);
                com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                final long jElapsedRealtime = SystemClock.elapsedRealtime();
                Context context2 = context;
                JSONObject jSONObject2 = jSONObject;
                listenableFutureZzo.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdud
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzdun.zzi(this.zza, obj, zzcakVar, str2, jElapsedRealtime, zzfhjVarZza2);
                    }
                }, zzdunVar.zzi);
                arrayList.add(listenableFutureZzo);
                final zzdum zzdumVar = new zzdum(zzdunVar, obj, str2, jElapsedRealtime, zzfhjVarZza2, zzcakVar);
                JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject(str2);
                final ArrayList arrayList2 = new ArrayList();
                if (jSONObjectOptJSONObject != null) {
                    try {
                        JSONArray jSONArray = jSONObjectOptJSONObject.getJSONArray("data");
                        int i2 = 0;
                        while (i2 < jSONArray.length()) {
                            JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                            String strOptString = jSONObject3.optString("format", "");
                            JSONObject jSONObjectOptJSONObject2 = jSONObject3.optJSONObject("data");
                            Bundle bundle = new Bundle();
                            if (jSONObjectOptJSONObject2 != null) {
                                Iterator itKeys2 = jSONObjectOptJSONObject2.keys();
                                while (itKeys2.hasNext()) {
                                    String str3 = (String) itKeys2.next();
                                    bundle.putString(str3, jSONObjectOptJSONObject2.optString(str3, ""));
                                    jSONArray = jSONArray;
                                }
                            }
                            JSONArray jSONArray2 = jSONArray;
                            arrayList2.add(new zzbmn(strOptString, bundle));
                            i2++;
                            jSONArray = jSONArray2;
                        }
                    } catch (JSONException unused) {
                    }
                }
                zzdunVar.zzv(str2, false, "", 0);
                try {
                    final zzfdu zzfduVarZzc = zzdunVar.zzh.zzc(str2, new JSONObject());
                    zzdunVar.zzj.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdui
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzdun.zzm(this.zza, str2, zzdumVar, zzfduVarZzc, arrayList2);
                        }
                    });
                } catch (zzfdd e) {
                    try {
                        String str4 = "Failed to create Adapter.";
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzns)).booleanValue()) {
                            str4 = "Failed to create Adapter. " + e.getMessage();
                        }
                        zzdumVar.zze(str4);
                    } catch (RemoteException e2) {
                        int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzh("", e2);
                    }
                }
                jSONObject = jSONObject2;
                context = context2;
                i = 5;
            }
            zzgdn.zza(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdue
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    zzdun.zzf(this.zza, zzfhjVarZza);
                    return null;
                }
            }, zzdunVar.zzi);
        } catch (JSONException e3) {
            com.google.android.gms.ads.internal.util.zze.zzb("Malformed CLD response", e3);
            zzdunVar.zzo.zza("MalformedJson");
            zzdunVar.zzl.zza("MalformedJson");
            zzdunVar.zze.zzd(e3);
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e3, "AdapterInitializer.updateAdapterStatus");
            zzfhx zzfhxVar = zzdunVar.zzp;
            zzfhjVarZza.zzh(e3);
            zzfhjVarZza.zzg(false);
            zzfhxVar.zzc(zzfhjVarZza.zzm());
        }
    }

    private final synchronized ListenableFuture zzu() {
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        String strZzc = ((com.google.android.gms.ads.internal.util.zzj) zzvVar.zzi.zzi()).zzg().zzc();
        if (!TextUtils.isEmpty(strZzc)) {
            return zzgdn.zzh(strZzc);
        }
        final zzcak zzcakVar = new zzcak();
        com.google.android.gms.ads.internal.util.zzg zzgVarZzi = zzvVar.zzi.zzi();
        ((com.google.android.gms.ads.internal.util.zzj) zzgVarZzi).zzc.add(new Runnable() { // from class: com.google.android.gms.internal.ads.zzduf
            @Override // java.lang.Runnable
            public final void run() {
                zzdun zzdunVar = this.zza;
                zzdunVar.zzi.execute(new Runnable(zzdunVar, zzcakVar) { // from class: com.google.android.gms.internal.ads.zzduh
                    public final /* synthetic */ zzcak zza;

                    {
                        this.zza = zzcakVar;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        String strZzc2 = ((com.google.android.gms.ads.internal.util.zzj) com.google.android.gms.ads.internal.zzv.zza.zzi.zzi()).zzg().zzc();
                        boolean zIsEmpty = TextUtils.isEmpty(strZzc2);
                        zzcak zzcakVar2 = this.zza;
                        if (zIsEmpty) {
                            zzcakVar2.zzd(new Exception());
                        } else {
                            zzcakVar2.zzc(strZzc2);
                        }
                    }
                });
            }
        });
        return zzcakVar;
    }

    public final void zzv(String str, boolean z, String str2, int i) {
        this.zzn.put(str, new zzbmd(str, z, i, str2));
    }

    public final List zzg() {
        ArrayList arrayList = new ArrayList();
        Map map = this.zzn;
        for (String str : map.keySet()) {
            zzbmd zzbmdVar = (zzbmd) map.get(str);
            arrayList.add(new zzbmd(str, zzbmdVar.zzb, zzbmdVar.zzc, zzbmdVar.zzd));
        }
        return arrayList;
    }

    public final void zzq() {
        this.zzq = false;
    }

    public final void zzr() {
        if (!((Boolean) zzbfk.zza.zze()).booleanValue()) {
            int i = this.zzm.clientJarVersion;
            zzbcv zzbcvVar = zzbde.zzbZ;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
            if (i >= ((Integer) zzbdVar.zzd.zzb(zzbcvVar)).intValue() && this.zzq) {
                if (this.zza) {
                    return;
                }
                synchronized (this) {
                    try {
                        if (this.zza) {
                            return;
                        }
                        this.zzl.zzf();
                        this.zzo.zzf();
                        zzcak zzcakVar = this.zze;
                        Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzduj
                            @Override // java.lang.Runnable
                            public final void run() {
                                zzdun.zzj(this.zza);
                            }
                        };
                        Executor executor = this.zzi;
                        zzcakVar.addListener(runnable, executor);
                        this.zza = true;
                        ListenableFuture listenableFutureZzu = zzu();
                        this.zzk.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzduc
                            @Override // java.lang.Runnable
                            public final void run() {
                                zzdun.zzl(this.zza);
                            }
                        }, ((Long) zzbdVar.zzd.zzb(zzbde.zzcb)).longValue(), TimeUnit.SECONDS);
                        zzgdn.zzr(listenableFutureZzu, new zzdul(this), executor);
                        return;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
        if (this.zza) {
            return;
        }
        zzv("com.google.android.gms.ads.MobileAds", true, "", 0);
        this.zze.zzc(Boolean.FALSE);
        this.zza = true;
        this.zzb = true;
    }

    public final void zzs(final zzbmk zzbmkVar) {
        this.zze.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdug
            @Override // java.lang.Runnable
            public final void run() {
                zzdun zzdunVar = this.zza;
                try {
                    zzbmkVar.zzb(zzdunVar.zzg());
                } catch (RemoteException e) {
                    int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
                }
            }
        }, this.zzj);
    }

    public final boolean zzt() {
        return this.zzb;
    }

    public static /* synthetic */ void zzm(zzdun zzdunVar, String str, zzbmh zzbmhVar, zzfdu zzfduVar, List list) {
        try {
            try {
                if (Objects.equals(str, xPQrbOSWiEdU.FsNyNJtyh)) {
                    zzbmhVar.zzf();
                    return;
                }
                Context context = (Context) zzdunVar.zzg.get();
                if (context == null) {
                    context = zzdunVar.zzf;
                }
                zzfduVar.zzi(context, zzbmhVar, list);
            } catch (RemoteException e) {
                throw new zzfwn(e);
            } catch (zzfdd unused) {
                zzbmhVar.zze("Failed to initialize adapter. " + str + " does not implement the initialize() method.");
            }
        } catch (RemoteException e2) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e2);
        }
    }
}
