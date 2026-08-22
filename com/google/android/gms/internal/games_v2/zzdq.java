package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.LeaderboardsClient;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public final class zzdq implements LeaderboardsClient {
    private final zzaq zza;

    public zzdq(zzaq zzaqVar) {
        this.zza = zzaqVar;
    }

    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task getAllLeaderboardsIntent() {
        return this.zza.zzb(zzdp.zza);
    }

    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task getLeaderboardIntent(String str) {
        return getLeaderboardIntent(str, -1, -1);
    }

    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task loadCurrentPlayerLeaderboardScore(final String str, final int i, final int i2) {
        return this.zza.zzb(new zzap() { // from class: com.google.android.gms.internal.games_v2.zzdi
            @Override // com.google.android.gms.internal.games_v2.zzap
            public final /* synthetic */ Task zza(GoogleApi googleApi) {
                TaskApiCall.Builder builder = TaskApiCall.builder();
                final String str2 = str;
                final int i3 = i;
                final int i4 = i2;
                return googleApi.doRead(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzdb
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final /* synthetic */ void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzah) obj).zzw((TaskCompletionSource) obj2, str2, i3, i4);
                    }
                }).setMethodKey(6703).build());
            }
        });
    }

    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task loadLeaderboardMetadata(final String str, final boolean z) {
        return this.zza.zzb(new zzap() { // from class: com.google.android.gms.internal.games_v2.zzdh
            @Override // com.google.android.gms.internal.games_v2.zzap
            public final /* synthetic */ Task zza(GoogleApi googleApi) {
                TaskApiCall.Builder builder = TaskApiCall.builder();
                final String str2 = str;
                final boolean z2 = z;
                return googleApi.doRead(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzdc
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final /* synthetic */ void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzah) obj).zzv((TaskCompletionSource) obj2, str2, z2);
                    }
                }).setMethodKey(6702).build());
            }
        });
    }

    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task loadMoreScores(final LeaderboardScoreBuffer leaderboardScoreBuffer, final int i, final int i2) {
        return this.zza.zzb(new zzap() { // from class: com.google.android.gms.internal.games_v2.zzdl
            @Override // com.google.android.gms.internal.games_v2.zzap
            public final /* synthetic */ Task zza(GoogleApi googleApi) {
                TaskApiCall.Builder builder = TaskApiCall.builder();
                final LeaderboardScoreBuffer leaderboardScoreBuffer2 = leaderboardScoreBuffer;
                final int i3 = i;
                final int i4 = i2;
                return googleApi.doRead(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzcy
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final /* synthetic */ void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzah) obj).zzz((TaskCompletionSource) obj2, leaderboardScoreBuffer2, i3, i4);
                    }
                }).setMethodKey(6706).build());
            }
        });
    }

    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task loadPlayerCenteredScores(String str, int i, int i2, int i3) {
        return this.zza.zzb(new zzdk(str, i, i2, i3, false));
    }

    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task loadTopScores(String str, int i, int i2, int i3) {
        return this.zza.zzb(new zzdj(str, i, i2, i3, false));
    }

    @Override // com.google.android.gms.games.LeaderboardsClient
    public final void submitScore(String str, long j) {
        this.zza.zzb(new zzdm(str, j));
    }

    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task submitScoreImmediate(String str, long j) {
        return this.zza.zzb(new zzdm(str, j));
    }

    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task getLeaderboardIntent(String str, int i) {
        return getLeaderboardIntent(str, i, -1);
    }

    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task loadLeaderboardMetadata(final boolean z) {
        return this.zza.zzb(new zzap() { // from class: com.google.android.gms.internal.games_v2.zzdg
            @Override // com.google.android.gms.internal.games_v2.zzap
            public final /* synthetic */ Task zza(GoogleApi googleApi) {
                TaskApiCall.Builder builder = TaskApiCall.builder();
                final boolean z2 = z;
                return googleApi.doRead(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzdd
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final /* synthetic */ void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzah) obj).zzu((TaskCompletionSource) obj2, z2);
                    }
                }).setMethodKey(6702).build());
            }
        });
    }

    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task loadPlayerCenteredScores(String str, int i, int i2, int i3, boolean z) {
        return this.zza.zzb(new zzdk(str, i, i2, i3, z));
    }

    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task loadTopScores(String str, int i, int i2, int i3, boolean z) {
        return this.zza.zzb(new zzdj(str, i, i2, i3, z));
    }

    @Override // com.google.android.gms.games.LeaderboardsClient
    public final void submitScore(String str, long j, String str2) {
        this.zza.zzb(new zzdn(str, j, str2));
    }

    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task submitScoreImmediate(String str, long j, String str2) {
        return this.zza.zzb(new zzdn(str, j, str2));
    }

    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task getLeaderboardIntent(final String str, final int i, final int i2) {
        return this.zza.zzb(new zzap() { // from class: com.google.android.gms.internal.games_v2.zzcw
            @Override // com.google.android.gms.internal.games_v2.zzap
            public final /* synthetic */ Task zza(GoogleApi googleApi) {
                TaskApiCall.Builder builder = TaskApiCall.builder();
                final String str2 = str;
                final int i3 = i;
                final int i4 = i2;
                return googleApi.doRead(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzde
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final /* synthetic */ void accept(Object obj, Object obj2) {
                        ((TaskCompletionSource) obj2).setResult(((com.google.android.gms.games.internal.zzam) ((com.google.android.gms.games.internal.zzah) obj).getService()).zzP(str2, i3, i4));
                    }
                }).setMethodKey(6701).build());
            }
        });
    }
}
