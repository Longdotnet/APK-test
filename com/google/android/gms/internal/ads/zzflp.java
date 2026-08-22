package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzflp extends zzfll {
    private final zzfln zza;
    private zzfnz zzc;
    private zzfmy zzd;
    private final String zzg;
    private final zzfmm zzb = new zzfmm();
    private boolean zze = false;
    private boolean zzf = false;

    public zzflp(zzflm zzflmVar, zzfln zzflnVar, String str) {
        this.zza = zzflnVar;
        this.zzg = str;
        zzk(null);
        if (zzflnVar.zzd() == zzflo.HTML || zzflnVar.zzd() == zzflo.JAVASCRIPT) {
            this.zzd = new zzfmz(str, zzflnVar.zza());
        } else {
            this.zzd = new zzfnc(str, zzflnVar.zzi(), null);
        }
        this.zzd.zzo();
        zzfmi.zza().zzd(this);
        this.zzd.zzf(zzflmVar);
    }

    private final void zzk(View view) {
        this.zzc = new zzfnz(view);
    }

    @Override // com.google.android.gms.internal.ads.zzfll
    public final void zzb(View view, zzfls zzflsVar, String str) {
        if (this.zzf) {
            return;
        }
        this.zzb.zzb(view, zzflsVar, "Ad overlay");
    }

    @Override // com.google.android.gms.internal.ads.zzfll
    public final void zzc() {
        if (this.zzf) {
            return;
        }
        this.zzc.clear();
        if (!this.zzf) {
            this.zzb.zzc();
        }
        this.zzf = true;
        this.zzd.zze();
        zzfmi.zza().zze(this);
        this.zzd.zzc();
        this.zzd = null;
    }

    @Override // com.google.android.gms.internal.ads.zzfll
    public final void zzd(View view) {
        if (this.zzf || zzf() == view) {
            return;
        }
        zzk(view);
        this.zzd.zzb();
        Collection<zzflp> collectionZzc = zzfmi.zza().zzc();
        if (collectionZzc == null || collectionZzc.isEmpty()) {
            return;
        }
        for (zzflp zzflpVar : collectionZzc) {
            if (zzflpVar != this && zzflpVar.zzf() == view) {
                zzflpVar.zzc.clear();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfll
    public final void zze() {
        if (this.zze || this.zzd == null) {
            return;
        }
        this.zze = true;
        zzfmi.zza().zzf(this);
        this.zzd.zzl(zzfmq.zzb().zza());
        this.zzd.zzg(zzfmg.zza().zzb());
        this.zzd.zzi(this, this.zza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View zzf() {
        return (View) this.zzc.get();
    }

    public final zzfmy zzg() {
        return this.zzd;
    }

    public final String zzh() {
        return this.zzg;
    }

    public final List zzi() {
        return this.zzb.zza();
    }

    public final boolean zzj() {
        return this.zze && !this.zzf;
    }
}
