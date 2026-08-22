package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class zzch implements zzap {
    static final /* synthetic */ zzch zza = new zzch();

    private /* synthetic */ zzch() {
    }

    @Override // com.google.android.gms.internal.games_v2.zzap
    public final /* synthetic */ Task zza(GoogleApi googleApi) {
        return googleApi.doRead(TaskApiCall.builder().run(zzci.zza).setMethodKey(6692).build());
    }
}
