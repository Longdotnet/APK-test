package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzfkw implements Comparator {
    final /* synthetic */ zzfld zza;

    public zzfkw(zzfld zzfldVar) {
        Objects.requireNonNull(zzfldVar);
        this.zza = zzfldVar;
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzfku zzfkuVar = (zzfku) obj;
        zzfku zzfkuVar2 = (zzfku) obj2;
        Object objZzc = zzfkuVar2.zzc();
        zzfld zzfldVar = this.zza;
        int iCompare = Double.compare(zzfld.zzc(zzfldVar, zzfldVar.zza(objZzc)), zzfld.zzc(zzfldVar, zzfldVar.zza(zzfkuVar.zzc())));
        return iCompare == 0 ? Long.compare(zzfkuVar.zzb(), zzfkuVar2.zzb()) : iCompare;
    }
}
