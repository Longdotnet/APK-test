package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class zzeme implements zzeub {
    final zzfcw zza;
    private final long zzb;

    public zzeme(zzfcw zzfcwVar, long j) {
        this.zza = zzfcwVar;
        this.zzb = j;
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final void zza(Object obj) {
        Bundle bundle = ((zzcva) obj).zzb;
        zzfcw zzfcwVar = this.zza;
        bundle.putString("slotname", zzfcwVar.zzf);
        com.google.android.gms.ads.internal.client.zzm zzmVar = zzfcwVar.zzd;
        if (zzmVar.zzf) {
            bundle.putBoolean("test_request", true);
        }
        int i = zzmVar.zzg;
        zzfdk.zze(bundle, "tag_for_child_directed_treatment", i, i != -1);
        if (zzmVar.zza >= 8) {
            int i2 = zzmVar.zzt;
            zzfdk.zze(bundle, "tag_for_under_age_of_consent", i2, i2 != -1);
        }
        zzfdk.zzc(bundle, "url", zzmVar.zzl);
        zzfdk.zzd(bundle, "neighboring_content_urls", zzmVar.zzv);
        Bundle bundle2 = zzmVar.zzc;
        Bundle bundle3 = (Bundle) bundle2.clone();
        HashSet hashSet = new HashSet(Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzhP)).split(",", -1)));
        for (String str : bundle2.keySet()) {
            if (!hashSet.contains(str)) {
                bundle3.remove(str);
            }
        }
        zzfdk.zzb(bundle, "extras", bundle3);
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final void zzb(Object obj) {
        Bundle bundle = ((zzcva) obj).zza;
        zzfcw zzfcwVar = this.zza;
        com.google.android.gms.ads.internal.client.zzm zzmVar = zzfcwVar.zzd;
        bundle.putInt("http_timeout_millis", zzmVar.zzw);
        bundle.putString("slotname", zzfcwVar.zzf);
        int i = zzfcwVar.zzo.zza;
        if (i == 0) {
            throw null;
        }
        int i2 = i - 1;
        if (i2 == 1) {
            bundle.putBoolean("is_new_rewarded", true);
        } else if (i2 == 2) {
            bundle.putBoolean("is_rewarded_interstitial", true);
        }
        bundle.putLong("start_signals_timestamp", this.zzb);
        Bundle bundle2 = zzmVar.zzc;
        zzfdk.zzg(bundle, "is_sdk_preload", true, bundle2.getBoolean("is_sdk_preload", false));
        zzfdk.zzf(bundle, "prefetch_type", "zenith_v2", bundle2.getBoolean("zenith_v2", false));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.US);
        long j = zzmVar.zzb;
        zzfdk.zzf(bundle, "cust_age", simpleDateFormat.format(new Date(j)), j != -1);
        zzfdk.zzb(bundle, "extras", bundle2);
        int i3 = zzmVar.zzd;
        zzfdk.zze(bundle, "cust_gender", i3, i3 != -1);
        zzfdk.zzd(bundle, "kw", zzmVar.zze);
        int i4 = zzmVar.zzg;
        zzfdk.zze(bundle, "tag_for_child_directed_treatment", i4, i4 != -1);
        if (zzmVar.zzf) {
            bundle.putBoolean("test_request", true);
        }
        bundle.putInt("ppt_p13n", zzmVar.zzy);
        int i5 = zzmVar.zza;
        zzfdk.zze(bundle, "d_imp_hdr", 1, i5 >= 2 && zzmVar.zzh);
        String str = zzmVar.zzi;
        zzfdk.zzf(bundle, "ppid", str, i5 >= 2 && !TextUtils.isEmpty(str));
        Location location = zzmVar.zzk;
        if (location != null) {
            float accuracy = location.getAccuracy() * 1000.0f;
            long time = location.getTime() * 1000;
            double latitude = location.getLatitude() * 1.0E7d;
            double longitude = 1.0E7d * location.getLongitude();
            Bundle bundle3 = new Bundle();
            bundle3.putFloat("radius", accuracy);
            bundle3.putLong("lat", (long) latitude);
            bundle3.putLong("long", (long) longitude);
            bundle3.putLong("time", time);
            bundle.putBundle("uule", bundle3);
        }
        zzfdk.zzc(bundle, "url", zzmVar.zzl);
        zzfdk.zzd(bundle, "neighboring_content_urls", zzmVar.zzv);
        zzfdk.zzb(bundle, "custom_targeting", zzmVar.zzn);
        zzfdk.zzd(bundle, "category_exclusions", zzmVar.zzo);
        zzfdk.zzc(bundle, "request_agent", zzmVar.zzp);
        zzfdk.zzc(bundle, "request_pkg", zzmVar.zzq);
        zzfdk.zzg(bundle, "is_designed_for_families", zzmVar.zzr, i5 >= 7);
        if (i5 >= 8) {
            int i6 = zzmVar.zzt;
            zzfdk.zze(bundle, "tag_for_under_age_of_consent", i6, i6 != -1);
            zzfdk.zzc(bundle, "max_ad_content_rating", zzmVar.zzu);
        }
    }
}
