package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class zzez implements RemoteCall {
    static final /* synthetic */ zzez zza = new zzez();

    private /* synthetic */ zzez() {
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final /* synthetic */ void accept(Object obj, Object obj2) {
        ((TaskCompletionSource) obj2).setResult(Integer.valueOf(((com.google.android.gms.games.internal.zzam) ((com.google.android.gms.games.internal.zzah) obj).getService()).zzF()));
    }
}
