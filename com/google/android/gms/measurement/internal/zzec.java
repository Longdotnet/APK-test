package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.facebook.AccessTokenCache;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzec {
    public static final AtomicReference zza = new AtomicReference();
    public static final AtomicReference zzb = new AtomicReference();
    public static final AtomicReference zzc = new AtomicReference();
    public final AccessTokenCache zzd;

    public zzec(AccessTokenCache accessTokenCache) {
        this.zzd = accessTokenCache;
    }

    public static final String zzg(String str, String[] strArr, String[] strArr2, AtomicReference atomicReference) {
        String str2;
        com.google.android.gms.common.internal.zzah.checkNotNull(atomicReference);
        com.google.android.gms.common.internal.zzah.checkArgument(strArr.length == strArr2.length);
        for (int i = 0; i < strArr.length; i++) {
            Object obj = strArr[i];
            if (str == obj || str.equals(obj)) {
                synchronized (atomicReference) {
                    try {
                        String[] strArr3 = (String[]) atomicReference.get();
                        if (strArr3 == null) {
                            strArr3 = new String[strArr2.length];
                            atomicReference.set(strArr3);
                        }
                        str2 = strArr3[i];
                        if (str2 == null) {
                            str2 = strArr2[i] + "(" + strArr[i] + ")";
                            strArr3[i] = str2;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str2;
            }
        }
        return str;
    }

    public final String zza(Object[] objArr) {
        if (objArr == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Object obj : objArr) {
            String strZzb = obj instanceof Bundle ? zzb((Bundle) obj) : String.valueOf(obj);
            if (strZzb != null) {
                if (sb.length() != 1) {
                    sb.append(", ");
                }
                sb.append(strZzb);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public final String zzb(Bundle bundle) {
        String strZza;
        if (bundle == null) {
            return null;
        }
        if (!this.zzd.m63zza()) {
            return bundle.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Bundle[{");
        for (String str : bundle.keySet()) {
            if (sb.length() != 8) {
                sb.append(", ");
            }
            sb.append(zze(str));
            sb.append("=");
            Object obj = bundle.get(str);
            if (obj instanceof Bundle) {
                strZza = zza(new Object[]{obj});
            } else if (obj instanceof Object[]) {
                strZza = zza((Object[]) obj);
            } else {
                strZza = obj instanceof ArrayList ? zza(((ArrayList) obj).toArray()) : String.valueOf(obj);
            }
            sb.append(strZza);
        }
        sb.append("}]");
        return sb.toString();
    }

    public final String zzc(zzaw zzawVar) {
        String string;
        AccessTokenCache accessTokenCache = this.zzd;
        if (!accessTokenCache.m63zza()) {
            return zzawVar.toString();
        }
        StringBuilder sb = new StringBuilder("origin=");
        sb.append(zzawVar.zzc);
        sb.append(",name=");
        sb.append(zzd(zzawVar.zza));
        sb.append(",params=");
        zzau zzauVar = zzawVar.zzb;
        if (zzauVar == null) {
            string = null;
        } else {
            string = !accessTokenCache.m63zza() ? zzauVar.zza.toString() : zzb(zzauVar.zzc());
        }
        sb.append(string);
        return sb.toString();
    }

    public final String zzd(String str) {
        if (str == null) {
            return null;
        }
        return !this.zzd.m63zza() ? str : zzg(str, zzg.zzc, zzg.f3zza, zza);
    }

    public final String zze(String str) {
        if (str == null) {
            return null;
        }
        return !this.zzd.m63zza() ? str : zzg(str, zzg.zzb$1, zzg.zza$1, zzb);
    }

    public final String zzf(String str) {
        if (str == null) {
            return null;
        }
        if (this.zzd.m63zza()) {
            return str.startsWith("_exp_") ? CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("experiment_id(", str, ")") : zzg(str, zzg.zzb$2, zzg.zza$2, zzc);
        }
        return str;
    }
}
