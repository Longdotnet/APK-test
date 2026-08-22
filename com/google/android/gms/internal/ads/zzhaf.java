package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzhaf {
    public static final List zza(Object obj, long j) {
        zzgzt zzgztVar = (zzgzt) zzhce.zzh(obj, j);
        if (zzgztVar.zzc()) {
            return zzgztVar;
        }
        int size = zzgztVar.size();
        zzgzt zzgztVarZzf = zzgztVar.zzf(size == 0 ? 10 : size + size);
        zzhce.zzv(obj, j, zzgztVarZzf);
        return zzgztVarZzf;
    }
}
