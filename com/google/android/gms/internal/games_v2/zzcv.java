package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.GamesSignInClient;
import com.google.android.gms.games.gamessignin.AuthScope;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzcv implements GamesSignInClient {
    private final zzaw zza;
    private final zzaq zzb;

    public zzcv(zzaw zzawVar, zzaq zzaqVar) {
        this.zza = zzawVar;
        this.zzb = zzaqVar;
    }

    @Override // com.google.android.gms.games.GamesSignInClient
    public final Task isAuthenticated() {
        return this.zza.zzc();
    }

    @Override // com.google.android.gms.games.GamesSignInClient
    public final Task requestServerSideAccess(final String str, final boolean z) {
        return this.zzb.zzb(new zzap() { // from class: com.google.android.gms.internal.games_v2.zzcu
            @Override // com.google.android.gms.internal.games_v2.zzap
            public final /* synthetic */ Task zza(GoogleApi googleApi) {
                TaskApiCall.Builder builder = TaskApiCall.builder();
                final String str2 = str;
                final boolean z2 = z;
                return googleApi.doWrite(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzct
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final /* synthetic */ void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzah) obj).zzR((TaskCompletionSource) obj2, str2, z2);
                    }
                }).setMethodKey(6699).build());
            }
        });
    }

    @Override // com.google.android.gms.games.GamesSignInClient
    public final Task signIn() {
        return this.zza.zze();
    }

    @Override // com.google.android.gms.games.GamesSignInClient
    public final Task requestServerSideAccess(final String str, final boolean z, List<AuthScope> list) {
        Objects.requireNonNull(str, "serverClientId must not be null.");
        if (str.isEmpty()) {
            throw new IllegalArgumentException("serverClientId must not be empty.");
        }
        if (list == null || list.contains(null)) {
            throw new IllegalArgumentException("AuthScope array cannot contain null elements.");
        }
        return this.zza.zzb(new zzau() { // from class: com.google.android.gms.internal.games_v2.zzcr
            @Override // com.google.android.gms.internal.games_v2.zzau
            public final /* synthetic */ Task zza(GoogleApi googleApi, final List list2) {
                TaskApiCall.Builder builder = TaskApiCall.builder();
                final String str2 = str;
                final boolean z2 = z;
                return googleApi.doWrite(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzcs
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final /* synthetic */ void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzah) obj).zzS((TaskCompletionSource) obj2, str2, z2, AuthScope.zza(list2));
                    }
                }).setMethodKey(6748).build());
            }
        }, list);
    }
}
