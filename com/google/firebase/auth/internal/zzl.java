package com.google.firebase.auth.internal;

import com.google.firebase.auth.ActionCodeEmailInfo;

/* JADX INFO: loaded from: classes2.dex */
public final class zzl extends ActionCodeEmailInfo {
    public final String zza;

    public zzl(String str, String str2) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        this.email = str;
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str2);
        this.zza = str2;
    }

    @Override // com.google.firebase.auth.ActionCodeEmailInfo
    public final String getPreviousEmail() {
        return this.zza;
    }
}
