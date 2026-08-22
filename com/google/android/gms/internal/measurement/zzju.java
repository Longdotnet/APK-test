package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zzju {
    private static final zzjs zza = new zzjt();
    private static final zzjs zzb;

    static {
        zzjs zzjsVar = null;
        try {
            zzjsVar = (zzjs) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        zzb = zzjsVar;
    }

    public static zzjs zza() {
        zzjs zzjsVar = zzb;
        if (zzjsVar != null) {
            return zzjsVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static zzjs zzb() {
        return zza;
    }
}
