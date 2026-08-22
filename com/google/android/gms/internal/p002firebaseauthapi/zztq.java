package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.internal.zzai;

/* JADX INFO: loaded from: classes.dex */
final class zztq implements zzyg {
    final /* synthetic */ EmailAuthCredential zza;
    final /* synthetic */ zzxa zzb;
    final /* synthetic */ zzvf zzc;

    public zztq(zzvf zzvfVar, EmailAuthCredential emailAuthCredential, zzxa zzxaVar) {
        this.zzc = zzvfVar;
        this.zza = emailAuthCredential;
        this.zzb = zzxaVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyf
    public final void zza(String str) {
        this.zzb.zzh(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyg
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzc.zzN(new zzzg(this.zza, ((zzzy) obj).zze()), this.zzb);
    }
}
