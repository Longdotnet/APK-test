package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd$Image;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbqx extends zzbqe {
    private final UnifiedNativeAdMapper zza;

    public zzbqx(UnifiedNativeAdMapper unifiedNativeAdMapper) {
        this.zza = unifiedNativeAdMapper;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final boolean zzA() {
        return this.zza.zzq;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final boolean zzB() {
        return this.zza.zzp;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final double zze() {
        Double d = this.zza.zzg;
        if (d != null) {
            return d.doubleValue();
        }
        return -1.0d;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final float zzf() {
        this.zza.getClass();
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final float zzg() {
        this.zza.getClass();
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final float zzh() {
        this.zza.getClass();
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final Bundle zzi() {
        return this.zza.zzo;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final com.google.android.gms.ads.internal.client.zzed zzj() {
        com.google.android.gms.ads.internal.client.zzed zzedVar;
        VideoController videoController = this.zza.zzj;
        if (videoController == null) {
            return null;
        }
        synchronized (videoController.zza) {
            zzedVar = videoController.zzb;
        }
        return zzedVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final zzbgi zzk() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final zzbgp zzl() {
        NativeAd$Image nativeAd$Image = this.zza.zzd;
        if (nativeAd$Image != null) {
            return new zzbgc(nativeAd$Image.getDrawable(), nativeAd$Image.getUri(), nativeAd$Image.getScale(), nativeAd$Image.zzb(), nativeAd$Image.zza(), null);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final IObjectWrapper zzm() {
        this.zza.getClass();
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final IObjectWrapper zzn() {
        this.zza.getClass();
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final IObjectWrapper zzo() {
        Object obj = this.zza.zzn;
        if (obj == null) {
            return null;
        }
        return new ObjectWrapper(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final String zzp() {
        return this.zza.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final String zzq() {
        return this.zza.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final String zzr() {
        return this.zza.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final String zzs() {
        return this.zza.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final String zzt() {
        return this.zza.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final String zzu() {
        return this.zza.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final List zzv() {
        List<NativeAd$Image> list = this.zza.zzb;
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (NativeAd$Image nativeAd$Image : list) {
                arrayList.add(new zzbgc(nativeAd$Image.getDrawable(), nativeAd$Image.getUri(), nativeAd$Image.getScale(), nativeAd$Image.zzb(), nativeAd$Image.zza(), null));
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final void zzw(IObjectWrapper iObjectWrapper) {
        this.zza.getClass();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final void zzx() {
        this.zza.getClass();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final void zzy(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
        ((com.google.ads.mediation.zza) this.zza).getClass();
        if (com.google.android.gms.ads.formats.zze.zza.get(view) != null) {
            throw new ClassCastException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final void zzz(IObjectWrapper iObjectWrapper) {
        this.zza.getClass();
    }
}
