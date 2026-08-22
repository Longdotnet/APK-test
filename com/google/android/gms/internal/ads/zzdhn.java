package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.hSi.sgtsHsWT;
import com.google.android.gms.ads.internal.gMU.QTaELkFI;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Hex;
import com.google.firebase.inject.PVS.jIKWv;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import okio.Okio;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdhn implements zzdjb {
    private com.google.android.gms.ads.internal.client.zzdf zzC;
    private final zzcyi zzD;
    private final zzdjv zzE;
    private final com.google.android.gms.ads.internal.zzb zzF;
    private final Context zza;
    private final zzdje zzb;
    private final JSONObject zzc;
    private final zzdny zzd;
    private final zzdit zze;
    private final zzavu zzf;
    private final zzcwq zzg;
    private final zzcvw zzh;
    private final zzdeb zzi;
    private final zzfca zzj;
    private final VersionInfoParcel zzk;
    private final zzfcw zzl;
    private final zzcnn zzm;
    private final zzdjz zzn;
    private final Clock zzo;
    private final zzddx zzp;
    private final zzfjy zzq;
    private final zzdpo zzr;
    private final zzfhu zzs;
    private final zzecl zzt;
    private boolean zzv;
    private boolean zzu = false;
    private boolean zzw = false;
    private boolean zzx = false;
    private Point zzy = new Point();
    private Point zzz = new Point();
    private long zzA = 0;
    private long zzB = 0;

    public zzdhn(Context context, zzdje zzdjeVar, JSONObject jSONObject, zzdny zzdnyVar, zzdit zzditVar, zzavu zzavuVar, zzcwq zzcwqVar, zzcvw zzcvwVar, zzdeb zzdebVar, zzfca zzfcaVar, VersionInfoParcel versionInfoParcel, zzfcw zzfcwVar, zzcnn zzcnnVar, zzdjz zzdjzVar, Clock clock, zzddx zzddxVar, zzfjy zzfjyVar, zzfhu zzfhuVar, zzecl zzeclVar, zzdpo zzdpoVar, zzdjv zzdjvVar, zzcyi zzcyiVar, com.google.android.gms.ads.internal.zzb zzbVar, zzbya zzbyaVar) {
        this.zza = context;
        this.zzb = zzdjeVar;
        this.zzc = jSONObject;
        this.zzd = zzdnyVar;
        this.zze = zzditVar;
        this.zzf = zzavuVar;
        this.zzg = zzcwqVar;
        this.zzh = zzcvwVar;
        this.zzi = zzdebVar;
        this.zzj = zzfcaVar;
        this.zzk = versionInfoParcel;
        this.zzl = zzfcwVar;
        this.zzm = zzcnnVar;
        this.zzn = zzdjzVar;
        this.zzo = clock;
        this.zzp = zzddxVar;
        this.zzq = zzfjyVar;
        this.zzs = zzfhuVar;
        this.zzt = zzeclVar;
        this.zzr = zzdpoVar;
        this.zzE = zzdjvVar;
        this.zzD = zzcyiVar;
        this.zzF = zzbVar;
    }

    private final String zzG(View view) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzdO)).booleanValue()) {
            return null;
        }
        try {
            return this.zzf.zzc().zzh(this.zza, view, null);
        } catch (Exception unused) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Exception getting data.");
            return null;
        }
    }

    private final String zzH(View view, Map map) {
        if (map != null && view != null) {
            for (Map.Entry entry : map.entrySet()) {
                if (view.equals((View) ((WeakReference) entry.getValue()).get())) {
                    return (String) entry.getKey();
                }
            }
        }
        int iZzc = this.zze.zzc();
        if (iZzc == 1) {
            return "1099";
        }
        if (iZzc == 2) {
            return "2099";
        }
        if (iZzc != 6) {
            return null;
        }
        return "3099";
    }

    private final void zzI() {
        com.google.android.gms.ads.internal.zzb zzbVar;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zznP)).booleanValue() || (zzbVar = this.zzF) == null) {
            return;
        }
        zzbVar.zzb = true;
    }

    private final boolean zzJ(String str) {
        JSONObject jSONObjectOptJSONObject = this.zzc.optJSONObject("allow_pub_event_reporting");
        return jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optBoolean(str, false);
    }

    private final boolean zzK() {
        return this.zzc.optBoolean("allow_custom_click_gesture", false);
    }

    private final boolean zzL(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, String str, JSONObject jSONObject5, boolean z, View view) {
        try {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("ad", this.zzc);
            jSONObject6.put("asset_view_signal", jSONObject2);
            jSONObject6.put("ad_view_signal", jSONObject);
            jSONObject6.put("scroll_view_signal", jSONObject3);
            jSONObject6.put("lock_screen_signal", jSONObject4);
            jSONObject6.put("provided_signals", jSONObject5);
            zzbcv zzbcvVar = zzbde.zzdO;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
            if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
                jSONObject6.put("view_signals", str);
            }
            jSONObject6.put("policy_validator_enabled", z);
            jSONObject6.put("screen", Okio.zzf(this.zza));
            boolean zBooleanValue = ((Boolean) zzbdVar.zzd.zzb(zzbde.zziY)).booleanValue();
            zzdhm zzdhmVar = null;
            if (zBooleanValue) {
                this.zzd.zzl("/clickRecorded", new zzdhj(this, zzdhmVar));
            } else {
                this.zzd.zzl("/logScionEvent", new zzdhi(this, zzdhmVar));
            }
            zzdny zzdnyVar = this.zzd;
            zzdnyVar.zzl("/nativeImpression", new zzdhk(this, view, null));
            zzdnyVar.zzl("/nativeImpressionFlowControl", new zzdhl(this, this.zzq, this.zzj.zzax, this.zzs, null));
            zzcai.zza(zzdnyVar.zzg("google.afma.nativeAds.handleImpression", jSONObject6), "Error during performing handleImpression");
            if (this.zzu) {
                return true;
            }
            zzfca zzfcaVar = this.zzj;
            this.zzu = com.google.android.gms.ads.internal.zzv.zza.zzp.zzn(this.zza, this.zzk.afmaVersion, zzfcaVar.zzC.toString(), this.zzl.zzf);
            return true;
        } catch (JSONException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to create impression JSON.", e);
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzA(zzbig zzbigVar) {
        if (this.zzc.optBoolean("custom_one_point_five_click_enabled", false)) {
            this.zzn.zzc(zzbigVar);
        } else {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("setUnconfirmedClickListener: Your account need to be in the allow list to use this feature.\nContact your account manager for more information.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzB(View view, Map map, Map map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        this.zzy = new Point();
        this.zzz = new Point();
        if (!this.zzv) {
            this.zzp.zza(view);
            this.zzv = true;
        }
        view.setOnTouchListener(onTouchListener);
        view.setClickable(true);
        view.setOnClickListener(onClickListener);
        this.zzm.zzi(this);
        boolean zZzj = Okio.zzj(this.zzk.clientJarVersion);
        if (map != null) {
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                View view2 = (View) ((WeakReference) ((Map.Entry) it.next()).getValue()).get();
                if (view2 != null) {
                    if (zZzj) {
                        view2.setOnTouchListener(onTouchListener);
                    }
                    view2.setClickable(true);
                    view2.setOnClickListener(onClickListener);
                }
            }
        }
        if (map2 != null) {
            Iterator it2 = map2.entrySet().iterator();
            while (it2.hasNext()) {
                View view3 = (View) ((WeakReference) ((Map.Entry) it2.next()).getValue()).get();
                if (view3 != null) {
                    if (zZzj) {
                        view3.setOnTouchListener(onTouchListener);
                    }
                    view3.setClickable(false);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzC(View view, Map map) {
        this.zzy = new Point();
        this.zzz = new Point();
        if (view != null) {
            this.zzp.zzb(view);
        }
        this.zzv = false;
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final boolean zzD() {
        if (zza() == 0) {
            return true;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzlW)).booleanValue()) {
            return this.zzl.zzi.zzj;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final boolean zzE() {
        return zzK();
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final int zza() {
        zzbge zzbgeVar = this.zzl.zzi;
        if (zzbgeVar == null) {
            return 0;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzlW)).booleanValue()) {
            return zzbgeVar.zzi;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final JSONObject zzf(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        Context context = this.zza;
        JSONObject jSONObjectZzd = Okio.zzd(context, map, map2, view, scaleType);
        JSONObject jSONObjectZzh = Okio.zzh(context, view);
        JSONObject jSONObjectZzg = Okio.zzg(view);
        JSONObject jSONObjectZze = Okio.zze(context, view);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("asset_view_signal", jSONObjectZzd);
            jSONObject.put("ad_view_signal", jSONObjectZzh);
            jSONObject.put("scroll_view_signal", jSONObjectZzg);
            jSONObject.put("lock_screen_signal", jSONObjectZze);
            return jSONObject;
        } catch (JSONException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to create native ad view signals JSON.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final JSONObject zzg(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        JSONObject jSONObjectZzf = zzf(view, map, map2, scaleType);
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.zzx && zzK()) {
                jSONObject.put("custom_click_gesture_eligible", true);
            }
            if (jSONObjectZzf != null) {
                jSONObject.put("nas", jSONObjectZzf);
            }
        } catch (JSONException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to create native click meta data JSON.", e);
        }
        return jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzi() {
        try {
            com.google.android.gms.ads.internal.client.zzdf zzdfVar = this.zzC;
            if (zzdfVar != null) {
                zzdfVar.zze();
            }
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzj() {
        if (this.zzc.optBoolean("custom_one_point_five_click_enabled", false)) {
            this.zzn.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzk() {
        this.zzd.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzl(com.google.android.gms.ads.internal.client.zzdj zzdjVar) {
        try {
            if (this.zzw) {
                return;
            }
            if (zzdjVar == null) {
                zzdit zzditVar = this.zze;
                if (zzditVar.zzk() != null) {
                    this.zzw = true;
                    this.zzq.zzd(zzditVar.zzk().zzb, this.zzj.zzax, this.zzs, null);
                    zzi();
                    return;
                }
            }
            this.zzw = true;
            this.zzq.zzd(zzdjVar.zzf(), this.zzj.zzax, this.zzs, null);
            zzi();
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzm(View view, View view2, Map map, Map map2, boolean z, ImageView.ScaleType scaleType) {
        Context context = this.zza;
        JSONObject jSONObjectZzd = Okio.zzd(context, map, map2, view2, scaleType);
        JSONObject jSONObjectZzh = Okio.zzh(context, view2);
        JSONObject jSONObjectZzg = Okio.zzg(view2);
        JSONObject jSONObjectZze = Okio.zze(context, view2);
        String strZzH = zzH(view, map);
        zzp(true == ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzdV)).booleanValue() ? view2 : view, jSONObjectZzh, jSONObjectZzd, jSONObjectZzg, jSONObjectZze, strZzH, Okio.zzc(strZzH, context, this.zzz, this.zzy), null, z, false);
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzn(String str) {
        zzp(null, null, null, null, null, str, null, null, false, false);
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzo(Bundle bundle) {
        if (bundle == null) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Click data is null. No click is reported.");
            return;
        }
        if (!zzJ("click_reporting")) {
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("The ad slot cannot handle external click events. You must be part of the allow list to be able to report your click events.");
            return;
        }
        Bundle bundle2 = bundle.getBundle("click_signal");
        JSONObject jSONObjectZzn = null;
        String string = bundle2 != null ? bundle2.getString("asset_id") : null;
        com.google.android.gms.ads.internal.util.client.zzf zzfVar = com.google.android.gms.ads.internal.client.zzbb.zzb.zzc;
        zzfVar.getClass();
        try {
            jSONObjectZzn = zzfVar.zzn(bundle);
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error converting Bundle to JSON", e);
        }
        zzp(null, null, null, null, null, string, null, jSONObjectZzn, false, false);
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
    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzq(View view, View view2, Map map, Map map2, boolean z, ImageView.ScaleType scaleType, int i) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = this.zzc;
        boolean z2 = false;
        if (jSONObject2.optBoolean("allow_sdk_custom_click_gesture", false)) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzlW)).booleanValue()) {
                z2 = true;
            }
        }
        if (!z2) {
            if (!this.zzx) {
                int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zze("Custom click reporting failed. enableCustomClickGesture is not set.");
                return;
            } else if (!zzK()) {
                int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zze("Custom click reporting failed. Ad unit id not in the allow list.");
                return;
            }
        }
        Context context = this.zza;
        JSONObject jSONObjectZzd = Okio.zzd(context, map, map2, view2, scaleType);
        JSONObject jSONObjectZzh = Okio.zzh(context, view2);
        JSONObject jSONObjectZzg = Okio.zzg(view2);
        JSONObject jSONObjectZze = Okio.zze(context, view2);
        String strZzH = zzH(view, map);
        JSONObject jSONObjectZzc = Okio.zzc(strZzH, context, this.zzz, this.zzy);
        if (z2) {
            try {
                Point point = this.zzz;
                Point point2 = this.zzy;
                try {
                    jSONObject = new JSONObject();
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        JSONObject jSONObject4 = new JSONObject();
                        if (point != null) {
                            jSONObject3.put("x", point.x);
                            jSONObject3.put("y", point.y);
                        }
                        if (point2 != null) {
                            jSONObject4.put("x", point2.x);
                            jSONObject4.put("y", point2.y);
                        }
                        jSONObject.put("start_point", jSONObject3);
                        jSONObject.put("end_point", jSONObject4);
                        jSONObject.put("duration_ms", i);
                    } catch (Exception e) {
                        e = e;
                        int i4 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzh("Error occurred while grabbing custom click gesture signals.", e);
                    }
                } catch (Exception e2) {
                    e = e2;
                    jSONObject = null;
                }
                jSONObject2.put("custom_click_gesture_signal", jSONObject);
            } catch (JSONException e3) {
                int i5 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Error occurred while adding CustomClickGestureSignals to adJson.", e3);
                com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e3, "FirstPartyNativeAdCore.performCustomClickGesture");
            }
        }
        zzp(view2, jSONObjectZzh, jSONObjectZzd, jSONObjectZzg, jSONObjectZze, strZzH, jSONObjectZzc, null, z, true);
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzr(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        Context context = this.zza;
        JSONObject jSONObjectZzd = Okio.zzd(context, map, map2, view, scaleType);
        JSONObject jSONObjectZzh = Okio.zzh(context, view);
        JSONObject jSONObjectZzg = Okio.zzg(view);
        JSONObject jSONObjectZze = Okio.zze(context, view);
        boolean zZzi = Okio.zzi(context, this.zzj);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad", this.zzc);
            jSONObject.put("asset_view_signal", jSONObjectZzd);
            jSONObject.put("ad_view_signal", jSONObjectZzh);
            jSONObject.put("scroll_view_signal", jSONObjectZzg);
            jSONObject.put("lock_screen_signal", jSONObjectZze);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzdO)).booleanValue()) {
                jSONObject.put("view_signals", zzG(view));
            }
            jSONObject.put("policy_validator_enabled", zZzi);
            jSONObject.put("screen", Okio.zzf(context));
            zzcai.zza(this.zzd.zzg("google.afma.nativeAds.handleNativeAdSignalsLogging", jSONObject), "Error during performing handleNativeAdSignalsLogging");
        } catch (JSONException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to create native ad signals logging JSON.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzs() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad", this.zzc);
            zzcai.zza(this.zzd.zzg("google.afma.nativeAds.handleDownloadedImpression", jSONObject), "Error during performing handleDownloadedImpression");
        } catch (JSONException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzt(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        Context context = this.zza;
        zzL(Okio.zzh(context, view), Okio.zzd(context, map, map2, view, scaleType), Okio.zzg(view), Okio.zze(context, view), zzG(view), null, Okio.zzi(context, this.zzj), view);
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzu() {
        zzL(null, null, null, null, null, null, false, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzv(View view, MotionEvent motionEvent, View view2) {
        int[] iArr = new int[2];
        if (view2 != null) {
            view2.getLocationOnScreen(iArr);
        }
        this.zzy = new Point(((int) motionEvent.getRawX()) - iArr[0], ((int) motionEvent.getRawY()) - iArr[1]);
        ((DefaultClock) this.zzo).getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.zzB = jCurrentTimeMillis;
        if (motionEvent.getAction() == 0) {
            this.zzr.zzb(motionEvent);
            this.zzA = jCurrentTimeMillis;
            this.zzz = this.zzy;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        Point point = this.zzy;
        motionEventObtain.setLocation(point.x, point.y);
        this.zzf.zzd(motionEventObtain);
        motionEventObtain.recycle();
        zzI();
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzw(Bundle bundle) {
        if (bundle == null) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Touch event data is null. No touch event is reported.");
        } else {
            if (!zzJ("touch_reporting")) {
                int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("The ad slot cannot handle external touch events. You must be in the allow list to be able to report your touch events.");
                return;
            }
            this.zzf.zzc().zzl((int) bundle.getFloat("x"), (int) bundle.getFloat("y"), bundle.getInt("duration_ms"));
            zzI();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzx(View view) {
        if (!this.zzc.optBoolean("custom_one_point_five_click_enabled", false)) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("setClickConfirmingView: Your account need to be in the allow list to use this feature.\nContact your account manager for more information.");
            return;
        }
        zzdjz zzdjzVar = this.zzn;
        if (view == null) {
            return;
        }
        view.setOnClickListener(zzdjzVar);
        view.setClickable(true);
        zzdjzVar.zzc = new WeakReference(view);
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzy() {
        this.zzx = true;
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzz(com.google.android.gms.ads.internal.client.zzdf zzdfVar) {
        this.zzC = zzdfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final boolean zzF(Bundle bundle) {
        JSONObject jSONObject;
        JSONObject jSONObjectZzn;
        if (!zzJ(jIKWv.WEPnOGYDad)) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("The ad slot cannot handle external impression events. You must be in the allow list to be able to report your impression events.");
            return false;
        }
        com.google.android.gms.ads.internal.util.client.zzf zzfVar = com.google.android.gms.ads.internal.client.zzbb.zzb.zzc;
        zzfVar.getClass();
        if (bundle != null) {
            try {
                jSONObjectZzn = zzfVar.zzn(bundle);
            } catch (JSONException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Error converting Bundle to JSON", e);
                jSONObject = null;
            }
        } else {
            jSONObjectZzn = null;
        }
        jSONObject = jSONObjectZzn;
        return zzL(null, null, null, null, ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzlS)).booleanValue() ? zzG(null) : null, jSONObject, false, null);
    }

    public final void zzp(View view, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, String str, JSONObject jSONObject5, JSONObject jSONObject6, boolean z, boolean z2) {
        String strZzd;
        try {
            zzI();
            JSONObject jSONObject7 = new JSONObject();
            JSONObject jSONObject8 = this.zzc;
            jSONObject7.put("ad", jSONObject8);
            jSONObject7.put("asset_view_signal", jSONObject2);
            jSONObject7.put("ad_view_signal", jSONObject);
            jSONObject7.put("click_signal", jSONObject5);
            jSONObject7.put("scroll_view_signal", jSONObject3);
            jSONObject7.put("lock_screen_signal", jSONObject4);
            zzdje zzdjeVar = this.zzb;
            zzdit zzditVar = this.zze;
            jSONObject7.put("has_custom_click_handler", zzdjeVar.zzc(zzditVar.zzA()) != null);
            jSONObject7.put("provided_signals", jSONObject6);
            JSONObject jSONObject9 = new JSONObject();
            jSONObject9.put("asset_id", str);
            jSONObject9.put("template", zzditVar.zzc());
            jSONObject9.put("view_aware_api_used", z);
            zzbge zzbgeVar = this.zzl.zzi;
            jSONObject9.put("custom_mute_requested", zzbgeVar != null && zzbgeVar.zzg);
            jSONObject9.put("custom_mute_enabled", (zzditVar.zzH().isEmpty() || zzditVar.zzk() == null) ? false : true);
            if (this.zzn.zza() != null && jSONObject8.optBoolean("custom_one_point_five_click_enabled", false)) {
                jSONObject9.put(sgtsHsWT.bpeKckOfRsayFqr, true);
            }
            ((DefaultClock) this.zzo).getClass();
            jSONObject9.put("timestamp", System.currentTimeMillis());
            if (this.zzx && zzK()) {
                jSONObject9.put("custom_click_gesture_eligible", true);
            }
            if (z2) {
                jSONObject9.put("is_custom_click_gesture", true);
            }
            jSONObject9.put("has_custom_click_handler", zzdjeVar.zzc(zzditVar.zzA()) != null);
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject8.optJSONObject("tracking_urls_and_actions");
                if (jSONObjectOptJSONObject == null) {
                    jSONObjectOptJSONObject = new JSONObject();
                }
                strZzd = this.zzf.zzc().zzd(this.zza, jSONObjectOptJSONObject.optString("click_string"), view);
            } catch (Exception e) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Exception obtaining click signals", e);
                strZzd = null;
            }
            jSONObject9.put("click_signals", strZzd);
            jSONObject9.put("open_chrome_custom_tab", true);
            zzbcv zzbcvVar = zzbde.zzjc;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
            if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() && Hex.isAtLeastR()) {
                jSONObject9.put("try_fallback_for_deep_link", true);
            }
            if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzjd)).booleanValue() && Hex.isAtLeastR()) {
                jSONObject9.put("in_app_link_handling_for_android_11_enabled", true);
            }
            jSONObject7.put("click", jSONObject9);
            JSONObject jSONObject10 = new JSONObject();
            ((DefaultClock) this.zzo).getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            jSONObject10.put("time_from_last_touch_down", jCurrentTimeMillis - this.zzA);
            jSONObject10.put("time_from_last_touch", jCurrentTimeMillis - this.zzB);
            jSONObject7.put("touch_signal", jSONObject10);
            if (this.zzj.zzb()) {
                JSONObject jSONObject11 = (JSONObject) this.zzc.get("tracking_urls_and_actions");
                String string = jSONObject11 != null ? jSONObject11.getString(QTaELkFI.tyvWXvSPU) : null;
                if (string != null) {
                    this.zzt.zzq(string, this.zze);
                }
            }
            zzcai.zza(this.zzd.zzg("google.afma.nativeAds.handleClick", jSONObject7), "Error during performing handleClick");
        } catch (JSONException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to create click JSON.", e2);
        }
    }
}
