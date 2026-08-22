package com.google.android.gms.ads.internal.overlay;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

/* JADX INFO: loaded from: classes.dex */
public final class zzu extends FrameLayout implements View.OnClickListener {
    public final ImageButton zza;
    public final zzm zzb;

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0062, code lost:
    
        r0 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzu(android.content.Context r7, com.google.android.gms.ads.internal.overlay.zzt r8, com.google.android.gms.ads.internal.overlay.zzm r9) {
        /*
            Method dump skipped, instruction units count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzu.<init>(android.content.Context, com.google.android.gms.ads.internal.overlay.zzt, com.google.android.gms.ads.internal.overlay.zzm):void");
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        zzm zzmVar = this.zzb;
        if (zzmVar != null) {
            zzmVar.zzn = 2;
            zzmVar.zzb.finish();
        }
    }
}
