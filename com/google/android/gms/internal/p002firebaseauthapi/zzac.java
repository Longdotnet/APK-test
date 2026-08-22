package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class zzac implements zzae {
    final /* synthetic */ zzq zza;

    public zzac(zzq zzqVar) {
        this.zza = zzqVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzae
    public final /* bridge */ /* synthetic */ Iterator zza(zzaf zzafVar, CharSequence charSequence) {
        return new zzab(this, zzafVar, charSequence, this.zza.zza(charSequence));
    }
}
