package com.google.android.gms.internal.auth;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzcg implements zzck {
    private final ContentResolver zzc;
    private final Uri zzd;
    private final ContentObserver zze;
    private final Object zzf;
    private volatile Map<String, String> zzg;
    private final List<zzch> zzh;
    private static final Map<Uri, zzcg> zzb = new ArrayMap();
    public static final String[] zza = {"key", FirebaseAnalytics.Param.VALUE};

    private zzcg(ContentResolver contentResolver, Uri uri) {
        zzcf zzcfVar = new zzcf(this, null);
        this.zze = zzcfVar;
        this.zzf = new Object();
        this.zzh = new ArrayList();
        contentResolver.getClass();
        uri.getClass();
        this.zzc = contentResolver;
        this.zzd = uri;
        contentResolver.registerContentObserver(uri, false, zzcfVar);
    }

    public static zzcg zza(ContentResolver contentResolver, Uri uri) {
        zzcg zzcgVar;
        synchronized (zzcg.class) {
            Map<Uri, zzcg> map = zzb;
            zzcgVar = map.get(uri);
            if (zzcgVar == null) {
                try {
                    zzcg zzcgVar2 = new zzcg(contentResolver, uri);
                    try {
                        map.put(uri, zzcgVar2);
                    } catch (SecurityException unused) {
                    }
                    zzcgVar = zzcgVar2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return zzcgVar;
    }

    public static synchronized void zzd() {
        try {
            for (zzcg zzcgVar : zzb.values()) {
                zzcgVar.zzc.unregisterContentObserver(zzcgVar.zze);
            }
            zzb.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v9 */
    @Override // com.google.android.gms.internal.auth.zzck
    public final /* bridge */ /* synthetic */ Object zzb(String str) {
        ?? r0;
        Map<String, String> map;
        Map<String, String> map2 = this.zzg;
        Map mapEmptyMap = map2;
        if (map2 == null) {
            synchronized (this.zzf) {
                Map<String, String> map3 = this.zzg;
                r0 = map3;
                if (map3 == null) {
                    StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        try {
                            map = (Map) zzci.zza(new zzcj() { // from class: com.google.android.gms.internal.auth.zzce
                                @Override // com.google.android.gms.internal.auth.zzcj
                                public final Object zza() {
                                    return this.zza.zzc();
                                }
                            });
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        } catch (SQLiteException | IllegalStateException | SecurityException unused) {
                            Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                            map = null;
                        }
                        this.zzg = map;
                        threadPolicyAllowThreadDiskReads = map;
                        r0 = threadPolicyAllowThreadDiskReads;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        throw th;
                    }
                }
            }
            mapEmptyMap = r0;
        }
        if (mapEmptyMap == 0) {
            mapEmptyMap = Collections.emptyMap();
        }
        return (String) mapEmptyMap.get(str);
    }

    public final /* synthetic */ Map zzc() {
        Cursor cursorQuery = this.zzc.query(this.zzd, zza, null, null, null);
        if (cursorQuery == null) {
            return Collections.emptyMap();
        }
        try {
            int count = cursorQuery.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            Map arrayMap = count <= 256 ? new ArrayMap(count) : new HashMap(count, 1.0f);
            while (cursorQuery.moveToNext()) {
                arrayMap.put(cursorQuery.getString(0), cursorQuery.getString(1));
            }
            return arrayMap;
        } finally {
            cursorQuery.close();
        }
    }

    public final void zze() {
        synchronized (this.zzf) {
            this.zzg = null;
            zzcz.zzd();
        }
        synchronized (this) {
            try {
                Iterator<zzch> it = this.zzh.iterator();
                while (it.hasNext()) {
                    it.next().zza();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
