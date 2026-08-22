package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class zzfzx extends zzfwr {
    final transient zzfwh zza;

    public zzfzx(Map map, zzfwh zzfwhVar) {
        super(map);
        this.zza = zzfwhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfwr, com.google.android.gms.internal.ads.zzfxi
    public final /* bridge */ /* synthetic */ Collection zza() {
        return (List) this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzfxi, com.google.android.gms.internal.ads.zzfxl
    public final Map zzj() {
        return zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzfxi, com.google.android.gms.internal.ads.zzfxl
    public final Set zzl() {
        return zzm();
    }
}
