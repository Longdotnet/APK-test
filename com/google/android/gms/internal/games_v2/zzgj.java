package com.google.android.gms.internal.games_v2;

import java.util.Objects;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class zzgj implements Function {
    static final /* synthetic */ zzgj zza = new zzgj();

    private /* synthetic */ zzgj() {
    }

    @Override // java.util.function.Function
    public final /* synthetic */ Object apply(Object obj) {
        zzhj zzhjVar = (zzhj) obj;
        int i = zzhjVar.zzb;
        if (i == 0) {
            return zzif.zza;
        }
        if (i == 1) {
            Object obj2 = zzhjVar.zza[0];
            Objects.requireNonNull(obj2);
            return new zzii(obj2);
        }
        zzhk zzhkVarZzk = zzhk.zzk(i, zzhjVar.zza);
        zzhjVar.zzb = zzhkVarZzk.size();
        zzhjVar.zzc = true;
        return zzhkVarZzk;
    }
}
