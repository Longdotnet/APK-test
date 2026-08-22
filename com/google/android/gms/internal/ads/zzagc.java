package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzagc implements zzadv {
    private zzady zzf;
    private boolean zzh;
    private long zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private long zzm;
    private boolean zzn;
    private zzagb zzo;
    private zzagg zzp;
    private final zzen zza = new zzen(4);
    private final zzen zzb = new zzen(9);
    private final zzen zzc = new zzen(11);
    private final zzen zzd = new zzen();
    private final zzagd zze = new zzagd();
    private int zzg = 1;

    private final zzen zza(zzadw zzadwVar) {
        zzen zzenVar = this.zzd;
        if (this.zzl > zzenVar.zzb()) {
            int iZzb = zzenVar.zzb();
            zzenVar.zzJ(new byte[Math.max(iZzb + iZzb, this.zzl)], 0);
        } else {
            zzenVar.zzL(0);
        }
        zzenVar.zzK(this.zzl);
        zzadwVar.zzi(zzenVar.zzN(), 0, this.zzl);
        return zzenVar;
    }

    private final void zzg() {
        if (this.zzn) {
            return;
        }
        this.zzf.zzP(new zzaet(-9223372036854775807L, 0L));
        this.zzn = true;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0097  */
    /* JADX WARN: Code duplicated, block: B:41:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:42:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:71:0x00be A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x0009 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzadv
    public final int zzb(zzadw zzadwVar, zzaer zzaerVar) {
        long j;
        boolean zZzf;
        boolean z;
        long j2;
        zzdd.zzb(this.zzf);
        while (true) {
            int i = this.zzg;
            int i2 = 8;
            if (i == 1) {
                zzen zzenVar = this.zzb;
                if (!zzadwVar.zzn(zzenVar.zzN(), 0, 9, true)) {
                    return -1;
                }
                zzenVar.zzL(0);
                zzenVar.zzM(4);
                int iZzm = zzenVar.zzm();
                int i3 = iZzm & 4;
                int i4 = iZzm & 1;
                if (i3 != 0 && this.zzo == null) {
                    this.zzo = new zzagb(this.zzf.zzw(8, 1));
                }
                if (i4 != 0 && this.zzp == null) {
                    this.zzp = new zzagg(this.zzf.zzw(9, 2));
                }
                this.zzf.zzG();
                this.zzj = zzenVar.zzg() - 5;
                this.zzg = 2;
            } else if (i == 2) {
                zzadwVar.zzk(this.zzj);
                this.zzj = 0;
                this.zzg = 3;
            } else if (i == 3) {
                zzen zzenVar2 = this.zzc;
                if (!zzadwVar.zzn(zzenVar2.zzN(), 0, 11, true)) {
                    return -1;
                }
                zzenVar2.zzL(0);
                this.zzk = zzenVar2.zzm();
                this.zzl = zzenVar2.zzo();
                this.zzm = zzenVar2.zzo();
                this.zzm = (((long) (zzenVar2.zzm() << 24)) | this.zzm) * 1000;
                zzenVar2.zzM(3);
                this.zzg = 4;
            } else {
                if (i != 4) {
                    throw new IllegalStateException();
                }
                if (this.zzh) {
                    j = this.zzi + this.zzm;
                } else {
                    j = this.zze.zzc() == -9223372036854775807L ? 0L : this.zzm;
                }
                int i5 = this.zzk;
                if (i5 == 8) {
                    if (this.zzo != null) {
                        zzg();
                        zZzf = this.zzo.zzf(zza(zzadwVar), j);
                    }
                    z = true;
                    if (!this.zzh && zZzf) {
                        this.zzh = true;
                        if (this.zze.zzc() == -9223372036854775807L) {
                            j2 = -this.zzm;
                        } else {
                            j2 = 0;
                        }
                        this.zzi = j2;
                    }
                    this.zzj = 4;
                    this.zzg = 2;
                    if (z) {
                        return 0;
                    }
                } else {
                    i2 = i5;
                }
                if (i2 == 9) {
                    if (this.zzp != null) {
                        zzg();
                        zZzf = this.zzp.zzf(zza(zzadwVar), j);
                        z = true;
                    } else {
                        zzadwVar.zzk(this.zzl);
                        zZzf = false;
                        z = false;
                    }
                } else if (i2 != 18 || this.zzn) {
                    zzadwVar.zzk(this.zzl);
                    zZzf = false;
                    z = false;
                } else {
                    zzagd zzagdVar = this.zze;
                    boolean zZzf2 = zzagdVar.zzf(zza(zzadwVar), j);
                    long jZzc = zzagdVar.zzc();
                    if (jZzc != -9223372036854775807L) {
                        this.zzf.zzP(new zzaem(zzagdVar.zzd(), zzagdVar.zze(), jZzc));
                        this.zzn = true;
                    }
                    zZzf = zZzf2;
                    z = true;
                }
                if (!this.zzh) {
                    this.zzh = true;
                    if (this.zze.zzc() == -9223372036854775807L) {
                        j2 = -this.zzm;
                    } else {
                        j2 = 0;
                    }
                    this.zzi = j2;
                }
                this.zzj = 4;
                this.zzg = 2;
                if (z) {
                    return 0;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final /* synthetic */ zzadv zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final /* synthetic */ List zzd() {
        return zzfyq.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zze(zzady zzadyVar) {
        this.zzf = zzadyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zzf(long j, long j2) {
        if (j == 0) {
            this.zzg = 1;
            this.zzh = false;
        } else {
            this.zzg = 3;
        }
        this.zzj = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final boolean zzi(zzadw zzadwVar) throws EOFException, InterruptedIOException {
        zzen zzenVar = this.zza;
        zzadl zzadlVar = (zzadl) zzadwVar;
        zzadlVar.zzm(zzenVar.zzN(), 0, 3, false);
        zzenVar.zzL(0);
        if (zzenVar.zzo() != 4607062) {
            return false;
        }
        zzadlVar.zzm(zzenVar.zzN(), 0, 2, false);
        zzenVar.zzL(0);
        if ((zzenVar.zzq() & 250) != 0) {
            return false;
        }
        zzadlVar.zzm(zzenVar.zzN(), 0, 4, false);
        zzenVar.zzL(0);
        int iZzg = zzenVar.zzg();
        zzadwVar.zzj();
        zzadl zzadlVar2 = (zzadl) zzadwVar;
        zzadlVar2.zzl(iZzg, false);
        zzadlVar2.zzm(zzenVar.zzN(), 0, 4, false);
        zzenVar.zzL(0);
        return zzenVar.zzg() == 0;
    }
}
