package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class zzdu implements zzap {
    static final /* synthetic */ zzdu zza = new zzdu();

    private /* synthetic */ zzdu() {
    }

    @Override // com.google.android.gms.internal.games_v2.zzap
    public final /* synthetic */ Task zza(GoogleApi googleApi) {
        return googleApi.doRead(TaskApiCall.builder().run(zzea.zza).setMethodKey(6710).build());
    }
}
