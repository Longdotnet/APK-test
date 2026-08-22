package com.google.android.gms.internal.games_v2;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.PlayersClient;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public final class zzem implements PlayersClient {
    private final zzaq zza;

    public zzem(zzaq zzaqVar) {
        this.zza = zzaqVar;
    }

    private final Task zza(final String str, final int i, final boolean z) {
        return this.zza.zzb(new zzap() { // from class: com.google.android.gms.internal.games_v2.zzeh
            @Override // com.google.android.gms.internal.games_v2.zzap
            public final /* synthetic */ Task zza(GoogleApi googleApi) {
                TaskApiCall.Builder builder = TaskApiCall.builder();
                final String str2 = str;
                final int i2 = i;
                final boolean z2 = z;
                return googleApi.doRead(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzek
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final /* synthetic */ void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzah) obj).zzt((TaskCompletionSource) obj2, str2, i2, false, z2);
                    }
                }).setMethodKey(6715).build());
            }
        });
    }

    private final Task zzb(final String str, final int i) {
        return this.zza.zzb(new zzap() { // from class: com.google.android.gms.internal.games_v2.zzei
            @Override // com.google.android.gms.internal.games_v2.zzap
            public final /* synthetic */ Task zza(GoogleApi googleApi) {
                TaskApiCall.Builder builder = TaskApiCall.builder();
                final String str2 = str;
                final int i2 = i;
                return googleApi.doRead(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzej
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final /* synthetic */ void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzah) obj).zzt((TaskCompletionSource) obj2, str2, i2, true, false);
                    }
                }).setMethodKey(6716).build());
            }
        });
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task getCompareProfileIntent(final Player player) {
        return this.zza.zzb(new zzap() { // from class: com.google.android.gms.internal.games_v2.zzef
            @Override // com.google.android.gms.internal.games_v2.zzap
            public final /* synthetic */ Task zza(GoogleApi googleApi) {
                TaskApiCall.Builder builder = TaskApiCall.builder();
                final Player player2 = player;
                return googleApi.doRead(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzdw
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final /* synthetic */ void accept(Object obj, Object obj2) {
                        Intent intentZzN = ((com.google.android.gms.games.internal.zzam) ((com.google.android.gms.games.internal.zzah) obj).getService()).zzN(new PlayerEntity(player2));
                        intentZzN.setExtrasClassLoader(PlayerEntity.class.getClassLoader());
                        ((TaskCompletionSource) obj2).setResult(intentZzN);
                    }
                }).setMethodKey(6713).build());
            }
        });
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task getCompareProfileIntentWithAlternativeNameHints(String str, String str2, String str3) {
        return this.zza.zzb(new zzee(str, str2, str3));
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task getCurrentPlayer() {
        return this.zza.zzb(zzdu.zza);
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task getCurrentPlayerId() {
        return this.zza.zzb(zzel.zza);
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task getPlayerSearchIntent() {
        return this.zza.zzb(zzeg.zza);
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task loadFriends(int i, boolean z) {
        return zza("friends_all", i, z);
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task loadMoreFriends(int i) {
        return zzb("friends_all", i);
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task loadMoreRecentlyPlayedWithPlayers(int i) {
        return zzb("played_with", i);
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task loadPlayer(String str) {
        return this.zza.zzb(new zzed(str, false));
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task loadRecentlyPlayedWithPlayers(int i, boolean z) {
        return zza("played_with", i, z);
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task getCompareProfileIntent(String str) {
        return this.zza.zzb(new zzee(str, null, null));
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task getCurrentPlayer(final boolean z) {
        return this.zza.zzb(new zzap() { // from class: com.google.android.gms.internal.games_v2.zzec
            @Override // com.google.android.gms.internal.games_v2.zzap
            public final /* synthetic */ Task zza(GoogleApi googleApi) {
                TaskApiCall.Builder builder = TaskApiCall.builder();
                final boolean z2 = z;
                return googleApi.doRead(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzdz
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final /* synthetic */ void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzah) obj).zzr((TaskCompletionSource) obj2, z2);
                    }
                }).setMethodKey(6710).build());
            }
        });
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task loadPlayer(String str, boolean z) {
        return this.zza.zzb(new zzed(str, z));
    }
}
