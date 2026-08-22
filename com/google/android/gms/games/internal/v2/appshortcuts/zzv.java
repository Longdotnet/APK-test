package com.google.android.gms.games.internal.v2.appshortcuts;

import android.os.IInterface;
import android.os.Parcel;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzv extends com.google.android.gms.internal.games_v2.zza implements IInterface {
    public final void zzd(zzx zzxVar, zzr zzrVar, List list, List list2) {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzd(parcelZza, zzxVar);
        com.google.android.gms.internal.games_v2.zzc.zzc(parcelZza, zzrVar);
        parcelZza.writeTypedList(list);
        parcelZza.writeTypedList(list2);
        zzc(3, parcelZza);
    }

    public final void zze(zzx zzxVar, zzr zzrVar, zzi zziVar) {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzd(parcelZza, zzxVar);
        com.google.android.gms.internal.games_v2.zzc.zzc(parcelZza, zzrVar);
        com.google.android.gms.internal.games_v2.zzc.zzc(parcelZza, zziVar);
        zzc(4, parcelZza);
    }
}
