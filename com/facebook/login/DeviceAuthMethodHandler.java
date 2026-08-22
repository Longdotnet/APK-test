package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentState;
import com.facebook.GraphRequest;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class DeviceAuthMethodHandler extends LoginMethodHandler {
    public static ScheduledThreadPoolExecutor backgroundExecutor;
    public final String nameForLogging;
    public static final GraphRequest.Companion Companion = new GraphRequest.Companion(14);
    public static final Parcelable.Creator<DeviceAuthMethodHandler> CREATOR = new FragmentState.AnonymousClass1(29);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceAuthMethodHandler(Parcel parcel) {
        super(parcel);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.nameForLogging = "device_auth";
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public final String getNameForLogging() {
        return this.nameForLogging;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public final int tryAuthorize(LoginClient.Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        FragmentActivity activity = getLoginClient().getActivity();
        if (activity == null || activity.isFinishing()) {
            return 1;
        }
        DeviceAuthDialog deviceAuthDialog = new DeviceAuthDialog();
        deviceAuthDialog.show(activity.getSupportFragmentManager(), "login_with_facebook");
        deviceAuthDialog.startLogin(request);
        return 1;
    }

    public DeviceAuthMethodHandler(LoginClient loginClient) {
        this.loginClient = loginClient;
        this.nameForLogging = "device_auth";
    }
}
