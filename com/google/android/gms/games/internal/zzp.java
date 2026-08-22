package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class zzp extends zza {
    public final TaskCompletionSource zza;

    public zzp(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzaj
    public final void zzb(DataHolder dataHolder) {
        int i = dataHolder.zai;
        TaskCompletionSource taskCompletionSource = this.zza;
        if (i == 0 || i == 3) {
            taskCompletionSource.setResult(new AnnotatedData(new AchievementBuffer(dataHolder), i == 3));
        } else {
            GamesStatusUtils.zzb(taskCompletionSource, i);
            dataHolder.close();
        }
    }
}
