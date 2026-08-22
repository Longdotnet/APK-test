package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.android.gms.ads.jY.UUFMQdNK;
import com.google.protobuf.DescriptorProtos;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlinx.coroutines.internal.Jbo.ygoi;

/* JADX INFO: loaded from: classes2.dex */
public final class zzahw {
    public byte[] zzO;
    public zzafc zzU;
    public boolean zzV;
    public zzafb zzX;
    public int zzY;
    private int zzZ;
    public boolean zza;
    public String zzb;
    public String zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public int zzg;
    public boolean zzh;
    public byte[] zzi;
    public zzafa zzj;
    public byte[] zzk;
    public zzs zzl;
    public int zzm = -1;
    public int zzn = -1;
    public int zzo = -1;
    public int zzp = -1;
    public int zzq = -1;
    public int zzr = 0;
    public int zzs = -1;
    public float zzt = 0.0f;
    public float zzu = 0.0f;
    public float zzv = 0.0f;
    public byte[] zzw = null;
    public int zzx = -1;
    public boolean zzy = false;
    public int zzz = -1;
    public int zzA = -1;
    public int zzB = -1;
    public int zzC = 1000;
    public int zzD = 200;
    public float zzE = -1.0f;
    public float zzF = -1.0f;
    public float zzG = -1.0f;
    public float zzH = -1.0f;
    public float zzI = -1.0f;
    public float zzJ = -1.0f;
    public float zzK = -1.0f;
    public float zzL = -1.0f;
    public float zzM = -1.0f;
    public float zzN = -1.0f;
    public int zzP = 1;
    public int zzQ = -1;
    public int zzR = 8000;
    public long zzS = 0;
    public long zzT = 0;
    public boolean zzW = true;
    private String zzaa = "eng";

    private static Pair zzf(zzen zzenVar) throws zzaz {
        try {
            zzenVar.zzM(16);
            long jZzs = zzenVar.zzs();
            if (jZzs == 1482049860) {
                return new Pair("video/divx", null);
            }
            if (jZzs == 859189832) {
                return new Pair("video/3gpp", null);
            }
            if (jZzs != 826496599) {
                zzea.zzf("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair("video/x-unknown", null);
            }
            int iZzc = zzenVar.zzc() + 20;
            byte[] bArrZzN = zzenVar.zzN();
            while (true) {
                int length = bArrZzN.length;
                if (iZzc >= length - 4) {
                    throw zzaz.zza("Failed to find FourCC VC1 initialization data", null);
                }
                int i = iZzc + 1;
                if (bArrZzN[iZzc] == 0 && bArrZzN[i] == 0 && bArrZzN[iZzc + 2] == 1 && bArrZzN[iZzc + 3] == 15) {
                    return new Pair("video/wvc1", Collections.singletonList(Arrays.copyOfRange(bArrZzN, iZzc, length)));
                }
                iZzc = i;
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzaz.zza("Error parsing FourCC private data", null);
        }
    }

    private static List zzg(byte[] bArr) throws zzaz {
        int i;
        int i2;
        try {
            if (bArr[0] != 2) {
                throw zzaz.zza("Error parsing vorbis codec private", null);
            }
            int i3 = 0;
            int i4 = 1;
            while (true) {
                int i5 = bArr[i4];
                i4++;
                i = i5 & 255;
                if (i != 255) {
                    break;
                }
                i3 += 255;
            }
            int i6 = i3 + i;
            int i7 = 0;
            while (true) {
                int i8 = bArr[i4];
                i4++;
                i2 = i8 & 255;
                if (i2 != 255) {
                    break;
                }
                i7 += 255;
            }
            int i9 = i7 + i2;
            if (bArr[i4] != 1) {
                throw zzaz.zza("Error parsing vorbis codec private", null);
            }
            byte[] bArr2 = new byte[i6];
            System.arraycopy(bArr, i4, bArr2, 0, i6);
            int i10 = i4 + i6;
            if (bArr[i10] != 3) {
                throw zzaz.zza("Error parsing vorbis codec private", null);
            }
            int i11 = i10 + i9;
            if (bArr[i11] != 5) {
                throw zzaz.zza("Error parsing vorbis codec private", null);
            }
            int length = bArr.length - i11;
            byte[] bArr3 = new byte[length];
            System.arraycopy(bArr, i11, bArr3, 0, length);
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(bArr2);
            arrayList.add(bArr3);
            return arrayList;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzaz.zza("Error parsing vorbis codec private", null);
        }
    }

    private static boolean zzh(zzen zzenVar) throws zzaz {
        try {
            int iZzk = zzenVar.zzk();
            if (iZzk == 1) {
                return true;
            }
            if (iZzk == 65534) {
                zzenVar.zzL(24);
                if (zzenVar.zzt() == zzahy.zze.getMostSignificantBits() && zzenVar.zzt() == zzahy.zze.getLeastSignificantBits()) {
                    return true;
                }
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzaz.zza("Error parsing MS/ACM codec private", null);
        }
    }

    private final byte[] zzi(String str) throws zzaz {
        byte[] bArr = this.zzk;
        if (bArr != null) {
            return bArr;
        }
        throw zzaz.zza("Missing CodecPrivate for codec ".concat(String.valueOf(str)), null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:107:0x019d  */
    /* JADX WARN: Code duplicated, block: B:124:0x01f9 A[PHI: r8
  0x01f9: PHI (r8v7 int) = (r8v1 int), (r8v2 int), (r8v3 int), (r8v4 int), (r8v5 int), (r8v6 int), (r8v0 int) binds: [B:143:0x027b, B:138:0x0249, B:135:0x0229, B:133:0x0224, B:131:0x021f, B:129:0x021b, B:123:0x01f7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:183:0x03ca  */
    /* JADX WARN: Code duplicated, block: B:188:0x03e4  */
    /* JADX WARN: Code duplicated, block: B:189:0x03e6  */
    /* JADX WARN: Code duplicated, block: B:192:0x03f3  */
    /* JADX WARN: Code duplicated, block: B:193:0x0403  */
    /* JADX WARN: Code duplicated, block: B:195:0x0409  */
    /* JADX WARN: Code duplicated, block: B:197:0x040d  */
    /* JADX WARN: Code duplicated, block: B:199:0x0412  */
    /* JADX WARN: Code duplicated, block: B:202:0x041a  */
    /* JADX WARN: Code duplicated, block: B:204:0x041f  */
    /* JADX WARN: Code duplicated, block: B:207:0x0426  */
    /* JADX WARN: Code duplicated, block: B:210:0x0434  */
    /* JADX WARN: Code duplicated, block: B:213:0x0439  */
    /* JADX WARN: Code duplicated, block: B:215:0x043f  */
    /* JADX WARN: Code duplicated, block: B:238:0x0519  */
    /* JADX WARN: Code duplicated, block: B:243:0x053a  */
    /* JADX WARN: Code duplicated, block: B:261:0x0585  */
    /* JADX WARN: Code duplicated, block: B:263:0x05a5  */
    /* JADX WARN: Code duplicated, block: B:265:0x05ad  */
    /* JADX WARN: Code duplicated, block: B:280:0x05dc  */
    /* JADX WARN: Code duplicated, block: B:285:0x05f7  */
    /* JADX WARN: Code duplicated, block: B:286:0x05fa  */
    public final void zze(zzady zzadyVar, int i) throws zzaz {
        byte b;
        List list;
        String str;
        String str2;
        List listZzo;
        int i2;
        List listZzg;
        int i3;
        List list2;
        List list3;
        String str3;
        int i4;
        zzx zzxVar;
        int i5;
        int iIntValue;
        int i6;
        float f;
        int i7;
        int i8;
        int i9;
        String str4;
        zzez zzezVarZza;
        List listZzo2;
        String str5 = this.zzc;
        int iZzn = 4;
        int i10 = 0;
        switch (str5.hashCode()) {
            case -2095576542:
                if (!str5.equals("V_MPEG4/ISO/AP")) {
                    b = -1;
                } else {
                    b = 6;
                }
                break;
            case -2095575984:
                if (!str5.equals("V_MPEG4/ISO/SP")) {
                    b = -1;
                } else {
                    b = 4;
                }
                break;
            case -1985379776:
                if (!str5.equals("A_MS/ACM")) {
                    b = -1;
                } else {
                    b = 23;
                }
                break;
            case -1784763192:
                if (!str5.equals("A_TRUEHD")) {
                    b = -1;
                } else {
                    b = 18;
                }
                break;
            case -1730367663:
                if (!str5.equals("A_VORBIS")) {
                    b = -1;
                } else {
                    b = 11;
                }
                break;
            case -1482641358:
                if (!str5.equals("A_MPEG/L2")) {
                    b = -1;
                } else {
                    b = 14;
                }
                break;
            case -1482641357:
                if (!str5.equals("A_MPEG/L3")) {
                    b = -1;
                } else {
                    b = 15;
                }
                break;
            case -1373388978:
                if (!str5.equals("V_MS/VFW/FOURCC")) {
                    b = -1;
                } else {
                    b = 9;
                }
                break;
            case -933872740:
                if (!str5.equals("S_DVBSUB")) {
                    b = -1;
                } else {
                    b = 33;
                }
                break;
            case -538363189:
                if (!str5.equals(ygoi.gVYx)) {
                    b = -1;
                } else {
                    b = 5;
                }
                break;
            case -538363109:
                if (!str5.equals("V_MPEG4/ISO/AVC")) {
                    b = -1;
                } else {
                    b = 7;
                }
                break;
            case -425012669:
                if (!str5.equals("S_VOBSUB")) {
                    b = -1;
                } else {
                    b = 31;
                }
                break;
            case -356037306:
                if (!str5.equals("A_DTS/LOSSLESS")) {
                    b = -1;
                } else {
                    b = 21;
                }
                break;
            case 62923557:
                if (!str5.equals("A_AAC")) {
                    b = -1;
                } else {
                    b = 13;
                }
                break;
            case 62923603:
                if (!str5.equals("A_AC3")) {
                    b = -1;
                } else {
                    b = 16;
                }
                break;
            case 62927045:
                if (!str5.equals("A_DTS")) {
                    b = -1;
                } else {
                    b = 19;
                }
                break;
            case 82318131:
                if (!str5.equals("V_AV1")) {
                    b = -1;
                } else {
                    b = 2;
                }
                break;
            case 82338133:
                if (!str5.equals("V_VP8")) {
                    b = -1;
                } else {
                    b = 0;
                }
                break;
            case 82338134:
                if (!str5.equals("V_VP9")) {
                    b = -1;
                } else {
                    b = 1;
                }
                break;
            case 99146302:
                if (!str5.equals("S_HDMV/PGS")) {
                    b = -1;
                } else {
                    b = 32;
                }
                break;
            case 444813526:
                if (!str5.equals(UUFMQdNK.kTgWMlNvzB)) {
                    b = -1;
                } else {
                    b = 10;
                }
                break;
            case 542569478:
                if (!str5.equals("A_DTS/EXPRESS")) {
                    b = -1;
                } else {
                    b = 20;
                }
                break;
            case 635596514:
                if (!str5.equals("A_PCM/FLOAT/IEEE")) {
                    b = -1;
                } else {
                    b = 26;
                }
                break;
            case 725948237:
                if (!str5.equals("A_PCM/INT/BIG")) {
                    b = -1;
                } else {
                    b = 25;
                }
                break;
            case 725957860:
                if (!str5.equals("A_PCM/INT/LIT")) {
                    b = -1;
                } else {
                    b = 24;
                }
                break;
            case 738597099:
                if (!str5.equals("S_TEXT/ASS")) {
                    b = -1;
                } else {
                    b = 28;
                }
                break;
            case 738614379:
                if (!str5.equals("S_TEXT/SSA")) {
                    b = -1;
                } else {
                    b = 29;
                }
                break;
            case 855502857:
                if (!str5.equals("V_MPEGH/ISO/HEVC")) {
                    b = -1;
                } else {
                    b = 8;
                }
                break;
            case 1045209816:
                if (!str5.equals("S_TEXT/WEBVTT")) {
                    b = -1;
                } else {
                    b = 30;
                }
                break;
            case 1422270023:
                if (!str5.equals("S_TEXT/UTF8")) {
                    b = -1;
                } else {
                    b = 27;
                }
                break;
            case 1809237540:
                if (!str5.equals("V_MPEG2")) {
                    b = -1;
                } else {
                    b = 3;
                }
                break;
            case 1950749482:
                if (!str5.equals("A_EAC3")) {
                    b = -1;
                } else {
                    b = 17;
                }
                break;
            case 1950789798:
                if (!str5.equals("A_FLAC")) {
                    b = -1;
                } else {
                    b = 22;
                }
                break;
            case 1951062397:
                if (!str5.equals("A_OPUS")) {
                    b = -1;
                } else {
                    b = 12;
                }
                break;
            default:
                b = -1;
                break;
        }
        String str6 = "audio/raw";
        zzk zzkVarZzg = null;
        bArr = null;
        bArr = null;
        bArr = null;
        bArr = null;
        bArr = null;
        bArr = null;
        bArr = null;
        bArr = null;
        bArr = null;
        byte[] bArr = null;
        switch (b) {
            case 0:
                str6 = "video/x-vnd.on2.vp8";
                listZzo = null;
                str2 = null;
                i2 = -1;
                list2 = listZzo;
                iZzn = -1;
                list3 = list2;
                if (this.zzO != null && (zzezVarZza = zzez.zza(new zzen(this.zzO))) != null) {
                    str2 = zzezVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i11 = (z ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                    zzxVar.zzD(this.zzP);
                    zzxVar.zzai(this.zzR);
                    zzxVar.zzab(iZzn);
                    i5 = 1;
                } else if (zzay.zzj(str3)) {
                    if (this.zzr == 0) {
                        i8 = this.zzp;
                        iIntValue = -1;
                        if (i8 == -1) {
                            i8 = this.zzm;
                        }
                        this.zzp = i8;
                        i9 = this.zzq;
                        if (i9 == -1) {
                            i9 = this.zzn;
                        }
                        this.zzq = i9;
                    } else {
                        iIntValue = -1;
                    }
                    i6 = this.zzp;
                    if (i6 != iIntValue || (i7 = this.zzq) == iIntValue) {
                        f = -1.0f;
                    } else {
                        f = (this.zzn * i6) / (this.zzm * i7);
                    }
                    if (this.zzy) {
                        if (this.zzE != -1.0f && this.zzF != -1.0f && this.zzG != -1.0f && this.zzH != -1.0f && this.zzI != -1.0f && this.zzJ != -1.0f && this.zzK != -1.0f && this.zzL != -1.0f && this.zzM != -1.0f && this.zzN != -1.0f) {
                            bArr = new byte[25];
                            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                            byteBufferOrder.put((byte) 0);
                            byteBufferOrder.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzL * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) (this.zzM + 0.5f));
                            byteBufferOrder.putShort((short) (this.zzN + 0.5f));
                            byteBufferOrder.putShort((short) this.zzC);
                            byteBufferOrder.putShort((short) this.zzD);
                        }
                        zzi zziVar = new zzi();
                        zziVar.zzc(this.zzz);
                        zziVar.zzb(this.zzB);
                        zziVar.zzd(this.zzA);
                        zziVar.zze(bArr);
                        zziVar.zzf(this.zzo);
                        zziVar.zza(this.zzo);
                        zzkVarZzg = zziVar.zzg();
                    }
                    if (this.zzb != null && zzahy.zzf.containsKey(this.zzb)) {
                        iIntValue = ((Integer) zzahy.zzf.get(this.zzb)).intValue();
                    }
                    if (this.zzs == 0 || Float.compare(this.zzt, 0.0f) != 0 || Float.compare(this.zzu, 0.0f) != 0) {
                        i10 = iIntValue;
                    } else if (Float.compare(this.zzv, 0.0f) != 0) {
                        if (Float.compare(this.zzv, 90.0f) == 0) {
                            i10 = 90;
                        } else if (Float.compare(this.zzv, -180.0f) == 0 || Float.compare(this.zzv, 180.0f) == 0) {
                            i10 = 180;
                        } else if (Float.compare(this.zzv, -90.0f) == 0) {
                            i10 = 270;
                        } else {
                            i10 = iIntValue;
                        }
                    }
                    zzxVar.zzam(this.zzm);
                    zzxVar.zzQ(this.zzn);
                    zzxVar.zzad(f);
                    zzxVar.zzag(i10);
                    zzxVar.zzae(this.zzw);
                    zzxVar.zzak(this.zzx);
                    zzxVar.zzF(zzkVarZzg);
                    i5 = 2;
                } else {
                    if ("application/x-subrip".equals(str3) && !"text/x-ssa".equals(str3) && !"text/vtt".equals(str3) && !"application/vobsub".equals(str3) && !"application/pgs".equals(str3) && !"application/dvbsubs".equals(str3)) {
                        throw zzaz.zza("Unexpected MIME type.", null);
                    }
                    i5 = 3;
                }
                if (this.zzb != null && !zzahy.zzf.containsKey(this.zzb)) {
                    zzxVar.zzU(this.zzb);
                }
                zzxVar.zzR(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzG(str4);
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i11);
                zzxVar.zzT(list3);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzzVarZzan = zzxVar.zzan();
                zzafb zzafbVarZzw = zzadyVar.zzw(this.zzd, i5);
                this.zzX = zzafbVarZzw;
                zzafbVarZzw.zzm(zzzVarZzan);
                return;
            case 1:
                byte[] bArr2 = this.zzk;
                str6 = "video/x-vnd.on2.vp9";
                listZzo2 = bArr2 == null ? null : zzfyq.zzo(bArr2);
                str2 = null;
                listZzo = listZzo2;
                i2 = -1;
                list2 = listZzo;
                iZzn = -1;
                list3 = list2;
                if (this.zzO != null) {
                    str2 = zzezVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z2 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i12 = (z2 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                    if (zzay.zzj(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            iIntValue = -1;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        } else {
                            iIntValue = -1;
                        }
                        i6 = this.zzp;
                        if (i6 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder2 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder2.put((byte) 0);
                                byteBufferOrder2.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder2.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder2.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder2.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder2.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder2.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder2.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder2.putShort((short) ((this.zzL * 50000.0f) + 0.5f));
                                byteBufferOrder2.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder2.putShort((short) (this.zzN + 0.5f));
                                byteBufferOrder2.putShort((short) this.zzC);
                                byteBufferOrder2.putShort((short) this.zzD);
                            }
                            zzi zziVar2 = new zzi();
                            zziVar2.zzc(this.zzz);
                            zziVar2.zzb(this.zzB);
                            zziVar2.zzd(this.zzA);
                            zziVar2.zze(bArr);
                            zziVar2.zzf(this.zzo);
                            zziVar2.zza(this.zzo);
                            zzkVarZzg = zziVar2.zzg();
                        }
                        if (this.zzb != null) {
                            iIntValue = ((Integer) zzahy.zzf.get(this.zzb)).intValue();
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzxVar.zzam(this.zzm);
                        zzxVar.zzQ(this.zzn);
                        zzxVar.zzad(f);
                        zzxVar.zzag(i10);
                        zzxVar.zzae(this.zzw);
                        zzxVar.zzak(this.zzx);
                        zzxVar.zzF(zzkVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zzxVar.zzD(this.zzP);
                    zzxVar.zzai(this.zzR);
                    zzxVar.zzab(iZzn);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    zzxVar.zzU(this.zzb);
                }
                zzxVar.zzR(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzG(str4);
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i12);
                zzxVar.zzT(list3);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzzVarZzan2 = zzxVar.zzan();
                zzafb zzafbVarZzw2 = zzadyVar.zzw(this.zzd, i5);
                this.zzX = zzafbVarZzw2;
                zzafbVarZzw2.zzm(zzzVarZzan2);
                return;
            case 2:
                byte[] bArr3 = this.zzk;
                str6 = "video/av01";
                listZzo2 = bArr3 == null ? null : zzfyq.zzo(bArr3);
                str2 = null;
                listZzo = listZzo2;
                i2 = -1;
                list2 = listZzo;
                iZzn = -1;
                list3 = list2;
                if (this.zzO != null) {
                    str2 = zzezVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z3 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i13 = (z3 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                    if (zzay.zzj(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            iIntValue = -1;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        } else {
                            iIntValue = -1;
                        }
                        i6 = this.zzp;
                        if (i6 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder3 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder3.put((byte) 0);
                                byteBufferOrder3.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder3.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder3.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder3.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder3.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder3.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder3.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder3.putShort((short) ((this.zzL * 50000.0f) + 0.5f));
                                byteBufferOrder3.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder3.putShort((short) (this.zzN + 0.5f));
                                byteBufferOrder3.putShort((short) this.zzC);
                                byteBufferOrder3.putShort((short) this.zzD);
                            }
                            zzi zziVar3 = new zzi();
                            zziVar3.zzc(this.zzz);
                            zziVar3.zzb(this.zzB);
                            zziVar3.zzd(this.zzA);
                            zziVar3.zze(bArr);
                            zziVar3.zzf(this.zzo);
                            zziVar3.zza(this.zzo);
                            zzkVarZzg = zziVar3.zzg();
                        }
                        if (this.zzb != null) {
                            iIntValue = ((Integer) zzahy.zzf.get(this.zzb)).intValue();
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzxVar.zzam(this.zzm);
                        zzxVar.zzQ(this.zzn);
                        zzxVar.zzad(f);
                        zzxVar.zzag(i10);
                        zzxVar.zzae(this.zzw);
                        zzxVar.zzak(this.zzx);
                        zzxVar.zzF(zzkVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zzxVar.zzD(this.zzP);
                    zzxVar.zzai(this.zzR);
                    zzxVar.zzab(iZzn);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    zzxVar.zzU(this.zzb);
                }
                zzxVar.zzR(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzG(str4);
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i13);
                zzxVar.zzT(list3);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzzVarZzan3 = zzxVar.zzan();
                zzafb zzafbVarZzw3 = zzadyVar.zzw(this.zzd, i5);
                this.zzX = zzafbVarZzw3;
                zzafbVarZzw3.zzm(zzzVarZzan3);
                return;
            case 3:
                str6 = "video/mpeg2";
                listZzo = null;
                str2 = null;
                i2 = -1;
                list2 = listZzo;
                iZzn = -1;
                list3 = list2;
                if (this.zzO != null) {
                    str2 = zzezVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z4 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i14 = (z4 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                    if (zzay.zzj(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            iIntValue = -1;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        } else {
                            iIntValue = -1;
                        }
                        i6 = this.zzp;
                        if (i6 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder4 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder4.put((byte) 0);
                                byteBufferOrder4.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder4.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder4.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder4.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder4.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder4.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder4.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder4.putShort((short) ((this.zzL * 50000.0f) + 0.5f));
                                byteBufferOrder4.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder4.putShort((short) (this.zzN + 0.5f));
                                byteBufferOrder4.putShort((short) this.zzC);
                                byteBufferOrder4.putShort((short) this.zzD);
                            }
                            zzi zziVar4 = new zzi();
                            zziVar4.zzc(this.zzz);
                            zziVar4.zzb(this.zzB);
                            zziVar4.zzd(this.zzA);
                            zziVar4.zze(bArr);
                            zziVar4.zzf(this.zzo);
                            zziVar4.zza(this.zzo);
                            zzkVarZzg = zziVar4.zzg();
                        }
                        if (this.zzb != null) {
                            iIntValue = ((Integer) zzahy.zzf.get(this.zzb)).intValue();
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzxVar.zzam(this.zzm);
                        zzxVar.zzQ(this.zzn);
                        zzxVar.zzad(f);
                        zzxVar.zzag(i10);
                        zzxVar.zzae(this.zzw);
                        zzxVar.zzak(this.zzx);
                        zzxVar.zzF(zzkVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zzxVar.zzD(this.zzP);
                    zzxVar.zzai(this.zzR);
                    zzxVar.zzab(iZzn);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    zzxVar.zzU(this.zzb);
                }
                zzxVar.zzR(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzG(str4);
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i14);
                zzxVar.zzT(list3);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzzVarZzan4 = zzxVar.zzan();
                zzafb zzafbVarZzw4 = zzadyVar.zzw(this.zzd, i5);
                this.zzX = zzafbVarZzw4;
                zzafbVarZzw4.zzm(zzzVarZzan4);
                return;
            case 4:
            case 5:
            case 6:
                byte[] bArr4 = this.zzk;
                str6 = "video/mp4v-es";
                listZzo2 = bArr4 == null ? null : Collections.singletonList(bArr4);
                str2 = null;
                listZzo = listZzo2;
                i2 = -1;
                list2 = listZzo;
                iZzn = -1;
                list3 = list2;
                if (this.zzO != null) {
                    str2 = zzezVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z5 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i15 = (z5 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                    if (zzay.zzj(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            iIntValue = -1;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        } else {
                            iIntValue = -1;
                        }
                        i6 = this.zzp;
                        if (i6 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder5 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder5.put((byte) 0);
                                byteBufferOrder5.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder5.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder5.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder5.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder5.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder5.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder5.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder5.putShort((short) ((this.zzL * 50000.0f) + 0.5f));
                                byteBufferOrder5.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder5.putShort((short) (this.zzN + 0.5f));
                                byteBufferOrder5.putShort((short) this.zzC);
                                byteBufferOrder5.putShort((short) this.zzD);
                            }
                            zzi zziVar5 = new zzi();
                            zziVar5.zzc(this.zzz);
                            zziVar5.zzb(this.zzB);
                            zziVar5.zzd(this.zzA);
                            zziVar5.zze(bArr);
                            zziVar5.zzf(this.zzo);
                            zziVar5.zza(this.zzo);
                            zzkVarZzg = zziVar5.zzg();
                        }
                        if (this.zzb != null) {
                            iIntValue = ((Integer) zzahy.zzf.get(this.zzb)).intValue();
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzxVar.zzam(this.zzm);
                        zzxVar.zzQ(this.zzn);
                        zzxVar.zzad(f);
                        zzxVar.zzag(i10);
                        zzxVar.zzae(this.zzw);
                        zzxVar.zzak(this.zzx);
                        zzxVar.zzF(zzkVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zzxVar.zzD(this.zzP);
                    zzxVar.zzai(this.zzR);
                    zzxVar.zzab(iZzn);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    zzxVar.zzU(this.zzb);
                }
                zzxVar.zzR(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzG(str4);
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i15);
                zzxVar.zzT(list3);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzzVarZzan5 = zzxVar.zzan();
                zzafb zzafbVarZzw5 = zzadyVar.zzw(this.zzd, i5);
                this.zzX = zzafbVarZzw5;
                zzafbVarZzw5.zzm(zzzVarZzan5);
                return;
            case 7:
                zzacz zzaczVarZza = zzacz.zza(new zzen(zzi(this.zzc)));
                list = zzaczVarZza.zza;
                this.zzY = zzaczVarZza.zzb;
                str = zzaczVarZza.zzl;
                str6 = "video/avc";
                str2 = str;
                listZzo = list;
                i2 = -1;
                list2 = listZzo;
                iZzn = -1;
                list3 = list2;
                if (this.zzO != null) {
                    str2 = zzezVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z6 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i16 = (z6 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                    if (zzay.zzj(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            iIntValue = -1;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        } else {
                            iIntValue = -1;
                        }
                        i6 = this.zzp;
                        if (i6 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder6 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder6.put((byte) 0);
                                byteBufferOrder6.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder6.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder6.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder6.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder6.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder6.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder6.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder6.putShort((short) ((this.zzL * 50000.0f) + 0.5f));
                                byteBufferOrder6.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder6.putShort((short) (this.zzN + 0.5f));
                                byteBufferOrder6.putShort((short) this.zzC);
                                byteBufferOrder6.putShort((short) this.zzD);
                            }
                            zzi zziVar6 = new zzi();
                            zziVar6.zzc(this.zzz);
                            zziVar6.zzb(this.zzB);
                            zziVar6.zzd(this.zzA);
                            zziVar6.zze(bArr);
                            zziVar6.zzf(this.zzo);
                            zziVar6.zza(this.zzo);
                            zzkVarZzg = zziVar6.zzg();
                        }
                        if (this.zzb != null) {
                            iIntValue = ((Integer) zzahy.zzf.get(this.zzb)).intValue();
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzxVar.zzam(this.zzm);
                        zzxVar.zzQ(this.zzn);
                        zzxVar.zzad(f);
                        zzxVar.zzag(i10);
                        zzxVar.zzae(this.zzw);
                        zzxVar.zzak(this.zzx);
                        zzxVar.zzF(zzkVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zzxVar.zzD(this.zzP);
                    zzxVar.zzai(this.zzR);
                    zzxVar.zzab(iZzn);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    zzxVar.zzU(this.zzb);
                }
                zzxVar.zzR(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzG(str4);
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i16);
                zzxVar.zzT(list3);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzzVarZzan6 = zzxVar.zzan();
                zzafb zzafbVarZzw6 = zzadyVar.zzw(this.zzd, i5);
                this.zzX = zzafbVarZzw6;
                zzafbVarZzw6.zzm(zzzVarZzan6);
                return;
            case 8:
                zzaek zzaekVarZza = zzaek.zza(new zzen(zzi(this.zzc)));
                list = zzaekVarZza.zza;
                this.zzY = zzaekVarZza.zzb;
                str = zzaekVarZza.zzn;
                str6 = "video/hevc";
                str2 = str;
                listZzo = list;
                i2 = -1;
                list2 = listZzo;
                iZzn = -1;
                list3 = list2;
                if (this.zzO != null) {
                    str2 = zzezVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z7 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i17 = (z7 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                    if (zzay.zzj(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            iIntValue = -1;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        } else {
                            iIntValue = -1;
                        }
                        i6 = this.zzp;
                        if (i6 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder7 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder7.put((byte) 0);
                                byteBufferOrder7.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder7.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder7.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder7.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder7.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder7.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder7.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder7.putShort((short) ((this.zzL * 50000.0f) + 0.5f));
                                byteBufferOrder7.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder7.putShort((short) (this.zzN + 0.5f));
                                byteBufferOrder7.putShort((short) this.zzC);
                                byteBufferOrder7.putShort((short) this.zzD);
                            }
                            zzi zziVar7 = new zzi();
                            zziVar7.zzc(this.zzz);
                            zziVar7.zzb(this.zzB);
                            zziVar7.zzd(this.zzA);
                            zziVar7.zze(bArr);
                            zziVar7.zzf(this.zzo);
                            zziVar7.zza(this.zzo);
                            zzkVarZzg = zziVar7.zzg();
                        }
                        if (this.zzb != null) {
                            iIntValue = ((Integer) zzahy.zzf.get(this.zzb)).intValue();
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzxVar.zzam(this.zzm);
                        zzxVar.zzQ(this.zzn);
                        zzxVar.zzad(f);
                        zzxVar.zzag(i10);
                        zzxVar.zzae(this.zzw);
                        zzxVar.zzak(this.zzx);
                        zzxVar.zzF(zzkVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zzxVar.zzD(this.zzP);
                    zzxVar.zzai(this.zzR);
                    zzxVar.zzab(iZzn);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    zzxVar.zzU(this.zzb);
                }
                zzxVar.zzR(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzG(str4);
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i17);
                zzxVar.zzT(list3);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzzVarZzan7 = zzxVar.zzan();
                zzafb zzafbVarZzw7 = zzadyVar.zzw(this.zzd, i5);
                this.zzX = zzafbVarZzw7;
                zzafbVarZzw7.zzm(zzzVarZzan7);
                return;
            case 9:
                Pair pairZzf = zzf(new zzen(zzi(this.zzc)));
                str6 = (String) pairZzf.first;
                listZzo2 = (List) pairZzf.second;
                str2 = null;
                listZzo = listZzo2;
                i2 = -1;
                list2 = listZzo;
                iZzn = -1;
                list3 = list2;
                if (this.zzO != null) {
                    str2 = zzezVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z8 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i18 = (z8 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                    if (zzay.zzj(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            iIntValue = -1;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        } else {
                            iIntValue = -1;
                        }
                        i6 = this.zzp;
                        if (i6 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder8 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder8.put((byte) 0);
                                byteBufferOrder8.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder8.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder8.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder8.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder8.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder8.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder8.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder8.putShort((short) ((this.zzL * 50000.0f) + 0.5f));
                                byteBufferOrder8.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder8.putShort((short) (this.zzN + 0.5f));
                                byteBufferOrder8.putShort((short) this.zzC);
                                byteBufferOrder8.putShort((short) this.zzD);
                            }
                            zzi zziVar8 = new zzi();
                            zziVar8.zzc(this.zzz);
                            zziVar8.zzb(this.zzB);
                            zziVar8.zzd(this.zzA);
                            zziVar8.zze(bArr);
                            zziVar8.zzf(this.zzo);
                            zziVar8.zza(this.zzo);
                            zzkVarZzg = zziVar8.zzg();
                        }
                        if (this.zzb != null) {
                            iIntValue = ((Integer) zzahy.zzf.get(this.zzb)).intValue();
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzxVar.zzam(this.zzm);
                        zzxVar.zzQ(this.zzn);
                        zzxVar.zzad(f);
                        zzxVar.zzag(i10);
                        zzxVar.zzae(this.zzw);
                        zzxVar.zzak(this.zzx);
                        zzxVar.zzF(zzkVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zzxVar.zzD(this.zzP);
                    zzxVar.zzai(this.zzR);
                    zzxVar.zzab(iZzn);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    zzxVar.zzU(this.zzb);
                }
                zzxVar.zzR(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzG(str4);
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i18);
                zzxVar.zzT(list3);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzzVarZzan8 = zzxVar.zzan();
                zzafb zzafbVarZzw8 = zzadyVar.zzw(this.zzd, i5);
                this.zzX = zzafbVarZzw8;
                zzafbVarZzw8.zzm(zzzVarZzan8);
                return;
            case 10:
                str6 = "video/x-unknown";
                listZzo = null;
                str2 = null;
                i2 = -1;
                list2 = listZzo;
                iZzn = -1;
                list3 = list2;
                if (this.zzO != null) {
                    str2 = zzezVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z9 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i19 = (z9 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                    if (zzay.zzj(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            iIntValue = -1;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        } else {
                            iIntValue = -1;
                        }
                        i6 = this.zzp;
                        if (i6 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder9 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder9.put((byte) 0);
                                byteBufferOrder9.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder9.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder9.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder9.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder9.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder9.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder9.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder9.putShort((short) ((this.zzL * 50000.0f) + 0.5f));
                                byteBufferOrder9.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder9.putShort((short) (this.zzN + 0.5f));
                                byteBufferOrder9.putShort((short) this.zzC);
                                byteBufferOrder9.putShort((short) this.zzD);
                            }
                            zzi zziVar9 = new zzi();
                            zziVar9.zzc(this.zzz);
                            zziVar9.zzb(this.zzB);
                            zziVar9.zzd(this.zzA);
                            zziVar9.zze(bArr);
                            zziVar9.zzf(this.zzo);
                            zziVar9.zza(this.zzo);
                            zzkVarZzg = zziVar9.zzg();
                        }
                        if (this.zzb != null) {
                            iIntValue = ((Integer) zzahy.zzf.get(this.zzb)).intValue();
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzxVar.zzam(this.zzm);
                        zzxVar.zzQ(this.zzn);
                        zzxVar.zzad(f);
                        zzxVar.zzag(i10);
                        zzxVar.zzae(this.zzw);
                        zzxVar.zzak(this.zzx);
                        zzxVar.zzF(zzkVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zzxVar.zzD(this.zzP);
                    zzxVar.zzai(this.zzR);
                    zzxVar.zzab(iZzn);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    zzxVar.zzU(this.zzb);
                }
                zzxVar.zzR(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzG(str4);
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i19);
                zzxVar.zzT(list3);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzzVarZzan9 = zzxVar.zzan();
                zzafb zzafbVarZzw9 = zzadyVar.zzw(this.zzd, i5);
                this.zzX = zzafbVarZzw9;
                zzafbVarZzw9.zzm(zzzVarZzan9);
                return;
            case 11:
                i2 = 8192;
                str6 = "audio/vorbis";
                listZzg = zzg(zzi(str5));
                str2 = null;
                list2 = listZzg;
                iZzn = -1;
                list3 = list2;
                if (this.zzO != null) {
                    str2 = zzezVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z10 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i110 = (z10 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                    if (zzay.zzj(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            iIntValue = -1;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        } else {
                            iIntValue = -1;
                        }
                        i6 = this.zzp;
                        if (i6 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder10 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder10.put((byte) 0);
                                byteBufferOrder10.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder10.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder10.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder10.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder10.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder10.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder10.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder10.putShort((short) ((this.zzL * 50000.0f) + 0.5f));
                                byteBufferOrder10.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder10.putShort((short) (this.zzN + 0.5f));
                                byteBufferOrder10.putShort((short) this.zzC);
                                byteBufferOrder10.putShort((short) this.zzD);
                            }
                            zzi zziVar10 = new zzi();
                            zziVar10.zzc(this.zzz);
                            zziVar10.zzb(this.zzB);
                            zziVar10.zzd(this.zzA);
                            zziVar10.zze(bArr);
                            zziVar10.zzf(this.zzo);
                            zziVar10.zza(this.zzo);
                            zzkVarZzg = zziVar10.zzg();
                        }
                        if (this.zzb != null) {
                            iIntValue = ((Integer) zzahy.zzf.get(this.zzb)).intValue();
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzxVar.zzam(this.zzm);
                        zzxVar.zzQ(this.zzn);
                        zzxVar.zzad(f);
                        zzxVar.zzag(i10);
                        zzxVar.zzae(this.zzw);
                        zzxVar.zzak(this.zzx);
                        zzxVar.zzF(zzkVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zzxVar.zzD(this.zzP);
                    zzxVar.zzai(this.zzR);
                    zzxVar.zzab(iZzn);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    zzxVar.zzU(this.zzb);
                }
                zzxVar.zzR(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzG(str4);
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i110);
                zzxVar.zzT(list3);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzzVarZzan10 = zzxVar.zzan();
                zzafb zzafbVarZzw10 = zzadyVar.zzw(this.zzd, i5);
                this.zzX = zzafbVarZzw10;
                zzafbVarZzw10.zzm(zzzVarZzan10);
                return;
            case 12:
                ArrayList arrayList = new ArrayList(3);
                arrayList.add(zzi(this.zzc));
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                arrayList.add(byteBufferAllocate.order(byteOrder).putLong(this.zzS).array());
                arrayList.add(ByteBuffer.allocate(8).order(byteOrder).putLong(this.zzT).array());
                i2 = 5760;
                str6 = "audio/opus";
                listZzg = arrayList;
                str2 = null;
                list2 = listZzg;
                iZzn = -1;
                list3 = list2;
                if (this.zzO != null) {
                    str2 = zzezVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z11 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i111 = (z11 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                    if (zzay.zzj(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            iIntValue = -1;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        } else {
                            iIntValue = -1;
                        }
                        i6 = this.zzp;
                        if (i6 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder11 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder11.put((byte) 0);
                                byteBufferOrder11.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder11.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder11.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder11.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder11.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder11.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder11.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder11.putShort((short) ((this.zzL * 50000.0f) + 0.5f));
                                byteBufferOrder11.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder11.putShort((short) (this.zzN + 0.5f));
                                byteBufferOrder11.putShort((short) this.zzC);
                                byteBufferOrder11.putShort((short) this.zzD);
                            }
                            zzi zziVar11 = new zzi();
                            zziVar11.zzc(this.zzz);
                            zziVar11.zzb(this.zzB);
                            zziVar11.zzd(this.zzA);
                            zziVar11.zze(bArr);
                            zziVar11.zzf(this.zzo);
                            zziVar11.zza(this.zzo);
                            zzkVarZzg = zziVar11.zzg();
                        }
                        if (this.zzb != null) {
                            iIntValue = ((Integer) zzahy.zzf.get(this.zzb)).intValue();
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzxVar.zzam(this.zzm);
                        zzxVar.zzQ(this.zzn);
                        zzxVar.zzad(f);
                        zzxVar.zzag(i10);
                        zzxVar.zzae(this.zzw);
                        zzxVar.zzak(this.zzx);
                        zzxVar.zzF(zzkVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zzxVar.zzD(this.zzP);
                    zzxVar.zzai(this.zzR);
                    zzxVar.zzab(iZzn);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    zzxVar.zzU(this.zzb);
                }
                zzxVar.zzR(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzG(str4);
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i111);
                zzxVar.zzT(list3);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzzVarZzan11 = zzxVar.zzan();
                zzafb zzafbVarZzw11 = zzadyVar.zzw(this.zzd, i5);
                this.zzX = zzafbVarZzw11;
                zzafbVarZzw11.zzm(zzzVarZzan11);
                return;
            case 13:
                List listSingletonList = Collections.singletonList(zzi(str5));
                zzacp zzacpVarZza = zzacr.zza(this.zzk);
                this.zzR = zzacpVarZza.zza;
                this.zzP = zzacpVarZza.zzb;
                str6 = "audio/mp4a-latm";
                str2 = zzacpVarZza.zzc;
                listZzo = listSingletonList;
                i2 = -1;
                list2 = listZzo;
                iZzn = -1;
                list3 = list2;
                if (this.zzO != null) {
                    str2 = zzezVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z12 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i112 = (z12 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                    if (zzay.zzj(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            iIntValue = -1;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        } else {
                            iIntValue = -1;
                        }
                        i6 = this.zzp;
                        if (i6 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder12 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder12.put((byte) 0);
                                byteBufferOrder12.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder12.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder12.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder12.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder12.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder12.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder12.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder12.putShort((short) ((this.zzL * 50000.0f) + 0.5f));
                                byteBufferOrder12.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder12.putShort((short) (this.zzN + 0.5f));
                                byteBufferOrder12.putShort((short) this.zzC);
                                byteBufferOrder12.putShort((short) this.zzD);
                            }
                            zzi zziVar12 = new zzi();
                            zziVar12.zzc(this.zzz);
                            zziVar12.zzb(this.zzB);
                            zziVar12.zzd(this.zzA);
                            zziVar12.zze(bArr);
                            zziVar12.zzf(this.zzo);
                            zziVar12.zza(this.zzo);
                            zzkVarZzg = zziVar12.zzg();
                        }
                        if (this.zzb != null) {
                            iIntValue = ((Integer) zzahy.zzf.get(this.zzb)).intValue();
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzxVar.zzam(this.zzm);
                        zzxVar.zzQ(this.zzn);
                        zzxVar.zzad(f);
                        zzxVar.zzag(i10);
                        zzxVar.zzae(this.zzw);
                        zzxVar.zzak(this.zzx);
                        zzxVar.zzF(zzkVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zzxVar.zzD(this.zzP);
                    zzxVar.zzai(this.zzR);
                    zzxVar.zzab(iZzn);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    zzxVar.zzU(this.zzb);
                }
                zzxVar.zzR(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzG(str4);
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i112);
                zzxVar.zzT(list3);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzzVarZzan12 = zzxVar.zzan();
                zzafb zzafbVarZzw12 = zzadyVar.zzw(this.zzd, i5);
                this.zzX = zzafbVarZzw12;
                zzafbVarZzw12.zzm(zzzVarZzan12);
                return;
            case 14:
                i3 = 4096;
                str6 = "audio/mpeg-L2";
                i2 = i3;
                list2 = null;
                str2 = null;
                iZzn = -1;
                list3 = list2;
                if (this.zzO != null) {
                    str2 = zzezVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z13 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i113 = (z13 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                    if (zzay.zzj(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            iIntValue = -1;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        } else {
                            iIntValue = -1;
                        }
                        i6 = this.zzp;
                        if (i6 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder13 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder13.put((byte) 0);
                                byteBufferOrder13.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder13.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder13.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder13.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder13.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder13.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder13.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder13.putShort((short) ((this.zzL * 50000.0f) + 0.5f));
                                byteBufferOrder13.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder13.putShort((short) (this.zzN + 0.5f));
                                byteBufferOrder13.putShort((short) this.zzC);
                                byteBufferOrder13.putShort((short) this.zzD);
                            }
                            zzi zziVar13 = new zzi();
                            zziVar13.zzc(this.zzz);
                            zziVar13.zzb(this.zzB);
                            zziVar13.zzd(this.zzA);
                            zziVar13.zze(bArr);
                            zziVar13.zzf(this.zzo);
                            zziVar13.zza(this.zzo);
                            zzkVarZzg = zziVar13.zzg();
                        }
                        if (this.zzb != null) {
                            iIntValue = ((Integer) zzahy.zzf.get(this.zzb)).intValue();
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzxVar.zzam(this.zzm);
                        zzxVar.zzQ(this.zzn);
                        zzxVar.zzad(f);
                        zzxVar.zzag(i10);
                        zzxVar.zzae(this.zzw);
                        zzxVar.zzak(this.zzx);
                        zzxVar.zzF(zzkVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zzxVar.zzD(this.zzP);
                    zzxVar.zzai(this.zzR);
                    zzxVar.zzab(iZzn);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    zzxVar.zzU(this.zzb);
                }
                zzxVar.zzR(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzG(str4);
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i113);
                zzxVar.zzT(list3);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzzVarZzan13 = zzxVar.zzan();
                zzafb zzafbVarZzw13 = zzadyVar.zzw(this.zzd, i5);
                this.zzX = zzafbVarZzw13;
                zzafbVarZzw13.zzm(zzzVarZzan13);
                return;
            case 15:
                i3 = 4096;
                str6 = "audio/mpeg";
                i2 = i3;
                list2 = null;
                str2 = null;
                iZzn = -1;
                list3 = list2;
                if (this.zzO != null) {
                    str2 = zzezVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z14 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i114 = (z14 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                    if (zzay.zzj(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            iIntValue = -1;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        } else {
                            iIntValue = -1;
                        }
                        i6 = this.zzp;
                        if (i6 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder14 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder14.put((byte) 0);
                                byteBufferOrder14.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder14.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder14.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder14.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder14.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder14.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder14.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder14.putShort((short) ((this.zzL * 50000.0f) + 0.5f));
                                byteBufferOrder14.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder14.putShort((short) (this.zzN + 0.5f));
                                byteBufferOrder14.putShort((short) this.zzC);
                                byteBufferOrder14.putShort((short) this.zzD);
                            }
                            zzi zziVar14 = new zzi();
                            zziVar14.zzc(this.zzz);
                            zziVar14.zzb(this.zzB);
                            zziVar14.zzd(this.zzA);
                            zziVar14.zze(bArr);
                            zziVar14.zzf(this.zzo);
                            zziVar14.zza(this.zzo);
                            zzkVarZzg = zziVar14.zzg();
                        }
                        if (this.zzb != null) {
                            iIntValue = ((Integer) zzahy.zzf.get(this.zzb)).intValue();
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzxVar.zzam(this.zzm);
                        zzxVar.zzQ(this.zzn);
                        zzxVar.zzad(f);
                        zzxVar.zzag(i10);
                        zzxVar.zzae(this.zzw);
                        zzxVar.zzak(this.zzx);
                        zzxVar.zzF(zzkVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zzxVar.zzD(this.zzP);
                    zzxVar.zzai(this.zzR);
                    zzxVar.zzab(iZzn);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    zzxVar.zzU(this.zzb);
                }
                zzxVar.zzR(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzG(str4);
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i114);
                zzxVar.zzT(list3);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzzVarZzan14 = zzxVar.zzan();
                zzafb zzafbVarZzw14 = zzadyVar.zzw(this.zzd, i5);
                this.zzX = zzafbVarZzw14;
                zzafbVarZzw14.zzm(zzzVarZzan14);
                return;
            case 16:
                str6 = UUFMQdNK.TrrUrTobFFA;
                listZzo = null;
                str2 = null;
                i2 = -1;
                list2 = listZzo;
                iZzn = -1;
                list3 = list2;
                if (this.zzO != null) {
                    str2 = zzezVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z15 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i115 = (z15 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                    if (zzay.zzj(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            iIntValue = -1;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        } else {
                            iIntValue = -1;
                        }
                        i6 = this.zzp;
                        if (i6 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder15 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder15.put((byte) 0);
                                byteBufferOrder15.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder15.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder15.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder15.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder15.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder15.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder15.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder15.putShort((short) ((this.zzL * 50000.0f) + 0.5f));
                                byteBufferOrder15.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder15.putShort((short) (this.zzN + 0.5f));
                                byteBufferOrder15.putShort((short) this.zzC);
                                byteBufferOrder15.putShort((short) this.zzD);
                            }
                            zzi zziVar15 = new zzi();
                            zziVar15.zzc(this.zzz);
                            zziVar15.zzb(this.zzB);
                            zziVar15.zzd(this.zzA);
                            zziVar15.zze(bArr);
                            zziVar15.zzf(this.zzo);
                            zziVar15.zza(this.zzo);
                            zzkVarZzg = zziVar15.zzg();
                        }
                        if (this.zzb != null) {
                            iIntValue = ((Integer) zzahy.zzf.get(this.zzb)).intValue();
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzxVar.zzam(this.zzm);
                        zzxVar.zzQ(this.zzn);
                        zzxVar.zzad(f);
                        zzxVar.zzag(i10);
                        zzxVar.zzae(this.zzw);
                        zzxVar.zzak(this.zzx);
                        zzxVar.zzF(zzkVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zzxVar.zzD(this.zzP);
                    zzxVar.zzai(this.zzR);
                    zzxVar.zzab(iZzn);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    zzxVar.zzU(this.zzb);
                }
                zzxVar.zzR(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzG(str4);
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i115);
                zzxVar.zzT(list3);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzzVarZzan15 = zzxVar.zzan();
                zzafb zzafbVarZzw15 = zzadyVar.zzw(this.zzd, i5);
                this.zzX = zzafbVarZzw15;
                zzafbVarZzw15.zzm(zzzVarZzan15);
                return;
            case 17:
                str6 = "audio/eac3";
                listZzo = null;
                str2 = null;
                i2 = -1;
                list2 = listZzo;
                iZzn = -1;
                list3 = list2;
                if (this.zzO != null) {
                    str2 = zzezVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z16 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i116 = (z16 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                    if (zzay.zzj(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            iIntValue = -1;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        } else {
                            iIntValue = -1;
                        }
                        i6 = this.zzp;
                        if (i6 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder16 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder16.put((byte) 0);
                                byteBufferOrder16.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder16.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder16.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder16.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder16.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder16.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder16.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder16.putShort((short) ((this.zzL * 50000.0f) + 0.5f));
                                byteBufferOrder16.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder16.putShort((short) (this.zzN + 0.5f));
                                byteBufferOrder16.putShort((short) this.zzC);
                                byteBufferOrder16.putShort((short) this.zzD);
                            }
                            zzi zziVar16 = new zzi();
                            zziVar16.zzc(this.zzz);
                            zziVar16.zzb(this.zzB);
                            zziVar16.zzd(this.zzA);
                            zziVar16.zze(bArr);
                            zziVar16.zzf(this.zzo);
                            zziVar16.zza(this.zzo);
                            zzkVarZzg = zziVar16.zzg();
                        }
                        if (this.zzb != null) {
                            iIntValue = ((Integer) zzahy.zzf.get(this.zzb)).intValue();
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzxVar.zzam(this.zzm);
                        zzxVar.zzQ(this.zzn);
                        zzxVar.zzad(f);
                        zzxVar.zzag(i10);
                        zzxVar.zzae(this.zzw);
                        zzxVar.zzak(this.zzx);
                        zzxVar.zzF(zzkVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zzxVar.zzD(this.zzP);
                    zzxVar.zzai(this.zzR);
                    zzxVar.zzab(iZzn);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    zzxVar.zzU(this.zzb);
                }
                zzxVar.zzR(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzG(str4);
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i116);
                zzxVar.zzT(list3);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzzVarZzan16 = zzxVar.zzan();
                zzafb zzafbVarZzw16 = zzadyVar.zzw(this.zzd, i5);
                this.zzX = zzafbVarZzw16;
                zzafbVarZzw16.zzm(zzzVarZzan16);
                return;
            case 18:
                this.zzU = new zzafc();
                str6 = "audio/true-hd";
                listZzo = null;
                str2 = null;
                i2 = -1;
                list2 = listZzo;
                iZzn = -1;
                list3 = list2;
                if (this.zzO != null) {
                    str2 = zzezVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z17 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i117 = (z17 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                    if (zzay.zzj(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            iIntValue = -1;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        } else {
                            iIntValue = -1;
                        }
                        i6 = this.zzp;
                        if (i6 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder17 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder17.put((byte) 0);
                                byteBufferOrder17.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder17.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder17.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder17.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder17.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder17.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder17.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder17.putShort((short) ((this.zzL * 50000.0f) + 0.5f));
                                byteBufferOrder17.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder17.putShort((short) (this.zzN + 0.5f));
                                byteBufferOrder17.putShort((short) this.zzC);
                                byteBufferOrder17.putShort((short) this.zzD);
                            }
                            zzi zziVar17 = new zzi();
                            zziVar17.zzc(this.zzz);
                            zziVar17.zzb(this.zzB);
                            zziVar17.zzd(this.zzA);
                            zziVar17.zze(bArr);
                            zziVar17.zzf(this.zzo);
                            zziVar17.zza(this.zzo);
                            zzkVarZzg = zziVar17.zzg();
                        }
                        if (this.zzb != null) {
                            iIntValue = ((Integer) zzahy.zzf.get(this.zzb)).intValue();
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzxVar.zzam(this.zzm);
                        zzxVar.zzQ(this.zzn);
                        zzxVar.zzad(f);
                        zzxVar.zzag(i10);
                        zzxVar.zzae(this.zzw);
                        zzxVar.zzak(this.zzx);
                        zzxVar.zzF(zzkVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zzxVar.zzD(this.zzP);
                    zzxVar.zzai(this.zzR);
                    zzxVar.zzab(iZzn);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    zzxVar.zzU(this.zzb);
                }
                zzxVar.zzR(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzG(str4);
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i117);
                zzxVar.zzT(list3);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzzVarZzan17 = zzxVar.zzan();
                zzafb zzafbVarZzw17 = zzadyVar.zzw(this.zzd, i5);
                this.zzX = zzafbVarZzw17;
                zzafbVarZzw17.zzm(zzzVarZzan17);
                return;
            case 19:
            case 20:
                str6 = "audio/vnd.dts";
                listZzo = null;
                str2 = null;
                i2 = -1;
                list2 = listZzo;
                iZzn = -1;
                list3 = list2;
                if (this.zzO != null) {
                    str2 = zzezVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z18 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i118 = (z18 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                    if (zzay.zzj(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            iIntValue = -1;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        } else {
                            iIntValue = -1;
                        }
                        i6 = this.zzp;
                        if (i6 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder18 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder18.put((byte) 0);
                                byteBufferOrder18.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder18.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder18.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder18.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder18.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder18.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder18.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder18.putShort((short) ((this.zzL * 50000.0f) + 0.5f));
                                byteBufferOrder18.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder18.putShort((short) (this.zzN + 0.5f));
                                byteBufferOrder18.putShort((short) this.zzC);
                                byteBufferOrder18.putShort((short) this.zzD);
                            }
                            zzi zziVar18 = new zzi();
                            zziVar18.zzc(this.zzz);
                            zziVar18.zzb(this.zzB);
                            zziVar18.zzd(this.zzA);
                            zziVar18.zze(bArr);
                            zziVar18.zzf(this.zzo);
                            zziVar18.zza(this.zzo);
                            zzkVarZzg = zziVar18.zzg();
                        }
                        if (this.zzb != null) {
                            iIntValue = ((Integer) zzahy.zzf.get(this.zzb)).intValue();
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzxVar.zzam(this.zzm);
                        zzxVar.zzQ(this.zzn);
                        zzxVar.zzad(f);
                        zzxVar.zzag(i10);
                        zzxVar.zzae(this.zzw);
                        zzxVar.zzak(this.zzx);
                        zzxVar.zzF(zzkVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zzxVar.zzD(this.zzP);
                    zzxVar.zzai(this.zzR);
                    zzxVar.zzab(iZzn);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    zzxVar.zzU(this.zzb);
                }
                zzxVar.zzR(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzG(str4);
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i118);
                zzxVar.zzT(list3);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzzVarZzan18 = zzxVar.zzan();
                zzafb zzafbVarZzw18 = zzadyVar.zzw(this.zzd, i5);
                this.zzX = zzafbVarZzw18;
                zzafbVarZzw18.zzm(zzzVarZzan18);
                return;
            case 21:
                str6 = "audio/vnd.dts.hd";
                listZzo = null;
                str2 = null;
                i2 = -1;
                list2 = listZzo;
                iZzn = -1;
                list3 = list2;
                if (this.zzO != null) {
                    str2 = zzezVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z19 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i119 = (z19 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                    if (zzay.zzj(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            iIntValue = -1;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        } else {
                            iIntValue = -1;
                        }
                        i6 = this.zzp;
                        if (i6 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder19 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder19.put((byte) 0);
                                byteBufferOrder19.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder19.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder19.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder19.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder19.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder19.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder19.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder19.putShort((short) ((this.zzL * 50000.0f) + 0.5f));
                                byteBufferOrder19.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder19.putShort((short) (this.zzN + 0.5f));
                                byteBufferOrder19.putShort((short) this.zzC);
                                byteBufferOrder19.putShort((short) this.zzD);
                            }
                            zzi zziVar19 = new zzi();
                            zziVar19.zzc(this.zzz);
                            zziVar19.zzb(this.zzB);
                            zziVar19.zzd(this.zzA);
                            zziVar19.zze(bArr);
                            zziVar19.zzf(this.zzo);
                            zziVar19.zza(this.zzo);
                            zzkVarZzg = zziVar19.zzg();
                        }
                        if (this.zzb != null) {
                            iIntValue = ((Integer) zzahy.zzf.get(this.zzb)).intValue();
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzxVar.zzam(this.zzm);
                        zzxVar.zzQ(this.zzn);
                        zzxVar.zzad(f);
                        zzxVar.zzag(i10);
                        zzxVar.zzae(this.zzw);
                        zzxVar.zzak(this.zzx);
                        zzxVar.zzF(zzkVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zzxVar.zzD(this.zzP);
                    zzxVar.zzai(this.zzR);
                    zzxVar.zzab(iZzn);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    zzxVar.zzU(this.zzb);
                }
                zzxVar.zzR(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzG(str4);
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i119);
                zzxVar.zzT(list3);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzzVarZzan19 = zzxVar.zzan();
                zzafb zzafbVarZzw19 = zzadyVar.zzw(this.zzd, i5);
                this.zzX = zzafbVarZzw19;
                zzafbVarZzw19.zzm(zzzVarZzan19);
                return;
            case 22:
                str6 = "audio/flac";
                listZzo2 = Collections.singletonList(zzi(str5));
                str2 = null;
                listZzo = listZzo2;
                i2 = -1;
                list2 = listZzo;
                iZzn = -1;
                list3 = list2;
                if (this.zzO != null) {
                    str2 = zzezVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z110 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i1110 = (z110 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                    if (zzay.zzj(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            iIntValue = -1;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        } else {
                            iIntValue = -1;
                        }
                        i6 = this.zzp;
                        if (i6 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder110 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder110.put((byte) 0);
                                byteBufferOrder110.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder110.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder110.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder110.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder110.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder110.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder110.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder110.putShort((short) ((this.zzL * 50000.0f) + 0.5f));
                                byteBufferOrder110.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder110.putShort((short) (this.zzN + 0.5f));
                                byteBufferOrder110.putShort((short) this.zzC);
                                byteBufferOrder110.putShort((short) this.zzD);
                            }
                            zzi zziVar110 = new zzi();
                            zziVar110.zzc(this.zzz);
                            zziVar110.zzb(this.zzB);
                            zziVar110.zzd(this.zzA);
                            zziVar110.zze(bArr);
                            zziVar110.zzf(this.zzo);
                            zziVar110.zza(this.zzo);
                            zzkVarZzg = zziVar110.zzg();
                        }
                        if (this.zzb != null) {
                            iIntValue = ((Integer) zzahy.zzf.get(this.zzb)).intValue();
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzxVar.zzam(this.zzm);
                        zzxVar.zzQ(this.zzn);
                        zzxVar.zzad(f);
                        zzxVar.zzag(i10);
                        zzxVar.zzae(this.zzw);
                        zzxVar.zzak(this.zzx);
                        zzxVar.zzF(zzkVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zzxVar.zzD(this.zzP);
                    zzxVar.zzai(this.zzR);
                    zzxVar.zzab(iZzn);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    zzxVar.zzU(this.zzb);
                }
                zzxVar.zzR(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzG(str4);
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i1110);
                zzxVar.zzT(list3);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzzVarZzan110 = zzxVar.zzan();
                zzafb zzafbVarZzw110 = zzadyVar.zzw(this.zzd, i5);
                this.zzX = zzafbVarZzw110;
                zzafbVarZzw110.zzm(zzzVarZzan110);
                return;
            case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                if (zzh(new zzen(zzi(this.zzc)))) {
                    iZzn = zzex.zzn(this.zzQ, ByteOrder.LITTLE_ENDIAN);
                    if (iZzn == 0) {
                        zzea.zzf("MatroskaExtractor", "Unsupported PCM bit depth: " + this.zzQ + ". Setting mimeType to audio/x-unknown");
                    } else {
                        list3 = null;
                        str2 = null;
                        i2 = -1;
                    }
                    if (this.zzO != null) {
                        str2 = zzezVarZza.zza;
                        str6 = "video/dolby-vision";
                    }
                    str3 = str6;
                    boolean z111 = this.zzW;
                    if (true != this.zzV) {
                        i4 = 0;
                    } else {
                        i4 = 2;
                    }
                    int i1111 = (z111 ? 1 : 0) | i4;
                    zzxVar = new zzx();
                    if (!zzay.zzh(str3)) {
                        if (zzay.zzj(str3)) {
                            if (this.zzr == 0) {
                                i8 = this.zzp;
                                iIntValue = -1;
                                if (i8 == -1) {
                                    i8 = this.zzm;
                                }
                                this.zzp = i8;
                                i9 = this.zzq;
                                if (i9 == -1) {
                                    i9 = this.zzn;
                                }
                                this.zzq = i9;
                            } else {
                                iIntValue = -1;
                            }
                            i6 = this.zzp;
                            if (i6 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.zzy) {
                                if (this.zzE != -1.0f) {
                                    bArr = new byte[25];
                                    ByteBuffer byteBufferOrder111 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                    byteBufferOrder111.put((byte) 0);
                                    byteBufferOrder111.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                    byteBufferOrder111.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                    byteBufferOrder111.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                    byteBufferOrder111.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                    byteBufferOrder111.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                    byteBufferOrder111.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                    byteBufferOrder111.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                    byteBufferOrder111.putShort((short) ((this.zzL * 50000.0f) + 0.5f));
                                    byteBufferOrder111.putShort((short) (this.zzM + 0.5f));
                                    byteBufferOrder111.putShort((short) (this.zzN + 0.5f));
                                    byteBufferOrder111.putShort((short) this.zzC);
                                    byteBufferOrder111.putShort((short) this.zzD);
                                }
                                zzi zziVar111 = new zzi();
                                zziVar111.zzc(this.zzz);
                                zziVar111.zzb(this.zzB);
                                zziVar111.zzd(this.zzA);
                                zziVar111.zze(bArr);
                                zziVar111.zzf(this.zzo);
                                zziVar111.zza(this.zzo);
                                zzkVarZzg = zziVar111.zzg();
                            }
                            if (this.zzb != null) {
                                iIntValue = ((Integer) zzahy.zzf.get(this.zzb)).intValue();
                            }
                            if (this.zzs == 0) {
                                i10 = iIntValue;
                            } else {
                                i10 = iIntValue;
                            }
                            zzxVar.zzam(this.zzm);
                            zzxVar.zzQ(this.zzn);
                            zzxVar.zzad(f);
                            zzxVar.zzag(i10);
                            zzxVar.zzae(this.zzw);
                            zzxVar.zzak(this.zzx);
                            zzxVar.zzF(zzkVarZzg);
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str3)) {
                            }
                            i5 = 3;
                        }
                        break;
                    } else {
                        zzxVar.zzD(this.zzP);
                        zzxVar.zzai(this.zzR);
                        zzxVar.zzab(iZzn);
                        i5 = 1;
                    }
                    if (this.zzb != null) {
                        zzxVar.zzU(this.zzb);
                    }
                    zzxVar.zzR(i);
                    if (true != this.zza) {
                        str4 = "video/x-matroska";
                    } else {
                        str4 = "video/webm";
                    }
                    zzxVar.zzG(str4);
                    zzxVar.zzah(str3);
                    zzxVar.zzX(i2);
                    zzxVar.zzW(this.zzaa);
                    zzxVar.zzaj(i1111);
                    zzxVar.zzT(list3);
                    zzxVar.zzE(str2);
                    zzxVar.zzL(this.zzl);
                    zzz zzzVarZzan111 = zzxVar.zzan();
                    zzafb zzafbVarZzw111 = zzadyVar.zzw(this.zzd, i5);
                    this.zzX = zzafbVarZzw111;
                    zzafbVarZzw111.zzm(zzzVarZzan111);
                    return;
                }
                zzea.zzf("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown");
                listZzo = null;
                str2 = null;
                str6 = "audio/x-unknown";
                i2 = -1;
                list2 = listZzo;
                iZzn = -1;
                list3 = list2;
                if (this.zzO != null) {
                    str2 = zzezVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z112 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i1112 = (z112 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                    if (zzay.zzj(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            iIntValue = -1;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        } else {
                            iIntValue = -1;
                        }
                        i6 = this.zzp;
                        if (i6 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder112 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder112.put((byte) 0);
                                byteBufferOrder112.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder112.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder112.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder112.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder112.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder112.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder112.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder112.putShort((short) ((this.zzL * 50000.0f) + 0.5f));
                                byteBufferOrder112.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder112.putShort((short) (this.zzN + 0.5f));
                                byteBufferOrder112.putShort((short) this.zzC);
                                byteBufferOrder112.putShort((short) this.zzD);
                            }
                            zzi zziVar112 = new zzi();
                            zziVar112.zzc(this.zzz);
                            zziVar112.zzb(this.zzB);
                            zziVar112.zzd(this.zzA);
                            zziVar112.zze(bArr);
                            zziVar112.zzf(this.zzo);
                            zziVar112.zza(this.zzo);
                            zzkVarZzg = zziVar112.zzg();
                        }
                        if (this.zzb != null) {
                            iIntValue = ((Integer) zzahy.zzf.get(this.zzb)).intValue();
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzxVar.zzam(this.zzm);
                        zzxVar.zzQ(this.zzn);
                        zzxVar.zzad(f);
                        zzxVar.zzag(i10);
                        zzxVar.zzae(this.zzw);
                        zzxVar.zzak(this.zzx);
                        zzxVar.zzF(zzkVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zzxVar.zzD(this.zzP);
                    zzxVar.zzai(this.zzR);
                    zzxVar.zzab(iZzn);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    zzxVar.zzU(this.zzb);
                }
                zzxVar.zzR(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzG(str4);
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i1112);
                zzxVar.zzT(list3);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzzVarZzan112 = zzxVar.zzan();
                zzafb zzafbVarZzw112 = zzadyVar.zzw(this.zzd, i5);
                this.zzX = zzafbVarZzw112;
                zzafbVarZzw112.zzm(zzzVarZzan112);
                return;
            case 24:
                iZzn = zzex.zzn(this.zzQ, ByteOrder.LITTLE_ENDIAN);
                if (iZzn == 0) {
                    zzea.zzf("MatroskaExtractor", "Unsupported little endian PCM bit depth: " + this.zzQ + ". Setting mimeType to audio/x-unknown");
                    listZzo = null;
                    str2 = null;
                    str6 = "audio/x-unknown";
                    i2 = -1;
                    list2 = listZzo;
                    iZzn = -1;
                    list3 = list2;
                } else {
                    list3 = null;
                    str2 = null;
                    i2 = -1;
                }
                if (this.zzO != null) {
                    str2 = zzezVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z113 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i1113 = (z113 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                    if (zzay.zzj(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            iIntValue = -1;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        } else {
                            iIntValue = -1;
                        }
                        i6 = this.zzp;
                        if (i6 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder113 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder113.put((byte) 0);
                                byteBufferOrder113.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder113.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder113.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder113.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder113.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder113.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder113.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder113.putShort((short) ((this.zzL * 50000.0f) + 0.5f));
                                byteBufferOrder113.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder113.putShort((short) (this.zzN + 0.5f));
                                byteBufferOrder113.putShort((short) this.zzC);
                                byteBufferOrder113.putShort((short) this.zzD);
                            }
                            zzi zziVar113 = new zzi();
                            zziVar113.zzc(this.zzz);
                            zziVar113.zzb(this.zzB);
                            zziVar113.zzd(this.zzA);
                            zziVar113.zze(bArr);
                            zziVar113.zzf(this.zzo);
                            zziVar113.zza(this.zzo);
                            zzkVarZzg = zziVar113.zzg();
                        }
                        if (this.zzb != null) {
                            iIntValue = ((Integer) zzahy.zzf.get(this.zzb)).intValue();
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzxVar.zzam(this.zzm);
                        zzxVar.zzQ(this.zzn);
                        zzxVar.zzad(f);
                        zzxVar.zzag(i10);
                        zzxVar.zzae(this.zzw);
                        zzxVar.zzak(this.zzx);
                        zzxVar.zzF(zzkVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zzxVar.zzD(this.zzP);
                    zzxVar.zzai(this.zzR);
                    zzxVar.zzab(iZzn);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    zzxVar.zzU(this.zzb);
                }
                zzxVar.zzR(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzG(str4);
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i1113);
                zzxVar.zzT(list3);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzzVarZzan113 = zzxVar.zzan();
                zzafb zzafbVarZzw113 = zzadyVar.zzw(this.zzd, i5);
                this.zzX = zzafbVarZzw113;
                zzafbVarZzw113.zzm(zzzVarZzan113);
                return;
            case 25:
                int i20 = this.zzQ;
                if (i20 == 8) {
                    iZzn = 3;
                } else if (i20 == 16) {
                    iZzn = 268435456;
                } else if (i20 == 24) {
                    iZzn = 1342177280;
                } else {
                    if (i20 != 32) {
                        zzea.zzf("MatroskaExtractor", "Unsupported big endian PCM bit depth: " + i20 + ". Setting mimeType to audio/x-unknown");
                        listZzo = null;
                        str2 = null;
                        str6 = "audio/x-unknown";
                        i2 = -1;
                        list2 = listZzo;
                        iZzn = -1;
                        list3 = list2;
                        if (this.zzO != null) {
                            str2 = zzezVarZza.zza;
                            str6 = "video/dolby-vision";
                        }
                        str3 = str6;
                        boolean z114 = this.zzW;
                        if (true != this.zzV) {
                            i4 = 0;
                        } else {
                            i4 = 2;
                        }
                        int i1114 = (z114 ? 1 : 0) | i4;
                        zzxVar = new zzx();
                        if (!zzay.zzh(str3)) {
                            if (zzay.zzj(str3)) {
                                if (this.zzr == 0) {
                                    i8 = this.zzp;
                                    iIntValue = -1;
                                    if (i8 == -1) {
                                        i8 = this.zzm;
                                    }
                                    this.zzp = i8;
                                    i9 = this.zzq;
                                    if (i9 == -1) {
                                        i9 = this.zzn;
                                    }
                                    this.zzq = i9;
                                } else {
                                    iIntValue = -1;
                                }
                                i6 = this.zzp;
                                if (i6 != iIntValue) {
                                    f = -1.0f;
                                } else {
                                    f = -1.0f;
                                }
                                if (this.zzy) {
                                    if (this.zzE != -1.0f) {
                                        bArr = new byte[25];
                                        ByteBuffer byteBufferOrder114 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                        byteBufferOrder114.put((byte) 0);
                                        byteBufferOrder114.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                        byteBufferOrder114.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                        byteBufferOrder114.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                        byteBufferOrder114.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                        byteBufferOrder114.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                        byteBufferOrder114.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                        byteBufferOrder114.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                        byteBufferOrder114.putShort((short) ((this.zzL * 50000.0f) + 0.5f));
                                        byteBufferOrder114.putShort((short) (this.zzM + 0.5f));
                                        byteBufferOrder114.putShort((short) (this.zzN + 0.5f));
                                        byteBufferOrder114.putShort((short) this.zzC);
                                        byteBufferOrder114.putShort((short) this.zzD);
                                    }
                                    zzi zziVar114 = new zzi();
                                    zziVar114.zzc(this.zzz);
                                    zziVar114.zzb(this.zzB);
                                    zziVar114.zzd(this.zzA);
                                    zziVar114.zze(bArr);
                                    zziVar114.zzf(this.zzo);
                                    zziVar114.zza(this.zzo);
                                    zzkVarZzg = zziVar114.zzg();
                                }
                                if (this.zzb != null) {
                                    iIntValue = ((Integer) zzahy.zzf.get(this.zzb)).intValue();
                                }
                                if (this.zzs == 0) {
                                    i10 = iIntValue;
                                } else {
                                    i10 = iIntValue;
                                }
                                zzxVar.zzam(this.zzm);
                                zzxVar.zzQ(this.zzn);
                                zzxVar.zzad(f);
                                zzxVar.zzag(i10);
                                zzxVar.zzae(this.zzw);
                                zzxVar.zzak(this.zzx);
                                zzxVar.zzF(zzkVarZzg);
                                i5 = 2;
                            } else {
                                if ("application/x-subrip".equals(str3)) {
                                }
                                i5 = 3;
                            }
                            break;
                        } else {
                            zzxVar.zzD(this.zzP);
                            zzxVar.zzai(this.zzR);
                            zzxVar.zzab(iZzn);
                            i5 = 1;
                        }
                        if (this.zzb != null) {
                            zzxVar.zzU(this.zzb);
                        }
                        zzxVar.zzR(i);
                        if (true != this.zza) {
                            str4 = "video/x-matroska";
                        } else {
                            str4 = "video/webm";
                        }
                        zzxVar.zzG(str4);
                        zzxVar.zzah(str3);
                        zzxVar.zzX(i2);
                        zzxVar.zzW(this.zzaa);
                        zzxVar.zzaj(i1114);
                        zzxVar.zzT(list3);
                        zzxVar.zzE(str2);
                        zzxVar.zzL(this.zzl);
                        zzz zzzVarZzan114 = zzxVar.zzan();
                        zzafb zzafbVarZzw114 = zzadyVar.zzw(this.zzd, i5);
                        this.zzX = zzafbVarZzw114;
                        zzafbVarZzw114.zzm(zzzVarZzan114);
                        return;
                    }
                    iZzn = 1610612736;
                }
                list3 = null;
                str2 = null;
                i2 = -1;
                if (this.zzO != null) {
                    str2 = zzezVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z115 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i1115 = (z115 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                    if (zzay.zzj(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            iIntValue = -1;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        } else {
                            iIntValue = -1;
                        }
                        i6 = this.zzp;
                        if (i6 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder115 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder115.put((byte) 0);
                                byteBufferOrder115.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder115.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder115.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder115.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder115.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder115.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder115.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder115.putShort((short) ((this.zzL * 50000.0f) + 0.5f));
                                byteBufferOrder115.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder115.putShort((short) (this.zzN + 0.5f));
                                byteBufferOrder115.putShort((short) this.zzC);
                                byteBufferOrder115.putShort((short) this.zzD);
                            }
                            zzi zziVar115 = new zzi();
                            zziVar115.zzc(this.zzz);
                            zziVar115.zzb(this.zzB);
                            zziVar115.zzd(this.zzA);
                            zziVar115.zze(bArr);
                            zziVar115.zzf(this.zzo);
                            zziVar115.zza(this.zzo);
                            zzkVarZzg = zziVar115.zzg();
                        }
                        if (this.zzb != null) {
                            iIntValue = ((Integer) zzahy.zzf.get(this.zzb)).intValue();
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzxVar.zzam(this.zzm);
                        zzxVar.zzQ(this.zzn);
                        zzxVar.zzad(f);
                        zzxVar.zzag(i10);
                        zzxVar.zzae(this.zzw);
                        zzxVar.zzak(this.zzx);
                        zzxVar.zzF(zzkVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zzxVar.zzD(this.zzP);
                    zzxVar.zzai(this.zzR);
                    zzxVar.zzab(iZzn);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    zzxVar.zzU(this.zzb);
                }
                zzxVar.zzR(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzG(str4);
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i1115);
                zzxVar.zzT(list3);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzzVarZzan115 = zzxVar.zzan();
                zzafb zzafbVarZzw115 = zzadyVar.zzw(this.zzd, i5);
                this.zzX = zzafbVarZzw115;
                zzafbVarZzw115.zzm(zzzVarZzan115);
                return;
            case 26:
                int i21 = this.zzQ;
                if (i21 == 32) {
                    list3 = null;
                    str2 = null;
                    i2 = -1;
                } else {
                    zzea.zzf("MatroskaExtractor", "Unsupported floating point PCM bit depth: " + i21 + ". Setting mimeType to audio/x-unknown");
                    listZzo = null;
                    str2 = null;
                    str6 = "audio/x-unknown";
                    i2 = -1;
                    list2 = listZzo;
                    iZzn = -1;
                    list3 = list2;
                }
                if (this.zzO != null) {
                    str2 = zzezVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z116 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i1116 = (z116 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                    if (zzay.zzj(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            iIntValue = -1;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        } else {
                            iIntValue = -1;
                        }
                        i6 = this.zzp;
                        if (i6 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder116 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder116.put((byte) 0);
                                byteBufferOrder116.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder116.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder116.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder116.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder116.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder116.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder116.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder116.putShort((short) ((this.zzL * 50000.0f) + 0.5f));
                                byteBufferOrder116.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder116.putShort((short) (this.zzN + 0.5f));
                                byteBufferOrder116.putShort((short) this.zzC);
                                byteBufferOrder116.putShort((short) this.zzD);
                            }
                            zzi zziVar116 = new zzi();
                            zziVar116.zzc(this.zzz);
                            zziVar116.zzb(this.zzB);
                            zziVar116.zzd(this.zzA);
                            zziVar116.zze(bArr);
                            zziVar116.zzf(this.zzo);
                            zziVar116.zza(this.zzo);
                            zzkVarZzg = zziVar116.zzg();
                        }
                        if (this.zzb != null) {
                            iIntValue = ((Integer) zzahy.zzf.get(this.zzb)).intValue();
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzxVar.zzam(this.zzm);
                        zzxVar.zzQ(this.zzn);
                        zzxVar.zzad(f);
                        zzxVar.zzag(i10);
                        zzxVar.zzae(this.zzw);
                        zzxVar.zzak(this.zzx);
                        zzxVar.zzF(zzkVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zzxVar.zzD(this.zzP);
                    zzxVar.zzai(this.zzR);
                    zzxVar.zzab(iZzn);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    zzxVar.zzU(this.zzb);
                }
                zzxVar.zzR(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzG(str4);
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i1116);
                zzxVar.zzT(list3);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzzVarZzan116 = zzxVar.zzan();
                zzafb zzafbVarZzw116 = zzadyVar.zzw(this.zzd, i5);
                this.zzX = zzafbVarZzw116;
                zzafbVarZzw116.zzm(zzzVarZzan116);
                return;
            case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                str6 = "application/x-subrip";
                listZzo = null;
                str2 = null;
                i2 = -1;
                list2 = listZzo;
                iZzn = -1;
                list3 = list2;
                if (this.zzO != null) {
                    str2 = zzezVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z117 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i1117 = (z117 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                    if (zzay.zzj(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            iIntValue = -1;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        } else {
                            iIntValue = -1;
                        }
                        i6 = this.zzp;
                        if (i6 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder117 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder117.put((byte) 0);
                                byteBufferOrder117.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder117.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder117.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder117.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder117.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder117.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder117.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder117.putShort((short) ((this.zzL * 50000.0f) + 0.5f));
                                byteBufferOrder117.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder117.putShort((short) (this.zzN + 0.5f));
                                byteBufferOrder117.putShort((short) this.zzC);
                                byteBufferOrder117.putShort((short) this.zzD);
                            }
                            zzi zziVar117 = new zzi();
                            zziVar117.zzc(this.zzz);
                            zziVar117.zzb(this.zzB);
                            zziVar117.zzd(this.zzA);
                            zziVar117.zze(bArr);
                            zziVar117.zzf(this.zzo);
                            zziVar117.zza(this.zzo);
                            zzkVarZzg = zziVar117.zzg();
                        }
                        if (this.zzb != null) {
                            iIntValue = ((Integer) zzahy.zzf.get(this.zzb)).intValue();
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzxVar.zzam(this.zzm);
                        zzxVar.zzQ(this.zzn);
                        zzxVar.zzad(f);
                        zzxVar.zzag(i10);
                        zzxVar.zzae(this.zzw);
                        zzxVar.zzak(this.zzx);
                        zzxVar.zzF(zzkVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zzxVar.zzD(this.zzP);
                    zzxVar.zzai(this.zzR);
                    zzxVar.zzab(iZzn);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    zzxVar.zzU(this.zzb);
                }
                zzxVar.zzR(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzG(str4);
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i1117);
                zzxVar.zzT(list3);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzzVarZzan117 = zzxVar.zzan();
                zzafb zzafbVarZzw117 = zzadyVar.zzw(this.zzd, i5);
                this.zzX = zzafbVarZzw117;
                zzafbVarZzw117.zzm(zzzVarZzan117);
                return;
            case 28:
            case 29:
                str6 = "text/x-ssa";
                listZzo2 = zzfyq.zzp(zzahy.zzb, zzi(this.zzc));
                str2 = null;
                listZzo = listZzo2;
                i2 = -1;
                list2 = listZzo;
                iZzn = -1;
                list3 = list2;
                if (this.zzO != null) {
                    str2 = zzezVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z118 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i1118 = (z118 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                    if (zzay.zzj(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            iIntValue = -1;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        } else {
                            iIntValue = -1;
                        }
                        i6 = this.zzp;
                        if (i6 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder118 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder118.put((byte) 0);
                                byteBufferOrder118.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder118.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder118.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder118.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder118.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder118.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder118.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder118.putShort((short) ((this.zzL * 50000.0f) + 0.5f));
                                byteBufferOrder118.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder118.putShort((short) (this.zzN + 0.5f));
                                byteBufferOrder118.putShort((short) this.zzC);
                                byteBufferOrder118.putShort((short) this.zzD);
                            }
                            zzi zziVar118 = new zzi();
                            zziVar118.zzc(this.zzz);
                            zziVar118.zzb(this.zzB);
                            zziVar118.zzd(this.zzA);
                            zziVar118.zze(bArr);
                            zziVar118.zzf(this.zzo);
                            zziVar118.zza(this.zzo);
                            zzkVarZzg = zziVar118.zzg();
                        }
                        if (this.zzb != null) {
                            iIntValue = ((Integer) zzahy.zzf.get(this.zzb)).intValue();
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzxVar.zzam(this.zzm);
                        zzxVar.zzQ(this.zzn);
                        zzxVar.zzad(f);
                        zzxVar.zzag(i10);
                        zzxVar.zzae(this.zzw);
                        zzxVar.zzak(this.zzx);
                        zzxVar.zzF(zzkVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zzxVar.zzD(this.zzP);
                    zzxVar.zzai(this.zzR);
                    zzxVar.zzab(iZzn);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    zzxVar.zzU(this.zzb);
                }
                zzxVar.zzR(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzG(str4);
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i1118);
                zzxVar.zzT(list3);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzzVarZzan118 = zzxVar.zzan();
                zzafb zzafbVarZzw118 = zzadyVar.zzw(this.zzd, i5);
                this.zzX = zzafbVarZzw118;
                zzafbVarZzw118.zzm(zzzVarZzan118);
                return;
            case 30:
                str6 = "text/vtt";
                listZzo = null;
                str2 = null;
                i2 = -1;
                list2 = listZzo;
                iZzn = -1;
                list3 = list2;
                if (this.zzO != null) {
                    str2 = zzezVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z119 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i1119 = (z119 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                    if (zzay.zzj(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            iIntValue = -1;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        } else {
                            iIntValue = -1;
                        }
                        i6 = this.zzp;
                        if (i6 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder119 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder119.put((byte) 0);
                                byteBufferOrder119.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder119.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder119.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder119.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder119.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder119.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder119.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder119.putShort((short) ((this.zzL * 50000.0f) + 0.5f));
                                byteBufferOrder119.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder119.putShort((short) (this.zzN + 0.5f));
                                byteBufferOrder119.putShort((short) this.zzC);
                                byteBufferOrder119.putShort((short) this.zzD);
                            }
                            zzi zziVar119 = new zzi();
                            zziVar119.zzc(this.zzz);
                            zziVar119.zzb(this.zzB);
                            zziVar119.zzd(this.zzA);
                            zziVar119.zze(bArr);
                            zziVar119.zzf(this.zzo);
                            zziVar119.zza(this.zzo);
                            zzkVarZzg = zziVar119.zzg();
                        }
                        if (this.zzb != null) {
                            iIntValue = ((Integer) zzahy.zzf.get(this.zzb)).intValue();
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzxVar.zzam(this.zzm);
                        zzxVar.zzQ(this.zzn);
                        zzxVar.zzad(f);
                        zzxVar.zzag(i10);
                        zzxVar.zzae(this.zzw);
                        zzxVar.zzak(this.zzx);
                        zzxVar.zzF(zzkVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zzxVar.zzD(this.zzP);
                    zzxVar.zzai(this.zzR);
                    zzxVar.zzab(iZzn);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    zzxVar.zzU(this.zzb);
                }
                zzxVar.zzR(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzG(str4);
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i1119);
                zzxVar.zzT(list3);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzzVarZzan119 = zzxVar.zzan();
                zzafb zzafbVarZzw119 = zzadyVar.zzw(this.zzd, i5);
                this.zzX = zzafbVarZzw119;
                zzafbVarZzw119.zzm(zzzVarZzan119);
                return;
            case DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                str2 = null;
                str6 = "application/vobsub";
                listZzo = zzfyq.zzo(zzi(str5));
                i2 = -1;
                list2 = listZzo;
                iZzn = -1;
                list3 = list2;
                if (this.zzO != null) {
                    str2 = zzezVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z1110 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i11110 = (z1110 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                    if (zzay.zzj(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            iIntValue = -1;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        } else {
                            iIntValue = -1;
                        }
                        i6 = this.zzp;
                        if (i6 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder1110 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder1110.put((byte) 0);
                                byteBufferOrder1110.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder1110.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder1110.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder1110.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder1110.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder1110.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder1110.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder1110.putShort((short) ((this.zzL * 50000.0f) + 0.5f));
                                byteBufferOrder1110.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder1110.putShort((short) (this.zzN + 0.5f));
                                byteBufferOrder1110.putShort((short) this.zzC);
                                byteBufferOrder1110.putShort((short) this.zzD);
                            }
                            zzi zziVar1110 = new zzi();
                            zziVar1110.zzc(this.zzz);
                            zziVar1110.zzb(this.zzB);
                            zziVar1110.zzd(this.zzA);
                            zziVar1110.zze(bArr);
                            zziVar1110.zzf(this.zzo);
                            zziVar1110.zza(this.zzo);
                            zzkVarZzg = zziVar1110.zzg();
                        }
                        if (this.zzb != null) {
                            iIntValue = ((Integer) zzahy.zzf.get(this.zzb)).intValue();
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzxVar.zzam(this.zzm);
                        zzxVar.zzQ(this.zzn);
                        zzxVar.zzad(f);
                        zzxVar.zzag(i10);
                        zzxVar.zzae(this.zzw);
                        zzxVar.zzak(this.zzx);
                        zzxVar.zzF(zzkVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zzxVar.zzD(this.zzP);
                    zzxVar.zzai(this.zzR);
                    zzxVar.zzab(iZzn);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    zzxVar.zzU(this.zzb);
                }
                zzxVar.zzR(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzG(str4);
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i11110);
                zzxVar.zzT(list3);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzzVarZzan1110 = zzxVar.zzan();
                zzafb zzafbVarZzw1110 = zzadyVar.zzw(this.zzd, i5);
                this.zzX = zzafbVarZzw1110;
                zzafbVarZzw1110.zzm(zzzVarZzan1110);
                return;
            case 32:
                listZzo = null;
                str2 = null;
                str6 = "application/pgs";
                i2 = -1;
                list2 = listZzo;
                iZzn = -1;
                list3 = list2;
                if (this.zzO != null) {
                    str2 = zzezVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z1111 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i11111 = (z1111 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                    if (zzay.zzj(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            iIntValue = -1;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        } else {
                            iIntValue = -1;
                        }
                        i6 = this.zzp;
                        if (i6 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder1111 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder1111.put((byte) 0);
                                byteBufferOrder1111.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder1111.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder1111.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder1111.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder1111.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder1111.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder1111.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder1111.putShort((short) ((this.zzL * 50000.0f) + 0.5f));
                                byteBufferOrder1111.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder1111.putShort((short) (this.zzN + 0.5f));
                                byteBufferOrder1111.putShort((short) this.zzC);
                                byteBufferOrder1111.putShort((short) this.zzD);
                            }
                            zzi zziVar1111 = new zzi();
                            zziVar1111.zzc(this.zzz);
                            zziVar1111.zzb(this.zzB);
                            zziVar1111.zzd(this.zzA);
                            zziVar1111.zze(bArr);
                            zziVar1111.zzf(this.zzo);
                            zziVar1111.zza(this.zzo);
                            zzkVarZzg = zziVar1111.zzg();
                        }
                        if (this.zzb != null) {
                            iIntValue = ((Integer) zzahy.zzf.get(this.zzb)).intValue();
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzxVar.zzam(this.zzm);
                        zzxVar.zzQ(this.zzn);
                        zzxVar.zzad(f);
                        zzxVar.zzag(i10);
                        zzxVar.zzae(this.zzw);
                        zzxVar.zzak(this.zzx);
                        zzxVar.zzF(zzkVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zzxVar.zzD(this.zzP);
                    zzxVar.zzai(this.zzR);
                    zzxVar.zzab(iZzn);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    zzxVar.zzU(this.zzb);
                }
                zzxVar.zzR(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzG(str4);
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i11111);
                zzxVar.zzT(list3);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzzVarZzan1111 = zzxVar.zzan();
                zzafb zzafbVarZzw1111 = zzadyVar.zzw(this.zzd, i5);
                this.zzX = zzafbVarZzw1111;
                zzafbVarZzw1111.zzm(zzzVarZzan1111);
                return;
            case 33:
                byte[] bArr5 = new byte[4];
                System.arraycopy(zzi(str5), 0, bArr5, 0, 4);
                str6 = "application/dvbsubs";
                listZzo2 = zzfyq.zzo(bArr5);
                str2 = null;
                listZzo = listZzo2;
                i2 = -1;
                list2 = listZzo;
                iZzn = -1;
                list3 = list2;
                if (this.zzO != null) {
                    str2 = zzezVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z1112 = this.zzW;
                if (true != this.zzV) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i11112 = (z1112 ? 1 : 0) | i4;
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                    if (zzay.zzj(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            iIntValue = -1;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        } else {
                            iIntValue = -1;
                        }
                        i6 = this.zzp;
                        if (i6 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder1112 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder1112.put((byte) 0);
                                byteBufferOrder1112.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder1112.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder1112.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder1112.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder1112.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder1112.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder1112.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder1112.putShort((short) ((this.zzL * 50000.0f) + 0.5f));
                                byteBufferOrder1112.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder1112.putShort((short) (this.zzN + 0.5f));
                                byteBufferOrder1112.putShort((short) this.zzC);
                                byteBufferOrder1112.putShort((short) this.zzD);
                            }
                            zzi zziVar1112 = new zzi();
                            zziVar1112.zzc(this.zzz);
                            zziVar1112.zzb(this.zzB);
                            zziVar1112.zzd(this.zzA);
                            zziVar1112.zze(bArr);
                            zziVar1112.zzf(this.zzo);
                            zziVar1112.zza(this.zzo);
                            zzkVarZzg = zziVar1112.zzg();
                        }
                        if (this.zzb != null) {
                            iIntValue = ((Integer) zzahy.zzf.get(this.zzb)).intValue();
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzxVar.zzam(this.zzm);
                        zzxVar.zzQ(this.zzn);
                        zzxVar.zzad(f);
                        zzxVar.zzag(i10);
                        zzxVar.zzae(this.zzw);
                        zzxVar.zzak(this.zzx);
                        zzxVar.zzF(zzkVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zzxVar.zzD(this.zzP);
                    zzxVar.zzai(this.zzR);
                    zzxVar.zzab(iZzn);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    zzxVar.zzU(this.zzb);
                }
                zzxVar.zzR(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zzxVar.zzG(str4);
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i11112);
                zzxVar.zzT(list3);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzzVarZzan1112 = zzxVar.zzan();
                zzafb zzafbVarZzw1112 = zzadyVar.zzw(this.zzd, i5);
                this.zzX = zzafbVarZzw1112;
                zzafbVarZzw1112.zzm(zzzVarZzan1112);
                return;
            default:
                throw zzaz.zza("Unrecognized codec identifier.", null);
        }
    }
}
