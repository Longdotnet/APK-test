package com.facebook.login;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.fragment.app.Fragment;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class LoginLogger {
    public static final ScheduledExecutorService worker = Executors.newSingleThreadScheduledExecutor();
    public final String applicationId;
    public final Fragment.AnonymousClass7 logger;

    public LoginLogger(Context context, String applicationId) {
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        this.applicationId = applicationId;
        this.logger = new Fragment.AnonymousClass7(context, applicationId);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                packageManager.getPackageInfo("com.facebook.katana", 0);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }
}
