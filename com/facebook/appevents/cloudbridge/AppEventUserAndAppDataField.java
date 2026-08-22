package com.facebook.appevents.cloudbridge;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public enum AppEventUserAndAppDataField {
    ANON_ID("anon_id"),
    APP_USER_ID("app_user_id"),
    ADVERTISER_ID("advertiser_id"),
    PAGE_ID("page_id"),
    PAGE_SCOPED_USER_ID("page_scoped_user_id"),
    USER_DATA("ud"),
    ADV_TE("advertiser_tracking_enabled"),
    APP_TE("application_tracking_enabled"),
    CONSIDER_VIEWS("consider_views"),
    DEVICE_TOKEN("device_token"),
    EXT_INFO("extInfo"),
    INCLUDE_DWELL_DATA("include_dwell_data"),
    INCLUDE_VIDEO_DATA("include_video_data"),
    INSTALL_REFERRER("install_referrer"),
    INSTALLER_PACKAGE("installer_package"),
    RECEIPT_DATA("receipt_data"),
    URL_SCHEMES("url_schemes");

    public final String rawValue;

    AppEventUserAndAppDataField(String str) {
        this.rawValue = str;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static AppEventUserAndAppDataField[] valuesCustom() {
        return (AppEventUserAndAppDataField[]) Arrays.copyOf(values(), 17);
    }
}
