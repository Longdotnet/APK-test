package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseIntArray;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzaoi implements zzaoa {
    final /* synthetic */ zzaoj zza;
    private final zzem zzb;
    private final SparseArray zzc;
    private final SparseIntArray zzd;
    private final int zze;

    public zzaoi(zzaoj zzaojVar, int i) {
        Objects.requireNonNull(zzaojVar);
        this.zza = zzaojVar;
        this.zzb = new zzem(new byte[5], 5);
        this.zzc = new SparseArray();
        this.zzd = new SparseIntArray();
        this.zze = i;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:23:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:26:0x00de  */
    @Override // com.google.android.gms.internal.ads.zzaoa
    public final void zza(zzen zzenVar) {
        zzeu zzeuVar;
        int i;
        int i2;
        if (zzenVar.zzm() == 2) {
            zzaoj zzaojVar = this.zza;
            zzeu zzeuVar2 = (zzeu) zzaojVar.zzb.get(0);
            if ((zzenVar.zzm() & 128) != 0) {
                zzenVar.zzM(1);
                int iZzq = zzenVar.zzq();
                int i3 = 3;
                zzenVar.zzM(3);
                zzem zzemVar = this.zzb;
                zzenVar.zzG(zzemVar, 2);
                zzemVar.zzn(3);
                int i4 = 13;
                zzaojVar.zzr = zzemVar.zzd(13);
                zzenVar.zzG(zzemVar, 2);
                int i5 = 4;
                zzemVar.zzn(4);
                int i6 = 12;
                zzenVar.zzM(zzemVar.zzd(12));
                SparseArray sparseArray = this.zzc;
                sparseArray.clear();
                SparseIntArray sparseIntArray = this.zzd;
                sparseIntArray.clear();
                int iZza = zzenVar.zza();
                while (iZza > 0) {
                    int i7 = 5;
                    zzenVar.zzG(zzemVar, 5);
                    int iZzd = zzemVar.zzd(8);
                    zzemVar.zzn(i3);
                    int iZzd2 = zzemVar.zzd(i4);
                    zzemVar.zzn(i5);
                    int iZzd3 = zzemVar.zzd(i6);
                    int iZzc = zzenVar.zzc();
                    int i8 = iZzc + iZzd3;
                    String str = null;
                    ArrayList arrayList = null;
                    int i9 = -1;
                    int iZzm = 0;
                    while (zzenVar.zzc() < i8) {
                        int iZzm2 = zzenVar.zzm();
                        int iZzc2 = zzenVar.zzc() + zzenVar.zzm();
                        if (iZzc2 > i8) {
                            break;
                        }
                        if (iZzm2 == i7) {
                            long jZzu = zzenVar.zzu();
                            if (jZzu == 1094921523) {
                                i9 = 129;
                            } else if (jZzu == 1161904947) {
                                i9 = 135;
                            } else if (jZzu == 1094921524) {
                                i9 = 172;
                            } else if (jZzu == 1212503619) {
                                i2 = 36;
                                i9 = i2;
                            }
                        } else if (iZzm2 == 106) {
                            i9 = 129;
                        } else if (iZzm2 == 122) {
                            i9 = 135;
                        } else if (iZzm2 == 127) {
                            int iZzm3 = zzenVar.zzm();
                            if (iZzm3 == 21) {
                                i9 = 172;
                            } else {
                                if (iZzm3 == 14) {
                                    i2 = 136;
                                } else if (iZzm3 == 33) {
                                    i2 = 139;
                                }
                                i9 = i2;
                            }
                        } else if (iZzm2 == 123) {
                            i2 = 138;
                            i9 = i2;
                        } else if (iZzm2 == 10) {
                            String strTrim = zzenVar.zzB(3, StandardCharsets.UTF_8).trim();
                            iZzm = zzenVar.zzm();
                            str = strTrim;
                        } else if (iZzm2 == 89) {
                            ArrayList arrayList2 = new ArrayList();
                            while (zzenVar.zzc() < iZzc2) {
                                zzem zzemVar2 = zzemVar;
                                String strTrim2 = zzenVar.zzB(3, StandardCharsets.UTF_8).trim();
                                int iZzm4 = zzenVar.zzm();
                                zzeu zzeuVar3 = zzeuVar2;
                                byte[] bArr = new byte[4];
                                zzenVar.zzH(bArr, 0, 4);
                                arrayList2.add(new zzaok(strTrim2, iZzm4, bArr));
                                zzeuVar2 = zzeuVar3;
                                zzemVar = zzemVar2;
                                iZzq = iZzq;
                            }
                            zzeuVar2 = zzeuVar2;
                            iZzq = iZzq;
                            zzemVar = zzemVar;
                            arrayList = arrayList2;
                            i9 = 89;
                        } else {
                            zzeuVar2 = zzeuVar2;
                            iZzq = iZzq;
                            zzemVar = zzemVar;
                            if (iZzm2 == 111) {
                                i9 = 257;
                            }
                        }
                        zzenVar.zzM(iZzc2 - zzenVar.zzc());
                        zzeuVar2 = zzeuVar2;
                        zzemVar = zzemVar;
                        iZzq = iZzq;
                        i7 = 5;
                    }
                    zzeu zzeuVar4 = zzeuVar2;
                    int i10 = iZzq;
                    zzem zzemVar3 = zzemVar;
                    zzenVar.zzL(i8);
                    zzaol zzaolVar = new zzaol(i9, str, iZzm, arrayList, Arrays.copyOfRange(zzenVar.zzN(), iZzc, i8));
                    if (iZzd == 6 || iZzd == 5) {
                        iZzd = zzaolVar.zza;
                    }
                    iZza -= iZzd3 + 5;
                    if (!zzaojVar.zzh.get(iZzd2)) {
                        zzaoo zzaooVarZzb = zzaojVar.zze.zzb(iZzd, zzaolVar);
                        sparseIntArray.put(iZzd2, iZzd2);
                        sparseArray.put(iZzd2, zzaooVarZzb);
                    }
                    i5 = 4;
                    zzeuVar2 = zzeuVar4;
                    zzemVar = zzemVar3;
                    iZzq = i10;
                    i3 = 3;
                    i4 = 13;
                    i6 = 12;
                }
                zzeu zzeuVar5 = zzeuVar2;
                int i11 = iZzq;
                int size = sparseIntArray.size();
                int i12 = 0;
                while (i12 < size) {
                    int iKeyAt = sparseIntArray.keyAt(i12);
                    int iValueAt = sparseIntArray.valueAt(i12);
                    zzaojVar.zzh.put(iKeyAt, true);
                    zzaojVar.zzi.put(iValueAt, true);
                    zzaoo zzaooVar = (zzaoo) sparseArray.valueAt(i12);
                    if (zzaooVar != null) {
                        zzady zzadyVar = zzaojVar.zzl;
                        i = i11;
                        zzaon zzaonVar = new zzaon(i, iKeyAt, 8192);
                        zzeuVar = zzeuVar5;
                        zzaooVar.zzb(zzeuVar, zzadyVar, zzaonVar);
                        zzaojVar.zzg.put(iValueAt, zzaooVar);
                    } else {
                        zzeuVar = zzeuVar5;
                        i = i11;
                    }
                    i12++;
                    zzeuVar5 = zzeuVar;
                    i11 = i;
                }
                zzaojVar.zzg.remove(this.zze);
                zzaojVar.zzm = 0;
                if (zzaojVar.zzm == 0) {
                    zzaojVar.zzl.zzG();
                    zzaojVar.zzn = true;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaoa
    public final void zzb(zzeu zzeuVar, zzady zzadyVar, zzaon zzaonVar) {
    }
}
