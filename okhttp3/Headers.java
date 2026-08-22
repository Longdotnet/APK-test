package okhttp3;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$SafeFuture;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.view.KeyEventDispatcher$Component;
import androidx.core.view.ViewCompat;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.android.billingclient.api.BillingResult;
import com.daerisoft.thespikerm.R;
import com.facebook.AccessToken;
import com.facebook.AccessTokenManager;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.LoginFragment$getLoginMethodHandlerCallback$1;
import com.google.android.gms.common.stats.ZnFR.FKidOcdAYt;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.analytics.connector.pDv.PZmDzEagKNdW;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.WeakHashMap;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.ArrayIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.DeferredCoroutine;
import okhttp3.internal.Util;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class Headers implements Iterable, KMappedMarker {
    public final String[] namesAndValues;

    public final class Builder {
        public final ArrayList namesAndValues;

        public Builder(BillingResult billingResult, ArrayList arrayList) {
            this.namesAndValues = arrayList;
        }

        public void addLenient$okhttp(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            ArrayList arrayList = this.namesAndValues;
            arrayList.add(name);
            arrayList.add(StringsKt__StringsKt.trim(value).toString());
        }

        public Headers build() {
            Object[] array = this.namesAndValues.toArray(new String[0]);
            if (array != null) {
                return new Headers((String[]) array);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        public void removeAll(String str) {
            int i = 0;
            while (true) {
                ArrayList arrayList = this.namesAndValues;
                if (i >= arrayList.size()) {
                    return;
                }
                if (str.equalsIgnoreCase((String) arrayList.get(i))) {
                    arrayList.remove(i);
                    arrayList.remove(i);
                    i -= 2;
                }
                i += 2;
            }
        }

        public Builder() {
            this.namesAndValues = new ArrayList(20);
        }
    }

    public abstract class Companion {
        public static boolean sActionBarFieldsFetched;
        public static Method sActionBarOnMenuKeyMethod;
        public static boolean sDialogFieldsFetched;
        public static Field sDialogKeyListenerField;

        public static CallbackToFutureAdapter$SafeFuture asListenableFuture$default(DeferredCoroutine deferredCoroutine) {
            CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = new CallbackToFutureAdapter$Completer();
            callbackToFutureAdapter$Completer.cancellationFuture = new ResolvableFuture();
            CallbackToFutureAdapter$SafeFuture callbackToFutureAdapter$SafeFuture = new CallbackToFutureAdapter$SafeFuture(callbackToFutureAdapter$Completer);
            callbackToFutureAdapter$Completer.future = callbackToFutureAdapter$SafeFuture;
            callbackToFutureAdapter$Completer.tag = CoroutineAdapterKt$$ExternalSyntheticLambda0.class;
            try {
                deferredCoroutine.invokeOnCompletion(false, true, new LoginFragment$getLoginMethodHandlerCallback$1(callbackToFutureAdapter$Completer, deferredCoroutine, 1));
                callbackToFutureAdapter$Completer.tag = "Deferred.asListenableFuture";
            } catch (Exception e) {
                callbackToFutureAdapter$SafeFuture.delegate.setException(e);
            }
            return callbackToFutureAdapter$SafeFuture;
        }

        public static void checkName(String str) {
            if (str.length() <= 0) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if ('!' > cCharAt || '~' < cCharAt) {
                    throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str).toString());
                }
            }
        }

        public static void checkValue(String str, String str2) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt != '\t' && (' ' > cCharAt || '~' < cCharAt)) {
                    throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str2, str).toString());
                }
            }
        }

        public static long checkedAdd(long j, long j2) {
            long j3 = j + j2;
            MediaType.Companion.checkNoOverflow(((j ^ j2) < 0) | ((j ^ j3) >= 0), "checkedAdd", j, j2);
            return j3;
        }

        public static long checkedMultiply(long j, long j2) {
            int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(~j2) + Long.numberOfLeadingZeros(j2) + Long.numberOfLeadingZeros(~j) + Long.numberOfLeadingZeros(j);
            if (iNumberOfLeadingZeros > 65) {
                return j * j2;
            }
            MediaType.Companion.checkNoOverflow(iNumberOfLeadingZeros >= 64, "checkedMultiply", j, j2);
            MediaType.Companion.checkNoOverflow((j >= 0) | (j2 != Long.MIN_VALUE), "checkedMultiply", j, j2);
            long j3 = j * j2;
            MediaType.Companion.checkNoOverflow(j == 0 || j3 / j == j2, "checkedMultiply", j, j2);
            return j3;
        }

        public static long checkedSubtract(long j, long j2) {
            long j3 = j - j2;
            MediaType.Companion.checkNoOverflow(((j ^ j2) >= 0) | ((j ^ j3) >= 0), "checkedSubtract", j, j2);
            return j3;
        }

        public static final void deleteFile(String str) {
            File instrumentReportDir = getInstrumentReportDir();
            if (instrumentReportDir == null || str == null) {
                return;
            }
            new File(instrumentReportDir, str).delete();
        }

        public static boolean dispatchBeforeHierarchy(View view, KeyEvent keyEvent) {
            ArrayList arrayList;
            int size;
            int iIndexOfKey;
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            if (Build.VERSION.SDK_INT >= 28) {
                return false;
            }
            ArrayList arrayList2 = ViewCompat.UnhandledKeyEventManager.sViewsWithListeners;
            ViewCompat.UnhandledKeyEventManager unhandledKeyEventManager = (ViewCompat.UnhandledKeyEventManager) view.getTag(R.id.tag_unhandled_key_event_manager);
            WeakReference weakReference = null;
            if (unhandledKeyEventManager == null) {
                unhandledKeyEventManager = new ViewCompat.UnhandledKeyEventManager();
                unhandledKeyEventManager.mViewsContainingListeners = null;
                unhandledKeyEventManager.mCapturedKeys = null;
                unhandledKeyEventManager.mLastDispatchedPreViewKeyEvent = null;
                view.setTag(R.id.tag_unhandled_key_event_manager, unhandledKeyEventManager);
            }
            WeakReference weakReference2 = unhandledKeyEventManager.mLastDispatchedPreViewKeyEvent;
            if (weakReference2 != null && weakReference2.get() == keyEvent) {
                return false;
            }
            unhandledKeyEventManager.mLastDispatchedPreViewKeyEvent = new WeakReference(keyEvent);
            if (unhandledKeyEventManager.mCapturedKeys == null) {
                unhandledKeyEventManager.mCapturedKeys = new SparseArray();
            }
            SparseArray sparseArray = unhandledKeyEventManager.mCapturedKeys;
            if (keyEvent.getAction() == 1 && (iIndexOfKey = sparseArray.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                weakReference = (WeakReference) sparseArray.valueAt(iIndexOfKey);
                sparseArray.removeAt(iIndexOfKey);
            }
            if (weakReference == null) {
                weakReference = (WeakReference) sparseArray.get(keyEvent.getKeyCode());
            }
            if (weakReference == null) {
                return false;
            }
            View view2 = (View) weakReference.get();
            if (view2 == null || !view2.isAttachedToWindow() || (arrayList = (ArrayList) view2.getTag(R.id.tag_unhandled_key_listeners)) == null || (size = arrayList.size() - 1) < 0) {
                return true;
            }
            arrayList.get(size).getClass();
            throw new ClassCastException();
        }

        public static boolean dispatchKeyEvent(KeyEventDispatcher$Component keyEventDispatcher$Component, View view, Window.Callback callback, KeyEvent keyEvent) {
            DialogInterface.OnKeyListener onKeyListener;
            boolean zBooleanValue = false;
            if (keyEventDispatcher$Component == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                return keyEventDispatcher$Component.superDispatchKeyEvent(keyEvent);
            }
            if (callback instanceof Activity) {
                Activity activity = (Activity) callback;
                activity.onUserInteraction();
                Window window = activity.getWindow();
                if (window.hasFeature(8)) {
                    ActionBar actionBar = activity.getActionBar();
                    if (keyEvent.getKeyCode() == 82 && actionBar != null) {
                        if (!sActionBarFieldsFetched) {
                            try {
                                sActionBarOnMenuKeyMethod = actionBar.getClass().getMethod("onMenuKeyEvent", KeyEvent.class);
                            } catch (NoSuchMethodException unused) {
                            }
                            sActionBarFieldsFetched = true;
                        }
                        Method method = sActionBarOnMenuKeyMethod;
                        if (method != null) {
                            try {
                                Object objInvoke = method.invoke(actionBar, keyEvent);
                                if (objInvoke != null) {
                                    zBooleanValue = ((Boolean) objInvoke).booleanValue();
                                }
                            } catch (IllegalAccessException | InvocationTargetException unused2) {
                            }
                        }
                        if (zBooleanValue) {
                            return true;
                        }
                    }
                }
                if (window.superDispatchKeyEvent(keyEvent)) {
                    return true;
                }
                View decorView = window.getDecorView();
                if (ViewCompat.dispatchUnhandledKeyEventBeforeCallback(decorView, keyEvent)) {
                    return true;
                }
                return keyEvent.dispatch(activity, decorView != null ? decorView.getKeyDispatcherState() : null, activity);
            }
            if (!(callback instanceof Dialog)) {
                return (view != null && ViewCompat.dispatchUnhandledKeyEventBeforeCallback(view, keyEvent)) || keyEventDispatcher$Component.superDispatchKeyEvent(keyEvent);
            }
            Dialog dialog = (Dialog) callback;
            if (!sDialogFieldsFetched) {
                try {
                    Field declaredField = Dialog.class.getDeclaredField("mOnKeyListener");
                    sDialogKeyListenerField = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException unused3) {
                }
                sDialogFieldsFetched = true;
            }
            Field field = sDialogKeyListenerField;
            if (field != null) {
                try {
                    onKeyListener = (DialogInterface.OnKeyListener) field.get(dialog);
                } catch (IllegalAccessException unused4) {
                    onKeyListener = null;
                }
            } else {
                onKeyListener = null;
            }
            if (onKeyListener != null && onKeyListener.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
                return true;
            }
            Window window2 = dialog.getWindow();
            if (window2.superDispatchKeyEvent(keyEvent)) {
                return true;
            }
            View decorView2 = window2.getDecorView();
            if (ViewCompat.dispatchUnhandledKeyEventBeforeCallback(decorView2, keyEvent)) {
                return true;
            }
            return keyEvent.dispatch(dialog, decorView2 != null ? decorView2.getKeyDispatcherState() : null, dialog);
        }

        public static final Class getClass(String str) {
            if (CrashShieldHandler.isObjectCrashing(Companion.class)) {
                return null;
            }
            try {
                return Class.forName(str);
            } catch (ClassNotFoundException unused) {
                return null;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(Companion.class, th);
                return null;
            }
        }

        public static AccessToken getCurrentAccessToken() {
            return AccessTokenManager.Companion.getInstance().currentAccessTokenField;
        }

        public static final Method getDeclaredMethod$facebook_core_release(Class cls, String str, Class... args) {
            if (CrashShieldHandler.isObjectCrashing(Companion.class)) {
                return null;
            }
            try {
                Intrinsics.checkNotNullParameter(args, "args");
                try {
                    return cls.getDeclaredMethod(str, (Class[]) Arrays.copyOf(args, args.length));
                } catch (NoSuchMethodException unused) {
                    return null;
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(Companion.class, th);
                return null;
            }
        }

        public static Drawable getDrawable(Context context, int i) {
            return ResourceManagerInternal.get().getDrawable(context, i);
        }

        public static final File getInstrumentReportDir() {
            File file = new File(FacebookSdk.getApplicationContext().getCacheDir(), "instrument");
            if (file.exists() || file.mkdirs()) {
                return file;
            }
            return null;
        }

        public static final Method getMethod(Class cls, String str, Class... clsArr) {
            if (CrashShieldHandler.isObjectCrashing(Companion.class)) {
                return null;
            }
            try {
                return cls.getMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            } catch (NoSuchMethodException unused) {
                return null;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(Companion.class, th);
                return null;
            }
        }

        public static final Object invokeMethod(Class clazz, Method method, Object obj, Object... args) {
            if (CrashShieldHandler.isObjectCrashing(Companion.class)) {
                return null;
            }
            try {
                Intrinsics.checkNotNullParameter(clazz, "clazz");
                Intrinsics.checkNotNullParameter(method, "method");
                Intrinsics.checkNotNullParameter(args, "args");
                if (obj != null) {
                    obj = clazz.cast(obj);
                }
                try {
                    return method.invoke(obj, Arrays.copyOf(args, args.length));
                } catch (IllegalAccessException | InvocationTargetException unused) {
                    return null;
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(Companion.class, th);
                return null;
            }
        }

        public static boolean isCurrentAccessTokenActive() {
            AccessToken accessToken = AccessTokenManager.Companion.getInstance().currentAccessTokenField;
            return (accessToken == null || new Date().after(accessToken.expires)) ? false : true;
        }

        public static final boolean isFromFbOrMeta(StackTraceElement stackTraceElement) {
            String className = stackTraceElement.getClassName();
            Intrinsics.checkNotNullExpressionValue(className, "element.className");
            if (!StringsKt__StringsKt.startsWith(className, "com.facebook", false)) {
                String className2 = stackTraceElement.getClassName();
                Intrinsics.checkNotNullExpressionValue(className2, "element.className");
                if (!StringsKt__StringsKt.startsWith(className2, "com.meta", false)) {
                    return false;
                }
            }
            return true;
        }

        public static final boolean isSDKRelatedThread(Thread thread) {
            StackTraceElement[] stackTrace = thread.getStackTrace();
            if (stackTrace != null) {
                for (StackTraceElement element : stackTrace) {
                    Intrinsics.checkNotNullExpressionValue(element, "element");
                    if (isFromFbOrMeta(element)) {
                        String className = element.getClassName();
                        Intrinsics.checkNotNullExpressionValue(className, "element.className");
                        if (!StringsKt__StringsKt.startsWith(className, "com.facebook.appevents.codeless", false)) {
                            String className2 = element.getClassName();
                            Intrinsics.checkNotNullExpressionValue(className2, "element.className");
                            if (!StringsKt__StringsKt.startsWith(className2, "com.facebook.appevents.suggestedevents", false)) {
                                return true;
                            }
                        }
                        String methodName = element.getMethodName();
                        Intrinsics.checkNotNullExpressionValue(methodName, "element.methodName");
                        if (StringsKt__StringsKt.startsWith(methodName, "onClick", false)) {
                            continue;
                        } else {
                            String methodName2 = element.getMethodName();
                            Intrinsics.checkNotNullExpressionValue(methodName2, "element.methodName");
                            if (StringsKt__StringsKt.startsWith(methodName2, "onItemClick", false)) {
                                continue;
                            } else {
                                String methodName3 = element.getMethodName();
                                Intrinsics.checkNotNullExpressionValue(methodName3, "element.methodName");
                                if (!StringsKt__StringsKt.startsWith(methodName3, "onTouch", false)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }

        public static Headers of(String... strArr) throws CloneNotSupportedException {
            if (strArr.length % 2 != 0) {
                throw new IllegalArgumentException("Expected alternating header names and values");
            }
            Object objClone = strArr.clone();
            if (objClone == null) {
                throw new NullPointerException(FKidOcdAYt.dOKk);
            }
            String[] strArr2 = (String[]) objClone;
            int length = strArr2.length;
            for (int i = 0; i < length; i++) {
                String str = strArr2[i];
                if (str == null) {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
                if (str == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                strArr2[i] = StringsKt__StringsKt.trim(str).toString();
            }
            IntProgression intProgressionStep = RangesKt.step(RangesKt.until(0, strArr2.length), 2);
            int i2 = intProgressionStep.first;
            int i3 = intProgressionStep.last;
            int i4 = intProgressionStep.step;
            if (i4 < 0 ? i2 >= i3 : i2 <= i3) {
                while (true) {
                    String str2 = strArr2[i2];
                    String str3 = strArr2[i2 + 1];
                    checkName(str2);
                    checkValue(str3, str2);
                    if (i2 == i3) {
                        break;
                    }
                    i2 += i4;
                }
            }
            return new Headers(strArr2);
        }

        public static CoroutineContext plus(CoroutineContext coroutineContext, CoroutineContext context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return context == EmptyCoroutineContext.INSTANCE ? coroutineContext : (CoroutineContext) context.fold(coroutineContext, CoroutineContext.AnonymousClass1.INSTANCE);
        }

        public static final JSONObject readFile(String str) {
            File instrumentReportDir = getInstrumentReportDir();
            if (instrumentReportDir != null) {
                try {
                    return new JSONObject(Utility.readStreamToString(new FileInputStream(new File(instrumentReportDir, str))));
                } catch (Exception unused) {
                    deleteFile(str);
                }
            }
            return null;
        }

        public static final void sendReports(String str, JSONArray jSONArray, GraphRequest.Callback callback) {
            if (jSONArray.length() == 0) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(str, jSONArray.toString());
                JSONObject dataProcessingOptions = Utility.getDataProcessingOptions();
                if (dataProcessingOptions != null) {
                    Iterator itKeys = dataProcessingOptions.keys();
                    while (itKeys.hasNext()) {
                        String str2 = (String) itKeys.next();
                        jSONObject.put(str2, dataProcessingOptions.get(str2));
                    }
                }
                String str3 = GraphRequest.MIME_BOUNDARY;
                GraphRequest.Companion.newPostRequest(null, String.format("%s/instruments", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1)), jSONObject, callback).executeAsync();
            } catch (JSONException unused) {
            }
        }

        public static final void writeFile(String str, String str2) {
            File instrumentReportDir = getInstrumentReportDir();
            if (instrumentReportDir == null || str == null || str2 == null) {
                return;
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(instrumentReportDir, str));
                byte[] bytes = str2.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                fileOutputStream.write(bytes);
                fileOutputStream.close();
            } catch (Exception unused) {
            }
        }

        public static AccessToken createFromJSONObject$facebook_core_release(JSONObject jSONObject) {
            if (jSONObject.getInt("version") > 1) {
                throw new FacebookException("Unknown AccessToken serialization format.");
            }
            String token = jSONObject.getString("token");
            Date date = new Date(jSONObject.getLong("expires_at"));
            JSONArray permissionsArray = jSONObject.getJSONArray("permissions");
            JSONArray declinedPermissionsArray = jSONObject.getJSONArray("declined_permissions");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("expired_permissions");
            Date date2 = new Date(jSONObject.getLong(PZmDzEagKNdW.eJZhBzly));
            String string = jSONObject.getString(FirebaseAnalytics.Param.SOURCE);
            Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(SOURCE_KEY)");
            AccessTokenSource accessTokenSourceValueOf = AccessTokenSource.valueOf(string);
            String applicationId = jSONObject.getString("application_id");
            String userId = jSONObject.getString("user_id");
            Date date3 = new Date(jSONObject.optLong("data_access_expiration_time", 0L));
            String strOptString = jSONObject.optString("graph_domain", null);
            Intrinsics.checkNotNullExpressionValue(token, "token");
            Intrinsics.checkNotNullExpressionValue(applicationId, "applicationId");
            Intrinsics.checkNotNullExpressionValue(userId, "userId");
            Intrinsics.checkNotNullExpressionValue(permissionsArray, "permissionsArray");
            ArrayList arrayListJsonArrayToStringList = Utility.jsonArrayToStringList(permissionsArray);
            Intrinsics.checkNotNullExpressionValue(declinedPermissionsArray, "declinedPermissionsArray");
            return new AccessToken(token, applicationId, userId, arrayListJsonArrayToStringList, Utility.jsonArrayToStringList(declinedPermissionsArray), jSONArrayOptJSONArray == null ? new ArrayList() : Utility.jsonArrayToStringList(jSONArrayOptJSONArray), accessTokenSourceValueOf, date, date2, date3, strOptString);
        }
    }

    public Headers(String[] strArr) {
        this.namesAndValues = strArr;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Headers) {
            if (Arrays.equals(this.namesAndValues, ((Headers) obj).namesAndValues)) {
                return true;
            }
        }
        return false;
    }

    public final String get(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        String[] strArr = this.namesAndValues;
        IntProgression intProgressionStep = RangesKt.step(new IntProgression(strArr.length - 2, 0, -1), 2);
        int i = intProgressionStep.first;
        int i2 = intProgressionStep.last;
        int i3 = intProgressionStep.step;
        if (i3 < 0 ? i >= i2 : i <= i2) {
            while (!name.equalsIgnoreCase(strArr[i])) {
                if (i != i2) {
                    i += i3;
                }
            }
            return strArr[i + 1];
        }
        return null;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        int size = size();
        Pair[] pairArr = new Pair[size];
        for (int i = 0; i < size; i++) {
            pairArr[i] = new Pair(name(i), value(i));
        }
        return new ArrayIterator(pairArr);
    }

    public final String name(int i) {
        return this.namesAndValues[i * 2];
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        ArrayList arrayList = builder.namesAndValues;
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        arrayList.addAll(ArraysKt.asList(this.namesAndValues));
        return builder;
    }

    public final int size() {
        return this.namesAndValues.length / 2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i = 0; i < size; i++) {
            sb.append(name(i));
            sb.append(": ");
            sb.append(value(i));
            sb.append("\n");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String value(int i) {
        return this.namesAndValues[(i * 2) + 1];
    }
}
