package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.core.app.NavUtils;
import androidx.core.app.TaskStackBuilder;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.CamUtils;
import androidx.core.os.LocaleListCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.work.InputMergerFactory$1;
import com.daerisoft.thespikerm.RunnerActivity;
import com.google.android.gms.ads.rewarded.zQ.yzwzcWHcnH;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okio.Okio;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AppCompatActivity extends FragmentActivity implements AppCompatCallback, TaskStackBuilder.SupportParentable {
    private static final String DELEGATE_TAG = "androidx:appcompat";
    private AppCompatDelegate mDelegate;
    private Resources mResources;

    /* JADX INFO: renamed from: androidx.appcompat.app.AppCompatActivity$2 */
    /* JADX INFO: loaded from: classes.dex */
    public final class AnonymousClass2 implements OnContextAvailableListener {
        public AnonymousClass2() {
        }

        @Override // androidx.activity.contextaware.OnContextAvailableListener
        public final void onContextAvailable(ComponentActivity componentActivity) {
            RunnerActivity runnerActivity = this.this$0;
            AppCompatDelegate delegate = runnerActivity.getDelegate();
            delegate.installViewFactory();
            runnerActivity.getSavedStateRegistry().consumeRestoredStateForKey(AppCompatActivity.DELEGATE_TAG);
            delegate.onCreate();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        appCompatDelegateImpl.ensureSubDecor();
        ((ViewGroup) appCompatDelegateImpl.mSubDecor.findViewById(R.id.content)).addView(view, layoutParams);
        appCompatDelegateImpl.mAppCompatWindowCallback.bypassOnContentChanged(appCompatDelegateImpl.mWindow.getCallback());
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0181  */
    /* JADX WARN: Code duplicated, block: B:104:0x018f  */
    /* JADX WARN: Code duplicated, block: B:107:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:110:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:113:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:116:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:119:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:122:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:125:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:129:0x020c  */
    /* JADX WARN: Code duplicated, block: B:44:0x0095  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:55:0x00df  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:63:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:67:0x0103  */
    /* JADX WARN: Code duplicated, block: B:69:0x010d  */
    /* JADX WARN: Code duplicated, block: B:72:0x0117  */
    /* JADX WARN: Code duplicated, block: B:75:0x011f  */
    /* JADX WARN: Code duplicated, block: B:78:0x0127  */
    /* JADX WARN: Code duplicated, block: B:81:0x012f  */
    /* JADX WARN: Code duplicated, block: B:84:0x0137  */
    /* JADX WARN: Code duplicated, block: B:87:0x013f  */
    /* JADX WARN: Code duplicated, block: B:90:0x014b  */
    /* JADX WARN: Code duplicated, block: B:93:0x015a  */
    /* JADX WARN: Code duplicated, block: B:96:0x0169  */
    /* JADX WARN: Code duplicated, block: B:99:0x0178  */
    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Configuration configuration;
        Configuration configuration2;
        ContextThemeWrapper contextThemeWrapper;
        float f;
        float f2;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        int i36;
        int i37;
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        appCompatDelegateImpl.mBaseContextAttached = true;
        int i38 = appCompatDelegateImpl.mLocalNightMode;
        if (i38 == -100) {
            i38 = AppCompatDelegate.sDefaultNightMode;
        }
        int iMapNightMode = appCompatDelegateImpl.mapNightMode(context, i38);
        if (AppCompatDelegate.isAutoStorageOptedIn(context) && AppCompatDelegate.isAutoStorageOptedIn(context)) {
            if (Build.VERSION.SDK_INT < 33) {
                synchronized (AppCompatDelegate.sAppLocalesStorageSyncLock) {
                    try {
                        LocaleListCompat localeListCompat = AppCompatDelegate.sRequestedAppLocales;
                        if (localeListCompat == null) {
                            if (AppCompatDelegate.sStoredAppLocales == null) {
                                AppCompatDelegate.sStoredAppLocales = LocaleListCompat.forLanguageTags(NavUtils.readLocales(context));
                            }
                            if (!AppCompatDelegate.sStoredAppLocales.mImpl.isEmpty()) {
                                AppCompatDelegate.sRequestedAppLocales = AppCompatDelegate.sStoredAppLocales;
                            }
                        } else if (!localeListCompat.equals(AppCompatDelegate.sStoredAppLocales)) {
                            LocaleListCompat localeListCompat2 = AppCompatDelegate.sRequestedAppLocales;
                            AppCompatDelegate.sStoredAppLocales = localeListCompat2;
                            NavUtils.persistLocales(context, localeListCompat2.mImpl.toLanguageTags());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } else if (!AppCompatDelegate.sIsFrameworkSyncChecked) {
                AppCompatDelegate.sSerialExecutorForLocalesStorage.execute(new AppCompatDelegate$$ExternalSyntheticLambda0(context, 0));
            }
        }
        LocaleListCompat localeListCompatCalculateApplicationLocales = AppCompatDelegateImpl.calculateApplicationLocales(context);
        Configuration configuration3 = null;
        if (context instanceof android.view.ContextThemeWrapper) {
            try {
                ((android.view.ContextThemeWrapper) context).applyOverrideConfiguration(AppCompatDelegateImpl.createOverrideAppConfiguration(context, iMapNightMode, localeListCompatCalculateApplicationLocales, null, false));
            } catch (IllegalStateException unused) {
                if (context instanceof ContextThemeWrapper) {
                    try {
                        ((ContextThemeWrapper) context).applyOverrideConfiguration(AppCompatDelegateImpl.createOverrideAppConfiguration(context, iMapNightMode, localeListCompatCalculateApplicationLocales, null, false));
                    } catch (IllegalStateException unused2) {
                        if (AppCompatDelegateImpl.sCanReturnDifferentContext) {
                            Configuration configuration4 = new Configuration();
                            configuration4.uiMode = -1;
                            configuration4.fontScale = 0.0f;
                            configuration = context.createConfigurationContext(configuration4).getResources().getConfiguration();
                            configuration2 = context.getResources().getConfiguration();
                            configuration.uiMode = configuration2.uiMode;
                            if (!configuration.equals(configuration2)) {
                                configuration3 = new Configuration();
                                configuration3.fontScale = 0.0f;
                                if (configuration.diff(configuration2) != 0) {
                                    f = configuration.fontScale;
                                    f2 = configuration2.fontScale;
                                    if (f != f2) {
                                        configuration3.fontScale = f2;
                                    }
                                    i = configuration.mcc;
                                    i2 = configuration2.mcc;
                                    if (i != i2) {
                                        configuration3.mcc = i2;
                                    }
                                    i3 = configuration.mnc;
                                    i4 = configuration2.mnc;
                                    if (i3 != i4) {
                                        configuration3.mnc = i4;
                                    }
                                    i5 = Build.VERSION.SDK_INT;
                                    if (i5 >= 24) {
                                        AppCompatDelegateImpl.Api24Impl.generateConfigDelta_locale(configuration, configuration2, configuration3);
                                    } else if (!Objects.equals(configuration.locale, configuration2.locale)) {
                                        configuration3.locale = configuration2.locale;
                                    }
                                    i6 = configuration.touchscreen;
                                    i7 = configuration2.touchscreen;
                                    if (i6 != i7) {
                                        configuration3.touchscreen = i7;
                                    }
                                    i8 = configuration.keyboard;
                                    i9 = configuration2.keyboard;
                                    if (i8 != i9) {
                                        configuration3.keyboard = i9;
                                    }
                                    i10 = configuration.keyboardHidden;
                                    i11 = configuration2.keyboardHidden;
                                    if (i10 != i11) {
                                        configuration3.keyboardHidden = i11;
                                    }
                                    i12 = configuration.navigation;
                                    i13 = configuration2.navigation;
                                    if (i12 != i13) {
                                        configuration3.navigation = i13;
                                    }
                                    i14 = configuration.navigationHidden;
                                    i15 = configuration2.navigationHidden;
                                    if (i14 != i15) {
                                        configuration3.navigationHidden = i15;
                                    }
                                    i16 = configuration.orientation;
                                    i17 = configuration2.orientation;
                                    if (i16 != i17) {
                                        configuration3.orientation = i17;
                                    }
                                    i18 = configuration.screenLayout & 15;
                                    i19 = configuration2.screenLayout & 15;
                                    if (i18 != i19) {
                                        configuration3.screenLayout |= i19;
                                    }
                                    i20 = configuration.screenLayout & 192;
                                    i21 = configuration2.screenLayout & 192;
                                    if (i20 != i21) {
                                        configuration3.screenLayout |= i21;
                                    }
                                    i22 = configuration.screenLayout & 48;
                                    i23 = configuration2.screenLayout & 48;
                                    if (i22 != i23) {
                                        configuration3.screenLayout |= i23;
                                    }
                                    i24 = configuration.screenLayout & 768;
                                    i25 = configuration2.screenLayout & 768;
                                    if (i24 != i25) {
                                        configuration3.screenLayout |= i25;
                                    }
                                    if (i5 >= 26) {
                                        if ((configuration.colorMode & 3) != (configuration2.colorMode & 3)) {
                                            configuration3.colorMode |= configuration2.colorMode & 3;
                                        }
                                        if ((configuration.colorMode & 12) != (configuration2.colorMode & 12)) {
                                            configuration3.colorMode |= configuration2.colorMode & 12;
                                        }
                                    }
                                    i26 = configuration.uiMode & 15;
                                    i27 = configuration2.uiMode & 15;
                                    if (i26 != i27) {
                                        configuration3.uiMode |= i27;
                                    }
                                    i28 = configuration.uiMode & 48;
                                    i29 = configuration2.uiMode & 48;
                                    if (i28 != i29) {
                                        configuration3.uiMode |= i29;
                                    }
                                    i30 = configuration.screenWidthDp;
                                    i31 = configuration2.screenWidthDp;
                                    if (i30 != i31) {
                                        configuration3.screenWidthDp = i31;
                                    }
                                    i32 = configuration.screenHeightDp;
                                    i33 = configuration2.screenHeightDp;
                                    if (i32 != i33) {
                                        configuration3.screenHeightDp = i33;
                                    }
                                    i34 = configuration.smallestScreenWidthDp;
                                    i35 = configuration2.smallestScreenWidthDp;
                                    if (i34 != i35) {
                                        configuration3.smallestScreenWidthDp = i35;
                                    }
                                    i36 = configuration.densityDpi;
                                    i37 = configuration2.densityDpi;
                                    if (i36 != i37) {
                                        configuration3.densityDpi = i37;
                                    }
                                }
                            }
                            Configuration configurationCreateOverrideAppConfiguration = AppCompatDelegateImpl.createOverrideAppConfiguration(context, iMapNightMode, localeListCompatCalculateApplicationLocales, configuration3, true);
                            contextThemeWrapper = new ContextThemeWrapper(context, com.daerisoft.thespikerm.R.style.Theme_AppCompat_Empty);
                            contextThemeWrapper.applyOverrideConfiguration(configurationCreateOverrideAppConfiguration);
                            try {
                                if (context.getTheme() != null) {
                                    CamUtils.rebase(contextThemeWrapper.getTheme());
                                }
                            } catch (NullPointerException unused3) {
                            }
                            context = contextThemeWrapper;
                        }
                    }
                } else if (AppCompatDelegateImpl.sCanReturnDifferentContext) {
                    Configuration configuration5 = new Configuration();
                    configuration5.uiMode = -1;
                    configuration5.fontScale = 0.0f;
                    configuration = context.createConfigurationContext(configuration5).getResources().getConfiguration();
                    configuration2 = context.getResources().getConfiguration();
                    configuration.uiMode = configuration2.uiMode;
                    if (!configuration.equals(configuration2)) {
                        configuration3 = new Configuration();
                        configuration3.fontScale = 0.0f;
                        if (configuration.diff(configuration2) != 0) {
                            f = configuration.fontScale;
                            f2 = configuration2.fontScale;
                            if (f != f2) {
                                configuration3.fontScale = f2;
                            }
                            i = configuration.mcc;
                            i2 = configuration2.mcc;
                            if (i != i2) {
                                configuration3.mcc = i2;
                            }
                            i3 = configuration.mnc;
                            i4 = configuration2.mnc;
                            if (i3 != i4) {
                                configuration3.mnc = i4;
                            }
                            i5 = Build.VERSION.SDK_INT;
                            if (i5 >= 24) {
                                AppCompatDelegateImpl.Api24Impl.generateConfigDelta_locale(configuration, configuration2, configuration3);
                            } else if (!Objects.equals(configuration.locale, configuration2.locale)) {
                                configuration3.locale = configuration2.locale;
                            }
                            i6 = configuration.touchscreen;
                            i7 = configuration2.touchscreen;
                            if (i6 != i7) {
                                configuration3.touchscreen = i7;
                            }
                            i8 = configuration.keyboard;
                            i9 = configuration2.keyboard;
                            if (i8 != i9) {
                                configuration3.keyboard = i9;
                            }
                            i10 = configuration.keyboardHidden;
                            i11 = configuration2.keyboardHidden;
                            if (i10 != i11) {
                                configuration3.keyboardHidden = i11;
                            }
                            i12 = configuration.navigation;
                            i13 = configuration2.navigation;
                            if (i12 != i13) {
                                configuration3.navigation = i13;
                            }
                            i14 = configuration.navigationHidden;
                            i15 = configuration2.navigationHidden;
                            if (i14 != i15) {
                                configuration3.navigationHidden = i15;
                            }
                            i16 = configuration.orientation;
                            i17 = configuration2.orientation;
                            if (i16 != i17) {
                                configuration3.orientation = i17;
                            }
                            i18 = configuration.screenLayout & 15;
                            i19 = configuration2.screenLayout & 15;
                            if (i18 != i19) {
                                configuration3.screenLayout |= i19;
                            }
                            i20 = configuration.screenLayout & 192;
                            i21 = configuration2.screenLayout & 192;
                            if (i20 != i21) {
                                configuration3.screenLayout |= i21;
                            }
                            i22 = configuration.screenLayout & 48;
                            i23 = configuration2.screenLayout & 48;
                            if (i22 != i23) {
                                configuration3.screenLayout |= i23;
                            }
                            i24 = configuration.screenLayout & 768;
                            i25 = configuration2.screenLayout & 768;
                            if (i24 != i25) {
                                configuration3.screenLayout |= i25;
                            }
                            if (i5 >= 26) {
                                if ((configuration.colorMode & 3) != (configuration2.colorMode & 3)) {
                                    configuration3.colorMode |= configuration2.colorMode & 3;
                                }
                                if ((configuration.colorMode & 12) != (configuration2.colorMode & 12)) {
                                    configuration3.colorMode |= configuration2.colorMode & 12;
                                }
                            }
                            i26 = configuration.uiMode & 15;
                            i27 = configuration2.uiMode & 15;
                            if (i26 != i27) {
                                configuration3.uiMode |= i27;
                            }
                            i28 = configuration.uiMode & 48;
                            i29 = configuration2.uiMode & 48;
                            if (i28 != i29) {
                                configuration3.uiMode |= i29;
                            }
                            i30 = configuration.screenWidthDp;
                            i31 = configuration2.screenWidthDp;
                            if (i30 != i31) {
                                configuration3.screenWidthDp = i31;
                            }
                            i32 = configuration.screenHeightDp;
                            i33 = configuration2.screenHeightDp;
                            if (i32 != i33) {
                                configuration3.screenHeightDp = i33;
                            }
                            i34 = configuration.smallestScreenWidthDp;
                            i35 = configuration2.smallestScreenWidthDp;
                            if (i34 != i35) {
                                configuration3.smallestScreenWidthDp = i35;
                            }
                            i36 = configuration.densityDpi;
                            i37 = configuration2.densityDpi;
                            if (i36 != i37) {
                                configuration3.densityDpi = i37;
                            }
                        }
                    }
                    Configuration configurationCreateOverrideAppConfiguration2 = AppCompatDelegateImpl.createOverrideAppConfiguration(context, iMapNightMode, localeListCompatCalculateApplicationLocales, configuration3, true);
                    contextThemeWrapper = new ContextThemeWrapper(context, com.daerisoft.thespikerm.R.style.Theme_AppCompat_Empty);
                    contextThemeWrapper.applyOverrideConfiguration(configurationCreateOverrideAppConfiguration2);
                    if (context.getTheme() != null) {
                        CamUtils.rebase(contextThemeWrapper.getTheme());
                    }
                    context = contextThemeWrapper;
                }
            }
        } else if (context instanceof ContextThemeWrapper) {
            ((ContextThemeWrapper) context).applyOverrideConfiguration(AppCompatDelegateImpl.createOverrideAppConfiguration(context, iMapNightMode, localeListCompatCalculateApplicationLocales, null, false));
        } else if (AppCompatDelegateImpl.sCanReturnDifferentContext) {
            Configuration configuration6 = new Configuration();
            configuration6.uiMode = -1;
            configuration6.fontScale = 0.0f;
            configuration = context.createConfigurationContext(configuration6).getResources().getConfiguration();
            configuration2 = context.getResources().getConfiguration();
            configuration.uiMode = configuration2.uiMode;
            if (!configuration.equals(configuration2)) {
                configuration3 = new Configuration();
                configuration3.fontScale = 0.0f;
                if (configuration.diff(configuration2) != 0) {
                    f = configuration.fontScale;
                    f2 = configuration2.fontScale;
                    if (f != f2) {
                        configuration3.fontScale = f2;
                    }
                    i = configuration.mcc;
                    i2 = configuration2.mcc;
                    if (i != i2) {
                        configuration3.mcc = i2;
                    }
                    i3 = configuration.mnc;
                    i4 = configuration2.mnc;
                    if (i3 != i4) {
                        configuration3.mnc = i4;
                    }
                    i5 = Build.VERSION.SDK_INT;
                    if (i5 >= 24) {
                        AppCompatDelegateImpl.Api24Impl.generateConfigDelta_locale(configuration, configuration2, configuration3);
                    } else if (!Objects.equals(configuration.locale, configuration2.locale)) {
                        configuration3.locale = configuration2.locale;
                    }
                    i6 = configuration.touchscreen;
                    i7 = configuration2.touchscreen;
                    if (i6 != i7) {
                        configuration3.touchscreen = i7;
                    }
                    i8 = configuration.keyboard;
                    i9 = configuration2.keyboard;
                    if (i8 != i9) {
                        configuration3.keyboard = i9;
                    }
                    i10 = configuration.keyboardHidden;
                    i11 = configuration2.keyboardHidden;
                    if (i10 != i11) {
                        configuration3.keyboardHidden = i11;
                    }
                    i12 = configuration.navigation;
                    i13 = configuration2.navigation;
                    if (i12 != i13) {
                        configuration3.navigation = i13;
                    }
                    i14 = configuration.navigationHidden;
                    i15 = configuration2.navigationHidden;
                    if (i14 != i15) {
                        configuration3.navigationHidden = i15;
                    }
                    i16 = configuration.orientation;
                    i17 = configuration2.orientation;
                    if (i16 != i17) {
                        configuration3.orientation = i17;
                    }
                    i18 = configuration.screenLayout & 15;
                    i19 = configuration2.screenLayout & 15;
                    if (i18 != i19) {
                        configuration3.screenLayout |= i19;
                    }
                    i20 = configuration.screenLayout & 192;
                    i21 = configuration2.screenLayout & 192;
                    if (i20 != i21) {
                        configuration3.screenLayout |= i21;
                    }
                    i22 = configuration.screenLayout & 48;
                    i23 = configuration2.screenLayout & 48;
                    if (i22 != i23) {
                        configuration3.screenLayout |= i23;
                    }
                    i24 = configuration.screenLayout & 768;
                    i25 = configuration2.screenLayout & 768;
                    if (i24 != i25) {
                        configuration3.screenLayout |= i25;
                    }
                    if (i5 >= 26) {
                        if ((configuration.colorMode & 3) != (configuration2.colorMode & 3)) {
                            configuration3.colorMode |= configuration2.colorMode & 3;
                        }
                        if ((configuration.colorMode & 12) != (configuration2.colorMode & 12)) {
                            configuration3.colorMode |= configuration2.colorMode & 12;
                        }
                    }
                    i26 = configuration.uiMode & 15;
                    i27 = configuration2.uiMode & 15;
                    if (i26 != i27) {
                        configuration3.uiMode |= i27;
                    }
                    i28 = configuration.uiMode & 48;
                    i29 = configuration2.uiMode & 48;
                    if (i28 != i29) {
                        configuration3.uiMode |= i29;
                    }
                    i30 = configuration.screenWidthDp;
                    i31 = configuration2.screenWidthDp;
                    if (i30 != i31) {
                        configuration3.screenWidthDp = i31;
                    }
                    i32 = configuration.screenHeightDp;
                    i33 = configuration2.screenHeightDp;
                    if (i32 != i33) {
                        configuration3.screenHeightDp = i33;
                    }
                    i34 = configuration.smallestScreenWidthDp;
                    i35 = configuration2.smallestScreenWidthDp;
                    if (i34 != i35) {
                        configuration3.smallestScreenWidthDp = i35;
                    }
                    i36 = configuration.densityDpi;
                    i37 = configuration2.densityDpi;
                    if (i36 != i37) {
                        configuration3.densityDpi = i37;
                    }
                }
            }
            Configuration configurationCreateOverrideAppConfiguration3 = AppCompatDelegateImpl.createOverrideAppConfiguration(context, iMapNightMode, localeListCompatCalculateApplicationLocales, configuration3, true);
            contextThemeWrapper = new ContextThemeWrapper(context, com.daerisoft.thespikerm.R.style.Theme_AppCompat_Empty);
            contextThemeWrapper.applyOverrideConfiguration(configurationCreateOverrideAppConfiguration3);
            if (context.getTheme() != null) {
                CamUtils.rebase(contextThemeWrapper.getTheme());
            }
            context = contextThemeWrapper;
        }
        super.attachBaseContext(context);
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (getWindow().hasFeature(0)) {
            if (supportActionBar == null || !supportActionBar.closeOptionsMenu()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        ActionBar supportActionBar = getSupportActionBar();
        if (keyCode == 82 && supportActionBar != null && supportActionBar.onMenuKeyEvent(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i) {
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        appCompatDelegateImpl.ensureSubDecor();
        return (T) appCompatDelegateImpl.mWindow.findViewById(i);
    }

    public AppCompatDelegate getDelegate() {
        if (this.mDelegate == null) {
            AppCompatDelegate.SerialExecutor serialExecutor = AppCompatDelegate.sSerialExecutorForLocalesStorage;
            this.mDelegate = new AppCompatDelegateImpl(this, null, this, this);
        }
        return this.mDelegate;
    }

    public ActionBarDrawerToggle$Delegate getDrawerToggleDelegate() {
        ((AppCompatDelegateImpl) getDelegate()).getClass();
        return new InputMergerFactory$1(2);
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        if (appCompatDelegateImpl.mMenuInflater == null) {
            appCompatDelegateImpl.initWindowDecorActionBar();
            ActionBar actionBar = appCompatDelegateImpl.mActionBar;
            appCompatDelegateImpl.mMenuInflater = new SupportMenuInflater(actionBar != null ? actionBar.getThemedContext() : appCompatDelegateImpl.mContext);
        }
        return appCompatDelegateImpl.mMenuInflater;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = this.mResources;
        if (resources == null) {
            int i = VectorEnabledTintResources.$r8$clinit;
        }
        return resources == null ? super.getResources() : resources;
    }

    public ActionBar getSupportActionBar() {
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        appCompatDelegateImpl.initWindowDecorActionBar();
        return appCompatDelegateImpl.mActionBar;
    }

    @Override // androidx.core.app.TaskStackBuilder.SupportParentable
    public Intent getSupportParentActivityIntent() {
        return NavUtils.getParentActivityIntent(this);
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        if (appCompatDelegateImpl.mHasActionBar && appCompatDelegateImpl.mSubDecorInstalled) {
            appCompatDelegateImpl.initWindowDecorActionBar();
            ActionBar actionBar = appCompatDelegateImpl.mActionBar;
            if (actionBar != null) {
                actionBar.onConfigurationChanged();
            }
        }
        AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
        Context context = appCompatDelegateImpl.mContext;
        synchronized (appCompatDrawableManager) {
            appCompatDrawableManager.mResourceManager.onConfigurationChanged(context);
        }
        appCompatDelegateImpl.mEffectiveConfiguration = new Configuration(appCompatDelegateImpl.mContext.getResources().getConfiguration());
        appCompatDelegateImpl.applyApplicationSpecificConfig(false, false);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(super.getResources().getConfiguration(), super.getResources().getDisplayMetrics());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        onSupportContentChanged();
    }

    public void onCreateSupportNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        taskStackBuilder.getClass();
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = NavUtils.getParentActivityIntent(this);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            AppCompatActivity appCompatActivity = taskStackBuilder.mSourceContext;
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(appCompatActivity.getPackageManager());
            }
            ArrayList arrayList = taskStackBuilder.mIntents;
            int size = arrayList.size();
            try {
                for (Intent parentActivityIntent = NavUtils.getParentActivityIntent(appCompatActivity, component); parentActivityIntent != null; parentActivityIntent = NavUtils.getParentActivityIntent(appCompatActivity, parentActivityIntent.getComponent())) {
                    arrayList.add(size, parentActivityIntent);
                }
                arrayList.add(supportParentActivityIntent);
            } catch (PackageManager.NameNotFoundException e) {
                Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                throw new IllegalArgumentException(e);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getDelegate().onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Window window;
        if (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    public void onLocalesChanged(LocaleListCompat localeListCompat) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.getDisplayOptions() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onNightModeChanged(int i) {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ((AppCompatDelegateImpl) getDelegate()).ensureSubDecor();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        appCompatDelegateImpl.initWindowDecorActionBar();
        ActionBar actionBar = appCompatDelegateImpl.mActionBar;
        if (actionBar != null) {
            actionBar.setShowHideAnimationEnabled(true);
        }
    }

    public void onPrepareSupportNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        ((AppCompatDelegateImpl) getDelegate()).applyApplicationSpecificConfig(true, false);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        appCompatDelegateImpl.initWindowDecorActionBar();
        ActionBar actionBar = appCompatDelegateImpl.mActionBar;
        if (actionBar != null) {
            actionBar.setShowHideAnimationEnabled(false);
        }
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeFinished(ActionMode actionMode) {
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeStarted(ActionMode actionMode) {
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public boolean onSupportNavigateUp() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (supportShouldUpRecreateTask(supportParentActivityIntent)) {
            TaskStackBuilder taskStackBuilder = new TaskStackBuilder(this);
            onCreateSupportNavigateUpTaskStack(taskStackBuilder);
            onPrepareSupportNavigateUpTaskStack(taskStackBuilder);
            ArrayList arrayList = taskStackBuilder.mIntents;
            if (arrayList.isEmpty()) {
                throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
            }
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[0]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            AppCompatActivity appCompatActivity = taskStackBuilder.mSourceContext;
            if (!ContextCompat.startActivities(appCompatActivity, intentArr, null)) {
                Intent intent = new Intent(intentArr[intentArr.length - 1]);
                intent.addFlags(268435456);
                appCompatActivity.startActivity(intent);
            }
            try {
                finishAffinity();
            } catch (IllegalStateException unused) {
                finish();
            }
        } else {
            supportNavigateUpTo(supportParentActivityIntent);
        }
        return true;
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        getDelegate().setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback callback) {
        return null;
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (getWindow().hasFeature(0)) {
            if (supportActionBar == null || !supportActionBar.openOptionsMenu()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i) {
        initViewTreeOwners();
        getDelegate().setContentView(i);
    }

    public void setSupportActionBar(Toolbar toolbar) {
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        if (appCompatDelegateImpl.mHost instanceof Activity) {
            appCompatDelegateImpl.initWindowDecorActionBar();
            ActionBar actionBar = appCompatDelegateImpl.mActionBar;
            if (actionBar instanceof WindowDecorActionBar) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            appCompatDelegateImpl.mMenuInflater = null;
            if (actionBar != null) {
                actionBar.onDestroy();
            }
            appCompatDelegateImpl.mActionBar = null;
            if (toolbar != null) {
                Object obj = appCompatDelegateImpl.mHost;
                ToolbarActionBar toolbarActionBar = new ToolbarActionBar(toolbar, obj instanceof Activity ? ((Activity) obj).getTitle() : appCompatDelegateImpl.mTitle, appCompatDelegateImpl.mAppCompatWindowCallback);
                appCompatDelegateImpl.mActionBar = toolbarActionBar;
                appCompatDelegateImpl.mAppCompatWindowCallback.mActionBarCallback = toolbarActionBar.mMenuCallback;
                toolbar.setBackInvokedCallbackEnabled(true);
            } else {
                appCompatDelegateImpl.mAppCompatWindowCallback.mActionBarCallback = null;
            }
            appCompatDelegateImpl.invalidateOptionsMenu();
        }
    }

    @Deprecated
    public void setSupportProgress(int i) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z) {
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        super.setTheme(i);
        ((AppCompatDelegateImpl) getDelegate()).mThemeResId = i;
    }

    public ActionMode startSupportActionMode(ActionMode.Callback callback) {
        return getDelegate().startSupportActionMode(callback);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void supportInvalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    public void supportNavigateUpTo(Intent intent) {
        navigateUpTo(intent);
    }

    public boolean supportRequestWindowFeature(int i) {
        return getDelegate().requestWindowFeature(i);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return shouldUpRecreateTask(intent);
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.AppCompatActivity$1 */
    /* JADX INFO: loaded from: classes.dex */
    public final class AnonymousClass1 implements SavedStateRegistry.SavedStateProvider {
        public final /* synthetic */ int $r8$classId = 1;
        public final Object this$0;

        public AnonymousClass1(SavedStateRegistry registry) {
            Intrinsics.checkNotNullParameter(registry, "registry");
            this.this$0 = new LinkedHashSet();
            registry.registerSavedStateProvider("androidx.savedstate.Restarter", this);
        }

        @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
        public final Bundle saveState() {
            switch (this.$r8$classId) {
                case 0:
                    Bundle bundle = new Bundle();
                    ((RunnerActivity) this.this$0).getDelegate().getClass();
                    return bundle;
                default:
                    Bundle bundle2 = new Bundle();
                    bundle2.putStringArrayList("classes_to_restore", new ArrayList<>((LinkedHashSet) this.this$0));
                    return bundle2;
            }
        }

        public AnonymousClass1(RunnerActivity runnerActivity) {
            this.this$0 = runnerActivity;
        }
    }

    public final void initViewTreeOwners() {
        ViewTreeLifecycleOwner.set(getWindow().getDecorView(), this);
        View decorView = getWindow().getDecorView();
        Intrinsics.checkNotNullParameter(decorView, yzwzcWHcnH.XjNOUkd);
        decorView.setTag(com.daerisoft.thespikerm.R.id.view_tree_view_model_store_owner, this);
        Protocol.Companion.set(getWindow().getDecorView(), this);
        Okio.set(getWindow().getDecorView(), this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        initViewTreeOwners();
        getDelegate().setContentView(view);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        getDelegate().setContentView(view, layoutParams);
    }
}
