package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzggx {
    public static final /* synthetic */ int zza = 0;
    private static final zzgoq zzb = zzgoq.zzb(new zzgoo() { // from class: com.google.android.gms.internal.ads.zzggv
        @Override // com.google.android.gms.internal.ads.zzgoo
        public final Object zza(zzgez zzgezVar) {
            return zzgwc.zzb((zzggu) zzgezVar);
        }
    }, zzggu.class, zzget.class);
    private static final zzgfa zzc = zzgmz.zzd("type.googleapis.com/google.crypto.tink.AesEaxKey", zzget.class, zzgtz.SYMMETRIC, zzgsp.zzh());
    private static final zzgnn zzd = new zzgnn() { // from class: com.google.android.gms.internal.ads.zzggw
        @Override // com.google.android.gms.internal.ads.zzgnn
        public final zzgez zza(zzgfm zzgfmVar, Integer num) throws GeneralSecurityException {
            zzghb zzghbVar = (zzghb) zzgfmVar;
            int i = zzggx.zza;
            if (zzghbVar.zzc() == 24) {
                throw new GeneralSecurityException("192 bit AES GCM Parameters are not valid");
            }
            zzggs zzggsVar = new zzggs(null);
            zzggsVar.zzc(zzghbVar);
            zzggsVar.zza(num);
            zzggsVar.zzb(zzgxf.zzc(zzghbVar.zzc()));
            return zzggsVar.zzd();
        }
    };

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzgmg.zza(1)) {
            throw new GeneralSecurityException("Registering AES EAX is not supported in FIPS mode");
        }
        int i = zzgkk.zza;
        zzgkk.zze(zzgny.zzc());
        zzgnv.zza().zzc(zzb);
        zzgnu zzgnuVarZzb = zzgnu.zzb();
        HashMap map = new HashMap();
        map.put("AES128_EAX", zzgjn.zzc);
        zzggy zzggyVar = new zzggy(null);
        zzggyVar.zza(16);
        zzggyVar.zzb(16);
        zzggyVar.zzc(16);
        zzggz zzggzVar = zzggz.zzc;
        zzggyVar.zzd(zzggzVar);
        map.put("AES128_EAX_RAW", zzggyVar.zze());
        map.put("AES256_EAX", zzgjn.zzd);
        zzggy zzggyVar2 = new zzggy(null);
        zzggyVar2.zza(16);
        zzggyVar2.zzb(32);
        zzggyVar2.zzc(16);
        zzggyVar2.zzd(zzggzVar);
        map.put("AES256_EAX_RAW", zzggyVar2.zze());
        zzgnuVarZzb.zzd(Collections.unmodifiableMap(map));
        zzgno.zzb().zzc(zzd, zzghb.class);
        zzgmp.zzc().zzd(zzc, true);
    }
}
