package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzgj {
    public static final zzjd zza = new zzgi(null);

    public static zzjj zza(zzbu zzbuVar) {
        zzbe zzbeVar;
        zzjf zzjfVar = new zzjf();
        zzjfVar.zzb(zzbuVar.zzb());
        Iterator it = zzbuVar.zzd().iterator();
        while (it.hasNext()) {
            for (zzbq zzbqVar : (List) it.next()) {
                int iZzg = zzbqVar.zzg() - 2;
                if (iZzg == 1) {
                    zzbeVar = zzbe.zza;
                } else if (iZzg == 2) {
                    zzbeVar = zzbe.zzb;
                } else {
                    if (iZzg != 3) {
                        throw new IllegalStateException("Unknown key status");
                    }
                    zzbeVar = zzbe.zzc;
                }
                zzjfVar.zza(zzbeVar, zzbqVar.zza(), zzbqVar.zzc());
            }
        }
        if (zzbuVar.zza() != null) {
            zzjfVar.zzc(zzbuVar.zza().zza());
        }
        try {
            return zzjfVar.zzd();
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
