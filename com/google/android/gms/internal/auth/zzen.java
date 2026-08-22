package com.google.android.gms.internal.auth;

/* JADX INFO: loaded from: classes.dex */
final class zzen implements zzfo {
    private static final zzen zza = new zzen();

    private zzen() {
    }

    public static zzen zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.auth.zzfo
    public final zzfn zzb(Class<?> cls) {
        if (!zzeq.class.isAssignableFrom(cls)) {
            String name = cls.getName();
            throw new IllegalArgumentException(name.length() != 0 ? "Unsupported message type: ".concat(name) : new String("Unsupported message type: "));
        }
        try {
            return (zzfn) zzeq.zza(cls.asSubclass(zzeq.class)).zzj(3, null, null);
        } catch (Exception e) {
            String name2 = cls.getName();
            throw new RuntimeException(name2.length() != 0 ? "Unable to get message info for ".concat(name2) : new String("Unable to get message info for "), e);
        }
    }

    @Override // com.google.android.gms.internal.auth.zzfo
    public final boolean zzc(Class<?> cls) {
        return zzeq.class.isAssignableFrom(cls);
    }
}
