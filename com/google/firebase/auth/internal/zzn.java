package com.google.firebase.auth.internal;

import com.google.firebase.auth.ActionCodeMultiFactorInfo;
import com.google.firebase.auth.MultiFactorInfo;

/* JADX INFO: loaded from: classes2.dex */
public final class zzn extends ActionCodeMultiFactorInfo {
    public final MultiFactorInfo zza;

    public zzn(String str, MultiFactorInfo multiFactorInfo) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        this.email = str;
        com.google.android.gms.common.internal.zzah.checkNotNull(multiFactorInfo);
        this.zza = multiFactorInfo;
    }

    @Override // com.google.firebase.auth.ActionCodeMultiFactorInfo
    public final MultiFactorInfo getMultiFactorInfo() {
        return this.zza;
    }
}
