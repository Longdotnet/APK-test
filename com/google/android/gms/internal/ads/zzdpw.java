package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzdpw {
    private final Map zza = new HashMap();

    public final synchronized zzdpv zza(String str) {
        return (zzdpv) this.zza.get(str);
    }

    public final String zzb(String str) {
        zzbse zzbseVar;
        zzdpv zzdpvVarZza = zza(str);
        return (zzdpvVarZza == null || (zzbseVar = zzdpvVarZza.zzb) == null) ? "" : zzbseVar.toString();
    }

    public final synchronized void zzc(String str, zzfdu zzfduVar) {
        zzbse zzbseVarZze;
        if (this.zza.containsKey(str)) {
            return;
        }
        zzbse zzbseVarZzf = null;
        if (zzfduVar == null) {
            zzbseVarZze = null;
        } else {
            try {
                zzbseVarZze = zzfduVar.zze();
            } catch (zzfdd unused) {
                zzbseVarZze = null;
            }
        }
        if (zzfduVar != null) {
            try {
                zzbseVarZzf = zzfduVar.zzf();
            } catch (zzfdd unused2) {
            }
        }
        boolean z = true;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjM)).booleanValue()) {
            if (zzfduVar == null) {
                z = false;
            } else {
                try {
                    zzfduVar.zzC();
                } catch (zzfdd unused3) {
                    z = false;
                }
            }
        }
        this.zza.put(str, new zzdpv(str, zzbseVarZze, zzbseVarZzf, z));
    }

    public final synchronized void zzd(String str, zzbrp zzbrpVar) {
        if (this.zza.containsKey(str)) {
            return;
        }
        try {
            this.zza.put(str, new zzdpv(str, zzbrpVar.zzf(), zzbrpVar.zzg(), true));
        } catch (Throwable unused) {
        }
    }
}
