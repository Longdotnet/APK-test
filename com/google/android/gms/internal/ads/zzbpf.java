package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
public final class zzbpf {
    private final zzboi zza;
    private ListenableFuture zzb;

    public zzbpf(zzboi zzboiVar) {
        this.zza = zzboiVar;
    }

    private final void zzd() {
        if (this.zzb == null) {
            final zzcak zzcakVar = new zzcak();
            this.zzb = zzcakVar;
            this.zza.zzb(null).zzj(new zzcao() { // from class: com.google.android.gms.internal.ads.zzbpc
                @Override // com.google.android.gms.internal.ads.zzcao
                public final void zza(Object obj) {
                    zzcakVar.zzc((zzboj) obj);
                }
            }, new zzcam() { // from class: com.google.android.gms.internal.ads.zzbpd
                @Override // com.google.android.gms.internal.ads.zzcam
                public final void zza() {
                    zzcakVar.zzd(new zzbol("Cannot get Javascript Engine"));
                }
            });
        }
    }

    public final zzbpi zza(String str, zzbop zzbopVar, zzboo zzbooVar) {
        zzd();
        return new zzbpi(this.zzb, "google.afma.activeView.handleUpdate", zzbopVar, zzbooVar);
    }

    public final void zzb(final String str, final zzbkf zzbkfVar) {
        zzd();
        this.zzb = zzgdn.zzn(this.zzb, new zzgcu() { // from class: com.google.android.gms.internal.ads.zzbpe
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                zzboj zzbojVar = (zzboj) obj;
                zzbojVar.zzq(str, zzbkfVar);
                return zzgdn.zzh(zzbojVar);
            }
        }, zzcaf.zzg);
    }

    public final void zzc(final String str, final zzbkf zzbkfVar) {
        this.zzb = zzgdn.zzm(this.zzb, new zzfve() { // from class: com.google.android.gms.internal.ads.zzbpb
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                zzboj zzbojVar = (zzboj) obj;
                zzbojVar.zzr(str, zzbkfVar);
                return zzbojVar;
            }
        }, zzcaf.zzg);
    }
}
