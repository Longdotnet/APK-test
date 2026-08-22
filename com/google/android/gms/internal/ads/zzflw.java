package com.google.android.gms.internal.ads;

import android.view.View;
import android.webkit.WebView;
import androidx.webkit.WebViewCompat;
import androidx.webkit.internal.WebViewFeatureInternal;
import com.facebook.AccessTokenCache;
import com.facebook.ProfileCache;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Timer;
import kotlin.io.TextStreamsKt;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;

/* JADX INFO: loaded from: classes.dex */
public final class zzflw {
    private final zzfly zza;
    private final WebView zzb;
    private zzfnz zzc;
    private final HashMap zzd;
    private final zzfmm zze;

    private zzflw(zzfly zzflyVar, WebView webView, boolean z) {
        boolean z2 = false;
        HashMap map = new HashMap();
        this.zzd = map;
        this.zze = new zzfmm();
        zzfni.zza();
        this.zza = zzflyVar;
        this.zzb = webView;
        if (zza() != webView) {
            Iterator it = map.values().iterator();
            while (it.hasNext()) {
                ((zzfll) it.next()).zzd(webView);
            }
            this.zzc = new zzfnz(webView);
        }
        if (!TextStreamsKt.isFeatureSupported("WEB_MESSAGE_LISTENER")) {
            throw new UnsupportedOperationException("The JavaScriptSessionService cannot be supported in this WebView version.");
        }
        zzh();
        zzflv zzflvVar = new zzflv(this);
        WebView webView2 = this.zzb;
        HashSet hashSet = new HashSet(Arrays.asList("*"));
        int i = WebViewCompat.$r8$clinit;
        if (!WebViewFeatureInternal.WEB_MESSAGE_LISTENER.isSupportedByWebView()) {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
        AccessTokenCache provider = WebViewCompat.getProvider(webView2);
        String[] strArr = (String[]) hashSet.toArray(new String[0]);
        final ProfileCache profileCache = new ProfileCache(1, z2);
        profileCache.sharedPreferences = zzflvVar;
        ((WebViewProviderBoundaryInterface) provider.sharedPreferences).addWebMessageListener("omidJsSessionService", strArr, new InvocationHandler(profileCache) { // from class: org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil$InvocationHandlerWithDelegateGetter
            public final ProfileCache mDelegate;

            {
                this.mDelegate = profileCache;
            }

            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                try {
                    return Class.forName(method.getDeclaringClass().getName(), true, ProfileCache.class.getClassLoader()).getDeclaredMethod(method.getName(), method.getParameterTypes()).invoke(this.mDelegate, objArr);
                } catch (InvocationTargetException e) {
                    throw e.getTargetException();
                } catch (ReflectiveOperationException e2) {
                    throw new RuntimeException("Reflection failed for method " + method, e2);
                }
            }
        });
    }

    public static zzflw zzb(zzfly zzflyVar, WebView webView, boolean z) {
        return new zzflw(zzflyVar, webView, true);
    }

    public static /* bridge */ /* synthetic */ void zzc(zzflw zzflwVar, String str) {
        HashMap map = zzflwVar.zzd;
        zzfll zzfllVar = (zzfll) map.get(str);
        if (zzfllVar != null) {
            zzfllVar.zzc();
            map.remove(str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* bridge */ /* synthetic */ void zze(zzflw zzflwVar, String str) {
        zzflq zzflqVar = zzflq.DEFINED_BY_JAVASCRIPT;
        zzflt zzfltVar = zzflt.DEFINED_BY_JAVASCRIPT;
        zzflx zzflxVar = zzflx.JAVASCRIPT;
        zzflp zzflpVar = new zzflp(zzflm.zza(zzflqVar, zzfltVar, zzflxVar, zzflxVar, false), zzfln.zzb(zzflwVar.zza, zzflwVar.zzb, null, null), str);
        zzflwVar.zzd.put(str, zzflpVar);
        zzflpVar.zzd(zzflwVar.zza());
        for (zzfml zzfmlVar : zzflwVar.zze.zza()) {
            zzflpVar.zzb((View) zzfmlVar.zzb().get(), zzfmlVar.zza(), zzfmlVar.zzc());
        }
        zzflpVar.zze();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzh() {
        WebView webView = this.zzb;
        int i = WebViewCompat.$r8$clinit;
        if (!WebViewFeatureInternal.WEB_MESSAGE_LISTENER.isSupportedByWebView()) {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
        ((WebViewProviderBoundaryInterface) WebViewCompat.getProvider(webView).sharedPreferences).removeWebMessageListener("omidJsSessionService");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View zza() {
        zzfnz zzfnzVar = this.zzc;
        if (zzfnzVar == null) {
            return null;
        }
        return (View) zzfnzVar.get();
    }

    public final void zzf(View view, zzfls zzflsVar, String str) {
        Iterator it = this.zzd.values().iterator();
        while (it.hasNext()) {
            ((zzfll) it.next()).zzb(view, zzflsVar, "Ad overlay");
        }
        this.zze.zzb(view, zzflsVar, "Ad overlay");
    }

    public final void zzg(zzcfx zzcfxVar) {
        Iterator it = this.zzd.values().iterator();
        while (it.hasNext()) {
            ((zzfll) it.next()).zzc();
        }
        Timer timer = new Timer();
        timer.schedule(new zzflu(this, zzcfxVar, timer), 1000L);
    }
}
