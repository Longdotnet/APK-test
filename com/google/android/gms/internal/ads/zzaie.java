package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.math.RoundingMode;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzaie implements zzadv {
    private final zzen zza;
    private final zzaen zzb;
    private final zzaej zzc;
    private final zzael zzd;
    private final zzafb zze;
    private zzady zzf;
    private zzafb zzg;
    private zzafb zzh;
    private int zzi;
    private zzav zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private int zzo;
    private zzaig zzp;
    private boolean zzq;

    public zzaie() {
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:124:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:125:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:129:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:24:0x005f  */
    /* JADX WARN: Code duplicated, block: B:26:0x0067  */
    /* JADX WARN: Code duplicated, block: B:28:0x0070  */
    /* JADX WARN: Code duplicated, block: B:29:0x0072  */
    /* JADX WARN: Code duplicated, block: B:34:0x007c  */
    /* JADX WARN: Code duplicated, block: B:36:0x0093  */
    /* JADX WARN: Code duplicated, block: B:45:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:47:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:49:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:52:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:53:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:56:0x0106  */
    /* JADX WARN: Code duplicated, block: B:58:0x010c  */
    /* JADX WARN: Code duplicated, block: B:60:0x0117  */
    /* JADX WARN: Code duplicated, block: B:62:0x011b  */
    /* JADX WARN: Instruction removed from duplicated block: B:49:0x00c8, please report this as an issue */
    private final int zzg(zzadw zzadwVar) {
        int iZzf;
        int i;
        int iZzg;
        zzaii zzaiiVarZzb;
        zzaej zzaejVar;
        long jZzf;
        long jZzd;
        long jZza;
        long j;
        int i2;
        zzaig zzaibVar;
        long j2;
        long j3;
        int i3;
        int i4;
        zzaid zzaidVarZzb;
        zzaig zzaibVar2;
        long jZzs;
        if (this.zzi == 0) {
            try {
                zzm(zzadwVar, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.zzp == null) {
            zzaen zzaenVar = this.zzb;
            zzen zzenVar = new zzen(zzaenVar.zzc);
            zzadwVar.zzh(zzenVar.zzN(), 0, zzaenVar.zzc);
            int i5 = 21;
            if ((zzaenVar.zza & 1) != 0) {
                if (zzaenVar.zze != 1) {
                    i5 = 36;
                }
            } else if (zzaenVar.zze == 1) {
                i5 = 13;
            }
            if (zzenVar.zzd() >= i5 + 4) {
                zzenVar.zzL(i5);
                iZzg = zzenVar.zzg();
                if (iZzg != 1483304551) {
                    if (iZzg == 1231971951) {
                        iZzg = 1231971951;
                    } else if (zzenVar.zzd() >= 40) {
                        zzenVar.zzL(36);
                        if (zzenVar.zzg() == 1447187017) {
                            iZzg = 1447187017;
                        } else {
                            iZzg = 0;
                        }
                    } else {
                        iZzg = 0;
                    }
                }
            } else if (zzenVar.zzd() >= 40) {
                zzenVar.zzL(36);
                if (zzenVar.zzg() == 1447187017) {
                    iZzg = 1447187017;
                } else {
                    iZzg = 0;
                }
            } else {
                iZzg = 0;
            }
            if (iZzg == 1231971951) {
                zzaiiVarZzb = zzaii.zzb(zzaenVar, zzenVar);
                zzaejVar = this.zzc;
                if (!zzaejVar.zza() && (i3 = zzaiiVarZzb.zzd) != -1 && (i4 = zzaiiVarZzb.zze) != -1) {
                    zzaejVar.zza = i3;
                    zzaejVar.zzb = i4;
                }
                jZzf = zzadwVar.zzf();
                if (zzadwVar.zzd() != -1) {
                    j2 = zzaiiVarZzb.zzc;
                    if (j2 != -1) {
                        j3 = j2 + jZzf;
                        if (zzadwVar.zzd() != j3) {
                            zzea.zze("Mp3Extractor", "Data size mismatch between stream (" + zzadwVar.zzd() + ") and Xing frame (" + j3 + "), using Xing value.");
                        }
                    }
                }
                zzadwVar.zzk(zzaenVar.zzc);
                if (iZzg == 1483304551) {
                    zzaibVar = zzaij.zzb(zzaiiVarZzb, jZzf);
                } else {
                    jZzd = zzadwVar.zzd();
                    jZza = zzaiiVarZzb.zza();
                    if (jZza != -9223372036854775807L) {
                        zzaibVar = null;
                    } else {
                        j = zzaiiVarZzb.zzc;
                        if (j != -1) {
                            jZzd = jZzf + j;
                            i2 = zzaiiVarZzb.zza.zzc;
                        } else if (jZzd != -1) {
                            j = jZzd - jZzf;
                            i2 = zzaiiVarZzb.zza.zzc;
                        } else {
                            zzaibVar = null;
                        }
                        long j4 = j - ((long) i2);
                        long j5 = jZzd;
                        RoundingMode roundingMode = RoundingMode.HALF_UP;
                        zzaibVar = new zzaib(j5, jZzf + ((long) zzaiiVarZzb.zza.zzc), zzgbt.zzb(zzex.zzu(j4, 8000000L, jZza, roundingMode)), zzgbt.zzb(zzgbo.zzb(j4, zzaiiVarZzb.zzb, roundingMode)), false);
                    }
                }
            } else if (iZzg != 1447187017) {
                if (iZzg != 1483304551) {
                    zzadwVar.zzj();
                } else {
                    zzaiiVarZzb = zzaii.zzb(zzaenVar, zzenVar);
                    zzaejVar = this.zzc;
                    if (!zzaejVar.zza()) {
                        zzaejVar.zza = i3;
                        zzaejVar.zzb = i4;
                    }
                    jZzf = zzadwVar.zzf();
                    if (zzadwVar.zzd() != -1) {
                        j2 = zzaiiVarZzb.zzc;
                        if (j2 != -1) {
                            j3 = j2 + jZzf;
                            if (zzadwVar.zzd() != j3) {
                                zzea.zze("Mp3Extractor", "Data size mismatch between stream (" + zzadwVar.zzd() + ") and Xing frame (" + j3 + "), using Xing value.");
                            }
                        }
                    }
                    zzadwVar.zzk(zzaenVar.zzc);
                    if (iZzg == 1483304551) {
                        zzaibVar = zzaij.zzb(zzaiiVarZzb, jZzf);
                    } else {
                        jZzd = zzadwVar.zzd();
                        jZza = zzaiiVarZzb.zza();
                        if (jZza != -9223372036854775807L) {
                            j = zzaiiVarZzb.zzc;
                            if (j != -1) {
                                jZzd = jZzf + j;
                                i2 = zzaiiVarZzb.zza.zzc;
                            } else if (jZzd != -1) {
                                j = jZzd - jZzf;
                                i2 = zzaiiVarZzb.zza.zzc;
                            }
                            long j6 = j - ((long) i2);
                            long j7 = jZzd;
                            RoundingMode roundingMode2 = RoundingMode.HALF_UP;
                            zzaibVar = new zzaib(j7, jZzf + ((long) zzaiiVarZzb.zza.zzc), zzgbt.zzb(zzex.zzu(j6, 8000000L, jZza, roundingMode2)), zzgbt.zzb(zzgbo.zzb(j6, zzaiiVarZzb.zzb, roundingMode2)), false);
                        }
                    }
                }
                zzaibVar = null;
            } else {
                zzaibVar = zzaih.zzb(zzadwVar.zzd(), zzadwVar.zzf(), zzaenVar, zzenVar);
                zzadwVar.zzk(zzaenVar.zzc);
            }
            zzav zzavVar = this.zzj;
            long jZzf2 = zzadwVar.zzf();
            if (zzavVar == null) {
                zzaidVarZzb = null;
                break;
            }
            int iZza = zzavVar.zza();
            int i6 = 0;
            while (true) {
                if (i6 >= iZza) {
                    zzaidVarZzb = null;
                    break;
                }
                zzau zzauVarZzb = zzavVar.zzb(i6);
                if (zzauVarZzb instanceof zzahi) {
                    zzahi zzahiVar = (zzahi) zzauVarZzb;
                    int iZza2 = zzavVar.zza();
                    int i7 = 0;
                    while (true) {
                        if (i7 >= iZza2) {
                            jZzs = -9223372036854775807L;
                            break;
                        }
                        zzau zzauVarZzb2 = zzavVar.zzb(i7);
                        if (zzauVarZzb2 instanceof zzahk) {
                            zzahk zzahkVar = (zzahk) zzauVarZzb2;
                            if (zzahkVar.zzf.equals("TLEN")) {
                                jZzs = zzex.zzs(Long.parseLong((String) zzahkVar.zzb.get(0)));
                                break;
                            }
                        }
                        i7++;
                    }
                    zzaidVarZzb = zzaid.zzb(jZzf2, zzahiVar, jZzs);
                    break;
                }
                i6++;
            }
            if (this.zzq) {
                zzaibVar2 = new zzaif();
            } else {
                if (zzaidVarZzb != null) {
                    zzaibVar = zzaidVarZzb;
                } else if (zzaibVar == null) {
                    zzaibVar = null;
                }
                if (zzaibVar == null) {
                    zzen zzenVar2 = this.zza;
                    zzadwVar.zzh(zzenVar2.zzN(), 0, 4);
                    zzenVar2.zzL(0);
                    zzaenVar.zza(zzenVar2.zzg());
                    zzaibVar2 = new zzaib(zzadwVar.zzd(), zzadwVar.zzf(), zzaenVar.zzf, zzaenVar.zzc, false);
                } else {
                    zzaibVar2 = zzaibVar;
                }
                this.zzg.zzl(zzaibVar2.zza());
            }
            this.zzp = zzaibVar2;
            this.zzf.zzP(zzaibVar2);
            zzx zzxVar = new zzx();
            zzxVar.zzG("audio/mpeg");
            zzxVar.zzah(zzaenVar.zzb);
            zzxVar.zzX(4096);
            zzxVar.zzD(zzaenVar.zze);
            zzxVar.zzai(zzaenVar.zzd);
            zzaej zzaejVar2 = this.zzc;
            zzxVar.zzM(zzaejVar2.zza);
            zzxVar.zzN(zzaejVar2.zzb);
            zzxVar.zzaa(this.zzj);
            if (this.zzp.zzc() != -2147483647) {
                zzxVar.zzC(this.zzp.zzc());
            }
            this.zzh.zzm(zzxVar.zzan());
            this.zzm = zzadwVar.zzf();
        } else {
            long j8 = this.zzm;
            if (j8 != 0) {
                long jZzf3 = zzadwVar.zzf();
                if (jZzf3 < j8) {
                    zzadwVar.zzk((int) (j8 - jZzf3));
                }
            }
        }
        int i8 = this.zzo;
        if (i8 == 0) {
            zzadwVar.zzj();
            if (zzl(zzadwVar)) {
                return -1;
            }
            zzen zzenVar3 = this.zza;
            zzenVar3.zzL(0);
            int iZzg2 = zzenVar3.zzg();
            if (!zzk(iZzg2, this.zzi) || zzaeo.zzb(iZzg2) == -1) {
                zzadwVar.zzk(1);
                this.zzi = 0;
            } else {
                zzaen zzaenVar2 = this.zzb;
                zzaenVar2.zza(iZzg2);
                if (this.zzk == -9223372036854775807L) {
                    this.zzk = this.zzp.zze(zzadwVar.zzf());
                }
                i8 = zzaenVar2.zzc;
                this.zzo = i8;
                this.zzn = zzadwVar.zzf() + ((long) i8);
                if (this.zzp instanceof zzaic) {
                    zzh(this.zzl + ((long) zzaenVar2.zzg));
                    throw null;
                }
                iZzf = this.zzh.zzf(zzadwVar, i8, true);
                if (iZzf == -1) {
                    return -1;
                }
                i = this.zzo - iZzf;
                this.zzo = i;
                if (i <= 0) {
                    zzafb zzafbVar = this.zzh;
                    long jZzh = zzh(this.zzl);
                    zzaen zzaenVar3 = this.zzb;
                    zzafbVar.zzt(jZzh, 1, zzaenVar3.zzc, 0, null);
                    this.zzl += (long) zzaenVar3.zzg;
                    this.zzo = 0;
                    return 0;
                }
            }
        } else {
            iZzf = this.zzh.zzf(zzadwVar, i8, true);
            if (iZzf == -1) {
                return -1;
            }
            i = this.zzo - iZzf;
            this.zzo = i;
            if (i <= 0) {
                zzafb zzafbVar2 = this.zzh;
                long jZzh2 = zzh(this.zzl);
                zzaen zzaenVar4 = this.zzb;
                zzafbVar2.zzt(jZzh2, 1, zzaenVar4.zzc, 0, null);
                this.zzl += (long) zzaenVar4.zzg;
                this.zzo = 0;
                return 0;
            }
        }
        return 0;
    }

    private final long zzh(long j) {
        zzaen zzaenVar = this.zzb;
        return ((j * 1000000) / ((long) zzaenVar.zzd)) + this.zzk;
    }

    private final void zzj() {
        zzaig zzaigVar = this.zzp;
        if ((zzaigVar instanceof zzaib) && zzaigVar.zzh()) {
            long j = this.zzn;
            if (j == -1 || j == this.zzp.zzd()) {
                return;
            }
            this.zzp = ((zzaib) this.zzp).zzf(this.zzn);
            zzady zzadyVar = this.zzf;
            zzadyVar.getClass();
            zzadyVar.zzP(this.zzp);
            this.zzg.getClass();
            this.zzp.zza();
        }
    }

    private static boolean zzk(int i, long j) {
        return ((long) (i & (-128000))) == (j & (-128000));
    }

    private final boolean zzl(zzadw zzadwVar) {
        zzaig zzaigVar = this.zzp;
        if (zzaigVar != null) {
            long jZzd = zzaigVar.zzd();
            if (jZzd != -1 && zzadwVar.zze() > jZzd - 4) {
                return true;
            }
        }
        try {
            return !zzadwVar.zzm(this.zza.zzN(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    private final boolean zzm(zzadw zzadwVar, boolean z) throws EOFException {
        int iZze;
        int i;
        int iZzb;
        zzadwVar.zzj();
        if (zzadwVar.zzf() == 0) {
            zzav zzavVarZza = this.zzd.zza(zzadwVar, null);
            this.zzj = zzavVarZza;
            if (zzavVarZza != null) {
                this.zzc.zzb(zzavVarZza);
            }
            iZze = (int) zzadwVar.zze();
            if (!z) {
                zzadwVar.zzk(iZze);
            }
            i = 0;
        } else {
            iZze = 0;
            i = 0;
        }
        int i2 = i;
        int i3 = i2;
        while (true) {
            if (zzl(zzadwVar)) {
                if (i2 > 0) {
                    break;
                }
                zzj();
                throw new EOFException();
            }
            zzen zzenVar = this.zza;
            zzenVar.zzL(0);
            int iZzg = zzenVar.zzg();
            if ((i == 0 || zzk(iZzg, i)) && (iZzb = zzaeo.zzb(iZzg)) != -1) {
                i2++;
                if (i2 != 1) {
                    if (i2 == 4) {
                        break;
                    }
                } else {
                    this.zzb.zza(iZzg);
                    i = iZzg;
                }
                zzadwVar.zzg(iZzb - 4);
            } else {
                int i4 = i3 + 1;
                if (i3 == (true != z ? 131072 : 32768)) {
                    if (z) {
                        return false;
                    }
                    zzj();
                    throw new EOFException();
                }
                if (z) {
                    zzadwVar.zzj();
                    zzadwVar.zzg(iZze + i4);
                } else {
                    zzadwVar.zzk(1);
                }
                i = 0;
                i3 = i4;
                i2 = 0;
            }
        }
        if (z) {
            zzadwVar.zzk(iZze + i3);
        } else {
            zzadwVar.zzj();
        }
        this.zzi = i;
        return true;
    }

    public final void zza() {
        this.zzq = true;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final int zzb(zzadw zzadwVar, zzaer zzaerVar) {
        zzdd.zzb(this.zzg);
        String str = zzex.zza;
        int iZzg = zzg(zzadwVar);
        if (iZzg == -1 && (this.zzp instanceof zzaic)) {
            if (this.zzp.zza() != zzh(this.zzl)) {
                throw null;
            }
        }
        return iZzg;
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
        zzafb zzafbVarZzw = zzadyVar.zzw(0, 1);
        this.zzg = zzafbVarZzw;
        this.zzh = zzafbVarZzw;
        this.zzf.zzG();
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zzf(long j, long j2) {
        this.zzi = 0;
        this.zzk = -9223372036854775807L;
        this.zzl = 0L;
        this.zzo = 0;
        if (this.zzp instanceof zzaic) {
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final boolean zzi(zzadw zzadwVar) {
        return zzm(zzadwVar, true);
    }

    public zzaie(int i) {
        this.zza = new zzen(10);
        this.zzb = new zzaen();
        this.zzc = new zzaej();
        this.zzk = -9223372036854775807L;
        this.zzd = new zzael();
        zzadr zzadrVar = new zzadr();
        this.zze = zzadrVar;
        this.zzh = zzadrVar;
        this.zzn = -1L;
    }
}
