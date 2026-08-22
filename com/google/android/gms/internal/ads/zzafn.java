package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzafn implements zzadv {
    private final zzen zza;
    private final zzafl zzb;
    private final boolean zzc;
    private final zzakr zzd;
    private int zze;
    private zzady zzf;
    private zzafo zzg;
    private long zzh;
    private zzafq[] zzi;
    private long zzj;
    private zzafq zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private int zzo;
    private boolean zzp;

    @Deprecated
    public zzafn() {
        this(1, zzakr.zza);
    }

    private final zzafq zzg(int i) {
        for (zzafq zzafqVar : this.zzi) {
            if (zzafqVar.zzf(i)) {
                return zzafqVar;
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final int zzb(zzadw zzadwVar, zzaer zzaerVar) throws zzaz {
        boolean z;
        long j;
        long j2 = this.zzj;
        if (j2 != -1) {
            long jZzf = zzadwVar.zzf();
            if (j2 < jZzf || j2 > 262144 + jZzf) {
                zzaerVar.zza = j2;
                z = true;
            } else {
                zzadwVar.zzk((int) (j2 - jZzf));
                z = false;
            }
        } else {
            z = false;
        }
        this.zzj = -1L;
        if (z) {
            return 1;
        }
        int i = this.zze;
        zzafq zzafqVar = null;
        if (i == 0) {
            if (!zzi(zzadwVar)) {
                throw zzaz.zza("AVI Header List not found", null);
            }
            zzadwVar.zzk(12);
            this.zze = 1;
            return 0;
        }
        if (i == 1) {
            zzen zzenVar = this.zza;
            zzadwVar.zzi(zzenVar.zzN(), 0, 12);
            zzenVar.zzL(0);
            zzafl zzaflVar = this.zzb;
            zzaflVar.zza(zzenVar);
            int i2 = zzaflVar.zza;
            if (i2 != 1414744396) {
                throw zzaz.zza("LIST expected, found: " + i2, null);
            }
            int iZzi = zzenVar.zzi();
            if (iZzi == 1819436136) {
                this.zzl = zzaflVar.zzb;
                this.zze = 2;
                return 0;
            }
            throw zzaz.zza("hdrl expected, found: " + iZzi, null);
        }
        if (i == 2) {
            int i3 = this.zzl - 4;
            zzen zzenVar2 = new zzen(i3);
            zzadwVar.zzi(zzenVar2.zzN(), 0, i3);
            zzafr zzafrVarZzc = zzafr.zzc(1819436136, zzenVar2);
            if (zzafrVarZzc.zza() != 1819436136) {
                throw zzaz.zza("Unexpected header list type " + zzafrVarZzc.zza(), null);
            }
            zzafo zzafoVar = (zzafo) zzafrVarZzc.zzb(zzafo.class);
            if (zzafoVar == null) {
                throw zzaz.zza("AviHeader not found", null);
            }
            this.zzg = zzafoVar;
            this.zzh = ((long) zzafoVar.zzc) * ((long) zzafoVar.zza);
            ArrayList arrayList = new ArrayList();
            zzfyq zzfyqVar = zzafrVarZzc.zza;
            int size = zzfyqVar.size();
            int i4 = 0;
            int i5 = 0;
            while (i4 < size) {
                zzafj zzafjVar = (zzafj) zzfyqVar.get(i4);
                if (zzafjVar.zza() == 1819440243) {
                    zzafr zzafrVar = (zzafr) zzafjVar;
                    int i6 = i5 + 1;
                    zzafp zzafpVar = (zzafp) zzafrVar.zzb(zzafp.class);
                    zzafs zzafsVar = (zzafs) zzafrVar.zzb(zzafs.class);
                    if (zzafpVar == null) {
                        zzea.zzf("AviExtractor", "Missing Stream Header");
                    } else if (zzafsVar == null) {
                        zzea.zzf("AviExtractor", "Missing Stream Format");
                    } else {
                        long jZzc = zzafpVar.zzc();
                        zzz zzzVar = zzafsVar.zza;
                        zzx zzxVarZzb = zzzVar.zzb();
                        zzxVarZzb.zzR(i5);
                        int i7 = zzafpVar.zze;
                        if (i7 != 0) {
                            zzxVarZzb.zzX(i7);
                        }
                        zzaft zzaftVar = (zzaft) zzafrVar.zzb(zzaft.class);
                        if (zzaftVar != null) {
                            zzxVarZzb.zzU(zzaftVar.zza);
                        }
                        int iZzb = zzay.zzb(zzzVar.zzo);
                        if (iZzb == 1) {
                            zzafb zzafbVarZzw = this.zzf.zzw(i5, iZzb);
                            zzafbVarZzw.zzm(zzxVarZzb.zzan());
                            zzafbVarZzw.zzl(jZzc);
                            this.zzh = Math.max(this.zzh, jZzc);
                            zzafqVar = new zzafq(i5, zzafpVar, zzafbVarZzw);
                        } else if (iZzb == 2) {
                            iZzb = 2;
                            zzafb zzafbVarZzw2 = this.zzf.zzw(i5, iZzb);
                            zzafbVarZzw2.zzm(zzxVarZzb.zzan());
                            zzafbVarZzw2.zzl(jZzc);
                            this.zzh = Math.max(this.zzh, jZzc);
                            zzafqVar = new zzafq(i5, zzafpVar, zzafbVarZzw2);
                        } else {
                            zzafqVar = null;
                        }
                    }
                    if (zzafqVar != null) {
                        arrayList.add(zzafqVar);
                    }
                    i5 = i6;
                }
                i4++;
                zzafqVar = null;
            }
            this.zzi = (zzafq[]) arrayList.toArray(new zzafq[0]);
            this.zzf.zzG();
            this.zze = 3;
            return 0;
        }
        if (i == 3) {
            long j3 = this.zzm;
            if (j3 != -1 && zzadwVar.zzf() != j3) {
                this.zzj = j3;
                return 0;
            }
            zzen zzenVar3 = this.zza;
            zzadwVar.zzh(zzenVar3.zzN(), 0, 12);
            zzadwVar.zzj();
            zzenVar3.zzL(0);
            zzafl zzaflVar2 = this.zzb;
            zzaflVar2.zza(zzenVar3);
            int iZzi2 = zzenVar3.zzi();
            int i8 = zzaflVar2.zza;
            if (i8 == 1179011410) {
                zzadwVar.zzk(12);
                return 0;
            }
            if (i8 != 1414744396 || iZzi2 != 1769369453) {
                this.zzj = zzadwVar.zzf() + ((long) zzaflVar2.zzb) + 8;
                return 0;
            }
            long jZzf2 = zzadwVar.zzf();
            this.zzm = jZzf2;
            long j4 = jZzf2 + ((long) zzaflVar2.zzb) + 8;
            this.zzn = j4;
            if (!this.zzp) {
                zzafo zzafoVar2 = this.zzg;
                zzafoVar2.getClass();
                if ((zzafoVar2.zzb & 16) == 16) {
                    this.zze = 4;
                    this.zzj = j4;
                    return 0;
                }
                this.zzf.zzP(new zzaet(this.zzh, 0L));
                this.zzp = true;
            }
            this.zzj = zzadwVar.zzf() + 12;
            this.zze = 6;
            return 0;
        }
        if (i == 4) {
            zzen zzenVar4 = this.zza;
            zzadwVar.zzi(zzenVar4.zzN(), 0, 8);
            zzenVar4.zzL(0);
            int iZzi3 = zzenVar4.zzi();
            int iZzi4 = zzenVar4.zzi();
            if (iZzi3 == 829973609) {
                this.zze = 5;
                this.zzo = iZzi4;
            } else {
                this.zzj = zzadwVar.zzf() + ((long) iZzi4);
            }
            return 0;
        }
        if (i == 5) {
            zzen zzenVar5 = new zzen(this.zzo);
            zzadwVar.zzi(zzenVar5.zzN(), 0, this.zzo);
            if (zzenVar5.zza() < 16) {
                j = 0;
            } else {
                int iZzc = zzenVar5.zzc();
                zzenVar5.zzM(8);
                long jZzi = zzenVar5.zzi();
                long j5 = this.zzm;
                j = jZzi > j5 ? 0L : 8 + j5;
                zzenVar5.zzL(iZzc);
            }
            while (zzenVar5.zza() >= 16) {
                int iZzi5 = zzenVar5.zzi();
                int iZzi6 = zzenVar5.zzi();
                long jZzi2 = ((long) zzenVar5.zzi()) + j;
                zzenVar5.zzM(4);
                zzafq zzafqVarZzg = zzg(iZzi5);
                if (zzafqVarZzg != null) {
                    zzafqVarZzg.zzb(jZzi2, (iZzi6 & 16) == 16);
                }
            }
            for (zzafq zzafqVar2 : this.zzi) {
                zzafqVar2.zzc();
            }
            this.zzp = true;
            if (this.zzi.length == 0) {
                this.zzf.zzP(new zzaet(this.zzh, 0L));
            } else {
                this.zzf.zzP(new zzafk(this, this.zzh));
            }
            this.zze = 6;
            this.zzj = this.zzm;
            return 0;
        }
        if (zzadwVar.zzf() >= this.zzn) {
            return -1;
        }
        zzafq zzafqVar3 = this.zzk;
        if (zzafqVar3 != null) {
            if (!zzafqVar3.zzg(zzadwVar)) {
                return 0;
            }
            this.zzk = null;
            return 0;
        }
        if ((zzadwVar.zzf() & 1) == 1) {
            zzadwVar.zzk(1);
        }
        zzen zzenVar6 = this.zza;
        zzadwVar.zzh(zzenVar6.zzN(), 0, 12);
        zzenVar6.zzL(0);
        int iZzi7 = zzenVar6.zzi();
        if (iZzi7 == 1414744396) {
            zzenVar6.zzL(8);
            zzadwVar.zzk(zzenVar6.zzi() != 1769369453 ? 8 : 12);
            zzadwVar.zzj();
            return 0;
        }
        int iZzi8 = zzenVar6.zzi();
        if (iZzi7 == 1263424842) {
            this.zzj = zzadwVar.zzf() + ((long) iZzi8) + 8;
            return 0;
        }
        zzadwVar.zzk(8);
        zzadwVar.zzj();
        zzafq zzafqVarZzg2 = zzg(iZzi7);
        if (zzafqVarZzg2 == null) {
            this.zzj = zzadwVar.zzf() + ((long) iZzi8);
            return 0;
        }
        zzafqVarZzg2.zzd(iZzi8);
        this.zzk = zzafqVarZzg2;
        return 0;
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
        this.zze = 0;
        if (this.zzc) {
            zzadyVar = new zzaku(zzadyVar, this.zzd);
        }
        this.zzf = zzadyVar;
        this.zzj = -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zzf(long j, long j2) {
        this.zzj = -1L;
        this.zzk = null;
        for (zzafq zzafqVar : this.zzi) {
            zzafqVar.zze(j);
        }
        if (j == 0) {
            this.zze = this.zzi.length != 0 ? 3 : 0;
        } else {
            this.zze = 6;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final boolean zzi(zzadw zzadwVar) {
        zzen zzenVar = this.zza;
        zzadwVar.zzh(zzenVar.zzN(), 0, 12);
        zzenVar.zzL(0);
        if (zzenVar.zzi() != 1179011410) {
            return false;
        }
        zzenVar.zzM(4);
        return zzenVar.zzi() == 541677121;
    }

    public zzafn(int i, zzakr zzakrVar) {
        this.zzd = zzakrVar;
        this.zzc = 1 == (i ^ 1);
        this.zza = new zzen(12);
        this.zzb = new zzafl(null);
        this.zzf = new zzaep();
        this.zzi = new zzafq[0];
        this.zzm = -1L;
        this.zzn = -1L;
        this.zzl = -1;
        this.zzh = -9223372036854775807L;
    }
}
