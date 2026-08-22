package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzo {
    public static final Uri zza = new Uri.Builder().scheme(FirebaseAnalytics.Param.CONTENT).authority("com.google.android.gms.chimera").build();
    public final String zzb;
    public final String zzc;
    public final boolean zzf;

    public zzo(String str, String str2, boolean z) {
        zzah.checkNotEmpty(str);
        this.zzb = str;
        zzah.checkNotEmpty(str2);
        this.zzc = str2;
        this.zzf = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzo)) {
            return false;
        }
        zzo zzoVar = (zzo) obj;
        return zzah.equal(this.zzb, zzoVar.zzb) && zzah.equal(this.zzc, zzoVar.zzc) && zzah.equal(null, null) && this.zzf == zzoVar.zzf;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzb, this.zzc, null, 4225, Boolean.valueOf(this.zzf)});
    }

    public final String toString() {
        String str = this.zzb;
        if (str != null) {
            return str;
        }
        zzah.checkNotNull(null);
        throw null;
    }

    public final Intent zzb(Context context) {
        Bundle bundleCall;
        Intent intent = null;
        String str = this.zzb;
        if (str == null) {
            return new Intent().setComponent(null);
        }
        if (this.zzf) {
            Bundle bundle = new Bundle();
            bundle.putString("serviceActionBundleKey", str);
            try {
                bundleCall = context.getContentResolver().call(zza, "serviceIntentCall", (String) null, bundle);
            } catch (IllegalArgumentException e) {
                Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e.toString()));
                bundleCall = null;
            }
            intent = bundleCall != null ? (Intent) bundleCall.getParcelable("serviceResponseIntentKey") : null;
            if (intent == null) {
                Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action: ".concat(String.valueOf(str)));
            }
        }
        return intent == null ? new Intent(str).setPackage(this.zzc) : intent;
    }
}
