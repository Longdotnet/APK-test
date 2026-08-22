package androidx.work.impl.background.systemalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.Preference;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.utils.IdGenerator;
import com.google.firebase.auth.zzaa;

/* JADX INFO: loaded from: classes.dex */
public abstract class Alarms {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("Alarms");

    public static void cancelExactAlarm(Context context, String str, int i) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(context, i, CommandHandler.createDelayMetIntent(context, str), 603979776);
        if (service == null || alarmManager == null) {
            return;
        }
        Logger$LogcatLogger.get().debug(TAG, "Cancelling existing alarm with (workSpecId, systemId) (" + str + ", " + i + ")", new Throwable[0]);
        alarmManager.cancel(service);
    }

    public static void setAlarm(Context context, WorkManagerImpl workManagerImpl, String str, long j) {
        int iIntValue;
        WorkDatabase workDatabase = workManagerImpl.mWorkDatabase;
        zzaa zzaaVarSystemIdInfoDao = workDatabase.systemIdInfoDao();
        SystemIdInfo systemIdInfo = zzaaVarSystemIdInfoDao.getSystemIdInfo(str);
        if (systemIdInfo != null) {
            cancelExactAlarm(context, str, systemIdInfo.systemId);
            int i = systemIdInfo.systemId;
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            PendingIntent service = PendingIntent.getService(context, i, CommandHandler.createDelayMetIntent(context, str), 201326592);
            if (alarmManager != null) {
                alarmManager.setExact(0, j, service);
                return;
            }
            return;
        }
        synchronized (IdGenerator.class) {
            workDatabase.beginTransaction();
            try {
                Long longValue = workDatabase.preferenceDao().getLongValue("next_alarm_manager_id");
                iIntValue = longValue != null ? longValue.intValue() : 0;
                workDatabase.preferenceDao().insertPreference(new Preference("next_alarm_manager_id", iIntValue == Integer.MAX_VALUE ? 0 : iIntValue + 1));
                workDatabase.setTransactionSuccessful();
                workDatabase.endTransaction();
            } catch (Throwable th) {
                workDatabase.endTransaction();
                throw th;
            }
        }
        zzaaVarSystemIdInfoDao.insertSystemIdInfo(new SystemIdInfo(str, iIntValue));
        AlarmManager alarmManager2 = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service2 = PendingIntent.getService(context, iIntValue, CommandHandler.createDelayMetIntent(context, str), 201326592);
        if (alarmManager2 != null) {
            alarmManager2.setExact(0, j, service2);
        }
    }
}
