package androidx.work.impl.foreground;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.appcompat.widget.AppCompatTextHelper;
import androidx.emoji2.text.EmojiCompat;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.work.ForegroundInfo;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.StopWorkRunnable;
import com.google.firebase.auth.zzaa;
import com.yoyogames.runner.RunnerJNILib;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class SystemForegroundDispatcher implements WorkConstraintsCallback, ExecutionListener {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("SystemFgDispatcher");
    public SystemForegroundService mCallback;
    public final WorkConstraintsTracker mConstraintsTracker;
    public String mCurrentForegroundWorkSpecId;
    public final LinkedHashMap mForegroundInfoById;
    public final Object mLock = new Object();
    public final zzaa mTaskExecutor;
    public final HashSet mTrackedWorkSpecs;
    public final WorkManagerImpl mWorkManagerImpl;
    public final HashMap mWorkSpecById;

    public SystemForegroundDispatcher(Context context) {
        WorkManagerImpl workManagerImpl = WorkManagerImpl.getInstance(context);
        this.mWorkManagerImpl = workManagerImpl;
        zzaa zzaaVar = workManagerImpl.mWorkTaskExecutor;
        this.mTaskExecutor = zzaaVar;
        this.mCurrentForegroundWorkSpecId = null;
        this.mForegroundInfoById = new LinkedHashMap();
        this.mTrackedWorkSpecs = new HashSet();
        this.mWorkSpecById = new HashMap();
        this.mConstraintsTracker = new WorkConstraintsTracker(context, zzaaVar, this);
        workManagerImpl.mProcessor.addExecutionListener(this);
    }

    public static Intent createNotifyIntent(Context context, String str, ForegroundInfo foregroundInfo) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_NOTIFY");
        intent.putExtra("KEY_NOTIFICATION_ID", foregroundInfo.mNotificationId);
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", foregroundInfo.mForegroundServiceType);
        intent.putExtra("KEY_NOTIFICATION", foregroundInfo.mNotification);
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent createStartForegroundIntent(Context context, String str, ForegroundInfo foregroundInfo) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NOTIFICATION_ID", foregroundInfo.mNotificationId);
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", foregroundInfo.mForegroundServiceType);
        intent.putExtra("KEY_NOTIFICATION", foregroundInfo.mNotification);
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public final void handleNotify(Intent intent) {
        int i = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        Logger$LogcatLogger logger$LogcatLogger = Logger$LogcatLogger.get();
        StringBuilder sb = new StringBuilder("Notifying with (id: ");
        sb.append(intExtra);
        sb.append(", workSpecId: ");
        sb.append(stringExtra);
        sb.append(", notificationType: ");
        logger$LogcatLogger.debug(TAG, CoroutineAdapterKt$$ExternalSyntheticLambda0.m(sb, intExtra2, ")"), new Throwable[0]);
        if (notification == null || this.mCallback == null) {
            return;
        }
        ForegroundInfo foregroundInfo = new ForegroundInfo(intExtra, notification, intExtra2);
        LinkedHashMap linkedHashMap = this.mForegroundInfoById;
        linkedHashMap.put(stringExtra, foregroundInfo);
        if (TextUtils.isEmpty(this.mCurrentForegroundWorkSpecId)) {
            this.mCurrentForegroundWorkSpecId = stringExtra;
            SystemForegroundService systemForegroundService = this.mCallback;
            systemForegroundService.mHandler.post(new RunnerJNILib.AnonymousClass10(systemForegroundService, intExtra, notification, intExtra2));
            return;
        }
        SystemForegroundService systemForegroundService2 = this.mCallback;
        systemForegroundService2.mHandler.post(new AppCompatTextHelper.AnonymousClass2(systemForegroundService2, intExtra, notification, 3));
        if (intExtra2 == 0 || Build.VERSION.SDK_INT < 29) {
            return;
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            i |= ((ForegroundInfo) ((Map.Entry) it.next()).getValue()).mForegroundServiceType;
        }
        ForegroundInfo foregroundInfo2 = (ForegroundInfo) linkedHashMap.get(this.mCurrentForegroundWorkSpecId);
        if (foregroundInfo2 != null) {
            SystemForegroundService systemForegroundService3 = this.mCallback;
            systemForegroundService3.mHandler.post(new RunnerJNILib.AnonymousClass10(systemForegroundService3, foregroundInfo2.mNotificationId, foregroundInfo2.mNotification, i));
        }
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public final void onAllConstraintsMet(List list) {
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public final void onAllConstraintsNotMet(ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Logger$LogcatLogger.get().debug(TAG, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Constraints unmet for WorkSpec ", str), new Throwable[0]);
            WorkManagerImpl workManagerImpl = this.mWorkManagerImpl;
            workManagerImpl.mWorkTaskExecutor.executeOnBackgroundThread(new StopWorkRunnable(workManagerImpl, str, true));
        }
    }

    public final void onDestroy() {
        this.mCallback = null;
        synchronized (this.mLock) {
            this.mConstraintsTracker.reset();
        }
        this.mWorkManagerImpl.mProcessor.removeExecutionListener(this);
    }

    @Override // androidx.work.impl.ExecutionListener
    public final void onExecuted(String str, boolean z) {
        Map.Entry entry;
        synchronized (this.mLock) {
            try {
                WorkSpec workSpec = (WorkSpec) this.mWorkSpecById.remove(str);
                if (workSpec != null ? this.mTrackedWorkSpecs.remove(workSpec) : false) {
                    this.mConstraintsTracker.replace(this.mTrackedWorkSpecs);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ForegroundInfo foregroundInfo = (ForegroundInfo) this.mForegroundInfoById.remove(str);
        if (str.equals(this.mCurrentForegroundWorkSpecId) && this.mForegroundInfoById.size() > 0) {
            Iterator it = this.mForegroundInfoById.entrySet().iterator();
            Object next = it.next();
            while (true) {
                entry = (Map.Entry) next;
                if (!it.hasNext()) {
                    break;
                } else {
                    next = it.next();
                }
            }
            this.mCurrentForegroundWorkSpecId = (String) entry.getKey();
            if (this.mCallback != null) {
                ForegroundInfo foregroundInfo2 = (ForegroundInfo) entry.getValue();
                SystemForegroundService systemForegroundService = this.mCallback;
                systemForegroundService.mHandler.post(new RunnerJNILib.AnonymousClass10(systemForegroundService, foregroundInfo2.mNotificationId, foregroundInfo2.mNotification, foregroundInfo2.mForegroundServiceType));
                SystemForegroundService systemForegroundService2 = this.mCallback;
                systemForegroundService2.mHandler.post(new EmojiCompat.ListenerDispatcher(systemForegroundService2, foregroundInfo2.mNotificationId, 1));
            }
        }
        SystemForegroundService systemForegroundService3 = this.mCallback;
        if (foregroundInfo == null || systemForegroundService3 == null) {
            return;
        }
        Logger$LogcatLogger logger$LogcatLogger = Logger$LogcatLogger.get();
        String str2 = TAG;
        int i = foregroundInfo.mNotificationId;
        int i2 = foregroundInfo.mForegroundServiceType;
        StringBuilder sb = new StringBuilder("Removing Notification (id: ");
        sb.append(i);
        sb.append(", workSpecId: ");
        sb.append(str);
        sb.append(" ,notificationType: ");
        logger$LogcatLogger.debug(str2, CoroutineAdapterKt$$ExternalSyntheticLambda0.m(sb, i2, ")"), new Throwable[0]);
        systemForegroundService3.mHandler.post(new EmojiCompat.ListenerDispatcher(systemForegroundService3, foregroundInfo.mNotificationId, 1));
    }
}
