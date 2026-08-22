package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
final class zzej {
    private static final zzei zza;
    private static final zzei zzb;

    static {
        zzei zzeiVar = null;
        try {
            zzeiVar = (zzei) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        zza = zzeiVar;
        zzb = new zzei();
    }

    public static zzei zza() {
        return zza;
    }

    public static zzei zzb() {
        return zzb;
    }
}
