package com.google.firebase.components;

import android.util.Log;
import com.facebook.GraphRequest$Companion$$ExternalSyntheticLambda1;
import com.google.firebase.FirebaseApp$$ExternalSyntheticLambda0;
import com.google.firebase.dynamicloading.ComponentLoader;
import com.google.firebase.events.Event;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.io.CloseableKt;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public class ComponentRuntime extends Protocol.Companion implements ComponentLoader {
    private static final Provider<Set<Object>> EMPTY_PROVIDER = new ComponentRuntime$$ExternalSyntheticLambda1(0);
    private final ComponentRegistrarProcessor componentRegistrarProcessor;
    private final Map<Component<?>, Provider<?>> components;
    private final AtomicReference<Boolean> eagerComponentsInitializedWith;
    private final EventBus eventBus;
    private final Map<Class<?>, Provider<?>> lazyInstanceMap;
    private final Map<Class<?>, LazySet> lazySetMap;
    private final List<Provider<ComponentRegistrar>> unprocessedRegistrarProviders;

    public static final class Builder {
        private final Executor defaultExecutor;
        private final List<Provider<ComponentRegistrar>> lazyRegistrars = new ArrayList();
        private final List<Component<?>> additionalComponents = new ArrayList();
        private ComponentRegistrarProcessor componentRegistrarProcessor = ComponentRegistrarProcessor.NOOP;

        public Builder(Executor executor) {
            this.defaultExecutor = executor;
        }

        public static /* synthetic */ ComponentRegistrar lambda$addComponentRegistrar$0(ComponentRegistrar componentRegistrar) {
            return componentRegistrar;
        }

        public Builder addComponent(Component<?> component) {
            this.additionalComponents.add(component);
            return this;
        }

        public Builder addComponentRegistrar(ComponentRegistrar componentRegistrar) {
            this.lazyRegistrars.add(new ComponentRuntime$$ExternalSyntheticLambda0(componentRegistrar, 1));
            return this;
        }

        public Builder addLazyComponentRegistrars(Collection<Provider<ComponentRegistrar>> collection) {
            this.lazyRegistrars.addAll(collection);
            return this;
        }

        public ComponentRuntime build() {
            return new ComponentRuntime(this.defaultExecutor, this.lazyRegistrars, this.additionalComponents, this.componentRegistrarProcessor);
        }

        public Builder setProcessor(ComponentRegistrarProcessor componentRegistrarProcessor) {
            this.componentRegistrarProcessor = componentRegistrarProcessor;
            return this;
        }
    }

    private ComponentRuntime(Executor executor, Iterable<Provider<ComponentRegistrar>> iterable, Collection<Component<?>> collection, ComponentRegistrarProcessor componentRegistrarProcessor) {
        this.components = new HashMap();
        this.lazyInstanceMap = new HashMap();
        this.lazySetMap = new HashMap();
        this.eagerComponentsInitializedWith = new AtomicReference<>();
        EventBus eventBus = new EventBus(executor);
        this.eventBus = eventBus;
        this.componentRegistrarProcessor = componentRegistrarProcessor;
        ArrayList arrayList = new ArrayList();
        arrayList.add(Component.of(eventBus, EventBus.class, Subscriber.class, Publisher.class));
        arrayList.add(Component.of(this, ComponentLoader.class, new Class[0]));
        for (Component<?> component : collection) {
            if (component != null) {
                arrayList.add(component);
            }
        }
        this.unprocessedRegistrarProviders = iterableToList(iterable);
        discoverComponents(arrayList);
    }

    public static Builder builder(Executor executor) {
        return new Builder(executor);
    }

    private void discoverComponents(List<Component<?>> list) {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<Provider<ComponentRegistrar>> it = this.unprocessedRegistrarProviders.iterator();
            while (it.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = it.next().get();
                    if (componentRegistrar != null) {
                        list.addAll(this.componentRegistrarProcessor.processRegistrar(componentRegistrar));
                        it.remove();
                    }
                } catch (InvalidRegistrarException e) {
                    it.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e);
                }
            }
            if (this.components.isEmpty()) {
                CloseableKt.detect(list);
            } else {
                ArrayList arrayList2 = new ArrayList(this.components.keySet());
                arrayList2.addAll(list);
                CloseableKt.detect(arrayList2);
            }
            for (Component<?> component : list) {
                this.components.put(component, new Lazy((Provider) new FirebaseApp$$ExternalSyntheticLambda0(this, component, 1)));
            }
            arrayList.addAll(processInstanceComponents(list));
            arrayList.addAll(processSetComponents());
            processDependencies();
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((Runnable) it2.next()).run();
        }
        maybeInitializeEagerComponents();
    }

    private void doInitializeEagerComponents(Map<Component<?>, Provider<?>> map, boolean z) {
        ArrayDeque arrayDeque;
        for (Map.Entry<Component<?>, Provider<?>> entry : map.entrySet()) {
            Component<?> key = entry.getKey();
            Provider<?> value = entry.getValue();
            if (key.isAlwaysEager() || (key.isEagerInDefaultApp() && z)) {
                value.get();
            }
        }
        EventBus eventBus = this.eventBus;
        synchronized (eventBus) {
            arrayDeque = eventBus.pendingEvents;
            if (arrayDeque != null) {
                eventBus.pendingEvents = null;
            } else {
                arrayDeque = null;
            }
        }
        if (arrayDeque != null) {
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                eventBus.publish((Event) it.next());
            }
        }
    }

    private static <T> List<T> iterableToList(Iterable<T> iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public /* synthetic */ Object lambda$discoverComponents$0(Component component) {
        return component.getFactory().create(new RestrictedComponentContainer(component, this));
    }

    public static void lambda$processInstanceComponents$2(OptionalProvider optionalProvider, Provider provider) {
        Deferred.DeferredHandler deferredHandler;
        if (optionalProvider.delegate != OptionalProvider.EMPTY_PROVIDER) {
            throw new IllegalStateException("provide() can be called only once.");
        }
        synchronized (optionalProvider) {
            deferredHandler = optionalProvider.handler;
            optionalProvider.handler = null;
            optionalProvider.delegate = provider;
        }
        deferredHandler.handle(provider);
    }

    public static void lambda$processSetComponents$3(LazySet lazySet, Provider provider) {
        synchronized (lazySet) {
            try {
                if (lazySet.actualSet == null) {
                    lazySet.providers.add(provider);
                } else {
                    lazySet.actualSet.add(provider.get());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* synthetic */ ComponentRegistrar lambda$toProviders$1(ComponentRegistrar componentRegistrar) {
        return componentRegistrar;
    }

    private void maybeInitializeEagerComponents() {
        Boolean bool = this.eagerComponentsInitializedWith.get();
        if (bool != null) {
            doInitializeEagerComponents(this.components, bool.booleanValue());
        }
    }

    private void processDependencies() {
        for (Component<?> component : this.components.keySet()) {
            for (Dependency dependency : component.getDependencies()) {
                if (dependency.isSet() && !this.lazySetMap.containsKey(dependency.getInterface())) {
                    Map<Class<?>, LazySet> map = this.lazySetMap;
                    Class<?> cls = dependency.getInterface();
                    Set setEmptySet = Collections.emptySet();
                    LazySet lazySet = new LazySet();
                    lazySet.actualSet = null;
                    lazySet.providers = Collections.newSetFromMap(new ConcurrentHashMap());
                    lazySet.providers.addAll(setEmptySet);
                    map.put(cls, lazySet);
                } else if (this.lazyInstanceMap.containsKey(dependency.getInterface())) {
                    continue;
                } else {
                    if (dependency.isRequired()) {
                        throw new MissingDependencyException("Unsatisfied dependency for component " + component + ": " + dependency.getInterface());
                    }
                    if (!dependency.isSet()) {
                        this.lazyInstanceMap.put(dependency.getInterface(), new OptionalProvider(OptionalProvider.NOOP_HANDLER, OptionalProvider.EMPTY_PROVIDER));
                    }
                }
            }
        }
    }

    private List<Runnable> processInstanceComponents(List<Component<?>> list) {
        ArrayList arrayList = new ArrayList();
        for (Component<?> component : list) {
            if (component.isValue()) {
                Provider<?> provider = this.components.get(component);
                for (Class<? super Object> cls : component.getProvidedInterfaces()) {
                    if (this.lazyInstanceMap.containsKey(cls)) {
                        arrayList.add(new GraphRequest$Companion$$ExternalSyntheticLambda1((OptionalProvider) this.lazyInstanceMap.get(cls), provider, 21));
                    } else {
                        this.lazyInstanceMap.put(cls, provider);
                    }
                }
            }
        }
        return arrayList;
    }

    private List<Runnable> processSetComponents() {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (Map.Entry<Component<?>, Provider<?>> entry : this.components.entrySet()) {
            Component<?> key = entry.getKey();
            if (!key.isValue()) {
                Provider<?> value = entry.getValue();
                for (Class<? super Object> cls : key.getProvidedInterfaces()) {
                    if (!map.containsKey(cls)) {
                        map.put(cls, new HashSet());
                    }
                    ((Set) map.get(cls)).add(value);
                }
            }
        }
        for (Map.Entry entry2 : map.entrySet()) {
            if (this.lazySetMap.containsKey(entry2.getKey())) {
                LazySet lazySet = this.lazySetMap.get(entry2.getKey());
                Iterator it = ((Set) entry2.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(new GraphRequest$Companion$$ExternalSyntheticLambda1(lazySet, (Provider) it.next(), 22));
                }
            } else {
                Map<Class<?>, LazySet> map2 = this.lazySetMap;
                Class<?> cls2 = (Class) entry2.getKey();
                Set set = (Set) ((Collection) entry2.getValue());
                LazySet lazySet2 = new LazySet();
                lazySet2.actualSet = null;
                lazySet2.providers = Collections.newSetFromMap(new ConcurrentHashMap());
                lazySet2.providers.addAll(set);
                map2.put(cls2, lazySet2);
            }
        }
        return arrayList;
    }

    private static Iterable<Provider<ComponentRegistrar>> toProviders(Iterable<ComponentRegistrar> iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator<ComponentRegistrar> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(new ComponentRuntime$$ExternalSyntheticLambda0(it.next(), 0));
        }
        return arrayList;
    }

    @Override // okhttp3.Protocol.Companion, com.google.firebase.components.ComponentContainer
    public /* bridge */ /* synthetic */ Object get(Class cls) {
        return super.get(cls);
    }

    public Collection<Component<?>> getAllComponentsForTest() {
        return this.components.keySet();
    }

    @Override // com.google.firebase.components.ComponentContainer
    public <T> Deferred<T> getDeferred(Class<T> cls) {
        Provider<T> provider = getProvider(cls);
        if (provider == null) {
            return new OptionalProvider(OptionalProvider.NOOP_HANDLER, OptionalProvider.EMPTY_PROVIDER);
        }
        return provider instanceof OptionalProvider ? (OptionalProvider) provider : new OptionalProvider(null, provider);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public synchronized <T> Provider<T> getProvider(Class<T> cls) {
        Preconditions.checkNotNull(cls, "Null interface requested.");
        return (Provider) this.lazyInstanceMap.get(cls);
    }

    public void initializeAllComponentsForTests() {
        Iterator<Provider<?>> it = this.components.values().iterator();
        while (it.hasNext()) {
            it.next().get();
        }
    }

    public void initializeEagerComponents(boolean z) {
        HashMap map;
        AtomicReference<Boolean> atomicReference = this.eagerComponentsInitializedWith;
        Boolean boolValueOf = Boolean.valueOf(z);
        while (!atomicReference.compareAndSet(null, boolValueOf)) {
            if (atomicReference.get() != null) {
                return;
            }
        }
        synchronized (this) {
            map = new HashMap(this.components);
        }
        doInitializeEagerComponents(map, z);
    }

    @Override // okhttp3.Protocol.Companion, com.google.firebase.components.ComponentContainer
    public /* bridge */ /* synthetic */ Set setOf(Class cls) {
        return super.setOf(cls);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public synchronized <T> Provider<Set<T>> setOfProvider(Class<T> cls) {
        LazySet lazySet = this.lazySetMap.get(cls);
        if (lazySet != null) {
            return lazySet;
        }
        return (Provider<Set<T>>) EMPTY_PROVIDER;
    }

    public /* synthetic */ ComponentRuntime(Executor executor, Iterable iterable, Collection collection, ComponentRegistrarProcessor componentRegistrarProcessor) {
        this(executor, iterable, collection, componentRegistrarProcessor);
    }

    @Deprecated
    public ComponentRuntime(Executor executor, Iterable<ComponentRegistrar> iterable, Component<?>... componentArr) {
        this(executor, toProviders(iterable), Arrays.asList(componentArr), ComponentRegistrarProcessor.NOOP);
    }

    @Override // com.google.firebase.dynamicloading.ComponentLoader
    public void discoverComponents() {
        synchronized (this) {
            try {
                if (this.unprocessedRegistrarProviders.isEmpty()) {
                    return;
                }
                discoverComponents(new ArrayList());
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
