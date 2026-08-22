package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.daerisoft.thespikerm.R;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.Predicate;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzcfy extends FrameLayout implements zzcfg {
    private final zzcfg zza;
    private final zzcbq zzb;
    private final AtomicBoolean zzc;

    /* JADX WARN: Multi-variable type inference failed */
    public zzcfy(zzcfg zzcfgVar, zzdsj zzdsjVar) {
        super(zzcfgVar.getContext());
        this.zzc = new AtomicBoolean();
        this.zza = zzcfgVar;
        this.zzb = new zzcbq(zzcfgVar.zzE(), this, this, zzdsjVar);
        addView((View) zzcfgVar);
    }

    public static /* synthetic */ void zzaI(zzcfy zzcfyVar, boolean z) {
        zzcfg zzcfgVar = zzcfyVar.zza;
        com.google.android.gms.ads.internal.util.zzf zzfVar = com.google.android.gms.ads.internal.util.zzs.zza;
        Objects.requireNonNull(zzcfgVar);
        zzfVar.post(new zzcfu(zzcfgVar));
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final boolean canGoBack() {
        return this.zza.canGoBack();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void destroy() {
        final zzedf zzedfVarZzP;
        final zzedh zzedhVarZzQ = zzQ();
        if (zzedhVarZzQ != null) {
            com.google.android.gms.ads.internal.util.zzf zzfVar = com.google.android.gms.ads.internal.util.zzs.zza;
            zzfVar.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfv
                @Override // java.lang.Runnable
                public final void run() {
                    com.google.android.gms.ads.internal.zzv.zza.zzz.zzi(zzedhVarZzQ.zza());
                }
            });
            zzcfg zzcfgVar = this.zza;
            Objects.requireNonNull(zzcfgVar);
            zzfVar.postDelayed(new zzcfu(zzcfgVar), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzfA)).intValue());
            return;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzfC)).booleanValue() || (zzedfVarZzP = zzP()) == null) {
            this.zza.destroy();
        } else {
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfw
                @Override // java.lang.Runnable
                public final void run() {
                    zzedfVarZzP.zzf(new zzcfx(this.zza));
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void goBack() {
        this.zza.goBack();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void loadData(String str, String str2, String str3) {
        this.zza.loadData(str, "text/html", str3);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.zza.loadDataWithBaseURL(str, str2, "text/html", "UTF-8", null);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void loadUrl(String str) {
        this.zza.loadUrl(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        zzcfg zzcfgVar = this.zza;
        if (zzcfgVar != null) {
            zzcfgVar.onAdClicked();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void onPause() {
        this.zzb.zzf();
        this.zza.onPause();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void onResume() {
        this.zza.onResume();
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzcfg
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zza.setOnClickListener(onClickListener);
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzcfg
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.zza.setOnTouchListener(onTouchListener);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.zza.setWebChromeClient(webChromeClient);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void setWebViewClient(WebViewClient webViewClient) {
        this.zza.setWebViewClient(webViewClient);
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final void zzA(int i) {
        this.zza.zzA(i);
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final void zzB(int i) {
        this.zzb.zzg(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.internal.ads.zzccb
    public final void zzC(zzcgi zzcgiVar) {
        this.zza.zzC(zzcgiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.internal.ads.zzcex
    public final zzfca zzD() {
        return this.zza.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final Context zzE() {
        return this.zza.zzE();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.internal.ads.zzcgv
    public final View zzF() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final WebView zzG() {
        return (WebView) this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final WebViewClient zzH() {
        return this.zza.zzH();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.internal.ads.zzcgt
    public final zzavu zzI() {
        return this.zza.zzI();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final zzbaq zzJ() {
        return this.zza.zzJ();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final zzbgd zzK() {
        return this.zza.zzK();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final com.google.android.gms.ads.internal.overlay.zzm zzL() {
        return this.zza.zzL();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final com.google.android.gms.ads.internal.overlay.zzm zzM() {
        return this.zza.zzM();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final zzcgy zzN() {
        return ((zzcgf) this.zza).zzaO();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.internal.ads.zzcgs
    public final zzchd zzO() {
        return this.zza.zzO();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final zzedf zzP() {
        return this.zza.zzP();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final zzedh zzQ() {
        return this.zza.zzQ();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.internal.ads.zzcgj
    public final zzfcd zzR() {
        return this.zza.zzR();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final zzfda zzS() {
        return this.zza.zzS();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final ListenableFuture zzT() {
        return this.zza.zzT();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final String zzU() {
        return this.zza.zzU();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final List zzV() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt != this.zza) {
                arrayList.add(childAt);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzW(zzfca zzfcaVar, zzfcd zzfcdVar) {
        this.zza.zzW(zzfcaVar, zzfcdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzX() {
        this.zzb.zze();
        this.zza.zzX();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzY() {
        this.zza.zzY();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzZ(int i) {
        this.zza.zzZ(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbnm
    public final void zza(String str) {
        ((zzcgf) this.zza).zzaW(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzaA(String str, Predicate predicate) {
        this.zza.zzaA(str, predicate);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final boolean zzaB() {
        return this.zza.zzaB();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final boolean zzaC() {
        return this.zza.zzaC();
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    @Override // com.google.android.gms.internal.ads.zzcfg
    public final boolean zzaD(boolean z, int i) {
        if (!this.zzc.compareAndSet(false, true)) {
            return true;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzba)).booleanValue()) {
            return false;
        }
        zzcfg zzcfgVar = this.zza;
        if (zzcfgVar.getParent() instanceof ViewGroup) {
            ((ViewGroup) zzcfgVar.getParent()).removeView((View) zzcfgVar);
        }
        zzcfgVar.zzaD(z, i);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final boolean zzaE() {
        return this.zza.zzaE();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final boolean zzaF() {
        return this.zza.zzaF();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final boolean zzaG() {
        return this.zzc.get();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final boolean zzaH() {
        return this.zza.zzaH();
    }

    @Override // com.google.android.gms.internal.ads.zzcgq
    public final void zzaJ(com.google.android.gms.ads.internal.overlay.zzc zzcVar, boolean z, boolean z2, String str) {
        this.zza.zzaJ(zzcVar, z, z2, str);
    }

    @Override // com.google.android.gms.internal.ads.zzcgq
    public final void zzaK(String str, String str2, int i) {
        this.zza.zzaK(str, str2, 14);
    }

    @Override // com.google.android.gms.internal.ads.zzcgq
    public final void zzaL(boolean z, int i, boolean z2) {
        this.zza.zzaL(z, i, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzcgq
    public final void zzaM(boolean z, int i, String str, String str2, boolean z2) {
        this.zza.zzaM(z, i, str, str2, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzcgq
    public final void zzaN(boolean z, int i, String str, boolean z2, boolean z3) {
        this.zza.zzaN(z, i, str, z2, z3);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzaa() {
        this.zza.zzaa();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzab() {
        this.zza.zzab();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzac(boolean z) {
        this.zza.zzac(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzad() {
        this.zza.zzad();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzae(String str, String str2, String str3) {
        this.zza.zzae(str, str2, null);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzaf() {
        this.zza.zzaf();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzag(String str, zzbkf zzbkfVar) {
        this.zza.zzag(str, zzbkfVar);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzah() {
        zzedh zzedhVarZzQ;
        zzedf zzedfVarZzP;
        TextView textView = new TextView(getContext());
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        com.google.android.gms.ads.internal.util.zzs zzsVar = zzvVar.zzd;
        Resources resourcesZze = zzvVar.zzi.zze();
        textView.setText(resourcesZze != null ? resourcesZze.getString(R.string.s7) : "Test Ad");
        textView.setTextSize(15.0f);
        textView.setTextColor(-1);
        textView.setPadding(5, 0, 5, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-12303292);
        gradientDrawable.setCornerRadius(8.0f);
        textView.setBackground(gradientDrawable);
        addView(textView, new FrameLayout.LayoutParams(-2, -2, 49));
        bringChildToFront(textView);
        zzbcv zzbcvVar = zzbde.zzfC;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() && (zzedfVarZzP = zzP()) != null) {
            zzedfVarZzP.zza(textView);
        } else if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzfB)).booleanValue() && (zzedhVarZzQ = zzQ()) != null && zzedhVarZzQ.zzb()) {
            zzvVar.zzz.zzg(zzedhVarZzQ.zza(), textView);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzai(com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        this.zza.zzai(zzmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzaj(zzchd zzchdVar) {
        this.zza.zzaj(zzchdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzak(zzbaq zzbaqVar) {
        this.zza.zzak(zzbaqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzal(boolean z) {
        this.zza.zzal(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzam() {
        setBackgroundColor(0);
        this.zza.setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzan(Context context) {
        this.zza.zzan(context);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzao(boolean z) {
        this.zza.zzao(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzap(zzbgb zzbgbVar) {
        this.zza.zzap(zzbgbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzaq(boolean z) {
        this.zza.zzaq(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzar(zzbgd zzbgdVar) {
        this.zza.zzar(zzbgdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzas(zzedf zzedfVar) {
        this.zza.zzas(zzedfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzat(zzedh zzedhVar) {
        this.zza.zzat(zzedhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzau(int i) {
        this.zza.zzau(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzav(boolean z) {
        this.zza.zzav(true);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzaw(com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        this.zza.zzaw(zzmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzax(boolean z) {
        this.zza.zzax(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzay(boolean z) {
        this.zza.zzay(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzaz(String str, zzbkf zzbkfVar) {
        this.zza.zzaz(str, zzbkfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbnm
    public final void zzb(String str, String str2) {
        this.zza.zzb("window.inspectorInfo", str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbna
    public final void zzd(String str, Map map) {
        this.zza.zzd(str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzded
    public final void zzdH() {
        zzcfg zzcfgVar = this.zza;
        if (zzcfgVar != null) {
            zzcfgVar.zzdH();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzded
    public final void zzdf() {
        zzcfg zzcfgVar = this.zza;
        if (zzcfgVar != null) {
            zzcfgVar.zzdf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.ads.internal.zzn
    public final void zzdg() {
        this.zza.zzdg();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.ads.internal.zzn
    public final void zzdh() {
        this.zza.zzdh();
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final void zzdi() {
        this.zza.zzdi();
    }

    @Override // com.google.android.gms.internal.ads.zzazd
    public final void zzdr(zzazc zzazcVar) {
        this.zza.zzdr(zzazcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbna
    public final void zze(String str, JSONObject jSONObject) {
        this.zza.zze(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final int zzf() {
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final int zzg() {
        return ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzeg)).booleanValue() ? this.zza.getMeasuredHeight() : getMeasuredHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final int zzh() {
        return ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzeg)).booleanValue() ? this.zza.getMeasuredWidth() : getMeasuredWidth();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.internal.ads.zzcgn, com.google.android.gms.internal.ads.zzccb
    public final Activity zzi() {
        return this.zza.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.internal.ads.zzccb
    public final com.google.android.gms.ads.internal.zza zzj() {
        return this.zza.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final zzbdq zzk() {
        return this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.internal.ads.zzccb
    public final zzbdr zzl() {
        return this.zza.zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.internal.ads.zzcgu, com.google.android.gms.internal.ads.zzccb
    public final VersionInfoParcel zzm() {
        return this.zza.zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final zzcbq zzn() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final zzcdn zzo(String str) {
        return this.zza.zzo(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbnm
    public final void zzp(String str, JSONObject jSONObject) {
        ((zzcgf) this.zza).zzb(str, jSONObject.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.internal.ads.zzccb
    public final zzcgi zzq() {
        return this.zza.zzq();
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final String zzr() {
        return this.zza.zzr();
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final String zzs() {
        return this.zza.zzs();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.internal.ads.zzccb
    public final void zzt(String str, zzcdn zzcdnVar) {
        this.zza.zzt(str, zzcdnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final void zzv(boolean z, long j) {
        this.zza.zzv(z, j);
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final void zzw() {
        this.zza.zzw();
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final void zzx(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final void zzy(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final void zzz(boolean z) {
        this.zza.zzz(false);
    }
}
