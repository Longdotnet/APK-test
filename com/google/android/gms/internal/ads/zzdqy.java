package com.google.android.gms.internal.ads;

import com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.TossType;

/* JADX INFO: loaded from: classes.dex */
public final class zzdqy implements zzcza, zzcxm, zzcwb, zzcws, com.google.android.gms.ads.internal.client.zza, zzdbm {
    private final zzbcc zza;
    private boolean zzb = false;

    public zzdqy(zzbcc zzbccVar, zzezv zzezvVar) {
        this.zza = zzbccVar;
        zzbccVar.zzc(2);
        if (zzezvVar != null) {
            zzbccVar.zzc(1101);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final synchronized void onAdClicked() {
        if (this.zzb) {
            this.zza.zzc(8);
        } else {
            this.zza.zzc(7);
            this.zzb = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwb
    public final void zzdD(com.google.android.gms.ads.internal.client.zze zzeVar) {
        switch (zzeVar.zza) {
            case 1:
                this.zza.zzc(101);
                break;
            case 2:
                this.zza.zzc(TossType.TOSS_OPEN_MASKED_SOLHWA_VALUE);
                break;
            case 3:
                this.zza.zzc(5);
                break;
            case 4:
                this.zza.zzc(TossType.TOSS_OPEN_BALANCED_VALUE);
                break;
            case 5:
                this.zza.zzc(TossType.TOSS_FIXED_LOW_FOR_BEGINNER_VALUE);
                break;
            case 6:
                this.zza.zzc(TossType.TOSS_NETUPOPEN_VALUE);
                break;
            case 7:
                this.zza.zzc(TossType.TOSS_NETUPC_VALUE);
                break;
            default:
                this.zza.zzc(4);
                break;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcza
    public final void zzdn(zzbvq zzbvqVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzcza
    public final void zzdo(final zzfcn zzfcnVar) {
        this.zza.zzb(new zzbcb() { // from class: com.google.android.gms.internal.ads.zzdqu
            @Override // com.google.android.gms.internal.ads.zzbcb
            public final void zza(zzbcj.zzt.zza zzaVar) {
                zzbcj.zza.zzb zzbVarZzbM = zzaVar.zze().zzbM();
                zzbcj.zzi.zza zzaVarZzbM = zzaVar.zze().zzad().zzbM();
                zzaVarZzbM.zzo(zzfcnVar.zzb.zzb.zzb);
                zzbVarZzbM.zzT(zzaVarZzbM);
                zzaVar.zzG(zzbVarZzbM);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdbm
    public final void zzh() {
        this.zza.zzc(1109);
    }

    @Override // com.google.android.gms.internal.ads.zzdbm
    public final void zzi(final zzbcj.zzb zzbVar) {
        zzbcb zzbcbVar = new zzbcb() { // from class: com.google.android.gms.internal.ads.zzdqx
            @Override // com.google.android.gms.internal.ads.zzbcb
            public final void zza(zzbcj.zzt.zza zzaVar) {
                zzaVar.zzJ(zzbVar);
            }
        };
        zzbcc zzbccVar = this.zza;
        zzbccVar.zzb(zzbcbVar);
        zzbccVar.zzc(1103);
    }

    @Override // com.google.android.gms.internal.ads.zzdbm
    public final void zzj(final zzbcj.zzb zzbVar) {
        zzbcb zzbcbVar = new zzbcb() { // from class: com.google.android.gms.internal.ads.zzdqv
            @Override // com.google.android.gms.internal.ads.zzbcb
            public final void zza(zzbcj.zzt.zza zzaVar) {
                zzaVar.zzJ(zzbVar);
            }
        };
        zzbcc zzbccVar = this.zza;
        zzbccVar.zzb(zzbcbVar);
        zzbccVar.zzc(1102);
    }

    @Override // com.google.android.gms.internal.ads.zzdbm
    public final void zzl(boolean z) {
        this.zza.zzc(true != z ? 1108 : 1107);
    }

    @Override // com.google.android.gms.internal.ads.zzdbm
    public final void zzm(final zzbcj.zzb zzbVar) {
        zzbcb zzbcbVar = new zzbcb() { // from class: com.google.android.gms.internal.ads.zzdqw
            @Override // com.google.android.gms.internal.ads.zzbcb
            public final void zza(zzbcj.zzt.zza zzaVar) {
                zzaVar.zzJ(zzbVar);
            }
        };
        zzbcc zzbccVar = this.zza;
        zzbccVar.zzb(zzbcbVar);
        zzbccVar.zzc(1104);
    }

    @Override // com.google.android.gms.internal.ads.zzdbm
    public final void zzn(boolean z) {
        this.zza.zzc(true != z ? 1106 : 1105);
    }

    @Override // com.google.android.gms.internal.ads.zzcws
    public final synchronized void zzt() {
        this.zza.zzc(6);
    }

    @Override // com.google.android.gms.internal.ads.zzcxm
    public final void zzu() {
        this.zza.zzc(3);
    }
}
