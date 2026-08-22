package com.facebook;

import androidx.core.view.inputmethod.InputConnectionCompat$$ExternalSyntheticLambda0;
import com.facebook.internal.FeatureManager;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class FacebookException extends RuntimeException {
    public static final long serialVersionUID = 1;

    public FacebookException(String str) {
        super(str);
        Random random = new Random();
        if (str == null || !FacebookSdk.sdkInitialized.get() || random.nextInt(100) <= 50) {
            return;
        }
        FeatureManager featureManager = FeatureManager.INSTANCE;
        FeatureManager.checkFeature(new InputConnectionCompat$$ExternalSyntheticLambda0(str, 3), FeatureManager.Feature.ErrorReport);
    }

    @Override // java.lang.Throwable
    public String toString() {
        String message = getMessage();
        return message == null ? "" : message;
    }
}
