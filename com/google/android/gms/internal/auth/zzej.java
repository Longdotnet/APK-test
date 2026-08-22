package com.google.android.gms.internal.auth;

/* JADX INFO: loaded from: classes.dex */
final class zzej {
    private static final zzeh<?> zza = new zzei();
    private static final zzeh<?> zzb;

    static {
        zzeh<?> zzehVar = null;
        try {
            zzehVar = (zzeh) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        zzb = zzehVar;
    }

    public static zzeh<?> zza() {
        zzeh<?> zzehVar = zzb;
        if (zzehVar != null) {
            return zzehVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static zzeh<?> zzb() {
        return zza;
    }
}
