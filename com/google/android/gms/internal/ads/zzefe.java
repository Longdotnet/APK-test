package com.google.android.gms.internal.ads;

import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzefe extends zzbwm implements zzcxi {
    private zzbwn zza;
    private zzcxh zzb;
    private zzdeo zzc;

    @Override // com.google.android.gms.internal.ads.zzcxi
    public final synchronized void zza(zzcxh zzcxhVar) {
        this.zzb = zzcxhVar;
    }

    public final synchronized void zzc(zzbwn zzbwnVar) {
        this.zza = zzbwnVar;
    }

    public final synchronized void zzd(zzdeo zzdeoVar) {
        this.zzc = zzdeoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final synchronized void zze(IObjectWrapper iObjectWrapper) {
        zzbwn zzbwnVar = this.zza;
        if (zzbwnVar != null) {
            ((zzeij) zzbwnVar).zzb.onAdClicked();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final synchronized void zzf(IObjectWrapper iObjectWrapper) {
        zzbwn zzbwnVar = this.zza;
        if (zzbwnVar != null) {
            zzbwnVar.zzf(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final synchronized void zzg(IObjectWrapper iObjectWrapper, int i) {
        zzcxh zzcxhVar = this.zzb;
        if (zzcxhVar != null) {
            zzcxhVar.zza(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final synchronized void zzh(IObjectWrapper iObjectWrapper) {
        zzbwn zzbwnVar = this.zza;
        if (zzbwnVar != null) {
            ((zzeij) zzbwnVar).zzc.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final synchronized void zzi(IObjectWrapper iObjectWrapper) {
        zzcxh zzcxhVar = this.zzb;
        if (zzcxhVar != null) {
            zzcxhVar.zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final synchronized void zzj(IObjectWrapper iObjectWrapper) {
        zzbwn zzbwnVar = this.zza;
        if (zzbwnVar != null) {
            ((zzeij) zzbwnVar).zza.zzdt();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final synchronized void zzk(IObjectWrapper iObjectWrapper, int i) {
        zzdeo zzdeoVar = this.zzc;
        if (zzdeoVar != null) {
            zzedp zzedpVar = ((zzeih) zzdeoVar).zzc;
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Fail to initialize adapter ".concat(String.valueOf(zzedpVar.zza)));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final synchronized void zzl(IObjectWrapper iObjectWrapper) {
        zzdeo zzdeoVar = this.zzc;
        if (zzdeoVar != null) {
            Executor executor = ((zzeih) zzdeoVar).zzd.zzb;
            final zzedp zzedpVar = ((zzeih) zzdeoVar).zzc;
            final zzfca zzfcaVar = ((zzeih) zzdeoVar).zzb;
            final zzfcn zzfcnVar = ((zzeih) zzdeoVar).zza;
            final zzeih zzeihVar = (zzeih) zzdeoVar;
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeig
                @Override // java.lang.Runnable
                public final void run() {
                    zzeik zzeikVar = zzeihVar.zzd;
                    zzeik.zze(zzfcnVar, zzfcaVar, zzedpVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final synchronized void zzm(IObjectWrapper iObjectWrapper, zzbwo zzbwoVar) {
        zzbwn zzbwnVar = this.zza;
        if (zzbwnVar != null) {
            ((zzeij) zzbwnVar).zzd.zza(zzbwoVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final synchronized void zzn(IObjectWrapper iObjectWrapper) {
        zzbwn zzbwnVar = this.zza;
        if (zzbwnVar != null) {
            ((zzeij) zzbwnVar).zzd.zza(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final synchronized void zzo(IObjectWrapper iObjectWrapper) {
        zzbwn zzbwnVar = this.zza;
        if (zzbwnVar != null) {
            ((zzeij) zzbwnVar).zzc.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final synchronized void zzp(IObjectWrapper iObjectWrapper) {
        zzbwn zzbwnVar = this.zza;
        if (zzbwnVar != null) {
            ((zzeij) zzbwnVar).zzd.zzc();
        }
    }
}
