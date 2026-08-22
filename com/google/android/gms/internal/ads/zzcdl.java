package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzcdl implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ zzcdn zzd;

    public zzcdl(zzcdn zzcdnVar, String str, String str2, long j) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = j;
        Objects.requireNonNull(zzcdnVar);
        this.zzd = zzcdnVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap map = new HashMap();
        map.put("event", "precacheComplete");
        map.put("src", this.zza);
        map.put("cachedSrc", this.zzb);
        map.put("totalDuration", Long.toString(this.zzc));
        zzcdn.zze(this.zzd, "onPrecacheEvent", map);
    }
}
