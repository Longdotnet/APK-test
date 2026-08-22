package com.facebook.appevents.internal;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.internal.Jbo.ygoi;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AppEventUtility {
    public static final String bytesToHex(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (i < length) {
            byte b = bArr[i];
            i++;
            stringBuffer.append(String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1)));
        }
        String string = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    public static final View getRootView(Activity activity) {
        if (CrashShieldHandler.isObjectCrashing(AppEventUtility.class) || activity == null) {
            return null;
        }
        try {
            Window window = activity.getWindow();
            if (window == null) {
                return null;
            }
            return window.getDecorView().getRootView();
        } catch (Exception unused) {
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(AppEventUtility.class, th);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0061  */
    /* JADX WARN: Code duplicated, block: B:22:? A[RETURN, SYNTHETIC] */
    public static final boolean isEmulator() {
        String str = Build.FINGERPRINT;
        Intrinsics.checkNotNullExpressionValue(str, ygoi.RBQEtAjoy);
        if (!StringsKt__StringsKt.startsWith(str, "generic", false) && !StringsKt__StringsKt.startsWith(str, "unknown", false)) {
            String MODEL = Build.MODEL;
            Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
            if (!StringsKt__StringsKt.contains$default(MODEL, "google_sdk") && !StringsKt__StringsKt.contains$default(MODEL, "Emulator") && !StringsKt__StringsKt.contains$default(MODEL, "Android SDK built for x86")) {
                String MANUFACTURER = Build.MANUFACTURER;
                Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                if (!StringsKt__StringsKt.contains$default(MANUFACTURER, "Genymotion")) {
                    String BRAND = Build.BRAND;
                    Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
                    if (StringsKt__StringsKt.startsWith(BRAND, "generic", false)) {
                        String DEVICE = Build.DEVICE;
                        Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
                        if (!StringsKt__StringsKt.startsWith(DEVICE, "generic", false)) {
                            if ("google_sdk".equals(Build.PRODUCT)) {
                                return false;
                            }
                        }
                    } else if ("google_sdk".equals(Build.PRODUCT)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
