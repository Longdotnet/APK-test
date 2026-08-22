package com.facebook.appevents.cloudbridge;

import com.google.android.gms.common.util.concurrent.dN.MnHfHMYQDPUO;
import com.google.android.gms.games.provider.NtJ.wsbWxekY;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public enum ConversionsAPICustomEventField {
    VALUE_TO_SUM(FirebaseAnalytics.Param.VALUE),
    EVENT_TIME("event_time"),
    EVENT_NAME("event_name"),
    CONTENT_IDS("content_ids"),
    CONTENTS("contents"),
    CONTENT_TYPE(FirebaseAnalytics.Param.CONTENT_TYPE),
    DESCRIPTION("description"),
    LEVEL(MnHfHMYQDPUO.iZlQosUyFxoEmRz),
    MAX_RATING_VALUE("max_rating_value"),
    NUM_ITEMS(wsbWxekY.aZxpfZU),
    PAYMENT_INFO_AVAILABLE("payment_info_available"),
    REGISTRATION_METHOD("registration_method"),
    SEARCH_STRING("search_string"),
    SUCCESS(FirebaseAnalytics.Param.SUCCESS),
    ORDER_ID("order_id"),
    AD_TYPE("ad_type"),
    CURRENCY(FirebaseAnalytics.Param.CURRENCY);

    public final String rawValue;

    ConversionsAPICustomEventField(String str) {
        this.rawValue = str;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static ConversionsAPICustomEventField[] valuesCustom() {
        return (ConversionsAPICustomEventField[]) Arrays.copyOf(values(), 17);
    }
}
