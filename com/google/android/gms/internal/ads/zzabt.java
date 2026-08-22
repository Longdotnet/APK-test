package com.google.android.gms.internal.ads;

import android.view.Surface;
import androidx.work.impl.constraints.controllers.pST.ehgOP;

/* JADX INFO: loaded from: classes2.dex */
final class zzabt {
    public static void zza(Surface surface, float f) {
        try {
            surface.setFrameRate(f, f == 0.0f ? 0 : 1);
        } catch (IllegalStateException e) {
            zzea.zzd(ehgOP.hiXVfqAwQQsUfM, "Failed to call Surface.setFrameRate", e);
        }
    }
}
