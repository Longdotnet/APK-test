package com.google.android.gms.games;

/* JADX INFO: loaded from: classes.dex */
public final class AuthenticationResult {
    public static final AuthenticationResult zza = new AuthenticationResult(true);
    public static final AuthenticationResult zzb = new AuthenticationResult(false);
    public final boolean zzc;

    public AuthenticationResult(boolean z) {
        this.zzc = z;
    }

    public boolean isAuthenticated() {
        return this.zzc;
    }
}
