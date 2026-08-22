package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import androidx.lifecycle.hSi.sgtsHsWT;
import androidx.work.impl.WorkerWrapper;
import com.android.billingclient.api.zzr;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbfj;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzdso;
import com.google.android.gms.internal.ads.zzgdy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;

/* JADX INFO: loaded from: classes2.dex */
public final class zzo {
    public final HashMap zza = new HashMap();
    public final HashMap zzb = new HashMap();
    public final Context zzc;
    public final zzdso zzd;
    public final zzgdy zze;

    public zzo(Context context, zzdso zzdsoVar, zzgdy zzgdyVar) {
        this.zzc = context;
        this.zzd = zzdsoVar;
        this.zze = zzgdyVar;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002f A[Catch: all -> 0x003f, TryCatch #0 {all -> 0x003f, blocks: (B:3:0x0001, B:5:0x0011, B:10:0x0027, B:12:0x002b, B:15:0x0032, B:17:0x0036, B:21:0x0049, B:25:0x0053, B:28:0x0072, B:29:0x0076, B:31:0x007c, B:20:0x0041, B:14:0x002f), top: B:37:0x0001 }] */
    public final synchronized void zzf(final boolean z, zzq zzqVar) {
        try {
            HashMap map = this.zza;
            Boolean boolValueOf = Boolean.valueOf(z);
            zzq zzqVar2 = (zzq) map.get(boolValueOf);
            final boolean z2 = true;
            if (zzqVar2 != null) {
                com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                if ((zzqVar2.zzc <= System.currentTimeMillis()) || zzqVar2.zza == null || zzqVar.zza != null) {
                    map.put(boolValueOf, zzqVar);
                }
            } else {
                map.put(boolValueOf, zzqVar);
            }
            long jLongValue = (zzqVar.zza != null ? (Long) zzbfj.zzf.zze() : (Long) zzbfj.zzg.zze()).longValue();
            if (zzqVar.zza != null) {
                z2 = false;
            }
            zzcaf.zzd.schedule(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzl
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzj(z, z2);
                }
            }, jLongValue, TimeUnit.SECONDS);
            HashMap map2 = this.zzb;
            List list = (List) map2.get(boolValueOf);
            map2.put(boolValueOf, new ArrayList());
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    zzi(zzqVar, (Pair) it.next(), false);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzg(Object obj, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
        zzcaf.zzf.execute(new WorkerWrapper.AnonymousClass1(this, obj, new Pair(queryInfoGenerationCallback, Long.valueOf(System.currentTimeMillis())), 12, false));
    }

    public final void zzh(boolean z) {
        HashMap map = this.zzb;
        Boolean boolValueOf = Boolean.valueOf(z);
        if (map.containsKey(boolValueOf)) {
            return;
        }
        map.put(boolValueOf, new ArrayList());
        this.zze.submit(new zzi(this, z, 1));
    }

    public final void zzi(zzq zzqVar, Pair pair, boolean z) {
        zzqVar.zze.set(true);
        QueryInfo queryInfo = zzqVar.zza;
        if (queryInfo != null) {
            ((QueryInfoGenerationCallback) pair.first).onSuccess(queryInfo);
        } else {
            ((QueryInfoGenerationCallback) pair.first).onFailure(zzqVar.zzb);
        }
        Pair pair2 = new Pair("se", "query_g");
        Pair pair3 = new Pair(sgtsHsWT.ifcAfZOhjMckV, "BANNER");
        Pair pair4 = new Pair("rtype", Integer.toString(6));
        Pair pair5 = new Pair("scar", "true");
        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
        MediaType.Companion.zzd(this.zzd, "sgpcr", pair2, pair3, pair4, pair5, new Pair("lat_ms", Long.toString(System.currentTimeMillis() - ((Long) pair.second).longValue())), new Pair("sgpc_h", Boolean.toString(z)), new Pair("sgpc_rs", Boolean.toString(queryInfo != null)));
    }

    public final synchronized void zzj(boolean z, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putString("query_info_type", "requester_type_6");
        bundle.putBoolean("accept_3p_cookie", z);
        HashMap map = this.zza;
        Boolean boolValueOf = Boolean.valueOf(z);
        zzq zzqVar = (zzq) map.get(boolValueOf);
        int i = 0;
        if (z2 && zzqVar != null) {
            i = zzqVar.zzd + 1;
        }
        zzq zzqVar2 = (zzq) map.get(boolValueOf);
        zzp zzpVar = new zzp(this, z, i, zzqVar2 == null ? null : Boolean.valueOf(zzqVar2.zze.get()), this.zzd);
        AdRequest adRequest = new AdRequest((AdRequest.Builder) new AdRequest.Builder().addNetworkExtrasBundle(bundle));
        if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzlz)).booleanValue()) {
            this.zze.submit(new zzr(this, adRequest, zzpVar, 6));
        } else {
            QueryInfo.generate(this.zzc, adRequest, zzpVar);
        }
    }
}
