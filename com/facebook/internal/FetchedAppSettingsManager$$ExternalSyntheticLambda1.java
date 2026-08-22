package com.facebook.internal;

import androidx.core.view.DifferentialMotionFlingController$$ExternalSyntheticLambda0;
import com.facebook.appevents.AppEventsManager$start$1;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FetchedAppSettingsManager$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ AppEventsManager$start$1 f$0;

    public /* synthetic */ FetchedAppSettingsManager$$ExternalSyntheticLambda1(AppEventsManager$start$1 appEventsManager$start$1) {
        this.f$0 = appEventsManager$start$1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AppEventsManager$start$1 appEventsManager$start$1 = this.f$0;
        switch (this.$r8$classId) {
            case 0:
                appEventsManager$start$1.getClass();
                break;
            default:
                appEventsManager$start$1.getClass();
                FeatureManager featureManager = FeatureManager.INSTANCE;
                FeatureManager.checkFeature(new DifferentialMotionFlingController$$ExternalSyntheticLambda0(9), FeatureManager.Feature.AAM);
                FeatureManager.checkFeature(new DifferentialMotionFlingController$$ExternalSyntheticLambda0(10), FeatureManager.Feature.RestrictiveDataFiltering);
                FeatureManager.checkFeature(new DifferentialMotionFlingController$$ExternalSyntheticLambda0(11), FeatureManager.Feature.PrivacyProtection);
                FeatureManager.checkFeature(new DifferentialMotionFlingController$$ExternalSyntheticLambda0(12), FeatureManager.Feature.EventDeactivation);
                FeatureManager.checkFeature(new DifferentialMotionFlingController$$ExternalSyntheticLambda0(13), FeatureManager.Feature.IapLogging);
                FeatureManager.checkFeature(new DifferentialMotionFlingController$$ExternalSyntheticLambda0(14), FeatureManager.Feature.CloudBridge);
                break;
        }
    }

    public /* synthetic */ FetchedAppSettingsManager$$ExternalSyntheticLambda1(AppEventsManager$start$1 appEventsManager$start$1, FetchedAppSettings fetchedAppSettings) {
        this.f$0 = appEventsManager$start$1;
    }
}
