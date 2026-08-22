package androidx.lifecycle;

import android.os.Looper;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.core.text.jp.CyjpdoedCdLTIO;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class LifecycleRegistry extends Lifecycle {
    public int addingObserverCounter;
    public final boolean enforceMainThread;
    public boolean handlingEvent;
    public final WeakReference lifecycleOwner;
    public boolean newEventOccurred;
    public FastSafeIterableMap observerMap;
    public final ArrayList parentStates;
    public Lifecycle.State state;

    /* JADX INFO: loaded from: classes.dex */
    public final class ObserverWithState {
        public LifecycleEventObserver lifecycleObserver;
        public Lifecycle.State state;

        public final void dispatchEvent(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            Lifecycle.State targetState = event.getTargetState();
            Lifecycle.State state1 = this.state;
            Intrinsics.checkNotNullParameter(state1, "state1");
            if (targetState.compareTo(state1) < 0) {
                state1 = targetState;
            }
            this.state = state1;
            this.lifecycleObserver.onStateChanged(lifecycleOwner, event);
            this.state = targetState;
        }
    }

    public LifecycleRegistry(LifecycleOwner lifecycleOwner) {
        new AtomicReference();
        this.enforceMainThread = true;
        this.observerMap = new FastSafeIterableMap();
        this.state = Lifecycle.State.INITIALIZED;
        this.parentStates = new ArrayList();
        this.lifecycleOwner = new WeakReference(lifecycleOwner);
    }

    @Override // androidx.lifecycle.Lifecycle
    public final void addObserver(LifecycleObserver lifecycleObserver) {
        LifecycleEventObserver reflectiveGenericLifecycleObserver;
        LifecycleOwner lifecycleOwner;
        ArrayList arrayList = this.parentStates;
        Object obj = null;
        enforceMainThreadIfNeeded("addObserver");
        Lifecycle.State state = this.state;
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        if (state != state2) {
            state2 = Lifecycle.State.INITIALIZED;
        }
        ObserverWithState observerWithState = new ObserverWithState();
        HashMap map = Lifecycling.callbackCache;
        boolean z = lifecycleObserver instanceof LifecycleEventObserver;
        boolean z2 = lifecycleObserver instanceof DefaultLifecycleObserver;
        if (z && z2) {
            reflectiveGenericLifecycleObserver = new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver) lifecycleObserver, (LifecycleEventObserver) lifecycleObserver);
        } else if (z2) {
            reflectiveGenericLifecycleObserver = new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver) lifecycleObserver, null);
        } else if (z) {
            reflectiveGenericLifecycleObserver = (LifecycleEventObserver) lifecycleObserver;
        } else {
            Class<?> cls = lifecycleObserver.getClass();
            if (Lifecycling.getObserverConstructorType(cls) == 2) {
                Object obj2 = Lifecycling.classToAdapters.get(cls);
                Intrinsics.checkNotNull(obj2);
                List list = (List) obj2;
                if (list.size() == 1) {
                    Lifecycling.createGeneratedAdapter((Constructor) list.get(0), lifecycleObserver);
                    throw null;
                }
                int size = list.size();
                GeneratedAdapter[] generatedAdapterArr = new GeneratedAdapter[size];
                if (size > 0) {
                    Lifecycling.createGeneratedAdapter((Constructor) list.get(0), lifecycleObserver);
                    throw null;
                }
                reflectiveGenericLifecycleObserver = new CompositeGeneratedAdaptersObserver(generatedAdapterArr);
            } else {
                reflectiveGenericLifecycleObserver = new ReflectiveGenericLifecycleObserver(lifecycleObserver);
            }
        }
        observerWithState.lifecycleObserver = reflectiveGenericLifecycleObserver;
        observerWithState.state = state2;
        FastSafeIterableMap fastSafeIterableMap = this.observerMap;
        SafeIterableMap.Entry entry = fastSafeIterableMap.get(lifecycleObserver);
        if (entry != null) {
            obj = entry.mValue;
        } else {
            HashMap map2 = fastSafeIterableMap.mHashMap;
            SafeIterableMap.Entry entry2 = new SafeIterableMap.Entry(lifecycleObserver, observerWithState);
            fastSafeIterableMap.mSize++;
            SafeIterableMap.Entry entry3 = fastSafeIterableMap.mEnd;
            if (entry3 == null) {
                fastSafeIterableMap.mStart = entry2;
                fastSafeIterableMap.mEnd = entry2;
            } else {
                entry3.mNext = entry2;
                entry2.mPrevious = entry3;
                fastSafeIterableMap.mEnd = entry2;
            }
            map2.put(lifecycleObserver, entry2);
        }
        if (((ObserverWithState) obj) == null && (lifecycleOwner = (LifecycleOwner) this.lifecycleOwner.get()) != null) {
            boolean z3 = this.addingObserverCounter != 0 || this.handlingEvent;
            Lifecycle.State stateCalculateTargetState = calculateTargetState(lifecycleObserver);
            this.addingObserverCounter++;
            while (observerWithState.state.compareTo(stateCalculateTargetState) < 0 && this.observerMap.mHashMap.containsKey(lifecycleObserver)) {
                arrayList.add(observerWithState.state);
                Lifecycle.Event.Companion companion = Lifecycle.Event.Companion;
                Lifecycle.State state3 = observerWithState.state;
                companion.getClass();
                Lifecycle.Event eventUpFrom = Lifecycle.Event.Companion.upFrom(state3);
                if (eventUpFrom == null) {
                    throw new IllegalStateException("no event up from " + observerWithState.state);
                }
                observerWithState.dispatchEvent(lifecycleOwner, eventUpFrom);
                arrayList.remove(arrayList.size() - 1);
                stateCalculateTargetState = calculateTargetState(lifecycleObserver);
            }
            if (!z3) {
                sync();
            }
            this.addingObserverCounter--;
        }
    }

    public final Lifecycle.State calculateTargetState(LifecycleObserver lifecycleObserver) {
        ObserverWithState observerWithState;
        HashMap map = this.observerMap.mHashMap;
        SafeIterableMap.Entry entry = map.containsKey(lifecycleObserver) ? ((SafeIterableMap.Entry) map.get(lifecycleObserver)).mPrevious : null;
        Lifecycle.State state = (entry == null || (observerWithState = (ObserverWithState) entry.mValue) == null) ? null : observerWithState.state;
        ArrayList arrayList = this.parentStates;
        Lifecycle.State state2 = arrayList.isEmpty() ? null : (Lifecycle.State) arrayList.get(arrayList.size() - 1);
        Lifecycle.State state1 = this.state;
        Intrinsics.checkNotNullParameter(state1, "state1");
        if (state == null || state.compareTo(state1) >= 0) {
            state = state1;
        }
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }

    public final void handleLifecycleEvent(Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        enforceMainThreadIfNeeded("handleLifecycleEvent");
        moveToState(event.getTargetState());
    }

    public final void moveToState(Lifecycle.State state) {
        Lifecycle.State state2 = this.state;
        if (state2 == state) {
            return;
        }
        Lifecycle.State state3 = Lifecycle.State.INITIALIZED;
        Lifecycle.State state4 = Lifecycle.State.DESTROYED;
        if (state2 == state3 && state == state4) {
            throw new IllegalStateException(("no event down from " + this.state + " in component " + this.lifecycleOwner.get()).toString());
        }
        this.state = state;
        if (this.handlingEvent || this.addingObserverCounter != 0) {
            this.newEventOccurred = true;
            return;
        }
        this.handlingEvent = true;
        sync();
        this.handlingEvent = false;
        if (this.state == state4) {
            this.observerMap = new FastSafeIterableMap();
        }
    }

    @Override // androidx.lifecycle.Lifecycle
    public final void removeObserver(LifecycleObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        enforceMainThreadIfNeeded("removeObserver");
        this.observerMap.remove(observer);
    }

    public final void setCurrentState() {
        Lifecycle.State state = Lifecycle.State.CREATED;
        enforceMainThreadIfNeeded("setCurrentState");
        moveToState(state);
    }

    public final void sync() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this.lifecycleOwner.get();
        if (lifecycleOwner == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
        }
        while (true) {
            FastSafeIterableMap fastSafeIterableMap = this.observerMap;
            if (fastSafeIterableMap.mSize != 0) {
                SafeIterableMap.Entry entry = fastSafeIterableMap.mStart;
                Intrinsics.checkNotNull(entry);
                Lifecycle.State state = ((ObserverWithState) entry.mValue).state;
                SafeIterableMap.Entry entry2 = this.observerMap.mEnd;
                Intrinsics.checkNotNull(entry2);
                Lifecycle.State state2 = ((ObserverWithState) entry2.mValue).state;
                if (state == state2 && this.state == state2) {
                    break;
                }
                this.newEventOccurred = false;
                Lifecycle.State state3 = this.state;
                SafeIterableMap.Entry entry3 = this.observerMap.mStart;
                Intrinsics.checkNotNull(entry3);
                if (state3.compareTo(((ObserverWithState) entry3.mValue).state) < 0) {
                    FastSafeIterableMap fastSafeIterableMap2 = this.observerMap;
                    SafeIterableMap.AscendingIterator ascendingIterator = new SafeIterableMap.AscendingIterator(fastSafeIterableMap2.mEnd, fastSafeIterableMap2.mStart, 1);
                    fastSafeIterableMap2.mIterators.put(ascendingIterator, Boolean.FALSE);
                    while (ascendingIterator.hasNext() && !this.newEventOccurred) {
                        Map.Entry entry4 = (Map.Entry) ascendingIterator.next();
                        Intrinsics.checkNotNullExpressionValue(entry4, "next()");
                        LifecycleObserver lifecycleObserver = (LifecycleObserver) entry4.getKey();
                        ObserverWithState observerWithState = (ObserverWithState) entry4.getValue();
                        while (observerWithState.state.compareTo(this.state) > 0 && !this.newEventOccurred && this.observerMap.mHashMap.containsKey(lifecycleObserver)) {
                            Lifecycle.Event.Companion companion = Lifecycle.Event.Companion;
                            Lifecycle.State state4 = observerWithState.state;
                            companion.getClass();
                            Lifecycle.Event eventDownFrom = Lifecycle.Event.Companion.downFrom(state4);
                            if (eventDownFrom == null) {
                                throw new IllegalStateException("no event down from " + observerWithState.state);
                            }
                            this.parentStates.add(eventDownFrom.getTargetState());
                            observerWithState.dispatchEvent(lifecycleOwner, eventDownFrom);
                            ArrayList arrayList = this.parentStates;
                            arrayList.remove(arrayList.size() - 1);
                        }
                    }
                }
                SafeIterableMap.Entry entry5 = this.observerMap.mEnd;
                if (!this.newEventOccurred && entry5 != null && this.state.compareTo(((ObserverWithState) entry5.mValue).state) > 0) {
                    FastSafeIterableMap fastSafeIterableMap3 = this.observerMap;
                    fastSafeIterableMap3.getClass();
                    SafeIterableMap.IteratorWithAdditions iteratorWithAdditions = new SafeIterableMap.IteratorWithAdditions();
                    fastSafeIterableMap3.mIterators.put(iteratorWithAdditions, Boolean.FALSE);
                    while (iteratorWithAdditions.hasNext() && !this.newEventOccurred) {
                        Map.Entry entry6 = (Map.Entry) iteratorWithAdditions.next();
                        LifecycleObserver lifecycleObserver2 = (LifecycleObserver) entry6.getKey();
                        ObserverWithState observerWithState2 = (ObserverWithState) entry6.getValue();
                        while (observerWithState2.state.compareTo(this.state) < 0 && !this.newEventOccurred && this.observerMap.mHashMap.containsKey(lifecycleObserver2)) {
                            this.parentStates.add(observerWithState2.state);
                            Lifecycle.Event.Companion companion2 = Lifecycle.Event.Companion;
                            Lifecycle.State state5 = observerWithState2.state;
                            companion2.getClass();
                            Lifecycle.Event eventUpFrom = Lifecycle.Event.Companion.upFrom(state5);
                            if (eventUpFrom == null) {
                                throw new IllegalStateException("no event up from " + observerWithState2.state);
                            }
                            observerWithState2.dispatchEvent(lifecycleOwner, eventUpFrom);
                            ArrayList arrayList2 = this.parentStates;
                            arrayList2.remove(arrayList2.size() - 1);
                        }
                    }
                }
            } else {
                break;
            }
        }
        this.newEventOccurred = false;
    }

    public final void enforceMainThreadIfNeeded(String str) {
        if (this.enforceMainThread) {
            ArchTaskExecutor.getInstance().mDelegate.getClass();
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                throw new IllegalStateException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1(CyjpdoedCdLTIO.cCN, str, " must be called on the main thread").toString());
            }
        }
    }
}
