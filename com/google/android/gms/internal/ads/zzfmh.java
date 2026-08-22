package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class zzfmh extends zzfmk {
    private static final zzfmh zzb = new zzfmh();

    private zzfmh() {
    }

    public static zzfmh zza() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfmk
    public final void zzb(boolean z) {
        Iterator it = zzfmi.zza().zzc().iterator();
        while (it.hasNext()) {
            ((zzflp) it.next()).zzg().zzk(z);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfmk
    public final boolean zzc() {
        Iterator it = zzfmi.zza().zzb().iterator();
        while (it.hasNext()) {
            View viewZzf = ((zzflp) it.next()).zzf();
            if (viewZzf != null && viewZzf.hasWindowFocus()) {
                return true;
            }
        }
        return false;
    }
}
