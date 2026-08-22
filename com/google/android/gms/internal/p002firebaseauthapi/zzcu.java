package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.InvalidAlgorithmParameterException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzcu extends zzgb {
    final /* synthetic */ zzcv zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcu(zzcv zzcvVar, Class cls) {
        super(cls);
        this.zza = zzcvVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final /* bridge */ /* synthetic */ zzaek zza(zzaek zzaekVar) {
        zzkz zzkzVarZzb = zzla.zzb();
        zzkzVarZzb.zza(zzacc.zzn(zzqq.zza(((zzld) zzaekVar).zza())));
        zzkzVarZzb.zzb(0);
        return (zzla) zzkzVarZzb.zzi();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final /* synthetic */ zzaek zzb(zzacc zzaccVar) {
        return zzld.zzd(zzaccVar, zzacs.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final Map zzc() {
        HashMap map = new HashMap();
        map.put("AES128_GCM_SIV", zzcv.zzh(16, 1));
        map.put("AES128_GCM_SIV_RAW", zzcv.zzh(16, 3));
        map.put("AES256_GCM_SIV", zzcv.zzh(32, 1));
        map.put("AES256_GCM_SIV_RAW", zzcv.zzh(32, 3));
        return Collections.unmodifiableMap(map);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final /* synthetic */ void zzd(zzaek zzaekVar) throws InvalidAlgorithmParameterException {
        zzqs.zzb(((zzld) zzaekVar).zza());
    }
}
