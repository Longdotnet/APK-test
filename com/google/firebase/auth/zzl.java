package com.google.firebase.auth;

import com.google.firebase.auth.internal.IdTokenListener;
import com.google.firebase.internal.InternalTokenResult;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class zzl implements Runnable {
    public final /* synthetic */ FirebaseAuth zza;
    public final /* synthetic */ InternalTokenResult zzb;

    public zzl(FirebaseAuth firebaseAuth, InternalTokenResult internalTokenResult) {
        this.zza = firebaseAuth;
        this.zzb = internalTokenResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FirebaseAuth firebaseAuth = this.zza;
        Iterator it = firebaseAuth.zzc.iterator();
        while (it.hasNext()) {
            ((IdTokenListener) it.next()).onIdTokenChanged(this.zzb);
        }
        Iterator it2 = firebaseAuth.zzb.iterator();
        while (it2.hasNext()) {
            ((FirebaseAuth.IdTokenListener) it2.next()).onIdTokenChanged(firebaseAuth);
        }
    }
}
