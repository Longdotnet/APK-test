package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzde {
    private static Executor zza;

    public static synchronized Executor zza() {
        try {
            if (zza == null) {
                zza = zzex.zzF("ExoPlayer:BackgroundExecutor");
            }
        } catch (Throwable th) {
            throw th;
        }
        return zza;
    }
}
