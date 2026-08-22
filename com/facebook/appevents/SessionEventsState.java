package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.internal.AppEventsLoggerUtility;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class SessionEventsState {
    public final String anonymousAppDeviceGUID;
    public final AttributionIdentifiers attributionIdentifiers;
    public int numSkippedEventsDueToFullBuffer;
    public ArrayList accumulatedEvents = new ArrayList();
    public final ArrayList inFlightEvents = new ArrayList();

    public SessionEventsState(AttributionIdentifiers attributionIdentifiers, String str) {
        this.attributionIdentifiers = attributionIdentifiers;
        this.anonymousAppDeviceGUID = str;
    }

    public final synchronized void addEvent(AppEvent event) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(event, "event");
            if (this.accumulatedEvents.size() + this.inFlightEvents.size() >= 1000) {
                this.numSkippedEventsDueToFullBuffer++;
            } else {
                this.accumulatedEvents.add(event);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }

    public final synchronized void clearInFlightAndStats(boolean z) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        if (z) {
            try {
                this.accumulatedEvents.addAll(this.inFlightEvents);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(this, th);
                return;
            }
        }
        this.inFlightEvents.clear();
        this.numSkippedEventsDueToFullBuffer = 0;
    }

    public final synchronized int getAccumulatedEventCount() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            return this.accumulatedEvents.size();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return 0;
        }
    }

    public final synchronized List getEventsToPersist() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ArrayList arrayList = this.accumulatedEvents;
            this.accumulatedEvents = new ArrayList();
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return null;
        }
    }

    public final int populateRequest(GraphRequest graphRequest, Context context, boolean z, boolean z2) {
        boolean zEquals;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            synchronized (this) {
                try {
                    int i = this.numSkippedEventsDueToFullBuffer;
                    EventDeactivationManager eventDeactivationManager = EventDeactivationManager.INSTANCE;
                    EventDeactivationManager.processEvents(this.accumulatedEvents);
                    this.inFlightEvents.addAll(this.accumulatedEvents);
                    this.accumulatedEvents.clear();
                    JSONArray jSONArray = new JSONArray();
                    for (AppEvent appEvent : this.inFlightEvents) {
                        String str = appEvent.checksum;
                        if (str == null) {
                            zEquals = true;
                        } else {
                            String string = appEvent.jsonObject.toString();
                            Intrinsics.checkNotNullExpressionValue(string, "jsonObject.toString()");
                            zEquals = GraphRequest.Companion.access$md5Checksum(string).equals(str);
                        }
                        if (!zEquals) {
                            Intrinsics.stringPlus(appEvent, "Event with invalid checksum: ");
                            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                        } else if (z || !appEvent.isImplicit) {
                            jSONArray.put(appEvent.jsonObject);
                        }
                    }
                    if (jSONArray.length() == 0) {
                        return 0;
                    }
                    populateRequest(graphRequest, context, i, jSONArray, z2);
                    return jSONArray.length();
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(this, th2);
            return 0;
        }
    }

    public final void populateRequest(GraphRequest graphRequest, Context context, int i, JSONArray jSONArray, boolean z) {
        JSONObject jSONObject;
        try {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                HashMap map = AppEventsLoggerUtility.API_ACTIVITY_TYPE_TO_STRING;
                jSONObject = AppEventsLoggerUtility.getJSONObjectForGraphAPICall(AppEventsLoggerUtility.GraphAPIActivityType.CUSTOM_APP_EVENTS, this.attributionIdentifiers, this.anonymousAppDeviceGUID, z, context);
                if (this.numSkippedEventsDueToFullBuffer > 0) {
                    jSONObject.put("num_skipped_events", i);
                }
            } catch (JSONException unused) {
                jSONObject = new JSONObject();
            }
            graphRequest.graphObject = jSONObject;
            Bundle bundle = graphRequest.parameters;
            String string = jSONArray.toString();
            Intrinsics.checkNotNullExpressionValue(string, "events.toString()");
            bundle.putString("custom_events", string);
            graphRequest.tag = string;
            graphRequest.parameters = bundle;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }
}
