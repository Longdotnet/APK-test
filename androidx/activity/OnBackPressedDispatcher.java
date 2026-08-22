package androidx.activity;

import android.os.Build;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.widget.Toolbar$Api33Impl$$ExternalSyntheticLambda0;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KCallable;
import okhttp3.internal.concurrent.onZL.mnwSv;

/* JADX INFO: loaded from: classes.dex */
public final class OnBackPressedDispatcher {
    public boolean backInvokedCallbackRegistered;
    public final Runnable fallbackOnBackPressed;
    public boolean hasEnabledCallbacks;
    public FragmentManager.AnonymousClass1 inProgressCallback;
    public OnBackInvokedDispatcher invokedDispatcher;
    public final OnBackInvokedCallback onBackInvokedCallback;
    public final ArrayDeque onBackPressedCallbacks = new ArrayDeque();

    public final class Api33Impl {
        public static final Api33Impl INSTANCE = new Api33Impl();

        public final OnBackInvokedCallback createOnBackInvokedCallback(Function0 onBackInvoked) {
            Intrinsics.checkNotNullParameter(onBackInvoked, "onBackInvoked");
            return new Toolbar$Api33Impl$$ExternalSyntheticLambda0(onBackInvoked, 1);
        }

        public final void registerOnBackInvokedCallback(Object dispatcher, int i, Object callback) {
            Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
            Intrinsics.checkNotNullParameter(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).registerOnBackInvokedCallback(i, (OnBackInvokedCallback) callback);
        }

        public final void unregisterOnBackInvokedCallback(Object dispatcher, Object callback) {
            Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
            Intrinsics.checkNotNullParameter(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).unregisterOnBackInvokedCallback((OnBackInvokedCallback) callback);
        }
    }

    public final class Api34Impl {
        public static final Api34Impl INSTANCE = new Api34Impl();

        public final OnBackInvokedCallback createOnBackAnimationCallback(final Function1 onBackStarted, final Function1 onBackProgressed, final Function0 onBackInvoked, final Function0 onBackCancelled) {
            Intrinsics.checkNotNullParameter(onBackStarted, "onBackStarted");
            Intrinsics.checkNotNullParameter(onBackProgressed, "onBackProgressed");
            Intrinsics.checkNotNullParameter(onBackInvoked, "onBackInvoked");
            Intrinsics.checkNotNullParameter(onBackCancelled, "onBackCancelled");
            return new OnBackAnimationCallback() { // from class: androidx.activity.OnBackPressedDispatcher$Api34Impl$createOnBackAnimationCallback$1
                public final void onBackCancelled() {
                    onBackCancelled.invoke();
                }

                public final void onBackInvoked() {
                    onBackInvoked.invoke();
                }

                public final void onBackProgressed(BackEvent backEvent) {
                    Intrinsics.checkNotNullParameter(backEvent, "backEvent");
                    onBackProgressed.invoke(new BackEventCompat(backEvent));
                }

                public final void onBackStarted(BackEvent backEvent) {
                    Intrinsics.checkNotNullParameter(backEvent, "backEvent");
                    onBackStarted.invoke(new BackEventCompat(backEvent));
                }
            };
        }
    }

    final class LifecycleOnBackPressedCancellable implements LifecycleEventObserver, Cancellable {
        public OnBackPressedCancellable currentCancellable;
        public final Lifecycle lifecycle;
        public final FragmentManager.AnonymousClass1 onBackPressedCallback;
        public final /* synthetic */ OnBackPressedDispatcher this$0;

        public LifecycleOnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, Lifecycle lifecycle, FragmentManager.AnonymousClass1 onBackPressedCallback) {
            Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
            this.this$0 = onBackPressedDispatcher;
            this.lifecycle = lifecycle;
            this.onBackPressedCallback = onBackPressedCallback;
            lifecycle.addObserver(this);
        }

        @Override // androidx.activity.Cancellable
        public final void cancel() {
            this.lifecycle.removeObserver(this);
            this.onBackPressedCallback.cancellables.remove(this);
            OnBackPressedCancellable onBackPressedCancellable = this.currentCancellable;
            if (onBackPressedCancellable != null) {
                onBackPressedCancellable.cancel();
            }
            this.currentCancellable = null;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            if (event != Lifecycle.Event.ON_START) {
                if (event != Lifecycle.Event.ON_STOP) {
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        cancel();
                        return;
                    }
                    return;
                } else {
                    OnBackPressedCancellable onBackPressedCancellable = this.currentCancellable;
                    if (onBackPressedCancellable != null) {
                        onBackPressedCancellable.cancel();
                        return;
                    }
                    return;
                }
            }
            OnBackPressedDispatcher onBackPressedDispatcher = this.this$0;
            onBackPressedDispatcher.getClass();
            FragmentManager.AnonymousClass1 onBackPressedCallback = this.onBackPressedCallback;
            Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
            onBackPressedDispatcher.onBackPressedCallbacks.addLast(onBackPressedCallback);
            OnBackPressedCancellable onBackPressedCancellable2 = new OnBackPressedCancellable(onBackPressedDispatcher, onBackPressedCallback);
            onBackPressedCallback.cancellables.add(onBackPressedCancellable2);
            onBackPressedDispatcher.updateEnabledCallbacks();
            onBackPressedCallback.enabledChangedCallback = new C00081(onBackPressedDispatcher, 1);
            this.currentCancellable = onBackPressedCancellable2;
        }
    }

    public final class OnBackPressedCancellable implements Cancellable {
        public final FragmentManager.AnonymousClass1 onBackPressedCallback;
        public final /* synthetic */ OnBackPressedDispatcher this$0;

        public OnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, FragmentManager.AnonymousClass1 onBackPressedCallback) {
            Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
            this.this$0 = onBackPressedDispatcher;
            this.onBackPressedCallback = onBackPressedCallback;
        }

        @Override // androidx.activity.Cancellable
        public final void cancel() {
            OnBackPressedDispatcher onBackPressedDispatcher = this.this$0;
            ArrayDeque arrayDeque = onBackPressedDispatcher.onBackPressedCallbacks;
            FragmentManager.AnonymousClass1 anonymousClass1 = this.onBackPressedCallback;
            arrayDeque.remove(anonymousClass1);
            if (Intrinsics.areEqual(onBackPressedDispatcher.inProgressCallback, anonymousClass1)) {
                anonymousClass1.getClass();
                onBackPressedDispatcher.inProgressCallback = null;
            }
            anonymousClass1.cancellables.remove(this);
            C00081 c00081 = anonymousClass1.enabledChangedCallback;
            if (c00081 != null) {
                c00081.invoke();
            }
            anonymousClass1.enabledChangedCallback = null;
        }
    }

    /* JADX INFO: renamed from: androidx.activity.OnBackPressedDispatcher$addCallback$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: loaded from: classes2.dex */
    public final /* synthetic */ class C00081 extends CallableReference implements Function0, FunctionBase, KCallable {
        public final /* synthetic */ int $r8$classId;
        public final int flags;

        public final KCallable computeReflected() {
            Reflection.factory.getClass();
            return this;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof C00081) {
                C00081 c00081 = (C00081) obj;
                return this.name.equals(c00081.name) && this.signature.equals(c00081.signature) && this.flags == c00081.flags && Intrinsics.areEqual(this.receiver, c00081.receiver) && getOwner().equals(c00081.getOwner());
            }
            if (!(obj instanceof C00081)) {
                return false;
            }
            KCallable kCallable = this.reflected;
            if (kCallable == null) {
                computeReflected();
                this.reflected = this;
                kCallable = this;
            }
            return obj.equals(kCallable);
        }

        @Override // kotlin.jvm.internal.FunctionBase
        public final int getArity() {
            return 0;
        }

        public final int hashCode() {
            getOwner();
            return this.signature.hashCode() + CoroutineAdapterKt$$ExternalSyntheticLambda0.m(getOwner().hashCode() * 31, 31, this.name);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            switch (this.$r8$classId) {
                case 0:
                    ((OnBackPressedDispatcher) this.receiver).updateEnabledCallbacks();
                    break;
                default:
                    ((OnBackPressedDispatcher) this.receiver).updateEnabledCallbacks();
                    break;
            }
            return Unit.INSTANCE;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00081(Object obj, int i) {
            super(obj, OnBackPressedDispatcher.class, "updateEnabledCallbacks", mnwSv.mvLrODtTFs, false);
            this.$r8$classId = i;
            this.flags = 0;
        }

        public final String toString() {
            KCallable kCallable = this.reflected;
            if (kCallable == null) {
                computeReflected();
                this.reflected = this;
                kCallable = this;
            }
            if (kCallable != this) {
                return kCallable.toString();
            }
            String str = this.name;
            return "<init>".equals(str) ? "constructor (Kotlin reflection is not available)" : CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1(mnwSv.quVpTXJF, str, " (Kotlin reflection is not available)");
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        OnBackInvokedCallback onBackInvokedCallbackCreateOnBackInvokedCallback;
        this.fallbackOnBackPressed = runnable;
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            if (i >= 34) {
                final int i2 = 0;
                final int i3 = 1;
                final int i4 = 0;
                final int i5 = 1;
                onBackInvokedCallbackCreateOnBackInvokedCallback = Api34Impl.INSTANCE.createOnBackAnimationCallback(new Function1(this) { // from class: androidx.activity.OnBackPressedDispatcher.1
                    public final /* synthetic */ OnBackPressedDispatcher this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.this$0 = this;
                    }

                    /* JADX WARN: Code duplicated, block: B:25:0x0060  */
                    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
                        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v5 java.lang.Object, still in use, count: 2, list:
                          (r1v5 java.lang.Object) from 0x005a: PHI (r1 I:??) = (r1v2 java.lang.Object), (r1v5 java.lang.Object) binds: [B:22:0x0059, B:32:0x005a] A[DONT_GENERATE, DONT_INLINE]
                          (r1v5 java.lang.Object) from 0x0052: CHECK_CAST (androidx.fragment.app.FragmentManager$1) (r1v5 java.lang.Object)
                        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
                        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
                        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
                        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:132)
                        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:67)
                        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:50)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:96)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
                        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:36)
                        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:44)
                        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
                        */
                    @Override // kotlin.jvm.functions.Function1
                    public final java.lang.Object invoke(java.lang.Object r4) {
                        /*
                            r3 = this;
                            int r0 = r2
                            switch(r0) {
                                case 0: goto L34;
                                default: goto L5;
                            }
                        L5:
                            androidx.activity.BackEventCompat r4 = (androidx.activity.BackEventCompat) r4
                            java.lang.String r0 = "backEvent"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                            androidx.activity.OnBackPressedDispatcher r4 = r3.this$0
                            androidx.fragment.app.FragmentManager$1 r0 = r4.inProgressCallback
                            if (r0 != 0) goto L31
                            kotlin.collections.ArrayDeque r4 = r4.onBackPressedCallbacks
                            int r0 = r4.size()
                            java.util.ListIterator r4 = r4.listIterator(r0)
                        L1c:
                            boolean r0 = r4.hasPrevious()
                            if (r0 == 0) goto L2e
                            java.lang.Object r0 = r4.previous()
                            r1 = r0
                            androidx.fragment.app.FragmentManager$1 r1 = (androidx.fragment.app.FragmentManager.AnonymousClass1) r1
                            boolean r1 = r1.isEnabled
                            if (r1 == 0) goto L1c
                            goto L2f
                        L2e:
                            r0 = 0
                        L2f:
                            androidx.fragment.app.FragmentManager$1 r0 = (androidx.fragment.app.FragmentManager.AnonymousClass1) r0
                        L31:
                            kotlin.Unit r4 = kotlin.Unit.INSTANCE
                            return r4
                        L34:
                            androidx.activity.BackEventCompat r4 = (androidx.activity.BackEventCompat) r4
                            java.lang.String r0 = "backEvent"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                            androidx.activity.OnBackPressedDispatcher r4 = r3.this$0
                            kotlin.collections.ArrayDeque r0 = r4.onBackPressedCallbacks
                            int r1 = r0.size()
                            java.util.ListIterator r0 = r0.listIterator(r1)
                        L47:
                            boolean r1 = r0.hasPrevious()
                            if (r1 == 0) goto L59
                            java.lang.Object r1 = r0.previous()
                            r2 = r1
                            androidx.fragment.app.FragmentManager$1 r2 = (androidx.fragment.app.FragmentManager.AnonymousClass1) r2
                            boolean r2 = r2.isEnabled
                            if (r2 == 0) goto L47
                            goto L5a
                        L59:
                            r1 = 0
                        L5a:
                            androidx.fragment.app.FragmentManager$1 r1 = (androidx.fragment.app.FragmentManager.AnonymousClass1) r1
                            androidx.fragment.app.FragmentManager$1 r0 = r4.inProgressCallback
                            if (r0 == 0) goto L63
                            r4.onBackCancelled()
                        L63:
                            r4.inProgressCallback = r1
                            kotlin.Unit r4 = kotlin.Unit.INSTANCE
                            return r4
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.OnBackPressedDispatcher.AnonymousClass1.invoke(java.lang.Object):java.lang.Object");
                    }
                }, new Function1(this) { // from class: androidx.activity.OnBackPressedDispatcher.1
                    public final /* synthetic */ OnBackPressedDispatcher this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.this$0 = this;
                    }

                    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
                        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v5 java.lang.Object, still in use, count: 2, list:
                          (r1v5 java.lang.Object) from 0x005a: PHI (r1 I:??) = (r1v2 java.lang.Object), (r1v5 java.lang.Object) binds: [B:22:0x0059, B:32:0x005a] A[DONT_GENERATE, DONT_INLINE]
                          (r1v5 java.lang.Object) from 0x0052: CHECK_CAST (androidx.fragment.app.FragmentManager$1) (r1v5 java.lang.Object)
                        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
                        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
                        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
                        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:132)
                        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:67)
                        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:50)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:96)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
                        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:36)
                        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:44)
                        */
                    @Override // kotlin.jvm.functions.Function1
                    public final java.lang.Object invoke(java.lang.Object r4) {
                        /*
                            r3 = this;
                            int r0 = r2
                            switch(r0) {
                                case 0: goto L34;
                                default: goto L5;
                            }
                        L5:
                            androidx.activity.BackEventCompat r4 = (androidx.activity.BackEventCompat) r4
                            java.lang.String r0 = "backEvent"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                            androidx.activity.OnBackPressedDispatcher r4 = r3.this$0
                            androidx.fragment.app.FragmentManager$1 r0 = r4.inProgressCallback
                            if (r0 != 0) goto L31
                            kotlin.collections.ArrayDeque r4 = r4.onBackPressedCallbacks
                            int r0 = r4.size()
                            java.util.ListIterator r4 = r4.listIterator(r0)
                        L1c:
                            boolean r0 = r4.hasPrevious()
                            if (r0 == 0) goto L2e
                            java.lang.Object r0 = r4.previous()
                            r1 = r0
                            androidx.fragment.app.FragmentManager$1 r1 = (androidx.fragment.app.FragmentManager.AnonymousClass1) r1
                            boolean r1 = r1.isEnabled
                            if (r1 == 0) goto L1c
                            goto L2f
                        L2e:
                            r0 = 0
                        L2f:
                            androidx.fragment.app.FragmentManager$1 r0 = (androidx.fragment.app.FragmentManager.AnonymousClass1) r0
                        L31:
                            kotlin.Unit r4 = kotlin.Unit.INSTANCE
                            return r4
                        L34:
                            androidx.activity.BackEventCompat r4 = (androidx.activity.BackEventCompat) r4
                            java.lang.String r0 = "backEvent"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                            androidx.activity.OnBackPressedDispatcher r4 = r3.this$0
                            kotlin.collections.ArrayDeque r0 = r4.onBackPressedCallbacks
                            int r1 = r0.size()
                            java.util.ListIterator r0 = r0.listIterator(r1)
                        L47:
                            boolean r1 = r0.hasPrevious()
                            if (r1 == 0) goto L59
                            java.lang.Object r1 = r0.previous()
                            r2 = r1
                            androidx.fragment.app.FragmentManager$1 r2 = (androidx.fragment.app.FragmentManager.AnonymousClass1) r2
                            boolean r2 = r2.isEnabled
                            if (r2 == 0) goto L47
                            goto L5a
                        L59:
                            r1 = 0
                        L5a:
                            androidx.fragment.app.FragmentManager$1 r1 = (androidx.fragment.app.FragmentManager.AnonymousClass1) r1
                            androidx.fragment.app.FragmentManager$1 r0 = r4.inProgressCallback
                            if (r0 == 0) goto L63
                            r4.onBackCancelled()
                        L63:
                            r4.inProgressCallback = r1
                            kotlin.Unit r4 = kotlin.Unit.INSTANCE
                            return r4
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.OnBackPressedDispatcher.AnonymousClass1.invoke(java.lang.Object):java.lang.Object");
                    }
                }, new Function0(this) { // from class: androidx.activity.OnBackPressedDispatcher.3
                    public final /* synthetic */ OnBackPressedDispatcher this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.this$0 = this;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        switch (i4) {
                            case 0:
                                this.this$0.onBackPressed();
                                break;
                            case 1:
                                this.this$0.onBackCancelled();
                                break;
                            default:
                                this.this$0.onBackPressed();
                                break;
                        }
                        return Unit.INSTANCE;
                    }
                }, new Function0(this) { // from class: androidx.activity.OnBackPressedDispatcher.3
                    public final /* synthetic */ OnBackPressedDispatcher this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.this$0 = this;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        switch (i5) {
                            case 0:
                                this.this$0.onBackPressed();
                                break;
                            case 1:
                                this.this$0.onBackCancelled();
                                break;
                            default:
                                this.this$0.onBackPressed();
                                break;
                        }
                        return Unit.INSTANCE;
                    }
                });
            } else {
                final int i6 = 2;
                onBackInvokedCallbackCreateOnBackInvokedCallback = Api33Impl.INSTANCE.createOnBackInvokedCallback(new Function0(this) { // from class: androidx.activity.OnBackPressedDispatcher.3
                    public final /* synthetic */ OnBackPressedDispatcher this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.this$0 = this;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        switch (i6) {
                            case 0:
                                this.this$0.onBackPressed();
                                break;
                            case 1:
                                this.this$0.onBackCancelled();
                                break;
                            default:
                                this.this$0.onBackPressed();
                                break;
                        }
                        return Unit.INSTANCE;
                    }
                });
            }
            this.onBackInvokedCallback = onBackInvokedCallbackCreateOnBackInvokedCallback;
        }
    }

    public final void addCallback(LifecycleOwner lifecycleOwner, FragmentManager.AnonymousClass1 onBackPressedCallback) {
        Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (((LifecycleRegistry) lifecycle).state == Lifecycle.State.DESTROYED) {
            return;
        }
        onBackPressedCallback.cancellables.add(new LifecycleOnBackPressedCancellable(this, lifecycle, onBackPressedCallback));
        updateEnabledCallbacks();
        onBackPressedCallback.enabledChangedCallback = new C00081(this, 0);
    }

    public final void onBackCancelled() {
        Object objPrevious;
        if (this.inProgressCallback == null) {
            ArrayDeque arrayDeque = this.onBackPressedCallbacks;
            ListIterator<E> listIterator = arrayDeque.listIterator(arrayDeque.size());
            do {
                if (!listIterator.hasPrevious()) {
                    objPrevious = null;
                    break;
                }
                objPrevious = listIterator.previous();
            } while (!((FragmentManager.AnonymousClass1) objPrevious).isEnabled);
        }
        this.inProgressCallback = null;
    }

    public final void onBackPressed() {
        Object objPrevious;
        FragmentManager.AnonymousClass1 anonymousClass1 = this.inProgressCallback;
        if (anonymousClass1 == null) {
            ArrayDeque arrayDeque = this.onBackPressedCallbacks;
            arrayDeque.getClass();
            ListIterator listIterator = arrayDeque.listIterator(arrayDeque.size);
            do {
                if (!listIterator.hasPrevious()) {
                    objPrevious = null;
                    break;
                }
                objPrevious = listIterator.previous();
            } while (!((FragmentManager.AnonymousClass1) objPrevious).isEnabled);
            anonymousClass1 = (FragmentManager.AnonymousClass1) objPrevious;
        }
        this.inProgressCallback = null;
        if (anonymousClass1 == null) {
            this.fallbackOnBackPressed.run();
            return;
        }
        FragmentManager fragmentManager = FragmentManager.this;
        fragmentManager.execPendingActions(true);
        if (fragmentManager.mOnBackPressedCallback.isEnabled) {
            fragmentManager.popBackStackImmediate();
        } else {
            fragmentManager.mOnBackPressedDispatcher.onBackPressed();
        }
    }

    public final void updateBackInvokedCallbackState(boolean z) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.invokedDispatcher;
        OnBackInvokedCallback onBackInvokedCallback = this.onBackInvokedCallback;
        if (onBackInvokedDispatcher == null || onBackInvokedCallback == null) {
            return;
        }
        Api33Impl api33Impl = Api33Impl.INSTANCE;
        if (z && !this.backInvokedCallbackRegistered) {
            api33Impl.registerOnBackInvokedCallback(onBackInvokedDispatcher, 0, onBackInvokedCallback);
            this.backInvokedCallbackRegistered = true;
        } else {
            if (z || !this.backInvokedCallbackRegistered) {
                return;
            }
            api33Impl.unregisterOnBackInvokedCallback(onBackInvokedDispatcher, onBackInvokedCallback);
            this.backInvokedCallbackRegistered = false;
        }
    }

    public final void updateEnabledCallbacks() {
        boolean z = this.hasEnabledCallbacks;
        ArrayDeque arrayDeque = this.onBackPressedCallbacks;
        boolean z2 = false;
        if (!(arrayDeque instanceof Collection) || !arrayDeque.isEmpty()) {
            Iterator<E> it = arrayDeque.iterator();
            while (it.hasNext()) {
                if (((FragmentManager.AnonymousClass1) it.next()).isEnabled) {
                    z2 = true;
                    break;
                }
            }
        }
        this.hasEnabledCallbacks = z2;
        if (z2 == z || Build.VERSION.SDK_INT < 33) {
            return;
        }
        updateBackInvokedCallbackState(z2);
    }
}
