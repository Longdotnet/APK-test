package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdsm implements zzfhb {
    private final zzdsd zzb;
    private final Clock zzc;
    private final Map zza = new HashMap();
    private final Map zzd = new HashMap();

    public zzdsm(zzdsd zzdsdVar, Set set, Clock clock) {
        this.zzb = zzdsdVar;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzdsl zzdslVar = (zzdsl) it.next();
            this.zzd.put(zzdslVar.zzc, zzdslVar);
        }
        this.zzc = clock;
    }

    @Override // com.google.android.gms.internal.ads.zzfhb
    public final void zzd(zzfgu zzfguVar, String str) {
        Map map = this.zza;
        if (map.containsKey(zzfguVar)) {
            ((DefaultClock) this.zzc).getClass();
            long jElapsedRealtime = SystemClock.elapsedRealtime() - ((Long) map.get(zzfguVar)).longValue();
            zzdsd zzdsdVar = this.zzb;
            String strValueOf = String.valueOf(str);
            zzdsdVar.zzb().put("task.".concat(strValueOf), "s.".concat(String.valueOf(Long.toString(jElapsedRealtime))));
        }
        if (this.zzd.containsKey(zzfguVar)) {
            zze(zzfguVar, true);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfhb
    public final void zzdE(zzfgu zzfguVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzfhb
    public final void zzdG(zzfgu zzfguVar, String str) {
        ((DefaultClock) this.zzc).getClass();
        this.zza.put(zzfguVar, Long.valueOf(SystemClock.elapsedRealtime()));
    }

    private final void zze(zzfgu zzfguVar, boolean z) {
        zzdsl zzdslVar = (zzdsl) this.zzd.get(zzfguVar);
        if (zzdslVar == null) {
            return;
        }
        String str = true != z ? eoBKjVuj.rDddu : "s.";
        Map map = this.zza;
        zzfgu zzfguVar2 = zzdslVar.zzb;
        if (map.containsKey(zzfguVar2)) {
            ((DefaultClock) this.zzc).getClass();
            long jElapsedRealtime = SystemClock.elapsedRealtime() - ((Long) map.get(zzfguVar2)).longValue();
            this.zzb.zzb().put("label.".concat(zzdslVar.zza), str + jElapsedRealtime);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfhb
    public final void zzdF(zzfgu zzfguVar, String str, Throwable th) {
        Map map = this.zza;
        if (map.containsKey(zzfguVar)) {
            ((DefaultClock) this.zzc).getClass();
            long jElapsedRealtime = SystemClock.elapsedRealtime() - ((Long) map.get(zzfguVar)).longValue();
            zzdsd zzdsdVar = this.zzb;
            String strValueOf = String.valueOf(str);
            zzdsdVar.zzb().put("task.".concat(strValueOf), eoBKjVuj.aVyxorZ.concat(String.valueOf(Long.toString(jElapsedRealtime))));
        }
        if (this.zzd.containsKey(zzfguVar)) {
            zze(zzfguVar, false);
        }
    }
}
