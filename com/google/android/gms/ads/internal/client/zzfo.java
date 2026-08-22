package com.google.android.gms.ads.internal.client;

import androidx.work.Worker;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbmk;
import com.google.android.gms.internal.ads.zzbpq;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzfo extends zzda {
    public zzbmk zza;

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final float zze() {
        return 1.0f;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final String zzf() {
        return "";
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final List zzg() {
        return Collections.emptyList();
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzh(String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzi() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzj(boolean z) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzk() {
        zzo.zzg("The initialization is not processed because MobileAdsSettingsManager is not created successfully.");
        zzf.zza.post(new Worker.AnonymousClass1(this, 23));
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzl(String str, IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzm(zzdn zzdnVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzn(IObjectWrapper iObjectWrapper, String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzo(zzbpq zzbpqVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzp(boolean z) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzq(float f) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzr(String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzs(zzbmk zzbmkVar) {
        this.zza = zzbmkVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzt(String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzu(zzfx zzfxVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final boolean zzv() {
        return false;
    }
}
