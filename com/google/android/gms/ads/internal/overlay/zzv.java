package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zze;

/* JADX INFO: loaded from: classes.dex */
public final class zzv extends zzm {
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ zzv(Activity activity, int i) {
        super(activity);
        this.$r8$classId = i;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzm, com.google.android.gms.internal.ads.zzbtq
    public void zzl(Bundle bundle) {
        switch (this.$r8$classId) {
            case 4:
                zze.zza("AdOverlayParcel is null or does not contain valid overlay type.");
                this.zzn = 4;
                this.zzb.finish();
                break;
            default:
                super.zzl(bundle);
                break;
        }
    }
}
