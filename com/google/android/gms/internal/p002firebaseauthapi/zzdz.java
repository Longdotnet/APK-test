package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* JADX INFO: loaded from: classes.dex */
public final class zzdz extends zzgc {
    public zzdz() {
        super(zzlg.class, new zzdx(zzat.class));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgc
    public final zzgb zza() {
        return new zzdy(this, zzlj.class);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgc
    public final zznr zzb() {
        return zznr.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgc
    public final /* synthetic */ zzaek zzc(zzacc zzaccVar) {
        return zzlg.zzd(zzaccVar, zzacs.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgc
    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesSivKey";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgc
    public final /* bridge */ /* synthetic */ void zze(zzaek zzaekVar) throws GeneralSecurityException {
        zzlg zzlgVar = (zzlg) zzaekVar;
        zzqs.zzc(zzlgVar.zza(), 0);
        if (zzlgVar.zze().zzd() != 64) {
            throw new InvalidKeyException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzlgVar.zze().zzd(), "invalid key size: ", ". Valid keys must have 64 bytes."));
        }
    }
}
