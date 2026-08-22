package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzac extends zza {
    public final /* synthetic */ zzah zza;
    public final TaskCompletionSource zzb;

    public zzac(zzah zzahVar, TaskCompletionSource taskCompletionSource) {
        Objects.requireNonNull(zzahVar);
        this.zza = zzahVar;
        this.zzb = taskCompletionSource;
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzaj
    public final void zzh(DataHolder dataHolder) {
        int i = dataHolder.zai;
        TaskCompletionSource taskCompletionSource = this.zzb;
        if (i == 10003) {
            this.zza.zzT(taskCompletionSource);
            dataHolder.close();
            return;
        }
        boolean z = i == 3;
        if (i == 0 || z) {
            taskCompletionSource.setResult(new AnnotatedData(new PlayerBuffer(dataHolder), z));
        } else {
            GamesStatusUtils.zzb(taskCompletionSource, i);
            dataHolder.close();
        }
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzaj
    public final void zzi(DataHolder dataHolder) {
        zzh(dataHolder);
    }
}
