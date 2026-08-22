package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class zzhbk extends zzgxz {
    static final int[] zza = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private final int zzc;
    private final zzgxz zzd;
    private final zzgxz zze;
    private final int zzf;
    private final int zzg;

    public /* synthetic */ zzhbk(zzgxz zzgxzVar, zzgxz zzgxzVar2) {
        this(zzgxzVar, zzgxzVar2);
    }

    public static zzgxz zzC(zzgxz zzgxzVar, zzgxz zzgxzVar2) {
        if (zzgxzVar2.zzd() == 0) {
            return zzgxzVar;
        }
        if (zzgxzVar.zzd() == 0) {
            return zzgxzVar2;
        }
        int iZzd = zzgxzVar2.zzd() + zzgxzVar.zzd();
        if (iZzd < 128) {
            return zzD(zzgxzVar, zzgxzVar2);
        }
        if (zzgxzVar instanceof zzhbk) {
            zzhbk zzhbkVar = (zzhbk) zzgxzVar;
            zzgxz zzgxzVar3 = zzhbkVar.zze;
            if (zzgxzVar2.zzd() + zzgxzVar3.zzd() < 128) {
                return new zzhbk(zzhbkVar.zzd, zzD(zzgxzVar3, zzgxzVar2));
            }
            zzgxz zzgxzVar4 = zzhbkVar.zzd;
            if (zzgxzVar4.zzf() > zzgxzVar3.zzf() && zzhbkVar.zzg > zzgxzVar2.zzf()) {
                return new zzhbk(zzgxzVar4, new zzhbk(zzgxzVar3, zzgxzVar2));
            }
        }
        return iZzd >= zzc(Math.max(zzgxzVar.zzf(), zzgxzVar2.zzf()) + 1) ? new zzhbk(zzgxzVar, zzgxzVar2) : zzhbh.zza(new zzhbh(null), zzgxzVar, zzgxzVar2);
    }

    private static zzgxz zzD(zzgxz zzgxzVar, zzgxz zzgxzVar2) {
        int iZzd = zzgxzVar.zzd();
        int iZzd2 = zzgxzVar2.zzd();
        byte[] bArr = new byte[iZzd + iZzd2];
        zzgxzVar.zzz(bArr, 0, 0, iZzd);
        zzgxzVar2.zzz(bArr, 0, iZzd, iZzd2);
        return new zzgxw(bArr);
    }

    public static int zzc(int i) {
        int[] iArr = zza;
        int length = iArr.length;
        if (i >= 47) {
            return Integer.MAX_VALUE;
        }
        return iArr[i];
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgxz)) {
            return false;
        }
        zzgxz zzgxzVar = (zzgxz) obj;
        int i = this.zzc;
        if (i != zzgxzVar.zzd()) {
            return false;
        }
        if (i == 0) {
            return true;
        }
        int iZzr = zzr();
        int iZzr2 = zzgxzVar.zzr();
        if (iZzr != 0 && iZzr2 != 0 && iZzr != iZzr2) {
            return false;
        }
        zzhbi zzhbiVar = new zzhbi(this, null);
        zzgxv next = zzhbiVar.next();
        zzhbi zzhbiVar2 = new zzhbi(zzgxzVar, null);
        zzgxv next2 = zzhbiVar2.next();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int iZzd = next.zzd() - i2;
            int iZzd2 = next2.zzd() - i3;
            int iMin = Math.min(iZzd, iZzd2);
            if (!(i2 == 0 ? next.zzg(next2, i3, iMin) : next2.zzg(next, i2, iMin))) {
                return false;
            }
            i4 += iMin;
            if (i4 >= i) {
                if (i4 == i) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (iMin == iZzd) {
                next = zzhbiVar.next();
                i2 = 0;
            } else {
                i2 += iMin;
            }
            if (iMin == iZzd2) {
                next = next;
                next2 = zzhbiVar2.next();
                i3 = 0;
            } else {
                next = next;
                i3 += iMin;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgxz, java.lang.Iterable
    public final /* synthetic */ Iterator<Byte> iterator() {
        return new zzhbg(this);
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    public final byte zza(int i) {
        zzgxz.zzy(i, this.zzc);
        return zzb(i);
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    public final byte zzb(int i) {
        int i2 = this.zzf;
        return i < i2 ? this.zzd.zzb(i) : this.zze.zzb(i - i2);
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    public final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    public final void zze(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.zzf;
        if (i4 <= i5) {
            this.zzd.zze(bArr, i, i2, i3);
        } else {
            if (i >= i5) {
                this.zze.zze(bArr, i - i5, i2, i3);
                return;
            }
            int i6 = i5 - i;
            this.zzd.zze(bArr, i, i2, i6);
            this.zze.zze(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    public final int zzf() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    public final boolean zzh() {
        return this.zzc >= zzc(this.zzg);
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    public final int zzi(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzf;
        if (i4 <= i5) {
            return this.zzd.zzi(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zze.zzi(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zze.zzi(this.zzd.zzi(i, i2, i6), 0, i3 - i6);
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    public final int zzj(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzf;
        if (i4 <= i5) {
            return this.zzd.zzj(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zze.zzj(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zze.zzj(this.zzd.zzj(i, i2, i6), 0, i3 - i6);
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    public final zzgxz zzk(int i, int i2) {
        int i3 = this.zzc;
        int iZzq = zzgxz.zzq(i, i2, i3);
        if (iZzq == 0) {
            return zzgxz.zzb;
        }
        if (iZzq == i3) {
            return this;
        }
        int i4 = this.zzf;
        if (i2 <= i4) {
            return this.zzd.zzk(i, i2);
        }
        int i5 = i2 - i4;
        if (i >= i4) {
            return this.zze.zzk(i - i4, i5);
        }
        zzgxz zzgxzVar = this.zzd;
        return new zzhbk(zzgxzVar.zzk(i, zzgxzVar.zzd()), this.zze.zzk(0, i5));
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    public final zzgyf zzl() {
        ArrayList<ByteBuffer> arrayList = new ArrayList();
        zzgye zzgyeVar = null;
        zzhbi zzhbiVar = new zzhbi(this, null);
        while (zzhbiVar.hasNext()) {
            arrayList.add(zzhbiVar.next().zzn());
        }
        int i = 0;
        int iRemaining = 0;
        for (ByteBuffer byteBuffer : arrayList) {
            iRemaining += byteBuffer.remaining();
            i = byteBuffer.hasArray() ? i | 1 : byteBuffer.isDirect() ? i | 2 : i | 4;
        }
        return i == 2 ? new zzgyb(arrayList, iRemaining, true, zzgyeVar) : zzgyf.zzG(new zzgzx(arrayList), 4096);
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    public final String zzm(Charset charset) {
        return new String(zzA(), charset);
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    public final ByteBuffer zzn() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    public final void zzo(zzgxq zzgxqVar) {
        this.zzd.zzo(zzgxqVar);
        this.zze.zzo(zzgxqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    public final boolean zzp() {
        zzgxz zzgxzVar = this.zzd;
        zzgxz zzgxzVar2 = this.zze;
        return zzgxzVar2.zzj(zzgxzVar.zzj(0, 0, this.zzf), 0, zzgxzVar2.zzd()) == 0;
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    /* JADX INFO: renamed from: zzs */
    public final zzgxu iterator() {
        return new zzhbg(this);
    }

    zzhbk(zzgxz zzgxzVar, zzgxz zzgxzVar2) {
        this.zzd = zzgxzVar;
        this.zze = zzgxzVar2;
        int iZzd = zzgxzVar.zzd();
        this.zzf = iZzd;
        this.zzc = zzgxzVar2.zzd() + iZzd;
        this.zzg = Math.max(zzgxzVar.zzf(), zzgxzVar2.zzf()) + 1;
    }
}
