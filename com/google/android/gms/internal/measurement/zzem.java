package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.util.concurrent.dN.MnHfHMYQDPUO;

/* JADX INFO: loaded from: classes2.dex */
public final class zzem extends zzkf implements zzln {
    private static final zzem zza;
    private int zzd;
    private zzey zze;
    private zzer zzf;
    private boolean zzg;
    private String zzh = "";

    static {
        zzem zzemVar = new zzem();
        zza = zzemVar;
        zzkf.zzbL(zzem.class, zzemVar);
    }

    private zzem() {
    }

    public static zzem zzb() {
        return zza;
    }

    public static /* synthetic */ void zzf(zzem zzemVar, String str) {
        zzemVar.zzd |= 8;
        zzemVar.zzh = str;
    }

    public final zzer zzc() {
        zzer zzerVar = this.zzf;
        return zzerVar == null ? zzer.zzb() : zzerVar;
    }

    public final zzey zzd() {
        zzey zzeyVar = this.zze;
        return zzeyVar == null ? zzey.zzc() : zzeyVar;
    }

    public final String zze() {
        return this.zzh;
    }

    public final boolean zzg() {
        return this.zzg;
    }

    public final boolean zzh() {
        return (this.zzd & 4) != 0;
    }

    public final boolean zzi() {
        return (this.zzd & 2) != 0;
    }

    public final boolean zzj() {
        return (this.zzd & 8) != 0;
    }

    public final boolean zzk() {
        return (this.zzd & 1) != 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzkf
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzkf.zzbI(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zzd", "zze", MnHfHMYQDPUO.NUXl, "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzem();
        }
        zzeg zzegVar = null;
        if (i2 == 4) {
            return new zzel(zzegVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
