package com.google.android.gms.internal.auth;

import android.os.IInterface;
import com.google.android.gms.auth.api.accounttransfer.DeviceMetaData;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public interface zzat extends IInterface {
    void zzb(byte[] bArr);

    void zzc(DeviceMetaData deviceMetaData);

    void zzd(Status status);

    void zze();

    void zzf(Status status, com.google.android.gms.auth.api.accounttransfer.zzv zzvVar);

    void zzg(Status status, com.google.android.gms.auth.api.accounttransfer.zzn zznVar);

    void zzh(Status status);
}
