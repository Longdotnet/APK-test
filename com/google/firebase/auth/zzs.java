package com.google.firebase.auth;

import com.google.android.gms.internal.p002firebaseauthapi.zzzy;

/* JADX INFO: loaded from: classes.dex */
public class zzs implements com.google.firebase.auth.internal.zzg {
    public final /* synthetic */ FirebaseAuth zza;

    public zzs(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    @Override // com.google.firebase.auth.internal.zzg
    public final void zza(zzzy zzzyVar, FirebaseUser firebaseUser) {
        com.google.android.gms.common.internal.zzah.checkNotNull(zzzyVar);
        com.google.android.gms.common.internal.zzah.checkNotNull(firebaseUser);
        firebaseUser.zzh(zzzyVar);
        this.zza.zzE(firebaseUser, zzzyVar, true);
    }
}
