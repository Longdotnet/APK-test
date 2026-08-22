package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class zzdj implements zzap {
    private final /* synthetic */ String zza;
    private final /* synthetic */ int zzb;
    private final /* synthetic */ int zzc;
    private final /* synthetic */ int zzd;
    private final /* synthetic */ boolean zze;

    public /* synthetic */ zzdj(String str, int i, int i2, int i3, boolean z) {
        this.zza = str;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = z;
    }

    @Override // com.google.android.gms.internal.games_v2.zzap
    public final /* synthetic */ Task zza(GoogleApi googleApi) {
        TaskApiCall.Builder builder = TaskApiCall.builder();
        final String str = this.zza;
        final int i = this.zzb;
        final int i2 = this.zzc;
        final int i3 = this.zzd;
        final boolean z = this.zze;
        return googleApi.doRead(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzda
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                ((com.google.android.gms.games.internal.zzah) obj).zzx((TaskCompletionSource) obj2, str, i, i2, i3, z);
            }
        }).setMethodKey(6704).build());
    }
}
