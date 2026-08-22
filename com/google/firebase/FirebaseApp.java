package com.google.firebase;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.os.UserManagerCompat$Api24Impl;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.util.Hex;
import com.google.firebase.auth.zzz;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentDiscovery;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.components.Lazy;
import com.google.firebase.events.Publisher;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import com.google.firebase.inject.Provider;
import com.google.firebase.internal.DataCollectionConfigStorage;
import com.google.firebase.tracing.ComponentMonitor;
import com.google.firebase.tracing.FirebaseTrace;
import com.pairip.VMRunner;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class FirebaseApp {
    public static final String DEFAULT_APP_NAME = "[DEFAULT]";
    private static final String FIREBASE_ANDROID = "fire-android";
    private static final String FIREBASE_COMMON = "fire-core";
    private static final String KOTLIN = "kotlin";
    private static final String LOG_TAG = "FirebaseApp";
    private final Context applicationContext;
    private final ComponentRuntime componentRuntime;
    private final Lazy<DataCollectionConfigStorage> dataCollectionConfigStorage;
    private final Provider<DefaultHeartBeatController> defaultHeartBeatController;
    private final String name;
    private final FirebaseOptions options;
    private static final Object LOCK = new Object();
    private static final Executor UI_EXECUTOR = new UiExecutor();
    static final Map<String, FirebaseApp> INSTANCES = new ArrayMap();
    private final AtomicBoolean automaticResourceManagementEnabled = new AtomicBoolean(false);
    private final AtomicBoolean deleted = new AtomicBoolean();
    private final List<BackgroundStateChangeListener> backgroundStateChangeListeners = new CopyOnWriteArrayList();
    private final List<FirebaseAppLifecycleListener> lifecycleListeners = new CopyOnWriteArrayList();

    public interface BackgroundStateChangeListener {
        void onBackgroundStateChanged(boolean z);
    }

    public final class GlobalBackgroundStateListener implements BackgroundDetector.BackgroundStateChangeListener {
        public static final AtomicReference INSTANCE = new AtomicReference();

        @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
        public final void onBackgroundStateChanged(boolean z) {
            synchronized (FirebaseApp.LOCK) {
                try {
                    for (FirebaseApp firebaseApp : new ArrayList(FirebaseApp.INSTANCES.values())) {
                        if (firebaseApp.automaticResourceManagementEnabled.get()) {
                            firebaseApp.notifyBackgroundStateChangeListeners(z);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final class UiExecutor implements Executor {
        public static final Handler HANDLER = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            HANDLER.post(runnable);
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public final class UserUnlockReceiver extends BroadcastReceiver {
        public static final AtomicReference INSTANCE = new AtomicReference();
        public final Context applicationContext;

        public UserUnlockReceiver(Context context) {
            this.applicationContext = context;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            VMRunner.invoke("lZ6k791zcllkLJkM", new Object[]{this, context, intent});
        }
    }

    public FirebaseApp(Context context, String str, FirebaseOptions firebaseOptions) {
        zzah.checkNotNull(context);
        this.applicationContext = context;
        zzah.checkNotEmpty(str);
        this.name = str;
        zzah.checkNotNull(firebaseOptions);
        this.options = firebaseOptions;
        FirebaseTrace.pushTrace("Firebase");
        FirebaseTrace.pushTrace("ComponentDiscovery");
        List<Provider<ComponentRegistrar>> listDiscoverLazy = ComponentDiscovery.forContext(context, ComponentDiscoveryService.class).discoverLazy();
        FirebaseTrace.popTrace();
        FirebaseTrace.pushTrace("Runtime");
        ComponentRuntime componentRuntimeBuild = ComponentRuntime.builder(UI_EXECUTOR).addLazyComponentRegistrars(listDiscoverLazy).addComponentRegistrar(new FirebaseCommonRegistrar()).addComponent(Component.of(context, Context.class, new Class[0])).addComponent(Component.of(this, FirebaseApp.class, new Class[0])).addComponent(Component.of(firebaseOptions, FirebaseOptions.class, new Class[0])).setProcessor(new ComponentMonitor()).build();
        this.componentRuntime = componentRuntimeBuild;
        FirebaseTrace.popTrace();
        this.dataCollectionConfigStorage = new Lazy<>((Provider) new FirebaseApp$$ExternalSyntheticLambda0(this, context, 0));
        this.defaultHeartBeatController = componentRuntimeBuild.getProvider(DefaultHeartBeatController.class);
        addBackgroundStateChangeListener(new BackgroundStateChangeListener() { // from class: com.google.firebase.FirebaseApp$$ExternalSyntheticLambda1
            @Override // com.google.firebase.FirebaseApp.BackgroundStateChangeListener
            public final void onBackgroundStateChanged(boolean z) {
                this.f$0.lambda$new$1(z);
            }
        });
        FirebaseTrace.popTrace();
    }

    private void checkNotDeleted() {
        zzah.checkState(!this.deleted.get(), "FirebaseApp was deleted");
    }

    public static void clearInstancesForTest() {
        synchronized (LOCK) {
            INSTANCES.clear();
        }
    }

    private static List<String> getAllAppNames() {
        ArrayList arrayList = new ArrayList();
        synchronized (LOCK) {
            try {
                Iterator<FirebaseApp> it = INSTANCES.values().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getName());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static List<FirebaseApp> getApps(Context context) {
        ArrayList arrayList;
        synchronized (LOCK) {
            arrayList = new ArrayList(INSTANCES.values());
        }
        return arrayList;
    }

    public static FirebaseApp getInstance() {
        FirebaseApp firebaseApp;
        synchronized (LOCK) {
            try {
                firebaseApp = INSTANCES.get(DEFAULT_APP_NAME);
                if (firebaseApp == null) {
                    throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + Hex.getMyProcessName() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return firebaseApp;
    }

    public void initializeAllApis() {
        if (Build.VERSION.SDK_INT >= 24 ? UserManagerCompat$Api24Impl.isUserUnlocked(this.applicationContext) : true) {
            Log.i(LOG_TAG, "Device unlocked: initializing all Firebase APIs for app " + getName());
            this.componentRuntime.initializeEagerComponents(isDefaultApp());
            this.defaultHeartBeatController.get().registerHeartBeat();
            return;
        }
        Log.i(LOG_TAG, "Device in Direct Boot Mode: postponing initialization of Firebase APIs for app " + getName());
        Context context = this.applicationContext;
        AtomicReference atomicReference = UserUnlockReceiver.INSTANCE;
        if (atomicReference.get() == null) {
            UserUnlockReceiver userUnlockReceiver = new UserUnlockReceiver(context);
            while (!atomicReference.compareAndSet(null, userUnlockReceiver)) {
                if (atomicReference.get() != null) {
                    return;
                }
            }
            context.registerReceiver(userUnlockReceiver, new IntentFilter("android.intent.action.USER_UNLOCKED"));
        }
    }

    public static FirebaseApp initializeApp(Context context) {
        synchronized (LOCK) {
            try {
                if (INSTANCES.containsKey(DEFAULT_APP_NAME)) {
                    return getInstance();
                }
                FirebaseOptions firebaseOptionsFromResource = FirebaseOptions.fromResource(context);
                if (firebaseOptionsFromResource == null) {
                    Log.w(LOG_TAG, "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                    return null;
                }
                return initializeApp(context, firebaseOptionsFromResource);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public /* synthetic */ DataCollectionConfigStorage lambda$new$0(Context context) {
        return new DataCollectionConfigStorage(context, getPersistenceKey(), (Publisher) this.componentRuntime.get(Publisher.class));
    }

    public /* synthetic */ void lambda$new$1(boolean z) {
        if (z) {
            return;
        }
        this.defaultHeartBeatController.get().registerHeartBeat();
    }

    private static String normalize(String str) {
        return str.trim();
    }

    public void notifyBackgroundStateChangeListeners(boolean z) {
        Log.d(LOG_TAG, "Notifying background state change listeners.");
        Iterator<BackgroundStateChangeListener> it = this.backgroundStateChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onBackgroundStateChanged(z);
        }
    }

    private void notifyOnAppDeleted() {
        Iterator<FirebaseAppLifecycleListener> it = this.lifecycleListeners.iterator();
        while (it.hasNext()) {
            it.next().onDeleted(this.name, this.options);
        }
    }

    public void addBackgroundStateChangeListener(BackgroundStateChangeListener backgroundStateChangeListener) {
        checkNotDeleted();
        if (this.automaticResourceManagementEnabled.get() && BackgroundDetector.getInstance().isInBackground()) {
            backgroundStateChangeListener.onBackgroundStateChanged(true);
        }
        this.backgroundStateChangeListeners.add(backgroundStateChangeListener);
    }

    public void addLifecycleEventListener(FirebaseAppLifecycleListener firebaseAppLifecycleListener) {
        checkNotDeleted();
        zzah.checkNotNull(firebaseAppLifecycleListener);
        this.lifecycleListeners.add(firebaseAppLifecycleListener);
    }

    public void delete() {
        if (this.deleted.compareAndSet(false, true)) {
            synchronized (LOCK) {
                INSTANCES.remove(this.name);
            }
            notifyOnAppDeleted();
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof FirebaseApp) {
            return this.name.equals(((FirebaseApp) obj).getName());
        }
        return false;
    }

    public <T> T get(Class<T> cls) {
        checkNotDeleted();
        return (T) this.componentRuntime.get(cls);
    }

    public Context getApplicationContext() {
        checkNotDeleted();
        return this.applicationContext;
    }

    public String getName() {
        checkNotDeleted();
        return this.name;
    }

    public FirebaseOptions getOptions() {
        checkNotDeleted();
        return this.options;
    }

    public String getPersistenceKey() {
        StringBuilder sb = new StringBuilder();
        byte[] bytes = getName().getBytes(Charset.defaultCharset());
        sb.append(bytes == null ? null : Base64.encodeToString(bytes, 11));
        sb.append("+");
        byte[] bytes2 = getOptions().getApplicationId().getBytes(Charset.defaultCharset());
        sb.append(bytes2 != null ? Base64.encodeToString(bytes2, 11) : null);
        return sb.toString();
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public void initializeAllComponents() {
        this.componentRuntime.initializeAllComponentsForTests();
    }

    public boolean isDataCollectionDefaultEnabled() {
        checkNotDeleted();
        return this.dataCollectionConfigStorage.get().isEnabled();
    }

    public boolean isDefaultApp() {
        return DEFAULT_APP_NAME.equals(getName());
    }

    public void removeBackgroundStateChangeListener(BackgroundStateChangeListener backgroundStateChangeListener) {
        checkNotDeleted();
        this.backgroundStateChangeListeners.remove(backgroundStateChangeListener);
    }

    public void removeLifecycleEventListener(FirebaseAppLifecycleListener firebaseAppLifecycleListener) {
        checkNotDeleted();
        zzah.checkNotNull(firebaseAppLifecycleListener);
        this.lifecycleListeners.remove(firebaseAppLifecycleListener);
    }

    public void setAutomaticResourceManagementEnabled(boolean z) {
        checkNotDeleted();
        if (this.automaticResourceManagementEnabled.compareAndSet(!z, z)) {
            boolean zIsInBackground = BackgroundDetector.getInstance().isInBackground();
            if (z && zIsInBackground) {
                notifyBackgroundStateChangeListeners(true);
            } else {
                if (z || !zIsInBackground) {
                    return;
                }
                notifyBackgroundStateChangeListeners(false);
            }
        }
    }

    public void setDataCollectionDefaultEnabled(Boolean bool) {
        checkNotDeleted();
        this.dataCollectionConfigStorage.get().setEnabled(bool);
    }

    public String toString() {
        zzz zzzVar = new zzz(this);
        zzzVar.add(this.name, "name");
        zzzVar.add(this.options, "options");
        return zzzVar.toString();
    }

    @Deprecated
    public void setDataCollectionDefaultEnabled(boolean z) {
        setDataCollectionDefaultEnabled(Boolean.valueOf(z));
    }

    public static FirebaseApp getInstance(String str) {
        FirebaseApp firebaseApp;
        String str2;
        synchronized (LOCK) {
            try {
                firebaseApp = INSTANCES.get(normalize(str));
                if (firebaseApp != null) {
                    firebaseApp.defaultHeartBeatController.get().registerHeartBeat();
                } else {
                    List<String> allAppNames = getAllAppNames();
                    if (allAppNames.isEmpty()) {
                        str2 = "";
                    } else {
                        str2 = "Available app names: " + TextUtils.join(", ", allAppNames);
                    }
                    throw new IllegalStateException("FirebaseApp with name " + str + " doesn't exist. " + str2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return firebaseApp;
    }

    public static String getPersistenceKey(String str, FirebaseOptions firebaseOptions) {
        StringBuilder sb = new StringBuilder();
        byte[] bytes = str.getBytes(Charset.defaultCharset());
        sb.append(bytes == null ? null : Base64.encodeToString(bytes, 11));
        sb.append("+");
        byte[] bytes2 = firebaseOptions.getApplicationId().getBytes(Charset.defaultCharset());
        sb.append(bytes2 != null ? Base64.encodeToString(bytes2, 11) : null);
        return sb.toString();
    }

    public static FirebaseApp initializeApp(Context context, FirebaseOptions firebaseOptions) {
        return initializeApp(context, firebaseOptions, DEFAULT_APP_NAME);
    }

    public static FirebaseApp initializeApp(Context context, FirebaseOptions firebaseOptions, String str) {
        FirebaseApp firebaseApp;
        AtomicReference atomicReference = GlobalBackgroundStateListener.INSTANCE;
        if (context.getApplicationContext() instanceof Application) {
            Application application = (Application) context.getApplicationContext();
            AtomicReference atomicReference2 = GlobalBackgroundStateListener.INSTANCE;
            if (atomicReference2.get() == null) {
                GlobalBackgroundStateListener globalBackgroundStateListener = new GlobalBackgroundStateListener();
                do {
                    if (atomicReference2.compareAndSet(null, globalBackgroundStateListener)) {
                        BackgroundDetector.initialize(application);
                        BackgroundDetector.getInstance().addListener(globalBackgroundStateListener);
                        break;
                    }
                } while (atomicReference2.get() == null);
            }
        }
        String strNormalize = normalize(str);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (LOCK) {
            Map<String, FirebaseApp> map = INSTANCES;
            zzah.checkState(!map.containsKey(strNormalize), "FirebaseApp name " + strNormalize + " already exists!");
            zzah.checkNotNull(context, "Application context cannot be null.");
            firebaseApp = new FirebaseApp(context, strNormalize, firebaseOptions);
            map.put(strNormalize, firebaseApp);
        }
        firebaseApp.initializeAllApis();
        return firebaseApp;
    }
}
