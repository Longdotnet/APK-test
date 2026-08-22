package com.google.android.gms.internal.games_v2;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.RecallClient;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.TaskExecutors;

/* JADX INFO: loaded from: classes.dex */
public final class zzer extends GoogleApi implements RecallClient {
    private static final Api.ClientKey zza;
    private static final Api.AbstractClientBuilder zzb;
    private static final Api zzc;
    private final zzaw zzd;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zza = clientKey;
        zzen zzenVar = new zzen();
        zzb = zzenVar;
        zzc = new Api("Recall.API", zzenVar, clientKey);
    }

    public zzer(Context context, zzaw zzawVar) {
        super(context, (Api<Api.ApiOptions.NoOptions>) zzc, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.zzd = zzawVar;
    }

    @Override // com.google.android.gms.games.RecallClient
    public final Task requestRecallAccess() {
        final TaskApiCall taskApiCallBuild = TaskApiCall.builder().setMethodKey(6742).setAutoResolveMissingFeatures(false).setFeatures(com.google.android.gms.games.zzd.zze).run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzeq
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                ((zzal) ((zzfm) obj).getService()).zzd(new zzeo(this.zza, (TaskCompletionSource) obj2), "unusedServerClientId");
            }
        }).build();
        Task taskZzd = this.zzd.zzd();
        SuccessContinuation successContinuation = new SuccessContinuation() { // from class: com.google.android.gms.internal.games_v2.zzep
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final /* synthetic */ Task then(Object obj) {
                return this.zza.doRead(taskApiCallBuild);
            }
        };
        com.google.android.gms.tasks.zzw zzwVar = (com.google.android.gms.tasks.zzw) taskZzd;
        zzwVar.getClass();
        com.google.android.gms.tasks.zzu zzuVar = TaskExecutors.MAIN_THREAD;
        com.google.android.gms.tasks.zzw zzwVar2 = new com.google.android.gms.tasks.zzw();
        zzwVar.zzb.zza(new com.google.android.gms.tasks.zzh(zzuVar, successContinuation, zzwVar2));
        zzwVar.zzi();
        return zzwVar2;
    }
}
