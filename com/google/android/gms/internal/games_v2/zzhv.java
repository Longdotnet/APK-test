package com.google.android.gms.internal.games_v2;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
final class zzhv extends zzht implements Serializable {
    static final zzht zza = new zzhv();

    private zzhv() {
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzhw zzhwVar = (zzhw) obj;
        zzhw zzhwVar2 = (zzhw) obj2;
        return zzgq.zzc().zza(zzhwVar.zza, zzhwVar2.zza).zza(zzhwVar.zzb, zzhwVar2.zzb).zzb();
    }
}
