package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class zzaa extends zza {
    public final TaskCompletionSource zza;

    public zzaa(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzaj
    public final void zzl(DataHolder dataHolder) {
        int i = dataHolder.zai;
        boolean z = i == 3;
        TaskCompletionSource taskCompletionSource = this.zza;
        if (i == 0 || z) {
            taskCompletionSource.setResult(new AnnotatedData(new SnapshotMetadataBuffer(dataHolder), z));
        } else {
            GamesStatusUtils.zzb(taskCompletionSource, i);
            dataHolder.close();
        }
    }
}
