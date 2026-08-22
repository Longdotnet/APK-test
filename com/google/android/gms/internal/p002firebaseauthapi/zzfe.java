package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzfe extends zzgc {
    public zzfe() {
        super(zznn.class, new zzfd(zzav.class));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgc
    public final zznr zzb() {
        return zznr.ASYMMETRIC_PUBLIC;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgc
    public final /* synthetic */ zzaek zzc(zzacc zzaccVar) {
        return zznn.zzf(zzaccVar, zzacs.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgc
    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.HpkePublicKey";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgc
    public final /* bridge */ /* synthetic */ void zze(zzaek zzaekVar) throws GeneralSecurityException {
        zznn zznnVar = (zznn) zzaekVar;
        zzqs.zzc(zznnVar.zza(), 0);
        if (!zznnVar.zzl()) {
            throw new GeneralSecurityException("Missing HPKE key params.");
        }
        zzff.zza(zznnVar.zzb());
    }
}
