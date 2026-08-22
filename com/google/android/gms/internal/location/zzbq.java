package com.google.android.gms.internal.location;

/* JADX INFO: loaded from: classes.dex */
final class zzbq<E> extends zzbo<E> {
    private final zzbs<E> zza;

    public zzbq(zzbs<E> zzbsVar, int i) {
        super(zzbsVar.size(), i);
        this.zza = zzbsVar;
    }

    @Override // com.google.android.gms.internal.location.zzbo
    public final E zza(int i) {
        return this.zza.get(i);
    }
}
