package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.security.GeneralSecurityException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
final class zzbd {
    private static final Logger zza = Logger.getLogger(zzbd.class.getName());
    private final ConcurrentMap zzb;

    public zzbd() {
        this.zzb = new ConcurrentHashMap();
    }

    private final zzax zzg(String str, Class cls) throws GeneralSecurityException {
        zzbc zzbcVarZzh = zzh(str);
        if (cls == null) {
            return zzbcVarZzh.zzb();
        }
        if (zzbcVarZzh.zze().contains(cls)) {
            return zzbcVarZzh.zza(cls);
        }
        String name = cls.getName();
        String strValueOf = String.valueOf(zzbcVarZzh.zzc());
        Set<Class> setZze = zzbcVarZzh.zze();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Class cls2 : setZze) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(cls2.getCanonicalName());
            z = false;
        }
        String string = sb.toString();
        StringBuilder sbM22m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m22m("Primitive type ", name, " not supported by key manager of type ", strValueOf, ", supported primitives: ");
        sbM22m.append(string);
        throw new GeneralSecurityException(sbM22m.toString());
    }

    private final synchronized zzbc zzh(String str) {
        if (!this.zzb.containsKey(str)) {
            throw new GeneralSecurityException("No key manager found for key type ".concat(String.valueOf(str)));
        }
        return (zzbc) this.zzb.get(str);
    }

    private final synchronized void zzi(zzbc zzbcVar, boolean z) {
        try {
            String strZze = zzbcVar.zzb().zze();
            zzbc zzbcVar2 = (zzbc) this.zzb.get(strZze);
            if (zzbcVar2 != null && !zzbcVar2.zzc().equals(zzbcVar.zzc())) {
                zza.logp(Level.WARNING, "com.google.crypto.tink.KeyManagerRegistry", "registerKeyManagerContainer", "Attempted overwrite of a registered key manager for key type ".concat(strZze));
                throw new GeneralSecurityException("typeUrl (" + strZze + ") is already registered with " + zzbcVar2.zzc().getName() + ", cannot be re-registered with " + zzbcVar.zzc().getName());
            }
            if (z) {
                this.zzb.put(strZze, zzbcVar);
            } else {
                this.zzb.putIfAbsent(strZze, zzbcVar);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Deprecated
    public final zzax zza(String str) {
        return zzg(str, null);
    }

    public final zzax zzb(String str, Class cls) {
        return zzg(str, cls);
    }

    public final zzax zzc(String str) {
        return zzh(str).zzb();
    }

    public final synchronized void zzd(zzgx zzgxVar, zzgc zzgcVar) {
        Class clsZzd;
        try {
            int iZzf = zzgcVar.zzf();
            if (!zzdv.zza(1)) {
                throw new GeneralSecurityException("failed to register key manager " + String.valueOf(zzgxVar.getClass()) + " as it is not FIPS compatible.");
            }
            if (!zzdv.zza(iZzf)) {
                throw new GeneralSecurityException("failed to register key manager " + String.valueOf(zzgcVar.getClass()) + " as it is not FIPS compatible.");
            }
            String strZzd = zzgxVar.zzd();
            String strZzd2 = zzgcVar.zzd();
            if (this.zzb.containsKey(strZzd) && ((zzbc) this.zzb.get(strZzd)).zzd() != null && (clsZzd = ((zzbc) this.zzb.get(strZzd)).zzd()) != null && !clsZzd.getName().equals(zzgcVar.getClass().getName())) {
                zza.logp(Level.WARNING, "com.google.crypto.tink.KeyManagerRegistry", "registerAsymmetricKeyManagers", "Attempted overwrite of a registered key manager for key type " + strZzd + " with inconsistent public key type " + strZzd2);
                throw new GeneralSecurityException("public key manager corresponding to " + zzgxVar.getClass().getName() + " is already registered with " + clsZzd.getName() + ", cannot be re-registered with " + zzgcVar.getClass().getName());
            }
            zzi(new zzbb(zzgxVar, zzgcVar), true);
            zzi(new zzba(zzgcVar), false);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zze(zzgc zzgcVar) {
        if (!zzdv.zza(zzgcVar.zzf())) {
            throw new GeneralSecurityException("failed to register key manager " + String.valueOf(zzgcVar.getClass()) + " as it is not FIPS compatible.");
        }
        zzi(new zzba(zzgcVar), false);
    }

    public final boolean zzf(String str) {
        return this.zzb.containsKey(str);
    }

    public zzbd(zzbd zzbdVar) {
        this.zzb = new ConcurrentHashMap(zzbdVar.zzb);
    }
}
