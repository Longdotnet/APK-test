package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.LocaleList;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.StandaloneActionMode;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.WindowCallbackWrapper$Api23Impl;
import androidx.appcompat.view.WindowCallbackWrapper$Api24Impl;
import androidx.appcompat.view.WindowCallbackWrapper$Api26Impl;
import androidx.appcompat.view.menu.BaseMenuWrapper;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Toolbar$Api33Impl$$ExternalSyntheticLambda0;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.ViewUtils;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.NavUtils;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.os.LocaleListCompat;
import androidx.core.os.LocaleListInterface;
import androidx.core.view.KeyEventDispatcher$Component;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.PopupWindowCompat$Api23Impl;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.room.RoomOpenHelper;
import androidx.sqlite.db.framework.VERT.YcVWhnLsj;
import com.daerisoft.thespikerm.GamepadHandler_API19;
import com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.TossType;
import com.facebook.AccessTokenCache;
import com.facebook.AccessTokenManager$$ExternalSyntheticLambda0;
import com.facebook.ProfileCache;
import com.google.android.gms.ads.jY.UUFMQdNK;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.zzaa;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.WeakHashMap;
import kotlin.ranges.RangesKt;
import okhttp3.Dispatcher;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.internal.concurrent.onZL.mnwSv;

/* JADX INFO: loaded from: classes2.dex */
public final class AppCompatDelegateImpl extends AppCompatDelegate implements MenuBuilder.Callback, LayoutInflater.Factory2 {
    public ActionBar mActionBar;
    public ProfileCache mActionMenuPresenterCallback;
    public ActionMode mActionMode;
    public PopupWindow mActionModePopup;
    public ActionBarContextView mActionModeView;
    public int mActivityHandlesConfigFlags;
    public boolean mActivityHandlesConfigFlagsChecked;
    public final Object mAppCompatCallback;
    public AppCompatViewInflater mAppCompatViewInflater;
    public AppCompatWindowCallback mAppCompatWindowCallback;
    public AutoTimeNightModeManager mAutoBatteryNightModeManager;
    public AutoTimeNightModeManager mAutoTimeNightModeManager;
    public OnBackInvokedCallback mBackCallback;
    public boolean mBaseContextAttached;
    public boolean mClosingActionMenu;
    public final Context mContext;
    public boolean mCreated;
    public DecorContentParent mDecorContentParent;
    public boolean mDestroyed;
    public OnBackInvokedDispatcher mDispatcher;
    public Configuration mEffectiveConfiguration;
    public boolean mEnableDefaultActionBarUp;
    public boolean mFeatureIndeterminateProgress;
    public boolean mFeatureProgress;
    public boolean mHasActionBar;
    public final Object mHost;
    public int mInvalidatePanelMenuFeatures;
    public boolean mInvalidatePanelMenuPosted;
    public boolean mIsFloating;
    public final int mLocalNightMode;
    public boolean mLongPressBackDown;
    public SupportMenuInflater mMenuInflater;
    public boolean mOverlayActionBar;
    public boolean mOverlayActionMode;
    public AnonymousClass3 mPanelMenuPresenterCallback;
    public PanelFeatureState[] mPanels;
    public PanelFeatureState mPreparedPanel;
    public AnonymousClass2 mShowActionModePopup;
    public View mStatusGuard;
    public ViewGroup mSubDecor;
    public boolean mSubDecorInstalled;
    public Rect mTempRect1;
    public Rect mTempRect2;
    public int mThemeResId;
    public CharSequence mTitle;
    public TextView mTitleView;
    public Window mWindow;
    public boolean mWindowNoTitle;
    public static final SimpleArrayMap sLocalNightModes = new SimpleArrayMap();
    public static final int[] sWindowBackgroundStyleable = {R.attr.windowBackground};
    public static final boolean sCanReturnDifferentContext = !"robolectric".equals(Build.FINGERPRINT);
    public ViewPropertyAnimatorCompat mFadeAnim = null;
    public final AnonymousClass2 mInvalidatePanelMenuRunnable = new AnonymousClass2(this, 0);

    /* JADX INFO: renamed from: androidx.appcompat.app.AppCompatDelegateImpl$2, reason: invalid class name */
    /* JADX INFO: loaded from: classes.dex */
    public final class AnonymousClass2 implements Runnable {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ AppCompatDelegateImpl this$0;

        public /* synthetic */ AnonymousClass2(AppCompatDelegateImpl appCompatDelegateImpl, int i) {
            this.$r8$classId = i;
            this.this$0 = appCompatDelegateImpl;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ViewGroup viewGroup;
            switch (this.$r8$classId) {
                case 0:
                    AppCompatDelegateImpl appCompatDelegateImpl = this.this$0;
                    if ((appCompatDelegateImpl.mInvalidatePanelMenuFeatures & 1) != 0) {
                        appCompatDelegateImpl.doInvalidatePanelMenu(0);
                    }
                    if ((appCompatDelegateImpl.mInvalidatePanelMenuFeatures & 4096) != 0) {
                        appCompatDelegateImpl.doInvalidatePanelMenu(TossType.TOSS_FIXED_MED_FOR_BEGINNER_VALUE);
                    }
                    appCompatDelegateImpl.mInvalidatePanelMenuPosted = false;
                    appCompatDelegateImpl.mInvalidatePanelMenuFeatures = 0;
                    break;
                default:
                    AppCompatDelegateImpl appCompatDelegateImpl2 = this.this$0;
                    appCompatDelegateImpl2.mActionModePopup.showAtLocation(appCompatDelegateImpl2.mActionModeView, 55, 0, 0);
                    ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = appCompatDelegateImpl2.mFadeAnim;
                    if (viewPropertyAnimatorCompat != null) {
                        viewPropertyAnimatorCompat.cancel();
                    }
                    if (!(appCompatDelegateImpl2.mSubDecorInstalled && (viewGroup = appCompatDelegateImpl2.mSubDecor) != null && viewGroup.isLaidOut())) {
                        appCompatDelegateImpl2.mActionModeView.setAlpha(1.0f);
                        appCompatDelegateImpl2.mActionModeView.setVisibility(0);
                    } else {
                        appCompatDelegateImpl2.mActionModeView.setAlpha(0.0f);
                        ViewPropertyAnimatorCompat viewPropertyAnimatorCompatAnimate = ViewCompat.animate(appCompatDelegateImpl2.mActionModeView);
                        viewPropertyAnimatorCompatAnimate.alpha(1.0f);
                        appCompatDelegateImpl2.mFadeAnim = viewPropertyAnimatorCompatAnimate;
                        viewPropertyAnimatorCompatAnimate.setListener(new AnonymousClass7(this, 1));
                    }
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.AppCompatDelegateImpl$3, reason: invalid class name */
    public final class AnonymousClass3 implements OnApplyWindowInsetsListener, MenuPresenter.Callback {
        public /* synthetic */ AnonymousClass3() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            PanelFeatureState panelFeatureState;
            MenuBuilder rootMenu = menuBuilder.getRootMenu();
            int i = 0;
            boolean z2 = rootMenu != menuBuilder;
            if (z2) {
                menuBuilder = rootMenu;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            PanelFeatureState[] panelFeatureStateArr = appCompatDelegateImpl.mPanels;
            int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
            while (true) {
                if (i < length) {
                    panelFeatureState = panelFeatureStateArr[i];
                    if (panelFeatureState != null && panelFeatureState.menu == menuBuilder) {
                        break;
                    } else {
                        i++;
                    }
                } else {
                    panelFeatureState = null;
                    break;
                }
            }
            if (panelFeatureState != null) {
                if (!z2) {
                    appCompatDelegateImpl.closePanel(panelFeatureState, z);
                } else {
                    appCompatDelegateImpl.callOnPanelClosed(panelFeatureState.featureId, panelFeatureState, rootMenu);
                    appCompatDelegateImpl.closePanel(panelFeatureState, true);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Window.Callback callback;
            if (menuBuilder != menuBuilder.getRootMenu()) {
                return true;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (!appCompatDelegateImpl.mHasActionBar || (callback = appCompatDelegateImpl.mWindow.getCallback()) == null || appCompatDelegateImpl.mDestroyed) {
                return true;
            }
            callback.onMenuOpened(TossType.TOSS_FIXED_MED_FOR_BEGINNER_VALUE, menuBuilder);
            return true;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            int i;
            int i2;
            boolean z;
            WindowInsetsCompat windowInsetsCompatBuild;
            WindowInsetsCompat.BuilderImpl builderImpl29;
            boolean z2;
            boolean z3;
            WindowInsetsCompat.Impl impl = windowInsetsCompat.mImpl;
            int i3 = impl.getSystemWindowInsets().top;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            appCompatDelegateImpl.getClass();
            int i4 = impl.getSystemWindowInsets().top;
            ActionBarContextView actionBarContextView = appCompatDelegateImpl.mActionModeView;
            if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                i = 0;
                i2 = 8;
                z = false;
            } else {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) appCompatDelegateImpl.mActionModeView.getLayoutParams();
                if (appCompatDelegateImpl.mActionModeView.isShown()) {
                    if (appCompatDelegateImpl.mTempRect1 == null) {
                        appCompatDelegateImpl.mTempRect1 = new Rect();
                        appCompatDelegateImpl.mTempRect2 = new Rect();
                    }
                    Rect rect = appCompatDelegateImpl.mTempRect1;
                    Rect rect2 = appCompatDelegateImpl.mTempRect2;
                    rect.set(impl.getSystemWindowInsets().left, impl.getSystemWindowInsets().top, impl.getSystemWindowInsets().right, impl.getSystemWindowInsets().bottom);
                    ViewGroup viewGroup = appCompatDelegateImpl.mSubDecor;
                    if (Build.VERSION.SDK_INT >= 29) {
                        boolean z4 = ViewUtils.sInitComputeFitSystemWindowsMethod;
                        ViewUtils.Api29Impl.computeFitSystemWindows(viewGroup, rect, rect2);
                    } else {
                        boolean z5 = ViewUtils.sInitComputeFitSystemWindowsMethod;
                        String str = mnwSv.XyQBKXrzqc;
                        if (!z5) {
                            ViewUtils.sInitComputeFitSystemWindowsMethod = true;
                            try {
                                Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
                                ViewUtils.sComputeFitSystemWindowsMethod = declaredMethod;
                                if (!declaredMethod.isAccessible()) {
                                    ViewUtils.sComputeFitSystemWindowsMethod.setAccessible(true);
                                }
                            } catch (NoSuchMethodException unused) {
                                Log.d(str, "Could not find method computeFitSystemWindows. Oh well.");
                            }
                        }
                        Method method = ViewUtils.sComputeFitSystemWindowsMethod;
                        if (method != null) {
                            try {
                                method.invoke(viewGroup, rect, rect2);
                            } catch (Exception e) {
                                Log.d(str, "Could not invoke computeFitSystemWindows", e);
                            }
                        }
                    }
                    int i5 = rect.top;
                    int i6 = rect.left;
                    int i7 = rect.right;
                    ViewGroup viewGroup2 = appCompatDelegateImpl.mSubDecor;
                    WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    WindowInsetsCompat rootWindowInsets = ViewCompat.Api23Impl.getRootWindowInsets(viewGroup2);
                    int i8 = rootWindowInsets == null ? 0 : rootWindowInsets.mImpl.getSystemWindowInsets().left;
                    int i9 = rootWindowInsets == null ? 0 : rootWindowInsets.mImpl.getSystemWindowInsets().right;
                    if (marginLayoutParams.topMargin == i5 && marginLayoutParams.leftMargin == i6 && marginLayoutParams.rightMargin == i7) {
                        z3 = false;
                    } else {
                        marginLayoutParams.topMargin = i5;
                        marginLayoutParams.leftMargin = i6;
                        marginLayoutParams.rightMargin = i7;
                        z3 = true;
                    }
                    Context context = appCompatDelegateImpl.mContext;
                    if (i5 <= 0 || appCompatDelegateImpl.mStatusGuard != null) {
                        i2 = 8;
                        View view2 = appCompatDelegateImpl.mStatusGuard;
                        if (view2 != null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                            int i10 = marginLayoutParams2.height;
                            int i11 = marginLayoutParams.topMargin;
                            if (i10 != i11 || marginLayoutParams2.leftMargin != i8 || marginLayoutParams2.rightMargin != i9) {
                                marginLayoutParams2.height = i11;
                                marginLayoutParams2.leftMargin = i8;
                                marginLayoutParams2.rightMargin = i9;
                                appCompatDelegateImpl.mStatusGuard.setLayoutParams(marginLayoutParams2);
                            }
                        }
                    } else {
                        View view3 = new View(context);
                        appCompatDelegateImpl.mStatusGuard = view3;
                        i2 = 8;
                        view3.setVisibility(8);
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                        layoutParams.leftMargin = i8;
                        layoutParams.rightMargin = i9;
                        appCompatDelegateImpl.mSubDecor.addView(appCompatDelegateImpl.mStatusGuard, -1, layoutParams);
                    }
                    View view4 = appCompatDelegateImpl.mStatusGuard;
                    boolean z6 = view4 != null;
                    if (z6 && view4.getVisibility() != 0) {
                        View view5 = appCompatDelegateImpl.mStatusGuard;
                        view5.setBackgroundColor((view5.getWindowSystemUiVisibility() & 8192) != 0 ? ContextCompat.getColor(context, com.daerisoft.thespikerm.R.color.abc_decor_view_status_guard_light) : ContextCompat.getColor(context, com.daerisoft.thespikerm.R.color.abc_decor_view_status_guard));
                    }
                    if (!appCompatDelegateImpl.mOverlayActionMode && z6) {
                        i4 = 0;
                    }
                    z = z6;
                    z2 = z3;
                    i = 0;
                } else {
                    i2 = 8;
                    i = 0;
                    if (marginLayoutParams.topMargin != 0) {
                        marginLayoutParams.topMargin = 0;
                        z = false;
                        z2 = true;
                    } else {
                        z2 = false;
                        z = false;
                    }
                }
                if (z2) {
                    appCompatDelegateImpl.mActionModeView.setLayoutParams(marginLayoutParams);
                }
            }
            View view6 = appCompatDelegateImpl.mStatusGuard;
            if (view6 != null) {
                view6.setVisibility(z ? i : i2);
            }
            if (i3 != i4) {
                int i12 = impl.getSystemWindowInsets().left;
                int i13 = impl.getSystemWindowInsets().right;
                int i14 = impl.getSystemWindowInsets().bottom;
                int i15 = Build.VERSION.SDK_INT;
                if (i15 >= 30) {
                    builderImpl29 = new WindowInsetsCompat.BuilderImpl30(windowInsetsCompat);
                } else {
                    builderImpl29 = i15 >= 29 ? new WindowInsetsCompat.BuilderImpl29(windowInsetsCompat) : new WindowInsetsCompat.BuilderImpl20(windowInsetsCompat);
                }
                builderImpl29.setSystemWindowInsets(Insets.of(i12, i4, i13, i14));
                windowInsetsCompatBuild = builderImpl29.build();
            } else {
                windowInsetsCompatBuild = windowInsetsCompat;
            }
            return ViewCompat.onApplyWindowInsets(view, windowInsetsCompatBuild);
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.AppCompatDelegateImpl$7, reason: invalid class name */
    /* JADX INFO: loaded from: classes.dex */
    public final class AnonymousClass7 extends MediaType.Companion {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object this$0;

        public /* synthetic */ AnonymousClass7(Object obj, int i) {
            this.$r8$classId = i;
            this.this$0 = obj;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public final void onAnimationEnd() {
            Object obj = this.this$0;
            switch (this.$r8$classId) {
                case 0:
                    AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) obj;
                    appCompatDelegateImpl.mActionModeView.setAlpha(1.0f);
                    appCompatDelegateImpl.mFadeAnim.setListener(null);
                    appCompatDelegateImpl.mFadeAnim = null;
                    break;
                case 1:
                    AnonymousClass2 anonymousClass2 = (AnonymousClass2) obj;
                    anonymousClass2.this$0.mActionModeView.setAlpha(1.0f);
                    AppCompatDelegateImpl appCompatDelegateImpl2 = anonymousClass2.this$0;
                    appCompatDelegateImpl2.mFadeAnim.setListener(null);
                    appCompatDelegateImpl2.mFadeAnim = null;
                    break;
                default:
                    RoomOpenHelper roomOpenHelper = (RoomOpenHelper) obj;
                    ((AppCompatDelegateImpl) roomOpenHelper.mDelegate).mActionModeView.setVisibility(8);
                    AppCompatDelegateImpl appCompatDelegateImpl3 = (AppCompatDelegateImpl) roomOpenHelper.mDelegate;
                    PopupWindow popupWindow = appCompatDelegateImpl3.mActionModePopup;
                    if (popupWindow != null) {
                        popupWindow.dismiss();
                    } else if (appCompatDelegateImpl3.mActionModeView.getParent() instanceof View) {
                        View view = (View) appCompatDelegateImpl3.mActionModeView.getParent();
                        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                        ViewCompat.Api20Impl.requestApplyInsets(view);
                    }
                    appCompatDelegateImpl3.mActionModeView.killMode();
                    appCompatDelegateImpl3.mFadeAnim.setListener(null);
                    appCompatDelegateImpl3.mFadeAnim = null;
                    ViewGroup viewGroup = appCompatDelegateImpl3.mSubDecor;
                    WeakHashMap weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                    ViewCompat.Api20Impl.requestApplyInsets(viewGroup);
                    break;
            }
        }

        @Override // okhttp3.MediaType.Companion, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart() {
            Object obj = this.this$0;
            switch (this.$r8$classId) {
                case 0:
                    AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) obj;
                    appCompatDelegateImpl.mActionModeView.setVisibility(0);
                    if (appCompatDelegateImpl.mActionModeView.getParent() instanceof View) {
                        View view = (View) appCompatDelegateImpl.mActionModeView.getParent();
                        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                        ViewCompat.Api20Impl.requestApplyInsets(view);
                    }
                    break;
                case 1:
                    ((AnonymousClass2) obj).this$0.mActionModeView.setVisibility(0);
                    break;
            }
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public abstract class Api21Impl {
        public static boolean isPowerSaveMode(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }

        public static String toLanguageTag(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public abstract class Api24Impl {
        public static void generateConfigDelta_locale(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (locales.equals(locales2)) {
                return;
            }
            configuration3.setLocales(locales2);
            configuration3.locale = configuration2.locale;
        }

        public static LocaleListCompat getLocales(Configuration configuration) {
            return LocaleListCompat.forLanguageTags(configuration.getLocales().toLanguageTags());
        }

        public static void setDefaultLocales(LocaleListCompat localeListCompat) {
            LocaleList.setDefault(LocaleList.forLanguageTags(localeListCompat.mImpl.toLanguageTags()));
        }

        public static void setLocales(Configuration configuration, LocaleListCompat localeListCompat) {
            configuration.setLocales(LocaleList.forLanguageTags(localeListCompat.mImpl.toLanguageTags()));
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public abstract class Api33Impl {
        public static OnBackInvokedDispatcher getOnBackInvokedDispatcher(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }

        public static OnBackInvokedCallback registerOnBackPressedCallback(Object obj, AppCompatDelegateImpl appCompatDelegateImpl) {
            Objects.requireNonNull(appCompatDelegateImpl);
            Toolbar$Api33Impl$$ExternalSyntheticLambda0 toolbar$Api33Impl$$ExternalSyntheticLambda0 = new Toolbar$Api33Impl$$ExternalSyntheticLambda0(appCompatDelegateImpl, 2);
            ComponentDialog$$ExternalSyntheticApiModelOutline0.m3m(obj).registerOnBackInvokedCallback(1000000, toolbar$Api33Impl$$ExternalSyntheticLambda0);
            return toolbar$Api33Impl$$ExternalSyntheticLambda0;
        }

        public static void unregisterOnBackInvokedCallback(Object obj, Object obj2) {
            ComponentDialog$$ExternalSyntheticApiModelOutline0.m3m(obj).unregisterOnBackInvokedCallback(ComponentDialog$$ExternalSyntheticApiModelOutline0.m2m(obj2));
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public final class AppCompatWindowCallback implements Window.Callback {
        public AccessTokenCache mActionBarCallback;
        public boolean mDispatchKeyEventBypassEnabled;
        public boolean mOnContentChangedBypassEnabled;
        public boolean mOnPanelClosedBypassEnabled;
        public final Window.Callback mWrapped;

        public AppCompatWindowCallback(Window.Callback callback) {
            if (callback == null) {
                throw new IllegalArgumentException("Window callback may not be null");
            }
            this.mWrapped = callback;
        }

        public final void bypassOnContentChanged(Window.Callback callback) {
            try {
                this.mOnContentChangedBypassEnabled = true;
                callback.onContentChanged();
            } finally {
                this.mOnContentChangedBypassEnabled = false;
            }
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
            return this.mWrapped.dispatchGenericMotionEvent(motionEvent);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            boolean z = this.mDispatchKeyEventBypassEnabled;
            Window.Callback callback = this.mWrapped;
            if (z) {
                return callback.dispatchKeyEvent(keyEvent);
            }
            return AppCompatDelegateImpl.this.dispatchKeyEvent(keyEvent) || callback.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            if (this.mWrapped.dispatchKeyShortcutEvent(keyEvent)) {
                return true;
            }
            int keyCode = keyEvent.getKeyCode();
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            appCompatDelegateImpl.initWindowDecorActionBar();
            ActionBar actionBar = appCompatDelegateImpl.mActionBar;
            if (actionBar != null && actionBar.onKeyShortcut(keyCode, keyEvent)) {
                return true;
            }
            PanelFeatureState panelFeatureState = appCompatDelegateImpl.mPreparedPanel;
            if (panelFeatureState != null && appCompatDelegateImpl.performPanelShortcut(panelFeatureState, keyEvent.getKeyCode(), keyEvent)) {
                PanelFeatureState panelFeatureState2 = appCompatDelegateImpl.mPreparedPanel;
                if (panelFeatureState2 == null) {
                    return true;
                }
                panelFeatureState2.isHandled = true;
                return true;
            }
            if (appCompatDelegateImpl.mPreparedPanel == null) {
                PanelFeatureState panelState = appCompatDelegateImpl.getPanelState(0);
                appCompatDelegateImpl.preparePanel(panelState, keyEvent);
                boolean zPerformPanelShortcut = appCompatDelegateImpl.performPanelShortcut(panelState, keyEvent.getKeyCode(), keyEvent);
                panelState.isPrepared = false;
                if (zPerformPanelShortcut) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            return this.mWrapped.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return this.mWrapped.dispatchTouchEvent(motionEvent);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
            return this.mWrapped.dispatchTrackballEvent(motionEvent);
        }

        @Override // android.view.Window.Callback
        public final void onActionModeFinished(android.view.ActionMode actionMode) {
            this.mWrapped.onActionModeFinished(actionMode);
        }

        @Override // android.view.Window.Callback
        public final void onActionModeStarted(android.view.ActionMode actionMode) {
            this.mWrapped.onActionModeStarted(actionMode);
        }

        @Override // android.view.Window.Callback
        public final void onAttachedToWindow() {
            this.mWrapped.onAttachedToWindow();
        }

        @Override // android.view.Window.Callback
        public final void onContentChanged() {
            if (this.mOnContentChangedBypassEnabled) {
                this.mWrapped.onContentChanged();
            }
        }

        @Override // android.view.Window.Callback
        public final boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof MenuBuilder)) {
                return this.mWrapped.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // android.view.Window.Callback
        public final View onCreatePanelView(int i) {
            AccessTokenCache accessTokenCache = this.mActionBarCallback;
            if (accessTokenCache != null) {
                View view = i == 0 ? new View(((ToolbarActionBar) accessTokenCache.sharedPreferences).mDecorToolbar.mToolbar.getContext()) : null;
                if (view != null) {
                    return view;
                }
            }
            return this.mWrapped.onCreatePanelView(i);
        }

        @Override // android.view.Window.Callback
        public final void onDetachedFromWindow() {
            this.mWrapped.onDetachedFromWindow();
        }

        @Override // android.view.Window.Callback
        public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
            return this.mWrapped.onMenuItemSelected(i, menuItem);
        }

        @Override // android.view.Window.Callback
        public final boolean onMenuOpened(int i, Menu menu) {
            onMenuOpened$androidx$appcompat$view$WindowCallbackWrapper(i, menu);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (i == 108) {
                appCompatDelegateImpl.initWindowDecorActionBar();
                ActionBar actionBar = appCompatDelegateImpl.mActionBar;
                if (actionBar != null) {
                    actionBar.dispatchMenuVisibilityChanged(true);
                }
            } else {
                appCompatDelegateImpl.getClass();
            }
            return true;
        }

        public final boolean onMenuOpened$androidx$appcompat$view$WindowCallbackWrapper(int i, Menu menu) {
            return this.mWrapped.onMenuOpened(i, menu);
        }

        @Override // android.view.Window.Callback
        public final void onPanelClosed(int i, Menu menu) {
            if (this.mOnPanelClosedBypassEnabled) {
                this.mWrapped.onPanelClosed(i, menu);
                return;
            }
            onPanelClosed$androidx$appcompat$view$WindowCallbackWrapper(i, menu);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (i == 108) {
                appCompatDelegateImpl.initWindowDecorActionBar();
                ActionBar actionBar = appCompatDelegateImpl.mActionBar;
                if (actionBar != null) {
                    actionBar.dispatchMenuVisibilityChanged(false);
                    return;
                }
                return;
            }
            if (i != 0) {
                appCompatDelegateImpl.getClass();
                return;
            }
            PanelFeatureState panelState = appCompatDelegateImpl.getPanelState(i);
            if (panelState.isOpen) {
                appCompatDelegateImpl.closePanel(panelState, false);
            }
        }

        public final void onPanelClosed$androidx$appcompat$view$WindowCallbackWrapper(int i, Menu menu) {
            this.mWrapped.onPanelClosed(i, menu);
        }

        @Override // android.view.Window.Callback
        public final void onPointerCaptureChanged(boolean z) {
            WindowCallbackWrapper$Api26Impl.onPointerCaptureChanged(this.mWrapped, z);
        }

        @Override // android.view.Window.Callback
        public final boolean onPreparePanel(int i, View view, Menu menu) {
            MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
            if (i == 0 && menuBuilder == null) {
                return false;
            }
            if (menuBuilder != null) {
                menuBuilder.mOverrideVisibleItems = true;
            }
            AccessTokenCache accessTokenCache = this.mActionBarCallback;
            if (accessTokenCache != null && i == 0) {
                ToolbarActionBar toolbarActionBar = (ToolbarActionBar) accessTokenCache.sharedPreferences;
                if (!toolbarActionBar.mToolbarMenuPrepared) {
                    toolbarActionBar.mDecorToolbar.mMenuPrepared = true;
                    toolbarActionBar.mToolbarMenuPrepared = true;
                }
            }
            boolean zOnPreparePanel = this.mWrapped.onPreparePanel(i, view, menu);
            if (menuBuilder != null) {
                menuBuilder.mOverrideVisibleItems = false;
            }
            return zOnPreparePanel;
        }

        @Override // android.view.Window.Callback
        public final void onProvideKeyboardShortcuts(List list, Menu menu, int i) {
            MenuBuilder menuBuilder = AppCompatDelegateImpl.this.getPanelState(0).menu;
            if (menuBuilder != null) {
                onProvideKeyboardShortcuts$androidx$appcompat$view$WindowCallbackWrapper(list, menuBuilder, i);
            } else {
                onProvideKeyboardShortcuts$androidx$appcompat$view$WindowCallbackWrapper(list, menu, i);
            }
        }

        public final void onProvideKeyboardShortcuts$androidx$appcompat$view$WindowCallbackWrapper(List list, Menu menu, int i) {
            WindowCallbackWrapper$Api24Impl.onProvideKeyboardShortcuts(this.mWrapped, list, menu, i);
        }

        @Override // android.view.Window.Callback
        public final boolean onSearchRequested(SearchEvent searchEvent) {
            return WindowCallbackWrapper$Api23Impl.onSearchRequested(this.mWrapped, searchEvent);
        }

        @Override // android.view.Window.Callback
        public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
            this.mWrapped.onWindowAttributesChanged(layoutParams);
        }

        @Override // android.view.Window.Callback
        public final void onWindowFocusChanged(boolean z) {
            this.mWrapped.onWindowFocusChanged(z);
        }

        @Override // android.view.Window.Callback
        public final android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback) {
            return null;
        }

        @Override // android.view.Window.Callback
        public final boolean onSearchRequested() {
            return this.mWrapped.onSearchRequested();
        }

        @Override // android.view.Window.Callback
        public final android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback, int i) {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            appCompatDelegateImpl.getClass();
            if (i != 0) {
                return WindowCallbackWrapper$Api23Impl.onWindowStartingActionMode(this.mWrapped, callback, i);
            }
            Context context = appCompatDelegateImpl.mContext;
            Dispatcher dispatcher = new Dispatcher();
            dispatcher.readyAsyncCalls = context;
            dispatcher.executorServiceOrNull = callback;
            dispatcher.runningAsyncCalls = new ArrayList();
            dispatcher.runningSyncCalls = new SimpleArrayMap();
            ActionMode actionModeStartSupportActionMode = appCompatDelegateImpl.startSupportActionMode(dispatcher);
            if (actionModeStartSupportActionMode != null) {
                return dispatcher.getActionModeWrapper(actionModeStartSupportActionMode);
            }
            return null;
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public final class ListMenuDecorView extends ContentFrameLayout {
        public ListMenuDecorView(ContextThemeWrapper contextThemeWrapper) {
            super(contextThemeWrapper, null);
        }

        @Override // android.view.ViewGroup, android.view.View
        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (x < -5 || y < -5 || x > getWidth() + 5 || y > getHeight() + 5) {
                    AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                    appCompatDelegateImpl.closePanel(appCompatDelegateImpl.getPanelState(0), true);
                    return true;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public final void setBackgroundResource(int i) {
            setBackgroundDrawable(Headers.Companion.getDrawable(getContext(), i));
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public final class PanelFeatureState {
        public int background;
        public View createdPanelView;
        public ListMenuDecorView decorView;
        public int featureId;
        public Bundle frozenActionViewState;
        public int gravity;
        public boolean isHandled;
        public boolean isOpen;
        public boolean isPrepared;
        public ListMenuPresenter listMenuPresenter;
        public ContextThemeWrapper listPresenterContext;
        public MenuBuilder menu;
        public boolean refreshDecorView;
        public boolean refreshMenuContent;
        public View shownPanelView;
        public int windowAnimations;
    }

    public AppCompatDelegateImpl(Context context, Window window, AppCompatCallback appCompatCallback, Object obj) {
        AppCompatActivity appCompatActivity;
        this.mLocalNightMode = -100;
        this.mContext = context;
        this.mAppCompatCallback = appCompatCallback;
        this.mHost = obj;
        if (obj instanceof Dialog) {
            while (true) {
                if (context != null) {
                    if (context instanceof AppCompatActivity) {
                        appCompatActivity = (AppCompatActivity) context;
                        break;
                    } else if (context instanceof ContextWrapper) {
                        context = ((ContextWrapper) context).getBaseContext();
                    }
                }
                appCompatActivity = null;
                break;
            }
            if (appCompatActivity != null) {
                this.mLocalNightMode = ((AppCompatDelegateImpl) appCompatActivity.getDelegate()).mLocalNightMode;
            }
        }
        if (this.mLocalNightMode == -100) {
            SimpleArrayMap simpleArrayMap = sLocalNightModes;
            Integer num = (Integer) simpleArrayMap.getOrDefault(this.mHost.getClass().getName(), null);
            if (num != null) {
                this.mLocalNightMode = num.intValue();
                simpleArrayMap.remove(this.mHost.getClass().getName());
            }
        }
        if (window != null) {
            attachToWindow(window);
        }
        AppCompatDrawableManager.preload();
    }

    public static LocaleListCompat calculateApplicationLocales(Context context) {
        LocaleListCompat localeListCompat;
        LocaleListCompat localeListCompatForLanguageTags;
        int i = Build.VERSION.SDK_INT;
        if (i >= 33 || (localeListCompat = AppCompatDelegate.sRequestedAppLocales) == null) {
            return null;
        }
        LocaleListCompat configurationLocales = getConfigurationLocales(context.getApplicationContext().getResources().getConfiguration());
        LocaleListInterface localeListInterface = localeListCompat.mImpl;
        int i2 = 0;
        if (i < 24) {
            localeListCompatForLanguageTags = localeListInterface.isEmpty() ? LocaleListCompat.sEmptyLocaleList : LocaleListCompat.forLanguageTags(Api21Impl.toLanguageTag(localeListInterface.get(0)));
        } else if (localeListInterface.isEmpty()) {
            localeListCompatForLanguageTags = LocaleListCompat.sEmptyLocaleList;
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (i2 < configurationLocales.mImpl.size() + localeListInterface.size()) {
                Locale locale = i2 < localeListInterface.size() ? localeListInterface.get(i2) : configurationLocales.mImpl.get(i2 - localeListInterface.size());
                if (locale != null) {
                    linkedHashSet.add(locale);
                }
                i2++;
            }
            localeListCompatForLanguageTags = LocaleListCompat.create((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
        }
        return localeListCompatForLanguageTags.mImpl.isEmpty() ? configurationLocales : localeListCompatForLanguageTags;
    }

    public static Configuration createOverrideAppConfiguration(Context context, int i, LocaleListCompat localeListCompat, Configuration configuration, boolean z) {
        int i2;
        if (i == 1) {
            i2 = 16;
        } else if (i != 2) {
            i2 = z ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        } else {
            i2 = 32;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i2 | (configuration2.uiMode & (-49));
        if (localeListCompat != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                Api24Impl.setLocales(configuration2, localeListCompat);
            } else {
                LocaleListInterface localeListInterface = localeListCompat.mImpl;
                configuration2.setLocale(localeListInterface.get(0));
                configuration2.setLayoutDirection(localeListInterface.get(0));
            }
        }
        return configuration2;
    }

    public static LocaleListCompat getConfigurationLocales(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? Api24Impl.getLocales(configuration) : LocaleListCompat.forLanguageTags(Api21Impl.toLanguageTag(configuration.locale));
    }

    /* JADX WARN: Code duplicated, block: B:72:0x0102  */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean applyApplicationSpecificConfig(boolean z, boolean z2) throws IllegalAccessException {
        int i;
        boolean z3;
        boolean z4;
        boolean z5;
        Object obj;
        Object obj2;
        Object obj3;
        int i2;
        if (this.mDestroyed) {
            return false;
        }
        int i3 = this.mLocalNightMode;
        if (i3 == -100) {
            i3 = AppCompatDelegate.sDefaultNightMode;
        }
        int i4 = i3;
        Context context = this.mContext;
        int iMapNightMode = mapNightMode(context, i4);
        int i5 = Build.VERSION.SDK_INT;
        LocaleListCompat localeListCompatCalculateApplicationLocales = i5 < 33 ? calculateApplicationLocales(context) : null;
        if (!z2 && localeListCompatCalculateApplicationLocales != null) {
            localeListCompatCalculateApplicationLocales = getConfigurationLocales(context.getResources().getConfiguration());
        }
        Configuration configurationCreateOverrideAppConfiguration = createOverrideAppConfiguration(context, iMapNightMode, localeListCompatCalculateApplicationLocales, null, false);
        boolean z6 = this.mActivityHandlesConfigFlagsChecked;
        Object obj4 = this.mHost;
        if (z6 || !(obj4 instanceof Activity)) {
            this.mActivityHandlesConfigFlagsChecked = true;
            i = this.mActivityHandlesConfigFlags;
        } else {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                i = 0;
            } else {
                if (i5 >= 29) {
                    i2 = 269221888;
                } else {
                    i2 = i5 >= 24 ? 786432 : 0;
                }
                try {
                    ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, obj4.getClass()), i2);
                    if (activityInfo != null) {
                        this.mActivityHandlesConfigFlags = activityInfo.configChanges;
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
                    this.mActivityHandlesConfigFlags = 0;
                }
                this.mActivityHandlesConfigFlagsChecked = true;
                i = this.mActivityHandlesConfigFlags;
            }
        }
        Configuration configuration = this.mEffectiveConfiguration;
        if (configuration == null) {
            configuration = context.getResources().getConfiguration();
        }
        int i6 = configuration.uiMode & 48;
        int i7 = configurationCreateOverrideAppConfiguration.uiMode & 48;
        LocaleListCompat configurationLocales = getConfigurationLocales(configuration);
        LocaleListCompat configurationLocales2 = localeListCompatCalculateApplicationLocales == null ? null : getConfigurationLocales(configurationCreateOverrideAppConfiguration);
        int i8 = i6 != i7 ? 512 : 0;
        if (configurationLocales2 != null && !configurationLocales.equals(configurationLocales2)) {
            i8 |= 8196;
        }
        if (((~i) & i8) != 0 && z && this.mBaseContextAttached && ((sCanReturnDifferentContext || this.mCreated) && (obj4 instanceof Activity))) {
            Activity activity = (Activity) obj4;
            if (activity.isChild()) {
                z3 = false;
            } else {
                int i9 = Build.VERSION.SDK_INT;
                if (i9 >= 31 && (i8 & 8192) != 0) {
                    activity.getWindow().getDecorView().setLayoutDirection(configurationCreateOverrideAppConfiguration.getLayoutDirection());
                }
                if (i9 >= 28) {
                    activity.recreate();
                } else {
                    new Handler(activity.getMainLooper()).post(new AccessTokenManager$$ExternalSyntheticLambda0(activity, 3));
                }
                z3 = true;
            }
        } else {
            z3 = false;
        }
        if (z3 || i8 == 0) {
            z4 = z3;
        } else {
            boolean z7 = (i & i8) == i8;
            Resources resources = context.getResources();
            Configuration configuration2 = new Configuration(resources.getConfiguration());
            configuration2.uiMode = (resources.getConfiguration().uiMode & (-49)) | i7;
            if (configurationLocales2 != null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    Api24Impl.setLocales(configuration2, configurationLocales2);
                } else {
                    LocaleListInterface localeListInterface = configurationLocales2.mImpl;
                    configuration2.setLocale(localeListInterface.get(0));
                    configuration2.setLayoutDirection(localeListInterface.get(0));
                }
            }
            resources.updateConfiguration(configuration2, null);
            int i10 = Build.VERSION.SDK_INT;
            if (i10 < 26 && i10 < 28) {
                if (i10 >= 24) {
                    if (!GamepadHandler_API19.sResourcesImplFieldFetched) {
                        try {
                            Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                            GamepadHandler_API19.sResourcesImplField = declaredField;
                            declaredField.setAccessible(true);
                        } catch (NoSuchFieldException e2) {
                            Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e2);
                        }
                        GamepadHandler_API19.sResourcesImplFieldFetched = true;
                    }
                    Field field = GamepadHandler_API19.sResourcesImplField;
                    if (field != null) {
                        try {
                            obj2 = field.get(resources);
                        } catch (IllegalAccessException e3) {
                            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e3);
                            obj2 = null;
                        }
                        if (obj2 != null) {
                            if (!GamepadHandler_API19.sDrawableCacheFieldFetched) {
                                try {
                                    Field declaredField2 = obj2.getClass().getDeclaredField("mDrawableCache");
                                    GamepadHandler_API19.sDrawableCacheField = declaredField2;
                                    declaredField2.setAccessible(true);
                                } catch (NoSuchFieldException e4) {
                                    Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e4);
                                }
                                GamepadHandler_API19.sDrawableCacheFieldFetched = true;
                            }
                            Field field2 = GamepadHandler_API19.sDrawableCacheField;
                            if (field2 != null) {
                                try {
                                    obj3 = field2.get(obj2);
                                } catch (IllegalAccessException e5) {
                                    Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e5);
                                    obj3 = null;
                                }
                            } else {
                                obj3 = null;
                            }
                            if (obj3 != null) {
                                GamepadHandler_API19.flushThemedResourcesCache(obj3);
                            }
                        }
                    }
                } else {
                    if (!GamepadHandler_API19.sDrawableCacheFieldFetched) {
                        try {
                            Field declaredField3 = Resources.class.getDeclaredField("mDrawableCache");
                            GamepadHandler_API19.sDrawableCacheField = declaredField3;
                            declaredField3.setAccessible(true);
                        } catch (NoSuchFieldException e6) {
                            Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e6);
                        }
                        GamepadHandler_API19.sDrawableCacheFieldFetched = true;
                    }
                    Field field3 = GamepadHandler_API19.sDrawableCacheField;
                    if (field3 != null) {
                        try {
                            obj = field3.get(resources);
                        } catch (IllegalAccessException e7) {
                            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e7);
                            obj = null;
                        }
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        GamepadHandler_API19.flushThemedResourcesCache(obj);
                    }
                }
            }
            int i11 = this.mThemeResId;
            if (i11 != 0) {
                context.setTheme(i11);
                z5 = true;
                context.getTheme().applyStyle(this.mThemeResId, true);
            } else {
                z5 = true;
            }
            if (z7 && (obj4 instanceof Activity)) {
                Activity activity2 = (Activity) obj4;
                if (activity2 instanceof LifecycleOwner) {
                    if (((LifecycleRegistry) ((LifecycleOwner) activity2).getLifecycle()).state.compareTo(Lifecycle.State.CREATED) >= 0) {
                        activity2.onConfigurationChanged(configuration2);
                    }
                } else if (this.mCreated && !this.mDestroyed) {
                    activity2.onConfigurationChanged(configuration2);
                }
            }
            z4 = z5;
        }
        if (z4 && (obj4 instanceof AppCompatActivity)) {
            if ((i8 & 512) != 0) {
                ((AppCompatActivity) obj4).onNightModeChanged(iMapNightMode);
            }
            if ((i8 & 4) != 0) {
                ((AppCompatActivity) obj4).onLocalesChanged(localeListCompatCalculateApplicationLocales);
            }
        }
        if (configurationLocales2 != null) {
            LocaleListCompat configurationLocales3 = getConfigurationLocales(context.getResources().getConfiguration());
            if (Build.VERSION.SDK_INT >= 24) {
                Api24Impl.setDefaultLocales(configurationLocales3);
            } else {
                Locale.setDefault(configurationLocales3.mImpl.get(0));
            }
        }
        if (i4 == 0) {
            getAutoTimeNightModeManager(context).setup();
        } else {
            AutoTimeNightModeManager autoTimeNightModeManager = this.mAutoTimeNightModeManager;
            if (autoTimeNightModeManager != null) {
                autoTimeNightModeManager.cleanup();
            }
        }
        if (i4 == 3) {
            if (this.mAutoBatteryNightModeManager == null) {
                this.mAutoBatteryNightModeManager = new AutoTimeNightModeManager(context);
            }
            this.mAutoBatteryNightModeManager.setup();
        } else {
            AutoTimeNightModeManager autoTimeNightModeManager2 = this.mAutoBatteryNightModeManager;
            if (autoTimeNightModeManager2 != null) {
                autoTimeNightModeManager2.cleanup();
            }
        }
        return z4;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0074  */
    public final void attachToWindow(Window window) {
        Drawable drawable;
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        OnBackInvokedCallback onBackInvokedCallback;
        int resourceId;
        if (this.mWindow != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof AppCompatWindowCallback) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        AppCompatWindowCallback appCompatWindowCallback = new AppCompatWindowCallback(callback);
        this.mAppCompatWindowCallback = appCompatWindowCallback;
        window.setCallback(appCompatWindowCallback);
        int[] iArr = sWindowBackgroundStyleable;
        Context context = this.mContext;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        if (!typedArrayObtainStyledAttributes.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0)) == 0) {
            drawable = null;
        } else {
            AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
            synchronized (appCompatDrawableManager) {
                drawable = appCompatDrawableManager.mResourceManager.getDrawable(context, resourceId, true);
            }
        }
        if (drawable != null) {
            window.setBackgroundDrawable(drawable);
        }
        typedArrayObtainStyledAttributes.recycle();
        this.mWindow = window;
        if (Build.VERSION.SDK_INT < 33 || (onBackInvokedDispatcher = this.mDispatcher) != null) {
            return;
        }
        if (onBackInvokedDispatcher != null && (onBackInvokedCallback = this.mBackCallback) != null) {
            Api33Impl.unregisterOnBackInvokedCallback(onBackInvokedDispatcher, onBackInvokedCallback);
            this.mBackCallback = null;
        }
        Object obj = this.mHost;
        if (obj instanceof Activity) {
            Activity activity = (Activity) obj;
            if (activity.getWindow() != null) {
                this.mDispatcher = Api33Impl.getOnBackInvokedDispatcher(activity);
            } else {
                this.mDispatcher = null;
            }
        } else {
            this.mDispatcher = null;
        }
        updateBackInvokedCallbackState();
    }

    public final void callOnPanelClosed(int i, PanelFeatureState panelFeatureState, MenuBuilder menuBuilder) {
        if (menuBuilder == null) {
            if (panelFeatureState == null && i >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.mPanels;
                if (i < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i];
                }
            }
            if (panelFeatureState != null) {
                menuBuilder = panelFeatureState.menu;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.isOpen) && !this.mDestroyed) {
            AppCompatWindowCallback appCompatWindowCallback = this.mAppCompatWindowCallback;
            Window.Callback callback = this.mWindow.getCallback();
            appCompatWindowCallback.getClass();
            try {
                appCompatWindowCallback.mOnPanelClosedBypassEnabled = true;
                callback.onPanelClosed(i, menuBuilder);
            } finally {
                appCompatWindowCallback.mOnPanelClosedBypassEnabled = false;
            }
        }
    }

    public final void checkCloseActionMenu(MenuBuilder menuBuilder) {
        ActionMenuPresenter actionMenuPresenter;
        if (this.mClosingActionMenu) {
            return;
        }
        this.mClosingActionMenu = true;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.mDecorContentParent;
        actionBarOverlayLayout.pullChildren();
        ActionMenuView actionMenuView = ((ToolbarWidgetWrapper) actionBarOverlayLayout.mDecorToolbar).mToolbar.mMenuView;
        if (actionMenuView != null && (actionMenuPresenter = actionMenuView.mPresenter) != null) {
            actionMenuPresenter.hideOverflowMenu();
            ActionMenuPresenter.OverflowPopup overflowPopup = actionMenuPresenter.mActionButtonPopup;
            if (overflowPopup != null && overflowPopup.isShowing()) {
                overflowPopup.mPopup.dismiss();
            }
        }
        Window.Callback callback = this.mWindow.getCallback();
        if (callback != null && !this.mDestroyed) {
            callback.onPanelClosed(TossType.TOSS_FIXED_MED_FOR_BEGINNER_VALUE, menuBuilder);
        }
        this.mClosingActionMenu = false;
    }

    public final void closePanel(PanelFeatureState panelFeatureState, boolean z) {
        ListMenuDecorView listMenuDecorView;
        DecorContentParent decorContentParent;
        if (z && panelFeatureState.featureId == 0 && (decorContentParent = this.mDecorContentParent) != null) {
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) decorContentParent;
            actionBarOverlayLayout.pullChildren();
            if (((ToolbarWidgetWrapper) actionBarOverlayLayout.mDecorToolbar).mToolbar.isOverflowMenuShowing()) {
                checkCloseActionMenu(panelFeatureState.menu);
                return;
            }
        }
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null && panelFeatureState.isOpen && (listMenuDecorView = panelFeatureState.decorView) != null) {
            windowManager.removeView(listMenuDecorView);
            if (z) {
                callOnPanelClosed(panelFeatureState.featureId, panelFeatureState, null);
            }
        }
        panelFeatureState.isPrepared = false;
        panelFeatureState.isHandled = false;
        panelFeatureState.isOpen = false;
        panelFeatureState.shownPanelView = null;
        panelFeatureState.refreshDecorView = true;
        if (this.mPreparedPanel == panelFeatureState) {
            this.mPreparedPanel = null;
        }
        if (panelFeatureState.featureId == 0) {
            updateBackInvokedCallbackState();
        }
    }

    /* JADX WARN: Code duplicated, block: B:67:0x00f2  */
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView;
        boolean z;
        boolean zShowOverflowMenu;
        boolean zPreparePanel;
        ActionMenuView actionMenuView;
        ActionMenuPresenter actionMenuPresenter;
        Object obj = this.mHost;
        if (((obj instanceof KeyEventDispatcher$Component) || (obj instanceof AlertDialog)) && (decorView = this.mWindow.getDecorView()) != null && Headers.Companion.dispatchBeforeHierarchy(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82) {
            AppCompatWindowCallback appCompatWindowCallback = this.mAppCompatWindowCallback;
            Window.Callback callback = this.mWindow.getCallback();
            appCompatWindowCallback.getClass();
            try {
                appCompatWindowCallback.mDispatchKeyEventBypassEnabled = true;
                boolean zDispatchKeyEvent = callback.dispatchKeyEvent(keyEvent);
                appCompatWindowCallback.mDispatchKeyEventBypassEnabled = false;
                if (zDispatchKeyEvent) {
                    return true;
                }
            } catch (Throwable th) {
                appCompatWindowCallback.mDispatchKeyEventBypassEnabled = false;
                throw th;
            }
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() == 0) {
            if (keyCode == 4) {
                this.mLongPressBackDown = (keyEvent.getFlags() & 128) != 0;
            } else if (keyCode == 82) {
                if (keyEvent.getRepeatCount() != 0) {
                    return true;
                }
                PanelFeatureState panelState = getPanelState(0);
                if (panelState.isOpen) {
                    return true;
                }
                preparePanel(panelState, keyEvent);
                return true;
            }
        } else if (keyCode != 4) {
            if (keyCode == 82) {
                if (this.mActionMode != null) {
                    return true;
                }
                PanelFeatureState panelState2 = getPanelState(0);
                DecorContentParent decorContentParent = this.mDecorContentParent;
                Context context = this.mContext;
                if (decorContentParent != null) {
                    ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) decorContentParent;
                    actionBarOverlayLayout.pullChildren();
                    Toolbar toolbar = ((ToolbarWidgetWrapper) actionBarOverlayLayout.mDecorToolbar).mToolbar;
                    if (toolbar.getVisibility() != 0 || (actionMenuView = toolbar.mMenuView) == null || !actionMenuView.mReserveOverflow || ViewConfiguration.get(context).hasPermanentMenuKey()) {
                        z = panelState2.isOpen;
                        if (!z || panelState2.isHandled) {
                            closePanel(panelState2, true);
                            zShowOverflowMenu = z;
                        } else {
                            if (panelState2.isPrepared) {
                                if (panelState2.refreshMenuContent) {
                                    panelState2.isPrepared = false;
                                    zPreparePanel = preparePanel(panelState2, keyEvent);
                                } else {
                                    zPreparePanel = true;
                                }
                                if (zPreparePanel) {
                                    openPanel(panelState2, keyEvent);
                                    zShowOverflowMenu = true;
                                }
                            }
                            zShowOverflowMenu = false;
                        }
                    } else {
                        ActionBarOverlayLayout actionBarOverlayLayout2 = (ActionBarOverlayLayout) this.mDecorContentParent;
                        actionBarOverlayLayout2.pullChildren();
                        if (((ToolbarWidgetWrapper) actionBarOverlayLayout2.mDecorToolbar).mToolbar.isOverflowMenuShowing()) {
                            ActionBarOverlayLayout actionBarOverlayLayout3 = (ActionBarOverlayLayout) this.mDecorContentParent;
                            actionBarOverlayLayout3.pullChildren();
                            ActionMenuView actionMenuView2 = ((ToolbarWidgetWrapper) actionBarOverlayLayout3.mDecorToolbar).mToolbar.mMenuView;
                            if (actionMenuView2 != null && (actionMenuPresenter = actionMenuView2.mPresenter) != null && actionMenuPresenter.hideOverflowMenu()) {
                                zShowOverflowMenu = true;
                            }
                        } else if (!this.mDestroyed && preparePanel(panelState2, keyEvent)) {
                            ActionBarOverlayLayout actionBarOverlayLayout4 = (ActionBarOverlayLayout) this.mDecorContentParent;
                            actionBarOverlayLayout4.pullChildren();
                            zShowOverflowMenu = ((ToolbarWidgetWrapper) actionBarOverlayLayout4.mDecorToolbar).mToolbar.showOverflowMenu();
                        }
                        zShowOverflowMenu = false;
                    }
                } else {
                    z = panelState2.isOpen;
                    if (z) {
                    }
                    closePanel(panelState2, true);
                    zShowOverflowMenu = z;
                }
                if (!zShowOverflowMenu) {
                    return true;
                }
                AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService("audio");
                if (audioManager != null) {
                    audioManager.playSoundEffect(0);
                    return true;
                }
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
                return true;
            }
        } else if (onBackPressed()) {
            return true;
        }
        return false;
    }

    public final void doInvalidatePanelMenu(int i) {
        PanelFeatureState panelState = getPanelState(i);
        if (panelState.menu != null) {
            Bundle bundle = new Bundle();
            panelState.menu.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                panelState.frozenActionViewState = bundle;
            }
            panelState.menu.stopDispatchingItemsChanged();
            panelState.menu.clear();
        }
        panelState.refreshMenuContent = true;
        panelState.refreshDecorView = true;
        if ((i == 108 || i == 0) && this.mDecorContentParent != null) {
            PanelFeatureState panelState2 = getPanelState(0);
            panelState2.isPrepared = false;
            preparePanel(panelState2, null);
        }
    }

    public final void ensureSubDecor() {
        ViewGroup viewGroup;
        if (this.mSubDecorInstalled) {
            return;
        }
        int[] iArr = R$styleable.AppCompatTheme;
        Context context = this.mContext;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        if (!typedArrayObtainStyledAttributes.hasValue(117)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException(YcVWhnLsj.KtLziJuL);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(126, false)) {
            requestWindowFeature(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(117, false)) {
            requestWindowFeature(TossType.TOSS_FIXED_MED_FOR_BEGINNER_VALUE);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(118, false)) {
            requestWindowFeature(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(119, false)) {
            requestWindowFeature(10);
        }
        this.mIsFloating = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        ensureWindow();
        this.mWindow.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        if (this.mWindowNoTitle) {
            viewGroup = this.mOverlayActionMode ? (ViewGroup) layoutInflaterFrom.inflate(com.daerisoft.thespikerm.R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(com.daerisoft.thespikerm.R.layout.abc_screen_simple, (ViewGroup) null);
        } else if (this.mIsFloating) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(com.daerisoft.thespikerm.R.layout.abc_dialog_title_material, (ViewGroup) null);
            this.mOverlayActionBar = false;
            this.mHasActionBar = false;
        } else if (this.mHasActionBar) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(com.daerisoft.thespikerm.R.attr.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new ContextThemeWrapper(context, typedValue.resourceId) : context).inflate(com.daerisoft.thespikerm.R.layout.abc_screen_toolbar, (ViewGroup) null);
            DecorContentParent decorContentParent = (DecorContentParent) viewGroup.findViewById(com.daerisoft.thespikerm.R.id.decor_content_parent);
            this.mDecorContentParent = decorContentParent;
            decorContentParent.setWindowCallback(this.mWindow.getCallback());
            if (this.mOverlayActionBar) {
                ((ActionBarOverlayLayout) this.mDecorContentParent).initFeature(109);
            }
            if (this.mFeatureProgress) {
                ((ActionBarOverlayLayout) this.mDecorContentParent).initFeature(2);
            }
            if (this.mFeatureIndeterminateProgress) {
                ((ActionBarOverlayLayout) this.mDecorContentParent).initFeature(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.mHasActionBar + ", windowActionBarOverlay: " + this.mOverlayActionBar + ", android:windowIsFloating: " + this.mIsFloating + ", windowActionModeOverlay: " + this.mOverlayActionMode + ", windowNoTitle: " + this.mWindowNoTitle + " }");
        }
        AnonymousClass3 anonymousClass3 = new AnonymousClass3();
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(viewGroup, anonymousClass3);
        if (this.mDecorContentParent == null) {
            this.mTitleView = (TextView) viewGroup.findViewById(com.daerisoft.thespikerm.R.id.title);
        }
        boolean z = ViewUtils.sInitComputeFitSystemWindowsMethod;
        String str = UUFMQdNK.WntauMtTIyZhcs;
        try {
            Method method = viewGroup.getClass().getMethod("makeOptionalFitsSystemWindows", null);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(viewGroup, null);
        } catch (IllegalAccessException e) {
            Log.d(str, "Could not invoke makeOptionalFitsSystemWindows", e);
        } catch (NoSuchMethodException unused) {
            Log.d(str, "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        } catch (InvocationTargetException e2) {
            Log.d(str, "Could not invoke makeOptionalFitsSystemWindows", e2);
        }
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(com.daerisoft.thespikerm.R.id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.mWindow.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.mWindow.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new Fragment.AnonymousClass7(this, 2));
        this.mSubDecor = viewGroup;
        Object obj = this.mHost;
        CharSequence title = obj instanceof Activity ? ((Activity) obj).getTitle() : this.mTitle;
        if (!TextUtils.isEmpty(title)) {
            DecorContentParent decorContentParent2 = this.mDecorContentParent;
            if (decorContentParent2 != null) {
                decorContentParent2.setWindowTitle(title);
            } else {
                ActionBar actionBar = this.mActionBar;
                if (actionBar != null) {
                    actionBar.setWindowTitle(title);
                } else {
                    TextView textView = this.mTitleView;
                    if (textView != null) {
                        textView.setText(title);
                    }
                }
            }
        }
        ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.mSubDecor.findViewById(R.id.content);
        View decorView = this.mWindow.getDecorView();
        contentFrameLayout2.mDecorPadding.set(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        if (contentFrameLayout2.isLaidOut()) {
            contentFrameLayout2.requestLayout();
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(iArr);
        typedArrayObtainStyledAttributes2.getValue(124, contentFrameLayout2.getMinWidthMajor());
        typedArrayObtainStyledAttributes2.getValue(125, contentFrameLayout2.getMinWidthMinor());
        if (typedArrayObtainStyledAttributes2.hasValue(122)) {
            typedArrayObtainStyledAttributes2.getValue(122, contentFrameLayout2.getFixedWidthMajor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(123)) {
            typedArrayObtainStyledAttributes2.getValue(123, contentFrameLayout2.getFixedWidthMinor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(120)) {
            typedArrayObtainStyledAttributes2.getValue(120, contentFrameLayout2.getFixedHeightMajor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(121)) {
            typedArrayObtainStyledAttributes2.getValue(121, contentFrameLayout2.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes2.recycle();
        contentFrameLayout2.requestLayout();
        this.mSubDecorInstalled = true;
        PanelFeatureState panelState = getPanelState(0);
        if (this.mDestroyed || panelState.menu != null) {
            return;
        }
        invalidatePanelMenu(TossType.TOSS_FIXED_MED_FOR_BEGINNER_VALUE);
    }

    public final void ensureWindow() {
        if (this.mWindow == null) {
            Object obj = this.mHost;
            if (obj instanceof Activity) {
                attachToWindow(((Activity) obj).getWindow());
            }
        }
        if (this.mWindow == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public final BaseMenuWrapper getAutoTimeNightModeManager(Context context) {
        if (this.mAutoTimeNightModeManager == null) {
            if (zzaa.sInstance == null) {
                Context applicationContext = context.getApplicationContext();
                zzaa.sInstance = new zzaa(applicationContext, (LocationManager) applicationContext.getSystemService(FirebaseAnalytics.Param.LOCATION));
            }
            this.mAutoTimeNightModeManager = new AutoTimeNightModeManager(zzaa.sInstance);
        }
        return this.mAutoTimeNightModeManager;
    }

    public final PanelFeatureState getPanelState(int i) {
        PanelFeatureState[] panelFeatureStateArr = this.mPanels;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[i + 1];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.mPanels = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState();
        panelFeatureState2.featureId = i;
        panelFeatureState2.refreshDecorView = false;
        panelFeatureStateArr[i] = panelFeatureState2;
        return panelFeatureState2;
    }

    public final void initWindowDecorActionBar() {
        ensureSubDecor();
        if (this.mHasActionBar && this.mActionBar == null) {
            Object obj = this.mHost;
            if (obj instanceof Activity) {
                this.mActionBar = new WindowDecorActionBar(this.mOverlayActionBar, (Activity) obj);
            } else if (obj instanceof Dialog) {
                this.mActionBar = new WindowDecorActionBar((Dialog) obj);
            }
            ActionBar actionBar = this.mActionBar;
            if (actionBar != null) {
                actionBar.setDefaultDisplayHomeAsUpEnabled(this.mEnableDefaultActionBarUp);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void installViewFactory() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.mContext);
        if (layoutInflaterFrom.getFactory() == null) {
            layoutInflaterFrom.setFactory2(this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof AppCompatDelegateImpl) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void invalidateOptionsMenu() {
        if (this.mActionBar != null) {
            initWindowDecorActionBar();
            if (this.mActionBar.invalidateOptionsMenu()) {
                return;
            }
            invalidatePanelMenu(0);
        }
    }

    public final void invalidatePanelMenu(int i) {
        this.mInvalidatePanelMenuFeatures = (1 << i) | this.mInvalidatePanelMenuFeatures;
        if (this.mInvalidatePanelMenuPosted) {
            return;
        }
        View decorView = this.mWindow.getDecorView();
        AnonymousClass2 anonymousClass2 = this.mInvalidatePanelMenuRunnable;
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        decorView.postOnAnimation(anonymousClass2);
        this.mInvalidatePanelMenuPosted = true;
    }

    public final int mapNightMode(Context context, int i) {
        if (i == -100) {
            return -1;
        }
        if (i != -1) {
            if (i == 0) {
                if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                    return -1;
                }
                return getAutoTimeNightModeManager(context).getApplyableNightMode();
            }
            if (i != 1 && i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                }
                if (this.mAutoBatteryNightModeManager == null) {
                    this.mAutoBatteryNightModeManager = new AutoTimeNightModeManager(context);
                }
                return this.mAutoBatteryNightModeManager.getApplyableNightMode();
            }
        }
        return i;
    }

    public final boolean onBackPressed() {
        boolean z = this.mLongPressBackDown;
        this.mLongPressBackDown = false;
        PanelFeatureState panelState = getPanelState(0);
        if (panelState.isOpen) {
            if (!z) {
                closePanel(panelState, true);
            }
            return true;
        }
        ActionMode actionMode = this.mActionMode;
        if (actionMode != null) {
            actionMode.finish();
            return true;
        }
        initWindowDecorActionBar();
        ActionBar actionBar = this.mActionBar;
        return actionBar != null && actionBar.collapseActionView();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void onCreate() throws IllegalAccessException {
        String parentActivityName;
        this.mBaseContextAttached = true;
        applyApplicationSpecificConfig(false, true);
        ensureWindow();
        Object obj = this.mHost;
        if (obj instanceof Activity) {
            try {
                Activity activity = (Activity) obj;
                try {
                    parentActivityName = NavUtils.getParentActivityName(activity, activity.getComponentName());
                } catch (PackageManager.NameNotFoundException e) {
                    throw new IllegalArgumentException(e);
                }
            } catch (IllegalArgumentException unused) {
                parentActivityName = null;
            }
            if (parentActivityName != null) {
                ActionBar actionBar = this.mActionBar;
                if (actionBar == null) {
                    this.mEnableDefaultActionBarUp = true;
                } else {
                    actionBar.setDefaultDisplayHomeAsUpEnabled(true);
                }
            }
            synchronized (AppCompatDelegate.sActivityDelegatesLock) {
                AppCompatDelegate.removeDelegateFromActives(this);
                AppCompatDelegate.sActivityDelegates.add(new WeakReference(this));
            }
        }
        this.mEffectiveConfiguration = new Configuration(this.mContext.getResources().getConfiguration());
        this.mCreated = true;
    }

    /* JADX WARN: Failed to calculate best type for var: r0v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v1 ??, new type: androidx.appcompat.app.AppCompatViewInflater
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v1 ??, new type: androidx.appcompat.app.AppCompatViewInflater
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v7 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v7 ??, new type: android.content.res.TypedArray
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v9 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v9 ??, new type: android.content.res.TypedArray
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r10v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r10v4 ??, new type: android.content.Context
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r20v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r20v0 ??, new type: android.content.Context
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to set immutable type for var: r20v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r20v0 ??, new type: android.content.Context
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$0(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r10v3 ??, new type: android.content.Context
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderAllow(TypeUpdate.java:66)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryWiderObjects(FixTypesVisitor.java:795)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:249)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException
        */
    @Override // android.view.LayoutInflater.Factory2
    public final android.view.View onCreateView(android.view.View r18, java.lang.String r19, android.content.Context r20, android.util.AttributeSet r21) {
        /*
            Method dump skipped, instruction units count: 750
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.onCreateView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    /* JADX WARN: Code duplicated, block: B:22:0x004d  */
    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void onDestroy() {
        if (this.mHost instanceof Activity) {
            synchronized (AppCompatDelegate.sActivityDelegatesLock) {
                AppCompatDelegate.removeDelegateFromActives(this);
            }
        }
        if (this.mInvalidatePanelMenuPosted) {
            this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
        }
        this.mDestroyed = true;
        if (this.mLocalNightMode != -100) {
            Object obj = this.mHost;
            if ((obj instanceof Activity) && ((Activity) obj).isChangingConfigurations()) {
                sLocalNightModes.put(this.mHost.getClass().getName(), Integer.valueOf(this.mLocalNightMode));
            } else {
                sLocalNightModes.remove(this.mHost.getClass().getName());
            }
        } else {
            sLocalNightModes.remove(this.mHost.getClass().getName());
        }
        ActionBar actionBar = this.mActionBar;
        if (actionBar != null) {
            actionBar.onDestroy();
        }
        AutoTimeNightModeManager autoTimeNightModeManager = this.mAutoTimeNightModeManager;
        if (autoTimeNightModeManager != null) {
            autoTimeNightModeManager.cleanup();
        }
        AutoTimeNightModeManager autoTimeNightModeManager2 = this.mAutoBatteryNightModeManager;
        if (autoTimeNightModeManager2 != null) {
            autoTimeNightModeManager2.cleanup();
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x002a  */
    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public final boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        PanelFeatureState panelFeatureState;
        Window.Callback callback = this.mWindow.getCallback();
        if (callback != null && !this.mDestroyed) {
            MenuBuilder rootMenu = menuBuilder.getRootMenu();
            PanelFeatureState[] panelFeatureStateArr = this.mPanels;
            int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
            for (int i = 0; i < length; i++) {
                panelFeatureState = panelFeatureStateArr[i];
                if (panelFeatureState != null && panelFeatureState.menu == rootMenu) {
                    if (panelFeatureState != null) {
                        return callback.onMenuItemSelected(panelFeatureState.featureId, menuItem);
                    }
                }
            }
            panelFeatureState = null;
            if (panelFeatureState != null) {
                return callback.onMenuItemSelected(panelFeatureState.featureId, menuItem);
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0048, code lost:
    
        if (r6.isOverflowMenuShowing() != false) goto L20;
     */
    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onMenuModeChange(androidx.appcompat.view.menu.MenuBuilder r6) {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.onMenuModeChange(androidx.appcompat.view.menu.MenuBuilder):void");
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0172, code lost:
    
        if (r3.mAdapter.getCount() > 0) goto L88;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void openPanel(androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState r18, android.view.KeyEvent r19) {
        /*
            Method dump skipped, instruction units count: 471
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.openPanel(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, android.view.KeyEvent):void");
    }

    public final boolean performPanelShortcut(PanelFeatureState panelFeatureState, int i, KeyEvent keyEvent) {
        MenuBuilder menuBuilder;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.isPrepared || preparePanel(panelFeatureState, keyEvent)) && (menuBuilder = panelFeatureState.menu) != null) {
            return menuBuilder.performShortcut(i, keyEvent, 1);
        }
        return false;
    }

    public final boolean preparePanel(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        DecorContentParent decorContentParent;
        DecorContentParent decorContentParent2;
        Resources.Theme themeNewTheme;
        DecorContentParent decorContentParent3;
        DecorContentParent decorContentParent4;
        if (this.mDestroyed) {
            return false;
        }
        if (panelFeatureState.isPrepared) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.mPreparedPanel;
        if (panelFeatureState2 != null && panelFeatureState2 != panelFeatureState) {
            closePanel(panelFeatureState2, false);
        }
        Window.Callback callback = this.mWindow.getCallback();
        int i = panelFeatureState.featureId;
        if (callback != null) {
            panelFeatureState.createdPanelView = callback.onCreatePanelView(i);
        }
        boolean z = i == 0 || i == 108;
        if (z && (decorContentParent4 = this.mDecorContentParent) != null) {
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) decorContentParent4;
            actionBarOverlayLayout.pullChildren();
            ((ToolbarWidgetWrapper) actionBarOverlayLayout.mDecorToolbar).mMenuPrepared = true;
        }
        if (panelFeatureState.createdPanelView == null && (!z || !(this.mActionBar instanceof ToolbarActionBar))) {
            MenuBuilder menuBuilder = panelFeatureState.menu;
            if (menuBuilder == null || panelFeatureState.refreshMenuContent) {
                if (menuBuilder == null) {
                    Context context = this.mContext;
                    if ((i == 0 || i == 108) && this.mDecorContentParent != null) {
                        TypedValue typedValue = new TypedValue();
                        Resources.Theme theme = context.getTheme();
                        theme.resolveAttribute(com.daerisoft.thespikerm.R.attr.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            themeNewTheme = context.getResources().newTheme();
                            themeNewTheme.setTo(theme);
                            themeNewTheme.applyStyle(typedValue.resourceId, true);
                            themeNewTheme.resolveAttribute(com.daerisoft.thespikerm.R.attr.actionBarWidgetTheme, typedValue, true);
                        } else {
                            theme.resolveAttribute(com.daerisoft.thespikerm.R.attr.actionBarWidgetTheme, typedValue, true);
                            themeNewTheme = null;
                        }
                        if (typedValue.resourceId != 0) {
                            if (themeNewTheme == null) {
                                themeNewTheme = context.getResources().newTheme();
                                themeNewTheme.setTo(theme);
                            }
                            themeNewTheme.applyStyle(typedValue.resourceId, true);
                        }
                        if (themeNewTheme != null) {
                            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
                            contextThemeWrapper.getTheme().setTo(themeNewTheme);
                            context = contextThemeWrapper;
                        }
                    }
                    MenuBuilder menuBuilder2 = new MenuBuilder(context);
                    menuBuilder2.mCallback = this;
                    MenuBuilder menuBuilder3 = panelFeatureState.menu;
                    if (menuBuilder2 != menuBuilder3) {
                        if (menuBuilder3 != null) {
                            menuBuilder3.removeMenuPresenter(panelFeatureState.listMenuPresenter);
                        }
                        panelFeatureState.menu = menuBuilder2;
                        ListMenuPresenter listMenuPresenter = panelFeatureState.listMenuPresenter;
                        if (listMenuPresenter != null) {
                            menuBuilder2.addMenuPresenter(listMenuPresenter, menuBuilder2.mContext);
                        }
                    }
                    if (panelFeatureState.menu == null) {
                        return false;
                    }
                }
                if (z && (decorContentParent2 = this.mDecorContentParent) != null) {
                    if (this.mActionMenuPresenterCallback == null) {
                        this.mActionMenuPresenterCallback = new ProfileCache(this, 2);
                    }
                    ((ActionBarOverlayLayout) decorContentParent2).setMenu(panelFeatureState.menu, this.mActionMenuPresenterCallback);
                }
                panelFeatureState.menu.stopDispatchingItemsChanged();
                if (!callback.onCreatePanelMenu(i, panelFeatureState.menu)) {
                    MenuBuilder menuBuilder4 = panelFeatureState.menu;
                    if (menuBuilder4 != null) {
                        if (menuBuilder4 != null) {
                            menuBuilder4.removeMenuPresenter(panelFeatureState.listMenuPresenter);
                        }
                        panelFeatureState.menu = null;
                    }
                    if (z && (decorContentParent = this.mDecorContentParent) != null) {
                        ((ActionBarOverlayLayout) decorContentParent).setMenu(null, this.mActionMenuPresenterCallback);
                    }
                    return false;
                }
                panelFeatureState.refreshMenuContent = false;
            }
            panelFeatureState.menu.stopDispatchingItemsChanged();
            Bundle bundle = panelFeatureState.frozenActionViewState;
            if (bundle != null) {
                panelFeatureState.menu.restoreActionViewStates(bundle);
                panelFeatureState.frozenActionViewState = null;
            }
            if (!callback.onPreparePanel(0, panelFeatureState.createdPanelView, panelFeatureState.menu)) {
                if (z && (decorContentParent3 = this.mDecorContentParent) != null) {
                    ((ActionBarOverlayLayout) decorContentParent3).setMenu(null, this.mActionMenuPresenterCallback);
                }
                panelFeatureState.menu.startDispatchingItemsChanged();
                return false;
            }
            panelFeatureState.menu.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
            panelFeatureState.menu.startDispatchingItemsChanged();
        }
        panelFeatureState.isPrepared = true;
        panelFeatureState.isHandled = false;
        this.mPreparedPanel = panelFeatureState;
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final boolean requestWindowFeature(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i = 108;
        } else if (i == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i = 109;
        }
        if (this.mWindowNoTitle && i == 108) {
            return false;
        }
        if (this.mHasActionBar && i == 1) {
            this.mHasActionBar = false;
        }
        if (i == 1) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mWindowNoTitle = true;
            return true;
        }
        if (i == 2) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mFeatureProgress = true;
            return true;
        }
        if (i == 5) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mFeatureIndeterminateProgress = true;
            return true;
        }
        if (i == 10) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mOverlayActionMode = true;
            return true;
        }
        if (i == 108) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mHasActionBar = true;
            return true;
        }
        if (i != 109) {
            return this.mWindow.requestFeature(i);
        }
        throwFeatureRequestIfSubDecorInstalled();
        this.mOverlayActionBar = true;
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setContentView(View view) {
        ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup) this.mSubDecor.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.mWindow.getCallback());
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        DecorContentParent decorContentParent = this.mDecorContentParent;
        if (decorContentParent != null) {
            decorContentParent.setWindowTitle(charSequence);
            return;
        }
        ActionBar actionBar = this.mActionBar;
        if (actionBar != null) {
            actionBar.setWindowTitle(charSequence);
            return;
        }
        TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [androidx.appcompat.app.AppCompatCallback, java.lang.Object] */
    @Override // androidx.appcompat.app.AppCompatDelegate
    public final ActionMode startSupportActionMode(ActionMode.Callback callback) {
        ActionMode actionModeOnWindowStartingSupportActionMode;
        ViewGroup viewGroup;
        int i = 0;
        int i2 = 1;
        if (callback == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        ActionMode actionMode = this.mActionMode;
        if (actionMode != null) {
            actionMode.finish();
        }
        RoomOpenHelper roomOpenHelper = new RoomOpenHelper(this, callback, 1);
        initWindowDecorActionBar();
        ActionBar actionBar = this.mActionBar;
        ?? r3 = this.mAppCompatCallback;
        if (actionBar != null) {
            ActionMode actionModeStartActionMode = actionBar.startActionMode(roomOpenHelper);
            this.mActionMode = actionModeStartActionMode;
            if (actionModeStartActionMode != null) {
                r3.onSupportActionModeStarted(actionModeStartActionMode);
            }
        }
        if (this.mActionMode == null) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mFadeAnim;
            if (viewPropertyAnimatorCompat != null) {
                viewPropertyAnimatorCompat.cancel();
            }
            ActionMode actionMode2 = this.mActionMode;
            if (actionMode2 != null) {
                actionMode2.finish();
            }
            if (this.mDestroyed) {
                actionModeOnWindowStartingSupportActionMode = null;
            } else {
                try {
                    actionModeOnWindowStartingSupportActionMode = r3.onWindowStartingSupportActionMode(roomOpenHelper);
                } catch (AbstractMethodError unused) {
                    actionModeOnWindowStartingSupportActionMode = null;
                }
            }
            if (actionModeOnWindowStartingSupportActionMode != null) {
                this.mActionMode = actionModeOnWindowStartingSupportActionMode;
            } else {
                if (this.mActionModeView == null) {
                    boolean z = this.mIsFloating;
                    Context context = this.mContext;
                    if (z) {
                        TypedValue typedValue = new TypedValue();
                        Resources.Theme theme = context.getTheme();
                        theme.resolveAttribute(com.daerisoft.thespikerm.R.attr.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            Resources.Theme themeNewTheme = context.getResources().newTheme();
                            themeNewTheme.setTo(theme);
                            themeNewTheme.applyStyle(typedValue.resourceId, true);
                            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
                            contextThemeWrapper.getTheme().setTo(themeNewTheme);
                            context = contextThemeWrapper;
                        }
                        this.mActionModeView = new ActionBarContextView(context, null);
                        PopupWindow popupWindow = new PopupWindow(context, (AttributeSet) null, com.daerisoft.thespikerm.R.attr.actionModePopupWindowStyle);
                        this.mActionModePopup = popupWindow;
                        PopupWindowCompat$Api23Impl.setWindowLayoutType(popupWindow, 2);
                        this.mActionModePopup.setContentView(this.mActionModeView);
                        this.mActionModePopup.setWidth(-1);
                        context.getTheme().resolveAttribute(com.daerisoft.thespikerm.R.attr.actionBarSize, typedValue, true);
                        this.mActionModeView.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics()));
                        this.mActionModePopup.setHeight(-2);
                        this.mShowActionModePopup = new AnonymousClass2(this, i2);
                    } else {
                        ViewStubCompat viewStubCompat = (ViewStubCompat) this.mSubDecor.findViewById(com.daerisoft.thespikerm.R.id.action_mode_bar_stub);
                        if (viewStubCompat != null) {
                            initWindowDecorActionBar();
                            ActionBar actionBar2 = this.mActionBar;
                            Context themedContext = actionBar2 != null ? actionBar2.getThemedContext() : null;
                            if (themedContext != null) {
                                context = themedContext;
                            }
                            viewStubCompat.setLayoutInflater(LayoutInflater.from(context));
                            this.mActionModeView = (ActionBarContextView) viewStubCompat.inflate();
                        }
                    }
                }
                if (this.mActionModeView != null) {
                    ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = this.mFadeAnim;
                    if (viewPropertyAnimatorCompat2 != null) {
                        viewPropertyAnimatorCompat2.cancel();
                    }
                    this.mActionModeView.killMode();
                    Context context2 = this.mActionModeView.getContext();
                    ActionBarContextView actionBarContextView = this.mActionModeView;
                    StandaloneActionMode standaloneActionMode = new StandaloneActionMode();
                    standaloneActionMode.mContext = context2;
                    standaloneActionMode.mContextView = actionBarContextView;
                    standaloneActionMode.mCallback = roomOpenHelper;
                    MenuBuilder menuBuilder = new MenuBuilder(actionBarContextView.getContext());
                    menuBuilder.mDefaultShowAsAction = 1;
                    standaloneActionMode.mMenu = menuBuilder;
                    menuBuilder.mCallback = standaloneActionMode;
                    if (((ActionMode.Callback) roomOpenHelper.mConfiguration).onCreateActionMode(standaloneActionMode, menuBuilder)) {
                        standaloneActionMode.invalidate();
                        this.mActionModeView.initForMode(standaloneActionMode);
                        this.mActionMode = standaloneActionMode;
                        if (((this.mSubDecorInstalled && (viewGroup = this.mSubDecor) != null && viewGroup.isLaidOut()) ? 1 : 0) != 0) {
                            this.mActionModeView.setAlpha(0.0f);
                            ViewPropertyAnimatorCompat viewPropertyAnimatorCompatAnimate = ViewCompat.animate(this.mActionModeView);
                            viewPropertyAnimatorCompatAnimate.alpha(1.0f);
                            this.mFadeAnim = viewPropertyAnimatorCompatAnimate;
                            viewPropertyAnimatorCompatAnimate.setListener(new AnonymousClass7(this, i));
                        } else {
                            this.mActionModeView.setAlpha(1.0f);
                            this.mActionModeView.setVisibility(0);
                            if (this.mActionModeView.getParent() instanceof View) {
                                View view = (View) this.mActionModeView.getParent();
                                WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                                ViewCompat.Api20Impl.requestApplyInsets(view);
                            }
                        }
                        if (this.mActionModePopup != null) {
                            this.mWindow.getDecorView().post(this.mShowActionModePopup);
                        }
                    } else {
                        this.mActionMode = null;
                    }
                }
            }
            ActionMode actionMode3 = this.mActionMode;
            if (actionMode3 != null) {
                r3.onSupportActionModeStarted(actionMode3);
            }
            updateBackInvokedCallbackState();
            this.mActionMode = this.mActionMode;
        }
        updateBackInvokedCallbackState();
        return this.mActionMode;
    }

    public final void throwFeatureRequestIfSubDecorInstalled() {
        if (this.mSubDecorInstalled) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final void updateBackInvokedCallbackState() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean z = false;
            if (this.mDispatcher != null && (getPanelState(0).isOpen || this.mActionMode != null)) {
                z = true;
            }
            if (z && this.mBackCallback == null) {
                this.mBackCallback = Api33Impl.registerOnBackPressedCallback(this.mDispatcher, this);
            } else {
                if (z || (onBackInvokedCallback = this.mBackCallback) == null) {
                    return;
                }
                Api33Impl.unregisterOnBackInvokedCallback(this.mDispatcher, onBackInvokedCallback);
                this.mBackCallback = null;
            }
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public final class AutoTimeNightModeManager extends BaseMenuWrapper {
        public final /* synthetic */ int $r8$classId = 1;
        public final Object mTwilightManager;

        public AutoTimeNightModeManager(zzaa zzaaVar) {
            super(AppCompatDelegateImpl.this);
            this.mTwilightManager = zzaaVar;
        }

        @Override // androidx.appcompat.view.menu.BaseMenuWrapper
        public final IntentFilter createIntentFilterForBroadcastReceiver() {
            switch (this.$r8$classId) {
                case 0:
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.TIME_SET");
                    intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
                    intentFilter.addAction("android.intent.action.TIME_TICK");
                    return intentFilter;
                default:
                    IntentFilter intentFilter2 = new IntentFilter();
                    intentFilter2.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                    return intentFilter2;
            }
        }

        @Override // androidx.appcompat.view.menu.BaseMenuWrapper
        public final int getApplyableNightMode() {
            Location location;
            boolean z;
            long j;
            Location lastKnownLocation;
            switch (this.$r8$classId) {
                case 0:
                    zzaa zzaaVar = (zzaa) this.mTwilightManager;
                    TwilightManager$TwilightState twilightManager$TwilightState = (TwilightManager$TwilightState) zzaaVar.zzc;
                    if (twilightManager$TwilightState.nextUpdate <= System.currentTimeMillis()) {
                        Context context = (Context) zzaaVar.zza;
                        int iCheckSelfPermission = RangesKt.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION");
                        Location lastKnownLocation2 = null;
                        LocationManager locationManager = (LocationManager) zzaaVar.zzb;
                        if (iCheckSelfPermission == 0) {
                            try {
                                lastKnownLocation = locationManager.isProviderEnabled("network") ? locationManager.getLastKnownLocation("network") : null;
                            } catch (Exception e) {
                                Log.d("TwilightManager", "Failed to get last known location", e);
                            }
                            location = lastKnownLocation;
                        } else {
                            location = null;
                        }
                        if (RangesKt.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                            try {
                                if (locationManager.isProviderEnabled("gps")) {
                                    lastKnownLocation2 = locationManager.getLastKnownLocation("gps");
                                }
                            } catch (Exception e2) {
                                Log.d("TwilightManager", "Failed to get last known location", e2);
                            }
                        }
                        if (lastKnownLocation2 == null || location == null ? lastKnownLocation2 != null : lastKnownLocation2.getTime() > location.getTime()) {
                            location = lastKnownLocation2;
                        }
                        z = false;
                        if (location != null) {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            if (TwilightCalculator.sInstance == null) {
                                TwilightCalculator.sInstance = new TwilightCalculator();
                            }
                            TwilightCalculator twilightCalculator = TwilightCalculator.sInstance;
                            twilightCalculator.calculateTwilight(jCurrentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
                            twilightCalculator.calculateTwilight(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
                            z = twilightCalculator.state == 1;
                            long j2 = twilightCalculator.sunrise;
                            long j3 = twilightCalculator.sunset;
                            twilightCalculator.calculateTwilight(jCurrentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
                            long j4 = twilightCalculator.sunrise;
                            if (j2 == -1 || j3 == -1) {
                                j = jCurrentTimeMillis + 43200000;
                            } else {
                                if (jCurrentTimeMillis <= j3) {
                                    j4 = jCurrentTimeMillis > j2 ? j3 : j2;
                                }
                                j = j4 + 60000;
                            }
                            twilightManager$TwilightState.isNight = z;
                            twilightManager$TwilightState.nextUpdate = j;
                        } else {
                            Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
                            int i = Calendar.getInstance().get(11);
                            if (i < 6 || i >= 22) {
                                z = true;
                            }
                        }
                        break;
                    } else {
                        z = twilightManager$TwilightState.isNight;
                    }
                    return z ? 2 : 1;
                default:
                    return Api21Impl.isPowerSaveMode((PowerManager) this.mTwilightManager) ? 2 : 1;
            }
        }

        @Override // androidx.appcompat.view.menu.BaseMenuWrapper
        public final void onChange() throws IllegalAccessException {
            switch (this.$r8$classId) {
                case 0:
                    AppCompatDelegateImpl.this.applyApplicationSpecificConfig(true, true);
                    break;
                default:
                    AppCompatDelegateImpl.this.applyApplicationSpecificConfig(true, true);
                    break;
            }
        }

        public AutoTimeNightModeManager(Context context) {
            super(AppCompatDelegateImpl.this);
            this.mTwilightManager = (PowerManager) context.getApplicationContext().getSystemService("power");
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setContentView(int i) {
        ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup) this.mSubDecor.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.mContext).inflate(i, viewGroup);
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.mWindow.getCallback());
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup) this.mSubDecor.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.mWindow.getCallback());
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
