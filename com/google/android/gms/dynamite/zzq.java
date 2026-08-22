package com.google.android.gms.dynamite;

import android.os.Parcel;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.common.zza;

/* JADX INFO: loaded from: classes.dex */
public final class zzq extends zza {
    public final IObjectWrapper zzh(ObjectWrapper objectWrapper, String str, int i) {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.common.zzc.zze(parcelZza, objectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(i);
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzB(2, parcelZza));
    }

    public final IObjectWrapper zzi(ObjectWrapper objectWrapper, String str, int i, ObjectWrapper objectWrapper2) {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.common.zzc.zze(parcelZza, objectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(i);
        com.google.android.gms.internal.common.zzc.zze(parcelZza, objectWrapper2);
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzB(8, parcelZza));
    }

    public final IObjectWrapper zzj(ObjectWrapper objectWrapper, String str, int i) {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.common.zzc.zze(parcelZza, objectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(i);
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzB(4, parcelZza));
    }
}
