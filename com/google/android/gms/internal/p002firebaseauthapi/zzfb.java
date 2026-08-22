package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.ads.rewarded.zQ.yzwzcWHcnH;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class zzfb extends zzgb {
    final /* synthetic */ zzfc zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfb(zzfc zzfcVar, Class cls) {
        super(cls);
        this.zza = zzfcVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final /* bridge */ /* synthetic */ zzaek zza(zzaek zzaekVar) throws GeneralSecurityException {
        byte[] bArrZza;
        byte[] bArrZzb;
        zzne zzneVar = (zzne) zzaekVar;
        int iZzf = zzneVar.zzd().zzf() - 2;
        if (iZzf == 1) {
            bArrZza = zzqq.zza(32);
            bArrZza[0] = (byte) (bArrZza[0] | 7);
            int i = bArrZza[31] & 63;
            bArrZza[31] = (byte) i;
            bArrZza[31] = (byte) (i | 128);
            bArrZzb = zzqt.zzb(bArrZza);
        } else {
            if (iZzf != 2 && iZzf != 3 && iZzf != 4) {
                throw new GeneralSecurityException("Invalid KEM");
            }
            int iZzg = zzff.zzg(zzneVar.zzd().zzf());
            KeyPair keyPairZzd = zzpx.zzd(zzpx.zzl(iZzg));
            bArrZzb = zzpx.zzm(iZzg, 1, ((ECPublicKey) keyPairZzd.getPublic()).getW());
            bArrZza = ((ECPrivateKey) keyPairZzd.getPrivate()).getS().toByteArray();
        }
        zznm zznmVarZzc = zznn.zzc();
        zznmVarZzc.zzc(0);
        zznmVarZzc.zza(zzneVar.zzd());
        zznmVarZzc.zzb(zzacc.zzn(bArrZzb));
        zznn zznnVar = (zznn) zznmVarZzc.zzi();
        zznj zznjVarZzb = zznk.zzb();
        zznjVarZzb.zzc(0);
        zznjVarZzb.zzb(zznnVar);
        zznjVarZzb.zza(zzacc.zzn(bArrZza));
        return (zznk) zznjVarZzb.zzi();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final /* synthetic */ zzaek zzb(zzacc zzaccVar) {
        return zzne.zzc(zzaccVar, zzacs.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final /* synthetic */ void zzd(zzaek zzaekVar) throws GeneralSecurityException {
        zzff.zza(((zzne) zzaekVar).zzd());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final Map zzc() {
        HashMap map = new HashMap();
        map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", zzfc.zzh(3, 3, 3, 1));
        map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", zzfc.zzh(3, 3, 3, 3));
        map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", zzfc.zzh(3, 3, 4, 1));
        map.put(yzwzcWHcnH.WvryIHYQynLgyPw, zzfc.zzh(3, 3, 4, 3));
        map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305", zzfc.zzh(3, 3, 5, 1));
        map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305_RAW", zzfc.zzh(3, 3, 5, 3));
        map.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", zzfc.zzh(4, 3, 3, 1));
        map.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", zzfc.zzh(4, 3, 3, 3));
        map.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", zzfc.zzh(4, 3, 4, 1));
        map.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", zzfc.zzh(4, 3, 4, 3));
        map.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM", zzfc.zzh(5, 4, 3, 1));
        map.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM_RAW", zzfc.zzh(5, 4, 3, 3));
        map.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM", zzfc.zzh(5, 4, 4, 1));
        map.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM_RAW", zzfc.zzh(5, 4, 4, 3));
        map.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM", zzfc.zzh(6, 5, 3, 1));
        map.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM_RAW", zzfc.zzh(6, 5, 3, 3));
        map.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM", zzfc.zzh(6, 5, 4, 1));
        map.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM_RAW", zzfc.zzh(6, 5, 4, 3));
        return Collections.unmodifiableMap(map);
    }
}
