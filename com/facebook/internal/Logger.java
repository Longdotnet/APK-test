package com.facebook.internal;

import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class Logger {
    public static final GraphRequest.Companion Companion = new GraphRequest.Companion(11);
    public static final HashMap stringsToReplace = new HashMap();
    public StringBuilder contents;
    public final String tag;

    public Logger() {
        Validate.notNullOrEmpty("Request", "tag");
        this.tag = Intrinsics.stringPlus("Request", "FacebookSDK.");
        this.contents = new StringBuilder();
    }

    public final void appendKeyValue(Object value, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        shouldLog();
    }

    public final void shouldLog() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        synchronized (FacebookSdk.loggingBehaviors) {
        }
    }
}
