package com.google.android.gms.internal.play_billing;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class zzar extends zzam {
    private final transient zzal zza;
    private final transient zzai zzb;

    public zzar(zzal zzalVar, zzai zzaiVar) {
        this.zza = zzalVar;
        this.zzb = zzaiVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzaf, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zza.get(obj) != null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzam, com.google.android.gms.internal.play_billing.zzaf, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.play_billing.zzaf
    public final int zza(Object[] objArr, int i) {
        return this.zzb.zza(objArr, 0);
    }

    @Override // com.google.android.gms.internal.play_billing.zzam, com.google.android.gms.internal.play_billing.zzaf
    public final zzai zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.play_billing.zzam, com.google.android.gms.internal.play_billing.zzaf
    /* JADX INFO: renamed from: zze */
    public final zzav iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // com.google.android.gms.internal.play_billing.zzaf
    public final boolean zzf() {
        throw null;
    }
}
