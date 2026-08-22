package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import androidx.work.Worker;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbws;
import com.google.android.gms.internal.ads.zzbwu;
import com.google.android.gms.internal.ads.zzbwy;
import com.google.android.gms.internal.ads.zzbxc;
import com.google.android.gms.internal.ads.zzbxd;
import com.google.android.gms.internal.ads.zzbxj;
import com.google.gson.yWTz.kBfGXgdfpo;

/* JADX INFO: loaded from: classes2.dex */
public final class zzfs extends zzbwu {
    @Override // com.google.android.gms.internal.ads.zzbwv
    public final long zzb() {
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final Bundle zzc() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final zzea zzd() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final zzbws zze() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final String zzf() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final String zzg() {
        return "";
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzh(zzm zzmVar, zzbxc zzbxcVar) {
        zzo.zzg("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzf.zza.post(new Worker.AnonymousClass1(zzbxcVar, 24));
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzj(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzk(zzdq zzdqVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzl(zzdt zzdtVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzm(long j) {
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzn(zzbwy zzbwyVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzo(zzbxj zzbxjVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzp(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzq(IObjectWrapper iObjectWrapper, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final boolean zzr() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzs(zzbxd zzbxdVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzi(zzm zzmVar, zzbxc zzbxcVar) {
        zzo.zzg(kBfGXgdfpo.ebiI);
        zzf.zza.post(new Worker.AnonymousClass1(zzbxcVar, 24));
    }
}
