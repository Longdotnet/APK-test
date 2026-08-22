package com.google.android.gms.games;

/* JADX INFO: loaded from: classes.dex */
public class AnnotatedData<T> {
    public final Object zza;
    public final boolean zzb;

    public AnnotatedData(Object obj, boolean z) {
        this.zza = obj;
        this.zzb = z;
    }

    public T get() {
        return (T) this.zza;
    }

    public boolean isStale() {
        return this.zzb;
    }
}
