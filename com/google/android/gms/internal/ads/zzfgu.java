package com.google.android.gms.internal.ads;

import androidx.emoji2.text.flatbuffer.bs.bUqMCsuPSX;
import androidx.loader.app.gv.DYYbQc;
import com.google.android.finsky.externalreferrer.jUdg.RDFWIi;

/* JADX INFO: loaded from: classes2.dex */
public enum zzfgu {
    SIGNALS("signals"),
    REQUEST_PARCEL("request-parcel"),
    SERVER_TRANSACTION("server-transaction"),
    RENDERER("renderer"),
    GMS_SIGNALS(RDFWIi.JKMp),
    AD_REQUEST("ad_request"),
    BUILD_URL("build-url"),
    PREPARE_HTTP_REQUEST("prepare-http-request"),
    HTTP("http"),
    PROXY("proxy"),
    PRE_PROCESS("preprocess"),
    GET_SIGNALS("get-signals"),
    JS_SIGNALS("js-signals"),
    RENDER_CONFIG_INIT("render-config-init"),
    RENDER_CONFIG_WATERFALL("render-config-waterfall"),
    RENDER_CONFIG_PARALLEL("render-config-parallel"),
    ADAPTER_LOAD_AD_SYN(bUqMCsuPSX.cgp),
    ADAPTER_LOAD_AD_ACK("adapter-load-ad-ack"),
    ADAPTER_WRAP_ADAPTER("wrap-adapter"),
    CUSTOM_RENDER_SYN("custom-render-syn"),
    zzu("custom-render-ack"),
    WEBVIEW_COOKIE("webview-cookie"),
    GENERATE_SIGNALS("generate-signals"),
    GET_CACHE_KEY("get-cache-key"),
    NOTIFY_CACHE_HIT("notify-cache-hit"),
    GET_URL_AND_CACHE_KEY(DYYbQc.Bbxuizn),
    PRELOADED_LOADER("preloaded-loader");

    private final String zzC;

    zzfgu(String str) {
        this.zzC = str;
    }

    public final String zza() {
        return this.zzC;
    }
}
