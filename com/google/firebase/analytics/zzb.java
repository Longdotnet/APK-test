package com.google.firebase.analytics;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzb implements Callable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ FirebaseAnalytics zza;

    public /* synthetic */ zzb(FirebaseAnalytics firebaseAnalytics, int i) {
        this.$r8$classId = i;
        this.zza = firebaseAnalytics;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        switch (this.$r8$classId) {
            case 0:
                return this.zza.zzb.zzl();
            default:
                return this.zza.zzb.zzh();
        }
    }
}
