package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.auth.api.LNi.xPQrbOSWiEdU;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbsy extends NativeAd.Image {
    private final zzbgp zzb;
    private final Drawable zzc;
    private final Uri zzd;
    private final double zze;
    private final int zzf;
    private final int zzg;

    public final Drawable getDrawable() {
        return this.zzc;
    }

    public final double getScale() {
        return this.zze;
    }

    public final Uri getUri() {
        return this.zzd;
    }

    public final int zza() {
        return this.zzg;
    }

    public final int zzb() {
        return this.zzf;
    }

    public zzbsy(zzbgp zzbgpVar) {
        Drawable drawable;
        Uri uriZze;
        double dZzb;
        int iZzd;
        String str = xPQrbOSWiEdU.FnkGTQAvdlITH;
        this.zzb = zzbgpVar;
        Map mapZzg = null;
        try {
            IObjectWrapper iObjectWrapperZzf = zzbgpVar.zzf();
            drawable = iObjectWrapperZzf != null ? (Drawable) ObjectWrapper.unwrap(iObjectWrapperZzf) : null;
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh(str, e);
        }
        this.zzc = drawable;
        try {
            uriZze = this.zzb.zze();
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh(str, e2);
            uriZze = null;
        }
        this.zzd = uriZze;
        try {
            dZzb = this.zzb.zzb();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh(str, e3);
            dZzb = 1.0d;
        }
        this.zze = dZzb;
        int iZzc = -1;
        try {
            iZzd = this.zzb.zzd();
        } catch (RemoteException e4) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh(str, e4);
            iZzd = -1;
        }
        this.zzf = iZzd;
        try {
            iZzc = this.zzb.zzc();
        } catch (RemoteException e5) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh(str, e5);
        }
        this.zzg = iZzc;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzek)).booleanValue()) {
            try {
                mapZzg = this.zzb.zzg();
            } catch (RemoteException unused) {
            }
        }
        this.zza = mapZzg;
    }
}
