package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzbgc extends zzbgo {
    private final Drawable zza;
    private final Uri zzb;
    private final double zzc;
    private final int zzd;
    private final int zze;
    private final Map zzf;

    public zzbgc(Drawable drawable, Uri uri, double d, int i, int i2, Map map) {
        this.zza = drawable;
        this.zzb = uri;
        this.zzc = d;
        this.zzd = i;
        this.zze = i2;
        this.zzf = map;
    }

    @Override // com.google.android.gms.internal.ads.zzbgp
    public final double zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzbgp
    public final int zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzbgp
    public final int zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzbgp
    public final Uri zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbgp
    public final IObjectWrapper zzf() {
        return new ObjectWrapper(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbgp
    public final Map zzg() {
        return this.zzf;
    }
}
