package com.google.android.gms.internal.ads;

import android.app.LocaleManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.LocaleList;
import android.os.StatFs;
import androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
final class zzeun implements zzeuc {
    private final zzgdy zza;
    private final Context zzb;

    public zzeun(zzgdy zzgdyVar, Context context) {
        this.zza = zzgdyVar;
        this.zzb = context;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0065  */
    /* JADX WARN: Code duplicated, block: B:37:0x0127  */
    public static zzeul zzc(zzeun zzeunVar) {
        ActivityInfo activityInfo;
        String str;
        String str2;
        boolean zEquals;
        String string;
        Context context = zzeunVar.zzb;
        PackageManager packageManager = context.getPackageManager();
        Locale locale = Locale.getDefault();
        ResolveInfo resolveInfoZzd = zzd(packageManager, "geo:0,0?q=donuts");
        ResolveInfo resolveInfoZzd2 = zzd(packageManager, "http://www.google.com");
        String country = locale.getCountry();
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
        com.google.android.gms.ads.internal.util.client.zzf zzfVar = com.google.android.gms.ads.internal.client.zzbb.zzb.zzc;
        boolean zZzw = com.google.android.gms.ads.internal.util.client.zzf.zzw();
        boolean zIsLatchsky = Hex.isLatchsky(context);
        boolean zZza = Hex.zza(context);
        String language = locale.getLanguage();
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 24) {
            LocaleList localeList = LocaleList.getDefault();
            for (int i = 0; i < localeList.size(); i++) {
                arrayList.add(localeList.get(i).getLanguage());
            }
        }
        ResolveInfo resolveInfoZzd3 = zzd(packageManager, "market://details?id=com.google.android.gms.ads");
        if (resolveInfoZzd3 == null || (activityInfo = resolveInfoZzd3.activityInfo) == null) {
            str = null;
        } else {
            try {
                PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(0, activityInfo.packageName);
                if (packageInfo != null) {
                    str = packageInfo.versionCode + "." + activityInfo.packageName;
                } else {
                    str = null;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        try {
            PackageInfo packageInfo2 = Wrappers.packageManager(zzeunVar.zzb).getPackageInfo(128, "com.android.vending");
            str2 = packageInfo2 != null ? packageInfo2.versionCode + "." + packageInfo2.packageName : null;
        } catch (Exception unused2) {
        }
        String str3 = Build.FINGERPRINT;
        String language2 = Locale.getDefault().getLanguage();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zznI)).booleanValue()) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 33) {
                LocaleManager localeManagerM = ComponentDialog$$ExternalSyntheticApiModelOutline0.m(zzeunVar.zzb.getSystemService(ComponentDialog$$ExternalSyntheticApiModelOutline0.m4m()));
                if (localeManagerM != null) {
                    language2 = localeManagerM.getSystemLocales().get(0).getLanguage();
                }
            } else {
                language2 = i2 >= 24 ? zzeunVar.zzb.getResources().getConfiguration().getLocales().get(0).getLanguage() : zzeunVar.zzb.getResources().getConfiguration().locale.getLanguage();
            }
        }
        String str4 = language2;
        Context context2 = zzeunVar.zzb;
        if (packageManager == null) {
            zEquals = false;
            break;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intent, 0);
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        if (listQueryIntentActivities == null || resolveInfoResolveActivity == null) {
            zEquals = false;
            break;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= listQueryIntentActivities.size()) {
                zEquals = false;
                break;
            }
            List<ResolveInfo> list = listQueryIntentActivities;
            if (resolveInfoResolveActivity.activityInfo.name.equals(listQueryIntentActivities.get(i3).activityInfo.name)) {
                zEquals = resolveInfoResolveActivity.activityInfo.packageName.equals(zzhhh.zza(context2));
                break;
            }
            i3++;
            listQueryIntentActivities = list;
        }
        com.google.android.gms.ads.internal.util.zzs zzsVar2 = com.google.android.gms.ads.internal.zzv.zza.zzd;
        long availableBytes = new StatFs(Environment.getDataDirectory().getAbsolutePath()).getAvailableBytes() / 1024;
        zzbcv zzbcvVar = zzbde.zzlN;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        boolean z = ((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() && com.google.android.gms.ads.internal.util.zzs.zzC(context2);
        if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzlR)).booleanValue()) {
            try {
                Bundle bundle = Wrappers.packageManager(context2).getApplicationInfo(128, context2.getPackageName()).metaData;
                string = (bundle == null || !bundle.containsKey("com.google.unity.ads.UNITY_VERSION")) ? null : bundle.getString("com.google.unity.ads.UNITY_VERSION");
            } catch (PackageManager.NameNotFoundException unused3) {
            }
        } else {
            string = "";
        }
        return new zzeul(resolveInfoZzd != null, resolveInfoZzd2 != null, country, zZzw, zIsLatchsky, zZza, language, arrayList, str, str2, str3, zEquals, Build.MODEL, availableBytes, z, string, Build.VERSION.SDK_INT, str4);
    }

    private static ResolveInfo zzd(PackageManager packageManager, String str) {
        return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 38;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeum
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzeun.zzc(this.zza);
            }
        });
    }
}
