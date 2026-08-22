package kotlin.jvm;

import android.os.Build;
import android.webkit.WebView;
import android.widget.EdgeEffect;
import androidx.concurrent.futures.AbstractResolvableFuture;
import androidx.core.widget.EdgeEffectCompat$Api21Impl;
import androidx.core.widget.EdgeEffectCompat$Api31Impl;
import androidx.webkit.internal.ApiHelperForP;
import com.facebook.appevents.aam.MetadataRule;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.platform.BouncyCastlePlatform;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class JvmClassMappingKt {
    public static final void access$log(Task task, TaskQueue taskQueue, String str) {
        TaskRunner.Companion.getClass();
        TaskRunner.logger.fine(taskQueue.name + ' ' + String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1)) + ": " + task.name);
    }

    public static void constructRules(JSONObject jSONObject) {
        Iterator itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String key = (String) itKeys.next();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(key);
            if (jSONObjectOptJSONObject != null) {
                String k = jSONObjectOptJSONObject.optString("k");
                String v = jSONObjectOptJSONObject.optString("v");
                Intrinsics.checkNotNullExpressionValue(k, "k");
                if (k.length() != 0) {
                    CopyOnWriteArraySet copyOnWriteArraySetAccess$getRules$cp = MetadataRule.access$getRules$cp();
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    List listSplit$default = StringsKt__StringsKt.split$default(k, new String[]{","}, 0, 6);
                    Intrinsics.checkNotNullExpressionValue(v, "v");
                    copyOnWriteArraySetAccess$getRules$cp.add(new MetadataRule(key, v, listSplit$default));
                }
            }
        }
    }

    public static InvocationHandler fetchGlueProviderFactoryImpl() {
        ClassLoader classLoader;
        if (Build.VERSION.SDK_INT >= 28) {
            classLoader = ApiHelperForP.getWebViewClassLoader();
        } else {
            try {
                Method declaredMethod = WebView.class.getDeclaredMethod("getFactory", null);
                declaredMethod.setAccessible(true);
                classLoader = declaredMethod.invoke(null, null).getClass().getClassLoader();
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e2) {
                throw new RuntimeException(e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException(e3);
            }
        }
        return (InvocationHandler) Class.forName("org.chromium.support_lib_glue.SupportLibReflectionUtil", false, classLoader).getDeclaredMethod("createWebViewProviderFactory", null).invoke(null, null);
    }

    public static int findMinimums(float[] fArr, int[] iArr, byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < 6; i2++) {
            int iCeil = (int) Math.ceil(fArr[i2]);
            iArr[i2] = iCeil;
            if (i > iCeil) {
                Arrays.fill(bArr, (byte) 0);
                i = iCeil;
            }
            if (i == iCeil) {
                bArr[i2] = (byte) (bArr[i2] + 1);
            }
        }
        return i;
    }

    public static final String formatDuration(long j) {
        String str;
        if (j <= -999500000) {
            str = ((j - ((long) 500000000)) / ((long) 1000000000)) + " s ";
        } else if (j <= -999500) {
            str = ((j - ((long) 500000)) / ((long) 1000000)) + " ms";
        } else if (j <= 0) {
            str = ((j - ((long) 500)) / ((long) 1000)) + " µs";
        } else if (j < 999500) {
            str = ((j + ((long) 500)) / ((long) 1000)) + " µs";
        } else if (j < 999500000) {
            str = ((j + ((long) 500000)) / ((long) 1000000)) + " ms";
        } else {
            str = ((j + ((long) 500000000)) / ((long) 1000000000)) + " s ";
        }
        return String.format("%6s", Arrays.copyOf(new Object[]{str}, 1));
    }

    public static float getDistance(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return EdgeEffectCompat$Api31Impl.getDistance(edgeEffect);
        }
        return 0.0f;
    }

    public static final Class getJavaObjectType(KClass kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Class jClass = ((ClassBasedDeclarationContainer) kClass).getJClass();
        if (!jClass.isPrimitive()) {
            return jClass;
        }
        String name = jClass.getName();
        switch (name.hashCode()) {
            case -1325958191:
                return !name.equals("double") ? jClass : Double.class;
            case 104431:
                return !name.equals("int") ? jClass : Integer.class;
            case 3039496:
                return !name.equals("byte") ? jClass : Byte.class;
            case 3052374:
                return !name.equals("char") ? jClass : Character.class;
            case 3327612:
                return !name.equals("long") ? jClass : Long.class;
            case 3625364:
                return !name.equals("void") ? jClass : Void.class;
            case 64711720:
                return !name.equals("boolean") ? jClass : Boolean.class;
            case 97526364:
                return !name.equals("float") ? jClass : Float.class;
            case 109413500:
                return !name.equals("short") ? jClass : Short.class;
            default:
                return jClass;
        }
    }

    public static void illegalCharacter(char c) {
        String hexString = Integer.toHexString(c);
        throw new IllegalArgumentException("Illegal character: " + c + " (0x" + ("0000".substring(0, 4 - hexString.length()) + hexString) + ')');
    }

    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean isExtendedASCII(char c) {
        return c >= 128 && c <= 255;
    }

    public static boolean isNativeX12(char c) {
        if (c == '\r' || c == '*' || c == '>' || c == ' ') {
            return true;
        }
        if (c < '0' || c > '9') {
            return c >= 'A' && c <= 'Z';
        }
        return true;
    }

    public static boolean isSupported() {
        return BouncyCastlePlatform.isSupported;
    }

    public static int lookAheadTest(CharSequence charSequence, int i, int i2) {
        float[] fArr;
        int i3;
        if (i >= charSequence.length()) {
            return i2;
        }
        int i4 = 0;
        int i5 = 6;
        float f = 2.0f;
        float f2 = 1.0f;
        if (i2 == 0) {
            fArr = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
        } else {
            fArr = new float[6];
            fArr[0] = 1.0f;
            fArr[1] = 2.0f;
            fArr[2] = 2.0f;
            fArr[3] = 2.0f;
            fArr[4] = 2.0f;
            fArr[5] = 2.25f;
            fArr[i2] = 0.0f;
        }
        int i6 = 0;
        while (true) {
            int i7 = i + i6;
            if (i7 == charSequence.length()) {
                byte[] bArr = new byte[i5];
                int[] iArr = new int[i5];
                int iFindMinimums = findMinimums(fArr, iArr, bArr);
                int i8 = i4;
                int i9 = i8;
                while (i8 < i5) {
                    i9 += bArr[i8];
                    i8++;
                }
                if (iArr[i4] == iFindMinimums) {
                    return i4;
                }
                if (i9 == 1 && bArr[5] > 0) {
                    return 5;
                }
                if (i9 == 1 && bArr[4] > 0) {
                    return 4;
                }
                if (i9 != 1 || bArr[2] <= 0) {
                    return (i9 != 1 || bArr[3] <= 0) ? 1 : 3;
                }
                return 2;
            }
            char cCharAt = charSequence.charAt(i7);
            i6++;
            if (isDigit(cCharAt)) {
                fArr[i4] = fArr[i4] + 0.5f;
            } else if (isExtendedASCII(cCharAt)) {
                float fCeil = (float) Math.ceil(fArr[i4]);
                fArr[i4] = fCeil;
                fArr[i4] = fCeil + f;
            } else {
                float fCeil2 = (float) Math.ceil(fArr[i4]);
                fArr[i4] = fCeil2;
                fArr[i4] = fCeil2 + f2;
            }
            if (cCharAt == ' ' || ((cCharAt >= '0' && cCharAt <= '9') || (cCharAt >= 'A' && cCharAt <= 'Z'))) {
                fArr[1] = fArr[1] + 0.6666667f;
            } else if (isExtendedASCII(cCharAt)) {
                fArr[1] = fArr[1] + 2.6666667f;
            } else {
                fArr[1] = fArr[1] + 1.3333334f;
            }
            if (cCharAt == ' ' || ((cCharAt >= '0' && cCharAt <= '9') || (cCharAt >= 'a' && cCharAt <= 'z'))) {
                fArr[2] = fArr[2] + 0.6666667f;
            } else if (isExtendedASCII(cCharAt)) {
                fArr[2] = fArr[2] + 2.6666667f;
            } else {
                fArr[2] = fArr[2] + 1.3333334f;
            }
            if (isNativeX12(cCharAt)) {
                fArr[3] = fArr[3] + 0.6666667f;
            } else if (isExtendedASCII(cCharAt)) {
                fArr[3] = fArr[3] + 4.3333335f;
            } else {
                fArr[3] = fArr[3] + 3.3333333f;
            }
            if (cCharAt >= ' ' && cCharAt <= '^') {
                fArr[4] = fArr[4] + 0.75f;
            } else if (isExtendedASCII(cCharAt)) {
                fArr[4] = fArr[4] + 4.25f;
            } else {
                fArr[4] = fArr[4] + 3.25f;
            }
            fArr[5] = fArr[5] + 1.0f;
            if (i6 >= 4) {
                int[] iArr2 = new int[6];
                byte[] bArr2 = new byte[6];
                findMinimums(fArr, iArr2, bArr2);
                int i10 = 0;
                for (int i11 = 0; i11 < 6; i11++) {
                    i10 += bArr2[i11];
                }
                i3 = 0;
                int i12 = iArr2[0];
                int i13 = iArr2[5];
                if (i12 < i13 && i12 < iArr2[1] && i12 < iArr2[2] && i12 < iArr2[3] && i12 < iArr2[4]) {
                    return 0;
                }
                if (i13 >= i12) {
                    byte b = bArr2[1];
                    byte b2 = bArr2[2];
                    byte b3 = bArr2[3];
                    byte b4 = bArr2[4];
                    if (b + b2 + b3 + b4 != 0) {
                        if (i10 == 1 && b4 > 0) {
                            return 4;
                        }
                        if (i10 == 1 && b2 > 0) {
                            return 2;
                        }
                        if (i10 == 1 && b3 > 0) {
                            return 3;
                        }
                        int i14 = iArr2[1];
                        int i15 = i14 + 1;
                        if (i15 < i12 && i15 < i13 && i15 < iArr2[4] && i15 < iArr2[2]) {
                            int i16 = iArr2[3];
                            if (i14 < i16) {
                                return 1;
                            }
                            if (i14 == i16) {
                                for (int i17 = i + i6 + 1; i17 < charSequence.length(); i17++) {
                                    char cCharAt2 = charSequence.charAt(i17);
                                    if (cCharAt2 == '\r' || cCharAt2 == '*' || cCharAt2 == '>') {
                                        return 3;
                                    }
                                    if (!isNativeX12(cCharAt2)) {
                                        break;
                                    }
                                }
                                return 1;
                            }
                        }
                    }
                }
                return 5;
            }
            i3 = 0;
            i4 = i3;
            i5 = 6;
            f = 2.0f;
            f2 = 1.0f;
        }
    }

    public static String mergeStrings(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb = new StringBuilder(str2.length() + str.length());
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (str2.length() > i) {
                sb.append(str2.charAt(i));
            }
        }
        return sb.toString();
    }

    public static float onPullDistance(EdgeEffect edgeEffect, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 31) {
            return EdgeEffectCompat$Api31Impl.onPullDistance(edgeEffect, f, f2);
        }
        EdgeEffectCompat$Api21Impl.onPull(edgeEffect, f, f2);
        return f;
    }

    public static int zza(int i) {
        int[] iArr = {1, 2, 3};
        for (int i2 = 0; i2 < 3; i2++) {
            int i3 = iArr[i2];
            int i4 = i3 - 1;
            if (i3 == 0) {
                throw null;
            }
            if (i4 == i) {
                return i3;
            }
        }
        return 1;
    }

    public abstract boolean casListeners(AbstractResolvableFuture abstractResolvableFuture, AbstractResolvableFuture.Listener listener, AbstractResolvableFuture.Listener listener2);

    public abstract boolean casValue(AbstractResolvableFuture abstractResolvableFuture, Object obj, Object obj2);

    public abstract boolean casWaiters(AbstractResolvableFuture abstractResolvableFuture, AbstractResolvableFuture.Waiter waiter, AbstractResolvableFuture.Waiter waiter2);

    public abstract void putNext(AbstractResolvableFuture.Waiter waiter, AbstractResolvableFuture.Waiter waiter2);

    public abstract void putThread(AbstractResolvableFuture.Waiter waiter, Thread thread);
}
