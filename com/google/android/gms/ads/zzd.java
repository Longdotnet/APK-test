package com.google.android.gms.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbx;
import com.google.android.gms.ads.internal.client.zzen;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import com.google.android.gms.internal.ads.zzbun;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class zzd implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ BaseAdView zza;

    public /* synthetic */ zzd(BaseAdView baseAdView, int i) {
        this.$r8$classId = i;
        this.zza = baseAdView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                BaseAdView baseAdView = this.zza;
                try {
                    zzen zzenVar = baseAdView.zza;
                    zzenVar.getClass();
                    try {
                        zzbx zzbxVar = zzenVar.zzj;
                        if (zzbxVar != null) {
                            zzbxVar.zzC();
                        }
                    } catch (RemoteException e) {
                        zzo.zzl(oKjScaD.cvDOTshBNglmVjh, e);
                        return;
                    }
                } catch (IllegalStateException e2) {
                    zzbun.zza(baseAdView.getContext()).zzh(e2, "BaseAdView.resume");
                    return;
                }
                zzbun.zza(baseAdView.getContext()).zzh(e2, "BaseAdView.resume");
                break;
            case 1:
                BaseAdView baseAdView2 = this.zza;
                try {
                    zzen zzenVar2 = baseAdView2.zza;
                    zzenVar2.getClass();
                    try {
                        zzbx zzbxVar2 = zzenVar2.zzj;
                        if (zzbxVar2 != null) {
                            zzbxVar2.zzy();
                        }
                    } catch (RemoteException e3) {
                        zzo.zzl("#007 Could not call remote method.", e3);
                    }
                } catch (IllegalStateException e4) {
                    zzbun.zza(baseAdView2.getContext()).zzh(e4, "BaseAdView.destroy");
                    return;
                }
                break;
            default:
                BaseAdView baseAdView3 = this.zza;
                try {
                    zzen zzenVar3 = baseAdView3.zza;
                    zzenVar3.getClass();
                    try {
                        zzbx zzbxVar3 = zzenVar3.zzj;
                        if (zzbxVar3 != null) {
                            zzbxVar3.zzA();
                        }
                    } catch (RemoteException e5) {
                        zzo.zzl("#007 Could not call remote method.", e5);
                        return;
                    }
                } catch (IllegalStateException e6) {
                    zzbun.zza(baseAdView3.getContext()).zzh(e6, "BaseAdView.pause");
                }
                zzbun.zza(baseAdView3.getContext()).zzh(e6, "BaseAdView.pause");
                break;
        }
    }
}
