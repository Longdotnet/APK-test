package com.google.android.gms.internal.auth;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import kotlin.coroutines.jvm.internal.DEXi.JuorMn;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcp {
    static volatile zzde<Boolean> zza = zzde.zzc();
    private static final Object zzb = new Object();

    public static boolean zza(Context context, Uri uri) {
        int i;
        String authority = uri.getAuthority();
        boolean z = false;
        if (!"com.google.android.gms.phenotype".equals(authority)) {
            StringBuilder sb = new StringBuilder(String.valueOf(authority).length() + 91);
            sb.append(authority);
            sb.append(" is an unsupported authority. Only com.google.android.gms.phenotype authority is supported.");
            Log.e("PhenotypeClientHelper", sb.toString());
            return false;
        }
        if (zza.zzb()) {
            return zza.zza().booleanValue();
        }
        synchronized (zzb) {
            try {
                if (zza.zzb()) {
                    return zza.zza().booleanValue();
                }
                try {
                    if (!"com.google.android.gms".equals(context.getPackageName())) {
                        PackageManager packageManager = context.getPackageManager();
                        if (Build.VERSION.SDK_INT < 29) {
                            i = 0;
                        } else {
                            i = 268435456;
                        }
                        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider("com.google.android.gms.phenotype", i);
                        if (providerInfoResolveContentProvider != null && "com.google.android.gms".equals(providerInfoResolveContentProvider.packageName)) {
                        }
                        zza = zzde.zzd(Boolean.valueOf(z));
                        return zza.zza().booleanValue();
                    }
                    if ((context.getPackageManager().getApplicationInfo(JuorMn.jnbSr, 0).flags & 129) != 0) {
                        z = true;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
                zza = zzde.zzd(Boolean.valueOf(z));
                return zza.zza().booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
