package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.Cancellable;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.content.ContextCompat;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.hSi.sgtsHsWT;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.room.RoomOpenHelper;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.startup.StartupException;
import androidx.work.InputMergerFactory$1;
import androidx.work.Worker;
import com.daerisoft.thespikerm.R;
import com.facebook.AccessTokenCache;
import com.facebook.ProfileCache;
import com.google.android.datatransport.runtime.dagger.internal.InstanceFactory;
import com.google.android.datatransport.runtime.synchronization.JDyk.FETmZwrVHuasmL;
import com.google.android.gms.ads.jY.UUFMQdNK;
import com.google.android.gms.ads.rewarded.zQ.yzwzcWHcnH;
import com.google.firebase.analytics.connector.pDv.PZmDzEagKNdW;
import com.google.firebase.auth.zzaa;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Dispatcher;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FragmentManager {
    public ArrayList mBackStack;
    public FragmentContainer mContainer;
    public ArrayList mCreatedMenus;
    public int mCurState;
    public final InputMergerFactory$1 mDefaultSpecialEffectsControllerFactory;
    public boolean mDestroyed;
    public final Worker.AnonymousClass1 mExecCommit;
    public boolean mExecutingActions;
    public boolean mHavePendingDeferredStart;
    public FragmentActivity.HostCallbacks mHost;
    public final AnonymousClass3 mHostFragmentFactory;
    public ArrayDeque mLaunchedFragments;
    public final RoomOpenHelper mLifecycleCallbacksDispatcher;
    public final AnonymousClass2 mMenuProvider;
    public boolean mNeedMenuInvalidate;
    public FragmentManagerViewModel mNonConfig;
    public final CopyOnWriteArrayList mOnAttachListeners;
    public OnBackPressedDispatcher mOnBackPressedDispatcher;
    public final FragmentManager$$ExternalSyntheticLambda1 mOnConfigurationChangedListener;
    public final FragmentManager$$ExternalSyntheticLambda1 mOnMultiWindowModeChangedListener;
    public final FragmentManager$$ExternalSyntheticLambda1 mOnPictureInPictureModeChangedListener;
    public final FragmentManager$$ExternalSyntheticLambda1 mOnTrimMemoryListener;
    public Fragment mParent;
    public Fragment mPrimaryNav;
    public ActivityResultRegistry.AnonymousClass2 mRequestPermissions;
    public ActivityResultRegistry.AnonymousClass2 mStartActivityForResult;
    public ActivityResultRegistry.AnonymousClass2 mStartIntentSenderForResult;
    public boolean mStateSaved;
    public boolean mStopped;
    public ArrayList mTmpAddedFragments;
    public ArrayList mTmpIsPop;
    public ArrayList mTmpRecords;
    public final ArrayList mPendingActions = new ArrayList();
    public final Dispatcher mFragmentStore = new Dispatcher(6);
    public final FragmentLayoutInflaterFactory mLayoutInflaterFactory = new FragmentLayoutInflaterFactory(this);
    public final AnonymousClass1 mOnBackPressedCallback = new AnonymousClass1();
    public final AtomicInteger mBackStackIndex = new AtomicInteger();
    public final Map mBackStackStates = Collections.synchronizedMap(new HashMap());
    public final Map mResults = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentManager$1 */
    /* JADX INFO: loaded from: classes.dex */
    public final class AnonymousClass1 {
        public OnBackPressedDispatcher.C00081 enabledChangedCallback;
        public boolean isEnabled = false;
        public final CopyOnWriteArrayList cancellables = new CopyOnWriteArrayList();

        public AnonymousClass1() {
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentManager$2 */
    /* JADX INFO: loaded from: classes.dex */
    public final class AnonymousClass2 implements MenuProvider {
        public AnonymousClass2() {
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentManager$3 */
    /* JADX INFO: loaded from: classes.dex */
    public final class AnonymousClass3 {
        public static final SimpleArrayMap sClassCacheMap = new SimpleArrayMap();

        public AnonymousClass3() {
        }

        public static Class loadClass(ClassLoader classLoader, String str) throws ClassNotFoundException {
            SimpleArrayMap simpleArrayMap = sClassCacheMap;
            SimpleArrayMap simpleArrayMap2 = (SimpleArrayMap) simpleArrayMap.getOrDefault(classLoader, null);
            if (simpleArrayMap2 == null) {
                simpleArrayMap2 = new SimpleArrayMap();
                simpleArrayMap.put(classLoader, simpleArrayMap2);
            }
            Class cls = (Class) simpleArrayMap2.getOrDefault(str, null);
            if (cls != null) {
                return cls;
            }
            Class<?> cls2 = Class.forName(str, false, classLoader);
            simpleArrayMap2.put(str, cls2);
            return cls2;
        }

        public static Class loadFragmentClass(ClassLoader classLoader, String str) {
            try {
                return loadClass(classLoader, str);
            } catch (ClassCastException e) {
                throw new StartupException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), e);
            } catch (ClassNotFoundException e2) {
                throw new StartupException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Unable to instantiate fragment ", str, ": make sure class name exists"), e2);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentManager$6 */
    /* JADX INFO: loaded from: classes.dex */
    class AnonymousClass6 implements LifecycleEventObserver {
        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_START || event == Lifecycle.Event.ON_DESTROY) {
                throw null;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentManager$7 */
    /* JADX INFO: loaded from: classes.dex */
    public final class AnonymousClass7 implements FragmentOnAttachListener {
        public AnonymousClass7() {
        }

        @Override // androidx.fragment.app.FragmentOnAttachListener
        public final void onAttachFragment$1(Fragment fragment) {
            fragment.onAttachFragment(fragment);
        }
    }

    public final class FragmentIntentSenderContract extends ActivityResultContract {
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ FragmentIntentSenderContract(int i) {
            this.$r8$classId = i;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public InstanceFactory getSynchronousResult(Context context, Object obj) {
            switch (this.$r8$classId) {
                case 1:
                    String[] input = (String[]) obj;
                    Intrinsics.checkNotNullParameter(input, "input");
                    if (input.length == 0) {
                        return new InstanceFactory(EmptyMap.INSTANCE);
                    }
                    for (String str : input) {
                        if (ContextCompat.checkSelfPermission(context, str) != 0) {
                            return null;
                        }
                    }
                    int iMapCapacity = MapsKt__MapsKt.mapCapacity(input.length);
                    if (iMapCapacity < 16) {
                        iMapCapacity = 16;
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
                    for (String str2 : input) {
                        linkedHashMap.put(str2, Boolean.TRUE);
                    }
                    return new InstanceFactory(linkedHashMap);
                default:
                    return super.getSynchronousResult(context, obj);
            }
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Object parseResult(int i, Intent intent) {
            switch (this.$r8$classId) {
                case 0:
                    return new ActivityResult(i, intent);
                case 1:
                    EmptyMap emptyMap = EmptyMap.INSTANCE;
                    if (i != -1 || intent == null) {
                        return emptyMap;
                    }
                    String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                    int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                    if (intArrayExtra == null || stringArrayExtra == null) {
                        return emptyMap;
                    }
                    ArrayList arrayList = new ArrayList(intArrayExtra.length);
                    for (int i2 : intArrayExtra) {
                        arrayList.add(Boolean.valueOf(i2 == 0));
                    }
                    ArrayList arrayListFilterNotNull = ArraysKt.filterNotNull(stringArrayExtra);
                    Iterator it = arrayListFilterNotNull.iterator();
                    Iterator it2 = arrayList.iterator();
                    ArrayList arrayList2 = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayListFilterNotNull), CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList)));
                    while (it.hasNext() && it2.hasNext()) {
                        arrayList2.add(new Pair(it.next(), it2.next()));
                    }
                    return MapsKt__MapsKt.toMap(arrayList2);
                case 2:
                    return new ActivityResult(i, intent);
                default:
                    return new ActivityResult(i, intent);
            }
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Intent createIntent(Context context, Object obj) {
            String str;
            Bundle bundleExtra;
            switch (this.$r8$classId) {
                case 0:
                    IntentSenderRequest intentSenderRequest = (IntentSenderRequest) obj;
                    Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
                    Intent intent2 = intentSenderRequest.fillInIntent;
                    if (intent2 != null && (bundleExtra = intent2.getBundleExtra((str = yzwzcWHcnH.nLCgcwBoSRZ))) != null) {
                        intent.putExtra(str, bundleExtra);
                        intent2.removeExtra(str);
                        if (intent2.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                            IntentSender intentSender = intentSenderRequest.intentSender;
                            Intrinsics.checkNotNullParameter(intentSender, "intentSender");
                            intentSenderRequest = new IntentSenderRequest(intentSender, null, intentSenderRequest.flagsMask, intentSenderRequest.flagsValues);
                        }
                    }
                    intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", intentSenderRequest);
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Log.v("FragmentManager", sgtsHsWT.LQMhxn + intent);
                    }
                    return intent;
                case 1:
                    String[] input = (String[]) obj;
                    Intrinsics.checkNotNullParameter(input, "input");
                    Intent intentPutExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", input);
                    Intrinsics.checkNotNullExpressionValue(intentPutExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
                    return intentPutExtra;
                case 2:
                    Intent input2 = (Intent) obj;
                    Intrinsics.checkNotNullParameter(input2, "input");
                    return input2;
                default:
                    IntentSenderRequest input3 = (IntentSenderRequest) obj;
                    Intrinsics.checkNotNullParameter(input3, "input");
                    Intent intentPutExtra2 = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", input3);
                    Intrinsics.checkNotNullExpressionValue(intentPutExtra2, "Intent(ACTION_INTENT_SEN…NT_SENDER_REQUEST, input)");
                    return intentPutExtra2;
            }
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public final class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new FragmentState.AnonymousClass1(17);
        public int mRequestCode;
        public String mWho;

        public LaunchedFragmentInfo(String str, int i) {
            this.mWho = str;
            this.mRequestCode = i;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.mWho);
            parcel.writeInt(this.mRequestCode);
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public interface OpGenerator {
        boolean generateOps(ArrayList arrayList, ArrayList arrayList2);
    }

    /* JADX INFO: loaded from: classes.dex */
    public final class PopBackStackState implements OpGenerator {
        public final int mId;

        public PopBackStackState(int i) {
            this.mId = i;
        }

        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public final boolean generateOps(ArrayList arrayList, ArrayList arrayList2) {
            FragmentManager fragmentManager = FragmentManager.this;
            Fragment fragment = fragmentManager.mPrimaryNav;
            int i = this.mId;
            if (fragment == null || i >= 0 || !fragment.getChildFragmentManager().popBackStackImmediate()) {
                return fragmentManager.popBackStackState(arrayList, arrayList2, i, 1);
            }
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda1] */
    /* JADX WARN: Type inference failed for: r0v13, types: [androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda1] */
    /* JADX WARN: Type inference failed for: r0v14, types: [androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda1] */
    /* JADX WARN: Type inference failed for: r0v15, types: [androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda1] */
    public FragmentManager() {
        Collections.synchronizedMap(new HashMap());
        this.mLifecycleCallbacksDispatcher = new RoomOpenHelper(this);
        this.mOnAttachListeners = new CopyOnWriteArrayList();
        final int i = 0;
        this.mOnConfigurationChangedListener = new Consumer(this) { // from class: androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda1
            public final /* synthetic */ FragmentManager f$0;

            {
                this.f$0 = this;
            }

            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                switch (i) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        FragmentManager fragmentManager = this.f$0;
                        if (fragmentManager.isParentAdded()) {
                            fragmentManager.dispatchConfigurationChanged(false, configuration);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        FragmentManager fragmentManager2 = this.f$0;
                        if (fragmentManager2.isParentAdded() && num.intValue() == 80) {
                            fragmentManager2.dispatchLowMemory(false);
                            break;
                        }
                        break;
                    case 2:
                        MultiWindowModeChangedInfo multiWindowModeChangedInfo = (MultiWindowModeChangedInfo) obj;
                        FragmentManager fragmentManager3 = this.f$0;
                        if (fragmentManager3.isParentAdded()) {
                            fragmentManager3.dispatchMultiWindowModeChanged(multiWindowModeChangedInfo.isInMultiWindowMode, false);
                        }
                        break;
                    default:
                        PictureInPictureModeChangedInfo pictureInPictureModeChangedInfo = (PictureInPictureModeChangedInfo) obj;
                        FragmentManager fragmentManager4 = this.f$0;
                        if (fragmentManager4.isParentAdded()) {
                            fragmentManager4.dispatchPictureInPictureModeChanged(pictureInPictureModeChangedInfo.isInPictureInPictureMode, false);
                        }
                        break;
                }
            }
        };
        final int i2 = 1;
        this.mOnTrimMemoryListener = new Consumer(this) { // from class: androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda1
            public final /* synthetic */ FragmentManager f$0;

            {
                this.f$0 = this;
            }

            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                switch (i2) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        FragmentManager fragmentManager = this.f$0;
                        if (fragmentManager.isParentAdded()) {
                            fragmentManager.dispatchConfigurationChanged(false, configuration);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        FragmentManager fragmentManager2 = this.f$0;
                        if (fragmentManager2.isParentAdded() && num.intValue() == 80) {
                            fragmentManager2.dispatchLowMemory(false);
                            break;
                        }
                        break;
                    case 2:
                        MultiWindowModeChangedInfo multiWindowModeChangedInfo = (MultiWindowModeChangedInfo) obj;
                        FragmentManager fragmentManager3 = this.f$0;
                        if (fragmentManager3.isParentAdded()) {
                            fragmentManager3.dispatchMultiWindowModeChanged(multiWindowModeChangedInfo.isInMultiWindowMode, false);
                        }
                        break;
                    default:
                        PictureInPictureModeChangedInfo pictureInPictureModeChangedInfo = (PictureInPictureModeChangedInfo) obj;
                        FragmentManager fragmentManager4 = this.f$0;
                        if (fragmentManager4.isParentAdded()) {
                            fragmentManager4.dispatchPictureInPictureModeChanged(pictureInPictureModeChangedInfo.isInPictureInPictureMode, false);
                        }
                        break;
                }
            }
        };
        final int i3 = 2;
        this.mOnMultiWindowModeChangedListener = new Consumer(this) { // from class: androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda1
            public final /* synthetic */ FragmentManager f$0;

            {
                this.f$0 = this;
            }

            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                switch (i3) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        FragmentManager fragmentManager = this.f$0;
                        if (fragmentManager.isParentAdded()) {
                            fragmentManager.dispatchConfigurationChanged(false, configuration);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        FragmentManager fragmentManager2 = this.f$0;
                        if (fragmentManager2.isParentAdded() && num.intValue() == 80) {
                            fragmentManager2.dispatchLowMemory(false);
                            break;
                        }
                        break;
                    case 2:
                        MultiWindowModeChangedInfo multiWindowModeChangedInfo = (MultiWindowModeChangedInfo) obj;
                        FragmentManager fragmentManager3 = this.f$0;
                        if (fragmentManager3.isParentAdded()) {
                            fragmentManager3.dispatchMultiWindowModeChanged(multiWindowModeChangedInfo.isInMultiWindowMode, false);
                        }
                        break;
                    default:
                        PictureInPictureModeChangedInfo pictureInPictureModeChangedInfo = (PictureInPictureModeChangedInfo) obj;
                        FragmentManager fragmentManager4 = this.f$0;
                        if (fragmentManager4.isParentAdded()) {
                            fragmentManager4.dispatchPictureInPictureModeChanged(pictureInPictureModeChangedInfo.isInPictureInPictureMode, false);
                        }
                        break;
                }
            }
        };
        final int i4 = 3;
        this.mOnPictureInPictureModeChangedListener = new Consumer(this) { // from class: androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda1
            public final /* synthetic */ FragmentManager f$0;

            {
                this.f$0 = this;
            }

            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                switch (i4) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        FragmentManager fragmentManager = this.f$0;
                        if (fragmentManager.isParentAdded()) {
                            fragmentManager.dispatchConfigurationChanged(false, configuration);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        FragmentManager fragmentManager2 = this.f$0;
                        if (fragmentManager2.isParentAdded() && num.intValue() == 80) {
                            fragmentManager2.dispatchLowMemory(false);
                            break;
                        }
                        break;
                    case 2:
                        MultiWindowModeChangedInfo multiWindowModeChangedInfo = (MultiWindowModeChangedInfo) obj;
                        FragmentManager fragmentManager3 = this.f$0;
                        if (fragmentManager3.isParentAdded()) {
                            fragmentManager3.dispatchMultiWindowModeChanged(multiWindowModeChangedInfo.isInMultiWindowMode, false);
                        }
                        break;
                    default:
                        PictureInPictureModeChangedInfo pictureInPictureModeChangedInfo = (PictureInPictureModeChangedInfo) obj;
                        FragmentManager fragmentManager4 = this.f$0;
                        if (fragmentManager4.isParentAdded()) {
                            fragmentManager4.dispatchPictureInPictureModeChanged(pictureInPictureModeChangedInfo.isInPictureInPictureMode, false);
                        }
                        break;
                }
            }
        };
        this.mMenuProvider = new AnonymousClass2();
        this.mCurState = -1;
        this.mHostFragmentFactory = new AnonymousClass3();
        this.mDefaultSpecialEffectsControllerFactory = new InputMergerFactory$1(14);
        this.mLaunchedFragments = new ArrayDeque();
        this.mExecCommit = new Worker.AnonymousClass1(this, 12);
    }

    public static boolean isMenuAvailable(Fragment fragment) {
        if (!fragment.mHasMenu || !fragment.mMenuVisible) {
            boolean zIsMenuAvailable = false;
            for (Fragment fragment2 : fragment.mChildFragmentManager.mFragmentStore.getActiveFragments()) {
                if (fragment2 != null) {
                    zIsMenuAvailable = isMenuAvailable(fragment2);
                }
                if (zIsMenuAvailable) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean isPrimaryNavigation(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        return fragment.equals(fragmentManager.mPrimaryNav) && isPrimaryNavigation(fragmentManager.mParent);
    }

    public static void showFragment(Fragment fragment) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    public final FragmentStateManager addFragment(Fragment fragment) {
        String str = fragment.mPreviousWho;
        if (str != null) {
            FragmentStrictMode.onFragmentReuse(fragment, str);
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        FragmentStateManager fragmentStateManagerCreateOrGetFragmentStateManager = createOrGetFragmentStateManager(fragment);
        fragment.mFragmentManager = this;
        Dispatcher dispatcher = this.mFragmentStore;
        dispatcher.makeActive(fragmentStateManagerCreateOrGetFragmentStateManager);
        if (!fragment.mDetached) {
            dispatcher.addFragment(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (isMenuAvailable(fragment)) {
                this.mNeedMenuInvalidate = true;
            }
        }
        return fragmentStateManagerCreateOrGetFragmentStateManager;
    }

    public final void attachController(FragmentActivity.HostCallbacks hostCallbacks, FragmentContainer fragmentContainer, Fragment fragment) {
        if (this.mHost != null) {
            throw new IllegalStateException("Already attached");
        }
        this.mHost = hostCallbacks;
        this.mContainer = fragmentContainer;
        this.mParent = fragment;
        CopyOnWriteArrayList copyOnWriteArrayList = this.mOnAttachListeners;
        if (fragment != null) {
            copyOnWriteArrayList.add(new FragmentOnAttachListener() { // from class: androidx.fragment.app.FragmentManager.7
                public AnonymousClass7() {
                }

                @Override // androidx.fragment.app.FragmentOnAttachListener
                public final void onAttachFragment$1(Fragment fragment2) {
                    fragment.onAttachFragment(fragment2);
                }
            });
        } else if (hostCallbacks instanceof FragmentOnAttachListener) {
            copyOnWriteArrayList.add(hostCallbacks);
        }
        if (this.mParent != null) {
            updateOnBackPressedCallbackEnabled();
        }
        if (hostCallbacks instanceof OnBackPressedDispatcherOwner) {
            OnBackPressedDispatcher onBackPressedDispatcher = FragmentActivity.this.getOnBackPressedDispatcher();
            this.mOnBackPressedDispatcher = onBackPressedDispatcher;
            onBackPressedDispatcher.addCallback(fragment != null ? fragment : hostCallbacks, this.mOnBackPressedCallback);
        }
        if (fragment != null) {
            FragmentManagerViewModel fragmentManagerViewModel = fragment.mFragmentManager.mNonConfig;
            HashMap map = fragmentManagerViewModel.mChildNonConfigs;
            FragmentManagerViewModel fragmentManagerViewModel2 = (FragmentManagerViewModel) map.get(fragment.mWho);
            if (fragmentManagerViewModel2 == null) {
                fragmentManagerViewModel2 = new FragmentManagerViewModel(fragmentManagerViewModel.mStateAutomaticallySaved);
                map.put(fragment.mWho, fragmentManagerViewModel2);
            }
            this.mNonConfig = fragmentManagerViewModel2;
        } else if (hostCallbacks instanceof ViewModelStoreOwner) {
            zzaa zzaaVar = new zzaa(FragmentActivity.this.getViewModelStore(), FragmentManagerViewModel.FACTORY);
            String canonicalName = FragmentManagerViewModel.class.getCanonicalName();
            if (canonicalName == null) {
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            }
            this.mNonConfig = (FragmentManagerViewModel) zzaaVar.get(FragmentManagerViewModel.class, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName));
        } else {
            this.mNonConfig = new FragmentManagerViewModel(false);
        }
        FragmentManagerViewModel fragmentManagerViewModel3 = this.mNonConfig;
        fragmentManagerViewModel3.mIsStateSaved = this.mStateSaved || this.mStopped;
        this.mFragmentStore.runningSyncCalls = fragmentManagerViewModel3;
        FragmentActivity.HostCallbacks hostCallbacks2 = this.mHost;
        if ((hostCallbacks2 instanceof SavedStateRegistryOwner) && fragment == null) {
            SavedStateRegistry savedStateRegistry = FragmentActivity.this.getSavedStateRegistry();
            savedStateRegistry.registerSavedStateProvider("android:support:fragments", new FragmentManager$$ExternalSyntheticLambda5((FragmentManagerImpl) this, 0));
            Bundle bundleConsumeRestoredStateForKey = savedStateRegistry.consumeRestoredStateForKey("android:support:fragments");
            if (bundleConsumeRestoredStateForKey != null) {
                restoreSaveStateInternal(bundleConsumeRestoredStateForKey);
            }
        }
        FragmentActivity.HostCallbacks hostCallbacks3 = this.mHost;
        if (hostCallbacks3 instanceof ActivityResultRegistryOwner) {
            ActivityResultRegistry activityResultRegistry = FragmentActivity.this.getActivityResultRegistry();
            String strM$1 = CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("FragmentManager:", fragment != null ? CoroutineAdapterKt$$ExternalSyntheticLambda0.m(new StringBuilder(), fragment.mWho, ":") : "");
            FragmentManagerImpl fragmentManagerImpl = (FragmentManagerImpl) this;
            this.mStartActivityForResult = activityResultRegistry.register(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(strM$1, "StartActivityForResult"), new FragmentIntentSenderContract(2), new Fragment.AnonymousClass7(fragmentManagerImpl, 11));
            this.mStartIntentSenderForResult = activityResultRegistry.register(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(strM$1, "StartIntentSenderForResult"), new FragmentIntentSenderContract(0), new ProfileCache(fragmentManagerImpl, 12));
            this.mRequestPermissions = activityResultRegistry.register(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(strM$1, "RequestPermissions"), new FragmentIntentSenderContract(1), new AccessTokenCache(fragmentManagerImpl, 8));
        }
        FragmentActivity.HostCallbacks hostCallbacks4 = this.mHost;
        if (hostCallbacks4 instanceof OnConfigurationChangedProvider) {
            FragmentActivity.this.addOnConfigurationChangedListener(this.mOnConfigurationChangedListener);
        }
        FragmentActivity.HostCallbacks hostCallbacks5 = this.mHost;
        if (hostCallbacks5 instanceof OnTrimMemoryProvider) {
            FragmentActivity.this.addOnTrimMemoryListener(this.mOnTrimMemoryListener);
        }
        FragmentActivity.HostCallbacks hostCallbacks6 = this.mHost;
        if (hostCallbacks6 instanceof OnMultiWindowModeChangedProvider) {
            FragmentActivity.this.addOnMultiWindowModeChangedListener(this.mOnMultiWindowModeChangedListener);
        }
        FragmentActivity.HostCallbacks hostCallbacks7 = this.mHost;
        if (hostCallbacks7 instanceof OnPictureInPictureModeChangedProvider) {
            FragmentActivity.this.addOnPictureInPictureModeChangedListener(this.mOnPictureInPictureModeChangedListener);
        }
        FragmentActivity.HostCallbacks hostCallbacks8 = this.mHost;
        if ((hostCallbacks8 instanceof MenuHost) && fragment == null) {
            FragmentActivity.this.addMenuProvider(this.mMenuProvider);
        }
    }

    public final void attachFragment(Fragment fragment) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            this.mFragmentStore.addFragment(fragment);
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            if (isMenuAvailable(fragment)) {
                this.mNeedMenuInvalidate = true;
            }
        }
    }

    public final void cleanupExec() {
        this.mExecutingActions = false;
        this.mTmpIsPop.clear();
        this.mTmpRecords.clear();
    }

    public final HashSet collectAllSpecialEffectsController() {
        HashSet hashSet = new HashSet();
        Iterator it = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((FragmentStateManager) it.next()).mFragment.mContainer;
            if (viewGroup != null) {
                hashSet.add(DefaultSpecialEffectsController.getOrCreateController(viewGroup, getSpecialEffectsControllerFactory()));
            }
        }
        return hashSet;
    }

    public final FragmentStateManager createOrGetFragmentStateManager(Fragment fragment) {
        String str = fragment.mWho;
        Dispatcher dispatcher = this.mFragmentStore;
        FragmentStateManager fragmentStateManager = (FragmentStateManager) ((HashMap) dispatcher.readyAsyncCalls).get(str);
        if (fragmentStateManager != null) {
            return fragmentStateManager;
        }
        FragmentStateManager fragmentStateManager2 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, dispatcher, fragment);
        fragmentStateManager2.restoreState(this.mHost.mContext.getClassLoader());
        fragmentStateManager2.mFragmentManagerState = this.mCurState;
        return fragmentStateManager2;
    }

    public final void dispatchConfigurationChanged(boolean z, Configuration configuration) {
        if (z && (this.mHost instanceof OnConfigurationChangedProvider)) {
            throwException(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
            throw null;
        }
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null) {
                fragment.onConfigurationChanged(configuration);
                if (z) {
                    fragment.mChildFragmentManager.dispatchConfigurationChanged(true, configuration);
                }
            }
        }
    }

    public final boolean dispatchContextItemSelected(MenuItem menuItem) {
        if (this.mCurState < 1) {
            return false;
        }
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null) {
                if (fragment.mHidden ? false : fragment.onContextItemSelected(menuItem) ? true : fragment.mChildFragmentManager.dispatchContextItemSelected(menuItem)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean zDispatchCreateOptionsMenu;
        boolean z;
        if (this.mCurState < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z2 = false;
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null && fragment.isMenuVisible()) {
                if (fragment.mHidden) {
                    zDispatchCreateOptionsMenu = false;
                } else {
                    if (fragment.mHasMenu && fragment.mMenuVisible) {
                        fragment.onCreateOptionsMenu(menu, menuInflater);
                        z = true;
                    } else {
                        z = false;
                    }
                    zDispatchCreateOptionsMenu = z | fragment.mChildFragmentManager.dispatchCreateOptionsMenu(menu, menuInflater);
                }
                if (zDispatchCreateOptionsMenu) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(fragment);
                    z2 = true;
                }
            }
        }
        if (this.mCreatedMenus != null) {
            for (int i = 0; i < this.mCreatedMenus.size(); i++) {
                Fragment fragment2 = (Fragment) this.mCreatedMenus.get(i);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.mCreatedMenus = arrayList;
        return z2;
    }

    public final void dispatchDestroy() {
        boolean zIsChangingConfigurations = true;
        this.mDestroyed = true;
        execPendingActions(true);
        Iterator it = collectAllSpecialEffectsController().iterator();
        while (it.hasNext()) {
            ((DefaultSpecialEffectsController) it.next()).forceCompleteAllOperations();
        }
        FragmentActivity.HostCallbacks hostCallbacks = this.mHost;
        boolean z = hostCallbacks instanceof ViewModelStoreOwner;
        Dispatcher dispatcher = this.mFragmentStore;
        if (z) {
            zIsChangingConfigurations = ((FragmentManagerViewModel) dispatcher.runningSyncCalls).mHasBeenCleared;
        } else {
            FragmentActivity fragmentActivity = hostCallbacks.mContext;
            if (fragmentActivity instanceof Activity) {
                zIsChangingConfigurations = true ^ fragmentActivity.isChangingConfigurations();
            }
        }
        if (zIsChangingConfigurations) {
            Iterator it2 = this.mBackStackStates.values().iterator();
            while (it2.hasNext()) {
                for (String str : ((BackStackState) it2.next()).mFragments) {
                    FragmentManagerViewModel fragmentManagerViewModel = (FragmentManagerViewModel) dispatcher.runningSyncCalls;
                    fragmentManagerViewModel.getClass();
                    if (Log.isLoggable("FragmentManager", 3)) {
                        Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + str);
                    }
                    fragmentManagerViewModel.clearNonConfigStateInternal(str);
                }
            }
        }
        dispatchStateChange(-1);
        FragmentActivity.HostCallbacks hostCallbacks2 = this.mHost;
        if (hostCallbacks2 instanceof OnTrimMemoryProvider) {
            FragmentActivity.this.removeOnTrimMemoryListener(this.mOnTrimMemoryListener);
        }
        FragmentActivity.HostCallbacks hostCallbacks3 = this.mHost;
        if (hostCallbacks3 instanceof OnConfigurationChangedProvider) {
            FragmentActivity.this.removeOnConfigurationChangedListener(this.mOnConfigurationChangedListener);
        }
        FragmentActivity.HostCallbacks hostCallbacks4 = this.mHost;
        if (hostCallbacks4 instanceof OnMultiWindowModeChangedProvider) {
            FragmentActivity.this.removeOnMultiWindowModeChangedListener(this.mOnMultiWindowModeChangedListener);
        }
        FragmentActivity.HostCallbacks hostCallbacks5 = this.mHost;
        if (hostCallbacks5 instanceof OnPictureInPictureModeChangedProvider) {
            FragmentActivity.this.removeOnPictureInPictureModeChangedListener(this.mOnPictureInPictureModeChangedListener);
        }
        FragmentActivity.HostCallbacks hostCallbacks6 = this.mHost;
        if (hostCallbacks6 instanceof MenuHost) {
            FragmentActivity.this.removeMenuProvider(this.mMenuProvider);
        }
        this.mHost = null;
        this.mContainer = null;
        this.mParent = null;
        if (this.mOnBackPressedDispatcher != null) {
            Iterator it3 = this.mOnBackPressedCallback.cancellables.iterator();
            while (it3.hasNext()) {
                ((Cancellable) it3.next()).cancel();
            }
            this.mOnBackPressedDispatcher = null;
        }
        ActivityResultRegistry.AnonymousClass2 anonymousClass2 = this.mStartActivityForResult;
        if (anonymousClass2 != null) {
            anonymousClass2.unregister();
            this.mStartIntentSenderForResult.unregister();
            this.mRequestPermissions.unregister();
        }
    }

    public final void dispatchLowMemory(boolean z) {
        if (z && (this.mHost instanceof OnTrimMemoryProvider)) {
            throwException(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
            throw null;
        }
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null) {
                fragment.onLowMemory();
                if (z) {
                    fragment.mChildFragmentManager.dispatchLowMemory(true);
                }
            }
        }
    }

    public final void dispatchMultiWindowModeChanged(boolean z, boolean z2) {
        if (z2 && (this.mHost instanceof OnMultiWindowModeChangedProvider)) {
            throwException(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
            throw null;
        }
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null) {
                fragment.onMultiWindowModeChanged(z);
                if (z2) {
                    fragment.mChildFragmentManager.dispatchMultiWindowModeChanged(z, true);
                }
            }
        }
    }

    public final void dispatchOnHiddenChanged() {
        for (Fragment fragment : this.mFragmentStore.getActiveFragments()) {
            if (fragment != null) {
                fragment.onHiddenChanged(fragment.isHidden());
                fragment.mChildFragmentManager.dispatchOnHiddenChanged();
            }
        }
    }

    public final boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        if (this.mCurState < 1) {
            return false;
        }
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null) {
                if (fragment.mHidden ? false : (fragment.mHasMenu && fragment.mMenuVisible && fragment.onOptionsItemSelected(menuItem)) ? true : fragment.mChildFragmentManager.dispatchOptionsItemSelected(menuItem)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void dispatchOptionsMenuClosed(Menu menu) {
        if (this.mCurState < 1) {
            return;
        }
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null && !fragment.mHidden) {
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    fragment.onOptionsMenuClosed(menu);
                }
                fragment.mChildFragmentManager.dispatchOptionsMenuClosed(menu);
            }
        }
    }

    public final void dispatchParentPrimaryNavigationFragmentChanged(Fragment fragment) {
        if (fragment != null) {
            if (fragment.equals(this.mFragmentStore.findActiveFragment(fragment.mWho))) {
                fragment.mFragmentManager.getClass();
                boolean zIsPrimaryNavigation = isPrimaryNavigation(fragment);
                Boolean bool = fragment.mIsPrimaryNavigationFragment;
                if (bool == null || bool.booleanValue() != zIsPrimaryNavigation) {
                    fragment.mIsPrimaryNavigationFragment = Boolean.valueOf(zIsPrimaryNavigation);
                    fragment.onPrimaryNavigationFragmentChanged(zIsPrimaryNavigation);
                    FragmentManagerImpl fragmentManagerImpl = fragment.mChildFragmentManager;
                    fragmentManagerImpl.updateOnBackPressedCallbackEnabled();
                    fragmentManagerImpl.dispatchParentPrimaryNavigationFragmentChanged(fragmentManagerImpl.mPrimaryNav);
                }
            }
        }
    }

    public final void dispatchPictureInPictureModeChanged(boolean z, boolean z2) {
        if (z2 && (this.mHost instanceof OnPictureInPictureModeChangedProvider)) {
            throwException(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
            throw null;
        }
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null) {
                fragment.onPictureInPictureModeChanged(z);
                if (z2) {
                    fragment.mChildFragmentManager.dispatchPictureInPictureModeChanged(z, true);
                }
            }
        }
    }

    public final boolean dispatchPrepareOptionsMenu(Menu menu) {
        boolean zDispatchPrepareOptionsMenu;
        boolean z;
        if (this.mCurState < 1) {
            return false;
        }
        boolean z2 = false;
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null && fragment.isMenuVisible()) {
                if (fragment.mHidden) {
                    zDispatchPrepareOptionsMenu = false;
                } else {
                    if (fragment.mHasMenu && fragment.mMenuVisible) {
                        fragment.onPrepareOptionsMenu(menu);
                        z = true;
                    } else {
                        z = false;
                    }
                    zDispatchPrepareOptionsMenu = fragment.mChildFragmentManager.dispatchPrepareOptionsMenu(menu) | z;
                }
                if (zDispatchPrepareOptionsMenu) {
                    z2 = true;
                }
            }
        }
        return z2;
    }

    public final void dispatchStateChange(int i) {
        try {
            this.mExecutingActions = true;
            for (FragmentStateManager fragmentStateManager : ((HashMap) this.mFragmentStore.readyAsyncCalls).values()) {
                if (fragmentStateManager != null) {
                    fragmentStateManager.mFragmentManagerState = i;
                }
            }
            moveToState(i, false);
            Iterator it = collectAllSpecialEffectsController().iterator();
            while (it.hasNext()) {
                ((DefaultSpecialEffectsController) it.next()).forceCompleteAllOperations();
            }
            this.mExecutingActions = false;
            execPendingActions(true);
        } catch (Throwable th) {
            this.mExecutingActions = false;
            throw th;
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(str, "    ");
        Dispatcher dispatcher = this.mFragmentStore;
        dispatcher.getClass();
        String str2 = str + "    ";
        HashMap map = (HashMap) dispatcher.readyAsyncCalls;
        if (!map.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (FragmentStateManager fragmentStateManager : map.values()) {
                printWriter.print(str);
                if (fragmentStateManager != null) {
                    Fragment fragment = fragmentStateManager.mFragment;
                    printWriter.println(fragment);
                    fragment.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        ArrayList arrayList = (ArrayList) dispatcher.executorServiceOrNull;
        int size3 = arrayList.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size3; i++) {
                Fragment fragment2 = (Fragment) arrayList.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
        ArrayList arrayList2 = this.mCreatedMenus;
        if (arrayList2 != null && (size2 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size2; i2++) {
                Fragment fragment3 = (Fragment) this.mCreatedMenus.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment3.toString());
            }
        }
        ArrayList arrayList3 = this.mBackStack;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size; i3++) {
                BackStackRecord backStackRecord = (BackStackRecord) this.mBackStack.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(backStackRecord.toString());
                backStackRecord.dump(strM, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.mBackStackIndex.get());
        synchronized (this.mPendingActions) {
            try {
                int size4 = this.mPendingActions.size();
                if (size4 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i4 = 0; i4 < size4; i4++) {
                        Object obj = (OpGenerator) this.mPendingActions.get(i4);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i4);
                        printWriter.print(": ");
                        printWriter.println(obj);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.mHost);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.mContainer);
        if (this.mParent != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.mParent);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.mCurState);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.mStateSaved);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.mDestroyed);
        if (this.mNeedMenuInvalidate) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.mNeedMenuInvalidate);
        }
    }

    public final void enqueueAction(OpGenerator opGenerator, boolean z) {
        if (!z) {
            if (this.mHost == null) {
                if (!this.mDestroyed) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            if (this.mStateSaved || this.mStopped) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.mPendingActions) {
            try {
                if (this.mHost == null) {
                    if (!z) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.mPendingActions.add(opGenerator);
                    scheduleCommit();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void ensureExecReady(boolean z) {
        if (this.mExecutingActions) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.mHost == null) {
            if (!this.mDestroyed) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.mHost.mHandler.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z && (this.mStateSaved || this.mStopped)) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.mTmpRecords == null) {
            this.mTmpRecords = new ArrayList();
            this.mTmpIsPop = new ArrayList();
        }
    }

    public final boolean execPendingActions(boolean z) {
        boolean zGenerateOps;
        ensureExecReady(z);
        boolean z2 = false;
        while (true) {
            ArrayList arrayList = this.mTmpRecords;
            ArrayList arrayList2 = this.mTmpIsPop;
            synchronized (this.mPendingActions) {
                if (this.mPendingActions.isEmpty()) {
                    zGenerateOps = false;
                } else {
                    try {
                        int size = this.mPendingActions.size();
                        zGenerateOps = false;
                        for (int i = 0; i < size; i++) {
                            zGenerateOps |= ((OpGenerator) this.mPendingActions.get(i)).generateOps(arrayList, arrayList2);
                        }
                        this.mPendingActions.clear();
                        this.mHost.mHandler.removeCallbacks(this.mExecCommit);
                    } catch (Throwable th) {
                        this.mPendingActions.clear();
                        this.mHost.mHandler.removeCallbacks(this.mExecCommit);
                        throw th;
                    }
                }
            }
            if (!zGenerateOps) {
                break;
            }
            z2 = true;
            this.mExecutingActions = true;
            try {
                removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
                cleanupExec();
            } catch (Throwable th2) {
                cleanupExec();
                throw th2;
            }
        }
        updateOnBackPressedCallbackEnabled();
        if (this.mHavePendingDeferredStart) {
            this.mHavePendingDeferredStart = false;
            startPendingDeferredFragments();
        }
        ((HashMap) this.mFragmentStore.readyAsyncCalls).values().removeAll(Collections.singleton(null));
        return z2;
    }

    /* JADX WARN: Code duplicated, block: B:114:0x0229 A[PHI: r13
  0x0229: PHI (r13v13 int) = (r13v11 int), (r13v14 int) binds: [B:107:0x0219, B:112:0x0225] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:64:0x0164  */
    public final void executeOpsTogether(ArrayList arrayList, ArrayList arrayList2, int i, int i2) {
        ViewGroup viewGroup;
        Dispatcher dispatcher;
        Dispatcher dispatcher2;
        int i3;
        int i4;
        ArrayList arrayList3 = arrayList;
        boolean z = ((BackStackRecord) arrayList3.get(i)).mReorderingAllowed;
        ArrayList arrayList4 = this.mTmpAddedFragments;
        if (arrayList4 == null) {
            this.mTmpAddedFragments = new ArrayList();
        } else {
            arrayList4.clear();
        }
        ArrayList arrayList5 = this.mTmpAddedFragments;
        Dispatcher dispatcher3 = this.mFragmentStore;
        arrayList5.addAll(dispatcher3.getFragments());
        Fragment fragment = this.mPrimaryNav;
        int i5 = i;
        boolean z2 = false;
        while (true) {
            int i6 = 1;
            if (i5 >= i2) {
                Dispatcher dispatcher4 = dispatcher3;
                this.mTmpAddedFragments.clear();
                if (!z && this.mCurState >= 1) {
                    for (int i7 = i; i7 < i2; i7++) {
                        Iterator it = ((BackStackRecord) arrayList.get(i7)).mOps.iterator();
                        while (it.hasNext()) {
                            Fragment fragment2 = ((FragmentTransaction$Op) it.next()).mFragment;
                            if (fragment2 == null || fragment2.mFragmentManager == null) {
                                dispatcher = dispatcher4;
                            } else {
                                dispatcher = dispatcher4;
                                dispatcher.makeActive(createOrGetFragmentStateManager(fragment2));
                            }
                            dispatcher4 = dispatcher;
                        }
                    }
                }
                for (int i8 = i; i8 < i2; i8++) {
                    BackStackRecord backStackRecord = (BackStackRecord) arrayList.get(i8);
                    if (((Boolean) arrayList2.get(i8)).booleanValue()) {
                        backStackRecord.bumpBackStackNesting(-1);
                        ArrayList arrayList6 = backStackRecord.mOps;
                        boolean z3 = true;
                        for (int size = arrayList6.size() - 1; size >= 0; size--) {
                            FragmentTransaction$Op fragmentTransaction$Op = (FragmentTransaction$Op) arrayList6.get(size);
                            Fragment fragment3 = fragmentTransaction$Op.mFragment;
                            if (fragment3 != null) {
                                if (fragment3.mAnimationInfo != null) {
                                    fragment3.ensureAnimationInfo().mIsPop = z3;
                                }
                                int i9 = backStackRecord.mTransition;
                                int i10 = 8194;
                                int i11 = 4097;
                                if (i9 != 4097) {
                                    if (i9 != 8194) {
                                        i10 = 4100;
                                        i11 = 8197;
                                        if (i9 != 8197) {
                                            if (i9 == 4099) {
                                                i10 = 4099;
                                            } else if (i9 != 4100) {
                                                i10 = 0;
                                            } else {
                                                i10 = i11;
                                            }
                                        }
                                    } else {
                                        i10 = i11;
                                    }
                                }
                                if (fragment3.mAnimationInfo != null || i10 != 0) {
                                    fragment3.ensureAnimationInfo();
                                    fragment3.mAnimationInfo.mNextTransition = i10;
                                }
                                ArrayList arrayList7 = backStackRecord.mSharedElementTargetNames;
                                ArrayList arrayList8 = backStackRecord.mSharedElementSourceNames;
                                fragment3.ensureAnimationInfo();
                                Fragment.AnimationInfo animationInfo = fragment3.mAnimationInfo;
                                animationInfo.mSharedElementSourceNames = arrayList7;
                                animationInfo.mSharedElementTargetNames = arrayList8;
                            }
                            int i12 = fragmentTransaction$Op.mCmd;
                            FragmentManager fragmentManager = backStackRecord.mManager;
                            switch (i12) {
                                case 1:
                                    fragment3.setAnimations(fragmentTransaction$Op.mEnterAnim, fragmentTransaction$Op.mExitAnim, fragmentTransaction$Op.mPopEnterAnim, fragmentTransaction$Op.mPopExitAnim);
                                    z3 = true;
                                    fragmentManager.setExitAnimationOrder(fragment3, true);
                                    fragmentManager.removeFragment(fragment3);
                                    break;
                                case 2:
                                default:
                                    throw new IllegalArgumentException("Unknown cmd: " + fragmentTransaction$Op.mCmd);
                                case 3:
                                    fragment3.setAnimations(fragmentTransaction$Op.mEnterAnim, fragmentTransaction$Op.mExitAnim, fragmentTransaction$Op.mPopEnterAnim, fragmentTransaction$Op.mPopExitAnim);
                                    fragmentManager.addFragment(fragment3);
                                    z3 = true;
                                    break;
                                case 4:
                                    fragment3.setAnimations(fragmentTransaction$Op.mEnterAnim, fragmentTransaction$Op.mExitAnim, fragmentTransaction$Op.mPopEnterAnim, fragmentTransaction$Op.mPopExitAnim);
                                    fragmentManager.getClass();
                                    showFragment(fragment3);
                                    z3 = true;
                                    break;
                                case 5:
                                    fragment3.setAnimations(fragmentTransaction$Op.mEnterAnim, fragmentTransaction$Op.mExitAnim, fragmentTransaction$Op.mPopEnterAnim, fragmentTransaction$Op.mPopExitAnim);
                                    fragmentManager.setExitAnimationOrder(fragment3, true);
                                    fragmentManager.hideFragment(fragment3);
                                    z3 = true;
                                    break;
                                case 6:
                                    fragment3.setAnimations(fragmentTransaction$Op.mEnterAnim, fragmentTransaction$Op.mExitAnim, fragmentTransaction$Op.mPopEnterAnim, fragmentTransaction$Op.mPopExitAnim);
                                    fragmentManager.attachFragment(fragment3);
                                    z3 = true;
                                    break;
                                case 7:
                                    fragment3.setAnimations(fragmentTransaction$Op.mEnterAnim, fragmentTransaction$Op.mExitAnim, fragmentTransaction$Op.mPopEnterAnim, fragmentTransaction$Op.mPopExitAnim);
                                    fragmentManager.setExitAnimationOrder(fragment3, true);
                                    fragmentManager.detachFragment(fragment3);
                                    z3 = true;
                                    break;
                                case 8:
                                    fragmentManager.setPrimaryNavigationFragment(null);
                                    z3 = true;
                                    break;
                                case 9:
                                    fragmentManager.setPrimaryNavigationFragment(fragment3);
                                    z3 = true;
                                    break;
                                case 10:
                                    fragmentManager.setMaxLifecycle(fragment3, fragmentTransaction$Op.mOldMaxState);
                                    z3 = true;
                                    break;
                            }
                        }
                    } else {
                        backStackRecord.bumpBackStackNesting(1);
                        ArrayList arrayList9 = backStackRecord.mOps;
                        int size2 = arrayList9.size();
                        for (int i13 = 0; i13 < size2; i13++) {
                            FragmentTransaction$Op fragmentTransaction$Op2 = (FragmentTransaction$Op) arrayList9.get(i13);
                            Fragment fragment4 = fragmentTransaction$Op2.mFragment;
                            if (fragment4 != null) {
                                if (fragment4.mAnimationInfo != null) {
                                    fragment4.ensureAnimationInfo().mIsPop = false;
                                }
                                int i14 = backStackRecord.mTransition;
                                if (fragment4.mAnimationInfo != null || i14 != 0) {
                                    fragment4.ensureAnimationInfo();
                                    fragment4.mAnimationInfo.mNextTransition = i14;
                                }
                                ArrayList arrayList10 = backStackRecord.mSharedElementSourceNames;
                                ArrayList arrayList11 = backStackRecord.mSharedElementTargetNames;
                                fragment4.ensureAnimationInfo();
                                Fragment.AnimationInfo animationInfo2 = fragment4.mAnimationInfo;
                                animationInfo2.mSharedElementSourceNames = arrayList10;
                                animationInfo2.mSharedElementTargetNames = arrayList11;
                            }
                            int i15 = fragmentTransaction$Op2.mCmd;
                            FragmentManager fragmentManager2 = backStackRecord.mManager;
                            switch (i15) {
                                case 1:
                                    fragment4.setAnimations(fragmentTransaction$Op2.mEnterAnim, fragmentTransaction$Op2.mExitAnim, fragmentTransaction$Op2.mPopEnterAnim, fragmentTransaction$Op2.mPopExitAnim);
                                    fragmentManager2.setExitAnimationOrder(fragment4, false);
                                    fragmentManager2.addFragment(fragment4);
                                    break;
                                case 2:
                                default:
                                    throw new IllegalArgumentException("Unknown cmd: " + fragmentTransaction$Op2.mCmd);
                                case 3:
                                    fragment4.setAnimations(fragmentTransaction$Op2.mEnterAnim, fragmentTransaction$Op2.mExitAnim, fragmentTransaction$Op2.mPopEnterAnim, fragmentTransaction$Op2.mPopExitAnim);
                                    fragmentManager2.removeFragment(fragment4);
                                    break;
                                case 4:
                                    fragment4.setAnimations(fragmentTransaction$Op2.mEnterAnim, fragmentTransaction$Op2.mExitAnim, fragmentTransaction$Op2.mPopEnterAnim, fragmentTransaction$Op2.mPopExitAnim);
                                    fragmentManager2.hideFragment(fragment4);
                                    break;
                                case 5:
                                    fragment4.setAnimations(fragmentTransaction$Op2.mEnterAnim, fragmentTransaction$Op2.mExitAnim, fragmentTransaction$Op2.mPopEnterAnim, fragmentTransaction$Op2.mPopExitAnim);
                                    fragmentManager2.setExitAnimationOrder(fragment4, false);
                                    showFragment(fragment4);
                                    break;
                                case 6:
                                    fragment4.setAnimations(fragmentTransaction$Op2.mEnterAnim, fragmentTransaction$Op2.mExitAnim, fragmentTransaction$Op2.mPopEnterAnim, fragmentTransaction$Op2.mPopExitAnim);
                                    fragmentManager2.detachFragment(fragment4);
                                    break;
                                case 7:
                                    fragment4.setAnimations(fragmentTransaction$Op2.mEnterAnim, fragmentTransaction$Op2.mExitAnim, fragmentTransaction$Op2.mPopEnterAnim, fragmentTransaction$Op2.mPopExitAnim);
                                    fragmentManager2.setExitAnimationOrder(fragment4, false);
                                    fragmentManager2.attachFragment(fragment4);
                                    break;
                                case 8:
                                    fragmentManager2.setPrimaryNavigationFragment(fragment4);
                                    break;
                                case 9:
                                    fragmentManager2.setPrimaryNavigationFragment(null);
                                    break;
                                case 10:
                                    fragmentManager2.setMaxLifecycle(fragment4, fragmentTransaction$Op2.mCurrentMaxState);
                                    break;
                            }
                        }
                    }
                }
                boolean zBooleanValue = ((Boolean) arrayList2.get(i2 - 1)).booleanValue();
                for (int i16 = i; i16 < i2; i16++) {
                    BackStackRecord backStackRecord2 = (BackStackRecord) arrayList.get(i16);
                    if (zBooleanValue) {
                        for (int size3 = backStackRecord2.mOps.size() - 1; size3 >= 0; size3--) {
                            Fragment fragment5 = ((FragmentTransaction$Op) backStackRecord2.mOps.get(size3)).mFragment;
                            if (fragment5 != null) {
                                createOrGetFragmentStateManager(fragment5).moveToExpectedState();
                            }
                        }
                    } else {
                        Iterator it2 = backStackRecord2.mOps.iterator();
                        while (it2.hasNext()) {
                            Fragment fragment6 = ((FragmentTransaction$Op) it2.next()).mFragment;
                            if (fragment6 != null) {
                                createOrGetFragmentStateManager(fragment6).moveToExpectedState();
                            }
                        }
                    }
                }
                moveToState(this.mCurState, true);
                HashSet<DefaultSpecialEffectsController> hashSet = new HashSet();
                for (int i17 = i; i17 < i2; i17++) {
                    Iterator it3 = ((BackStackRecord) arrayList.get(i17)).mOps.iterator();
                    while (it3.hasNext()) {
                        Fragment fragment7 = ((FragmentTransaction$Op) it3.next()).mFragment;
                        if (fragment7 != null && (viewGroup = fragment7.mContainer) != null) {
                            hashSet.add(DefaultSpecialEffectsController.getOrCreateController(viewGroup, getSpecialEffectsControllerFactory()));
                        }
                    }
                }
                for (DefaultSpecialEffectsController defaultSpecialEffectsController : hashSet) {
                    defaultSpecialEffectsController.mOperationDirectionIsPop = zBooleanValue;
                    defaultSpecialEffectsController.markPostponedState();
                    defaultSpecialEffectsController.executePendingOperations();
                }
                for (int i18 = i; i18 < i2; i18++) {
                    BackStackRecord backStackRecord3 = (BackStackRecord) arrayList.get(i18);
                    if (((Boolean) arrayList2.get(i18)).booleanValue() && backStackRecord3.mIndex >= 0) {
                        backStackRecord3.mIndex = -1;
                    }
                    backStackRecord3.getClass();
                }
                return;
            }
            BackStackRecord backStackRecord4 = (BackStackRecord) arrayList3.get(i5);
            if (((Boolean) arrayList2.get(i5)).booleanValue()) {
                dispatcher2 = dispatcher3;
                int i19 = 1;
                ArrayList arrayList12 = this.mTmpAddedFragments;
                ArrayList arrayList13 = backStackRecord4.mOps;
                int size4 = arrayList13.size() - 1;
                while (size4 >= 0) {
                    FragmentTransaction$Op fragmentTransaction$Op3 = (FragmentTransaction$Op) arrayList13.get(size4);
                    int i20 = fragmentTransaction$Op3.mCmd;
                    if (i20 != i19) {
                        if (i20 != 3) {
                            switch (i20) {
                                case 6:
                                    arrayList12.add(fragmentTransaction$Op3.mFragment);
                                    break;
                                case 8:
                                    fragment = null;
                                    break;
                                case 9:
                                    fragment = fragmentTransaction$Op3.mFragment;
                                    break;
                                case 10:
                                    fragmentTransaction$Op3.mCurrentMaxState = fragmentTransaction$Op3.mOldMaxState;
                                    break;
                            }
                        } else {
                            arrayList12.add(fragmentTransaction$Op3.mFragment);
                        }
                        size4--;
                        i19 = 1;
                    }
                    arrayList12.remove(fragmentTransaction$Op3.mFragment);
                    size4--;
                    i19 = 1;
                }
            } else {
                ArrayList arrayList14 = this.mTmpAddedFragments;
                int i21 = 0;
                while (true) {
                    ArrayList arrayList15 = backStackRecord4.mOps;
                    if (i21 < arrayList15.size()) {
                        FragmentTransaction$Op fragmentTransaction$Op4 = (FragmentTransaction$Op) arrayList15.get(i21);
                        int i22 = fragmentTransaction$Op4.mCmd;
                        if (i22 != i6) {
                            if (i22 != 2) {
                                if (i22 == 3 || i22 == 6) {
                                    arrayList14.remove(fragmentTransaction$Op4.mFragment);
                                    Fragment fragment8 = fragmentTransaction$Op4.mFragment;
                                    if (fragment8 == fragment) {
                                        arrayList15.add(i21, new FragmentTransaction$Op(fragment8, 9));
                                        i21++;
                                        dispatcher3 = dispatcher3;
                                        i3 = 1;
                                        fragment = null;
                                    }
                                } else if (i22 == 7) {
                                    i3 = 1;
                                } else if (i22 == 8) {
                                    arrayList15.add(i21, new FragmentTransaction$Op(9, fragment, 0));
                                    fragmentTransaction$Op4.mFromExpandedOp = true;
                                    i21++;
                                    fragment = fragmentTransaction$Op4.mFragment;
                                }
                                dispatcher3 = dispatcher3;
                                i3 = 1;
                            } else {
                                Fragment fragment9 = fragmentTransaction$Op4.mFragment;
                                int i23 = fragment9.mContainerId;
                                int size5 = arrayList14.size() - 1;
                                boolean z4 = false;
                                while (size5 >= 0) {
                                    Dispatcher dispatcher5 = dispatcher3;
                                    Fragment fragment10 = (Fragment) arrayList14.get(size5);
                                    if (fragment10.mContainerId != i23) {
                                        i23 = i23;
                                    } else if (fragment10 == fragment9) {
                                        i23 = i23;
                                        z4 = true;
                                    } else {
                                        if (fragment10 == fragment) {
                                            arrayList15.add(i21, new FragmentTransaction$Op(9, fragment10, 0));
                                            i21++;
                                            i4 = 0;
                                            fragment = null;
                                        } else {
                                            i4 = 0;
                                        }
                                        FragmentTransaction$Op fragmentTransaction$Op5 = new FragmentTransaction$Op(3, fragment10, i4);
                                        fragmentTransaction$Op5.mEnterAnim = fragmentTransaction$Op4.mEnterAnim;
                                        fragmentTransaction$Op5.mPopEnterAnim = fragmentTransaction$Op4.mPopEnterAnim;
                                        fragmentTransaction$Op5.mExitAnim = fragmentTransaction$Op4.mExitAnim;
                                        fragmentTransaction$Op5.mPopExitAnim = fragmentTransaction$Op4.mPopExitAnim;
                                        arrayList15.add(i21, fragmentTransaction$Op5);
                                        arrayList14.remove(fragment10);
                                        i21++;
                                        fragment = fragment;
                                    }
                                    size5--;
                                    i23 = i23;
                                    dispatcher3 = dispatcher5;
                                }
                                dispatcher3 = dispatcher3;
                                i3 = 1;
                                if (z4) {
                                    arrayList15.remove(i21);
                                    i21--;
                                } else {
                                    fragmentTransaction$Op4.mCmd = 1;
                                    fragmentTransaction$Op4.mFromExpandedOp = true;
                                    arrayList14.add(fragment9);
                                }
                            }
                            i21 += i3;
                            i6 = i3;
                            dispatcher3 = dispatcher3;
                        } else {
                            i3 = i6;
                        }
                        arrayList14.add(fragmentTransaction$Op4.mFragment);
                        i21 += i3;
                        i6 = i3;
                        dispatcher3 = dispatcher3;
                    } else {
                        dispatcher2 = dispatcher3;
                    }
                }
            }
            z2 = z2 || backStackRecord4.mAddToBackStack;
            i5++;
            arrayList3 = arrayList;
            dispatcher3 = dispatcher2;
        }
    }

    public final Fragment findFragmentById(int i) {
        Dispatcher dispatcher = this.mFragmentStore;
        ArrayList arrayList = (ArrayList) dispatcher.executorServiceOrNull;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) arrayList.get(size);
            if (fragment != null && fragment.mFragmentId == i) {
                return fragment;
            }
        }
        for (FragmentStateManager fragmentStateManager : ((HashMap) dispatcher.readyAsyncCalls).values()) {
            if (fragmentStateManager != null) {
                Fragment fragment2 = fragmentStateManager.mFragment;
                if (fragment2.mFragmentId == i) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    public final Fragment findFragmentByTag(String str) {
        Dispatcher dispatcher = this.mFragmentStore;
        ArrayList arrayList = (ArrayList) dispatcher.executorServiceOrNull;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) arrayList.get(size);
            if (fragment != null && str.equals(fragment.mTag)) {
                return fragment;
            }
        }
        for (FragmentStateManager fragmentStateManager : ((HashMap) dispatcher.readyAsyncCalls).values()) {
            if (fragmentStateManager != null) {
                Fragment fragment2 = fragmentStateManager.mFragment;
                if (str.equals(fragment2.mTag)) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    public final ViewGroup getFragmentContainer(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId > 0 && this.mContainer.onHasView()) {
            View viewOnFindViewById = this.mContainer.onFindViewById(fragment.mContainerId);
            if (viewOnFindViewById instanceof ViewGroup) {
                return (ViewGroup) viewOnFindViewById;
            }
        }
        return null;
    }

    public final AnonymousClass3 getFragmentFactory() {
        Fragment fragment = this.mParent;
        return fragment != null ? fragment.mFragmentManager.getFragmentFactory() : this.mHostFragmentFactory;
    }

    public final InputMergerFactory$1 getSpecialEffectsControllerFactory() {
        Fragment fragment = this.mParent;
        return fragment != null ? fragment.mFragmentManager.getSpecialEffectsControllerFactory() : this.mDefaultSpecialEffectsControllerFactory;
    }

    public final void hideFragment(Fragment fragment) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.mHidden) {
            return;
        }
        fragment.mHidden = true;
        fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
        setVisibleRemovingFragment(fragment);
    }

    public final boolean isParentAdded() {
        Fragment fragment = this.mParent;
        if (fragment == null) {
            return true;
        }
        return fragment.isAdded() && this.mParent.getParentFragmentManager().isParentAdded();
    }

    public final void moveToState(int i, boolean z) {
        HashMap map;
        FragmentActivity.HostCallbacks hostCallbacks;
        if (this.mHost == null && i != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z || i != this.mCurState) {
            this.mCurState = i;
            Dispatcher dispatcher = this.mFragmentStore;
            Iterator it = ((ArrayList) dispatcher.executorServiceOrNull).iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                map = (HashMap) dispatcher.readyAsyncCalls;
                if (!zHasNext) {
                    break;
                }
                FragmentStateManager fragmentStateManager = (FragmentStateManager) map.get(((Fragment) it.next()).mWho);
                if (fragmentStateManager != null) {
                    fragmentStateManager.moveToExpectedState();
                }
            }
            for (FragmentStateManager fragmentStateManager2 : map.values()) {
                if (fragmentStateManager2 != null) {
                    fragmentStateManager2.moveToExpectedState();
                    Fragment fragment = fragmentStateManager2.mFragment;
                    if (fragment.mRemoving && !fragment.isInBackStack()) {
                        dispatcher.makeInactive(fragmentStateManager2);
                    }
                }
            }
            startPendingDeferredFragments();
            if (this.mNeedMenuInvalidate && (hostCallbacks = this.mHost) != null && this.mCurState == 7) {
                FragmentActivity.this.invalidateOptionsMenu();
                this.mNeedMenuInvalidate = false;
            }
        }
    }

    public final void noteStateNotSaved() {
        if (this.mHost == null) {
            return;
        }
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.mIsStateSaved = false;
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null) {
                fragment.mChildFragmentManager.noteStateNotSaved();
            }
        }
    }

    public final boolean popBackStackImmediate() {
        execPendingActions(false);
        ensureExecReady(true);
        Fragment fragment = this.mPrimaryNav;
        if (fragment != null && fragment.getChildFragmentManager().popBackStackImmediate()) {
            return true;
        }
        boolean zPopBackStackState = popBackStackState(this.mTmpRecords, this.mTmpIsPop, -1, 0);
        if (zPopBackStackState) {
            this.mExecutingActions = true;
            try {
                removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
                cleanupExec();
            } catch (Throwable th) {
                cleanupExec();
                throw th;
            }
        }
        updateOnBackPressedCallbackEnabled();
        if (this.mHavePendingDeferredStart) {
            this.mHavePendingDeferredStart = false;
            startPendingDeferredFragments();
        }
        ((HashMap) this.mFragmentStore.readyAsyncCalls).values().removeAll(Collections.singleton(null));
        return zPopBackStackState;
    }

    public final boolean popBackStackState(ArrayList arrayList, ArrayList arrayList2, int i, int i2) {
        boolean z = (i2 & 1) != 0;
        ArrayList arrayList3 = this.mBackStack;
        int size = -1;
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            if (i < 0) {
                size = z ? 0 : this.mBackStack.size() - 1;
            } else {
                int size2 = this.mBackStack.size() - 1;
                while (size2 >= 0) {
                    BackStackRecord backStackRecord = (BackStackRecord) this.mBackStack.get(size2);
                    if (i >= 0 && i == backStackRecord.mIndex) {
                        break;
                    }
                    size2--;
                }
                if (size2 >= 0) {
                    if (z) {
                        while (size2 > 0) {
                            BackStackRecord backStackRecord2 = (BackStackRecord) this.mBackStack.get(size2 - 1);
                            if (i < 0 || i != backStackRecord2.mIndex) {
                                break;
                            }
                            size2--;
                        }
                    } else if (size2 != this.mBackStack.size() - 1) {
                        size2++;
                    }
                    size = size2;
                } else {
                    size = size2;
                }
            }
        }
        if (size < 0) {
            return false;
        }
        for (int size3 = this.mBackStack.size() - 1; size3 >= size; size3--) {
            arrayList.add((BackStackRecord) this.mBackStack.remove(size3));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public final void removeFragment(Fragment fragment) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean zIsInBackStack = fragment.isInBackStack();
        if (fragment.mDetached && zIsInBackStack) {
            return;
        }
        Dispatcher dispatcher = this.mFragmentStore;
        synchronized (((ArrayList) dispatcher.executorServiceOrNull)) {
            ((ArrayList) dispatcher.executorServiceOrNull).remove(fragment);
        }
        fragment.mAdded = false;
        if (isMenuAvailable(fragment)) {
            this.mNeedMenuInvalidate = true;
        }
        fragment.mRemoving = true;
        setVisibleRemovingFragment(fragment);
    }

    public final void removeRedundantOperationsAndExecute(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            if (!((BackStackRecord) arrayList.get(i)).mReorderingAllowed) {
                if (i2 != i) {
                    executeOpsTogether(arrayList, arrayList2, i2, i);
                }
                i2 = i + 1;
                if (((Boolean) arrayList2.get(i)).booleanValue()) {
                    while (i2 < size && ((Boolean) arrayList2.get(i2)).booleanValue() && !((BackStackRecord) arrayList.get(i2)).mReorderingAllowed) {
                        i2++;
                    }
                }
                executeOpsTogether(arrayList, arrayList2, i, i2);
                i = i2 - 1;
            }
            i++;
        }
        if (i2 != size) {
            executeOpsTogether(arrayList, arrayList2, i2, size);
        }
    }

    public final Bundle saveAllStateInternal() {
        int i;
        ArrayList arrayList;
        BackStackRecordState[] backStackRecordStateArr;
        int size;
        Bundle bundle = new Bundle();
        Iterator it = collectAllSpecialEffectsController().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DefaultSpecialEffectsController defaultSpecialEffectsController = (DefaultSpecialEffectsController) it.next();
            if (defaultSpecialEffectsController.mIsContainerPostponed) {
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
                }
                defaultSpecialEffectsController.mIsContainerPostponed = false;
                defaultSpecialEffectsController.executePendingOperations();
            }
        }
        Iterator it2 = collectAllSpecialEffectsController().iterator();
        while (it2.hasNext()) {
            ((DefaultSpecialEffectsController) it2.next()).forceCompleteAllOperations();
        }
        execPendingActions(true);
        this.mStateSaved = true;
        this.mNonConfig.mIsStateSaved = true;
        Dispatcher dispatcher = this.mFragmentStore;
        dispatcher.getClass();
        HashMap map = (HashMap) dispatcher.readyAsyncCalls;
        ArrayList arrayList2 = new ArrayList(map.size());
        Iterator it3 = map.values().iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            FragmentStateManager fragmentStateManager = (FragmentStateManager) it3.next();
            if (fragmentStateManager != null) {
                Fragment fragment = fragmentStateManager.mFragment;
                FragmentState fragmentState = new FragmentState(fragment);
                if (fragment.mState <= -1 || fragmentState.mSavedFragmentState != null) {
                    fragmentState.mSavedFragmentState = fragment.mSavedFragmentState;
                } else {
                    Bundle bundle2 = new Bundle();
                    fragment.onSaveInstanceState(bundle2);
                    fragment.mSavedStateRegistryController.performSave(bundle2);
                    bundle2.putParcelable("android:support:fragments", fragment.mChildFragmentManager.saveAllStateInternal());
                    fragmentStateManager.mDispatcher.dispatchOnFragmentSaveInstanceState(false);
                    Bundle bundle3 = bundle2.isEmpty() ? null : bundle2;
                    if (fragment.mView != null) {
                        fragmentStateManager.saveViewState();
                    }
                    if (fragment.mSavedViewState != null) {
                        if (bundle3 == null) {
                            bundle3 = new Bundle();
                        }
                        bundle3.putSparseParcelableArray("android:view_state", fragment.mSavedViewState);
                    }
                    if (fragment.mSavedViewRegistryState != null) {
                        if (bundle3 == null) {
                            bundle3 = new Bundle();
                        }
                        bundle3.putBundle("android:view_registry_state", fragment.mSavedViewRegistryState);
                    }
                    if (!fragment.mUserVisibleHint) {
                        if (bundle3 == null) {
                            bundle3 = new Bundle();
                        }
                        bundle3.putBoolean("android:user_visible_hint", fragment.mUserVisibleHint);
                    }
                    fragmentState.mSavedFragmentState = bundle3;
                    if (fragment.mTargetWho != null) {
                        if (bundle3 == null) {
                            fragmentState.mSavedFragmentState = new Bundle();
                        }
                        fragmentState.mSavedFragmentState.putString("android:target_state", fragment.mTargetWho);
                        int i2 = fragment.mTargetRequestCode;
                        if (i2 != 0) {
                            fragmentState.mSavedFragmentState.putInt("android:target_req_state", i2);
                        }
                    }
                }
                Fragment fragment2 = fragmentStateManager.mFragment;
                arrayList2.add(fragment2.mWho);
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "Saved state of " + fragment2 + ": " + fragment2.mSavedFragmentState);
                }
            }
        }
        Dispatcher dispatcher2 = this.mFragmentStore;
        dispatcher2.getClass();
        ArrayList<FragmentState> arrayList3 = new ArrayList(((HashMap) dispatcher2.runningAsyncCalls).values());
        if (!arrayList3.isEmpty()) {
            Dispatcher dispatcher3 = this.mFragmentStore;
            synchronized (((ArrayList) dispatcher3.executorServiceOrNull)) {
                try {
                    if (((ArrayList) dispatcher3.executorServiceOrNull).isEmpty()) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(((ArrayList) dispatcher3.executorServiceOrNull).size());
                        for (Fragment fragment3 : (ArrayList) dispatcher3.executorServiceOrNull) {
                            arrayList.add(fragment3.mWho);
                            if (Log.isLoggable("FragmentManager", 2)) {
                                Log.v("FragmentManager", "saveAllState: adding fragment (" + fragment3.mWho + "): " + fragment3);
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            ArrayList arrayList4 = this.mBackStack;
            if (arrayList4 == null || (size = arrayList4.size()) <= 0) {
                backStackRecordStateArr = null;
            } else {
                backStackRecordStateArr = new BackStackRecordState[size];
                for (i = 0; i < size; i++) {
                    backStackRecordStateArr[i] = new BackStackRecordState((BackStackRecord) this.mBackStack.get(i));
                    if (Log.isLoggable("FragmentManager", 2)) {
                        StringBuilder sbM = Fragment$$ExternalSyntheticOutline0.m(i, "saveAllState: adding back stack #", ": ");
                        sbM.append(this.mBackStack.get(i));
                        Log.v("FragmentManager", sbM.toString());
                    }
                }
            }
            FragmentManagerState fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.mPrimaryNavActiveWho = null;
            ArrayList arrayList5 = new ArrayList();
            fragmentManagerState.mBackStackStateKeys = arrayList5;
            ArrayList arrayList6 = new ArrayList();
            fragmentManagerState.mBackStackStates = arrayList6;
            fragmentManagerState.mActive = arrayList2;
            fragmentManagerState.mAdded = arrayList;
            fragmentManagerState.mBackStack = backStackRecordStateArr;
            fragmentManagerState.mBackStackIndex = this.mBackStackIndex.get();
            Fragment fragment4 = this.mPrimaryNav;
            if (fragment4 != null) {
                fragmentManagerState.mPrimaryNavActiveWho = fragment4.mWho;
            }
            arrayList5.addAll(this.mBackStackStates.keySet());
            arrayList6.addAll(this.mBackStackStates.values());
            fragmentManagerState.mLaunchedFragments = new ArrayList(this.mLaunchedFragments);
            bundle.putParcelable("state", fragmentManagerState);
            for (String str : this.mResults.keySet()) {
                bundle.putBundle(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("result_", str), (Bundle) this.mResults.get(str));
            }
            for (FragmentState fragmentState2 : arrayList3) {
                Bundle bundle4 = new Bundle();
                bundle4.putParcelable("state", fragmentState2);
                bundle.putBundle("fragment_" + fragmentState2.mWho, bundle4);
            }
        } else if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
        }
        return bundle;
    }

    public final void scheduleCommit() {
        synchronized (this.mPendingActions) {
            try {
                if (this.mPendingActions.size() == 1) {
                    this.mHost.mHandler.removeCallbacks(this.mExecCommit);
                    this.mHost.mHandler.post(this.mExecCommit);
                    updateOnBackPressedCallbackEnabled();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void setExitAnimationOrder(Fragment fragment, boolean z) {
        ViewGroup fragmentContainer = getFragmentContainer(fragment);
        if (fragmentContainer == null || !(fragmentContainer instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) fragmentContainer).setDrawDisappearingViewsLast(!z);
    }

    public final void setPrimaryNavigationFragment(Fragment fragment) {
        if (fragment != null) {
            if (!fragment.equals(this.mFragmentStore.findActiveFragment(fragment.mWho)) || (fragment.mHost != null && fragment.mFragmentManager != this)) {
                throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
            }
        }
        Fragment fragment2 = this.mPrimaryNav;
        this.mPrimaryNav = fragment;
        dispatchParentPrimaryNavigationFragmentChanged(fragment2);
        dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
    }

    public final void setVisibleRemovingFragment(Fragment fragment) {
        ViewGroup fragmentContainer = getFragmentContainer(fragment);
        if (fragmentContainer != null) {
            Fragment.AnimationInfo animationInfo = fragment.mAnimationInfo;
            if ((animationInfo == null ? 0 : animationInfo.mPopExitAnim) + (animationInfo == null ? 0 : animationInfo.mPopEnterAnim) + (animationInfo == null ? 0 : animationInfo.mExitAnim) + (animationInfo == null ? 0 : animationInfo.mEnterAnim) > 0) {
                if (fragmentContainer.getTag(R.id.visible_removing_fragment_view_tag) == null) {
                    fragmentContainer.setTag(R.id.visible_removing_fragment_view_tag, fragment);
                }
                Fragment fragment2 = (Fragment) fragmentContainer.getTag(R.id.visible_removing_fragment_view_tag);
                Fragment.AnimationInfo animationInfo2 = fragment.mAnimationInfo;
                boolean z = animationInfo2 != null ? animationInfo2.mIsPop : false;
                if (fragment2.mAnimationInfo == null) {
                    return;
                }
                fragment2.ensureAnimationInfo().mIsPop = z;
            }
        }
    }

    public final void startPendingDeferredFragments() {
        for (FragmentStateManager fragmentStateManager : this.mFragmentStore.getActiveFragmentStateManagers()) {
            Fragment fragment = fragmentStateManager.mFragment;
            if (fragment.mDeferStart) {
                if (this.mExecutingActions) {
                    this.mHavePendingDeferredStart = true;
                } else {
                    fragment.mDeferStart = false;
                    fragmentStateManager.moveToExpectedState();
                }
            }
        }
    }

    public final void throwException(IllegalStateException illegalStateException) {
        Log.e("FragmentManager", illegalStateException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new LogWriter());
        FragmentActivity.HostCallbacks hostCallbacks = this.mHost;
        if (hostCallbacks == null) {
            try {
                dump("  ", null, printWriter, new String[0]);
                throw illegalStateException;
            } catch (Exception e) {
                Log.e("FragmentManager", "Failed dumping state", e);
                throw illegalStateException;
            }
        }
        try {
            FragmentActivity.this.dump("  ", null, printWriter, new String[0]);
            throw illegalStateException;
        } catch (Exception e2) {
            Log.e("FragmentManager", "Failed dumping state", e2);
            throw illegalStateException;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.mParent;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.mParent)));
            sb.append("}");
        } else {
            FragmentActivity.HostCallbacks hostCallbacks = this.mHost;
            if (hostCallbacks != null) {
                sb.append(hostCallbacks.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.mHost)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public final void updateOnBackPressedCallbackEnabled() {
        synchronized (this.mPendingActions) {
            try {
                if (!this.mPendingActions.isEmpty()) {
                    AnonymousClass1 anonymousClass1 = this.mOnBackPressedCallback;
                    anonymousClass1.isEnabled = true;
                    OnBackPressedDispatcher.C00081 c00081 = anonymousClass1.enabledChangedCallback;
                    if (c00081 != null) {
                        c00081.invoke();
                    }
                    return;
                }
                AnonymousClass1 anonymousClass2 = this.mOnBackPressedCallback;
                ArrayList arrayList = this.mBackStack;
                anonymousClass2.isEnabled = (arrayList != null ? arrayList.size() : 0) > 0 && isPrimaryNavigation(this.mParent);
                OnBackPressedDispatcher.C00081 c00082 = anonymousClass2.enabledChangedCallback;
                if (c00082 != null) {
                    c00082.invoke();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void detachFragment(Fragment fragment) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", FETmZwrVHuasmL.tkphPqN + fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            Dispatcher dispatcher = this.mFragmentStore;
            synchronized (((ArrayList) dispatcher.executorServiceOrNull)) {
                ((ArrayList) dispatcher.executorServiceOrNull).remove(fragment);
            }
            fragment.mAdded = false;
            if (isMenuAvailable(fragment)) {
                this.mNeedMenuInvalidate = true;
            }
            setVisibleRemovingFragment(fragment);
        }
    }

    public final void restoreSaveStateInternal(Parcelable parcelable) {
        int i;
        RoomOpenHelper roomOpenHelper;
        int i2;
        FragmentStateManager fragmentStateManager;
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3 = (Bundle) parcelable;
        for (String str : bundle3.keySet()) {
            if (str.startsWith("result_") && (bundle2 = bundle3.getBundle(str)) != null) {
                bundle2.setClassLoader(this.mHost.mContext.getClassLoader());
                this.mResults.put(str.substring(7), bundle2);
            }
        }
        ArrayList<FragmentState> arrayList = new ArrayList();
        for (String str2 : bundle3.keySet()) {
            if (str2.startsWith("fragment_") && (bundle = bundle3.getBundle(str2)) != null) {
                bundle.setClassLoader(this.mHost.mContext.getClassLoader());
                arrayList.add((FragmentState) bundle.getParcelable("state"));
            }
        }
        Dispatcher dispatcher = this.mFragmentStore;
        HashMap map = (HashMap) dispatcher.runningAsyncCalls;
        map.clear();
        for (FragmentState fragmentState : arrayList) {
            map.put(fragmentState.mWho, fragmentState);
        }
        FragmentManagerState fragmentManagerState = (FragmentManagerState) bundle3.getParcelable("state");
        if (fragmentManagerState == null) {
            return;
        }
        HashMap map2 = (HashMap) dispatcher.readyAsyncCalls;
        map2.clear();
        Iterator it = fragmentManagerState.mActive.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            i = 2;
            roomOpenHelper = this.mLifecycleCallbacksDispatcher;
            if (!zHasNext) {
                break;
            }
            FragmentState fragmentState2 = (FragmentState) ((HashMap) dispatcher.runningAsyncCalls).remove((String) it.next());
            if (fragmentState2 != null) {
                Fragment fragment = (Fragment) this.mNonConfig.mRetainedFragments.get(fragmentState2.mWho);
                if (fragment != null) {
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + fragment);
                    }
                    fragmentStateManager = new FragmentStateManager(roomOpenHelper, dispatcher, fragment, fragmentState2);
                } else {
                    fragmentStateManager = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, this.mHost.mContext.getClassLoader(), getFragmentFactory(), fragmentState2);
                }
                Fragment fragment2 = fragmentStateManager.mFragment;
                fragment2.mFragmentManager = this;
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + fragment2.mWho + "): " + fragment2);
                }
                fragmentStateManager.restoreState(this.mHost.mContext.getClassLoader());
                dispatcher.makeActive(fragmentStateManager);
                fragmentStateManager.mFragmentManagerState = this.mCurState;
            }
        }
        FragmentManagerViewModel fragmentManagerViewModel = this.mNonConfig;
        fragmentManagerViewModel.getClass();
        for (Fragment fragment3 : new ArrayList(fragmentManagerViewModel.mRetainedFragments.values())) {
            if (map2.get(fragment3.mWho) == null) {
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment3 + " that was not found in the set of active Fragments " + fragmentManagerState.mActive);
                }
                this.mNonConfig.removeRetainedFragment(fragment3);
                fragment3.mFragmentManager = this;
                FragmentStateManager fragmentStateManager2 = new FragmentStateManager(roomOpenHelper, dispatcher, fragment3);
                fragmentStateManager2.mFragmentManagerState = 1;
                fragmentStateManager2.moveToExpectedState();
                fragment3.mRemoving = true;
                fragmentStateManager2.moveToExpectedState();
            }
        }
        ArrayList<String> arrayList2 = fragmentManagerState.mAdded;
        ((ArrayList) dispatcher.executorServiceOrNull).clear();
        if (arrayList2 != null) {
            for (String str3 : arrayList2) {
                Fragment fragmentFindActiveFragment = dispatcher.findActiveFragment(str3);
                if (fragmentFindActiveFragment == null) {
                    throw new IllegalStateException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("No instantiated fragment for (", str3, ")"));
                }
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str3 + "): " + fragmentFindActiveFragment);
                }
                dispatcher.addFragment(fragmentFindActiveFragment);
            }
        }
        if (fragmentManagerState.mBackStack != null) {
            this.mBackStack = new ArrayList(fragmentManagerState.mBackStack.length);
            int i3 = 0;
            while (true) {
                BackStackRecordState[] backStackRecordStateArr = fragmentManagerState.mBackStack;
                if (i3 >= backStackRecordStateArr.length) {
                    break;
                }
                BackStackRecordState backStackRecordState = backStackRecordStateArr[i3];
                backStackRecordState.getClass();
                BackStackRecord backStackRecord = new BackStackRecord(this);
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    int[] iArr = backStackRecordState.mOps;
                    if (i4 >= iArr.length) {
                        break;
                    }
                    FragmentTransaction$Op fragmentTransaction$Op = new FragmentTransaction$Op();
                    int i6 = i4 + 1;
                    fragmentTransaction$Op.mCmd = iArr[i4];
                    if (Log.isLoggable("FragmentManager", i)) {
                        Log.v("FragmentManager", "Instantiate " + backStackRecord + " op #" + i5 + PZmDzEagKNdW.Gehk + iArr[i6]);
                    }
                    fragmentTransaction$Op.mOldMaxState = Lifecycle.State.values()[backStackRecordState.mOldMaxLifecycleStates[i5]];
                    fragmentTransaction$Op.mCurrentMaxState = Lifecycle.State.values()[backStackRecordState.mCurrentMaxLifecycleStates[i5]];
                    int i7 = i4 + 2;
                    fragmentTransaction$Op.mFromExpandedOp = iArr[i6] != 0;
                    int i8 = iArr[i7];
                    fragmentTransaction$Op.mEnterAnim = i8;
                    int i9 = iArr[i4 + 3];
                    fragmentTransaction$Op.mExitAnim = i9;
                    int i10 = i4 + 5;
                    int i11 = iArr[i4 + 4];
                    fragmentTransaction$Op.mPopEnterAnim = i11;
                    i4 += 6;
                    int i12 = iArr[i10];
                    fragmentTransaction$Op.mPopExitAnim = i12;
                    backStackRecord.mEnterAnim = i8;
                    backStackRecord.mExitAnim = i9;
                    backStackRecord.mPopEnterAnim = i11;
                    backStackRecord.mPopExitAnim = i12;
                    backStackRecord.addOp(fragmentTransaction$Op);
                    i5++;
                    i = 2;
                }
                backStackRecord.mTransition = backStackRecordState.mTransition;
                backStackRecord.mName = backStackRecordState.mName;
                backStackRecord.mAddToBackStack = true;
                backStackRecord.mBreadCrumbTitleRes = backStackRecordState.mBreadCrumbTitleRes;
                backStackRecord.mBreadCrumbTitleText = backStackRecordState.mBreadCrumbTitleText;
                backStackRecord.mBreadCrumbShortTitleRes = backStackRecordState.mBreadCrumbShortTitleRes;
                backStackRecord.mBreadCrumbShortTitleText = backStackRecordState.mBreadCrumbShortTitleText;
                backStackRecord.mSharedElementSourceNames = backStackRecordState.mSharedElementSourceNames;
                backStackRecord.mSharedElementTargetNames = backStackRecordState.mSharedElementTargetNames;
                backStackRecord.mReorderingAllowed = backStackRecordState.mReorderingAllowed;
                backStackRecord.mIndex = backStackRecordState.mIndex;
                int i13 = 0;
                while (true) {
                    ArrayList arrayList3 = backStackRecordState.mFragmentWhos;
                    if (i13 >= arrayList3.size()) {
                        break;
                    }
                    String str4 = (String) arrayList3.get(i13);
                    if (str4 != null) {
                        ((FragmentTransaction$Op) backStackRecord.mOps.get(i13)).mFragment = dispatcher.findActiveFragment(str4);
                    }
                    i13++;
                }
                backStackRecord.bumpBackStackNesting(1);
                if (Log.isLoggable("FragmentManager", 2)) {
                    StringBuilder sbM = Fragment$$ExternalSyntheticOutline0.m(i3, "restoreAllState: back stack #", " (index ");
                    sbM.append(backStackRecord.mIndex);
                    sbM.append("): ");
                    sbM.append(backStackRecord);
                    Log.v("FragmentManager", sbM.toString());
                    PrintWriter printWriter = new PrintWriter(new LogWriter());
                    backStackRecord.dump("  ", printWriter, false);
                    printWriter.close();
                }
                this.mBackStack.add(backStackRecord);
                i3++;
                i = 2;
            }
            i2 = 0;
        } else {
            i2 = 0;
            this.mBackStack = null;
        }
        this.mBackStackIndex.set(fragmentManagerState.mBackStackIndex);
        String str5 = fragmentManagerState.mPrimaryNavActiveWho;
        if (str5 != null) {
            Fragment fragmentFindActiveFragment2 = dispatcher.findActiveFragment(str5);
            this.mPrimaryNav = fragmentFindActiveFragment2;
            dispatchParentPrimaryNavigationFragmentChanged(fragmentFindActiveFragment2);
        }
        ArrayList arrayList4 = fragmentManagerState.mBackStackStateKeys;
        if (arrayList4 != null) {
            for (int i14 = i2; i14 < arrayList4.size(); i14++) {
                this.mBackStackStates.put((String) arrayList4.get(i14), (BackStackState) fragmentManagerState.mBackStackStates.get(i14));
            }
        }
        this.mLaunchedFragments = new ArrayDeque(fragmentManagerState.mLaunchedFragments);
    }

    public final void setMaxLifecycle(Fragment fragment, Lifecycle.State state) {
        if (fragment.equals(this.mFragmentStore.findActiveFragment(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this)) {
            fragment.mMaxState = state;
            return;
        }
        throw new IllegalArgumentException(UUFMQdNK.nhBRpRc + fragment + " is not an active fragment of FragmentManager " + this);
    }
}
