package androidx.lifecycle;

import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
class ReflectiveGenericLifecycleObserver implements LifecycleEventObserver {
    public final ClassesInfoCache.CallbackInfo mInfo;
    public final LifecycleObserver mWrapped;

    public ReflectiveGenericLifecycleObserver(LifecycleObserver lifecycleObserver) {
        this.mWrapped = lifecycleObserver;
        ClassesInfoCache classesInfoCache = ClassesInfoCache.sInstance;
        Class<?> cls = lifecycleObserver.getClass();
        ClassesInfoCache.CallbackInfo callbackInfo = (ClassesInfoCache.CallbackInfo) classesInfoCache.mCallbackMap.get(cls);
        this.mInfo = callbackInfo == null ? classesInfoCache.createInfo(cls, null) : callbackInfo;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        HashMap map = this.mInfo.mEventToHandlers;
        List list = (List) map.get(event);
        LifecycleObserver lifecycleObserver = this.mWrapped;
        ClassesInfoCache.CallbackInfo.invokeMethodsForEvent(list, lifecycleOwner, event, lifecycleObserver);
        ClassesInfoCache.CallbackInfo.invokeMethodsForEvent((List) map.get(Lifecycle.Event.ON_ANY), lifecycleOwner, event, lifecycleObserver);
    }
}
