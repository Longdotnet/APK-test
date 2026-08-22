package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import androidx.collection.ArraySet;
import com.google.android.gms.ads.internal.gMU.QTaELkFI;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbso extends zzbsu {
    private String zza;
    private boolean zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private final Object zzi;
    private final zzcfg zzj;
    private final Activity zzk;
    private zzchd zzl;
    private ImageView zzm;
    private LinearLayout zzn;
    private final zzbsv zzo;
    private PopupWindow zzp;
    private RelativeLayout zzq;
    private ViewGroup zzr;

    static {
        ArraySet arraySet = new ArraySet(7);
        Collections.addAll(arraySet, "top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
        Collections.unmodifiableSet(arraySet);
    }

    public zzbso(zzcfg zzcfgVar, zzbsv zzbsvVar) {
        super(zzcfgVar, "resize");
        this.zza = "top-right";
        this.zzb = true;
        this.zzc = 0;
        this.zzd = 0;
        this.zze = -1;
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = -1;
        this.zzi = new Object();
        this.zzj = zzcfgVar;
        this.zzk = zzcfgVar.zzi();
        this.zzo = zzbsvVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void zzm(boolean z) {
        zzbcv zzbcvVar = zzbde.zzlm;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            this.zzq.removeView((View) this.zzj);
            this.zzp.dismiss();
        } else {
            this.zzp.dismiss();
            this.zzq.removeView((View) this.zzj);
        }
        if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzln)).booleanValue()) {
            View view = (View) this.zzj;
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
        ViewGroup viewGroup = this.zzr;
        if (viewGroup != null) {
            viewGroup.removeView(this.zzm);
            if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzlo)).booleanValue()) {
                try {
                    ViewGroup viewGroup2 = this.zzr;
                    zzcfg zzcfgVar = this.zzj;
                    viewGroup2.addView((View) zzcfgVar);
                    zzcfgVar.zzaj(this.zzl);
                } catch (IllegalStateException e) {
                    int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to add webview back to view hierarchy.", e);
                }
            } else {
                ViewGroup viewGroup3 = this.zzr;
                zzcfg zzcfgVar2 = this.zzj;
                viewGroup3.addView((View) zzcfgVar2);
                zzcfgVar2.zzaj(this.zzl);
            }
        }
        if (z) {
            zzl("default");
            zzbsv zzbsvVar = this.zzo;
            if (zzbsvVar != null) {
                zzbsvVar.zzb();
            }
        }
        this.zzp = null;
        this.zzq = null;
        this.zzr = null;
        this.zzn = null;
    }

    public final void zzb(final boolean z) {
        synchronized (this.zzi) {
            try {
                if (this.zzp != null) {
                    if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzll)).booleanValue() || Looper.getMainLooper().getThread() == Thread.currentThread()) {
                        zzm(z);
                    } else {
                        zzcaf.zzf.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbsm
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.zza.zzm(z);
                            }
                        });
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzd(int i, int i2, boolean z) {
        synchronized (this.zzi) {
            this.zzc = i;
            this.zzd = i2;
        }
    }

    public final void zze(int i, int i2) {
        this.zzc = i;
        this.zzd = i2;
    }

    public final boolean zzf() {
        boolean z;
        synchronized (this.zzi) {
            z = this.zzp != null;
        }
        return z;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:87:0x019c  */
    /* JADX WARN: Multi-variable type inference failed */
    public final void zzc(Map map) {
        byte b;
        int i;
        byte b2;
        int i2;
        int i3;
        int i4;
        int i5;
        String str = QTaELkFI.sUQXrLunVTFYnq;
        synchronized (this.zzi) {
            try {
                Activity activity = this.zzk;
                if (activity == null) {
                    zzh("Not an activity context. Cannot resize.");
                    return;
                }
                zzcfg zzcfgVar = this.zzj;
                if (zzcfgVar.zzO() == null) {
                    zzh("Webview is not yet available, size is not set.");
                    return;
                }
                if (zzcfgVar.zzO().zzi()) {
                    zzh("Is interstitial. Cannot resize an interstitial.");
                    return;
                }
                if (zzcfgVar.zzaF()) {
                    zzh("Cannot resize an expanded banner.");
                    return;
                }
                if (!TextUtils.isEmpty((CharSequence) map.get("width"))) {
                    com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
                    this.zzh = com.google.android.gms.ads.internal.util.zzs.zzP((String) map.get("width"));
                }
                if (!TextUtils.isEmpty((CharSequence) map.get("height"))) {
                    com.google.android.gms.ads.internal.util.zzs zzsVar2 = com.google.android.gms.ads.internal.zzv.zza.zzd;
                    this.zze = com.google.android.gms.ads.internal.util.zzs.zzP((String) map.get("height"));
                }
                if (!TextUtils.isEmpty((CharSequence) map.get("offsetX"))) {
                    com.google.android.gms.ads.internal.util.zzs zzsVar3 = com.google.android.gms.ads.internal.zzv.zza.zzd;
                    this.zzf = com.google.android.gms.ads.internal.util.zzs.zzP((String) map.get("offsetX"));
                }
                if (!TextUtils.isEmpty((CharSequence) map.get("offsetY"))) {
                    com.google.android.gms.ads.internal.util.zzs zzsVar4 = com.google.android.gms.ads.internal.zzv.zza.zzd;
                    this.zzg = com.google.android.gms.ads.internal.util.zzs.zzP((String) map.get("offsetY"));
                }
                if (!TextUtils.isEmpty((CharSequence) map.get("allowOffscreen"))) {
                    this.zzb = Boolean.parseBoolean((String) map.get("allowOffscreen"));
                }
                String str2 = (String) map.get("customClosePosition");
                if (!TextUtils.isEmpty(str2)) {
                    this.zza = str2;
                }
                if (this.zzh < 0 || this.zze < 0) {
                    zzh("Invalid width and height options. Cannot resize.");
                    return;
                }
                Window window = activity.getWindow();
                if (window != null && window.getDecorView() != null) {
                    com.google.android.gms.ads.internal.util.zzs zzsVar5 = com.google.android.gms.ads.internal.zzv.zza.zzd;
                    int[] iArrZzR = com.google.android.gms.ads.internal.util.zzs.zzR(activity);
                    com.google.android.gms.ads.internal.client.zzbb zzbbVar = com.google.android.gms.ads.internal.client.zzbb.zzb;
                    int[] iArr = {zzbbVar.zzc.zzb(activity, iArrZzR[0]), zzbbVar.zzc.zzb(activity, iArrZzR[1])};
                    int[] iArrZzS = com.google.android.gms.ads.internal.util.zzs.zzS(activity);
                    int i6 = iArr[0];
                    int i7 = iArr[1];
                    int i8 = this.zzh;
                    int[] iArr2 = null;
                    if (i8 < 50 || i8 > i6) {
                        int i9 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzj("Width is too small or too large.");
                    } else {
                        int i10 = this.zze;
                        if (i10 < 50 || i10 > i7) {
                            int i11 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                            com.google.android.gms.ads.internal.util.client.zzo.zzj("Height is too small or too large.");
                        } else if (i10 == i7 && i8 == i6) {
                            int i12 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                            com.google.android.gms.ads.internal.util.client.zzo.zzj("Cannot resize to a full-screen ad.");
                        } else if (this.zzb) {
                            switch (this.zza) {
                                case "center":
                                    b2 = 2;
                                    break;
                                case "top-left":
                                    b2 = 0;
                                    break;
                                case "bottom-left":
                                    b2 = 3;
                                    break;
                                case "bottom-right":
                                    b2 = 5;
                                    break;
                                case "bottom-center":
                                    b2 = 4;
                                    break;
                                case "top-center":
                                    b2 = 1;
                                    break;
                                default:
                                    b2 = -1;
                                    break;
                            }
                            if (b2 == 0) {
                                i2 = this.zzc + this.zzf;
                                i3 = this.zzd;
                            } else if (b2 != 1) {
                                if (b2 != 2) {
                                    if (b2 == 3) {
                                        i2 = this.zzc + this.zzf;
                                        i5 = this.zzd;
                                    } else if (b2 == 4) {
                                        i2 = ((this.zzc + this.zzf) + (i8 >> 1)) - 25;
                                        i5 = this.zzd;
                                    } else if (b2 != 5) {
                                        i2 = ((this.zzc + this.zzf) + i8) - 50;
                                        i3 = this.zzd;
                                    } else {
                                        i2 = ((this.zzc + this.zzf) + i8) - 50;
                                        i5 = this.zzd;
                                    }
                                    i4 = ((i5 + this.zzg) + i10) - 50;
                                } else {
                                    i2 = ((this.zzc + this.zzf) + (i8 >> 1)) - 25;
                                    i4 = ((this.zzd + this.zzg) + (i10 >> 1)) - 25;
                                }
                                if (i2 >= 0 && i2 + 50 <= i6 && i4 >= iArrZzS[0] && i4 + 50 <= iArrZzS[1]) {
                                    iArr2 = new int[]{this.zzc + this.zzf, this.zzd + this.zzg};
                                }
                            } else {
                                i2 = ((this.zzc + this.zzf) + (i8 >> 1)) - 25;
                                i3 = this.zzd;
                            }
                            i4 = i3 + this.zzg;
                            if (i2 >= 0) {
                                iArr2 = new int[]{this.zzc + this.zzf, this.zzd + this.zzg};
                            }
                        } else {
                            int[] iArrZzR2 = com.google.android.gms.ads.internal.util.zzs.zzR(activity);
                            int[] iArr3 = {zzbbVar.zzc.zzb(activity, iArrZzR2[0]), zzbbVar.zzc.zzb(activity, iArrZzR2[1])};
                            int[] iArrZzS2 = com.google.android.gms.ads.internal.util.zzs.zzS(activity);
                            int i13 = iArr3[0];
                            int i14 = this.zzc + this.zzf;
                            int i15 = this.zzd + this.zzg;
                            if (i14 < 0) {
                                i = 0;
                            } else {
                                int i16 = this.zzh;
                                i = i14 + i16 > i13 ? i13 - i16 : i14;
                            }
                            int i17 = iArrZzS2[0];
                            if (i15 < i17) {
                                i15 = i17;
                            } else {
                                int i18 = this.zze;
                                int i19 = i15 + i18;
                                int i20 = iArrZzS2[1];
                                if (i19 > i20) {
                                    i15 = i20 - i18;
                                }
                            }
                            iArr2 = new int[]{i, i15};
                        }
                    }
                    if (iArr2 == null) {
                        zzh("Resize location out of screen or close button is not visible.");
                        return;
                    }
                    com.google.android.gms.ads.internal.util.client.zzf zzfVar = zzbbVar.zzc;
                    int iZzu = com.google.android.gms.ads.internal.util.client.zzf.zzu(activity.getResources().getDisplayMetrics(), this.zzh);
                    int iZzu2 = com.google.android.gms.ads.internal.util.client.zzf.zzu(activity.getResources().getDisplayMetrics(), this.zze);
                    ViewParent parent = ((View) zzcfgVar).getParent();
                    if (!(parent instanceof ViewGroup)) {
                        zzh("Webview is detached, probably in the middle of a resize or expand.");
                        return;
                    }
                    ViewGroup viewGroup = (ViewGroup) parent;
                    viewGroup.removeView((View) zzcfgVar);
                    PopupWindow popupWindow = this.zzp;
                    if (popupWindow == null) {
                        this.zzr = viewGroup;
                        ((View) zzcfgVar).setDrawingCacheEnabled(true);
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(((View) zzcfgVar).getDrawingCache());
                        ((View) zzcfgVar).setDrawingCacheEnabled(false);
                        ImageView imageView = new ImageView(activity);
                        this.zzm = imageView;
                        imageView.setImageBitmap(bitmapCreateBitmap);
                        this.zzl = zzcfgVar.zzO();
                        this.zzr.addView(this.zzm);
                    } else {
                        popupWindow.dismiss();
                    }
                    RelativeLayout relativeLayout = new RelativeLayout(activity);
                    this.zzq = relativeLayout;
                    relativeLayout.setBackgroundColor(0);
                    this.zzq.setLayoutParams(new ViewGroup.LayoutParams(iZzu, iZzu2));
                    PopupWindow popupWindow2 = new PopupWindow((View) this.zzq, iZzu, iZzu2, false);
                    this.zzp = popupWindow2;
                    popupWindow2.setOutsideTouchable(false);
                    this.zzp.setTouchable(true);
                    this.zzp.setClippingEnabled(!this.zzb);
                    this.zzq.addView((View) zzcfgVar, -1, -1);
                    this.zzn = new LinearLayout(activity);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.google.android.gms.ads.internal.util.client.zzf.zzu(activity.getResources().getDisplayMetrics(), 50), com.google.android.gms.ads.internal.util.client.zzf.zzu(activity.getResources().getDisplayMetrics(), 50));
                    switch (this.zza) {
                        case "center":
                            b = 2;
                            break;
                        case "top-left":
                            b = 0;
                            break;
                        case "bottom-left":
                            b = 3;
                            break;
                        case "bottom-right":
                            b = 5;
                            break;
                        case "bottom-center":
                            b = 4;
                            break;
                        case "top-center":
                            b = 1;
                            break;
                        default:
                            b = -1;
                            break;
                    }
                    if (b == 0) {
                        layoutParams.addRule(10);
                        layoutParams.addRule(9);
                    } else if (b == 1) {
                        layoutParams.addRule(10);
                        layoutParams.addRule(14);
                    } else if (b == 2) {
                        layoutParams.addRule(13);
                    } else if (b == 3) {
                        layoutParams.addRule(12);
                        layoutParams.addRule(9);
                    } else if (b == 4) {
                        layoutParams.addRule(12);
                        layoutParams.addRule(14);
                    } else if (b != 5) {
                        layoutParams.addRule(10);
                        layoutParams.addRule(11);
                    } else {
                        layoutParams.addRule(12);
                        layoutParams.addRule(11);
                    }
                    this.zzn.setOnClickListener(new zzbsn(this));
                    this.zzn.setContentDescription("Close button");
                    this.zzq.addView(this.zzn, layoutParams);
                    try {
                        this.zzp.showAtLocation(window.getDecorView(), 0, com.google.android.gms.ads.internal.util.client.zzf.zzu(activity.getResources().getDisplayMetrics(), iArr2[0]), com.google.android.gms.ads.internal.util.client.zzf.zzu(activity.getResources().getDisplayMetrics(), iArr2[1]));
                        int i21 = iArr2[0];
                        int i22 = iArr2[1];
                        zzbsv zzbsvVar = this.zzo;
                        if (zzbsvVar != null) {
                            zzbsvVar.zza(i21, i22, this.zzh, this.zze);
                        }
                        this.zzj.zzaj(zzchd.zzb(iZzu, iZzu2));
                        zzk(iArr2[0], iArr2[1] - com.google.android.gms.ads.internal.util.zzs.zzS(this.zzk)[0], this.zzh, this.zze);
                        zzl("resized");
                        return;
                    } catch (RuntimeException e) {
                        zzh(str + e.getMessage());
                        RelativeLayout relativeLayout2 = this.zzq;
                        zzcfg zzcfgVar2 = this.zzj;
                        relativeLayout2.removeView((View) zzcfgVar2);
                        ViewGroup viewGroup2 = this.zzr;
                        if (viewGroup2 != null) {
                            viewGroup2.removeView(this.zzm);
                            this.zzr.addView((View) zzcfgVar2);
                            zzcfgVar2.zzaj(this.zzl);
                        }
                        return;
                    }
                }
                zzh("Activity context is not ready, cannot get window or decor view.");
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
