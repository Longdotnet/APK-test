package androidx.lifecycle.viewmodel;

import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class CreationExtras {
    public final LinkedHashMap map = new LinkedHashMap();

    public final class Empty extends CreationExtras {
        public static final Empty INSTANCE = new Empty();
    }
}
