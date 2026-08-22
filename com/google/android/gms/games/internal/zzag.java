package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.SnapshotsClient;
import com.google.android.gms.games.snapshot.SnapshotContentsEntity;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class zzag extends zza {
    public final TaskCompletionSource zza;

    public zzag(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzaj
    public final void zzm(DataHolder dataHolder, Contents contents) {
        int i = dataHolder.zai;
        SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
        try {
            SnapshotEntity snapshotEntity = snapshotMetadataBuffer.getCount() > 0 ? new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(contents)) : null;
            snapshotMetadataBuffer.close();
            TaskCompletionSource taskCompletionSource = this.zza;
            if (i == 0) {
                taskCompletionSource.setResult(new SnapshotsClient.DataOrConflict(snapshotEntity, null));
                return;
            }
            if (i == 4002) {
                if (snapshotEntity != null && snapshotEntity.getMetadata() != null) {
                    taskCompletionSource.setException(new SnapshotsClient.SnapshotContentUnavailableApiException(com.google.android.gms.games.zzj.zza(4002), snapshotEntity.getMetadata()));
                    return;
                }
                i = 4002;
            }
            GamesStatusUtils.zzb(taskCompletionSource, i);
        } catch (Throwable th) {
            try {
                snapshotMetadataBuffer.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzaj
    public final void zzn(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) {
        SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
        try {
            int count = snapshotMetadataBuffer.getCount();
            TaskCompletionSource taskCompletionSource = this.zza;
            if (count < 2 || str == null || contents3 == null) {
                taskCompletionSource.setResult(null);
                snapshotMetadataBuffer.close();
            } else {
                SnapshotEntity snapshotEntity = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(contents));
                SnapshotEntity snapshotEntity2 = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(1)), new SnapshotContentsEntity(contents2));
                snapshotMetadataBuffer.close();
                taskCompletionSource.setResult(new SnapshotsClient.DataOrConflict(null, new SnapshotsClient.SnapshotConflict(snapshotEntity, str, snapshotEntity2, new SnapshotContentsEntity(contents3))));
            }
        } catch (Throwable th) {
            try {
                snapshotMetadataBuffer.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
