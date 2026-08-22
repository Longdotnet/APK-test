package com.google.android.gms.internal.safetynet;

import android.os.IInterface;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.SafeBrowsingData;

/* JADX INFO: loaded from: classes.dex */
public interface zzg extends IInterface {
    void zza(Status status);

    void zza(Status status, SafeBrowsingData safeBrowsingData);

    void zza(Status status, com.google.android.gms.safetynet.zza zzaVar);

    void zza(Status status, com.google.android.gms.safetynet.zzd zzdVar);

    void zza(Status status, com.google.android.gms.safetynet.zzf zzfVar);

    void zza(Status status, com.google.android.gms.safetynet.zzh zzhVar);

    void zza(Status status, boolean z);

    void zza(String str);

    void zzb(Status status, boolean z);
}
