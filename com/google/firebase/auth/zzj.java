package com.google.firebase.auth;

/* JADX INFO: loaded from: classes.dex */
public final class zzj implements Runnable {
    public final /* synthetic */ FirebaseAuth.IdTokenListener zza;
    public final /* synthetic */ FirebaseAuth zzb;

    public zzj(FirebaseAuth firebaseAuth, FirebaseAuth.IdTokenListener idTokenListener) {
        this.zzb = firebaseAuth;
        this.zza = idTokenListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.onIdTokenChanged(this.zzb);
    }
}
