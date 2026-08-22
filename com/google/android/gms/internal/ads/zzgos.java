package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzgos {
    private final Map zza;
    private final Map zzb;

    private zzgos() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    public final zzgos zza(zzgoq zzgoqVar) throws GeneralSecurityException {
        if (zzgoqVar == null) {
            throw new NullPointerException("primitive constructor must be non-null");
        }
        zzgot zzgotVar = new zzgot(zzgoqVar.zzc(), zzgoqVar.zzd(), null);
        Map map = this.zza;
        if (map.containsKey(zzgotVar)) {
            zzgoq zzgoqVar2 = (zzgoq) map.get(zzgotVar);
            if (!zzgoqVar2.equals(zzgoqVar) || !zzgoqVar.equals(zzgoqVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal PrimitiveConstructor object for already existing object of type: ".concat(zzgotVar.toString()));
            }
        } else {
            map.put(zzgotVar, zzgoqVar);
        }
        return this;
    }

    public final zzgos zzb(zzgow zzgowVar) throws GeneralSecurityException {
        Map map = this.zzb;
        Class clsZzb = zzgowVar.zzb();
        if (map.containsKey(clsZzb)) {
            zzgow zzgowVar2 = (zzgow) map.get(clsZzb);
            if (!zzgowVar2.equals(zzgowVar) || !zzgowVar.equals(zzgowVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal PrimitiveWrapper object or input class object for already existing object of type".concat(clsZzb.toString()));
            }
        } else {
            map.put(clsZzb, zzgowVar);
        }
        return this;
    }

    public final zzgov zzc() {
        return new zzgov(this, null);
    }

    public /* synthetic */ zzgos(zzgou zzgouVar) {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    public /* synthetic */ zzgos(zzgov zzgovVar, zzgou zzgouVar) {
        this.zza = new HashMap(zzgovVar.zza);
        this.zzb = new HashMap(zzgovVar.zzb);
    }
}
