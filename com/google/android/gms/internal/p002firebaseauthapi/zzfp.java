package com.google.android.gms.internal.p002firebaseauthapi;

import android.util.Log;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class zzfp implements zzbk {
    private static final String zza = "zzfp";
    private KeyStore zzb;

    public zzfp() {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            this.zzb = keyStore;
        } catch (IOException | GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbk
    public final synchronized zzap zza(String str) {
        zzfo zzfoVar;
        zzfoVar = new zzfo(zzqs.zza("android-keystore://", str), this.zzb);
        byte[] bArrZza = zzqq.zza(10);
        byte[] bArr = new byte[0];
        if (!Arrays.equals(bArrZza, zzfoVar.zza(zzfoVar.zzb(bArrZza, bArr), bArr))) {
            throw new KeyStoreException("cannot use Android Keystore: encryption/decryption of non-empty message and empty aad returns an incorrect result");
        }
        return zzfoVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbk
    public final synchronized boolean zzb(String str) {
        return str.toLowerCase(Locale.US).startsWith("android-keystore://");
    }

    public final synchronized boolean zzc(String str) {
        String strZza;
        strZza = zzqs.zza("android-keystore://", str);
        try {
        } catch (NullPointerException unused) {
            Log.w(zza, "Keystore is temporarily unavailable, wait 20ms, reinitialize Keystore and try again.");
            try {
                Thread.sleep(20L);
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                this.zzb = keyStore;
                keyStore.load(null);
            } catch (IOException e) {
                throw new GeneralSecurityException(e);
            } catch (InterruptedException unused2) {
            }
            return this.zzb.containsAlias(strZza);
        }
        return this.zzb.containsAlias(strZza);
    }
}
