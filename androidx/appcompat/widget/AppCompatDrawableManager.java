package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Log;
import okhttp3.ConnectionSpec;
import okhttp3.Request;

/* JADX INFO: loaded from: classes.dex */
public final class AppCompatDrawableManager {
    public static final PorterDuff.Mode DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
    public static AppCompatDrawableManager INSTANCE;
    public ResourceManagerInternal mResourceManager;

    public static synchronized AppCompatDrawableManager get() {
        try {
            if (INSTANCE == null) {
                preload();
            }
        } catch (Throwable th) {
            throw th;
        }
        return INSTANCE;
    }

    public static synchronized void preload() {
        if (INSTANCE == null) {
            AppCompatDrawableManager appCompatDrawableManager = new AppCompatDrawableManager();
            INSTANCE = appCompatDrawableManager;
            appCompatDrawableManager.mResourceManager = ResourceManagerInternal.get();
            INSTANCE.mResourceManager.setHooks(new Request(1));
        }
    }

    public static void tintDrawable(Drawable drawable, ConnectionSpec.Builder builder, int[] iArr) {
        PorterDuff.Mode mode = ResourceManagerInternal.DEFAULT_MODE;
        int[] state = drawable.getState();
        if (drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z = builder.supportsTlsExtensions;
        if (z || builder.tls) {
            PorterDuffColorFilter porterDuffColorFilter = null;
            ColorStateList colorStateList = z ? (ColorStateList) builder.cipherSuites : null;
            PorterDuff.Mode mode2 = builder.tls ? (PorterDuff.Mode) builder.tlsVersions : ResourceManagerInternal.DEFAULT_MODE;
            if (colorStateList != null && mode2 != null) {
                porterDuffColorFilter = ResourceManagerInternal.getPorterDuffColorFilter(colorStateList.getColorForState(iArr, 0), mode2);
            }
            drawable.setColorFilter(porterDuffColorFilter);
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    public final synchronized Drawable getDrawable(Context context, int i) {
        return this.mResourceManager.getDrawable(context, i);
    }
}
