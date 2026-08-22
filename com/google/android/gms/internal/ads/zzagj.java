package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzagj implements zzadv {
    private zzady zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private zzahm zzg;
    private zzadw zzh;
    private zzagm zzi;
    private zzajj zzj;
    private final zzen zza = new zzen(6);
    private long zzf = -1;

    private final int zza(zzadw zzadwVar) {
        zzen zzenVar = this.zza;
        zzenVar.zzI(2);
        ((zzadl) zzadwVar).zzm(zzenVar.zzN(), 0, 2, false);
        return zzenVar.zzq();
    }

    private final void zzg() {
        zzady zzadyVar = this.zzb;
        zzadyVar.getClass();
        zzadyVar.zzG();
        this.zzb.zzP(new zzaet(-9223372036854775807L, 0L));
        this.zzc = 6;
    }

    /* JADX WARN: Code duplicated, block: B:48:0x010b  */
    @Override // com.google.android.gms.internal.ads.zzadv
    public final int zzb(zzadw zzadwVar, zzaer zzaerVar) throws zzaz {
        int i;
        String strZzy;
        zzagl zzaglVarZza;
        zzahm zzahmVar;
        long j;
        int i2 = this.zzc;
        long j2 = -1;
        if (i2 == 0) {
            zzen zzenVar = this.zza;
            zzenVar.zzI(2);
            zzadwVar.zzi(zzenVar.zzN(), 0, 2);
            int iZzq = zzenVar.zzq();
            this.zzd = iZzq;
            if (iZzq == 65498) {
                if (this.zzf != -1) {
                    this.zzc = 4;
                    return 0;
                }
                zzg();
                return 0;
            }
            if ((iZzq >= 65488 && iZzq <= 65497) || iZzq == 65281) {
                return 0;
            }
            this.zzc = 1;
            return 0;
        }
        if (i2 == 1) {
            zzen zzenVar2 = this.zza;
            zzenVar2.zzI(2);
            zzadwVar.zzi(zzenVar2.zzN(), 0, 2);
            this.zze = zzenVar2.zzq() - 2;
            this.zzc = 2;
            return 0;
        }
        if (i2 != 2) {
            if (i2 != 4) {
                if (i2 != 5) {
                    if (i2 == 6) {
                        return -1;
                    }
                    throw new IllegalStateException();
                }
                if (this.zzi == null || zzadwVar != this.zzh) {
                    this.zzh = zzadwVar;
                    this.zzi = new zzagm(zzadwVar, this.zzf);
                }
                zzajj zzajjVar = this.zzj;
                zzajjVar.getClass();
                int iZzb = zzajjVar.zzb(this.zzi, zzaerVar);
                if (iZzb == 1) {
                    zzaerVar.zza += this.zzf;
                }
                return iZzb;
            }
            long jZzf = zzadwVar.zzf();
            long j3 = this.zzf;
            if (jZzf != j3) {
                zzaerVar.zza = j3;
                return 1;
            }
            if (zzadwVar.zzm(this.zza.zzN(), 0, 1, true)) {
                zzadwVar.zzj();
                if (this.zzj == null) {
                    this.zzj = new zzajj(zzakr.zza, 8);
                }
                zzagm zzagmVar = new zzagm(zzadwVar, this.zzf);
                this.zzi = zzagmVar;
                if (this.zzj.zzi(zzagmVar)) {
                    zzajj zzajjVar2 = this.zzj;
                    long j4 = this.zzf;
                    zzady zzadyVar = this.zzb;
                    zzadyVar.getClass();
                    zzajjVar2.zze(new zzago(j4, zzadyVar));
                    zzahm zzahmVar2 = this.zzg;
                    zzahmVar2.getClass();
                    zzady zzadyVar2 = this.zzb;
                    zzadyVar2.getClass();
                    zzafb zzafbVarZzw = zzadyVar2.zzw(1024, 4);
                    zzx zzxVar = new zzx();
                    zzxVar.zzG("image/jpeg");
                    zzxVar.zzaa(new zzav(-9223372036854775807L, zzahmVar2));
                    zzafbVarZzw.zzm(zzxVar.zzan());
                    this.zzc = 5;
                } else {
                    zzg();
                }
            } else {
                zzg();
            }
            return 0;
        }
        if (this.zzd == 65505) {
            zzen zzenVar3 = new zzen(this.zze);
            zzadwVar.zzi(zzenVar3.zzN(), 0, this.zze);
            if (this.zzg == null && "http://ns.adobe.com/xap/1.0/".equals(zzenVar3.zzy((char) 0)) && (strZzy = zzenVar3.zzy((char) 0)) != null) {
                long jZzd = zzadwVar.zzd();
                if (jZzd == -1 || (zzaglVarZza = zzagp.zza(strZzy)) == null) {
                    zzahmVar = null;
                } else {
                    List list = zzaglVarZza.zzb;
                    if (list.size() < 2) {
                        zzahmVar = null;
                    } else {
                        int size = list.size() - 1;
                        boolean z = false;
                        long j5 = -1;
                        long j6 = -1;
                        long j7 = -1;
                        long j8 = -1;
                        while (size >= 0) {
                            zzagk zzagkVar = (zzagk) list.get(size);
                            boolean zEquals = "video/mp4".equals(zzagkVar.zza) | z;
                            if (size == 0) {
                                jZzd -= zzagkVar.zzc;
                                j = 0;
                            } else {
                                j = jZzd - zzagkVar.zzb;
                            }
                            long j9 = jZzd;
                            jZzd = j;
                            if (!zEquals || jZzd == j9) {
                                z = zEquals;
                            } else {
                                j8 = j9 - jZzd;
                                j7 = jZzd;
                                z = false;
                            }
                            if (size == 0) {
                                j6 = j9;
                            }
                            if (size == 0) {
                                j5 = jZzd;
                            }
                            size--;
                            j2 = -1;
                        }
                        long j10 = j2;
                        if (j7 == j10 || j8 == j10 || j5 == j10 || j6 == j10) {
                            zzahmVar = null;
                        } else {
                            zzahmVar = new zzahm(j5, j6, zzaglVarZza.zza, j7, j8);
                        }
                    }
                }
                this.zzg = zzahmVar;
                if (zzahmVar != null) {
                    this.zzf = zzahmVar.zzd;
                }
            } else {
                i = 0;
            }
            this.zzc = i;
            return i;
        }
        zzadwVar.zzk(this.zze);
        i = 0;
        this.zzc = i;
        return i;
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
        this.zzb = zzadyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zzf(long j, long j2) {
        if (j == 0) {
            this.zzc = 0;
            this.zzj = null;
        } else if (this.zzc == 5) {
            zzajj zzajjVar = this.zzj;
            zzajjVar.getClass();
            zzajjVar.zzf(j, j2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final boolean zzi(zzadw zzadwVar) throws EOFException, InterruptedIOException {
        if (zza(zzadwVar) != 65496) {
            return false;
        }
        int iZza = zza(zzadwVar);
        this.zzd = iZza;
        if (iZza == 65504) {
            zzen zzenVar = this.zza;
            zzenVar.zzI(2);
            zzadl zzadlVar = (zzadl) zzadwVar;
            zzadlVar.zzm(zzenVar.zzN(), 0, 2, false);
            zzadlVar.zzl(zzenVar.zzq() - 2, false);
            iZza = zza(zzadwVar);
            this.zzd = iZza;
        }
        if (iZza == 65505) {
            zzadl zzadlVar2 = (zzadl) zzadwVar;
            zzadlVar2.zzl(2, false);
            zzen zzenVar2 = this.zza;
            zzenVar2.zzI(6);
            zzadlVar2.zzm(zzenVar2.zzN(), 0, 6, false);
            if (zzenVar2.zzu() == 1165519206 && zzenVar2.zzq() == 0) {
                return true;
            }
        }
        return false;
    }
}
