package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.collection.ArrayMap;
import com.google.android.gms.games.provider.NtJ.wsbWxekY;
import com.google.android.gms.measurement.internal.RVw.ZRqOdXiy;
import com.google.firebase.FirebaseApp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzyz {
    private static final Map zza = new ArrayMap();
    private static final Map zzb = new ArrayMap();

    public static String zza(String str) {
        zzyx zzyxVar;
        Map map = zza;
        synchronized (map) {
            zzyxVar = (zzyx) map.get(str);
        }
        if (zzyxVar != null) {
            return zzh(zzyxVar.zzb(), zzyxVar.zza(), zzyxVar.zzb().contains(":")).concat("emulator/auth/handler");
        }
        throw new IllegalStateException("Tried to get the emulator widget endpoint, but no emulator endpoint overrides found.");
    }

    public static String zzb(String str) {
        zzyx zzyxVar;
        Map map = zza;
        synchronized (map) {
            zzyxVar = (zzyx) map.get(str);
        }
        return (zzyxVar != null ? "".concat(zzh(zzyxVar.zzb(), zzyxVar.zza(), zzyxVar.zzb().contains(":"))) : "https://").concat("www.googleapis.com/identitytoolkit/v3/relyingparty");
    }

    public static String zzd(String str) {
        zzyx zzyxVar;
        Map map = zza;
        synchronized (map) {
            zzyxVar = (zzyx) map.get(str);
        }
        return (zzyxVar != null ? "".concat(zzh(zzyxVar.zzb(), zzyxVar.zza(), zzyxVar.zzb().contains(":"))) : "https://").concat("securetoken.googleapis.com/v1");
    }

    public static void zze(String str, zzyy zzyyVar) {
        Map map = zzb;
        synchronized (map) {
            try {
                if (map.containsKey(str)) {
                    ((List) map.get(str)).add(new WeakReference(zzyyVar));
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new WeakReference(zzyyVar));
                    map.put(str, arrayList);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void zzf(FirebaseApp firebaseApp, String str, int i) {
        String apiKey = firebaseApp.getOptions().getApiKey();
        Map map = zza;
        synchronized (map) {
            map.put(apiKey, new zzyx(str, i));
        }
        Map map2 = zzb;
        synchronized (map2) {
            try {
                if (map2.containsKey(apiKey)) {
                    Iterator it = ((List) map2.get(apiKey)).iterator();
                    boolean z = false;
                    while (it.hasNext()) {
                        zzyy zzyyVar = (zzyy) ((WeakReference) it.next()).get();
                        if (zzyyVar != null) {
                            zzyyVar.zzi();
                            z = true;
                        }
                    }
                    if (!z) {
                        zza.remove(apiKey);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean zzg(FirebaseApp firebaseApp) {
        return zza.containsKey(firebaseApp.getOptions().getApiKey());
    }

    public static String zzc(String str) {
        zzyx zzyxVar;
        Map map = zza;
        synchronized (map) {
            zzyxVar = (zzyx) map.get(str);
        }
        return (zzyxVar != null ? wsbWxekY.Gkm.concat(zzh(zzyxVar.zzb(), zzyxVar.zza(), zzyxVar.zzb().contains(":"))) : "https://").concat("identitytoolkit.googleapis.com/v2");
    }

    private static String zzh(String str, int i, boolean z) {
        if (z) {
            return "http://[" + str + "]:" + i + "/";
        }
        return ZRqOdXiy.ykyRfP + str + ":" + i + "/";
    }
}
