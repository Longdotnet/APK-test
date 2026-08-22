package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Insets;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
public final class zzemq implements zzeuc {
    private final zzeuc zza;
    private final zzfcw zzb;
    private final Context zzc;
    private final zzbzs zzd;

    public zzemq(zzeou zzeouVar, zzfcw zzfcwVar, Context context, zzbzs zzbzsVar) {
        this.zza = zzeouVar;
        this.zzb = zzfcwVar;
        this.zzc = context;
        this.zzd = zzbzsVar;
    }

    public static zzemr zzc(zzemq zzemqVar, zzeul zzeulVar) {
        String str;
        boolean z;
        String strZzj;
        float f;
        int i;
        int i2;
        int i3;
        Insets insetsOf;
        DisplayMetrics displayMetrics;
        zzfcw zzfcwVar = zzemqVar.zzb;
        com.google.android.gms.ads.internal.client.zzr zzrVar = zzfcwVar.zze;
        com.google.android.gms.ads.internal.client.zzr[] zzrVarArr = zzrVar.zzg;
        if (zzrVarArr != null) {
            str = null;
            boolean z2 = false;
            boolean z3 = false;
            z = false;
            for (com.google.android.gms.ads.internal.client.zzr zzrVar2 : zzrVarArr) {
                boolean z4 = zzrVar2.zzi;
                if (!z4 && !z2) {
                    str = zzrVar2.zza;
                    z2 = true;
                }
                if (z4) {
                    if (z3) {
                        z3 = true;
                    } else {
                        z3 = true;
                        z = true;
                    }
                }
                if (z2 && z3) {
                    break;
                }
            }
        } else {
            str = zzrVar.zza;
            z = zzrVar.zzi;
        }
        Context context = zzemqVar.zzc;
        Resources resources = context.getResources();
        int i4 = Build.VERSION.SDK_INT;
        Insets insets = i4 >= 29 ? Insets.NONE : null;
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            strZzj = null;
            f = 0.0f;
            i = 0;
            i2 = 0;
        } else {
            zzbzs zzbzsVar = zzemqVar.zzd;
            float f2 = displayMetrics.density;
            int i5 = displayMetrics.widthPixels;
            int i6 = displayMetrics.heightPixels;
            strZzj = ((com.google.android.gms.ads.internal.util.zzj) zzbzsVar.zzi()).zzj();
            f = f2;
            i2 = i6;
            i = i5;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zznH)).booleanValue() || i4 < 35) {
            str = str;
        } else {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null || f == 0.0f) {
                insetsOf = Insets.NONE;
            } else {
                Insets insets2 = windowManager.getCurrentWindowMetrics().getWindowInsets().getInsets(WindowInsets.Type.statusBars() | WindowInsets.Type.displayCutout() | WindowInsets.Type.navigationBars() | WindowInsets.Type.captionBar());
                insetsOf = Insets.of((int) Math.ceil(insets2.left / f), (int) Math.ceil(insets2.top / f), (int) Math.ceil(insets2.right / f), (int) Math.ceil(insets2.bottom / f));
            }
            insets = insetsOf;
        }
        StringBuilder sb = new StringBuilder();
        if (zzrVarArr != null) {
            boolean z5 = false;
            for (com.google.android.gms.ads.internal.client.zzr zzrVar3 : zzrVarArr) {
                if (zzrVar3.zzi) {
                    z5 = true;
                } else {
                    if (sb.length() != 0) {
                        sb.append("|");
                    }
                    int i7 = -1;
                    int i8 = zzrVar3.zze;
                    if (i8 != -1) {
                        i7 = i8;
                    } else if (f != 0.0f) {
                        i7 = (int) (zzrVar3.zzf / f);
                    }
                    sb.append(i7);
                    sb.append("x");
                    int i9 = -2;
                    int i10 = zzrVar3.zzb;
                    if (i10 != -2) {
                        i9 = i10;
                    } else if (f != 0.0f) {
                        i9 = (int) (zzrVar3.zzc / f);
                    }
                    sb.append(i9);
                }
            }
            if (z5) {
                if (sb.length() != 0) {
                    i3 = 0;
                    sb.insert(0, "|");
                } else {
                    i3 = 0;
                }
                sb.insert(i3, "320x50");
            }
        }
        return new zzemr(zzrVar, str, z, sb.toString(), f, i, i2, strZzj, zzfcwVar.zzq, insets);
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 7;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return zzgdn.zzm(this.zza.zzb(), new zzfve() { // from class: com.google.android.gms.internal.ads.zzemp
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                return zzemq.zzc(this.zza, (zzeul) obj);
            }
        }, zzcaf.zzg);
    }
}
