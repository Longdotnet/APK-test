package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzgqg {
    public static final /* synthetic */ int zza = 0;
    private static final zzgoq zzb = zzgoq.zzb(new zzgoo() { // from class: com.google.android.gms.internal.ads.zzgqc
        @Override // com.google.android.gms.internal.ads.zzgoo
        public final Object zza(zzgez zzgezVar) {
            return new zzgrh((zzgqb) zzgezVar);
        }
    }, zzgqb.class, zzgpv.class);
    private static final zzgoq zzc = zzgoq.zzb(new zzgoo() { // from class: com.google.android.gms.internal.ads.zzgqd
        @Override // com.google.android.gms.internal.ads.zzgoo
        public final Object zza(zzgez zzgezVar) {
            return zzgxb.zzb((zzgqb) zzgezVar);
        }
    }, zzgqb.class, zzgfl.class);
    private static final zzgfa zzd = zzgmz.zzd("type.googleapis.com/google.crypto.tink.HmacKey", zzgfl.class, zzgtz.SYMMETRIC, zzgtr.zzi());
    private static final zzgnp zze = new zzgnp() { // from class: com.google.android.gms.internal.ads.zzgqe
    };
    private static final zzgnn zzf = new zzgnn() { // from class: com.google.android.gms.internal.ads.zzgqf
        @Override // com.google.android.gms.internal.ads.zzgnn
        public final zzgez zza(zzgfm zzgfmVar, Integer num) {
            zzgql zzgqlVar = (zzgql) zzgfmVar;
            int i = zzgqg.zza;
            zzgpz zzgpzVar = new zzgpz(null);
            zzgpzVar.zzc(zzgqlVar);
            zzgpzVar.zzb(zzgxf.zzc(zzgqlVar.zzc()));
            zzgpzVar.zza(num);
            return zzgpzVar.zzd();
        }
    };
    private static final int zzg = 2;

    public static void zza(boolean z) throws GeneralSecurityException {
        int i = zzg;
        if (!zzgmg.zza(i)) {
            throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
        }
        int i2 = zzgrm.zza;
        zzgrm.zze(zzgny.zzc());
        zzgnv.zza().zzc(zzb);
        zzgnv.zza().zzc(zzc);
        zzgnu zzgnuVarZzb = zzgnu.zzb();
        HashMap map = new HashMap();
        map.put("HMAC_SHA256_128BITTAG", zzgqz.zza);
        zzgqh zzgqhVar = new zzgqh(null);
        zzgqhVar.zzb(32);
        zzgqhVar.zzc(16);
        zzgqj zzgqjVar = zzgqj.zzd;
        zzgqhVar.zzd(zzgqjVar);
        zzgqi zzgqiVar = zzgqi.zzc;
        zzgqhVar.zza(zzgqiVar);
        map.put("HMAC_SHA256_128BITTAG_RAW", zzgqhVar.zze());
        zzgqh zzgqhVar2 = new zzgqh(null);
        zzgqhVar2.zzb(32);
        zzgqhVar2.zzc(32);
        zzgqj zzgqjVar2 = zzgqj.zza;
        zzgqhVar2.zzd(zzgqjVar2);
        zzgqhVar2.zza(zzgqiVar);
        map.put("HMAC_SHA256_256BITTAG", zzgqhVar2.zze());
        zzgqh zzgqhVar3 = new zzgqh(null);
        zzgqhVar3.zzb(32);
        zzgqhVar3.zzc(32);
        zzgqhVar3.zzd(zzgqjVar);
        zzgqhVar3.zza(zzgqiVar);
        map.put("HMAC_SHA256_256BITTAG_RAW", zzgqhVar3.zze());
        zzgqh zzgqhVar4 = new zzgqh(null);
        zzgqhVar4.zzb(64);
        zzgqhVar4.zzc(16);
        zzgqhVar4.zzd(zzgqjVar2);
        zzgqi zzgqiVar2 = zzgqi.zze;
        zzgqhVar4.zza(zzgqiVar2);
        map.put("HMAC_SHA512_128BITTAG", zzgqhVar4.zze());
        zzgqh zzgqhVar5 = new zzgqh(null);
        zzgqhVar5.zzb(64);
        zzgqhVar5.zzc(16);
        zzgqhVar5.zzd(zzgqjVar);
        zzgqhVar5.zza(zzgqiVar2);
        map.put("HMAC_SHA512_128BITTAG_RAW", zzgqhVar5.zze());
        zzgqh zzgqhVar6 = new zzgqh(null);
        zzgqhVar6.zzb(64);
        zzgqhVar6.zzc(32);
        zzgqhVar6.zzd(zzgqjVar2);
        zzgqhVar6.zza(zzgqiVar2);
        map.put("HMAC_SHA512_256BITTAG", zzgqhVar6.zze());
        zzgqh zzgqhVar7 = new zzgqh(null);
        zzgqhVar7.zzb(64);
        zzgqhVar7.zzc(32);
        zzgqhVar7.zzd(zzgqjVar);
        zzgqhVar7.zza(zzgqiVar2);
        map.put("HMAC_SHA512_256BITTAG_RAW", zzgqhVar7.zze());
        map.put("HMAC_SHA512_512BITTAG", zzgqz.zzb);
        zzgqh zzgqhVar8 = new zzgqh(null);
        zzgqhVar8.zzb(64);
        zzgqhVar8.zzc(64);
        zzgqhVar8.zzd(zzgqjVar);
        zzgqhVar8.zza(zzgqiVar2);
        map.put("HMAC_SHA512_512BITTAG_RAW", zzgqhVar8.zze());
        zzgnuVarZzb.zzd(Collections.unmodifiableMap(map));
        zzgno.zzb().zzc(zzf, zzgql.class);
        zzgnq.zza().zzb(zze, zzgql.class);
        zzgmp.zzc().zzf(zzd, i, true);
    }
}
