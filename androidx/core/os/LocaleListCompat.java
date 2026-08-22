package androidx.core.os;

import android.os.Build;
import android.os.LocaleList;
import androidx.core.text.ICUCompat;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class LocaleListCompat {
    public static final LocaleListCompat sEmptyLocaleList = create(new Locale[0]);
    public final LocaleListInterface mImpl;

    public abstract class Api21Impl {
        public static final Locale[] PSEUDO_LOCALE = {new Locale("en", "XA"), new Locale("ar", "XB")};

        public static Locale forLanguageTag(String str) {
            return Locale.forLanguageTag(str);
        }

        public static boolean matchesLanguageAndScript(Locale locale, Locale locale2) {
            if (locale.equals(locale2)) {
                return true;
            }
            if (!locale.getLanguage().equals(locale2.getLanguage())) {
                return false;
            }
            Locale[] localeArr = PSEUDO_LOCALE;
            for (Locale locale3 : localeArr) {
                if (locale3.equals(locale)) {
                    return false;
                }
            }
            for (Locale locale4 : localeArr) {
                if (locale4.equals(locale2)) {
                    return false;
                }
            }
            String strMaximizeAndGetScript = ICUCompat.maximizeAndGetScript(locale);
            if (!strMaximizeAndGetScript.isEmpty()) {
                return strMaximizeAndGetScript.equals(ICUCompat.maximizeAndGetScript(locale2));
            }
            String country = locale.getCountry();
            return country.isEmpty() || country.equals(locale2.getCountry());
        }
    }

    public abstract class Api24Impl {
        public static LocaleList createLocaleList(Locale... localeArr) {
            return new LocaleList(localeArr);
        }

        public static LocaleList getAdjustedDefault() {
            return LocaleList.getAdjustedDefault();
        }

        public static LocaleList getDefault() {
            return LocaleList.getDefault();
        }
    }

    public LocaleListCompat(LocaleListInterface localeListInterface) {
        this.mImpl = localeListInterface;
    }

    public static LocaleListCompat create(Locale... localeArr) {
        return Build.VERSION.SDK_INT >= 24 ? new LocaleListCompat(new LocaleListPlatformWrapper(Api24Impl.createLocaleList(localeArr))) : new LocaleListCompat(new LocaleListCompatWrapper(localeArr));
    }

    public static LocaleListCompat forLanguageTags(String str) {
        if (str == null || str.isEmpty()) {
            return sEmptyLocaleList;
        }
        String[] strArrSplit = str.split(",", -1);
        int length = strArrSplit.length;
        Locale[] localeArr = new Locale[length];
        for (int i = 0; i < length; i++) {
            localeArr[i] = Api21Impl.forLanguageTag(strArrSplit[i]);
        }
        return create(localeArr);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof LocaleListCompat) {
            if (this.mImpl.equals(((LocaleListCompat) obj).mImpl)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.mImpl.hashCode();
    }

    public final String toString() {
        return this.mImpl.toString();
    }
}
