package com.google.firebase.components;

import androidx.core.view.DifferentialMotionFlingController$$ExternalSyntheticLambda0;
import com.facebook.appevents.codeless.CodelessManager$$ExternalSyntheticLambda0;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class OptionalProvider implements Provider, Deferred {
    public volatile Provider delegate;
    public Deferred.DeferredHandler handler;
    public static final DifferentialMotionFlingController$$ExternalSyntheticLambda0 NOOP_HANDLER = new DifferentialMotionFlingController$$ExternalSyntheticLambda0(26);
    public static final ComponentRuntime$$ExternalSyntheticLambda1 EMPTY_PROVIDER = new ComponentRuntime$$ExternalSyntheticLambda1(1);

    public OptionalProvider(DifferentialMotionFlingController$$ExternalSyntheticLambda0 differentialMotionFlingController$$ExternalSyntheticLambda0, Provider provider) {
        this.handler = differentialMotionFlingController$$ExternalSyntheticLambda0;
        this.delegate = provider;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        return this.delegate.get();
    }

    @Override // com.google.firebase.inject.Deferred
    public final void whenAvailable(Deferred.DeferredHandler deferredHandler) {
        Provider provider;
        Provider provider2;
        Provider provider3 = this.delegate;
        ComponentRuntime$$ExternalSyntheticLambda1 componentRuntime$$ExternalSyntheticLambda1 = EMPTY_PROVIDER;
        if (provider3 != componentRuntime$$ExternalSyntheticLambda1) {
            deferredHandler.handle(provider3);
            return;
        }
        synchronized (this) {
            provider = this.delegate;
            if (provider != componentRuntime$$ExternalSyntheticLambda1) {
                provider2 = provider;
            } else {
                this.handler = new CodelessManager$$ExternalSyntheticLambda0(this.handler, deferredHandler, 11);
                provider2 = null;
            }
        }
        if (provider2 != null) {
            deferredHandler.handle(provider);
        }
    }
}
