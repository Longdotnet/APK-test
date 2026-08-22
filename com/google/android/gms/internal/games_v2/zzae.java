package com.google.android.gms.internal.games_v2;

import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.common.stats.ZnFR.FKidOcdAYt;

/* JADX INFO: loaded from: classes2.dex */
public final class zzae {
    public final int zzb;
    public int zzc = -1;
    public int zzd = 0;
    public int zze = 0;
    public int zzf = 0;
    public int zzg = 0;
    public IBinder zza = null;

    public zzae(int i, IBinder iBinder) {
        this.zzb = i;
    }

    public final Bundle zza() {
        Bundle bundle = new Bundle();
        bundle.putInt(FKidOcdAYt.UIIdbCkL, this.zzb);
        bundle.putInt("popupLocationInfo.displayId", this.zzc);
        bundle.putInt("popupLocationInfo.left", this.zzd);
        bundle.putInt("popupLocationInfo.top", this.zze);
        bundle.putInt("popupLocationInfo.right", this.zzf);
        bundle.putInt("popupLocationInfo.bottom", this.zzg);
        return bundle;
    }
}
