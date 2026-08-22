package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
final class zziy implements zzbv {
    private static final Logger zza = Logger.getLogger(zziy.class.getName());
    private static final byte[] zzb = {0};

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbv
    public final Class zza() {
        return zzbm.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbv
    public final Class zzb() {
        return zzbm.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbv
    public final /* bridge */ /* synthetic */ Object zzc(zzbu zzbuVar) throws GeneralSecurityException {
        Iterator it = zzbuVar.zzd().iterator();
        while (it.hasNext()) {
            for (zzbq zzbqVar : (List) it.next()) {
                if (zzbqVar.zzb() instanceof zziu) {
                    zziu zziuVar = (zziu) zzbqVar.zzb();
                    zzqv zzqvVarZzb = zzqv.zzb(zzbqVar.zzf());
                    if (!zzqvVarZzb.equals(zziuVar.zzc())) {
                        String strValueOf = String.valueOf(zziuVar.zzb());
                        String string = zziuVar.zzc().toString();
                        throw new GeneralSecurityException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(CoroutineAdapterKt$$ExternalSyntheticLambda0.m22m("Mac Key with parameters ", strValueOf, " has wrong output prefix (", string, ") instead of ("), zzqvVarZzb.toString(), ")"));
                    }
                }
            }
        }
        return new zzix(zzbuVar, null);
    }
}
