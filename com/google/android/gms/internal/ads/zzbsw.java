package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.nativead.NativeAd;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbsw extends NativeAd.AdChoicesInfo {
    private final List zza = new ArrayList();
    private String zzb;

    public zzbsw(zzbgi zzbgiVar) {
        try {
            this.zzb = zzbgiVar.zzg();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            this.zzb = "";
        }
        try {
            for (Object obj : zzbgiVar.zzh()) {
                zzbgp zzbgpVarZzh = obj instanceof IBinder ? zzbgo.zzh((IBinder) obj) : null;
                if (zzbgpVarZzh != null) {
                    this.zza.add(new zzbsy(zzbgpVarZzh));
                }
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e2);
        }
    }

    public final List<NativeAd.Image> getImages() {
        return this.zza;
    }

    public final CharSequence getText() {
        return this.zzb;
    }
}
