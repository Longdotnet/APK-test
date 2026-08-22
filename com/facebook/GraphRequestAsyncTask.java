package com.facebook;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class GraphRequestAsyncTask extends AsyncTask {
    public Exception exception;
    public final GraphRequestBatch requests;

    public GraphRequestAsyncTask(GraphRequestBatch requests) {
        Intrinsics.checkNotNullParameter(requests, "requests");
        this.requests = requests;
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] objArr) {
        ArrayList arrayListExecuteBatchAndWait = null;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                Void[] params = (Void[]) objArr;
                if (!CrashShieldHandler.isObjectCrashing(this)) {
                    try {
                        if (!CrashShieldHandler.isObjectCrashing(this)) {
                            try {
                                Intrinsics.checkNotNullParameter(params, "params");
                                try {
                                    GraphRequestBatch graphRequestBatch = this.requests;
                                    graphRequestBatch.getClass();
                                    String str = GraphRequest.MIME_BOUNDARY;
                                    arrayListExecuteBatchAndWait = GraphRequest.Companion.executeBatchAndWait(graphRequestBatch);
                                } catch (Exception e) {
                                    this.exception = e;
                                }
                            } catch (Throwable th) {
                                CrashShieldHandler.handleThrowable(this, th);
                            }
                        }
                    } catch (Throwable th2) {
                        CrashShieldHandler.handleThrowable(this, th2);
                    }
                }
                return arrayListExecuteBatchAndWait;
            } catch (Throwable th3) {
                CrashShieldHandler.handleThrowable(this, th3);
                return arrayListExecuteBatchAndWait;
            }
        } catch (Throwable th4) {
            CrashShieldHandler.handleThrowable(this, th4);
            return arrayListExecuteBatchAndWait;
        }
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                List result = (List) obj;
                if (CrashShieldHandler.isObjectCrashing(this)) {
                    return;
                }
                try {
                    if (CrashShieldHandler.isObjectCrashing(this)) {
                        return;
                    }
                    try {
                        Intrinsics.checkNotNullParameter(result, "result");
                        super.onPostExecute(result);
                        Exception exc = this.exception;
                        if (exc != null) {
                            String.format("onPostExecute: exception encountered during request: %s", Arrays.copyOf(new Object[]{exc.getMessage()}, 1));
                            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(this, th);
                        return;
                    }
                    CrashShieldHandler.handleThrowable(this, th);
                    return;
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(this, th2);
                    return;
                }
                CrashShieldHandler.handleThrowable(this, th);
                return;
            } catch (Throwable th3) {
                CrashShieldHandler.handleThrowable(this, th3);
                return;
            }
            CrashShieldHandler.handleThrowable(this, th);
        } catch (Throwable th4) {
            CrashShieldHandler.handleThrowable(this, th4);
        }
    }

    @Override // android.os.AsyncTask
    public final void onPreExecute() {
        GraphRequestBatch graphRequestBatch = this.requests;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                super.onPreExecute();
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                if (graphRequestBatch.callbackHandler == null) {
                    graphRequestBatch.callbackHandler = Thread.currentThread() instanceof HandlerThread ? new Handler() : new Handler(Looper.getMainLooper());
                    return;
                }
                return;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(this, th);
                return;
            }
            CrashShieldHandler.handleThrowable(this, th);
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(this, th2);
        }
    }

    public final String toString() {
        String str = "{RequestAsyncTask:  connection: null, requests: " + this.requests + "}";
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder()\n        .append(\"{RequestAsyncTask: \")\n        .append(\" connection: \")\n        .append(connection)\n        .append(\", requests: \")\n        .append(requests)\n        .append(\"}\")\n        .toString()");
        return str;
    }
}
