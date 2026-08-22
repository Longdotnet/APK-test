package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.appcompat.view.menu.BaseMenuWrapper;
import androidx.collection.ArrayMap;
import androidx.collection.MapCollections$KeySet;
import androidx.collection.MapCollections$MapIterator;
import androidx.collection.SimpleArrayMap;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat$Api21Impl;
import androidx.emoji2.text.flatbuffer.bs.bUqMCsuPSX;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.room.RoomOpenHelper;
import androidx.work.InputMergerFactory$1;
import androidx.work.Worker;
import androidx.work.impl.WorkerWrapper;
import com.daerisoft.thespikerm.R;
import com.google.android.datatransport.runtime.synchronization.JDyk.FETmZwrVHuasmL;
import com.google.android.gms.ads.zza;
import com.google.firebase.analytics.connector.pDv.PZmDzEagKNdW;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Dispatcher;

/* JADX INFO: loaded from: classes2.dex */
public final class DefaultSpecialEffectsController {
    public final ViewGroup mContainer;
    public final ArrayList mPendingOperations = new ArrayList();
    public final ArrayList mRunningOperations = new ArrayList();
    public boolean mOperationDirectionIsPop = false;
    public boolean mIsContainerPostponed = false;

    /* JADX INFO: renamed from: androidx.fragment.app.DefaultSpecialEffectsController$4, reason: invalid class name */
    public final class AnonymousClass4 implements Animation.AnimationListener {
        public final /* synthetic */ AnimationInfo val$animationInfo;
        public final /* synthetic */ ViewGroup val$container;
        public final /* synthetic */ SpecialEffectsController$FragmentStateManagerOperation val$operation;
        public final /* synthetic */ View val$viewToAnimate;

        public AnonymousClass4(SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation, ViewGroup viewGroup, View view, AnimationInfo animationInfo) {
            this.val$operation = specialEffectsController$FragmentStateManagerOperation;
            this.val$container = viewGroup;
            this.val$viewToAnimate = view;
            this.val$animationInfo = animationInfo;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation animation) {
            this.val$container.post(new Worker.AnonymousClass1(this, 8));
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "Animation from operation " + this.val$operation + " has ended.");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation animation) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", FETmZwrVHuasmL.EGfLecFJDaxSLw + this.val$operation + " has reached onAnimationStart.");
            }
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public final class AnimationInfo extends BaseMenuWrapper {
        public RoomOpenHelper mAnimation;
        public boolean mIsPop;
        public boolean mLoadedAnim;

        /* JADX WARN: Code duplicated, block: B:18:0x0027  */
        /* JADX WARN: Code duplicated, block: B:86:0x0102 A[Catch: RuntimeException -> 0x0108, TRY_LEAVE, TryCatch #0 {RuntimeException -> 0x0108, blocks: (B:84:0x00fc, B:86:0x0102), top: B:97:0x00fc }] */
        public final RoomOpenHelper getAnimation(Context context) {
            int i;
            RoomOpenHelper roomOpenHelper;
            Animator animatorLoadAnimator;
            int activityTransitResId;
            if (this.mLoadedAnim) {
                return this.mAnimation;
            }
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = (SpecialEffectsController$FragmentStateManagerOperation) this.mContext;
            boolean z = specialEffectsController$FragmentStateManagerOperation.mFinalState == 2;
            Fragment fragment = specialEffectsController$FragmentStateManagerOperation.mFragment;
            Fragment.AnimationInfo animationInfo = fragment.mAnimationInfo;
            int i2 = animationInfo == null ? 0 : animationInfo.mNextTransition;
            if (this.mIsPop) {
                if (z) {
                    if (animationInfo == null) {
                        i = 0;
                    } else {
                        i = animationInfo.mPopEnterAnim;
                    }
                } else if (animationInfo == null) {
                    i = 0;
                } else {
                    i = animationInfo.mPopExitAnim;
                }
            } else if (z) {
                if (animationInfo == null) {
                    i = 0;
                } else {
                    i = animationInfo.mEnterAnim;
                }
            } else if (animationInfo == null) {
                i = 0;
            } else {
                i = animationInfo.mExitAnim;
            }
            fragment.setAnimations(0, 0, 0, 0);
            ViewGroup viewGroup = fragment.mContainer;
            RoomOpenHelper roomOpenHelper2 = null;
            if (viewGroup != null && viewGroup.getTag(R.id.visible_removing_fragment_view_tag) != null) {
                fragment.mContainer.setTag(R.id.visible_removing_fragment_view_tag, null);
            }
            ViewGroup viewGroup2 = fragment.mContainer;
            if (viewGroup2 == null || viewGroup2.getLayoutTransition() == null) {
                Animation animationOnCreateAnimation = fragment.onCreateAnimation(i2, z, i);
                if (animationOnCreateAnimation != null) {
                    roomOpenHelper2 = new RoomOpenHelper(animationOnCreateAnimation, 9);
                } else {
                    Animator animatorOnCreateAnimator = fragment.onCreateAnimator(i2, z, i);
                    if (animatorOnCreateAnimator != null) {
                        roomOpenHelper2 = new RoomOpenHelper(animatorOnCreateAnimator);
                    } else {
                        if (i == 0 && i2 != 0) {
                            if (i2 == 4097) {
                                activityTransitResId = z ? R.animator.fragment_open_enter : R.animator.fragment_open_exit;
                            } else if (i2 == 8194) {
                                activityTransitResId = z ? R.animator.fragment_close_enter : R.animator.fragment_close_exit;
                            } else if (i2 == 8197) {
                                activityTransitResId = z ? MapsKt__MapsKt.toActivityTransitResId(context, android.R.attr.activityCloseEnterAnimation) : MapsKt__MapsKt.toActivityTransitResId(context, android.R.attr.activityCloseExitAnimation);
                            } else if (i2 == 4099) {
                                activityTransitResId = z ? R.animator.fragment_fade_enter : R.animator.fragment_fade_exit;
                            } else if (i2 != 4100) {
                                activityTransitResId = -1;
                            } else {
                                activityTransitResId = z ? MapsKt__MapsKt.toActivityTransitResId(context, android.R.attr.activityOpenEnterAnimation) : MapsKt__MapsKt.toActivityTransitResId(context, android.R.attr.activityOpenExitAnimation);
                            }
                            i = activityTransitResId;
                        }
                        if (i != 0) {
                            boolean zEquals = "anim".equals(context.getResources().getResourceTypeName(i));
                            if (zEquals) {
                                try {
                                    Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, i);
                                    if (animationLoadAnimation != null) {
                                        roomOpenHelper = new RoomOpenHelper(animationLoadAnimation, 9);
                                        roomOpenHelper2 = roomOpenHelper;
                                    }
                                } catch (Resources.NotFoundException e) {
                                    throw e;
                                } catch (RuntimeException unused) {
                                    try {
                                        animatorLoadAnimator = AnimatorInflater.loadAnimator(context, i);
                                        if (animatorLoadAnimator != null) {
                                            roomOpenHelper = new RoomOpenHelper(animatorLoadAnimator);
                                            roomOpenHelper2 = roomOpenHelper;
                                        }
                                    } catch (RuntimeException e2) {
                                        if (zEquals) {
                                            throw e2;
                                        }
                                        Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, i);
                                        if (animationLoadAnimation2 != null) {
                                            roomOpenHelper2 = new RoomOpenHelper(animationLoadAnimation2, 9);
                                        }
                                    }
                                }
                            } else {
                                animatorLoadAnimator = AnimatorInflater.loadAnimator(context, i);
                                if (animatorLoadAnimator != null) {
                                    roomOpenHelper = new RoomOpenHelper(animatorLoadAnimator);
                                    roomOpenHelper2 = roomOpenHelper;
                                }
                            }
                        }
                    }
                }
            }
            this.mAnimation = roomOpenHelper2;
            this.mLoadedAnim = true;
            return roomOpenHelper2;
        }
    }

    public final class TransitionInfo extends BaseMenuWrapper {
        public final boolean mOverlapAllowed;
        public final Object mSharedElementTransition;
        public final Object mTransition;

        public TransitionInfo(SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation, CancellationSignal cancellationSignal, boolean z, boolean z2) {
            super(specialEffectsController$FragmentStateManagerOperation, cancellationSignal);
            int i = specialEffectsController$FragmentStateManagerOperation.mFinalState;
            Fragment fragment = specialEffectsController$FragmentStateManagerOperation.mFragment;
            if (i == 2) {
                this.mTransition = z ? fragment.getReenterTransition() : fragment.getEnterTransition();
                this.mOverlapAllowed = z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
            } else {
                this.mTransition = z ? fragment.getReturnTransition() : fragment.getExitTransition();
                this.mOverlapAllowed = true;
            }
            if (!z2) {
                this.mSharedElementTransition = null;
            } else if (z) {
                this.mSharedElementTransition = fragment.getSharedElementReturnTransition();
            } else {
                this.mSharedElementTransition = fragment.getSharedElementEnterTransition();
            }
        }

        public final FragmentTransitionCompat21 getHandlingImpl(Object obj) {
            if (obj == null) {
                return null;
            }
            FragmentTransitionCompat21 fragmentTransitionCompat21 = FragmentTransition.PLATFORM_IMPL;
            if (obj instanceof Transition) {
                return fragmentTransitionCompat21;
            }
            FragmentTransitionCompat21 fragmentTransitionCompat22 = FragmentTransition.SUPPORT_IMPL;
            if (fragmentTransitionCompat22 != null) {
                fragmentTransitionCompat22.getClass();
                if (obj instanceof Transition) {
                    return fragmentTransitionCompat22;
                }
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + ((SpecialEffectsController$FragmentStateManagerOperation) this.mContext).mFragment + bUqMCsuPSX.riWypTfVyqfAo);
        }
    }

    public DefaultSpecialEffectsController(ViewGroup viewGroup) {
        this.mContainer = viewGroup;
    }

    public static void captureTransitioningViews(View view, ArrayList arrayList) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (ViewGroupCompat$Api21Impl.isTransitionGroup(viewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getVisibility() == 0) {
                captureTransitioningViews(childAt, arrayList);
            }
        }
    }

    public static void findNamedViews(ArrayMap arrayMap, View view) {
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        String transitionName = ViewCompat.Api21Impl.getTransitionName(view);
        if (transitionName != null) {
            arrayMap.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    findNamedViews(arrayMap, childAt);
                }
            }
        }
    }

    public static DefaultSpecialEffectsController getOrCreateController(ViewGroup viewGroup, FragmentManager fragmentManager) {
        return getOrCreateController(viewGroup, fragmentManager.getSpecialEffectsControllerFactory());
    }

    public static void retainMatchingViews(ArrayMap arrayMap, Collection collection) {
        Iterator it = ((MapCollections$KeySet) arrayMap.entrySet()).iterator();
        while (true) {
            MapCollections$MapIterator mapCollections$MapIterator = (MapCollections$MapIterator) it;
            if (!mapCollections$MapIterator.hasNext()) {
                return;
            }
            mapCollections$MapIterator.next();
            View view = (View) mapCollections$MapIterator.getValue();
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            if (!collection.contains(ViewCompat.Api21Impl.getTransitionName(view))) {
                mapCollections$MapIterator.remove();
            }
        }
    }

    public final void enqueue(int i, int i2, FragmentStateManager fragmentStateManager) {
        synchronized (this.mPendingOperations) {
            try {
                CancellationSignal cancellationSignal = new CancellationSignal();
                SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperationFindPendingOperation = findPendingOperation(fragmentStateManager.mFragment);
                if (specialEffectsController$FragmentStateManagerOperationFindPendingOperation != null) {
                    specialEffectsController$FragmentStateManagerOperationFindPendingOperation.mergeWith(i, i2);
                    return;
                }
                final SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = new SpecialEffectsController$FragmentStateManagerOperation(i, i2, fragmentStateManager, cancellationSignal);
                this.mPendingOperations.add(specialEffectsController$FragmentStateManagerOperation);
                final int i3 = 0;
                specialEffectsController$FragmentStateManagerOperation.mCompletionListeners.add(new Runnable(this) { // from class: androidx.fragment.app.SpecialEffectsController$1
                    public final /* synthetic */ DefaultSpecialEffectsController this$0;

                    {
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i3) {
                            case 0:
                                ArrayList arrayList = this.this$0.mPendingOperations;
                                SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation2 = specialEffectsController$FragmentStateManagerOperation;
                                if (arrayList.contains(specialEffectsController$FragmentStateManagerOperation2)) {
                                    Fragment$$ExternalSyntheticOutline0._applyState(specialEffectsController$FragmentStateManagerOperation2.mFragment.mView, specialEffectsController$FragmentStateManagerOperation2.mFinalState);
                                }
                                break;
                            default:
                                DefaultSpecialEffectsController defaultSpecialEffectsController = this.this$0;
                                ArrayList arrayList2 = defaultSpecialEffectsController.mPendingOperations;
                                SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation3 = specialEffectsController$FragmentStateManagerOperation;
                                arrayList2.remove(specialEffectsController$FragmentStateManagerOperation3);
                                defaultSpecialEffectsController.mRunningOperations.remove(specialEffectsController$FragmentStateManagerOperation3);
                                break;
                        }
                    }
                });
                final int i4 = 1;
                specialEffectsController$FragmentStateManagerOperation.mCompletionListeners.add(new Runnable(this) { // from class: androidx.fragment.app.SpecialEffectsController$1
                    public final /* synthetic */ DefaultSpecialEffectsController this$0;

                    {
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i4) {
                            case 0:
                                ArrayList arrayList = this.this$0.mPendingOperations;
                                SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation2 = specialEffectsController$FragmentStateManagerOperation;
                                if (arrayList.contains(specialEffectsController$FragmentStateManagerOperation2)) {
                                    Fragment$$ExternalSyntheticOutline0._applyState(specialEffectsController$FragmentStateManagerOperation2.mFragment.mView, specialEffectsController$FragmentStateManagerOperation2.mFinalState);
                                }
                                break;
                            default:
                                DefaultSpecialEffectsController defaultSpecialEffectsController = this.this$0;
                                ArrayList arrayList2 = defaultSpecialEffectsController.mPendingOperations;
                                SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation3 = specialEffectsController$FragmentStateManagerOperation;
                                arrayList2.remove(specialEffectsController$FragmentStateManagerOperation3);
                                defaultSpecialEffectsController.mRunningOperations.remove(specialEffectsController$FragmentStateManagerOperation3);
                                break;
                        }
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void executePendingOperations() {
        if (this.mIsContainerPostponed) {
            return;
        }
        ViewGroup viewGroup = this.mContainer;
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        if (!viewGroup.isAttachedToWindow()) {
            forceCompleteAllOperations();
            this.mOperationDirectionIsPop = false;
            return;
        }
        synchronized (this.mPendingOperations) {
            try {
                if (!this.mPendingOperations.isEmpty()) {
                    ArrayList<SpecialEffectsController$FragmentStateManagerOperation> arrayList = new ArrayList(this.mRunningOperations);
                    this.mRunningOperations.clear();
                    for (SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation : arrayList) {
                        if (Log.isLoggable("FragmentManager", 2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + specialEffectsController$FragmentStateManagerOperation);
                        }
                        specialEffectsController$FragmentStateManagerOperation.cancel();
                        if (!specialEffectsController$FragmentStateManagerOperation.mIsComplete) {
                            this.mRunningOperations.add(specialEffectsController$FragmentStateManagerOperation);
                        }
                    }
                    updateFinalState();
                    ArrayList arrayList2 = new ArrayList(this.mPendingOperations);
                    this.mPendingOperations.clear();
                    this.mRunningOperations.addAll(arrayList2);
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                    }
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        ((SpecialEffectsController$FragmentStateManagerOperation) it.next()).onStart();
                    }
                    executeOperations(arrayList2, this.mOperationDirectionIsPop);
                    this.mOperationDirectionIsPop = false;
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final SpecialEffectsController$FragmentStateManagerOperation findPendingOperation(Fragment fragment) {
        for (SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation : this.mPendingOperations) {
            if (specialEffectsController$FragmentStateManagerOperation.mFragment.equals(fragment) && !specialEffectsController$FragmentStateManagerOperation.mIsCanceled) {
                return specialEffectsController$FragmentStateManagerOperation;
            }
        }
        return null;
    }

    public final void forceCompleteAllOperations() {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        ViewGroup viewGroup = this.mContainer;
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        boolean zIsAttachedToWindow = viewGroup.isAttachedToWindow();
        synchronized (this.mPendingOperations) {
            try {
                updateFinalState();
                Iterator it = this.mPendingOperations.iterator();
                while (it.hasNext()) {
                    ((SpecialEffectsController$FragmentStateManagerOperation) it.next()).onStart();
                }
                for (SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation : new ArrayList(this.mRunningOperations)) {
                    if (Log.isLoggable("FragmentManager", 2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("SpecialEffectsController: ");
                        sb.append(zIsAttachedToWindow ? "" : "Container " + this.mContainer + " is not attached to window. ");
                        sb.append("Cancelling running operation ");
                        sb.append(specialEffectsController$FragmentStateManagerOperation);
                        Log.v("FragmentManager", sb.toString());
                    }
                    specialEffectsController$FragmentStateManagerOperation.cancel();
                }
                for (SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation2 : new ArrayList(this.mPendingOperations)) {
                    if (Log.isLoggable("FragmentManager", 2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: ");
                        sb2.append(zIsAttachedToWindow ? "" : "Container " + this.mContainer + " is not attached to window. ");
                        sb2.append("Cancelling pending operation ");
                        sb2.append(specialEffectsController$FragmentStateManagerOperation2);
                        Log.v("FragmentManager", sb2.toString());
                    }
                    specialEffectsController$FragmentStateManagerOperation2.cancel();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void markPostponedState() {
        synchronized (this.mPendingOperations) {
            try {
                updateFinalState();
                boolean z = false;
                this.mIsContainerPostponed = false;
                for (int size = this.mPendingOperations.size() - 1; size >= 0; size--) {
                    SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = (SpecialEffectsController$FragmentStateManagerOperation) this.mPendingOperations.get(size);
                    int i_from = Fragment$$ExternalSyntheticOutline0._from(specialEffectsController$FragmentStateManagerOperation.mFragment.mView);
                    if (specialEffectsController$FragmentStateManagerOperation.mFinalState == 2 && i_from != 2) {
                        Fragment.AnimationInfo animationInfo = specialEffectsController$FragmentStateManagerOperation.mFragment.mAnimationInfo;
                        if (animationInfo != null) {
                            z = animationInfo.mEnterTransitionPostponed;
                        }
                        this.mIsContainerPostponed = z;
                        break;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void updateFinalState() {
        for (SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation : this.mPendingOperations) {
            if (specialEffectsController$FragmentStateManagerOperation.mLifecycleImpact == 2) {
                specialEffectsController$FragmentStateManagerOperation.mergeWith(Fragment$$ExternalSyntheticOutline0._from(specialEffectsController$FragmentStateManagerOperation.mFragment.requireView().getVisibility()), 1);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:212:0x059b  */
    /* JADX WARN: Code duplicated, block: B:214:0x05a0  */
    /* JADX WARN: Code duplicated, block: B:216:0x05ac A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:217:0x05ae  */
    /* JADX WARN: Code duplicated, block: B:220:0x05ca  */
    /* JADX WARN: Code duplicated, block: B:222:0x05d1  */
    /* JADX WARN: Code duplicated, block: B:224:0x05db  */
    /* JADX WARN: Code duplicated, block: B:226:0x05e2  */
    public final void executeOperations(ArrayList arrayList, boolean z) {
        SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation;
        ArrayList<SpecialEffectsController$FragmentStateManagerOperation> arrayList2;
        TransitionSet ordering;
        TransitionSet transitionSet;
        String str;
        SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation2;
        SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation3;
        SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation4;
        String str2;
        SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation5;
        TransitionSet transitionSet2;
        View view;
        ArrayList arrayList3;
        View view2;
        TransitionSet transitionSet3;
        TransitionSet transitionSet4;
        View view3;
        ArrayMap arrayMap;
        ArrayList arrayList4;
        ArrayList arrayList5;
        Rect rect;
        FragmentTransitionCompat21 fragmentTransitionCompat21;
        TransitionSet transitionSet5;
        View view4;
        ArrayList arrayList6;
        ArrayList arrayList7;
        ArrayList arrayList8;
        ArrayList arrayList9;
        int i;
        View view5;
        int i2;
        int i3;
        int i4;
        int i5;
        View view6;
        boolean z2 = z;
        Iterator it = arrayList.iterator();
        SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation6 = null;
        SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation7 = null;
        while (it.hasNext()) {
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation8 = (SpecialEffectsController$FragmentStateManagerOperation) it.next();
            int i_from = Fragment$$ExternalSyntheticOutline0._from(specialEffectsController$FragmentStateManagerOperation8.mFragment.mView);
            int iOrdinal = Fragment$$ExternalSyntheticOutline0.ordinal(specialEffectsController$FragmentStateManagerOperation8.mFinalState);
            if (iOrdinal != 0) {
                if (iOrdinal != 1) {
                    if (iOrdinal == 2 || iOrdinal == 3) {
                    }
                } else if (i_from != 2) {
                    specialEffectsController$FragmentStateManagerOperation7 = specialEffectsController$FragmentStateManagerOperation8;
                }
            }
            if (i_from == 2 && specialEffectsController$FragmentStateManagerOperation6 == null) {
                specialEffectsController$FragmentStateManagerOperation6 = specialEffectsController$FragmentStateManagerOperation8;
            }
        }
        String str3 = "FragmentManager";
        String str4 = " to ";
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Executing operations from " + specialEffectsController$FragmentStateManagerOperation6 + " to " + specialEffectsController$FragmentStateManagerOperation7);
        }
        ArrayList arrayList10 = new ArrayList();
        ArrayList<TransitionInfo> arrayList11 = new ArrayList();
        ArrayList arrayList12 = new ArrayList(arrayList);
        Fragment fragment = ((SpecialEffectsController$FragmentStateManagerOperation) arrayList.get(arrayList.size() - 1)).mFragment;
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Fragment.AnimationInfo animationInfo = ((SpecialEffectsController$FragmentStateManagerOperation) it2.next()).mFragment.mAnimationInfo;
            Fragment.AnimationInfo animationInfo2 = fragment.mAnimationInfo;
            animationInfo.mEnterAnim = animationInfo2.mEnterAnim;
            animationInfo.mExitAnim = animationInfo2.mExitAnim;
            animationInfo.mPopEnterAnim = animationInfo2.mPopEnterAnim;
            animationInfo.mPopExitAnim = animationInfo2.mPopExitAnim;
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation9 = (SpecialEffectsController$FragmentStateManagerOperation) it3.next();
            CancellationSignal cancellationSignal = new CancellationSignal();
            specialEffectsController$FragmentStateManagerOperation9.onStart();
            HashSet hashSet = specialEffectsController$FragmentStateManagerOperation9.mSpecialEffectsSignals;
            hashSet.add(cancellationSignal);
            AnimationInfo animationInfo3 = new AnimationInfo(specialEffectsController$FragmentStateManagerOperation9, cancellationSignal);
            animationInfo3.mLoadedAnim = false;
            animationInfo3.mIsPop = z2;
            arrayList10.add(animationInfo3);
            CancellationSignal cancellationSignal2 = new CancellationSignal();
            specialEffectsController$FragmentStateManagerOperation9.onStart();
            hashSet.add(cancellationSignal2);
            arrayList11.add(new TransitionInfo(specialEffectsController$FragmentStateManagerOperation9, cancellationSignal2, z2, !z2 ? specialEffectsController$FragmentStateManagerOperation9 != specialEffectsController$FragmentStateManagerOperation7 : specialEffectsController$FragmentStateManagerOperation9 != specialEffectsController$FragmentStateManagerOperation6));
            specialEffectsController$FragmentStateManagerOperation9.mCompletionListeners.add(new WorkerWrapper.AnonymousClass1(this, arrayList12, specialEffectsController$FragmentStateManagerOperation9, 2));
        }
        HashMap map = new HashMap();
        Iterator it4 = arrayList11.iterator();
        FragmentTransitionCompat21 fragmentTransitionCompat22 = null;
        while (it4.hasNext()) {
            TransitionInfo transitionInfo = (TransitionInfo) it4.next();
            if (!transitionInfo.isVisibilityUnchanged()) {
                Object obj = transitionInfo.mTransition;
                FragmentTransitionCompat21 handlingImpl = transitionInfo.getHandlingImpl(obj);
                Object obj2 = transitionInfo.mSharedElementTransition;
                Iterator it5 = it4;
                FragmentTransitionCompat21 handlingImpl2 = transitionInfo.getHandlingImpl(obj2);
                SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation10 = (SpecialEffectsController$FragmentStateManagerOperation) transitionInfo.mContext;
                String str5 = str4;
                String str6 = PZmDzEagKNdW.UBdAUZb;
                ArrayList arrayList13 = arrayList10;
                Fragment fragment2 = specialEffectsController$FragmentStateManagerOperation10.mFragment;
                if (handlingImpl != null && handlingImpl2 != null && handlingImpl != handlingImpl2) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + fragment2 + str6 + obj + " which uses a different Transition  type than its shared element transition " + obj2);
                }
                if (handlingImpl == null) {
                    handlingImpl = handlingImpl2;
                }
                if (fragmentTransitionCompat22 == null) {
                    fragmentTransitionCompat22 = handlingImpl;
                } else if (handlingImpl != null && fragmentTransitionCompat22 != handlingImpl) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + fragment2 + str6 + obj + " which uses a different Transition  type than other Fragments.");
                }
                it4 = it5;
                str4 = str5;
                arrayList10 = arrayList13;
            }
        }
        ArrayList<AnimationInfo> arrayList14 = arrayList10;
        String str7 = str4;
        final ViewGroup viewGroup = this.mContainer;
        if (fragmentTransitionCompat22 == null) {
            for (TransitionInfo transitionInfo2 : arrayList11) {
                map.put((SpecialEffectsController$FragmentStateManagerOperation) transitionInfo2.mContext, Boolean.FALSE);
                transitionInfo2.completeSpecialEffect();
            }
            str = "FragmentManager";
            specialEffectsController$FragmentStateManagerOperation2 = specialEffectsController$FragmentStateManagerOperation6;
            specialEffectsController$FragmentStateManagerOperation = specialEffectsController$FragmentStateManagerOperation7;
            arrayList2 = arrayList12;
        } else {
            View view7 = new View(viewGroup.getContext());
            Rect rect2 = new Rect();
            final ArrayList arrayList15 = new ArrayList();
            final ArrayList arrayList16 = new ArrayList();
            ArrayMap arrayMap2 = new ArrayMap();
            Iterator it6 = arrayList11.iterator();
            View view8 = null;
            TransitionSet transitionSet6 = null;
            boolean z3 = false;
            while (it6.hasNext()) {
                Iterator it7 = it6;
                Object obj3 = ((TransitionInfo) it6.next()).mSharedElementTransition;
                if (obj3 == null || specialEffectsController$FragmentStateManagerOperation6 == null || specialEffectsController$FragmentStateManagerOperation7 == null) {
                    view3 = view7;
                    arrayMap = arrayMap2;
                    arrayList4 = arrayList11;
                    arrayList5 = arrayList12;
                    rect = rect2;
                    fragmentTransitionCompat21 = fragmentTransitionCompat22;
                    transitionSet5 = transitionSet6;
                } else {
                    Transition transitionClone = ((Transition) obj3).clone();
                    if (transitionClone == null) {
                        transitionSet5 = null;
                    } else {
                        transitionSet5 = new TransitionSet();
                        transitionSet5.addTransition(transitionClone);
                    }
                    Fragment fragment3 = specialEffectsController$FragmentStateManagerOperation7.mFragment;
                    arrayList5 = arrayList12;
                    Fragment.AnimationInfo animationInfo4 = fragment3.mAnimationInfo;
                    if (animationInfo4 == null || (arrayList6 = animationInfo4.mSharedElementSourceNames) == null) {
                        arrayList6 = new ArrayList();
                    }
                    arrayList4 = arrayList11;
                    Fragment fragment4 = specialEffectsController$FragmentStateManagerOperation6.mFragment;
                    HashMap map2 = map;
                    Fragment.AnimationInfo animationInfo5 = fragment4.mAnimationInfo;
                    if (animationInfo5 == null || (arrayList7 = animationInfo5.mSharedElementSourceNames) == null) {
                        arrayList7 = new ArrayList();
                    }
                    View view9 = view7;
                    Fragment.AnimationInfo animationInfo6 = fragment4.mAnimationInfo;
                    if (animationInfo6 == null || (arrayList8 = animationInfo6.mSharedElementTargetNames) == null) {
                        arrayList8 = new ArrayList();
                    }
                    Rect rect3 = rect2;
                    FragmentTransitionCompat21 fragmentTransitionCompat23 = fragmentTransitionCompat22;
                    int i6 = 0;
                    while (i6 < arrayList8.size()) {
                        int iIndexOf = arrayList6.indexOf(arrayList8.get(i6));
                        ArrayList arrayList17 = arrayList8;
                        if (iIndexOf != -1) {
                            arrayList6.set(iIndexOf, (String) arrayList7.get(i6));
                        }
                        i6++;
                        arrayList8 = arrayList17;
                    }
                    Fragment.AnimationInfo animationInfo7 = fragment3.mAnimationInfo;
                    if (animationInfo7 == null || (arrayList9 = animationInfo7.mSharedElementTargetNames) == null) {
                        arrayList9 = new ArrayList();
                    }
                    int i7 = 0;
                    for (int size = arrayList6.size(); i7 < size; size = size) {
                        arrayMap2.put((String) arrayList6.get(i7), (String) arrayList9.get(i7));
                        i7++;
                    }
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Log.v("FragmentManager", ">>> entering view names <<<");
                        for (Iterator it8 = arrayList9.iterator(); it8.hasNext(); it8 = it8) {
                            Log.v("FragmentManager", "Name: " + ((String) it8.next()));
                        }
                        Log.v("FragmentManager", ">>> exiting view names <<<");
                        for (Iterator it9 = arrayList6.iterator(); it9.hasNext(); it9 = it9) {
                            Log.v("FragmentManager", "Name: " + ((String) it9.next()));
                        }
                    }
                    ArrayMap arrayMap3 = new ArrayMap();
                    findNamedViews(arrayMap3, fragment4.mView);
                    ArrayMap.AnonymousClass1.retainAllHelper(arrayMap3, arrayList6);
                    ArrayMap.AnonymousClass1.retainAllHelper(arrayMap2, arrayMap3.keySet());
                    ArrayMap arrayMap4 = new ArrayMap();
                    findNamedViews(arrayMap4, fragment3.mView);
                    ArrayMap.AnonymousClass1.retainAllHelper(arrayMap4, arrayList9);
                    ArrayMap.AnonymousClass1.retainAllHelper(arrayMap4, arrayMap2.values());
                    FragmentTransitionCompat21 fragmentTransitionCompat24 = FragmentTransition.PLATFORM_IMPL;
                    for (int i8 = arrayMap2.mSize - 1; i8 >= 0; i8--) {
                        if (!arrayMap4.containsKey((String) arrayMap2.valueAt(i8))) {
                            arrayMap2.removeAt(i8);
                        }
                    }
                    retainMatchingViews(arrayMap3, arrayMap2.keySet());
                    retainMatchingViews(arrayMap4, arrayMap2.values());
                    if (arrayMap2.isEmpty()) {
                        arrayList15.clear();
                        arrayList16.clear();
                        view4 = view8;
                        map = map2;
                        view3 = view9;
                        rect = rect3;
                        fragmentTransitionCompat21 = fragmentTransitionCompat23;
                        transitionSet5 = null;
                        arrayMap = arrayMap2;
                    } else {
                        OneShotPreDrawListener.add(viewGroup, new AnonymousClass6(specialEffectsController$FragmentStateManagerOperation7, specialEffectsController$FragmentStateManagerOperation6, z2, arrayMap4));
                        arrayList15.addAll(arrayMap3.values());
                        if (arrayList6.isEmpty()) {
                            i = 0;
                            view5 = view8;
                        } else {
                            view5 = (View) arrayMap3.getOrDefault((String) arrayList6.get(0), null);
                            if (view5 != null) {
                                Rect rect4 = new Rect();
                                FragmentTransitionCompat21.getBoundsOnScreen(view5, rect4);
                                i = 0;
                                transitionSet5.setEpicenterCallback(new Transition.EpicenterCallback() { // from class: androidx.fragment.app.FragmentTransitionCompat21.1
                                    public final /* synthetic */ int $r8$classId;
                                    public final /* synthetic */ Rect val$epicenter;

                                    public /* synthetic */ AnonymousClass1() {
                                        i = i;
                                        rect = rect4;
                                    }

                                    @Override // android.transition.Transition.EpicenterCallback
                                    public final Rect onGetEpicenter(Transition transition) {
                                        switch (i) {
                                            case 0:
                                                return rect;
                                            default:
                                                Rect rect5 = rect;
                                                if (rect5 == null || rect5.isEmpty()) {
                                                    return null;
                                                }
                                                return rect5;
                                        }
                                    }
                                });
                            } else {
                                i = 0;
                            }
                        }
                        arrayList16.addAll(arrayMap4.values());
                        if (arrayList9.isEmpty() || (view6 = (View) arrayMap4.getOrDefault((String) arrayList9.get(i), null)) == null) {
                            rect = rect3;
                            fragmentTransitionCompat21 = fragmentTransitionCompat23;
                        } else {
                            rect = rect3;
                            fragmentTransitionCompat21 = fragmentTransitionCompat23;
                            OneShotPreDrawListener.add(viewGroup, new zza(fragmentTransitionCompat21, view6, rect, 6));
                            z3 = true;
                        }
                        List<View> targets = transitionSet5.getTargets();
                        targets.clear();
                        int size2 = arrayList15.size();
                        int i9 = 0;
                        while (i9 < size2) {
                            View view10 = (View) arrayList15.get(i9);
                            View view11 = view5;
                            int size3 = targets.size();
                            int i10 = 0;
                            while (true) {
                                if (i10 >= size3) {
                                    i2 = size2;
                                    WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                                    if (ViewCompat.Api21Impl.getTransitionName(view10) != null) {
                                        targets.add(view10);
                                    }
                                    int i11 = size3;
                                    while (i11 < targets.size()) {
                                        View view12 = targets.get(i11);
                                        if (view12 instanceof ViewGroup) {
                                            ViewGroup viewGroup2 = (ViewGroup) view12;
                                            int childCount = viewGroup2.getChildCount();
                                            int i12 = 0;
                                            while (i12 < childCount) {
                                                int i13 = childCount;
                                                View childAt = viewGroup2.getChildAt(i12);
                                                ViewGroup viewGroup3 = viewGroup2;
                                                int i14 = 0;
                                                while (true) {
                                                    if (i14 >= size3) {
                                                        i4 = size3;
                                                        i5 = 1;
                                                        if (ViewCompat.Api21Impl.getTransitionName(childAt) == null) {
                                                            break;
                                                        }
                                                        targets.add(childAt);
                                                        break;
                                                    }
                                                    i4 = size3;
                                                    if (targets.get(i14) == childAt) {
                                                        i5 = 1;
                                                        break;
                                                    } else {
                                                        i14++;
                                                        size3 = i4;
                                                    }
                                                }
                                                i12 += i5;
                                                childCount = i13;
                                                viewGroup2 = viewGroup3;
                                                size3 = i4;
                                            }
                                            i3 = size3;
                                        } else {
                                            i3 = size3;
                                        }
                                        i11++;
                                        size3 = i3;
                                        arrayMap2 = arrayMap2;
                                    }
                                    break;
                                }
                                i2 = size2;
                                if (targets.get(i10) == view10) {
                                    break;
                                }
                                i10++;
                                size2 = i2;
                            }
                            i9++;
                            view5 = view11;
                            size2 = i2;
                            arrayMap2 = arrayMap2;
                        }
                        view8 = view5;
                        arrayMap = arrayMap2;
                        view3 = view9;
                        targets.add(view3);
                        arrayList15.add(view3);
                        FragmentTransitionCompat21.addTargets(transitionSet5, arrayList15);
                        transitionSet5.addListener((Transition.TransitionListener) new Transition.TransitionListener() { // from class: androidx.fragment.app.FragmentTransitionCompat21.3
                            public final /* synthetic */ Transition val$enterTransition;
                            public final /* synthetic */ ArrayList val$enteringViews;
                            public final /* synthetic */ TransitionSet val$sharedElementTransition;
                            public final /* synthetic */ ArrayList val$sharedElementsIn;

                            public AnonymousClass3() {
                                transition = transition;
                                arrayList = arrayList;
                                transitionSet = transitionSet5;
                                arrayList = arrayList16;
                            }

                            @Override // android.transition.Transition.TransitionListener
                            public final void onTransitionCancel(Transition transition) {
                            }

                            @Override // android.transition.Transition.TransitionListener
                            public final void onTransitionEnd(Transition transition) {
                                transition.removeListener(this);
                            }

                            @Override // android.transition.Transition.TransitionListener
                            public final void onTransitionPause(Transition transition) {
                            }

                            @Override // android.transition.Transition.TransitionListener
                            public final void onTransitionResume(Transition transition) {
                            }

                            @Override // android.transition.Transition.TransitionListener
                            public final void onTransitionStart(Transition transition) {
                                FragmentTransitionCompat21 fragmentTransitionCompat25 = FragmentTransitionCompat21.this;
                                Transition transition2 = transition;
                                if (transition2 != null) {
                                    ArrayList arrayList18 = arrayList;
                                    fragmentTransitionCompat25.getClass();
                                    FragmentTransitionCompat21.replaceTargets(transition2, arrayList18, null);
                                }
                                TransitionSet transitionSet7 = transitionSet;
                                if (transitionSet7 != null) {
                                    ArrayList arrayList19 = arrayList;
                                    fragmentTransitionCompat25.getClass();
                                    FragmentTransitionCompat21.replaceTargets(transitionSet7, arrayList19, null);
                                }
                            }
                        });
                        Boolean bool = Boolean.TRUE;
                        map = map2;
                        map.put(specialEffectsController$FragmentStateManagerOperation6, bool);
                        map.put(specialEffectsController$FragmentStateManagerOperation7, bool);
                    }
                    view8 = view4;
                    view7 = view3;
                    transitionSet6 = transitionSet5;
                    fragmentTransitionCompat22 = fragmentTransitionCompat21;
                    rect2 = rect;
                    it6 = it7;
                    arrayList12 = arrayList5;
                    arrayList11 = arrayList4;
                    arrayMap2 = arrayMap;
                    z2 = z;
                }
                view4 = view8;
                view8 = view4;
                view7 = view3;
                transitionSet6 = transitionSet5;
                fragmentTransitionCompat22 = fragmentTransitionCompat21;
                rect2 = rect;
                it6 = it7;
                arrayList12 = arrayList5;
                arrayList11 = arrayList4;
                arrayMap2 = arrayMap;
                z2 = z;
            }
            View view13 = view7;
            SimpleArrayMap simpleArrayMap = arrayMap2;
            ArrayList<TransitionInfo> arrayList18 = arrayList11;
            ArrayList arrayList19 = arrayList12;
            Rect rect5 = rect2;
            FragmentTransitionCompat21 fragmentTransitionCompat25 = fragmentTransitionCompat22;
            ArrayList arrayList20 = new ArrayList();
            Iterator it10 = arrayList18.iterator();
            TransitionSet transitionSet7 = null;
            TransitionSet transitionSet8 = null;
            while (it10.hasNext()) {
                TransitionInfo transitionInfo3 = (TransitionInfo) it10.next();
                boolean zIsVisibilityUnchanged = transitionInfo3.isVisibilityUnchanged();
                it10 = it10;
                SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation11 = (SpecialEffectsController$FragmentStateManagerOperation) transitionInfo3.mContext;
                if (zIsVisibilityUnchanged) {
                    map.put(specialEffectsController$FragmentStateManagerOperation11, Boolean.FALSE);
                    transitionInfo3.completeSpecialEffect();
                    str3 = str3;
                } else {
                    String str8 = str3;
                    Object obj4 = transitionInfo3.mTransition;
                    Transition transitionClone2 = obj4 != null ? ((Transition) obj4).clone() : null;
                    boolean z4 = transitionSet6 != null && (specialEffectsController$FragmentStateManagerOperation11 == specialEffectsController$FragmentStateManagerOperation6 || specialEffectsController$FragmentStateManagerOperation11 == specialEffectsController$FragmentStateManagerOperation7);
                    if (transitionClone2 == null) {
                        if (!z4) {
                            map.put(specialEffectsController$FragmentStateManagerOperation11, Boolean.FALSE);
                            transitionInfo3.completeSpecialEffect();
                        }
                        transitionSet2 = transitionSet6;
                        view = view13;
                        specialEffectsController$FragmentStateManagerOperation5 = specialEffectsController$FragmentStateManagerOperation7;
                        fragmentTransitionCompat25 = fragmentTransitionCompat25;
                        arrayList3 = arrayList19;
                        view2 = view8;
                    } else {
                        specialEffectsController$FragmentStateManagerOperation5 = specialEffectsController$FragmentStateManagerOperation7;
                        ArrayList arrayList21 = new ArrayList();
                        transitionSet2 = transitionSet6;
                        Fragment fragment5 = specialEffectsController$FragmentStateManagerOperation11.mFragment;
                        TransitionSet transitionSet9 = transitionSet8;
                        captureTransitioningViews(fragment5.mView, arrayList21);
                        if (z4) {
                            if (specialEffectsController$FragmentStateManagerOperation11 == specialEffectsController$FragmentStateManagerOperation6) {
                                arrayList21.removeAll(arrayList15);
                            } else {
                                arrayList21.removeAll(arrayList16);
                            }
                        }
                        if (arrayList21.isEmpty()) {
                            transitionClone2.addTarget(view13);
                            view = view13;
                        } else {
                            FragmentTransitionCompat21.addTargets(transitionClone2, arrayList21);
                            transitionClone2.addListener(new Transition.TransitionListener() { // from class: androidx.fragment.app.FragmentTransitionCompat21.3
                                public final /* synthetic */ Transition val$enterTransition;
                                public final /* synthetic */ ArrayList val$enteringViews;
                                public final /* synthetic */ TransitionSet val$sharedElementTransition;
                                public final /* synthetic */ ArrayList val$sharedElementsIn;

                                public AnonymousClass3() {
                                    transition = transitionClone2;
                                    arrayList = arrayList21;
                                    transitionSet = transitionSet5;
                                    arrayList = arrayList16;
                                }

                                @Override // android.transition.Transition.TransitionListener
                                public final void onTransitionCancel(Transition transition) {
                                }

                                @Override // android.transition.Transition.TransitionListener
                                public final void onTransitionEnd(Transition transition) {
                                    transition.removeListener(this);
                                }

                                @Override // android.transition.Transition.TransitionListener
                                public final void onTransitionPause(Transition transition) {
                                }

                                @Override // android.transition.Transition.TransitionListener
                                public final void onTransitionResume(Transition transition) {
                                }

                                @Override // android.transition.Transition.TransitionListener
                                public final void onTransitionStart(Transition transition) {
                                    FragmentTransitionCompat21 fragmentTransitionCompat26 = FragmentTransitionCompat21.this;
                                    Transition transition2 = transition;
                                    if (transition2 != null) {
                                        ArrayList arrayList110 = arrayList;
                                        fragmentTransitionCompat26.getClass();
                                        FragmentTransitionCompat21.replaceTargets(transition2, arrayList110, null);
                                    }
                                    TransitionSet transitionSet10 = transitionSet;
                                    if (transitionSet10 != null) {
                                        ArrayList arrayList111 = arrayList;
                                        fragmentTransitionCompat26.getClass();
                                        FragmentTransitionCompat21.replaceTargets(transitionSet10, arrayList111, null);
                                    }
                                }
                            });
                            view = view13;
                            if (specialEffectsController$FragmentStateManagerOperation11.mFinalState == 3) {
                                arrayList3 = arrayList19;
                                arrayList3.remove(specialEffectsController$FragmentStateManagerOperation11);
                                ArrayList arrayList22 = new ArrayList(arrayList21);
                                arrayList22.remove(fragment5.mView);
                                transitionClone2.addListener(new Transition.TransitionListener() { // from class: androidx.fragment.app.FragmentTransitionCompat21.2
                                    public final /* synthetic */ ArrayList val$exitingViews;
                                    public final /* synthetic */ View val$fragmentView;

                                    public AnonymousClass2() {
                                        view = view;
                                        arrayList = arrayList22;
                                    }

                                    @Override // android.transition.Transition.TransitionListener
                                    public final void onTransitionCancel(Transition transition) {
                                    }

                                    @Override // android.transition.Transition.TransitionListener
                                    public final void onTransitionEnd(Transition transition) {
                                        transition.removeListener(this);
                                        view.setVisibility(8);
                                        ArrayList arrayList23 = arrayList;
                                        int size4 = arrayList23.size();
                                        for (int i15 = 0; i15 < size4; i15++) {
                                            ((View) arrayList23.get(i15)).setVisibility(0);
                                        }
                                    }

                                    @Override // android.transition.Transition.TransitionListener
                                    public final void onTransitionPause(Transition transition) {
                                    }

                                    @Override // android.transition.Transition.TransitionListener
                                    public final void onTransitionResume(Transition transition) {
                                    }

                                    @Override // android.transition.Transition.TransitionListener
                                    public final void onTransitionStart(Transition transition) {
                                        transition.removeListener(this);
                                        transition.addListener(this);
                                    }
                                });
                                OneShotPreDrawListener.add(viewGroup, new Worker.AnonymousClass1(arrayList21, 9));
                            }
                            if (specialEffectsController$FragmentStateManagerOperation11.mFinalState == 2) {
                                arrayList20.addAll(arrayList21);
                                if (z3) {
                                    transitionClone2.setEpicenterCallback(new Transition.EpicenterCallback() { // from class: androidx.fragment.app.FragmentTransitionCompat21.1
                                        public final /* synthetic */ int $r8$classId;
                                        public final /* synthetic */ Rect val$epicenter;

                                        public /* synthetic */ AnonymousClass1() {
                                            i = i;
                                            rect = rect5;
                                        }

                                        @Override // android.transition.Transition.EpicenterCallback
                                        public final Rect onGetEpicenter(Transition transition) {
                                            switch (i) {
                                                case 0:
                                                    return rect;
                                                default:
                                                    Rect rect6 = rect;
                                                    if (rect6 == null || rect6.isEmpty()) {
                                                        return null;
                                                    }
                                                    return rect6;
                                            }
                                        }
                                    });
                                }
                            } else {
                                if (view8 != null) {
                                    Rect rect6 = new Rect();
                                    view2 = view8;
                                    FragmentTransitionCompat21.getBoundsOnScreen(view2, rect6);
                                    transitionClone2.setEpicenterCallback(new Transition.EpicenterCallback() { // from class: androidx.fragment.app.FragmentTransitionCompat21.1
                                        public final /* synthetic */ int $r8$classId;
                                        public final /* synthetic */ Rect val$epicenter;

                                        public /* synthetic */ AnonymousClass1() {
                                            i = i;
                                            rect = rect6;
                                        }

                                        @Override // android.transition.Transition.EpicenterCallback
                                        public final Rect onGetEpicenter(Transition transition) {
                                            switch (i) {
                                                case 0:
                                                    return rect;
                                                default:
                                                    Rect rect7 = rect;
                                                    if (rect7 == null || rect7.isEmpty()) {
                                                        return null;
                                                    }
                                                    return rect7;
                                            }
                                        }
                                    });
                                }
                                map.put(specialEffectsController$FragmentStateManagerOperation11, Boolean.TRUE);
                                if (transitionInfo3.mOverlapAllowed) {
                                    transitionSet4 = new TransitionSet();
                                    if (transitionSet7 != null) {
                                        transitionSet4.addTransition(transitionSet7);
                                    }
                                    transitionSet4.addTransition(transitionClone2);
                                    transitionSet7 = transitionSet4;
                                    transitionSet8 = transitionSet9;
                                } else {
                                    transitionSet3 = new TransitionSet();
                                    if (transitionSet9 != null) {
                                        transitionSet3.addTransition(transitionSet9);
                                    }
                                    transitionSet3.addTransition(transitionClone2);
                                    transitionSet8 = transitionSet3;
                                }
                            }
                            view2 = view8;
                            map.put(specialEffectsController$FragmentStateManagerOperation11, Boolean.TRUE);
                            if (transitionInfo3.mOverlapAllowed) {
                                transitionSet4 = new TransitionSet();
                                if (transitionSet7 != null) {
                                    transitionSet4.addTransition(transitionSet7);
                                }
                                transitionSet4.addTransition(transitionClone2);
                                transitionSet7 = transitionSet4;
                                transitionSet8 = transitionSet9;
                            } else {
                                transitionSet3 = new TransitionSet();
                                if (transitionSet9 != null) {
                                    transitionSet3.addTransition(transitionSet9);
                                }
                                transitionSet3.addTransition(transitionClone2);
                                transitionSet8 = transitionSet3;
                            }
                        }
                        arrayList3 = arrayList19;
                        if (specialEffectsController$FragmentStateManagerOperation11.mFinalState == 2) {
                            arrayList20.addAll(arrayList21);
                            if (z3) {
                                transitionClone2.setEpicenterCallback(new Transition.EpicenterCallback() { // from class: androidx.fragment.app.FragmentTransitionCompat21.1
                                    public final /* synthetic */ int $r8$classId;
                                    public final /* synthetic */ Rect val$epicenter;

                                    public /* synthetic */ AnonymousClass1() {
                                        i = i;
                                        rect = rect5;
                                    }

                                    @Override // android.transition.Transition.EpicenterCallback
                                    public final Rect onGetEpicenter(Transition transition) {
                                        switch (i) {
                                            case 0:
                                                return rect;
                                            default:
                                                Rect rect7 = rect;
                                                if (rect7 == null || rect7.isEmpty()) {
                                                    return null;
                                                }
                                                return rect7;
                                        }
                                    }
                                });
                            }
                        } else {
                            if (view8 != null) {
                                Rect rect7 = new Rect();
                                view2 = view8;
                                FragmentTransitionCompat21.getBoundsOnScreen(view2, rect7);
                                transitionClone2.setEpicenterCallback(new Transition.EpicenterCallback() { // from class: androidx.fragment.app.FragmentTransitionCompat21.1
                                    public final /* synthetic */ int $r8$classId;
                                    public final /* synthetic */ Rect val$epicenter;

                                    public /* synthetic */ AnonymousClass1() {
                                        i = i;
                                        rect = rect7;
                                    }

                                    @Override // android.transition.Transition.EpicenterCallback
                                    public final Rect onGetEpicenter(Transition transition) {
                                        switch (i) {
                                            case 0:
                                                return rect;
                                            default:
                                                Rect rect8 = rect;
                                                if (rect8 == null || rect8.isEmpty()) {
                                                    return null;
                                                }
                                                return rect8;
                                        }
                                    }
                                });
                            }
                            map.put(specialEffectsController$FragmentStateManagerOperation11, Boolean.TRUE);
                            if (transitionInfo3.mOverlapAllowed) {
                                transitionSet4 = new TransitionSet();
                                if (transitionSet7 != null) {
                                    transitionSet4.addTransition(transitionSet7);
                                }
                                transitionSet4.addTransition(transitionClone2);
                                transitionSet7 = transitionSet4;
                                transitionSet8 = transitionSet9;
                            } else {
                                transitionSet3 = new TransitionSet();
                                if (transitionSet9 != null) {
                                    transitionSet3.addTransition(transitionSet9);
                                }
                                transitionSet3.addTransition(transitionClone2);
                                transitionSet8 = transitionSet3;
                            }
                        }
                        view2 = view8;
                        map.put(specialEffectsController$FragmentStateManagerOperation11, Boolean.TRUE);
                        if (transitionInfo3.mOverlapAllowed) {
                            transitionSet4 = new TransitionSet();
                            if (transitionSet7 != null) {
                                transitionSet4.addTransition(transitionSet7);
                            }
                            transitionSet4.addTransition(transitionClone2);
                            transitionSet7 = transitionSet4;
                            transitionSet8 = transitionSet9;
                        } else {
                            transitionSet3 = new TransitionSet();
                            if (transitionSet9 != null) {
                                transitionSet3.addTransition(transitionSet9);
                            }
                            transitionSet3.addTransition(transitionClone2);
                            transitionSet8 = transitionSet3;
                        }
                    }
                    arrayList19 = arrayList3;
                    view8 = view2;
                    str3 = str8;
                    view13 = view;
                    fragmentTransitionCompat25 = fragmentTransitionCompat25;
                    specialEffectsController$FragmentStateManagerOperation7 = specialEffectsController$FragmentStateManagerOperation5;
                    transitionSet6 = transitionSet2;
                }
            }
            TransitionSet transitionSet10 = transitionSet6;
            String str9 = str3;
            specialEffectsController$FragmentStateManagerOperation = specialEffectsController$FragmentStateManagerOperation7;
            arrayList2 = arrayList19;
            if (transitionSet7 != null && transitionSet8 != null) {
                ordering = new TransitionSet().addTransition(transitionSet7).addTransition(transitionSet8).setOrdering(1);
            } else if (transitionSet7 != null) {
                ordering = transitionSet7;
            } else {
                ordering = transitionSet8 != null ? transitionSet8 : null;
            }
            if (transitionSet10 != null) {
                TransitionSet transitionSet11 = new TransitionSet();
                if (ordering != null) {
                    transitionSet11.addTransition(ordering);
                }
                transitionSet = transitionSet10;
                transitionSet11.addTransition(transitionSet);
                ordering = transitionSet11;
            } else {
                transitionSet = transitionSet10;
            }
            if (ordering == null) {
                specialEffectsController$FragmentStateManagerOperation2 = specialEffectsController$FragmentStateManagerOperation6;
                str = str9;
            } else {
                for (TransitionInfo transitionInfo4 : arrayList18) {
                    if (!transitionInfo4.isVisibilityUnchanged()) {
                        SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation12 = (SpecialEffectsController$FragmentStateManagerOperation) transitionInfo4.mContext;
                        SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation13 = specialEffectsController$FragmentStateManagerOperation;
                        boolean z5 = transitionSet != null && (specialEffectsController$FragmentStateManagerOperation12 == specialEffectsController$FragmentStateManagerOperation6 || specialEffectsController$FragmentStateManagerOperation12 == specialEffectsController$FragmentStateManagerOperation13);
                        if (transitionInfo4.mTransition != null || z5) {
                            WeakHashMap weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                            if (viewGroup.isLaidOut()) {
                                str2 = str9;
                                ordering.addListener((Transition.TransitionListener) new Transition.TransitionListener() { // from class: androidx.fragment.app.FragmentTransitionCompat21.4
                                    public AnonymousClass4() {
                                    }

                                    @Override // android.transition.Transition.TransitionListener
                                    public final void onTransitionCancel(Transition transition) {
                                    }

                                    @Override // android.transition.Transition.TransitionListener
                                    public final void onTransitionEnd(Transition transition) {
                                        zzaVar.run();
                                    }

                                    @Override // android.transition.Transition.TransitionListener
                                    public final void onTransitionPause(Transition transition) {
                                    }

                                    @Override // android.transition.Transition.TransitionListener
                                    public final void onTransitionResume(Transition transition) {
                                    }

                                    @Override // android.transition.Transition.TransitionListener
                                    public final void onTransitionStart(Transition transition) {
                                    }
                                });
                            } else {
                                str2 = str9;
                                if (Log.isLoggable(str2, 2)) {
                                    Log.v(str2, "SpecialEffectsController: Container " + viewGroup + " has not been laid out. Completing operation " + specialEffectsController$FragmentStateManagerOperation12);
                                }
                                transitionInfo4.completeSpecialEffect();
                            }
                        } else {
                            str2 = str9;
                        }
                        specialEffectsController$FragmentStateManagerOperation = specialEffectsController$FragmentStateManagerOperation13;
                        str9 = str2;
                    }
                }
                str = str9;
                SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation14 = specialEffectsController$FragmentStateManagerOperation;
                WeakHashMap weakHashMap3 = ViewCompat.sViewPropertyAnimatorMap;
                if (viewGroup.isLaidOut()) {
                    FragmentTransition.setViewVisibility(arrayList20, 4);
                    final ArrayList arrayList23 = new ArrayList();
                    int size4 = arrayList16.size();
                    for (int i15 = 0; i15 < size4; i15++) {
                        View view14 = (View) arrayList16.get(i15);
                        WeakHashMap weakHashMap4 = ViewCompat.sViewPropertyAnimatorMap;
                        arrayList23.add(ViewCompat.Api21Impl.getTransitionName(view14));
                        ViewCompat.Api21Impl.setTransitionName(view14, null);
                    }
                    if (Log.isLoggable(str, 2)) {
                        Log.v(str, ">>>>> Beginning transition <<<<<");
                        Log.v(str, ">>>>> SharedElementFirstOutViews <<<<<");
                        for (Iterator it11 = arrayList15.iterator(); it11.hasNext(); it11 = it11) {
                            View view15 = (View) it11.next();
                            Log.v(str, "View: " + view15 + " Name: " + ViewCompat.Api21Impl.getTransitionName(view15));
                        }
                        Log.v(str, ">>>>> SharedElementLastInViews <<<<<");
                        for (Iterator it12 = arrayList16.iterator(); it12.hasNext(); it12 = it12) {
                            View view16 = (View) it12.next();
                            Log.v(str, "View: " + view16 + " Name: " + ViewCompat.Api21Impl.getTransitionName(view16));
                        }
                    }
                    TransitionManager.beginDelayedTransition(viewGroup, ordering);
                    final int size5 = arrayList16.size();
                    final ArrayList arrayList24 = new ArrayList();
                    int i16 = 0;
                    while (i16 < size5) {
                        View view17 = (View) arrayList15.get(i16);
                        WeakHashMap weakHashMap5 = ViewCompat.sViewPropertyAnimatorMap;
                        String transitionName = ViewCompat.Api21Impl.getTransitionName(view17);
                        arrayList24.add(transitionName);
                        if (transitionName == null) {
                            specialEffectsController$FragmentStateManagerOperation4 = specialEffectsController$FragmentStateManagerOperation6;
                            specialEffectsController$FragmentStateManagerOperation3 = specialEffectsController$FragmentStateManagerOperation14;
                        } else {
                            specialEffectsController$FragmentStateManagerOperation3 = specialEffectsController$FragmentStateManagerOperation14;
                            ViewCompat.Api21Impl.setTransitionName(view17, null);
                            SimpleArrayMap simpleArrayMap2 = simpleArrayMap;
                            String str10 = (String) simpleArrayMap2.getOrDefault(transitionName, null);
                            simpleArrayMap = simpleArrayMap2;
                            int i17 = 0;
                            while (true) {
                                specialEffectsController$FragmentStateManagerOperation4 = specialEffectsController$FragmentStateManagerOperation6;
                                if (i17 >= size5) {
                                    break;
                                }
                                if (str10.equals(arrayList23.get(i17))) {
                                    ViewCompat.Api21Impl.setTransitionName((View) arrayList16.get(i17), transitionName);
                                    break;
                                } else {
                                    i17++;
                                    specialEffectsController$FragmentStateManagerOperation6 = specialEffectsController$FragmentStateManagerOperation4;
                                }
                            }
                        }
                        i16++;
                        specialEffectsController$FragmentStateManagerOperation6 = specialEffectsController$FragmentStateManagerOperation4;
                        specialEffectsController$FragmentStateManagerOperation14 = specialEffectsController$FragmentStateManagerOperation3;
                    }
                    specialEffectsController$FragmentStateManagerOperation2 = specialEffectsController$FragmentStateManagerOperation6;
                    specialEffectsController$FragmentStateManagerOperation = specialEffectsController$FragmentStateManagerOperation14;
                    OneShotPreDrawListener.add(viewGroup, new Runnable() { // from class: androidx.fragment.app.FragmentTransitionImpl$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            for (int i18 = 0; i18 < size5; i18++) {
                                View view18 = (View) arrayList16.get(i18);
                                String str11 = (String) arrayList23.get(i18);
                                WeakHashMap weakHashMap6 = ViewCompat.sViewPropertyAnimatorMap;
                                ViewCompat.Api21Impl.setTransitionName(view18, str11);
                                ViewCompat.Api21Impl.setTransitionName((View) arrayList15.get(i18), (String) arrayList24.get(i18));
                            }
                        }
                    });
                    FragmentTransition.setViewVisibility(arrayList20, 0);
                    if (transitionSet != null) {
                        transitionSet.getTargets().clear();
                        transitionSet.getTargets().addAll(arrayList16);
                        FragmentTransitionCompat21.replaceTargets(transitionSet, arrayList15, arrayList16);
                    }
                } else {
                    specialEffectsController$FragmentStateManagerOperation2 = specialEffectsController$FragmentStateManagerOperation6;
                    specialEffectsController$FragmentStateManagerOperation = specialEffectsController$FragmentStateManagerOperation14;
                }
            }
        }
        boolean zContainsValue = map.containsValue(Boolean.TRUE);
        Context context = viewGroup.getContext();
        ArrayList<AnimationInfo> arrayList25 = new ArrayList();
        boolean z6 = false;
        for (final AnimationInfo animationInfo8 : arrayList14) {
            if (animationInfo8.isVisibilityUnchanged()) {
                animationInfo8.completeSpecialEffect();
            } else {
                RoomOpenHelper animation = animationInfo8.getAnimation(context);
                if (animation == null) {
                    animationInfo8.completeSpecialEffect();
                } else {
                    Animator animator = (Animator) animation.mDelegate;
                    if (animator == null) {
                        arrayList25.add(animationInfo8);
                    } else {
                        final SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation15 = (SpecialEffectsController$FragmentStateManagerOperation) animationInfo8.mContext;
                        boolean zEquals = Boolean.TRUE.equals(map.get(specialEffectsController$FragmentStateManagerOperation15));
                        Fragment fragment6 = specialEffectsController$FragmentStateManagerOperation15.mFragment;
                        if (zEquals) {
                            if (Log.isLoggable(str, 2)) {
                                Log.v(str, PZmDzEagKNdW.KXmPTQx + fragment6 + " as this Fragment was involved in a Transition.");
                            }
                            animationInfo8.completeSpecialEffect();
                        } else {
                            final boolean z7 = specialEffectsController$FragmentStateManagerOperation15.mFinalState == 3;
                            if (z7) {
                                arrayList2.remove(specialEffectsController$FragmentStateManagerOperation15);
                            }
                            final View view18 = fragment6.mView;
                            viewGroup.startViewTransition(view18);
                            animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.2
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public final void onAnimationEnd(Animator animator2) {
                                    ViewGroup viewGroup4 = viewGroup;
                                    View view19 = view18;
                                    viewGroup4.endViewTransition(view19);
                                    SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation16 = specialEffectsController$FragmentStateManagerOperation15;
                                    if (z7) {
                                        Fragment$$ExternalSyntheticOutline0._applyState(view19, specialEffectsController$FragmentStateManagerOperation16.mFinalState);
                                    }
                                    animationInfo8.completeSpecialEffect();
                                    if (Log.isLoggable("FragmentManager", 2)) {
                                        Log.v("FragmentManager", "Animator from operation " + specialEffectsController$FragmentStateManagerOperation16 + " has ended.");
                                    }
                                }
                            });
                            animator.setTarget(view18);
                            animator.start();
                            if (Log.isLoggable(str, 2)) {
                                Log.v(str, "Animator from operation " + specialEffectsController$FragmentStateManagerOperation15 + " has started.");
                            }
                            ((CancellationSignal) animationInfo8.mMenuItems).setOnCancelListener(new RoomOpenHelper(animator, specialEffectsController$FragmentStateManagerOperation15, 8, false));
                            z6 = true;
                        }
                    }
                }
            }
        }
        for (AnimationInfo animationInfo9 : arrayList25) {
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation16 = (SpecialEffectsController$FragmentStateManagerOperation) animationInfo9.mContext;
            Fragment fragment7 = specialEffectsController$FragmentStateManagerOperation16.mFragment;
            if (zContainsValue) {
                if (Log.isLoggable(str, 2)) {
                    Log.v(str, "Ignoring Animation set on " + fragment7 + " as Animations cannot run alongside Transitions.");
                }
                animationInfo9.completeSpecialEffect();
            } else if (z6) {
                if (Log.isLoggable(str, 2)) {
                    Log.v(str, "Ignoring Animation set on " + fragment7 + " as Animations cannot run alongside Animators.");
                }
                animationInfo9.completeSpecialEffect();
            } else {
                View view19 = fragment7.mView;
                RoomOpenHelper animation2 = animationInfo9.getAnimation(context);
                animation2.getClass();
                Animation animation3 = (Animation) animation2.mConfiguration;
                animation3.getClass();
                if (specialEffectsController$FragmentStateManagerOperation16.mFinalState != 1) {
                    view19.startAnimation(animation3);
                    animationInfo9.completeSpecialEffect();
                } else {
                    viewGroup.startViewTransition(view19);
                    FragmentAnim$EndViewTransitionAnimation fragmentAnim$EndViewTransitionAnimation = new FragmentAnim$EndViewTransitionAnimation(animation3, viewGroup, view19);
                    fragmentAnim$EndViewTransitionAnimation.setAnimationListener(new AnonymousClass4(specialEffectsController$FragmentStateManagerOperation16, viewGroup, view19, animationInfo9));
                    view19.startAnimation(fragmentAnim$EndViewTransitionAnimation);
                    if (Log.isLoggable(str, 2)) {
                        Log.v(str, "Animation from operation " + specialEffectsController$FragmentStateManagerOperation16 + " has started.");
                    }
                }
                ((CancellationSignal) animationInfo9.mMenuItems).setOnCancelListener(new Dispatcher(view19, viewGroup, animationInfo9, specialEffectsController$FragmentStateManagerOperation16));
            }
        }
        for (SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation17 : arrayList2) {
            Fragment$$ExternalSyntheticOutline0._applyState(specialEffectsController$FragmentStateManagerOperation17.mFragment.mView, specialEffectsController$FragmentStateManagerOperation17.mFinalState);
        }
        arrayList2.clear();
        if (Log.isLoggable(str, 2)) {
            Log.v(str, "Completed executing operations from " + specialEffectsController$FragmentStateManagerOperation2 + str7 + specialEffectsController$FragmentStateManagerOperation);
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.DefaultSpecialEffectsController$6, reason: invalid class name */
    /* JADX INFO: loaded from: classes.dex */
    public final class AnonymousClass6 implements Runnable {
        public final /* synthetic */ int $r8$classId = 0;
        public final Object val$firstOut;
        public boolean val$isPop;
        public final Object val$lastIn;

        public AnonymousClass6(LifecycleRegistry registry, Lifecycle.Event event) {
            Intrinsics.checkNotNullParameter(registry, "registry");
            Intrinsics.checkNotNullParameter(event, "event");
            this.val$lastIn = registry;
            this.val$firstOut = event;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Object obj = this.val$firstOut;
            Object obj2 = this.val$lastIn;
            switch (this.$r8$classId) {
                case 0:
                    SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = (SpecialEffectsController$FragmentStateManagerOperation) obj2;
                    SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation2 = (SpecialEffectsController$FragmentStateManagerOperation) obj;
                    FragmentTransitionCompat21 fragmentTransitionCompat21 = FragmentTransition.PLATFORM_IMPL;
                    if (!this.val$isPop) {
                        specialEffectsController$FragmentStateManagerOperation.mFragment.getClass();
                    } else {
                        specialEffectsController$FragmentStateManagerOperation2.mFragment.getClass();
                    }
                    break;
                default:
                    if (!this.val$isPop) {
                        ((LifecycleRegistry) obj2).handleLifecycleEvent((Lifecycle.Event) obj);
                        this.val$isPop = true;
                    }
                    break;
            }
        }

        public AnonymousClass6(SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation, SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation2, boolean z, ArrayMap arrayMap) {
            this.val$lastIn = specialEffectsController$FragmentStateManagerOperation;
            this.val$firstOut = specialEffectsController$FragmentStateManagerOperation2;
            this.val$isPop = z;
        }
    }

    public static DefaultSpecialEffectsController getOrCreateController(ViewGroup viewGroup, InputMergerFactory$1 inputMergerFactory$1) {
        Object tag = viewGroup.getTag(R.id.special_effects_controller_view_tag);
        if (tag instanceof DefaultSpecialEffectsController) {
            return (DefaultSpecialEffectsController) tag;
        }
        inputMergerFactory$1.getClass();
        DefaultSpecialEffectsController defaultSpecialEffectsController = new DefaultSpecialEffectsController(viewGroup);
        viewGroup.setTag(R.id.special_effects_controller_view_tag, defaultSpecialEffectsController);
        return defaultSpecialEffectsController;
    }
}
