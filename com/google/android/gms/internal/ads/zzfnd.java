package com.google.android.gms.internal.ads;

import android.app.UiModeManager;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzfnd {
    private static UiModeManager zza;

    public static zzflr zza() {
        UiModeManager uiModeManager = zza;
        if (uiModeManager == null) {
            return zzflr.OTHER;
        }
        int currentModeType = uiModeManager.getCurrentModeType();
        if (currentModeType != 1) {
            return currentModeType != 4 ? zzflr.OTHER : zzflr.CTV;
        }
        return zzflr.zzb;
    }

    public static void zzb(Context context) {
        if (context != null) {
            zza = (UiModeManager) context.getSystemService("uimode");
        }
    }
}
