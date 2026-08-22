package com.google.android.gms.games;

import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes.dex */
public interface AchievementsClient {
    Task getAchievementsIntent();

    void increment(String str, int i);

    Task incrementImmediate(String str, int i);

    Task load(boolean z);

    void reveal(String str);

    Task revealImmediate(String str);

    void setSteps(String str, int i);

    Task setStepsImmediate(String str, int i);

    void unlock(String str);

    Task unlockImmediate(String str);
}
