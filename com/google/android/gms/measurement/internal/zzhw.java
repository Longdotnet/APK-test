package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.datatransport.runtime.synchronization.JDyk.FETmZwrVHuasmL;
import com.google.android.gms.appset.vSSa.iafHZUfOuHNwvy;
import com.google.android.gms.signin.internal.FVfQ.GsPcpBmONXh;

/* JADX INFO: loaded from: classes2.dex */
public final class zzhw implements Application.ActivityLifecycleCallbacks {
    public final /* synthetic */ zzhx zza;

    public /* synthetic */ zzhw(zzhx zzhxVar) {
        this.zza = zzhxVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zzim zzimVar = ((zzfr) this.zza.mBuilder).zzs;
        zzfr.zzQ(zzimVar);
        synchronized (zzimVar.zzj) {
            try {
                if (activity == zzimVar.zze) {
                    zzimVar.zze = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (((zzfr) zzimVar.mBuilder).zzk.zzu()) {
            zzimVar.zzd.remove(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zzim zzimVar = ((zzfr) this.zza.mBuilder).zzs;
        zzfr.zzQ(zzimVar);
        synchronized (zzimVar.zzj) {
            zzimVar.zzi = false;
            zzimVar.zzf = true;
        }
        ((zzfr) zzimVar.mBuilder).zzr.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (((zzfr) zzimVar.mBuilder).zzk.zzu()) {
            zzie zzieVarZzy = zzimVar.zzy(activity);
            zzimVar.zzc = zzimVar.zzb;
            zzimVar.zzb = null;
            zzfo zzfoVar = ((zzfr) zzimVar.mBuilder).zzn;
            zzfr.zzR(zzfoVar);
            zzfoVar.zzp(new zzgv(zzimVar, zzieVarZzy, jElapsedRealtime));
        } else {
            zzimVar.zzb = null;
            zzfo zzfoVar2 = ((zzfr) zzimVar.mBuilder).zzn;
            zzfr.zzR(zzfoVar2);
            zzfoVar2.zzp(new zzc(zzimVar, jElapsedRealtime, 1));
        }
        zzkc zzkcVar = ((zzfr) this.zza.mBuilder).zzo;
        zzfr.zzQ(zzkcVar);
        ((zzfr) zzkcVar.mBuilder).zzr.getClass();
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        zzfo zzfoVar3 = ((zzfr) zzkcVar.mBuilder).zzn;
        zzfr.zzR(zzfoVar3);
        zzfoVar3.zzp(new zzju(zzkcVar, jElapsedRealtime2, 1));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zzkc zzkcVar = ((zzfr) this.zza.mBuilder).zzo;
        zzfr.zzQ(zzkcVar);
        ((zzfr) zzkcVar.mBuilder).zzr.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        zzfo zzfoVar = ((zzfr) zzkcVar.mBuilder).zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new zzju(zzkcVar, jElapsedRealtime, 0));
        zzim zzimVar = ((zzfr) this.zza.mBuilder).zzs;
        zzfr.zzQ(zzimVar);
        synchronized (zzimVar.zzj) {
            zzimVar.zzi = true;
            if (activity != zzimVar.zze) {
                synchronized (zzimVar.zzj) {
                    zzimVar.zze = activity;
                    zzimVar.zzf = false;
                }
                if (((zzfr) zzimVar.mBuilder).zzk.zzu()) {
                    zzimVar.zzg = null;
                    zzfo zzfoVar2 = ((zzfr) zzimVar.mBuilder).zzn;
                    zzfr.zzR(zzfoVar2);
                    zzfoVar2.zzp(new zzii(zzimVar, 1));
                }
            }
        }
        if (!((zzfr) zzimVar.mBuilder).zzk.zzu()) {
            zzimVar.zzb = zzimVar.zzg;
            zzfo zzfoVar3 = ((zzfr) zzimVar.mBuilder).zzn;
            zzfr.zzR(zzfoVar3);
            zzfoVar3.zzp(new zzii(zzimVar, 0));
            return;
        }
        zzimVar.zzz(activity, zzimVar.zzy(activity), false);
        zzd zzdVarZzd = ((zzfr) zzimVar.mBuilder).zzd();
        ((zzfr) zzdVarZzd.mBuilder).zzr.getClass();
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        zzfo zzfoVar4 = ((zzfr) zzdVarZzd.mBuilder).zzn;
        zzfr.zzR(zzfoVar4);
        zzfoVar4.zzp(new zzc(zzdVarZzd, jElapsedRealtime2, 0));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zzfr zzfrVar = (zzfr) this.zza.mBuilder;
        try {
            try {
                zzeh zzehVar = zzfrVar.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzl.zza("onActivityCreated");
                Intent intent = activity.getIntent();
                if (intent == null) {
                    return;
                }
                Uri data = intent.getData();
                if (data != null && data.isHierarchical()) {
                    zzfr.zzP(zzfrVar.zzp);
                    String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
                    String str = ("android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || FETmZwrVHuasmL.ZIFLCKMbPqbZhHZ.equals(stringExtra)) ? "gs" : "auto";
                    String queryParameter = data.getQueryParameter(GsPcpBmONXh.GZlnFdyFESE);
                    boolean z = bundle == null;
                    zzfo zzfoVar = zzfrVar.zzn;
                    zzfr.zzR(zzfoVar);
                    zzfoVar.zzp(new zzk(this, z, data, str, queryParameter));
                }
            } catch (RuntimeException e) {
                zzeh zzehVar2 = zzfrVar.zzm;
                zzfr.zzR(zzehVar2);
                zzehVar2.zzd.zzb(e, "Throwable caught in onActivityCreated");
            }
        } finally {
            zzim zzimVar = zzfrVar.zzs;
            zzfr.zzQ(zzimVar);
            zzimVar.zzr(activity, bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzie zzieVar;
        zzim zzimVar = ((zzfr) this.zza.mBuilder).zzs;
        zzfr.zzQ(zzimVar);
        if (!((zzfr) zzimVar.mBuilder).zzk.zzu() || bundle == null || (zzieVar = (zzie) zzimVar.zzd.get(activity)) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", zzieVar.zzc);
        bundle2.putString(iafHZUfOuHNwvy.OWvltEJuSjktk, zzieVar.zza);
        bundle2.putString("referrer_name", zzieVar.zzb);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }
}
