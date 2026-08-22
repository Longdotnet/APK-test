package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public final class zzdib extends zzbgl {
    private final zzdit zza;
    private IObjectWrapper zzb;

    public zzdib(zzdit zzditVar) {
        this.zza = zzditVar;
    }

    private static float zzb(IObjectWrapper iObjectWrapper) {
        Drawable drawable;
        if (iObjectWrapper == null || (drawable = (Drawable) ObjectWrapper.unwrap(iObjectWrapper)) == null || drawable.getIntrinsicWidth() == -1 || drawable.getIntrinsicHeight() == -1) {
            return 0.0f;
        }
        return drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final float zze() {
        zzdit zzditVar = this.zza;
        if (zzditVar.zzb() != 0.0f) {
            return zzditVar.zzb();
        }
        if (zzditVar.zzj() != null) {
            try {
                return zzditVar.zzj().zze();
            } catch (RemoteException e) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Remote exception getting video controller aspect ratio.", e);
                return 0.0f;
            }
        }
        IObjectWrapper iObjectWrapper = this.zzb;
        if (iObjectWrapper != null) {
            return zzb(iObjectWrapper);
        }
        zzbgp zzbgpVarZzm = zzditVar.zzm();
        if (zzbgpVarZzm == null) {
            return 0.0f;
        }
        float fZzd = (zzbgpVarZzm.zzd() == -1 || zzbgpVarZzm.zzc() == -1) ? 0.0f : zzbgpVarZzm.zzd() / zzbgpVarZzm.zzc();
        return fZzd == 0.0f ? zzb(zzbgpVarZzm.zzf()) : fZzd;
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final float zzf() {
        zzdit zzditVar = this.zza;
        if (zzditVar.zzj() != null) {
            return zzditVar.zzj().zzf();
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final float zzg() {
        zzdit zzditVar = this.zza;
        if (zzditVar.zzj() != null) {
            return zzditVar.zzj().zzg();
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final com.google.android.gms.ads.internal.client.zzed zzh() {
        return this.zza.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final IObjectWrapper zzi() {
        IObjectWrapper iObjectWrapper = this.zzb;
        if (iObjectWrapper != null) {
            return iObjectWrapper;
        }
        zzbgp zzbgpVarZzm = this.zza.zzm();
        if (zzbgpVarZzm == null) {
            return null;
        }
        return zzbgpVarZzm.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final void zzj(IObjectWrapper iObjectWrapper) {
        this.zzb = iObjectWrapper;
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final boolean zzk() {
        return this.zza.zzaf();
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final boolean zzl() {
        return this.zza.zzj() != null;
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final void zzm(zzbhx zzbhxVar) {
        zzdit zzditVar = this.zza;
        if (zzditVar.zzj() instanceof zzcgi) {
            ((zzcgi) zzditVar.zzj()).zzv(zzbhxVar);
        }
    }
}
