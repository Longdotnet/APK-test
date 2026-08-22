package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzght {
    public static final /* synthetic */ int zza = 0;
    private static final zzgoq zzb = zzgoq.zzb(new zzgoo() { // from class: com.google.android.gms.internal.ads.zzghq
        @Override // com.google.android.gms.internal.ads.zzgoo
        public final Object zza(zzgez zzgezVar) {
            return zzgmc.zzb((zzghp) zzgezVar);
        }
    }, zzghp.class, zzget.class);
    private static final zzgnn zzc = new zzgnn() { // from class: com.google.android.gms.internal.ads.zzghr
        @Override // com.google.android.gms.internal.ads.zzgnn
        public final zzgez zza(zzgfm zzgfmVar, Integer num) {
            zzghx zzghxVar = (zzghx) zzgfmVar;
            int i = zzght.zza;
            zzghn zzghnVar = new zzghn(null);
            zzghnVar.zzc(zzghxVar);
            zzghnVar.zza(num);
            zzghnVar.zzb(zzgxf.zzc(zzghxVar.zzb()));
            return zzghnVar.zzd();
        }
    };
    private static final zzgnp zzd = new zzgnp() { // from class: com.google.android.gms.internal.ads.zzghs
    };
    private static final zzgfa zze = zzgmz.zzd("type.googleapis.com/google.crypto.tink.AesGcmSivKey", zzget.class, zzgtz.SYMMETRIC, zzgte.zzg());

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzgmg.zza(1)) {
            throw new GeneralSecurityException("Registering AES GCM SIV is not supported in FIPS mode");
        }
        int i = zzgkx.zza;
        zzgkx.zze(zzgny.zzc());
        zzgnu zzgnuVarZzb = zzgnu.zzb();
        HashMap map = new HashMap();
        zzghu zzghuVar = new zzghu(null);
        zzghuVar.zza(16);
        zzghv zzghvVar = zzghv.zza;
        zzghuVar.zzb(zzghvVar);
        map.put("AES128_GCM_SIV", zzghuVar.zzc());
        zzghu zzghuVar2 = new zzghu(null);
        zzghuVar2.zza(16);
        zzghv zzghvVar2 = zzghv.zzc;
        zzghuVar2.zzb(zzghvVar2);
        map.put("AES128_GCM_SIV_RAW", zzghuVar2.zzc());
        zzghu zzghuVar3 = new zzghu(null);
        zzghuVar3.zza(32);
        zzghuVar3.zzb(zzghvVar);
        map.put("AES256_GCM_SIV", zzghuVar3.zzc());
        zzghu zzghuVar4 = new zzghu(null);
        zzghuVar4.zza(32);
        zzghuVar4.zzb(zzghvVar2);
        map.put("AES256_GCM_SIV_RAW", zzghuVar4.zzc());
        zzgnuVarZzb.zzd(Collections.unmodifiableMap(map));
        zzgnq.zza().zzb(zzd, zzghx.class);
        zzgno.zzb().zzc(zzc, zzghx.class);
        zzgnv.zza().zzc(zzb);
        zzgmp.zzc().zzd(zze, true);
    }
}
