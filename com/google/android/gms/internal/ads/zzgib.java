package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzgib {
    public static final /* synthetic */ int zza = 0;
    private static final zzgoq zzb = zzgoq.zzb(new zzgoo() { // from class: com.google.android.gms.internal.ads.zzghz
        @Override // com.google.android.gms.internal.ads.zzgoo
        public final Object zza(zzgez zzgezVar) {
            zzghy zzghyVar = (zzghy) zzgezVar;
            int i = zzgib.zza;
            return zzgkz.zze() ? zzgkz.zzb(zzghyVar) : zzgwf.zzb(zzghyVar);
        }
    }, zzghy.class, zzget.class);
    private static final zzgnn zzc = new zzgnn() { // from class: com.google.android.gms.internal.ads.zzgia
        @Override // com.google.android.gms.internal.ads.zzgnn
        public final zzgez zza(zzgfm zzgfmVar, Integer num) {
            int i = zzgib.zza;
            return zzghy.zzc(((zzgid) zzgfmVar).zzb(), zzgxf.zzc(32), num);
        }
    };
    private static final zzgfa zzd = zzgmz.zzd("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key", zzget.class, zzgtz.SYMMETRIC, zzgtk.zzg());

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzgmg.zza(1)) {
            throw new GeneralSecurityException("Registering ChaCha20Poly1305 is not supported in FIPS mode");
        }
        int i = zzgle.zza;
        zzgle.zze(zzgny.zzc());
        zzgnv.zza().zzc(zzb);
        zzgno.zzb().zzc(zzc, zzgid.class);
        zzgnu zzgnuVarZzb = zzgnu.zzb();
        HashMap map = new HashMap();
        map.put("CHACHA20_POLY1305", zzgid.zzc(zzgic.zza));
        map.put("CHACHA20_POLY1305_RAW", zzgid.zzc(zzgic.zzc));
        zzgnuVarZzb.zzd(Collections.unmodifiableMap(map));
        zzgmp.zzc().zzd(zzd, true);
    }
}
