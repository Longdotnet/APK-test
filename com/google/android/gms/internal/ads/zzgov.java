package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzgov {
    private final Map zza;
    private final Map zzb;

    public /* synthetic */ zzgov(zzgos zzgosVar, zzgou zzgouVar) {
        this.zza = new HashMap(zzgosVar.zza);
        this.zzb = new HashMap(zzgosVar.zzb);
    }

    public static zzgos zza() {
        return new zzgos(null);
    }

    public final Object zzb(zzgez zzgezVar, Class cls) throws GeneralSecurityException {
        zzgot zzgotVar = new zzgot(zzgezVar.getClass(), cls, null);
        Map map = this.zza;
        if (map.containsKey(zzgotVar)) {
            return ((zzgoq) map.get(zzgotVar)).zza(zzgezVar);
        }
        throw new GeneralSecurityException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("No PrimitiveConstructor for ", zzgotVar.toString(), " available, see https://developers.google.com/tink/faq/registration_errors"));
    }

    public final Object zzc(zzgmy zzgmyVar, zzgnh zzgnhVar, Class cls) throws GeneralSecurityException {
        Map map = this.zzb;
        if (!map.containsKey(cls)) {
            throw new GeneralSecurityException("No wrapper found for ".concat(cls.toString()));
        }
        zzgow zzgowVar = (zzgow) map.get(cls);
        return zzgowVar.zze(zzgmyVar, zzgnhVar, new zzgor(this, zzgowVar));
    }
}
