package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.appcompat.widget.AppCompatTextHelper;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$ProviderResourceEntry;
import androidx.core.provider.FontRequestWorker;
import androidx.room.RoomOpenHelper;
import androidx.work.Worker;
import androidx.work.impl.WorkerWrapper;
import com.facebook.AccessTokenCache;
import com.facebook.GraphRequest$Companion$$ExternalSyntheticLambda1;
import com.google.android.gms.ads.jY.UUFMQdNK;
import com.google.android.gms.ads.zza;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.ExceptionsKt;
import okhttp3.Request;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TypefaceCompat {
    public static final LruCache sTypefaceCache;
    public static final ExceptionsKt sTypefaceCompatImpl;

    /* JADX WARN: Code duplicated, block: B:18:0x003f  */
    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            sTypefaceCompatImpl = new TypefaceCompatApi29Impl();
        } else if (i >= 28) {
            sTypefaceCompatImpl = new TypefaceCompatApi28Impl();
        } else if (i >= 26) {
            sTypefaceCompatImpl = new TypefaceCompatApi26Impl();
        } else if (i < 24) {
            sTypefaceCompatImpl = new TypefaceCompatApi21Impl();
        } else {
            Method method = TypefaceCompatApi24Impl.sAddFontWeightStyle;
            if (method == null) {
                Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
            }
            if (method != null) {
                sTypefaceCompatImpl = new TypefaceCompatApi24Impl();
            } else {
                sTypefaceCompatImpl = new TypefaceCompatApi21Impl();
            }
        }
        sTypefaceCache = new LruCache(16);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002f  */
    public static Typeface createFromResourcesFamilyXml(Context context, FontResourcesParserCompat$FamilyResourceEntry fontResourcesParserCompat$FamilyResourceEntry, Resources resources, int i, String str, int i2, int i3, AppCompatTextHelper.AnonymousClass1 anonymousClass1) {
        Typeface typefaceCreateFromFontFamilyFilesResourceEntry;
        Typeface typefaceCreate;
        Typeface typeface;
        int i4 = 1;
        int i5 = 0;
        if (fontResourcesParserCompat$FamilyResourceEntry instanceof FontResourcesParserCompat$ProviderResourceEntry) {
            FontResourcesParserCompat$ProviderResourceEntry fontResourcesParserCompat$ProviderResourceEntry = (FontResourcesParserCompat$ProviderResourceEntry) fontResourcesParserCompat$FamilyResourceEntry;
            String str2 = fontResourcesParserCompat$ProviderResourceEntry.mSystemFontFamilyName;
            typefaceCreateFromFontFamilyFilesResourceEntry = null;
            if (str2 == null || str2.isEmpty()) {
                typefaceCreate = null;
            } else {
                typefaceCreate = Typeface.create(str2, 0);
                Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
                if (typefaceCreate == null || typefaceCreate.equals(typefaceCreate2)) {
                    typefaceCreate = null;
                }
            }
            if (typefaceCreate != null) {
                new Handler(Looper.getMainLooper()).post(new GraphRequest$Companion$$ExternalSyntheticLambda1(anonymousClass1, typefaceCreate, 3));
                return typefaceCreate;
            }
            boolean z = fontResourcesParserCompat$ProviderResourceEntry.mStrategy == 0;
            int i6 = fontResourcesParserCompat$ProviderResourceEntry.mTimeoutMs;
            Handler handler = new Handler(Looper.getMainLooper());
            AccessTokenCache accessTokenCache = new AccessTokenCache(4, false);
            accessTokenCache.sharedPreferences = anonymousClass1;
            Request.Builder builder = fontResourcesParserCompat$ProviderResourceEntry.mRequest;
            RoomOpenHelper roomOpenHelper = new RoomOpenHelper(accessTokenCache, handler, 5, false);
            if (z) {
                LruCache lruCache = FontRequestWorker.sTypefaceCache;
                String str3 = ((String) builder.tags) + "-" + i3;
                typeface = (Typeface) FontRequestWorker.sTypefaceCache.get(str3);
                if (typeface != null) {
                    handler.post(new zza(accessTokenCache, typeface, 4));
                    typefaceCreateFromFontFamilyFilesResourceEntry = typeface;
                } else if (i6 == -1) {
                    FontRequestWorker.TypefaceResult fontSync = FontRequestWorker.getFontSync(str3, context, builder, i3);
                    roomOpenHelper.onTypefaceResult(fontSync);
                    typefaceCreateFromFontFamilyFilesResourceEntry = fontSync.mTypeface;
                } else {
                    try {
                        try {
                            FontRequestWorker.TypefaceResult typefaceResult = (FontRequestWorker.TypefaceResult) FontRequestWorker.DEFAULT_EXECUTOR_SERVICE.submit(new FontRequestWorker.AnonymousClass1(str3, context, builder, i3, 0)).get(i6, TimeUnit.MILLISECONDS);
                            roomOpenHelper.onTypefaceResult(typefaceResult);
                            typefaceCreateFromFontFamilyFilesResourceEntry = typefaceResult.mTypeface;
                        } catch (InterruptedException e) {
                            throw e;
                        } catch (ExecutionException e2) {
                            throw new RuntimeException(e2);
                        } catch (TimeoutException unused) {
                            throw new InterruptedException(UUFMQdNK.gLbupNyLNSa);
                        }
                    } catch (InterruptedException unused2) {
                        ((Handler) roomOpenHelper.mDelegate).post(new Worker.AnonymousClass1((AccessTokenCache) roomOpenHelper.mConfiguration, -3));
                    }
                }
            } else {
                LruCache lruCache2 = FontRequestWorker.sTypefaceCache;
                String str4 = ((String) builder.tags) + "-" + i3;
                typeface = (Typeface) FontRequestWorker.sTypefaceCache.get(str4);
                if (typeface != null) {
                    handler.post(new zza(accessTokenCache, typeface, 4));
                    typefaceCreateFromFontFamilyFilesResourceEntry = typeface;
                } else {
                    FontRequestWorker.AnonymousClass2 anonymousClass2 = new FontRequestWorker.AnonymousClass2(roomOpenHelper, i5);
                    synchronized (FontRequestWorker.LOCK) {
                        try {
                            SimpleArrayMap simpleArrayMap = FontRequestWorker.PENDING_REPLIES;
                            ArrayList arrayList = (ArrayList) simpleArrayMap.getOrDefault(str4, null);
                            if (arrayList != null) {
                                arrayList.add(anonymousClass2);
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(anonymousClass2);
                                simpleArrayMap.put(str4, arrayList2);
                                FontRequestWorker.AnonymousClass1 anonymousClass3 = new FontRequestWorker.AnonymousClass1(str4, context, builder, i3, 1);
                                ThreadPoolExecutor threadPoolExecutor = FontRequestWorker.DEFAULT_EXECUTOR_SERVICE;
                                FontRequestWorker.AnonymousClass2 anonymousClass4 = new FontRequestWorker.AnonymousClass2(str4, i4);
                                Handler handler2 = Looper.myLooper() == null ? new Handler(Looper.getMainLooper()) : new Handler();
                                WorkerWrapper.AnonymousClass1 anonymousClass5 = new WorkerWrapper.AnonymousClass1(1);
                                anonymousClass5.val$runExpedited = anonymousClass3;
                                anonymousClass5.val$future = anonymousClass4;
                                anonymousClass5.this$0 = handler2;
                                threadPoolExecutor.execute(anonymousClass5);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            }
        } else {
            typefaceCreateFromFontFamilyFilesResourceEntry = sTypefaceCompatImpl.createFromFontFamilyFilesResourceEntry(context, (FontResourcesParserCompat$FontFamilyFilesResourceEntry) fontResourcesParserCompat$FamilyResourceEntry, resources, i3);
            if (typefaceCreateFromFontFamilyFilesResourceEntry != null) {
                new Handler(Looper.getMainLooper()).post(new GraphRequest$Companion$$ExternalSyntheticLambda1(anonymousClass1, typefaceCreateFromFontFamilyFilesResourceEntry, 3));
            } else {
                anonymousClass1.callbackFailAsync();
            }
        }
        if (typefaceCreateFromFontFamilyFilesResourceEntry != null) {
            sTypefaceCache.put(createResourceUid(resources, i, str, i2, i3), typefaceCreateFromFontFamilyFilesResourceEntry);
        }
        return typefaceCreateFromFontFamilyFilesResourceEntry;
    }

    public static String createResourceUid(Resources resources, int i, String str, int i2, int i3) {
        return resources.getResourcePackageName(i) + '-' + str + '-' + i2 + '-' + i + '-' + i3;
    }
}
