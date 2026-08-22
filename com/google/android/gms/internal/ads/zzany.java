package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzany {
    private final zzamz zza;
    private final zzeu zzb;
    private final zzem zzc = new zzem(new byte[64], 64);
    private boolean zzd;
    private boolean zze;
    private boolean zzf;

    public zzany(zzamz zzamzVar, zzeu zzeuVar) {
        this.zza = zzamzVar;
        this.zzb = zzeuVar;
    }

    public final void zza(zzen zzenVar) {
        long jZzb;
        zzem zzemVar = this.zzc;
        zzenVar.zzH(zzemVar.zza, 0, 3);
        zzemVar.zzl(0);
        zzemVar.zzn(8);
        this.zzd = zzemVar.zzp();
        this.zze = zzemVar.zzp();
        zzemVar.zzn(6);
        zzenVar.zzH(zzemVar.zza, 0, zzemVar.zzd(8));
        zzemVar.zzl(0);
        if (this.zzd) {
            zzemVar.zzn(4);
            long jZzd = zzemVar.zzd(3);
            zzemVar.zzn(1);
            int iZzd = zzemVar.zzd(15) << 15;
            zzemVar.zzn(1);
            long jZzd2 = zzemVar.zzd(15);
            zzemVar.zzn(1);
            if (!this.zzf && this.zze) {
                zzemVar.zzn(4);
                long jZzd3 = ((long) zzemVar.zzd(3)) << 30;
                zzemVar.zzn(1);
                int iZzd2 = zzemVar.zzd(15) << 15;
                zzemVar.zzn(1);
                long jZzd4 = zzemVar.zzd(15);
                zzemVar.zzn(1);
                this.zzb.zzb(jZzd3 | ((long) iZzd2) | jZzd4);
                this.zzf = true;
            }
            jZzb = this.zzb.zzb((jZzd << 30) | ((long) iZzd) | jZzd2);
        } else {
            jZzb = 0;
        }
        zzamz zzamzVar = this.zza;
        zzamzVar.zzd(jZzb, 4);
        zzamzVar.zza(zzenVar);
        zzamzVar.zzc(false);
    }

    public final void zzb() {
        this.zzf = false;
        this.zza.zze();
    }
}
