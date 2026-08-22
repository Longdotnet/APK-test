package com.facebook.internal;

import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class FacebookRequestErrorClassification {
    public static final GraphRequest.Companion Companion = new GraphRequest.Companion(10);
    public static FacebookRequestErrorClassification defaultInstance;
    public final HashMap loginRecoverableErrors;
    public final HashMap otherErrors;
    public final HashMap transientErrors;

    public abstract /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FacebookRequestError.Category.values().length];
            iArr[1] = 1;
            iArr[0] = 2;
            iArr[2] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public FacebookRequestErrorClassification(HashMap map, HashMap map2, HashMap map3, String str, String str2, String str3) {
        this.otherErrors = map;
        this.transientErrors = map2;
        this.loginRecoverableErrors = map3;
    }
}
