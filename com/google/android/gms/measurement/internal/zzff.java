package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.collection.LruCache;

/* JADX INFO: loaded from: classes.dex */
public final class zzff extends LruCache {
    public final /* synthetic */ zzfi zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzff(zzfi zzfiVar) {
        super(20);
        this.zza = zzfiVar;
    }

    @Override // androidx.collection.LruCache
    public final Object create(Object obj) {
        com.google.android.gms.internal.measurement.zzff zzffVar;
        String str = (String) obj;
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        zzfi zzfiVar = this.zza;
        zzfiVar.zzW();
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        boolean zIsEmpty = TextUtils.isEmpty(str);
        ArrayMap arrayMap = zzfiVar.zzh;
        boolean z = false;
        if (!zIsEmpty && (zzffVar = (com.google.android.gms.internal.measurement.zzff) arrayMap.getOrDefault(str, null)) != null && zzffVar.zza() != 0) {
            z = true;
        }
        if (!z) {
            return null;
        }
        if (!arrayMap.containsKey(str) || arrayMap.getOrDefault(str, null) == null) {
            zzfiVar.zzC(str);
        } else {
            zzfiVar.zzD(str, (com.google.android.gms.internal.measurement.zzff) arrayMap.getOrDefault(str, null));
        }
        return (com.google.android.gms.internal.measurement.zzc) zzfiVar.zzd.snapshot().get(str);
    }
}
