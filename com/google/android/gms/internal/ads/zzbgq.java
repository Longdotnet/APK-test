package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd$Image;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public final class zzbgq extends NativeAd$Image {
    private final zzbgp zza;
    private final Drawable zzb;
    private final Uri zzc;
    private final double zzd;
    private final int zze;
    private final int zzf;

    public zzbgq(zzbgp zzbgpVar) {
        Drawable drawable;
        double dZzb;
        int iZzd;
        this.zza = zzbgpVar;
        Uri uriZze = null;
        try {
            IObjectWrapper iObjectWrapperZzf = zzbgpVar.zzf();
            drawable = iObjectWrapperZzf != null ? (Drawable) ObjectWrapper.unwrap(iObjectWrapperZzf) : null;
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
        this.zzb = drawable;
        try {
            uriZze = this.zza.zze();
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e2);
        }
        this.zzc = uriZze;
        try {
            dZzb = this.zza.zzb();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e3);
            dZzb = 1.0d;
        }
        this.zzd = dZzb;
        int iZzc = -1;
        try {
            iZzd = this.zza.zzd();
        } catch (RemoteException e4) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e4);
            iZzd = -1;
        }
        this.zze = iZzd;
        try {
            iZzc = this.zza.zzc();
        } catch (RemoteException e5) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e5);
        }
        this.zzf = iZzc;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd$Image
    public final Drawable getDrawable() {
        return this.zzb;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd$Image
    public final double getScale() {
        return this.zzd;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd$Image
    public final Uri getUri() {
        return this.zzc;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd$Image
    public final int zza() {
        return this.zzf;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd$Image
    public final int zzb() {
        return this.zze;
    }
}
