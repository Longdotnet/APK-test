package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.PhoneAuthProvider;

/* JADX INFO: loaded from: classes.dex */
final class zzxx implements Runnable {
    final /* synthetic */ zzxz zza;
    final /* synthetic */ zzxy zzb;

    public zzxx(zzxy zzxyVar, zzxz zzxzVar) {
        this.zzb = zzxyVar;
        this.zza = zzxzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzb.zza.zzh) {
            try {
                if (!this.zzb.zza.zzh.isEmpty()) {
                    this.zza.zza((PhoneAuthProvider.OnVerificationStateChangedCallbacks) this.zzb.zza.zzh.get(0), new Object[0]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
