package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class zzfg implements zzap {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ SnapshotMetadataChange zzc;
    private final /* synthetic */ SnapshotContents zzd;

    public /* synthetic */ zzfg(String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = snapshotMetadataChange;
        this.zzd = snapshotContents;
    }

    @Override // com.google.android.gms.internal.games_v2.zzap
    public final /* synthetic */ Task zza(GoogleApi googleApi) {
        TaskApiCall.Builder builder = TaskApiCall.builder();
        final String str = this.zza;
        final String str2 = this.zzb;
        final SnapshotMetadataChange snapshotMetadataChange = this.zzc;
        final SnapshotContents snapshotContents = this.zzd;
        return googleApi.doWrite(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzfh
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                ((com.google.android.gms.games.internal.zzah) obj).zzO((TaskCompletionSource) obj2, str, str2, snapshotMetadataChange, snapshotContents);
            }
        }).setMethodKey(6725).build());
    }
}
