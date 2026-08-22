package androidx.work.impl.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.work.Configuration;
import androidx.work.Logger$LogcatLogger;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class ProcessUtils {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("ProcessUtils");

    public static boolean isDefaultProcess(Context context, Configuration configuration) {
        String processName;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (Build.VERSION.SDK_INT >= 28) {
            processName = Application.getProcessName();
        } else {
            try {
                Method declaredMethod = Class.forName("android.app.ActivityThread", false, ProcessUtils.class.getClassLoader()).getDeclaredMethod("currentProcessName", null);
                declaredMethod.setAccessible(true);
                Object objInvoke = declaredMethod.invoke(null, null);
                if (!(objInvoke instanceof String)) {
                    int iMyPid = Process.myPid();
                    ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                    if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null && !runningAppProcesses.isEmpty()) {
                        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                processName = null;
                                break;
                            }
                            ActivityManager.RunningAppProcessInfo next = it.next();
                            if (next.pid == iMyPid) {
                                processName = next.processName;
                                break;
                            }
                        }
                    } else {
                        processName = null;
                        break;
                    }
                } else {
                    processName = (String) objInvoke;
                }
            } catch (Throwable th) {
                Logger$LogcatLogger.get().debug(TAG, "Unable to check ActivityThread for processName", th);
            }
        }
        configuration.getClass();
        return !TextUtils.isEmpty(null) ? TextUtils.equals(processName, null) : TextUtils.equals(processName, context.getApplicationInfo().processName);
    }
}
