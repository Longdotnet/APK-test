package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
final class zzaeg {
    private static final zzaef zza;
    private static final zzaef zzb;

    static {
        zzaef zzaefVar = null;
        try {
            zzaefVar = (zzaef) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        zza = zzaefVar;
        zzb = new zzaef();
    }

    public static zzaef zza() {
        return zza;
    }

    public static zzaef zzb() {
        return zzb;
    }
}
