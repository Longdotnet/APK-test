package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzt extends LinkedHashMap {
    public final /* synthetic */ zzv zza;

    public zzt(zzv zzvVar) {
        Objects.requireNonNull(zzvVar);
        this.zza = zzvVar;
    }

    @Override // java.util.LinkedHashMap
    public final boolean removeEldestEntry(Map.Entry entry) {
        zzv zzvVar = this.zza;
        synchronized (zzvVar) {
            try {
                if (size() <= zzvVar.zza) {
                    return false;
                }
                zzvVar.zzf.add(new Pair((String) entry.getKey(), ((zzu) entry.getValue()).zzb));
                return size() > zzvVar.zza;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
