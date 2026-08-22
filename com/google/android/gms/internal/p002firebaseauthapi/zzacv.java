package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
final class zzacv {
    private static final zzact zza = new zzacu();
    private static final zzact zzb;

    static {
        zzact zzactVar = null;
        try {
            zzactVar = (zzact) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        zzb = zzactVar;
    }

    public static zzact zza() {
        zzact zzactVar = zzb;
        if (zzactVar != null) {
            return zzactVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static zzact zzb() {
        return zza;
    }
}
