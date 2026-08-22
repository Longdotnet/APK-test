package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public class zzbeo {
    private final String zza;
    private final Object zzb;
    private final int zzc;

    public zzbeo(String str, Object obj, int i) {
        this.zza = str;
        this.zzb = obj;
        this.zzc = i;
    }

    public static zzbeo zza(String str, double d) {
        return new zzbeo(str, Double.valueOf(d), 3);
    }

    public static zzbeo zzb(String str, long j) {
        return new zzbeo(str, Long.valueOf(j), 2);
    }

    public static zzbeo zzc(String str, String str2) {
        return new zzbeo("gad:dynamite_module:experiment_id", "", 4);
    }

    public static zzbeo zzd(String str, boolean z) {
        return new zzbeo(str, Boolean.valueOf(z), 1);
    }

    public final Object zze() {
        zzbft zzbftVarZza = zzbfv.zza();
        if (zzbftVarZza == null) {
            if (zzbfv.zzb() != null) {
                zzbfv.zzb().zza();
            }
            return this.zzb;
        }
        int i = this.zzc - 1;
        if (i == 0) {
            return zzbftVarZza.zza(this.zza, ((Boolean) this.zzb).booleanValue());
        }
        if (i != 1) {
            return i != 2 ? zzbftVarZza.zzd(this.zza, (String) this.zzb) : zzbftVarZza.zzb(this.zza, ((Double) this.zzb).doubleValue());
        }
        return zzbftVarZza.zzc(this.zza, ((Long) this.zzb).longValue());
    }
}
