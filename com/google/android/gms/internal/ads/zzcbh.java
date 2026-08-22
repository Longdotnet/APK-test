package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.TextureView;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzcbh extends TextureView implements zzcce {
    protected final zzcbv zza;
    protected final zzccf zzb;

    public zzcbh(Context context) {
        super(context);
        this.zza = new zzcbv();
        this.zzb = new zzccf(context, this);
    }

    public void zzA(int i) {
    }

    public void zzB(int i) {
    }

    public void zzC(String str, String[] strArr, Integer num) {
        zzs(str);
    }

    public abstract int zza();

    public abstract int zzb();

    public abstract int zzc();

    public abstract int zzd();

    public abstract int zze();

    public abstract long zzf();

    public abstract long zzg();

    public abstract long zzh();

    public abstract String zzj();

    public abstract void zzn();

    public abstract void zzo();

    public abstract void zzp();

    public abstract void zzq(int i);

    public abstract void zzr(zzcbg zzcbgVar);

    public abstract void zzs(String str);

    public abstract void zzt();

    public abstract void zzu(float f, float f2);

    public Integer zzw() {
        return null;
    }

    public void zzx(int i) {
    }

    public void zzy(int i) {
    }

    public void zzz(int i) {
    }
}
