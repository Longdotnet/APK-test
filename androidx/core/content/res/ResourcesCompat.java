package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import java.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class ResourcesCompat {
    public static final ThreadLocal sTempTypedValue = new ThreadLocal();
    public static final WeakHashMap sColorStateCaches = new WeakHashMap(0);
    public static final Object sColorStateCacheLock = new Object();

    public abstract class Api21Impl {
        public static Drawable getDrawable(Resources resources, int i, Resources.Theme theme) {
            return resources.getDrawable(i, theme);
        }

        public static Drawable getDrawableForDensity(Resources resources, int i, int i2, Resources.Theme theme) {
            return resources.getDrawableForDensity(i, i2, theme);
        }
    }

    public abstract class Api23Impl {
        public static int getColor(Resources resources, int i, Resources.Theme theme) {
            return resources.getColor(i, theme);
        }

        public static ColorStateList getColorStateList(Resources resources, int i, Resources.Theme theme) {
            return resources.getColorStateList(i, theme);
        }
    }

    public final class ColorStateListCacheEntry {
        public final Configuration mConfiguration;
        public final int mThemeHash;
        public final ColorStateList mValue;

        public ColorStateListCacheEntry(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
            this.mValue = colorStateList;
            this.mConfiguration = configuration;
            this.mThemeHash = theme == null ? 0 : theme.hashCode();
        }
    }

    public final class ColorStateListCacheKey {
        public final Resources mResources;
        public final Resources.Theme mTheme;

        public ColorStateListCacheKey(Resources resources, Resources.Theme theme) {
            this.mResources = resources;
            this.mTheme = theme;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ColorStateListCacheKey.class != obj.getClass()) {
                return false;
            }
            ColorStateListCacheKey colorStateListCacheKey = (ColorStateListCacheKey) obj;
            return this.mResources.equals(colorStateListCacheKey.mResources) && Objects.equals(this.mTheme, colorStateListCacheKey.mTheme);
        }

        public final int hashCode() {
            return Objects.hash(this.mResources, this.mTheme);
        }
    }

    public static void addColorStateListToCache(ColorStateListCacheKey colorStateListCacheKey, int i, ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (sColorStateCacheLock) {
            try {
                WeakHashMap weakHashMap = sColorStateCaches;
                SparseArray sparseArray = (SparseArray) weakHashMap.get(colorStateListCacheKey);
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    weakHashMap.put(colorStateListCacheKey, sparseArray);
                }
                sparseArray.append(i, new ColorStateListCacheEntry(colorStateList, colorStateListCacheKey.mResources.getConfiguration(), theme));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
