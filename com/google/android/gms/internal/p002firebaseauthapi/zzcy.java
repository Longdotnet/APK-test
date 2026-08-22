package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.auth.IJ.gZrKCJ;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcy extends zzgc {
    public zzcy() {
        super(zzlm.class, new zzcw(zzap.class));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgc
    public final zzgb zza() {
        return new zzcx(this, zzlp.class);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgc
    public final zznr zzb() {
        return zznr.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgc
    public final /* synthetic */ zzaek zzc(zzacc zzaccVar) {
        return zzlm.zzd(zzaccVar, zzacs.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgc
    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgc
    public final /* bridge */ /* synthetic */ void zze(zzaek zzaekVar) throws GeneralSecurityException {
        zzlm zzlmVar = (zzlm) zzaekVar;
        zzqs.zzc(zzlmVar.zza(), 0);
        if (zzlmVar.zze().zzd() != 32) {
            throw new GeneralSecurityException(gZrKCJ.RTmdryWddPYc);
        }
    }
}
