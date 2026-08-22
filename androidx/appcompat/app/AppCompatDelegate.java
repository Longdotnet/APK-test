package androidx.appcompat.app;

import android.app.LocaleManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.ActionMode;
import androidx.collection.ArraySet;
import androidx.collection.MapCollections$ArrayIterator;
import androidx.core.os.LocaleListCompat;
import com.facebook.GraphRequest$Companion$$ExternalSyntheticLambda1;
import com.google.android.gms.tasks.zzt;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class AppCompatDelegate {
    public static final SerialExecutor sSerialExecutorForLocalesStorage = new SerialExecutor(new zzt(1));
    public static final int sDefaultNightMode = -100;
    public static LocaleListCompat sRequestedAppLocales = null;
    public static LocaleListCompat sStoredAppLocales = null;
    public static Boolean sIsAutoStoreLocalesOptedIn = null;
    public static boolean sIsFrameworkSyncChecked = false;
    public static final ArraySet sActivityDelegates = new ArraySet(0);
    public static final Object sActivityDelegatesLock = new Object();
    public static final Object sAppLocalesStorageSyncLock = new Object();

    public abstract class Api24Impl {
        public static LocaleList localeListForLanguageTags(String str) {
            return LocaleList.forLanguageTags(str);
        }
    }

    public abstract class Api33Impl {
        public static LocaleList localeManagerGetApplicationLocales(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        public static void localeManagerSetApplicationLocales(Object obj, LocaleList localeList) {
            ((LocaleManager) obj).setApplicationLocales(localeList);
        }
    }

    public final class SerialExecutor implements Executor {
        public Runnable mActive;
        public final zzt mExecutor;
        public final Object mLock = new Object();
        public final ArrayDeque mTasks = new ArrayDeque();

        public SerialExecutor(zzt zztVar) {
            this.mExecutor = zztVar;
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            synchronized (this.mLock) {
                try {
                    this.mTasks.add(new GraphRequest$Companion$$ExternalSyntheticLambda1(this, runnable, 2));
                    if (this.mActive == null) {
                        scheduleNext();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void scheduleNext() {
            synchronized (this.mLock) {
                try {
                    Runnable runnable = (Runnable) this.mTasks.poll();
                    this.mActive = runnable;
                    if (runnable != null) {
                        this.mExecutor.execute(runnable);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static boolean isAutoStorageOptedIn(Context context) {
        if (sIsAutoStoreLocalesOptedIn == null) {
            try {
                int i = AppLocalesMetadataHolderService.$r8$clinit;
                Bundle bundle = context.getPackageManager().getServiceInfo(new ComponentName(context, (Class<?>) AppLocalesMetadataHolderService.class), Build.VERSION.SDK_INT >= 24 ? AppLocalesMetadataHolderService.Api24Impl.getDisabledComponentFlag() | 128 : 640).metaData;
                if (bundle != null) {
                    sIsAutoStoreLocalesOptedIn = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                sIsAutoStoreLocalesOptedIn = Boolean.FALSE;
            }
        }
        return sIsAutoStoreLocalesOptedIn.booleanValue();
    }

    public static void removeDelegateFromActives(AppCompatDelegateImpl appCompatDelegateImpl) {
        synchronized (sActivityDelegatesLock) {
            try {
                Iterator it = sActivityDelegates.iterator();
                while (true) {
                    MapCollections$ArrayIterator mapCollections$ArrayIterator = (MapCollections$ArrayIterator) it;
                    if (mapCollections$ArrayIterator.hasNext()) {
                        AppCompatDelegate appCompatDelegate = (AppCompatDelegate) ((WeakReference) mapCollections$ArrayIterator.next()).get();
                        if (appCompatDelegate == appCompatDelegateImpl || appCompatDelegate == null) {
                            mapCollections$ArrayIterator.remove();
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void installViewFactory();

    public abstract void invalidateOptionsMenu();

    public abstract void onCreate();

    public abstract void onDestroy();

    public abstract boolean requestWindowFeature(int i);

    public abstract void setContentView(int i);

    public abstract void setContentView(View view);

    public abstract void setContentView(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void setTitle(CharSequence charSequence);

    public abstract ActionMode startSupportActionMode(ActionMode.Callback callback);
}
