package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
public final class zzbf {
    private final zznx zza;

    private zzbf(zznx zznxVar) {
        this.zza = zznxVar;
    }

    public static zzbf zze(String str, byte[] bArr, int i) {
        zzoy zzoyVar;
        zznw zznwVarZza = zznx.zza();
        zznwVarZza.zzb(str);
        zznwVarZza.zzc(zzacc.zzn(bArr));
        int i2 = i - 1;
        if (i2 == 0) {
            zzoyVar = zzoy.TINK;
        } else if (i2 != 1) {
            zzoyVar = i2 != 2 ? zzoy.CRUNCHY : zzoy.RAW;
        } else {
            zzoyVar = zzoy.LEGACY;
        }
        zznwVarZza.zza(zzoyVar);
        return new zzbf((zznx) zznwVarZza.zzi());
    }

    public final zznx zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zza.zzf();
    }

    public final byte[] zzc() {
        return this.zza.zze().zzt();
    }

    public final int zzd() {
        zzoy zzoyVarZzd = this.zza.zzd();
        zzoy zzoyVar = zzoy.UNKNOWN_PREFIX;
        int iOrdinal = zzoyVarZzd.ordinal();
        int i = 1;
        if (iOrdinal != 1) {
            i = 2;
            if (iOrdinal != 2) {
                i = 3;
                if (iOrdinal != 3) {
                    if (iOrdinal == 4) {
                        return 4;
                    }
                    throw new IllegalArgumentException("Unknown output prefix type");
                }
            }
        }
        return i;
    }
}
