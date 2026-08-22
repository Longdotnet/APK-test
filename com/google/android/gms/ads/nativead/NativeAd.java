package com.google.android.gms.ads.nativead;

import android.os.Bundle;
import com.google.android.gms.ads.ResponseInfo;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class NativeAd {

    public abstract class AdChoicesInfo {
    }

    public abstract class Image {
        protected Map zza;
    }

    public interface OnNativeAdLoadedListener {
        void onNativeAdLoaded(NativeAd nativeAd);
    }

    public interface UnconfirmedClickListener {
    }

    public abstract String getBody();

    public abstract String getHeadline();

    public abstract ResponseInfo getResponseInfo();

    public abstract void recordEvent(Bundle bundle);

    public abstract Object zza();
}
