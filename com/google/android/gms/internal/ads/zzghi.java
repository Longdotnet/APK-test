package com.google.android.gms.internal.ads;

import com.facebook.login.vu.dLDI;
import com.google.firebase.analytics.connector.pDv.PZmDzEagKNdW;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class zzghi {
    public static final /* synthetic */ int zza = 0;
    private static final zzgoq zzb = zzgoq.zzb(new zzgoo() { // from class: com.google.android.gms.internal.ads.zzghf
        @Override // com.google.android.gms.internal.ads.zzgoo
        public final Object zza(zzgez zzgezVar) {
            return zzgwd.zzb((zzghe) zzgezVar);
        }
    }, zzghe.class, zzget.class);
    private static final zzgfa zzc = zzgmz.zzd(dLDI.KJLvFHa, zzget.class, zzgtz.SYMMETRIC, zzgsy.zzg());
    private static final zzgnp zzd = new zzgnp() { // from class: com.google.android.gms.internal.ads.zzghg
    };
    private static final zzgnn zze = new zzgnn() { // from class: com.google.android.gms.internal.ads.zzghh
        @Override // com.google.android.gms.internal.ads.zzgnn
        public final zzgez zza(zzgfm zzgfmVar, Integer num) throws GeneralSecurityException {
            zzghm zzghmVar = (zzghm) zzgfmVar;
            int i = zzghi.zza;
            if (zzghmVar.zzb() == 24) {
                throw new GeneralSecurityException("192 bit AES GCM Parameters are not valid");
            }
            zzghc zzghcVar = new zzghc(null);
            zzghcVar.zzc(zzghmVar);
            zzghcVar.zza(num);
            zzghcVar.zzb(zzgxf.zzc(zzghmVar.zzb()));
            return zzghcVar.zzd();
        }
    };
    private static final int zzf = 2;

    public static void zza(boolean z) throws GeneralSecurityException {
        int i = zzf;
        if (!zzgmg.zza(i)) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        int i2 = zzgkr.zza;
        zzgkr.zze(zzgny.zzc());
        zzgnv.zza().zzc(zzb);
        zzgnu zzgnuVarZzb = zzgnu.zzb();
        HashMap map = new HashMap();
        map.put(PZmDzEagKNdW.uHhAs, zzgjn.zza);
        zzghj zzghjVar = new zzghj(null);
        zzghjVar.zza(12);
        zzghjVar.zzb(16);
        zzghjVar.zzc(16);
        zzghk zzghkVar = zzghk.zzc;
        zzghjVar.zzd(zzghkVar);
        map.put("AES128_GCM_RAW", zzghjVar.zze());
        map.put("AES256_GCM", zzgjn.zzb);
        zzghj zzghjVar2 = new zzghj(null);
        zzghjVar2.zza(12);
        zzghjVar2.zzb(32);
        zzghjVar2.zzc(16);
        zzghjVar2.zzd(zzghkVar);
        map.put("AES256_GCM_RAW", zzghjVar2.zze());
        zzgnuVarZzb.zzd(Collections.unmodifiableMap(map));
        zzgnq.zza().zzb(zzd, zzghm.class);
        zzgno.zzb().zzc(zze, zzghm.class);
        zzgmp.zzc().zzf(zzc, i, true);
    }
}
