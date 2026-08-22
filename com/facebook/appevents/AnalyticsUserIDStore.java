package com.facebook.appevents;

import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes.dex */
public abstract class AnalyticsUserIDStore {
    public static volatile boolean initialized;
    public static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public static String userID;

    public static void initAndWait() {
        if (initialized) {
            return;
        }
        lock.writeLock().lock();
        try {
            if (initialized) {
                return;
            }
            userID = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).getString("com.facebook.appevents.AnalyticsUserIDStore.userID", null);
            initialized = true;
        } finally {
            lock.writeLock().unlock();
        }
    }
}
