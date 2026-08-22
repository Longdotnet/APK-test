package com.google.android.gms.games;

import com.google.android.gms.tasks.Task;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface VideosClient {
    public static final int CAPTURE_OVERLAY_STATE_CAPTURE_STARTED = 2;
    public static final int CAPTURE_OVERLAY_STATE_CAPTURE_STOPPED = 3;
    public static final int CAPTURE_OVERLAY_STATE_DISMISSED = 4;
    public static final int CAPTURE_OVERLAY_STATE_SHOWN = 1;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CaptureOverlayState {
    }

    @Deprecated
    public interface OnCaptureOverlayStateListener {
        @Deprecated
        void onCaptureOverlayStateChanged(int i);
    }

    @Deprecated
    Task getCaptureCapabilities();

    @Deprecated
    Task getCaptureOverlayIntent();

    @Deprecated
    Task getCaptureState();

    @Deprecated
    Task isCaptureAvailable(int i);

    @Deprecated
    Task isCaptureSupported();

    @Deprecated
    Task registerOnCaptureOverlayStateChangedListener(OnCaptureOverlayStateListener onCaptureOverlayStateListener);

    @Deprecated
    Task unregisterOnCaptureOverlayStateChangedListener(OnCaptureOverlayStateListener onCaptureOverlayStateListener);
}
