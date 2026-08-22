package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzdjn extends zzbgy implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzdkr {
    private final WeakReference zza;
    private final Map zzb = new HashMap();
    private final Map zzc = new HashMap();
    private final Map zzd = new HashMap();
    private zzdio zze;
    private zzaze zzf;

    public zzdjn(View view, HashMap map, HashMap map2) {
        view.setOnTouchListener(this);
        view.setOnClickListener(this);
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        zzcas zzcasVar = zzvVar.zzE;
        zzcas.zza(view, this);
        zzcas zzcasVar2 = zzvVar.zzE;
        zzcas.zzb(view, this);
        this.zza = new WeakReference(view);
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            View view2 = (View) entry.getValue();
            if (view2 != null) {
                this.zzb.put(str, new WeakReference(view2));
                if (!"1098".equals(str) && !"3011".equals(str)) {
                    view2.setOnTouchListener(this);
                    view2.setClickable(true);
                    view2.setOnClickListener(this);
                }
            }
        }
        this.zzd.putAll(this.zzb);
        for (Map.Entry entry2 : map2.entrySet()) {
            View view3 = (View) entry2.getValue();
            if (view3 != null) {
                this.zzc.put((String) entry2.getKey(), new WeakReference(view3));
                view3.setOnTouchListener(this);
                view3.setClickable(false);
            }
        }
        this.zzd.putAll(this.zzc);
        this.zzf = new zzaze(view.getContext(), view);
    }

    @Override // android.view.View.OnClickListener
    public final synchronized void onClick(View view) {
        zzdio zzdioVar = this.zze;
        if (zzdioVar != null) {
            zzdioVar.zzE(view, zzf(), zzl(), zzm(), true);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final synchronized void onGlobalLayout() {
        zzdio zzdioVar = this.zze;
        if (zzdioVar != null) {
            zzdioVar.zzC(zzf(), zzl(), zzm(), zzdio.zzZ(zzf()));
        }
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final synchronized void onScrollChanged() {
        zzdio zzdioVar = this.zze;
        if (zzdioVar != null) {
            zzdioVar.zzC(zzf(), zzl(), zzm(), zzdio.zzZ(zzf()));
        }
    }

    @Override // android.view.View.OnTouchListener
    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        zzdio zzdioVar = this.zze;
        if (zzdioVar != null) {
            zzdioVar.zzM(view, motionEvent, zzf());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized void zzb(IObjectWrapper iObjectWrapper) {
        try {
            if (this.zze != null) {
                Object objUnwrap = ObjectWrapper.unwrap(iObjectWrapper);
                if (!(objUnwrap instanceof View)) {
                    int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Calling NativeAdViewHolderNonagonDelegate.setClickConfirmingView with wrong wrapped object");
                }
                this.zze.zzO((View) objUnwrap);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized void zzc(IObjectWrapper iObjectWrapper) {
        Object objUnwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(objUnwrap instanceof zzdio)) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Not an instance of InternalNativeAd. This is most likely a transient error");
            return;
        }
        zzdio zzdioVar = this.zze;
        if (zzdioVar != null) {
            zzdioVar.zzU(this);
        }
        zzdio zzdioVar2 = (zzdio) objUnwrap;
        if (!zzdioVar2.zzV()) {
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Your account must be enabled to use this feature. Talk to your account manager to request this feature for your account.");
        } else {
            this.zze = zzdioVar2;
            zzdioVar2.zzT(this);
            this.zze.zzL(zzf());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized void zzd() {
        zzdio zzdioVar = this.zze;
        if (zzdioVar != null) {
            zzdioVar.zzU(this);
            this.zze = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdkr
    public final View zzf() {
        return (View) this.zza.get();
    }

    @Override // com.google.android.gms.internal.ads.zzdkr
    public final synchronized View zzg(String str) {
        WeakReference weakReference = (WeakReference) this.zzd.get(str);
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    @Override // com.google.android.gms.internal.ads.zzdkr
    public final FrameLayout zzh() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdkr
    public final zzaze zzi() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzdkr
    public final synchronized IObjectWrapper zzj() {
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Override // com.google.android.gms.internal.ads.zzdkr
    public final synchronized String zzk() {
        return "1007";
    }

    @Override // com.google.android.gms.internal.ads.zzdkr
    public final synchronized Map zzl() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzdkr
    public final synchronized Map zzm() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzdkr
    public final synchronized Map zzn() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzdkr
    public final synchronized JSONObject zzo() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdkr
    public final synchronized JSONObject zzp() {
        zzdio zzdioVar = this.zze;
        if (zzdioVar == null) {
            return null;
        }
        return zzdioVar.zzj(zzf(), zzl(), zzm());
    }

    @Override // com.google.android.gms.internal.ads.zzdkr
    public final synchronized void zzq(String str, View view, boolean z) {
        this.zzd.put(str, new WeakReference(view));
        if (!"1098".equals(str) && !"3011".equals(str)) {
            this.zzb.put(str, new WeakReference(view));
            view.setClickable(true);
            view.setOnClickListener(this);
            view.setOnTouchListener(this);
        }
    }
}
