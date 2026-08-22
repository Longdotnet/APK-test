package com.google.android.gms.internal.auth;

/* JADX INFO: loaded from: classes.dex */
final class zzfw {
    private static final zzfv zza;
    private static final zzfv zzb;

    static {
        zzfv zzfvVar = null;
        try {
            zzfvVar = (zzfv) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        zza = zzfvVar;
        zzb = new zzfv();
    }

    public static zzfv zza() {
        return zza;
    }

    public static zzfv zzb() {
        return zzb;
    }
}
