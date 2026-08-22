package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgox implements zzgpb {
    private final String zza;
    private final zzgxe zzb;
    private final zzgxz zzc;
    private final zzgtz zzd;
    private final zzgvf zze;
    private final Integer zzf;

    private zzgox(String str, zzgxe zzgxeVar, zzgxz zzgxzVar, zzgtz zzgtzVar, zzgvf zzgvfVar, Integer num) {
        this.zza = str;
        this.zzb = zzgxeVar;
        this.zzc = zzgxzVar;
        this.zzd = zzgtzVar;
        this.zze = zzgvfVar;
        this.zzf = num;
    }

    public static zzgox zza(String str, zzgxz zzgxzVar, zzgtz zzgtzVar, zzgvf zzgvfVar, Integer num) {
        if (zzgvfVar == zzgvf.RAW) {
            if (num != null) {
                throw new GeneralSecurityException("Keys with output prefix type raw should not have an id requirement.");
            }
        } else if (num == null) {
            throw new GeneralSecurityException("Keys with output prefix type different from raw should have an id requirement.");
        }
        return new zzgox(str, zzgpj.zza(str), zzgxzVar, zzgtzVar, zzgvfVar, num);
    }

    public final zzgtz zzb() {
        return this.zzd;
    }

    public final zzgvf zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzgpb
    public final zzgxe zzd() {
        return this.zzb;
    }

    public final zzgxz zze() {
        return this.zzc;
    }

    public final Integer zzf() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zza;
    }
}
