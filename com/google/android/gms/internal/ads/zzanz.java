package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzanz implements zzadv {
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private long zzh;
    private zzanw zzi;
    private zzady zzj;
    private boolean zzk;
    private final zzeu zza = new zzeu(0);
    private final zzen zzc = new zzen(4096);
    private final SparseArray zzb = new SparseArray();
    private final zzanx zzd = new zzanx();

    /* JADX WARN: Code duplicated, block: B:64:0x013b  */
    @Override // com.google.android.gms.internal.ads.zzadv
    public final int zzb(zzadw zzadwVar, zzaer zzaerVar) {
        zzamz zzanbVar;
        zzdd.zzb(this.zzj);
        long jZzd = zzadwVar.zzd();
        if (jZzd != -1) {
            zzanx zzanxVar = this.zzd;
            if (!zzanxVar.zze()) {
                return zzanxVar.zza(zzadwVar, zzaerVar);
            }
        }
        if (!this.zzk) {
            this.zzk = true;
            zzanx zzanxVar2 = this.zzd;
            if (zzanxVar2.zzb() != -9223372036854775807L) {
                zzanw zzanwVar = new zzanw(zzanxVar2.zzd(), zzanxVar2.zzb(), jZzd);
                this.zzi = zzanwVar;
                this.zzj.zzP(zzanwVar.zzb());
            } else {
                this.zzj.zzP(new zzaet(zzanxVar2.zzb(), 0L));
            }
        }
        zzanw zzanwVar2 = this.zzi;
        if (zzanwVar2 != null && zzanwVar2.zze()) {
            return zzanwVar2.zza(zzadwVar, zzaerVar);
        }
        zzadwVar.zzj();
        long jZze = jZzd != -1 ? jZzd - zzadwVar.zze() : -1L;
        if (jZze != -1 && jZze < 4) {
            return -1;
        }
        zzen zzenVar = this.zzc;
        if (!zzadwVar.zzm(zzenVar.zzN(), 0, 4, true)) {
            return -1;
        }
        zzenVar.zzL(0);
        int iZzg = zzenVar.zzg();
        if (iZzg == 441) {
            return -1;
        }
        if (iZzg == 442) {
            zzadwVar.zzh(zzenVar.zzN(), 0, 10);
            zzenVar.zzL(9);
            zzadwVar.zzk((zzenVar.zzm() & 7) + 14);
            return 0;
        }
        if (iZzg == 443) {
            zzadwVar.zzh(zzenVar.zzN(), 0, 2);
            zzenVar.zzL(0);
            zzadwVar.zzk(zzenVar.zzq() + 6);
            return 0;
        }
        if ((iZzg >> 8) != 1) {
            zzadwVar.zzk(1);
            return 0;
        }
        int i = iZzg & 255;
        SparseArray sparseArray = this.zzb;
        zzany zzanyVar = (zzany) sparseArray.get(i);
        if (!this.zze) {
            if (zzanyVar == null) {
                zzamz zzamzVar = null;
                if (i == 189) {
                    zzanbVar = new zzamr(null, 0, "video/mp2p");
                    this.zzf = true;
                    this.zzh = zzadwVar.zzf();
                } else if ((iZzg & 224) == 192) {
                    zzanbVar = new zzanl(null, 0, "video/mp2p");
                    this.zzf = true;
                    this.zzh = zzadwVar.zzf();
                } else if ((iZzg & 240) == 224) {
                    zzanbVar = new zzanb(null, "video/mp2p");
                    this.zzg = true;
                    this.zzh = zzadwVar.zzf();
                } else if (zzamzVar != null) {
                    zzamzVar.zzb(this.zzj, new zzaon(Integer.MIN_VALUE, i, 256));
                    zzanyVar = new zzany(zzamzVar, this.zza);
                    sparseArray.put(i, zzanyVar);
                }
                zzamzVar = zzanbVar;
                if (zzamzVar != null) {
                    zzamzVar.zzb(this.zzj, new zzaon(Integer.MIN_VALUE, i, 256));
                    zzanyVar = new zzany(zzamzVar, this.zza);
                    sparseArray.put(i, zzanyVar);
                }
            }
            long j = 1048576;
            if (this.zzf && this.zzg) {
                j = this.zzh + 8192;
            }
            if (zzadwVar.zzf() > j) {
                this.zze = true;
                this.zzj.zzG();
            }
        }
        zzadwVar.zzh(zzenVar.zzN(), 0, 2);
        zzenVar.zzL(0);
        int iZzq = zzenVar.zzq() + 6;
        if (zzanyVar == null) {
            zzadwVar.zzk(iZzq);
        } else {
            zzenVar.zzI(iZzq);
            zzadwVar.zzi(zzenVar.zzN(), 0, iZzq);
            zzenVar.zzL(6);
            zzanyVar.zza(zzenVar);
            zzenVar.zzK(zzenVar.zzb());
        }
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
        this.zzj = zzadyVar;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zzf(long j, long j2) {
        zzeu zzeuVar = this.zza;
        if (zzeuVar.zzf() != -9223372036854775807L) {
            long jZzd = zzeuVar.zzd();
            if (jZzd != -9223372036854775807L && jZzd != 0 && jZzd != j2) {
                zzeuVar.zzi(j2);
            }
        } else {
            zzeuVar.zzi(j2);
        }
        zzanw zzanwVar = this.zzi;
        int i = 0;
        if (zzanwVar != null) {
            zzanwVar.zzd(j2);
        }
        while (true) {
            SparseArray sparseArray = this.zzb;
            if (i >= sparseArray.size()) {
                return;
            }
            ((zzany) sparseArray.valueAt(i)).zzb();
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final boolean zzi(zzadw zzadwVar) throws EOFException, InterruptedIOException {
        byte[] bArr = new byte[14];
        zzadl zzadlVar = (zzadl) zzadwVar;
        zzadlVar.zzm(bArr, 0, 14, false);
        if ((((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) != 442 || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        zzadlVar.zzl(bArr[13] & 7, false);
        zzadlVar.zzm(bArr, 0, 3, false);
        return ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255)) == 1;
    }
}
