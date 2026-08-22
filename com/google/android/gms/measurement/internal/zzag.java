package com.google.android.gms.measurement.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat$Style;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public final class zzag extends NotificationCompat$Style {
    public Boolean zza;
    public zzaf zzb;
    public Boolean zzc;

    public final String zzB(String str) {
        zzfr zzfrVar = (zzfr) this.mBuilder;
        try {
            String str2 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, "");
            com.google.android.gms.common.internal.zzah.checkNotNull(str2);
            return str2;
        } catch (ClassNotFoundException e) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zzb(e, "Could not find SystemProperties class");
            return "";
        } catch (IllegalAccessException e2) {
            zzeh zzehVar2 = zzfrVar.zzm;
            zzfr.zzR(zzehVar2);
            zzehVar2.zzd.zzb(e2, "Could not access SystemProperties.get()");
            return "";
        } catch (NoSuchMethodException e3) {
            zzeh zzehVar3 = zzfrVar.zzm;
            zzfr.zzR(zzehVar3);
            zzehVar3.zzd.zzb(e3, "Could not find SystemProperties.get() method");
            return "";
        } catch (InvocationTargetException e4) {
            zzeh zzehVar4 = zzfrVar.zzm;
            zzfr.zzR(zzehVar4);
            zzehVar4.zzd.zzb(e4, "SystemProperties.get() threw an exception");
            return "";
        }
    }

    public final double zza(String str, zzdt zzdtVar) {
        if (str == null) {
            return ((Double) zzdtVar.zza(null)).doubleValue();
        }
        String strZza = this.zzb.zza(str, zzdtVar.zzb);
        if (TextUtils.isEmpty(strZza)) {
            return ((Double) zzdtVar.zza(null)).doubleValue();
        }
        try {
            return ((Double) zzdtVar.zza(Double.valueOf(Double.parseDouble(strZza)))).doubleValue();
        } catch (NumberFormatException unused) {
            return ((Double) zzdtVar.zza(null)).doubleValue();
        }
    }

    public final int zzc() {
        zzlb zzlbVar = ((zzfr) this.mBuilder).zzp;
        zzfr.zzP(zzlbVar);
        Boolean bool = ((zzfr) zzlbVar.mBuilder).zzt().zzc;
        if (zzlbVar.zzm() < 201500) {
            return (bool == null || bool.booleanValue()) ? 25 : 100;
        }
        return 100;
    }

    public final int zze(String str, zzdt zzdtVar) {
        if (str == null) {
            return ((Integer) zzdtVar.zza(null)).intValue();
        }
        String strZza = this.zzb.zza(str, zzdtVar.zzb);
        if (TextUtils.isEmpty(strZza)) {
            return ((Integer) zzdtVar.zza(null)).intValue();
        }
        try {
            return ((Integer) zzdtVar.zza(Integer.valueOf(Integer.parseInt(strZza)))).intValue();
        } catch (NumberFormatException unused) {
            return ((Integer) zzdtVar.zza(null)).intValue();
        }
    }

    public final void zzh() {
        ((zzfr) this.mBuilder).getClass();
    }

    public final long zzi(String str, zzdt zzdtVar) {
        if (str == null) {
            return ((Long) zzdtVar.zza(null)).longValue();
        }
        String strZza = this.zzb.zza(str, zzdtVar.zzb);
        if (TextUtils.isEmpty(strZza)) {
            return ((Long) zzdtVar.zza(null)).longValue();
        }
        try {
            return ((Long) zzdtVar.zza(Long.valueOf(Long.parseLong(strZza)))).longValue();
        } catch (NumberFormatException unused) {
            return ((Long) zzdtVar.zza(null)).longValue();
        }
    }

    public final Bundle zzj() {
        zzfr zzfrVar = (zzfr) this.mBuilder;
        try {
            if (zzfrVar.zze.getPackageManager() == null) {
                zzeh zzehVar = zzfrVar.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzd.zza("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(zzfrVar.zze).getApplicationInfo(128, zzfrVar.zze.getPackageName());
            if (applicationInfo != null) {
                return applicationInfo.metaData;
            }
            zzeh zzehVar2 = zzfrVar.zzm;
            zzfr.zzR(zzehVar2);
            zzehVar2.zzd.zza("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            zzeh zzehVar3 = zzfrVar.zzm;
            zzfr.zzR(zzehVar3);
            zzehVar3.zzd.zzb(e, "Failed to load metadata: Package name not found");
            return null;
        }
    }

    public final Boolean zzk(String str) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        Bundle bundleZzj = zzj();
        if (bundleZzj != null) {
            if (bundleZzj.containsKey(str)) {
                return Boolean.valueOf(bundleZzj.getBoolean(str));
            }
            return null;
        }
        zzeh zzehVar = ((zzfr) this.mBuilder).zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzd.zza("Failed to load metadata: Metadata bundle is null");
        return null;
    }

    public final boolean zzs(String str, zzdt zzdtVar) {
        if (str == null) {
            return ((Boolean) zzdtVar.zza(null)).booleanValue();
        }
        String strZza = this.zzb.zza(str, zzdtVar.zzb);
        return TextUtils.isEmpty(strZza) ? ((Boolean) zzdtVar.zza(null)).booleanValue() : ((Boolean) zzdtVar.zza(Boolean.valueOf("1".equals(strZza)))).booleanValue();
    }

    public final boolean zzt(String str) {
        return "1".equals(this.zzb.zza(str, "gaia_collection_enabled"));
    }

    public final boolean zzu() {
        Boolean boolZzk = zzk("google_analytics_automatic_screen_reporting_enabled");
        return boolZzk == null || boolZzk.booleanValue();
    }

    public final boolean zzv() {
        ((zzfr) this.mBuilder).getClass();
        Boolean boolZzk = zzk("firebase_analytics_collection_deactivated");
        return boolZzk != null && boolZzk.booleanValue();
    }

    public final boolean zzw(String str) {
        return "1".equals(this.zzb.zza(str, "measurement.event_sampling_enabled"));
    }

    public final boolean zzx() {
        if (this.zza == null) {
            Boolean boolZzk = zzk("app_measurement_lite");
            this.zza = boolZzk;
            if (boolZzk == null) {
                this.zza = Boolean.FALSE;
            }
        }
        return this.zza.booleanValue() || !((zzfr) this.mBuilder).zzi;
    }
}
