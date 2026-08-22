package okhttp3;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.work.impl.WorkerWrapper;
import com.facebook.appevents.ml.MTensor;
import com.facebook.appevents.ml.Utils;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.client.zzc;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.common.stats.ZnFR.FKidOcdAYt;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzdso;
import com.google.android.gms.internal.ads.zzfcw;
import com.google.android.gms.internal.ads.zzfhz;
import com.google.gson.yWTz.kBfGXgdfpo;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class MediaType {
    public final String mediaType;
    public final String[] parameterNamesAndValues;
    public static final Pattern TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    public static final Pattern PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    public abstract class Companion implements ViewPropertyAnimatorListener {
        public static final void addmv(MTensor x, MTensor b) {
            if (CrashShieldHandler.isObjectCrashing(Companion.class)) {
                return;
            }
            try {
                Intrinsics.checkNotNullParameter(x, "x");
                Intrinsics.checkNotNullParameter(b, "b");
                int[] iArr = x.shape;
                int i = iArr[0];
                int i2 = iArr[1];
                int i3 = iArr[2];
                float[] fArr = x.data;
                float[] fArr2 = b.data;
                if (i <= 0) {
                    return;
                }
                int i4 = 0;
                while (true) {
                    int i5 = i4 + 1;
                    if (i2 > 0) {
                        int i6 = 0;
                        while (true) {
                            int i7 = i6 + 1;
                            if (i3 > 0) {
                                int i8 = 0;
                                while (true) {
                                    int i9 = i8 + 1;
                                    int i10 = (i6 * i3) + (i4 * i2 * i3) + i8;
                                    fArr[i10] = fArr[i10] + fArr2[i8];
                                    if (i9 >= i3) {
                                        break;
                                    } else {
                                        i8 = i9;
                                    }
                                }
                            }
                            if (i7 >= i2) {
                                break;
                            } else {
                                i6 = i7;
                            }
                        }
                    }
                    if (i5 >= i) {
                        return;
                    } else {
                        i4 = i5;
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(Companion.class, th);
            }
        }

        public static void checkNoOverflow(boolean z, String str, int i, int i2) {
            if (z) {
                return;
            }
            StringBuilder sb = new StringBuilder("overflow: ");
            sb.append(str);
            sb.append("(");
            sb.append(i);
            sb.append(", ");
            throw new ArithmeticException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(sb, i2, ")"));
        }

        public static final MTensor concatenate(MTensor[] mTensorArr) {
            int i;
            if (CrashShieldHandler.isObjectCrashing(Companion.class)) {
                return null;
            }
            int i2 = 0;
            try {
                int i3 = mTensorArr[0].shape[0];
                int length = mTensorArr.length - 1;
                if (length >= 0) {
                    int i4 = 0;
                    i = 0;
                    while (true) {
                        int i5 = i4 + 1;
                        i += mTensorArr[i4].shape[1];
                        if (i5 > length) {
                            break;
                        }
                        i4 = i5;
                    }
                } else {
                    i = 0;
                }
                MTensor mTensor = new MTensor(new int[]{i3, i});
                float[] fArr = mTensor.data;
                if (i3 > 0) {
                    int i6 = 0;
                    while (true) {
                        int i7 = i6 + 1;
                        int i8 = i6 * i;
                        int length2 = mTensorArr.length - 1;
                        if (length2 >= 0) {
                            int i9 = i2;
                            while (true) {
                                int i10 = i9 + 1;
                                MTensor mTensor2 = mTensorArr[i9];
                                float[] fArr2 = mTensor2.data;
                                int i11 = mTensor2.shape[1];
                                System.arraycopy(fArr2, i6 * i11, fArr, i8, i11);
                                i8 += i11;
                                if (i10 > length2) {
                                    break;
                                }
                                i9 = i10;
                            }
                        }
                        if (i7 >= i3) {
                            break;
                        }
                        i6 = i7;
                        i2 = 0;
                    }
                }
                return mTensor;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(Companion.class, th);
                return null;
            }
        }

        public static final MTensor conv1D(MTensor x, MTensor w) {
            Class<Companion> cls;
            MTensor mTensor;
            Class<Companion> cls2 = Companion.class;
            if (CrashShieldHandler.isObjectCrashing(cls2)) {
                return null;
            }
            try {
                Intrinsics.checkNotNullParameter(x, "x");
                Intrinsics.checkNotNullParameter(w, "w");
                int[] iArr = x.shape;
                int i = 0;
                int i2 = iArr[0];
                int i3 = iArr[1];
                int i4 = iArr[2];
                int[] iArr2 = w.shape;
                int i5 = iArr2[0];
                int i6 = (i3 - i5) + 1;
                int i7 = iArr2[2];
                MTensor mTensor2 = new MTensor(new int[]{i2, i6, i7});
                float[] fArr = x.data;
                float[] fArr2 = mTensor2.data;
                float[] fArr3 = w.data;
                if (i2 <= 0) {
                    return mTensor2;
                }
                int i8 = 0;
                while (true) {
                    int i9 = i8 + 1;
                    if (i7 > 0) {
                        int i10 = i;
                        while (true) {
                            int i11 = i10 + 1;
                            if (i6 > 0) {
                                int i12 = 0;
                                while (true) {
                                    int i13 = i12 + 1;
                                    float f = 0.0f;
                                    if (i5 > 0) {
                                        int i14 = 0;
                                        while (true) {
                                            cls = cls2;
                                            int i15 = i14 + 1;
                                            if (i4 > 0) {
                                                int i16 = 0;
                                                while (true) {
                                                    mTensor = mTensor2;
                                                    int i17 = i16 + 1;
                                                    try {
                                                        f = (fArr[((i14 + i12) * i4) + (i3 * i4 * i8) + i16] * fArr3[(((i14 * i4) + i16) * i7) + i10]) + f;
                                                        if (i17 >= i4) {
                                                            break;
                                                        }
                                                        i16 = i17;
                                                        mTensor2 = mTensor;
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        CrashShieldHandler.handleThrowable(cls, th);
                                                        return null;
                                                    }
                                                }
                                            } else {
                                                mTensor = mTensor2;
                                            }
                                            if (i15 >= i5) {
                                                break;
                                            }
                                            i14 = i15;
                                            cls2 = cls;
                                            mTensor2 = mTensor;
                                        }
                                    } else {
                                        cls = cls2;
                                        mTensor = mTensor2;
                                    }
                                    fArr2[(i12 * i7) + (i6 * i7 * i8) + i10] = f;
                                    if (i13 >= i6) {
                                        break;
                                    }
                                    i12 = i13;
                                    cls2 = cls;
                                    mTensor2 = mTensor;
                                }
                            } else {
                                cls = cls2;
                                mTensor = mTensor2;
                            }
                            if (i11 >= i7) {
                                break;
                            }
                            i10 = i11;
                            cls2 = cls;
                            mTensor2 = mTensor;
                        }
                    } else {
                        cls = cls2;
                        mTensor = mTensor2;
                    }
                    if (i9 >= i2) {
                        return mTensor;
                    }
                    i8 = i9;
                    cls2 = cls;
                    mTensor2 = mTensor;
                    i = 0;
                }
            } catch (Throwable th2) {
                th = th2;
                cls = cls2;
            }
        }

        public static final MTensor dense(MTensor x, MTensor w, MTensor b) {
            if (CrashShieldHandler.isObjectCrashing(Companion.class)) {
                return null;
            }
            try {
                Intrinsics.checkNotNullParameter(x, "x");
                Intrinsics.checkNotNullParameter(w, "w");
                Intrinsics.checkNotNullParameter(b, "b");
                int i = x.shape[0];
                int i2 = b.shape[0];
                MTensor mTensorMul = mul(x, w);
                float[] fArr = b.data;
                float[] fArr2 = mTensorMul.data;
                if (i > 0) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3 + 1;
                        if (i2 > 0) {
                            int i5 = 0;
                            while (true) {
                                int i6 = i5 + 1;
                                int i7 = (i3 * i2) + i5;
                                fArr2[i7] = fArr2[i7] + fArr[i5];
                                if (i6 >= i2) {
                                    break;
                                }
                                i5 = i6;
                            }
                        }
                        if (i4 >= i) {
                            break;
                        }
                        i3 = i4;
                    }
                }
                return mTensorMul;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(Companion.class, th);
                return null;
            }
        }

        public static final MTensor embedding(String[] strArr, MTensor w) {
            if (CrashShieldHandler.isObjectCrashing(Companion.class)) {
                return null;
            }
            try {
                Intrinsics.checkNotNullParameter(w, "w");
                int length = strArr.length;
                int i = w.shape[1];
                MTensor mTensor = new MTensor(new int[]{length, 128, i});
                float[] fArr = mTensor.data;
                float[] fArr2 = w.data;
                if (length > 0) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2 + 1;
                        int[] iArrVectorize = Utils.INSTANCE.vectorize(strArr[i2]);
                        int i4 = 0;
                        while (true) {
                            int i5 = i4 + 1;
                            System.arraycopy(fArr2, iArrVectorize[i4] * i, fArr, (i4 * i) + (i * 128 * i2), i);
                            if (i5 >= 128) {
                                break;
                            }
                            i4 = i5;
                        }
                        if (i3 >= length) {
                            break;
                        }
                        i2 = i3;
                    }
                }
                return mTensor;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(Companion.class, th);
                return null;
            }
        }

        public static final void flatten(MTensor x) {
            int i;
            if (CrashShieldHandler.isObjectCrashing(Companion.class)) {
                return;
            }
            try {
                Intrinsics.checkNotNullParameter(x, "x");
                int[] iArr = x.shape;
                if (1 >= iArr.length) {
                    return;
                }
                int length = iArr.length;
                if (1 < length) {
                    int i2 = 1;
                    i = 1;
                    while (true) {
                        int i3 = i2 + 1;
                        i *= x.shape[i2];
                        if (i3 >= length) {
                            break;
                        } else {
                            i2 = i3;
                        }
                    }
                } else {
                    i = 1;
                }
                int[] iArr2 = {x.shape[0], i};
                x.shape = iArr2;
                int iAccess$getCapacity = Utils.access$getCapacity(iArr2);
                float[] fArr = new float[iAccess$getCapacity];
                System.arraycopy(x.data, 0, fArr, 0, Math.min(x.capacity, iAccess$getCapacity));
                x.data = fArr;
                x.capacity = iAccess$getCapacity;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(Companion.class, th);
            }
        }

        public static MediaType get(String toMediaType) {
            Intrinsics.checkNotNullParameter(toMediaType, "$this$toMediaType");
            Matcher matcher = MediaType.TYPE_SUBTYPE.matcher(toMediaType);
            if (!matcher.lookingAt()) {
                throw new IllegalArgumentException(("No subtype found for: \"" + toMediaType + '\"').toString());
            }
            String strGroup = matcher.group(1);
            Intrinsics.checkNotNullExpressionValue(strGroup, "typeSubtype.group(1)");
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, "Locale.US");
            Intrinsics.checkNotNullExpressionValue(strGroup.toLowerCase(locale), "(this as java.lang.String).toLowerCase(locale)");
            String strGroup2 = matcher.group(2);
            Intrinsics.checkNotNullExpressionValue(strGroup2, "typeSubtype.group(2)");
            Intrinsics.checkNotNullExpressionValue(strGroup2.toLowerCase(locale), "(this as java.lang.String).toLowerCase(locale)");
            ArrayList arrayList = new ArrayList();
            Matcher matcher2 = MediaType.PARAMETER.matcher(toMediaType);
            int iEnd = matcher.end();
            while (iEnd < toMediaType.length()) {
                matcher2.region(iEnd, toMediaType.length());
                if (!matcher2.lookingAt()) {
                    StringBuilder sb = new StringBuilder("Parameter is not formatted correctly: \"");
                    String strSubstring = toMediaType.substring(iEnd);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
                    sb.append(strSubstring);
                    sb.append("\" for: \"");
                    sb.append(toMediaType);
                    sb.append('\"');
                    throw new IllegalArgumentException(sb.toString().toString());
                }
                String strGroup3 = matcher2.group(1);
                if (strGroup3 == null) {
                    iEnd = matcher2.end();
                } else {
                    String strGroup4 = matcher2.group(2);
                    if (strGroup4 == null) {
                        strGroup4 = matcher2.group(3);
                    } else if (StringsKt__StringsKt.startsWith(strGroup4, "'", false) && strGroup4.endsWith("'") && strGroup4.length() > 2) {
                        strGroup4 = strGroup4.substring(1, strGroup4.length() - 1);
                        Intrinsics.checkNotNullExpressionValue(strGroup4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    }
                    arrayList.add(strGroup3);
                    arrayList.add(strGroup4);
                    iEnd = matcher2.end();
                }
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                return new MediaType(toMediaType, (String[]) array);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        public static int getColumnIndexOrThrow(Cursor cursor, String str) {
            int columnIndex = cursor.getColumnIndex(str);
            if (columnIndex >= 0) {
                return columnIndex;
            }
            return cursor.getColumnIndexOrThrow("`" + str + "`");
        }

        public static String getNullableString$facebook_core_release(String str, JSONObject jSONObject) {
            if (jSONObject.has(str)) {
                return jSONObject.getString(str);
            }
            return null;
        }

        public static final MTensor maxPool1D(MTensor x, int i) {
            int i2;
            if (CrashShieldHandler.isObjectCrashing(Companion.class)) {
                return null;
            }
            try {
                Intrinsics.checkNotNullParameter(x, "x");
                int[] iArr = x.shape;
                int i3 = 0;
                int i4 = iArr[0];
                int i5 = iArr[1];
                int i6 = iArr[2];
                int i7 = (i5 - i) + 1;
                MTensor mTensor = new MTensor(new int[]{i4, i7, i6});
                float[] fArr = x.data;
                float[] fArr2 = mTensor.data;
                if (i4 > 0) {
                    int i8 = 0;
                    while (true) {
                        int i9 = i8 + 1;
                        if (i6 > 0) {
                            int i10 = i3;
                            while (true) {
                                int i11 = i10 + 1;
                                if (i7 > 0) {
                                    int i12 = i3;
                                    while (true) {
                                        int i13 = i12 + 1;
                                        int i14 = i12 * i6;
                                        int i15 = (i8 * i7 * i6) + i14 + i10;
                                        int i16 = (i8 * i5 * i6) + i14 + i10;
                                        fArr2[i15] = Float.MIN_VALUE;
                                        if (i > 0) {
                                            int i17 = 0;
                                            while (true) {
                                                int i18 = i17 + 1;
                                                i2 = i5;
                                                fArr2[i15] = Math.max(fArr2[i15], fArr[(i17 * i6) + i16]);
                                                if (i18 >= i) {
                                                    break;
                                                }
                                                i17 = i18;
                                                i5 = i2;
                                            }
                                        } else {
                                            i2 = i5;
                                        }
                                        if (i13 >= i7) {
                                            break;
                                        }
                                        i12 = i13;
                                        i5 = i2;
                                    }
                                } else {
                                    i2 = i5;
                                }
                                if (i11 >= i6) {
                                    break;
                                }
                                i10 = i11;
                                i5 = i2;
                                i3 = 0;
                            }
                        } else {
                            i2 = i5;
                        }
                        if (i9 >= i4) {
                            break;
                        }
                        i8 = i9;
                        i5 = i2;
                        i3 = 0;
                    }
                }
                return mTensor;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(Companion.class, th);
                return null;
            }
        }

        public static CoroutineContext minusKey(CoroutineContext.Element element, CoroutineContext.Key key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return Intrinsics.areEqual(element.getKey(), key) ? EmptyCoroutineContext.INSTANCE : element;
        }

        public static final MTensor mul(MTensor x, MTensor w) {
            if (CrashShieldHandler.isObjectCrashing(Companion.class)) {
                return null;
            }
            try {
                Intrinsics.checkNotNullParameter(x, "x");
                Intrinsics.checkNotNullParameter(w, "w");
                int i = 0;
                int i2 = x.shape[0];
                int[] iArr = w.shape;
                int i3 = iArr[0];
                int i4 = iArr[1];
                MTensor mTensor = new MTensor(new int[]{i2, i4});
                float[] fArr = x.data;
                float[] fArr2 = w.data;
                float[] fArr3 = mTensor.data;
                if (i2 > 0) {
                    int i5 = 0;
                    while (true) {
                        int i6 = i5 + 1;
                        if (i4 > 0) {
                            int i7 = i;
                            while (true) {
                                int i8 = i7 + 1;
                                int i9 = (i5 * i4) + i7;
                                fArr3[i9] = 0.0f;
                                if (i3 > 0) {
                                    int i10 = i;
                                    while (true) {
                                        int i11 = i10 + 1;
                                        fArr3[i9] = (fArr[(i5 * i3) + i10] * fArr2[(i10 * i4) + i7]) + fArr3[i9];
                                        if (i11 >= i3) {
                                            break;
                                        }
                                        i10 = i11;
                                    }
                                }
                                if (i8 >= i4) {
                                    break;
                                }
                                i7 = i8;
                                i = 0;
                            }
                        }
                        if (i6 >= i2) {
                            break;
                        }
                        i5 = i6;
                        i = 0;
                    }
                }
                return mTensor;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(Companion.class, th);
                return null;
            }
        }

        public static CoroutineContext plus(CoroutineContext.Element element, CoroutineContext context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return Headers.Companion.plus(element, context);
        }

        public static final void relu(MTensor x) {
            if (CrashShieldHandler.isObjectCrashing(Companion.class)) {
                return;
            }
            try {
                Intrinsics.checkNotNullParameter(x, "x");
                float[] fArr = x.data;
                int length = fArr.length - 1;
                if (length < 0) {
                    return;
                }
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    if (fArr[i] < 0.0f) {
                        fArr[i] = 0.0f;
                    }
                    if (i2 > length) {
                        return;
                    } else {
                        i = i2;
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(Companion.class, th);
            }
        }

        public static final void softmax(MTensor x) {
            if (CrashShieldHandler.isObjectCrashing(Companion.class)) {
                return;
            }
            try {
                Intrinsics.checkNotNullParameter(x, "x");
                int[] iArr = x.shape;
                int i = 0;
                int i2 = iArr[0];
                int i3 = iArr[1];
                float[] fArr = x.data;
                if (i2 <= 0) {
                    return;
                }
                while (true) {
                    int i4 = i + 1;
                    int i5 = i * i3;
                    int i6 = i5 + i3;
                    float f = Float.MIN_VALUE;
                    if (i5 < i6) {
                        int i7 = i5;
                        while (true) {
                            int i8 = i7 + 1;
                            float f2 = fArr[i7];
                            if (f2 > f) {
                                f = f2;
                            }
                            if (i8 >= i6) {
                                break;
                            } else {
                                i7 = i8;
                            }
                        }
                    }
                    float f3 = 0.0f;
                    if (i5 < i6) {
                        int i9 = i5;
                        while (true) {
                            int i10 = i9 + 1;
                            float fExp = (float) Math.exp(fArr[i9] - f);
                            fArr[i9] = fExp;
                            f3 += fExp;
                            if (i10 >= i6) {
                                break;
                            } else {
                                i9 = i10;
                            }
                        }
                    }
                    if (i5 < i6) {
                        while (true) {
                            int i11 = i5 + 1;
                            fArr[i5] = fArr[i5] / f3;
                            if (i11 >= i6) {
                                break;
                            } else {
                                i5 = i11;
                            }
                        }
                    }
                    if (i4 >= i2) {
                        return;
                    } else {
                        i = i4;
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(Companion.class, th);
            }
        }

        public static final MTensor transpose2D(MTensor mTensor) {
            if (CrashShieldHandler.isObjectCrashing(Companion.class)) {
                return null;
            }
            try {
                int[] iArr = mTensor.shape;
                int i = iArr[0];
                int i2 = iArr[1];
                MTensor mTensor2 = new MTensor(new int[]{i2, i});
                float[] fArr = mTensor.data;
                float[] fArr2 = mTensor2.data;
                if (i > 0) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3 + 1;
                        if (i2 > 0) {
                            int i5 = 0;
                            while (true) {
                                int i6 = i5 + 1;
                                fArr2[(i5 * i) + i3] = fArr[(i3 * i2) + i5];
                                if (i6 >= i2) {
                                    break;
                                }
                                i5 = i6;
                            }
                        }
                        if (i4 >= i) {
                            break;
                        }
                        i3 = i4;
                    }
                }
                return mTensor2;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(Companion.class, th);
                return null;
            }
        }

        public static final MTensor transpose3D(MTensor mTensor) {
            if (CrashShieldHandler.isObjectCrashing(Companion.class)) {
                return null;
            }
            try {
                int[] iArr = mTensor.shape;
                int i = iArr[0];
                int i2 = iArr[1];
                int i3 = iArr[2];
                MTensor mTensor2 = new MTensor(new int[]{i3, i2, i});
                float[] fArr = mTensor.data;
                float[] fArr2 = mTensor2.data;
                if (i > 0) {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4 + 1;
                        if (i2 > 0) {
                            int i6 = 0;
                            while (true) {
                                int i7 = i6 + 1;
                                if (i3 > 0) {
                                    int i8 = 0;
                                    while (true) {
                                        int i9 = i8 + 1;
                                        fArr2[(i6 * i) + (i8 * i * i2) + i4] = fArr[(i6 * i3) + (i4 * i2 * i3) + i8];
                                        if (i9 >= i3) {
                                            break;
                                        }
                                        i8 = i9;
                                    }
                                }
                                if (i7 >= i2) {
                                    break;
                                }
                                i6 = i7;
                            }
                        }
                        if (i5 >= i) {
                            break;
                        }
                        i4 = i5;
                    }
                }
                return mTensor2;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(Companion.class, th);
                return null;
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:36:0x006c  */
        public static String zzb(String str) {
            if (TextUtils.isEmpty(str)) {
                return "unspecified";
            }
            switch (str) {
                case "requester_type_0":
                    return "0";
                case "requester_type_1":
                    return "1";
                case "requester_type_2":
                    return "2";
                case "requester_type_3":
                    return "3";
                case "requester_type_4":
                    return "4";
                case "requester_type_5":
                    return "5";
                case "requester_type_6":
                    return "6";
                case "requester_type_7":
                    return "7";
                case "requester_type_8":
                    return "8";
                default:
                    return str;
            }
        }

        public static String zzc(zzm zzmVar) {
            Bundle bundle;
            return (zzmVar == null || (bundle = zzmVar.zzc) == null) ? "unspecified" : bundle.getString("query_info_type");
        }

        public static void zzd(zzdso zzdsoVar, String str, Pair... pairArr) {
            if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzhg)).booleanValue()) {
                zzcaf.zza.execute(new WorkerWrapper.AnonymousClass1(zzdsoVar, str, pairArr, 13, false));
            }
        }

        public static int zzg(zzfcw zzfcwVar) {
            if (zzfcwVar.zzr) {
                return 2;
            }
            zzm zzmVar = zzfcwVar.zzd;
            zzc zzcVar = zzmVar.zzs;
            String str = zzmVar.zzx;
            if (zzcVar == null && str == null) {
                return 1;
            }
            if (zzcVar == null || str == null) {
                return zzcVar != null ? 3 : 4;
            }
            return 5;
        }

        public boolean canReverse() {
            return false;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationCancel() {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart() {
        }

        public void reverse() {
        }

        public abstract void start();

        public abstract void stop();

        public static final String getCertificateHash(Context ctx) {
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            try {
                Signature[] signatureArr = ctx.getPackageManager().getPackageInfo(ctx.getPackageName(), 64).signatures;
                StringBuilder sb = new StringBuilder();
                MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                Intrinsics.checkNotNullExpressionValue(signatureArr, FKidOcdAYt.mxuAn);
                int length = signatureArr.length;
                int i = 0;
                while (i < length) {
                    Signature signature = signatureArr[i];
                    i++;
                    messageDigest.update(signature.toByteArray());
                    sb.append(Base64.encodeToString(messageDigest.digest(), 0));
                    sb.append(":");
                }
                if (sb.length() > 0) {
                    sb.setLength(sb.length() - 1);
                }
                String string = sb.toString();
                Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
                return string;
            } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException unused) {
                return "";
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:39:0x007c  */
        public static zzfhz zza(Bundle bundle) {
            Bundle bundle2 = bundle.getBundle(kBfGXgdfpo.vENboVZpfdF);
            if (bundle2 != null) {
                bundle = bundle2;
            }
            String string = bundle.getString("query_info_type");
            if (TextUtils.isEmpty(string)) {
                return zzfhz.SCAR_REQUEST_TYPE_UNSPECIFIED;
            }
            switch (string) {
                case "requester_type_0":
                    return zzfhz.SCAR_REQUEST_TYPE_ADMOB;
                case "requester_type_1":
                    return zzfhz.SCAR_REQUEST_TYPE_INBOUND_MEDIATION;
                case "requester_type_2":
                    return zzfhz.SCAR_REQUEST_TYPE_GBID;
                case "requester_type_3":
                    return zzfhz.SCAR_REQUEST_TYPE_GOLDENEYE;
                case "requester_type_4":
                    return zzfhz.SCAR_REQUEST_TYPE_YAVIN;
                case "requester_type_5":
                    return zzfhz.SCAR_REQUEST_TYPE_UNITY;
                case "requester_type_6":
                    return zzfhz.SCAR_REQUEST_TYPE_PAW;
                case "requester_type_7":
                    return zzfhz.SCAR_REQUEST_TYPE_GUILDER;
                case "requester_type_8":
                    return zzfhz.SCAR_REQUEST_TYPE_GAM_S2S;
                default:
                    return zzfhz.SCAR_REQUEST_TYPE_UNSPECIFIED;
            }
        }

        public static void checkNoOverflow(boolean z, String str, long j, long j2) {
            if (z) {
                return;
            }
            throw new ArithmeticException("overflow: " + str + "(" + j + ", " + j2 + ")");
        }

        public static CoroutineContext.Element get(CoroutineContext.Element element, CoroutineContext.Key key) {
            Intrinsics.checkNotNullParameter(key, "key");
            if (Intrinsics.areEqual(element.getKey(), key)) {
                return element;
            }
            return null;
        }
    }

    public MediaType(String str, String[] strArr) {
        this.mediaType = str;
        this.parameterNamesAndValues = strArr;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof MediaType) && Intrinsics.areEqual(((MediaType) obj).mediaType, this.mediaType);
    }

    public final int hashCode() {
        return this.mediaType.hashCode();
    }

    public final String toString() {
        return this.mediaType;
    }
}
