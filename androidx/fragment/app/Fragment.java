package androidx.fragment.app;

import android.animation.Animator;
import android.app.Activity;
import android.app.Application;
import android.content.ClipData;
import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.webkit.WebView;
import android.widget.EditText;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.arch.core.util.Function;
import androidx.core.app.ActivityCompat;
import androidx.core.app.SharedElementCallback;
import androidx.core.content.ContextCompat;
import androidx.core.provider.FontProvider;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ContentInfoCompat$$ExternalSyntheticApiModelOutline0;
import androidx.customview.view.AbsSavedState;
import androidx.fragment.app.strictmode.FragmentReuseViolation;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.GetRetainInstanceUsageViolation;
import androidx.fragment.app.strictmode.GetTargetFragmentUsageViolation;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandleSupport$DEFAULT_ARGS_KEY$1;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.hSi.sgtsHsWT;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.loader.app.LoaderManager;
import androidx.loader.app.gv.DYYbQc;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.room.RoomOpenHelper;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.startup.StartupException;
import androidx.webkit.internal.WebViewProviderFactory;
import androidx.work.WorkContinuation;
import androidx.work.Worker;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ProxyBillingActivityV2;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsResponseListener;
import com.daerisoft.thespikerm.GooglePlayBillingService;
import com.daerisoft.thespikerm.R;
import com.daerisoft.thespikerm.YYFirebaseAuthentication;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.ProfileCache;
import com.facebook.UserSettingsManager;
import com.facebook.appevents.AppEventsLoggerImpl;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.nonagon.signalgeneration.zzbk;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.ads.zzcfg;
import com.google.android.gms.internal.ads.zzcgw;
import com.google.android.gms.internal.ads.zzdes;
import com.google.android.gms.internal.ads.zzgdj;
import com.google.android.gms.internal.measurement.zzr;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.measurement.internal.zzam;
import com.google.android.gms.measurement.internal.zzef;
import com.google.android.gms.measurement.internal.zzeh;
import com.google.android.gms.measurement.internal.zzej;
import com.google.android.gms.measurement.internal.zzen;
import com.google.android.gms.measurement.internal.zzes;
import com.google.android.gms.measurement.internal.zzfi;
import com.google.android.gms.measurement.internal.zzfr;
import com.google.android.gms.measurement.internal.zzhx;
import com.google.android.gms.measurement.internal.zzkt;
import com.google.android.gms.measurement.internal.zzla;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.common.base.JdkPattern;
import com.google.common.base.Splitter;
import com.google.common.base.Splitter$1$1;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.internal.zze;
import com.google.firebase.auth.internal.zzf;
import com.google.firebase.components.ComponentDiscovery;
import com.yoyogames.runner.RunnerJNILib;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.concurrent.onZL.mnwSv;
import org.chromium.support_lib_boundary.StaticsBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner {
    public static final Object USE_DEFAULT_TRANSITION = new Object();
    public boolean mAdded;
    public AnimationInfo mAnimationInfo;
    public Bundle mArguments;
    public int mBackStackNesting;
    public boolean mCalled;
    public ViewGroup mContainer;
    public int mContainerId;
    public SavedStateViewModelFactory mDefaultFactory;
    public boolean mDeferStart;
    public boolean mDetached;
    public int mFragmentId;
    public FragmentManager mFragmentManager;
    public boolean mFromLayout;
    public boolean mHasMenu;
    public boolean mHidden;
    public boolean mHiddenChanged;
    public FragmentActivity.HostCallbacks mHost;
    public boolean mInLayout;
    public boolean mIsCreated;
    public LayoutInflater mLayoutInflater;
    public LifecycleRegistry mLifecycleRegistry;
    public Fragment mParentFragment;
    public boolean mPerformedCreateView;
    public String mPreviousWho;
    public boolean mRemoving;
    public boolean mRestored;
    public boolean mRetainInstance;
    public boolean mRetainInstanceChangedWhileDetached;
    public Bundle mSavedFragmentState;
    public SavedStateRegistryController mSavedStateRegistryController;
    public Boolean mSavedUserVisibleHint;
    public Bundle mSavedViewRegistryState;
    public SparseArray mSavedViewState;
    public String mTag;
    public Fragment mTarget;
    public int mTargetRequestCode;
    public View mView;
    public FragmentViewLifecycleOwner mViewLifecycleOwner;
    public int mState = -1;
    public String mWho = UUID.randomUUID().toString();
    public String mTargetWho = null;
    public Boolean mIsPrimaryNavigationFragment = null;
    public FragmentManagerImpl mChildFragmentManager = new FragmentManagerImpl();
    public boolean mMenuVisible = true;
    public boolean mUserVisibleHint = true;
    public final AnonymousClass1 mPostponedDurationRunnable = new AnonymousClass1(this, 0);
    public Lifecycle.State mMaxState = Lifecycle.State.RESUMED;
    public final MutableLiveData mViewLifecycleOwnerLiveData = new MutableLiveData();
    public final AtomicInteger mNextLocalRequestCode = new AtomicInteger();
    public final ArrayList mOnPreAttachedListeners = new ArrayList();
    public final AnonymousClass2 mSavedStateAttachListener = new AnonymousClass2();

    /* JADX INFO: renamed from: androidx.fragment.app.Fragment$1 */
    /* JADX INFO: loaded from: classes.dex */
    public final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Fragment this$0;

        public /* synthetic */ AnonymousClass1(Fragment fragment, int i) {
            this.$r8$classId = i;
            this.this$0 = fragment;
        }

        @Override // java.lang.Runnable
        public final void run() {
            switch (this.$r8$classId) {
                case 0:
                    this.this$0.startPostponedEnterTransition();
                    break;
                default:
                    this.this$0.callStartTransitionListener(false);
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.Fragment$10 */
    /* JADX INFO: loaded from: classes.dex */
    public final class AnonymousClass10 extends ActivityResultLauncher {
        public final /* synthetic */ AtomicReference val$ref;

        public AnonymousClass10() {
            atomicReference = atomicReference;
        }

        @Override // androidx.activity.result.ActivityResultLauncher
        public final void launch(Object obj) {
            ActivityResultLauncher activityResultLauncher = (ActivityResultLauncher) atomicReference.get();
            if (activityResultLauncher == null) {
                throw new IllegalStateException("Operation cannot be started before fragment is in created state");
            }
            activityResultLauncher.launch(obj);
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.Fragment$2 */
    /* JADX INFO: loaded from: classes.dex */
    public final class AnonymousClass2 extends OnPreAttachedListener {
        public AnonymousClass2() {
        }

        @Override // androidx.fragment.app.Fragment.OnPreAttachedListener
        public final void onPreAttached() {
            Fragment fragment = Fragment.this;
            fragment.mSavedStateRegistryController.performAttach();
            ViewTreeLifecycleOwner.enableSavedStateHandles(fragment);
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.Fragment$5 */
    /* JADX INFO: loaded from: classes.dex */
    public final class AnonymousClass5 extends FragmentContainer {
        public AnonymousClass5() {
        }

        @Override // androidx.fragment.app.FragmentContainer
        public final View onFindViewById(int i) {
            Fragment fragment = Fragment.this;
            View view = fragment.mView;
            if (view != null) {
                return view.findViewById(i);
            }
            throw new IllegalStateException("Fragment " + fragment + " does not have a view");
        }

        @Override // androidx.fragment.app.FragmentContainer
        public final boolean onHasView() {
            return Fragment.this.mView != null;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.Fragment$6 */
    /* JADX INFO: loaded from: classes.dex */
    class AnonymousClass6 implements LifecycleEventObserver {
        public AnonymousClass6() {
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            View view;
            if (event != Lifecycle.Event.ON_STOP || (view = Fragment.this.mView) == null) {
                return;
            }
            view.cancelPendingInputEvents();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.Fragment$7 */
    public final class AnonymousClass7 implements ContentFrameLayout.OnAttachListener, Toolbar.OnMenuItemClickListener, MenuPresenter.Callback, ActionMenuView.OnMenuItemClickListener, FontProvider.ContentQueryWrapper, ContentInfoCompat.Compat, Function, ActivityResultCallback, WebViewProviderFactory, SkuDetailsResponseListener, OnCompleteListener, GraphRequest.KeyValueSerializer, zzcgw, zzgdj, zzr, zzla, zzej, Splitter.Strategy, OnFailureListener, ComponentDiscovery.RegistrarNameRetriever {
        public static AnonymousClass7 zbd;
        public final /* synthetic */ int $r8$classId;
        public final Object this$0;

        public AnonymousClass7(zzkt zzktVar, String str) {
            this.$r8$classId = 25;
            this.this$0 = zzktVar;
        }

        public static synchronized AnonymousClass7 zbc(Context context) {
            return zbf(context.getApplicationContext());
        }

        public static synchronized AnonymousClass7 zbf(Context context) {
            AnonymousClass7 anonymousClass7 = zbd;
            if (anonymousClass7 != null) {
                return anonymousClass7;
            }
            AnonymousClass7 anonymousClass8 = new AnonymousClass7(context, 1);
            zbd = anonymousClass8;
            return anonymousClass8;
        }

        @Override // androidx.arch.core.util.Function
        public Object apply() {
            Fragment fragment = (Fragment) this.this$0;
            FragmentActivity.HostCallbacks hostCallbacks = fragment.mHost;
            return hostCallbacks instanceof ActivityResultRegistryOwner ? FragmentActivity.this.getActivityResultRegistry() : fragment.requireActivity().getActivityResultRegistry();
        }

        @Override // androidx.core.provider.FontProvider.ContentQueryWrapper
        public void close() {
            ContentProviderClient contentProviderClient = (ContentProviderClient) this.this$0;
            if (contentProviderClient != null) {
                contentProviderClient.release();
            }
        }

        @Override // androidx.webkit.internal.WebViewProviderFactory
        public WebViewProviderBoundaryInterface createWebView(WebView webView) {
            return (WebViewProviderBoundaryInterface) WorkContinuation.castToSuppLibClass(WebViewProviderBoundaryInterface.class, ((WebViewProviderFactoryBoundaryInterface) this.this$0).createWebView(webView));
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ClipData getClip() {
            return ((ContentInfo) this.this$0).getClip();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getFlags() {
            return ((ContentInfo) this.this$0).getFlags();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getSource() {
            return ((ContentInfo) this.this$0).getSource();
        }

        @Override // androidx.webkit.internal.WebViewProviderFactory
        public StaticsBoundaryInterface getStatics() {
            return (StaticsBoundaryInterface) WorkContinuation.castToSuppLibClass(StaticsBoundaryInterface.class, ((WebViewProviderFactoryBoundaryInterface) this.this$0).getStatics());
        }

        @Override // androidx.webkit.internal.WebViewProviderFactory
        public String[] getWebViewFeatures() {
            return ((WebViewProviderFactoryBoundaryInterface) this.this$0).getSupportedFeatures();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ContentInfo getWrapped() {
            return (ContentInfo) this.this$0;
        }

        @Override // com.google.common.base.Splitter.Strategy
        public Iterator iterator(Splitter splitter, String str) {
            return new Splitter$1$1(splitter, str, new AnonymousClass7(((JdkPattern) this.this$0).pattern.matcher(str)));
        }

        public void logEventImplicitly(Bundle bundle, String str) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (UserSettingsManager.getAutoLogAppEventsEnabled()) {
                ((AppEventsLoggerImpl) this.this$0).logEventImplicitly(bundle, str);
            }
        }

        @Override // androidx.activity.result.ActivityResultCallback
        public void onActivityResult(Object obj) {
            switch (this.$r8$classId) {
                case 11:
                    ActivityResult activityResult = (ActivityResult) obj;
                    FragmentManagerImpl fragmentManagerImpl = (FragmentManagerImpl) this.this$0;
                    FragmentManager.LaunchedFragmentInfo launchedFragmentInfo = (FragmentManager.LaunchedFragmentInfo) fragmentManagerImpl.mLaunchedFragments.pollFirst();
                    if (launchedFragmentInfo != null) {
                        String str = launchedFragmentInfo.mWho;
                        Fragment fragmentFindFragmentByWho = fragmentManagerImpl.mFragmentStore.findFragmentByWho(str);
                        if (fragmentFindFragmentByWho != null) {
                            fragmentFindFragmentByWho.onActivityResult(launchedFragmentInfo.mRequestCode, activityResult.resultCode, activityResult.data);
                        } else {
                            Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
                        }
                    } else {
                        Log.w("FragmentManager", "No Activities were started for result for " + this);
                    }
                    break;
                default:
                    ActivityResult activityResult2 = (ActivityResult) obj;
                    ProxyBillingActivityV2 proxyBillingActivityV2 = (ProxyBillingActivityV2) this.this$0;
                    proxyBillingActivityV2.getClass();
                    Intent intent = activityResult2.data;
                    int i = zzb.zze(intent, "ProxyBillingActivityV2").zza;
                    ResultReceiver resultReceiver = proxyBillingActivityV2.zzd;
                    if (resultReceiver != null) {
                        resultReceiver.send(i, intent == null ? null : intent.getExtras());
                    }
                    int i2 = activityResult2.resultCode;
                    if (i2 != -1 || i != 0) {
                        zzb.zzk("ProxyBillingActivityV2", "External offer dialog finished with resultCode: " + i2 + " and billing's responseCode: " + i);
                    }
                    proxyBillingActivityV2.finish();
                    break;
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            if (menuBuilder instanceof SubMenuBuilder) {
                ((SubMenuBuilder) menuBuilder).mParentMenu.getRootMenu().close(false);
            }
            MenuPresenter.Callback callback = ((ActionMenuPresenter) this.this$0).mCallback;
            if (callback != null) {
                callback.onCloseMenu(menuBuilder, z);
            }
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public void onComplete(Task task) {
            if (task.isSuccessful()) {
                String token = ((GetTokenResult) task.getResult()).getToken();
                int iJCreateDsMap = RunnerJNILib.jCreateDsMap(null, null, null);
                RunnerJNILib.DsMapAddString(iJCreateDsMap, "type", "FirebaseAuthentication_IdTokenListener");
                RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "listener", ((YYFirebaseAuthentication.AnonymousClass26) this.this$0).val$listenerInd);
                RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "status", 200.0d);
                RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "withSuncyan", 1.0d);
                RunnerJNILib.DsMapAddString(iJCreateDsMap, FirebaseAnalytics.Param.VALUE, token);
                RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 70);
            }
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public void onFailure(Exception exc) {
            Log.e(zzf.zza, "Failed to get reCAPTCHA token with error [" + exc.getMessage() + "]- calling backend without app verification");
            ((TaskCompletionSource) this.this$0).setResult(new zze(null, null));
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            ActionMenuPresenter actionMenuPresenter = (ActionMenuPresenter) this.this$0;
            if (menuBuilder == actionMenuPresenter.mMenu) {
                return false;
            }
            ((SubMenuBuilder) menuBuilder).mItem.getClass();
            actionMenuPresenter.getClass();
            MenuPresenter.Callback callback = actionMenuPresenter.mCallback;
            if (callback != null) {
                return callback.onOpenSubMenu(menuBuilder);
            }
            return false;
        }

        @Override // com.android.billingclient.api.SkuDetailsResponseListener
        public void onSkuDetailsResponse(BillingResult billingResult, ArrayList arrayList) {
            if (billingResult.zza != 0) {
                try {
                    Log.w(GooglePlayBillingService.TAG, "onSkuDetailsResponse response was unsuccessful! Error Code: " + Integer.toString(billingResult.zza));
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(FirebaseAnalytics.Param.SUCCESS, false);
                    jSONObject.put("responseCode", billingResult.zza);
                    String string = jSONObject.toString();
                    int iJCreateDsMap = RunnerJNILib.jCreateDsMap(new String[]{"id"}, null, new double[]{12009.0d});
                    RunnerJNILib.DsMapAddString(iJCreateDsMap, "response_json", string);
                    RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 66);
                    return;
                } catch (JSONException unused) {
                    Log.e(GooglePlayBillingService.TAG, "Malformed JSON data from queryPurchases.");
                    return;
                }
            }
            try {
                ((GooglePlayBillingService) this.this$0).m_subSkuDetails = arrayList;
                JSONObject jSONObject2 = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    jSONArray.put(new JSONObject(((SkuDetails) it.next()).zza));
                }
                jSONObject2.put("skuDetails", jSONArray);
                jSONObject2.put(FirebaseAnalytics.Param.SUCCESS, true);
                String string2 = jSONObject2.toString();
                int iJCreateDsMap2 = RunnerJNILib.jCreateDsMap(new String[]{"id"}, null, new double[]{12009.0d});
                RunnerJNILib.DsMapAddString(iJCreateDsMap2, "response_json", string2);
                RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap2, 66);
            } catch (JSONException unused2) {
                Log.e(GooglePlayBillingService.TAG, "Malformed JSON data from queryPurchases.");
            }
        }

        @Override // androidx.core.provider.FontProvider.ContentQueryWrapper
        public Cursor query(Uri uri, String[] strArr, String[] strArr2) {
            ContentProviderClient contentProviderClient = (ContentProviderClient) this.this$0;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, "query = ?", strArr2, null, null);
            } catch (RemoteException e) {
                Log.w("FontsProvider", "Unable to query the content provider", e);
                return null;
            }
        }

        public List retrieve(Object obj) {
            Context context = (Context) obj;
            Class cls = (Class) this.this$0;
            Bundle bundle = null;
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("ComponentDiscovery", "Context has no PackageManager.");
                } else {
                    ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) cls), 128);
                    if (serviceInfo == null) {
                        Log.w("ComponentDiscovery", cls + " has no service info.");
                    } else {
                        bundle = serviceInfo.metaData;
                    }
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("ComponentDiscovery", "Application info not found.");
            }
            if (bundle == null) {
                Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (String str : bundle.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(bundle.get(str)) && str.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str.substring(31));
                }
            }
            return arrayList;
        }

        @Override // com.facebook.GraphRequest.KeyValueSerializer
        public void writeString(String str, String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ((ArrayList) this.this$0).add(String.format(Locale.US, "%s=%s", Arrays.copyOf(new Object[]{str, URLEncoder.encode(value, "UTF-8")}, 2)));
        }

        public synchronized void zbd() {
            Storage storage = (Storage) this.this$0;
            ReentrantLock reentrantLock = storage.zac;
            reentrantLock.lock();
            try {
                storage.zad.edit().clear().apply();
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        /* JADX WARN: Code duplicated, block: B:18:0x0070 A[Catch: all -> 0x00a5, TRY_LEAVE, TryCatch #3 {all -> 0x00a5, blocks: (B:15:0x0066, B:16:0x006a, B:18:0x0070, B:19:0x0076, B:20:0x0091, B:23:0x009d, B:24:0x00a4, B:28:0x00a8, B:29:0x00b8, B:31:0x00ba, B:33:0x00be, B:36:0x00c5, B:37:0x00c6), top: B:65:0x0066, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:45:0x00ef A[Catch: all -> 0x0014, SQLiteException -> 0x00ed, TryCatch #4 {SQLiteException -> 0x00ed, blocks: (B:14:0x002a, B:38:0x00ce, B:40:0x00e3, B:42:0x00e9, B:46:0x00f6, B:45:0x00ef, B:47:0x00fa, B:48:0x0102), top: B:66:0x002a, outer: #2 }] */
        /* JADX WARN: Code duplicated, block: B:50:0x012f A[Catch: all -> 0x0014, PHI: r9
  0x012f: PHI (r9v19 int) = (r9v2 int), (r9v0 int) binds: [B:13:0x0028, B:11:0x0025] A[DONT_GENERATE, DONT_INLINE], TryCatch #2 {all -> 0x0014, blocks: (B:4:0x0011, B:7:0x0017, B:50:0x012f, B:55:0x016e, B:54:0x015a, B:14:0x002a, B:38:0x00ce, B:40:0x00e3, B:42:0x00e9, B:46:0x00f6, B:45:0x00ef, B:47:0x00fa, B:48:0x0102, B:49:0x0103), top: B:64:0x0011, inners: #4 }] */
        /* JADX WARN: Code duplicated, block: B:52:0x0156  */
        /* JADX WARN: Code duplicated, block: B:54:0x015a A[Catch: all -> 0x0014, TryCatch #2 {all -> 0x0014, blocks: (B:4:0x0011, B:7:0x0017, B:50:0x012f, B:55:0x016e, B:54:0x015a, B:14:0x002a, B:38:0x00ce, B:40:0x00e3, B:42:0x00e9, B:46:0x00f6, B:45:0x00ef, B:47:0x00fa, B:48:0x0102, B:49:0x0103), top: B:64:0x0011, inners: #4 }] */
        /* JADX WARN: Code duplicated, block: B:66:0x002a A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:68:0x009d A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:71:0x009c A[SYNTHETIC] */
        @Override // com.google.android.gms.measurement.internal.zzej
        public void zza(String str, int i, IOException iOException, byte[] bArr, Map map) {
            zzen zzenVar;
            zzam zzamVar;
            long jLongValue;
            zzkt zzktVar = (zzkt) this.this$0;
            zzktVar.zzaz().zzg();
            zzktVar.zzB$1();
            if (bArr == null) {
                try {
                    bArr = new byte[0];
                } catch (Throwable th) {
                    zzktVar.zzu = false;
                    zzktVar.zzae();
                    throw th;
                }
            }
            ArrayList<Long> arrayList = zzktVar.zzy;
            zzah.checkNotNull(arrayList);
            zzktVar.zzy = null;
            if (i == 200) {
                if (iOException == null) {
                    try {
                        zzes zzesVar = zzktVar.zzk.zzc;
                        ((DefaultClock) zzktVar.zzav()).getClass();
                        zzesVar.zzb(System.currentTimeMillis());
                        zzktVar.zzk.zzd.zzb(0L);
                        zzktVar.zzag();
                        zzktVar.zzay().zzl.zzc(Integer.valueOf(i), "Successful upload. Got network response. code, size", Integer.valueOf(bArr.length));
                        zzam zzamVar2 = zzktVar.zze;
                        zzkt.zzal(zzamVar2);
                        zzamVar2.zzw();
                        try {
                            for (Long l : arrayList) {
                                try {
                                    zzamVar = zzktVar.zze;
                                    zzkt.zzal(zzamVar);
                                    jLongValue = l.longValue();
                                    zzamVar.zzg();
                                    zzamVar.zzW();
                                    try {
                                        if (zzamVar.zzh().delete("queue", "rowid=?", new String[]{String.valueOf(jLongValue)}) == 1) {
                                            throw new SQLiteException("Deleted fewer rows from queue than expected");
                                        }
                                    } catch (SQLiteException e) {
                                        zzeh zzehVar = ((zzfr) zzamVar.mBuilder).zzm;
                                        zzfr.zzR(zzehVar);
                                        zzehVar.zzd.zzb(e, "Failed to delete a bundle in a queue table");
                                        throw e;
                                    }
                                } catch (SQLiteException e2) {
                                    ArrayList arrayList2 = zzktVar.zzz;
                                    if (arrayList2 == null || !arrayList2.contains(l)) {
                                        throw e2;
                                    }
                                }
                            }
                            zzam zzamVar3 = zzktVar.zze;
                            zzkt.zzal(zzamVar3);
                            zzamVar3.zzC();
                            zzam zzamVar4 = zzktVar.zze;
                            zzkt.zzal(zzamVar4);
                            zzamVar4.zzx();
                            zzktVar.zzz = null;
                            zzenVar = zzktVar.zzd;
                            zzkt.zzal(zzenVar);
                            if (zzenVar.zza() || !zzktVar.zzai()) {
                                zzktVar.zzA = -1L;
                                zzktVar.zzag();
                            } else {
                                zzktVar.zzX();
                            }
                            zzktVar.zza = 0L;
                        } catch (Throwable th2) {
                            zzam zzamVar5 = zzktVar.zze;
                            zzkt.zzal(zzamVar5);
                            zzamVar5.zzx();
                            throw th2;
                        }
                    } catch (SQLiteException e3) {
                        zzktVar.zzay().zzd.zzb(e3, "Database error while trying to delete uploaded bundles");
                        ((DefaultClock) zzktVar.zzav()).getClass();
                        zzktVar.zza = SystemClock.elapsedRealtime();
                        zzktVar.zzay().zzl.zzb(Long.valueOf(zzktVar.zza), "Disable upload, time");
                    }
                } else {
                    zzktVar.zzay().zzl.zzc(Integer.valueOf(i), "Network upload failed. Will retry later. code, error", iOException);
                    zzes zzesVar2 = zzktVar.zzk.zzd;
                    ((DefaultClock) zzktVar.zzav()).getClass();
                    zzesVar2.zzb(System.currentTimeMillis());
                    if (i != 503 || i == 429) {
                        zzes zzesVar3 = zzktVar.zzk.zzb;
                        ((DefaultClock) zzktVar.zzav()).getClass();
                        zzesVar3.zzb(System.currentTimeMillis());
                    }
                    zzam zzamVar6 = zzktVar.zze;
                    zzkt.zzal(zzamVar6);
                    zzamVar6.zzy(arrayList);
                    zzktVar.zzag();
                }
            } else if (i == 204) {
                i = 204;
                if (iOException == null) {
                    zzes zzesVar4 = zzktVar.zzk.zzc;
                    ((DefaultClock) zzktVar.zzav()).getClass();
                    zzesVar4.zzb(System.currentTimeMillis());
                    zzktVar.zzk.zzd.zzb(0L);
                    zzktVar.zzag();
                    zzktVar.zzay().zzl.zzc(Integer.valueOf(i), "Successful upload. Got network response. code, size", Integer.valueOf(bArr.length));
                    zzam zzamVar7 = zzktVar.zze;
                    zzkt.zzal(zzamVar7);
                    zzamVar7.zzw();
                    while (r9.hasNext()) {
                        zzamVar = zzktVar.zze;
                        zzkt.zzal(zzamVar);
                        jLongValue = l.longValue();
                        zzamVar.zzg();
                        zzamVar.zzW();
                        if (zzamVar.zzh().delete("queue", "rowid=?", new String[]{String.valueOf(jLongValue)}) == 1) {
                            throw new SQLiteException("Deleted fewer rows from queue than expected");
                        }
                    }
                    zzam zzamVar8 = zzktVar.zze;
                    zzkt.zzal(zzamVar8);
                    zzamVar8.zzC();
                    zzam zzamVar9 = zzktVar.zze;
                    zzkt.zzal(zzamVar9);
                    zzamVar9.zzx();
                    zzktVar.zzz = null;
                    zzenVar = zzktVar.zzd;
                    zzkt.zzal(zzenVar);
                    if (zzenVar.zza()) {
                        zzktVar.zzA = -1L;
                        zzktVar.zzag();
                    } else {
                        zzktVar.zzA = -1L;
                        zzktVar.zzag();
                    }
                    zzktVar.zza = 0L;
                } else {
                    zzktVar.zzay().zzl.zzc(Integer.valueOf(i), "Network upload failed. Will retry later. code, error", iOException);
                    zzes zzesVar5 = zzktVar.zzk.zzd;
                    ((DefaultClock) zzktVar.zzav()).getClass();
                    zzesVar5.zzb(System.currentTimeMillis());
                    if (i != 503) {
                        zzes zzesVar6 = zzktVar.zzk.zzb;
                        ((DefaultClock) zzktVar.zzav()).getClass();
                        zzesVar6.zzb(System.currentTimeMillis());
                    } else {
                        zzes zzesVar7 = zzktVar.zzk.zzb;
                        ((DefaultClock) zzktVar.zzav()).getClass();
                        zzesVar7.zzb(System.currentTimeMillis());
                    }
                    zzam zzamVar10 = zzktVar.zze;
                    zzkt.zzal(zzamVar10);
                    zzamVar10.zzy(arrayList);
                    zzktVar.zzag();
                }
            } else {
                zzktVar.zzay().zzl.zzc(Integer.valueOf(i), "Network upload failed. Will retry later. code, error", iOException);
                zzes zzesVar8 = zzktVar.zzk.zzd;
                ((DefaultClock) zzktVar.zzav()).getClass();
                zzesVar8.zzb(System.currentTimeMillis());
                if (i != 503) {
                    zzes zzesVar9 = zzktVar.zzk.zzb;
                    ((DefaultClock) zzktVar.zzav()).getClass();
                    zzesVar9.zzb(System.currentTimeMillis());
                } else {
                    zzes zzesVar10 = zzktVar.zzk.zzb;
                    ((DefaultClock) zzktVar.zzav()).getClass();
                    zzesVar10.zzb(System.currentTimeMillis());
                }
                zzam zzamVar11 = zzktVar.zze;
                zzkt.zzal(zzamVar11);
                zzamVar11.zzy(arrayList);
                zzktVar.zzag();
            }
            zzktVar.zzu = false;
            zzktVar.zzae();
        }

        @Override // com.google.android.gms.internal.ads.zzgdj
        public /* synthetic */ void zzb(Object obj) {
            ((zzdes) this.this$0).zza((zzbk) obj);
        }

        public /* synthetic */ AnonymousClass7(Object obj, int i) {
            this.$r8$classId = i;
            this.this$0 = obj;
        }

        public String toString() {
            switch (this.$r8$classId) {
                case 8:
                    return "ContentInfoCompat{" + ((ContentInfo) this.this$0) + sgtsHsWT.TizZjqMgQcWUUj;
                default:
                    return super.toString();
            }
        }

        public AnonymousClass7(Context context, int i) {
            this.$r8$classId = i;
            switch (i) {
                case 18:
                    this.this$0 = new AppEventsLoggerImpl(context, (String) null);
                    break;
                default:
                    Storage storage = Storage.getInstance(context);
                    this.this$0 = storage;
                    storage.getSavedDefaultGoogleSignInAccount();
                    storage.getSavedDefaultGoogleSignInOptions();
                    break;
            }
        }

        public AnonymousClass7() {
            this.$r8$classId = 19;
            this.this$0 = new ConcurrentHashMap();
        }

        public AnonymousClass7(Matcher matcher) {
            this.$r8$classId = 26;
            matcher.getClass();
            this.this$0 = matcher;
        }

        public AnonymousClass7(Context context, String str) {
            this.$r8$classId = 18;
            this.this$0 = new AppEventsLoggerImpl(context, str);
        }

        public AnonymousClass7(EditText editText) {
            this.$r8$classId = 10;
            this.this$0 = new RoomOpenHelper(editText);
        }

        public AnonymousClass7(Context context, Uri uri) {
            this.$r8$classId = 7;
            this.this$0 = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        public AnonymousClass7(ContentInfo contentInfo) {
            this.$r8$classId = 8;
            contentInfo.getClass();
            this.this$0 = ContentInfoCompat$$ExternalSyntheticApiModelOutline0.m15m((Object) contentInfo);
        }

        @Override // com.google.android.gms.measurement.internal.zzla
        public void zza(String str, Bundle bundle) {
            boolean zIsEmpty = TextUtils.isEmpty(str);
            zzhx zzhxVar = (zzhx) this.this$0;
            if (zIsEmpty) {
                ((zzfr) zzhxVar.mBuilder).zzr.getClass();
                zzhxVar.zzE("auto", "_err", bundle, true, true, System.currentTimeMillis());
            } else {
                zzhxVar.getClass();
                throw new IllegalStateException("Unexpected call on client side");
            }
        }

        @Override // com.google.android.gms.internal.ads.zzgdj
        public void zza(Throwable th) {
            ((zzdes) this.this$0).zzb(th.getMessage());
        }

        @Override // com.google.android.gms.internal.ads.zzcgw
        public void zza(boolean z, int i, String str, String str2) {
            zzcfg zzcfgVar = ((zzm) this.this$0).zzd;
            if (zzcfgVar != null) {
                zzcfgVar.zzaa();
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzr
        public void zza(int i, String str, List list, boolean z, boolean z2) {
            zzef zzefVar;
            int i2 = i - 1;
            zzfi zzfiVar = (zzfi) this.this$0;
            if (i2 == 0) {
                zzeh zzehVar = ((zzfr) zzfiVar.mBuilder).zzm;
                zzfr.zzR(zzehVar);
                zzefVar = zzehVar.zzk;
            } else if (i2 != 1) {
                if (i2 == 3) {
                    zzeh zzehVar2 = ((zzfr) zzfiVar.mBuilder).zzm;
                    zzfr.zzR(zzehVar2);
                    zzefVar = zzehVar2.zzl;
                } else if (i2 != 4) {
                    zzeh zzehVar3 = ((zzfr) zzfiVar.mBuilder).zzm;
                    zzfr.zzR(zzehVar3);
                    zzefVar = zzehVar3.zzj;
                } else if (z) {
                    zzeh zzehVar4 = ((zzfr) zzfiVar.mBuilder).zzm;
                    zzfr.zzR(zzehVar4);
                    zzefVar = zzehVar4.zzh;
                } else if (!z2) {
                    zzeh zzehVar5 = ((zzfr) zzfiVar.mBuilder).zzm;
                    zzfr.zzR(zzehVar5);
                    zzefVar = zzehVar5.zzi;
                } else {
                    zzeh zzehVar6 = ((zzfr) zzfiVar.mBuilder).zzm;
                    zzfr.zzR(zzehVar6);
                    zzefVar = zzehVar6.zzg;
                }
            } else if (z) {
                zzeh zzehVar7 = ((zzfr) zzfiVar.mBuilder).zzm;
                zzfr.zzR(zzehVar7);
                zzefVar = zzehVar7.zze;
            } else if (!z2) {
                zzeh zzehVar8 = ((zzfr) zzfiVar.mBuilder).zzm;
                zzfr.zzR(zzehVar8);
                zzefVar = zzehVar8.zzf;
            } else {
                zzeh zzehVar9 = ((zzfr) zzfiVar.mBuilder).zzm;
                zzfr.zzR(zzehVar9);
                zzefVar = zzehVar9.zzd;
            }
            int size = list.size();
            if (size == 1) {
                zzefVar.zzb(list.get(0), str);
                return;
            }
            if (size == 2) {
                zzefVar.zzc(list.get(0), str, list.get(1));
            } else if (size != 3) {
                zzefVar.zza(str);
            } else {
                zzefVar.zzd(str, list.get(0), list.get(1), list.get(2));
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.Fragment$9 */
    /* JADX INFO: loaded from: classes.dex */
    public final class AnonymousClass9 extends OnPreAttachedListener {
        public final /* synthetic */ ActivityResultCallback val$callback;
        public final /* synthetic */ ActivityResultContract val$contract;
        public final /* synthetic */ AtomicReference val$ref;
        public final /* synthetic */ Function val$registryProvider;

        public AnonymousClass9() {
            function = function;
            atomicReference = atomicReference;
            activityResultContract = activityResultContract;
            activityResultCallback = activityResultCallback;
        }

        @Override // androidx.fragment.app.Fragment.OnPreAttachedListener
        public final void onPreAttached() {
            StringBuilder sb = new StringBuilder("fragment_");
            Fragment fragment = Fragment.this;
            sb.append(fragment.mWho);
            sb.append("_rq#");
            sb.append(fragment.mNextLocalRequestCode.getAndIncrement());
            atomicReference.set(((ActivityResultRegistry) function.apply()).register(sb.toString(), fragment, activityResultContract, activityResultCallback));
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public final class AnimationInfo {
        public Boolean mAllowEnterTransitionOverlap;
        public Boolean mAllowReturnTransitionOverlap;
        public int mEnterAnim;
        public Object mEnterTransition;
        public boolean mEnterTransitionPostponed;
        public int mExitAnim;
        public Object mExitTransition;
        public View mFocusedView;
        public boolean mIsPop;
        public int mNextTransition;
        public int mPopEnterAnim;
        public int mPopExitAnim;
        public float mPostOnViewCreatedAlpha;
        public Object mReenterTransition;
        public Object mReturnTransition;
        public Object mSharedElementEnterTransition;
        public Object mSharedElementReturnTransition;
        public ArrayList mSharedElementSourceNames;
        public ArrayList mSharedElementTargetNames;
    }

    /* JADX INFO: loaded from: classes.dex */
    public abstract class OnPreAttachedListener {
        public abstract void onPreAttached();
    }

    /* JADX INFO: loaded from: classes.dex */
    public final class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new AbsSavedState.AnonymousClass2(2);
        public final Bundle mState;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            Bundle bundle = parcel.readBundle();
            this.mState = bundle;
            if (classLoader == null || bundle == null) {
                return;
            }
            bundle.setClassLoader(classLoader);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.mState);
        }
    }

    public Fragment() {
        initLifecycle();
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str) {
        return instantiate(context, str, null);
    }

    public final void callStartTransitionListener(boolean z) {
        ViewGroup viewGroup;
        FragmentManager fragmentManager;
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo != null) {
            animationInfo.mEnterTransitionPostponed = false;
        }
        if (this.mView == null || (viewGroup = this.mContainer) == null || (fragmentManager = this.mFragmentManager) == null) {
            return;
        }
        DefaultSpecialEffectsController orCreateController = DefaultSpecialEffectsController.getOrCreateController(viewGroup, fragmentManager.getSpecialEffectsControllerFactory());
        orCreateController.markPostponedState();
        if (z) {
            this.mHost.mHandler.post(new Worker.AnonymousClass1(orCreateController, 11));
        } else {
            orCreateController.executePendingOperations();
        }
    }

    public FragmentContainer createFragmentContainer() {
        return new AnonymousClass5();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.mSavedViewRegistryState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.mSavedViewRegistryState);
        }
        Fragment targetFragment = getTargetFragment(false);
        if (targetFragment != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(targetFragment);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        AnimationInfo animationInfo = this.mAnimationInfo;
        printWriter.println(animationInfo == null ? false : animationInfo.mIsPop);
        AnimationInfo animationInfo2 = this.mAnimationInfo;
        if ((animationInfo2 == null ? 0 : animationInfo2.mEnterAnim) != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            AnimationInfo animationInfo3 = this.mAnimationInfo;
            printWriter.println(animationInfo3 == null ? 0 : animationInfo3.mEnterAnim);
        }
        AnimationInfo animationInfo4 = this.mAnimationInfo;
        if ((animationInfo4 == null ? 0 : animationInfo4.mExitAnim) != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            AnimationInfo animationInfo5 = this.mAnimationInfo;
            printWriter.println(animationInfo5 == null ? 0 : animationInfo5.mExitAnim);
        }
        AnimationInfo animationInfo6 = this.mAnimationInfo;
        if ((animationInfo6 == null ? 0 : animationInfo6.mPopEnterAnim) != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            AnimationInfo animationInfo7 = this.mAnimationInfo;
            printWriter.println(animationInfo7 == null ? 0 : animationInfo7.mPopEnterAnim);
        }
        AnimationInfo animationInfo8 = this.mAnimationInfo;
        if ((animationInfo8 == null ? 0 : animationInfo8.mPopExitAnim) != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            AnimationInfo animationInfo9 = this.mAnimationInfo;
            printWriter.println(animationInfo9 != null ? animationInfo9.mPopExitAnim : 0);
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (getContext() != null) {
            LoaderManager.getInstance(this).dump(str, printWriter);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.mChildFragmentManager + ":");
        this.mChildFragmentManager.dump(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(str, "  "), fileDescriptor, printWriter, strArr);
    }

    public final AnimationInfo ensureAnimationInfo() {
        if (this.mAnimationInfo == null) {
            AnimationInfo animationInfo = new AnimationInfo();
            animationInfo.mEnterTransition = null;
            Object obj = USE_DEFAULT_TRANSITION;
            animationInfo.mReturnTransition = obj;
            animationInfo.mExitTransition = null;
            animationInfo.mReenterTransition = obj;
            animationInfo.mSharedElementEnterTransition = null;
            animationInfo.mSharedElementReturnTransition = obj;
            animationInfo.mPostOnViewCreatedAlpha = 1.0f;
            animationInfo.mFocusedView = null;
            this.mAnimationInfo = animationInfo;
        }
        return this.mAnimationInfo;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final FragmentActivity getActivity() {
        FragmentActivity.HostCallbacks hostCallbacks = this.mHost;
        if (hostCallbacks == null) {
            return null;
        }
        return hostCallbacks.mActivity;
    }

    public boolean getAllowEnterTransitionOverlap() {
        Boolean bool;
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null || (bool = animationInfo.mAllowEnterTransitionOverlap) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean getAllowReturnTransitionOverlap() {
        Boolean bool;
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null || (bool = animationInfo.mAllowReturnTransitionOverlap) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final FragmentManager getChildFragmentManager() {
        if (this.mHost != null) {
            return this.mChildFragmentManager;
        }
        throw new IllegalStateException(Fragment$$ExternalSyntheticOutline0.m("Fragment ", this, " has not been attached yet."));
    }

    public Context getContext() {
        FragmentActivity.HostCallbacks hostCallbacks = this.mHost;
        if (hostCallbacks == null) {
            return null;
        }
        return hostCallbacks.mContext;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        Application application;
        Context applicationContext = requireContext().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        if (application == null && Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        }
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(0);
        LinkedHashMap linkedHashMap = mutableCreationExtras.map;
        if (application != null) {
            linkedHashMap.put(SavedStateHandleSupport$DEFAULT_ARGS_KEY$1.INSTANCE, application);
        }
        linkedHashMap.put(ViewTreeLifecycleOwner.SAVED_STATE_REGISTRY_OWNER_KEY, this);
        linkedHashMap.put(ViewTreeLifecycleOwner.VIEW_MODEL_STORE_OWNER_KEY, this);
        if (getArguments() != null) {
            linkedHashMap.put(ViewTreeLifecycleOwner.DEFAULT_ARGS_KEY, getArguments());
        }
        return mutableCreationExtras;
    }

    public ViewModelProvider$Factory getDefaultViewModelProviderFactory() {
        Application application;
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (this.mDefaultFactory == null) {
            Context applicationContext = requireContext().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            if (application == null && Log.isLoggable("FragmentManager", 3)) {
                Log.d("FragmentManager", "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will need CreationExtras to use AndroidViewModel with the default ViewModelProvider.Factory");
            }
            this.mDefaultFactory = new SavedStateViewModelFactory(application, this, getArguments());
        }
        return this.mDefaultFactory;
    }

    public Object getEnterTransition() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.mEnterTransition;
    }

    public Object getExitTransition() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.mExitTransition;
    }

    @Deprecated
    public final FragmentManager getFragmentManager() {
        return this.mFragmentManager;
    }

    public final Object getHost() {
        FragmentActivity.HostCallbacks hostCallbacks = this.mHost;
        if (hostCallbacks == null) {
            return null;
        }
        return FragmentActivity.this;
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        if (layoutInflater != null) {
            return layoutInflater;
        }
        LayoutInflater layoutInflaterOnGetLayoutInflater = onGetLayoutInflater(null);
        this.mLayoutInflater = layoutInflaterOnGetLayoutInflater;
        return layoutInflaterOnGetLayoutInflater;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Deprecated
    public LoaderManager getLoaderManager() {
        return LoaderManager.getInstance(this);
    }

    public final int getMinimumMaxLifecycleState() {
        Lifecycle.State state = this.mMaxState;
        return (state == Lifecycle.State.INITIALIZED || this.mParentFragment == null) ? state.ordinal() : Math.min(state.ordinal(), this.mParentFragment.getMinimumMaxLifecycleState());
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public final FragmentManager getParentFragmentManager() {
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        throw new IllegalStateException(Fragment$$ExternalSyntheticOutline0.m("Fragment ", this, " not associated with a fragment manager."));
    }

    public Object getReenterTransition() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        Object obj = animationInfo.mReenterTransition;
        return obj == USE_DEFAULT_TRANSITION ? getExitTransition() : obj;
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    @Deprecated
    public final boolean getRetainInstance() {
        FragmentStrictMode.Policy policy = FragmentStrictMode.defaultPolicy;
        FragmentStrictMode.logIfDebuggingEnabled(new GetRetainInstanceUsageViolation(this, "Attempting to get retain instance for fragment " + this));
        FragmentStrictMode.getNearestPolicy(this).getClass();
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        Object obj = animationInfo.mReturnTransition;
        return obj == USE_DEFAULT_TRANSITION ? getEnterTransition() : obj;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.savedStateRegistry;
    }

    public Object getSharedElementEnterTransition() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.mSharedElementEnterTransition;
    }

    public Object getSharedElementReturnTransition() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        Object obj = animationInfo.mSharedElementReturnTransition;
        return obj == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : obj;
    }

    public final String getString(int i) {
        return getResources().getString(i);
    }

    public final String getTag() {
        return this.mTag;
    }

    @Deprecated
    public final Fragment getTargetFragment() {
        return getTargetFragment(true);
    }

    @Deprecated
    public final int getTargetRequestCode() {
        FragmentStrictMode.Policy policy = FragmentStrictMode.defaultPolicy;
        FragmentStrictMode.logIfDebuggingEnabled(new GetTargetFragmentUsageViolation(this, "Attempting to get target request code from fragment " + this));
        FragmentStrictMode.getNearestPolicy(this).getClass();
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(int i) {
        return getResources().getText(i);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public View getView() {
        return this.mView;
    }

    public LifecycleOwner getViewLifecycleOwner() {
        FragmentViewLifecycleOwner fragmentViewLifecycleOwner = this.mViewLifecycleOwner;
        if (fragmentViewLifecycleOwner != null) {
            return fragmentViewLifecycleOwner;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public LiveData getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (getMinimumMaxLifecycleState() == 1) {
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
        HashMap map = this.mFragmentManager.mNonConfig.mViewModelStores;
        ViewModelStore viewModelStore = (ViewModelStore) map.get(this.mWho);
        if (viewModelStore != null) {
            return viewModelStore;
        }
        ViewModelStore viewModelStore2 = new ViewModelStore();
        map.put(this.mWho, viewModelStore2);
        return viewModelStore2;
    }

    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final void initLifecycle() {
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        this.mSavedStateRegistryController = new SavedStateRegistryController(this);
        this.mDefaultFactory = null;
        ArrayList arrayList = this.mOnPreAttachedListeners;
        AnonymousClass2 anonymousClass2 = this.mSavedStateAttachListener;
        if (arrayList.contains(anonymousClass2)) {
            return;
        }
        if (this.mState >= 0) {
            anonymousClass2.onPreAttached();
        } else {
            arrayList.add(anonymousClass2);
        }
    }

    public final void initState() {
        initLifecycle();
        this.mPreviousWho = this.mWho;
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new FragmentManagerImpl();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        if (!this.mHidden) {
            FragmentManager fragmentManager = this.mFragmentManager;
            if (fragmentManager == null) {
                return false;
            }
            Fragment fragment = this.mParentFragment;
            fragmentManager.getClass();
            if (!(fragment == null ? false : fragment.isHidden())) {
                return false;
            }
        }
        return true;
    }

    public final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isMenuVisible() {
        if (this.mMenuVisible) {
            if (this.mFragmentManager == null) {
                return true;
            }
            Fragment fragment = this.mParentFragment;
            if (fragment == null ? true : fragment.isMenuVisible()) {
                return true;
            }
        }
        return false;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isResumed() {
        return this.mState >= 7;
    }

    public final boolean isStateSaved() {
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager == null) {
            return false;
        }
        return fragmentManager.mStateSaved || fragmentManager.mStopped;
    }

    public final boolean isVisible() {
        View view;
        return (!isAdded() || isHidden() || (view = this.mView) == null || view.getWindowToken() == null || this.mView.getVisibility() != 0) ? false : true;
    }

    @Deprecated
    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i + " resultCode: " + i2 + " data: " + intent);
        }
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        FragmentActivity.HostCallbacks hostCallbacks = this.mHost;
        FragmentActivity fragmentActivity = hostCallbacks == null ? null : hostCallbacks.mActivity;
        if (fragmentActivity != null) {
            this.mCalled = false;
            onAttach((Activity) fragmentActivity);
        }
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState(bundle);
        FragmentManagerImpl fragmentManagerImpl = this.mChildFragmentManager;
        if (fragmentManagerImpl.mCurState >= 1) {
            return;
        }
        fragmentManagerImpl.mStateSaved = false;
        fragmentManagerImpl.mStopped = false;
        fragmentManagerImpl.mNonConfig.mIsStateSaved = false;
        fragmentManagerImpl.dispatchStateChange(1);
    }

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        return null;
    }

    public Animator onCreateAnimator(int i, boolean z, int i2) {
        return null;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Deprecated
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    @Deprecated
    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    public void onHiddenChanged(boolean z) {
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        FragmentActivity.HostCallbacks hostCallbacks = this.mHost;
        FragmentActivity fragmentActivity = hostCallbacks == null ? null : hostCallbacks.mActivity;
        if (fragmentActivity != null) {
            this.mCalled = false;
            onInflate((Activity) fragmentActivity, attributeSet, bundle);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean z) {
    }

    @Deprecated
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    @Deprecated
    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean z) {
    }

    @Deprecated
    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean z) {
    }

    @Deprecated
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    public void onResume() {
        this.mCalled = true;
    }

    public abstract void onSaveInstanceState(Bundle bundle);

    public void onStart() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new FragmentViewLifecycleOwner(this, getViewModelStore());
        View viewOnCreateView = onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = viewOnCreateView;
        if (viewOnCreateView == null) {
            if (this.mViewLifecycleOwner.mLifecycleRegistry != null) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.mViewLifecycleOwner = null;
            return;
        }
        this.mViewLifecycleOwner.initialize();
        ViewTreeLifecycleOwner.set(this.mView, this.mViewLifecycleOwner);
        View view = this.mView;
        FragmentViewLifecycleOwner fragmentViewLifecycleOwner = this.mViewLifecycleOwner;
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setTag(R.id.view_tree_view_model_store_owner, fragmentViewLifecycleOwner);
        Protocol.Companion.set(this.mView, this.mViewLifecycleOwner);
        this.mViewLifecycleOwnerLiveData.setValue(this.mViewLifecycleOwner);
    }

    public void postponeEnterTransition() {
        ensureAnimationInfo().mEnterTransitionPostponed = true;
    }

    public final AnonymousClass10 prepareCallInternal(ActivityResultContract activityResultContract, Function function, ActivityResultCallback activityResultCallback) {
        if (this.mState > 1) {
            throw new IllegalStateException(Fragment$$ExternalSyntheticOutline0.m("Fragment ", this, " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate())."));
        }
        AtomicReference atomicReference = new AtomicReference();
        AnonymousClass9 anonymousClass9 = new OnPreAttachedListener() { // from class: androidx.fragment.app.Fragment.9
            public final /* synthetic */ ActivityResultCallback val$callback;
            public final /* synthetic */ ActivityResultContract val$contract;
            public final /* synthetic */ AtomicReference val$ref;
            public final /* synthetic */ Function val$registryProvider;

            public AnonymousClass9() {
                function = function;
                atomicReference = atomicReference;
                activityResultContract = activityResultContract;
                activityResultCallback = activityResultCallback;
            }

            @Override // androidx.fragment.app.Fragment.OnPreAttachedListener
            public final void onPreAttached() {
                StringBuilder sb = new StringBuilder("fragment_");
                Fragment fragment = Fragment.this;
                sb.append(fragment.mWho);
                sb.append("_rq#");
                sb.append(fragment.mNextLocalRequestCode.getAndIncrement());
                atomicReference.set(((ActivityResultRegistry) function.apply()).register(sb.toString(), fragment, activityResultContract, activityResultCallback));
            }
        };
        if (this.mState >= 0) {
            anonymousClass9.onPreAttached();
        } else {
            this.mOnPreAttachedListeners.add(anonymousClass9);
        }
        return new ActivityResultLauncher() { // from class: androidx.fragment.app.Fragment.10
            public final /* synthetic */ AtomicReference val$ref;

            public AnonymousClass10() {
                atomicReference = atomicReference;
            }

            @Override // androidx.activity.result.ActivityResultLauncher
            public final void launch(Object obj) {
                ActivityResultLauncher activityResultLauncher = (ActivityResultLauncher) atomicReference.get();
                if (activityResultLauncher == null) {
                    throw new IllegalStateException("Operation cannot be started before fragment is in created state");
                }
                activityResultLauncher.launch(obj);
            }
        };
    }

    public final <I, O> ActivityResultLauncher registerForActivityResult(ActivityResultContract activityResultContract, ActivityResultCallback activityResultCallback) {
        return prepareCallInternal(activityResultContract, new AnonymousClass7(this, 0), activityResultCallback);
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    @Deprecated
    public final void requestPermissions(String[] strArr, int i) {
        if (this.mHost == null) {
            throw new IllegalStateException(Fragment$$ExternalSyntheticOutline0.m("Fragment ", this, " not attached to Activity"));
        }
        FragmentManager parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.mRequestPermissions == null) {
            parentFragmentManager.mHost.getClass();
            return;
        }
        parentFragmentManager.mLaunchedFragments.addLast(new FragmentManager.LaunchedFragmentInfo(this.mWho, i));
        parentFragmentManager.mRequestPermissions.launch(strArr);
    }

    public final FragmentActivity requireActivity() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException(Fragment$$ExternalSyntheticOutline0.m("Fragment ", this, " not attached to an activity."));
    }

    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalStateException(Fragment$$ExternalSyntheticOutline0.m("Fragment ", this, " does not have any arguments."));
    }

    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException(Fragment$$ExternalSyntheticOutline0.m("Fragment ", this, " not attached to a context."));
    }

    @Deprecated
    public final FragmentManager requireFragmentManager() {
        return getParentFragmentManager();
    }

    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        throw new IllegalStateException(Fragment$$ExternalSyntheticOutline0.m("Fragment ", this, " not attached to a host."));
    }

    public final Fragment requireParentFragment() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        if (getContext() == null) {
            throw new IllegalStateException(Fragment$$ExternalSyntheticOutline0.m("Fragment ", this, " is not attached to any Fragment or host"));
        }
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
    }

    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        throw new IllegalStateException(Fragment$$ExternalSyntheticOutline0.m("Fragment ", this, " did not return a View from onCreateView() or this was called before onCreateView()."));
    }

    public final void restoreChildFragmentState(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.mChildFragmentManager.restoreSaveStateInternal(parcelable);
        FragmentManagerImpl fragmentManagerImpl = this.mChildFragmentManager;
        fragmentManagerImpl.mStateSaved = false;
        fragmentManagerImpl.mStopped = false;
        fragmentManagerImpl.mNonConfig.mIsStateSaved = false;
        fragmentManagerImpl.dispatchStateChange(1);
    }

    public void setAllowEnterTransitionOverlap(boolean z) {
        ensureAnimationInfo().mAllowEnterTransitionOverlap = Boolean.valueOf(z);
    }

    public void setAllowReturnTransitionOverlap(boolean z) {
        ensureAnimationInfo().mAllowReturnTransitionOverlap = Boolean.valueOf(z);
    }

    public final void setAnimations(int i, int i2, int i3, int i4) {
        if (this.mAnimationInfo == null && i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            return;
        }
        ensureAnimationInfo().mEnterAnim = i;
        ensureAnimationInfo().mExitAnim = i2;
        ensureAnimationInfo().mPopEnterAnim = i3;
        ensureAnimationInfo().mPopExitAnim = i4;
    }

    public void setArguments(Bundle bundle) {
        if (this.mFragmentManager != null && isStateSaved()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.mArguments = bundle;
    }

    public void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        ensureAnimationInfo().getClass();
    }

    public void setEnterTransition(Object obj) {
        ensureAnimationInfo().mEnterTransition = obj;
    }

    public void setExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        ensureAnimationInfo().getClass();
    }

    public void setExitTransition(Object obj) {
        ensureAnimationInfo().mExitTransition = obj;
    }

    @Deprecated
    public void setHasOptionsMenu(boolean z) {
        if (this.mHasMenu != z) {
            this.mHasMenu = z;
            if (!isAdded() || isHidden()) {
                return;
            }
            FragmentActivity.this.invalidateOptionsMenu();
        }
    }

    public void setInitialSavedState(SavedState savedState) {
        Bundle bundle;
        if (this.mFragmentManager != null) {
            throw new IllegalStateException("Fragment already added");
        }
        if (savedState == null || (bundle = savedState.mState) == null) {
            bundle = null;
        }
        this.mSavedFragmentState = bundle;
    }

    public void setMenuVisibility(boolean z) {
        if (this.mMenuVisible != z) {
            this.mMenuVisible = z;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                FragmentActivity.this.invalidateOptionsMenu();
            }
        }
    }

    public void setReenterTransition(Object obj) {
        ensureAnimationInfo().mReenterTransition = obj;
    }

    @Deprecated
    public void setRetainInstance(boolean z) {
        FragmentStrictMode.Policy policy = FragmentStrictMode.defaultPolicy;
        FragmentStrictMode.logIfDebuggingEnabled(new GetRetainInstanceUsageViolation(this, "Attempting to set retain instance for fragment " + this));
        FragmentStrictMode.getNearestPolicy(this).getClass();
        this.mRetainInstance = z;
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager == null) {
            this.mRetainInstanceChangedWhileDetached = true;
        } else if (z) {
            fragmentManager.mNonConfig.addRetainedFragment(this);
        } else {
            fragmentManager.mNonConfig.removeRetainedFragment(this);
        }
    }

    public void setReturnTransition(Object obj) {
        ensureAnimationInfo().mReturnTransition = obj;
    }

    public void setSharedElementEnterTransition(Object obj) {
        ensureAnimationInfo().mSharedElementEnterTransition = obj;
    }

    public void setSharedElementReturnTransition(Object obj) {
        ensureAnimationInfo().mSharedElementReturnTransition = obj;
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        FragmentActivity.HostCallbacks hostCallbacks = this.mHost;
        if (hostCallbacks != null) {
            return ActivityCompat.shouldShowRequestPermissionRationale(FragmentActivity.this, str);
        }
        return false;
    }

    public void startActivity(Intent intent) {
        startActivity(intent, null);
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i) {
        startActivityForResult(intent, i, null);
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        Intent intent2 = intent;
        if (this.mHost == null) {
            throw new IllegalStateException(Fragment$$ExternalSyntheticOutline0.m("Fragment ", this, " not attached to Activity"));
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in startIntentSenderForResult() requestCode: " + i + " IntentSender: " + intentSender + " fillInIntent: " + intent + " options: " + bundle);
        }
        FragmentManager parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.mStartIntentSenderForResult == null) {
            FragmentActivity.HostCallbacks hostCallbacks = parentFragmentManager.mHost;
            if (i == -1) {
                hostCallbacks.mActivity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
                return;
            } else {
                hostCallbacks.getClass();
                throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
            }
        }
        if (bundle != null) {
            if (intent2 == null) {
                intent2 = new Intent();
                intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
            }
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "ActivityOptions " + bundle + " were added to fillInIntent " + intent2 + " for fragment " + this);
            }
            intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        Intrinsics.checkNotNullParameter(intentSender, "intentSender");
        IntentSenderRequest intentSenderRequest = new IntentSenderRequest(intentSender, intent2, i2, i3);
        parentFragmentManager.mLaunchedFragments.addLast(new FragmentManager.LaunchedFragmentInfo(this.mWho, i));
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Fragment " + this + "is launching an IntentSender for result ");
        }
        parentFragmentManager.mStartIntentSenderForResult.launch(intentSenderRequest);
    }

    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo == null || !ensureAnimationInfo().mEnterTransitionPostponed) {
            return;
        }
        if (this.mHost == null) {
            ensureAnimationInfo().mEnterTransitionPostponed = false;
        } else if (Looper.myLooper() != this.mHost.mHandler.getLooper()) {
            this.mHost.mHandler.postAtFrontOfQueue(new AnonymousClass1(this, 1));
        } else {
            callStartTransitionListener(true);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} (");
        sb.append(this.mWho);
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" tag=");
            sb.append(this.mTag);
        }
        sb.append(")");
        return sb.toString();
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str, Bundle bundle) {
        try {
            Fragment fragment = (Fragment) FragmentManager.AnonymousClass3.loadFragmentClass(context.getClassLoader(), str).getConstructor(null).newInstance(null);
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.setArguments(bundle);
            }
            return fragment;
        } catch (IllegalAccessException e) {
            throw new StartupException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e);
        } catch (InstantiationException e2) {
            throw new StartupException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e2);
        } catch (NoSuchMethodException e3) {
            throw new StartupException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e3);
        } catch (InvocationTargetException e4) {
            throw new StartupException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e4);
        }
    }

    public final String getString(int i, Object... objArr) {
        return getResources().getString(i, objArr);
    }

    public final Fragment getTargetFragment(boolean z) {
        String str;
        if (z) {
            FragmentStrictMode.Policy policy = FragmentStrictMode.defaultPolicy;
            FragmentStrictMode.logIfDebuggingEnabled(new GetTargetFragmentUsageViolation(this, "Attempting to get target fragment from fragment " + this));
            FragmentStrictMode.getNearestPolicy(this).getClass();
        }
        Fragment fragment = this.mTarget;
        if (fragment != null) {
            return fragment;
        }
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager == null || (str = this.mTargetWho) == null) {
            return null;
        }
        return fragmentManager.mFragmentStore.findActiveFragment(str);
    }

    public final void postponeEnterTransition(long j, TimeUnit timeUnit) {
        ensureAnimationInfo().mEnterTransitionPostponed = true;
        FragmentManager fragmentManager = this.mFragmentManager;
        Handler handler = fragmentManager != null ? fragmentManager.mHost.mHandler : new Handler(Looper.getMainLooper());
        AnonymousClass1 anonymousClass1 = this.mPostponedDurationRunnable;
        handler.removeCallbacks(anonymousClass1);
        handler.postDelayed(anonymousClass1, timeUnit.toMillis(j));
    }

    public final <I, O> ActivityResultLauncher registerForActivityResult(ActivityResultContract activityResultContract, ActivityResultRegistry activityResultRegistry, ActivityResultCallback activityResultCallback) {
        return prepareCallInternal(activityResultContract, new ProfileCache(activityResultRegistry, 11), activityResultCallback);
    }

    @Deprecated
    public void setTargetFragment(Fragment fragment, int i) {
        if (fragment != null) {
            FragmentStrictMode.Policy policy = FragmentStrictMode.defaultPolicy;
            FragmentStrictMode.logIfDebuggingEnabled(new GetTargetFragmentUsageViolation(this, "Attempting to set target fragment " + fragment + " with request code " + i + " for fragment " + this));
            FragmentStrictMode.getNearestPolicy(this).getClass();
        }
        FragmentManager fragmentManager = this.mFragmentManager;
        FragmentManager fragmentManager2 = fragment != null ? fragment.mFragmentManager : null;
        if (fragmentManager != null && fragmentManager2 != null && fragmentManager != fragmentManager2) {
            throw new IllegalArgumentException(Fragment$$ExternalSyntheticOutline0.m("Fragment ", fragment, DYYbQc.LpiQyvFe));
        }
        for (Fragment targetFragment = fragment; targetFragment != null; targetFragment = targetFragment.getTargetFragment(false)) {
            if (targetFragment.equals(this)) {
                throw new IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create a target cycle");
            }
        }
        if (fragment == null) {
            this.mTargetWho = null;
            this.mTarget = null;
        } else if (this.mFragmentManager == null || fragment.mFragmentManager == null) {
            this.mTargetWho = null;
            this.mTarget = fragment;
        } else {
            this.mTargetWho = fragment.mWho;
            this.mTarget = null;
        }
        this.mTargetRequestCode = i;
    }

    @Deprecated
    public void setUserVisibleHint(boolean z) {
        FragmentStrictMode.Policy policy = FragmentStrictMode.defaultPolicy;
        FragmentStrictMode.logIfDebuggingEnabled(new FragmentReuseViolation(this, mnwSv.THWMGqHrI + z + " for fragment " + this));
        FragmentStrictMode.getNearestPolicy(this).getClass();
        boolean z2 = false;
        if (!this.mUserVisibleHint && z && this.mState < 5 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            FragmentManager fragmentManager = this.mFragmentManager;
            FragmentStateManager fragmentStateManagerCreateOrGetFragmentStateManager = fragmentManager.createOrGetFragmentStateManager(this);
            Fragment fragment = fragmentStateManagerCreateOrGetFragmentStateManager.mFragment;
            if (fragment.mDeferStart) {
                if (fragmentManager.mExecutingActions) {
                    fragmentManager.mHavePendingDeferredStart = true;
                } else {
                    fragment.mDeferStart = false;
                    fragmentStateManagerCreateOrGetFragmentStateManager.moveToExpectedState();
                }
            }
        }
        this.mUserVisibleHint = z;
        if (this.mState < 5 && !z) {
            z2 = true;
        }
        this.mDeferStart = z2;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(z);
        }
    }

    public void startActivity(Intent intent, Bundle bundle) {
        FragmentActivity.HostCallbacks hostCallbacks = this.mHost;
        if (hostCallbacks == null) {
            throw new IllegalStateException(Fragment$$ExternalSyntheticOutline0.m("Fragment ", this, " not attached to Activity"));
        }
        ContextCompat.startActivity(hostCallbacks.mContext, intent, bundle);
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (this.mHost == null) {
            throw new IllegalStateException(Fragment$$ExternalSyntheticOutline0.m("Fragment ", this, " not attached to Activity"));
        }
        FragmentManager parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.mStartActivityForResult == null) {
            FragmentActivity.HostCallbacks hostCallbacks = parentFragmentManager.mHost;
            if (i == -1) {
                ContextCompat.startActivity(hostCallbacks.mContext, intent, bundle);
                return;
            } else {
                hostCallbacks.getClass();
                throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
            }
        }
        parentFragmentManager.mLaunchedFragments.addLast(new FragmentManager.LaunchedFragmentInfo(this.mWho, i));
        if (intent != null && bundle != null) {
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        parentFragmentManager.mStartActivityForResult.launch(intent);
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        FragmentActivity.HostCallbacks hostCallbacks = this.mHost;
        if (hostCallbacks != null) {
            FragmentActivity fragmentActivity = FragmentActivity.this;
            LayoutInflater layoutInflaterCloneInContext = fragmentActivity.getLayoutInflater().cloneInContext(fragmentActivity);
            layoutInflaterCloneInContext.setFactory2(this.mChildFragmentManager.mLayoutInflaterFactory);
            return layoutInflaterCloneInContext;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }
}
