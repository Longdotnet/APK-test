package com.google.android.gms.internal.play_billing;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: loaded from: classes.dex */
final class zzah extends zzai {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzai zzc;

    public zzah(zzai zzaiVar, int i, int i2) {
        this.zzc = zzaiVar;
        this.zza = i;
        this.zzb = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzaa.zza(i, this.zzb, FirebaseAnalytics.Param.INDEX);
        return this.zzc.get(i + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.play_billing.zzaf
    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.play_billing.zzaf
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.play_billing.zzaf
    public final boolean zzf() {
        return true;
    }

    @Override // com.google.android.gms.internal.play_billing.zzaf
    public final Object[] zzg() {
        return this.zzc.zzg();
    }

    @Override // com.google.android.gms.internal.play_billing.zzai, java.util.List
    /* JADX INFO: renamed from: zzh */
    public final zzai subList(int i, int i2) {
        zzaa.zzd(i, i2, this.zzb);
        int i3 = this.zza;
        return this.zzc.subList(i + i3, i2 + i3);
    }
}
