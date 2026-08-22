package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzhgv extends zzhgn {
    static {
        zzhgs.zza(Collections.emptyMap());
    }

    public /* synthetic */ zzhgv(Map map, zzhgt zzhgtVar) {
        super(map);
    }

    public static zzhgu zzc(int i) {
        return new zzhgu(i, null);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final Map zzb() {
        LinkedHashMap linkedHashMapZzb = zzhgo.zzb(zza().size());
        for (Map.Entry entry : zza().entrySet()) {
            linkedHashMapZzb.put(entry.getKey(), ((zzhha) entry.getValue()).zzb());
        }
        return Collections.unmodifiableMap(linkedHashMapZzb);
    }
}
