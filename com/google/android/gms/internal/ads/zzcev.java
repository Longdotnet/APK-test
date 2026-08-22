package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes.dex */
public final class zzcev extends zzcbh {
    private final zzccc zzc;
    private zzcew zzd;
    private Uri zze;
    private zzcbg zzf;
    private boolean zzg;
    private int zzh;

    public zzcev(Context context, zzccc zzcccVar) {
        super(context);
        this.zzh = 1;
        this.zzg = false;
        this.zzc = zzcccVar;
        zzcccVar.zza(this);
    }

    public static /* synthetic */ void zzi(zzcev zzcevVar) {
        zzcbg zzcbgVar = zzcevVar.zzf;
        if (zzcbgVar != null) {
            if (!zzcevVar.zzg) {
                zzcbgVar.zzg();
                zzcevVar.zzg = true;
            }
            zzcevVar.zzf.zze();
        }
    }

    public static /* synthetic */ void zzk(zzcev zzcevVar) {
        zzcbg zzcbgVar = zzcevVar.zzf;
        if (zzcbgVar != null) {
            zzcbgVar.zzd();
        }
    }

    public static /* synthetic */ void zzl(zzcev zzcevVar) {
        zzcbg zzcbgVar = zzcevVar.zzf;
        if (zzcbgVar != null) {
            zzcbgVar.zzf();
        }
    }

    private final boolean zzm() {
        int i = this.zzh;
        return (i == 1 || i == 2 || this.zzd == null) ? false : true;
    }

    private final void zzv(int i) {
        if (i == 4) {
            this.zzc.zzc();
            this.zzb.zzb();
        } else if (this.zzh == 4) {
            this.zzc.zze();
            this.zzb.zzc();
        }
        this.zzh = i;
    }

    @Override // android.view.View
    public final String toString() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzcev.class.getName(), "@", Integer.toHexString(hashCode()));
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final int zza() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final int zzb() {
        return zzm() ? 0 : -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final int zzc() {
        return zzm() ? 0 : -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final int zzd() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final int zze() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final long zzf() {
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final long zzg() {
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final long zzh() {
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final String zzj() {
        return "ImmersivePlayer";
    }

    @Override // com.google.android.gms.internal.ads.zzcbh, com.google.android.gms.internal.ads.zzcce
    public final void zzn() {
        if (this.zzd != null) {
            this.zzb.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final void zzo() {
        com.google.android.gms.ads.internal.util.zze.zza("AdImmersivePlayerView pause");
        if (zzm() && this.zzd.zzd()) {
            this.zzd.zza();
            zzv(5);
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzceu
                @Override // java.lang.Runnable
                public final void run() {
                    zzcev.zzk(this.zza);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final void zzp() {
        com.google.android.gms.ads.internal.util.zze.zza("AdImmersivePlayerView play");
        if (zzm()) {
            this.zzd.zzb();
            zzv(4);
            this.zza.zzb();
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcet
                @Override // java.lang.Runnable
                public final void run() {
                    zzcev.zzi(this.zza);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final void zzq(int i) {
        com.google.android.gms.ads.internal.util.zze.zza("AdImmersivePlayerView seek " + i);
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final void zzr(zzcbg zzcbgVar) {
        this.zzf = zzcbgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final void zzs(String str) {
        if (str != null) {
            Uri uri = Uri.parse(str);
            this.zze = uri;
            this.zzd = new zzcew(uri.toString());
            zzv(3);
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzces
                @Override // java.lang.Runnable
                public final void run() {
                    zzcev.zzl(this.zza);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final void zzt() {
        com.google.android.gms.ads.internal.util.zze.zza("AdImmersivePlayerView stop");
        zzcew zzcewVar = this.zzd;
        if (zzcewVar != null) {
            zzcewVar.zzc();
            this.zzd = null;
            zzv(1);
        }
        this.zzc.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final void zzu(float f, float f2) {
    }
}
