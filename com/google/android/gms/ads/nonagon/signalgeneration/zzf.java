package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Base64;
import android.webkit.WebView;
import androidx.webkit.WebViewCompat;
import androidx.webkit.internal.WebViewFeatureInternal;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbfj;
import com.google.android.gms.internal.ads.zzfyv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.io.TextStreamsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzf {
    public final Context zza;
    public final ApplicationInfo zzb;
    public final List zzc;
    public final VersionInfoParcel zzd;
    public final JSONObject zze = new JSONObject();
    public final AtomicBoolean zzf = new AtomicBoolean(false);

    public zzf(Context context, List list, VersionInfoParcel versionInfoParcel) {
        this.zza = context;
        this.zzb = context.getApplicationInfo();
        this.zzc = list;
        this.zzd = versionInfoParcel;
    }

    public final JSONObject zza() {
        if (!this.zzf.get()) {
            zzb(null);
        }
        return this.zze;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void zzb(WebView webView) {
        ApplicationInfo applicationInfo = this.zzb;
        if (this.zzf.getAndSet(true)) {
            return;
        }
        PackageInfo packageInfo = null;
        if (applicationInfo != null) {
            try {
                packageInfo = Wrappers.packageManager(this.zza).getPackageInfo(0, applicationInfo.packageName);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        JSONObject jSONObject = this.zze;
        if (packageInfo != null) {
            try {
                jSONObject.put("vc", packageInfo.versionCode);
                jSONObject.put("vnm", packageInfo.versionName);
            } catch (JSONException e) {
                com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "PawAppSignalGenerator.initialize");
            }
        }
        if (applicationInfo != null) {
            jSONObject.put("pn", applicationInfo.packageName);
        }
        List list = this.zzc;
        ArrayList arrayList = new ArrayList();
        for (String str : ((String) zzbd.zza.zzd.zzb(zzbde.zzkk)).split(",", -1)) {
            if (list.contains(str)) {
                arrayList.add(str);
            }
        }
        jSONObject.put("eid", (Object) arrayList);
        jSONObject.put("js", this.zzd.afmaVersion);
        Iterator itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String str2 = (String) itKeys.next();
            Object obj = jSONObject.get(str2);
            if (obj != null) {
                jSONObject.put(str2, Base64.encodeToString(obj.toString().getBytes(), 2));
            }
        }
        if (((Boolean) zzbfj.zzb.zze()).booleanValue() && TextStreamsKt.isFeatureSupported("DOCUMENT_START_SCRIPT") && webView != null) {
            String str3 = String.format(Locale.getDefault(), (String) zzbd.zza.zzd.zzb(zzbde.zzkj), zza());
            zzfyv zzfyvVarZzo = zzfyv.zzo("*");
            int i = WebViewCompat.$r8$clinit;
            if (!WebViewFeatureInternal.DOCUMENT_START_SCRIPT.isSupportedByWebView()) {
                throw WebViewFeatureInternal.getUnsupportedOperationException();
            }
        }
    }
}
