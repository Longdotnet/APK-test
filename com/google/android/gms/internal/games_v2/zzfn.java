package com.google.android.gms.internal.games_v2;

import android.util.Log;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.common.internal.GmsLogger;

/* JADX INFO: loaded from: classes.dex */
public final class zzfn {
    private static final GmsLogger zza = new GmsLogger("Games", null);

    public static void zza(String str, String str2) {
        GmsLogger gmsLogger = zza;
        String strZzi = zzi(str);
        if (Log.isLoggable(gmsLogger.zza, 3)) {
            Log.d(strZzi, gmsLogger.zza(str2));
        }
    }

    public static void zzb(String str, String str2, Throwable th) {
        GmsLogger gmsLogger = zza;
        String strZzi = zzi("GamesApiManager");
        if (Log.isLoggable(gmsLogger.zza, 3)) {
            Log.d(strZzi, gmsLogger.zza("Authentication task failed"), th);
        }
    }

    public static void zzc(String str, String str2) {
        GmsLogger gmsLogger = zza;
        String strZzi = zzi(str);
        if (Log.isLoggable(gmsLogger.zza, 2)) {
            Log.v(strZzi, gmsLogger.zza(str2));
        }
    }

    public static void zzd(String str, String str2, Throwable th) {
        GmsLogger gmsLogger = zza;
        String strZzi = zzi("SnapshotContentsEntity");
        if (Log.isLoggable(gmsLogger.zza, 4)) {
            Log.i(strZzi, gmsLogger.zza("Failed to write snapshot data"), th);
        }
    }

    public static void zze(String str, String str2) {
        GmsLogger gmsLogger = zza;
        String strZzi = zzi(str);
        if (Log.isLoggable(gmsLogger.zza, 5)) {
            Log.w(strZzi, gmsLogger.zza(str2));
        }
    }

    public static void zzf(String str, String str2, Throwable th) {
        GmsLogger gmsLogger = zza;
        String strZzi = zzi(str);
        if (Log.isLoggable(gmsLogger.zza, 5)) {
            Log.w(strZzi, gmsLogger.zza(str2), th);
        }
    }

    public static void zzg(String str, String str2) {
        GmsLogger gmsLogger = zza;
        String strZzi = zzi(str);
        if (Log.isLoggable(gmsLogger.zza, 6)) {
            Log.e(strZzi, gmsLogger.zza(str2));
        }
    }

    public static void zzh(String str, String str2, Throwable th) {
        GmsLogger gmsLogger = zza;
        String strZzi = zzi(str);
        if (Log.isLoggable(gmsLogger.zza, 6)) {
            Log.e(strZzi, gmsLogger.zza(str2), th);
        }
    }

    private static String zzi(String str) {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("PlayGamesServices[", str, "]");
    }
}
