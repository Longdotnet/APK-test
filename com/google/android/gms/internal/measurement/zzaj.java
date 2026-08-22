package com.google.android.gms.internal.measurement;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzaj {
    public static zzap zza(zzal zzalVar, zzap zzapVar, zzg zzgVar, List list) {
        if (zzalVar.zzt(zzapVar.zzi())) {
            zzap zzapVarZzf = zzalVar.zzf(zzapVar.zzi());
            if (zzapVarZzf instanceof zzai) {
                return ((zzai) zzapVarZzf).zza(zzgVar, list);
            }
            throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzapVar.zzi(), " is not a function"));
        }
        if (!"hasOwnProperty".equals(zzapVar.zzi())) {
            throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Object has no function ", zzapVar.zzi()));
        }
        zzh.zzh("hasOwnProperty", 1, list);
        return zzalVar.zzt(zzgVar.zzb((zzap) list.get(0)).zzi()) ? zzap.zzk : zzap.zzl;
    }

    public static Iterator zzb(Map map) {
        return new zzak(map.keySet().iterator());
    }
}
