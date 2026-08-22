package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.Hex;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzeab extends zzbvd {
    private final Context zza;
    private final zzgdy zzb;
    private final zzeaj zzc;
    private final zzcld zzd;
    private final ArrayDeque zze;
    private final zzfhx zzf;
    private final zzbvy zzg;

    public zzeab(Context context, zzgdy zzgdyVar, zzbvy zzbvyVar, zzcld zzcldVar, zzeaj zzeajVar, ArrayDeque arrayDeque, zzeag zzeagVar, zzfhx zzfhxVar) {
        zzbde.zza(context);
        this.zza = context;
        this.zzb = zzgdyVar;
        this.zzg = zzbvyVar;
        this.zzc = zzeajVar;
        this.zzd = zzcldVar;
        this.zze = arrayDeque;
        this.zzf = zzfhxVar;
    }

    public static /* synthetic */ InputStream zzk(zzeab zzeabVar, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, zzbvq zzbvqVar, zzfhj zzfhjVar) {
        String strZze = ((zzbvs) listenableFuture.get()).zze();
        zzeabVar.zzo(new zzdzy((zzbvs) listenableFuture.get(), (JSONObject) listenableFuture2.get(), zzbvqVar.zzh, strZze, zzfhjVar));
        return new ByteArrayInputStream(strZze.getBytes(StandardCharsets.UTF_8));
    }

    private final synchronized zzdzy zzl(String str) {
        Iterator it = this.zze.iterator();
        while (it.hasNext()) {
            zzdzy zzdzyVar = (zzdzy) it.next();
            if (zzdzyVar.zzc.equals(str)) {
                it.remove();
                return zzdzyVar;
            }
        }
        return null;
    }

    private static ListenableFuture zzm(ListenableFuture listenableFuture, zzfha zzfhaVar, zzbow zzbowVar, zzfhu zzfhuVar, zzfhj zzfhjVar) {
        zzbom zzbomVarZza = zzbowVar.zza("AFMA_getAdDictionary", zzbot.zza, new zzboo() { // from class: com.google.android.gms.internal.ads.zzdzs
            @Override // com.google.android.gms.internal.ads.zzboo
            public final Object zza(JSONObject jSONObject) {
                return new zzbvs(jSONObject);
            }
        });
        zzfht.zzd(listenableFuture, zzfhjVar);
        zzfgg zzfggVarZza = zzfhaVar.zzb(zzfgu.BUILD_URL, listenableFuture).zzf(zzbomVarZza).zza();
        zzfht.zzc(zzfggVarZza, zzfhuVar, zzfhjVar);
        return zzfggVarZza;
    }

    private static ListenableFuture zzn(final zzbvq zzbvqVar, zzfha zzfhaVar, final zzevf zzevfVar) {
        zzgcu zzgcuVar = new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdzm
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzevfVar.zzb().zza(com.google.android.gms.ads.internal.client.zzbb.zzb.zzc.zzn((Bundle) obj), zzbvqVar.zzm, false);
            }
        };
        return zzfhaVar.zzb(zzfgu.GMS_SIGNALS, zzgdn.zzh(zzbvqVar.zza)).zzf(zzgcuVar).zze(new zzfge() { // from class: com.google.android.gms.internal.ads.zzdzn
            @Override // com.google.android.gms.internal.ads.zzfge
            public final Object zza(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                com.google.android.gms.ads.internal.util.zze.zza("Ad request signals:");
                com.google.android.gms.ads.internal.util.zze.zza(jSONObject.toString(2));
                return jSONObject;
            }
        }).zza();
    }

    private final synchronized void zzo(zzdzy zzdzyVar) {
        zzp();
        this.zze.addLast(zzdzyVar);
    }

    private final synchronized void zzp() {
        int iIntValue = ((Long) zzbfl.zzb.zze()).intValue();
        while (true) {
            ArrayDeque arrayDeque = this.zze;
            if (arrayDeque.size() >= iIntValue) {
                arrayDeque.removeFirst();
            }
        }
    }

    private final void zzq(ListenableFuture listenableFuture, zzbvi zzbviVar, zzbvq zzbvqVar) {
        zzgdn.zzr(zzgdn.zzn(listenableFuture, new zzgcu(this) { // from class: com.google.android.gms.internal.ads.zzdzt
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) throws IOException {
                final InputStream inputStream = (InputStream) obj;
                ParcelFileDescriptor[] parcelFileDescriptorArrCreatePipe = ParcelFileDescriptor.createPipe();
                ParcelFileDescriptor parcelFileDescriptor = parcelFileDescriptorArrCreatePipe[0];
                final ParcelFileDescriptor parcelFileDescriptor2 = parcelFileDescriptorArrCreatePipe[1];
                zzcaf.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfdw
                    @Override // java.lang.Runnable
                    public final void run() {
                        InputStream inputStream2 = inputStream;
                        try {
                            try {
                                ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptor2);
                                try {
                                    Hex.copyStream(inputStream2, autoCloseOutputStream, false);
                                    autoCloseOutputStream.close();
                                    inputStream2.close();
                                } catch (Throwable th) {
                                    try {
                                        autoCloseOutputStream.close();
                                    } catch (Throwable th2) {
                                        th.addSuppressed(th2);
                                    }
                                    throw th;
                                }
                            } catch (IOException unused) {
                            }
                        } catch (Throwable th3) {
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Throwable th4) {
                                    th3.addSuppressed(th4);
                                }
                            }
                            throw th3;
                        }
                    }
                });
                return zzgdn.zzh(parcelFileDescriptor);
            }
        }, zzcaf.zza), new zzdzx(this, zzbvqVar, zzbviVar), zzcaf.zzg);
    }

    public final ListenableFuture zzb(final zzbvq zzbvqVar, int i) {
        if (!((Boolean) zzbfl.zza.zze()).booleanValue()) {
            return zzgdn.zzg(new Exception("Split request is disabled."));
        }
        zzfeq zzfeqVar = zzbvqVar.zzi;
        if (zzfeqVar == null) {
            return zzgdn.zzg(new Exception("Pool configuration missing from request."));
        }
        if (zzfeqVar.zzc == 0 || zzfeqVar.zzd == 0) {
            return zzgdn.zzg(new Exception("Caching is disabled."));
        }
        Context context = this.zza;
        zzbow zzbowVarZzb = com.google.android.gms.ads.internal.zzv.zza.zzs.zzb(context, VersionInfoParcel.forPackage(), this.zzf);
        zzevf zzevfVarZzq = this.zzd.zzq(zzbvqVar, i);
        zzfha zzfhaVarZze = zzevfVarZzq.zze();
        final ListenableFuture listenableFutureZzn = zzn(zzbvqVar, zzfhaVarZze, zzevfVarZzq);
        zzfhu zzfhuVarZzf = zzevfVarZzq.zzf();
        final zzfhj zzfhjVarZza = zzfhi.zza(context, 9);
        final ListenableFuture listenableFutureZzm = zzm(listenableFutureZzn, zzfhaVarZze, zzbowVarZzb, zzfhuVarZzf, zzfhjVarZza);
        return zzfhaVarZze.zza(zzfgu.GET_URL_AND_CACHE_KEY, listenableFutureZzn, listenableFutureZzm).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdzq
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzeab.zzk(this.zza, listenableFutureZzm, listenableFutureZzn, zzbvqVar, zzfhjVarZza);
            }
        }).zza();
    }

    public final ListenableFuture zzc(final zzbvq zzbvqVar, int i) {
        zzdzy zzdzyVarZzl;
        zzfgg zzfggVarZza;
        zzbon zzbonVar = com.google.android.gms.ads.internal.zzv.zza.zzs;
        Context context = this.zza;
        zzbow zzbowVarZzb = zzbonVar.zzb(context, VersionInfoParcel.forPackage(), this.zzf);
        zzevf zzevfVarZzq = this.zzd.zzq(zzbvqVar, i);
        zzbom zzbomVarZza = zzbowVarZzb.zza("google.afma.response.normalize", zzeaa.zza, zzbot.zzb);
        if (((Boolean) zzbfl.zza.zze()).booleanValue()) {
            zzdzyVarZzl = zzl(zzbvqVar.zzh);
            if (zzdzyVarZzl == null) {
                com.google.android.gms.ads.internal.util.zze.zza("Request contained a PoolKey but no matching parameters were found.");
            }
        } else {
            String str = zzbvqVar.zzj;
            zzdzyVarZzl = null;
            if (str != null && !str.isEmpty()) {
                com.google.android.gms.ads.internal.util.zze.zza("Request contained a PoolKey but split request is disabled.");
            }
        }
        zzfhj zzfhjVarZza = zzdzyVarZzl == null ? zzfhi.zza(context, 9) : zzdzyVarZzl.zzd;
        zzfhu zzfhuVarZzf = zzevfVarZzq.zzf();
        zzfhuVarZzf.zzd(zzbvqVar.zza.getStringArrayList("ad_types"));
        zzeai zzeaiVar = new zzeai(zzbvqVar.zzg, zzfhuVarZzf, zzfhjVarZza);
        zzeaf zzeafVar = new zzeaf(context, zzbvqVar.zzb.afmaVersion, this.zzg, i);
        zzfha zzfhaVarZze = zzevfVarZzq.zze();
        zzfhj zzfhjVarZza2 = zzfhi.zza(context, 11);
        if (zzdzyVarZzl == null) {
            final ListenableFuture listenableFutureZzn = zzn(zzbvqVar, zzfhaVarZze, zzevfVarZzq);
            final ListenableFuture listenableFutureZzm = zzm(listenableFutureZzn, zzfhaVarZze, zzbowVarZzb, zzfhuVarZzf, zzfhjVarZza);
            zzfhj zzfhjVarZza3 = zzfhi.zza(context, 10);
            final zzfgg zzfggVarZza2 = zzfhaVarZze.zza(zzfgu.HTTP, listenableFutureZzm, listenableFutureZzn).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdzo
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Bundle bundle;
                    zzbvs zzbvsVar = (zzbvs) listenableFutureZzm.get();
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcq)).booleanValue() && (bundle = zzbvqVar.zzm) != null) {
                        bundle.putLong(zzdrr.GET_AD_DICTIONARY_SDKCORE_START.zza(), zzbvsVar.zzc());
                        bundle.putLong(zzdrr.zzm.zza(), zzbvsVar.zzb());
                    }
                    return new zzeah((JSONObject) listenableFutureZzn.get(), zzbvsVar);
                }
            }).zze(zzeaiVar).zze(new zzfhp(zzfhjVarZza3)).zze(zzeafVar).zza();
            zzfht.zza(zzfggVarZza2, zzfhuVarZzf, zzfhjVarZza3);
            zzfht.zzd(zzfggVarZza2, zzfhjVarZza2);
            zzfggVarZza = zzfhaVarZze.zza(zzfgu.PRE_PROCESS, listenableFutureZzn, listenableFutureZzm, zzfggVarZza2).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdzp
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Bundle bundle;
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcq)).booleanValue() && (bundle = zzbvqVar.zzm) != null) {
                        CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, bundle, zzdrr.HTTP_RESPONSE_READY.zza());
                    }
                    return new zzeaa((zzeae) zzfggVarZza2.get(), (JSONObject) listenableFutureZzn.get(), (zzbvs) listenableFutureZzm.get());
                }
            }).zzf(zzbomVarZza).zza();
        } else {
            zzeah zzeahVar = new zzeah(zzdzyVarZzl.zzb, zzdzyVarZzl.zza);
            zzfhj zzfhjVarZza4 = zzfhi.zza(context, 10);
            final zzfgg zzfggVarZza3 = zzfhaVarZze.zzb(zzfgu.HTTP, zzgdn.zzh(zzeahVar)).zze(zzeaiVar).zze(new zzfhp(zzfhjVarZza4)).zze(zzeafVar).zza();
            zzfht.zza(zzfggVarZza3, zzfhuVarZzf, zzfhjVarZza4);
            final ListenableFuture listenableFutureZzh = zzgdn.zzh(zzdzyVarZzl);
            zzfht.zzd(zzfggVarZza3, zzfhjVarZza2);
            zzfggVarZza = zzfhaVarZze.zza(zzfgu.PRE_PROCESS, zzfggVarZza3, listenableFutureZzh).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdzl
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    zzeae zzeaeVar = (zzeae) zzfggVarZza3.get();
                    ListenableFuture listenableFuture = listenableFutureZzh;
                    return new zzeaa(zzeaeVar, ((zzdzy) listenableFuture.get()).zzb, ((zzdzy) listenableFuture.get()).zza);
                }
            }).zzf(zzbomVarZza).zza();
        }
        zzfht.zza(zzfggVarZza, zzfhuVarZzf, zzfhjVarZza2);
        return zzfggVarZza;
    }

    public final ListenableFuture zzd(final zzbvq zzbvqVar, int i) {
        zzbon zzbonVar = com.google.android.gms.ads.internal.zzv.zza.zzs;
        Context context = this.zza;
        zzbow zzbowVarZzb = zzbonVar.zzb(context, VersionInfoParcel.forPackage(), this.zzf);
        if (!((Boolean) zzbfq.zza.zze()).booleanValue()) {
            return zzgdn.zzg(new Exception("Signal collection disabled."));
        }
        zzevf zzevfVarZzq = this.zzd.zzq(zzbvqVar, i);
        final zzeuf zzeufVarZza = zzevfVarZzq.zza();
        zzbom zzbomVarZza = zzbowVarZzb.zza("google.afma.request.getSignals", zzbot.zza, zzbot.zzb);
        zzfhj zzfhjVarZza = zzfhi.zza(context, 22);
        zzfha zzfhaVarZze = zzevfVarZzq.zze();
        zzfgu zzfguVar = zzfgu.GET_SIGNALS;
        Bundle bundle = zzbvqVar.zza;
        zzfgg zzfggVarZza = zzfhaVarZze.zzb(zzfguVar, zzgdn.zzh(bundle)).zze(new zzfhp(zzfhjVarZza)).zzf(new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdzu
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzeufVarZza.zza(com.google.android.gms.ads.internal.client.zzbb.zzb.zzc.zzn((Bundle) obj), zzbvqVar.zzm, false);
            }
        }).zzb(zzfgu.JS_SIGNALS).zzf(zzbomVarZza).zza();
        zzfhu zzfhuVarZzf = zzevfVarZzq.zzf();
        zzfhuVarZzf.zzd(bundle.getStringArrayList("ad_types"));
        zzfhuVarZzf.zzf(bundle.getBundle("extras"));
        zzfht.zzb(zzfggVarZza, zzfhuVarZzf, zzfhjVarZza);
        if (((Boolean) zzbfe.zzf.zze()).booleanValue()) {
            zzeaj zzeajVar = this.zzc;
            Objects.requireNonNull(zzeajVar);
            zzfggVarZza.addListener(new zzdzr(zzeajVar), this.zzb);
        }
        return zzfggVarZza;
    }

    @Override // com.google.android.gms.internal.ads.zzbve
    public final void zze(zzbvq zzbvqVar, zzbvi zzbviVar) {
        zzq(zzb(zzbvqVar, Binder.getCallingUid()), zzbviVar, zzbvqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbve
    public final void zzf(zzbvq zzbvqVar, zzbvi zzbviVar) {
        Bundle bundle;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcq)).booleanValue() && (bundle = zzbvqVar.zzm) != null) {
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, bundle, zzdrr.SERVICE_CONNECTED.zza());
        }
        zzq(zzd(zzbvqVar, Binder.getCallingUid()), zzbviVar, zzbvqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbve
    public final void zzg(zzbvq zzbvqVar, zzbvi zzbviVar) {
        Bundle bundle;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcq)).booleanValue() && (bundle = zzbvqVar.zzm) != null) {
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, bundle, zzdrr.SERVICE_CONNECTED.zza());
        }
        ListenableFuture listenableFutureZzc = zzc(zzbvqVar, Binder.getCallingUid());
        zzq(listenableFutureZzc, zzbviVar, zzbvqVar);
        if (((Boolean) zzbfe.zze.zze()).booleanValue()) {
            zzeaj zzeajVar = this.zzc;
            Objects.requireNonNull(zzeajVar);
            listenableFutureZzc.addListener(new zzdzr(zzeajVar), this.zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbve
    public final void zzh(String str, zzbvi zzbviVar) {
        zzq(zzj(str), zzbviVar, null);
    }

    @Override // com.google.android.gms.internal.ads.zzbve
    public final void zzi(zzbva zzbvaVar, zzbvj zzbvjVar) {
        if (((Boolean) zzbfs.zza.zze()).booleanValue()) {
            this.zzd.zzD();
            String str = zzbvaVar.zza;
            zzgdn.zzr(zzgdn.zzh(null), new zzdzv(this, zzbvjVar, zzbvaVar), zzcaf.zzg);
        } else {
            try {
                zzbvjVar.zzf("", zzbvaVar);
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.zze.zzb("Service can't call client", e);
            }
        }
    }

    public final ListenableFuture zzj(String str) {
        if (((Boolean) zzbfl.zza.zze()).booleanValue()) {
            return zzl(str) == null ? zzgdn.zzg(new Exception("URL to be removed not found for cache key: ".concat(String.valueOf(str)))) : zzgdn.zzh(new zzdzw(this));
        }
        return zzgdn.zzg(new Exception("Split request is disabled."));
    }
}
