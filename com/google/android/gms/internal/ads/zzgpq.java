package com.google.android.gms.internal.ads;

import androidx.core.internal.view.Oteb.nYVxXTZQ;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class zzgpq {
    private static final zzgnn zza = new zzgnn() { // from class: com.google.android.gms.internal.ads.zzgpn
        @Override // com.google.android.gms.internal.ads.zzgnn
        public final zzgez zza(zzgfm zzgfmVar, Integer num) {
            return zzgpq.zzb((zzgpu) zzgfmVar, num);
        }
    };
    private static final zzgoq zzb = zzgoq.zzb(new zzgoo() { // from class: com.google.android.gms.internal.ads.zzgpo
        @Override // com.google.android.gms.internal.ads.zzgoo
        public final Object zza(zzgez zzgezVar) {
            return zzgpq.zzc((zzgpm) zzgezVar);
        }
    }, zzgpm.class, zzgpv.class);
    private static final zzgoq zzc = zzgoq.zzb(new zzgoo() { // from class: com.google.android.gms.internal.ads.zzgpp
        @Override // com.google.android.gms.internal.ads.zzgoo
        public final Object zza(zzgez zzgezVar) {
            return zzgpq.zza((zzgpm) zzgezVar);
        }
    }, zzgpm.class, zzgfl.class);
    private static final zzgfa zzd = zzgmz.zzd("type.googleapis.com/google.crypto.tink.AesCmacKey", zzgfl.class, zzgtz.SYMMETRIC, zzgrr.zzh());

    public static /* synthetic */ zzgfl zza(zzgpm zzgpmVar) throws GeneralSecurityException {
        zze(zzgpmVar.zzc());
        return zzgxb.zza(zzgpmVar);
    }

    public static /* synthetic */ zzgpm zzb(zzgpu zzgpuVar, Integer num) throws GeneralSecurityException {
        zze(zzgpuVar);
        zzgpk zzgpkVar = new zzgpk(null);
        zzgpkVar.zzc(zzgpuVar);
        zzgpkVar.zza(zzgxf.zzc(zzgpuVar.zzc()));
        zzgpkVar.zzb(num);
        return zzgpkVar.zzd();
    }

    public static /* synthetic */ zzgpv zzc(zzgpm zzgpmVar) throws GeneralSecurityException {
        zze(zzgpmVar.zzc());
        return new zzgrg(zzgpmVar);
    }

    public static void zzd(boolean z) throws GeneralSecurityException {
        if (!zzgmg.zza(1)) {
            throw new GeneralSecurityException("Registering AES CMAC is not supported in FIPS mode");
        }
        int i = zzgre.zza;
        zzgre.zze(zzgny.zzc());
        zzgno.zzb().zzc(zza, zzgpu.class);
        zzgnv.zza().zzc(zzb);
        zzgnv.zza().zzc(zzc);
        zzgnu zzgnuVarZzb = zzgnu.zzb();
        HashMap map = new HashMap();
        zzgpu zzgpuVar = zzgqz.zzc;
        map.put(nYVxXTZQ.IHx, zzgpuVar);
        map.put("AES256_CMAC", zzgpuVar);
        zzgpr zzgprVar = new zzgpr(null);
        zzgprVar.zza(32);
        zzgprVar.zzb(16);
        zzgprVar.zzc(zzgps.zzd);
        map.put("AES256_CMAC_RAW", zzgprVar.zzd());
        zzgnuVarZzb.zzd(Collections.unmodifiableMap(map));
        zzgmp.zzc().zzd(zzd, true);
    }

    private static void zze(zzgpu zzgpuVar) throws GeneralSecurityException {
        if (zzgpuVar.zzc() != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }
}
