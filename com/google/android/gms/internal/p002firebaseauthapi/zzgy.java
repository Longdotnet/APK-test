package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgy implements zzha {
    private final String zza;
    private final zzqv zzb;
    private final zzacc zzc;
    private final zznr zzd;
    private final zzoy zze;
    private final Integer zzf;

    private zzgy(String str, zzacc zzaccVar, zznr zznrVar, zzoy zzoyVar, Integer num) {
        this.zza = str;
        this.zzb = zzhj.zzb(str);
        this.zzc = zzaccVar;
        this.zzd = zznrVar;
        this.zze = zzoyVar;
        this.zzf = num;
    }

    public static zzgy zza(String str, zzacc zzaccVar, zznr zznrVar, zzoy zzoyVar, Integer num) throws GeneralSecurityException {
        if (zzoyVar == zzoy.RAW) {
            if (num != null) {
                throw new GeneralSecurityException("Keys with output prefix type raw should not have an id requirement.");
            }
        } else if (num == null) {
            throw new GeneralSecurityException("Keys with output prefix type different from raw should have an id requirement.");
        }
        return new zzgy(str, zzaccVar, zznrVar, zzoyVar, num);
    }

    public final zznr zzb() {
        return this.zzd;
    }

    public final zzoy zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzha
    public final zzqv zzd() {
        return this.zzb;
    }

    public final zzacc zze() {
        return this.zzc;
    }

    public final Integer zzf() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zza;
    }
}
