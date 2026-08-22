package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class zzdm implements zzap {
    private final /* synthetic */ String zza;
    private final /* synthetic */ long zzb;

    public /* synthetic */ zzdm(String str, long j) {
        this.zza = str;
        this.zzb = j;
    }

    @Override // com.google.android.gms.internal.games_v2.zzap
    public final /* synthetic */ Task zza(GoogleApi googleApi) {
        TaskApiCall.Builder builder = TaskApiCall.builder();
        final String str = this.zza;
        final long j = this.zzb;
        return googleApi.doWrite(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzcx
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                ((com.google.android.gms.games.internal.zzah) obj).zzA((TaskCompletionSource) obj2, str, j, null);
            }
        }).setMethodKey(6707).build());
    }
}
