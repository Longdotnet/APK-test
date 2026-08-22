package androidx.emoji2.text;

import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.view.View;
import androidx.collection.ArraySet;
import androidx.room.RoomOpenHelper;
import androidx.work.InputMergerFactory$1;
import androidx.work.impl.foreground.SystemForegroundService;
import com.daerisoft.thespikerm.GamepadHandler_API19;
import com.daerisoft.thespikerm.RunnerKeyboardController;
import com.google.firebase.auth.zzaa;
import com.yoyogames.runner.RunnerJNILib;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.ExceptionsKt;
import kotlin.text.StringsKt__IndentKt;
import okhttp3.Dispatcher;

/* JADX INFO: loaded from: classes.dex */
public final class EmojiCompat {
    public static final Object INSTANCE_LOCK = new Object();
    public static volatile EmojiCompat sInstance;
    public final DefaultGlyphChecker mGlyphChecker;
    public final CompatInternal19 mHelper;
    public final ArraySet mInitCallbacks;
    public final ReentrantReadWriteLock mInitLock;
    public volatile int mLoadState;
    public final Handler mMainHandler;
    public final int mMetadataLoadStrategy;
    public final MetadataRepoLoader mMetadataLoader;
    public final InputMergerFactory$1 mSpanFactory;

    public final class CompatInternal19 {
        public final EmojiCompat mEmojiCompat;
        public volatile Dispatcher mMetadataRepo;
        public volatile zzaa mProcessor;

        /* JADX INFO: renamed from: androidx.emoji2.text.EmojiCompat$CompatInternal19$1, reason: invalid class name */
        public final class AnonymousClass1 extends ExceptionsKt {
            public AnonymousClass1() {
            }

            @Override // kotlin.ExceptionsKt
            public final void onFailed(Throwable th) {
                CompatInternal19.this.mEmojiCompat.onMetadataLoadFailed(th);
            }

            @Override // kotlin.ExceptionsKt
            public final void onLoaded(Dispatcher dispatcher) {
                CompatInternal19 compatInternal19 = CompatInternal19.this;
                compatInternal19.mMetadataRepo = dispatcher;
                Dispatcher dispatcher2 = compatInternal19.mMetadataRepo;
                EmojiCompat emojiCompat = compatInternal19.mEmojiCompat;
                compatInternal19.mProcessor = new zzaa(dispatcher2, emojiCompat.mSpanFactory, emojiCompat.mGlyphChecker, Build.VERSION.SDK_INT >= 34 ? EmojiExclusions$EmojiExclusions_Api34.getExclusions() : StringsKt__IndentKt.getExclusions());
                EmojiCompat emojiCompat2 = compatInternal19.mEmojiCompat;
                emojiCompat2.getClass();
                ArrayList arrayList = new ArrayList();
                emojiCompat2.mInitLock.writeLock().lock();
                try {
                    emojiCompat2.mLoadState = 1;
                    arrayList.addAll(emojiCompat2.mInitCallbacks);
                    emojiCompat2.mInitCallbacks.clear();
                    emojiCompat2.mInitLock.writeLock().unlock();
                    emojiCompat2.mMainHandler.post(new ListenerDispatcher(arrayList, emojiCompat2.mLoadState, (Throwable) null));
                } catch (Throwable th) {
                    emojiCompat2.mInitLock.writeLock().unlock();
                    throw th;
                }
            }
        }

        public CompatInternal19(EmojiCompat emojiCompat) {
            this.mEmojiCompat = emojiCompat;
        }
    }

    public abstract class InitCallback {
        public abstract void onInitialized();
    }

    public final class ListenerDispatcher implements Runnable {
        public final /* synthetic */ int $r8$classId;
        public final Object mInitCallbacks;
        public final int mLoadState;

        public /* synthetic */ ListenerDispatcher(Object obj, int i, int i2) {
            this.$r8$classId = i2;
            this.mInitCallbacks = obj;
            this.mLoadState = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            switch (this.$r8$classId) {
                case 0:
                    ArrayList arrayList = (ArrayList) this.mInitCallbacks;
                    int size = arrayList.size();
                    int i = 0;
                    if (this.mLoadState == 1) {
                        while (i < size) {
                            ((InitCallback) arrayList.get(i)).onInitialized();
                            i++;
                        }
                    } else {
                        while (i < size) {
                            ((InitCallback) arrayList.get(i)).getClass();
                            i++;
                        }
                    }
                    break;
                case 1:
                    ((SystemForegroundService) this.mInitCallbacks).mNotificationManager.cancel(this.mLoadState);
                    break;
                default:
                    RunnerKeyboardController runnerKeyboardController = (RunnerKeyboardController) this.mInitCallbacks;
                    int i2 = this.mLoadState;
                    if (i2 == 3) {
                        runnerKeyboardController.m_inputMethodManager.showSoftInput(runnerKeyboardController.m_editText, 0, runnerKeyboardController.m_virtualKeyboardVisibilityCheckAdjustReceiver);
                    } else if (i2 != 2) {
                        View view = runnerKeyboardController.m_activityView;
                        Rect rect = runnerKeyboardController.m_viewActiveRect;
                        view.getWindowVisibleDisplayFrame(rect);
                        int height = view.getHeight() - (rect.bottom - rect.top);
                        runnerKeyboardController.m_currentKeyboardHeight = height;
                        RunnerJNILib.OnVirtualKeyboardStatus(runnerKeyboardController.m_keyboardStatus, height);
                    } else {
                        runnerKeyboardController.m_inputMethodManager.hideSoftInputFromWindow(runnerKeyboardController.m_editText.getWindowToken(), 0, runnerKeyboardController.m_virtualKeyboardVisibilityCheckAdjustReceiver);
                    }
                    break;
            }
        }

        public ListenerDispatcher(List list, int i, Throwable th) {
            this.$r8$classId = 0;
            GamepadHandler_API19.checkNotNull(list, "initCallbacks cannot be null");
            this.mInitCallbacks = new ArrayList(list);
            this.mLoadState = i;
        }
    }

    public interface MetadataRepoLoader {
        void load(ExceptionsKt exceptionsKt);
    }

    public EmojiCompat(FontRequestEmojiCompatConfig fontRequestEmojiCompatConfig) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.mInitLock = reentrantReadWriteLock;
        this.mLoadState = 3;
        MetadataRepoLoader metadataRepoLoader = fontRequestEmojiCompatConfig.mMetadataLoader;
        this.mMetadataLoader = metadataRepoLoader;
        int i = fontRequestEmojiCompatConfig.mMetadataLoadStrategy;
        this.mMetadataLoadStrategy = i;
        this.mGlyphChecker = fontRequestEmojiCompatConfig.mGlyphChecker;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mInitCallbacks = new ArraySet(0);
        this.mSpanFactory = new InputMergerFactory$1(8);
        CompatInternal19 compatInternal19 = new CompatInternal19(this);
        this.mHelper = compatInternal19;
        reentrantReadWriteLock.writeLock().lock();
        if (i == 0) {
            try {
                this.mLoadState = 0;
            } catch (Throwable th) {
                this.mInitLock.writeLock().unlock();
                throw th;
            }
        }
        reentrantReadWriteLock.writeLock().unlock();
        if (getLoadState() == 0) {
            try {
                metadataRepoLoader.load(compatInternal19.new AnonymousClass1());
            } catch (Throwable th2) {
                onMetadataLoadFailed(th2);
            }
        }
    }

    public static EmojiCompat get() {
        EmojiCompat emojiCompat;
        synchronized (INSTANCE_LOCK) {
            try {
                emojiCompat = sInstance;
                if (!(emojiCompat != null)) {
                    throw new IllegalStateException("EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return emojiCompat;
    }

    public final int getLoadState() {
        this.mInitLock.readLock().lock();
        try {
            return this.mLoadState;
        } finally {
            this.mInitLock.readLock().unlock();
        }
    }

    public final void load() {
        if (!(this.mMetadataLoadStrategy == 1)) {
            throw new IllegalStateException("Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        }
        if (getLoadState() == 1) {
            return;
        }
        this.mInitLock.writeLock().lock();
        try {
            if (this.mLoadState == 0) {
                this.mInitLock.writeLock().unlock();
                return;
            }
            this.mLoadState = 0;
            this.mInitLock.writeLock().unlock();
            CompatInternal19 compatInternal19 = this.mHelper;
            EmojiCompat emojiCompat = compatInternal19.mEmojiCompat;
            try {
                emojiCompat.mMetadataLoader.load(compatInternal19.new AnonymousClass1());
            } catch (Throwable th) {
                emojiCompat.onMetadataLoadFailed(th);
            }
        } catch (Throwable th2) {
            this.mInitLock.writeLock().unlock();
            throw th2;
        }
    }

    public final void onMetadataLoadFailed(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.mInitLock.writeLock().lock();
        try {
            this.mLoadState = 2;
            arrayList.addAll(this.mInitCallbacks);
            this.mInitCallbacks.clear();
            this.mInitLock.writeLock().unlock();
            this.mMainHandler.post(new ListenerDispatcher(arrayList, this.mLoadState, th));
        } catch (Throwable th2) {
            this.mInitLock.writeLock().unlock();
            throw th2;
        }
    }

    public final CharSequence process(CharSequence charSequence, int i, int i2) {
        TypefaceEmojiSpan[] typefaceEmojiSpanArr;
        if (!(getLoadState() == 1)) {
            throw new IllegalStateException("Not initialized yet");
        }
        if (i < 0) {
            throw new IllegalArgumentException("start cannot be negative");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("end cannot be negative");
        }
        if (!(i <= i2)) {
            throw new IllegalArgumentException("start should be <= than end");
        }
        UnprecomputeTextOnModificationSpannable unprecomputeTextOnModificationSpannable = null;
        if (charSequence == null) {
            return null;
        }
        if (!(i <= charSequence.length())) {
            throw new IllegalArgumentException("start should be < than charSequence length");
        }
        if (!(i2 <= charSequence.length())) {
            throw new IllegalArgumentException("end should be < than charSequence length");
        }
        if (charSequence.length() == 0 || i == i2) {
            return charSequence;
        }
        zzaa zzaaVar = this.mHelper.mProcessor;
        zzaaVar.getClass();
        boolean z = charSequence instanceof SpannableBuilder;
        if (z) {
            ((SpannableBuilder) charSequence).blockWatchers();
        }
        if (z) {
            unprecomputeTextOnModificationSpannable = new UnprecomputeTextOnModificationSpannable((Spannable) charSequence);
        } else {
            try {
                if (charSequence instanceof Spannable) {
                    unprecomputeTextOnModificationSpannable = new UnprecomputeTextOnModificationSpannable((Spannable) charSequence);
                } else if ((charSequence instanceof Spanned) && ((Spanned) charSequence).nextSpanTransition(i - 1, i2 + 1, TypefaceEmojiSpan.class) <= i2) {
                    unprecomputeTextOnModificationSpannable = new UnprecomputeTextOnModificationSpannable();
                    unprecomputeTextOnModificationSpannable.mSafeToWrite = false;
                    unprecomputeTextOnModificationSpannable.mDelegate = new SpannableString(charSequence);
                }
            } finally {
                if (z) {
                    ((SpannableBuilder) charSequence).endBatchEdit();
                }
            }
        }
        if (unprecomputeTextOnModificationSpannable != null && (typefaceEmojiSpanArr = (TypefaceEmojiSpan[]) unprecomputeTextOnModificationSpannable.mDelegate.getSpans(i, i2, TypefaceEmojiSpan.class)) != null && typefaceEmojiSpanArr.length > 0) {
            for (TypefaceEmojiSpan typefaceEmojiSpan : typefaceEmojiSpanArr) {
                int spanStart = unprecomputeTextOnModificationSpannable.mDelegate.getSpanStart(typefaceEmojiSpan);
                int spanEnd = unprecomputeTextOnModificationSpannable.mDelegate.getSpanEnd(typefaceEmojiSpan);
                if (spanStart != i2) {
                    unprecomputeTextOnModificationSpannable.removeSpan(typefaceEmojiSpan);
                }
                i = Math.min(spanStart, i);
                i2 = Math.max(spanEnd, i2);
            }
        }
        int i3 = i;
        int i4 = i2;
        if (i3 != i4 && i3 < charSequence.length()) {
            UnprecomputeTextOnModificationSpannable unprecomputeTextOnModificationSpannable2 = (UnprecomputeTextOnModificationSpannable) zzaaVar.process(charSequence, i3, i4, Integer.MAX_VALUE, false, new RoomOpenHelper(unprecomputeTextOnModificationSpannable, (InputMergerFactory$1) zzaaVar.zza, 6, false));
            if (unprecomputeTextOnModificationSpannable2 != null) {
                return unprecomputeTextOnModificationSpannable2.mDelegate;
            }
            if (!z) {
                return charSequence;
            }
        } else if (!z) {
            return charSequence;
        }
        return charSequence;
    }

    public final void registerInitCallback(InitCallback initCallback) {
        GamepadHandler_API19.checkNotNull(initCallback, "initCallback cannot be null");
        this.mInitLock.writeLock().lock();
        try {
            if (this.mLoadState == 1 || this.mLoadState == 2) {
                this.mMainHandler.post(new ListenerDispatcher(Arrays.asList(initCallback), this.mLoadState, (Throwable) null));
            } else {
                this.mInitCallbacks.add(initCallback);
            }
        } finally {
            this.mInitLock.writeLock().unlock();
        }
    }
}
