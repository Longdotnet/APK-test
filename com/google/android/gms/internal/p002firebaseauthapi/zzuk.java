package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.firebase.auth.internal.zzai;

/* JADX INFO: loaded from: classes.dex */
final class zzuk implements zzyg {
    final /* synthetic */ zzul zza;

    public zzuk(zzul zzulVar) {
        this.zza = zzulVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyf
    public final void zza(String str) {
        this.zza.zzb.zzh(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyg
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzabj zzabjVar = (zzabj) obj;
        if (TextUtils.isEmpty(zzabjVar.zzb()) || TextUtils.isEmpty(zzabjVar.zzc())) {
            this.zza.zzb.zzh(zzai.zza("INTERNAL_SUCCESS_SIGN_OUT"));
            return;
        }
        zzzy zzzyVar = new zzzy(zzabjVar.zzc(), zzabjVar.zzb(), Long.valueOf(zzaaa.zza(zzabjVar.zzb())), "Bearer");
        zzul zzulVar = this.zza;
        zzulVar.zzc.zzO(zzzyVar, null, null, Boolean.FALSE, null, zzulVar.zzb, this);
    }
}
