package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class zzbyt {
    private final Map zza = new HashMap();
    private final List zzb = new ArrayList();
    private final Context zzc;
    private final zzbyf zzd;

    public zzbyt(Context context, zzbyf zzbyfVar) {
        this.zzc = context;
        this.zzd = zzbyfVar;
    }

    public static /* synthetic */ void zzb(zzbyt zzbytVar, Map map, SharedPreferences sharedPreferences, String str, String str2) {
        if (map.containsKey(str) && ((Set) map.get(str)).contains(str2)) {
            zzbytVar.zzd.zzd();
        }
    }

    public final synchronized void zzc(String str) {
        try {
            Map map = this.zza;
            if (map.containsKey(str)) {
                return;
            }
            SharedPreferences defaultSharedPreferences = Objects.equals(str, "__default__") ? PreferenceManager.getDefaultSharedPreferences(this.zzc) : this.zzc.getSharedPreferences(str, 0);
            zzbys zzbysVar = new zzbys(this, str);
            map.put(str, zzbysVar);
            defaultSharedPreferences.registerOnSharedPreferenceChangeListener(zzbysVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzd(zzbyr zzbyrVar) {
        this.zzb.add(zzbyrVar);
    }
}
