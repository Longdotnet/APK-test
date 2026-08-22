package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsService;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbef {
    private CustomTabsSession zza;
    private CustomTabsClient zzb;
    private CustomTabsServiceConnection zzc;
    private zzbee zzd;

    public static boolean zzg(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
            ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intent, 0);
            List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            if (listQueryIntentActivities != null && resolveInfoResolveActivity != null) {
                for (int i = 0; i < listQueryIntentActivities.size(); i++) {
                    if (resolveInfoResolveActivity.activityInfo.name.equals(listQueryIntentActivities.get(i).activityInfo.name)) {
                        return resolveInfoResolveActivity.activityInfo.packageName.equals(zzhhh.zza(context));
                    }
                }
            }
        }
        return false;
    }

    public final CustomTabsSession zza() {
        CustomTabsClient customTabsClient = this.zzb;
        if (customTabsClient == null) {
            this.zza = null;
        } else if (this.zza == null) {
            this.zza = customTabsClient.newSession(null);
        }
        return this.zza;
    }

    public final void zzb(Activity activity) {
        String strZza;
        if (this.zzb == null && (strZza = zzhhh.zza(activity)) != null) {
            zzhhi zzhhiVar = new zzhhi(this);
            this.zzc = zzhhiVar;
            zzhhiVar.setApplicationContext(activity.getApplicationContext());
            Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
            if (!TextUtils.isEmpty(strZza)) {
                intent.setPackage(strZza);
            }
            activity.bindService(intent, zzhhiVar, 33);
        }
    }

    public final void zzc(CustomTabsClient customTabsClient) {
        this.zzb = customTabsClient;
        customTabsClient.getClass();
        try {
            ((ICustomTabsService.Stub.Proxy) customTabsClient.mService).warmup();
        } catch (RemoteException unused) {
        }
        zzbee zzbeeVar = this.zzd;
        if (zzbeeVar != null) {
            zzbeeVar.zza();
        }
    }

    public final void zzd() {
        this.zzb = null;
        this.zza = null;
    }

    public final void zze(zzbee zzbeeVar) {
        this.zzd = zzbeeVar;
    }

    public final void zzf(Activity activity) {
        CustomTabsServiceConnection customTabsServiceConnection = this.zzc;
        if (customTabsServiceConnection == null) {
            return;
        }
        activity.unbindService(customTabsServiceConnection);
        this.zzb = null;
        this.zza = null;
        this.zzc = null;
    }
}
