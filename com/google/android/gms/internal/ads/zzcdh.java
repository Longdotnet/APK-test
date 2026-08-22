package com.google.android.gms.internal.ads;

import com.google.android.gms.signin.internal.FVfQ.GsPcpBmONXh;
import com.google.firebase.inject.PVS.jIKWv;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class zzcdh implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ int zzc;
    final /* synthetic */ int zzd;
    final /* synthetic */ zzcdn zze;

    public zzcdh(zzcdn zzcdnVar, String str, String str2, int i, int i2, boolean z) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = i;
        this.zzd = i2;
        Objects.requireNonNull(zzcdnVar);
        this.zze = zzcdnVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap map = new HashMap();
        map.put(jIKWv.ICvXD, "precacheProgress");
        map.put("src", this.zza);
        map.put(GsPcpBmONXh.ReWscaecRqr, this.zzb);
        map.put("bytesLoaded", Integer.toString(this.zzc));
        map.put("totalBytes", Integer.toString(this.zzd));
        map.put("cacheReady", "0");
        zzcdn.zze(this.zze, "onPrecacheEvent", map);
    }
}
