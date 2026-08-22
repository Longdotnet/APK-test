package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzeti implements zzeuc {
    public static final /* synthetic */ int zzb = 0;
    private static final zzetj zzc = new zzetj(new JSONArray().toString(), new Bundle());
    final String zza;
    private final zzgdy zzd;
    private final ScheduledExecutorService zze;
    private final zzeju zzf;
    private final Context zzg;
    private final zzfcw zzh;
    private final zzejq zzi;
    private final zzdpz zzj;
    private final zzdup zzk;
    private final int zzl;

    public zzeti(zzgdy zzgdyVar, ScheduledExecutorService scheduledExecutorService, String str, zzeju zzejuVar, Context context, zzfcw zzfcwVar, zzejq zzejqVar, zzdpz zzdpzVar, zzdup zzdupVar, int i) {
        this.zzd = zzgdyVar;
        this.zze = scheduledExecutorService;
        this.zza = str;
        this.zzf = zzejuVar;
        this.zzg = context;
        this.zzh = zzfcwVar;
        this.zzi = zzejqVar;
        this.zzj = zzdpzVar;
        this.zzk = zzdupVar;
        this.zzl = i;
    }

    public static ListenableFuture zzc(zzeti zzetiVar) {
        zzbcv zzbcvVar = zzbde.zzlq;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        String lowerCase = ((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() ? zzetiVar.zzh.zzf.toLowerCase(Locale.ROOT) : zzetiVar.zzh.zzf;
        final Bundle bundleZzg = ((Boolean) zzbdVar.zzd.zzb(zzbde.zzbP)).booleanValue() ? zzetiVar.zzk.zzg() : new Bundle();
        final ArrayList arrayList = new ArrayList();
        if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzbY)).booleanValue()) {
            zzetiVar.zzi(arrayList, zzetiVar.zzf.zza(zzetiVar.zza, lowerCase));
        } else {
            zzeju zzejuVar = zzetiVar.zzf;
            for (Map.Entry entry : ((zzfyt) zzejuVar.zzb(zzetiVar.zza, lowerCase)).entrySet()) {
                String str = (String) entry.getKey();
                arrayList.add(zzetiVar.zzg(str, (List) entry.getValue(), zzetiVar.zzf(str), true, true));
            }
            zzetiVar.zzi(arrayList, zzejuVar.zzc());
        }
        return zzgdn.zzb(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzetd
            @Override // java.util.concurrent.Callable
            public final Object call() {
                int i = zzeti.zzb;
                JSONArray jSONArray = new JSONArray();
                for (ListenableFuture listenableFuture : arrayList) {
                    if (((JSONObject) listenableFuture.get()) != null) {
                        jSONArray.put(listenableFuture.get());
                    }
                }
                if (jSONArray.length() == 0) {
                    return null;
                }
                return new zzetj(jSONArray.toString(), bundleZzg);
            }
        }, zzetiVar.zzd);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0024 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static ListenableFuture zzd(final zzeti zzetiVar, String str, final List list, final Bundle bundle, boolean z, boolean z2) {
        zzbrp zzbrpVarZzb;
        final zzcak zzcakVar = new zzcak();
        if (z2) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzbQ)).booleanValue()) {
                try {
                    zzbrpVarZzb = zzetiVar.zzj.zzb(str);
                } catch (RemoteException e) {
                    com.google.android.gms.ads.internal.util.zze.zzb("Couldn't create RTB adapter : ", e);
                    zzbrpVarZzb = null;
                }
            } else {
                zzejq zzejqVar = zzetiVar.zzi;
                zzejqVar.zzb(str);
                zzbrpVarZzb = zzejqVar.zza(str);
            }
        } else {
            zzbrpVarZzb = zzetiVar.zzj.zzb(str);
        }
        if (zzbrpVarZzb == null) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzbG)).booleanValue()) {
                throw null;
            }
            zzejx.zzb(str, zzcakVar);
        } else {
            com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
            final zzejx zzejxVar = new zzejx(str, zzbrpVarZzb, zzcakVar, SystemClock.elapsedRealtime());
            zzbcv zzbcvVar = zzbde.zzbL;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
            boolean zBooleanValue = ((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue();
            zzbdc zzbdcVar = zzbdVar.zzd;
            if (zBooleanValue) {
                zzetiVar.zze.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeth
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzejxVar.zzc();
                    }
                }, ((Long) zzbdcVar.zzb(zzbde.zzbE)).longValue(), TimeUnit.MILLISECONDS);
            }
            if (!z) {
                zzejxVar.zzd();
            } else if (((Boolean) zzbdcVar.zzb(zzbde.zzbS)).booleanValue()) {
                final zzbrp zzbrpVar = zzbrpVarZzb;
                zzetiVar.zzd.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzete
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzeti.zze(this.zza, zzbrpVar, bundle, list, zzejxVar, zzcakVar);
                    }
                });
            } else {
                zzetiVar.zzh(zzbrpVarZzb, bundle, list, zzejxVar);
            }
        }
        return zzcakVar;
    }

    public static /* synthetic */ void zze(zzeti zzetiVar, zzbrp zzbrpVar, Bundle bundle, List list, zzejx zzejxVar, zzcak zzcakVar) {
        try {
            zzetiVar.zzh(zzbrpVar, bundle, list, zzejxVar);
        } catch (RemoteException e) {
            zzcakVar.zzd(e);
        }
    }

    private final Bundle zzf(String str) {
        Bundle bundle = this.zzh.zzd.zzm;
        if (bundle != null) {
            return bundle.getBundle(str);
        }
        return null;
    }

    private final zzgde zzg(final String str, final List list, final Bundle bundle, final boolean z, final boolean z2) {
        zzgct zzgctVar = new zzgct() { // from class: com.google.android.gms.internal.ads.zzetf
            @Override // com.google.android.gms.internal.ads.zzgct
            public final ListenableFuture zza() {
                return zzeti.zzd(this.zza, str, list, bundle, z, z2);
            }
        };
        zzgdy zzgdyVar = this.zzd;
        zzgde zzgdeVarZzw = zzgde.zzw(zzgdn.zzk(zzgctVar, zzgdyVar));
        zzbcv zzbcvVar = zzbde.zzbL;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (!((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            zzgdeVarZzw = (zzgde) zzgdn.zzo(zzgdeVarZzw, ((Long) zzbdVar.zzd.zzb(zzbde.zzbE)).longValue(), TimeUnit.MILLISECONDS, this.zze);
        }
        return (zzgde) zzgdn.zze(zzgdeVarZzw, Throwable.class, new zzfve() { // from class: com.google.android.gms.internal.ads.zzetg
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                Throwable th = (Throwable) obj;
                int i = zzeti.zzb;
                int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                String str2 = str;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Error calling adapter: ".concat(String.valueOf(str2)));
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zznu)).booleanValue()) {
                    com.google.android.gms.ads.internal.zzv.zza.zzi.zzv(th, "rtbSignal.fetchRtbJsonInfo-".concat(String.valueOf(str2)));
                    return null;
                }
                com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(th, "rtbSignal.fetchRtbJsonInfo-".concat(String.valueOf(str2)));
                return null;
            }
        }, zzgdyVar);
    }

    private final void zzh(zzbrp zzbrpVar, Bundle bundle, List list, zzejx zzejxVar) {
        zzbrpVar.zzh(new ObjectWrapper(this.zzg), this.zza, bundle, (Bundle) list.get(0), this.zzh.zze, zzejxVar);
    }

    private final void zzi(List list, Map map) {
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            zzejy zzejyVar = (zzejy) ((Map.Entry) it.next()).getValue();
            String str = zzejyVar.zza;
            list.add(zzg(str, Collections.singletonList(zzejyVar.zze), zzf(str), zzejyVar.zzb, zzejyVar.zzc));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 32;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        if (this.zzl == 2) {
            return zzgdn.zzh(zzc);
        }
        zzfcw zzfcwVar = this.zzh;
        if (zzfcwVar.zzr) {
            if (!Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzbR)).split(",")).contains(MediaType.Companion.zzb(MediaType.Companion.zzc(zzfcwVar.zzd)))) {
                return zzgdn.zzh(zzc);
            }
        }
        return zzgdn.zzk(new zzgct() { // from class: com.google.android.gms.internal.ads.zzetc
            @Override // com.google.android.gms.internal.ads.zzgct
            public final ListenableFuture zza() {
                return zzeti.zzc(this.zza);
            }
        }, this.zzd);
    }
}
