package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.wrappers.Wrappers;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzah {
    public static final Object zza = new Object();
    public static boolean zzb;
    public static String zzc;
    public static int zzd;

    public static void checkArgument(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkHandlerThread(Handler handler) {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != handler.getLooper()) {
            throw new IllegalStateException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m("Must be called on ", handler.getLooper().getThread().getName(), " thread, but got ", looperMyLooper != null ? looperMyLooper.getThread().getName() : "null current looper", "."));
        }
    }

    public static void checkMainThread(String str) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return;
        }
        Log.e("Asserts", CoroutineAdapterKt$$ExternalSyntheticLambda0.m("checkMainThread: current thread ", String.valueOf(Thread.currentThread()), " IS NOT the main thread ", String.valueOf(Looper.getMainLooper().getThread()), "!"));
        throw new IllegalStateException(str);
    }

    public static void checkMainThread$1(String str) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException(str);
        }
    }

    public static void checkNotEmpty(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
    }

    public static void checkNotGoogleApiHandlerThread() {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != null) {
            String name = looperMyLooper.getThread().getName();
            if (name == "GoogleApiHandler" || (name != null && name.equals("GoogleApiHandler"))) {
                throw new IllegalStateException("Must not be called on GoogleApiHandler thread.");
            }
        }
    }

    public static void checkNotMainThread(String str) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IllegalStateException(str);
        }
    }

    public static void checkNotNull(Object obj) {
        if (obj == null) {
            throw new NullPointerException("null reference");
        }
    }

    public static void checkState(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void checkState$1(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static boolean equal(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static ApiException fromStatus(Status status) {
        return status.hasResolution() ? new ResolvableApiException(status) : new ApiException(status);
    }

    public static void zzc(Context context) {
        synchronized (zza) {
            try {
                if (zzb) {
                    return;
                }
                zzb = true;
                try {
                    Bundle bundle = Wrappers.packageManager(context).getApplicationInfo(128, context.getPackageName()).metaData;
                    if (bundle == null) {
                        return;
                    }
                    zzc = bundle.getString("com.google.app.id");
                    zzd = bundle.getInt("com.google.android.gms.version");
                } catch (PackageManager.NameNotFoundException e) {
                    Log.wtf("MetadataValueReader", "This should never happen.", e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void checkArgument(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(str));
        }
    }

    public static void checkNotNull(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static void checkState(boolean z, String str) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(str));
        }
    }

    public static void checkNotEmpty(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }
}
