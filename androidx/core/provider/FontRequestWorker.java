package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.util.Consumer;
import androidx.room.RoomOpenHelper;
import com.android.billingclient.api.zzda;
import com.google.android.gms.ads.nonagon.signalgeneration.zzau;
import com.google.android.gms.internal.ads.zzbze;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Request;

/* JADX INFO: loaded from: classes.dex */
public abstract class FontRequestWorker {
    public static final ThreadPoolExecutor DEFAULT_EXECUTOR_SERVICE;
    public static final Object LOCK;
    public static final SimpleArrayMap PENDING_REPLIES;
    public static final LruCache sTypefaceCache = new LruCache(16);

    /* JADX INFO: renamed from: androidx.core.provider.FontRequestWorker$1, reason: invalid class name */
    public final class AnonymousClass1 implements Callable {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object val$context;
        public final /* synthetic */ Object val$id;
        public final /* synthetic */ Object val$request;
        public final /* synthetic */ int val$style;

        public /* synthetic */ AnonymousClass1(zzau zzauVar, zzbze zzbzeVar, int i, Bundle bundle) {
            this.$r8$classId = 2;
            this.val$id = zzauVar;
            this.val$context = zzbzeVar;
            this.val$style = i;
            this.val$request = bundle;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            switch (this.$r8$classId) {
                case 0:
                    return FontRequestWorker.getFontSync((String) this.val$id, (Context) this.val$context, (Request.Builder) this.val$request, this.val$style);
                case 1:
                    try {
                        return FontRequestWorker.getFontSync((String) this.val$id, (Context) this.val$context, (Request.Builder) this.val$request, this.val$style);
                    } catch (Throwable unused) {
                        return new TypefaceResult(-3);
                    }
                default:
                    zzau zzauVar = (zzau) this.val$id;
                    Context context = zzauVar.zzg;
                    zzbze zzbzeVar = (zzbze) this.val$context;
                    return zzauVar.zzR(context, zzbzeVar.zza, zzbzeVar.zzb, zzbzeVar.zzc, zzbzeVar.zzd, this.val$style, zzbzeVar.zzf, (Bundle) this.val$request, zzbzeVar);
            }
        }

        public /* synthetic */ AnonymousClass1(String str, Context context, Request.Builder builder, int i, int i2) {
            this.$r8$classId = i2;
            this.val$id = str;
            this.val$context = context;
            this.val$request = builder;
            this.val$style = i;
        }
    }

    /* JADX INFO: renamed from: androidx.core.provider.FontRequestWorker$2, reason: invalid class name */
    public final class AnonymousClass2 implements Consumer {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object val$callback;

        public /* synthetic */ AnonymousClass2(Object obj, int i) {
            this.$r8$classId = i;
            this.val$callback = obj;
        }

        @Override // androidx.core.util.Consumer
        public final void accept(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    TypefaceResult typefaceResult = (TypefaceResult) obj;
                    if (typefaceResult == null) {
                        typefaceResult = new TypefaceResult(-3);
                    }
                    ((RoomOpenHelper) this.val$callback).onTypefaceResult(typefaceResult);
                    return;
                default:
                    TypefaceResult typefaceResult2 = (TypefaceResult) obj;
                    synchronized (FontRequestWorker.LOCK) {
                        try {
                            SimpleArrayMap simpleArrayMap = FontRequestWorker.PENDING_REPLIES;
                            ArrayList arrayList = (ArrayList) simpleArrayMap.getOrDefault((String) this.val$callback, null);
                            if (arrayList == null) {
                                return;
                            }
                            simpleArrayMap.remove((String) this.val$callback);
                            for (int i = 0; i < arrayList.size(); i++) {
                                ((Consumer) arrayList.get(i)).accept(typefaceResult2);
                            }
                            return;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
            }
        }
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 10000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new RequestExecutor$DefaultThreadFactory(0));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        DEFAULT_EXECUTOR_SERVICE = threadPoolExecutor;
        LOCK = new Object();
        PENDING_REPLIES = new SimpleArrayMap();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0020 A[EDGE_INSN: B:10:0x0020->B:24:0x003d BREAK  A[LOOP:0: B:17:0x002d->B:23:0x003a]] */
    public static TypefaceResult getFontSync(String str, Context context, Request.Builder builder, int i) {
        LruCache lruCache = sTypefaceCache;
        Typeface typeface = (Typeface) lruCache.get(str);
        if (typeface != null) {
            return new TypefaceResult(typeface);
        }
        try {
            zzda fontFamilyResult = FontProvider.getFontFamilyResult(context, builder);
            int i2 = 1;
            FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArr = (FontsContractCompat$FontInfo[]) fontFamilyResult.zza;
            int i3 = fontFamilyResult.zzb;
            if (i3 != 0) {
                if (i3 != 1) {
                    i2 = -3;
                    break;
                }
                i2 = -2;
            } else if (fontsContractCompat$FontInfoArr != null && fontsContractCompat$FontInfoArr.length != 0) {
                i2 = 0;
                for (FontsContractCompat$FontInfo fontsContractCompat$FontInfo : fontsContractCompat$FontInfoArr) {
                    int i4 = fontsContractCompat$FontInfo.mResultCode;
                    if (i4 != 0) {
                        if (i4 >= 0) {
                            i2 = i4;
                            break;
                        }
                        i2 = -3;
                        break;
                    }
                }
            }
            if (i2 != 0) {
                return new TypefaceResult(i2);
            }
            Typeface typefaceCreateFromFontInfo = TypefaceCompat.sTypefaceCompatImpl.createFromFontInfo(context, fontsContractCompat$FontInfoArr, i);
            if (typefaceCreateFromFontInfo == null) {
                return new TypefaceResult(-3);
            }
            lruCache.put(str, typefaceCreateFromFontInfo);
            return new TypefaceResult(typefaceCreateFromFontInfo);
        } catch (PackageManager.NameNotFoundException unused) {
            return new TypefaceResult(-1);
        }
    }

    public final class TypefaceResult {
        public final int mResult;
        public final Typeface mTypeface;

        public TypefaceResult(int i) {
            this.mTypeface = null;
            this.mResult = i;
        }

        public TypefaceResult(Typeface typeface) {
            this.mTypeface = typeface;
            this.mResult = 0;
        }
    }
}
