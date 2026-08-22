package com.facebook.internal;

import android.R;
import androidx.loader.app.gv.DYYbQc;
import com.facebook.FacebookSdk;
import com.google.android.gms.ads.rewarded.zQ.yzwzcWHcnH;
import com.google.protobuf.DescriptorProtos;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class FeatureManager {
    public static final FeatureManager INSTANCE = new FeatureManager();
    public static final HashMap featureMapping = new HashMap();

    public interface Callback {
        void onCompleted(boolean z);
    }

    /* JADX INFO: renamed from: com.facebook.internal.FeatureManager$checkFeature$1 */
    public final class AnonymousClass1 {
        public final /* synthetic */ Callback $callback;
        public final /* synthetic */ Feature $feature;

        public AnonymousClass1(Callback callback, Feature feature) {
            this.$callback = callback;
            this.$feature = feature;
        }
    }

    public static final void checkFeature(Callback callback, Feature feature) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        FetchedAppGateKeepersManager.loadAppGateKeepersAsync(new AnonymousClass1(callback, feature));
    }

    public static final boolean isEnabled(Feature feature) {
        Feature featureFromInt;
        boolean z;
        Intrinsics.checkNotNullParameter(feature, "feature");
        boolean z2 = false;
        if (Feature.Unknown == feature) {
            return false;
        }
        if (Feature.Core == feature) {
            return true;
        }
        String string = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.FEATURE_MANAGER", 0).getString(Intrinsics.stringPlus(feature, "FBSDKFeature"), null);
        if (string != null && string.equals("16.0.0")) {
            return false;
        }
        int i = feature.code;
        if ((i & 255) > 0) {
            featureFromInt = Validate.fromInt(i & (-256));
        } else if ((65280 & i) > 0) {
            featureFromInt = Validate.fromInt(i & (-65536));
        } else {
            featureFromInt = (16711680 & i) > 0 ? Validate.fromInt(i & (-16777216)) : Validate.fromInt(0);
        }
        if (featureFromInt == feature) {
            switch (feature.ordinal()) {
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 24:
                case 25:
                case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                case 28:
                case 29:
                    break;
                case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                case 26:
                default:
                    z2 = true;
                    break;
            }
            AtomicBoolean atomicBoolean = FetchedAppGateKeepersManager.isLoading;
            return FetchedAppGateKeepersManager.getGateKeeperForKey(Intrinsics.stringPlus(feature, "FBSDKFeature"), FacebookSdk.getApplicationId(), z2);
        }
        if (!isEnabled(featureFromInt)) {
            return false;
        }
        switch (feature.ordinal()) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 24:
            case 25:
            case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
            case 28:
            case 29:
                z = false;
                break;
            case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
            case 26:
            default:
                z = true;
                break;
        }
        AtomicBoolean atomicBoolean2 = FetchedAppGateKeepersManager.isLoading;
        return FetchedAppGateKeepersManager.getGateKeeperForKey(Intrinsics.stringPlus(feature, "FBSDKFeature"), FacebookSdk.getApplicationId(), z);
    }

    /* JADX INFO: loaded from: classes2.dex */
    public enum Feature {
        Unknown(-1),
        Core(0),
        AppEvents(65536),
        CodelessEvents(65792),
        CloudBridge(67584),
        RestrictiveDataFiltering(66048),
        AAM(66304),
        PrivacyProtection(66560),
        SuggestedEvents(66561),
        IntelligentIntegrity(66562),
        ModelRequest(66563),
        EventDeactivation(66816),
        OnDeviceEventProcessing(67072),
        OnDevicePostInstallEventProcessing(67073),
        IapLogging(67328),
        IapLoggingLib2(67329),
        Instrument(131072),
        CrashReport(131328),
        CrashShield(131329),
        ThreadCheck(131330),
        ErrorReport(131584),
        AnrReport(131840),
        Monitoring(196608),
        ServiceUpdateCompliance(196864),
        /* JADX INFO: Fake field, exist only in values array */
        Login(262144),
        /* JADX INFO: Fake field, exist only in values array */
        Elora(327680),
        /* JADX INFO: Fake field, exist only in values array */
        Login(16777216),
        ChromeCustomTabsPrefetching(R.attr.theme),
        IgnoreAppSwitchToLoggedOut(R.id.background),
        BypassAppSwitch(R.style.Animation),
        /* JADX INFO: Fake field, exist only in values array */
        Share(33554432);

        public final int code;

        /* JADX INFO: renamed from: EF4 */
        Feature Login;

        /* JADX INFO: renamed from: EF2 */
        Feature Elora;

        /* JADX INFO: renamed from: EF4 */
        Feature Login;

        /* JADX INFO: renamed from: EF438 */
        Feature Share;

        Feature(int i) {
            this.code = i;
        }

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static Feature[] valuesCustom() {
            return (Feature[]) Arrays.copyOf(values(), 31);
        }

        @Override // java.lang.Enum
        public final String toString() {
            switch (ordinal()) {
                case 1:
                    return DYYbQc.vnxxe;
                case 2:
                    return "AppEvents";
                case 3:
                    return "CodelessEvents";
                case 4:
                    return "AppEventsCloudbridge";
                case 5:
                    return "RestrictiveDataFiltering";
                case 6:
                    return "AAM";
                case 7:
                    return "PrivacyProtection";
                case 8:
                    return "SuggestedEvents";
                case 9:
                    return "IntelligentIntegrity";
                case 10:
                    return "ModelRequest";
                case 11:
                    return "EventDeactivation";
                case 12:
                    return "OnDeviceEventProcessing";
                case 13:
                    return "OnDevicePostInstallEventProcessing";
                case 14:
                    return "IAPLogging";
                case 15:
                    return "IAPLoggingLib2";
                case 16:
                    return "Instrument";
                case 17:
                    return "CrashReport";
                case 18:
                    return "CrashShield";
                case 19:
                    return "ThreadCheck";
                case 20:
                    return "ErrorReport";
                case 21:
                    return "AnrReport";
                case 22:
                    return "Monitoring";
                case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                    return "ServiceUpdateCompliance";
                case 24:
                    return "Megatron";
                case 25:
                    return "Elora";
                case 26:
                    return "LoginKit";
                case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                    return "ChromeCustomTabsPrefetching";
                case 28:
                    return yzwzcWHcnH.QjxyemsxvCYf;
                case 29:
                    return "BypassAppSwitch";
                case 30:
                    return "ShareKit";
                default:
                    return "unknown";
            }
        }
    }
}
