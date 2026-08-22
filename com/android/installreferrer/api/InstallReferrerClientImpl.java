package com.android.installreferrer.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.RemoteException;
import com.android.billingclient.api.zzbc;
import com.facebook.AccessTokenCache;
import com.google.android.finsky.externalreferrer.IGetInstallReferrerService;
import java.util.List;
import okio.Okio;

/* JADX INFO: loaded from: classes.dex */
public final class InstallReferrerClientImpl extends InstallReferrerClient {
    public final Context mApplicationContext;
    public int mClientState = 0;
    public IGetInstallReferrerService mService;
    public zzbc mServiceConnection;

    public InstallReferrerClientImpl(Context context) {
        this.mApplicationContext = context.getApplicationContext();
    }

    public final ReferrerDetails getInstallReferrer() throws RemoteException {
        if (this.mClientState != 2 || this.mService == null || this.mServiceConnection == null) {
            throw new IllegalStateException("Service not connected. Please start a connection before using the service.");
        }
        Bundle bundle = new Bundle();
        bundle.putString("package_name", this.mApplicationContext.getPackageName());
        try {
            return new ReferrerDetails(((IGetInstallReferrerService.Stub.Proxy) this.mService).getInstallReferrer(bundle));
        } catch (RemoteException e) {
            Okio.logWarn("RemoteException getting install referrer information");
            this.mClientState = 0;
            throw e;
        }
    }

    public final void startConnection(AccessTokenCache accessTokenCache) {
        ServiceInfo serviceInfo;
        int i = this.mClientState;
        if ((i != 2 || this.mService == null || this.mServiceConnection == null) ? false : true) {
            Okio.logVerbose("Service connection is valid. No need to re-initialize.");
            accessTokenCache.onInstallReferrerSetupFinished(0);
            return;
        }
        if (i == 1) {
            Okio.logWarn("Client is already in the process of connecting to the service.");
            accessTokenCache.onInstallReferrerSetupFinished(3);
            return;
        }
        if (i == 3) {
            Okio.logWarn("Client was already closed and can't be reused. Please create another instance.");
            accessTokenCache.onInstallReferrerSetupFinished(3);
            return;
        }
        Okio.logVerbose("Starting install referrer service setup.");
        this.mServiceConnection = new zzbc(this, accessTokenCache, 1);
        Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
        intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
        Context context = this.mApplicationContext;
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty() || (serviceInfo = listQueryIntentServices.get(0).serviceInfo) == null) {
            this.mClientState = 0;
            Okio.logVerbose("Install Referrer service unavailable on device.");
            accessTokenCache.onInstallReferrerSetupFinished(2);
            return;
        }
        String str = serviceInfo.packageName;
        String str2 = serviceInfo.name;
        if ("com.android.vending".equals(str) && str2 != null) {
            try {
                if (context.getPackageManager().getPackageInfo("com.android.vending", 128).versionCode >= 80837300) {
                    if (context.bindService(new Intent(intent), this.mServiceConnection, 1)) {
                        Okio.logVerbose("Service was bonded successfully.");
                        return;
                    }
                    Okio.logWarn("Connection to service is blocked.");
                    this.mClientState = 0;
                    accessTokenCache.onInstallReferrerSetupFinished(1);
                    return;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        Okio.logWarn("Play Store missing or incompatible. Version 8.3.73 or later required.");
        this.mClientState = 0;
        accessTokenCache.onInstallReferrerSetupFinished(2);
    }
}
