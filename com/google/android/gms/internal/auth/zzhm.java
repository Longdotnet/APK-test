package com.google.android.gms.internal.auth;

import com.google.firebase.inject.PVS.jIKWv;

/* JADX INFO: loaded from: classes2.dex */
public final class zzhm implements zzhk {
    public static final zzcz<Double> zza;
    public static final zzcz<Boolean> zzb;
    public static final zzcz<Long> zzc;
    public static final zzcz<Long> zzd;
    public static final zzcz<Boolean> zze;
    public static final zzcz<zzhi> zzf;
    public static final zzcz<Boolean> zzg;
    public static final zzcz<Long> zzh;
    public static final zzcz<Long> zzi;
    public static final zzcz<Boolean> zzj;
    public static final zzcz<Boolean> zzk;
    public static final zzcz<Long> zzl;
    public static final zzcz<Boolean> zzm;
    public static final zzcz<Double> zzn;

    @Override // com.google.android.gms.internal.auth.zzhk
    public final zzhi zza() {
        return zzf.zzb();
    }

    @Override // com.google.android.gms.internal.auth.zzhk
    public final boolean zzb() {
        return zzj.zzb().booleanValue();
    }

    @Override // com.google.android.gms.internal.auth.zzhk
    public final boolean zzc() {
        return zzk.zzb().booleanValue();
    }

    static {
        zzcx zzcxVarZza = new zzcx(zzcq.zza("com.google.android.gms.auth_account")).zza();
        zza = zzcxVarZza.zzb("getTokenRefactor__account_data_service_sample_percentage", 0.0d);
        zzb = zzcxVarZza.zzd("getTokenRefactor__account_data_service_tokenAPI_usable", true);
        zzc = zzcxVarZza.zzc("getTokenRefactor__account_manager_timeout_seconds", 20L);
        zzd = zzcxVarZza.zzc("getTokenRefactor__android_id_shift", 0L);
        zze = zzcxVarZza.zzd("getTokenRefactor__authenticator_logic_improved", false);
        try {
            zzf = zzcxVarZza.zze("getTokenRefactor__blocked_packages", zzhi.zzl(new byte[]{10, 19, 99, 111, 109, 46, 97, 110, 100, 114, 111, 105, 100, 46, 118, 101, 110, 100, 105, 110, 103, 10, 32, 99, 111, 109, 46, 103, 111, 111, 103, 108, 101, 46, 97, 110, 100, 114, 111, 105, 100, 46, 97, 112, 112, 115, 46, 109, 101, 101, 116, 105, 110, 103, 115, 10, 33, 99, 111, 109, 46, 103, 111, 111, 103, 108, 101, 46, 97, 110, 100, 114, 111, 105, 100, 46, 97, 112, 112, 115, 46, 109, 101, 115, 115, 97, 103, 105, 110, 103}), zzhl.zza);
            zzg = zzcxVarZza.zzd("getTokenRefactor__chimera_get_token_evolved", true);
            zzh = zzcxVarZza.zzc("getTokenRefactor__clear_token_timeout_seconds", 20L);
            zzi = zzcxVarZza.zzc("getTokenRefactor__default_task_timeout_seconds", 20L);
            zzj = zzcxVarZza.zzd("getTokenRefactor__gaul_accounts_api_evolved", false);
            zzk = zzcxVarZza.zzd(jIKWv.SUYPQhd, false);
            zzl = zzcxVarZza.zzc("getTokenRefactor__get_token_timeout_seconds", 120L);
            zzm = zzcxVarZza.zzd("getTokenRefactor__gms_account_authenticator_evolved", true);
            zzn = zzcxVarZza.zzb("getTokenRefactor__gms_account_authenticator_sample_percentage", 0.0d);
        } catch (zzew e) {
            throw new AssertionError("Could not parse proto flag \"getTokenRefactor__blocked_packages\"", e);
        }
    }
}
