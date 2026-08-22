package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.google.android.gms.games.provider.NtJ.wsbWxekY;
import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class HeartBeatInfoStorage {
    public final SharedPreferences firebaseSharedPreferences;

    public HeartBeatInfoStorage(Context context, String str) {
        this.firebaseSharedPreferences = context.getSharedPreferences("FirebaseHeartBeat" + str, 0);
    }

    public final synchronized void cleanUpStoredHeartBeats() {
        try {
            long j = this.firebaseSharedPreferences.getLong("fire-count", 0L);
            String key = "";
            String str = null;
            for (Map.Entry<String, ?> entry : this.firebaseSharedPreferences.getAll().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    for (String str2 : (Set) entry.getValue()) {
                        if (str == null || str.compareTo(str2) > 0) {
                            key = entry.getKey();
                            str = str2;
                        }
                    }
                }
            }
            HashSet hashSet = new HashSet(this.firebaseSharedPreferences.getStringSet(key, new HashSet()));
            hashSet.remove(str);
            this.firebaseSharedPreferences.edit().putStringSet(key, hashSet).putLong(wsbWxekY.gEyyzHTohY, j - 1).commit();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void deleteAllHeartBeats() {
        try {
            SharedPreferences.Editor editorEdit = this.firebaseSharedPreferences.edit();
            for (Map.Entry<String, ?> entry : this.firebaseSharedPreferences.getAll().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    editorEdit.remove(entry.getKey());
                }
            }
            editorEdit.remove("fire-count");
            editorEdit.commit();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized ArrayList getAllHeartBeats() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (Map.Entry<String, ?> entry : this.firebaseSharedPreferences.getAll().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    arrayList.add(HeartBeatResult.create(entry.getKey(), new ArrayList((Set) entry.getValue())));
                }
            }
            updateGlobalHeartBeat(System.currentTimeMillis());
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public final synchronized String getFormattedDate(long j) {
        if (Build.VERSION.SDK_INT >= 26) {
            return new Date(j).toInstant().atOffset(ZoneOffset.UTC).toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
        return new SimpleDateFormat("yyyy-MM-dd", Locale.UK).format(new Date(j));
    }

    public final synchronized String getStoredUserAgentString(String str) {
        for (Map.Entry<String, ?> entry : this.firebaseSharedPreferences.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                Iterator it = ((Set) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (str.equals((String) it.next())) {
                        return entry.getKey();
                    }
                }
            }
        }
        return null;
    }

    public final synchronized boolean isSameDateUtc(long j, long j2) {
        return getFormattedDate(j).equals(getFormattedDate(j2));
    }

    public final synchronized void postHeartBeatCleanUp() {
        String formattedDate = getFormattedDate(System.currentTimeMillis());
        this.firebaseSharedPreferences.edit().putString("last-used-date", formattedDate).commit();
        removeStoredDate(formattedDate);
    }

    public final synchronized void removeStoredDate(String str) {
        try {
            String storedUserAgentString = getStoredUserAgentString(str);
            if (storedUserAgentString == null) {
                return;
            }
            HashSet hashSet = new HashSet(this.firebaseSharedPreferences.getStringSet(storedUserAgentString, new HashSet()));
            hashSet.remove(str);
            if (hashSet.isEmpty()) {
                this.firebaseSharedPreferences.edit().remove(storedUserAgentString).commit();
            } else {
                this.firebaseSharedPreferences.edit().putStringSet(storedUserAgentString, hashSet).commit();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean shouldSendGlobalHeartBeat(long j) {
        return shouldSendSdkHeartBeat(j);
    }

    public final synchronized boolean shouldSendSdkHeartBeat(long j) {
        if (!this.firebaseSharedPreferences.contains("fire-global")) {
            this.firebaseSharedPreferences.edit().putLong("fire-global", j).commit();
            return true;
        }
        if (isSameDateUtc(this.firebaseSharedPreferences.getLong("fire-global", -1L), j)) {
            return false;
        }
        this.firebaseSharedPreferences.edit().putLong("fire-global", j).commit();
        return true;
    }

    public final synchronized void storeHeartBeat(long j, String str) {
        try {
            String formattedDate = getFormattedDate(j);
            if (this.firebaseSharedPreferences.getString("last-used-date", "").equals(formattedDate)) {
                return;
            }
            long j2 = this.firebaseSharedPreferences.getLong("fire-count", 0L);
            if (j2 + 1 == 30) {
                cleanUpStoredHeartBeats();
                j2 = this.firebaseSharedPreferences.getLong("fire-count", 0L);
            }
            HashSet hashSet = new HashSet(this.firebaseSharedPreferences.getStringSet(str, new HashSet()));
            hashSet.add(formattedDate);
            this.firebaseSharedPreferences.edit().putStringSet(str, hashSet).putLong("fire-count", j2 + 1).putString("last-used-date", formattedDate).commit();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void updateGlobalHeartBeat(long j) {
        this.firebaseSharedPreferences.edit().putLong("fire-global", j).commit();
    }
}
