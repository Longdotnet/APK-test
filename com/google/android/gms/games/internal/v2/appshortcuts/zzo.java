package com.google.android.gms.games.internal.v2.appshortcuts;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class zzo implements RemoteCall {
    public final /* synthetic */ zzq zza;
    public final /* synthetic */ zzr zzb;
    public final /* synthetic */ zzi zzc;

    public /* synthetic */ zzo(zzq zzqVar, zzr zzrVar, zzi zziVar) {
        this.zza = zzqVar;
        this.zzb = zzrVar;
        this.zzc = zziVar;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        zzv zzvVar = (zzv) ((zzu) obj).getService();
        Objects.requireNonNull(this.zza);
        zzvVar.zze(new zzm((TaskCompletionSource) obj2), this.zzb, this.zzc);
    }
}
