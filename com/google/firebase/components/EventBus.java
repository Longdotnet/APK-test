package com.google.firebase.components;

import com.facebook.GraphRequest$Companion$$ExternalSyntheticLambda1;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class EventBus implements Subscriber, Publisher {
    public final Executor defaultExecutor;
    public final HashMap handlerMap = new HashMap();
    public ArrayDeque pendingEvents = new ArrayDeque();

    public EventBus(Executor executor) {
        this.defaultExecutor = executor;
    }

    public final synchronized Set getHandlers(Event event) {
        Map map;
        try {
            map = (Map) this.handlerMap.get(event.getType());
        } catch (Throwable th) {
            throw th;
        }
        return map == null ? Collections.emptySet() : map.entrySet();
    }

    @Override // com.google.firebase.events.Publisher
    public final void publish(Event event) {
        Preconditions.checkNotNull(event);
        synchronized (this) {
            try {
                ArrayDeque arrayDeque = this.pendingEvents;
                if (arrayDeque != null) {
                    arrayDeque.add(event);
                    return;
                }
                for (Map.Entry entry : getHandlers(event)) {
                    ((Executor) entry.getValue()).execute(new GraphRequest$Companion$$ExternalSyntheticLambda1(entry, event, 23));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.firebase.events.Subscriber
    public final synchronized void subscribe(Class cls, Executor executor, EventHandler eventHandler) {
        try {
            Preconditions.checkNotNull(cls);
            Preconditions.checkNotNull(eventHandler);
            Preconditions.checkNotNull(executor);
            if (!this.handlerMap.containsKey(cls)) {
                this.handlerMap.put(cls, new ConcurrentHashMap());
            }
            ((ConcurrentHashMap) this.handlerMap.get(cls)).put(eventHandler, executor);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.firebase.events.Subscriber
    public final synchronized void unsubscribe(Class cls, EventHandler eventHandler) {
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(eventHandler);
        if (this.handlerMap.containsKey(cls)) {
            ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.handlerMap.get(cls);
            concurrentHashMap.remove(eventHandler);
            if (concurrentHashMap.isEmpty()) {
                this.handlerMap.remove(cls);
            }
        }
    }

    @Override // com.google.firebase.events.Subscriber
    public final void subscribe(Class cls, EventHandler eventHandler) {
        subscribe(cls, this.defaultExecutor, eventHandler);
    }
}
