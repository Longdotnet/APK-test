package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class zzgmp {
    private static final Logger zza = Logger.getLogger(zzgmp.class.getName());
    private static final zzgmp zzb = new zzgmp();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final ConcurrentMap zzd = new ConcurrentHashMap();

    public static zzgmp zzc() {
        return zzb;
    }

    private final synchronized zzgfa zzg(String str) {
        ConcurrentMap concurrentMap;
        concurrentMap = this.zzc;
        if (!concurrentMap.containsKey(str)) {
            throw new GeneralSecurityException("No key manager found for key type " + str + ", see https://developers.google.com/tink/faq/registration_errors");
        }
        return (zzgfa) concurrentMap.get(str);
    }

    private final synchronized void zzh(zzgfa zzgfaVar, boolean z, boolean z2) {
        try {
            String str = ((zzgmz) zzgfaVar).zza;
            ConcurrentMap concurrentMap = this.zzd;
            if (concurrentMap.containsKey(str) && !((Boolean) concurrentMap.get(str)).booleanValue()) {
                throw new GeneralSecurityException("New keys are already disallowed for key type ".concat(str));
            }
            ConcurrentMap concurrentMap2 = this.zzc;
            zzgfa zzgfaVar2 = (zzgfa) concurrentMap2.get(str);
            if (zzgfaVar2 != null && !zzgfaVar2.getClass().equals(zzgfaVar.getClass())) {
                zza.logp(Level.WARNING, "com.google.crypto.tink.internal.KeyManagerRegistry", "insertKeyManager", "Attempted overwrite of a registered key manager for key type ".concat(str));
                throw new GeneralSecurityException("typeUrl (" + str + ") is already registered with " + zzgfaVar2.getClass().getName() + ", cannot be re-registered with " + zzgfaVar.getClass().getName());
            }
            concurrentMap2.putIfAbsent(str, zzgfaVar);
            concurrentMap.put(str, Boolean.TRUE);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final zzgfa zza(String str, Class cls) throws GeneralSecurityException {
        zzgfa zzgfaVarZzg = zzg(str);
        if (zzgfaVarZzg.zzb().equals(cls)) {
            return zzgfaVarZzg;
        }
        String name = cls.getName();
        String strValueOf = String.valueOf(zzgfaVarZzg.getClass());
        String string = zzgfaVarZzg.zzb().toString();
        StringBuilder sbM22m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m22m("Primitive type ", name, " not supported by key manager of type ", strValueOf, ", which only supports: ");
        sbM22m.append(string);
        throw new GeneralSecurityException(sbM22m.toString());
    }

    public final zzgfa zzb(String str) {
        return zzg(str);
    }

    public final synchronized void zzd(zzgfa zzgfaVar, boolean z) {
        zzf(zzgfaVar, 1, true);
    }

    public final boolean zze(String str) {
        return ((Boolean) this.zzd.get(str)).booleanValue();
    }

    public final synchronized void zzf(zzgfa zzgfaVar, int i, boolean z) {
        if (!zzgmg.zza(i)) {
            throw new GeneralSecurityException("Cannot register key manager: FIPS compatibility insufficient");
        }
        zzh(zzgfaVar, false, true);
    }
}
