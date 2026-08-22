package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.collection.ArrayMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzic implements zzhk {
    private static final Map zza = new ArrayMap();
    private final SharedPreferences zzb;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzc;

    public static zzic zza(Context context, String str, Runnable runnable) {
        zzic zzicVar;
        if (zzhb.zzb()) {
            throw null;
        }
        synchronized (zzic.class) {
            try {
                zzicVar = (zzic) zza.get(null);
                if (zzicVar == null) {
                    StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        throw null;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return zzicVar;
    }

    public static synchronized void zzc() {
        Map map = zza;
        Iterator it = map.values().iterator();
        if (it.hasNext()) {
            SharedPreferences sharedPreferences = ((zzic) it.next()).zzb;
            throw null;
        }
        map.clear();
    }

    @Override // com.google.android.gms.internal.measurement.zzhk
    public final Object zzb(String str) {
        throw null;
    }
}
