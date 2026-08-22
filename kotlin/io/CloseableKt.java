package kotlin.io;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Trace;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.TooltipCompat$Api26Impl;
import androidx.appcompat.widget.TooltipCompatHandler;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.AuthenticationToken;
import com.facebook.FacebookException;
import com.facebook.appevents.AppEventsLoggerImpl;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.android.gms.ads.rewarded.zQ.yzwzcWHcnH;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.measurement.internal.RVw.ZRqOdXiy;
import com.google.firebase.components.Component;
import com.google.firebase.components.CycleDetector$ComponentNode;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.DependencyCycleException;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import kotlin.ExceptionsKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.TlsVersion;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CloseableKt {
    public static Method sIsTagEnabledMethod;
    public static long sTraceTagApp;
    public static Context zza;
    public static Boolean zzb;

    public static final void closeFinally(Closeable closeable, Throwable th) throws IOException {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                ExceptionsKt.addSuppressed(th, th2);
            }
        }
    }

    public static AccessToken createAccessTokenFromWebBundle(HashSet hashSet, Bundle bundle, AccessTokenSource accessTokenSource, String applicationId) {
        Collection collectionArrayListOf;
        ArrayList arrayListArrayListOf;
        ArrayList arrayListArrayListOf2;
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, "expires_in", new Date());
        String string = bundle.getString("access_token");
        if (string == null) {
            return null;
        }
        Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle, "data_access_expiration_time", new Date(0L));
        String string2 = bundle.getString("granted_scopes");
        if (string2 == null || string2.length() <= 0) {
            collectionArrayListOf = hashSet;
        } else {
            Object[] array = StringsKt__StringsKt.split$default(string2, new String[]{","}, 0, 6).toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            String[] strArr = (String[]) array;
            collectionArrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Arrays.copyOf(strArr, strArr.length));
        }
        String string3 = bundle.getString("denied_scopes");
        if (string3 == null || string3.length() <= 0) {
            arrayListArrayListOf = null;
        } else {
            Object[] array2 = StringsKt__StringsKt.split$default(string3, new String[]{","}, 0, 6).toArray(new String[0]);
            if (array2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            String[] strArr2 = (String[]) array2;
            arrayListArrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Arrays.copyOf(strArr2, strArr2.length));
        }
        String string4 = bundle.getString("expired_scopes");
        if (string4 == null || string4.length() <= 0) {
            arrayListArrayListOf2 = null;
        } else {
            Object[] array3 = StringsKt__StringsKt.split$default(string4, new String[]{","}, 0, 6).toArray(new String[0]);
            if (array3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            String[] strArr3 = (String[]) array3;
            arrayListArrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(Arrays.copyOf(strArr3, strArr3.length));
        }
        if (Utility.isNullOrEmpty(string)) {
            return null;
        }
        String string5 = bundle.getString("graph_domain");
        String string6 = bundle.getString("signed_request");
        if (string6 == null || string6.length() == 0) {
            throw new FacebookException("Authorization response does not contain the signed_request");
        }
        try {
            Object[] array4 = StringsKt__StringsKt.split$default(string6, new String[]{"."}, 0, 6).toArray(new String[0]);
            if (array4 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            String[] strArr4 = (String[]) array4;
            if (strArr4.length == 2) {
                byte[] data = Base64.decode(strArr4[1], 0);
                Intrinsics.checkNotNullExpressionValue(data, "data");
                String string7 = new JSONObject(new String(data, Charsets.UTF_8)).getString("user_id");
                Intrinsics.checkNotNullExpressionValue(string7, "jsonObject.getString(\"user_id\")");
                return new AccessToken(string, applicationId, string7, collectionArrayListOf, arrayListArrayListOf, arrayListArrayListOf2, accessTokenSource, bundleLongAsDate, new Date(), bundleLongAsDate2, string5);
            }
            throw new FacebookException("Failed to retrieve user_id from signed_request");
        } catch (UnsupportedEncodingException | JSONException unused) {
        }
    }

    public static AuthenticationToken createAuthenticationTokenFromWebBundle(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        String string = bundle.getString("id_token");
        if (string == null || string.length() == 0 || str == null || str.length() == 0) {
            return null;
        }
        try {
            return new AuthenticationToken(string, str);
        } catch (Exception e) {
            throw new FacebookException(e.getMessage(), e);
        }
    }

    public static void detect(List list) {
        HashMap map = new HashMap(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Component component = (Component) it.next();
            CycleDetector$ComponentNode cycleDetector$ComponentNode = new CycleDetector$ComponentNode(component);
            for (final Class cls : component.getProvidedInterfaces()) {
                boolean zIsValue = component.isValue();
                final boolean z = !zIsValue;
                Object obj = new Object(cls, z) { // from class: com.google.firebase.components.CycleDetector$Dep
                    public final Class anInterface;
                    public final boolean set;

                    {
                        this.anInterface = cls;
                        this.set = z;
                    }

                    public final boolean equals(Object obj2) {
                        if (!(obj2 instanceof CycleDetector$Dep)) {
                            return false;
                        }
                        CycleDetector$Dep cycleDetector$Dep = (CycleDetector$Dep) obj2;
                        return cycleDetector$Dep.anInterface.equals(this.anInterface) && cycleDetector$Dep.set == this.set;
                    }

                    public final int hashCode() {
                        return ((this.anInterface.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.set).hashCode();
                    }
                };
                if (!map.containsKey(obj)) {
                    map.put(obj, new HashSet());
                }
                Set set = (Set) map.get(obj);
                if (!set.isEmpty() && zIsValue) {
                    throw new IllegalArgumentException("Multiple components provide " + cls + ".");
                }
                set.add(cycleDetector$ComponentNode);
            }
        }
        Iterator it2 = map.values().iterator();
        while (it2.hasNext()) {
            for (CycleDetector$ComponentNode cycleDetector$ComponentNode2 : (Set) it2.next()) {
                for (Dependency dependency : cycleDetector$ComponentNode2.component.getDependencies()) {
                    if (dependency.isDirectInjection()) {
                        final Class<?> cls2 = dependency.getInterface();
                        final boolean zIsSet = dependency.isSet();
                        Set<CycleDetector$ComponentNode> set2 = (Set) map.get(new Object(cls2, zIsSet) { // from class: com.google.firebase.components.CycleDetector$Dep
                            public final Class anInterface;
                            public final boolean set;

                            {
                                this.anInterface = cls2;
                                this.set = zIsSet;
                            }

                            public final boolean equals(Object obj2) {
                                if (!(obj2 instanceof CycleDetector$Dep)) {
                                    return false;
                                }
                                CycleDetector$Dep cycleDetector$Dep = (CycleDetector$Dep) obj2;
                                return cycleDetector$Dep.anInterface.equals(this.anInterface) && cycleDetector$Dep.set == this.set;
                            }

                            public final int hashCode() {
                                return ((this.anInterface.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.set).hashCode();
                            }
                        });
                        if (set2 != null) {
                            for (CycleDetector$ComponentNode cycleDetector$ComponentNode3 : set2) {
                                cycleDetector$ComponentNode2.dependencies.add(cycleDetector$ComponentNode3);
                                cycleDetector$ComponentNode3.dependents.add(cycleDetector$ComponentNode2);
                            }
                        }
                    }
                }
            }
        }
        HashSet<CycleDetector$ComponentNode> hashSet = new HashSet();
        Iterator it3 = map.values().iterator();
        while (it3.hasNext()) {
            hashSet.addAll((Set) it3.next());
        }
        HashSet hashSet2 = new HashSet();
        for (CycleDetector$ComponentNode cycleDetector$ComponentNode4 : hashSet) {
            if (cycleDetector$ComponentNode4.dependents.isEmpty()) {
                hashSet2.add(cycleDetector$ComponentNode4);
            }
        }
        int i = 0;
        while (!hashSet2.isEmpty()) {
            CycleDetector$ComponentNode cycleDetector$ComponentNode5 = (CycleDetector$ComponentNode) hashSet2.iterator().next();
            hashSet2.remove(cycleDetector$ComponentNode5);
            i++;
            for (CycleDetector$ComponentNode cycleDetector$ComponentNode6 : cycleDetector$ComponentNode5.dependencies) {
                cycleDetector$ComponentNode6.dependents.remove(cycleDetector$ComponentNode5);
                if (cycleDetector$ComponentNode6.dependents.isEmpty()) {
                    hashSet2.add(cycleDetector$ComponentNode6);
                }
            }
        }
        if (i == list.size()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (CycleDetector$ComponentNode cycleDetector$ComponentNode7 : hashSet) {
            if (!cycleDetector$ComponentNode7.dependents.isEmpty() && !cycleDetector$ComponentNode7.dependencies.isEmpty()) {
                arrayList.add(cycleDetector$ComponentNode7.component);
            }
        }
        throw new DependencyCycleException(arrayList);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static TlsVersion forJavaName(String javaName) {
        Intrinsics.checkNotNullParameter(javaName, "javaName");
        int iHashCode = javaName.hashCode();
        if (iHashCode != 79201641) {
            if (iHashCode != 79923350) {
                switch (iHashCode) {
                    case -503070503:
                        if (javaName.equals("TLSv1.1")) {
                            return TlsVersion.TLS_1_1;
                        }
                        break;
                    case -503070502:
                        if (javaName.equals("TLSv1.2")) {
                            return TlsVersion.TLS_1_2;
                        }
                        break;
                    case -503070501:
                        if (javaName.equals("TLSv1.3")) {
                            return TlsVersion.TLS_1_3;
                        }
                        break;
                }
            } else if (javaName.equals("TLSv1")) {
                return TlsVersion.TLS_1_0;
            }
        } else if (javaName.equals("SSLv3")) {
            return TlsVersion.SSL_3_0;
        }
        throw new IllegalArgumentException("Unexpected TLS version: ".concat(javaName));
    }

    public static boolean isEnabled() {
        try {
            if (sIsTagEnabledMethod == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        try {
            if (sIsTagEnabledMethod == null) {
                sTraceTagApp = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                sIsTagEnabledMethod = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) sIsTagEnabledMethod.invoke(null, Long.valueOf(sTraceTagApp))).booleanValue();
        } catch (Exception e) {
            if (!(e instanceof InvocationTargetException)) {
                Log.v("Trace", "Unable to call isTagEnabled via reflection", e);
                return false;
            }
            Throwable cause = e.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
    }

    public static synchronized boolean isInstantApp(Context context) {
        Boolean bool;
        Context applicationContext = context.getApplicationContext();
        Context context2 = zza;
        if (context2 != null && (bool = zzb) != null && context2 == applicationContext) {
            return bool.booleanValue();
        }
        zzb = null;
        if (Hex.isAtLeastO()) {
            zzb = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
        } else {
            try {
                context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                zzb = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                zzb = Boolean.FALSE;
            }
        }
        zza = applicationContext;
        return zzb.booleanValue();
    }

    public static void setTooltipText(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            TooltipCompat$Api26Impl.setTooltipText(view, charSequence);
            return;
        }
        TooltipCompatHandler tooltipCompatHandler = TooltipCompatHandler.sPendingHandler;
        if (tooltipCompatHandler != null && tooltipCompatHandler.mAnchor == view) {
            TooltipCompatHandler.setPendingHandler(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new TooltipCompatHandler(view, charSequence);
            return;
        }
        TooltipCompatHandler tooltipCompatHandler2 = TooltipCompatHandler.sActiveHandler;
        if (tooltipCompatHandler2 != null && tooltipCompatHandler2.mAnchor == view) {
            tooltipCompatHandler2.hide();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    public static void writeBooleanArray(Parcel parcel, int i, boolean[] zArr, boolean z) {
        if (zArr == null) {
            if (z) {
                zzc(parcel, i, 0);
            }
        } else {
            int iZza = zza(parcel, i);
            parcel.writeBooleanArray(zArr);
            zzb(parcel, iZza);
        }
    }

    public static void writeBooleanObject(Parcel parcel, int i, Boolean bool) {
        if (bool == null) {
            return;
        }
        zzc(parcel, i, 4);
        parcel.writeInt(bool.booleanValue() ? 1 : 0);
    }

    public static void writeBundle(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle == null) {
            if (z) {
                zzc(parcel, i, 0);
            }
        } else {
            int iZza = zza(parcel, i);
            parcel.writeBundle(bundle);
            zzb(parcel, iZza);
        }
    }

    public static void writeByteArray(Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr == null) {
            if (z) {
                zzc(parcel, i, 0);
            }
        } else {
            int iZza = zza(parcel, i);
            parcel.writeByteArray(bArr);
            zzb(parcel, iZza);
        }
    }

    public static void writeIBinder(Parcel parcel, int i, IBinder iBinder) {
        if (iBinder == null) {
            return;
        }
        int iZza = zza(parcel, i);
        parcel.writeStrongBinder(iBinder);
        zzb(parcel, iZza);
    }

    public static void writeIntArray(Parcel parcel, int i, int[] iArr, boolean z) {
        if (iArr == null) {
            if (z) {
                zzc(parcel, i, 0);
            }
        } else {
            int iZza = zza(parcel, i);
            parcel.writeIntArray(iArr);
            zzb(parcel, iZza);
        }
    }

    public static void writeLongObject(Parcel parcel, int i, Long l) {
        if (l == null) {
            return;
        }
        zzc(parcel, i, 8);
        parcel.writeLong(l.longValue());
    }

    public static void writeParcelable(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable == null) {
            if (z) {
                zzc(parcel, i, 0);
            }
        } else {
            int iZza = zza(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            zzb(parcel, iZza);
        }
    }

    public static void writeString(Parcel parcel, int i, String str, boolean z) {
        if (str == null) {
            if (z) {
                zzc(parcel, i, 0);
            }
        } else {
            int iZza = zza(parcel, i);
            parcel.writeString(str);
            zzb(parcel, iZza);
        }
    }

    public static void writeStringArray(Parcel parcel, int i, String[] strArr, boolean z) {
        if (strArr == null) {
            if (z) {
                zzc(parcel, i, 0);
            }
        } else {
            int iZza = zza(parcel, i);
            parcel.writeStringArray(strArr);
            zzb(parcel, iZza);
        }
    }

    public static void writeStringList(Parcel parcel, int i, List list) {
        if (list == null) {
            return;
        }
        int iZza = zza(parcel, i);
        parcel.writeStringList(list);
        zzb(parcel, iZza);
    }

    public static void writeTypedArray(Parcel parcel, int i, Parcelable[] parcelableArr, int i2) {
        if (parcelableArr == null) {
            return;
        }
        int iZza = zza(parcel, i);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int iDataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int iDataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, i2);
                int iDataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(iDataPosition);
                parcel.writeInt(iDataPosition3 - iDataPosition2);
                parcel.setDataPosition(iDataPosition3);
            }
        }
        zzb(parcel, iZza);
    }

    public static void writeTypedList(Parcel parcel, int i, List list, boolean z) {
        if (list == null) {
            if (z) {
                zzc(parcel, i, 0);
                return;
            }
            return;
        }
        int iZza = zza(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            Parcelable parcelable = (Parcelable) list.get(i2);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int iDataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int iDataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, 0);
                int iDataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(iDataPosition);
                parcel.writeInt(iDataPosition3 - iDataPosition2);
                parcel.setDataPosition(iDataPosition3);
            }
        }
        zzb(parcel, iZza);
    }

    public static int zza(Parcel parcel, int i) {
        parcel.writeInt(i | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void zzb(Parcel parcel, int i) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(iDataPosition - i);
        parcel.setDataPosition(iDataPosition);
    }

    public static void zzc(Parcel parcel, int i, int i2) {
        parcel.writeInt(i | (i2 << 16));
    }

    public void setAppearanceLightNavigationBars(boolean z) {
    }

    public abstract void setAppearanceLightStatusBars(boolean z);

    public static AccessToken createAccessTokenFromNativeLogin(Bundle bundle, String applicationId) {
        String string;
        AccessTokenSource accessTokenSource = AccessTokenSource.FACEBOOK_APPLICATION_SERVICE;
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH", new Date(0L));
        ArrayList<String> stringArrayList = bundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
        String string2 = bundle.getString("com.facebook.platform.extra.ACCESS_TOKEN");
        Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle, ZRqOdXiy.yUke, new Date(0L));
        if (string2 == null || string2.length() == 0 || (string = bundle.getString("com.facebook.platform.extra.USER_ID")) == null || string.length() == 0) {
            return null;
        }
        return new AccessToken(string2, applicationId, string, stringArrayList, null, null, accessTokenSource, bundleLongAsDate, new Date(), bundleLongAsDate2, bundle.getString("graph_domain"));
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003a A[Catch: all -> 0x0072, TRY_LEAVE, TryCatch #1 {, blocks: (B:6:0x0010, B:8:0x0016, B:15:0x0034, B:17:0x003a, B:24:0x005a, B:23:0x0057, B:14:0x0031, B:11:0x002d, B:20:0x0053), top: B:39:0x0010, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x0053 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static String getAnonymousAppDeviceGUID(Context context) {
        String strStringPlus;
        Intrinsics.checkNotNullParameter(context, "context");
        if (AppEventsLoggerImpl.access$getAnonymousAppDeviceGUID$cp() == null) {
            synchronized (AppEventsLoggerImpl.access$getStaticLock$cp()) {
                if (AppEventsLoggerImpl.access$getAnonymousAppDeviceGUID$cp() == null) {
                    String string = context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getString("anonymousAppDeviceGUID", null);
                    if (!CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
                        try {
                            AppEventsLoggerImpl.anonymousAppDeviceGUID = string;
                        } catch (Throwable th) {
                            CrashShieldHandler.handleThrowable(AppEventsLoggerImpl.class, th);
                        }
                        if (AppEventsLoggerImpl.access$getAnonymousAppDeviceGUID$cp() == null) {
                            UUID uuidRandomUUID = UUID.randomUUID();
                            Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, yzwzcWHcnH.UFeHNDeOUIWUT);
                            strStringPlus = Intrinsics.stringPlus(uuidRandomUUID, "XZ");
                            if (!CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
                                AppEventsLoggerImpl.anonymousAppDeviceGUID = strStringPlus;
                            }
                            context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putString("anonymousAppDeviceGUID", AppEventsLoggerImpl.access$getAnonymousAppDeviceGUID$cp()).apply();
                        }
                    } else if (AppEventsLoggerImpl.access$getAnonymousAppDeviceGUID$cp() == null) {
                        UUID uuidRandomUUID2 = UUID.randomUUID();
                        Intrinsics.checkNotNullExpressionValue(uuidRandomUUID2, yzwzcWHcnH.UFeHNDeOUIWUT);
                        strStringPlus = Intrinsics.stringPlus(uuidRandomUUID2, "XZ");
                        if (!CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
                            try {
                                AppEventsLoggerImpl.anonymousAppDeviceGUID = strStringPlus;
                            } catch (Throwable th2) {
                                CrashShieldHandler.handleThrowable(AppEventsLoggerImpl.class, th2);
                            }
                        }
                        context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putString("anonymousAppDeviceGUID", AppEventsLoggerImpl.access$getAnonymousAppDeviceGUID$cp()).apply();
                    }
                }
            }
        }
        String strAccess$getAnonymousAppDeviceGUID$cp = AppEventsLoggerImpl.access$getAnonymousAppDeviceGUID$cp();
        if (strAccess$getAnonymousAppDeviceGUID$cp != null) {
            return strAccess$getAnonymousAppDeviceGUID$cp;
        }
        throw new IllegalStateException("Required value was null.");
    }
}
