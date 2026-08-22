package kotlin.text;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Process;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.work.ContentUriTriggers;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventDiskStore$MovedClassObjectInputStream;
import com.facebook.appevents.PersistedEvents;
import com.facebook.appevents.suggestedevents.naLU.DaWYVMJ;
import com.facebook.internal.Utility;
import com.facebook.login.vu.dLDI;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.games.snapshot.Xa.JrbhsraGtto;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzfse;
import com.google.android.gms.internal.ads.zzfsf;
import com.google.android.gms.internal.ads.zzfsg;
import com.google.android.gms.internal.ads.zzfva;
import com.google.android.gms.internal.ads.zzfwe;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.collections.AbstractCollection$toString$1;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.sequences.TransformingSequence;
import okio.AsyncTimeout;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class StringsKt__IndentKt {
    public static Class unityPlayer;

    public static void appendElement(StringBuilder sb, Object obj, Function1 function1) {
        if (function1 != null) {
            sb.append((CharSequence) function1.invoke(obj));
            return;
        }
        if (obj == null ? true : obj instanceof CharSequence) {
            sb.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            sb.append(((Character) obj).charValue());
        } else {
            sb.append((CharSequence) String.valueOf(obj));
        }
    }

    public static final boolean arrayRangeEquals(byte[] a, int i, byte[] b, int i2, int i3) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        for (int i4 = 0; i4 < i3; i4++) {
            if (a[i4 + i] != b[i4 + i2]) {
                return false;
            }
        }
        return true;
    }

    public static String badPositionIndex(int i, int i2, String str) {
        if (i < 0) {
            return AsyncTimeout.Companion.lenientFormat("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return AsyncTimeout.Companion.lenientFormat(DaWYVMJ.fVCGGZnyba, str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i2, "negative size: "));
    }

    /* JADX WARN: Code duplicated, block: B:50:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static ContentUriTriggers byteArrayToContentUriTriggers(byte[] bArr) throws Throwable {
        Throwable th;
        ObjectInputStream objectInputStream;
        IOException e;
        ContentUriTriggers contentUriTriggers = new ContentUriTriggers();
        if (bArr == null) {
            return contentUriTriggers;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ObjectInputStream objectInputStream2 = null;
        try {
            try {
                try {
                    objectInputStream = new ObjectInputStream(byteArrayInputStream);
                    try {
                        for (int i = objectInputStream.readInt(); i > 0; i--) {
                            contentUriTriggers.mTriggers.add(new ContentUriTriggers.Trigger(Uri.parse(objectInputStream.readUTF()), objectInputStream.readBoolean()));
                        }
                        try {
                            objectInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        byteArrayInputStream.close();
                    } catch (IOException e3) {
                        e = e3;
                        e.printStackTrace();
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        byteArrayInputStream.close();
                    }
                } catch (IOException e5) {
                    objectInputStream = null;
                    e = e5;
                } catch (Throwable th2) {
                    th = th2;
                    if (0 != 0) {
                        try {
                            objectInputStream2.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    try {
                        byteArrayInputStream.close();
                        throw th;
                    } catch (IOException e7) {
                        e7.printStackTrace();
                        throw th;
                    }
                }
                return contentUriTriggers;
            } catch (Throwable th3) {
                th = th3;
                if (0 != 0) {
                    objectInputStream2.close();
                }
                byteArrayInputStream.close();
                throw th;
            }
        } catch (IOException e8) {
            e8.printStackTrace();
        }
    }

    public static void checkArgument(boolean z, String str, Serializable serializable) {
        if (!z) {
            throw new IllegalArgumentException(AsyncTimeout.Companion.lenientFormat(str, serializable));
        }
    }

    public static void checkElementIndex(int i, int i2) {
        String strLenientFormat;
        if (i < 0 || i >= i2) {
            if (i < 0) {
                strLenientFormat = AsyncTimeout.Companion.lenientFormat("%s (%s) must not be negative", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i));
            } else {
                if (i2 < 0) {
                    throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i2, "negative size: "));
                }
                strLenientFormat = AsyncTimeout.Companion.lenientFormat("%s (%s) must be less than size (%s)", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i), Integer.valueOf(i2));
            }
            throw new IndexOutOfBoundsException(strLenientFormat);
        }
    }

    public static final void checkOffsetAndCount(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException("size=" + j + " offset=" + j2 + " byteCount=" + j3);
        }
    }

    public static void checkPositionIndex(int i, int i2) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(badPositionIndex(i, i2, FirebaseAnalytics.Param.INDEX));
        }
    }

    public static void checkPositionIndexes(int i, int i2, int i3) {
        String strBadPositionIndex;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                strBadPositionIndex = badPositionIndex(i, i3, "start index");
            } else {
                strBadPositionIndex = (i2 < 0 || i2 > i3) ? badPositionIndex(i2, i3, "end index") : AsyncTimeout.Companion.lenientFormat("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(strBadPositionIndex);
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static boolean copyToFile(File file, InputStream inputStream) throws Throwable {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file, false);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            closeQuietly(fileOutputStream2);
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                            return true;
                        }
                        fileOutputStream2.write(bArr, 0, i);
                    }
                } catch (IOException e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
                    closeQuietly(fileOutputStream);
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    closeQuietly(fileOutputStream);
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    public static final Result.Failure createFailure(Throwable exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        return new Result.Failure(exception);
    }

    public static Set getExclusions() {
        try {
            Object objInvoke = Class.forName("android.text.EmojiConsistency").getMethod("getEmojiConsistencySet", null).invoke(null, null);
            if (objInvoke == null) {
                return Collections.emptySet();
            }
            Set set = (Set) objInvoke;
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (!(it.next() instanceof int[])) {
                    return Collections.emptySet();
                }
            }
            return set;
        } catch (Throwable unused) {
            return Collections.emptySet();
        }
    }

    public static File getTempFile(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        for (int i = 0; i < 100; i++) {
            File file = new File(cacheDir, str + i);
            try {
                if (file.createNewFile()) {
                    return file;
                }
            } catch (IOException unused) {
            }
        }
        return null;
    }

    public static int intToBackoffPolicy(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "Could not convert ", DaWYVMJ.hBeg));
    }

    public static int intToNetworkType(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 3;
        }
        if (i == 3) {
            return 4;
        }
        if (i == 4) {
            return 5;
        }
        if (Build.VERSION.SDK_INT < 30 || i != 5) {
            throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "Could not convert ", " to NetworkType"));
        }
        return 6;
    }

    public static int intToOutOfQuotaPolicy(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "Could not convert ", " to OutOfQuotaPolicy"));
    }

    public static int intToState(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 3;
        }
        if (i == 3) {
            return 4;
        }
        if (i == 4) {
            return 5;
        }
        if (i == 5) {
            return 6;
        }
        throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "Could not convert ", " to State"));
    }

    public static MappedByteBuffer mmap(Context context, Uri uri) {
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", null);
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    parcelFileDescriptorOpenFileDescriptor.close();
                }
                return null;
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                try {
                    FileChannel channel = fileInputStream.getChannel();
                    MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                    fileInputStream.close();
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return map;
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    parcelFileDescriptorOpenFileDescriptor.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public static final int reverseBytes(int i) {
        return ((i & 255) << 24) | (((-16777216) & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    public static final void saveEventsToDisk$facebook_core_release(PersistedEvents persistedEvents) {
        Context applicationContext = FacebookSdk.getApplicationContext();
        ObjectOutputStream objectOutputStream = null;
        try {
            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new BufferedOutputStream(applicationContext.openFileOutput("AppEventsLogger.persistedevents", 0)));
            try {
                objectOutputStream2.writeObject(persistedEvents);
                Utility.closeQuietly(objectOutputStream2);
            } catch (Throwable th) {
                th = th;
                objectOutputStream = objectOutputStream2;
                try {
                    Log.w("com.facebook.appevents.AppEventDiskStore", "Got unexpected exception while persisting events: ", th);
                    try {
                        applicationContext.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                    } catch (Exception unused) {
                    }
                } finally {
                    Utility.closeQuietly(objectOutputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static final void sendMessage(String str, String str2) {
        try {
            if (unityPlayer == null) {
                unityPlayer = Class.forName("com.unity3d.player.UnityPlayer");
            }
            Class cls = unityPlayer;
            if (cls == null) {
                Intrinsics.throwUninitializedPropertyAccessException("unityPlayer");
                throw null;
            }
            Method method = cls.getMethod("UnitySendMessage", String.class, String.class, String.class);
            Class cls2 = unityPlayer;
            if (cls2 != null) {
                method.invoke(cls2, "UnityFacebookSDKPlugin", str, str2);
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("unityPlayer");
                throw null;
            }
        } catch (Exception e) {
            Log.e("com.facebook.appevents.codeless.internal.UnityReflection", "Failed to send message to Unity", e);
        }
    }

    public static int stateToInt(int i) {
        int iOrdinal = Fragment$$ExternalSyntheticOutline0.ordinal(i);
        if (iOrdinal == 0) {
            return 0;
        }
        int i2 = 1;
        if (iOrdinal != 1) {
            i2 = 2;
            if (iOrdinal != 2) {
                i2 = 3;
                if (iOrdinal != 3) {
                    i2 = 4;
                    if (iOrdinal != 4) {
                        if (iOrdinal == 5) {
                            return 5;
                        }
                        throw new IllegalArgumentException("Could not convert " + CoroutineAdapterKt$$ExternalSyntheticLambda0.stringValueOf$3(i) + " to int");
                    }
                }
            }
        }
        return i2;
    }

    public static final void throwOnFailure(Object obj) throws Throwable {
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).exception;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x005d A[PHI: r8
  0x005d: PHI (r8v2 java.lang.String) = (r8v1 java.lang.String), (r8v3 java.lang.String) binds: [B:13:0x005b, B:29:0x0092] A[DONT_GENERATE, DONT_INLINE]] */
    public static String trimMargin$default(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (StringsKt__StringsKt.isBlank("|")) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.");
        }
        List list = SequencesKt.toList(new TransformingSequence(StringsKt__StringsKt.rangesDelimitedBy$StringsKt__StringsKt$default(str, new String[]{"\r\n", "\n", "\r"}, false, 0), new AbstractCollection$toString$1(str, 1)));
        int length = str.length();
        list.size();
        int size = list.size() - 1;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                throw new ArithmeticException("Index overflow has happened.");
            }
            String str2 = (String) obj;
            String strSubstring = null;
            if ((i == 0 || i == size) && StringsKt__StringsKt.isBlank(str2)) {
                str2 = strSubstring;
            } else {
                int length2 = str2.length();
                int i3 = 0;
                while (true) {
                    if (i3 >= length2) {
                        i3 = -1;
                        break;
                    }
                    char cCharAt = str2.charAt(i3);
                    if (!Character.isWhitespace(cCharAt) && !Character.isSpaceChar(cCharAt)) {
                        break;
                    }
                    i3++;
                }
                if (i3 != -1 && StringsKt__StringsKt.startsWith(str2, i3, "|", false)) {
                    strSubstring = str2.substring("|".length() + i3);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                }
                if (strSubstring != null) {
                    str2 = strSubstring;
                }
            }
            if (str2 != null) {
                arrayList.add(str2);
            }
            i = i2;
        }
        StringBuilder sb = new StringBuilder(length);
        CollectionsKt.joinTo(arrayList, sb, "\n", "", "", -1, "...", null);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return string;
    }

    public static void writeTypedObject(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        }
    }

    public static Bundle zzb(Context context, String str) {
        JSONArray jSONArray;
        int i;
        Object obj;
        SharedPreferences sharedPreferences;
        String str2;
        if (TextUtils.isEmpty(str)) {
            jSONArray = null;
        } else {
            try {
                jSONArray = new JSONArray(str);
            } catch (JSONException e) {
                int i2 = zze.$r8$clinit;
                zzo.zzf("JSON parsing error", e);
                jSONArray = null;
            }
        }
        if (jSONArray == null) {
            return Bundle.EMPTY;
        }
        Bundle bundle = new Bundle();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i3);
            String strOptString = jSONObjectOptJSONObject.optString("bk");
            String strOptString2 = jSONObjectOptJSONObject.optString("sk");
            int iOptInt = jSONObjectOptJSONObject.optInt("type", -1);
            if (iOptInt == 0) {
                i = 1;
            } else if (iOptInt != 1) {
                i = iOptInt != 2 ? 0 : 3;
            } else {
                i = 2;
            }
            if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2) && i != 0) {
                List listZzf = zzfwe.zzb(zzfva.zzc('/')).zzf(strOptString2);
                if (listZzf.size() > 2 || listZzf.isEmpty()) {
                    obj = null;
                } else {
                    if (listZzf.size() == 1) {
                        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                        str2 = (String) listZzf.get(0);
                    } else {
                        sharedPreferences = context.getSharedPreferences((String) listZzf.get(0), 0);
                        str2 = (String) listZzf.get(1);
                    }
                    obj = sharedPreferences.getAll().get(str2);
                }
                if (obj != null) {
                    int i4 = i - 1;
                    if (i4 != 0) {
                        if (i4 != 1) {
                            if (obj instanceof Boolean) {
                                bundle.putBoolean(strOptString, ((Boolean) obj).booleanValue());
                            }
                        } else if (obj instanceof Integer) {
                            bundle.putInt(strOptString, ((Integer) obj).intValue());
                        } else if (obj instanceof Long) {
                            bundle.putLong(strOptString, ((Long) obj).longValue());
                        } else if (obj instanceof Float) {
                            bundle.putFloat(strOptString, ((Float) obj).floatValue());
                        }
                    } else if (obj instanceof String) {
                        bundle.putString(strOptString, (String) obj);
                    }
                }
            }
        }
        return bundle;
    }

    public static void zzc(Context context) {
        if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzgv)).booleanValue() && context != null) {
            context.deleteDatabase("OfflineUpload.db");
        }
        try {
            zzfse zzfseVarZzj = zzfse.zzj(context);
            zzfsf zzfsfVarZzi = zzfsf.zzi(context);
            zzfsg zzfsgVarZza = zzfsg.zza(context);
            zzfseVarZzj.zzk();
            zzfseVarZzj.zzl();
            zzfsfVarZzi.zzj();
            zzfsgVarZza.zzb(null);
        } catch (IOException e) {
            zzv.zza.zzi.zzw(e, "clearStorageOnIdlessMode");
        }
        try {
            if (context.getSharedPreferences("query_info_shared_prefs", 0).edit().clear().commit()) {
            } else {
                throw new IOException("Failed to remove query_info_shared_prefs");
            }
        } catch (IOException e2) {
            zzv.zza.zzi.zzw(e2, "clearStorageOnIdlessMode_scar");
        }
    }

    public static final synchronized PersistedEvents readAndClearStore() {
        PersistedEvents persistedEvents;
        Throwable th;
        AppEventDiskStore$MovedClassObjectInputStream appEventDiskStore$MovedClassObjectInputStream;
        String str;
        String str2;
        Context applicationContext = FacebookSdk.getApplicationContext();
        persistedEvents = null;
        try {
            try {
                FileInputStream fileInputStreamOpenFileInput = applicationContext.openFileInput("AppEventsLogger.persistedevents");
                Intrinsics.checkNotNullExpressionValue(fileInputStreamOpenFileInput, "context.openFileInput(PERSISTED_EVENTS_FILENAME)");
                appEventDiskStore$MovedClassObjectInputStream = new AppEventDiskStore$MovedClassObjectInputStream(new BufferedInputStream(fileInputStreamOpenFileInput));
                try {
                    Object object = appEventDiskStore$MovedClassObjectInputStream.readObject();
                    if (object == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.PersistedEvents");
                    }
                    PersistedEvents persistedEvents2 = (PersistedEvents) object;
                    Utility.closeQuietly(appEventDiskStore$MovedClassObjectInputStream);
                    try {
                        applicationContext.getFileStreamPath(dLDI.ncmvGAvjzJUV).delete();
                    } catch (Exception e) {
                        Log.w("com.facebook.appevents.AppEventDiskStore", "Got unexpected exception when removing events file: ", e);
                    }
                    persistedEvents = persistedEvents2;
                    if (persistedEvents == null) {
                        persistedEvents = new PersistedEvents();
                    }
                } catch (FileNotFoundException unused) {
                    Utility.closeQuietly(appEventDiskStore$MovedClassObjectInputStream);
                    try {
                        applicationContext.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                    } catch (Exception e2) {
                        e = e2;
                        str = JrbhsraGtto.IKcpZk;
                        str2 = "Got unexpected exception when removing events file: ";
                        Log.w(str, str2, e);
                    }
                } catch (Exception e3) {
                    e = e3;
                    Log.w("com.facebook.appevents.AppEventDiskStore", "Got unexpected exception while reading events: ", e);
                    Utility.closeQuietly(appEventDiskStore$MovedClassObjectInputStream);
                    try {
                        applicationContext.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                    } catch (Exception e4) {
                        e = e4;
                        str = "com.facebook.appevents.AppEventDiskStore";
                        str2 = "Got unexpected exception when removing events file: ";
                        Log.w(str, str2, e);
                    }
                }
            } catch (FileNotFoundException unused2) {
                appEventDiskStore$MovedClassObjectInputStream = null;
            } catch (Exception e5) {
                e = e5;
                appEventDiskStore$MovedClassObjectInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                Utility.closeQuietly(null);
                try {
                    applicationContext.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                } catch (Exception e6) {
                    Log.w("com.facebook.appevents.AppEventDiskStore", "Got unexpected exception when removing events file: ", e6);
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            Utility.closeQuietly(null);
            applicationContext.getFileStreamPath("AppEventsLogger.persistedevents").delete();
            throw th;
        }
        return persistedEvents;
    }

    public static boolean copyToFile(File file, Resources resources, int i) throws Throwable {
        InputStream inputStreamOpenRawResource;
        try {
            inputStreamOpenRawResource = resources.openRawResource(i);
            try {
                boolean zCopyToFile = copyToFile(file, inputStreamOpenRawResource);
                closeQuietly(inputStreamOpenRawResource);
                return zCopyToFile;
            } catch (Throwable th) {
                th = th;
                closeQuietly(inputStreamOpenRawResource);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStreamOpenRawResource = null;
        }
    }
}
