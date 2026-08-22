package androidx.lifecycle;

import android.os.Looper;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap.IteratorWithAdditions;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.work.Worker;
import com.facebook.AccessTokenCache;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class LiveData {
    public static final Object NOT_SET = new Object();
    public boolean mChangingActiveState;
    public volatile Object mData;
    public boolean mDispatchInvalidated;
    public boolean mDispatchingValue;
    public volatile Object mPendingData;
    public final Worker.AnonymousClass1 mPostValueRunnable;
    public int mVersion;
    public final Object mDataLock = new Object();
    public final SafeIterableMap mObservers = new SafeIterableMap();
    public int mActiveCount = 0;

    public final class AlwaysActiveObserver extends ObserverWrapper {
        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        public final boolean shouldBeActive() {
            return true;
        }
    }

    class LifecycleBoundObserver extends ObserverWrapper implements LifecycleEventObserver {
        public final LifecycleOwner mOwner;

        public LifecycleBoundObserver(LifecycleOwner lifecycleOwner, Observer observer) {
            super(observer);
            this.mOwner = lifecycleOwner;
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        public final void detachObserver() {
            this.mOwner.getLifecycle().removeObserver(this);
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        public final boolean isAttachedTo(LifecycleOwner lifecycleOwner) {
            return this.mOwner == lifecycleOwner;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            LifecycleOwner lifecycleOwner2 = this.mOwner;
            Lifecycle.State state = ((LifecycleRegistry) lifecycleOwner2.getLifecycle()).state;
            if (state == Lifecycle.State.DESTROYED) {
                LiveData.this.removeObserver(this.mObserver);
                return;
            }
            Lifecycle.State state2 = null;
            while (state2 != state) {
                activeStateChanged(shouldBeActive());
                state2 = state;
                state = ((LifecycleRegistry) lifecycleOwner2.getLifecycle()).state;
            }
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        public final boolean shouldBeActive() {
            return ((LifecycleRegistry) this.mOwner.getLifecycle()).state.compareTo(Lifecycle.State.STARTED) >= 0;
        }
    }

    public abstract class ObserverWrapper {
        public boolean mActive;
        public int mLastVersion = -1;
        public final Observer mObserver;

        public ObserverWrapper(Observer observer) {
            this.mObserver = observer;
        }

        public final void activeStateChanged(boolean z) {
            if (z == this.mActive) {
                return;
            }
            this.mActive = z;
            int i = z ? 1 : -1;
            LiveData liveData = LiveData.this;
            int i2 = liveData.mActiveCount;
            liveData.mActiveCount = i + i2;
            if (!liveData.mChangingActiveState) {
                liveData.mChangingActiveState = true;
                while (true) {
                    try {
                        int i3 = liveData.mActiveCount;
                        if (i2 == i3) {
                            break;
                        }
                        boolean z2 = i2 == 0 && i3 > 0;
                        boolean z3 = i2 > 0 && i3 == 0;
                        if (z2) {
                            liveData.onActive();
                        } else if (z3) {
                            liveData.onInactive();
                        }
                        i2 = i3;
                    } catch (Throwable th) {
                        liveData.mChangingActiveState = false;
                        throw th;
                    }
                }
                liveData.mChangingActiveState = false;
            }
            if (this.mActive) {
                liveData.dispatchingValue(this);
            }
        }

        public void detachObserver() {
        }

        public boolean isAttachedTo(LifecycleOwner lifecycleOwner) {
            return false;
        }

        public abstract boolean shouldBeActive();
    }

    public LiveData() {
        Object obj = NOT_SET;
        this.mPendingData = obj;
        this.mPostValueRunnable = new Worker.AnonymousClass1(this, 13);
        this.mData = obj;
        this.mVersion = -1;
    }

    public static void assertMainThread(String str) {
        ArchTaskExecutor.getInstance().mDelegate.getClass();
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Cannot invoke ", str, " on a background thread"));
        }
    }

    public final void considerNotify(ObserverWrapper observerWrapper) {
        if (observerWrapper.mActive) {
            if (!observerWrapper.shouldBeActive()) {
                observerWrapper.activeStateChanged(false);
                return;
            }
            int i = observerWrapper.mLastVersion;
            int i2 = this.mVersion;
            if (i >= i2) {
                return;
            }
            observerWrapper.mLastVersion = i2;
            observerWrapper.mObserver.onChanged(this.mData);
        }
    }

    public final void dispatchingValue(ObserverWrapper observerWrapper) {
        if (this.mDispatchingValue) {
            this.mDispatchInvalidated = true;
            return;
        }
        this.mDispatchingValue = true;
        do {
            this.mDispatchInvalidated = false;
            if (observerWrapper != null) {
                considerNotify(observerWrapper);
                observerWrapper = null;
            } else {
                SafeIterableMap safeIterableMap = this.mObservers;
                safeIterableMap.getClass();
                SafeIterableMap.IteratorWithAdditions iteratorWithAdditions = safeIterableMap.new IteratorWithAdditions();
                safeIterableMap.mIterators.put(iteratorWithAdditions, Boolean.FALSE);
                while (iteratorWithAdditions.hasNext()) {
                    considerNotify((ObserverWrapper) ((Map.Entry) iteratorWithAdditions.next()).getValue());
                    if (this.mDispatchInvalidated) {
                        break;
                    }
                }
            }
        } while (this.mDispatchInvalidated);
        this.mDispatchingValue = false;
    }

    public final void observe(LifecycleOwner lifecycleOwner, Observer observer) {
        Object obj;
        assertMainThread("observe");
        if (((LifecycleRegistry) lifecycleOwner.getLifecycle()).state == Lifecycle.State.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(lifecycleOwner, observer);
        SafeIterableMap safeIterableMap = this.mObservers;
        SafeIterableMap.Entry entry = safeIterableMap.get(observer);
        if (entry != null) {
            obj = entry.mValue;
        } else {
            SafeIterableMap.Entry entry2 = new SafeIterableMap.Entry(observer, lifecycleBoundObserver);
            safeIterableMap.mSize++;
            SafeIterableMap.Entry entry3 = safeIterableMap.mEnd;
            if (entry3 == null) {
                safeIterableMap.mStart = entry2;
                safeIterableMap.mEnd = entry2;
            } else {
                entry3.mNext = entry2;
                entry2.mPrevious = entry3;
                safeIterableMap.mEnd = entry2;
            }
            obj = null;
        }
        ObserverWrapper observerWrapper = (ObserverWrapper) obj;
        if (observerWrapper != null && !observerWrapper.isAttachedTo(lifecycleOwner)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (observerWrapper != null) {
            return;
        }
        lifecycleOwner.getLifecycle().addObserver(lifecycleBoundObserver);
    }

    public final void observeForever(AccessTokenCache accessTokenCache) {
        Object obj;
        assertMainThread("observeForever");
        AlwaysActiveObserver alwaysActiveObserver = new AlwaysActiveObserver(accessTokenCache);
        SafeIterableMap safeIterableMap = this.mObservers;
        SafeIterableMap.Entry entry = safeIterableMap.get(accessTokenCache);
        if (entry != null) {
            obj = entry.mValue;
        } else {
            SafeIterableMap.Entry entry2 = new SafeIterableMap.Entry(accessTokenCache, alwaysActiveObserver);
            safeIterableMap.mSize++;
            SafeIterableMap.Entry entry3 = safeIterableMap.mEnd;
            if (entry3 == null) {
                safeIterableMap.mStart = entry2;
                safeIterableMap.mEnd = entry2;
            } else {
                entry3.mNext = entry2;
                entry2.mPrevious = entry3;
                safeIterableMap.mEnd = entry2;
            }
            obj = null;
        }
        ObserverWrapper observerWrapper = (ObserverWrapper) obj;
        if (observerWrapper instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (observerWrapper != null) {
            return;
        }
        alwaysActiveObserver.activeStateChanged(true);
    }

    public void onActive() {
    }

    public void onInactive() {
    }

    public void removeObserver(Observer observer) {
        assertMainThread("removeObserver");
        ObserverWrapper observerWrapper = (ObserverWrapper) this.mObservers.remove(observer);
        if (observerWrapper == null) {
            return;
        }
        observerWrapper.detachObserver();
        observerWrapper.activeStateChanged(false);
    }

    public abstract void setValue(Object obj);
}
