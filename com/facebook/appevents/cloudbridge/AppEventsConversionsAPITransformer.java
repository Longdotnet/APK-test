package com.facebook.appevents.cloudbridge;

import androidx.lifecycle.hSi.sgtsHsWT;
import androidx.startup.StartupException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AppEventsConversionsAPITransformer {
    public static final Object customEventTransformations;
    public static final Object standardEventTransformations;
    public static final Object topLevelTransformations;

    /* JADX INFO: loaded from: classes.dex */
    public enum DataProcessingParameterName {
        /* JADX INFO: Fake field, exist only in values array */
        OPTIONS("data_processing_options"),
        /* JADX INFO: Fake field, exist only in values array */
        COUNTRY("data_processing_options_country"),
        /* JADX INFO: Fake field, exist only in values array */
        STATE("data_processing_options_state");

        public final String rawValue;

        /* JADX INFO: renamed from: EF7 */
        DataProcessingParameterName OPTIONS;

        /* JADX INFO: renamed from: EF17 */
        DataProcessingParameterName COUNTRY;

        /* JADX INFO: renamed from: EF27 */
        DataProcessingParameterName STATE;

        DataProcessingParameterName(String str) {
            this.rawValue = str;
        }

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static DataProcessingParameterName[] valuesCustom() {
            return (DataProcessingParameterName[]) Arrays.copyOf(values(), 3);
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public final class SectionCustomEventFieldMapping {
        public final ConversionsAPICustomEventField field;
        public final ConversionsAPISection section;

        public SectionCustomEventFieldMapping(ConversionsAPISection conversionsAPISection, ConversionsAPICustomEventField field) {
            Intrinsics.checkNotNullParameter(field, "field");
            this.section = conversionsAPISection;
            this.field = field;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SectionCustomEventFieldMapping)) {
                return false;
            }
            SectionCustomEventFieldMapping sectionCustomEventFieldMapping = (SectionCustomEventFieldMapping) obj;
            return this.section == sectionCustomEventFieldMapping.section && this.field == sectionCustomEventFieldMapping.field;
        }

        public final int hashCode() {
            ConversionsAPISection conversionsAPISection = this.section;
            return this.field.hashCode() + ((conversionsAPISection == null ? 0 : conversionsAPISection.hashCode()) * 31);
        }

        public final String toString() {
            return "SectionCustomEventFieldMapping(section=" + this.section + ", field=" + this.field + ')';
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public final class SectionFieldMapping {
        public ConversionsAPIUserAndAppDataField field;
        public ConversionsAPISection section;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SectionFieldMapping)) {
                return false;
            }
            SectionFieldMapping sectionFieldMapping = (SectionFieldMapping) obj;
            return this.section == sectionFieldMapping.section && this.field == sectionFieldMapping.field;
        }

        public final int hashCode() {
            int iHashCode = this.section.hashCode() * 31;
            ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField = this.field;
            return iHashCode + (conversionsAPIUserAndAppDataField == null ? 0 : conversionsAPIUserAndAppDataField.hashCode());
        }

        public final String toString() {
            return "SectionFieldMapping(section=" + this.section + ", field=" + this.field + ')';
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public final class ValueTransformationType extends Enum {
        public static final /* synthetic */ ValueTransformationType[] $VALUES;
        public static final ValueTransformationType ARRAY;
        public static final ValueTransformationType BOOL;
        public static final ValueTransformationType INT;

        static {
            ValueTransformationType valueTransformationType = new ValueTransformationType("ARRAY", 0);
            ARRAY = valueTransformationType;
            ValueTransformationType valueTransformationType2 = new ValueTransformationType("BOOL", 1);
            BOOL = valueTransformationType2;
            ValueTransformationType valueTransformationType3 = new ValueTransformationType("INT", 2);
            INT = valueTransformationType3;
            $VALUES = new ValueTransformationType[]{valueTransformationType, valueTransformationType2, valueTransformationType3};
        }

        public static ValueTransformationType valueOf(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return (ValueTransformationType) Enum.valueOf(ValueTransformationType.class, value);
        }

        public static ValueTransformationType[] values() {
            return (ValueTransformationType[]) Arrays.copyOf($VALUES, 3);
        }
    }

    static {
        AppEventUserAndAppDataField appEventUserAndAppDataField = AppEventUserAndAppDataField.ANON_ID;
        ConversionsAPISection conversionsAPISection = ConversionsAPISection.USER_DATA;
        ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField = ConversionsAPIUserAndAppDataField.ANON_ID;
        SectionFieldMapping sectionFieldMapping = new SectionFieldMapping();
        sectionFieldMapping.section = conversionsAPISection;
        sectionFieldMapping.field = conversionsAPIUserAndAppDataField;
        Pair pair = new Pair(appEventUserAndAppDataField, sectionFieldMapping);
        AppEventUserAndAppDataField appEventUserAndAppDataField2 = AppEventUserAndAppDataField.APP_USER_ID;
        ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField2 = ConversionsAPIUserAndAppDataField.FB_LOGIN_ID;
        SectionFieldMapping sectionFieldMapping2 = new SectionFieldMapping();
        sectionFieldMapping2.section = conversionsAPISection;
        sectionFieldMapping2.field = conversionsAPIUserAndAppDataField2;
        Pair pair2 = new Pair(appEventUserAndAppDataField2, sectionFieldMapping2);
        AppEventUserAndAppDataField appEventUserAndAppDataField3 = AppEventUserAndAppDataField.ADVERTISER_ID;
        ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField3 = ConversionsAPIUserAndAppDataField.MAD_ID;
        SectionFieldMapping sectionFieldMapping3 = new SectionFieldMapping();
        sectionFieldMapping3.section = conversionsAPISection;
        sectionFieldMapping3.field = conversionsAPIUserAndAppDataField3;
        Pair pair3 = new Pair(appEventUserAndAppDataField3, sectionFieldMapping3);
        AppEventUserAndAppDataField appEventUserAndAppDataField4 = AppEventUserAndAppDataField.PAGE_ID;
        ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField4 = ConversionsAPIUserAndAppDataField.PAGE_ID;
        SectionFieldMapping sectionFieldMapping4 = new SectionFieldMapping();
        sectionFieldMapping4.section = conversionsAPISection;
        sectionFieldMapping4.field = conversionsAPIUserAndAppDataField4;
        Pair pair4 = new Pair(appEventUserAndAppDataField4, sectionFieldMapping4);
        AppEventUserAndAppDataField appEventUserAndAppDataField5 = AppEventUserAndAppDataField.PAGE_SCOPED_USER_ID;
        ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField5 = ConversionsAPIUserAndAppDataField.PAGE_SCOPED_USER_ID;
        SectionFieldMapping sectionFieldMapping5 = new SectionFieldMapping();
        sectionFieldMapping5.section = conversionsAPISection;
        sectionFieldMapping5.field = conversionsAPIUserAndAppDataField5;
        Pair pair5 = new Pair(appEventUserAndAppDataField5, sectionFieldMapping5);
        AppEventUserAndAppDataField appEventUserAndAppDataField6 = AppEventUserAndAppDataField.ADV_TE;
        ConversionsAPISection conversionsAPISection2 = ConversionsAPISection.APP_DATA;
        ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField6 = ConversionsAPIUserAndAppDataField.ADV_TE;
        SectionFieldMapping sectionFieldMapping6 = new SectionFieldMapping();
        sectionFieldMapping6.section = conversionsAPISection2;
        sectionFieldMapping6.field = conversionsAPIUserAndAppDataField6;
        Pair pair6 = new Pair(appEventUserAndAppDataField6, sectionFieldMapping6);
        AppEventUserAndAppDataField appEventUserAndAppDataField7 = AppEventUserAndAppDataField.APP_TE;
        ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField7 = ConversionsAPIUserAndAppDataField.APP_TE;
        SectionFieldMapping sectionFieldMapping7 = new SectionFieldMapping();
        sectionFieldMapping7.section = conversionsAPISection2;
        sectionFieldMapping7.field = conversionsAPIUserAndAppDataField7;
        Pair pair7 = new Pair(appEventUserAndAppDataField7, sectionFieldMapping7);
        AppEventUserAndAppDataField appEventUserAndAppDataField8 = AppEventUserAndAppDataField.CONSIDER_VIEWS;
        ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField8 = ConversionsAPIUserAndAppDataField.CONSIDER_VIEWS;
        SectionFieldMapping sectionFieldMapping8 = new SectionFieldMapping();
        sectionFieldMapping8.section = conversionsAPISection2;
        sectionFieldMapping8.field = conversionsAPIUserAndAppDataField8;
        Pair pair8 = new Pair(appEventUserAndAppDataField8, sectionFieldMapping8);
        AppEventUserAndAppDataField appEventUserAndAppDataField9 = AppEventUserAndAppDataField.DEVICE_TOKEN;
        ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField9 = ConversionsAPIUserAndAppDataField.DEVICE_TOKEN;
        SectionFieldMapping sectionFieldMapping9 = new SectionFieldMapping();
        sectionFieldMapping9.section = conversionsAPISection2;
        sectionFieldMapping9.field = conversionsAPIUserAndAppDataField9;
        Pair pair9 = new Pair(appEventUserAndAppDataField9, sectionFieldMapping9);
        AppEventUserAndAppDataField appEventUserAndAppDataField10 = AppEventUserAndAppDataField.EXT_INFO;
        ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField10 = ConversionsAPIUserAndAppDataField.EXT_INFO;
        SectionFieldMapping sectionFieldMapping10 = new SectionFieldMapping();
        sectionFieldMapping10.section = conversionsAPISection2;
        sectionFieldMapping10.field = conversionsAPIUserAndAppDataField10;
        Pair pair10 = new Pair(appEventUserAndAppDataField10, sectionFieldMapping10);
        AppEventUserAndAppDataField appEventUserAndAppDataField11 = AppEventUserAndAppDataField.INCLUDE_DWELL_DATA;
        ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField11 = ConversionsAPIUserAndAppDataField.INCLUDE_DWELL_DATA;
        SectionFieldMapping sectionFieldMapping11 = new SectionFieldMapping();
        sectionFieldMapping11.section = conversionsAPISection2;
        sectionFieldMapping11.field = conversionsAPIUserAndAppDataField11;
        Pair pair11 = new Pair(appEventUserAndAppDataField11, sectionFieldMapping11);
        AppEventUserAndAppDataField appEventUserAndAppDataField12 = AppEventUserAndAppDataField.INCLUDE_VIDEO_DATA;
        ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField12 = ConversionsAPIUserAndAppDataField.INCLUDE_VIDEO_DATA;
        SectionFieldMapping sectionFieldMapping12 = new SectionFieldMapping();
        sectionFieldMapping12.section = conversionsAPISection2;
        sectionFieldMapping12.field = conversionsAPIUserAndAppDataField12;
        Pair pair12 = new Pair(appEventUserAndAppDataField12, sectionFieldMapping12);
        AppEventUserAndAppDataField appEventUserAndAppDataField13 = AppEventUserAndAppDataField.INSTALL_REFERRER;
        ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField13 = ConversionsAPIUserAndAppDataField.INSTALL_REFERRER;
        SectionFieldMapping sectionFieldMapping13 = new SectionFieldMapping();
        sectionFieldMapping13.section = conversionsAPISection2;
        sectionFieldMapping13.field = conversionsAPIUserAndAppDataField13;
        Pair pair13 = new Pair(appEventUserAndAppDataField13, sectionFieldMapping13);
        AppEventUserAndAppDataField appEventUserAndAppDataField14 = AppEventUserAndAppDataField.INSTALLER_PACKAGE;
        ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField14 = ConversionsAPIUserAndAppDataField.INSTALLER_PACKAGE;
        SectionFieldMapping sectionFieldMapping14 = new SectionFieldMapping();
        sectionFieldMapping14.section = conversionsAPISection2;
        sectionFieldMapping14.field = conversionsAPIUserAndAppDataField14;
        Pair pair14 = new Pair(appEventUserAndAppDataField14, sectionFieldMapping14);
        AppEventUserAndAppDataField appEventUserAndAppDataField15 = AppEventUserAndAppDataField.RECEIPT_DATA;
        ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField15 = ConversionsAPIUserAndAppDataField.RECEIPT_DATA;
        SectionFieldMapping sectionFieldMapping15 = new SectionFieldMapping();
        sectionFieldMapping15.section = conversionsAPISection2;
        sectionFieldMapping15.field = conversionsAPIUserAndAppDataField15;
        Pair pair15 = new Pair(appEventUserAndAppDataField15, sectionFieldMapping15);
        AppEventUserAndAppDataField appEventUserAndAppDataField16 = AppEventUserAndAppDataField.URL_SCHEMES;
        ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField16 = ConversionsAPIUserAndAppDataField.URL_SCHEMES;
        SectionFieldMapping sectionFieldMapping16 = new SectionFieldMapping();
        sectionFieldMapping16.section = conversionsAPISection2;
        sectionFieldMapping16.field = conversionsAPIUserAndAppDataField16;
        Pair pair16 = new Pair(appEventUserAndAppDataField16, sectionFieldMapping16);
        AppEventUserAndAppDataField appEventUserAndAppDataField17 = AppEventUserAndAppDataField.USER_DATA;
        SectionFieldMapping sectionFieldMapping17 = new SectionFieldMapping();
        sectionFieldMapping17.section = conversionsAPISection;
        sectionFieldMapping17.field = null;
        topLevelTransformations = MapsKt__MapsKt.mapOf(pair, pair2, pair3, pair4, pair5, pair6, pair7, pair8, pair9, pair10, pair11, pair12, pair13, pair14, pair15, pair16, new Pair(appEventUserAndAppDataField17, sectionFieldMapping17));
        Pair pair17 = new Pair(CustomEventField.EVENT_TIME, new SectionCustomEventFieldMapping(null, ConversionsAPICustomEventField.EVENT_TIME));
        Pair pair18 = new Pair(CustomEventField.EVENT_NAME, new SectionCustomEventFieldMapping(null, ConversionsAPICustomEventField.EVENT_NAME));
        CustomEventField customEventField = CustomEventField.VALUE_TO_SUM;
        ConversionsAPISection conversionsAPISection3 = ConversionsAPISection.CUSTOM_DATA;
        customEventTransformations = MapsKt__MapsKt.mapOf(pair17, pair18, new Pair(customEventField, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.VALUE_TO_SUM)), new Pair(CustomEventField.CONTENT_IDS, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.CONTENT_IDS)), new Pair(CustomEventField.CONTENTS, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.CONTENTS)), new Pair(CustomEventField.CONTENT_TYPE, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.CONTENT_TYPE)), new Pair(CustomEventField.CURRENCY, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.CURRENCY)), new Pair(CustomEventField.DESCRIPTION, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.DESCRIPTION)), new Pair(CustomEventField.LEVEL, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.LEVEL)), new Pair(CustomEventField.MAX_RATING_VALUE, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.MAX_RATING_VALUE)), new Pair(CustomEventField.NUM_ITEMS, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.NUM_ITEMS)), new Pair(CustomEventField.PAYMENT_INFO_AVAILABLE, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.PAYMENT_INFO_AVAILABLE)), new Pair(CustomEventField.REGISTRATION_METHOD, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.REGISTRATION_METHOD)), new Pair(CustomEventField.SEARCH_STRING, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.SEARCH_STRING)), new Pair(CustomEventField.SUCCESS, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.SUCCESS)), new Pair(CustomEventField.ORDER_ID, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.ORDER_ID)), new Pair(CustomEventField.AD_TYPE, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.AD_TYPE)));
        standardEventTransformations = MapsKt__MapsKt.mapOf(new Pair("fb_mobile_achievement_unlocked", ConversionsAPIEventName.UNLOCKED_ACHIEVEMENT), new Pair("fb_mobile_activate_app", ConversionsAPIEventName.ACTIVATED_APP), new Pair("fb_mobile_add_payment_info", ConversionsAPIEventName.ADDED_PAYMENT_INFO), new Pair("fb_mobile_add_to_cart", ConversionsAPIEventName.ADDED_TO_CART), new Pair("fb_mobile_add_to_wishlist", ConversionsAPIEventName.ADDED_TO_WISHLIST), new Pair("fb_mobile_complete_registration", ConversionsAPIEventName.COMPLETED_REGISTRATION), new Pair("fb_mobile_content_view", ConversionsAPIEventName.VIEWED_CONTENT), new Pair("fb_mobile_initiated_checkout", ConversionsAPIEventName.INITIATED_CHECKOUT), new Pair("fb_mobile_level_achieved", ConversionsAPIEventName.ACHIEVED_LEVEL), new Pair("fb_mobile_purchase", ConversionsAPIEventName.PURCHASED), new Pair("fb_mobile_rate", ConversionsAPIEventName.RATED), new Pair("fb_mobile_search", ConversionsAPIEventName.SEARCHED), new Pair("fb_mobile_spent_credits", ConversionsAPIEventName.SPENT_CREDITS), new Pair("fb_mobile_tutorial_completion", ConversionsAPIEventName.COMPLETED_TUTORIAL));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.lang.Object] */
    public static final Object transformValue$facebook_core_release(Object obj, String str) {
        boolean zEquals = str.equals("extInfo");
        ValueTransformationType valueTransformationType = ValueTransformationType.ARRAY;
        if (!zEquals && !str.equals("url_schemes") && !str.equals("fb_content_id") && !str.equals(sgtsHsWT.URpmO) && !str.equals("data_processing_options")) {
            boolean zEquals2 = str.equals("advertiser_tracking_enabled");
            valueTransformationType = ValueTransformationType.BOOL;
            if (!zEquals2 && !str.equals("application_tracking_enabled")) {
                valueTransformationType = str.equals("_logTime") ? ValueTransformationType.INT : null;
            }
        }
        String str2 = obj instanceof String ? (String) obj : null;
        if (valueTransformationType == null || str2 == null) {
            return obj;
        }
        int iOrdinal = valueTransformationType.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                if (iOrdinal == 2) {
                    return StringsKt__StringsKt.toIntOrNull(obj.toString());
                }
                throw new StartupException();
            }
            Integer intOrNull = StringsKt__StringsKt.toIntOrNull(str2.toString());
            if (intOrNull != null) {
                return Boolean.valueOf(intOrNull.intValue() != 0);
            }
            return null;
        }
        try {
            ArrayList<??> arrayListConvertJSONArrayToList = Utility.convertJSONArrayToList(new JSONArray(str2));
            ArrayList arrayList = new ArrayList();
            for (?? ConvertJSONArrayToList : arrayListConvertJSONArrayToList) {
                try {
                    try {
                        ConvertJSONArrayToList = Utility.convertJSONObjectToHashMap(new JSONObject((String) ConvertJSONArrayToList));
                    } catch (JSONException unused) {
                        ConvertJSONArrayToList = Utility.convertJSONArrayToList(new JSONArray((String) ConvertJSONArrayToList));
                    }
                } catch (JSONException unused2) {
                }
                arrayList.add(ConvertJSONArrayToList);
            }
            return arrayList;
        } catch (JSONException unused3) {
            GraphRequest.Companion companion = Logger.Companion;
            synchronized (FacebookSdk.loggingBehaviors) {
                return Unit.INSTANCE;
            }
        }
    }
}
