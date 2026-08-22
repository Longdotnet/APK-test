package com.google.android.gms.internal.auth;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.collection.ArrayMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzda implements zzck {
    private static final Map<String, zzda> zza = new ArrayMap();
    private final SharedPreferences zzb;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzc;

    public static zzda zza(Context context, String str) {
        zzda zzdaVar;
        if (zzcc.zza()) {
            throw null;
        }
        synchronized (zzda.class) {
            try {
                zzdaVar = zza.get(null);
                if (zzdaVar == null) {
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
        return zzdaVar;
    }

    public static synchronized void zzc() {
        Map<String, zzda> map = zza;
        Iterator<zzda> it = map.values().iterator();
        if (it.hasNext()) {
            SharedPreferences sharedPreferences = it.next().zzb;
            throw null;
        }
        map.clear();
    }

    @Override // com.google.android.gms.internal.auth.zzck
    public final Object zzb(String str) {
        throw null;
    }
}
