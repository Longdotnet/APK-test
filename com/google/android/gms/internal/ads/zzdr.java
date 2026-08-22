package com.google.android.gms.internal.ads;

import android.content.Context;
import android.opengl.EGL14;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class zzdr {
    public static void zza(boolean z, String str) throws zzdq {
        if (!z) {
            throw new zzdq(str);
        }
    }

    public static boolean zzb() {
        return Build.VERSION.SDK_INT >= 33 && zzf("EGL_EXT_gl_colorspace_bt2020_pq");
    }

    public static boolean zzc(int i) {
        if (i == 6) {
            return zzb();
        }
        if (i == 7) {
            return zzf("EGL_EXT_gl_colorspace_bt2020_hlg");
        }
        return true;
    }

    public static boolean zzd(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i < 24) {
            return false;
        }
        if (i < 26 && ("samsung".equals(Build.MANUFACTURER) || "XT1650".equals(Build.MODEL))) {
            return false;
        }
        if (i >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) {
            return zzf("EGL_EXT_protected_content");
        }
        return false;
    }

    public static boolean zze() {
        return zzf("EGL_KHR_surfaceless_context");
    }

    private static boolean zzf(String str) {
        String strEglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
        return strEglQueryString != null && strEglQueryString.contains(str);
    }
}
