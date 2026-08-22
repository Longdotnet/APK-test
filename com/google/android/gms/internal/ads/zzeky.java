package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.android.gms.ads.admanager.AppEventListener;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzeky implements AppEventListener, zzcza, zzcxm, zzcwb, zzcws, com.google.android.gms.ads.internal.client.zza, zzcvy, zzcyk, zzcwo, zzded {
    final zzdsj zza;
    private final AtomicReference zzc = new AtomicReference();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    private final AtomicReference zzf = new AtomicReference();
    private final AtomicReference zzg = new AtomicReference();
    private final AtomicBoolean zzh = new AtomicBoolean(true);
    private final AtomicBoolean zzi = new AtomicBoolean(false);
    private final AtomicBoolean zzj = new AtomicBoolean(false);
    final BlockingQueue zzb = new ArrayBlockingQueue(((Integer) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjm)).intValue());

    public zzeky(zzdsj zzdsjVar) {
        this.zza = zzdsjVar;
    }

    private final void zzo() {
        if (this.zzi.get() && this.zzj.get()) {
            BlockingQueue<Pair> blockingQueue = this.zzb;
            for (final Pair pair : blockingQueue) {
                zzezf.zza(this.zzd, new zzeze() { // from class: com.google.android.gms.internal.ads.zzekj
                    @Override // com.google.android.gms.internal.ads.zzeze
                    public final void zza(Object obj) {
                        Pair pair2 = pair;
                        ((com.google.android.gms.ads.internal.client.zzco) obj).zzc((String) pair2.first, (String) pair2.second);
                    }
                });
            }
            blockingQueue.clear();
            this.zzh.set(false);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzli)).booleanValue()) {
            return;
        }
        zzezf.zza(this.zzc, new zzekw());
    }

    @Override // com.google.android.gms.ads.admanager.AppEventListener
    public final synchronized void onAppEvent(final String str, final String str2) {
        if (!this.zzh.get()) {
            zzezf.zza(this.zzd, new zzeze() { // from class: com.google.android.gms.internal.ads.zzekq
                @Override // com.google.android.gms.internal.ads.zzeze
                public final void zza(Object obj) {
                    ((com.google.android.gms.ads.internal.client.zzco) obj).zzc(str, str2);
                }
            });
            return;
        }
        if (!this.zzb.offer(new Pair(str, str2))) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zze("The queue for app events is full, dropping the new event.");
            zzdsj zzdsjVar = this.zza;
            if (zzdsjVar != null) {
                zzdsi zzdsiVarZza = zzdsjVar.zza();
                zzdsiVarZza.zzb("action", "dae_action");
                zzdsiVarZza.zzb("dae_name", str);
                zzdsiVarZza.zzb("dae_data", str2);
                zzdsiVarZza.zzj();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcvy
    public final void zza() {
        zzezf.zza(this.zzc, new zzeze() { // from class: com.google.android.gms.internal.ads.zzekg
            @Override // com.google.android.gms.internal.ads.zzeze
            public final void zza(Object obj) {
                ((com.google.android.gms.ads.internal.client.zzbk) obj).zzd();
            }
        });
        zzezf.zza(this.zzg, new zzeze() { // from class: com.google.android.gms.internal.ads.zzekh
            @Override // com.google.android.gms.internal.ads.zzeze
            public final void zza(Object obj) {
                ((com.google.android.gms.ads.internal.client.zzcv) obj).zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvy
    public final void zzb() {
        zzezf.zza(this.zzc, new zzeze() { // from class: com.google.android.gms.internal.ads.zzekr
            @Override // com.google.android.gms.internal.ads.zzeze
            public final void zza(Object obj) {
                ((com.google.android.gms.ads.internal.client.zzbk) obj).zzh();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvy
    public final void zzc() {
        zzezf.zza(this.zzc, new zzeze() { // from class: com.google.android.gms.internal.ads.zzekt
            @Override // com.google.android.gms.internal.ads.zzeze
            public final void zza(Object obj) {
                ((com.google.android.gms.ads.internal.client.zzbk) obj).zzj();
            }
        });
        zzeze zzezeVar = new zzeze() { // from class: com.google.android.gms.internal.ads.zzeku
            @Override // com.google.android.gms.internal.ads.zzeze
            public final void zza(Object obj) {
                ((com.google.android.gms.ads.internal.client.zzcv) obj).zzf();
            }
        };
        AtomicReference atomicReference = this.zzg;
        zzezf.zza(atomicReference, zzezeVar);
        zzezf.zza(atomicReference, new zzeze() { // from class: com.google.android.gms.internal.ads.zzekv
            @Override // com.google.android.gms.internal.ads.zzeze
            public final void zza(Object obj) {
                ((com.google.android.gms.ads.internal.client.zzcv) obj).zze();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcwb
    public final void zzdD(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzeze zzezeVar = new zzeze() { // from class: com.google.android.gms.internal.ads.zzekk
            @Override // com.google.android.gms.internal.ads.zzeze
            public final void zza(Object obj) {
                ((com.google.android.gms.ads.internal.client.zzbk) obj).zzf(zzeVar);
            }
        };
        AtomicReference atomicReference = this.zzc;
        zzezf.zza(atomicReference, zzezeVar);
        zzezf.zza(atomicReference, new zzeze() { // from class: com.google.android.gms.internal.ads.zzekl
            @Override // com.google.android.gms.internal.ads.zzeze
            public final void zza(Object obj) {
                ((com.google.android.gms.ads.internal.client.zzbk) obj).zze(zzeVar.zza);
            }
        });
        zzezf.zza(this.zzf, new zzeze() { // from class: com.google.android.gms.internal.ads.zzekm
            @Override // com.google.android.gms.internal.ads.zzeze
            public final void zza(Object obj) {
                ((com.google.android.gms.ads.internal.client.zzbn) obj).zzb(zzeVar);
            }
        });
        this.zzh.set(false);
        this.zzb.clear();
    }

    @Override // com.google.android.gms.internal.ads.zzded
    public final void zzdH() {
        zzezf.zza(this.zzc, new zzeze() { // from class: com.google.android.gms.internal.ads.zzeks
            @Override // com.google.android.gms.internal.ads.zzeze
            public final void zza(Object obj) {
                ((com.google.android.gms.ads.internal.client.zzbk) obj).zzk();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzded
    public final void zzdf() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzli)).booleanValue()) {
            zzezf.zza(this.zzc, new zzekw());
        }
        zzezf.zza(this.zzg, new zzeze() { // from class: com.google.android.gms.internal.ads.zzeki
            @Override // com.google.android.gms.internal.ads.zzeze
            public final void zza(Object obj) {
                ((com.google.android.gms.ads.internal.client.zzcv) obj).zzb();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcza
    public final void zzdn(zzbvq zzbvqVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzcza
    public final void zzdo(zzfcn zzfcnVar) {
        this.zzh.set(true);
        this.zzj.set(false);
    }

    @Override // com.google.android.gms.internal.ads.zzcvy
    public final void zzdu(zzbwc zzbwcVar, String str, String str2) {
    }

    @Override // com.google.android.gms.internal.ads.zzcvy
    public final void zze() {
    }

    @Override // com.google.android.gms.internal.ads.zzcvy
    public final void zzf() {
    }

    public final synchronized com.google.android.gms.ads.internal.client.zzbk zzg() {
        return (com.google.android.gms.ads.internal.client.zzbk) this.zzc.get();
    }

    @Override // com.google.android.gms.internal.ads.zzcyk
    public final void zzh(final com.google.android.gms.ads.internal.client.zzt zztVar) {
        zzezf.zza(this.zze, new zzeze() { // from class: com.google.android.gms.internal.ads.zzekx
            @Override // com.google.android.gms.internal.ads.zzeze
            public final void zza(Object obj) {
                ((com.google.android.gms.ads.internal.client.zzdt) obj).zze(zztVar);
            }
        });
    }

    public final synchronized com.google.android.gms.ads.internal.client.zzco zzi() {
        return (com.google.android.gms.ads.internal.client.zzco) this.zzd.get();
    }

    public final void zzj(com.google.android.gms.ads.internal.client.zzbk zzbkVar) {
        this.zzc.set(zzbkVar);
    }

    public final void zzk(com.google.android.gms.ads.internal.client.zzbn zzbnVar) {
        this.zzf.set(zzbnVar);
    }

    public final void zzl(com.google.android.gms.ads.internal.client.zzdt zzdtVar) {
        this.zze.set(zzdtVar);
    }

    public final void zzm(com.google.android.gms.ads.internal.client.zzco zzcoVar) {
        this.zzd.set(zzcoVar);
        this.zzi.set(true);
        zzo();
    }

    public final void zzn(com.google.android.gms.ads.internal.client.zzcv zzcvVar) {
        this.zzg.set(zzcvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcwo
    public final void zzs(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzezf.zza(this.zzg, new zzeze() { // from class: com.google.android.gms.internal.ads.zzekp
            @Override // com.google.android.gms.internal.ads.zzeze
            public final void zza(Object obj) {
                ((com.google.android.gms.ads.internal.client.zzcv) obj).zzd(zzeVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcws
    public final void zzt() {
        zzezf.zza(this.zzc, new zzeze() { // from class: com.google.android.gms.internal.ads.zzekf
            @Override // com.google.android.gms.internal.ads.zzeze
            public final void zza(Object obj) {
                ((com.google.android.gms.ads.internal.client.zzbk) obj).zzg();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcxm
    public final synchronized void zzu() {
        zzezf.zza(this.zzc, new zzeze() { // from class: com.google.android.gms.internal.ads.zzekn
            @Override // com.google.android.gms.internal.ads.zzeze
            public final void zza(Object obj) {
                ((com.google.android.gms.ads.internal.client.zzbk) obj).zzi();
            }
        });
        zzezf.zza(this.zzf, new zzeze() { // from class: com.google.android.gms.internal.ads.zzeko
            @Override // com.google.android.gms.internal.ads.zzeze
            public final void zza(Object obj) {
                ((com.google.android.gms.ads.internal.client.zzbn) obj).zzc();
            }
        });
        this.zzj.set(true);
        zzo();
    }
}
