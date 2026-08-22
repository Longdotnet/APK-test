package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import androidx.appcompat.widget.AppCompatTextHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzek {
    public final String zza;
    public final ArrayList zzb;
    public final Set zzc;
    public final Bundle zzd;
    public final String zze;
    public final String zzf;
    public final int zzg;
    public final Set zzh;
    public final Bundle zzi;
    public final Set zzj;
    public final boolean zzk;
    public final int zzm;
    public long zzn = 0;

    public zzek(AppCompatTextHelper appCompatTextHelper) {
        this.zza = (String) appCompatTextHelper.mDrawableEndTint;
        this.zzb = (ArrayList) appCompatTextHelper.mDrawableTint;
        this.zzc = Collections.unmodifiableSet((HashSet) appCompatTextHelper.mView);
        this.zzd = (Bundle) appCompatTextHelper.mDrawableLeftTint;
        Collections.unmodifiableMap((HashMap) appCompatTextHelper.mDrawableTopTint);
        this.zze = (String) appCompatTextHelper.mAutoSizeTextHelper;
        this.zzf = (String) appCompatTextHelper.mFontTypeface;
        this.zzg = appCompatTextHelper.mStyle;
        this.zzh = Collections.unmodifiableSet((HashSet) appCompatTextHelper.mDrawableRightTint);
        this.zzi = (Bundle) appCompatTextHelper.mDrawableBottomTint;
        this.zzj = Collections.unmodifiableSet((HashSet) appCompatTextHelper.mDrawableStartTint);
        this.zzk = appCompatTextHelper.mAsyncFontPending;
        this.zzm = appCompatTextHelper.mFontWeight;
    }
}
