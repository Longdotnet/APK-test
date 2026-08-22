package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzgjy {
    public static final /* synthetic */ int zza = 0;
    private static final zzgoq zzb = zzgoq.zzb(new zzgoo() { // from class: com.google.android.gms.internal.ads.zzgjv
        @Override // com.google.android.gms.internal.ads.zzgoo
        public final Object zza(zzgez zzgezVar) {
            zzgju zzgjuVar = (zzgju) zzgezVar;
            int i = zzgjy.zza;
            return zzglu.zzc() ? zzglu.zzb(zzgjuVar) : zzgxd.zzb(zzgjuVar);
        }
    }, zzgju.class, zzget.class);
    private static final zzgfa zzc = zzgmz.zzd("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key", zzget.class, zzgtz.SYMMETRIC, zzgvu.zzg());
    private static final zzgnp zzd = new zzgnp() { // from class: com.google.android.gms.internal.ads.zzgjw
    };
    private static final zzgnn zze = new zzgnn() { // from class: com.google.android.gms.internal.ads.zzgjx
        @Override // com.google.android.gms.internal.ads.zzgnn
        public final zzgez zza(zzgfm zzgfmVar, Integer num) {
            int i = zzgjy.zza;
            return zzgju.zzc(((zzgka) zzgfmVar).zzb(), zzgxf.zzc(32), num);
        }
    };

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzgmg.zza(1)) {
            throw new GeneralSecurityException("Registering XChaCha20Poly1305 is not supported in FIPS mode");
        }
        int i = zzglz.zza;
        zzglz.zze(zzgny.zzc());
        zzgnv.zza().zzc(zzb);
        zzgnu zzgnuVarZzb = zzgnu.zzb();
        HashMap map = new HashMap();
        map.put("XCHACHA20_POLY1305", zzgka.zzc(zzgjz.zza));
        map.put("XCHACHA20_POLY1305_RAW", zzgka.zzc(zzgjz.zzc));
        zzgnuVarZzb.zzd(Collections.unmodifiableMap(map));
        zzgno.zzb().zzc(zze, zzgka.class);
        zzgnq.zza().zzb(zzd, zzgka.class);
        zzgmp.zzc().zzd(zzc, true);
    }
}
