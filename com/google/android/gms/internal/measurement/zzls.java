package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zzls {
    private static final zzlr zza;
    private static final zzlr zzb;

    static {
        zzlr zzlrVar = null;
        try {
            zzlrVar = (zzlr) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        zza = zzlrVar;
        zzb = new zzlr();
    }

    public static zzlr zza() {
        return zza;
    }

    public static zzlr zzb() {
        return zzb;
    }
}
