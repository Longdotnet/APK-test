package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzfwb implements Iterable {
    final /* synthetic */ CharSequence zza;
    final /* synthetic */ zzfwe zzb;

    public zzfwb(zzfwe zzfweVar, CharSequence charSequence) {
        this.zza = charSequence;
        Objects.requireNonNull(zzfweVar);
        this.zzb = zzfweVar;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.zzb.zzg(this.zza);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        zzfvh.zzb(sb, this, ", ");
        sb.append(']');
        return sb.toString();
    }
}
