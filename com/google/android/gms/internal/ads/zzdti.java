package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.SystemClock;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.firebase.analytics.connector.pDv.PZmDzEagKNdW;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdti implements AppEventListener, zzcza, com.google.android.gms.ads.internal.client.zza, zzcvy, zzcws, zzcwt, zzcxm, zzcwb, zzfhb {
    private final List zza;
    private final zzdsw zzb;
    private long zzc;

    public zzdti(zzdsw zzdswVar, zzche zzcheVar) {
        this.zzb = zzdswVar;
        this.zza = Collections.singletonList(zzcheVar);
    }

    private final void zzg(Class cls, String str, Object... objArr) {
        this.zzb.zza(this.zza, "Event-".concat(cls.getSimpleName()), str, objArr);
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        zzg(com.google.android.gms.ads.internal.client.zza.class, "onAdClicked", new Object[0]);
    }

    @Override // com.google.android.gms.ads.admanager.AppEventListener
    public final void onAppEvent(String str, String str2) {
        zzg(AppEventListener.class, "onAppEvent", str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzcvy
    public final void zza() {
        zzg(zzcvy.class, "onAdClosed", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzcvy
    public final void zzb() {
        zzg(zzcvy.class, "onAdLeftApplication", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzcvy
    public final void zzc() {
        zzg(zzcvy.class, "onAdOpened", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzfhb
    public final void zzd(zzfgu zzfguVar, String str) {
        zzg(zzfgt.class, "onTaskSucceeded", str);
    }

    @Override // com.google.android.gms.internal.ads.zzcwb
    public final void zzdD(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzg(zzcwb.class, "onAdFailedToLoad", Integer.valueOf(zzeVar.zza), zzeVar.zzb, zzeVar.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzfhb
    public final void zzdE(zzfgu zzfguVar, String str) {
        zzg(zzfgt.class, "onTaskCreated", str);
    }

    @Override // com.google.android.gms.internal.ads.zzfhb
    public final void zzdF(zzfgu zzfguVar, String str, Throwable th) {
        zzg(zzfgt.class, "onTaskFailed", str, th.getClass().getSimpleName());
    }

    @Override // com.google.android.gms.internal.ads.zzfhb
    public final void zzdG(zzfgu zzfguVar, String str) {
        zzg(zzfgt.class, "onTaskStarted", str);
    }

    @Override // com.google.android.gms.internal.ads.zzcwt
    public final void zzdj(Context context) {
        zzg(zzcwt.class, "onDestroy", context);
    }

    @Override // com.google.android.gms.internal.ads.zzcwt
    public final void zzdl(Context context) {
        zzg(zzcwt.class, "onPause", context);
    }

    @Override // com.google.android.gms.internal.ads.zzcwt
    public final void zzdm(Context context) {
        zzg(zzcwt.class, PZmDzEagKNdW.EyhJcNbO, context);
    }

    @Override // com.google.android.gms.internal.ads.zzcza
    public final void zzdn(zzbvq zzbvqVar) {
        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
        this.zzc = SystemClock.elapsedRealtime();
        zzg(zzcza.class, "onAdRequest", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzcza
    public final void zzdo(zzfcn zzfcnVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzcvy
    public final void zzdu(zzbwc zzbwcVar, String str, String str2) {
        zzg(zzcvy.class, "onRewarded", zzbwcVar, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzcvy
    public final void zze() {
        zzg(zzcvy.class, "onRewardedVideoCompleted", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzcvy
    public final void zzf() {
        zzg(zzcvy.class, "onRewardedVideoStarted", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzcws
    public final void zzt() {
        zzg(zzcws.class, "onAdImpression", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzcxm
    public final void zzu() {
        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
        com.google.android.gms.ads.internal.util.zze.zza("Ad Request Latency : " + (SystemClock.elapsedRealtime() - this.zzc));
        zzg(zzcxm.class, "onAdLoaded", new Object[0]);
    }
}
