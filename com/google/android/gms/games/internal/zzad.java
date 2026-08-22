package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class zzad extends zza {
    public final TaskCompletionSource zza;

    public zzad(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzaj
    public final void zzh(DataHolder dataHolder) {
        int i = dataHolder.zai;
        TaskCompletionSource taskCompletionSource = this.zza;
        if (i != 0 && i != 3) {
            GamesStatusUtils.zzb(taskCompletionSource, i);
            dataHolder.close();
            return;
        }
        PlayerBuffer playerBuffer = new PlayerBuffer(dataHolder);
        try {
            PlayerEntity playerEntity = playerBuffer.getCount() > 0 ? new PlayerEntity(playerBuffer.get(0)) : null;
            playerBuffer.release();
            taskCompletionSource.setResult(new AnnotatedData(playerEntity, i == 3));
        } catch (Throwable th) {
            playerBuffer.release();
            throw th;
        }
    }
}
