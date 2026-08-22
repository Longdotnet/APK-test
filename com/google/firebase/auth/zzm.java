package com.google.firebase.auth;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class zzm implements Runnable {
    public final /* synthetic */ FirebaseAuth zza;

    public zzm(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FirebaseAuth firebaseAuth = this.zza;
        Iterator it = firebaseAuth.zzd.iterator();
        while (it.hasNext()) {
            ((FirebaseAuth.AuthStateListener) it.next()).onAuthStateChanged(firebaseAuth);
        }
    }
}
