package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.core.internal.view.Oteb.nYVxXTZQ;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzcb;
import com.google.android.gms.internal.measurement.zzcf;
import com.google.android.gms.internal.measurement.zzci;
import com.google.android.gms.internal.measurement.zzck;
import com.google.android.gms.internal.measurement.zzcl;
import com.google.firebase.auth.zzz;
import com.yoyogames.runner.RunnerJNILib;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public class AppMeasurementDynamiteService extends zzcb {
    public zzfr zza = null;
    public final ArrayMap zzb = new ArrayMap();

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void beginAdUnitExposure(String str, long j) {
        zzb();
        this.zza.zzd().zzd(str, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzhxVar.zzA(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void clearMeasurementEnabled(long j) {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzhxVar.zza();
        zzfo zzfoVar = ((zzfr) zzhxVar.mBuilder).zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new com.google.android.gms.tasks.zzc(zzhxVar, null, 4));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void endAdUnitExposure(String str, long j) {
        zzb();
        this.zza.zzd().zze(str, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void generateEventId(zzcf zzcfVar) {
        zzb();
        zzlb zzlbVar = this.zza.zzp;
        zzfr.zzP(zzlbVar);
        long jZzq = zzlbVar.zzq();
        zzb();
        zzlb zzlbVar2 = this.zza.zzp;
        zzfr.zzP(zzlbVar2);
        zzlbVar2.zzU(zzcfVar, jZzq);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getAppInstanceId(zzcf zzcfVar) {
        zzb();
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new zzi(this, zzcfVar, 0));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getCachedAppInstanceId(zzcf zzcfVar) {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzc(zzhxVar.zzo$1(), zzcfVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getConditionalUserProperties(String str, String str2, zzcf zzcfVar) {
        zzb();
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new RunnerJNILib.AnonymousClass2((Object) this, (Object) zzcfVar, str, str2, 14));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getCurrentScreenClass(zzcf zzcfVar) {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzim zzimVar = ((zzfr) zzhxVar.mBuilder).zzs;
        zzfr.zzQ(zzimVar);
        zzie zzieVar = zzimVar.zzb;
        zzc(zzieVar != null ? zzieVar.zzb : null, zzcfVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getCurrentScreenName(zzcf zzcfVar) {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzim zzimVar = ((zzfr) zzhxVar.mBuilder).zzs;
        zzfr.zzQ(zzimVar);
        zzie zzieVar = zzimVar.zzb;
        zzc(zzieVar != null ? zzieVar.zza : null, zzcfVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getGmpAppId(zzcf zzcfVar) {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzfr zzfrVar = (zzfr) zzhxVar.mBuilder;
        String strZzc = zzfrVar.zzf;
        if (strZzc == null) {
            try {
                strZzc = zzg.zzc(zzfrVar.zze, zzfrVar.zzw);
            } catch (IllegalStateException e) {
                zzeh zzehVar = zzfrVar.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzd.zzb(e, "getGoogleAppId failed with exception");
                strZzc = null;
            }
        }
        zzc(strZzc, zzcfVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getMaxUserProperties(String str, zzcf zzcfVar) {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        ((zzfr) zzhxVar.mBuilder).getClass();
        zzb();
        zzlb zzlbVar = this.zza.zzp;
        zzfr.zzP(zzlbVar);
        zzlbVar.zzT(zzcfVar, 25);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getSessionId(zzcf zzcfVar) {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzfo zzfoVar = ((zzfr) zzhxVar.mBuilder).zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new com.google.android.gms.tasks.zzc(zzhxVar, zzcfVar, 3));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getUserProperties(String str, String str2, boolean z, zzcf zzcfVar) {
        zzb();
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new zzk(this, zzcfVar, str, str2, z, 0));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void initForTests(Map map) {
        zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void initialize(IObjectWrapper iObjectWrapper, zzcl zzclVar, long j) {
        zzfr zzfrVar = this.zza;
        if (zzfrVar == null) {
            Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            com.google.android.gms.common.internal.zzah.checkNotNull(context);
            this.zza = zzfr.zzp(context, zzclVar, Long.valueOf(j));
        } else {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzg.zza("Attempting to initialize multiple times");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void isDataCollectionEnabled(zzcf zzcfVar) {
        zzb();
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new zzi(this, zzcfVar, 1));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzhxVar.zzE(str, str2, bundle, z, z2, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void logEventAndBundle(String str, String str2, Bundle bundle, zzcf zzcfVar, long j) {
        zzb();
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", "app");
        zzaw zzawVar = new zzaw(str2, new zzau(bundle), "app", j);
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new RunnerJNILib.AnonymousClass2(this, zzcfVar, zzawVar, str));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        zzb();
        Object objUnwrap = iObjectWrapper == null ? null : ObjectWrapper.unwrap(iObjectWrapper);
        Object objUnwrap2 = iObjectWrapper2 == null ? null : ObjectWrapper.unwrap(iObjectWrapper2);
        Object objUnwrap3 = iObjectWrapper3 != null ? ObjectWrapper.unwrap(iObjectWrapper3) : null;
        zzeh zzehVar = this.zza.zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzt(i, true, false, str, objUnwrap, objUnwrap2, objUnwrap3);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzhw zzhwVar = zzhxVar.zza;
        if (zzhwVar != null) {
            zzhx zzhxVar2 = this.zza.zzt;
            zzfr.zzQ(zzhxVar2);
            zzhxVar2.zzB$1();
            zzhwVar.onActivityCreated((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzhw zzhwVar = zzhxVar.zza;
        if (zzhwVar != null) {
            zzhx zzhxVar2 = this.zza.zzt;
            zzfr.zzQ(zzhxVar2);
            zzhxVar2.zzB$1();
            zzhwVar.onActivityDestroyed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void onActivityPaused(IObjectWrapper iObjectWrapper, long j) {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzhw zzhwVar = zzhxVar.zza;
        if (zzhwVar != null) {
            zzhx zzhxVar2 = this.zza.zzt;
            zzfr.zzQ(zzhxVar2);
            zzhxVar2.zzB$1();
            zzhwVar.onActivityPaused((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void onActivityResumed(IObjectWrapper iObjectWrapper, long j) {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzhw zzhwVar = zzhxVar.zza;
        if (zzhwVar != null) {
            zzhx zzhxVar2 = this.zza.zzt;
            zzfr.zzQ(zzhxVar2);
            zzhxVar2.zzB$1();
            zzhwVar.onActivityResumed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzcf zzcfVar, long j) {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzhw zzhwVar = zzhxVar.zza;
        Bundle bundle = new Bundle();
        if (zzhwVar != null) {
            zzhx zzhxVar2 = this.zza.zzt;
            zzfr.zzQ(zzhxVar2);
            zzhxVar2.zzB$1();
            zzhwVar.onActivitySaveInstanceState((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e) {
            zzeh zzehVar = this.zza.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzg.zzb(e, "Error returning bundle value to wrapper");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void onActivityStarted(IObjectWrapper iObjectWrapper, long j) {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        if (zzhxVar.zza != null) {
            zzhx zzhxVar2 = this.zza.zzt;
            zzfr.zzQ(zzhxVar2);
            zzhxVar2.zzB$1();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void onActivityStopped(IObjectWrapper iObjectWrapper, long j) {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        if (zzhxVar.zza != null) {
            zzhx zzhxVar2 = this.zza.zzt;
            zzfr.zzQ(zzhxVar2);
            zzhxVar2.zzB$1();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void performAction(Bundle bundle, zzcf zzcfVar, long j) {
        zzb();
        zzcfVar.zze(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void registerOnMeasurementEventListener(zzci zzciVar) {
        Object zzpVar;
        zzb();
        synchronized (this.zzb) {
            try {
                zzpVar = (zzgs) this.zzb.getOrDefault(Integer.valueOf(zzciVar.zzd()), null);
                if (zzpVar == null) {
                    zzpVar = new zzp(this, zzciVar);
                    this.zzb.put(Integer.valueOf(zzciVar.zzd()), zzpVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzhxVar.zza();
        if (zzhxVar.zze.add(zzpVar)) {
            return;
        }
        zzeh zzehVar = ((zzfr) zzhxVar.mBuilder).zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzg.zza("OnEventListener already registered");
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void resetAnalyticsData(long j) {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzhxVar.zzg.set(null);
        zzfo zzfoVar = ((zzfr) zzhxVar.mBuilder).zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new zzha(zzhxVar, j, 1));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setConditionalUserProperty(Bundle bundle, long j) {
        zzb();
        if (bundle == null) {
            zzeh zzehVar = this.zza.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zza("Conditional user property must not be null");
        } else {
            zzhx zzhxVar = this.zza.zzt;
            zzfr.zzQ(zzhxVar);
            zzhxVar.zzQ(bundle, j);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setConsent(Bundle bundle, long j) {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzfo zzfoVar = ((zzfr) zzhxVar.mBuilder).zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzq(new zzgv(zzhxVar, bundle, j));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setConsentThirdParty(Bundle bundle, long j) {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzhxVar.zzR(bundle, -20, j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a0, code lost:
    
        if (r4.length() <= 100) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00cf, code lost:
    
        if (r5.length() <= 100) goto L33;
     */
    @Override // com.google.android.gms.internal.measurement.zzcc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setCurrentScreen(com.google.android.gms.dynamic.IObjectWrapper r3, java.lang.String r4, java.lang.String r5, long r6) {
        /*
            Method dump skipped, instruction units count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.AppMeasurementDynamiteService.setCurrentScreen(com.google.android.gms.dynamic.IObjectWrapper, java.lang.String, java.lang.String, long):void");
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setDataCollectionEnabled(boolean z) {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzhxVar.zza();
        zzfo zzfoVar = ((zzfr) zzhxVar.mBuilder).zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new com.google.android.gms.ads.internal.zzi(zzhxVar, z, 2));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setDefaultEventParameters(Bundle bundle) {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
        zzfo zzfoVar = ((zzfr) zzhxVar.mBuilder).zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new zzgw(zzhxVar, bundle2, 0));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setEventInterceptor(zzci zzciVar) {
        zzb();
        zzz zzzVar = new zzz(this, zzciVar, 6);
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        if (!zzfoVar.zzs()) {
            zzfo zzfoVar2 = this.zza.zzn;
            zzfr.zzR(zzfoVar2);
            zzfoVar2.zzp(new com.google.android.gms.tasks.zzc(this, zzzVar, 8));
            return;
        }
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzhxVar.zzg();
        zzhxVar.zza();
        zzgr zzgrVar = zzhxVar.zzd;
        if (zzzVar != zzgrVar) {
            com.google.android.gms.common.internal.zzah.checkState(zzgrVar == null, "EventInterceptor already set.");
        }
        zzhxVar.zzd = zzzVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setInstanceIdProvider(zzck zzckVar) {
        zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setMeasurementEnabled(boolean z, long j) {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        Boolean boolValueOf = Boolean.valueOf(z);
        zzhxVar.zza();
        zzfo zzfoVar = ((zzfr) zzhxVar.mBuilder).zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new com.google.android.gms.tasks.zzc(zzhxVar, boolValueOf, 4));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setMinimumSessionDuration(long j) {
        zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setSessionTimeoutDuration(long j) {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzfo zzfoVar = ((zzfr) zzhxVar.mBuilder).zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new zzha(zzhxVar, j, 0));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setUserId(String str, long j) {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzfr zzfrVar = (zzfr) zzhxVar.mBuilder;
        if (str != null && TextUtils.isEmpty(str)) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzg.zza("User ID must be non-empty or null");
        } else {
            zzfo zzfoVar = zzfrVar.zzn;
            zzfr.zzR(zzfoVar);
            zzfoVar.zzp(new com.google.android.gms.tasks.zzc(zzhxVar, str, 2, false));
            zzhxVar.zzX(null, "_id", str, true, j);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) {
        zzb();
        Object objUnwrap = ObjectWrapper.unwrap(iObjectWrapper);
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzhxVar.zzX(str, str2, objUnwrap, z, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void unregisterOnMeasurementEventListener(zzci zzciVar) {
        Object zzpVar;
        zzb();
        synchronized (this.zzb) {
            zzpVar = (zzgs) this.zzb.remove(Integer.valueOf(zzciVar.zzd()));
        }
        if (zzpVar == null) {
            zzpVar = new zzp(this, zzciVar);
        }
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzhxVar.zza();
        if (zzhxVar.zze.remove(zzpVar)) {
            return;
        }
        zzeh zzehVar = ((zzfr) zzhxVar.mBuilder).zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzg.zza("OnEventListener had not been registered");
    }

    public final void zzb() {
        if (this.zza == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    public final void zzc(String str, zzcf zzcfVar) {
        zzb();
        zzlb zzlbVar = this.zza.zzp;
        zzfr.zzP(zzlbVar);
        zzlbVar.zzV(str, zzcfVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getTestFlag(zzcf zzcfVar, int i) {
        zzb();
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return;
                        }
                        zzlb zzlbVar = this.zza.zzp;
                        zzfr.zzP(zzlbVar);
                        zzhx zzhxVar = this.zza.zzt;
                        zzfr.zzQ(zzhxVar);
                        AtomicReference atomicReference = new AtomicReference();
                        zzfo zzfoVar = ((zzfr) zzhxVar.mBuilder).zzn;
                        zzfr.zzR(zzfoVar);
                        zzlbVar.zzP(zzcfVar, ((Boolean) zzfoVar.zzd(atomicReference, 15000L, "boolean test flag value", new zzhi(zzhxVar, atomicReference, 0))).booleanValue());
                        return;
                    }
                    zzlb zzlbVar2 = this.zza.zzp;
                    zzfr.zzP(zzlbVar2);
                    zzhx zzhxVar2 = this.zza.zzt;
                    zzfr.zzQ(zzhxVar2);
                    AtomicReference atomicReference2 = new AtomicReference();
                    zzfo zzfoVar2 = ((zzfr) zzhxVar2.mBuilder).zzn;
                    zzfr.zzR(zzfoVar2);
                    zzlbVar2.zzT(zzcfVar, ((Integer) zzfoVar2.zzd(atomicReference2, 15000L, "int test flag value", new zzhi(zzhxVar2, atomicReference2, 3))).intValue());
                    return;
                }
                zzlb zzlbVar3 = this.zza.zzp;
                zzfr.zzP(zzlbVar3);
                zzhx zzhxVar3 = this.zza.zzt;
                zzfr.zzQ(zzhxVar3);
                AtomicReference atomicReference3 = new AtomicReference();
                zzfo zzfoVar3 = ((zzfr) zzhxVar3.mBuilder).zzn;
                zzfr.zzR(zzfoVar3);
                double dDoubleValue = ((Double) zzfoVar3.zzd(atomicReference3, 15000L, "double test flag value", new zzhi(zzhxVar3, atomicReference3, 4))).doubleValue();
                Bundle bundle = new Bundle();
                bundle.putDouble("r", dDoubleValue);
                try {
                    zzcfVar.zze(bundle);
                    return;
                } catch (RemoteException e) {
                    zzeh zzehVar = ((zzfr) zzlbVar3.mBuilder).zzm;
                    zzfr.zzR(zzehVar);
                    zzehVar.zzg.zzb(e, "Error returning double value to wrapper");
                    return;
                }
            }
            zzlb zzlbVar4 = this.zza.zzp;
            zzfr.zzP(zzlbVar4);
            zzhx zzhxVar4 = this.zza.zzt;
            zzfr.zzQ(zzhxVar4);
            AtomicReference atomicReference4 = new AtomicReference();
            zzfo zzfoVar4 = ((zzfr) zzhxVar4.mBuilder).zzn;
            zzfr.zzR(zzfoVar4);
            zzlbVar4.zzU(zzcfVar, ((Long) zzfoVar4.zzd(atomicReference4, 15000L, "long test flag value", new zzhi(zzhxVar4, atomicReference4, 2))).longValue());
            return;
        }
        zzlb zzlbVar5 = this.zza.zzp;
        zzfr.zzP(zzlbVar5);
        zzhx zzhxVar5 = this.zza.zzt;
        zzfr.zzQ(zzhxVar5);
        AtomicReference atomicReference5 = new AtomicReference();
        zzfo zzfoVar5 = ((zzfr) zzhxVar5.mBuilder).zzn;
        zzfr.zzR(zzfoVar5);
        zzlbVar5.zzV((String) zzfoVar5.zzd(atomicReference5, 15000L, nYVxXTZQ.CgnLxFUXvZrY, new zzhi(zzhxVar5, atomicReference5, 1)), zzcfVar);
    }
}
