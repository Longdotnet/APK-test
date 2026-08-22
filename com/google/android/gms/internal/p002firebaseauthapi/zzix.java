package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.games.event.AfJ.oKjScaD;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes2.dex */
final class zzix implements zzbm {
    private final zzbu zza;
    private final zzjd zzb;
    private final zzjd zzc;

    public /* synthetic */ zzix(zzbu zzbuVar, zziw zziwVar) {
        zzjd zzjdVarZza;
        this.zza = zzbuVar;
        if (zzbuVar.zzf()) {
            zzje zzjeVarZzb = zzgm.zza().zzb();
            zzjj zzjjVarZza = zzgj.zza(zzbuVar);
            this.zzb = zzjeVarZzb.zza(zzjjVarZza, "mac", "compute");
            zzjdVarZza = zzjeVarZzb.zza(zzjjVarZza, "mac", "verify");
        } else {
            zzjdVarZza = zzgj.zza;
            this.zzb = zzjdVarZza;
        }
        this.zzc = zzjdVarZza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbm
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        if (length <= 5) {
            throw new GeneralSecurityException("tag too short");
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, 5);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 5, length);
        for (zzbq zzbqVar : this.zza.zze(bArrCopyOf)) {
            try {
                ((zzbm) zzbqVar.zze()).zza(bArrCopyOfRange, zzbqVar.zzd().equals(zzoy.LEGACY) ? zzpp.zzc(bArr2, zziy.zzb) : bArr2);
                zzbqVar.zza();
                return;
            } catch (GeneralSecurityException e) {
                zziy.zza.logp(Level.INFO, "com.google.crypto.tink.mac.MacWrapper$WrappedMac", oKjScaD.jHuxxPv, "tag prefix matches a key, but cannot verify: ".concat(e.toString()));
            }
        }
        for (zzbq zzbqVar2 : this.zza.zze(zzas.zza)) {
            try {
                ((zzbm) zzbqVar2.zze()).zza(bArr, bArr2);
                zzbqVar2.zza();
                return;
            } catch (GeneralSecurityException unused) {
            }
        }
        throw new GeneralSecurityException("invalid MAC");
    }
}
