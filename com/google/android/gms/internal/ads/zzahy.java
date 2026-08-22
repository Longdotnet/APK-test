package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import androidx.emoji2.text.flatbuffer.bs.bUqMCsuPSX;
import com.google.android.gms.appset.vSSa.iafHZUfOuHNwvy;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import com.google.protobuf.DescriptorProtos;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import kotlinx.coroutines.internal.Jbo.ygoi;

/* JADX INFO: loaded from: classes2.dex */
public final class zzahy implements zzadv {
    private static final byte[] zza = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] zzb;
    private static final byte[] zzc;
    private static final byte[] zzd;
    private static final UUID zze;
    private static final Map zzf;
    private long zzA;
    private boolean zzB;
    private zzahw zzC;
    private boolean zzD;
    private int zzE;
    private long zzF;
    private boolean zzG;
    private long zzH;
    private long zzI;
    private long zzJ;
    private zzeb zzK;
    private zzeb zzL;
    private boolean zzM;
    private boolean zzN;
    private int zzO;
    private long zzP;
    private long zzQ;
    private int zzR;
    private int zzS;
    private int[] zzT;
    private int zzU;
    private int zzV;
    private int zzW;
    private int zzX;
    private boolean zzY;
    private long zzZ;
    private int zzaa;
    private int zzab;
    private int zzac;
    private boolean zzad;
    private boolean zzae;
    private boolean zzaf;
    private int zzag;
    private byte zzah;
    private boolean zzai;
    private zzady zzaj;
    private final zzaht zzak;
    private final zzaia zzg;
    private final SparseArray zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final zzakr zzk;
    private final zzen zzl;
    private final zzen zzm;
    private final zzen zzn;
    private final zzen zzo;
    private final zzen zzp;
    private final zzen zzq;
    private final zzen zzr;
    private final zzen zzs;
    private final zzen zzt;
    private final zzen zzu;
    private ByteBuffer zzv;
    private long zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    static {
        String str = zzex.zza;
        zzb = "Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text".getBytes(StandardCharsets.UTF_8);
        zzc = new byte[]{68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
        zzd = new byte[]{87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};
        zze = new UUID(72057594037932032L, -9223371306706625679L);
        HashMap map = new HashMap();
        map.put("htc_video_rotA-000", 0);
        map.put("htc_video_rotA-090", 90);
        map.put("htc_video_rotA-180", 180);
        map.put("htc_video_rotA-270", 270);
        zzf = Collections.unmodifiableMap(map);
    }

    @Deprecated
    public zzahy() {
        this(new zzaht(), 2, zzakr.zza);
    }

    private final int zzp(zzadw zzadwVar, zzahw zzahwVar, int i, boolean z) throws zzaz {
        int i2;
        if ("S_TEXT/UTF8".equals(zzahwVar.zzc)) {
            zzx(zzadwVar, zza, i);
            int i3 = this.zzab;
            zzw();
            return i3;
        }
        if ("S_TEXT/ASS".equals(zzahwVar.zzc) || "S_TEXT/SSA".equals(zzahwVar.zzc)) {
            zzx(zzadwVar, zzc, i);
            int i4 = this.zzab;
            zzw();
            return i4;
        }
        if ("S_TEXT/WEBVTT".equals(zzahwVar.zzc)) {
            zzx(zzadwVar, zzd, i);
            int i5 = this.zzab;
            zzw();
            return i5;
        }
        zzafb zzafbVar = zzahwVar.zzX;
        if (!this.zzad) {
            if (zzahwVar.zzh) {
                this.zzW &= -1073741825;
                if (!this.zzae) {
                    zzen zzenVar = this.zzn;
                    zzadwVar.zzi(zzenVar.zzN(), 0, 1);
                    this.zzaa++;
                    if ((zzenVar.zzN()[0] & 128) == 128) {
                        throw zzaz.zza("Extension bit is set in signal byte", null);
                    }
                    this.zzah = zzenVar.zzN()[0];
                    this.zzae = true;
                }
                byte b = this.zzah;
                if ((b & 1) == 1) {
                    int i6 = b & 2;
                    this.zzW |= 1073741824;
                    if (!this.zzai) {
                        zzen zzenVar2 = this.zzs;
                        zzadwVar.zzi(zzenVar2.zzN(), 0, 8);
                        this.zzaa += 8;
                        this.zzai = true;
                        zzen zzenVar3 = this.zzn;
                        zzenVar3.zzN()[0] = (byte) ((i6 != 2 ? 0 : 128) | 8);
                        zzenVar3.zzL(0);
                        zzafbVar.zzs(zzenVar3, 1, 1);
                        this.zzab++;
                        zzenVar2.zzL(0);
                        zzafbVar.zzs(zzenVar2, 8, 1);
                        this.zzab += 8;
                    }
                    if (i6 == 2) {
                        if (!this.zzaf) {
                            zzen zzenVar4 = this.zzn;
                            zzadwVar.zzi(zzenVar4.zzN(), 0, 1);
                            this.zzaa++;
                            zzenVar4.zzL(0);
                            this.zzag = zzenVar4.zzm();
                            this.zzaf = true;
                        }
                        int i7 = this.zzag * 4;
                        zzen zzenVar5 = this.zzn;
                        zzenVar5.zzI(i7);
                        zzadwVar.zzi(zzenVar5.zzN(), 0, i7);
                        this.zzaa += i7;
                        int i8 = (this.zzag >> 1) + 1;
                        int i9 = (i8 * 6) + 2;
                        ByteBuffer byteBuffer = this.zzv;
                        if (byteBuffer == null || byteBuffer.capacity() < i9) {
                            this.zzv = ByteBuffer.allocate(i9);
                        }
                        this.zzv.position(0);
                        this.zzv.putShort((short) i8);
                        int i10 = 0;
                        int i11 = 0;
                        while (true) {
                            i2 = this.zzag;
                            if (i10 >= i2) {
                                break;
                            }
                            int iZzp = zzenVar5.zzp();
                            int i12 = iZzp - i11;
                            if (i10 % 2 == 0) {
                                this.zzv.putShort((short) i12);
                            } else {
                                this.zzv.putInt(i12);
                            }
                            i10++;
                            i11 = iZzp;
                        }
                        int i13 = (i - this.zzaa) - i11;
                        if ((i2 & 1) == 1) {
                            this.zzv.putInt(i13);
                        } else {
                            this.zzv.putShort((short) i13);
                            this.zzv.putInt(0);
                        }
                        zzen zzenVar6 = this.zzt;
                        zzenVar6.zzJ(this.zzv.array(), i9);
                        zzafbVar.zzs(zzenVar6, i9, 1);
                        this.zzab += i9;
                    }
                }
            } else {
                byte[] bArr = zzahwVar.zzi;
                if (bArr != null) {
                    this.zzq.zzJ(bArr, bArr.length);
                }
            }
            if (!"A_OPUS".equals(zzahwVar.zzc) ? zzahwVar.zzg > 0 : z) {
                this.zzW |= 268435456;
                this.zzu.zzI(0);
                int iZzd = (this.zzq.zzd() + i) - this.zzaa;
                zzen zzenVar7 = this.zzn;
                zzenVar7.zzI(4);
                zzenVar7.zzN()[0] = (byte) ((iZzd >> 24) & 255);
                zzenVar7.zzN()[1] = (byte) ((iZzd >> 16) & 255);
                zzenVar7.zzN()[2] = (byte) ((iZzd >> 8) & 255);
                zzenVar7.zzN()[3] = (byte) (iZzd & 255);
                zzafbVar.zzs(zzenVar7, 4, 2);
                this.zzab += 4;
            }
            this.zzad = true;
        }
        zzen zzenVar8 = this.zzq;
        int iZzd2 = zzenVar8.zzd() + i;
        if (!"V_MPEG4/ISO/AVC".equals(zzahwVar.zzc) && !"V_MPEGH/ISO/HEVC".equals(zzahwVar.zzc)) {
            if (zzahwVar.zzU != null) {
                zzdd.zzf(zzenVar8.zzd() == 0);
                zzahwVar.zzU.zzd(zzadwVar);
            }
            while (true) {
                int i14 = this.zzaa;
                if (i14 >= iZzd2) {
                    break;
                }
                int iZzq = zzq(zzadwVar, zzafbVar, iZzd2 - i14);
                this.zzaa += iZzq;
                this.zzab += iZzq;
            }
        } else {
            zzen zzenVar9 = this.zzm;
            byte[] bArrZzN = zzenVar9.zzN();
            bArrZzN[0] = 0;
            bArrZzN[1] = 0;
            bArrZzN[2] = 0;
            int i15 = zzahwVar.zzY;
            int i16 = 4 - i15;
            while (this.zzaa < iZzd2) {
                int i17 = this.zzac;
                if (i17 == 0) {
                    int iMin = Math.min(i15, zzenVar8.zza());
                    zzadwVar.zzi(bArrZzN, i16 + iMin, i15 - iMin);
                    if (iMin > 0) {
                        zzenVar8.zzH(bArrZzN, i16, iMin);
                    }
                    this.zzaa += i15;
                    zzenVar9.zzL(0);
                    this.zzac = zzenVar9.zzp();
                    zzen zzenVar10 = this.zzl;
                    zzenVar10.zzL(0);
                    zzafbVar.zzr(zzenVar10, 4);
                    this.zzab += 4;
                } else {
                    int iZzq2 = zzq(zzadwVar, zzafbVar, i17);
                    this.zzaa += iZzq2;
                    this.zzab += iZzq2;
                    this.zzac -= iZzq2;
                }
            }
        }
        if ("A_VORBIS".equals(zzahwVar.zzc)) {
            zzen zzenVar11 = this.zzo;
            zzenVar11.zzL(0);
            zzafbVar.zzr(zzenVar11, 4);
            this.zzab += 4;
        }
        int i18 = this.zzab;
        zzw();
        return i18;
    }

    private final int zzq(zzadw zzadwVar, zzafb zzafbVar, int i) {
        zzen zzenVar = this.zzq;
        int iZza = zzenVar.zza();
        if (iZza <= 0) {
            return zzafbVar.zzf(zzadwVar, i, false);
        }
        int iMin = Math.min(i, iZza);
        zzafbVar.zzr(zzenVar, iMin);
        return iMin;
    }

    private final long zzr(long j) throws zzaz {
        long j2 = this.zzy;
        if (j2 != -9223372036854775807L) {
            return zzex.zzu(j, j2, 1000L, RoundingMode.DOWN);
        }
        throw zzaz.zza("Can't scale timecode prior to timecodeScale being set.", null);
    }

    private final void zzs(int i) throws zzaz {
        if (this.zzK == null || this.zzL == null) {
            throw zzaz.zza("Element " + i + " must be in a Cues", null);
        }
    }

    private final void zzt(int i) throws zzaz {
        if (this.zzC != null) {
            return;
        }
        throw zzaz.zza("Element " + i + " must be in a TrackEntry", null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:35:0x0097  */
    private final void zzu(zzahw zzahwVar, long j, int i, int i2, int i3) {
        byte b;
        byte[] bArrZzy;
        int i4;
        int iZzd;
        zzafc zzafcVar = zzahwVar.zzU;
        if (zzafcVar != null) {
            zzafcVar.zzc(zzahwVar.zzX, j, i, i2, i3, zzahwVar.zzj);
        } else {
            if ("S_TEXT/UTF8".equals(zzahwVar.zzc) || "S_TEXT/ASS".equals(zzahwVar.zzc) || "S_TEXT/SSA".equals(zzahwVar.zzc) || "S_TEXT/WEBVTT".equals(zzahwVar.zzc)) {
                if (this.zzS > 1) {
                    zzea.zzf("MatroskaExtractor", "Skipping subtitle sample in laced block.");
                } else {
                    long j2 = this.zzQ;
                    if (j2 == -9223372036854775807L) {
                        zzea.zzf("MatroskaExtractor", "Skipping subtitle sample with no duration.");
                    } else {
                        String str = zzahwVar.zzc;
                        zzen zzenVar = this.zzr;
                        byte[] bArrZzN = zzenVar.zzN();
                        switch (str) {
                            case "S_TEXT/ASS":
                                b = 1;
                                break;
                            case "S_TEXT/SSA":
                                b = 2;
                                break;
                            case "S_TEXT/WEBVTT":
                                b = 3;
                                break;
                            case "S_TEXT/UTF8":
                                b = 0;
                                break;
                            default:
                                b = -1;
                                break;
                        }
                        if (b == 0) {
                            bArrZzy = zzy(j2, "%02d:%02d:%02d,%03d", 1000L);
                            i4 = 19;
                        } else if (b == 1 || b == 2) {
                            bArrZzy = zzy(j2, "%01d:%02d:%02d:%02d", 10000L);
                            i4 = 21;
                        } else {
                            if (b != 3) {
                                throw new IllegalArgumentException();
                            }
                            bArrZzy = zzy(j2, "%02d:%02d:%02d.%03d", 1000L);
                            i4 = 25;
                        }
                        System.arraycopy(bArrZzy, 0, bArrZzN, i4, bArrZzy.length);
                        for (int iZzc = zzenVar.zzc(); iZzc < zzenVar.zzd(); iZzc++) {
                            if (zzenVar.zzN()[iZzc] == 0) {
                                zzenVar.zzK(iZzc);
                                zzahwVar.zzX.zzr(zzenVar, zzenVar.zzd());
                                iZzd = zzenVar.zzd() + i2;
                            }
                        }
                        zzahwVar.zzX.zzr(zzenVar, zzenVar.zzd());
                        iZzd = zzenVar.zzd() + i2;
                    }
                }
                iZzd = i2;
            } else {
                iZzd = i2;
            }
            if ((i & 268435456) != 0) {
                if (this.zzS > 1) {
                    this.zzu.zzI(0);
                } else {
                    zzen zzenVar2 = this.zzu;
                    int iZzd2 = zzenVar2.zzd();
                    zzahwVar.zzX.zzs(zzenVar2, iZzd2, 2);
                    iZzd += iZzd2;
                }
            }
            zzahwVar.zzX.zzt(j, i, iZzd, i3, zzahwVar.zzj);
        }
        this.zzN = true;
    }

    private final void zzv(zzadw zzadwVar, int i) {
        zzen zzenVar = this.zzn;
        if (zzenVar.zzd() >= i) {
            return;
        }
        if (zzenVar.zzb() < i) {
            int iZzb = zzenVar.zzb();
            zzenVar.zzF(Math.max(iZzb + iZzb, i));
        }
        zzadwVar.zzi(zzenVar.zzN(), zzenVar.zzd(), i - zzenVar.zzd());
        zzenVar.zzK(i);
    }

    private final void zzw() {
        this.zzaa = 0;
        this.zzab = 0;
        this.zzac = 0;
        this.zzad = false;
        this.zzae = false;
        this.zzaf = false;
        this.zzag = 0;
        this.zzah = (byte) 0;
        this.zzai = false;
        this.zzq.zzI(0);
    }

    private final void zzx(zzadw zzadwVar, byte[] bArr, int i) {
        int length = bArr.length;
        int i2 = length + i;
        zzen zzenVar = this.zzr;
        if (zzenVar.zzb() < i2) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, i2 + i);
            zzenVar.zzJ(bArrCopyOf, bArrCopyOf.length);
        } else {
            System.arraycopy(bArr, 0, zzenVar.zzN(), 0, length);
        }
        zzadwVar.zzi(zzenVar.zzN(), length, i);
        zzenVar.zzL(0);
        zzenVar.zzK(i2);
    }

    private static byte[] zzy(long j, String str, long j2) {
        zzdd.zzd(j != -9223372036854775807L);
        Locale locale = Locale.US;
        int i = (int) (j / 3600000000L);
        Integer numValueOf = Integer.valueOf(i);
        long j3 = j - (((long) i) * 3600000000L);
        int i2 = (int) (j3 / 60000000);
        Integer numValueOf2 = Integer.valueOf(i2);
        long j4 = j3 - (((long) i2) * 60000000);
        int i3 = (int) (j4 / 1000000);
        String str2 = String.format(locale, str, numValueOf, numValueOf2, Integer.valueOf(i3), Integer.valueOf((int) ((j4 - (((long) i3) * 1000000)) / j2)));
        String str3 = zzex.zza;
        return str2.getBytes(StandardCharsets.UTF_8);
    }

    private static int[] zzz(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        int length = iArr.length;
        return length >= i ? iArr : new int[Math.max(length + length, i)];
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final int zzb(zzadw zzadwVar, zzaer zzaerVar) {
        int i = 0;
        this.zzN = false;
        while (!this.zzN) {
            if (this.zzak.zzc(zzadwVar)) {
                long jZzf = zzadwVar.zzf();
                if (this.zzG) {
                    this.zzI = jZzf;
                    zzaerVar.zza = this.zzH;
                    this.zzG = false;
                    return 1;
                }
                if (this.zzD) {
                    long j = this.zzI;
                    if (j != -1) {
                        zzaerVar.zza = j;
                        this.zzI = -1L;
                        return 1;
                    }
                }
            } else {
                while (true) {
                    SparseArray sparseArray = this.zzh;
                    if (i >= sparseArray.size()) {
                        return -1;
                    }
                    zzahw zzahwVar = (zzahw) sparseArray.valueAt(i);
                    zzahwVar.zzX.getClass();
                    zzafc zzafcVar = zzahwVar.zzU;
                    if (zzafcVar != null) {
                        zzafcVar.zza(zzahwVar.zzX, zzahwVar.zzj);
                    }
                    i++;
                }
            }
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
        if (this.zzj) {
            zzadyVar = new zzaku(zzadyVar, this.zzk);
        }
        this.zzaj = zzadyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zzf(long j, long j2) {
        this.zzJ = -9223372036854775807L;
        int i = 0;
        this.zzO = 0;
        this.zzak.zzb();
        this.zzg.zze();
        zzw();
        while (true) {
            SparseArray sparseArray = this.zzh;
            if (i >= sparseArray.size()) {
                return;
            }
            zzafc zzafcVar = ((zzahw) sparseArray.valueAt(i)).zzU;
            if (zzafcVar != null) {
                zzafcVar.zzb();
            }
            i++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:111:0x0289  */
    /* JADX WARN: Code duplicated, block: B:113:0x028d  */
    /* JADX WARN: Code duplicated, block: B:115:0x0298  */
    /* JADX WARN: Code duplicated, block: B:116:0x029a A[PHI: r0
  0x029a: PHI (r0v18 int) = (r0v0 int), (r0v25 int) binds: [B:110:0x0287, B:115:0x0298] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:117:0x029c  */
    public final void zzh(int i, int i2, zzadw zzadwVar) {
        zzahw zzahwVar;
        int i3;
        zzahw zzahwVar2;
        zzahw zzahwVar3;
        long j;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = i;
        int i9 = 1;
        int i10 = 0;
        if (i8 != 161 && i8 != 163) {
            if (i8 == 165) {
                if (this.zzO != 2) {
                    return;
                }
                zzahw zzahwVar4 = (zzahw) this.zzh.get(this.zzU);
                if (this.zzX != 4 || !"V_VP9".equals(zzahwVar4.zzc)) {
                    zzadwVar.zzk(i2);
                    return;
                }
                zzen zzenVar = this.zzu;
                zzenVar.zzI(i2);
                zzadwVar.zzi(zzenVar.zzN(), 0, i2);
                return;
            }
            if (i8 == 16877) {
                zzt(i);
                zzahw zzahwVar5 = this.zzC;
                if (zzahwVar5.zzZ != 1685485123 && zzahwVar5.zzZ != 1685480259) {
                    zzadwVar.zzk(i2);
                    return;
                }
                byte[] bArr = new byte[i2];
                zzahwVar5.zzO = bArr;
                zzadwVar.zzi(bArr, 0, i2);
                return;
            }
            if (i8 == 16981) {
                zzt(i);
                byte[] bArr2 = new byte[i2];
                this.zzC.zzi = bArr2;
                zzadwVar.zzi(bArr2, 0, i2);
                return;
            }
            if (i8 == 18402) {
                byte[] bArr3 = new byte[i2];
                zzadwVar.zzi(bArr3, 0, i2);
                zzt(i);
                this.zzC.zzj = new zzafa(1, bArr3, 0, 0);
                return;
            }
            if (i8 == 21419) {
                zzen zzenVar2 = this.zzp;
                Arrays.fill(zzenVar2.zzN(), (byte) 0);
                zzadwVar.zzi(zzenVar2.zzN(), 4 - i2, i2);
                zzenVar2.zzL(0);
                this.zzE = (int) zzenVar2.zzu();
                return;
            }
            if (i8 == 25506) {
                zzt(i);
                byte[] bArr4 = new byte[i2];
                this.zzC.zzk = bArr4;
                zzadwVar.zzi(bArr4, 0, i2);
                return;
            }
            if (i8 != 30322) {
                throw zzaz.zza("Unexpected id: " + i8, null);
            }
            zzt(i);
            byte[] bArr5 = new byte[i2];
            this.zzC.zzw = bArr5;
            zzadwVar.zzi(bArr5, 0, i2);
            return;
        }
        int i11 = 8;
        if (this.zzO == 0) {
            zzaia zzaiaVar = this.zzg;
            this.zzU = (int) zzaiaVar.zzd(zzadwVar, false, true, 8);
            this.zzV = zzaiaVar.zza();
            this.zzQ = -9223372036854775807L;
            this.zzO = 1;
            this.zzn.zzI(0);
        }
        zzahw zzahwVar6 = (zzahw) this.zzh.get(this.zzU);
        if (zzahwVar6 == null) {
            zzadwVar.zzk(i2 - this.zzV);
            this.zzO = 0;
            return;
        }
        zzahwVar6.zzX.getClass();
        if (this.zzO == 1) {
            zzv(zzadwVar, 3);
            zzen zzenVar3 = this.zzn;
            int i12 = (zzenVar3.zzN()[2] & 6) >> 1;
            if (i12 == 0) {
                this.zzS = 1;
                int[] iArrZzz = zzz(this.zzT, 1);
                this.zzT = iArrZzz;
                iArrZzz[0] = (i2 - this.zzV) - 3;
            } else {
                zzv(zzadwVar, 4);
                int i13 = (zzenVar3.zzN()[3] & 255) + 1;
                this.zzS = i13;
                int[] iArrZzz2 = zzz(this.zzT, i13);
                this.zzT = iArrZzz2;
                if (i12 == 2) {
                    int i14 = (i2 - this.zzV) - 4;
                    int i15 = this.zzS;
                    Arrays.fill(iArrZzz2, 0, i15, i14 / i15);
                } else {
                    if (i12 == 1) {
                        int i16 = 0;
                        int i17 = 0;
                        int i18 = 4;
                        while (true) {
                            i4 = this.zzS - 1;
                            if (i16 >= i4) {
                                break;
                            }
                            this.zzT[i16] = 0;
                            while (true) {
                                i5 = i18 + 1;
                                zzv(zzadwVar, i5);
                                int i19 = zzenVar3.zzN()[i18] & 255;
                                int[] iArr = this.zzT;
                                i6 = iArr[i16] + i19;
                                iArr[i16] = i6;
                                if (i19 != 255) {
                                    break;
                                } else {
                                    i18 = i5;
                                }
                            }
                            i17 += i6;
                            i16++;
                            i18 = i5;
                        }
                        this.zzT[i4] = ((i2 - this.zzV) - i18) - i17;
                    } else {
                        if (i12 != 3) {
                            throw zzaz.zza("Unexpected lacing value: 2", null);
                        }
                        int i20 = 0;
                        int i21 = 0;
                        int i22 = 4;
                        while (true) {
                            int i23 = this.zzS - 1;
                            if (i20 >= i23) {
                                zzahwVar2 = zzahwVar6;
                                this.zzT[i23] = ((i2 - this.zzV) - i22) - i21;
                                break;
                            }
                            this.zzT[i20] = i10;
                            int i24 = i22 + 1;
                            zzv(zzadwVar, i24);
                            if (zzenVar3.zzN()[i22] == 0) {
                                throw zzaz.zza("No valid varint length mask found", null);
                            }
                            int i25 = i10;
                            while (true) {
                                if (i25 >= i11) {
                                    zzahwVar3 = zzahwVar6;
                                    j = 0;
                                    break;
                                }
                                int i26 = i9 << (7 - i25);
                                if ((zzenVar3.zzN()[i22] & i26) != 0) {
                                    i24 += i25;
                                    zzv(zzadwVar, i24);
                                    j = zzenVar3.zzN()[i22] & 255 & (~i26);
                                    int i27 = i22 + 1;
                                    while (i27 < i24) {
                                        j = (j << i11) | ((long) (zzenVar3.zzN()[i27] & 255));
                                        i27++;
                                        zzahwVar6 = zzahwVar6;
                                        i11 = 8;
                                    }
                                    zzahwVar3 = zzahwVar6;
                                    if (i20 <= 0) {
                                        break;
                                    }
                                    j -= (1 << ((i25 * 7) + 6)) - 1;
                                    break;
                                }
                                i25++;
                                i9 = 1;
                                i11 = 8;
                            }
                            i22 = i24;
                            if (j < -2147483648L || j > 2147483647L) {
                                throw zzaz.zza("EBML lacing sample size out of range.", null);
                            }
                            int[] iArr2 = this.zzT;
                            int i28 = (int) j;
                            if (i20 != 0) {
                                i28 += iArr2[i20 - 1];
                            }
                            iArr2[i20] = i28;
                            i21 += i28;
                            i20++;
                            zzahwVar6 = zzahwVar3;
                            i9 = 1;
                            i10 = 0;
                            i11 = 8;
                        }
                    }
                    this.zzP = this.zzJ + zzr((zzenVar3.zzN()[0] << 8) | (zzenVar3.zzN()[1] & 255));
                    zzahwVar = zzahwVar2;
                    if (zzahwVar.zze == 2) {
                        i7 = 1;
                    } else {
                        if (i8 == 163) {
                            if ((zzenVar3.zzN()[2] & 128) == 128) {
                                i8 = 163;
                                i7 = 1;
                            } else {
                                i8 = 163;
                            }
                        }
                        i7 = 0;
                    }
                    this.zzW = i7;
                    this.zzO = 2;
                    this.zzR = 0;
                    i3 = 163;
                }
            }
            zzahwVar2 = zzahwVar6;
            this.zzP = this.zzJ + zzr((zzenVar3.zzN()[0] << 8) | (zzenVar3.zzN()[1] & 255));
            zzahwVar = zzahwVar2;
            if (zzahwVar.zze == 2) {
                i7 = 1;
            } else {
                if (i8 == 163) {
                    if ((zzenVar3.zzN()[2] & 128) == 128) {
                        i8 = 163;
                        i7 = 1;
                    } else {
                        i8 = 163;
                    }
                }
                i7 = 0;
            }
            this.zzW = i7;
            this.zzO = 2;
            this.zzR = 0;
            i3 = 163;
        } else {
            zzahwVar = zzahwVar6;
            i3 = 163;
        }
        if (i8 == i3) {
            while (true) {
                int i29 = this.zzR;
                if (i29 >= this.zzS) {
                    this.zzO = 0;
                    return;
                }
                zzu(zzahwVar, ((long) ((this.zzR * zzahwVar.zzf) / 1000)) + this.zzP, this.zzW, zzp(zzadwVar, zzahwVar, this.zzT[i29], false), 0);
                this.zzR++;
            }
        } else {
            while (true) {
                int i30 = this.zzR;
                if (i30 >= this.zzS) {
                    return;
                }
                int[] iArr3 = this.zzT;
                iArr3[i30] = zzp(zzadwVar, zzahwVar, iArr3[i30], true);
                this.zzR++;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final boolean zzi(zzadw zzadwVar) {
        return new zzahz().zza(zzadwVar);
    }

    public final void zzk(int i, double d) {
        if (i == 181) {
            zzt(i);
            this.zzC.zzR = (int) d;
            return;
        }
        if (i == 17545) {
            this.zzz = (long) d;
            return;
        }
        switch (i) {
            case 21969:
                zzt(i);
                this.zzC.zzE = (float) d;
                break;
            case 21970:
                zzt(i);
                this.zzC.zzF = (float) d;
                break;
            case 21971:
                zzt(i);
                this.zzC.zzG = (float) d;
                break;
            case 21972:
                zzt(i);
                this.zzC.zzH = (float) d;
                break;
            case 21973:
                zzt(i);
                this.zzC.zzI = (float) d;
                break;
            case 21974:
                zzt(i);
                this.zzC.zzJ = (float) d;
                break;
            case 21975:
                zzt(i);
                this.zzC.zzK = (float) d;
                break;
            case 21976:
                zzt(i);
                this.zzC.zzL = (float) d;
                break;
            case 21977:
                zzt(i);
                this.zzC.zzM = (float) d;
                break;
            case 21978:
                zzt(i);
                this.zzC.zzN = (float) d;
                break;
            default:
                switch (i) {
                    case 30323:
                        zzt(i);
                        this.zzC.zzt = (float) d;
                        break;
                    case 30324:
                        zzt(i);
                        this.zzC.zzu = (float) d;
                        break;
                    case 30325:
                        zzt(i);
                        this.zzC.zzv = (float) d;
                        break;
                }
                break;
        }
    }

    public final void zzl(int i, long j) {
        boolean z;
        if (i == 20529) {
            if (j == 0) {
                return;
            }
            throw zzaz.zza("ContentEncodingOrder " + j + " not supported", null);
        }
        if (i == 20530) {
            if (j == 1) {
                return;
            }
            throw zzaz.zza("ContentEncodingScope " + j + " not supported", null);
        }
        switch (i) {
            case 131:
                zzt(i);
                this.zzC.zze = (int) j;
                return;
            case 136:
                z = j == 1;
                zzt(i);
                this.zzC.zzW = z;
                return;
            case 155:
                this.zzQ = zzr(j);
                return;
            case 159:
                zzt(i);
                this.zzC.zzP = (int) j;
                return;
            case 176:
                zzt(i);
                this.zzC.zzm = (int) j;
                return;
            case 179:
                zzs(i);
                this.zzK.zzc(zzr(j));
                return;
            case 186:
                zzt(i);
                this.zzC.zzn = (int) j;
                return;
            case 215:
                zzt(i);
                this.zzC.zzd = (int) j;
                return;
            case 231:
                this.zzJ = zzr(j);
                return;
            case 238:
                this.zzX = (int) j;
                return;
            case 241:
                if (this.zzM) {
                    return;
                }
                zzs(i);
                this.zzL.zzc(j);
                this.zzM = true;
                return;
            case 251:
                this.zzY = true;
                return;
            case 16871:
                zzt(i);
                this.zzC.zzZ = (int) j;
                return;
            case 16980:
                if (j == 3) {
                    return;
                }
                throw zzaz.zza("ContentCompAlgo " + j + " not supported", null);
            case 17029:
                if (j < 1 || j > 2) {
                    throw zzaz.zza("DocTypeReadVersion " + j + " not supported", null);
                }
                return;
            case 17143:
                if (j == 1) {
                    return;
                }
                throw zzaz.zza("EBMLReadVersion " + j + " not supported", null);
            case 18401:
                if (j == 5) {
                    return;
                }
                throw zzaz.zza("ContentEncAlgo " + j + " not supported", null);
            case 18408:
                if (j == 1) {
                    return;
                }
                throw zzaz.zza("AESSettingsCipherMode " + j + " not supported", null);
            case 21420:
                this.zzF = j + this.zzx;
                return;
            case 21432:
                int i2 = (int) j;
                zzt(i);
                if (i2 == 0) {
                    this.zzC.zzx = 0;
                    return;
                }
                if (i2 == 1) {
                    this.zzC.zzx = 2;
                    return;
                } else if (i2 == 3) {
                    this.zzC.zzx = 1;
                    return;
                } else {
                    if (i2 != 15) {
                        return;
                    }
                    this.zzC.zzx = 3;
                    return;
                }
            case 21680:
                zzt(i);
                this.zzC.zzp = (int) j;
                return;
            case 21682:
                zzt(i);
                this.zzC.zzr = (int) j;
                return;
            case 21690:
                zzt(i);
                this.zzC.zzq = (int) j;
                return;
            case 21930:
                z = j == 1;
                zzt(i);
                this.zzC.zzV = z;
                return;
            case 21938:
                zzt(i);
                zzahw zzahwVar = this.zzC;
                zzahwVar.zzy = true;
                zzahwVar.zzo = (int) j;
                return;
            case 21998:
                zzt(i);
                this.zzC.zzg = (int) j;
                return;
            case 22186:
                zzt(i);
                this.zzC.zzS = j;
                return;
            case 22203:
                zzt(i);
                this.zzC.zzT = j;
                return;
            case 25188:
                zzt(i);
                this.zzC.zzQ = (int) j;
                return;
            case 30114:
                this.zzZ = j;
                return;
            case 30321:
                int i3 = (int) j;
                zzt(i);
                if (i3 == 0) {
                    this.zzC.zzs = 0;
                    return;
                }
                if (i3 == 1) {
                    this.zzC.zzs = 1;
                    return;
                } else if (i3 == 2) {
                    this.zzC.zzs = 2;
                    return;
                } else {
                    if (i3 != 3) {
                        return;
                    }
                    this.zzC.zzs = 3;
                    return;
                }
            case 2352003:
                zzt(i);
                this.zzC.zzf = (int) j;
                return;
            case 2807729:
                this.zzy = j;
                return;
            default:
                switch (i) {
                    case 21945:
                        int i4 = (int) j;
                        zzt(i);
                        if (i4 == 1) {
                            this.zzC.zzB = 2;
                            return;
                        } else {
                            if (i4 != 2) {
                                return;
                            }
                            this.zzC.zzB = 1;
                            return;
                        }
                    case 21946:
                        zzt(i);
                        int iZzb = zzk.zzb((int) j);
                        if (iZzb != -1) {
                            this.zzC.zzA = iZzb;
                            return;
                        }
                        return;
                    case 21947:
                        zzt(i);
                        this.zzC.zzy = true;
                        int iZza = zzk.zza((int) j);
                        if (iZza != -1) {
                            this.zzC.zzz = iZza;
                            return;
                        }
                        return;
                    case 21948:
                        zzt(i);
                        this.zzC.zzC = (int) j;
                        return;
                    case 21949:
                        zzt(i);
                        this.zzC.zzD = (int) j;
                        return;
                    default:
                        return;
                }
        }
    }

    public final void zzm(int i, long j, long j2) {
        zzdd.zzb(this.zzaj);
        if (i == 160) {
            this.zzY = false;
            this.zzZ = 0L;
            return;
        }
        if (i == 174) {
            zzahw zzahwVar = new zzahw();
            this.zzC = zzahwVar;
            zzahwVar.zza = this.zzB;
            return;
        }
        if (i == 187) {
            this.zzM = false;
            return;
        }
        if (i == 19899) {
            this.zzE = -1;
            this.zzF = -1L;
            return;
        }
        if (i == 20533) {
            zzt(i);
            this.zzC.zzh = true;
            return;
        }
        if (i == 21968) {
            zzt(i);
            this.zzC.zzy = true;
            return;
        }
        if (i == 408125543) {
            long j3 = this.zzx;
            if (j3 != -1 && j3 != j) {
                throw zzaz.zza("Multiple Segment elements not supported", null);
            }
            this.zzx = j;
            this.zzw = j2;
            return;
        }
        if (i == 475249515) {
            this.zzK = new zzeb(32);
            this.zzL = new zzeb(32);
        } else if (i == 524531317 && !this.zzD) {
            if (this.zzi && this.zzH != -1) {
                this.zzG = true;
            } else {
                this.zzaj.zzP(new zzaet(this.zzA, 0L));
                this.zzD = true;
            }
        }
    }

    public zzahy(zzaht zzahtVar, int i, zzakr zzakrVar) {
        this.zzx = -1L;
        this.zzy = -9223372036854775807L;
        this.zzz = -9223372036854775807L;
        this.zzA = -9223372036854775807L;
        this.zzH = -1L;
        this.zzI = -1L;
        this.zzJ = -9223372036854775807L;
        this.zzak = zzahtVar;
        zzahtVar.zza(new zzahv(this, null));
        this.zzk = zzakrVar;
        this.zzi = 1 == ((i & 1) ^ 1);
        this.zzj = (i & 2) == 0;
        this.zzg = new zzaia();
        this.zzh = new SparseArray();
        this.zzn = new zzen(4);
        this.zzo = new zzen(ByteBuffer.allocate(4).putInt(-1).array());
        this.zzp = new zzen(4);
        this.zzl = new zzen(zzfv.zza);
        this.zzm = new zzen(4);
        this.zzq = new zzen();
        this.zzr = new zzen();
        this.zzs = new zzen(8);
        this.zzt = new zzen();
        this.zzu = new zzen();
        this.zzT = new int[1];
    }

    public final void zzj(int i) {
        int i2;
        zzaeu zzaetVar;
        int i3;
        long[] jArr;
        long[] jArrCopyOf;
        byte b = -1;
        int i4 = 0;
        zzdd.zzb(this.zzaj);
        if (i == 160) {
            if (this.zzO == 2) {
                zzahw zzahwVar = (zzahw) this.zzh.get(this.zzU);
                zzahwVar.zzX.getClass();
                if (this.zzZ > 0 && "A_OPUS".equals(zzahwVar.zzc)) {
                    zzen zzenVar = this.zzu;
                    byte[] bArrArray = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.zzZ).array();
                    zzenVar.zzJ(bArrArray, bArrArray.length);
                }
                int i5 = 0;
                for (int i6 = 0; i6 < this.zzS; i6++) {
                    i5 += this.zzT[i6];
                }
                int i7 = 0;
                while (i7 < this.zzS) {
                    long j = this.zzP + ((long) ((zzahwVar.zzf * i7) / 1000));
                    int i8 = this.zzW;
                    if (i7 == 0) {
                        if (!this.zzY) {
                            i8 |= 1;
                        }
                        i2 = 0;
                    } else {
                        i2 = i7;
                    }
                    int i9 = this.zzT[i2];
                    int i10 = i5 - i9;
                    zzu(zzahwVar, j, i8, i9, i10);
                    i7 = i2 + 1;
                    i5 = i10;
                }
                this.zzO = 0;
                return;
            }
            return;
        }
        if (i != 174) {
            if (i == 19899) {
                int i11 = this.zzE;
                if (i11 != -1) {
                    long j2 = this.zzF;
                    if (j2 != -1) {
                        if (i11 == 475249515) {
                            this.zzH = j2;
                            return;
                        }
                        return;
                    }
                }
                throw zzaz.zza("Mandatory element SeekID or SeekPosition not found", null);
            }
            if (i == 25152) {
                zzt(i);
                zzahw zzahwVar2 = this.zzC;
                if (zzahwVar2.zzh) {
                    if (zzahwVar2.zzj == null) {
                        throw zzaz.zza("Encrypted Track found but ContentEncKeyID was not found", null);
                    }
                    zzahwVar2.zzl = new zzs(null, new zzr(zzh.zza, null, "video/webm", this.zzC.zzj.zzb));
                    return;
                }
                return;
            }
            if (i == 28032) {
                zzt(i);
                zzahw zzahwVar3 = this.zzC;
                if (zzahwVar3.zzh && zzahwVar3.zzi != null) {
                    throw zzaz.zza("Combining encryption and compression is not supported", null);
                }
                return;
            }
            if (i == 357149030) {
                if (this.zzy == -9223372036854775807L) {
                    this.zzy = 1000000L;
                }
                long j3 = this.zzz;
                if (j3 != -9223372036854775807L) {
                    this.zzA = zzr(j3);
                    return;
                }
                return;
            }
            if (i == 374648427) {
                if (this.zzh.size() == 0) {
                    throw zzaz.zza("No valid tracks were found", null);
                }
                this.zzaj.zzG();
                return;
            }
            if (i != 475249515) {
                return;
            }
            if (!this.zzD) {
                zzady zzadyVar = this.zzaj;
                zzeb zzebVar = this.zzK;
                zzeb zzebVar2 = this.zzL;
                if (this.zzx == -1 || this.zzA == -9223372036854775807L || zzebVar == null || zzebVar.zza() == 0 || zzebVar2 == null || zzebVar2.zza() != zzebVar.zza()) {
                    zzaetVar = new zzaet(this.zzA, 0L);
                } else {
                    int iZza = zzebVar.zza();
                    int[] iArrCopyOf = new int[iZza];
                    long[] jArr2 = new long[iZza];
                    long[] jArrCopyOf2 = new long[iZza];
                    long[] jArrCopyOf3 = new long[iZza];
                    for (int i12 = 0; i12 < iZza; i12++) {
                        jArrCopyOf3[i12] = zzebVar.zzb(i12);
                        jArr2[i12] = zzebVar2.zzb(i12) + this.zzx;
                    }
                    while (true) {
                        i3 = iZza - 1;
                        if (i4 >= i3) {
                            break;
                        }
                        int i13 = i4 + 1;
                        iArrCopyOf[i4] = (int) (jArr2[i13] - jArr2[i4]);
                        jArrCopyOf2[i4] = jArrCopyOf3[i13] - jArrCopyOf3[i4];
                        i4 = i13;
                    }
                    int i14 = i3;
                    while (true) {
                        if (i14 <= 0) {
                            jArr = jArr2;
                            break;
                        }
                        jArr = jArr2;
                        if (jArrCopyOf3[i14] <= this.zzA) {
                            break;
                        }
                        i14--;
                        jArr2 = jArr;
                    }
                    iArrCopyOf[i14] = (int) ((this.zzx + this.zzw) - jArr[i14]);
                    jArrCopyOf2[i14] = this.zzA - jArrCopyOf3[i14];
                    if (i14 < i3) {
                        zzea.zzf("MatroskaExtractor", "Discarding trailing cue points with timestamps greater than total duration");
                        int i15 = i14 + 1;
                        iArrCopyOf = Arrays.copyOf(iArrCopyOf, i15);
                        jArrCopyOf = Arrays.copyOf(jArr, i15);
                        jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i15);
                        jArrCopyOf3 = Arrays.copyOf(jArrCopyOf3, i15);
                    } else {
                        jArrCopyOf = jArr;
                    }
                    zzaetVar = new zzadi(iArrCopyOf, jArrCopyOf, jArrCopyOf2, jArrCopyOf3);
                }
                zzadyVar.zzP(zzaetVar);
                this.zzD = true;
            }
            this.zzK = null;
            this.zzL = null;
            return;
        }
        zzahw zzahwVar4 = this.zzC;
        zzdd.zzb(zzahwVar4);
        String str = zzahwVar4.zzc;
        if (str == null) {
            throw zzaz.zza("CodecId is missing in TrackEntry element", null);
        }
        switch (str.hashCode()) {
            case -2095576542:
                if (str.equals("V_MPEG4/ISO/AP")) {
                    b = 6;
                }
                break;
            case -2095575984:
                if (str.equals(ygoi.EJsFffaIV)) {
                    b = 4;
                }
                break;
            case -1985379776:
                if (str.equals("A_MS/ACM")) {
                    b = 23;
                }
                break;
            case -1784763192:
                if (str.equals(iafHZUfOuHNwvy.OxQ)) {
                    b = 18;
                }
                break;
            case -1730367663:
                if (str.equals("A_VORBIS")) {
                    b = 12;
                }
                break;
            case -1482641358:
                if (str.equals("A_MPEG/L2")) {
                    b = 14;
                }
                break;
            case -1482641357:
                if (str.equals("A_MPEG/L3")) {
                    b = 15;
                }
                break;
            case -1373388978:
                if (str.equals("V_MS/VFW/FOURCC")) {
                    b = 9;
                }
                break;
            case -933872740:
                if (str.equals("S_DVBSUB")) {
                    b = 33;
                }
                break;
            case -538363189:
                if (str.equals("V_MPEG4/ISO/ASP")) {
                    b = 5;
                }
                break;
            case -538363109:
                if (str.equals("V_MPEG4/ISO/AVC")) {
                    b = 7;
                }
                break;
            case -425012669:
                if (str.equals("S_VOBSUB")) {
                    b = 31;
                }
                break;
            case -356037306:
                if (str.equals("A_DTS/LOSSLESS")) {
                    b = 21;
                }
                break;
            case 62923557:
                if (str.equals("A_AAC")) {
                    b = 13;
                }
                break;
            case 62923603:
                if (str.equals("A_AC3")) {
                    b = 16;
                }
                break;
            case 62927045:
                if (str.equals("A_DTS")) {
                    b = 19;
                }
                break;
            case 82318131:
                if (str.equals("V_AV1")) {
                    b = 2;
                }
                break;
            case 82338133:
                if (str.equals("V_VP8")) {
                    b = 0;
                }
                break;
            case 82338134:
                if (str.equals("V_VP9")) {
                    b = 1;
                }
                break;
            case 99146302:
                if (str.equals(bUqMCsuPSX.DIrqdfNGgLQQ)) {
                    b = 32;
                }
                break;
            case 444813526:
                if (str.equals("V_THEORA")) {
                    b = 10;
                }
                break;
            case 542569478:
                if (str.equals("A_DTS/EXPRESS")) {
                    b = 20;
                }
                break;
            case 635596514:
                if (str.equals("A_PCM/FLOAT/IEEE")) {
                    b = 26;
                }
                break;
            case 725948237:
                if (str.equals("A_PCM/INT/BIG")) {
                    b = 25;
                }
                break;
            case 725957860:
                if (str.equals("A_PCM/INT/LIT")) {
                    b = 24;
                }
                break;
            case 738597099:
                if (str.equals("S_TEXT/ASS")) {
                    b = 28;
                }
                break;
            case 738614379:
                if (str.equals("S_TEXT/SSA")) {
                    b = 29;
                }
                break;
            case 855502857:
                if (str.equals("V_MPEGH/ISO/HEVC")) {
                    b = 8;
                }
                break;
            case 1045209816:
                if (str.equals("S_TEXT/WEBVTT")) {
                    b = 30;
                }
                break;
            case 1422270023:
                if (str.equals("S_TEXT/UTF8")) {
                    b = 27;
                }
                break;
            case 1809237540:
                if (str.equals("V_MPEG2")) {
                    b = 3;
                }
                break;
            case 1950749482:
                if (str.equals("A_EAC3")) {
                    b = 17;
                }
                break;
            case 1950789798:
                if (str.equals("A_FLAC")) {
                    b = 22;
                }
                break;
            case 1951062397:
                if (str.equals("A_OPUS")) {
                    b = 11;
                }
                break;
        }
        switch (b) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
            case 24:
            case 25:
            case 26:
            case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
            case 28:
            case 29:
            case 30:
            case DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
            case 32:
            case 33:
                zzahwVar4.zze(this.zzaj, zzahwVar4.zzd);
                this.zzh.put(zzahwVar4.zzd, zzahwVar4);
                break;
        }
        this.zzC = null;
    }

    public final void zzn(int i, String str) {
        if (i == 134) {
            zzt(i);
            this.zzC.zzc = str;
            return;
        }
        if (i == 17026) {
            if ("webm".equals(str) || "matroska".equals(str)) {
                this.zzB = Objects.equals(str, "webm");
                return;
            }
            throw zzaz.zza(oKjScaD.BzsqfAEuBF + str + " not supported", null);
        }
        if (i == 21358) {
            zzt(i);
            this.zzC.zzb = str;
        } else {
            if (i != 2274716) {
                return;
            }
            zzt(i);
            this.zzC.zzaa = str;
        }
    }

    public zzahy(zzakr zzakrVar, int i) {
        this(new zzaht(), 0, zzakrVar);
    }
}
