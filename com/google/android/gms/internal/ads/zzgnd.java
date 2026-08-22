package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgnd extends zzgez {
    private final zzgox zza;
    private final zzgxe zzb;

    public zzgnd(zzgox zzgoxVar, zzgfn zzgfnVar) throws GeneralSecurityException {
        zzgxe zzgxeVarZza;
        zze(zzgoxVar, zzgfnVar);
        this.zza = zzgoxVar;
        if (zzgoxVar.zzc().equals(zzgvf.RAW)) {
            zzgxeVarZza = zzgxe.zzb(new byte[0]);
        } else if (zzgoxVar.zzc().equals(zzgvf.TINK)) {
            zzgxeVarZza = zzgnz.zzb(zzgoxVar.zzf().intValue());
        } else {
            if (!zzgoxVar.zzc().equals(zzgvf.LEGACY) && !zzgoxVar.zzc().equals(zzgvf.CRUNCHY)) {
                throw new GeneralSecurityException("Unknown output prefix type");
            }
            zzgxeVarZza = zzgnz.zza(zzgoxVar.zzf().intValue());
        }
        this.zzb = zzgxeVarZza;
    }

    private static void zze(zzgox zzgoxVar, zzgfn zzgfnVar) {
        int i = zzgna.zzb[zzgoxVar.zzb().ordinal()];
    }

    @Override // com.google.android.gms.internal.ads.zzgez
    public final zzgfm zza() {
        zzgox zzgoxVar = this.zza;
        return new zzgnb(zzgoxVar.zzg(), zzgoxVar.zzc(), null);
    }

    public final zzgox zzb(zzgfn zzgfnVar) {
        zzgox zzgoxVar = this.zza;
        zze(zzgoxVar, zzgfnVar);
        return zzgoxVar;
    }

    public final zzgxe zzc() {
        return this.zzb;
    }

    public final Integer zzd() {
        return this.zza.zzf();
    }
}
