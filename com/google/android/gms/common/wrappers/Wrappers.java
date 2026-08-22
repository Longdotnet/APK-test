package com.google.android.gms.common.wrappers;

import android.content.Context;
import androidx.work.impl.WorkDatabase;

/* JADX INFO: loaded from: classes.dex */
public final class Wrappers {
    public static final Wrappers zza;
    public WorkDatabase.AnonymousClass1 zzb;

    static {
        Wrappers wrappers = new Wrappers();
        wrappers.zzb = null;
        zza = wrappers;
    }

    public static WorkDatabase.AnonymousClass1 packageManager(Context context) {
        WorkDatabase.AnonymousClass1 anonymousClass1;
        Wrappers wrappers = zza;
        synchronized (wrappers) {
            try {
                if (wrappers.zzb == null) {
                    if (context.getApplicationContext() != null) {
                        context = context.getApplicationContext();
                    }
                    wrappers.zzb = new WorkDatabase.AnonymousClass1(context);
                }
                anonymousClass1 = wrappers.zzb;
            } catch (Throwable th) {
                throw th;
            }
        }
        return anonymousClass1;
    }
}
