package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgig {
    public static final /* synthetic */ int zza = 0;
    private static final zzgoq zzb = zzgoq.zzb(new zzgoo() { // from class: com.google.android.gms.internal.ads.zzgie
        @Override // com.google.android.gms.internal.ads.zzgoo
        public final Object zza(zzgez zzgezVar) {
            zzgil zzgilVar = (zzgil) zzgezVar;
            int i = zzgig.zza;
            return zzglm.zzc(zzgfk.zza(zzgilVar.zzd().zzd()).zzb(), zzgilVar.zzb());
        }
    }, zzgil.class, zzget.class);
    private static final zzgfa zzc = zzgmz.zzd("type.googleapis.com/google.crypto.tink.KmsAeadKey", zzget.class, zzgtz.REMOTE, zzguv.zzg());
    private static final zzgnn zzd = new zzgnn() { // from class: com.google.android.gms.internal.ads.zzgif
        @Override // com.google.android.gms.internal.ads.zzgnn
        public final zzgez zza(zzgfm zzgfmVar, Integer num) {
            int i = zzgig.zza;
            return zzgil.zzc((zzgin) zzgfmVar, num);
        }
    };

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzgmg.zza(1)) {
            throw new GeneralSecurityException("Registering KMS AEAD is not supported in FIPS mode");
        }
        int i = zzgis.zza;
        zzgis.zze(zzgny.zzc());
        zzgnv.zza().zzc(zzb);
        zzgno.zzb().zzc(zzd, zzgin.class);
        zzgmp.zzc().zzd(zzc, true);
    }
}
