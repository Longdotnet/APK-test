package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.security.InvalidAlgorithmParameterException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzdy extends zzgb {
    final /* synthetic */ zzdz zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdy(zzdz zzdzVar, Class cls) {
        super(cls);
        this.zza = zzdzVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final /* bridge */ /* synthetic */ zzaek zza(zzaek zzaekVar) {
        zzlf zzlfVarZzb = zzlg.zzb();
        zzlfVarZzb.zza(zzacc.zzn(zzqq.zza(((zzlj) zzaekVar).zza())));
        zzlfVarZzb.zzb(0);
        return (zzlg) zzlfVarZzb.zzi();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final /* synthetic */ zzaek zzb(zzacc zzaccVar) {
        return zzlj.zzd(zzaccVar, zzacs.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final Map zzc() {
        HashMap map = new HashMap();
        zzli zzliVarZzb = zzlj.zzb();
        zzliVarZzb.zza(64);
        map.put("AES256_SIV", new zzga((zzlj) zzliVarZzb.zzi(), 1));
        zzli zzliVarZzb2 = zzlj.zzb();
        zzliVarZzb2.zza(64);
        map.put("AES256_SIV_RAW", new zzga((zzlj) zzliVarZzb2.zzi(), 3));
        return Collections.unmodifiableMap(map);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final /* bridge */ /* synthetic */ void zzd(zzaek zzaekVar) throws InvalidAlgorithmParameterException {
        zzlj zzljVar = (zzlj) zzaekVar;
        if (zzljVar.zza() != 64) {
            throw new InvalidAlgorithmParameterException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzljVar.zza(), "invalid key size: ", ". Valid keys must have 64 bytes."));
        }
    }
}
