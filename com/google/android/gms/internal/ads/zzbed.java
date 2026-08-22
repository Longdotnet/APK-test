package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsService;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import com.google.android.gms.games.snapshot.Xa.JrbhsraGtto;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbed extends CustomTabsServiceConnection {
    public static final /* synthetic */ int zza = 0;
    private final AtomicBoolean zzb = new AtomicBoolean(false);
    private Context zzc;
    private zzdsj zzd;
    private CustomTabsSession zze;
    private CustomTabsClient zzf;

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzf(Context context) {
        String packageName;
        if (this.zzf != null || context == null || (packageName = CustomTabsClient.getPackageName(context)) == null || packageName.equals(context.getPackageName())) {
            return;
        }
        setApplicationContext(context.getApplicationContext());
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        if (!TextUtils.isEmpty(packageName)) {
            intent.setPackage(packageName);
        }
        context.bindService(intent, this, 33);
    }

    @Override // androidx.browser.customtabs.CustomTabsServiceConnection
    public final void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        this.zzf = customTabsClient;
        customTabsClient.getClass();
        try {
            ((ICustomTabsService.Stub.Proxy) customTabsClient.mService).warmup();
        } catch (RemoteException unused) {
        }
        this.zze = customTabsClient.newSession(new zzbec(this));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.zzf = null;
        this.zze = null;
    }

    public final CustomTabsSession zza() {
        if (this.zze == null) {
            zzcaf.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbeb
                @Override // java.lang.Runnable
                public final void run() {
                    zzbed zzbedVar = this.zza;
                    zzbedVar.zzf(zzbedVar.zzc);
                }
            });
        }
        return this.zze;
    }

    public final void zzd(Context context, zzdsj zzdsjVar) {
        if (this.zzb.getAndSet(true)) {
            return;
        }
        this.zzc = context;
        this.zzd = zzdsjVar;
        zzf(context);
    }

    public final void zze(final int i) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzeS)).booleanValue() || this.zzd == null) {
            return;
        }
        zzcaf.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbea
            @Override // java.lang.Runnable
            public final void run() {
                zzbed.zzb(this.zza, i);
            }
        });
    }

    public static /* synthetic */ void zzb(zzbed zzbedVar, int i) {
        zzdsj zzdsjVar = zzbedVar.zzd;
        if (zzdsjVar != null) {
            zzdsi zzdsiVarZza = zzdsjVar.zza();
            zzdsiVarZza.zzb(JrbhsraGtto.pVPOxVkTBQXOT, "cct_nav");
            zzdsiVarZza.zzb("cct_navs", String.valueOf(i));
            zzdsiVarZza.zzj();
        }
    }
}
