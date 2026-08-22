package androidx.work;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class InputMerger {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("InputMerger");

    public abstract Data merge(ArrayList arrayList);
}
