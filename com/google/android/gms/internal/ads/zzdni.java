package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzdni extends zzbii {
    private final String zza;
    private final zzdio zzb;
    private final zzdit zzc;
    private final zzdsj zzd;

    public zzdni(String str, zzdio zzdioVar, zzdit zzditVar, zzdsj zzdsjVar) {
        this.zza = str;
        this.zzb = zzdioVar;
        this.zzc = zzditVar;
        this.zzd = zzdsjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zzA(Bundle bundle) {
        this.zzb.zzH(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zzB() {
        this.zzb.zzI();
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zzC(Bundle bundle) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zznr)).booleanValue()) {
            this.zzb.zzJ(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zzD(Bundle bundle) {
        this.zzb.zzN(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zzE() {
        this.zzb.zzP();
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zzF(com.google.android.gms.ads.internal.client.zzdf zzdfVar) {
        this.zzb.zzQ(zzdfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zzG(com.google.android.gms.ads.internal.client.zzdt zzdtVar) {
        try {
            if (!zzdtVar.zzf()) {
                this.zzd.zze();
            }
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzf("Error in making CSI ping for reporting paid event callback", e);
        }
        this.zzb.zzR(zzdtVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zzH(long j) {
        zzdio zzdioVar = this.zzb;
        if (zzdioVar == null || zzdioVar.zzl() == null) {
            return;
        }
        zzdioVar.zzl().zzb(j);
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zzI(zzbig zzbigVar) {
        this.zzb.zzS(zzbigVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final boolean zzJ() {
        return this.zzb.zzX();
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final boolean zzK() {
        zzdit zzditVar = this.zzc;
        return (zzditVar.zzH().isEmpty() || zzditVar.zzk() == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final boolean zzL(Bundle bundle) {
        return this.zzb.zzaa(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final double zze() {
        return this.zzc.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final long zzf() {
        zzdio zzdioVar = this.zzb;
        if (zzdioVar == null || zzdioVar.zzl() == null) {
            return 0L;
        }
        return zzdioVar.zzl().zza();
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final Bundle zzg() {
        return this.zzc.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final com.google.android.gms.ads.internal.client.zzea zzh() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzgW)).booleanValue()) {
            return this.zzb.zzm();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final com.google.android.gms.ads.internal.client.zzed zzi() {
        return this.zzc.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final zzbgi zzj() {
        return this.zzc.zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final zzbgm zzk() {
        return this.zzb.zzc().zza();
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final zzbgp zzl() {
        return this.zzc.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final IObjectWrapper zzm() {
        return this.zzc.zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final IObjectWrapper zzn() {
        return new ObjectWrapper(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final String zzo() {
        return this.zzc.zzx();
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final String zzp() {
        return this.zzc.zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final String zzq() {
        return this.zzc.zzz();
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final String zzr() {
        return this.zzc.zzB();
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final String zzs() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final String zzt() {
        return this.zzc.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final String zzu() {
        return this.zzc.zzE();
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final List zzv() {
        return this.zzc.zzG();
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final List zzw() {
        return zzK() ? this.zzc.zzH() : Collections.emptyList();
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zzx() {
        this.zzb.zzB();
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zzy() {
        this.zzb.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zzz(com.google.android.gms.ads.internal.client.zzdj zzdjVar) {
        this.zzb.zzD(zzdjVar);
    }
}
