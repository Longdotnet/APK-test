package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: classes.dex */
public final class zzcv extends zzgc {
    public zzcv() {
        super(zzla.class, new zzct(zzap.class));
    }

    public static void zzg(boolean z) {
        if (zzi()) {
            zzbz.zzn(new zzcv(), true);
        }
    }

    public static /* bridge */ /* synthetic */ zzga zzh(int i, int i2) {
        zzlc zzlcVarZzb = zzld.zzb();
        zzlcVarZzb.zza(i);
        return new zzga((zzld) zzlcVarZzb.zzi(), i2);
    }

    private static boolean zzi() {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgc
    public final zzgb zza() {
        return new zzcu(this, zzld.class);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgc
    public final zznr zzb() {
        return zznr.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgc
    public final /* synthetic */ zzaek zzc(zzacc zzaccVar) {
        return zzla.zzd(zzaccVar, zzacs.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgc
    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgc
    public final /* bridge */ /* synthetic */ void zze(zzaek zzaekVar) throws GeneralSecurityException {
        zzla zzlaVar = (zzla) zzaekVar;
        zzqs.zzc(zzlaVar.zza(), 0);
        zzqs.zzb(zzlaVar.zze().zzd());
    }
}
