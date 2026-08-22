package com.google.android.gms.internal.ads;

import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzfdl {
    public zzfdl() {
        try {
            zzgfq.zza();
        } catch (GeneralSecurityException e) {
            com.google.android.gms.ads.internal.util.zze.zza("Failed to Configure Aead. ".concat(e.toString()));
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "CryptoUtils.registerAead");
        }
    }

    public static final String zza() {
        byte[] byteArray;
        try {
            zzgfi zzgfiVarZze = zzgfi.zze(zzgfc.zza(zzgnu.zzb().zza("AES128_GCM")));
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                zzgew.zzb(zzgfiVarZze, zzgev.zzb(byteArrayOutputStream));
                byteArray = byteArrayOutputStream.toByteArray();
            } catch (IOException unused) {
                throw new GeneralSecurityException("Serialize keyset failed");
            }
        } catch (GeneralSecurityException e) {
            com.google.android.gms.ads.internal.util.zze.zza("Failed to generate key".concat(e.toString()));
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "CryptoUtils.generateKey");
            byteArray = new byte[0];
        }
        return Base64.encodeToString(byteArray, 11);
    }

    public static final String zzb(byte[] bArr, byte[] bArr2, String str, zzdsd zzdsdVar) {
        zzgfi zzgfiVarZzc;
        if (str != null && (zzgfiVarZzc = zzc(str)) != null) {
            try {
                byte[] bArrZza = ((zzget) zzgfiVarZzc.zzg(zzgfy.zza(), zzget.class)).zza(bArr, bArr2);
                zzdsdVar.zzb().put("ds", "1");
                return new String(bArrZza, "UTF-8");
            } catch (UnsupportedEncodingException | UnsupportedOperationException | GeneralSecurityException e) {
                com.google.android.gms.ads.internal.util.zze.zza("Failed to decrypt ".concat(e.toString()));
                com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "CryptoUtils.decrypt");
                zzdsdVar.zzb().put("dsf", e.toString());
            }
        }
        return null;
    }

    private static final zzgfi zzc(String str) {
        try {
            try {
                return zzgew.zza(zzgeu.zzb(Base64.decode(str, 11)));
            } catch (IOException unused) {
                throw new GeneralSecurityException("Parse keyset failed");
            }
        } catch (GeneralSecurityException e) {
            com.google.android.gms.ads.internal.util.zze.zza("Failed to get keysethandle".concat(e.toString()));
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "CryptoUtils.getHandle");
            return null;
        }
    }
}
