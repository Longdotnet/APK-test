package com.google.firebase.auth;

/* JADX INFO: loaded from: classes.dex */
public final class zzk implements Runnable {
    public final /* synthetic */ FirebaseAuth.AuthStateListener zza;
    public final /* synthetic */ FirebaseAuth zzb;

    public zzk(FirebaseAuth firebaseAuth, FirebaseAuth.AuthStateListener authStateListener) {
        this.zzb = firebaseAuth;
        this.zza = authStateListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.onAuthStateChanged(this.zzb);
    }
}
