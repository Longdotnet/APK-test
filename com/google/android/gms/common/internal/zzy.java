package com.google.android.gms.common.internal;

import android.os.Parcel;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public final class zzy extends com.google.android.gms.internal.common.zza implements zzaa {
    @Override // com.google.android.gms.common.internal.zzaa
    public final int zzc() {
        Parcel parcelZzB = zzB(2, zza());
        int i = parcelZzB.readInt();
        parcelZzB.recycle();
        return i;
    }

    @Override // com.google.android.gms.common.internal.zzaa
    public final IObjectWrapper zzd() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzB(1, zza()));
    }
}
