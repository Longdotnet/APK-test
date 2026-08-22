package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class zzgat extends zzfyv {
    final transient Object zza;

    public zzgat(Object obj) {
        obj.getClass();
        this.zza = obj;
    }

    @Override // com.google.android.gms.internal.ads.zzfyl, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zza.equals(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzfyv, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // com.google.android.gms.internal.ads.zzfyv, com.google.android.gms.internal.ads.zzfyl, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzfyz(this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("[", this.zza.toString(), "]");
    }

    @Override // com.google.android.gms.internal.ads.zzfyl
    public final int zza(Object[] objArr, int i) {
        objArr[i] = this.zza;
        return i + 1;
    }

    @Override // com.google.android.gms.internal.ads.zzfyv, com.google.android.gms.internal.ads.zzfyl
    public final zzfyq zzd() {
        return zzfyq.zzo(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzfyv, com.google.android.gms.internal.ads.zzfyl
    /* JADX INFO: renamed from: zze */
    public final zzgaw iterator() {
        return new zzfyz(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzfyl
    public final boolean zzf() {
        return false;
    }
}
