package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzaoj implements zzadv {
    private final int zza;
    private final List zzb;
    private final zzen zzc;
    private final SparseIntArray zzd;
    private final zzaom zze;
    private final zzakr zzf;
    private final SparseArray zzg;
    private final SparseBooleanArray zzh;
    private final SparseBooleanArray zzi;
    private final zzaog zzj;
    private zzaof zzk;
    private zzady zzl;
    private int zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private int zzq;
    private int zzr;

    @Deprecated
    public zzaoj() {
        this(1, 1, zzakr.zza, new zzeu(0L), new zzamw(0), 112800);
    }

    /* JADX WARN: Code duplicated, block: B:97:0x019f  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [int] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [android.util.SparseArray] */
    /* JADX WARN: Type inference failed for: r1v9, types: [com.google.android.gms.internal.ads.zzant] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.util.SparseBooleanArray] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2, types: [com.google.android.gms.internal.ads.zzaoo] */
    /* JADX WARN: Type inference failed for: r9v7 */
    @Override // com.google.android.gms.internal.ads.zzadv
    public final int zzb(zzadw zzadwVar, zzaer zzaerVar) {
        ?? r3;
        ?? r9;
        zzaoo zzaooVar;
        long j;
        boolean z;
        long jZzd = zzadwVar.zzd();
        if (this.zzn) {
            if (jZzd != -1) {
                zzaog zzaogVar = this.zzj;
                if (!zzaogVar.zzd()) {
                    return zzaogVar.zza(zzadwVar, zzaerVar, this.zzr);
                }
            }
            if (this.zzo) {
                j = 0;
            } else {
                this.zzo = true;
                zzaog zzaogVar2 = this.zzj;
                if (zzaogVar2.zzb() != -9223372036854775807L) {
                    j = 0;
                    zzaof zzaofVar = new zzaof(zzaogVar2.zzc(), zzaogVar2.zzb(), jZzd, this.zzr, 112800);
                    this.zzk = zzaofVar;
                    this.zzl.zzP(zzaofVar.zzb());
                } else {
                    j = 0;
                    this.zzl.zzP(new zzaet(zzaogVar2.zzb(), 0L));
                }
            }
            if (this.zzp) {
                z = false;
                this.zzp = false;
                zzf(j, j);
                if (zzadwVar.zzf() != j) {
                    zzaerVar.zza = j;
                    return 1;
                }
            } else {
                z = false;
            }
            zzaof zzaofVar2 = this.zzk;
            r3 = z;
            if (zzaofVar2 != null && zzaofVar2.zze()) {
                r3 = z;
                return zzaofVar2.zza(zzadwVar, zzaerVar);
            }
        } else {
            r3 = 0;
        }
        r3 = z;
        zzen zzenVar = this.zzc;
        byte[] bArrZzN = zzenVar.zzN();
        if (9400 - zzenVar.zzc() < 188) {
            int iZza = zzenVar.zza();
            if (iZza > 0) {
                System.arraycopy(bArrZzN, zzenVar.zzc(), bArrZzN, r3, iZza);
            }
            zzenVar.zzJ(bArrZzN, iZza);
        }
        while (zzenVar.zza() < 188) {
            int iZzd = zzenVar.zzd();
            int iZza2 = zzadwVar.zza(bArrZzN, iZzd, 9400 - iZzd);
            if (iZza2 == -1) {
                ?? r10 = r3;
                while (true) {
                    ?? r1 = this.zzg;
                    if (r10 >= r1.size()) {
                        return -1;
                    }
                    zzaoo zzaooVar2 = (zzaoo) r1.valueAt(r10);
                    if (zzaooVar2 instanceof zzant) {
                        ?? r2 = (zzant) zzaooVar2;
                        if (r2.zzd(r3)) {
                            r2.zza(new zzen(), 1);
                        }
                    }
                    r10++;
                }
            } else {
                zzenVar.zzK(iZzd + iZza2);
            }
        }
        int iZzc = zzenVar.zzc();
        int iZzd2 = zzenVar.zzd();
        int iZza3 = zzaop.zza(zzenVar.zzN(), iZzc, iZzd2);
        zzenVar.zzL(iZza3);
        int i = iZza3 + 188;
        if (i > iZzd2) {
            this.zzq = (iZza3 - iZzc) + this.zzq;
        } else {
            this.zzq = r3;
        }
        int iZzd3 = zzenVar.zzd();
        if (i > iZzd3) {
            return r3;
        }
        int iZzg = zzenVar.zzg();
        if ((8388608 & iZzg) != 0) {
            zzenVar.zzL(i);
            return r3;
        }
        ?? r11 = (4194304 & iZzg) != 0 ? 1 : r3;
        int i2 = iZzg & 32;
        int i3 = (iZzg >> 8) & 8191;
        if ((iZzg & 16) != 0) {
            zzaooVar = (zzaoo) this.zzg.get(i3);
        } else {
            r9 = 0;
        }
        if (r9 == 0) {
            r9 = zzaooVar;
            zzenVar.zzL(i);
            return r3;
        }
        int i4 = iZzg & 15;
        SparseIntArray sparseIntArray = this.zzd;
        int i5 = sparseIntArray.get(i3, i4 - 1);
        sparseIntArray.put(i3, i4);
        if (i5 == i4) {
            r9 = zzaooVar;
            zzenVar.zzL(i);
            return r3;
        }
        if (i4 != ((i5 + 1) & 15)) {
            r9 = zzaooVar;
            r9.zzc();
        }
        if (i2 != 0) {
            int iZzm = zzenVar.zzm();
            r11 = (r11 == true ? 1 : 0) | ((zzenVar.zzm() & 64) != 0 ? 2 : r3);
            zzenVar.zzM(iZzm - 1);
        }
        boolean z2 = this.zzn;
        if (z2 || !this.zzi.get(i3, r3)) {
            zzenVar.zzK(i);
            r9.zza(zzenVar, r11);
            zzenVar.zzK(iZzd3);
            if (!z2) {
                if (this.zzn && jZzd != -1) {
                    this.zzp = true;
                }
            }
        } else if (this.zzn) {
            this.zzp = true;
        }
        zzenVar.zzL(i);
        return r3;
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
        if (this.zza == 0) {
            zzadyVar = new zzaku(zzadyVar, this.zzf);
        }
        this.zzl = zzadyVar;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002f  */
    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zzf(long j, long j2) {
        zzaof zzaofVar;
        List list = this.zzb;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            zzeu zzeuVar = (zzeu) list.get(i);
            if (zzeuVar.zzf() != -9223372036854775807L) {
                long jZzd = zzeuVar.zzd();
                if (jZzd != -9223372036854775807L && jZzd != 0 && jZzd != j2) {
                    zzeuVar.zzi(j2);
                }
            } else {
                zzeuVar.zzi(j2);
            }
        }
        if (j2 != 0 && (zzaofVar = this.zzk) != null) {
            zzaofVar.zzd(j2);
        }
        this.zzc.zzI(0);
        this.zzd.clear();
        int i2 = 0;
        while (true) {
            SparseArray sparseArray = this.zzg;
            if (i2 >= sparseArray.size()) {
                this.zzq = 0;
                return;
            } else {
                ((zzaoo) sparseArray.valueAt(i2)).zzc();
                i2++;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final boolean zzi(zzadw zzadwVar) throws EOFException, InterruptedIOException {
        byte[] bArrZzN = this.zzc.zzN();
        zzadl zzadlVar = (zzadl) zzadwVar;
        zzadlVar.zzm(bArrZzN, 0, 940, false);
        for (int i = 0; i < 188; i++) {
            int i2 = 0;
            while (true) {
                if (i2 >= 5) {
                    zzadlVar.zzo(i, false);
                    return true;
                }
                if (bArrZzN[(i2 * 188) + i] != 71) {
                    break;
                }
                i2++;
            }
        }
        return false;
    }

    public zzaoj(int i, int i2, zzakr zzakrVar, zzeu zzeuVar, zzaom zzaomVar, int i3) {
        this.zze = zzaomVar;
        this.zza = i2;
        this.zzf = zzakrVar;
        this.zzb = Collections.singletonList(zzeuVar);
        this.zzc = new zzen(new byte[9400], 0);
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        this.zzh = sparseBooleanArray;
        this.zzi = new SparseBooleanArray();
        SparseArray sparseArray = new SparseArray();
        this.zzg = sparseArray;
        this.zzd = new SparseIntArray();
        this.zzj = new zzaog(112800);
        this.zzl = zzady.zza;
        this.zzr = -1;
        sparseBooleanArray.clear();
        sparseArray.clear();
        SparseArray sparseArrayZza = zzaomVar.zza();
        int size = sparseArrayZza.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.zzg.put(sparseArrayZza.keyAt(i4), (zzaoo) sparseArrayZza.valueAt(i4));
        }
        this.zzg.put(0, new zzaob(new zzaoh(this)));
    }
}
