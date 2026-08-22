package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzgpc {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;
    private final Map zzd;

    public zzgpc() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
        this.zzc = new HashMap();
        this.zzd = new HashMap();
    }

    public final zzgpc zza(zzgmt zzgmtVar) throws GeneralSecurityException {
        zzgpd zzgpdVar = new zzgpd(zzgmtVar.zzd(), zzgmtVar.zzc(), null);
        Map map = this.zzb;
        if (map.containsKey(zzgpdVar)) {
            zzgmt zzgmtVar2 = (zzgmt) map.get(zzgpdVar);
            if (!zzgmtVar2.equals(zzgmtVar) || !zzgmtVar.equals(zzgmtVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzgpdVar.toString()));
            }
        } else {
            map.put(zzgpdVar, zzgmtVar);
        }
        return this;
    }

    public final zzgpc zzb(zzgmx zzgmxVar) throws GeneralSecurityException {
        zzgpe zzgpeVar = new zzgpe(zzgmxVar.zzc(), zzgmxVar.zzd(), null);
        Map map = this.zza;
        if (map.containsKey(zzgpeVar)) {
            zzgmx zzgmxVar2 = (zzgmx) map.get(zzgpeVar);
            if (!zzgmxVar2.equals(zzgmxVar) || !zzgmxVar.equals(zzgmxVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzgpeVar.toString()));
            }
        } else {
            map.put(zzgpeVar, zzgmxVar);
        }
        return this;
    }

    public final zzgpc zzc(zzgod zzgodVar) throws GeneralSecurityException {
        zzgpd zzgpdVar = new zzgpd(zzgodVar.zzd(), zzgodVar.zzc(), null);
        Map map = this.zzd;
        if (map.containsKey(zzgpdVar)) {
            zzgod zzgodVar2 = (zzgod) map.get(zzgpdVar);
            if (!zzgodVar2.equals(zzgodVar) || !zzgodVar.equals(zzgodVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzgpdVar.toString()));
            }
        } else {
            map.put(zzgpdVar, zzgodVar);
        }
        return this;
    }

    public final zzgpc zzd(zzgoh zzgohVar) throws GeneralSecurityException {
        zzgpe zzgpeVar = new zzgpe(zzgohVar.zzc(), zzgohVar.zzd(), null);
        Map map = this.zzc;
        if (map.containsKey(zzgpeVar)) {
            zzgoh zzgohVar2 = (zzgoh) map.get(zzgpeVar);
            if (!zzgohVar2.equals(zzgohVar) || !zzgohVar.equals(zzgohVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzgpeVar.toString()));
            }
        } else {
            map.put(zzgpeVar, zzgohVar);
        }
        return this;
    }

    public zzgpc(zzgpg zzgpgVar) {
        this.zza = new HashMap(zzgpgVar.zza);
        this.zzb = new HashMap(zzgpgVar.zzb);
        this.zzc = new HashMap(zzgpgVar.zzc);
        this.zzd = new HashMap(zzgpgVar.zzd);
    }
}
