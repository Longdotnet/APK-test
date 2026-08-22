package okio;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.result.ActivityResult;
import androidx.core.os.BundleCompat$Api33Impl;
import com.daerisoft.thespikerm.R;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.appevents.suggestedevents.ViewObserver;
import com.facebook.appevents.suggestedevents.naLU.DaWYVMJ;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.games.snapshot.Xa.JrbhsraGtto;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbdc;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzfca;
import com.google.android.gms.internal.ads.zzfva;
import com.google.android.gms.internal.ads.zzfwe;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Okio {
    public static Object getParcelable(Bundle bundle, String str) {
        if (Build.VERSION.SDK_INT >= 34) {
            return BundleCompat$Api33Impl.getParcelable(bundle, str, ActivityResult.class);
        }
        Parcelable parcelable = bundle.getParcelable(str);
        if (ActivityResult.class.isInstance(parcelable)) {
            return parcelable;
        }
        return null;
    }

    public static final boolean isAndroidGetsocknameError(AssertionError assertionError) {
        Logger logger = Okio__JvmOkioKt.logger;
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        return message != null ? StringsKt__StringsKt.contains$default(message, "getsockname failed") : false;
    }

    public static List listOf(Object obj) {
        List listSingletonList = Collections.singletonList(obj);
        Intrinsics.checkNotNullExpressionValue(listSingletonList, "singletonList(element)");
        return listSingletonList;
    }

    public static void logVerbose(String str) {
        if (Log.isLoggable("InstallReferrerClient", 2)) {
            Log.v("InstallReferrerClient", str);
        }
    }

    public static void logWarn(String str) {
        if (Log.isLoggable("InstallReferrerClient", 5)) {
            Log.w("InstallReferrerClient", str);
        }
    }

    public static String pin(X509Certificate x509Certificate) {
        StringBuilder sb = new StringBuilder("sha256/");
        ByteString byteString = ByteString.EMPTY;
        PublicKey publicKey = x509Certificate.getPublicKey();
        Intrinsics.checkNotNullExpressionValue(publicKey, "publicKey");
        byte[] encoded = publicKey.getEncoded();
        Intrinsics.checkNotNullExpressionValue(encoded, "publicKey.encoded");
        int length = encoded.length;
        int i = 0;
        StringsKt__IndentKt.checkOffsetAndCount(encoded.length, 0, length);
        byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(new ByteString(ArraysKt.copyOfRange(0, encoded, length)).data);
        Intrinsics.checkNotNullExpressionValue(bArrDigest, "MessageDigest.getInstance(algorithm).digest(data)");
        byte[] encodeBase64 = new ByteString(bArrDigest).data;
        byte[] map = Base64.BASE64;
        Intrinsics.checkNotNullParameter(encodeBase64, "$this$encodeBase64");
        Intrinsics.checkNotNullParameter(map, "map");
        byte[] bArr = new byte[((encodeBase64.length + 2) / 3) * 4];
        int length2 = encodeBase64.length - (encodeBase64.length % 3);
        int i2 = 0;
        while (i < length2) {
            byte b = encodeBase64[i];
            int i3 = i + 2;
            byte b2 = encodeBase64[i + 1];
            i += 3;
            byte b3 = encodeBase64[i3];
            bArr[i2] = map[(b & 255) >> 2];
            bArr[i2 + 1] = map[((b & 3) << 4) | ((b2 & 255) >> 4)];
            int i4 = i2 + 3;
            bArr[i2 + 2] = map[((b2 & 15) << 2) | ((b3 & 255) >> 6)];
            i2 += 4;
            bArr[i4] = map[b3 & 63];
        }
        int length3 = encodeBase64.length - length2;
        if (length3 == 1) {
            byte b4 = encodeBase64[i];
            bArr[i2] = map[(b4 & 255) >> 2];
            bArr[1 + i2] = map[(b4 & 3) << 4];
            byte b5 = (byte) 61;
            bArr[2 + i2] = b5;
            bArr[i2 + 3] = b5;
        } else if (length3 == 2) {
            int i5 = i + 1;
            byte b6 = encodeBase64[i];
            byte b7 = encodeBase64[i5];
            bArr[i2] = map[(b6 & 255) >> 2];
            bArr[1 + i2] = map[((b6 & 3) << 4) | ((b7 & 255) >> 4)];
            bArr[i2 + 2] = map[(b7 & 15) << 2];
            bArr[i2 + 3] = (byte) 61;
        }
        sb.append(new String(bArr, Charsets.UTF_8));
        return sb.toString();
    }

    public static final void set(View view, OnBackPressedDispatcherOwner onBackPressedDispatcherOwner) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, onBackPressedDispatcherOwner);
    }

    public static final OutputStreamSink sink(Socket socket) throws IOException {
        Logger logger = Okio__JvmOkioKt.logger;
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket, 0);
        OutputStream outputStream = socket.getOutputStream();
        Intrinsics.checkNotNullExpressionValue(outputStream, "getOutputStream()");
        return new OutputStreamSink(socketAsyncTimeout, new OutputStreamSink(outputStream, socketAsyncTimeout));
    }

    public static int smear(int i) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i) * (-862048943)), 15)) * 461845907);
    }

    public static final InputStreamSource source(Socket socket) throws IOException {
        int i = 0;
        Logger logger = Okio__JvmOkioKt.logger;
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket, i);
        InputStream inputStream = socket.getInputStream();
        Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream()");
        return new InputStreamSource(socketAsyncTimeout, new InputStreamSource(inputStream, socketAsyncTimeout, i), 1);
    }

    public static void startTrackingActivity(Activity activity) {
        View rootView;
        Intrinsics.checkNotNullParameter(activity, "activity");
        int iHashCode = activity.hashCode();
        HashMap map = ViewObserver.observers;
        HashMap map2 = null;
        if (!CrashShieldHandler.isObjectCrashing(ViewObserver.class)) {
            try {
                map2 = ViewObserver.observers;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(ViewObserver.class, th);
            }
        }
        Integer numValueOf = Integer.valueOf(iHashCode);
        Object viewObserver = map2.get(numValueOf);
        if (viewObserver == null) {
            viewObserver = new ViewObserver(activity);
            map2.put(numValueOf, viewObserver);
        }
        ViewObserver viewObserver2 = (ViewObserver) viewObserver;
        if (CrashShieldHandler.isObjectCrashing(ViewObserver.class)) {
            return;
        }
        try {
            if (CrashShieldHandler.isObjectCrashing(viewObserver2)) {
                return;
            }
            try {
                if (!viewObserver2.isTracking.getAndSet(true) && (rootView = AppEventUtility.getRootView((Activity) viewObserver2.activityWeakReference.get())) != null) {
                    ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.addOnGlobalLayoutListener(viewObserver2);
                        viewObserver2.process();
                        return;
                    }
                    return;
                    CrashShieldHandler.handleThrowable(ViewObserver.class, th);
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(viewObserver2, th2);
            }
        } catch (Throwable th3) {
            CrashShieldHandler.handleThrowable(ViewObserver.class, th3);
        }
    }

    public static void stopTrackingActivity(Activity activity) {
        View rootView;
        Intrinsics.checkNotNullParameter(activity, "activity");
        int iHashCode = activity.hashCode();
        HashMap map = ViewObserver.observers;
        HashMap map2 = null;
        if (!CrashShieldHandler.isObjectCrashing(ViewObserver.class)) {
            try {
                map2 = ViewObserver.observers;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(ViewObserver.class, th);
            }
        }
        ViewObserver viewObserver = (ViewObserver) map2.remove(Integer.valueOf(iHashCode));
        if (viewObserver == null || CrashShieldHandler.isObjectCrashing(ViewObserver.class)) {
            return;
        }
        try {
            if (!CrashShieldHandler.isObjectCrashing(viewObserver)) {
                try {
                    if (viewObserver.isTracking.getAndSet(false) && (rootView = AppEventUtility.getRootView((Activity) viewObserver.activityWeakReference.get())) != null) {
                        ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
                        if (viewTreeObserver.isAlive()) {
                            viewTreeObserver.removeOnGlobalLayoutListener(viewObserver);
                        }
                    }
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(viewObserver, th2);
                }
            }
        } catch (Throwable th3) {
            CrashShieldHandler.handleThrowable(ViewObserver.class, th3);
        }
    }

    public static WindowManager.LayoutParams zzb() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 0, 0, -2);
        layoutParams.flags = ((Integer) zzbd.zza.zzd.zzb(zzbde.zziu)).intValue();
        layoutParams.type = 2;
        layoutParams.gravity = 8388659;
        return layoutParams;
    }

    public static JSONObject zzc(String str, Context context, Point point, Point point2) {
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    int i = point2.x;
                    zzbb zzbbVar = zzbb.zzb;
                    jSONObject3.put("x", zzbbVar.zzc.zzb(context, i));
                    jSONObject3.put("y", zzbbVar.zzc.zzb(context, point2.y));
                    jSONObject3.put("start_x", zzbbVar.zzc.zzb(context, point.x));
                    jSONObject3.put("start_y", zzbbVar.zzc.zzb(context, point.y));
                    jSONObject = jSONObject3;
                } catch (JSONException e) {
                    int i2 = zze.$r8$clinit;
                    zzo.zzh("Error occurred while putting signals into JSON object.", e);
                }
                jSONObject2.put("click_point", jSONObject);
                jSONObject2.put("asset_id", str);
                return jSONObject2;
            } catch (Exception e2) {
                e = e2;
                jSONObject = jSONObject2;
                int i3 = zze.$r8$clinit;
                zzo.zzh("Error occurred while grabbing click signals.", e);
                return jSONObject;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:59:0x01cc  */
    public static JSONObject zzd(Context context, Map map, Map map2, View view, ImageView.ScaleType scaleType) {
        Map map3;
        int[] iArr;
        JSONObject jSONObject;
        boolean z;
        Map map4 = map2;
        JSONObject jSONObject2 = new JSONObject();
        if (map != null && view != null) {
            int i = 2;
            int[] iArr2 = new int[2];
            view.getLocationOnScreen(iArr2);
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                View view2 = (View) ((WeakReference) entry.getValue()).get();
                if (view2 != null) {
                    int[] iArr3 = new int[i];
                    view2.getLocationOnScreen(iArr3);
                    JSONObject jSONObject3 = new JSONObject();
                    JSONObject jSONObject4 = new JSONObject();
                    Iterator it2 = it;
                    try {
                        int measuredWidth = view2.getMeasuredWidth();
                        JSONObject jSONObject5 = jSONObject2;
                        try {
                            zzbb zzbbVar = zzbb.zzb;
                            try {
                                zzf zzfVar = zzbbVar.zzc;
                                zzf zzfVar2 = zzbbVar.zzc;
                                jSONObject4.put("width", zzfVar.zzb(context, measuredWidth));
                                jSONObject4.put("height", zzfVar2.zzb(context, view2.getMeasuredHeight()));
                                jSONObject4.put("x", zzfVar2.zzb(context, iArr3[0] - iArr2[0]));
                                jSONObject4.put("y", zzfVar2.zzb(context, iArr3[1] - iArr2[1]));
                                jSONObject4.put("relative_to", "ad_view");
                                jSONObject3.put("frame", jSONObject4);
                                Rect rect = new Rect();
                                if (view2.getLocalVisibleRect(rect)) {
                                    jSONObject = zzl(context, rect);
                                } else {
                                    jSONObject = new JSONObject();
                                    jSONObject.put("width", 0);
                                    jSONObject.put("height", 0);
                                    jSONObject.put("x", zzfVar2.zzb(context, iArr3[0] - iArr2[0]));
                                    jSONObject.put("y", zzfVar2.zzb(context, iArr3[1] - iArr2[1]));
                                    jSONObject.put("relative_to", "ad_view");
                                }
                                jSONObject3.put("visible_bounds", jSONObject);
                                if (((String) entry.getKey()).equals("3010")) {
                                    zzbcv zzbcvVar = zzbde.zzio;
                                    zzbd zzbdVar = zzbd.zza;
                                    zzbdc zzbdcVar = zzbdVar.zzd;
                                    zzbdc zzbdcVar2 = zzbdVar.zzd;
                                    if (((Boolean) zzbdcVar.zzb(zzbcvVar)).booleanValue()) {
                                        jSONObject3.put("mediaview_graphics_matrix", view2.getMatrix().toShortString());
                                    }
                                    if (((Boolean) zzbdcVar2.zzb(zzbde.zzip)).booleanValue()) {
                                        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                                        jSONObject3.put("view_width_layout_type", zzm(layoutParams.width) - 1);
                                        jSONObject3.put("view_height_layout_type", zzm(layoutParams.height) - 1);
                                    }
                                    if (((Boolean) zzbdcVar2.zzb(zzbde.zziq)).booleanValue()) {
                                        ArrayList arrayList = new ArrayList();
                                        arrayList.add(Integer.valueOf(view2.getId()));
                                        for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                            arrayList.add(Integer.valueOf(((View) parent).getId()));
                                        }
                                        jSONObject3.put("view_path", TextUtils.join("/", arrayList));
                                    }
                                    if (scaleType != null) {
                                        jSONObject3.put("mediaview_scale_type", scaleType.ordinal());
                                    }
                                }
                                if (view2 instanceof TextView) {
                                    try {
                                        TextView textView = (TextView) view2;
                                        jSONObject3.put("text_color", textView.getCurrentTextColor());
                                        iArr = iArr2;
                                        try {
                                            jSONObject3.put("font_size", textView.getTextSize());
                                            jSONObject3.put("text", textView.getText());
                                        } catch (JSONException unused) {
                                            map3 = map2;
                                            jSONObject2 = jSONObject5;
                                            int i2 = zze.$r8$clinit;
                                            zzo.zzj("Unable to get asset views information");
                                            map4 = map3;
                                            iArr2 = iArr;
                                            i = 2;
                                            it = it2;
                                        }
                                    } catch (JSONException unused2) {
                                        iArr = iArr2;
                                    }
                                } else {
                                    iArr = iArr2;
                                }
                                map3 = map2;
                                if (map3 != null) {
                                    try {
                                        if (map3.containsKey(entry.getKey()) && view2.isClickable()) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                    } catch (JSONException unused3) {
                                        jSONObject2 = jSONObject5;
                                        int i3 = zze.$r8$clinit;
                                        zzo.zzj("Unable to get asset views information");
                                        map4 = map3;
                                        iArr2 = iArr;
                                        i = 2;
                                        it = it2;
                                    }
                                } else {
                                    z = false;
                                }
                                jSONObject3.put("is_clickable", z);
                                if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzir)).booleanValue()) {
                                    jSONObject3.put("alpha", view2.getAlpha());
                                }
                                jSONObject2 = jSONObject5;
                                try {
                                    jSONObject2.put((String) entry.getKey(), jSONObject3);
                                } catch (JSONException unused4) {
                                    int i4 = zze.$r8$clinit;
                                    zzo.zzj("Unable to get asset views information");
                                }
                            } catch (JSONException unused5) {
                                map3 = map2;
                                iArr = iArr2;
                                jSONObject2 = jSONObject5;
                                int i5 = zze.$r8$clinit;
                                zzo.zzj("Unable to get asset views information");
                                map4 = map3;
                                iArr2 = iArr;
                                i = 2;
                                it = it2;
                            }
                        } catch (JSONException unused6) {
                            map3 = map4;
                        }
                    } catch (JSONException unused7) {
                        map3 = map4;
                        iArr = iArr2;
                    }
                    map4 = map3;
                    iArr2 = iArr;
                    i = 2;
                    it = it2;
                }
            }
        }
        return jSONObject2;
    }

    public static JSONObject zze(Context context, View view) {
        JSONObject jSONObject = new JSONObject();
        if (view != null) {
            try {
                zzs zzsVar = zzv.zza.zzd;
                jSONObject.put("can_show_on_lock_screen", zzs.zzo(view));
                boolean z = false;
                if (context != null) {
                    Object systemService = context.getSystemService("keyguard");
                    KeyguardManager keyguardManager = (systemService == null || !(systemService instanceof KeyguardManager)) ? null : (KeyguardManager) systemService;
                    if (keyguardManager != null && keyguardManager.isKeyguardLocked()) {
                        z = true;
                    }
                }
                jSONObject.put("is_keyguard_locked", z);
            } catch (JSONException unused) {
                int i = zze.$r8$clinit;
                zzo.zzj("Unable to get lock screen information");
            }
        }
        return jSONObject;
    }

    public static JSONObject zzf(Context context) {
        JSONObject jSONObject = new JSONObject();
        zzs zzsVar = zzv.zza.zzd;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        try {
            int i = displayMetrics.widthPixels;
            zzbb zzbbVar = zzbb.zzb;
            jSONObject.put("width", zzbbVar.zzc.zzb(context, i));
            jSONObject.put("height", zzbbVar.zzc.zzb(context, displayMetrics.heightPixels));
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static JSONObject zzg(View view) {
        JSONObject jSONObject = new JSONObject();
        if (view != null) {
            try {
                boolean z = true;
                if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzin)).booleanValue()) {
                    zzs zzsVar = zzv.zza.zzd;
                    ViewParent parent = view.getParent();
                    while (parent != null && !(parent instanceof ScrollView)) {
                        parent = parent.getParent();
                    }
                    jSONObject.put("contained_in_scroll_view", parent != null);
                } else {
                    zzs zzsVar2 = zzv.zza.zzd;
                    ViewParent parent2 = view.getParent();
                    while (parent2 != null && !(parent2 instanceof AdapterView)) {
                        parent2 = parent2.getParent();
                    }
                    if ((parent2 == null ? -1 : ((AdapterView) parent2).getPositionForView(view)) == -1) {
                        z = false;
                    }
                    jSONObject.put("contained_in_scroll_view", z);
                }
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    public static boolean zzi(Context context, zzfca zzfcaVar) {
        if (!zzfcaVar.zzN) {
            return false;
        }
        zzbcv zzbcvVar = zzbde.zzis;
        zzbd zzbdVar = zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            return ((Boolean) zzbdVar.zzd.zzb(zzbde.zziv)).booleanValue();
        }
        String str = (String) zzbdVar.zzd.zzb(zzbde.zzit);
        if (!str.isEmpty() && context != null) {
            String packageName = context.getPackageName();
            Iterator it = zzfwe.zzb(zzfva.zzc(';')).zzd(str).iterator();
            while (it.hasNext()) {
                if (((String) it.next()).equals(packageName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean zzj(int i) {
        zzbcv zzbcvVar = zzbde.zzdL;
        zzbd zzbdVar = zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            return ((Boolean) zzbdVar.zzd.zzb(zzbde.zzdM)).booleanValue() || i <= 15299999;
        }
        return true;
    }

    public static JSONObject zzl(Context context, Rect rect) {
        JSONObject jSONObject = new JSONObject();
        int i = rect.right - rect.left;
        zzbb zzbbVar = zzbb.zzb;
        jSONObject.put("width", zzbbVar.zzc.zzb(context, i));
        int i2 = rect.bottom - rect.top;
        zzf zzfVar = zzbbVar.zzc;
        jSONObject.put("height", zzfVar.zzb(context, i2));
        jSONObject.put("x", zzfVar.zzb(context, rect.left));
        jSONObject.put("y", zzfVar.zzb(context, rect.top));
        jSONObject.put("relative_to", "self");
        return jSONObject;
    }

    public static int zzm(int i) {
        if (i != -2) {
            return i != -1 ? 2 : 3;
        }
        return 4;
    }

    public abstract InputFilter[] getFilters(InputFilter[] inputFilterArr);

    public abstract void setAllCaps(boolean z);

    public abstract void setEnabled(boolean z);

    /* JADX WARN: Code duplicated, block: B:43:0x0138  */
    public static JSONObject zzh(Context context, View view) {
        String str;
        byte b;
        JSONObject jSONObjectZzl;
        JSONObject jSONObject = new JSONObject();
        if (view != null) {
            try {
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                int[] iArr2 = {view.getMeasuredWidth(), view.getMeasuredHeight()};
                for (ViewParent parent = view.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    iArr2[0] = Math.min(viewGroup.getMeasuredWidth(), iArr2[0]);
                    iArr2[1] = Math.min(viewGroup.getMeasuredHeight(), iArr2[1]);
                }
                JSONObject jSONObject2 = new JSONObject();
                int measuredWidth = view.getMeasuredWidth();
                zzbb zzbbVar = zzbb.zzb;
                zzf zzfVar = zzbbVar.zzc;
                zzf zzfVar2 = zzbbVar.zzc;
                jSONObject2.put("width", zzfVar.zzb(context, measuredWidth));
                jSONObject2.put("height", zzfVar2.zzb(context, view.getMeasuredHeight()));
                jSONObject2.put("x", zzfVar2.zzb(context, iArr[0]));
                jSONObject2.put("y", zzfVar2.zzb(context, iArr[1]));
                jSONObject2.put("maximum_visible_width", zzfVar2.zzb(context, iArr2[0]));
                jSONObject2.put("maximum_visible_height", zzfVar2.zzb(context, iArr2[1]));
                jSONObject2.put("relative_to", "window");
                jSONObject.put(JrbhsraGtto.BViGea, jSONObject2);
                Rect rect = new Rect();
                if (view.getGlobalVisibleRect(rect)) {
                    jSONObjectZzl = zzl(context, rect);
                } else {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("width", 0);
                    jSONObject3.put("height", 0);
                    jSONObject3.put("x", zzfVar2.zzb(context, iArr[0]));
                    jSONObject3.put("y", zzfVar2.zzb(context, iArr[1]));
                    jSONObject3.put("relative_to", "window");
                    jSONObjectZzl = jSONObject3;
                }
                jSONObject.put("visible_bounds", jSONObjectZzl);
            } catch (Exception unused) {
                int i = zze.$r8$clinit;
                zzo.zzj("Unable to get native ad view bounding box");
            }
            ViewParent parent2 = view.getParent();
            if (parent2 != null) {
                try {
                    str = (String) parent2.getClass().getMethod("getTemplateTypeName", null).invoke(parent2, null);
                } catch (IllegalAccessException e) {
                    e = e;
                    int i2 = zze.$r8$clinit;
                    zzo.zzh("Cannot access method getTemplateTypeName: ", e);
                    str = "";
                } catch (NoSuchMethodException unused2) {
                    str = "";
                } catch (SecurityException e2) {
                    e = e2;
                    int i3 = zze.$r8$clinit;
                    zzo.zzh("Cannot access method getTemplateTypeName: ", e);
                    str = "";
                } catch (InvocationTargetException e3) {
                    e = e3;
                    int i4 = zze.$r8$clinit;
                    zzo.zzh("Cannot access method getTemplateTypeName: ", e);
                    str = "";
                }
            } else {
                str = "";
            }
            try {
                int iHashCode = str.hashCode();
                if (iHashCode != -2066603854) {
                    if (iHashCode == 2019754500 && str.equals(DaWYVMJ.KFwlqO)) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                } else if (str.equals("small_template")) {
                    b = 0;
                } else {
                    b = -1;
                }
                if (b == 0) {
                    jSONObject.put("native_template_type", 1);
                } else if (b != 1) {
                    jSONObject.put("native_template_type", 0);
                } else {
                    jSONObject.put("native_template_type", 2);
                }
            } catch (JSONException e4) {
                int i5 = zze.$r8$clinit;
                zzo.zzh("Could not log native template signal to JSON", e4);
            }
            if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzip)).booleanValue()) {
                try {
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    jSONObject.put("view_width_layout_type", zzm(layoutParams.width) - 1);
                    jSONObject.put("view_height_layout_type", zzm(layoutParams.height) - 1);
                } catch (Exception unused3) {
                    zze.zza("Unable to get native ad view layout types");
                }
            }
            if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzir)).booleanValue()) {
                try {
                    jSONObject.put("alpha", view.getAlpha());
                } catch (JSONException e5) {
                    int i6 = zze.$r8$clinit;
                    zzo.zzh("Could not log container view alpha signal to JSON", e5);
                }
            }
        }
        return jSONObject;
    }
}
