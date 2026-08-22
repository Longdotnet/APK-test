package com.google.android.gms.games.internal.v2.appshortcuts;

import android.content.Intent;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes2.dex */
public final class zzm extends zzn {
    @Override // com.google.android.gms.games.internal.v2.appshortcuts.zzn, com.google.android.gms.games.internal.v2.appshortcuts.zzx
    public final void zzc(Intent intent) {
        if (intent == null) {
            zzd(new Status(17));
        } else {
            this.zza.trySetResult(intent);
        }
    }
}
