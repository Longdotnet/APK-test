package okhttp3;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.core.view.WindowCompat$Api30Impl;
import androidx.emoji2.text.flatbuffer.bs.bUqMCsuPSX;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.savedstate.SavedStateRegistryOwner;
import com.daerisoft.thespikerm.R;
import com.daerisoft.thespikerm.RunnerBillingSecurity;
import com.facebook.AccessToken;
import com.facebook.AccessTokenManager;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.login.CustomTabPrefetchHelper;
import com.google.android.gms.ads.internal.gMU.QTaELkFI;
import com.google.android.gms.ads.rewarded.zQ.yzwzcWHcnH;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader$ParseException;
import com.google.android.gms.common.util.concurrent.dN.MnHfHMYQDPUO;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.inject.Provider;
import com.google.gson.yWTz.kBfGXgdfpo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.InitializedLazyImpl;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.DispatchedContinuation;
import okhttp3.Protocol;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes3.dex */
public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE(oKjScaD.bOHe),
    QUIC("quic");

    public final String protocol;

    public abstract class Companion implements ComponentContainer {
        public static ArrayList constructErrorResponses(GraphRequestBatch requests, HttpURLConnection httpURLConnection, FacebookException facebookException) {
            Intrinsics.checkNotNullParameter(requests, "requests");
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(requests));
            Iterator it = requests.iterator();
            while (it.hasNext()) {
                arrayList.add(new GraphResponse((GraphRequest) it.next(), httpURLConnection, new FacebookRequestError(facebookException)));
            }
            return arrayList;
        }

        public static BigDecimal createBigDecimal(Parcel parcel, int i) {
            int size = readSize(parcel, i);
            int iDataPosition = parcel.dataPosition();
            if (size == 0) {
                return null;
            }
            byte[] bArrCreateByteArray = parcel.createByteArray();
            int i2 = parcel.readInt();
            parcel.setDataPosition(iDataPosition + size);
            return new BigDecimal(new BigInteger(bArrCreateByteArray), i2);
        }

        public static boolean[] createBooleanArray(Parcel parcel, int i) {
            int size = readSize(parcel, i);
            int iDataPosition = parcel.dataPosition();
            if (size == 0) {
                return null;
            }
            boolean[] zArrCreateBooleanArray = parcel.createBooleanArray();
            parcel.setDataPosition(iDataPosition + size);
            return zArrCreateBooleanArray;
        }

        public static Bundle createBundle(Parcel parcel, int i) {
            int size = readSize(parcel, i);
            int iDataPosition = parcel.dataPosition();
            if (size == 0) {
                return null;
            }
            Bundle bundle = parcel.readBundle();
            parcel.setDataPosition(iDataPosition + size);
            return bundle;
        }

        public static byte[] createByteArray(Parcel parcel, int i) {
            int size = readSize(parcel, i);
            int iDataPosition = parcel.dataPosition();
            if (size == 0) {
                return null;
            }
            byte[] bArrCreateByteArray = parcel.createByteArray();
            parcel.setDataPosition(iDataPosition + size);
            return bArrCreateByteArray;
        }

        public static int[] createIntArray(Parcel parcel, int i) {
            int size = readSize(parcel, i);
            int iDataPosition = parcel.dataPosition();
            if (size == 0) {
                return null;
            }
            int[] iArrCreateIntArray = parcel.createIntArray();
            parcel.setDataPosition(iDataPosition + size);
            return iArrCreateIntArray;
        }

        public static Parcelable createParcelable(Parcel parcel, int i, Parcelable.Creator creator) {
            int size = readSize(parcel, i);
            int iDataPosition = parcel.dataPosition();
            if (size == 0) {
                return null;
            }
            Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
            parcel.setDataPosition(iDataPosition + size);
            return parcelable;
        }

        public static ArrayList createResponsesFromStream$facebook_core_release(InputStream inputStream, HttpURLConnection httpURLConnection, GraphRequestBatch requests) {
            Object obj;
            Intrinsics.checkNotNullParameter(requests, "requests");
            String streamToString = Utility.readStreamToString(inputStream);
            GraphRequest.Companion companion = Logger.Companion;
            synchronized (FacebookSdk.loggingBehaviors) {
            }
            Object resultObject = new JSONTokener(streamToString).nextValue();
            Intrinsics.checkNotNullExpressionValue(resultObject, "resultObject");
            int size = requests.requests.size();
            ArrayList arrayList = new ArrayList(size);
            if (size == 1) {
                GraphRequest graphRequest = (GraphRequest) requests.get(0);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("body", resultObject);
                    jSONObject.put("code", httpURLConnection.getResponseCode());
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(jSONObject);
                    obj = jSONArray;
                } catch (IOException e) {
                    arrayList.add(new GraphResponse(graphRequest, httpURLConnection, new FacebookRequestError(e)));
                    obj = resultObject;
                } catch (JSONException e2) {
                    arrayList.add(new GraphResponse(graphRequest, httpURLConnection, new FacebookRequestError(e2)));
                    obj = resultObject;
                }
            } else {
                obj = resultObject;
            }
            if (obj instanceof JSONArray) {
                JSONArray jSONArray2 = (JSONArray) obj;
                if (jSONArray2.length() == size) {
                    int length = jSONArray2.length();
                    if (length > 0) {
                        int i = 0;
                        while (true) {
                            int i2 = i + 1;
                            GraphRequest graphRequest2 = (GraphRequest) requests.get(i);
                            try {
                                Object obj2 = ((JSONArray) obj).get(i);
                                Intrinsics.checkNotNullExpressionValue(obj2, MnHfHMYQDPUO.CEAYS);
                                arrayList.add(createResponseFromObject(graphRequest2, httpURLConnection, obj2, resultObject));
                            } catch (FacebookException e3) {
                                arrayList.add(new GraphResponse(graphRequest2, httpURLConnection, new FacebookRequestError(e3)));
                            } catch (JSONException e4) {
                                arrayList.add(new GraphResponse(graphRequest2, httpURLConnection, new FacebookRequestError(e4)));
                            }
                            if (i2 >= length) {
                                break;
                            }
                            i = i2;
                        }
                    }
                    GraphRequest.Companion companion2 = Logger.Companion;
                    GraphRequest.Companion.log(LoggingBehavior.REQUESTS, "Response", "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", requests.id, Integer.valueOf(streamToString.length()), arrayList);
                    return arrayList;
                }
            }
            throw new FacebookException("Unexpected number of results");
        }

        public static String createString(Parcel parcel, int i) {
            int size = readSize(parcel, i);
            int iDataPosition = parcel.dataPosition();
            if (size == 0) {
                return null;
            }
            String string = parcel.readString();
            parcel.setDataPosition(iDataPosition + size);
            return string;
        }

        public static String[] createStringArray(Parcel parcel, int i) {
            int size = readSize(parcel, i);
            int iDataPosition = parcel.dataPosition();
            if (size == 0) {
                return null;
            }
            String[] strArrCreateStringArray = parcel.createStringArray();
            parcel.setDataPosition(iDataPosition + size);
            return strArrCreateStringArray;
        }

        public static ArrayList createStringList(Parcel parcel, int i) {
            int size = readSize(parcel, i);
            int iDataPosition = parcel.dataPosition();
            if (size == 0) {
                return null;
            }
            ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
            parcel.setDataPosition(iDataPosition + size);
            return arrayListCreateStringArrayList;
        }

        public static Object[] createTypedArray(Parcel parcel, int i, Parcelable.Creator creator) {
            int size = readSize(parcel, i);
            int iDataPosition = parcel.dataPosition();
            if (size == 0) {
                return null;
            }
            Object[] objArrCreateTypedArray = parcel.createTypedArray(creator);
            parcel.setDataPosition(iDataPosition + size);
            return objArrCreateTypedArray;
        }

        public static ArrayList createTypedList(Parcel parcel, int i, Parcelable.Creator creator) {
            int size = readSize(parcel, i);
            int iDataPosition = parcel.dataPosition();
            if (size == 0) {
                return null;
            }
            ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
            parcel.setDataPosition(iDataPosition + size);
            return arrayListCreateTypedArrayList;
        }

        public static void ensureAtEnd(Parcel parcel, int i) {
            if (parcel.dataPosition() != i) {
                throw new SafeParcelReader$ParseException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "Overread allowed size end="), parcel);
            }
        }

        public static final String getRawKeyFromEndPoint(final String kid) {
            Intrinsics.checkNotNullParameter(kid, "kid");
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            final URL url = new URL("https", Intrinsics.stringPlus(FacebookSdk.facebookDomain, "www."), "/.well-known/oauth/openid/keys/");
            final ReentrantLock reentrantLock = new ReentrantLock();
            final Condition conditionNewCondition = reentrantLock.newCondition();
            final InitializedLazyImpl initializedLazyImpl = new InitializedLazyImpl();
            FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.internal.security.OidcSecurityUtil$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() throws IOException {
                    Condition condition = conditionNewCondition;
                    URL url2 = url;
                    InitializedLazyImpl initializedLazyImpl2 = initializedLazyImpl;
                    String kid2 = kid;
                    Intrinsics.checkNotNullParameter(kid2, "$kid");
                    ReentrantLock reentrantLock2 = reentrantLock;
                    URLConnection uRLConnectionOpenConnection = url2.openConnection();
                    if (uRLConnectionOpenConnection == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
                    }
                    HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                    try {
                        try {
                            InputStream inputStream = httpURLConnection.getInputStream();
                            Intrinsics.checkNotNullExpressionValue(inputStream, "connection.inputStream");
                            String text = TextStreamsKt.readText(new BufferedReader(new InputStreamReader(inputStream, Charsets.UTF_8), 8192));
                            httpURLConnection.getInputStream().close();
                            initializedLazyImpl2.value = new JSONObject(text).optString(kid2);
                            httpURLConnection.disconnect();
                            reentrantLock2.lock();
                            try {
                                condition.signal();
                            } finally {
                                reentrantLock2.unlock();
                            }
                        } catch (Exception e) {
                            String name = Protocol.Companion.class.getName();
                            String message = e.getMessage();
                            if (message == null) {
                                message = "Error getting public key";
                            }
                            Log.d(name, message);
                            httpURLConnection.disconnect();
                            reentrantLock2.lock();
                            try {
                                condition.signal();
                            } finally {
                                reentrantLock2.unlock();
                            }
                        }
                    } catch (Throwable th) {
                        httpURLConnection.disconnect();
                        reentrantLock2.lock();
                        try {
                            condition.signal();
                            throw th;
                        } finally {
                            reentrantLock2.unlock();
                        }
                    }
                }
            });
            reentrantLock.lock();
            try {
                conditionNewCondition.await(5000L, TimeUnit.MILLISECONDS);
                return (String) initializedLazyImpl.value;
            } finally {
                reentrantLock.unlock();
            }
        }

        public static Continuation intercepted(Continuation continuation) {
            Intrinsics.checkNotNullParameter(continuation, "<this>");
            ContinuationImpl continuationImpl = continuation instanceof ContinuationImpl ? (ContinuationImpl) continuation : null;
            if (continuationImpl == null) {
                return continuation;
            }
            Continuation continuation2 = continuationImpl.intercepted;
            if (continuation2 != null) {
                return continuation2;
            }
            CoroutineContext coroutineContext = continuationImpl._context;
            Intrinsics.checkNotNull(coroutineContext);
            ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.get(ContinuationInterceptor.Key.$$INSTANCE);
            Continuation dispatchedContinuation = continuationInterceptor != null ? new DispatchedContinuation((CoroutineDispatcher) continuationInterceptor, continuationImpl) : continuationImpl;
            continuationImpl.intercepted = dispatchedContinuation;
            return dispatchedContinuation;
        }

        public static void mayLaunchUrl(Uri uri) {
            ReentrantLock reentrantLock = CustomTabPrefetchHelper.lock;
            reentrantLock.lock();
            reentrantLock.unlock();
            reentrantLock.lock();
            reentrantLock.unlock();
        }

        public static void onCreateInputConnection(EditorInfo editorInfo, InputConnection inputConnection, TextView textView) {
            if (inputConnection == null || editorInfo.hintText != null) {
                return;
            }
            for (ViewParent parent = textView.getParent(); parent instanceof View; parent = parent.getParent()) {
            }
        }

        public static boolean readBoolean(Parcel parcel, int i) {
            zzb(parcel, i, 4);
            return parcel.readInt() != 0;
        }

        public static Boolean readBooleanObject(Parcel parcel, int i) {
            int size = readSize(parcel, i);
            if (size == 0) {
                return null;
            }
            zza(parcel, size, 4);
            return Boolean.valueOf(parcel.readInt() != 0);
        }

        public static float readFloat(Parcel parcel, int i) {
            zzb(parcel, i, 4);
            return parcel.readFloat();
        }

        public static IBinder readIBinder(Parcel parcel, int i) {
            int size = readSize(parcel, i);
            int iDataPosition = parcel.dataPosition();
            if (size == 0) {
                return null;
            }
            IBinder strongBinder = parcel.readStrongBinder();
            parcel.setDataPosition(iDataPosition + size);
            return strongBinder;
        }

        public static int readInt(Parcel parcel, int i) {
            zzb(parcel, i, 4);
            return parcel.readInt();
        }

        public static long readLong(Parcel parcel, int i) {
            zzb(parcel, i, 8);
            return parcel.readLong();
        }

        public static Long readLongObject(Parcel parcel, int i) {
            int size = readSize(parcel, i);
            if (size == 0) {
                return null;
            }
            zza(parcel, size, 8);
            return Long.valueOf(parcel.readLong());
        }

        public static int readSize(Parcel parcel, int i) {
            return (i & (-65536)) != -65536 ? (char) (i >> 16) : parcel.readInt();
        }

        public static final void set(View view, SavedStateRegistryOwner savedStateRegistryOwner) {
            Intrinsics.checkNotNullParameter(view, "<this>");
            view.setTag(R.id.view_tree_saved_state_registry_owner, savedStateRegistryOwner);
        }

        public static void setDecorFitsSystemWindows(Window window) {
            if (Build.VERSION.SDK_INT >= 30) {
                WindowCompat$Api30Impl.setDecorFitsSystemWindows(window, false);
            } else {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 1792);
            }
        }

        public static void skipUnknownField(Parcel parcel, int i) {
            parcel.setDataPosition(parcel.dataPosition() + readSize(parcel, i));
        }

        public static void zzb(Parcel parcel, int i, int i2) {
            int size = readSize(parcel, i);
            if (size == i2) {
                return;
            }
            throw new SafeParcelReader$ParseException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(CoroutineAdapterKt$$ExternalSyntheticLambda0.m("Expected size ", i2, " got ", size, " (0x"), Integer.toHexString(size), ")"), parcel);
        }

        @Override // com.google.firebase.components.ComponentContainer
        public Object get(Class cls) {
            Provider provider = getProvider(cls);
            if (provider == null) {
                return null;
            }
            return provider.get();
        }

        @Override // com.google.firebase.components.ComponentContainer
        public Set setOf(Class cls) {
            return (Set) setOfProvider(cls).get();
        }

        /* JADX WARN: Code duplicated, block: B:51:0x00f0  */
        /* JADX WARN: Code duplicated, block: B:58:0x0101 A[Catch: JSONException -> 0x011b, TryCatch #0 {JSONException -> 0x011b, blocks: (B:5:0x0017, B:7:0x001d, B:9:0x0027, B:11:0x002b, B:14:0x0038, B:49:0x00e0, B:35:0x007b, B:32:0x0072, B:29:0x0068, B:26:0x0060, B:23:0x0059, B:20:0x004f, B:17:0x0045, B:37:0x008e, B:40:0x009b, B:42:0x00a4, B:47:0x00b9, B:56:0x00f9, B:58:0x0101, B:59:0x0107), top: B:99:0x0017 }] */
        public static GraphResponse createResponseFromObject(GraphRequest request, HttpURLConnection httpURLConnection, Object obj, Object obj2) {
            FacebookRequestError facebookRequestError;
            AccessToken accessToken;
            AccessToken accessToken2;
            FacebookRequestError facebookRequestError2;
            String strOptString;
            String str;
            int iOptInt;
            String str2;
            String str3;
            Object NULL = obj;
            if (NULL instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) NULL;
                try {
                    if (jSONObject.has("code")) {
                        int i = jSONObject.getInt("code");
                        Object stringPropertyAsJSON = Utility.getStringPropertyAsJSON(jSONObject, "body", "FACEBOOK_NON_JSON_RESULT");
                        if (stringPropertyAsJSON != null && (stringPropertyAsJSON instanceof JSONObject)) {
                            boolean zOptBoolean = false;
                            int iOptInt2 = -1;
                            if (((JSONObject) stringPropertyAsJSON).has("error")) {
                                JSONObject jSONObject2 = (JSONObject) Utility.getStringPropertyAsJSON((JSONObject) stringPropertyAsJSON, "error", null);
                                String strOptString2 = jSONObject2 == null ? null : jSONObject2.optString("type", null);
                                String strOptString3 = jSONObject2 == null ? null : jSONObject2.optString("message", null);
                                int iOptInt3 = jSONObject2 == null ? -1 : jSONObject2.optInt("code", -1);
                                if (jSONObject2 != null) {
                                    iOptInt2 = jSONObject2.optInt("error_subcode", -1);
                                }
                                String strOptString4 = jSONObject2 == null ? null : jSONObject2.optString("error_user_msg", null);
                                String strOptString5 = jSONObject2 == null ? null : jSONObject2.optString("error_user_title", null);
                                if (jSONObject2 != null) {
                                    zOptBoolean = jSONObject2.optBoolean("is_transient", false);
                                }
                                strOptString = strOptString2;
                                str2 = strOptString5;
                                str = strOptString3;
                                zOptBoolean = zOptBoolean;
                                str3 = strOptString4;
                                iOptInt = iOptInt2;
                                zOptBoolean = true;
                                iOptInt2 = iOptInt3;
                            } else {
                                if (((JSONObject) stringPropertyAsJSON).has("error_code") || ((JSONObject) stringPropertyAsJSON).has("error_msg") || ((JSONObject) stringPropertyAsJSON).has("error_reason")) {
                                    strOptString = ((JSONObject) stringPropertyAsJSON).optString("error_reason", null);
                                    String strOptString6 = ((JSONObject) stringPropertyAsJSON).optString("error_msg", null);
                                    iOptInt2 = ((JSONObject) stringPropertyAsJSON).optInt("error_code", -1);
                                    str = strOptString6;
                                    iOptInt = ((JSONObject) stringPropertyAsJSON).optInt("error_subcode", -1);
                                    zOptBoolean = true;
                                } else {
                                    iOptInt = -1;
                                    strOptString = null;
                                    str = null;
                                }
                                str2 = null;
                                str3 = null;
                            }
                            if (zOptBoolean) {
                                facebookRequestError2 = new FacebookRequestError(i, iOptInt2, iOptInt, strOptString, str, str2, str3, obj2, null, zOptBoolean);
                            } else {
                                if (i <= 299) {
                                }
                                if (jSONObject.has("body")) {
                                }
                                facebookRequestError2 = new FacebookRequestError(i, -1, -1, null, null, null, null, obj2, null, false);
                            }
                        } else if (i <= 299 || 200 > i) {
                            if (jSONObject.has("body")) {
                            }
                            facebookRequestError2 = new FacebookRequestError(i, -1, -1, null, null, null, null, obj2, null, false);
                        } else {
                            facebookRequestError = null;
                        }
                        facebookRequestError = facebookRequestError2;
                    } else {
                        facebookRequestError = null;
                    }
                } catch (JSONException unused) {
                }
                if (facebookRequestError != null) {
                    Log.e(bUqMCsuPSX.OIeCDW, facebookRequestError.toString());
                    if (facebookRequestError.errorCode == 190 && (accessToken = request.accessToken) != null) {
                        Date date = AccessToken.DEFAULT_EXPIRATION_TIME;
                        if (accessToken.equals(Headers.Companion.getCurrentAccessToken())) {
                            int i2 = facebookRequestError.subErrorCode;
                            GraphRequest.Companion companion = AccessTokenManager.Companion;
                            if (i2 != 493) {
                                companion.getInstance().setCurrentAccessToken(null, true);
                            } else {
                                AccessToken currentAccessToken = Headers.Companion.getCurrentAccessToken();
                                if (Intrinsics.areEqual(currentAccessToken == null ? null : Boolean.valueOf(new Date().after(currentAccessToken.expires)), Boolean.FALSE) && (accessToken2 = companion.getInstance().currentAccessTokenField) != null) {
                                    companion.getInstance().setCurrentAccessToken(new AccessToken(accessToken2.token, accessToken2.applicationId, accessToken2.userId, accessToken2.permissions, accessToken2.declinedPermissions, accessToken2.expiredPermissions, accessToken2.source, new Date(), new Date(), accessToken2.dataAccessExpirationTime, "facebook"), true);
                                }
                            }
                        }
                    }
                    return new GraphResponse(request, httpURLConnection, facebookRequestError);
                }
                Object stringPropertyAsJSON2 = Utility.getStringPropertyAsJSON(jSONObject, "body", "FACEBOOK_NON_JSON_RESULT");
                if (stringPropertyAsJSON2 instanceof JSONObject) {
                    JSONObject jSONObject3 = (JSONObject) stringPropertyAsJSON2;
                    return new GraphResponse(request, httpURLConnection, jSONObject3.toString(), jSONObject3);
                }
                if (stringPropertyAsJSON2 instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) stringPropertyAsJSON2;
                    String rawResponse = jSONArray.toString();
                    Intrinsics.checkNotNullParameter(request, "request");
                    Intrinsics.checkNotNullParameter(rawResponse, "rawResponse");
                    return new GraphResponse(request, httpURLConnection, null, jSONArray, null);
                }
                NULL = JSONObject.NULL;
                Intrinsics.checkNotNullExpressionValue(NULL, "NULL");
            }
            if (NULL == JSONObject.NULL) {
                return new GraphResponse(request, httpURLConnection, NULL.toString(), null);
            }
            throw new FacebookException(Intrinsics.stringPlus(NULL.getClass().getSimpleName(), "Got unexpected object type in response, class: "));
        }

        public static final PublicKey getPublicKeyFromString(String str) throws InvalidKeySpecException {
            byte[] bArrDecode = Base64.decode(StringsKt__StringsKt.replace$default(StringsKt__StringsKt.replace$default(StringsKt__StringsKt.replace$default(str, kBfGXgdfpo.zUxieZ, ""), "-----BEGIN PUBLIC KEY-----", ""), "-----END PUBLIC KEY-----", ""), 0);
            Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(pubKeyString, Base64.DEFAULT)");
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(RunnerBillingSecurity.KEY_FACTORY_ALGORITHM).generatePublic(new X509EncodedKeySpec(bArrDecode));
            Intrinsics.checkNotNullExpressionValue(publicKeyGeneratePublic, "kf.generatePublic(x509publicKey)");
            return publicKeyGeneratePublic;
        }

        public static final boolean verify(PublicKey publicKey, String str, String signature) {
            Intrinsics.checkNotNullParameter(str, kBfGXgdfpo.tZnIloPMw);
            Intrinsics.checkNotNullParameter(signature, "signature");
            try {
                Signature signature2 = Signature.getInstance("SHA256withRSA");
                signature2.initVerify(publicKey);
                byte[] bytes = str.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                signature2.update(bytes);
                byte[] bArrDecode = Base64.decode(signature, 8);
                Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(signature, Base64.URL_SAFE)");
                return signature2.verify(bArrDecode);
            } catch (Exception unused) {
                return false;
            }
        }

        public static void zza(Parcel parcel, int i, int i2) {
            if (i == i2) {
                return;
            }
            throw new SafeParcelReader$ParseException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(CoroutineAdapterKt$$ExternalSyntheticLambda0.m("Expected size ", i2, " got ", i, " (0x"), Integer.toHexString(i), yzwzcWHcnH.xWdfUn), parcel);
        }

        public static Protocol get(String str) throws IOException {
            if (str.equals("http/1.0")) {
                return Protocol.HTTP_1_0;
            }
            if (str.equals("http/1.1")) {
                return Protocol.HTTP_1_1;
            }
            if (str.equals("h2_prior_knowledge")) {
                return Protocol.H2_PRIOR_KNOWLEDGE;
            }
            if (str.equals("h2")) {
                return Protocol.HTTP_2;
            }
            if (str.equals("spdy/3.1")) {
                return Protocol.SPDY_3;
            }
            if (str.equals("quic")) {
                return Protocol.QUIC;
            }
            throw new IOException("Unexpected protocol: ".concat(str));
        }

        public static int validateObjectHeader(Parcel parcel) {
            int i = parcel.readInt();
            int size = readSize(parcel, i);
            char c = (char) i;
            int iDataPosition = parcel.dataPosition();
            if (c == 20293) {
                int i2 = size + iDataPosition;
                if (i2 >= iDataPosition && i2 <= parcel.dataSize()) {
                    return i2;
                }
                throw new SafeParcelReader$ParseException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iDataPosition, i2, "Size read is invalid start=", " end="), parcel);
            }
            throw new SafeParcelReader$ParseException(QTaELkFI.IzPJIfTbOQ.concat(String.valueOf(Integer.toHexString(i))), parcel);
        }
    }

    Protocol(String str) {
        this.protocol = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.protocol;
    }
}
