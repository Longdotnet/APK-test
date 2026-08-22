package androidx.emoji2.text;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import com.facebook.ProfileCache;
import com.yoyogames.runner.RunnerJNILib;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class EmojiCompatInitializer implements Initializer {
    @Override // androidx.startup.Initializer
    public final Object create(Context context) {
        FontRequestEmojiCompatConfig fontRequestEmojiCompatConfig = new FontRequestEmojiCompatConfig(new ProfileCache(context));
        fontRequestEmojiCompatConfig.mMetadataLoadStrategy = 1;
        if (EmojiCompat.sInstance == null) {
            synchronized (EmojiCompat.INSTANCE_LOCK) {
                try {
                    if (EmojiCompat.sInstance == null) {
                        EmojiCompat.sInstance = new EmojiCompat(fontRequestEmojiCompatConfig);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        delayUntilFirstResume(context);
        return Boolean.TRUE;
    }

    public final void delayUntilFirstResume(Context context) {
        Object objDoInitialize;
        AppInitializer appInitializer = AppInitializer.getInstance(context);
        appInitializer.getClass();
        synchronized (AppInitializer.sLock) {
            try {
                objDoInitialize = appInitializer.mInitialized.get(ProcessLifecycleInitializer.class);
                if (objDoInitialize == null) {
                    objDoInitialize = appInitializer.doInitialize(ProcessLifecycleInitializer.class, new HashSet());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        final Lifecycle lifecycle = ((LifecycleOwner) objDoInitialize).getLifecycle();
        lifecycle.addObserver(new DefaultLifecycleObserver() { // from class: androidx.emoji2.text.EmojiCompatInitializer.1
            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public final void onResume() {
                EmojiCompatInitializer.this.getClass();
                (Build.VERSION.SDK_INT >= 28 ? ConcurrencyHelpers$Handler28Impl.createAsync(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new RunnerJNILib.AnonymousClass1(1), 500L);
                lifecycle.removeObserver(this);
            }
        });
    }

    @Override // androidx.startup.Initializer
    public final List dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }
}
