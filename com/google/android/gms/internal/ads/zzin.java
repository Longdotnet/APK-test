package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzin extends zzba {
    public final int zzc;
    public final String zzd;
    public final int zze;
    public final zzz zzf;
    public final int zzg;
    public final zzvh zzh;
    final boolean zzi;

    private zzin(int i, Throwable th, int i2) {
        this(i, th, null, i2, null, -1, null, 4, null, false);
    }

    public static zzin zzb(Throwable th, String str, int i, zzz zzzVar, int i2, zzvh zzvhVar, boolean z, int i3) {
        return new zzin(1, th, null, i3, str, i, zzzVar, zzzVar == null ? 4 : i2, zzvhVar, z);
    }

    public static zzin zzc(IOException iOException, int i) {
        return new zzin(0, iOException, i);
    }

    public static zzin zzd(RuntimeException runtimeException, int i) {
        return new zzin(2, runtimeException, i);
    }

    public final zzin zza(zzvh zzvhVar) {
        String message = getMessage();
        String str = zzex.zza;
        return new zzin(message, getCause(), this.zza, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, zzvhVar, this.zzb, this.zzi);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private zzin(int i, Throwable th, String str, int i2, String str2, int i3, zzz zzzVar, int i4, zzvh zzvhVar, boolean z) {
        String strM;
        String str3;
        if (i == 0) {
            strM = "Source error";
        } else if (i != 1) {
            strM = "Unexpected runtime error";
        } else {
            String strValueOf = String.valueOf(zzzVar);
            String str4 = zzex.zza;
            if (i4 == 0) {
                str3 = "NO";
            } else if (i4 == 1) {
                str3 = "NO_UNSUPPORTED_TYPE";
            } else if (i4 == 2) {
                str3 = "NO_UNSUPPORTED_DRM";
            } else if (i4 == 3) {
                str3 = "NO_EXCEEDS_CAPABILITIES";
            } else {
                if (i4 != 4) {
                    throw new IllegalStateException();
                }
                str3 = "YES";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(" error, index=");
            sb.append(i3);
            sb.append(", format=");
            sb.append(strValueOf);
            strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(sb, ", format_supported=", str3);
        }
        this(TextUtils.isEmpty(null) ? strM : strM.concat(": null"), th, i2, i, str2, i3, zzzVar, i4, zzvhVar, SystemClock.elapsedRealtime(), z);
    }

    private zzin(String str, Throwable th, int i, int i2, String str2, int i3, zzz zzzVar, int i4, zzvh zzvhVar, long j, boolean z) {
        int i5;
        boolean z2;
        super(str, th, i, Bundle.EMPTY, j);
        if (z) {
            i5 = i2;
            if (i5 == 1) {
                i5 = 1;
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            i5 = i2;
            z2 = true;
        }
        zzdd.zzd(z2);
        zzdd.zzd(th != null);
        this.zzc = i5;
        this.zzd = str2;
        this.zze = i3;
        this.zzf = zzzVar;
        this.zzg = i4;
        this.zzh = zzvhVar;
        this.zzi = z;
    }
}
