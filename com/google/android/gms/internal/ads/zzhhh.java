package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.ads.jY.UUFMQdNK;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzhhh {
    private static String zza;

    /* JADX WARN: Code duplicated, block: B:43:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:44:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:46:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:47:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:49:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:50:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:52:0x00e4  */
    public static String zza(Context context) {
        String str;
        String str2 = zza;
        if (str2 != null) {
            return str2;
        }
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.example.com"));
        ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intent, 0);
        String str3 = resolveInfoResolveActivity != null ? resolveInfoResolveActivity.activityInfo.packageName : null;
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : listQueryIntentActivities) {
            Intent intent2 = new Intent();
            intent2.setAction("android.support.customtabs.action.CustomTabsService");
            intent2.setPackage(resolveInfo.activityInfo.packageName);
            if (packageManager.resolveService(intent2, 0) != null) {
                arrayList.add(resolveInfo.activityInfo.packageName);
            }
        }
        if (arrayList.isEmpty()) {
            zza = null;
        } else if (arrayList.size() == 1) {
            zza = (String) arrayList.get(0);
        } else if (!TextUtils.isEmpty(str3)) {
            try {
                List<ResolveInfo> listQueryIntentActivities2 = context.getPackageManager().queryIntentActivities(intent, 64);
                if (listQueryIntentActivities2 != null && listQueryIntentActivities2.size() != 0) {
                    Iterator<ResolveInfo> it = listQueryIntentActivities2.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            ResolveInfo next = it.next();
                            IntentFilter intentFilter = next.filter;
                            if (intentFilter == null || intentFilter.countDataAuthorities() == 0 || intentFilter.countDataPaths() == 0 || next.activityInfo == null) {
                            }
                        } else if (arrayList.contains(str3)) {
                            zza = str3;
                        }
                        if (arrayList.contains("com.android.chrome")) {
                            zza = "com.android.chrome";
                        } else {
                            str = UUFMQdNK.ZITHVOKsPHDpTUn;
                            if (arrayList.contains(str)) {
                                zza = str;
                            } else if (arrayList.contains("com.chrome.dev")) {
                                zza = "com.chrome.dev";
                            }
                        }
                    }
                } else if (arrayList.contains(str3)) {
                    zza = str3;
                } else if (arrayList.contains("com.android.chrome")) {
                    zza = "com.android.chrome";
                } else {
                    str = UUFMQdNK.ZITHVOKsPHDpTUn;
                    if (arrayList.contains(str)) {
                        zza = str;
                    } else if (arrayList.contains("com.chrome.dev")) {
                        zza = "com.chrome.dev";
                    }
                }
            } catch (RuntimeException unused) {
                Log.e("CustomTabsHelper", "Runtime exception while getting specialized handlers");
            }
        } else if (arrayList.contains("com.android.chrome")) {
            zza = "com.android.chrome";
        } else {
            str = UUFMQdNK.ZITHVOKsPHDpTUn;
            if (arrayList.contains(str)) {
                zza = str;
            } else if (arrayList.contains("com.chrome.dev")) {
                zza = "com.chrome.dev";
            }
        }
        return zza;
    }
}
