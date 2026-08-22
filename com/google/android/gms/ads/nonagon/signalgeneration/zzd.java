package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.text.jp.CyjpdoedCdLTIO;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class zzd {
    public SharedPreferences zza;
    public SharedPreferences.Editor zzb;
    public final Context zzc;
    public final Object zzd = new Object();

    public zzd(Context context) {
        this.zzc = context;
    }

    public final int zza() {
        int i;
        zzk();
        synchronized (this.zzd) {
            i = this.zza.getInt("aav", -1);
        }
        return i;
    }

    public final int zzb() {
        int i;
        zzk();
        synchronized (this.zzd) {
            i = this.zza.getInt("vc", -1);
        }
        return i;
    }

    public final String zzc(String str) {
        String string;
        zzk();
        synchronized (this.zzd) {
            string = this.zza.getString(str, null);
            this.zzb.remove(str).commit();
        }
        return string;
    }

    public final String zzd() {
        String string;
        zzk();
        synchronized (this.zzd) {
            string = this.zza.getString("dm", null);
        }
        return string;
    }

    public final HashMap zzf() {
        HashMap map;
        zzk();
        synchronized (this.zzd) {
            try {
                Map<String, ?> all = this.zza.getAll();
                map = new HashMap();
                for (Map.Entry<String, ?> entry : all.entrySet()) {
                    if ((entry.getValue() instanceof String) && !Objects.equals(entry.getKey(), "pn") && !Objects.equals(entry.getKey(), "vc") && !Objects.equals(entry.getKey(), "dm") && !Objects.equals(entry.getKey(), "aav")) {
                        map.put(entry.getKey(), (String) entry.getValue());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return map;
    }

    public final void zzg() {
        zzk();
        synchronized (this.zzd) {
            this.zzb.clear().commit();
        }
    }

    public final void zzk() {
        synchronized (this.zzd) {
            try {
                if (this.zza != null) {
                    return;
                }
                SharedPreferences sharedPreferences = this.zzc.getSharedPreferences("query_info_shared_prefs", 0);
                this.zza = sharedPreferences;
                this.zzb = sharedPreferences.edit();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzi(int i, int i2, String str, String str2) {
        zzk();
        synchronized (this.zzd) {
            this.zzb.putString("pn", str).putInt("vc", i).putString("dm", str2).putInt(CyjpdoedCdLTIO.ZcQTHWwFuU, i2).commit();
        }
    }
}
