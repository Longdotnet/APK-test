package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import androidx.core.internal.view.Oteb.nYVxXTZQ;
import androidx.core.provider.FontProvider;
import androidx.core.provider.FontsContractCompat$FontInfo;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.work.InputMergerFactory$1;
import com.android.billingclient.api.zzda;
import com.daerisoft.thespikerm.GamepadHandler_API19;
import com.facebook.AccessTokenManager$$ExternalSyntheticLambda0;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.ExceptionsKt;
import okhttp3.Request;

/* JADX INFO: loaded from: classes.dex */
public final class FontRequestEmojiCompatConfig {
    public static final InputMergerFactory$1 DEFAULT_FONTS_CONTRACT = new InputMergerFactory$1(9);
    public final EmojiCompat.MetadataRepoLoader mMetadataLoader;
    public int mMetadataLoadStrategy = 0;
    public final DefaultGlyphChecker mGlyphChecker = new DefaultGlyphChecker();

    /* JADX INFO: loaded from: classes2.dex */
    public final class FontRequestMetadataLoader implements EmojiCompat.MetadataRepoLoader {
        public ExceptionsKt mCallback;
        public final Context mContext;
        public ThreadPoolExecutor mExecutor;
        public final InputMergerFactory$1 mFontProviderHelper;
        public final Object mLock;
        public Handler mMainHandler;
        public ThreadPoolExecutor mMyThreadPoolExecutor;
        public final Request.Builder mRequest;

        public FontRequestMetadataLoader(Context context, Request.Builder builder) {
            InputMergerFactory$1 inputMergerFactory$1 = FontRequestEmojiCompatConfig.DEFAULT_FONTS_CONTRACT;
            this.mLock = new Object();
            GamepadHandler_API19.checkNotNull(context, "Context cannot be null");
            this.mContext = context.getApplicationContext();
            this.mRequest = builder;
            this.mFontProviderHelper = inputMergerFactory$1;
        }

        public final void cleanUp() {
            synchronized (this.mLock) {
                try {
                    this.mCallback = null;
                    Handler handler = this.mMainHandler;
                    if (handler != null) {
                        handler.removeCallbacks(null);
                    }
                    this.mMainHandler = null;
                    ThreadPoolExecutor threadPoolExecutor = this.mMyThreadPoolExecutor;
                    if (threadPoolExecutor != null) {
                        threadPoolExecutor.shutdown();
                    }
                    this.mExecutor = null;
                    this.mMyThreadPoolExecutor = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoader
        public final void load(ExceptionsKt exceptionsKt) {
            synchronized (this.mLock) {
                this.mCallback = exceptionsKt;
            }
            loadInternal();
        }

        public final void loadInternal() {
            synchronized (this.mLock) {
                try {
                    if (this.mCallback == null) {
                        return;
                    }
                    if (this.mExecutor == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ConcurrencyHelpers$$ExternalSyntheticLambda0("emojiCompat"));
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        this.mMyThreadPoolExecutor = threadPoolExecutor;
                        this.mExecutor = threadPoolExecutor;
                    }
                    this.mExecutor.execute(new AccessTokenManager$$ExternalSyntheticLambda0(this, 5));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final FontsContractCompat$FontInfo retrieveFontInfo() {
            try {
                InputMergerFactory$1 inputMergerFactory$1 = this.mFontProviderHelper;
                Context context = this.mContext;
                Request.Builder builder = this.mRequest;
                inputMergerFactory$1.getClass();
                zzda fontFamilyResult = FontProvider.getFontFamilyResult(context, builder);
                int i = fontFamilyResult.zzb;
                if (i != 0) {
                    throw new RuntimeException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, nYVxXTZQ.AKWCMHWR, ")"));
                }
                FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArr = (FontsContractCompat$FontInfo[]) fontFamilyResult.zza;
                if (fontsContractCompat$FontInfoArr == null || fontsContractCompat$FontInfoArr.length == 0) {
                    throw new RuntimeException("fetchFonts failed (empty result)");
                }
                return fontsContractCompat$FontInfoArr[0];
            } catch (PackageManager.NameNotFoundException e) {
                throw new RuntimeException("provider not found", e);
            }
        }
    }

    public FontRequestEmojiCompatConfig(EmojiCompat.MetadataRepoLoader metadataRepoLoader) {
        this.mMetadataLoader = metadataRepoLoader;
    }
}
