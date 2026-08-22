package com.facebook.internal.instrument.anrreport;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ANRHandler$$ExternalSyntheticLambda1 implements GraphRequest.Callback {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ List f$0;

    public /* synthetic */ ANRHandler$$ExternalSyntheticLambda1(int i, List list) {
        this.$r8$classId = i;
        this.f$0 = list;
    }

    @Override // com.facebook.GraphRequest.Callback
    public final void onCompleted(GraphResponse graphResponse) {
        switch (this.$r8$classId) {
            case 0:
                List list = this.f$0;
                if (!CrashShieldHandler.isObjectCrashing(ANRHandler.class)) {
                    try {
                        if (graphResponse.error == null) {
                            JSONObject jSONObject = graphResponse.jsonObject;
                            if (Intrinsics.areEqual(jSONObject == null ? null : Boolean.valueOf(jSONObject.getBoolean(FirebaseAnalytics.Param.SUCCESS)), Boolean.TRUE)) {
                                Iterator it = list.iterator();
                                while (it.hasNext()) {
                                    Headers.Companion.deleteFile(((InstrumentData) it.next()).filename);
                                }
                            }
                        }
                    } catch (JSONException unused) {
                        return;
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(ANRHandler.class, th);
                        return;
                    }
                    break;
                }
                break;
            default:
                List list2 = this.f$0;
                try {
                    if (graphResponse.error == null) {
                        JSONObject jSONObject2 = graphResponse.jsonObject;
                        if (Intrinsics.areEqual(jSONObject2 == null ? null : Boolean.valueOf(jSONObject2.getBoolean(FirebaseAnalytics.Param.SUCCESS)), Boolean.TRUE)) {
                            Iterator it2 = list2.iterator();
                            while (it2.hasNext()) {
                                Headers.Companion.deleteFile(((InstrumentData) it2.next()).filename);
                            }
                        }
                    }
                } catch (JSONException unused2) {
                    return;
                }
                break;
        }
    }
}
