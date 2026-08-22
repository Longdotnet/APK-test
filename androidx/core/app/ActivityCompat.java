package androidx.core.app;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActivityCompat extends ContextCompat {

    public abstract class Api21Impl {
        public static void finishAfterTransition(Activity activity) {
            activity.finishAfterTransition();
        }

        public static void postponeEnterTransition(Activity activity) {
            activity.postponeEnterTransition();
        }

        public static void setEnterSharedElementCallback(Activity activity, android.app.SharedElementCallback sharedElementCallback) {
            activity.setEnterSharedElementCallback(sharedElementCallback);
        }

        public static void setExitSharedElementCallback(Activity activity, android.app.SharedElementCallback sharedElementCallback) {
            activity.setExitSharedElementCallback(sharedElementCallback);
        }

        public static void startPostponedEnterTransition(Activity activity) {
            activity.startPostponedEnterTransition();
        }
    }

    public abstract class Api23Impl {
        public static void onSharedElementsReady(Object obj) {
            ((android.app.SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
        }

        public static void requestPermissions(Activity activity, String[] strArr, int i) {
            activity.requestPermissions(strArr, i);
        }

        public static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    public abstract class Api31Impl {
        public static boolean isLaunchedFromBubble(Activity activity) {
            return activity.isLaunchedFromBubble();
        }

        public static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
            try {
                return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", String.class).invoke(activity.getApplication().getPackageManager(), str)).booleanValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return activity.shouldShowRequestPermissionRationale(str);
            }
        }
    }

    public abstract class Api32Impl {
        public static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void requestPermissions(Activity activity, String[] strArr, int i) {
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (TextUtils.isEmpty(strArr[i2])) {
                throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(new StringBuilder("Permission request for permissions "), Arrays.toString(strArr), " must not contain null or empty values"));
            }
            if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(strArr[i2], "android.permission.POST_NOTIFICATIONS")) {
                hashSet.add(Integer.valueOf(i2));
            }
        }
        int size = hashSet.size();
        String[] strArr2 = size > 0 ? new String[strArr.length - size] : strArr;
        if (size > 0) {
            if (size == strArr.length) {
                return;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < strArr.length; i4++) {
                if (!hashSet.contains(Integer.valueOf(i4))) {
                    strArr2[i3] = strArr[i4];
                    i3++;
                }
            }
        }
        if (activity instanceof RequestPermissionsRequestCodeValidator) {
            ((RequestPermissionsRequestCodeValidator) activity).validateRequestPermissionsRequestCode(i);
        }
        Api23Impl.requestPermissions(activity, strArr, i);
    }

    public static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
        int i = Build.VERSION.SDK_INT;
        if (i < 33 && TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return false;
        }
        if (i >= 32) {
            return Api32Impl.shouldShowRequestPermissionRationale(activity, str);
        }
        return i == 31 ? Api31Impl.shouldShowRequestPermissionRationale(activity, str) : Api23Impl.shouldShowRequestPermissionRationale(activity, str);
    }
}
