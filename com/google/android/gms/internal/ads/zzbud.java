package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbud extends zzayt implements zzbuf {
    public zzbud(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.query.IUpdateUrlsCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbuf
    public final void zze(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzdb(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbuf
    public final void zzf(List list) {
        Parcel parcelZza = zza();
        parcelZza.writeTypedList(list);
        zzdb(1, parcelZza);
    }
}
