package com.facebook.internal;

import java.util.EnumSet;
import java.util.HashMap;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public final class FetchedAppSettings {
    public final boolean automaticLoggingEnabled;
    public final boolean codelessEventsEnabled;
    public final FacebookRequestErrorClassification errorClassification;
    public final JSONArray eventBindings;
    public final boolean iAPAutomaticLoggingEnabled;
    public final String rawAamRules;
    public final String restrictiveDataSetting;
    public final String sdkUpdateMessage;
    public final int sessionTimeoutInSeconds;
    public final EnumSet smartLoginOptions;
    public final String suggestedEventsSetting;
    public final boolean supportsImplicitLogging;

    public final class DialogFeatureConfig {
        public String dialogName;
        public String featureName;
    }

    public FetchedAppSettings(boolean z, String str, int i, EnumSet enumSet, HashMap map, boolean z2, FacebookRequestErrorClassification facebookRequestErrorClassification, String str2, String str3, boolean z3, boolean z4, JSONArray jSONArray, String str4, String str5, String str6, String str7) {
        this.supportsImplicitLogging = z;
        this.sessionTimeoutInSeconds = i;
        this.smartLoginOptions = enumSet;
        this.automaticLoggingEnabled = z2;
        this.errorClassification = facebookRequestErrorClassification;
        this.iAPAutomaticLoggingEnabled = z3;
        this.codelessEventsEnabled = z4;
        this.eventBindings = jSONArray;
        this.sdkUpdateMessage = str4;
        this.rawAamRules = str5;
        this.suggestedEventsSetting = str6;
        this.restrictiveDataSetting = str7;
    }
}
