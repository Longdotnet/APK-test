package com.google.android.gms.internal.ads;

import androidx.lifecycle.hSi.sgtsHsWT;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class zzglm implements zzget {
    private final zzget zza;
    private final byte[] zzb;

    public static zzget zzb(zzgnd zzgndVar) throws GeneralSecurityException {
        byte[] bArrZzd;
        zzgox zzgoxVarZzb = zzgndVar.zzb(zzgey.zza());
        zzget zzgetVar = (zzget) zzgmp.zzc().zza(zzgoxVarZzb.zzg(), zzget.class).zzc(zzgoxVarZzb.zze());
        zzgvf zzgvfVarZzc = zzgoxVarZzb.zzc();
        int iOrdinal = zzgvfVarZzc.ordinal();
        if (iOrdinal == 1) {
            bArrZzd = zzgnz.zzb(zzgndVar.zzd().intValue()).zzd();
        } else if (iOrdinal == 2) {
            bArrZzd = zzgnz.zza(zzgndVar.zzd().intValue()).zzd();
        } else if (iOrdinal != 3) {
            if (iOrdinal != 4) {
                throw new GeneralSecurityException("unknown output prefix type ".concat(String.valueOf(zzgvfVarZzc)));
            }
            bArrZzd = zzgnz.zza(zzgndVar.zzd().intValue()).zzd();
        } else {
            bArrZzd = zzgnz.zza.zzd();
        }
        return new zzglm(zzgetVar, bArrZzd);
    }

    public static zzget zzc(zzget zzgetVar, zzgxe zzgxeVar) {
        return new zzglm(zzgetVar, zzgxeVar.zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzget
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        if (bArr3.length == 0) {
            return this.zza.zza(bArr, bArr2);
        }
        if (zzgpj.zzc(bArr3, bArr)) {
            return this.zza.zza(Arrays.copyOfRange(bArr, 5, bArr.length), bArr2);
        }
        throw new GeneralSecurityException("wrong prefix");
    }

    private zzglm(zzget zzgetVar, byte[] bArr) {
        this.zza = zzgetVar;
        int length = bArr.length;
        if (length != 0 && length != 5) {
            throw new IllegalArgumentException(sgtsHsWT.kafgqtDmagRaq);
        }
        this.zzb = bArr;
    }
}
