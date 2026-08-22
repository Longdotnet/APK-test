package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzco implements zzcn {
    protected zzcl zzb;
    protected zzcl zzc;
    private zzcl zzd;
    private zzcl zze;
    private ByteBuffer zzf;
    private ByteBuffer zzg;
    private boolean zzh;

    public zzco() {
        ByteBuffer byteBuffer = zzcn.zza;
        this.zzf = byteBuffer;
        this.zzg = byteBuffer;
        zzcl zzclVar = zzcl.zza;
        this.zzd = zzclVar;
        this.zze = zzclVar;
        this.zzb = zzclVar;
        this.zzc = zzclVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcn
    public final zzcl zza(zzcl zzclVar) {
        this.zzd = zzclVar;
        this.zze = zzi(zzclVar);
        return zzg() ? this.zze : zzcl.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzcn
    public ByteBuffer zzb() {
        ByteBuffer byteBuffer = this.zzg;
        this.zzg = zzcn.zza;
        return byteBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzcn
    public final void zzc() {
        this.zzg = zzcn.zza;
        this.zzh = false;
        this.zzb = this.zzd;
        this.zzc = this.zze;
        zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzcn
    public final void zzd() {
        this.zzh = true;
        zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzcn
    public final void zzf() {
        ByteBuffer byteBuffer = zzcn.zza;
        this.zzg = byteBuffer;
        this.zzh = false;
        this.zzf = byteBuffer;
        zzcl zzclVar = zzcl.zza;
        this.zzd = zzclVar;
        this.zze = zzclVar;
        this.zzb = zzclVar;
        this.zzc = zzclVar;
        zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzcn
    public boolean zzg() {
        return this.zze != zzcl.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzcn
    public boolean zzh() {
        return this.zzh && this.zzg == zzcn.zza;
    }

    public zzcl zzi(zzcl zzclVar) {
        throw null;
    }

    public final ByteBuffer zzj(int i) {
        if (this.zzf.capacity() < i) {
            this.zzf = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.zzf.clear();
        }
        ByteBuffer byteBuffer = this.zzf;
        this.zzg = byteBuffer;
        return byteBuffer;
    }

    public void zzk() {
    }

    public void zzl() {
    }

    public void zzm() {
    }

    public final boolean zzn() {
        return this.zzg.hasRemaining();
    }
}
