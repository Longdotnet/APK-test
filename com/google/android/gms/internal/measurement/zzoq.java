package com.google.android.gms.internal.measurement;

import com.google.gson.yWTz.kBfGXgdfpo;

/* JADX INFO: loaded from: classes2.dex */
public final class zzoq implements zzop {
    public static final zzib zza;
    public static final zzib zzb;
    public static final zzib zzc;
    public static final zzib zzd;

    @Override // com.google.android.gms.internal.measurement.zzop
    public final boolean zza() {
        return ((Boolean) zzc.zzb()).booleanValue();
    }

    static {
        zzhy zzhyVarZza = new zzhy(zzhq.zza(kBfGXgdfpo.Ujg)).zza();
        zza = zzhyVarZza.zzd("measurement.id.lifecycle.app_in_background_parameter", 0L);
        zzb = zzhyVarZza.zzf("measurement.lifecycle.app_backgrounded_tracking", true);
        zzc = zzhyVarZza.zzf("measurement.lifecycle.app_in_background_parameter", false);
        zzd = zzhyVarZza.zzd("measurement.id.lifecycle.app_backgrounded_tracking", 0L);
    }
}
