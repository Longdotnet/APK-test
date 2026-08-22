package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.graphics.Rect;
import android.media.AudioManager;
import android.text.TextUtils;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbzs;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class zzx extends zzv {
    @Override // com.google.android.gms.ads.internal.util.zzaa
    public final int zzj(AudioManager audioManager) {
        return audioManager.getStreamMinVolume(3);
    }

    @Override // com.google.android.gms.ads.internal.util.zzaa
    public final void zzl(final Activity activity) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzbs)).booleanValue() && ((zzj) com.google.android.gms.ads.internal.zzv.zza.zzi.zzi()).zzj() == null && !activity.isInMultiWindowMode()) {
            Window window = activity.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (1 != attributes.layoutInDisplayCutoutMode) {
                attributes.layoutInDisplayCutoutMode = 1;
                window.setAttributes(attributes);
            }
            activity.getWindow().getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener(this) { // from class: com.google.android.gms.ads.internal.util.zzw
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
                    if (((zzj) zzvVar.zzi.zzi()).zzj() == null) {
                        DisplayCutout displayCutout = windowInsets.getDisplayCutout();
                        zzbzs zzbzsVar = zzvVar.zzi;
                        String strConcat = "";
                        if (displayCutout != null) {
                            zzg zzgVarZzi = zzbzsVar.zzi();
                            for (Rect rect : displayCutout.getBoundingRects()) {
                                Locale locale = Locale.US;
                                String str = rect.left + "," + rect.top + "," + rect.right + "," + rect.bottom;
                                if (!TextUtils.isEmpty(strConcat)) {
                                    strConcat = strConcat.concat("|");
                                }
                                strConcat = strConcat.concat(str);
                            }
                            ((zzj) zzgVarZzi).zzy(strConcat);
                        } else {
                            ((zzj) zzbzsVar.zzi()).zzy("");
                        }
                    }
                    Window window2 = activity.getWindow();
                    WindowManager.LayoutParams attributes2 = window2.getAttributes();
                    if (2 != attributes2.layoutInDisplayCutoutMode) {
                        attributes2.layoutInDisplayCutoutMode = 2;
                        window2.setAttributes(attributes2);
                    }
                    return view.onApplyWindowInsets(windowInsets);
                }
            });
        }
    }
}
