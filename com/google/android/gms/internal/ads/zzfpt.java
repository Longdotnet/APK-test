package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.internal.view.Oteb.nYVxXTZQ;
import com.google.android.gms.auth.api.LNi.xPQrbOSWiEdU;
import java.util.HashMap;
import java.util.Map;
import kotlinx.coroutines.internal.Jbo.ygoi;

/* JADX INFO: loaded from: classes2.dex */
final class zzfpt implements zzfol {
    private final Object zza;
    private final zzfpu zzb;
    private final zzfqf zzc;
    private final zzfoi zzd;

    public zzfpt(Object obj, zzfpu zzfpuVar, zzfqf zzfqfVar, zzfoi zzfoiVar, boolean z) {
        this.zza = obj;
        this.zzb = zzfpuVar;
        this.zzc = zzfqfVar;
        this.zzd = zzfoiVar;
    }

    private static String zzi(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        zzaug zzaugVarZza = zzauh.zza();
        zzaugVarZza.zzc(5);
        zzaugVarZza.zza(zzgxz.zzv(bArr, 0, bArr.length));
        return Base64.encodeToString(((zzauh) zzaugVarZza.zzbr()).zzaV(), 11);
    }

    private final synchronized byte[] zzj(Map map, Map map2) {
        Object obj;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            obj = this.zza;
        } catch (Exception e) {
            this.zzd.zzc(2007, System.currentTimeMillis() - jCurrentTimeMillis, e);
            return null;
        }
        return (byte[]) obj.getClass().getDeclaredMethod("xss", Map.class, Map.class).invoke(obj, null, map2);
    }

    @Override // com.google.android.gms.internal.ads.zzfol
    public final synchronized String zza(Context context, String str, String str2, View view, Activity activity) {
        Map mapZza;
        mapZza = this.zzc.zza();
        mapZza.put(xPQrbOSWiEdU.GEBqcoeFWx, "c");
        mapZza.put("ctx", context);
        mapZza.put("cs", str2);
        mapZza.put(ygoi.UqZqKNYgtacg, null);
        mapZza.put("view", view);
        mapZza.put("act", activity);
        return zzi(zzj(null, mapZza));
    }

    @Override // com.google.android.gms.internal.ads.zzfol
    public final synchronized String zzb(Context context, String str, View view, Activity activity) {
        Map mapZzc;
        mapZzc = this.zzc.zzc();
        mapZzc.put("f", "v");
        mapZzc.put(ygoi.usnQbtOyHiEMPu, context);
        mapZzc.put("aid", null);
        mapZzc.put("view", view);
        mapZzc.put("act", activity);
        return zzi(zzj(null, mapZzc));
    }

    @Override // com.google.android.gms.internal.ads.zzfol
    public final synchronized String zzc(Context context, String str) {
        Map mapZzb;
        mapZzb = this.zzc.zzb();
        mapZzb.put("f", "q");
        mapZzb.put("ctx", context);
        mapZzb.put("aid", null);
        return zzi(zzj(null, mapZzb));
    }

    @Override // com.google.android.gms.internal.ads.zzfol
    public final synchronized void zzd(String str, MotionEvent motionEvent) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            HashMap map = new HashMap();
            map.put(nYVxXTZQ.xtVfBrdOWGnmh, new Throwable());
            map.put("aid", null);
            map.put("evt", motionEvent);
            Object obj = this.zza;
            obj.getClass().getDeclaredMethod("he", Map.class).invoke(obj, map);
            this.zzd.zzd(3003, System.currentTimeMillis() - jCurrentTimeMillis);
        } catch (Exception e) {
            throw new zzfqd(2005, e);
        }
    }

    public final synchronized int zze() {
        Object obj;
        try {
            obj = this.zza;
        } catch (Exception e) {
            throw new zzfqd(2006, e);
        }
        return ((Integer) obj.getClass().getDeclaredMethod("lcs", null).invoke(obj, null)).intValue();
    }

    public final zzfpu zzf() {
        return this.zzb;
    }

    public final synchronized void zzg() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Object obj = this.zza;
            obj.getClass().getDeclaredMethod("close", null).invoke(obj, null);
            this.zzd.zzd(3001, System.currentTimeMillis() - jCurrentTimeMillis);
        } catch (Exception e) {
            throw new zzfqd(2003, e);
        }
    }

    public final synchronized boolean zzh() {
        Object obj;
        try {
            obj = this.zza;
        } catch (Exception e) {
            throw new zzfqd(2001, e);
        }
        return ((Boolean) obj.getClass().getDeclaredMethod("init", null).invoke(obj, null)).booleanValue();
    }
}
