package androidx.core.app;

import android.app.LocaleManager;
import android.os.LocaleList;

/* JADX INFO: loaded from: classes.dex */
public abstract class LocaleManagerCompat$Api33Impl {
    public static LocaleList localeManagerGetApplicationLocales(Object obj) {
        return ((LocaleManager) obj).getApplicationLocales();
    }

    public static LocaleList localeManagerGetSystemLocales(Object obj) {
        return ((LocaleManager) obj).getSystemLocales();
    }
}
