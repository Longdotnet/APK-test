package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
final class zzaeq {
    private static final zzaep zza;
    private static final zzaep zzb;

    static {
        zzaep zzaepVar = null;
        try {
            zzaepVar = (zzaep) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        zza = zzaepVar;
        zzb = new zzaep();
    }

    public static zzaep zza() {
        return zza;
    }

    public static zzaep zzb() {
        return zzb;
    }
}
