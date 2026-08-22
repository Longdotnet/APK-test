package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.util.zzau;

/* JADX INFO: loaded from: classes.dex */
public final class zzh extends RelativeLayout {
    public final zzau zza;
    public boolean zzb;

    public zzh(Context context, String str, String str2, String str3) {
        super(context);
        zzau zzauVar = new zzau(context);
        zzauVar.zzc = str;
        this.zza = zzauVar;
        zzauVar.zze = str2;
        zzauVar.zzd = str3;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.zzb) {
            return false;
        }
        this.zza.zzm(motionEvent);
        return false;
    }
}
