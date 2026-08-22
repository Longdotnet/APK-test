package okio;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Process;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.JsonWriter;
import android.view.View;
import android.view.Window;
import androidx.activity.SystemBarStyle;
import androidx.core.graphics.drawable.DrawableCompat$Api21Impl;
import androidx.core.view.inputmethod.InputConnectionCompat$$ExternalSyntheticLambda0;
import androidx.emoji2.text.flatbuffer.MetadataList;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.work.impl.utils.futures.AbstractFuture;
import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEventCollection;
import com.facebook.appevents.PersistedEvents;
import com.facebook.appevents.SessionEventsState;
import com.facebook.appevents.internal.FileDownloadTask;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.appevents.ml.Utils;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzfcf;
import com.google.firebase.inject.PVS.jIKWv;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.concurrent.onZL.mnwSv;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class AsyncTimeout extends Timeout {
    public static final long IDLE_TIMEOUT_MILLIS;
    public static final long IDLE_TIMEOUT_NANOS;
    public static AsyncTimeout head;
    public boolean inQueue;
    public AsyncTimeout next;
    public long timeoutAt;

    public final class Watchdog extends Thread {
        public final /* synthetic */ int $r8$classId = 0;

        public /* synthetic */ Watchdog(String str) {
            super(str);
        }

        private final void run$okio$AsyncTimeout$Watchdog() {
            AsyncTimeout asyncTimeoutAwaitTimeout$okio;
            while (true) {
                try {
                    synchronized (AsyncTimeout.class) {
                        AsyncTimeout asyncTimeout = AsyncTimeout.head;
                        asyncTimeoutAwaitTimeout$okio = Companion.awaitTimeout$okio();
                        if (asyncTimeoutAwaitTimeout$okio == AsyncTimeout.head) {
                            AsyncTimeout.head = null;
                            return;
                        }
                    }
                    if (asyncTimeoutAwaitTimeout$okio != null) {
                        asyncTimeoutAwaitTimeout$okio.timedOut();
                    }
                } catch (InterruptedException unused) {
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            switch (this.$r8$classId) {
                case 0:
                    run$okio$AsyncTimeout$Watchdog();
                    return;
                default:
                    Process.setThreadPriority(19);
                    synchronized (this) {
                        while (true) {
                            try {
                                wait();
                            } catch (InterruptedException unused) {
                                return;
                            }
                        }
                    }
                    break;
            }
        }

        public /* synthetic */ Watchdog(ThreadGroup threadGroup, String str) {
            super(threadGroup, str);
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final boolean exit() {
        if (!this.inQueue) {
            return false;
        }
        this.inQueue = false;
        synchronized (AsyncTimeout.class) {
            AsyncTimeout asyncTimeout = head;
            while (asyncTimeout != null) {
                AsyncTimeout asyncTimeout2 = asyncTimeout.next;
                if (asyncTimeout2 == this) {
                    asyncTimeout.next = this.next;
                    this.next = null;
                    return false;
                }
                asyncTimeout = asyncTimeout2;
            }
            return true;
        }
    }

    public void timedOut() {
    }

    public final void enter() {
        AsyncTimeout asyncTimeout;
        if (this.inQueue) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long j = this.timeoutNanos;
        boolean z = this.hasDeadline;
        if (j != 0 || z) {
            this.inQueue = true;
            synchronized (AsyncTimeout.class) {
                try {
                    if (head == null) {
                        head = new AsyncTimeout();
                        Watchdog watchdog = new Watchdog(jIKWv.cSo);
                        watchdog.setDaemon(true);
                        watchdog.start();
                    }
                    long jNanoTime = System.nanoTime();
                    if (j != 0 && z) {
                        this.timeoutAt = Math.min(j, deadlineNanoTime() - jNanoTime) + jNanoTime;
                    } else if (j != 0) {
                        this.timeoutAt = j + jNanoTime;
                    } else {
                        if (!z) {
                            throw new AssertionError();
                        }
                        this.timeoutAt = deadlineNanoTime();
                    }
                    long j2 = this.timeoutAt - jNanoTime;
                    AsyncTimeout asyncTimeout2 = head;
                    Intrinsics.checkNotNull(asyncTimeout2);
                    while (true) {
                        asyncTimeout = asyncTimeout2.next;
                        if (asyncTimeout == null || j2 < asyncTimeout.timeoutAt - jNanoTime) {
                            break;
                            break;
                        }
                        asyncTimeout2 = asyncTimeout;
                    }
                    this.next = asyncTimeout;
                    asyncTimeout2.next = this;
                    if (asyncTimeout2 == head) {
                        AsyncTimeout.class.notify();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public abstract class Companion {
        public static AsyncTimeout awaitTimeout$okio() throws InterruptedException {
            AsyncTimeout asyncTimeout = AsyncTimeout.head;
            Intrinsics.checkNotNull(asyncTimeout);
            AsyncTimeout asyncTimeout2 = asyncTimeout.next;
            if (asyncTimeout2 == null) {
                long jNanoTime = System.nanoTime();
                AsyncTimeout.class.wait(AsyncTimeout.IDLE_TIMEOUT_MILLIS);
                AsyncTimeout asyncTimeout3 = AsyncTimeout.head;
                Intrinsics.checkNotNull(asyncTimeout3);
                if (asyncTimeout3.next != null || System.nanoTime() - jNanoTime < AsyncTimeout.IDLE_TIMEOUT_NANOS) {
                    return null;
                }
                return AsyncTimeout.head;
            }
            long jNanoTime2 = asyncTimeout2.timeoutAt - System.nanoTime();
            if (jNanoTime2 > 0) {
                long j = jNanoTime2 / 1000000;
                AsyncTimeout.class.wait(j, (int) (jNanoTime2 - (1000000 * j)));
                return null;
            }
            AsyncTimeout asyncTimeout4 = AsyncTimeout.head;
            Intrinsics.checkNotNull(asyncTimeout4);
            asyncTimeout4.next = asyncTimeout2.next;
            asyncTimeout2.next = null;
            return asyncTimeout2;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x002d  */
        public static ModelManager.TaskHandler build(JSONObject jSONObject) {
            float[] fArr;
            if (jSONObject == null) {
                return null;
            }
            try {
                String useCase = jSONObject.getString("use_case");
                String string = jSONObject.getString("asset_uri");
                String strOptString = jSONObject.optString("rules_uri", null);
                int i = jSONObject.getInt("version_id");
                ModelManager modelManager = ModelManager.INSTANCE;
                JSONArray jSONArray = jSONObject.getJSONArray("thresholds");
                if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
                    fArr = null;
                } else {
                    try {
                        if (CrashShieldHandler.isObjectCrashing(modelManager) || jSONArray == null) {
                            fArr = null;
                        } else {
                            try {
                                fArr = new float[jSONArray.length()];
                                int length = jSONArray.length();
                                if (length > 0) {
                                    int i2 = 0;
                                    while (true) {
                                        int i3 = i2 + 1;
                                        try {
                                            String string2 = jSONArray.getString(i2);
                                            Intrinsics.checkNotNullExpressionValue(string2, "jsonArray.getString(i)");
                                            fArr[i2] = Float.parseFloat(string2);
                                        } catch (JSONException unused) {
                                        }
                                        if (i3 >= length) {
                                            break;
                                        }
                                        i2 = i3;
                                    }
                                }
                            } catch (Throwable th) {
                                CrashShieldHandler.handleThrowable(modelManager, th);
                                fArr = null;
                            }
                        }
                    } catch (Throwable th2) {
                        CrashShieldHandler.handleThrowable(ModelManager.class, th2);
                    }
                }
                Intrinsics.checkNotNullExpressionValue(useCase, "useCase");
                Intrinsics.checkNotNullExpressionValue(string, mnwSv.vvbegwXGFFhE);
                return new ModelManager.TaskHandler(useCase, string, strOptString, i, fArr);
            } catch (Exception unused2) {
                return null;
            }
        }

        public static void execute(ModelManager.TaskHandler taskHandler, ArrayList arrayList) {
            File[] fileArrListFiles;
            File mlDir = Utils.getMlDir();
            int i = taskHandler.versionId;
            String str = taskHandler.useCase;
            if (mlDir != null && (fileArrListFiles = mlDir.listFiles()) != null && fileArrListFiles.length != 0) {
                String str2 = str + '_' + i;
                int length = fileArrListFiles.length;
                int i2 = 0;
                while (i2 < length) {
                    File file = fileArrListFiles[i2];
                    i2++;
                    String name = file.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "name");
                    if (StringsKt__StringsKt.startsWith(name, str, false) && !StringsKt__StringsKt.startsWith(name, str2, false)) {
                        file.delete();
                    }
                }
            }
            String str3 = str + '_' + i;
            InputConnectionCompat$$ExternalSyntheticLambda0 inputConnectionCompat$$ExternalSyntheticLambda0 = new InputConnectionCompat$$ExternalSyntheticLambda0(arrayList, 4);
            String str4 = taskHandler.assetUri;
            File file2 = new File(Utils.getMlDir(), str3);
            if (file2.exists()) {
                inputConnectionCompat$$ExternalSyntheticLambda0.onComplete(file2);
            } else {
                new FileDownloadTask(str4, file2, inputConnectionCompat$$ExternalSyntheticLambda0).execute(new String[0]);
            }
        }

        public static String lenientFormat(String str, Object... objArr) {
            int iIndexOf;
            String string;
            int i = 0;
            for (int i2 = 0; i2 < objArr.length; i2++) {
                Object obj = objArr[i2];
                if (obj == null) {
                    string = "null";
                } else {
                    try {
                        string = obj.toString();
                    } catch (Exception e) {
                        String str2 = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
                        Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + str2, (Throwable) e);
                        StringBuilder sbM21m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m21m("<", str2, " threw ");
                        sbM21m.append(e.getClass().getName());
                        sbM21m.append(">");
                        string = sbM21m.toString();
                    }
                }
                objArr[i2] = string;
            }
            StringBuilder sb = new StringBuilder((objArr.length * 16) + str.length());
            int i3 = 0;
            while (i < objArr.length && (iIndexOf = str.indexOf("%s", i3)) != -1) {
                sb.append((CharSequence) str, i3, iIndexOf);
                sb.append(objArr[i]);
                i3 = iIndexOf + 2;
                i++;
            }
            sb.append((CharSequence) str, i3, str.length());
            if (i < objArr.length) {
                sb.append(" [");
                sb.append(objArr[i]);
                for (int i4 = i + 1; i4 < objArr.length; i4++) {
                    sb.append(", ");
                    sb.append(objArr[i4]);
                }
                sb.append(']');
            }
            return sb.toString();
        }

        public static final synchronized void persistEvents(AccessTokenAppIdPair accessTokenAppIdPair, SessionEventsState sessionEventsState) {
            if (CrashShieldHandler.isObjectCrashing(Companion.class)) {
                return;
            }
            try {
                PersistedEvents andClearStore = StringsKt__IndentKt.readAndClearStore();
                andClearStore.addEvents(accessTokenAppIdPair, sessionEventsState.getEventsToPersist());
                StringsKt__IndentKt.saveEventsToDisk$facebook_core_release(andClearStore);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(Companion.class, th);
            }
        }

        public static MetadataList read(MappedByteBuffer mappedByteBuffer) throws IOException {
            long j;
            ByteBuffer byteBufferDuplicate = mappedByteBuffer.duplicate();
            byteBufferDuplicate.order(ByteOrder.BIG_ENDIAN);
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
            int i = byteBufferDuplicate.getShort() & 65535;
            if (i > 100) {
                throw new IOException("Cannot read metadata.");
            }
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 6);
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    j = -1;
                    break;
                }
                int i3 = byteBufferDuplicate.getInt();
                byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
                j = ((long) byteBufferDuplicate.getInt()) & 4294967295L;
                byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
                if (1835365473 == i3) {
                    break;
                }
                i2++;
            }
            if (j != -1) {
                byteBufferDuplicate.position(byteBufferDuplicate.position() + ((int) (j - ((long) byteBufferDuplicate.position()))));
                byteBufferDuplicate.position(byteBufferDuplicate.position() + 12);
                long j2 = ((long) byteBufferDuplicate.getInt()) & 4294967295L;
                for (int i4 = 0; i4 < j2; i4++) {
                    int i5 = byteBufferDuplicate.getInt();
                    long j3 = ((long) byteBufferDuplicate.getInt()) & 4294967295L;
                    byteBufferDuplicate.getInt();
                    if (1164798569 == i5 || 1701669481 == i5) {
                        byteBufferDuplicate.position((int) (j3 + j));
                        MetadataList metadataList = new MetadataList();
                        byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
                        int iPosition = byteBufferDuplicate.position() + byteBufferDuplicate.getInt(byteBufferDuplicate.position());
                        metadataList.bb = byteBufferDuplicate;
                        metadataList.bb_pos = iPosition;
                        int i6 = iPosition - byteBufferDuplicate.getInt(iPosition);
                        metadataList.vtable_start = i6;
                        metadataList.vtable_size = ((ByteBuffer) metadataList.bb).getShort(i6);
                        return metadataList;
                    }
                }
            }
            throw new IOException("Cannot read metadata.");
        }

        public static void setTint(Drawable drawable, int i) {
            DrawableCompat$Api21Impl.setTint(drawable, i);
        }

        public static Bundle zza(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            Iterator itKeys = jSONObject.keys();
            Bundle bundle = new Bundle();
            while (itKeys.hasNext()) {
                String str = (String) itKeys.next();
                Object objOpt = jSONObject.opt(str);
                if (objOpt != null) {
                    if (objOpt instanceof Boolean) {
                        bundle.putBoolean(str, ((Boolean) objOpt).booleanValue());
                    } else if (objOpt instanceof Double) {
                        bundle.putDouble(str, ((Double) objOpt).doubleValue());
                    } else if (objOpt instanceof Integer) {
                        bundle.putInt(str, ((Integer) objOpt).intValue());
                    } else if (objOpt instanceof Long) {
                        bundle.putLong(str, ((Long) objOpt).longValue());
                    } else if (objOpt instanceof String) {
                        bundle.putString(str, (String) objOpt);
                    } else if (objOpt instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) objOpt;
                        if (jSONArray.length() != 0) {
                            int length = jSONArray.length();
                            int i = 0;
                            Object objOpt2 = null;
                            for (int i2 = 0; objOpt2 == null && i2 < length; i2++) {
                                objOpt2 = !jSONArray.isNull(i2) ? jSONArray.opt(i2) : null;
                            }
                            if (objOpt2 == null) {
                                String strValueOf = String.valueOf(str);
                                int i3 = zze.$r8$clinit;
                                zzo.zzj("Expected JSONArray with at least 1 non-null element for key:".concat(strValueOf));
                            } else if (objOpt2 instanceof JSONObject) {
                                Bundle[] bundleArr = new Bundle[length];
                                while (i < length) {
                                    bundleArr[i] = !jSONArray.isNull(i) ? zza(jSONArray.optJSONObject(i)) : null;
                                    i++;
                                }
                                bundle.putParcelableArray(str, bundleArr);
                            } else if (objOpt2 instanceof Number) {
                                double[] dArr = new double[jSONArray.length()];
                                while (i < length) {
                                    dArr[i] = jSONArray.optDouble(i);
                                    i++;
                                }
                                bundle.putDoubleArray(str, dArr);
                            } else if (objOpt2 instanceof CharSequence) {
                                String[] strArr = new String[length];
                                while (i < length) {
                                    strArr[i] = !jSONArray.isNull(i) ? jSONArray.optString(i) : null;
                                    i++;
                                }
                                bundle.putStringArray(str, strArr);
                            } else if (objOpt2 instanceof Boolean) {
                                boolean[] zArr = new boolean[length];
                                while (i < length) {
                                    zArr[i] = jSONArray.optBoolean(i);
                                    i++;
                                }
                                bundle.putBooleanArray(str, zArr);
                            } else {
                                String strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m("JSONArray with unsupported type ", objOpt2.getClass().getCanonicalName(), " for key:", str);
                                int i4 = zze.$r8$clinit;
                                zzo.zzj(strM);
                            }
                        }
                    } else if (objOpt instanceof JSONObject) {
                        bundle.putBundle(str, zza((JSONObject) objOpt));
                    } else {
                        String strValueOf2 = String.valueOf(str);
                        int i5 = zze.$r8$clinit;
                        zzo.zzj("Unsupported type for key:".concat(strValueOf2));
                    }
                }
            }
            return bundle;
        }

        public static List zzc(JSONArray jSONArray, ArrayList arrayList) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
            }
            return arrayList;
        }

        public static ArrayList zzd(JsonReader jsonReader) {
            ArrayList arrayList = new ArrayList();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(jsonReader.nextString());
            }
            jsonReader.endArray();
            return arrayList;
        }

        public static JSONArray zzf(JsonReader jsonReader) throws JSONException, IOException {
            JSONArray jSONArray = new JSONArray();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                JsonToken jsonTokenPeek = jsonReader.peek();
                if (JsonToken.BEGIN_ARRAY.equals(jsonTokenPeek)) {
                    jSONArray.put(zzf(jsonReader));
                } else if (JsonToken.BEGIN_OBJECT.equals(jsonTokenPeek)) {
                    jSONArray.put(zzi(jsonReader));
                } else if (JsonToken.BOOLEAN.equals(jsonTokenPeek)) {
                    jSONArray.put(jsonReader.nextBoolean());
                } else if (JsonToken.NUMBER.equals(jsonTokenPeek)) {
                    jSONArray.put(jsonReader.nextDouble());
                } else {
                    if (!JsonToken.STRING.equals(jsonTokenPeek)) {
                        throw new IllegalStateException("unexpected json token: ".concat(String.valueOf(jsonTokenPeek)));
                    }
                    jSONArray.put(jsonReader.nextString());
                }
            }
            jsonReader.endArray();
            return jSONArray;
        }

        public static JSONObject zzg(String str, JSONObject jSONObject) {
            try {
                return jSONObject.getJSONObject(str);
            } catch (JSONException unused) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject.put(str, jSONObject2);
                return jSONObject2;
            }
        }

        public static JSONObject zzi(JsonReader jsonReader) {
            JSONObject jSONObject = new JSONObject();
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                JsonToken jsonTokenPeek = jsonReader.peek();
                if (JsonToken.BEGIN_ARRAY.equals(jsonTokenPeek)) {
                    jSONObject.put(strNextName, zzf(jsonReader));
                } else if (JsonToken.BEGIN_OBJECT.equals(jsonTokenPeek)) {
                    jSONObject.put(strNextName, zzi(jsonReader));
                } else if (JsonToken.BOOLEAN.equals(jsonTokenPeek)) {
                    jSONObject.put(strNextName, jsonReader.nextBoolean());
                } else if (JsonToken.NUMBER.equals(jsonTokenPeek)) {
                    jSONObject.put(strNextName, jsonReader.nextDouble());
                } else {
                    if (!JsonToken.STRING.equals(jsonTokenPeek)) {
                        throw new IllegalStateException("unexpected json token: ".concat(String.valueOf(jsonTokenPeek)));
                    }
                    jSONObject.put(strNextName, jsonReader.nextString());
                }
            }
            jsonReader.endObject();
            return jSONObject;
        }

        public static void zzj(JsonWriter jsonWriter, JSONArray jSONArray) throws IOException {
            try {
                jsonWriter.beginArray();
                for (int i = 0; i < jSONArray.length(); i++) {
                    Object obj = jSONArray.get(i);
                    if (obj instanceof String) {
                        jsonWriter.value((String) obj);
                    } else if (obj instanceof Number) {
                        jsonWriter.value((Number) obj);
                    } else if (obj instanceof Boolean) {
                        jsonWriter.value(((Boolean) obj).booleanValue());
                    } else if (obj instanceof JSONObject) {
                        zzk(jsonWriter, (JSONObject) obj);
                    } else {
                        if (!(obj instanceof JSONArray)) {
                            throw new JSONException("unable to write field: " + String.valueOf(obj));
                        }
                        zzj(jsonWriter, (JSONArray) obj);
                    }
                }
                jsonWriter.endArray();
            } catch (JSONException e) {
                throw new IOException(e);
            }
        }

        public static void zzk(JsonWriter jsonWriter, JSONObject jSONObject) throws IOException {
            try {
                jsonWriter.beginObject();
                Iterator itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String str = (String) itKeys.next();
                    Object obj = jSONObject.get(str);
                    if (obj instanceof String) {
                        jsonWriter.name(str).value((String) obj);
                    } else if (obj instanceof Number) {
                        jsonWriter.name(str).value((Number) obj);
                    } else if (obj instanceof Boolean) {
                        jsonWriter.name(str).value(((Boolean) obj).booleanValue());
                    } else if (obj instanceof JSONObject) {
                        zzk(jsonWriter.name(str), (JSONObject) obj);
                    } else {
                        if (!(obj instanceof JSONArray)) {
                            throw new JSONException("unable to write field: " + String.valueOf(obj));
                        }
                        zzj(jsonWriter.name(str), (JSONArray) obj);
                    }
                }
                jsonWriter.endObject();
            } catch (JSONException e) {
                throw new IOException(e);
            }
        }

        public static String zzm(zzfcf zzfcfVar) {
            if (zzfcfVar == null) {
                return null;
            }
            StringWriter stringWriter = new StringWriter();
            try {
                JsonWriter jsonWriter = new JsonWriter(stringWriter);
                zzo(jsonWriter, zzfcfVar);
                jsonWriter.close();
                return stringWriter.toString();
            } catch (IOException e) {
                int i = zze.$r8$clinit;
                zzo.zzh("Error when writing JSON.", e);
                return null;
            }
        }

        public static JSONObject zzn(JSONObject jSONObject, String[] strArr) {
            for (int i = 0; i < strArr.length - 1; i = 1) {
                if (jSONObject == null) {
                    return null;
                }
                jSONObject = jSONObject.optJSONObject(strArr[0]);
            }
            return jSONObject;
        }

        public static void zzo(JsonWriter jsonWriter, Object obj) throws IOException {
            if (obj == null) {
                jsonWriter.nullValue();
                return;
            }
            if (obj instanceof Number) {
                jsonWriter.value((Number) obj);
                return;
            }
            if (obj instanceof Boolean) {
                jsonWriter.value(((Boolean) obj).booleanValue());
                return;
            }
            if (obj instanceof String) {
                jsonWriter.value((String) obj);
                return;
            }
            if (obj instanceof zzfcf) {
                zzk(jsonWriter, ((zzfcf) obj).zzd);
                return;
            }
            if (!(obj instanceof Map)) {
                if (!(obj instanceof List)) {
                    jsonWriter.nullValue();
                    return;
                }
                jsonWriter.beginArray();
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    zzo(jsonWriter, it.next());
                }
                jsonWriter.endArray();
                return;
            }
            jsonWriter.beginObject();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                if (key instanceof String) {
                    zzo(jsonWriter.name((String) key), entry.getValue());
                }
            }
            jsonWriter.endObject();
        }

        public void adjustLayoutInDisplayCutoutMode(Window window) {
        }

        public abstract boolean casListeners(AbstractFuture abstractFuture, AbstractFuture.Listener listener, AbstractFuture.Listener listener2);

        public abstract boolean casValue(AbstractFuture abstractFuture, Object obj, Object obj2);

        public abstract boolean casWaiters(AbstractFuture abstractFuture, AbstractFuture.Waiter waiter, AbstractFuture.Waiter waiter2);

        public abstract void putNext(AbstractFuture.Waiter waiter, AbstractFuture.Waiter waiter2);

        public abstract void putThread(AbstractFuture.Waiter waiter, Thread thread);

        public abstract void setUp(SystemBarStyle systemBarStyle, SystemBarStyle systemBarStyle2, Window window, View view, boolean z, boolean z2);

        public static final synchronized void persistEvents(AppEventCollection eventsToPersist) {
            if (CrashShieldHandler.isObjectCrashing(Companion.class)) {
                return;
            }
            try {
                Intrinsics.checkNotNullParameter(eventsToPersist, "eventsToPersist");
                PersistedEvents andClearStore = StringsKt__IndentKt.readAndClearStore();
                for (AccessTokenAppIdPair accessTokenAppIdPair : eventsToPersist.keySet()) {
                    SessionEventsState sessionEventsState = eventsToPersist.get(accessTokenAppIdPair);
                    if (sessionEventsState != null) {
                        andClearStore.addEvents(accessTokenAppIdPair, sessionEventsState.getEventsToPersist());
                    } else {
                        throw new IllegalStateException("Required value was null.");
                    }
                }
                StringsKt__IndentKt.saveEventsToDisk$facebook_core_release(andClearStore);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(Companion.class, th);
            }
        }
    }
}
