package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzexy implements zzcwb, zzcxx, zzezo, com.google.android.gms.ads.internal.overlay.zzr, zzcyk, zzcwo, zzded {
    private final zzfef zza;
    private final AtomicReference zzb = new AtomicReference();
    private final AtomicReference zzc = new AtomicReference();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    private final AtomicReference zzf = new AtomicReference();
    private final AtomicReference zzg = new AtomicReference();
    private zzexy zzh = null;

    public zzexy(zzfef zzfefVar) {
        this.zza = zzfefVar;
    }

    public static zzexy zzi(zzexy zzexyVar) {
        zzexy zzexyVar2 = new zzexy(zzexyVar.zza);
        zzexyVar2.zzh = zzexyVar;
        return zzexyVar2;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzd() {
    }

    @Override // com.google.android.gms.internal.ads.zzcwb
    public final void zzdD(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzexy zzexyVar = this.zzh;
        if (zzexyVar != null) {
            zzexyVar.zzdD(zzeVar);
            return;
        }
        AtomicReference atomicReference = this.zzb;
        zzezf.zza(atomicReference, new zzeze() { // from class: com.google.android.gms.internal.ads.zzext
            @Override // com.google.android.gms.internal.ads.zzeze
            public final void zza(Object obj) {
                ((zzbaz) obj).zzc(zzeVar);
            }
        });
        zzezf.zza(atomicReference, new zzeze() { // from class: com.google.android.gms.internal.ads.zzexu
            @Override // com.google.android.gms.internal.ads.zzeze
            public final void zza(Object obj) {
                ((zzbaz) obj).zzb(zzeVar.zza);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzded
    public final void zzdH() {
    }

    @Override // com.google.android.gms.internal.ads.zzded
    public final void zzdf() {
        zzexy zzexyVar = this.zzh;
        if (zzexyVar != null) {
            zzexyVar.zzdf();
        } else {
            zzezf.zza(this.zzd, new zzeze() { // from class: com.google.android.gms.internal.ads.zzexp
                @Override // com.google.android.gms.internal.ads.zzeze
                public final void zza(Object obj) {
                    ((zzbbd) obj).zzb();
                }
            });
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdk() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzds() {
        zzexy zzexyVar = this.zzh;
        if (zzexyVar != null) {
            zzexyVar.zzds();
        } else {
            zzezf.zza(this.zzf, new zzeze() { // from class: com.google.android.gms.internal.ads.zzexm
                @Override // com.google.android.gms.internal.ads.zzeze
                public final void zza(Object obj) {
                    ((com.google.android.gms.ads.internal.overlay.zzr) obj).zzds();
                }
            });
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdt() {
        zzexy zzexyVar = this.zzh;
        if (zzexyVar != null) {
            zzexyVar.zzdt();
            return;
        }
        zzezf.zza(this.zzf, new zzeze() { // from class: com.google.android.gms.internal.ads.zzexx
            @Override // com.google.android.gms.internal.ads.zzeze
            public final void zza(Object obj) {
                ((com.google.android.gms.ads.internal.overlay.zzr) obj).zzdt();
            }
        });
        AtomicReference atomicReference = this.zzd;
        zzezf.zza(atomicReference, new zzeze() { // from class: com.google.android.gms.internal.ads.zzexk
            @Override // com.google.android.gms.internal.ads.zzeze
            public final void zza(Object obj) {
                ((zzbbd) obj).zzf();
            }
        });
        zzezf.zza(atomicReference, new zzeze() { // from class: com.google.android.gms.internal.ads.zzexl
            @Override // com.google.android.gms.internal.ads.zzeze
            public final void zza(Object obj) {
                ((zzbbd) obj).zze();
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdv() {
        zzexy zzexyVar = this.zzh;
        if (zzexyVar != null) {
            zzexyVar.zzdv();
        } else {
            zzezf.zza(this.zzf, new zzeze() { // from class: com.google.android.gms.internal.ads.zzexw
                @Override // com.google.android.gms.internal.ads.zzeze
                public final void zza(Object obj) {
                    ((com.google.android.gms.ads.internal.overlay.zzr) obj).zzdv();
                }
            });
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdw(final int i) {
        zzexy zzexyVar = this.zzh;
        if (zzexyVar != null) {
            zzexyVar.zzdw(i);
        } else {
            zzezf.zza(this.zzf, new zzeze() { // from class: com.google.android.gms.internal.ads.zzexs
                @Override // com.google.android.gms.internal.ads.zzeze
                public final void zza(Object obj) {
                    ((com.google.android.gms.ads.internal.overlay.zzr) obj).zzdw(i);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcxx
    public final void zzg() {
        zzexy zzexyVar = this.zzh;
        if (zzexyVar != null) {
            zzexyVar.zzg();
        } else {
            zzezf.zza(this.zze, new zzeze() { // from class: com.google.android.gms.internal.ads.zzexv
                @Override // com.google.android.gms.internal.ads.zzeze
                public final void zza(Object obj) {
                    ((zzcxx) obj).zzg();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcyk
    public final void zzh(final com.google.android.gms.ads.internal.client.zzt zztVar) {
        zzexy zzexyVar = this.zzh;
        if (zzexyVar != null) {
            zzexyVar.zzh(zztVar);
        } else {
            zzezf.zza(this.zzg, new zzeze() { // from class: com.google.android.gms.internal.ads.zzexj
                @Override // com.google.android.gms.internal.ads.zzeze
                public final void zza(Object obj) {
                    ((com.google.android.gms.ads.internal.client.zzdt) obj).zze(zztVar);
                }
            });
        }
    }

    public final void zzj() {
        zzexy zzexyVar = this.zzh;
        if (zzexyVar != null) {
            zzexyVar.zzj();
            return;
        }
        this.zza.zza();
        zzezf.zza(this.zzc, new zzeze() { // from class: com.google.android.gms.internal.ads.zzexq
            @Override // com.google.android.gms.internal.ads.zzeze
            public final void zza(Object obj) {
                ((zzbba) obj).zza();
            }
        });
        zzezf.zza(this.zzd, new zzeze() { // from class: com.google.android.gms.internal.ads.zzexr
            @Override // com.google.android.gms.internal.ads.zzeze
            public final void zza(Object obj) {
                ((zzbbd) obj).zzc();
            }
        });
    }

    public final void zzk(final zzbaw zzbawVar) {
        zzexy zzexyVar = this.zzh;
        if (zzexyVar != null) {
            zzexyVar.zzk(zzbawVar);
        } else {
            zzezf.zza(this.zzb, new zzeze() { // from class: com.google.android.gms.internal.ads.zzexo
                @Override // com.google.android.gms.internal.ads.zzeze
                public final void zza(Object obj) {
                    ((zzbaz) obj).zzd(zzbawVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzezo
    public final void zzl(zzezo zzezoVar) {
        this.zzh = (zzexy) zzezoVar;
    }

    public final void zzm(com.google.android.gms.ads.internal.overlay.zzr zzrVar) {
        this.zzf.set(zzrVar);
    }

    public final void zzn(com.google.android.gms.ads.internal.client.zzdt zzdtVar) {
        this.zzg.set(zzdtVar);
    }

    public final void zzo(zzbaz zzbazVar) {
        this.zzb.set(zzbazVar);
    }

    public final void zzp(zzbbd zzbbdVar) {
        this.zzd.set(zzbbdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcwo
    public final void zzs(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzexy zzexyVar = this.zzh;
        if (zzexyVar != null) {
            zzexyVar.zzs(zzeVar);
        } else {
            zzezf.zza(this.zzd, new zzeze() { // from class: com.google.android.gms.internal.ads.zzexn
                @Override // com.google.android.gms.internal.ads.zzeze
                public final void zza(Object obj) {
                    ((zzbbd) obj).zzd(zzeVar);
                }
            });
        }
    }
}
