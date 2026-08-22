package com.google.android.gms.internal.safetynet;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzj extends zza implements zzi {
    public zzj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.safetynet.internal.ISafetyNetService");
    }

    @Override // com.google.android.gms.internal.safetynet.zzi
    public final void zza(zzg zzgVar) {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(parcelObtainAndWriteInterfaceToken, zzgVar);
        transactAndReadExceptionReturnVoid(12, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.safetynet.zzi
    public final void zzb() {
        transactAndReadExceptionReturnVoid(13, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.safetynet.zzi
    public final void zzc(zzg zzgVar) {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(parcelObtainAndWriteInterfaceToken, zzgVar);
        transactAndReadExceptionReturnVoid(4, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.safetynet.zzi
    public final void zzd(zzg zzgVar) {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(parcelObtainAndWriteInterfaceToken, zzgVar);
        transactAndReadExceptionReturnVoid(5, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.safetynet.zzi
    public final void zza(zzg zzgVar, String str) {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(parcelObtainAndWriteInterfaceToken, zzgVar);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        transactAndReadExceptionReturnVoid(6, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.safetynet.zzi
    public final void zzb(zzg zzgVar) {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(parcelObtainAndWriteInterfaceToken, zzgVar);
        transactAndReadExceptionReturnVoid(14, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.safetynet.zzi
    public final void zza(zzg zzgVar, String str, int[] iArr, int i, String str2) {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(parcelObtainAndWriteInterfaceToken, zzgVar);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        parcelObtainAndWriteInterfaceToken.writeIntArray(iArr);
        parcelObtainAndWriteInterfaceToken.writeInt(i);
        parcelObtainAndWriteInterfaceToken.writeString(str2);
        transactAndReadExceptionReturnVoid(3, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.safetynet.zzi
    public final void zza(zzg zzgVar, byte[] bArr, String str) {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(parcelObtainAndWriteInterfaceToken, zzgVar);
        parcelObtainAndWriteInterfaceToken.writeByteArray(bArr);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        transactAndReadExceptionReturnVoid(7, parcelObtainAndWriteInterfaceToken);
    }
}
