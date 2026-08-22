package com.google.firebase.auth;

import androidx.work.Configuration;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.gson.internal.ObjectConstructor;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzy implements Continuation, ObjectConstructor {
    public final Object zza;

    public /* synthetic */ zzy(Object obj) {
        this.zza = obj;
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        Constructor constructor = (Constructor) this.zza;
        try {
            return constructor.newInstance(null);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("Failed to invoke " + constructor + " with no args", e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException("Failed to invoke " + constructor + " with no args", e3.getTargetException());
        }
    }

    @Override // com.google.android.gms.tasks.Continuation
    public /* bridge */ /* synthetic */ Object then(Task task) {
        GetTokenResult getTokenResult = (GetTokenResult) task.getResult();
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(((FirebaseUser) this.zza).zza());
        String token = getTokenResult.getToken();
        com.google.android.gms.common.internal.zzah.checkNotNull(token);
        return firebaseAuth.zzi(null, token);
    }

    public zzy(Configuration.AnonymousClass1 anonymousClass1) {
        this.zza = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), anonymousClass1);
    }
}
