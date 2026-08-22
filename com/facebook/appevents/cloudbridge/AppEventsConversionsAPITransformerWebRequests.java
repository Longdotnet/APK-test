package com.facebook.appevents.cloudbridge;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.daerisoft.thespikerm.GamepadHandler_API19;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.internal.Logger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class AppEventsConversionsAPITransformerWebRequests {
    public static final HashSet ACCEPTABLE_HTTP_RESPONSE = GamepadHandler_API19.hashSetOf(200, 202);
    public static final HashSet RETRY_EVENTS_HTTP_RESPONSE = GamepadHandler_API19.hashSetOf(503, 504, 429);
    public static CloudBridgeCredentials credentials;
    public static int currentRetryCount;
    public static List transformedEvents;

    public final class CloudBridgeCredentials {
        public final String accessKey;
        public final String cloudBridgeURL;
        public final String datasetID;

        public CloudBridgeCredentials(String str, String cloudBridgeURL, String str2) {
            Intrinsics.checkNotNullParameter(cloudBridgeURL, "cloudBridgeURL");
            this.datasetID = str;
            this.cloudBridgeURL = cloudBridgeURL;
            this.accessKey = str2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CloudBridgeCredentials)) {
                return false;
            }
            CloudBridgeCredentials cloudBridgeCredentials = (CloudBridgeCredentials) obj;
            return Intrinsics.areEqual(this.datasetID, cloudBridgeCredentials.datasetID) && Intrinsics.areEqual(this.cloudBridgeURL, cloudBridgeCredentials.cloudBridgeURL) && Intrinsics.areEqual(this.accessKey, cloudBridgeCredentials.accessKey);
        }

        public final int hashCode() {
            return this.accessKey.hashCode() + CoroutineAdapterKt$$ExternalSyntheticLambda0.m(this.datasetID.hashCode() * 31, 31, this.cloudBridgeURL);
        }

        public final String toString() {
            return "CloudBridgeCredentials(datasetID=" + this.datasetID + ", cloudBridgeURL=" + this.cloudBridgeURL + ", accessKey=" + this.accessKey + ')';
        }
    }

    public static final void configure(String str, String url, String str2) {
        Intrinsics.checkNotNullParameter(url, "url");
        GraphRequest.Companion companion = Logger.Companion;
        synchronized (FacebookSdk.loggingBehaviors) {
        }
        credentials = new CloudBridgeCredentials(str, url, str2);
        transformedEvents = new ArrayList();
    }

    public static List getTransformedEvents$facebook_core_release() {
        List list = transformedEvents;
        if (list != null) {
            return list;
        }
        Intrinsics.throwUninitializedPropertyAccessException("transformedEvents");
        throw null;
    }
}
