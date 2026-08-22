package androidx.activity;

import android.view.inputmethod.InputMethodManager;
import java.lang.reflect.Field;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
public final class ImmLeaksCleaner$Companion$cleaner$2 extends Lambda implements Function0 {
    public static final ImmLeaksCleaner$Companion$cleaner$2 INSTANCE = new ImmLeaksCleaner$Companion$cleaner$2(0);

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        try {
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            declaredField3.setAccessible(true);
            return new ImmLeaksCleaner.ValidCleaner(declaredField3, declaredField, declaredField2);
        } catch (NoSuchFieldException unused) {
            return ImmLeaksCleaner.FailedInitialization.INSTANCE;
        }
    }
}
