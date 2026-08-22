package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzgno {
    public static final /* synthetic */ int zza = 0;
    private static final zzgnn zzb = new zzgnn() { // from class: com.google.android.gms.internal.ads.zzgnm
        @Override // com.google.android.gms.internal.ads.zzgnn
        public final zzgez zza(zzgfm zzgfmVar, Integer num) throws GeneralSecurityException {
            int i = zzgno.zza;
            zzguf zzgufVarZzc = ((zzgne) zzgfmVar).zzb().zzc();
            zzgfa zzgfaVarZzb = zzgmp.zzc().zzb(zzgufVarZzc.zzi());
            if (!zzgmp.zzc().zze(zzgufVarZzc.zzi())) {
                throw new GeneralSecurityException("Creating new keys is not allowed.");
            }
            zzgub zzgubVarZza = zzgfaVarZzb.zza(zzgufVarZzc.zzh());
            return new zzgnd(zzgox.zza(zzgubVarZza.zzg(), zzgubVarZza.zzf(), zzgubVarZza.zzb(), zzgufVarZzc.zzg(), num), zzgey.zza());
        }
    };
    private static final zzgno zzc = zze();
    private final Map zzd = new HashMap();

    public static zzgno zzb() {
        return zzc;
    }

    private final synchronized zzgez zzd(zzgfm zzgfmVar, Integer num) {
        zzgnn zzgnnVar;
        zzgnnVar = (zzgnn) this.zzd.get(zzgfmVar.getClass());
        if (zzgnnVar == null) {
            throw new GeneralSecurityException("Cannot create a new key for parameters " + zzgfmVar.toString() + ": no key creator for this class was registered.");
        }
        return zzgnnVar.zza(zzgfmVar, num);
    }

    private static zzgno zze() {
        zzgno zzgnoVar = new zzgno();
        try {
            zzgnoVar.zzc(zzb, zzgne.class);
            return zzgnoVar;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException("unexpected error.", e);
        }
    }

    public final zzgez zza(zzgfm zzgfmVar, Integer num) {
        return zzd(zzgfmVar, num);
    }

    public final synchronized void zzc(zzgnn zzgnnVar, Class cls) {
        try {
            Map map = this.zzd;
            zzgnn zzgnnVar2 = (zzgnn) map.get(cls);
            if (zzgnnVar2 != null && !zzgnnVar2.equals(zzgnnVar)) {
                throw new GeneralSecurityException("Different key creator for parameters class " + cls.toString() + " already inserted");
            }
            map.put(cls, zzgnnVar);
        } catch (Throwable th) {
            throw th;
        }
    }
}
