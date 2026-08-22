package androidx.browser.customtabs;

import android.os.LocaleList;

/* JADX INFO: loaded from: classes.dex */
public abstract class CustomTabsIntent$Api24Impl {
    public static String getDefaultLocale() {
        LocaleList adjustedDefault = LocaleList.getAdjustedDefault();
        if (adjustedDefault.size() > 0) {
            return adjustedDefault.get(0).toLanguageTag();
        }
        return null;
    }
}
