package com.android.billingclient.api;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent$Api23Impl;
import androidx.browser.customtabs.CustomTabsIntent$Api24Impl;
import androidx.browser.customtabs.CustomTabsIntent$Api34Impl;
import androidx.browser.customtabs.CustomTabsSession;
import androidx.room.RoomOpenHelper;
import androidx.work.InputMergerFactory$1;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.measurement.internal.zzew;

/* JADX INFO: loaded from: classes.dex */
public final class BillingFlowParams {
    public boolean zza;
    public Object zzd;
    public Object zze;
    public Object zzf;

    public BillingFlowParams(zzew zzewVar, String str) {
        this.zzf = zzewVar;
        zzah.checkNotEmpty(str);
        this.zzd = str;
    }

    public RoomOpenHelper build() {
        Intent intent = (Intent) this.zzd;
        if (!intent.hasExtra("android.support.customtabs.extra.SESSION")) {
            Bundle bundle = new Bundle();
            bundle.putBinder("android.support.customtabs.extra.SESSION", null);
            intent.putExtras(bundle);
        }
        intent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.zza);
        ((InputMergerFactory$1) this.zze).getClass();
        intent.putExtras(new Bundle());
        intent.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", 0);
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            String defaultLocale = CustomTabsIntent$Api24Impl.getDefaultLocale();
            if (!TextUtils.isEmpty(defaultLocale)) {
                Bundle bundleExtra = intent.hasExtra("com.android.browser.headers") ? intent.getBundleExtra("com.android.browser.headers") : new Bundle();
                if (!bundleExtra.containsKey("Accept-Language")) {
                    bundleExtra.putString("Accept-Language", defaultLocale);
                    intent.putExtra("com.android.browser.headers", bundleExtra);
                }
            }
        }
        if (i >= 34) {
            if (((ActivityOptions) this.zzf) == null) {
                this.zzf = CustomTabsIntent$Api23Impl.makeBasicActivityOptions();
            }
            CustomTabsIntent$Api34Impl.setShareIdentityEnabled((ActivityOptions) this.zzf, false);
        }
        ActivityOptions activityOptions = (ActivityOptions) this.zzf;
        return new RoomOpenHelper(intent, activityOptions != null ? activityOptions.toBundle() : null, 2, false);
    }

    public String zza() {
        if (!this.zza) {
            this.zza = true;
            this.zze = ((zzew) this.zzf).zza().getString((String) this.zzd, null);
        }
        return (String) this.zze;
    }

    public void zzb(String str) {
        SharedPreferences.Editor editorEdit = ((zzew) this.zzf).zza().edit();
        editorEdit.putString((String) this.zzd, str);
        editorEdit.apply();
        this.zze = str;
    }

    public BillingFlowParams(Context context, String str, RoomOpenHelper roomOpenHelper, boolean z) {
        this.zzd = context;
        this.zze = str;
        this.zzf = roomOpenHelper;
        this.zza = z;
    }

    public BillingFlowParams() {
        this.zzd = new Intent("android.intent.action.VIEW");
        this.zze = new InputMergerFactory$1(4);
        this.zza = true;
    }

    public BillingFlowParams(CustomTabsSession customTabsSession) {
        Intent intent = new Intent("android.intent.action.VIEW");
        this.zzd = intent;
        this.zze = new InputMergerFactory$1(4);
        this.zza = true;
        if (customTabsSession != null) {
            intent.setPackage(customTabsSession.mComponentName.getPackageName());
            CustomTabsClient.AnonymousClass2 anonymousClass2 = customTabsSession.mCallback;
            Bundle bundle = new Bundle();
            bundle.putBinder("android.support.customtabs.extra.SESSION", anonymousClass2);
            intent.putExtras(bundle);
        }
    }
}
