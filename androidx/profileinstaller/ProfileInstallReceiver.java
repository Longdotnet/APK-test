package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import androidx.arch.core.executor.ArchTaskExecutor$$ExternalSyntheticLambda0;
import com.facebook.ProfileCache;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class ProfileInstallReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) throws Throwable {
        Bundle extras;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if ("androidx.profileinstaller.action.INSTALL_PROFILE".equals(action)) {
            Encoding.writeProfile(context, new ArchTaskExecutor$$ExternalSyntheticLambda0(1), new ProfileCache(this, 13), true);
            return;
        }
        if ("androidx.profileinstaller.action.SKIP_FILE".equals(action)) {
            Bundle extras2 = intent.getExtras();
            if (extras2 != null) {
                String string = extras2.getString("EXTRA_SKIP_FILE_OPERATION");
                if (!"WRITE_SKIP_FILE".equals(string)) {
                    if ("DELETE_SKIP_FILE".equals(string)) {
                        new File(context.getFilesDir(), "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
                        Log.d("ProfileInstaller", "RESULT_DELETE_SKIP_FILE_SUCCESS");
                        setResultCode(11);
                        return;
                    }
                    return;
                }
                ProfileCache profileCache = new ProfileCache(this, 13);
                try {
                    Encoding.noteProfileWrittenFor(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
                    profileCache.onResultReceived(10, null);
                    return;
                } catch (PackageManager.NameNotFoundException e) {
                    profileCache.onResultReceived(7, e);
                    return;
                }
            }
            return;
        }
        if ("androidx.profileinstaller.action.SAVE_PROFILE".equals(action)) {
            ProfileCache profileCache2 = new ProfileCache(this, 13);
            if (Build.VERSION.SDK_INT < 24) {
                profileCache2.onResultReceived(13, null);
                return;
            } else {
                Process.sendSignal(Process.myPid(), 10);
                profileCache2.onResultReceived(12, null);
                return;
            }
        }
        if (!"androidx.profileinstaller.action.BENCHMARK_OPERATION".equals(action) || (extras = intent.getExtras()) == null) {
            return;
        }
        String string2 = extras.getString("EXTRA_BENCHMARK_OPERATION");
        ProfileCache profileCache3 = new ProfileCache(this, 13);
        if (!"DROP_SHADER_CACHE".equals(string2)) {
            profileCache3.onResultReceived(16, null);
            return;
        }
        if (Encoding.deleteFilesRecursively(Build.VERSION.SDK_INT >= 24 ? context.createDeviceProtectedStorageContext().getCodeCacheDir() : context.getCodeCacheDir())) {
            profileCache3.onResultReceived(14, null);
        } else {
            profileCache3.onResultReceived(15, null);
        }
    }
}
