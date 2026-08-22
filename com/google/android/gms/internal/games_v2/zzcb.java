package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class zzcb implements zzap {
    private final /* synthetic */ String zza;
    private final /* synthetic */ int zzb;

    public /* synthetic */ zzcb(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }

    @Override // com.google.android.gms.internal.games_v2.zzap
    public final /* synthetic */ Task zza(GoogleApi googleApi) {
        TaskApiCall.Builder builder = TaskApiCall.builder();
        final String str = this.zza;
        final int i = this.zzb;
        return googleApi.doWrite(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzcc
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                ((com.google.android.gms.games.internal.zzah) obj).zzF((TaskCompletionSource) obj2, str, i);
            }
        }).setMethodKey(6697).build());
    }
}
