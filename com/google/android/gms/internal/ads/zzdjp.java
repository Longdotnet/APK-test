package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import okio.Okio;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzdjp extends zzbgs implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzdkr {
    public static final zzfyq zza = zzfyq.zzq("2011", "1009", "3010");
    private final String zzb;
    private FrameLayout zzd;
    private FrameLayout zze;
    private final zzgdy zzf;
    private View zzg;
    private zzdio zzi;
    private zzaze zzj;
    private zzbgm zzl;
    private boolean zzm;
    private GestureDetector zzo;
    private Map zzc = new HashMap();
    private IObjectWrapper zzk = null;
    private boolean zzn = false;
    private final int zzh = ModuleDescriptor.MODULE_VERSION;

    public zzdjp(FrameLayout frameLayout, FrameLayout frameLayout2, int i) {
        String str;
        this.zzd = frameLayout;
        this.zze = frameLayout2;
        String canonicalName = frameLayout.getClass().getCanonicalName();
        if ("com.google.android.gms.ads.formats.NativeContentAdView".equals(canonicalName)) {
            str = "1007";
        } else if ("com.google.android.gms.ads.formats.NativeAppInstallAdView".equals(canonicalName)) {
            str = "2009";
        } else {
            "com.google.android.gms.ads.formats.UnifiedNativeAdView".equals(canonicalName);
            str = "3012";
        }
        this.zzb = str;
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        zzcas zzcasVar = zzvVar.zzE;
        zzcas.zza(frameLayout, this);
        zzcas zzcasVar2 = zzvVar.zzE;
        zzcas.zzb(frameLayout, this);
        this.zzf = zzcaf.zzf;
        this.zzj = new zzaze(this.zzd.getContext(), this.zzd);
        frameLayout.setOnTouchListener(this);
        frameLayout.setOnClickListener(this);
    }

    public static /* synthetic */ void zzs(zzdjp zzdjpVar) {
        if (zzdjpVar.zzg == null) {
            View view = new View(zzdjpVar.zzd.getContext());
            zzdjpVar.zzg = view;
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, 0));
        }
        if (zzdjpVar.zzd != zzdjpVar.zzg.getParent()) {
            zzdjpVar.zzd.addView(zzdjpVar.zzg);
        }
    }

    private final synchronized void zzt(String str) {
        DisplayMetrics displayMetrics;
        try {
            View frameLayout = new FrameLayout(this.zze.getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            Context context = this.zze.getContext();
            frameLayout.setClickable(false);
            frameLayout.setFocusable(false);
            if (!TextUtils.isEmpty(str)) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                Resources resources = context.getResources();
                if (resources != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
                    try {
                        byte[] bArrDecode = Base64.decode(str, 0);
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
                        bitmapDrawable.setTargetDensity(displayMetrics.densityDpi);
                        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                        bitmapDrawable.setTileModeXY(tileMode, tileMode);
                        frameLayout.setBackground(bitmapDrawable);
                    } catch (IllegalArgumentException e) {
                        com.google.android.gms.ads.internal.util.client.zzo.zzk("Encountered invalid base64 watermark.", e);
                    }
                }
            }
            this.zze.addView(frameLayout);
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized void zzu() {
        this.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdjo
            @Override // java.lang.Runnable
            public final void run() {
                zzdjp.zzs(this.zza);
            }
        });
    }

    private final synchronized void zzv() {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzlW)).booleanValue() || this.zzi.zza() == 0) {
            return;
        }
        this.zzo = new GestureDetector(this.zzd.getContext(), new zzdjx(this.zzi, this));
    }

    @Override // android.view.View.OnClickListener
    public final synchronized void onClick(View view) {
        zzdio zzdioVar = this.zzi;
        if (zzdioVar == null || !zzdioVar.zzW()) {
            return;
        }
        this.zzi.zzB();
        this.zzi.zzE(view, this.zzd, zzl(), zzm(), false);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final synchronized void onGlobalLayout() {
        zzdio zzdioVar = this.zzi;
        if (zzdioVar != null) {
            FrameLayout frameLayout = this.zzd;
            zzdioVar.zzC(frameLayout, zzl(), zzm(), zzdio.zzZ(frameLayout));
        }
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final synchronized void onScrollChanged() {
        zzdio zzdioVar = this.zzi;
        if (zzdioVar != null) {
            FrameLayout frameLayout = this.zzd;
            zzdioVar.zzC(frameLayout, zzl(), zzm(), zzdio.zzZ(frameLayout));
        }
    }

    @Override // android.view.View.OnTouchListener
    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        zzdio zzdioVar = this.zzi;
        if (zzdioVar != null) {
            zzdioVar.zzM(view, motionEvent, this.zzd);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzlW)).booleanValue() && this.zzo != null && this.zzi.zza() != 0) {
                this.zzo.onTouchEvent(motionEvent);
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbgt
    public final synchronized IObjectWrapper zzb(String str) {
        return new ObjectWrapper(zzg(str));
    }

    @Override // com.google.android.gms.internal.ads.zzbgt
    public final synchronized void zzc() {
        try {
            if (this.zzn) {
                return;
            }
            zzdio zzdioVar = this.zzi;
            if (zzdioVar != null) {
                zzdioVar.zzU(this);
                this.zzi = null;
            }
            this.zzc.clear();
            this.zzd.removeAllViews();
            this.zze.removeAllViews();
            this.zzc = null;
            this.zzd = null;
            this.zze = null;
            this.zzg = null;
            this.zzj = null;
            this.zzn = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgt
    public final void zzd(IObjectWrapper iObjectWrapper) {
        onTouch(this.zzd, (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzbgt
    public final synchronized void zzdA(IObjectWrapper iObjectWrapper) {
        if (this.zzn) {
            return;
        }
        this.zzk = iObjectWrapper;
    }

    @Override // com.google.android.gms.internal.ads.zzbgt
    public final synchronized void zzdB(IObjectWrapper iObjectWrapper) {
        if (this.zzn) {
            return;
        }
        Object objUnwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(objUnwrap instanceof zzdio)) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Not an instance of native engine. This is most likely a transient error");
            return;
        }
        zzdio zzdioVar = this.zzi;
        if (zzdioVar != null) {
            zzdioVar.zzU(this);
        }
        zzu();
        zzdio zzdioVar2 = (zzdio) objUnwrap;
        this.zzi = zzdioVar2;
        zzdioVar2.zzT(this);
        this.zzi.zzL(this.zzd);
        this.zzi.zzA(this.zze);
        if (this.zzm) {
            this.zzi.zzc().zzb(this.zzl);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzei)).booleanValue() && !TextUtils.isEmpty(this.zzi.zzg())) {
            zzt(this.zzi.zzg());
        }
        zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzbgt
    public final synchronized void zzdx(String str, IObjectWrapper iObjectWrapper) {
        zzq(str, (View) ObjectWrapper.unwrap(iObjectWrapper), true);
    }

    @Override // com.google.android.gms.internal.ads.zzbgt
    public final synchronized void zzdy(IObjectWrapper iObjectWrapper) {
        this.zzi.zzO((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzbgt
    public final synchronized void zzdz(zzbgm zzbgmVar) {
        if (!this.zzn) {
            this.zzm = true;
            this.zzl = zzbgmVar;
            zzdio zzdioVar = this.zzi;
            if (zzdioVar != null) {
                zzdioVar.zzc().zzb(zzbgmVar);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgt
    public final synchronized void zze(IObjectWrapper iObjectWrapper, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzdkr
    public final /* synthetic */ View zzf() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzdkr
    public final synchronized View zzg(String str) {
        WeakReference weakReference;
        if (!this.zzn && (weakReference = (WeakReference) this.zzc.get(str)) != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdkr
    public final FrameLayout zzh() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzdkr
    public final zzaze zzi() {
        return this.zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzdkr
    public final IObjectWrapper zzj() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzdkr
    public final synchronized String zzk() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzdkr
    public final synchronized Map zzl() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzdkr
    public final synchronized Map zzm() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzdkr
    public final synchronized Map zzn() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdkr
    public final synchronized JSONObject zzo() {
        zzdio zzdioVar = this.zzi;
        if (zzdioVar == null) {
            return null;
        }
        return zzdioVar.zzi(this.zzd, zzl(), zzm());
    }

    @Override // com.google.android.gms.internal.ads.zzdkr
    public final synchronized JSONObject zzp() {
        zzdio zzdioVar = this.zzi;
        if (zzdioVar == null) {
            return null;
        }
        return zzdioVar.zzj(this.zzd, zzl(), zzm());
    }

    @Override // com.google.android.gms.internal.ads.zzdkr
    public final synchronized void zzq(String str, View view, boolean z) {
        if (!this.zzn) {
            if (view == null) {
                this.zzc.remove(str);
                return;
            }
            this.zzc.put(str, new WeakReference(view));
            if (!"1098".equals(str) && !"3011".equals(str)) {
                if (Okio.zzj(this.zzh)) {
                    view.setOnTouchListener(this);
                }
                view.setClickable(true);
                view.setOnClickListener(this);
            }
        }
    }

    public final FrameLayout zzr() {
        return this.zzd;
    }
}
