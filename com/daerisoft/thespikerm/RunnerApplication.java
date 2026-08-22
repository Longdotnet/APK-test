package com.daerisoft.thespikerm;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import androidx.multidex.MultiDex;
import com.facebook.internal.instrument.anrreport.eBpy.lxnc;
import com.pairip.StartupLauncher;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public class RunnerApplication extends Application {
    static {
        StartupLauncher.launch();
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        ApplicationInfo applicationInfo;
        super.attachBaseContext(context);
        HashSet hashSet = MultiDex.installedApk;
        Log.i("MultiDex", "Installing application");
        try {
            if (MultiDex.IS_VM_MULTIDEX_CAPABLE) {
                Log.i("MultiDex", "VM has multidex support, MultiDex support library is disabled.");
                return;
            }
            try {
                applicationInfo = getApplicationInfo();
            } catch (RuntimeException e) {
                Log.w("MultiDex", "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", e);
                applicationInfo = null;
            }
            if (applicationInfo == null) {
                Log.i("MultiDex", "No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
            } else {
                MultiDex.doInstallation(this, new File(applicationInfo.sourceDir), new File(applicationInfo.dataDir));
                Log.i("MultiDex", "install done");
            }
        } catch (Exception e2) {
            Log.e("MultiDex", "MultiDex installation failure", e2);
            throw new RuntimeException("MultiDex installation failed (" + e2.getMessage() + ").");
        }
    }

    @Override // android.app.Application
    public final void onCreate() throws IllegalAccessException, InvocationTargetException {
        lxnc.dnqdtFIUj.invoke(null, this);
    }
}
