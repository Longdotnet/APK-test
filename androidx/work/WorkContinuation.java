package androidx.work;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.core.graphics.PathParser$PathDataNode;
import androidx.emoji2.text.DefaultEmojiCompatConfig$DefaultEmojiCompatConfigHelper_API28;
import androidx.emoji2.text.FontRequestEmojiCompatConfig;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.daerisoft.thespikerm.GamepadHandler_API19;
import com.facebook.AccessToken;
import com.facebook.AccessTokenCache;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest$Companion$$ExternalSyntheticLambda0;
import com.facebook.appevents.codeless.CodelessManager;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzc;
import com.google.android.gms.tasks.zzh;
import com.google.android.gms.tasks.zzt;
import com.google.android.gms.tasks.zzw;
import com.google.common.base.Splitter;
import com.google.protobuf.DescriptorProtos;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Protocol;
import okhttp3.Request;

/* JADX INFO: loaded from: classes.dex */
public abstract class WorkContinuation implements Writer {
    public static int appendPattern(boolean[] zArr, int i, int[] iArr, boolean z) {
        int i2 = 0;
        for (int i3 : iArr) {
            int i4 = 0;
            while (i4 < i3) {
                zArr[i] = z;
                i4++;
                i++;
            }
            i2 += i3;
            z = !z;
        }
        return i2;
    }

    public static Object await(Task task) throws InterruptedException {
        zzah.checkNotMainThread("Must not be called on the main application thread");
        zzah.checkNotGoogleApiHandlerThread();
        zzah.checkNotNull(task, "Task must not be null");
        if (task.isComplete()) {
            return zza(task);
        }
        AccessTokenCache accessTokenCache = new AccessTokenCache(27);
        zzt zztVar = TaskExecutors.zza;
        task.addOnSuccessListener(zztVar, accessTokenCache);
        task.addOnFailureListener(zztVar, accessTokenCache);
        zzw zzwVar = (zzw) task;
        zzwVar.zzb.zza(new zzh(zztVar, (OnCanceledListener) accessTokenCache));
        zzwVar.zzi();
        ((CountDownLatch) accessTokenCache.sharedPreferences).await();
        return zza(task);
    }

    public static GraphRequest buildAppIndexingRequest(String str, AccessToken accessToken, String str2) {
        String str3;
        String str4 = GraphRequest.MIME_BOUNDARY;
        GraphRequest graphRequestNewPostRequest = GraphRequest.Companion.newPostRequest(accessToken, String.format(Locale.US, "%s/app_indexing", Arrays.copyOf(new Object[]{str2}, 1)), null, null);
        Bundle bundle = graphRequestNewPostRequest.parameters;
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("tree", str);
        Context applicationContext = FacebookSdk.getApplicationContext();
        try {
            str3 = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).versionName;
            Intrinsics.checkNotNullExpressionValue(str3, "{\n      val packageInfo = context.packageManager.getPackageInfo(context.packageName, 0)\n      packageInfo.versionName\n    }");
        } catch (PackageManager.NameNotFoundException unused) {
            str3 = "";
        }
        bundle.putString("app_version", str3);
        bundle.putString("platform", "android");
        bundle.putString("request_type", "app_indexing");
        bundle.putString("device_session_id", CodelessManager.getCurrentDeviceSessionID$facebook_core_release());
        graphRequestNewPostRequest.parameters = bundle;
        graphRequestNewPostRequest.setCallback(new GraphRequest$Companion$$ExternalSyntheticLambda0(2));
        return graphRequestNewPostRequest;
    }

    public static zzw call(Callable callable, Executor executor) {
        zzah.checkNotNull(executor, "Executor must not be null");
        zzw zzwVar = new zzw();
        executor.execute(new zzc(zzwVar, callable, 14, false));
        return zzwVar;
    }

    public static boolean canMorph(PathParser$PathDataNode[] pathParser$PathDataNodeArr, PathParser$PathDataNode[] pathParser$PathDataNodeArr2) {
        if (pathParser$PathDataNodeArr == null || pathParser$PathDataNodeArr2 == null || pathParser$PathDataNodeArr.length != pathParser$PathDataNodeArr2.length) {
            return false;
        }
        for (int i = 0; i < pathParser$PathDataNodeArr.length; i++) {
            PathParser$PathDataNode pathParser$PathDataNode = pathParser$PathDataNodeArr[i];
            char c = pathParser$PathDataNode.mType;
            PathParser$PathDataNode pathParser$PathDataNode2 = pathParser$PathDataNodeArr2[i];
            if (c != pathParser$PathDataNode2.mType || pathParser$PathDataNode.mParams.length != pathParser$PathDataNode2.mParams.length) {
                return false;
            }
        }
        return true;
    }

    public static Object castToSuppLibClass(Class cls, InvocationHandler invocationHandler) {
        if (invocationHandler == null) {
            return null;
        }
        return cls.cast(Proxy.newProxyInstance(WorkContinuation.class.getClassLoader(), new Class[]{cls}, invocationHandler));
    }

    public static float[] copyOfRange(float[] fArr, int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int iMin = Math.min(i, length);
        float[] fArr2 = new float[i];
        System.arraycopy(fArr, 0, fArr2, 0, iMin);
        return fArr2;
    }

    public static FontRequestEmojiCompatConfig create(Context context) {
        ProviderInfo providerInfo;
        Request.Builder builder;
        ApplicationInfo applicationInfo;
        InputMergerFactory$1 defaultEmojiCompatConfig$DefaultEmojiCompatConfigHelper_API28 = Build.VERSION.SDK_INT >= 28 ? new DefaultEmojiCompatConfig$DefaultEmojiCompatConfigHelper_API28(7) : new InputMergerFactory$1(7);
        PackageManager packageManager = context.getPackageManager();
        GamepadHandler_API19.checkNotNull(packageManager, "Package manager required to locate emoji font provider");
        Iterator<ResolveInfo> it = packageManager.queryIntentContentProviders(new Intent("androidx.content.action.LOAD_EMOJI_FONT"), 0).iterator();
        while (true) {
            if (!it.hasNext()) {
                providerInfo = null;
                break;
            }
            providerInfo = it.next().providerInfo;
            if (providerInfo != null && (applicationInfo = providerInfo.applicationInfo) != null && (applicationInfo.flags & 1) == 1) {
                break;
            }
        }
        if (providerInfo == null) {
            builder = null;
        } else {
            try {
                String str = providerInfo.authority;
                String str2 = providerInfo.packageName;
                Signature[] signingSignatures = defaultEmojiCompatConfig$DefaultEmojiCompatConfigHelper_API28.getSigningSignatures(packageManager, str2);
                ArrayList arrayList = new ArrayList();
                for (Signature signature : signingSignatures) {
                    arrayList.add(signature.toByteArray());
                }
                builder = new Request.Builder(str, str2, "emojicompat-emoji-font", Collections.singletonList(arrayList));
            } catch (PackageManager.NameNotFoundException e) {
                Log.wtf("emoji2.text.DefaultEmojiConfig", e);
                builder = null;
            }
        }
        if (builder == null) {
            return null;
        }
        return new FontRequestEmojiCompatConfig(new FontRequestEmojiCompatConfig.FontRequestMetadataLoader(context, builder));
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002c  */
    /* JADX WARN: Code duplicated, block: B:17:0x0042  */
    /* JADX WARN: Code duplicated, block: B:41:0x0091  */
    /* JADX WARN: Code duplicated, block: B:46:0x009c A[Catch: NumberFormatException -> 0x00aa, TryCatch #0 {NumberFormatException -> 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:44:0x0096, B:46:0x009c, B:52:0x00b1, B:53:0x00b4), top: B:68:0x0054 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:52:0x00b1 A[Catch: NumberFormatException -> 0x00aa, TryCatch #0 {NumberFormatException -> 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:44:0x0096, B:46:0x009c, B:52:0x00b1, B:53:0x00b4), top: B:68:0x0054 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d7 A[SYNTHETIC] */
    public static PathParser$PathDataNode[] createNodesFromPathData(String str) {
        int i;
        String strTrim;
        float[] fArrCopyOfRange;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i4 < str.length()) {
            while (i4 < str.length()) {
                char cCharAt = str.charAt(i4);
                if ((cCharAt - 'Z') * (cCharAt - 'A') > 0) {
                    if ((cCharAt - 'z') * (cCharAt - 'a') > 0) {
                        continue;
                    } else if (cCharAt != 'e' && cCharAt != 'E') {
                        strTrim = str.substring(i3, i4).trim();
                        if (strTrim.isEmpty()) {
                            if (strTrim.charAt(i2) != 'z' || strTrim.charAt(i2) == 'Z') {
                                fArrCopyOfRange = new float[i2];
                            } else {
                                try {
                                    float[] fArr = new float[strTrim.length()];
                                    int length = strTrim.length();
                                    int i5 = i2;
                                    int i6 = 1;
                                    while (i6 < length) {
                                        int i7 = i2;
                                        int i8 = i7;
                                        int i9 = i8;
                                        int i10 = i9;
                                        for (int i11 = i6; i11 < strTrim.length(); i11++) {
                                            char cCharAt2 = strTrim.charAt(i11);
                                            if (cCharAt2 == ' ') {
                                                i7 = 0;
                                                i9 = 1;
                                            } else if (cCharAt2 != 'E' && cCharAt2 != 'e') {
                                                switch (cCharAt2) {
                                                    case DescriptorProtos.FileOptions.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                                                        i7 = 0;
                                                        i9 = 1;
                                                        break;
                                                    case DescriptorProtos.FileOptions.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                                                        if (i11 == i6 || i7 != 0) {
                                                            i7 = 0;
                                                        } else {
                                                            i7 = 0;
                                                            i9 = 1;
                                                            i10 = 1;
                                                        }
                                                        break;
                                                    case '.':
                                                        if (i8 == 0) {
                                                            i7 = 0;
                                                            i8 = 1;
                                                        } else {
                                                            i7 = 0;
                                                            i9 = 1;
                                                            i10 = 1;
                                                        }
                                                        break;
                                                    default:
                                                        i7 = 0;
                                                        break;
                                                }
                                            } else {
                                                i7 = 1;
                                            }
                                            if (i9 != 0) {
                                                if (i6 < i11) {
                                                    fArr[i5] = Float.parseFloat(strTrim.substring(i6, i11));
                                                    i5++;
                                                }
                                                if (i10 != 0) {
                                                    i6 = i11;
                                                } else {
                                                    i6 = i11 + 1;
                                                }
                                                i2 = 0;
                                            }
                                        }
                                        if (i6 < i11) {
                                            fArr[i5] = Float.parseFloat(strTrim.substring(i6, i11));
                                            i5++;
                                        }
                                        if (i10 != 0) {
                                            i6 = i11;
                                        } else {
                                            i6 = i11 + 1;
                                        }
                                        i2 = 0;
                                    }
                                    fArrCopyOfRange = copyOfRange(fArr, i5);
                                    i2 = 0;
                                } catch (NumberFormatException e) {
                                    throw new RuntimeException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("error in parsing \"", strTrim, "\""), e);
                                }
                            }
                            arrayList.add(new PathParser$PathDataNode(strTrim.charAt(i2), fArrCopyOfRange));
                        }
                        i3 = i4;
                        i4++;
                        i2 = 0;
                    }
                } else if (cCharAt != 'e') {
                    continue;
                }
                i4++;
            }
            strTrim = str.substring(i3, i4).trim();
            if (strTrim.isEmpty()) {
                if (strTrim.charAt(i2) != 'z') {
                    fArrCopyOfRange = new float[i2];
                } else {
                    fArrCopyOfRange = new float[i2];
                }
                arrayList.add(new PathParser$PathDataNode(strTrim.charAt(i2), fArrCopyOfRange));
            }
            i3 = i4;
            i4++;
            i2 = 0;
        }
        if (i4 - i3 != 1 || i3 >= str.length()) {
            i = 0;
        } else {
            i = 0;
            arrayList.add(new PathParser$PathDataNode(str.charAt(i3), new float[0]));
        }
        return (PathParser$PathDataNode[]) arrayList.toArray(new PathParser$PathDataNode[i]);
    }

    public static PathParser$PathDataNode[] deepCopyNodes(PathParser$PathDataNode[] pathParser$PathDataNodeArr) {
        PathParser$PathDataNode[] pathParser$PathDataNodeArr2 = new PathParser$PathDataNode[pathParser$PathDataNodeArr.length];
        for (int i = 0; i < pathParser$PathDataNodeArr.length; i++) {
            pathParser$PathDataNodeArr2[i] = new PathParser$PathDataNode(pathParser$PathDataNodeArr[i]);
        }
        return pathParser$PathDataNodeArr2;
    }

    public static zzw forException(Exception exc) {
        zzw zzwVar = new zzw();
        zzwVar.zza(exc);
        return zzwVar;
    }

    public static zzw forResult(Object obj) {
        zzw zzwVar = new zzw();
        zzwVar.zzb(obj);
        return zzwVar;
    }

    public static Splitter parse(String statusLine) throws ProtocolException {
        int i;
        String strSubstring;
        Intrinsics.checkNotNullParameter(statusLine, "statusLine");
        boolean zStartsWith = StringsKt__StringsKt.startsWith(statusLine, "HTTP/1.", false);
        Protocol protocol = Protocol.HTTP_1_0;
        if (zStartsWith) {
            i = 9;
            if (statusLine.length() < 9 || statusLine.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: ".concat(statusLine));
            }
            int iCharAt = statusLine.charAt(7) - '0';
            if (iCharAt != 0) {
                if (iCharAt != 1) {
                    throw new ProtocolException("Unexpected status line: ".concat(statusLine));
                }
                protocol = Protocol.HTTP_1_1;
            }
        } else {
            if (!StringsKt__StringsKt.startsWith(statusLine, "ICY ", false)) {
                throw new ProtocolException("Unexpected status line: ".concat(statusLine));
            }
            i = 4;
        }
        int i2 = i + 3;
        if (statusLine.length() < i2) {
            throw new ProtocolException("Unexpected status line: ".concat(statusLine));
        }
        try {
            String strSubstring2 = statusLine.substring(i, i2);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            int i3 = Integer.parseInt(strSubstring2);
            if (statusLine.length() <= i2) {
                strSubstring = "";
            } else {
                if (statusLine.charAt(i2) != ' ') {
                    throw new ProtocolException("Unexpected status line: ".concat(statusLine));
                }
                strSubstring = statusLine.substring(i + 4);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
            }
            return new Splitter(protocol, i3, strSubstring);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: ".concat(statusLine));
        }
    }

    public static Object zza(Task task) throws ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        if (((zzw) task).zzd) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(task.getException());
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, int i, EnumMap enumMap) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        int defaultMargin = getDefaultMargin();
        EncodeHintType encodeHintType = EncodeHintType.MARGIN;
        if (enumMap.containsKey(encodeHintType)) {
            defaultMargin = Integer.parseInt(enumMap.get(encodeHintType).toString());
        }
        boolean[] zArrEncode = encode(str);
        int length = zArrEncode.length;
        int i2 = defaultMargin + length;
        int iMax = Math.max(200, i2);
        int iMax2 = Math.max(1, 200);
        int i3 = iMax / i2;
        int i4 = (iMax - (length * i3)) / 2;
        BitMatrix bitMatrix = new BitMatrix(iMax, iMax2);
        int i5 = 0;
        while (i5 < length) {
            if (zArrEncode[i5]) {
                bitMatrix.setRegion(i4, 0, i3, iMax2);
            }
            i5++;
            i4 += i3;
        }
        return bitMatrix;
    }

    public abstract boolean[] encode(String str);

    public int getDefaultMargin() {
        return 10;
    }

    public static boolean zza(Bundle bundle, Bundle bundle2) {
        if (bundle != null && bundle2 != null) {
            if (bundle.size() != bundle2.size()) {
                return false;
            }
            for (String str : bundle.keySet()) {
                if (!bundle2.containsKey(str)) {
                    return false;
                }
                Object obj = bundle.get(str);
                Object obj2 = bundle2.get(str);
                if (obj == null || obj2 == null) {
                    bundle2 = obj2;
                    bundle = obj;
                } else if (obj instanceof Bundle) {
                    if (!(obj2 instanceof Bundle) || !zza((Bundle) obj, (Bundle) obj2)) {
                        return false;
                    }
                } else if (obj.getClass().isArray()) {
                    int length = Array.getLength(obj);
                    if (!obj2.getClass().isArray() || length != Array.getLength(obj2)) {
                        return false;
                    }
                    for (int i = 0; i < length; i++) {
                        if (!zzah.equal(Array.get(obj, i), Array.get(obj2, i))) {
                            return false;
                        }
                    }
                } else if (!obj.equals(obj2)) {
                    return false;
                }
            }
            return true;
        }
        return bundle == null && bundle2 == null;
    }

    public static Object await(Task task, TimeUnit timeUnit) throws TimeoutException {
        zzah.checkNotMainThread("Must not be called on the main application thread");
        zzah.checkNotGoogleApiHandlerThread();
        zzah.checkNotNull(task, "Task must not be null");
        zzah.checkNotNull(timeUnit, "TimeUnit must not be null");
        if (task.isComplete()) {
            return zza(task);
        }
        AccessTokenCache accessTokenCache = new AccessTokenCache(27);
        zzt zztVar = TaskExecutors.zza;
        task.addOnSuccessListener(zztVar, accessTokenCache);
        task.addOnFailureListener(zztVar, accessTokenCache);
        zzw zzwVar = (zzw) task;
        zzwVar.zzb.zza(new zzh(zztVar, (OnCanceledListener) accessTokenCache));
        zzwVar.zzi();
        if (((CountDownLatch) accessTokenCache.sharedPreferences).await(30000L, timeUnit)) {
            return zza(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }
}
