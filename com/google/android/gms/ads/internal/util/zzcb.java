package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbde;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzcb {
    public final HashMap zza = new HashMap();
    public final ArrayList zzb = new ArrayList();
    public final Context zzc;

    public zzcb(Context context) {
        this.zzc = context;
    }

    public final void zzc() {
        zzbcv zzbcvVar = zzbde.zzkQ;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
            HashMap mapZzw = zzs.zzw((String) zzbdVar.zzd.zzb(zzbde.zzkV));
            for (String str : mapZzw.keySet()) {
                synchronized (this) {
                    try {
                        HashMap map = this.zza;
                        if (!map.containsKey(str)) {
                            SharedPreferences defaultSharedPreferences = Objects.equals(str, "__default__") ? PreferenceManager.getDefaultSharedPreferences(this.zzc) : this.zzc.getSharedPreferences(str, 0);
                            zzca zzcaVar = new zzca(this, str);
                            map.put(str, zzcaVar);
                            defaultSharedPreferences.registerOnSharedPreferenceChangeListener(zzcaVar);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            zzd(new zzbz(mapZzw));
        }
    }

    public final synchronized void zzd(zzbz zzbzVar) {
        this.zzb.add(zzbzVar);
    }
}
