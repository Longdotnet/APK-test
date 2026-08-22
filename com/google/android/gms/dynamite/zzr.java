package com.google.android.gms.dynamite;

import android.os.Parcel;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.common.zza;

/* JADX INFO: loaded from: classes.dex */
public final class zzr extends zza {
    public final IObjectWrapper zze(ObjectWrapper objectWrapper, String str, int i, ObjectWrapper objectWrapper2) {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.common.zzc.zze(parcelZza, objectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(i);
        com.google.android.gms.internal.common.zzc.zze(parcelZza, objectWrapper2);
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzB(2, parcelZza));
    }

    public final IObjectWrapper zzf(ObjectWrapper objectWrapper, String str, int i, ObjectWrapper objectWrapper2) {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.common.zzc.zze(parcelZza, objectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(i);
        com.google.android.gms.internal.common.zzc.zze(parcelZza, objectWrapper2);
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzB(3, parcelZza));
    }
}
