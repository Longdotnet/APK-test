package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzws {
    private final zzen zza = new zzen(32);
    private zzwr zzb;
    private zzwr zzc;
    private zzwr zzd;
    private long zze;
    private final zzzm zzf;

    public zzws(zzzm zzzmVar) {
        this.zzf = zzzmVar;
        zzwr zzwrVar = new zzwr(0L, 65536);
        this.zzb = zzwrVar;
        this.zzc = zzwrVar;
        this.zzd = zzwrVar;
    }

    private final int zzi(int i) {
        zzwr zzwrVar = this.zzd;
        if (zzwrVar.zzc == null) {
            zzzf zzzfVarZzb = this.zzf.zzb();
            zzwr zzwrVar2 = new zzwr(this.zzd.zzb, 65536);
            zzwrVar.zzc = zzzfVarZzb;
            zzwrVar.zzd = zzwrVar2;
        }
        return Math.min(i, (int) (this.zzd.zzb - this.zze));
    }

    private static zzwr zzj(zzwr zzwrVar, long j) {
        while (j >= zzwrVar.zzb) {
            zzwrVar = zzwrVar.zzd;
        }
        return zzwrVar;
    }

    private static zzwr zzk(zzwr zzwrVar, long j, ByteBuffer byteBuffer, int i) {
        zzwr zzwrVarZzj = zzj(zzwrVar, j);
        while (i > 0) {
            int iMin = Math.min(i, (int) (zzwrVarZzj.zzb - j));
            byteBuffer.put(zzwrVarZzj.zzc.zza, zzwrVarZzj.zza(j), iMin);
            i -= iMin;
            j += (long) iMin;
            if (j == zzwrVarZzj.zzb) {
                zzwrVarZzj = zzwrVarZzj.zzd;
            }
        }
        return zzwrVarZzj;
    }

    private static zzwr zzl(zzwr zzwrVar, long j, byte[] bArr, int i) {
        zzwr zzwrVarZzj = zzj(zzwrVar, j);
        int i2 = i;
        while (i2 > 0) {
            int iMin = Math.min(i2, (int) (zzwrVarZzj.zzb - j));
            System.arraycopy(zzwrVarZzj.zzc.zza, zzwrVarZzj.zza(j), bArr, i - i2, iMin);
            i2 -= iMin;
            j += (long) iMin;
            if (j == zzwrVarZzj.zzb) {
                zzwrVarZzj = zzwrVarZzj.zzd;
            }
        }
        return zzwrVarZzj;
    }

    private static zzwr zzm(zzwr zzwrVar, zzhs zzhsVar, zzwu zzwuVar, zzen zzenVar) {
        zzwr zzwrVarZzl;
        int iZzq;
        if (zzhsVar.zzl()) {
            long j = zzwuVar.zzb;
            zzenVar.zzI(1);
            zzwr zzwrVarZzl2 = zzl(zzwrVar, j, zzenVar.zzN(), 1);
            long j2 = j + 1;
            byte b = zzenVar.zzN()[0];
            int i = b & 128;
            int i2 = b & 127;
            zzhp zzhpVar = zzhsVar.zzb;
            byte[] bArr = zzhpVar.zza;
            if (bArr == null) {
                zzhpVar.zza = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            boolean z = i != 0;
            zzwrVarZzl = zzl(zzwrVarZzl2, j2, zzhpVar.zza, i2);
            long j3 = j2 + ((long) i2);
            if (z) {
                zzenVar.zzI(2);
                zzwrVarZzl = zzl(zzwrVarZzl, j3, zzenVar.zzN(), 2);
                j3 += 2;
                iZzq = zzenVar.zzq();
            } else {
                iZzq = 1;
            }
            int[] iArr = zzhpVar.zzd;
            if (iArr == null || iArr.length < iZzq) {
                iArr = new int[iZzq];
            }
            int[] iArr2 = iArr;
            int[] iArr3 = zzhpVar.zze;
            if (iArr3 == null || iArr3.length < iZzq) {
                iArr3 = new int[iZzq];
            }
            int[] iArr4 = iArr3;
            if (z) {
                int i3 = iZzq * 6;
                zzenVar.zzI(i3);
                zzwrVarZzl = zzl(zzwrVarZzl, j3, zzenVar.zzN(), i3);
                j3 += (long) i3;
                zzenVar.zzL(0);
                for (int i4 = 0; i4 < iZzq; i4++) {
                    iArr2[i4] = zzenVar.zzq();
                    iArr4[i4] = zzenVar.zzp();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = zzwuVar.zza - ((int) (j3 - zzwuVar.zzb));
            }
            zzafa zzafaVar = zzwuVar.zzc;
            String str = zzex.zza;
            zzhpVar.zzc(iZzq, iArr2, iArr4, zzafaVar.zzb, zzhpVar.zza, zzafaVar.zza, zzafaVar.zzc, zzafaVar.zzd);
            long j4 = zzwuVar.zzb;
            int i5 = (int) (j3 - j4);
            zzwuVar.zzb = j4 + ((long) i5);
            zzwuVar.zza -= i5;
        } else {
            zzwrVarZzl = zzwrVar;
        }
        if (!zzhsVar.zze()) {
            zzhsVar.zzj(zzwuVar.zza);
            return zzk(zzwrVarZzl, zzwuVar.zzb, zzhsVar.zzc, zzwuVar.zza);
        }
        zzenVar.zzI(4);
        zzwr zzwrVarZzl3 = zzl(zzwrVarZzl, zzwuVar.zzb, zzenVar.zzN(), 4);
        int iZzp = zzenVar.zzp();
        zzwuVar.zzb += 4;
        zzwuVar.zza -= 4;
        zzhsVar.zzj(iZzp);
        zzwr zzwrVarZzk = zzk(zzwrVarZzl3, zzwuVar.zzb, zzhsVar.zzc, iZzp);
        zzwuVar.zzb += (long) iZzp;
        int i6 = zzwuVar.zza - iZzp;
        zzwuVar.zza = i6;
        ByteBuffer byteBuffer = zzhsVar.zzf;
        if (byteBuffer == null || byteBuffer.capacity() < i6) {
            zzhsVar.zzf = ByteBuffer.allocate(i6);
        } else {
            zzhsVar.zzf.clear();
        }
        return zzk(zzwrVarZzk, zzwuVar.zzb, zzhsVar.zzf, zzwuVar.zza);
    }

    private final void zzn(int i) {
        long j = this.zze + ((long) i);
        this.zze = j;
        zzwr zzwrVar = this.zzd;
        if (j == zzwrVar.zzb) {
            this.zzd = zzwrVar.zzd;
        }
    }

    public final int zza(zzl zzlVar, int i, boolean z) throws EOFException {
        int iZzi = zzi(i);
        zzwr zzwrVar = this.zzd;
        int iZza = zzlVar.zza(zzwrVar.zzc.zza, zzwrVar.zza(this.zze), iZzi);
        if (iZza != -1) {
            zzn(iZza);
            return iZza;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    public final long zzb() {
        return this.zze;
    }

    public final void zzc(long j) {
        zzwr zzwrVar;
        if (j != -1) {
            while (true) {
                zzwrVar = this.zzb;
                if (j < zzwrVar.zzb) {
                    break;
                }
                this.zzf.zzc(zzwrVar.zzc);
                this.zzb = this.zzb.zzb();
            }
            if (this.zzc.zza < zzwrVar.zza) {
                this.zzc = zzwrVar;
            }
        }
    }

    public final void zzd(zzhs zzhsVar, zzwu zzwuVar) {
        zzm(this.zzc, zzhsVar, zzwuVar, this.zza);
    }

    public final void zze(zzhs zzhsVar, zzwu zzwuVar) {
        this.zzc = zzm(this.zzc, zzhsVar, zzwuVar, this.zza);
    }

    public final void zzf() {
        zzwr zzwrVar = this.zzb;
        if (zzwrVar.zzc != null) {
            this.zzf.zzd(zzwrVar);
            zzwrVar.zzb();
        }
        this.zzb.zze(0L, 65536);
        zzwr zzwrVar2 = this.zzb;
        this.zzc = zzwrVar2;
        this.zzd = zzwrVar2;
        this.zze = 0L;
        this.zzf.zzg();
    }

    public final void zzg() {
        this.zzc = this.zzb;
    }

    public final void zzh(zzen zzenVar, int i) {
        while (i > 0) {
            int iZzi = zzi(i);
            zzwr zzwrVar = this.zzd;
            zzenVar.zzH(zzwrVar.zzc.zza, zzwrVar.zza(this.zze), iZzi);
            i -= iZzi;
            zzn(iZzi);
        }
    }
}
