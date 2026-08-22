package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.PersistableBundle;
import android.util.Base64;
import android.util.Log;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import com.google.android.gms.appset.vSSa.iafHZUfOuHNwvy;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Set;
import java.util.zip.Adler32;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
public final class JobInfoScheduler {
    public final AutoValue_SchedulerConfig config;
    public final Context context;
    public final EventStore eventStore;

    public JobInfoScheduler(Context context, EventStore eventStore, AutoValue_SchedulerConfig autoValue_SchedulerConfig) {
        this.context = context;
        this.eventStore = eventStore;
        this.config = autoValue_SchedulerConfig;
    }

    public final void schedule(AutoValue_TransportContext autoValue_TransportContext, int i, boolean z) {
        Context context = this.context;
        ComponentName componentName = new ComponentName(context, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        Adler32 adler32 = new Adler32();
        adler32.update(context.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(autoValue_TransportContext.backendName.getBytes(Charset.forName("UTF-8")));
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        Priority priority = autoValue_TransportContext.priority;
        adler32.update(byteBufferAllocate.putInt(PriorityMapping.toInt(priority)).array());
        byte[] bArr = autoValue_TransportContext.extras;
        if (bArr != null) {
            adler32.update(bArr);
        }
        int value = (int) adler32.getValue();
        if (!z) {
            for (JobInfo jobInfo : jobScheduler.getAllPendingJobs()) {
                int i2 = jobInfo.getExtras().getInt("attemptNumber");
                if (jobInfo.getId() == value) {
                    if (i2 < i) {
                        break;
                    }
                    RangesKt.d("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", autoValue_TransportContext);
                    return;
                }
            }
        }
        SQLiteDatabase db = ((SQLiteEventStore) this.eventStore).getDb();
        String strValueOf = String.valueOf(PriorityMapping.toInt(priority));
        String str = autoValue_TransportContext.backendName;
        Cursor cursorRawQuery = db.rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{str, strValueOf});
        try {
            Long lValueOf = cursorRawQuery.moveToNext() ? Long.valueOf(cursorRawQuery.getLong(0)) : 0L;
            cursorRawQuery.close();
            long jLongValue = lValueOf.longValue();
            JobInfo.Builder builder = new JobInfo.Builder(value, componentName);
            AutoValue_SchedulerConfig autoValue_SchedulerConfig = this.config;
            Long l = lValueOf;
            builder.setMinimumLatency(autoValue_SchedulerConfig.getScheduleDelay(priority, jLongValue, i));
            Set set = ((AutoValue_SchedulerConfig_ConfigValue) autoValue_SchedulerConfig.values.get(priority)).flags;
            if (set.contains(SchedulerConfig$Flag.NETWORK_UNMETERED)) {
                builder.setRequiredNetworkType(2);
            } else {
                builder.setRequiredNetworkType(1);
            }
            if (set.contains(SchedulerConfig$Flag.DEVICE_CHARGING)) {
                builder.setRequiresCharging(true);
            }
            if (set.contains(SchedulerConfig$Flag.DEVICE_IDLE)) {
                builder.setRequiresDeviceIdle(true);
            }
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putInt("attemptNumber", i);
            persistableBundle.putString("backendName", str);
            persistableBundle.putInt(iafHZUfOuHNwvy.ZmuRq, PriorityMapping.toInt(priority));
            if (bArr != null) {
                persistableBundle.putString("extras", Base64.encodeToString(bArr, 0));
            }
            builder.setExtras(persistableBundle);
            Object[] objArr = {autoValue_TransportContext, Integer.valueOf(value), Long.valueOf(autoValue_SchedulerConfig.getScheduleDelay(priority, jLongValue, i)), l, Integer.valueOf(i)};
            String tag = RangesKt.getTag("JobInfoScheduler");
            if (Log.isLoggable(tag, 3)) {
                Log.d(tag, String.format("Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", objArr));
            }
            jobScheduler.schedule(builder.build());
        } catch (Throwable th) {
            cursorRawQuery.close();
            throw th;
        }
    }
}
