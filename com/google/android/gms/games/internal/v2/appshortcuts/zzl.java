package com.google.android.gms.games.internal.v2.appshortcuts;

import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes2.dex */
public final class zzl extends zzn {
    @Override // com.google.android.gms.games.internal.v2.appshortcuts.zzn, com.google.android.gms.games.internal.v2.appshortcuts.zzx
    public final void zzb(zzg zzgVar) {
        if (zzgVar == null) {
            zzd(new Status(17));
        } else {
            this.zza.trySetResult(zzgVar);
        }
    }
}
