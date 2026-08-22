package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.os.Build;
import android.util.Base64OutputStream;
import androidx.core.os.UserManagerCompat$Api24Impl;
import androidx.work.WorkContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseApp$$ExternalSyntheticLambda0;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.Dependency;
import com.google.firebase.inject.Provider;
import com.google.firebase.platforminfo.DefaultUserAgentPublisher$$ExternalSyntheticLambda0;
import com.google.firebase.platforminfo.UserAgentPublisher;
import com.google.gson.yWTz.kBfGXgdfpo;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultHeartBeatController implements HeartBeatController, HeartBeatInfo {
    private static final ThreadFactory THREAD_FACTORY = new DefaultHeartBeatController$$ExternalSyntheticLambda3();
    private final Context applicationContext;
    private final Executor backgroundExecutor;
    private final Set<HeartBeatConsumer> consumers;
    private final Provider<HeartBeatInfoStorage> storageProvider;
    private final Provider<UserAgentPublisher> userAgentProvider;

    private DefaultHeartBeatController(Context context, String str, Set<HeartBeatConsumer> set, Provider<UserAgentPublisher> provider) {
        this(new FirebaseApp$$ExternalSyntheticLambda0(context, str), set, new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), THREAD_FACTORY), provider, context);
    }

    public static Component<DefaultHeartBeatController> component() {
        return Component.builder(DefaultHeartBeatController.class, HeartBeatController.class, HeartBeatInfo.class).add(Dependency.required(Context.class)).add(Dependency.required(FirebaseApp.class)).add(Dependency.setOf(HeartBeatConsumer.class)).add(Dependency.requiredProvider(UserAgentPublisher.class)).factory(new DefaultUserAgentPublisher$$ExternalSyntheticLambda0(1)).build();
    }

    public static /* synthetic */ DefaultHeartBeatController lambda$component$4(ComponentContainer componentContainer) {
        return new DefaultHeartBeatController((Context) componentContainer.get(Context.class), ((FirebaseApp) componentContainer.get(FirebaseApp.class)).getPersistenceKey(), componentContainer.setOf(HeartBeatConsumer.class), componentContainer.getProvider(UserAgentPublisher.class));
    }

    public /* synthetic */ String lambda$getHeartBeatsHeader$2() {
        String string;
        synchronized (this) {
            try {
                HeartBeatInfoStorage heartBeatInfoStorage = this.storageProvider.get();
                ArrayList allHeartBeats = heartBeatInfoStorage.getAllHeartBeats();
                heartBeatInfoStorage.deleteAllHeartBeats();
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < allHeartBeats.size(); i++) {
                    HeartBeatResult heartBeatResult = (HeartBeatResult) allHeartBeats.get(i);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("agent", heartBeatResult.getUserAgent());
                    jSONObject.put("dates", new JSONArray((Collection) heartBeatResult.getUsedDates()));
                    jSONArray.put(jSONObject);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(kBfGXgdfpo.aqqVilf, jSONArray);
                jSONObject2.put("version", "2");
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream, 11);
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(base64OutputStream);
                    try {
                        gZIPOutputStream.write(jSONObject2.toString().getBytes("UTF-8"));
                        gZIPOutputStream.close();
                        base64OutputStream.close();
                        string = byteArrayOutputStream.toString("UTF-8");
                    } catch (Throwable th) {
                        try {
                            gZIPOutputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    try {
                        base64OutputStream.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                    throw th3;
                }
            } catch (Throwable th5) {
                throw th5;
            }
        }
        return string;
    }

    public static /* synthetic */ HeartBeatInfoStorage lambda$new$3(Context context, String str) {
        return new HeartBeatInfoStorage(context, str);
    }

    public /* synthetic */ Void lambda$registerHeartBeat$1() {
        synchronized (this) {
            this.storageProvider.get().storeHeartBeat(System.currentTimeMillis(), this.userAgentProvider.get().getUserAgent());
        }
        return null;
    }

    public static /* synthetic */ Thread lambda$static$0(Runnable runnable) {
        return new Thread(runnable, "heartbeat-information-executor");
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatInfo
    public synchronized HeartBeatInfo.HeartBeat getHeartBeatCode(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        HeartBeatInfoStorage heartBeatInfoStorage = this.storageProvider.get();
        if (!heartBeatInfoStorage.shouldSendGlobalHeartBeat(jCurrentTimeMillis)) {
            return HeartBeatInfo.HeartBeat.NONE;
        }
        heartBeatInfoStorage.postHeartBeatCleanUp();
        return HeartBeatInfo.HeartBeat.GLOBAL;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatController
    public Task getHeartBeatsHeader() {
        if (Build.VERSION.SDK_INT >= 24 ? UserManagerCompat$Api24Impl.isUserUnlocked(this.applicationContext) : true) {
            return WorkContinuation.call(new DefaultHeartBeatController$$ExternalSyntheticLambda1(this, 0), this.backgroundExecutor);
        }
        return WorkContinuation.forResult("");
    }

    public Task registerHeartBeat() {
        if (this.consumers.size() <= 0) {
            return WorkContinuation.forResult(null);
        }
        if (Build.VERSION.SDK_INT >= 24 ? UserManagerCompat$Api24Impl.isUserUnlocked(this.applicationContext) : true) {
            return WorkContinuation.call(new DefaultHeartBeatController$$ExternalSyntheticLambda1(this, 1), this.backgroundExecutor);
        }
        return WorkContinuation.forResult(null);
    }

    public DefaultHeartBeatController(Provider<HeartBeatInfoStorage> provider, Set<HeartBeatConsumer> set, Executor executor, Provider<UserAgentPublisher> provider2, Context context) {
        this.storageProvider = provider;
        this.consumers = set;
        this.backgroundExecutor = executor;
        this.userAgentProvider = provider2;
        this.applicationContext = context;
    }
}
