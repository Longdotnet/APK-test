package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzgjr {
    private static final zzgnn zza = new zzgnn() { // from class: com.google.android.gms.internal.ads.zzgjp
        @Override // com.google.android.gms.internal.ads.zzgnn
        public final zzgez zza(zzgfm zzgfmVar, Integer num) {
            return zzgjo.zzc((zzgjt) zzgfmVar, zzgxf.zzc(32), num);
        }
    };
    private static final zzgoq zzb = zzgoq.zzb(new zzgoo() { // from class: com.google.android.gms.internal.ads.zzgjq
        @Override // com.google.android.gms.internal.ads.zzgoo
        public final Object zza(zzgez zzgezVar) {
            return zzglo.zzb((zzgjo) zzgezVar);
        }
    }, zzgjo.class, zzget.class);

    public static void zza(boolean z) {
        int i = zzglt.zza;
        zzglt.zze(zzgny.zzc());
        zzgnu zzgnuVarZzb = zzgnu.zzb();
        HashMap map = new HashMap();
        map.put("XAES_256_GCM_192_BIT_NONCE", zzgjn.zzg);
        map.put("XAES_256_GCM_192_BIT_NONCE_NO_PREFIX", zzgjn.zzh);
        map.put("XAES_256_GCM_160_BIT_NONCE_NO_PREFIX", zzgjn.zzi);
        map.put("X_AES_GCM_8_BYTE_SALT_NO_PREFIX", zzgjn.zzj);
        zzgnuVarZzb.zzd(Collections.unmodifiableMap(map));
        zzgnv.zza().zzc(zzb);
        zzgno.zzb().zzc(zza, zzgjt.class);
    }
}
