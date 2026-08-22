package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.work.impl.constraints.controllers.pST.ehgOP;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;
import com.google.android.gms.ads.jY.UUFMQdNK;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.measurement.internal.RVw.ZRqOdXiy;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzfkl {
    private final zzdsj zza;
    private final String zzb;

    public zzfkl(zzdsj zzdsjVar, Context context) {
        CharSequence applicationLabel;
        this.zza = zzdsjVar;
        com.google.android.gms.ads.internal.util.zzf zzfVar = com.google.android.gms.ads.internal.util.zzs.zza;
        try {
            applicationLabel = Wrappers.packageManager(context).getApplicationLabel(context.getPackageName());
        } catch (PackageManager.NameNotFoundException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to get application name", e);
            applicationLabel = "";
        }
        this.zzb = applicationLabel.toString();
    }

    private final void zzq(String str, String str2, long j, int i, int i2, String str3, zzfkt zzfktVar, String str4) {
        zzdsi zzdsiVarZza = this.zza.zza();
        zzdsiVarZza.zzb(str2, Long.toString(j));
        zzdsiVarZza.zzb("app", this.zzb);
        if (zzfktVar != null) {
            zzdsiVarZza.zzb("ad_unit_id", zzfktVar.zzb());
            zzdsiVarZza.zzb(FirebaseAnalytics.Param.AD_FORMAT, zzfktVar.zza());
            zzdsiVarZza.zzb("pid", zzfktVar.zzc());
        }
        zzdsiVarZza.zzb("action", str);
        if (str3 != null) {
            zzdsiVarZza.zzb("gqi", str3);
        }
        if (i >= 0) {
            zzdsiVarZza.zzb("max_ads", Integer.toString(i));
        }
        if (i2 >= 0) {
            zzdsiVarZza.zzb("cache_size", Integer.toString(i2));
        }
        zzdsiVarZza.zzb("pv", str4);
        zzdsiVarZza.zzj();
    }

    private final void zzr(String str, long j, String str2, String str3, AdFormat adFormat, int i, int i2, int i3, String str4) {
        zzdsi zzdsiVarZza = this.zza.zza();
        zzdsiVarZza.zzb("action", str);
        zzdsiVarZza.zzb("pat", Long.toString(j));
        zzdsiVarZza.zzb("app", this.zzb);
        zzdsiVarZza.zzb(FirebaseAnalytics.Param.AD_FORMAT, adFormat.name().toLowerCase(Locale.ENGLISH));
        zzdsiVarZza.zzb("max_ads", Integer.toString(i));
        zzdsiVarZza.zzb("cache_size", Integer.toString(i2));
        zzdsiVarZza.zzb("pas", Integer.toString(i3));
        zzdsiVarZza.zzb("pv", "2");
        zzdsiVarZza.zzb("ad_unit_id", str3);
        zzdsiVarZza.zzb("pid", str2);
        zzdsiVarZza.zzj();
    }

    public final void zza(int i, int i2, long j, zzfkt zzfktVar) {
        zzdsi zzdsiVarZza = this.zza.zza();
        zzdsiVarZza.zzb("action", "cache_resize");
        zzdsiVarZza.zzb("cs_ts", Long.toString(j));
        zzdsiVarZza.zzb("app", this.zzb);
        zzdsiVarZza.zzb("orig_ma", Integer.toString(i));
        zzdsiVarZza.zzb("max_ads", Integer.toString(i2));
        zzdsiVarZza.zzb(FirebaseAnalytics.Param.AD_FORMAT, zzfktVar.zza());
        zzdsiVarZza.zzb("ad_unit_id", zzfktVar.zzb());
        zzdsiVarZza.zzb("pid", zzfktVar.zzc());
        zzdsiVarZza.zzb("pv", "1");
        zzdsiVarZza.zzj();
    }

    public final void zzb(long j, String str, String str2, AdFormat adFormat, int i, int i2) {
        zzr("pd", j, str, str2, adFormat, i, i2, 1, "2");
    }

    public final void zzc(long j, AdFormat adFormat, int i) {
        zzr("pda", j, null, null, adFormat, -1, -1, i, "2");
    }

    public final void zzd(long j, String str, String str2, AdFormat adFormat, int i, int i2) {
        zzr("pgc", j, str, str2, adFormat, i, i2, 1, "2");
    }

    public final void zze(AdFormat adFormat, long j, int i) {
        zzr("pgcs", j, null, null, adFormat, -1, -1, i, "2");
    }

    public final void zzg(long j, String str) {
        zzq("poll_ad", "ppacwe_ts", j, -1, -1, null, null, "2");
    }

    public final void zzh(int i, int i2, long j, Long l, String str, zzfkt zzfktVar, String str2) {
        zzdsi zzdsiVarZza = this.zza.zza();
        zzdsiVarZza.zzb("plaac_ts", Long.toString(j));
        zzdsiVarZza.zzb("app", this.zzb);
        zzdsiVarZza.zzb("max_ads", Integer.toString(i));
        zzdsiVarZza.zzb("cache_size", Integer.toString(i2));
        zzdsiVarZza.zzb("action", "is_ad_available");
        if (zzfktVar != null) {
            zzdsiVarZza.zzb("ad_unit_id", zzfktVar.zzb());
            zzdsiVarZza.zzb("pid", zzfktVar.zzc());
            zzdsiVarZza.zzb(FirebaseAnalytics.Param.AD_FORMAT, zzfktVar.zza());
        }
        if (l != null) {
            zzdsiVarZza.zzb("plaay_ts", Long.toString(l.longValue()));
        }
        if (str != null) {
            zzdsiVarZza.zzb("gqi", str);
        }
        zzdsiVarZza.zzb("pv", str2);
        zzdsiVarZza.zzj();
    }

    public final void zzi(long j, String str, zzfkt zzfktVar, int i, int i2, String str2) {
        zzq("paa", "pano_ts", j, i, i2, str, zzfktVar, str2);
    }

    public final void zzj(long j, zzfkt zzfktVar, int i, String str) {
        zzq(UUFMQdNK.uMvJjsGXvVDKDcI, "paeo_ts", j, i, 0, null, zzfktVar, str);
    }

    public final void zzk(long j, zzfkt zzfktVar, com.google.android.gms.ads.internal.client.zze zzeVar, int i, int i2, String str) {
        zzdsi zzdsiVarZza = this.zza.zza();
        zzdsiVarZza.zzb("action", "pftla");
        zzdsiVarZza.zzb("pftlat_ts", Long.toString(j));
        zzdsiVarZza.zzb("pftlaec", Integer.toString(zzeVar.zza));
        zzdsiVarZza.zzb("app", this.zzb);
        zzdsiVarZza.zzb(FirebaseAnalytics.Param.AD_FORMAT, zzfktVar.zza());
        zzdsiVarZza.zzb("max_ads", Integer.toString(i));
        zzdsiVarZza.zzb("cache_size", Integer.toString(i2));
        zzdsiVarZza.zzb("ad_unit_id", zzfktVar.zzb());
        zzdsiVarZza.zzb("pid", zzfktVar.zzc());
        zzdsiVarZza.zzb("pv", str);
        zzdsiVarZza.zzj();
    }

    public final void zzl(long j, zzfkt zzfktVar, int i, int i2, String str) {
        zzq("poll_ad", "ppac_ts", j, i, i2, null, zzfktVar, str);
    }

    public final void zzm(long j, int i, int i2, String str, zzfkt zzfktVar, String str2) {
        zzdsi zzdsiVarZza = this.zza.zza();
        zzdsiVarZza.zzb("ppla_ts", Long.toString(j));
        zzdsiVarZza.zzb("app", this.zzb);
        zzdsiVarZza.zzb(FirebaseAnalytics.Param.AD_FORMAT, zzfktVar.zza());
        zzdsiVarZza.zzb("ad_unit_id", zzfktVar.zzb());
        zzdsiVarZza.zzb("pid", zzfktVar.zzc());
        zzdsiVarZza.zzb("max_ads", Integer.toString(i));
        zzdsiVarZza.zzb("cache_size", Integer.toString(i2));
        zzdsiVarZza.zzb("action", "poll_ad");
        if (str != null) {
            zzdsiVarZza.zzb("gqi", str);
        }
        zzdsiVarZza.zzb("pv", str2);
        zzdsiVarZza.zzj();
    }

    public final void zzn(long j, int i, int i2, String str, zzfkt zzfktVar, String str2) {
        zzq("poll_ad", "psvroc_ts", j, i, i2, str, zzfktVar, str2);
    }

    public final void zzo(Map map, long j, String str) {
        zzdsi zzdsiVarZza = this.zza.zza();
        zzdsiVarZza.zzb("action", "start_preload");
        zzdsiVarZza.zzb("sp_ts", Long.toString(j));
        zzdsiVarZza.zzb("app", this.zzb);
        zzdsiVarZza.zzb("pv", "1");
        for (AdFormat adFormat : map.keySet()) {
            String strValueOf = String.valueOf(adFormat.name().toLowerCase(Locale.ENGLISH));
            zzdsiVarZza.zzb(strValueOf.concat("_count"), Integer.toString(((Integer) map.get(adFormat)).intValue()));
        }
        zzdsiVarZza.zzj();
    }

    public final void zzf(int i, long j, String str, String str2, AdFormat adFormat, int i2) {
        zzr(eoBKjVuj.UEqrxS, j, str, str2, adFormat, i2, i, 1, "2");
    }

    public final void zzp(int i, long j, zzfkt zzfktVar, String str) {
        zzdsi zzdsiVarZza = this.zza.zza();
        zzdsiVarZza.zzb("action", "start_preload");
        zzdsiVarZza.zzb("sp_ts", Long.toString(j));
        zzdsiVarZza.zzb(ehgOP.AOZbNM, this.zzb);
        zzdsiVarZza.zzb(ZRqOdXiy.JJxZRdy, zzfktVar.zza());
        zzdsiVarZza.zzb("ad_unit_id", zzfktVar.zzb());
        zzdsiVarZza.zzb("pid", zzfktVar.zzc());
        zzdsiVarZza.zzb("max_ads", Integer.toString(i));
        zzdsiVarZza.zzb("pv", str);
        zzdsiVarZza.zzj();
    }
}
