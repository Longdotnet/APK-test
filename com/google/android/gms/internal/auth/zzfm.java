package com.google.android.gms.internal.auth;

/* JADX INFO: loaded from: classes.dex */
final class zzfm {
    private static final zzfl zza;
    private static final zzfl zzb;

    static {
        zzfl zzflVar = null;
        try {
            zzflVar = (zzfl) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        zza = zzflVar;
        zzb = new zzfl();
    }

    public static zzfl zza() {
        return zza;
    }

    public static zzfl zzb() {
        return zzb;
    }
}
