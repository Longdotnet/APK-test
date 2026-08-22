package com.google.firebase.components;

import com.google.firebase.events.Event;
import com.google.firebase.events.Publisher;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class RestrictedComponentContainer extends Protocol.Companion {
    public final Set allowedDeferredInterfaces;
    public final Set allowedDirectInterfaces;
    public final Set allowedProviderInterfaces;
    public final Set allowedPublishedEvents;
    public final Set allowedSetDirectInterfaces;
    public final Set allowedSetProviderInterfaces;
    public final ComponentRuntime delegateContainer;

    public final class RestrictedPublisher implements Publisher {
        public final Set allowedPublishedEvents;
        public final Publisher delegate;

        public RestrictedPublisher(Set set, Publisher publisher) {
            this.allowedPublishedEvents = set;
            this.delegate = publisher;
        }

        @Override // com.google.firebase.events.Publisher
        public final void publish(Event event) {
            if (!this.allowedPublishedEvents.contains(event.getType())) {
                throw new DependencyException(String.format("Attempting to publish an undeclared event %s.", event));
            }
            this.delegate.publish(event);
        }
    }

    public RestrictedComponentContainer(Component component, ComponentRuntime componentRuntime) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        for (Dependency dependency : component.getDependencies()) {
            if (dependency.isDirectInjection()) {
                if (dependency.isSet()) {
                    hashSet4.add(dependency.getInterface());
                } else {
                    hashSet.add(dependency.getInterface());
                }
            } else if (dependency.isDeferred()) {
                hashSet3.add(dependency.getInterface());
            } else if (dependency.isSet()) {
                hashSet5.add(dependency.getInterface());
            } else {
                hashSet2.add(dependency.getInterface());
            }
        }
        if (!component.getPublishedEvents().isEmpty()) {
            hashSet.add(Publisher.class);
        }
        this.allowedDirectInterfaces = Collections.unmodifiableSet(hashSet);
        this.allowedProviderInterfaces = Collections.unmodifiableSet(hashSet2);
        this.allowedDeferredInterfaces = Collections.unmodifiableSet(hashSet3);
        this.allowedSetDirectInterfaces = Collections.unmodifiableSet(hashSet4);
        this.allowedSetProviderInterfaces = Collections.unmodifiableSet(hashSet5);
        this.allowedPublishedEvents = component.getPublishedEvents();
        this.delegateContainer = componentRuntime;
    }

    @Override // okhttp3.Protocol.Companion, com.google.firebase.components.ComponentContainer
    public final Object get(Class cls) {
        if (this.allowedDirectInterfaces.contains(cls)) {
            Object obj = this.delegateContainer.get((Class<Object>) cls);
            return !cls.equals(Publisher.class) ? obj : new RestrictedPublisher(this.allowedPublishedEvents, (Publisher) obj);
        }
        throw new DependencyException("Attempting to request an undeclared dependency " + cls + ".");
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final Deferred getDeferred(Class cls) {
        if (this.allowedDeferredInterfaces.contains(cls)) {
            return this.delegateContainer.getDeferred(cls);
        }
        throw new DependencyException("Attempting to request an undeclared dependency Deferred<" + cls + ">.");
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final Provider getProvider(Class cls) {
        if (this.allowedProviderInterfaces.contains(cls)) {
            return this.delegateContainer.getProvider(cls);
        }
        throw new DependencyException("Attempting to request an undeclared dependency Provider<" + cls + ">.");
    }

    @Override // okhttp3.Protocol.Companion, com.google.firebase.components.ComponentContainer
    public final Set setOf(Class cls) {
        if (this.allowedSetDirectInterfaces.contains(cls)) {
            return this.delegateContainer.setOf(cls);
        }
        throw new DependencyException("Attempting to request an undeclared dependency Set<" + cls + ">.");
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final Provider setOfProvider(Class cls) {
        if (this.allowedSetProviderInterfaces.contains(cls)) {
            return this.delegateContainer.setOfProvider(cls);
        }
        throw new DependencyException("Attempting to request an undeclared dependency Provider<Set<" + cls + ">>.");
    }
}
