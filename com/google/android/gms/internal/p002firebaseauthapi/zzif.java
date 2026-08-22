package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
final class zzif extends zzgw {
    public zzif(Class cls) {
        super(cls);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgw
    public final /* bridge */ /* synthetic */ Object zza(zzaek zzaekVar) throws GeneralSecurityException {
        zzmt zzmtVar = (zzmt) zzaekVar;
        int iZzf = zzmtVar.zzf().zzf();
        SecretKeySpec secretKeySpec = new SecretKeySpec(zzmtVar.zzg().zzt(), "HMAC");
        int iZza = zzmtVar.zzf().zza();
        int i = iZzf - 2;
        if (i == 1) {
            return new zzqo(new zzqn("HMACSHA1", secretKeySpec), iZza);
        }
        if (i == 2) {
            return new zzqo(new zzqn("HMACSHA384", secretKeySpec), iZza);
        }
        if (i == 3) {
            return new zzqo(new zzqn("HMACSHA256", secretKeySpec), iZza);
        }
        if (i == 4) {
            return new zzqo(new zzqn("HMACSHA512", secretKeySpec), iZza);
        }
        if (i == 5) {
            return new zzqo(new zzqn("HMACSHA224", secretKeySpec), iZza);
        }
        throw new GeneralSecurityException("unknown hash");
    }
}
