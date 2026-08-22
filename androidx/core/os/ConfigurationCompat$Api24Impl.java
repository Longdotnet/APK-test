package androidx.core.os;

import android.content.res.Configuration;
import android.os.LocaleList;

/* JADX INFO: loaded from: classes.dex */
public abstract class ConfigurationCompat$Api24Impl {
    public static LocaleList getLocales(Configuration configuration) {
        return configuration.getLocales();
    }

    public static void setLocales(Configuration configuration, LocaleListCompat localeListCompat) {
        configuration.setLocales((LocaleList) localeListCompat.mImpl.getLocaleList());
    }
}
