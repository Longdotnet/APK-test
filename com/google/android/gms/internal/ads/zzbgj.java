package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd$Image;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbgj {
    private final zzbgi zza;
    private final List zzb = new ArrayList();
    private String zzc;

    public zzbgj(zzbgi zzbgiVar) {
        IBinder iBinder;
        this.zza = zzbgiVar;
        try {
            this.zzc = zzbgiVar.zzg();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            this.zzc = "";
        }
        try {
            for (Object obj : zzbgiVar.zzh()) {
                zzbgp zzbgnVar = null;
                if ((obj instanceof IBinder) && (iBinder = (IBinder) obj) != null) {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    zzbgnVar = iInterfaceQueryLocalInterface instanceof zzbgp ? (zzbgp) iInterfaceQueryLocalInterface : new zzbgn(iBinder);
                }
                if (zzbgnVar != null) {
                    this.zzb.add(new zzbgq(zzbgnVar));
                }
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e2);
        }
    }

    public final List<NativeAd$Image> getImages() {
        return this.zzb;
    }

    public final CharSequence getText() {
        return this.zzc;
    }
}
