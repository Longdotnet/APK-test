package com.google.android.gms.internal.ads;

import com.google.android.gms.appset.vSSa.iafHZUfOuHNwvy;
import okhttp3.internal.concurrent.onZL.mnwSv;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdrs {
    public static final zzfyq zza;
    public static final zzfyq zzb;
    private final String zzc;
    private final zzdrr zzd;
    private final zzdrr zze;

    public zzdrs(String str, zzdrr zzdrrVar, zzdrr zzdrrVar2) {
        this.zzc = str;
        this.zzd = zzdrrVar;
        this.zze = zzdrrVar2;
    }

    public final zzdrr zza() {
        return this.zzd;
    }

    public final zzdrr zzb() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzc;
    }

    static {
        zzdrr zzdrrVar = zzdrr.PUBLIC_API_CALL;
        zzdrr zzdrrVar2 = zzdrr.PUBLIC_API_CALLBACK;
        zzdrs zzdrsVar = new zzdrs("tqgt", zzdrrVar, zzdrrVar2);
        zzdrr zzdrrVar3 = zzdrr.DYNAMITE_ENTER;
        zzdrs zzdrsVar2 = new zzdrs("l.dl", zzdrrVar, zzdrrVar3);
        zzdrr zzdrrVar4 = zzdrr.READ_FROM_DISK_START;
        zzdrs zzdrsVar3 = new zzdrs("l.rccde", zzdrrVar3, zzdrrVar4);
        zzdrs zzdrsVar4 = new zzdrs("l.rfd", zzdrrVar4, zzdrr.READ_FROM_DISK_END);
        zzdrr zzdrrVar5 = zzdrr.CLIENT_SIGNALS_START;
        zzdrs zzdrsVar5 = new zzdrs("l.rcc", zzdrrVar3, zzdrrVar5);
        zzdrr zzdrrVar6 = zzdrr.CLIENT_SIGNALS_END;
        zzdrs zzdrsVar6 = new zzdrs("l.cs", zzdrrVar5, zzdrrVar6);
        zzdrr zzdrrVar7 = zzdrr.SERVICE_CONNECTED;
        zzdrs zzdrsVar7 = new zzdrs("l.cts", zzdrrVar6, zzdrrVar7);
        zzdrr zzdrrVar8 = zzdrr.GMS_SIGNALS_START;
        zzdrr zzdrrVar9 = zzdrr.zzi;
        zzdrs zzdrsVar8 = new zzdrs("l.gs", zzdrrVar8, zzdrrVar9);
        zzdrr zzdrrVar10 = zzdrr.GET_SIGNALS_SDKCORE_START;
        zzdrs zzdrsVar9 = new zzdrs("l.jse", zzdrrVar9, zzdrrVar10);
        zzdrr zzdrrVar11 = zzdrr.GET_SIGNALS_SDKCORE_END;
        zzdrs zzdrsVar10 = new zzdrs("l.gs-sdkcore", zzdrrVar10, zzdrrVar11);
        zzdrs zzdrsVar11 = new zzdrs("l.gs-pp", zzdrrVar11, zzdrrVar2);
        zzdrr zzdrrVar12 = zzdrr.zzu;
        String str = iafHZUfOuHNwvy.wglLqw;
        zzdrs zzdrsVar12 = new zzdrs(str, zzdrrVar12, zzdrrVar2);
        zzdrr zzdrrVar13 = zzdrr.RENDERING_WEBVIEW_CREATION_START;
        zzdrs zzdrsVar13 = new zzdrs("l.render.pre", zzdrrVar12, zzdrrVar13);
        zzdrr zzdrrVar14 = zzdrr.RENDERING_WEBVIEW_CREATION_END;
        zzdrs zzdrsVar14 = new zzdrs("l.render.wvc", zzdrrVar13, zzdrrVar14);
        zzdrr zzdrrVar15 = zzdrr.RENDERING_AD_COMPONENT_CREATION_END;
        zzdrs zzdrsVar15 = new zzdrs("l.render.acc", zzdrrVar14, zzdrrVar15);
        zzdrr zzdrrVar16 = zzdrr.RENDERING_CONFIGURE_WEBVIEW_START;
        zzdrr zzdrrVar17 = zzdrr.RENDERING_CONFIGURE_WEBVIEW_END;
        zzdrs zzdrsVar16 = new zzdrs("l.render.cfg-wv", zzdrrVar16, zzdrrVar17);
        zzdrr zzdrrVar18 = zzdrr.RENDERING_WEBVIEW_LOAD_HTML_START;
        zzdrr zzdrrVar19 = zzdrr.RENDERING_WEBVIEW_LOAD_HTML_END;
        zza = zzfyq.zzt(zzdrsVar, zzdrsVar2, zzdrsVar3, zzdrsVar4, zzdrsVar5, zzdrsVar6, zzdrsVar7, zzdrsVar8, zzdrsVar9, zzdrsVar10, zzdrsVar11, zzdrsVar12, zzdrsVar13, zzdrsVar14, zzdrsVar15, zzdrsVar16, new zzdrs("l.render.wvlh", zzdrrVar18, zzdrrVar19), new zzdrs("l.render.post", zzdrrVar19, zzdrrVar2), new zzdrs("l.sodv", zzdrr.SIGNAL_ON_DISK_VALIDATION_START, zzdrr.SIGNAL_ON_DISK_VALIDATION_END), new zzdrs("l.sodck", zzdrr.SIGNAL_ON_DISK_CACHE_KEY_START, zzdrr.SIGNAL_ON_DISK_CACHE_KEY_END), new zzdrs("l.sodrar", zzdrr.SIGNAL_ON_DISK_READ_AND_REMOVE_START, zzdrr.SIGNAL_ON_DISK_READ_AND_REMOVE_END), new zzdrs("l.soddc", zzdrr.SIGNAL_ON_DISK_DECODE_START, zzdrr.SIGNAL_ON_DISK_DECODE_END));
        zzdrs zzdrsVar17 = new zzdrs("l.al", zzdrrVar, zzdrrVar2);
        zzdrs zzdrsVar18 = new zzdrs("l.al2", zzdrrVar3, zzdrrVar2);
        zzdrs zzdrsVar19 = new zzdrs("l.dl", zzdrrVar, zzdrrVar3);
        zzdrs zzdrsVar20 = new zzdrs("l.rcc", zzdrrVar3, zzdrrVar5);
        zzdrs zzdrsVar21 = new zzdrs("l.cs", zzdrrVar5, zzdrrVar6);
        zzdrs zzdrsVar22 = new zzdrs("l.cts", zzdrrVar6, zzdrrVar7);
        zzdrs zzdrsVar23 = new zzdrs("l.gs", zzdrrVar8, zzdrrVar9);
        zzdrr zzdrrVar20 = zzdrr.GET_AD_DICTIONARY_SDKCORE_START;
        zzdrs zzdrsVar24 = new zzdrs("l.jse", zzdrrVar9, zzdrrVar20);
        zzdrr zzdrrVar21 = zzdrr.zzm;
        zzdrs zzdrsVar25 = new zzdrs("l.gad-js", zzdrrVar20, zzdrrVar21);
        zzdrr zzdrrVar22 = zzdrr.HTTP_RESPONSE_READY;
        zzdrs zzdrsVar26 = new zzdrs("l.http", zzdrrVar21, zzdrrVar22);
        zzdrr zzdrrVar23 = zzdrr.SCAR_PRELOADER_READY;
        zzdrs zzdrsVar27 = new zzdrs("l.slas.pre", zzdrrVar, zzdrrVar23);
        zzdrr zzdrrVar24 = zzdrr.SCAR_PRELOADER_PROCESSING_DONE;
        zzdrs zzdrsVar28 = new zzdrs("l.slas.prel.p", zzdrrVar23, zzdrrVar24);
        zzdrr zzdrrVar25 = zzdrr.NORMALIZATION_AD_RESPONSE_START;
        zzdrs zzdrsVar29 = new zzdrs("l.jse-nml", zzdrrVar22, zzdrrVar25);
        zzdrs zzdrsVar30 = new zzdrs("l.jse-nml", zzdrrVar24, zzdrrVar25);
        zzdrr zzdrrVar26 = zzdrr.NORMALIZATION_AD_RESPONSE_END;
        zzdrs zzdrsVar31 = new zzdrs("l.nml-js", zzdrrVar25, zzdrrVar26);
        zzdrr zzdrrVar27 = zzdrr.BINDER_CALL_START;
        zzdrs zzdrsVar32 = new zzdrs("l.nml-gmsg", zzdrrVar26, zzdrrVar27);
        zzdrr zzdrrVar28 = zzdrr.SERVER_RESPONSE_PARSE_START;
        zzdrs zzdrsVar33 = new zzdrs("l.nml-gmsg.s2s", zzdrrVar26, zzdrrVar28);
        zzdrs zzdrsVar34 = new zzdrs("l.binder", zzdrrVar27, zzdrrVar28);
        zzdrs zzdrsVar35 = new zzdrs("l.sr", zzdrrVar28, zzdrrVar12);
        zzdrs zzdrsVar36 = new zzdrs(str, zzdrrVar12, zzdrrVar2);
        zzdrs zzdrsVar37 = new zzdrs("l.t2", zzdrr.RENDERING_ADSTRING_TYPE2_FETCH_START, zzdrr.RENDERING_ADSTRING_TYPE2_FETCH_END);
        zzdrr zzdrrVar29 = zzdrr.RENDERING_NATIVE_ADS_NATIVE_JS_WEBVIEW_START;
        zzdrr zzdrrVar30 = zzdrr.RENDERING_NATIVE_ADS_PREPROCESS_START;
        zzdrs zzdrsVar38 = new zzdrs("l.render.na.js", zzdrrVar29, zzdrrVar30);
        zzdrs zzdrsVar39 = new zzdrs("l.render.na.prep", zzdrrVar30, zzdrr.RENDERING_NATIVE_ADS_PREPROCESS_END);
        zzdrs zzdrsVar40 = new zzdrs("l.render.na.lna", zzdrr.RENDERING_NATIVE_ASSETS_LOADING_START, zzdrr.RENDERING_NATIVE_ASSETS_LOADING_END);
        zzdrs zzdrsVar41 = new zzdrs("l.render.wvc", zzdrrVar13, zzdrrVar14);
        zzdrs zzdrsVar42 = new zzdrs("l.render.acc", zzdrrVar14, zzdrrVar15);
        zzdrs zzdrsVar43 = new zzdrs("l.render.cfg-wv", zzdrrVar16, zzdrrVar17);
        zzdrs zzdrsVar44 = new zzdrs("l.render.pre", zzdrrVar12, zzdrrVar13);
        zzdrs zzdrsVar45 = new zzdrs("l.render.post", zzdrrVar19, zzdrrVar2);
        zzdrs zzdrsVar46 = new zzdrs("l.render.na.post", zzdrrVar17, zzdrrVar2);
        zzdrs zzdrsVar47 = new zzdrs("l.render.wvlh", zzdrrVar18, zzdrrVar19);
        zzdrs zzdrsVar48 = new zzdrs("l.na.b", zzdrr.NATIVE_ASSETS_LOADING_BASIC_START, zzdrr.NATIVE_ASSETS_LOADING_BASIC_END);
        zzdrs zzdrsVar49 = new zzdrs("l.na.im", zzdrr.zzU, zzdrr.NATIVE_ASSETS_LOADING_IMAGE_END);
        zzdrs zzdrsVar50 = new zzdrs("l.na.imc", zzdrr.NATIVE_ASSETS_LOADING_IMAGE_COMPOSITION_START, zzdrr.NATIVE_ASSETS_LOADING_IMAGE_COMPOSITION_END);
        zzdrs zzdrsVar51 = new zzdrs("l.na.l", zzdrr.NATIVE_ASSETS_LOADING_LOGO_START, zzdrr.NATIVE_ASSETS_LOADING_LOGO_END);
        zzdrs zzdrsVar52 = new zzdrs("l.na.ic", zzdrr.NATIVE_ASSETS_LOADING_ICON_START, zzdrr.NATIVE_ASSETS_LOADING_ICON_END);
        zzdrs zzdrsVar53 = new zzdrs("l.na.a", zzdrr.NATIVE_ASSETS_LOADING_ATTRIBUTION_START, zzdrr.NATIVE_ASSETS_LOADING_ATTRIBUTION_END);
        zzdrr zzdrrVar31 = zzdrr.zzae;
        zzdrr zzdrrVar32 = zzdrr.NATIVE_ASSETS_LOADING_VIDEO_END;
        zzb = zzfyq.zzt(zzdrsVar17, zzdrsVar18, zzdrsVar19, zzdrsVar20, zzdrsVar21, zzdrsVar22, zzdrsVar23, zzdrsVar24, zzdrsVar25, zzdrsVar26, zzdrsVar27, zzdrsVar28, zzdrsVar29, zzdrsVar30, zzdrsVar31, zzdrsVar32, zzdrsVar33, zzdrsVar34, zzdrsVar35, zzdrsVar36, zzdrsVar37, zzdrsVar38, zzdrsVar39, zzdrsVar40, zzdrsVar41, zzdrsVar42, zzdrsVar43, zzdrsVar44, zzdrsVar45, zzdrsVar46, zzdrsVar47, zzdrsVar48, zzdrsVar49, zzdrsVar50, zzdrsVar51, zzdrsVar52, zzdrsVar53, new zzdrs("l.na.v", zzdrrVar31, zzdrrVar32), new zzdrs("l.na.vc", zzdrr.NATIVE_ASSETS_LOADING_VIDEO_COMPOSITION_START, zzdrrVar32), new zzdrs("l.na.m", zzdrr.NATIVE_ASSETS_LOADING_MEDIA_START, zzdrr.NATIVE_ASSETS_LOADING_MEDIA_END), new zzdrs(mnwSv.RbijbyMpP, zzdrr.NATIVE_ASSETS_LOADING_CUSTOM_START, zzdrr.zzak), new zzdrs("l.na.o", zzdrr.NATIVE_ASSETS_LOADING_OMID_START, zzdrr.NATIVE_ASSETS_LOADING_OMID_END));
    }
}
