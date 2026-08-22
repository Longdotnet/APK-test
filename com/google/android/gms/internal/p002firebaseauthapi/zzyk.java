package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.util.Hex;

/* JADX INFO: loaded from: classes.dex */
public final class zzyk {
    private final String zza;
    private final String zzb;

    public zzyk(Context context, String str) {
        zzah.checkNotNull(context);
        zzah.checkNotEmpty(str);
        this.zza = str;
        try {
            byte[] packageCertificateHashBytes = Hex.getPackageCertificateHashBytes(context, str);
            if (packageCertificateHashBytes != null) {
                this.zzb = Hex.bytesToStringUppercase(packageCertificateHashBytes);
            } else {
                Log.e("FBA-PackageInfo", "single cert required: ".concat(String.valueOf(str)));
                this.zzb = null;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e("FBA-PackageInfo", "no pkg: ".concat(String.valueOf(str)));
            this.zzb = null;
        }
    }

    public final String zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }
}
