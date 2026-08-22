package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzedr {
    private final String zzc;
    private zzfcd zzd = null;
    private zzfca zze = null;
    private com.google.android.gms.ads.internal.client.zzv zzf = null;
    private final Map zzb = Collections.synchronizedMap(new HashMap());
    private final List zza = Collections.synchronizedList(new ArrayList());

    public zzedr(String str) {
        this.zzc = str;
    }

    private static String zzj(zzfca zzfcaVar) {
        return ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzdR)).booleanValue() ? zzfcaVar.zzap : zzfcaVar.zzw;
    }

    private final synchronized void zzk(zzfca zzfcaVar, int i) {
        Map map = this.zzb;
        String strZzj = zzj(zzfcaVar);
        if (map.containsKey(strZzj)) {
            return;
        }
        Bundle bundle = new Bundle();
        JSONObject jSONObject = zzfcaVar.zzv;
        Iterator itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String str = (String) itKeys.next();
            try {
                bundle.putString(str, jSONObject.getString(str));
            } catch (JSONException unused) {
            }
        }
        com.google.android.gms.ads.internal.client.zzv zzvVar = new com.google.android.gms.ads.internal.client.zzv(zzfcaVar.zzE, 0L, null, bundle, zzfcaVar.zzF, zzfcaVar.zzG, zzfcaVar.zzH, zzfcaVar.zzI);
        try {
            this.zza.add(i, zzvVar);
        } catch (IndexOutOfBoundsException e) {
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "AdapterResponseInfoCollector.addAdapterResponseInfoEntryAtLocation");
        }
        this.zzb.put(strZzj, zzvVar);
    }

    private final void zzl(zzfca zzfcaVar, long j, com.google.android.gms.ads.internal.client.zze zzeVar, boolean z) {
        Map map = this.zzb;
        String strZzj = zzj(zzfcaVar);
        if (map.containsKey(strZzj)) {
            if (this.zze == null) {
                this.zze = zzfcaVar;
            }
            com.google.android.gms.ads.internal.client.zzv zzvVar = (com.google.android.gms.ads.internal.client.zzv) map.get(strZzj);
            zzvVar.zzb = j;
            zzvVar.zzc = zzeVar;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzgX)).booleanValue() && z) {
                this.zzf = zzvVar;
            }
        }
    }

    public final com.google.android.gms.ads.internal.client.zzv zza() {
        return this.zzf;
    }

    public final zzcvr zzb() {
        return new zzcvr(this.zze, "", this, this.zzd, this.zzc);
    }

    public final List zzc() {
        return this.zza;
    }

    public final void zzd(zzfca zzfcaVar) {
        zzk(zzfcaVar, this.zza.size());
    }

    public final void zze(zzfca zzfcaVar) {
        Map map = this.zzb;
        Object obj = map.get(zzj(zzfcaVar));
        List list = this.zza;
        int iIndexOf = list.indexOf(obj);
        if (iIndexOf < 0 || iIndexOf >= map.size()) {
            iIndexOf = list.indexOf(this.zzf);
        }
        if (iIndexOf < 0 || iIndexOf >= map.size()) {
            return;
        }
        this.zzf = (com.google.android.gms.ads.internal.client.zzv) list.get(iIndexOf);
        while (true) {
            iIndexOf++;
            if (iIndexOf >= list.size()) {
                return;
            }
            com.google.android.gms.ads.internal.client.zzv zzvVar = (com.google.android.gms.ads.internal.client.zzv) list.get(iIndexOf);
            zzvVar.zzb = 0L;
            zzvVar.zzc = null;
        }
    }

    public final void zzf(zzfca zzfcaVar, long j, com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzl(zzfcaVar, j, zzeVar, false);
    }

    public final void zzg(zzfca zzfcaVar, long j, com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzl(zzfcaVar, j, null, true);
    }

    public final synchronized void zzh(String str, List list) {
        try {
            Map map = this.zzb;
            if (map.containsKey(str)) {
                com.google.android.gms.ads.internal.client.zzv zzvVar = (com.google.android.gms.ads.internal.client.zzv) map.get(str);
                List list2 = this.zza;
                int iIndexOf = list2.indexOf(zzvVar);
                try {
                    list2.remove(iIndexOf);
                } catch (IndexOutOfBoundsException e) {
                    com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "AdapterResponseInfoCollector.replaceAdapterResponseInfoEntry");
                }
                this.zzb.remove(str);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    zzk((zzfca) it.next(), iIndexOf);
                    iIndexOf++;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void zzi(zzfcd zzfcdVar) {
        this.zzd = zzfcdVar;
    }
}
