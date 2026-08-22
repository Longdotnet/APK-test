package com.google.android.gms.internal.games_v2;

import java.io.Serializable;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzhi extends zzfz implements Serializable {
    public static final /* synthetic */ int zza = 0;
    private static final zzhi zzb;
    private static final zzhi zzc;
    private final transient zzhd zzd;

    static {
        int i = zzhd.zzd;
        zzb = new zzhi(zzhz.zza);
        zzc = new zzhi(zzhd.zzj(zzhw.zza()));
    }

    public zzhi(zzhd zzhdVar) {
        this.zzd = zzhdVar;
    }

    public static zzhi zza() {
        return zzb;
    }

    public static zzhi zzb() {
        return zzc;
    }

    @Override // com.google.android.gms.internal.games_v2.zzhy
    public final /* bridge */ /* synthetic */ Set zzc() {
        zzhd zzhdVar = this.zzd;
        if (zzhdVar.isEmpty()) {
            return zzif.zza;
        }
        int i = zzhw.zzc;
        return new zzig(zzhdVar, zzhv.zza);
    }
}
