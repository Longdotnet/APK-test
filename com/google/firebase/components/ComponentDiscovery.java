package com.google.firebase.components;

import android.app.Service;
import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.firebase.inject.Provider;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ComponentDiscovery<T> {
    private static final String COMPONENT_KEY_PREFIX = "com.google.firebase.components:";
    private static final String COMPONENT_SENTINEL_VALUE = "com.google.firebase.components.ComponentRegistrar";
    static final String TAG = "ComponentDiscovery";
    private final T context;
    private final RegistrarNameRetriever retriever;

    public interface RegistrarNameRetriever {
    }

    public ComponentDiscovery(T t, RegistrarNameRetriever registrarNameRetriever) {
        this.context = t;
        this.retriever = registrarNameRetriever;
    }

    public static ComponentDiscovery<Context> forContext(Context context, Class<? extends Service> cls) {
        return new ComponentDiscovery<>(context, new Fragment.AnonymousClass7(cls, 29));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ComponentRegistrar instantiate(String str) {
        try {
            Class<?> cls = Class.forName(str);
            if (ComponentRegistrar.class.isAssignableFrom(cls)) {
                return (ComponentRegistrar) cls.getDeclaredConstructor(null).newInstance(null);
            }
            throw new InvalidRegistrarException("Class " + str + " is not an instance of com.google.firebase.components.ComponentRegistrar");
        } catch (ClassNotFoundException unused) {
            Log.w(TAG, "Class " + str + " is not an found.");
            return null;
        } catch (IllegalAccessException e) {
            throw new InvalidRegistrarException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Could not instantiate ", str, "."), e);
        } catch (InstantiationException e2) {
            throw new InvalidRegistrarException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Could not instantiate ", str, "."), e2);
        } catch (NoSuchMethodException e3) {
            throw new InvalidRegistrarException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Could not instantiate ", str), e3);
        } catch (InvocationTargetException e4) {
            throw new InvalidRegistrarException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Could not instantiate ", str), e4);
        }
    }

    @Deprecated
    public List<ComponentRegistrar> discover() {
        ArrayList arrayList = new ArrayList();
        Iterator it = ((Fragment.AnonymousClass7) this.retriever).retrieve(this.context).iterator();
        while (it.hasNext()) {
            try {
                ComponentRegistrar componentRegistrarInstantiate = instantiate((String) it.next());
                if (componentRegistrarInstantiate != null) {
                    arrayList.add(componentRegistrarInstantiate);
                }
            } catch (InvalidRegistrarException e) {
                Log.w(TAG, "Invalid component registrar.", e);
            }
        }
        return arrayList;
    }

    public List<Provider<ComponentRegistrar>> discoverLazy() {
        ArrayList arrayList = new ArrayList();
        Iterator it = ((Fragment.AnonymousClass7) this.retriever).retrieve(this.context).iterator();
        while (it.hasNext()) {
            arrayList.add(new ComponentDiscovery$$ExternalSyntheticLambda0((String) it.next(), 0));
        }
        return arrayList;
    }
}
