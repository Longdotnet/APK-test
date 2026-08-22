package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzbys implements SharedPreferences.OnSharedPreferenceChangeListener {
    final /* synthetic */ zzbyt zza;
    private final String zzb;

    public zzbys(zzbyt zzbytVar, String str) {
        Objects.requireNonNull(zzbytVar);
        this.zza = zzbytVar;
        this.zzb = str;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        zzbyt zzbytVar = this.zza;
        synchronized (zzbytVar) {
            try {
                for (zzbyr zzbyrVar : zzbytVar.zzb) {
                    zzbyt.zzb(zzbyrVar.zza, zzbyrVar.zzb, sharedPreferences, this.zzb, str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
