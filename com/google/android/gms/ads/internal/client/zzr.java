package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.loader.app.gv.DYYbQc;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes2.dex */
public final class zzr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzr> CREATOR = new com.google.android.gms.appset.zzb(19);
    public final String zza;
    public final int zzb;
    public final int zzc;
    public final boolean zzd;
    public final int zze;
    public final int zzf;
    public final zzr[] zzg;
    public final boolean zzh;
    public final boolean zzi;
    public boolean zzj;
    public final boolean zzk;
    public final boolean zzl;
    public final boolean zzm;
    public final boolean zzn;
    public final boolean zzo;

    /* JADX WARN: Code duplicated, block: B:41:0x00d2  */
    public zzr(Context context, AdSize[] adSizeArr) {
        int i;
        int i2;
        String str;
        int dimensionPixelSize;
        AdSize adSize = adSizeArr[0];
        this.zzd = false;
        int i3 = adSize.zzb;
        int i4 = adSize.zzc;
        boolean z = i3 == -3 && i4 == -4;
        this.zzi = z;
        this.zzm = adSize.zze;
        boolean z2 = adSize.zzf;
        this.zzn = z2;
        boolean z3 = adSize.zzh;
        this.zzo = z3;
        if (z) {
            AdSize adSize2 = AdSize.BANNER;
            this.zze = adSize2.zzb;
            i4 = adSize2.zzc;
            this.zzb = i4;
        } else if (z2) {
            this.zze = i3;
            i4 = adSize.zzg;
            this.zzb = i4;
        } else if (z3) {
            this.zze = i3;
            i4 = adSize.zzi;
            this.zzb = i4;
        } else {
            this.zze = i3;
            this.zzb = i4;
        }
        boolean z4 = this.zze == -1;
        boolean z5 = i4 == -2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (z4) {
            zzf zzfVar = zzbb.zzb.zzc;
            if (context.getResources().getConfiguration().orientation != 2) {
                dimensionPixelSize = displayMetrics.widthPixels;
                this.zzf = dimensionPixelSize;
            } else {
                DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
                if (((int) (displayMetrics2.heightPixels / displayMetrics2.density)) < 600) {
                    DisplayMetrics displayMetrics3 = context.getResources().getDisplayMetrics();
                    WindowManager windowManager = (WindowManager) context.getSystemService("window");
                    if (windowManager != null) {
                        Display defaultDisplay = windowManager.getDefaultDisplay();
                        defaultDisplay.getRealMetrics(displayMetrics3);
                        int i5 = displayMetrics3.heightPixels;
                        int i6 = displayMetrics3.widthPixels;
                        defaultDisplay.getMetrics(displayMetrics3);
                        int i7 = displayMetrics3.heightPixels;
                        int i8 = displayMetrics3.widthPixels;
                        if (i7 == i5 && i8 == i6) {
                            int i9 = displayMetrics.widthPixels;
                            int identifier = context.getResources().getIdentifier("navigation_bar_width", "dimen", "android");
                            dimensionPixelSize = i9 - (identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0);
                            this.zzf = dimensionPixelSize;
                        } else {
                            dimensionPixelSize = displayMetrics.widthPixels;
                            this.zzf = dimensionPixelSize;
                        }
                    } else {
                        dimensionPixelSize = displayMetrics.widthPixels;
                        this.zzf = dimensionPixelSize;
                    }
                } else {
                    dimensionPixelSize = displayMetrics.widthPixels;
                    this.zzf = dimensionPixelSize;
                }
            }
            double d = dimensionPixelSize / displayMetrics.density;
            i = (int) d;
            if (d - ((double) i) >= 0.01d) {
                i++;
            }
        } else {
            i = this.zze;
            zzf zzfVar2 = zzbb.zzb.zzc;
            this.zzf = zzf.zzu(displayMetrics, i);
        }
        if (z5) {
            int i10 = (int) (displayMetrics.heightPixels / displayMetrics.density);
            i2 = i10 <= 400 ? 32 : i10 <= 720 ? 50 : 90;
        } else {
            i2 = this.zzb;
        }
        zzf zzfVar3 = zzbb.zzb.zzc;
        this.zzc = zzf.zzu(displayMetrics, i2);
        if (z4 || z5) {
            this.zza = i + "x" + i2 + "_as";
        } else {
            if (z2 || z3) {
                str = this.zze + "x" + this.zzb + "_as";
            } else if (z) {
                str = DYYbQc.DMAAgkCnD;
            } else {
                this.zza = adSize.zzd;
            }
            this.zza = str;
        }
        int length = adSizeArr.length;
        if (length > 1) {
            this.zzg = new zzr[length];
            for (int i11 = 0; i11 < adSizeArr.length; i11++) {
                this.zzg[i11] = new zzr(context, adSizeArr[i11]);
            }
        } else {
            this.zzg = null;
        }
        this.zzh = false;
        this.zzj = false;
    }

    public static zzr zzb() {
        return new zzr("interstitial_mb", 0, 0, false, 0, 0, null, false, false, false, false, true, false, false, false);
    }

    public static zzr zzc() {
        return new zzr("320x50_mb", 0, 0, false, 0, 0, null, true, false, false, false, false, false, false, false);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 2, this.zza, false);
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(this.zzb);
        CloseableKt.zzc(parcel, 4, 4);
        parcel.writeInt(this.zzc);
        CloseableKt.zzc(parcel, 5, 4);
        parcel.writeInt(this.zzd ? 1 : 0);
        CloseableKt.zzc(parcel, 6, 4);
        parcel.writeInt(this.zze);
        CloseableKt.zzc(parcel, 7, 4);
        parcel.writeInt(this.zzf);
        CloseableKt.writeTypedArray(parcel, 8, this.zzg, i);
        CloseableKt.zzc(parcel, 9, 4);
        parcel.writeInt(this.zzh ? 1 : 0);
        CloseableKt.zzc(parcel, 10, 4);
        parcel.writeInt(this.zzi ? 1 : 0);
        boolean z = this.zzj;
        CloseableKt.zzc(parcel, 11, 4);
        parcel.writeInt(z ? 1 : 0);
        CloseableKt.zzc(parcel, 12, 4);
        parcel.writeInt(this.zzk ? 1 : 0);
        CloseableKt.zzc(parcel, 13, 4);
        parcel.writeInt(this.zzl ? 1 : 0);
        CloseableKt.zzc(parcel, 14, 4);
        parcel.writeInt(this.zzm ? 1 : 0);
        CloseableKt.zzc(parcel, 15, 4);
        parcel.writeInt(this.zzn ? 1 : 0);
        CloseableKt.zzc(parcel, 16, 4);
        parcel.writeInt(this.zzo ? 1 : 0);
        CloseableKt.zzb(parcel, iZza);
    }

    public zzr(String str, int i, int i2, boolean z, int i3, int i4, zzr[] zzrVarArr, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9) {
        this.zza = str;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = z;
        this.zze = i3;
        this.zzf = i4;
        this.zzg = zzrVarArr;
        this.zzh = z2;
        this.zzi = z3;
        this.zzj = z4;
        this.zzk = z5;
        this.zzl = z6;
        this.zzm = z7;
        this.zzn = z8;
        this.zzo = z9;
    }

    public zzr() {
        this("interstitial_mb", 0, 0, true, 0, 0, null, false, false, false, false, false, false, false, false);
    }

    public zzr(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }
}
