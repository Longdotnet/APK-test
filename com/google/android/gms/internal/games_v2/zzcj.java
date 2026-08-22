package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.AchievementsClient;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public final class zzcj implements AchievementsClient {
    private final zzaq zza;

    public zzcj(zzaq zzaqVar) {
        this.zza = zzaqVar;
    }

    @Override // com.google.android.gms.games.AchievementsClient
    public final Task getAchievementsIntent() {
        return this.zza.zzb(zzch.zza);
    }

    @Override // com.google.android.gms.games.AchievementsClient
    public final void increment(String str, int i) {
        this.zza.zzb(new zzca(str, i));
    }

    @Override // com.google.android.gms.games.AchievementsClient
    public final Task incrementImmediate(String str, int i) {
        return this.zza.zzb(new zzca(str, i));
    }

    @Override // com.google.android.gms.games.AchievementsClient
    public final Task load(final boolean z) {
        return this.zza.zzb(new zzap() { // from class: com.google.android.gms.internal.games_v2.zzbx
            @Override // com.google.android.gms.internal.games_v2.zzap
            public final /* synthetic */ Task zza(GoogleApi googleApi) {
                TaskApiCall.Builder builder = TaskApiCall.builder();
                final boolean z2 = z;
                return googleApi.doRead(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzcg
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final /* synthetic */ void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzah) obj).zzB((TaskCompletionSource) obj2, z2);
                    }
                }).setMethodKey(6693).build());
            }
        });
    }

    @Override // com.google.android.gms.games.AchievementsClient
    public final void reveal(String str) {
        this.zza.zzb(new zzby(str));
    }

    @Override // com.google.android.gms.games.AchievementsClient
    public final Task revealImmediate(String str) {
        return this.zza.zzb(new zzby(str));
    }

    @Override // com.google.android.gms.games.AchievementsClient
    public final void setSteps(String str, int i) {
        this.zza.zzb(new zzcb(str, i));
    }

    @Override // com.google.android.gms.games.AchievementsClient
    public final Task setStepsImmediate(String str, int i) {
        return this.zza.zzb(new zzcb(str, i));
    }

    @Override // com.google.android.gms.games.AchievementsClient
    public final void unlock(String str) {
        this.zza.zzb(new zzbz(str));
    }

    @Override // com.google.android.gms.games.AchievementsClient
    public final Task unlockImmediate(String str) {
        return this.zza.zzb(new zzbz(str));
    }
}
