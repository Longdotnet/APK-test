package androidx.core.view.inputmethod;

import android.content.ClipData;
import android.content.ClipDescription;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.DifferentialMotionFlingController$$ExternalSyntheticLambda0;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.hSi.sgtsHsWT;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.sqlite.db.framework.VERT.YcVWhnLsj;
import com.daerisoft.thespikerm.GoogleMobileAdsGM;
import com.daerisoft.thespikerm.RunnerActivity;
import com.facebook.AccessTokenCache;
import com.facebook.AccessTokenManager;
import com.facebook.appevents.codeless.CodelessManager$$ExternalSyntheticLambda0;
import com.facebook.appevents.internal.FileDownloadTask;
import com.facebook.appevents.ml.MTensor;
import com.facebook.appevents.ml.Model;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.appevents.ml.Utils;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.internal.instrument.errorreport.ErrorReportData;
import com.facebook.login.LoginFragment$getLoginMethodHandlerCallback$1;
import com.google.android.datatransport.cct.CctTransportBackend;
import com.google.android.datatransport.cct.internal.AutoValue_LogResponse;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler$$ExternalSyntheticLambda1;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.AdapterResponseInfo;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.firebase.encoders.EncodingException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import okhttp3.Dispatcher;
import okhttp3.Headers;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class InputConnectionCompat$$ExternalSyntheticLambda0 implements OnPaidEventListener, OnApplyWindowInsetsListener, FeatureManager.Callback, FileDownloadTask.Callback, ActivityResultCallback, SynchronizationGuard.CriticalSection {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ InputConnectionCompat$$ExternalSyntheticLambda0(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    public CctTransportBackend.HttpResponse apply(Object obj) throws IOException {
        CctTransportBackend.HttpRequest httpRequest = (CctTransportBackend.HttpRequest) obj;
        CctTransportBackend cctTransportBackend = (CctTransportBackend) this.f$0;
        URL url = httpRequest.url;
        String tag = RangesKt.getTag("CctTransportBackend");
        if (Log.isLoggable(tag, 4)) {
            Log.i(tag, String.format("Making request to: %s", url));
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) httpRequest.url.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(cctTransportBackend.readTimeout);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", "datatransport/3.1.8 android/");
        String str = sgtsHsWT.ltCuXHdhognYyR;
        httpURLConnection.setRequestProperty(str, "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str2 = httpRequest.apiKey;
        if (str2 != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str2);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    cctTransportBackend.dataEncoder.encode(httpRequest.requestBody, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    Integer numValueOf = Integer.valueOf(responseCode);
                    String tag2 = RangesKt.getTag("CctTransportBackend");
                    if (Log.isLoggable(tag2, 4)) {
                        Log.i(tag2, String.format("Status Code: %d", numValueOf));
                    }
                    RangesKt.d("CctTransportBackend", "Content-Type: %s", httpURLConnection.getHeaderField("Content-Type"));
                    RangesKt.d("CctTransportBackend", "Content-Encoding: %s", httpURLConnection.getHeaderField(str));
                    if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                        return new CctTransportBackend.HttpResponse(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                    }
                    if (responseCode != 200) {
                        return new CctTransportBackend.HttpResponse(responseCode, null, 0L);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        InputStream gZIPInputStream = "gzip".equals(httpURLConnection.getHeaderField(str)) ? new GZIPInputStream(inputStream) : inputStream;
                        try {
                            CctTransportBackend.HttpResponse httpResponse = new CctTransportBackend.HttpResponse(responseCode, null, AutoValue_LogResponse.fromJson(new BufferedReader(new InputStreamReader(gZIPInputStream))).nextRequestWaitMillis);
                            if (gZIPInputStream != null) {
                                gZIPInputStream.close();
                            }
                            if (inputStream == null) {
                                return httpResponse;
                            }
                            inputStream.close();
                            return httpResponse;
                        } catch (Throwable th) {
                            if (gZIPInputStream == null) {
                                throw th;
                            }
                            try {
                                gZIPInputStream.close();
                                throw th;
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                                throw th;
                            }
                        }
                    } catch (Throwable th3) {
                        if (inputStream == null) {
                            throw th3;
                        }
                        try {
                            inputStream.close();
                            throw th3;
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                            throw th3;
                        }
                    }
                } catch (Throwable th5) {
                    try {
                        gZIPOutputStream.close();
                        throw th5;
                    } catch (Throwable th6) {
                        th5.addSuppressed(th6);
                        throw th5;
                    }
                }
            } catch (Throwable th7) {
                if (outputStream == null) {
                    throw th7;
                }
                try {
                    outputStream.close();
                    throw th7;
                } catch (Throwable th8) {
                    th7.addSuppressed(th8);
                    throw th7;
                }
            }
        } catch (EncodingException e) {
            e = e;
            RangesKt.e(e, "CctTransportBackend", "Couldn't encode request, returning with 400");
            return new CctTransportBackend.HttpResponse(400, null, 0L);
        } catch (ConnectException e2) {
            e = e2;
            RangesKt.e(e, "CctTransportBackend", "Couldn't open connection, returning with 500");
            return new CctTransportBackend.HttpResponse(500, null, 0L);
        } catch (UnknownHostException e3) {
            e = e3;
            RangesKt.e(e, "CctTransportBackend", "Couldn't open connection, returning with 500");
            return new CctTransportBackend.HttpResponse(500, null, 0L);
        } catch (IOException e4) {
            e = e4;
            RangesKt.e(e, "CctTransportBackend", "Couldn't encode request, returning with 400");
            return new CctTransportBackend.HttpResponse(400, null, 0L);
        }
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        Object obj = this.f$0;
        switch (this.$r8$classId) {
            case 8:
                SQLiteEventStore sQLiteEventStore = (SQLiteEventStore) ((ClientHealthMetricsStore) obj);
                sQLiteEventStore.getClass();
                int i = ClientMetrics.$r8$clinit;
                Dispatcher dispatcher = new Dispatcher();
                dispatcher.executorServiceOrNull = null;
                dispatcher.readyAsyncCalls = new ArrayList();
                dispatcher.runningAsyncCalls = null;
                dispatcher.runningSyncCalls = "";
                HashMap map = new HashMap();
                SQLiteDatabase db = sQLiteEventStore.getDb();
                db.beginTransaction();
                try {
                    ClientMetrics clientMetrics = (ClientMetrics) SQLiteEventStore.tryWithCursor(db.rawQuery("SELECT log_source, reason, events_dropped_count FROM log_event_dropped", new String[0]), new DefaultScheduler$$ExternalSyntheticLambda1(sQLiteEventStore, map, dispatcher, 3));
                    db.setTransactionSuccessful();
                    return clientMetrics;
                } finally {
                    db.endTransaction();
                }
            case 9:
                SQLiteEventStore sQLiteEventStore2 = (SQLiteEventStore) ((EventStore) obj);
                long time = sQLiteEventStore2.wallClock.getTime() - sQLiteEventStore2.config.eventCleanUpAge;
                SQLiteDatabase db2 = sQLiteEventStore2.getDb();
                db2.beginTransaction();
                try {
                    String[] strArr = {String.valueOf(time)};
                    Cursor cursorRawQuery = db2.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr);
                    while (cursorRawQuery.moveToNext()) {
                        try {
                            sQLiteEventStore2.recordLogEventDropped(cursorRawQuery.getInt(0), LogEventDropped.Reason.MESSAGE_TOO_OLD, cursorRawQuery.getString(1));
                        } catch (Throwable th) {
                            cursorRawQuery.close();
                            throw th;
                        }
                    }
                    cursorRawQuery.close();
                    int iDelete = db2.delete("events", "timestamp_ms < ?", strArr);
                    db2.setTransactionSuccessful();
                    db2.endTransaction();
                    return Integer.valueOf(iDelete);
                } catch (Throwable th2) {
                    db2.endTransaction();
                    throw th2;
                }
            case 10:
                SQLiteEventStore sQLiteEventStore3 = (SQLiteEventStore) ((Uploader) obj).clientHealthMetricsStore;
                SQLiteDatabase db3 = sQLiteEventStore3.getDb();
                db3.beginTransaction();
                try {
                    db3.compileStatement(YcVWhnLsj.UJXDxLcf).execute();
                    db3.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + sQLiteEventStore3.wallClock.getTime()).execute();
                    db3.setTransactionSuccessful();
                    return null;
                } finally {
                    db3.endTransaction();
                }
            default:
                WorkInitializer workInitializer = (WorkInitializer) obj;
                Iterator it = ((Iterable) ((SQLiteEventStore) workInitializer.store).inTransaction(new DifferentialMotionFlingController$$ExternalSyntheticLambda0(20))).iterator();
                while (it.hasNext()) {
                    workInitializer.scheduler.schedule((AutoValue_TransportContext) it.next(), 1, false);
                }
                return null;
        }
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        ((LoginFragment$getLoginMethodHandlerCallback$1) this.f$0).invoke((ActivityResult) obj);
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        RunnerActivity runnerActivity = RunnerActivity.CurrentActivity;
        ((RunnerActivity) this.f$0).GenerateAsyncEventForInsets();
        return ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
    }

    public boolean onCommitContent(AccessTokenCache accessTokenCache, int i, Bundle bundle) {
        ContentInfoCompat.BuilderCompat accessTokenCache2;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 25 && (i & 1) != 0) {
            try {
                ((InputContentInfoCompat$InputContentInfoCompatImpl) accessTokenCache.sharedPreferences).requestPermission();
                Parcelable parcelable = (Parcelable) ((InputContentInfoCompat$InputContentInfoCompatImpl) accessTokenCache.sharedPreferences).getInputContentInfo();
                bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", parcelable);
            } catch (Exception e) {
                Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e);
                return false;
            }
        }
        ClipDescription description = ((InputContentInfoCompat$InputContentInfoCompatImpl) accessTokenCache.sharedPreferences).getDescription();
        InputContentInfoCompat$InputContentInfoCompatImpl inputContentInfoCompat$InputContentInfoCompatImpl = (InputContentInfoCompat$InputContentInfoCompatImpl) accessTokenCache.sharedPreferences;
        ClipData clipData = new ClipData(description, new ClipData.Item(inputContentInfoCompat$InputContentInfoCompatImpl.getContentUri()));
        if (i2 >= 31) {
            accessTokenCache2 = new AccessTokenCache(clipData, 2);
        } else {
            AccessTokenManager.RefreshResult refreshResult = new AccessTokenManager.RefreshResult(1);
            refreshResult.accessToken = clipData;
            refreshResult.expiresAt = 2;
            accessTokenCache2 = refreshResult;
        }
        accessTokenCache2.setLinkUri(inputContentInfoCompat$InputContentInfoCompatImpl.getLinkUri());
        accessTokenCache2.setExtras(bundle);
        return ViewCompat.performReceiveContent((AppCompatEditText) this.f$0, accessTokenCache2.build()) == null;
    }

    @Override // com.facebook.appevents.internal.FileDownloadTask.Callback
    public void onComplete(File file) {
        HashMap map;
        int i;
        HashMap map2;
        Model model;
        HashMap map3;
        int i2 = 1;
        ArrayList<ModelManager.TaskHandler> arrayList = (ArrayList) this.f$0;
        Intrinsics.checkNotNullParameter(file, "file");
        HashMap map4 = Model.mapping;
        if (CrashShieldHandler.isObjectCrashing(Utils.class)) {
            map = null;
            break;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            int iAvailable = fileInputStream.available();
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            byte[] bArr = new byte[iAvailable];
            dataInputStream.readFully(bArr);
            dataInputStream.close();
            if (iAvailable >= 4) {
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, 0, 4);
                byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
                int i3 = byteBufferWrap.getInt();
                int i4 = i3 + 4;
                if (iAvailable >= i4) {
                    JSONObject jSONObject = new JSONObject(new String(bArr, 4, i3, Charsets.UTF_8));
                    JSONArray jSONArrayNames = jSONObject.names();
                    int length = jSONArrayNames.length();
                    String[] strArr = new String[length];
                    int i5 = length - 1;
                    if (i5 >= 0) {
                        int i6 = 0;
                        while (true) {
                            int i7 = i6 + 1;
                            strArr[i6] = jSONArrayNames.getString(i6);
                            if (i7 > i5) {
                                break;
                            } else {
                                i6 = i7;
                            }
                        }
                    }
                    if (length > 1) {
                        Arrays.sort(strArr);
                    }
                    map = new HashMap();
                    int i8 = 0;
                    while (i8 < length) {
                        String str = strArr[i8];
                        i8 += i2;
                        if (str != null) {
                            JSONArray jSONArray = jSONObject.getJSONArray(str);
                            int length2 = jSONArray.length();
                            int[] iArr = new int[length2];
                            int i9 = length2 - 1;
                            if (i9 >= 0) {
                                int i10 = i2;
                                int i11 = 0;
                                while (true) {
                                    int i12 = i11 + 1;
                                    int i13 = jSONArray.getInt(i11);
                                    iArr[i11] = i13;
                                    i10 *= i13;
                                    if (i12 > i9) {
                                        break;
                                    } else {
                                        i11 = i12;
                                    }
                                }
                                i = i10;
                            } else {
                                i = i2;
                            }
                            int i14 = i * 4;
                            int i15 = i4 + i14;
                            if (i15 <= iAvailable) {
                                ByteBuffer byteBufferWrap2 = ByteBuffer.wrap(bArr, i4, i14);
                                byteBufferWrap2.order(ByteOrder.LITTLE_ENDIAN);
                                MTensor mTensor = new MTensor(iArr);
                                byteBufferWrap2.asFloatBuffer().get(mTensor.data, 0, i);
                                map.put(str, mTensor);
                                jSONObject = jSONObject;
                                i4 = i15;
                                i2 = 1;
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(Utils.class, th);
        }
        map = null;
        break;
        if (map == null) {
            map2 = null;
            break;
        }
        map2 = new HashMap();
        if (CrashShieldHandler.isObjectCrashing(Model.class)) {
            map3 = null;
        } else {
            try {
                map3 = Model.mapping;
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(Model.class, th2);
                map3 = null;
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            String str2 = (String) entry.getKey();
            if (map3.containsKey(entry.getKey()) && (str2 = (String) map3.get(entry.getKey())) == null) {
                map2 = null;
                break;
            }
            map2.put(str2, entry.getValue());
        }
        if (map2 == null) {
            model = null;
        } else {
            try {
                model = new Model(map2);
            } catch (Exception unused2) {
                model = null;
            }
        }
        if (model != null) {
            for (ModelManager.TaskHandler taskHandler : arrayList) {
                StringBuilder sb = new StringBuilder();
                sb.append(taskHandler.useCase);
                sb.append('_');
                String strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(sb, taskHandler.versionId, "_rule");
                CodelessManager$$ExternalSyntheticLambda0 codelessManager$$ExternalSyntheticLambda0 = new CodelessManager$$ExternalSyntheticLambda0(taskHandler, model, 6);
                File file2 = new File(Utils.getMlDir(), strM);
                String str3 = taskHandler.ruleUri;
                if (str3 == null || file2.exists()) {
                    codelessManager$$ExternalSyntheticLambda0.onComplete(file2);
                } else {
                    new FileDownloadTask(str3, file2, codelessManager$$ExternalSyntheticLambda0).execute(new String[0]);
                }
            }
        }
    }

    @Override // com.facebook.internal.FeatureManager.Callback
    public void onCompleted(boolean z) {
        String str = (String) this.f$0;
        if (z) {
            try {
                ErrorReportData errorReportData = new ErrorReportData(str);
                if ((errorReportData.errorMessage == null || errorReportData.timestamp == null) ? false : true) {
                    Headers.Companion.writeFile(errorReportData.filename, errorReportData.toString());
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.google.android.gms.ads.OnPaidEventListener
    public void onPaidEvent(AdValue adValue) {
        GoogleMobileAdsGM.AnonymousClass8 anonymousClass8 = (GoogleMobileAdsGM.AnonymousClass8) this.f$0;
        GoogleMobileAdsGM googleMobileAdsGM = GoogleMobileAdsGM.this;
        AdapterResponseInfo adapterResponseInfo = googleMobileAdsGM.appOpenAd.getResponseInfo().zzc;
        if (adapterResponseInfo == null) {
            return;
        }
        GoogleMobileAdsGM googleMobileAdsGM2 = GoogleMobileAdsGM.this;
        googleMobileAdsGM2.onPaidEventHandler(adValue, googleMobileAdsGM2.appOpenAd.getAdUnitId(), "AppOpen", adapterResponseInfo, googleMobileAdsGM.appOpenAd.getResponseInfo().getMediationAdapterClassName());
    }
}
