package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbpu extends zzayt implements zzbpw {
    public zzbpu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zze() {
        zzdb(1, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzf() {
        zzdb(2, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzg(int i) {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        zzdb(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzh(com.google.android.gms.ads.internal.client.zze zzeVar) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, zzeVar);
        zzdb(23, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzi(int i, String str) {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        parcelZza.writeString(str);
        zzdb(22, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzj(int i) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzk(com.google.android.gms.ads.internal.client.zze zzeVar) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, zzeVar);
        zzdb(24, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzl(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzdb(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzm() {
        zzdb(8, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzn() {
        zzdb(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzo() {
        zzdb(6, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzp() {
        zzdb(5, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzq(String str, String str2) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzdb(9, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzr(zzbhj zzbhjVar, String str) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, zzbhjVar);
        parcelZza.writeString(str);
        zzdb(10, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzs(zzbwo zzbwoVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzt(zzbws zzbwsVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, zzbwsVar);
        zzdb(16, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzu() {
        zzdb(25, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzv() {
        zzdb(18, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzw() {
        zzdb(11, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzx() {
        zzdb(15, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzy() {
        zzdb(20, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzz() {
        zzdb(13, zza());
    }
}
