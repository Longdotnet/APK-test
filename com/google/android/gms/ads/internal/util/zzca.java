package com.google.android.gms.ads.internal.util;

import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzca implements SharedPreferences.OnSharedPreferenceChangeListener {
    public final /* synthetic */ zzcb zza;
    public final String zzb;

    public zzca(zzcb zzcbVar, String str) {
        Objects.requireNonNull(zzcbVar);
        this.zza = zzcbVar;
        this.zzb = str;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        zzcb zzcbVar = this.zza;
        synchronized (zzcbVar) {
            try {
                for (zzbz zzbzVar : zzcbVar.zzb) {
                    String str2 = this.zzb;
                    HashMap map = zzbzVar.zza;
                    if (map.containsKey(str2) && ((Set) map.get(str2)).contains(str)) {
                        ((zzj) com.google.android.gms.ads.internal.zzv.zza.zzi.zzi()).zzE(false);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
