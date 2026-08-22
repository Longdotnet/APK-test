package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat$Style;
import com.facebook.AccessTokenCache;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.games.provider.NtJ.wsbWxekY;
import com.google.android.gms.internal.measurement.zzcl;
import com.google.gson.yWTz.kBfGXgdfpo;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class zzfr implements zzgm {
    public static volatile zzfr zzd;
    public zzdy zzA;
    public Boolean zzC;
    public long zzD;
    public volatile Boolean zzE;
    public volatile boolean zzF;
    public int zzG;
    public final Boolean zza;
    public final Boolean zzb;
    public final long zzc;
    public final Context zze;
    public final String zzf;
    public final String zzg;
    public final String zzh;
    public final boolean zzi;
    public final zzdg zzj;
    public final zzag zzk;
    public final zzew zzl;
    public final zzeh zzm;
    public final zzfo zzn;
    public final zzkc zzo;
    public final zzlb zzp;
    public final zzec zzq;
    public final DefaultClock zzr;
    public final zzim zzs;
    public final zzhx zzt;
    public final zzd zzu;
    public final zzib zzv;
    public final String zzw;
    public zzea zzx;
    public zzjm zzy;
    public zzaq zzz;
    public boolean zzB = false;
    public final AtomicInteger zzH = new AtomicInteger(0);

    public static final void zzP(NotificationCompat$Style notificationCompat$Style) {
        if (notificationCompat$Style == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    public static final void zzQ(zzf zzfVar) {
        if (zzfVar == null) {
            throw new IllegalStateException("Component not created");
        }
        if (!zzfVar.zza) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(zzfVar.getClass())));
        }
    }

    public static final void zzR(zzgl zzglVar) {
        if (zzglVar == null) {
            throw new IllegalStateException("Component not created");
        }
        if (!zzglVar.zza) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(zzglVar.getClass())));
        }
    }

    public static zzfr zzp(Context context, zzcl zzclVar, Long l) {
        Bundle bundle;
        if (zzclVar != null && (zzclVar.zze == null || zzclVar.zzf == null)) {
            zzclVar = new zzcl(zzclVar.zza, zzclVar.zzb, zzclVar.zzc, zzclVar.zzd, null, null, zzclVar.zzg, null);
        }
        com.google.android.gms.common.internal.zzah.checkNotNull(context);
        com.google.android.gms.common.internal.zzah.checkNotNull(context.getApplicationContext());
        if (zzd == null) {
            synchronized (zzfr.class) {
                try {
                    if (zzd == null) {
                        zzd = new zzfr(new zzgu(context, zzclVar, l));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (zzclVar != null && (bundle = zzclVar.zzg) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            com.google.android.gms.common.internal.zzah.checkNotNull(zzd);
            zzd.zzE = Boolean.valueOf(zzclVar.zzg.getBoolean("dataCollectionDefaultEnabled"));
        }
        com.google.android.gms.common.internal.zzah.checkNotNull(zzd);
        return zzd;
    }

    public final void zzB$1() {
        this.zzH.incrementAndGet();
    }

    public final boolean zzJ() {
        return zza() == 0;
    }

    public final int zza() {
        zzfo zzfoVar = this.zzn;
        zzR(zzfoVar);
        zzfoVar.zzg();
        if (this.zzk.zzv()) {
            return 1;
        }
        Boolean bool = this.zzb;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        zzfo zzfoVar2 = this.zzn;
        zzR(zzfoVar2);
        zzfoVar2.zzg();
        if (!this.zzF) {
            return 8;
        }
        zzew zzewVar = this.zzl;
        zzP(zzewVar);
        zzewVar.zzg();
        Boolean boolValueOf = zzewVar.zza().contains("measurement_enabled") ? Boolean.valueOf(zzewVar.zza().getBoolean("measurement_enabled", true)) : null;
        if (boolValueOf != null) {
            return boolValueOf.booleanValue() ? 0 : 3;
        }
        zzag zzagVar = this.zzk;
        zzdg zzdgVar = ((zzfr) zzagVar.mBuilder).zzj;
        Boolean boolZzk = zzagVar.zzk("firebase_analytics_collection_enabled");
        if (boolZzk != null) {
            return boolZzk.booleanValue() ? 0 : 4;
        }
        Boolean bool2 = this.zza;
        if (bool2 != null) {
            return bool2.booleanValue() ? 0 : 5;
        }
        return (this.zzE == null || this.zzE.booleanValue()) ? 0 : 7;
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    public final Context zzau() {
        return this.zze;
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    public final Clock zzav() {
        return this.zzr;
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    public final zzdg zzaw() {
        return this.zzj;
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    public final zzeh zzay() {
        zzeh zzehVar = this.zzm;
        zzR(zzehVar);
        return zzehVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    public final zzfo zzaz() {
        zzfo zzfoVar = this.zzn;
        zzR(zzfoVar);
        return zzfoVar;
    }

    public final zzd zzd() {
        zzd zzdVar = this.zzu;
        if (zzdVar != null) {
            return zzdVar;
        }
        throw new IllegalStateException("Component not created");
    }

    public final zzaq zzg() {
        zzR(this.zzz);
        return this.zzz;
    }

    public final zzdy zzh() {
        zzQ(this.zzA);
        return this.zzA;
    }

    public final zzea zzi() {
        zzQ(this.zzx);
        return this.zzx;
    }

    public final zzec zzj() {
        return this.zzq;
    }

    public final zzjm zzt() {
        zzQ(this.zzy);
        return this.zzy;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0034  */
    /* JADX WARN: Code duplicated, block: B:25:0x0076  */
    /* JADX WARN: Code duplicated, block: B:28:0x007f  */
    /* JADX WARN: Code duplicated, block: B:30:0x0096  */
    /* JADX WARN: Code duplicated, block: B:33:0x00a6  */
    public final boolean zzM() {
        zzlb zzlbVar;
        boolean z;
        boolean z2;
        String strZzm;
        zzdy zzdyVarZzh;
        zzdy zzdyVarZzh2;
        if (!this.zzB) {
            throw new IllegalStateException(kBfGXgdfpo.NxbQjyhU);
        }
        zzfo zzfoVar = this.zzn;
        zzR(zzfoVar);
        zzfoVar.zzg();
        Boolean bool = this.zzC;
        DefaultClock defaultClock = this.zzr;
        if (bool == null || this.zzD == 0) {
            defaultClock.getClass();
            this.zzD = SystemClock.elapsedRealtime();
            zzlbVar = this.zzp;
            zzP(zzlbVar);
            z = true;
            if (zzlbVar.zzad("android.permission.INTERNET") || !zzlbVar.zzad("android.permission.ACCESS_NETWORK_STATE")) {
                z2 = false;
            } else {
                Context context = this.zze;
                if (Wrappers.packageManager(context).isCallerInstantApp() || this.zzk.zzx() || (zzlb.zzaj(context) && zzlb.zzak(context))) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            this.zzC = Boolean.valueOf(z2);
            if (z2) {
                strZzm = zzh().zzm();
                zzdyVarZzh = zzh();
                zzdyVarZzh.zza();
                if (!zzlbVar.zzX(strZzm, zzdyVarZzh.zzl)) {
                    zzdyVarZzh2 = zzh();
                    zzdyVarZzh2.zza();
                    if (TextUtils.isEmpty(zzdyVarZzh2.zzl)) {
                        z = false;
                    }
                }
                this.zzC = Boolean.valueOf(z);
            }
        } else if (!bool.booleanValue()) {
            defaultClock.getClass();
            if (Math.abs(SystemClock.elapsedRealtime() - this.zzD) > 1000) {
                defaultClock.getClass();
                this.zzD = SystemClock.elapsedRealtime();
                zzlbVar = this.zzp;
                zzP(zzlbVar);
                z = true;
                if (zzlbVar.zzad("android.permission.INTERNET")) {
                    z2 = false;
                } else {
                    z2 = false;
                }
                this.zzC = Boolean.valueOf(z2);
                if (z2) {
                    strZzm = zzh().zzm();
                    zzdyVarZzh = zzh();
                    zzdyVarZzh.zza();
                    if (!zzlbVar.zzX(strZzm, zzdyVarZzh.zzl)) {
                        zzdyVarZzh2 = zzh();
                        zzdyVarZzh2.zza();
                        if (TextUtils.isEmpty(zzdyVarZzh2.zzl)) {
                            z = false;
                        }
                    }
                    this.zzC = Boolean.valueOf(z);
                }
            }
        }
        return this.zzC.booleanValue();
    }

    public zzfr(zzgu zzguVar) {
        long jCurrentTimeMillis;
        Bundle bundle;
        Context context = zzguVar.zza;
        zzdg zzdgVar = new zzdg(10);
        this.zzj = zzdgVar;
        zzg.zza = zzdgVar;
        this.zze = context;
        this.zzf = zzguVar.zzb;
        this.zzg = zzguVar.zzc;
        this.zzh = zzguVar.zzd;
        this.zzi = zzguVar.zzh;
        this.zzE = zzguVar.zze;
        this.zzw = zzguVar.zzj;
        this.zzF = true;
        zzcl zzclVar = zzguVar.zzg;
        if (zzclVar != null && (bundle = zzclVar.zzg) != null) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.zza = (Boolean) obj;
            }
            Object obj2 = zzclVar.zzg.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.zzb = (Boolean) obj2;
            }
        }
        com.google.android.gms.internal.measurement.zzib.zze(context);
        this.zzr = DefaultClock.zza;
        Long l = zzguVar.zzi;
        if (l != null) {
            jCurrentTimeMillis = l.longValue();
        } else {
            jCurrentTimeMillis = System.currentTimeMillis();
        }
        this.zzc = jCurrentTimeMillis;
        zzag zzagVar = new zzag(this);
        zzagVar.zzb = zzae.zza;
        this.zzk = zzagVar;
        zzew zzewVar = new zzew(this);
        zzewVar.zzv();
        this.zzl = zzewVar;
        zzeh zzehVar = new zzeh(this);
        zzehVar.zzv();
        this.zzm = zzehVar;
        zzlb zzlbVar = new zzlb(this);
        zzlbVar.zzv();
        this.zzp = zzlbVar;
        this.zzq = new zzec(new AccessTokenCache(this, 24));
        this.zzu = new zzd(this);
        zzim zzimVar = new zzim(this);
        zzimVar.zzb$1();
        this.zzs = zzimVar;
        zzhx zzhxVar = new zzhx(this);
        zzhxVar.zzb$1();
        this.zzt = zzhxVar;
        zzkc zzkcVar = new zzkc(this);
        zzkcVar.zzb$1();
        this.zzo = zzkcVar;
        zzib zzibVar = new zzib(this);
        zzibVar.zzv();
        this.zzv = zzibVar;
        zzfo zzfoVar = new zzfo(this);
        zzfoVar.zzv();
        this.zzn = zzfoVar;
        zzcl zzclVar2 = zzguVar.zzg;
        boolean z = zzclVar2 == null || zzclVar2.zzb == 0;
        if (context.getApplicationContext() instanceof Application) {
            zzQ(zzhxVar);
            if (((zzfr) zzhxVar.mBuilder).zze.getApplicationContext() instanceof Application) {
                Application application = (Application) ((zzfr) zzhxVar.mBuilder).zze.getApplicationContext();
                if (zzhxVar.zza == null) {
                    zzhxVar.zza = new zzhw(zzhxVar);
                }
                if (z) {
                    application.unregisterActivityLifecycleCallbacks(zzhxVar.zza);
                    application.registerActivityLifecycleCallbacks(zzhxVar.zza);
                    zzeh zzehVar2 = ((zzfr) zzhxVar.mBuilder).zzm;
                    zzR(zzehVar2);
                    zzehVar2.zzl.zza("Registered activity lifecycle callback");
                }
            }
        } else {
            zzR(zzehVar);
            zzehVar.zzg.zza(wsbWxekY.sfLNzy);
        }
        zzfoVar.zzp(new com.google.android.gms.ads.zza((Object) this, (Object) zzguVar, 29, false));
    }
}
