package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.google.firebase.auth.zzaa;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class LifecycleService extends Service implements LifecycleOwner {
    public final zzaa dispatcher = new zzaa(this);

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return (LifecycleRegistry) this.dispatcher.zza;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        this.dispatcher.postDispatchRunnable(Lifecycle.Event.ON_START);
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.dispatcher.postDispatchRunnable(Lifecycle.Event.ON_CREATE);
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        Lifecycle.Event event = Lifecycle.Event.ON_STOP;
        zzaa zzaaVar = this.dispatcher;
        zzaaVar.postDispatchRunnable(event);
        zzaaVar.postDispatchRunnable(Lifecycle.Event.ON_DESTROY);
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onStart(Intent intent, int i) {
        this.dispatcher.postDispatchRunnable(Lifecycle.Event.ON_START);
        super.onStart(intent, i);
    }
}
