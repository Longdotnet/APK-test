package androidx.privacysandbox.ads.adservices.internal;

import android.os.ext.SdkExtensions;

/* JADX INFO: loaded from: classes.dex */
public final class AdServicesInfo$Extensions30Impl {
    public static final AdServicesInfo$Extensions30Impl INSTANCE = new AdServicesInfo$Extensions30Impl();

    public final int getAdServicesVersion() {
        return SdkExtensions.getExtensionVersion(1000000);
    }
}
