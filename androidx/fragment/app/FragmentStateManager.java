package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.appcompat.view.menu.CascadingMenuPopup;
import androidx.appcompat.view.menu.StandardMenuPopup;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.FragmentTagUsageViolation;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import androidx.loader.app.LoaderManagerImpl;
import androidx.loader.app.gv.DYYbQc;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.room.RoomOpenHelper;
import com.daerisoft.thespikerm.R;
import com.google.android.gms.ads.internal.gMU.QTaELkFI;
import com.google.android.gms.ads.rewarded.zQ.yzwzcWHcnH;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;
import okhttp3.Dispatcher;

/* JADX INFO: loaded from: classes2.dex */
public final class FragmentStateManager {
    public final RoomOpenHelper mDispatcher;
    public final Fragment mFragment;
    public final Dispatcher mFragmentStore;
    public boolean mMovingToState = false;
    public int mFragmentManagerState = -1;

    public FragmentStateManager(RoomOpenHelper roomOpenHelper, Dispatcher dispatcher, Fragment fragment) {
        this.mDispatcher = roomOpenHelper;
        this.mFragmentStore = dispatcher;
        this.mFragment = fragment;
    }

    public final void activityCreated() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        Fragment fragment = this.mFragment;
        if (zIsLoggable) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + fragment);
        }
        Bundle bundle = fragment.mSavedFragmentState;
        fragment.mChildFragmentManager.noteStateNotSaved();
        fragment.mState = 3;
        fragment.mCalled = false;
        fragment.onActivityCreated(bundle);
        if (!fragment.mCalled) {
            throw new SuperNotCalledException(Fragment$$ExternalSyntheticOutline0.m("Fragment ", fragment, " did not call through to super.onActivityCreated()"));
        }
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + fragment);
        }
        View view = fragment.mView;
        if (view != null) {
            Bundle bundle2 = fragment.mSavedFragmentState;
            SparseArray<Parcelable> sparseArray = fragment.mSavedViewState;
            if (sparseArray != null) {
                view.restoreHierarchyState(sparseArray);
                fragment.mSavedViewState = null;
            }
            if (fragment.mView != null) {
                fragment.mViewLifecycleOwner.mSavedStateRegistryController.performRestore(fragment.mSavedViewRegistryState);
                fragment.mSavedViewRegistryState = null;
            }
            fragment.mCalled = false;
            fragment.onViewStateRestored(bundle2);
            if (!fragment.mCalled) {
                throw new SuperNotCalledException(Fragment$$ExternalSyntheticOutline0.m("Fragment ", fragment, " did not call through to super.onViewStateRestored()"));
            }
            if (fragment.mView != null) {
                fragment.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
            }
        }
        fragment.mSavedFragmentState = null;
        FragmentManagerImpl fragmentManagerImpl = fragment.mChildFragmentManager;
        fragmentManagerImpl.mStateSaved = false;
        fragmentManagerImpl.mStopped = false;
        fragmentManagerImpl.mNonConfig.mIsStateSaved = false;
        fragmentManagerImpl.dispatchStateChange(4);
        this.mDispatcher.dispatchOnFragmentActivityCreated(false);
    }

    public final void addViewToContainer() {
        View view;
        View view2;
        Dispatcher dispatcher = this.mFragmentStore;
        dispatcher.getClass();
        Fragment fragment = this.mFragment;
        ViewGroup viewGroup = fragment.mContainer;
        int iIndexOfChild = -1;
        if (viewGroup != null) {
            ArrayList arrayList = (ArrayList) dispatcher.executorServiceOrNull;
            int iIndexOf = arrayList.indexOf(fragment);
            for (int i = iIndexOf - 1; i >= 0; i--) {
                Fragment fragment2 = (Fragment) arrayList.get(i);
                if (fragment2.mContainer == viewGroup && (view2 = fragment2.mView) != null) {
                    iIndexOfChild = viewGroup.indexOfChild(view2) + 1;
                }
            }
            while (true) {
                iIndexOf++;
                if (iIndexOf >= arrayList.size()) {
                    break;
                }
                Fragment fragment3 = (Fragment) arrayList.get(iIndexOf);
                if (fragment3.mContainer == viewGroup && (view = fragment3.mView) != null) {
                    iIndexOfChild = viewGroup.indexOfChild(view);
                    break;
                }
            }
        }
        fragment.mContainer.addView(fragment.mView, iIndexOfChild);
    }

    public final void attach() {
        String str = DYYbQc.OpQfnWK;
        boolean zIsLoggable = Log.isLoggable(str, 3);
        Fragment fragment = this.mFragment;
        if (zIsLoggable) {
            Log.d(str, "moveto ATTACHED: " + fragment);
        }
        Fragment fragment2 = fragment.mTarget;
        FragmentStateManager fragmentStateManager = null;
        Dispatcher dispatcher = this.mFragmentStore;
        if (fragment2 != null) {
            FragmentStateManager fragmentStateManager2 = (FragmentStateManager) ((HashMap) dispatcher.readyAsyncCalls).get(fragment2.mWho);
            if (fragmentStateManager2 == null) {
                throw new IllegalStateException("Fragment " + fragment + " declared target fragment " + fragment.mTarget + " that does not belong to this FragmentManager!");
            }
            fragment.mTargetWho = fragment.mTarget.mWho;
            fragment.mTarget = null;
            fragmentStateManager = fragmentStateManager2;
        } else {
            String str2 = fragment.mTargetWho;
            if (str2 != null && (fragmentStateManager = (FragmentStateManager) ((HashMap) dispatcher.readyAsyncCalls).get(str2)) == null) {
                StringBuilder sb = new StringBuilder("Fragment ");
                sb.append(fragment);
                sb.append(" declared target fragment ");
                throw new IllegalStateException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(sb, fragment.mTargetWho, " that does not belong to this FragmentManager!"));
            }
        }
        if (fragmentStateManager != null) {
            fragmentStateManager.moveToExpectedState();
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        fragment.mHost = fragmentManager.mHost;
        fragment.mParentFragment = fragmentManager.mParent;
        RoomOpenHelper roomOpenHelper = this.mDispatcher;
        roomOpenHelper.dispatchOnFragmentPreAttached(false);
        ArrayList arrayList = fragment.mOnPreAttachedListeners;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Fragment.OnPreAttachedListener) it.next()).onPreAttached();
        }
        arrayList.clear();
        fragment.mChildFragmentManager.attachController(fragment.mHost, fragment.createFragmentContainer(), fragment);
        fragment.mState = 0;
        fragment.mCalled = false;
        fragment.onAttach((Context) fragment.mHost.mContext);
        if (!fragment.mCalled) {
            throw new SuperNotCalledException(Fragment$$ExternalSyntheticOutline0.m("Fragment ", fragment, " did not call through to super.onAttach()"));
        }
        Iterator it2 = fragment.mFragmentManager.mOnAttachListeners.iterator();
        while (it2.hasNext()) {
            ((FragmentOnAttachListener) it2.next()).onAttachFragment$1(fragment);
        }
        FragmentManagerImpl fragmentManagerImpl = fragment.mChildFragmentManager;
        fragmentManagerImpl.mStateSaved = false;
        fragmentManagerImpl.mStopped = false;
        fragmentManagerImpl.mNonConfig.mIsStateSaved = false;
        fragmentManagerImpl.dispatchStateChange(0);
        roomOpenHelper.dispatchOnFragmentAttached(false);
    }

    public final void create() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        Fragment fragment = this.mFragment;
        if (zIsLoggable) {
            Log.d("FragmentManager", "moveto CREATED: " + fragment);
        }
        if (fragment.mIsCreated) {
            fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
            fragment.mState = 1;
            return;
        }
        RoomOpenHelper roomOpenHelper = this.mDispatcher;
        roomOpenHelper.dispatchOnFragmentPreCreated(false);
        Bundle bundle = fragment.mSavedFragmentState;
        fragment.mChildFragmentManager.noteStateNotSaved();
        fragment.mState = 1;
        fragment.mCalled = false;
        fragment.mLifecycleRegistry.addObserver(new LifecycleEventObserver() { // from class: androidx.fragment.app.Fragment.6
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
        });
        fragment.mSavedStateRegistryController.performRestore(bundle);
        fragment.onCreate(bundle);
        fragment.mIsCreated = true;
        if (!fragment.mCalled) {
            throw new SuperNotCalledException(Fragment$$ExternalSyntheticOutline0.m("Fragment ", fragment, " did not call through to super.onCreate()"));
        }
        fragment.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        roomOpenHelper.dispatchOnFragmentCreated(false);
    }

    public final void createView() {
        String resourceName;
        int i = 0;
        Fragment fragment = this.mFragment;
        if (fragment.mFromLayout) {
            return;
        }
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + fragment);
        }
        LayoutInflater layoutInflaterOnGetLayoutInflater = fragment.onGetLayoutInflater(fragment.mSavedFragmentState);
        fragment.mLayoutInflater = layoutInflaterOnGetLayoutInflater;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            int i2 = fragment.mContainerId;
            if (i2 == 0) {
                viewGroup = null;
            } else {
                if (i2 == -1) {
                    throw new IllegalArgumentException(Fragment$$ExternalSyntheticOutline0.m("Cannot create fragment ", fragment, " for a container view with no id"));
                }
                viewGroup = (ViewGroup) fragment.mFragmentManager.mContainer.onFindViewById(i2);
                if (viewGroup == null) {
                    if (!fragment.mRestored) {
                        try {
                            resourceName = fragment.getResources().getResourceName(fragment.mContainerId);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(fragment.mContainerId) + " (" + resourceName + ") for fragment " + fragment);
                    }
                } else if (!(viewGroup instanceof FragmentContainerView)) {
                    FragmentStrictMode.Policy policy = FragmentStrictMode.defaultPolicy;
                    FragmentStrictMode.logIfDebuggingEnabled(new FragmentTagUsageViolation(fragment, viewGroup, 1));
                    FragmentStrictMode.getNearestPolicy(fragment).getClass();
                }
            }
        }
        fragment.mContainer = viewGroup;
        fragment.performCreateView(layoutInflaterOnGetLayoutInflater, viewGroup, fragment.mSavedFragmentState);
        View view = fragment.mView;
        if (view != null) {
            view.setSaveFromParentEnabled(false);
            fragment.mView.setTag(R.id.fragment_container_view_tag, fragment);
            if (viewGroup != null) {
                addViewToContainer();
            }
            if (fragment.mHidden) {
                fragment.mView.setVisibility(8);
            }
            View view2 = fragment.mView;
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            if (view2.isAttachedToWindow()) {
                ViewCompat.Api20Impl.requestApplyInsets(fragment.mView);
            } else {
                View view3 = fragment.mView;
                view3.addOnAttachStateChangeListener(new AnonymousClass1(view3, i));
            }
            fragment.onViewCreated(fragment.mView, fragment.mSavedFragmentState);
            fragment.mChildFragmentManager.dispatchStateChange(2);
            this.mDispatcher.dispatchOnFragmentViewCreated(false);
            int visibility = fragment.mView.getVisibility();
            fragment.ensureAnimationInfo().mPostOnViewCreatedAlpha = fragment.mView.getAlpha();
            if (fragment.mContainer != null && visibility == 0) {
                View viewFindFocus = fragment.mView.findFocus();
                if (viewFindFocus != null) {
                    fragment.ensureAnimationInfo().mFocusedView = viewFindFocus;
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + fragment);
                    }
                }
                fragment.mView.setAlpha(0.0f);
            }
        }
        fragment.mState = 2;
    }

    public final void destroy() {
        Fragment fragmentFindActiveFragment;
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        Fragment fragment = this.mFragment;
        if (zIsLoggable) {
            Log.d("FragmentManager", "movefrom CREATED: " + fragment);
        }
        boolean zIsChangingConfigurations = true;
        boolean z = fragment.mRemoving && !fragment.isInBackStack();
        Dispatcher dispatcher = this.mFragmentStore;
        if (z) {
        }
        if (!z) {
            FragmentManagerViewModel fragmentManagerViewModel = (FragmentManagerViewModel) dispatcher.runningSyncCalls;
            if (!((fragmentManagerViewModel.mRetainedFragments.containsKey(fragment.mWho) && fragmentManagerViewModel.mStateAutomaticallySaved) ? fragmentManagerViewModel.mHasBeenCleared : true)) {
                String str = fragment.mTargetWho;
                if (str != null && (fragmentFindActiveFragment = dispatcher.findActiveFragment(str)) != null && fragmentFindActiveFragment.mRetainInstance) {
                    fragment.mTarget = fragmentFindActiveFragment;
                }
                fragment.mState = 0;
                return;
            }
        }
        FragmentActivity.HostCallbacks hostCallbacks = fragment.mHost;
        if (hostCallbacks instanceof ViewModelStoreOwner) {
            zIsChangingConfigurations = ((FragmentManagerViewModel) dispatcher.runningSyncCalls).mHasBeenCleared;
        } else {
            FragmentActivity fragmentActivity = hostCallbacks.mContext;
            if (fragmentActivity instanceof Activity) {
                zIsChangingConfigurations = true ^ fragmentActivity.isChangingConfigurations();
            }
        }
        if (z || zIsChangingConfigurations) {
            ((FragmentManagerViewModel) dispatcher.runningSyncCalls).clearNonConfigState(fragment);
        }
        fragment.mChildFragmentManager.dispatchDestroy();
        fragment.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        fragment.mState = 0;
        fragment.mCalled = false;
        fragment.mIsCreated = false;
        fragment.onDestroy();
        if (!fragment.mCalled) {
            throw new SuperNotCalledException(Fragment$$ExternalSyntheticOutline0.m("Fragment ", fragment, " did not call through to super.onDestroy()"));
        }
        this.mDispatcher.dispatchOnFragmentDestroyed(false);
        for (FragmentStateManager fragmentStateManager : dispatcher.getActiveFragmentStateManagers()) {
            if (fragmentStateManager != null) {
                String str2 = fragment.mWho;
                Fragment fragment2 = fragmentStateManager.mFragment;
                if (str2.equals(fragment2.mTargetWho)) {
                    fragment2.mTarget = fragment;
                    fragment2.mTargetWho = null;
                }
            }
        }
        String str3 = fragment.mTargetWho;
        if (str3 != null) {
            fragment.mTarget = dispatcher.findActiveFragment(str3);
        }
        dispatcher.makeInactive(this);
    }

    public final void destroyFragmentView() {
        View view;
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        Fragment fragment = this.mFragment;
        if (zIsLoggable) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + fragment);
        }
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && (view = fragment.mView) != null) {
            viewGroup.removeView(view);
        }
        fragment.mChildFragmentManager.dispatchStateChange(1);
        if (fragment.mView != null) {
            FragmentViewLifecycleOwner fragmentViewLifecycleOwner = fragment.mViewLifecycleOwner;
            fragmentViewLifecycleOwner.initialize();
            if (fragmentViewLifecycleOwner.mLifecycleRegistry.state.compareTo(Lifecycle.State.CREATED) >= 0) {
                fragment.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
            }
        }
        fragment.mState = 1;
        fragment.mCalled = false;
        fragment.onDestroyView();
        if (!fragment.mCalled) {
            throw new SuperNotCalledException(Fragment$$ExternalSyntheticOutline0.m("Fragment ", fragment, " did not call through to super.onDestroyView()"));
        }
        SparseArrayCompat sparseArrayCompat = LoaderManager.getInstance(fragment).mLoaderViewModel.mLoaders;
        int i = sparseArrayCompat.mSize;
        for (int i2 = 0; i2 < i; i2++) {
            ((LoaderManagerImpl.LoaderInfo) sparseArrayCompat.mValues[i2]).markForRedelivery();
        }
        fragment.mPerformedCreateView = false;
        this.mDispatcher.dispatchOnFragmentViewDestroyed(false);
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.setValue(null);
        fragment.mInLayout = false;
    }

    public final void detach() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        Fragment fragment = this.mFragment;
        if (zIsLoggable) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + fragment);
        }
        fragment.mState = -1;
        fragment.mCalled = false;
        fragment.onDetach();
        fragment.mLayoutInflater = null;
        if (!fragment.mCalled) {
            throw new SuperNotCalledException(Fragment$$ExternalSyntheticOutline0.m("Fragment ", fragment, " did not call through to super.onDetach()"));
        }
        FragmentManagerImpl fragmentManagerImpl = fragment.mChildFragmentManager;
        if (!fragmentManagerImpl.mDestroyed) {
            fragmentManagerImpl.dispatchDestroy();
            fragment.mChildFragmentManager = new FragmentManagerImpl();
        }
        this.mDispatcher.dispatchOnFragmentDetached(false);
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if (!fragment.mRemoving || fragment.isInBackStack()) {
            FragmentManagerViewModel fragmentManagerViewModel = (FragmentManagerViewModel) this.mFragmentStore.runningSyncCalls;
            boolean z = true;
            if (fragmentManagerViewModel.mRetainedFragments.containsKey(fragment.mWho) && fragmentManagerViewModel.mStateAutomaticallySaved) {
                z = fragmentManagerViewModel.mHasBeenCleared;
            }
            if (!z) {
                return;
            }
        }
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "initState called for fragment: " + fragment);
        }
        fragment.initState();
    }

    public final void ensureInflatedView() {
        Fragment fragment = this.mFragment;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (Log.isLoggable("FragmentManager", 3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + fragment);
            }
            LayoutInflater layoutInflaterOnGetLayoutInflater = fragment.onGetLayoutInflater(fragment.mSavedFragmentState);
            fragment.mLayoutInflater = layoutInflaterOnGetLayoutInflater;
            fragment.performCreateView(layoutInflaterOnGetLayoutInflater, null, fragment.mSavedFragmentState);
            View view = fragment.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                fragment.mView.setTag(R.id.fragment_container_view_tag, fragment);
                if (fragment.mHidden) {
                    fragment.mView.setVisibility(8);
                }
                fragment.onViewCreated(fragment.mView, fragment.mSavedFragmentState);
                fragment.mChildFragmentManager.dispatchStateChange(2);
                this.mDispatcher.dispatchOnFragmentViewCreated(false);
                fragment.mState = 2;
            }
        }
    }

    public final void moveToExpectedState() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        Dispatcher dispatcher = this.mFragmentStore;
        boolean z = this.mMovingToState;
        Fragment fragment = this.mFragment;
        if (z) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + fragment);
                return;
            }
            return;
        }
        try {
            this.mMovingToState = true;
            boolean z2 = false;
            while (true) {
                int iComputeExpectedState = computeExpectedState();
                int i = fragment.mState;
                if (iComputeExpectedState == i) {
                    if (!z2 && i == -1 && fragment.mRemoving && !fragment.isInBackStack()) {
                        if (Log.isLoggable("FragmentManager", 3)) {
                            Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + fragment);
                        }
                        ((FragmentManagerViewModel) dispatcher.runningSyncCalls).clearNonConfigState(fragment);
                        dispatcher.makeInactive(this);
                        if (Log.isLoggable("FragmentManager", 3)) {
                            Log.d("FragmentManager", "initState called for fragment: " + fragment);
                        }
                        fragment.initState();
                    }
                    if (fragment.mHiddenChanged) {
                        if (fragment.mView != null && (viewGroup = fragment.mContainer) != null) {
                            DefaultSpecialEffectsController orCreateController = DefaultSpecialEffectsController.getOrCreateController(viewGroup, fragment.getParentFragmentManager());
                            if (fragment.mHidden) {
                                orCreateController.getClass();
                                if (Log.isLoggable("FragmentManager", 2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + fragment);
                                }
                                orCreateController.enqueue(3, 1, this);
                            } else {
                                orCreateController.getClass();
                                if (Log.isLoggable("FragmentManager", 2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + fragment);
                                }
                                orCreateController.enqueue(2, 1, this);
                            }
                        }
                        FragmentManager fragmentManager = fragment.mFragmentManager;
                        if (fragmentManager != null && fragment.mAdded && FragmentManager.isMenuAvailable(fragment)) {
                            fragmentManager.mNeedMenuInvalidate = true;
                        }
                        fragment.mHiddenChanged = false;
                        fragment.onHiddenChanged(fragment.mHidden);
                        fragment.mChildFragmentManager.dispatchOnHiddenChanged();
                    }
                    return;
                }
                if (iComputeExpectedState <= i) {
                    switch (i - 1) {
                        case -1:
                            detach();
                            break;
                        case 0:
                            destroy();
                            break;
                        case 1:
                            destroyFragmentView();
                            fragment.mState = 1;
                            break;
                        case 2:
                            fragment.mInLayout = false;
                            fragment.mState = 2;
                            break;
                        case 3:
                            if (Log.isLoggable("FragmentManager", 3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + fragment);
                            }
                            if (fragment.mView != null && fragment.mSavedViewState == null) {
                                saveViewState();
                            }
                            if (fragment.mView != null && (viewGroup2 = fragment.mContainer) != null) {
                                DefaultSpecialEffectsController orCreateController2 = DefaultSpecialEffectsController.getOrCreateController(viewGroup2, fragment.getParentFragmentManager());
                                orCreateController2.getClass();
                                if (Log.isLoggable("FragmentManager", 2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + fragment);
                                }
                                orCreateController2.enqueue(1, 3, this);
                            }
                            fragment.mState = 3;
                            break;
                        case 4:
                            stop();
                            break;
                        case 5:
                            fragment.mState = 5;
                            break;
                        case 6:
                            pause();
                            break;
                    }
                } else {
                    switch (i + 1) {
                        case 0:
                            attach();
                            break;
                        case 1:
                            create();
                            break;
                        case 2:
                            ensureInflatedView();
                            createView();
                            break;
                        case 3:
                            activityCreated();
                            break;
                        case 4:
                            if (fragment.mView != null && (viewGroup3 = fragment.mContainer) != null) {
                                DefaultSpecialEffectsController orCreateController3 = DefaultSpecialEffectsController.getOrCreateController(viewGroup3, fragment.getParentFragmentManager());
                                int i_from = Fragment$$ExternalSyntheticOutline0._from(fragment.mView.getVisibility());
                                orCreateController3.getClass();
                                if (Log.isLoggable("FragmentManager", 2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + fragment);
                                }
                                orCreateController3.enqueue(i_from, 2, this);
                            }
                            fragment.mState = 4;
                            break;
                        case 5:
                            start();
                            break;
                        case 6:
                            fragment.mState = 6;
                            break;
                        case 7:
                            resume();
                            break;
                    }
                }
                z2 = true;
            }
        } finally {
            this.mMovingToState = false;
        }
    }

    public final void pause() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        Fragment fragment = this.mFragment;
        if (zIsLoggable) {
            Log.d("FragmentManager", "movefrom RESUMED: " + fragment);
        }
        fragment.mChildFragmentManager.dispatchStateChange(5);
        if (fragment.mView != null) {
            fragment.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        }
        fragment.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        fragment.mState = 6;
        fragment.mCalled = false;
        fragment.onPause();
        if (!fragment.mCalled) {
            throw new SuperNotCalledException(Fragment$$ExternalSyntheticOutline0.m("Fragment ", fragment, " did not call through to super.onPause()"));
        }
        this.mDispatcher.dispatchOnFragmentPaused(false);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0041  */
    /* JADX WARN: Code duplicated, block: B:21:0x0052  */
    /* JADX WARN: Code duplicated, block: B:22:0x0055  */
    public final void resume() {
        boolean zRequestFocus;
        String str;
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        Fragment fragment = this.mFragment;
        if (zIsLoggable) {
            Log.d("FragmentManager", "moveto RESUMED: " + fragment);
        }
        Fragment.AnimationInfo animationInfo = fragment.mAnimationInfo;
        View view = animationInfo == null ? null : animationInfo.mFocusedView;
        if (view != null) {
            if (view == fragment.mView) {
                zRequestFocus = view.requestFocus();
                if (Log.isLoggable("FragmentManager", 2)) {
                    StringBuilder sb = new StringBuilder("requestFocus: Restoring focused view ");
                    sb.append(view);
                    sb.append(" ");
                    if (zRequestFocus) {
                        str = "succeeded";
                    } else {
                        str = "failed";
                    }
                    sb.append(str);
                    sb.append(" on Fragment ");
                    sb.append(fragment);
                    sb.append(" resulting in focused view ");
                    sb.append(fragment.mView.findFocus());
                    Log.v("FragmentManager", sb.toString());
                }
            } else {
                ViewParent parent = view.getParent();
                while (true) {
                    if (parent != null) {
                        if (parent == fragment.mView) {
                            zRequestFocus = view.requestFocus();
                            if (Log.isLoggable("FragmentManager", 2)) {
                                StringBuilder sb2 = new StringBuilder("requestFocus: Restoring focused view ");
                                sb2.append(view);
                                sb2.append(" ");
                                if (zRequestFocus) {
                                    str = "succeeded";
                                } else {
                                    str = "failed";
                                }
                                sb2.append(str);
                                sb2.append(" on Fragment ");
                                sb2.append(fragment);
                                sb2.append(" resulting in focused view ");
                                sb2.append(fragment.mView.findFocus());
                                Log.v("FragmentManager", sb2.toString());
                            }
                        } else {
                            parent = parent.getParent();
                        }
                    }
                }
            }
        }
        fragment.ensureAnimationInfo().mFocusedView = null;
        fragment.mChildFragmentManager.noteStateNotSaved();
        fragment.mChildFragmentManager.execPendingActions(true);
        fragment.mState = 7;
        fragment.mCalled = false;
        fragment.onResume();
        if (!fragment.mCalled) {
            throw new SuperNotCalledException(Fragment$$ExternalSyntheticOutline0.m("Fragment ", fragment, " did not call through to super.onResume()"));
        }
        LifecycleRegistry lifecycleRegistry = fragment.mLifecycleRegistry;
        Lifecycle.Event event = Lifecycle.Event.ON_RESUME;
        lifecycleRegistry.handleLifecycleEvent(event);
        if (fragment.mView != null) {
            fragment.mViewLifecycleOwner.mLifecycleRegistry.handleLifecycleEvent(event);
        }
        FragmentManagerImpl fragmentManagerImpl = fragment.mChildFragmentManager;
        fragmentManagerImpl.mStateSaved = false;
        fragmentManagerImpl.mStopped = false;
        fragmentManagerImpl.mNonConfig.mIsStateSaved = false;
        fragmentManagerImpl.dispatchStateChange(7);
        this.mDispatcher.dispatchOnFragmentResumed(false);
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    public final void saveViewState() {
        Fragment fragment = this.mFragment;
        if (fragment.mView == null) {
            return;
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Saving view state for fragment " + fragment + " with view " + fragment.mView);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        fragment.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            fragment.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        fragment.mViewLifecycleOwner.mSavedStateRegistryController.performSave(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        fragment.mSavedViewRegistryState = bundle;
    }

    public final void start() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        Fragment fragment = this.mFragment;
        if (zIsLoggable) {
            Log.d("FragmentManager", "moveto STARTED: " + fragment);
        }
        fragment.mChildFragmentManager.noteStateNotSaved();
        fragment.mChildFragmentManager.execPendingActions(true);
        fragment.mState = 5;
        fragment.mCalled = false;
        fragment.onStart();
        if (!fragment.mCalled) {
            throw new SuperNotCalledException(Fragment$$ExternalSyntheticOutline0.m("Fragment ", fragment, " did not call through to super.onStart()"));
        }
        LifecycleRegistry lifecycleRegistry = fragment.mLifecycleRegistry;
        Lifecycle.Event event = Lifecycle.Event.ON_START;
        lifecycleRegistry.handleLifecycleEvent(event);
        if (fragment.mView != null) {
            fragment.mViewLifecycleOwner.mLifecycleRegistry.handleLifecycleEvent(event);
        }
        FragmentManagerImpl fragmentManagerImpl = fragment.mChildFragmentManager;
        fragmentManagerImpl.mStateSaved = false;
        fragmentManagerImpl.mStopped = false;
        fragmentManagerImpl.mNonConfig.mIsStateSaved = false;
        fragmentManagerImpl.dispatchStateChange(5);
        this.mDispatcher.dispatchOnFragmentStarted(false);
    }

    public final void stop() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        Fragment fragment = this.mFragment;
        if (zIsLoggable) {
            Log.d("FragmentManager", "movefrom STARTED: " + fragment);
        }
        FragmentManagerImpl fragmentManagerImpl = fragment.mChildFragmentManager;
        fragmentManagerImpl.mStopped = true;
        fragmentManagerImpl.mNonConfig.mIsStateSaved = true;
        fragmentManagerImpl.dispatchStateChange(4);
        if (fragment.mView != null) {
            fragment.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        }
        fragment.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        fragment.mState = 4;
        fragment.mCalled = false;
        fragment.onStop();
        if (!fragment.mCalled) {
            throw new SuperNotCalledException(Fragment$$ExternalSyntheticOutline0.m("Fragment ", fragment, " did not call through to super.onStop()"));
        }
        this.mDispatcher.dispatchOnFragmentStopped(false);
    }

    public final int computeExpectedState() {
        SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation;
        Fragment fragment = this.mFragment;
        if (fragment.mFragmentManager == null) {
            return fragment.mState;
        }
        int iMin = this.mFragmentManagerState;
        int iOrdinal = fragment.mMaxState.ordinal();
        int i = 0;
        if (iOrdinal == 1) {
            iMin = Math.min(iMin, 0);
        } else if (iOrdinal == 2) {
            iMin = Math.min(iMin, 1);
        } else if (iOrdinal == 3) {
            iMin = Math.min(iMin, 5);
        } else if (iOrdinal != 4) {
            iMin = Math.min(iMin, -1);
        }
        if (fragment.mFromLayout) {
            if (fragment.mInLayout) {
                iMin = Math.max(this.mFragmentManagerState, 2);
                View view = fragment.mView;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = this.mFragmentManagerState < 4 ? Math.min(iMin, fragment.mState) : Math.min(iMin, 1);
            }
        }
        if (!fragment.mAdded) {
            iMin = Math.min(iMin, 1);
        }
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            DefaultSpecialEffectsController orCreateController = DefaultSpecialEffectsController.getOrCreateController(viewGroup, fragment.getParentFragmentManager());
            orCreateController.getClass();
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperationFindPendingOperation = orCreateController.findPendingOperation(fragment);
            i = specialEffectsController$FragmentStateManagerOperationFindPendingOperation != null ? specialEffectsController$FragmentStateManagerOperationFindPendingOperation.mLifecycleImpact : 0;
            Iterator it = orCreateController.mRunningOperations.iterator();
            while (true) {
                if (!it.hasNext()) {
                    specialEffectsController$FragmentStateManagerOperation = null;
                    break;
                }
                specialEffectsController$FragmentStateManagerOperation = (SpecialEffectsController$FragmentStateManagerOperation) it.next();
                if (specialEffectsController$FragmentStateManagerOperation.mFragment.equals(fragment) && !specialEffectsController$FragmentStateManagerOperation.mIsCanceled) {
                    break;
                }
            }
            if (specialEffectsController$FragmentStateManagerOperation != null && (i == 0 || i == 1)) {
                i = specialEffectsController$FragmentStateManagerOperation.mLifecycleImpact;
            }
        }
        if (i == 2) {
            iMin = Math.min(iMin, 6);
        } else if (i == 3) {
            iMin = Math.max(iMin, 3);
        } else if (fragment.mRemoving) {
            iMin = fragment.isInBackStack() ? Math.min(iMin, 1) : Math.min(iMin, -1);
        }
        if (fragment.mDeferStart && fragment.mState < 5) {
            iMin = Math.min(iMin, 4);
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", yzwzcWHcnH.Sgd + iMin + " for " + fragment);
        }
        return iMin;
    }

    public final void restoreState(ClassLoader classLoader) {
        Fragment fragment = this.mFragment;
        Bundle bundle = fragment.mSavedFragmentState;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
        fragment.mSavedViewRegistryState = fragment.mSavedFragmentState.getBundle("android:view_registry_state");
        fragment.mTargetWho = fragment.mSavedFragmentState.getString("android:target_state");
        if (fragment.mTargetWho != null) {
            fragment.mTargetRequestCode = fragment.mSavedFragmentState.getInt("android:target_req_state", 0);
        }
        Boolean bool = fragment.mSavedUserVisibleHint;
        if (bool != null) {
            fragment.mUserVisibleHint = bool.booleanValue();
            fragment.mSavedUserVisibleHint = null;
        } else {
            fragment.mUserVisibleHint = fragment.mSavedFragmentState.getBoolean(QTaELkFI.LOPlkrMypnnj, true);
        }
        if (fragment.mUserVisibleHint) {
            return;
        }
        fragment.mDeferStart = true;
    }

    public FragmentStateManager(RoomOpenHelper roomOpenHelper, Dispatcher dispatcher, ClassLoader classLoader, FragmentManager.AnonymousClass3 anonymousClass3, FragmentState fragmentState) {
        this.mDispatcher = roomOpenHelper;
        this.mFragmentStore = dispatcher;
        Fragment fragmentInstantiate = Fragment.instantiate(FragmentManager.this.mHost.mContext, fragmentState.mClassName, null);
        Bundle bundle = fragmentState.mArguments;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        fragmentInstantiate.setArguments(bundle);
        fragmentInstantiate.mWho = fragmentState.mWho;
        fragmentInstantiate.mFromLayout = fragmentState.mFromLayout;
        fragmentInstantiate.mRestored = true;
        fragmentInstantiate.mFragmentId = fragmentState.mFragmentId;
        fragmentInstantiate.mContainerId = fragmentState.mContainerId;
        fragmentInstantiate.mTag = fragmentState.mTag;
        fragmentInstantiate.mRetainInstance = fragmentState.mRetainInstance;
        fragmentInstantiate.mRemoving = fragmentState.mRemoving;
        fragmentInstantiate.mDetached = fragmentState.mDetached;
        fragmentInstantiate.mHidden = fragmentState.mHidden;
        fragmentInstantiate.mMaxState = Lifecycle.State.values()[fragmentState.mMaxLifecycleState];
        Bundle bundle2 = fragmentState.mSavedFragmentState;
        if (bundle2 != null) {
            fragmentInstantiate.mSavedFragmentState = bundle2;
        } else {
            fragmentInstantiate.mSavedFragmentState = new Bundle();
        }
        this.mFragment = fragmentInstantiate;
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Instantiated fragment " + fragmentInstantiate);
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentStateManager$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes.dex */
    public final class AnonymousClass1 implements View.OnAttachStateChangeListener {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object val$fragmentView;

        public /* synthetic */ AnonymousClass1(Object obj, int i) {
            this.$r8$classId = i;
            this.val$fragmentView = obj;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            switch (this.$r8$classId) {
                case 0:
                    View view2 = (View) this.val$fragmentView;
                    view2.removeOnAttachStateChangeListener(this);
                    WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    ViewCompat.Api20Impl.requestApplyInsets(view2);
                    break;
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            switch (this.$r8$classId) {
                case 0:
                    break;
                case 1:
                    CascadingMenuPopup cascadingMenuPopup = (CascadingMenuPopup) this.val$fragmentView;
                    ViewTreeObserver viewTreeObserver = cascadingMenuPopup.mTreeObserver;
                    if (viewTreeObserver != null) {
                        if (!viewTreeObserver.isAlive()) {
                            cascadingMenuPopup.mTreeObserver = view.getViewTreeObserver();
                        }
                        cascadingMenuPopup.mTreeObserver.removeGlobalOnLayoutListener(cascadingMenuPopup.mGlobalLayoutListener);
                    }
                    view.removeOnAttachStateChangeListener(this);
                    break;
                default:
                    StandardMenuPopup standardMenuPopup = (StandardMenuPopup) this.val$fragmentView;
                    ViewTreeObserver viewTreeObserver2 = standardMenuPopup.mTreeObserver;
                    if (viewTreeObserver2 != null) {
                        if (!viewTreeObserver2.isAlive()) {
                            standardMenuPopup.mTreeObserver = view.getViewTreeObserver();
                        }
                        standardMenuPopup.mTreeObserver.removeGlobalOnLayoutListener(standardMenuPopup.mGlobalLayoutListener);
                    }
                    view.removeOnAttachStateChangeListener(this);
                    break;
            }
        }

        private final void onViewAttachedToWindow$androidx$appcompat$view$menu$CascadingMenuPopup$2(View view) {
        }

        private final void onViewAttachedToWindow$androidx$appcompat$view$menu$StandardMenuPopup$2(View view) {
        }

        private final void onViewDetachedFromWindow$androidx$fragment$app$FragmentStateManager$1(View view) {
        }
    }

    public FragmentStateManager(RoomOpenHelper roomOpenHelper, Dispatcher dispatcher, Fragment fragment, FragmentState fragmentState) {
        this.mDispatcher = roomOpenHelper;
        this.mFragmentStore = dispatcher;
        this.mFragment = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        Bundle bundle = fragmentState.mSavedFragmentState;
        if (bundle != null) {
            fragment.mSavedFragmentState = bundle;
        } else {
            fragment.mSavedFragmentState = new Bundle();
        }
    }
}
