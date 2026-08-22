package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: loaded from: classes.dex */
final class zzak extends zzal {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzal zzc;

    public zzak(zzal zzalVar, int i, int i2) {
        this.zzc = zzalVar;
        this.zza = i;
        this.zzb = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzy.zza(i, this.zzb, FirebaseAnalytics.Param.INDEX);
        return this.zzc.get(i + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai
    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai
    public final Object[] zze() {
        return this.zzc.zze();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzal, java.util.List
    /* JADX INFO: renamed from: zzf */
    public final zzal subList(int i, int i2) {
        zzy.zzc(i, i2, this.zzb);
        zzal zzalVar = this.zzc;
        int i3 = this.zza;
        return zzalVar.subList(i + i3, i2 + i3);
    }
}
