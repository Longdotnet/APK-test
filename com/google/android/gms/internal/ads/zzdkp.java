package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.gMU.QTaELkFI;
import com.google.android.gms.ads.jY.UUFMQdNK;
import com.google.android.gms.internal.common.Ko.TSDAbK;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import okio.Okio;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdkp {
    private final zzdpj zza;
    private final zzdny zzb;
    private ViewTreeObserver.OnScrollChangedListener zzc = null;

    public zzdkp(zzdpj zzdpjVar, zzdny zzdnyVar) {
        this.zza = zzdpjVar;
        this.zzb = zzdnyVar;
    }

    public static /* synthetic */ void zzb(zzdkp zzdkpVar, WindowManager windowManager, View view, zzcfg zzcfgVar, Map map) {
        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zze("Hide native ad policy validator overlay.");
        zzcfgVar.zzF().setVisibility(8);
        if (zzcfgVar.zzF().getWindowToken() != null) {
            windowManager.removeView(zzcfgVar.zzF());
        }
        zzcfgVar.destroy();
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (zzdkpVar.zzc == null || viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.removeOnScrollChangedListener(zzdkpVar.zzc);
    }

    public static void zzc(final zzdkp zzdkpVar, final View view, final WindowManager windowManager, final zzcfg zzcfgVar, final Map map) {
        zzcfgVar.zzN().zzC(new zzcgw() { // from class: com.google.android.gms.internal.ads.zzdkn
            @Override // com.google.android.gms.internal.ads.zzcgw
            public final void zza(boolean z, int i, String str, String str2) {
                zzdkp.zzd(this.zza, map, z, i, str, str2);
            }
        });
        if (map == null) {
            return;
        }
        Context context = view.getContext();
        String str = (String) map.get("validator_width");
        zzbcv zzbcvVar = zzbde.zziw;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        int iZzf = zzf(context, str, ((Integer) zzbdVar.zzd.zzb(zzbcvVar)).intValue());
        int iZzf2 = zzf(context, (String) map.get(QTaELkFI.siZA), ((Integer) zzbdVar.zzd.zzb(zzbde.zzix)).intValue());
        int iZzf3 = zzf(context, (String) map.get("validator_x"), 0);
        int iZzf4 = zzf(context, (String) map.get("validator_y"), 0);
        zzcfgVar.zzaj(zzchd.zzb(iZzf, iZzf2));
        try {
            zzcfgVar.zzG().getSettings().setUseWideViewPort(((Boolean) zzbdVar.zzd.zzb(zzbde.zziy)).booleanValue());
            zzcfgVar.zzG().getSettings().setLoadWithOverviewMode(((Boolean) zzbdVar.zzd.zzb(zzbde.zziz)).booleanValue());
        } catch (NullPointerException unused) {
        }
        final WindowManager.LayoutParams layoutParamsZzb = Okio.zzb();
        layoutParamsZzb.x = iZzf3;
        layoutParamsZzb.y = iZzf4;
        windowManager.updateViewLayout(zzcfgVar.zzF(), layoutParamsZzb);
        final String str2 = (String) map.get("orientation");
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
            final int i = (("1".equals(str2) || "2".equals(str2)) ? rect.bottom : rect.top) - iZzf4;
            zzdkpVar.zzc = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.google.android.gms.internal.ads.zzdko
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    Rect rect2 = new Rect();
                    if (view.getGlobalVisibleRect(rect2)) {
                        zzcfg zzcfgVar2 = zzcfgVar;
                        if (zzcfgVar2.zzF().getWindowToken() == null) {
                            return;
                        }
                        int i2 = i;
                        WindowManager.LayoutParams layoutParams = layoutParamsZzb;
                        String str3 = str2;
                        if ("1".equals(str3) || "2".equals(str3)) {
                            layoutParams.y = rect2.bottom - i2;
                        } else {
                            layoutParams.y = rect2.top - i2;
                        }
                        windowManager.updateViewLayout(zzcfgVar2.zzF(), layoutParams);
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnScrollChangedListener(zzdkpVar.zzc);
            }
        }
        String str3 = (String) map.get(UUFMQdNK.wWFMo);
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        zzcfgVar.loadUrl(str3);
    }

    public static /* synthetic */ void zzd(zzdkp zzdkpVar, Map map, boolean z, int i, String str, String str2) {
        HashMap map2 = new HashMap();
        map2.put("messageType", "validatorHtmlLoaded");
        map2.put("id", (String) map.get("id"));
        zzdkpVar.zzb.zzj("sendMessageToNativeJs", map2);
    }

    private static final int zzf(Context context, String str, int i) {
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
        }
        com.google.android.gms.ads.internal.util.client.zzf zzfVar = com.google.android.gms.ads.internal.client.zzbb.zzb.zzc;
        return com.google.android.gms.ads.internal.util.client.zzf.zzC(context, i);
    }

    public final View zza(final View view, final WindowManager windowManager) {
        zzcfg zzcfgVarZza = this.zza.zza(com.google.android.gms.ads.internal.client.zzr.zzc(), null, null);
        zzcfgVarZza.zzF().setVisibility(4);
        zzcfgVarZza.zzF().setContentDescription(TSDAbK.umVl);
        zzcfgVarZza.zzag("/sendMessageToSdk", new zzbkf() { // from class: com.google.android.gms.internal.ads.zzdkj
            @Override // com.google.android.gms.internal.ads.zzbkf
            public final void zza(Object obj, Map map) {
                this.zza.zzb.zzj("sendMessageToNativeJs", map);
            }
        });
        zzcfgVarZza.zzag("/hideValidatorOverlay", new zzbkf() { // from class: com.google.android.gms.internal.ads.zzdkk
            @Override // com.google.android.gms.internal.ads.zzbkf
            public final void zza(Object obj, Map map) {
                zzdkp.zzb(this.zza, windowManager, view, (zzcfg) obj, map);
            }
        });
        zzcfgVarZza.zzag("/open", new zzbkr(null, null, null, null, null));
        WeakReference weakReference = new WeakReference(zzcfgVarZza);
        zzbkf zzbkfVar = new zzbkf() { // from class: com.google.android.gms.internal.ads.zzdkl
            @Override // com.google.android.gms.internal.ads.zzbkf
            public final void zza(Object obj, Map map) {
                zzdkp.zzc(this.zza, view, windowManager, (zzcfg) obj, map);
            }
        };
        zzdny zzdnyVar = this.zzb;
        zzdnyVar.zzm(weakReference, "/loadNativeAdPolicyViolations", zzbkfVar);
        zzdnyVar.zzm(new WeakReference(zzcfgVarZza), "/showValidatorOverlay", new zzbkf() { // from class: com.google.android.gms.internal.ads.zzdkm
            @Override // com.google.android.gms.internal.ads.zzbkf
            public final void zza(Object obj, Map map) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zze("Show native ad policy validator overlay.");
                ((zzcfg) obj).zzF().setVisibility(0);
            }
        });
        return zzcfgVarZza.zzF();
    }
}
