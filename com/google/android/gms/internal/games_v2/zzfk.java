package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.SnapshotsClient;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public final class zzfk implements SnapshotsClient {
    private final zzaq zza;

    public zzfk(zzaq zzaqVar) {
        this.zza = zzaqVar;
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task commitAndClose(final Snapshot snapshot, final SnapshotMetadataChange snapshotMetadataChange) {
        return this.zza.zzb(new zzap() { // from class: com.google.android.gms.internal.games_v2.zzfd
            @Override // com.google.android.gms.internal.games_v2.zzap
            public final /* synthetic */ Task zza(GoogleApi googleApi) {
                TaskApiCall.Builder builder = TaskApiCall.builder();
                final Snapshot snapshot2 = snapshot;
                final SnapshotMetadataChange snapshotMetadataChange2 = snapshotMetadataChange;
                return googleApi.doWrite(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzeu
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final /* synthetic */ void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzah) obj).zzM((TaskCompletionSource) obj2, snapshot2, snapshotMetadataChange2);
                    }
                }).setMethodKey(6722).build());
            }
        });
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task delete(final SnapshotMetadata snapshotMetadata) {
        return this.zza.zzb(new zzap() { // from class: com.google.android.gms.internal.games_v2.zzff
            @Override // com.google.android.gms.internal.games_v2.zzap
            public final /* synthetic */ Task zza(GoogleApi googleApi) {
                TaskApiCall.Builder builder = TaskApiCall.builder();
                final SnapshotMetadata snapshotMetadata2 = snapshotMetadata;
                return googleApi.doWrite(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzfi
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final /* synthetic */ void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzah) obj).zzN((TaskCompletionSource) obj2, snapshotMetadata2.getSnapshotId());
                    }
                }).setMethodKey(6724).build());
            }
        });
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task discardAndClose(final Snapshot snapshot) {
        return this.zza.zzb(new zzap() { // from class: com.google.android.gms.internal.games_v2.zzfe
            @Override // com.google.android.gms.internal.games_v2.zzap
            public final /* synthetic */ Task zza(GoogleApi googleApi) {
                TaskApiCall.Builder builder = TaskApiCall.builder();
                final Snapshot snapshot2 = snapshot;
                return googleApi.doWrite(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzet
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final /* synthetic */ void accept(Object obj, Object obj2) {
                        SnapshotContents snapshotContents = snapshot2.getSnapshotContents();
                        com.google.android.gms.common.internal.zzah.checkState(!snapshotContents.isClosed(), "Snapshot already closed");
                        Contents contentsZza = snapshotContents.zza();
                        snapshotContents.zzb();
                        ((com.google.android.gms.games.internal.zzam) ((com.google.android.gms.games.internal.zzah) obj).getService()).zzC(contentsZza);
                        ((TaskCompletionSource) obj2).setResult(null);
                    }
                }).setMethodKey(6723).build());
            }
        });
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task getMaxCoverImageSize() {
        return this.zza.zzb(zzes.zza);
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task getMaxDataSize() {
        return this.zza.zzb(zzfj.zza);
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task getSelectSnapshotIntent(final String str, final boolean z, final boolean z2, final int i) {
        return this.zza.zzb(new zzap() { // from class: com.google.android.gms.internal.games_v2.zzfa
            @Override // com.google.android.gms.internal.games_v2.zzap
            public final /* synthetic */ Task zza(GoogleApi googleApi) {
                TaskApiCall.Builder builder = TaskApiCall.builder();
                final String str2 = str;
                final boolean z3 = z;
                final boolean z4 = z2;
                final int i2 = i;
                return googleApi.doRead(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzex
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final /* synthetic */ void accept(Object obj, Object obj2) {
                        ((TaskCompletionSource) obj2).setResult(((com.google.android.gms.games.internal.zzam) ((com.google.android.gms.games.internal.zzah) obj).getService()).zzz(str2, z3, z4, i2));
                    }
                }).setMethodKey(6719).build());
            }
        });
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task load(final boolean z) {
        return this.zza.zzb(new zzap() { // from class: com.google.android.gms.internal.games_v2.zzfb
            @Override // com.google.android.gms.internal.games_v2.zzap
            public final /* synthetic */ Task zza(GoogleApi googleApi) {
                TaskApiCall.Builder builder = TaskApiCall.builder();
                final boolean z2 = z;
                return googleApi.doRead(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzew
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final /* synthetic */ void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzah) obj).zzK((TaskCompletionSource) obj2, z2);
                    }
                }).setMethodKey(6720).build());
            }
        });
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task open(SnapshotMetadata snapshotMetadata) {
        return open(snapshotMetadata.getUniqueName(), false, -1);
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task resolveConflict(String str, Snapshot snapshot) {
        SnapshotMetadata metadata = snapshot.getMetadata();
        SnapshotMetadataChange.Builder builder = new SnapshotMetadataChange.Builder();
        builder.fromMetadata(metadata);
        return this.zza.zzb(new zzfg(str, metadata.getSnapshotId(), builder.build(), snapshot.getSnapshotContents()));
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task open(SnapshotMetadata snapshotMetadata, int i) {
        return open(snapshotMetadata.getUniqueName(), false, i);
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task open(String str, boolean z) {
        return open(str, z, -1);
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task open(final String str, final boolean z, final int i) {
        return this.zza.zzb(new zzap() { // from class: com.google.android.gms.internal.games_v2.zzfc
            @Override // com.google.android.gms.internal.games_v2.zzap
            public final /* synthetic */ Task zza(GoogleApi googleApi) {
                TaskApiCall.Builder builder = TaskApiCall.builder();
                final String str2 = str;
                final boolean z2 = z;
                final int i2 = i;
                return googleApi.doWrite(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzev
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final /* synthetic */ void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzah) obj).zzL((TaskCompletionSource) obj2, str2, z2, i2);
                    }
                }).setMethodKey(6721).build());
            }
        });
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task resolveConflict(String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) {
        return this.zza.zzb(new zzfg(str, str2, snapshotMetadataChange, snapshotContents));
    }
}
