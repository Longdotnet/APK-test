package com.google.android.datatransport.cct;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.facebook.GraphRequest;
import com.google.android.datatransport.cct.internal.AutoBatchedLogRequestEncoder;
import com.google.android.datatransport.cct.internal.AutoValue_BatchedLogRequest;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.ranges.RangesKt;
import okhttp3.Request;

/* JADX INFO: loaded from: classes.dex */
public final class CctTransportBackend implements TransportBackend {
    public final Context applicationContext;
    public final ConnectivityManager connectivityManager;
    public final DataEncoder dataEncoder = new JsonDataEncoderBuilder().configureWith(AutoBatchedLogRequestEncoder.CONFIG).ignoreNullValues(true).build();
    public final URL endPoint = parseUrlOrThrow(CCTDestination.DEFAULT_END_POINT);
    public final int readTimeout = 130000;
    public final GraphRequest.Companion uptimeClock;
    public final GraphRequest.Companion wallTimeClock;

    public final class HttpRequest {
        public final String apiKey;
        public final AutoValue_BatchedLogRequest requestBody;
        public final URL url;

        public HttpRequest(URL url, AutoValue_BatchedLogRequest autoValue_BatchedLogRequest, String str) {
            this.url = url;
            this.requestBody = autoValue_BatchedLogRequest;
            this.apiKey = str;
        }
    }

    public final class HttpResponse {
        public final int code;
        public final long nextRequestMillis;
        public final URL redirectUrl;

        public HttpResponse(int i, URL url, long j) {
            this.code = i;
            this.redirectUrl = url;
            this.nextRequestMillis = j;
        }
    }

    public CctTransportBackend(Context context, GraphRequest.Companion companion, GraphRequest.Companion companion2) {
        this.applicationContext = context;
        this.connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.uptimeClock = companion2;
        this.wallTimeClock = companion;
    }

    public static URL parseUrlOrThrow(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Invalid url: ", str), e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x00af  */
    /* JADX WARN: Code duplicated, block: B:30:0x010a  */
    public final AutoValue_EventInternal decorate(AutoValue_EventInternal autoValue_EventInternal) {
        int type;
        int subtype;
        HashMap map;
        NetworkInfo activeNetworkInfo = this.connectivityManager.getActiveNetworkInfo();
        Request builder = autoValue_EventInternal.toBuilder();
        int i = Build.VERSION.SDK_INT;
        HashMap map2 = (HashMap) builder.tags;
        if (map2 == null) {
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        map2.put("sdk-version", String.valueOf(i));
        builder.addMetadata("model", Build.MODEL);
        builder.addMetadata("hardware", Build.HARDWARE);
        builder.addMetadata("device", Build.DEVICE);
        builder.addMetadata("product", Build.PRODUCT);
        builder.addMetadata("os-uild", Build.ID);
        builder.addMetadata("manufacturer", Build.MANUFACTURER);
        builder.addMetadata("fingerprint", Build.FINGERPRINT);
        Calendar.getInstance();
        long offset = TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000;
        HashMap map3 = (HashMap) builder.tags;
        if (map3 == null) {
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        map3.put("tz-offset", String.valueOf(offset));
        int i2 = -1;
        if (activeNetworkInfo == null) {
            SparseArray sparseArray = NetworkConnectionInfo.NetworkType.valueMap;
            type = -1;
        } else {
            type = activeNetworkInfo.getType();
        }
        HashMap map4 = (HashMap) builder.tags;
        if (map4 == null) {
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        map4.put("net-type", String.valueOf(type));
        if (activeNetworkInfo != null) {
            subtype = activeNetworkInfo.getSubtype();
            if (subtype == -1) {
                SparseArray sparseArray2 = NetworkConnectionInfo.MobileSubtype.valueMap;
                subtype = 100;
            } else if (((NetworkConnectionInfo.MobileSubtype) NetworkConnectionInfo.MobileSubtype.valueMap.get(subtype)) == null) {
            }
            map = (HashMap) builder.tags;
            if (map != null) {
                throw new IllegalStateException("Property \"autoMetadata\" has not been set");
            }
            map.put("mobile-subtype", String.valueOf(subtype));
            builder.addMetadata("country", Locale.getDefault().getCountry());
            builder.addMetadata("locale", Locale.getDefault().getLanguage());
            Context context = this.applicationContext;
            builder.addMetadata("mcc_mnc", ((TelephonyManager) context.getSystemService("phone")).getSimOperator());
            try {
                i2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException e) {
                RangesKt.e(e, "CctTransportBackend", "Unable to find version code for package");
            }
            builder.addMetadata("application_build", Integer.toString(i2));
            return builder.build();
        }
        SparseArray sparseArray3 = NetworkConnectionInfo.MobileSubtype.valueMap;
        subtype = 0;
        map = (HashMap) builder.tags;
        if (map != null) {
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        map.put("mobile-subtype", String.valueOf(subtype));
        builder.addMetadata("country", Locale.getDefault().getCountry());
        builder.addMetadata("locale", Locale.getDefault().getLanguage());
        Context context2 = this.applicationContext;
        builder.addMetadata("mcc_mnc", ((TelephonyManager) context2.getSystemService("phone")).getSimOperator());
        i2 = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).versionCode;
        builder.addMetadata("application_build", Integer.toString(i2));
        return builder.build();
    }
}
