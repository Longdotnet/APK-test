package com.facebook.appevents.integrity;

import com.facebook.appevents.ml.ModelManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;

/* JADX INFO: loaded from: classes2.dex */
public final class IntegrityManager {
    public static final IntegrityManager INSTANCE = new IntegrityManager();
    public static boolean enabled;
    public static boolean isSampleEnabled;

    public final boolean shouldFilter(String str) {
        String str2;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            boolean zIsObjectCrashing = CrashShieldHandler.isObjectCrashing(this);
            String str3 = eoBKjVuj.SiIKgFsAcSul;
            String str4 = null;
            if (!zIsObjectCrashing) {
                try {
                    float[] fArr = new float[30];
                    for (int i = 0; i < 30; i++) {
                        fArr[i] = 0.0f;
                    }
                    ModelManager modelManager = ModelManager.INSTANCE;
                    String[] strArrPredict = ModelManager.predict(ModelManager.Task.MTML_INTEGRITY_DETECT, new float[][]{fArr}, new String[]{str});
                    str4 = (strArrPredict == null || (str2 = strArrPredict[0]) == null) ? str3 : str2;
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(this, th);
                }
            }
            return !str3.equals(str4);
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(this, th2);
            return false;
        }
    }
}
