package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgik {
    public static final /* synthetic */ int zza = 0;
    private static final zzgfa zzb = zzgmz.zzd("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey", zzget.class, zzgtz.SYMMETRIC, zzgvb.zzg());
    private static final zzgnn zzc = new zzgnn() { // from class: com.google.android.gms.internal.ads.zzgii
        @Override // com.google.android.gms.internal.ads.zzgnn
        public final zzgez zza(zzgfm zzgfmVar, Integer num) {
            int i = zzgik.zza;
            return zzgit.zzc((zzgiy) zzgfmVar, num);
        }
    };
    private static final zzgoq zzd = zzgoq.zzb(new zzgoo() { // from class: com.google.android.gms.internal.ads.zzgij
        @Override // com.google.android.gms.internal.ads.zzgoo
        public final Object zza(zzgez zzgezVar) throws GeneralSecurityException {
            zzgit zzgitVar = (zzgit) zzgezVar;
            int i = zzgik.zza;
            String strZzd = zzgitVar.zzd().zzd();
            zzgga zzggaVarZzb = zzgitVar.zzd().zzb();
            zzget zzgetVarZzb = zzgfk.zza(strZzd).zzb();
            int i2 = zzgih.zza;
            try {
                return zzglm.zzc(new zzgih(zzguf.zzf(zzgfo.zzb(zzggaVarZzb), zzgyr.zza()), zzgetVarZzb), zzgitVar.zzb());
            } catch (zzgzw e) {
                throw new GeneralSecurityException(e);
            }
        }
    }, zzgit.class, zzget.class);

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzgmg.zza(1)) {
            throw new GeneralSecurityException("Registering KMS Envelope AEAD is not supported in FIPS mode");
        }
        int i = zzgjd.zza;
        zzgjd.zze(zzgny.zzc());
        zzgno.zzb().zzc(zzc, zzgiy.class);
        zzgnv.zza().zzc(zzd);
        zzgmp.zzc().zzd(zzb, true);
    }
}
