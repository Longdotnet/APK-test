package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
final class zzde extends zzgb {
    final /* synthetic */ zzdf zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzde(zzdf zzdfVar, Class cls) {
        super(cls);
        this.zza = zzdfVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final /* bridge */ /* synthetic */ zzaek zza(zzaek zzaekVar) {
        zzos zzosVarZzb = zzot.zzb();
        zzosVarZzb.zza((zzow) zzaekVar);
        zzosVarZzb.zzb(0);
        return (zzot) zzosVarZzb.zzi();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final /* synthetic */ zzaek zzb(zzacc zzaccVar) {
        return zzow.zzd(zzaccVar, zzacs.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final /* bridge */ /* synthetic */ void zzd(zzaek zzaekVar) throws GeneralSecurityException {
        zzow zzowVar = (zzow) zzaekVar;
        if (zzowVar.zze().isEmpty() || !zzowVar.zzf()) {
            throw new GeneralSecurityException("invalid key format: missing KEK URI or DEK template");
        }
    }
}
