package com.facebook;

import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.instrument.errorreport.ErrorReportData;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AccessTokenManager$$ExternalSyntheticLambda2 implements GraphRequest.Callback {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ AccessTokenManager$$ExternalSyntheticLambda2(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // com.facebook.GraphRequest.Callback
    public final void onCompleted(GraphResponse graphResponse) {
        switch (this.$r8$classId) {
            case 0:
                AccessTokenManager.RefreshResult refreshResult = (AccessTokenManager.RefreshResult) this.f$0;
                JSONObject jSONObject = graphResponse.jsonObject;
                if (jSONObject != null) {
                    refreshResult.accessToken = jSONObject.optString("access_token");
                    refreshResult.expiresAt = jSONObject.optInt("expires_at");
                    refreshResult.expiresIn = jSONObject.optInt("expires_in");
                    refreshResult.dataAccessExpirationTime = Long.valueOf(jSONObject.optLong("data_access_expiration_time"));
                    refreshResult.graphDomain = jSONObject.optString("graph_domain", null);
                    break;
                }
                break;
            case 1:
                InstrumentData instrumentData = (InstrumentData) this.f$0;
                try {
                    if (graphResponse.error == null) {
                        JSONObject jSONObject2 = graphResponse.jsonObject;
                        if (Intrinsics.areEqual(jSONObject2 == null ? null : Boolean.valueOf(jSONObject2.getBoolean(FirebaseAnalytics.Param.SUCCESS)), Boolean.TRUE)) {
                            Headers.Companion.deleteFile(instrumentData.filename);
                        }
                    }
                } catch (JSONException unused) {
                    return;
                }
                break;
            default:
                ArrayList arrayList = (ArrayList) this.f$0;
                try {
                    if (graphResponse.error == null) {
                        JSONObject jSONObject3 = graphResponse.jsonObject;
                        if (Intrinsics.areEqual(jSONObject3 == null ? null : Boolean.valueOf(jSONObject3.getBoolean(FirebaseAnalytics.Param.SUCCESS)), Boolean.TRUE)) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                Headers.Companion.deleteFile(((ErrorReportData) it.next()).filename);
                                break;
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
