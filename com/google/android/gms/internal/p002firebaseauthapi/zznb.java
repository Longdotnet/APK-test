package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
public final class zznb {
    private static final zzadi zza = new zzna();

    public static /* synthetic */ String zza(int i) {
        if (i == 2) {
            return "KEM_UNKNOWN";
        }
        if (i == 3) {
            return "DHKEM_X25519_HKDF_SHA256";
        }
        if (i == 4) {
            return "DHKEM_P256_HKDF_SHA256";
        }
        if (i != 5) {
            return i != 6 ? "UNRECOGNIZED" : "DHKEM_P521_HKDF_SHA512";
        }
        return "DHKEM_P384_HKDF_SHA384";
    }
}
