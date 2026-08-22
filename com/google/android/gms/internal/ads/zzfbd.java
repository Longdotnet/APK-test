package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzfbd implements OnAdMetadataChangedListener, zzcxm, zzcwb, zzcvy, zzcwo, zzcyk, zzezo, zzded {
    private final zzfef zza;
    private final AtomicReference zzb = new AtomicReference();
    private final AtomicReference zzc = new AtomicReference();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    private final AtomicReference zzf = new AtomicReference();
    private final AtomicReference zzg = new AtomicReference();
    private final AtomicReference zzh = new AtomicReference();
    private zzfbd zzi = null;

    public zzfbd(zzfef zzfefVar) {
        this.zza = zzfefVar;
    }

    @Override // com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener
    public final void onAdMetadataChanged() {
        zzfbd zzfbdVar = this.zzi;
        if (zzfbdVar != null) {
            zzfbdVar.onAdMetadataChanged();
        } else {
            zzezf.zza(this.zzb, new zzeze() { // from class: com.google.android.gms.internal.ads.zzfar
                @Override // com.google.android.gms.internal.ads.zzeze
                public final void zza(Object obj) {
                    ((OnAdMetadataChangedListener) obj).onAdMetadataChanged();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcvy
    public final void zza() {
        zzfbd zzfbdVar = this.zzi;
        if (zzfbdVar != null) {
            zzfbdVar.zza();
            return;
        }
        this.zza.zza();
        zzezf.zza(this.zzd, new zzeze() { // from class: com.google.android.gms.internal.ads.zzfaz
            @Override // com.google.android.gms.internal.ads.zzeze
            public final void zza(Object obj) {
                ((zzbwy) obj).zzg();
            }
        });
        zzezf.zza(this.zze, new zzeze() { // from class: com.google.android.gms.internal.ads.zzfba
            @Override // com.google.android.gms.internal.ads.zzeze
            public final void zza(Object obj) {
                ((zzbwi) obj).zzf();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvy
    public final void zzb() {
        zzfbd zzfbdVar = this.zzi;
        if (zzfbdVar != null) {
            zzfbdVar.zzb();
        } else {
            zzezf.zza(this.zze, new zzeze() { // from class: com.google.android.gms.internal.ads.zzfbb
                @Override // com.google.android.gms.internal.ads.zzeze
                public final void zza(Object obj) {
                    ((zzbwi) obj).zzh();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcvy
    public final void zzc() {
        zzfbd zzfbdVar = this.zzi;
        if (zzfbdVar != null) {
            zzfbdVar.zzc();
            return;
        }
        AtomicReference atomicReference = this.zzd;
        zzezf.zza(atomicReference, new zzeze() { // from class: com.google.android.gms.internal.ads.zzfal
            @Override // com.google.android.gms.internal.ads.zzeze
            public final void zza(Object obj) {
                ((zzbwy) obj).zzj();
            }
        });
        zzezf.zza(this.zze, new zzeze() { // from class: com.google.android.gms.internal.ads.zzfam
            @Override // com.google.android.gms.internal.ads.zzeze
            public final void zza(Object obj) {
                ((zzbwi) obj).zzj();
            }
        });
        zzezf.zza(atomicReference, new zzeze() { // from class: com.google.android.gms.internal.ads.zzfan
            @Override // com.google.android.gms.internal.ads.zzeze
            public final void zza(Object obj) {
                ((zzbwy) obj).zzf();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcwb
    public final void zzdD(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzfbd zzfbdVar = this.zzi;
        if (zzfbdVar != null) {
            zzfbdVar.zzdD(zzeVar);
            return;
        }
        final int i = zzeVar.zza;
        AtomicReference atomicReference = this.zzc;
        zzezf.zza(atomicReference, new zzeze() { // from class: com.google.android.gms.internal.ads.zzfaw
            @Override // com.google.android.gms.internal.ads.zzeze
            public final void zza(Object obj) {
                ((zzbxc) obj).zzf(zzeVar);
            }
        });
        zzezf.zza(atomicReference, new zzeze() { // from class: com.google.android.gms.internal.ads.zzfax
            @Override // com.google.android.gms.internal.ads.zzeze
            public final void zza(Object obj) {
                ((zzbxc) obj).zze(i);
            }
        });
        zzezf.zza(this.zze, new zzeze() { // from class: com.google.android.gms.internal.ads.zzfay
            @Override // com.google.android.gms.internal.ads.zzeze
            public final void zza(Object obj) {
                ((zzbwi) obj).zzg(i);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzded
    public final void zzdH() {
    }

    @Override // com.google.android.gms.internal.ads.zzded
    public final void zzdf() {
        zzfbd zzfbdVar = this.zzi;
        if (zzfbdVar != null) {
            zzfbdVar.zzdf();
        } else {
            zzezf.zza(this.zzd, new zzeze() { // from class: com.google.android.gms.internal.ads.zzfas
                @Override // com.google.android.gms.internal.ads.zzeze
                public final void zza(Object obj) {
                    ((zzbwy) obj).zze();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcvy
    public final void zzdu(final zzbwc zzbwcVar, final String str, final String str2) {
        zzfbd zzfbdVar = this.zzi;
        if (zzfbdVar != null) {
            zzfbdVar.zzdu(zzbwcVar, str, str2);
            return;
        }
        zzezf.zza(this.zzd, new zzeze() { // from class: com.google.android.gms.internal.ads.zzfbc
            @Override // com.google.android.gms.internal.ads.zzeze
            public final void zza(Object obj) {
                zzbwc zzbwcVar2 = zzbwcVar;
                ((zzbwy) obj).zzk(new zzbxm(zzbwcVar2.zzc(), zzbwcVar2.zzb()));
            }
        });
        zzezf.zza(this.zzf, new zzeze() { // from class: com.google.android.gms.internal.ads.zzfai
            @Override // com.google.android.gms.internal.ads.zzeze
            public final void zza(Object obj) {
                zzbwc zzbwcVar2 = zzbwcVar;
                ((zzbxd) obj).zze(new zzbxm(zzbwcVar2.zzc(), zzbwcVar2.zzb()), str, str2);
            }
        });
        zzezf.zza(this.zze, new zzeze() { // from class: com.google.android.gms.internal.ads.zzfaj
            @Override // com.google.android.gms.internal.ads.zzeze
            public final void zza(Object obj) {
                ((zzbwi) obj).zze(zzbwcVar);
            }
        });
        zzezf.zza(this.zzg, new zzeze() { // from class: com.google.android.gms.internal.ads.zzfak
            @Override // com.google.android.gms.internal.ads.zzeze
            public final void zza(Object obj) {
                ((zzbwd) obj).zze(zzbwcVar, str, str2);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvy
    public final void zze() {
        zzfbd zzfbdVar = this.zzi;
        if (zzfbdVar != null) {
            zzfbdVar.zze();
        } else {
            zzezf.zza(this.zze, new zzeze() { // from class: com.google.android.gms.internal.ads.zzfav
                @Override // com.google.android.gms.internal.ads.zzeze
                public final void zza(Object obj) {
                    ((zzbwi) obj).zzk();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcvy
    public final void zzf() {
        zzfbd zzfbdVar = this.zzi;
        if (zzfbdVar != null) {
            zzfbdVar.zzf();
        } else {
            zzezf.zza(this.zze, new zzeze() { // from class: com.google.android.gms.internal.ads.zzfah
                @Override // com.google.android.gms.internal.ads.zzeze
                public final void zza(Object obj) {
                    ((zzbwi) obj).zzl();
                }
            });
        }
    }

    public final void zzg(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.zzb.set(onAdMetadataChangedListener);
    }

    @Override // com.google.android.gms.internal.ads.zzcyk
    public final void zzh(final com.google.android.gms.ads.internal.client.zzt zztVar) {
        zzfbd zzfbdVar = this.zzi;
        if (zzfbdVar != null) {
            zzfbdVar.zzh(zztVar);
        } else {
            zzezf.zza(this.zzh, new zzeze() { // from class: com.google.android.gms.internal.ads.zzfao
                @Override // com.google.android.gms.internal.ads.zzeze
                public final void zza(Object obj) {
                    ((com.google.android.gms.ads.internal.client.zzdt) obj).zze(zztVar);
                }
            });
        }
    }

    public final void zzi(com.google.android.gms.ads.internal.client.zzdt zzdtVar) {
        this.zzh.set(zzdtVar);
    }

    public final void zzj(zzbwy zzbwyVar) {
        this.zzd.set(zzbwyVar);
    }

    public final void zzk(zzbxc zzbxcVar) {
        this.zzc.set(zzbxcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzezo
    public final void zzl(zzezo zzezoVar) {
        this.zzi = (zzfbd) zzezoVar;
    }

    @Deprecated
    public final void zzm(zzbwi zzbwiVar) {
        this.zze.set(zzbwiVar);
    }

    @Deprecated
    public final void zzn(zzbwd zzbwdVar) {
        this.zzg.set(zzbwdVar);
    }

    public final void zzo(zzbxd zzbxdVar) {
        this.zzf.set(zzbxdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcwo
    public final void zzs(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzfbd zzfbdVar = this.zzi;
        if (zzfbdVar != null) {
            zzfbdVar.zzs(zzeVar);
            return;
        }
        AtomicReference atomicReference = this.zzd;
        zzezf.zza(atomicReference, new zzeze() { // from class: com.google.android.gms.internal.ads.zzfat
            @Override // com.google.android.gms.internal.ads.zzeze
            public final void zza(Object obj) {
                ((zzbwy) obj).zzi(zzeVar);
            }
        });
        zzezf.zza(atomicReference, new zzeze() { // from class: com.google.android.gms.internal.ads.zzfau
            @Override // com.google.android.gms.internal.ads.zzeze
            public final void zza(Object obj) {
                ((zzbwy) obj).zzh(zzeVar.zza);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcxm
    public final void zzu() {
        zzfbd zzfbdVar = this.zzi;
        if (zzfbdVar != null) {
            zzfbdVar.zzu();
        } else {
            zzezf.zza(this.zzc, new zzeze() { // from class: com.google.android.gms.internal.ads.zzfap
                @Override // com.google.android.gms.internal.ads.zzeze
                public final void zza(Object obj) {
                    ((zzbxc) obj).zzg();
                }
            });
            zzezf.zza(this.zze, new zzeze() { // from class: com.google.android.gms.internal.ads.zzfaq
                @Override // com.google.android.gms.internal.ads.zzeze
                public final void zza(Object obj) {
                    ((zzbwi) obj).zzi();
                }
            });
        }
    }
}
