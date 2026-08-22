package androidx.work;

import android.R;
import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.app.ToolbarActionBar;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.DropDownListView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.core.view.ViewCompat;
import androidx.core.widget.AutoScrollHelper$ClampedScroller;
import androidx.core.widget.ListViewAutoScrollHelper;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransition;
import androidx.lifecycle.LiveData;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.framework.FrameworkSQLiteProgram;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import com.android.billingclient.api.BillingClientImpl;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.zzbc;
import com.android.billingclient.api.zzcb;
import com.android.billingclient.api.zzce;
import com.android.billingclient.api.zzn;
import com.daerisoft.thespikerm.FirebaseAuthentication_tools;
import com.daerisoft.thespikerm.FirebaseAuthentication_tools$1$1;
import com.daerisoft.thespikerm.FirebaseAuthentication_tools$1$2;
import com.daerisoft.thespikerm.GooglePlayBillingService;
import com.daerisoft.thespikerm.RunnerActivity;
import com.daerisoft.thespikerm.SuncyanFacebookSdk;
import com.facebook.AccessTokenCache;
import com.facebook.FacebookSdk;
import com.facebook.UserSettingsManager;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.android.gms.ads.internal.client.zzbk;
import com.google.android.gms.ads.internal.client.zzfi;
import com.google.android.gms.ads.internal.client.zzfm;
import com.google.android.gms.ads.internal.client.zzfo;
import com.google.android.gms.ads.internal.gMU.QTaELkFI;
import com.google.android.gms.ads.internal.overlay.zzac;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.ads.internal.util.zzb;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.zza;
import com.google.android.gms.common.util.concurrent.dN.MnHfHMYQDPUO;
import com.google.android.gms.internal.ads.zzbac;
import com.google.android.gms.internal.ads.zzbev;
import com.google.android.gms.internal.ads.zzbmk;
import com.google.android.gms.internal.ads.zzbxc;
import com.google.android.gms.measurement.internal.zzkt;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.protobuf.DescriptorProtos;
import com.yoyogames.runner.RunnerJNILib;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes.dex */
public abstract class Worker extends ListenableWorker {
    public SettableFuture mFuture;

    /* JADX INFO: renamed from: androidx.work.Worker$1 */
    /* JADX INFO: loaded from: classes2.dex */
    public final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object this$0;

        public AnonymousClass1(zzn zznVar, boolean z) {
            this.$r8$classId = 29;
            this.this$0 = zznVar;
        }

        private final void run$androidx$work$impl$workers$ConstraintTrackingWorker$1() {
            ConstraintTrackingWorker constraintTrackingWorker = (ConstraintTrackingWorker) this.this$0;
            String string = constraintTrackingWorker.getInputData().getString("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
            if (TextUtils.isEmpty(string)) {
                Logger$LogcatLogger.get().error(ConstraintTrackingWorker.TAG, "No worker to delegate to.", new Throwable[0]);
                constraintTrackingWorker.mFuture.set(new ListenableWorker.Result.Failure());
                return;
            }
            ListenableWorker listenableWorkerCreateWorkerWithDefaultFallback = constraintTrackingWorker.getWorkerFactory().createWorkerWithDefaultFallback(constraintTrackingWorker.getApplicationContext(), string, constraintTrackingWorker.mWorkerParameters);
            constraintTrackingWorker.mDelegate = listenableWorkerCreateWorkerWithDefaultFallback;
            if (listenableWorkerCreateWorkerWithDefaultFallback == null) {
                Logger$LogcatLogger.get().debug(ConstraintTrackingWorker.TAG, "No worker to delegate to.", new Throwable[0]);
                constraintTrackingWorker.mFuture.set(new ListenableWorker.Result.Failure());
                return;
            }
            WorkSpec workSpec = WorkManagerImpl.getInstance(constraintTrackingWorker.getApplicationContext()).mWorkDatabase.workSpecDao().getWorkSpec(constraintTrackingWorker.getId().toString());
            if (workSpec == null) {
                constraintTrackingWorker.mFuture.set(new ListenableWorker.Result.Failure());
                return;
            }
            WorkConstraintsTracker workConstraintsTracker = new WorkConstraintsTracker(constraintTrackingWorker.getApplicationContext(), constraintTrackingWorker.getTaskExecutor(), constraintTrackingWorker);
            workConstraintsTracker.replace(Collections.singletonList(workSpec));
            if (!workConstraintsTracker.areAllConstraintsMet(constraintTrackingWorker.getId().toString())) {
                Logger$LogcatLogger.get().debug(ConstraintTrackingWorker.TAG, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Constraints not met for delegate ", string, ". Requesting retry."), new Throwable[0]);
                constraintTrackingWorker.mFuture.set(new ListenableWorker.Result.Retry());
                return;
            }
            Logger$LogcatLogger.get().debug(ConstraintTrackingWorker.TAG, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1(MnHfHMYQDPUO.MhyrlzargRzY, string), new Throwable[0]);
            try {
                ListenableFuture listenableFutureStartWork = constraintTrackingWorker.mDelegate.startWork();
                listenableFutureStartWork.addListener(new zza((Object) constraintTrackingWorker, (Object) listenableFutureStartWork, 11, false), constraintTrackingWorker.getBackgroundExecutor());
            } catch (Throwable th) {
                Logger$LogcatLogger logger$LogcatLogger = Logger$LogcatLogger.get();
                String str = ConstraintTrackingWorker.TAG;
                logger$LogcatLogger.debug(str, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Delegated worker ", string, " threw exception in startWork."), th);
                synchronized (constraintTrackingWorker.mLock) {
                    try {
                        if (constraintTrackingWorker.mAreConstraintsUnmet) {
                            Logger$LogcatLogger.get().debug(str, "Constraints were unmet, Retrying.", new Throwable[0]);
                            constraintTrackingWorker.mFuture.set(new ListenableWorker.Result.Retry());
                        } else {
                            constraintTrackingWorker.mFuture.set(new ListenableWorker.Result.Failure());
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }

        private final void run$com$google$android$gms$ads$internal$util$zzh() {
            zzj zzjVar = (zzj) this.this$0;
            if (zzjVar.zzb) {
                if (!(zzjVar.zzK() && zzjVar.zzL()) && ((Boolean) zzbev.zzb.zze()).booleanValue()) {
                    synchronized (zzjVar.zza) {
                        try {
                            if (Looper.getMainLooper() == null) {
                                return;
                            }
                            if (zzjVar.zze == null) {
                                zzjVar.zze = new zzbac();
                            }
                            zzjVar.zze.zzd();
                            int i = zze.$r8$clinit;
                            zzo.zzi("start fetching content...");
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            }
        }

        public HashSet checkUpdatedTable() {
            HashSet hashSet = new HashSet();
            Cursor cursorQuery = ((InvalidationTracker) this.this$0).mDatabase.query(new SimpleSQLiteQuery("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
            while (cursorQuery.moveToNext()) {
                try {
                    hashSet.add(Integer.valueOf(cursorQuery.getInt(0)));
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            }
            cursorQuery.close();
            if (!hashSet.isEmpty()) {
                ((InvalidationTracker) this.this$0).mCleanupStatement.executeUpdateDelete();
            }
            return hashSet;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Object obj;
            switch (this.$r8$classId) {
                case 0:
                    Worker worker = (Worker) this.this$0;
                    try {
                        worker.mFuture.set(worker.doWork());
                        return;
                    } catch (Throwable th) {
                        worker.mFuture.setException(th);
                        return;
                    }
                case 1:
                    ToolbarActionBar toolbarActionBar = (ToolbarActionBar) this.this$0;
                    AppCompatDelegateImpl.AppCompatWindowCallback appCompatWindowCallback = toolbarActionBar.mWindowCallback;
                    Menu menu = toolbarActionBar.getMenu();
                    MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
                    if (menuBuilder != null) {
                        menuBuilder.stopDispatchingItemsChanged();
                    }
                    try {
                        menu.clear();
                        if (!appCompatWindowCallback.onCreatePanelMenu(0, menu) || !appCompatWindowCallback.onPreparePanel(0, null, menu)) {
                            menu.clear();
                        }
                        if (menuBuilder != null) {
                            return;
                        } else {
                            return;
                        }
                    } finally {
                        if (menuBuilder != null) {
                            menuBuilder.startDispatchingItemsChanged();
                        }
                    }
                    break;
                case 2:
                    AnimatedStateListDrawableCompat animatedStateListDrawableCompat = (AnimatedStateListDrawableCompat) this.this$0;
                    animatedStateListDrawableCompat.animate(true);
                    animatedStateListDrawableCompat.invalidateSelf();
                    return;
                case 3:
                    DropDownListView dropDownListView = (DropDownListView) this.this$0;
                    dropDownListView.mResolveHoverRunnable = null;
                    dropDownListView.drawableStateChanged();
                    return;
                case 4:
                    SearchView.SearchAutoComplete searchAutoComplete = (SearchView.SearchAutoComplete) this.this$0;
                    if (searchAutoComplete.mHasPendingShowSoftInputRequest) {
                        ((InputMethodManager) searchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(searchAutoComplete, 0);
                        searchAutoComplete.mHasPendingShowSoftInputRequest = false;
                        return;
                    }
                    return;
                case 5:
                    ((Toolbar) this.this$0).showOverflowMenu();
                    return;
                case 6:
                    Object obj2 = ((AccessTokenCache) this.this$0).sharedPreferences;
                    return;
                case 7:
                    ListViewAutoScrollHelper listViewAutoScrollHelper = (ListViewAutoScrollHelper) this.this$0;
                    if (listViewAutoScrollHelper.mAnimating) {
                        boolean z = listViewAutoScrollHelper.mNeedsReset;
                        AutoScrollHelper$ClampedScroller autoScrollHelper$ClampedScroller = listViewAutoScrollHelper.mScroller;
                        if (z) {
                            listViewAutoScrollHelper.mNeedsReset = false;
                            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                            autoScrollHelper$ClampedScroller.mStartTime = jCurrentAnimationTimeMillis;
                            autoScrollHelper$ClampedScroller.mStopTime = -1L;
                            autoScrollHelper$ClampedScroller.mDeltaTime = jCurrentAnimationTimeMillis;
                            autoScrollHelper$ClampedScroller.mStopValue = 0.5f;
                        }
                        if ((autoScrollHelper$ClampedScroller.mStopTime > 0 && AnimationUtils.currentAnimationTimeMillis() > autoScrollHelper$ClampedScroller.mStopTime + ((long) autoScrollHelper$ClampedScroller.mEffectiveRampDown)) || !listViewAutoScrollHelper.shouldAnimate()) {
                            listViewAutoScrollHelper.mAnimating = false;
                            return;
                        }
                        boolean z2 = listViewAutoScrollHelper.mNeedsCancel;
                        ListView listView = listViewAutoScrollHelper.mTarget$1;
                        if (z2) {
                            listViewAutoScrollHelper.mNeedsCancel = false;
                            long jUptimeMillis = SystemClock.uptimeMillis();
                            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                            listView.onTouchEvent(motionEventObtain);
                            motionEventObtain.recycle();
                        }
                        if (autoScrollHelper$ClampedScroller.mDeltaTime == 0) {
                            throw new RuntimeException("Cannot compute scroll delta before calling start()");
                        }
                        long jCurrentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                        float valueAt = autoScrollHelper$ClampedScroller.getValueAt(jCurrentAnimationTimeMillis2);
                        long j = jCurrentAnimationTimeMillis2 - autoScrollHelper$ClampedScroller.mDeltaTime;
                        autoScrollHelper$ClampedScroller.mDeltaTime = jCurrentAnimationTimeMillis2;
                        listViewAutoScrollHelper.mTarget.scrollListBy((int) (j * ((valueAt * 4.0f) + ((-4.0f) * valueAt * valueAt)) * autoScrollHelper$ClampedScroller.mTargetVelocityY));
                        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                        listView.postOnAnimation(this);
                        return;
                    }
                    return;
                case 8:
                    DefaultSpecialEffectsController.AnonymousClass4 anonymousClass4 = (DefaultSpecialEffectsController.AnonymousClass4) this.this$0;
                    anonymousClass4.val$container.endViewTransition(anonymousClass4.val$viewToAnimate);
                    anonymousClass4.val$animationInfo.completeSpecialEffect();
                    return;
                case 9:
                    FragmentTransition.setViewVisibility((ArrayList) this.this$0, 4);
                    return;
                case 10:
                    DialogFragment dialogFragment = (DialogFragment) this.this$0;
                    dialogFragment.mOnDismissListener.onDismiss(dialogFragment.mDialog);
                    return;
                case 11:
                    ((DefaultSpecialEffectsController) this.this$0).executePendingOperations();
                    return;
                case 12:
                    ((FragmentManager) this.this$0).execPendingActions(true);
                    return;
                case 13:
                    synchronized (((LiveData) this.this$0).mDataLock) {
                        obj = ((LiveData) this.this$0).mPendingData;
                        ((LiveData) this.this$0).mPendingData = LiveData.NOT_SET;
                        break;
                    }
                    ((LiveData) this.this$0).setValue(obj);
                    return;
                case 14:
                    run$androidx$room$InvalidationTracker$1();
                    return;
                case 15:
                    run$androidx$work$impl$workers$ConstraintTrackingWorker$1();
                    return;
                case 16:
                    zzbc zzbcVar = (zzbc) this.this$0;
                    ((BillingClientImpl) zzbcVar.zza).zza = 0;
                    ((BillingClientImpl) zzbcVar.zza).zzg = null;
                    BillingResult billingResult = zzce.zzn;
                    ((BillingClientImpl) zzbcVar.zza).zzap(zzcb.zza(24, 6, billingResult));
                    zzbcVar.zzd(billingResult);
                    return;
                case 17:
                    WebView unused = FirebaseAuthentication_tools.webView = new WebView(FirebaseAuthentication_tools.activity);
                    FirebaseAuthentication_tools.webView.getSettings().setJavaScriptEnabled(true);
                    FirebaseAuthentication_tools.webView.addJavascriptInterface(FirebaseAuthentication_tools.activity, "webview");
                    FirebaseAuthentication_tools.webView.setWebViewClient(new FirebaseAuthentication_tools$1$1());
                    FirebaseAuthentication_tools.webView.setWebChromeClient(new FirebaseAuthentication_tools$1$2());
                    FirebaseAuthentication_tools.webView.loadUrl((String) this.this$0);
                    ((ViewGroup) FirebaseAuthentication_tools.activity.findViewById(R.id.content)).addView(FirebaseAuthentication_tools.webView);
                    return;
                case 18:
                    Window window = RunnerActivity.CurrentActivity.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    Display.Mode mode = (Display.Mode) this.this$0;
                    attributes.preferredDisplayModeId = mode.getModeId();
                    window.setAttributes(attributes);
                    RunnerJNILib.mCurrentRefreshRate = Math.round(mode.getRefreshRate());
                    RunnerJNILib.OnDisplayFrequencyChanged();
                    RunnerActivity.CurrentDisplayMode = mode;
                    RunnerActivity.DisplayUpdatePending.set(false);
                    Log.i(GooglePlayBillingService.TAG, "Selected activity refresh rate: " + String.valueOf(RunnerJNILib.mCurrentRefreshRate));
                    return;
                case 19:
                    ((RunnerActivity) this.this$0).setupUiVisibility();
                    return;
                case 20:
                    SuncyanFacebookSdk suncyanFacebookSdk = (SuncyanFacebookSdk) ((RoomOpenHelper) this.this$0).mDelegate;
                    CallbackManagerImpl callbackManagerImpl = new CallbackManagerImpl();
                    new HashMap();
                    suncyanFacebookSdk.callbackManager = callbackManagerImpl;
                    FacebookSdk.isFullyInitialized = true;
                    UserSettingsManager userSettingsManager = UserSettingsManager.INSTANCE;
                    if (!CrashShieldHandler.isObjectCrashing(UserSettingsManager.class)) {
                        try {
                            UserSettingsManager.UserSetting userSetting = UserSettingsManager.autoLogAppEventsEnabled;
                            userSetting.value = Boolean.TRUE;
                            userSetting.lastTS = System.currentTimeMillis();
                            boolean z3 = UserSettingsManager.isInitialized.get();
                            UserSettingsManager userSettingsManager2 = UserSettingsManager.INSTANCE;
                            if (z3) {
                                userSettingsManager2.writeSettingToCache(userSetting);
                            } else {
                                userSettingsManager2.initializeIfNotInitialized();
                            }
                        } catch (Throwable th2) {
                            CrashShieldHandler.handleThrowable(UserSettingsManager.class, th2);
                        }
                        break;
                    }
                    Application application = (Application) FacebookSdk.getApplicationContext();
                    String str = ActivityLifecycleTracker.TAG;
                    ActivityLifecycleTracker.startTracking(application, FacebookSdk.getApplicationId());
                    UserSettingsManager userSettingsManager3 = UserSettingsManager.INSTANCE;
                    if (!CrashShieldHandler.isObjectCrashing(UserSettingsManager.class)) {
                        try {
                            UserSettingsManager.UserSetting userSetting2 = UserSettingsManager.advertiserIDCollectionEnabled;
                            userSetting2.value = Boolean.TRUE;
                            userSetting2.lastTS = System.currentTimeMillis();
                            boolean z4 = UserSettingsManager.isInitialized.get();
                            UserSettingsManager userSettingsManager4 = UserSettingsManager.INSTANCE;
                            if (z4) {
                                userSettingsManager4.writeSettingToCache(userSetting2);
                            } else {
                                userSettingsManager4.initializeIfNotInitialized();
                            }
                        } catch (Throwable th3) {
                            CrashShieldHandler.handleThrowable(UserSettingsManager.class, th3);
                        }
                        break;
                    }
                    SuncyanFacebookSdk.msInitialized = 1.0d;
                    Log.i(GooglePlayBillingService.TAG, "Facebook SDK initialized successfully.");
                    return;
                case 21:
                    zzbk zzbkVar = ((zzfi) this.this$0).zza.zza;
                    if (zzbkVar != null) {
                        try {
                            zzbkVar.zze(1);
                            return;
                        } catch (RemoteException e) {
                            zzo.zzk("Could not notify onAdFailedToLoad event.", e);
                            return;
                        }
                    }
                    return;
                case 22:
                    zzbk zzbkVar2 = ((zzfm) this.this$0).zza;
                    if (zzbkVar2 != null) {
                        try {
                            zzbkVar2.zze(1);
                            return;
                        } catch (RemoteException e2) {
                            zzo.zzk("Could not notify onAdFailedToLoad event.", e2);
                            return;
                        }
                    }
                    return;
                case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                    zzbmk zzbmkVar = ((zzfo) this.this$0).zza;
                    if (zzbmkVar != null) {
                        try {
                            zzbmkVar.zzb(Collections.emptyList());
                            return;
                        } catch (RemoteException e3) {
                            zzo.zzk("Could not notify onComplete event.", e3);
                            return;
                        }
                    }
                    return;
                case 24:
                    zzbxc zzbxcVar = (zzbxc) this.this$0;
                    if (zzbxcVar != null) {
                        try {
                            zzbxcVar.zze(1);
                            return;
                        } catch (RemoteException e4) {
                            zzo.zzl("#007 Could not call remote method.", e4);
                            return;
                        }
                    }
                    return;
                case 25:
                    zzac zzacVar = (zzac) this.this$0;
                    if (zzacVar.zzg) {
                        zzacVar.zzb.finish();
                        return;
                    }
                    return;
                case 26:
                    ((zzm) this.this$0).zzc();
                    return;
                case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                    Thread threadCurrentThread = Thread.currentThread();
                    zzb zzbVar = (zzb) this.this$0;
                    zzbVar.zzb = threadCurrentThread;
                    zzbVar.zza();
                    return;
                case 28:
                    run$com$google$android$gms$ads$internal$util$zzh();
                    return;
                default:
                    ((zzkt) ((zzn) this.this$0).zza).zzag();
                    return;
            }
        }

        public /* synthetic */ AnonymousClass1(Object obj, int i) {
            this.$r8$classId = i;
            this.this$0 = obj;
        }

        private final void run$androidx$room$InvalidationTracker$1() {
            ReentrantReadWriteLock.ReadLock lock = ((InvalidationTracker) this.this$0).mDatabase.mCloseLock.readLock();
            HashSet hashSetCheckUpdatedTable = null;
            try {
                try {
                    lock.lock();
                    if (!((InvalidationTracker) this.this$0).ensureInitialization()) {
                        lock.unlock();
                        return;
                    }
                    if (!((InvalidationTracker) this.this$0).mPendingRefresh.compareAndSet(true, false)) {
                        lock.unlock();
                        return;
                    }
                    if (((SQLiteDatabase) ((InvalidationTracker) this.this$0).mDatabase.mOpenHelper.getWritableDatabase().mDelegate).inTransaction()) {
                        lock.unlock();
                        return;
                    }
                    WorkDatabase_Impl workDatabase_Impl = ((InvalidationTracker) this.this$0).mDatabase;
                    if (workDatabase_Impl.mWriteAheadLoggingEnabled) {
                        FrameworkSQLiteProgram writableDatabase = workDatabase_Impl.mOpenHelper.getWritableDatabase();
                        writableDatabase.beginTransaction();
                        try {
                            hashSetCheckUpdatedTable = checkUpdatedTable();
                            writableDatabase.setTransactionSuccessful();
                            writableDatabase.endTransaction();
                        } catch (Throwable th) {
                            writableDatabase.endTransaction();
                            throw th;
                        }
                    } else {
                        hashSetCheckUpdatedTable = checkUpdatedTable();
                    }
                    lock.unlock();
                    if (hashSetCheckUpdatedTable == null || hashSetCheckUpdatedTable.isEmpty()) {
                        return;
                    }
                    synchronized (((InvalidationTracker) this.this$0).mObserverMap) {
                        try {
                            SafeIterableMap.AscendingIterator ascendingIterator = (SafeIterableMap.AscendingIterator) ((InvalidationTracker) this.this$0).mObserverMap.iterator();
                            if (ascendingIterator.hasNext()) {
                                ((InvalidationTracker.ObserverWrapper) ((Map.Entry) ascendingIterator.next()).getValue()).getClass();
                                throw null;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                } catch (SQLiteException e) {
                    e = e;
                    Log.e(QTaELkFI.HXOMnPjxvTP, "Cannot run invalidation tracker. Is the db closed?", e);
                } catch (IllegalStateException e2) {
                    e = e2;
                    Log.e(QTaELkFI.HXOMnPjxvTP, "Cannot run invalidation tracker. Is the db closed?", e);
                }
            } catch (Throwable th3) {
                lock.unlock();
                throw th3;
            }
        }

        public AnonymousClass1(zzfi zzfiVar) {
            this.$r8$classId = 21;
            Objects.requireNonNull(zzfiVar);
            this.this$0 = zzfiVar;
        }

        public AnonymousClass1(zzfm zzfmVar) {
            this.$r8$classId = 22;
            Objects.requireNonNull(zzfmVar);
            this.this$0 = zzfmVar;
        }

        public AnonymousClass1(zzb zzbVar) {
            this.$r8$classId = 27;
            Objects.requireNonNull(zzbVar);
            this.this$0 = zzbVar;
        }

        public AnonymousClass1(AccessTokenCache accessTokenCache, int i) {
            this.$r8$classId = 6;
            this.this$0 = accessTokenCache;
        }
    }

    public Worker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public abstract ListenableWorker.Result doWork();

    @Override // androidx.work.ListenableWorker
    public final ListenableFuture startWork() {
        this.mFuture = new SettableFuture();
        getBackgroundExecutor().execute(new AnonymousClass1(this, 0));
        return this.mFuture;
    }
}
