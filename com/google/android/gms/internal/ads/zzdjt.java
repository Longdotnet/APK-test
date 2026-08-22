package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;
import okio.Okio;

/* JADX INFO: loaded from: classes.dex */
public final class zzdjt {
    static final ImageView.ScaleType zza = ImageView.ScaleType.CENTER_INSIDE;
    private final com.google.android.gms.ads.internal.util.zzg zzb;
    private final zzfcw zzc;
    private final zzdiy zzd;
    private final zzdit zze;
    private final zzdkh zzf;
    private final zzdkp zzg;
    private final Executor zzh;
    private final Executor zzi;
    private final zzbge zzj;
    private final zzdiq zzk;

    public zzdjt(com.google.android.gms.ads.internal.util.zzg zzgVar, zzfcw zzfcwVar, zzdiy zzdiyVar, zzdit zzditVar, zzdkh zzdkhVar, zzdkp zzdkpVar, Executor executor, Executor executor2, zzdiq zzdiqVar) {
        this.zzb = zzgVar;
        this.zzc = zzfcwVar;
        this.zzj = zzfcwVar.zzi;
        this.zzd = zzdiyVar;
        this.zze = zzditVar;
        this.zzf = zzdkhVar;
        this.zzg = zzdkpVar;
        this.zzh = executor;
        this.zzi = executor2;
        this.zzk = zzdiqVar;
    }

    public static /* synthetic */ void zza(zzdjt zzdjtVar, ViewGroup viewGroup) {
        zzdit zzditVar = zzdjtVar.zze;
        if (zzditVar.zzf() != null) {
            boolean z = viewGroup != null;
            if (zzditVar.zzc() == 2 || zzditVar.zzc() == 1) {
                com.google.android.gms.ads.internal.util.zzg zzgVar = zzdjtVar.zzb;
                com.google.android.gms.ads.internal.util.zzj zzjVar = (com.google.android.gms.ads.internal.util.zzj) zzgVar;
                zzjVar.zzF(zzdjtVar.zzc.zzf, String.valueOf(zzditVar.zzc()), z);
                return;
            }
            if (zzditVar.zzc() == 6) {
                com.google.android.gms.ads.internal.util.zzg zzgVar2 = zzdjtVar.zzb;
                String str = zzdjtVar.zzc.zzf;
                com.google.android.gms.ads.internal.util.zzj zzjVar2 = (com.google.android.gms.ads.internal.util.zzj) zzgVar2;
                zzjVar2.zzF(str, "2", z);
                zzjVar2.zzF(str, "1", z);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:80:0x018b  */
    public static void zzb(final zzdjt zzdjtVar, zzdkr zzdkrVar) {
        ViewGroup viewGroup;
        View viewZze;
        final ViewGroup viewGroup2;
        zzbgm zzbgmVarZza;
        Drawable drawable;
        zzdiy zzdiyVar = zzdjtVar.zzd;
        if (!zzdiyVar.zzf() && !zzdiyVar.zze()) {
            viewGroup = null;
            break;
        }
        String[] strArr = {"1098", "3011"};
        int i = 0;
        while (true) {
            if (i >= 2) {
                viewGroup = null;
                break;
            }
            View viewZzg = zzdkrVar.zzg(strArr[i]);
            if (viewZzg instanceof ViewGroup) {
                viewGroup = (ViewGroup) viewZzg;
                break;
            }
            i++;
        }
        Context context = zzdkrVar.zzf().getContext();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        zzdit zzditVar = zzdjtVar.zze;
        if (zzditVar.zze() != null) {
            viewZze = zzditVar.zze();
            zzbge zzbgeVar = zzdjtVar.zzj;
            if (zzbgeVar != null && viewGroup == null) {
                zzh(layoutParams, zzbgeVar.zze);
                viewZze.setLayoutParams(layoutParams);
                viewGroup = null;
            }
        } else if (zzditVar.zzl() instanceof zzbfz) {
            zzbfz zzbfzVar = (zzbfz) zzditVar.zzl();
            if (viewGroup == null) {
                zzh(layoutParams, zzbfzVar.zzc());
                viewGroup = null;
            }
            View zzbgaVar = new zzbga(context, zzbfzVar, layoutParams);
            zzbgaVar.setContentDescription((CharSequence) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzed));
            viewZze = zzbgaVar;
        } else {
            viewZze = null;
        }
        if (viewZze != null) {
            if (viewZze.getParent() instanceof ViewGroup) {
                ((ViewGroup) viewZze.getParent()).removeView(viewZze);
            }
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                viewGroup.addView(viewZze);
            } else {
                com.google.android.gms.ads.formats.zza zzaVar = new com.google.android.gms.ads.formats.zza(zzdkrVar.zzf().getContext());
                zzaVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                zzaVar.addView(viewZze);
                FrameLayout frameLayoutZzh = zzdkrVar.zzh();
                if (frameLayoutZzh != null) {
                    frameLayoutZzh.addView(zzaVar);
                }
            }
            zzdkrVar.zzq(zzdkrVar.zzk(), viewZze, true);
        }
        zzfyq zzfyqVar = zzdjp.zza;
        int size = zzfyqVar.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                viewGroup2 = null;
                break;
            }
            View viewZzg2 = zzdkrVar.zzg((String) zzfyqVar.get(i2));
            i2++;
            if (viewZzg2 instanceof ViewGroup) {
                viewGroup2 = (ViewGroup) viewZzg2;
                break;
            }
        }
        zzdjtVar.zzi.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdjq
            @Override // java.lang.Runnable
            public final void run() {
                zzdjt.zza(this.zza, viewGroup2);
            }
        });
        if (viewGroup2 == null) {
            return;
        }
        if (zzdjtVar.zzi(viewGroup2, true)) {
            if (zzditVar.zzs() != null) {
                zzditVar.zzs().zzar(new zzdjs(zzdkrVar, viewGroup2));
                return;
            }
            return;
        }
        zzbcv zzbcvVar = zzbde.zzkw;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() && zzdjtVar.zzi(viewGroup2, false)) {
            if (zzditVar.zzq() != null) {
                zzditVar.zzq().zzar(new zzdjs(zzdkrVar, viewGroup2));
                return;
            }
            return;
        }
        viewGroup2.removeAllViews();
        View viewZzf = zzdkrVar.zzf();
        Context context2 = viewZzf != null ? viewZzf.getContext() : null;
        if (context2 == null || (zzbgmVarZza = zzdjtVar.zzk.zza()) == null) {
            return;
        }
        try {
            IObjectWrapper iObjectWrapperZzi = zzbgmVarZza.zzi();
            if (iObjectWrapperZzi == null || (drawable = (Drawable) ObjectWrapper.unwrap(iObjectWrapperZzi)) == null) {
                return;
            }
            ImageView imageView = new ImageView(context2);
            imageView.setImageDrawable(drawable);
            IObjectWrapper iObjectWrapperZzj = zzdkrVar.zzj();
            if (iObjectWrapperZzj == null) {
                imageView.setScaleType(zza);
            } else if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzgu)).booleanValue()) {
                imageView.setScaleType((ImageView.ScaleType) ObjectWrapper.unwrap(iObjectWrapperZzj));
            } else {
                imageView.setScaleType(zza);
            }
            imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            viewGroup2.addView(imageView);
        } catch (RemoteException unused) {
            int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not get main image drawable");
        }
    }

    private static void zzh(RelativeLayout.LayoutParams layoutParams, int i) {
        if (i == 0) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        } else if (i == 2) {
            layoutParams.addRule(12);
            layoutParams.addRule(11);
        } else if (i != 3) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(9);
        }
    }

    private final boolean zzi(ViewGroup viewGroup, boolean z) {
        View viewZzf = z ? this.zze.zzf() : this.zze.zzg();
        if (viewZzf == null) {
            return false;
        }
        viewGroup.removeAllViews();
        if (viewZzf.getParent() instanceof ViewGroup) {
            ((ViewGroup) viewZzf.getParent()).removeView(viewZzf);
        }
        viewGroup.addView(viewZzf, ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzef)).booleanValue() ? new FrameLayout.LayoutParams(-1, -1, 17) : new FrameLayout.LayoutParams(-2, -2, 17));
        return true;
    }

    public final void zzc(zzdkr zzdkrVar) {
        zzdkh zzdkhVar;
        if (zzdkrVar == null || (zzdkhVar = this.zzf) == null || zzdkrVar.zzh() == null || !this.zzd.zzg()) {
            return;
        }
        try {
            zzdkrVar.zzh().addView(zzdkhVar.zza());
        } catch (zzcfs e) {
            com.google.android.gms.ads.internal.util.zze.zzb("web view can not be obtained", e);
        }
    }

    public final void zzd(zzdkr zzdkrVar) {
        if (zzdkrVar == null) {
            return;
        }
        Context context = zzdkrVar.zzf().getContext();
        if (Okio.zzi(context, this.zzd.zza)) {
            if (!(context instanceof Activity)) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zze("Activity context is needed for policy validator.");
                return;
            }
            zzdkp zzdkpVar = this.zzg;
            if (zzdkpVar == null || zzdkrVar.zzh() == null) {
                return;
            }
            try {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                windowManager.addView(zzdkpVar.zza(zzdkrVar.zzh(), windowManager), Okio.zzb());
            } catch (zzcfs e) {
                com.google.android.gms.ads.internal.util.zze.zzb("web view can not be obtained", e);
            }
        }
    }

    public final void zze(final zzdkr zzdkrVar) {
        this.zzh.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdjr
            @Override // java.lang.Runnable
            public final void run() {
                zzdjt.zzb(this.zza, zzdkrVar);
            }
        });
    }

    public final boolean zzf(ViewGroup viewGroup) {
        return zzi(viewGroup, false);
    }

    public final boolean zzg(ViewGroup viewGroup) {
        return zzi(viewGroup, true);
    }
}
