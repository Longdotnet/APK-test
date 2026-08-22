package com.google.android.gms.internal.ads;

import androidx.emoji2.text.flatbuffer.bs.bUqMCsuPSX;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
final class zzafr implements zzafj {
    public final zzfyq zza;
    private final int zzb;

    private zzafr(int i, zzfyq zzfyqVar) {
        this.zzb = i;
        this.zza = zzfyqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafj
    public final int zza() {
        return this.zzb;
    }

    public final zzafj zzb(Class cls) {
        zzfyq zzfyqVar = this.zza;
        int size = zzfyqVar.size();
        int i = 0;
        while (i < size) {
            zzafj zzafjVar = (zzafj) zzfyqVar.get(i);
            i++;
            if (zzafjVar.getClass() == cls) {
                return zzafjVar;
            }
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static zzafr zzc(int i, zzen zzenVar) {
        String str;
        zzafj zzafsVar;
        String str2;
        zzfyn zzfynVar = new zzfyn();
        int iZzd = zzenVar.zzd();
        int iZzb = -2;
        while (zzenVar.zza() > 8) {
            int iZzi = zzenVar.zzi();
            int iZzc = zzenVar.zzc() + zzenVar.zzi();
            zzenVar.zzK(iZzc);
            if (iZzi != 1414744396) {
                zzafs zzafsVar2 = null;
                switch (iZzi) {
                    case 1718776947:
                        if (iZzb != 2) {
                            if (iZzb == 1) {
                                int iZzk = zzenVar.zzk();
                                if (iZzk == 1) {
                                    str = "audio/raw";
                                } else if (iZzk == 85) {
                                    str = "audio/mpeg";
                                } else if (iZzk == 255) {
                                    str = "audio/mp4a-latm";
                                } else if (iZzk != 8192) {
                                    str = iZzk != 8193 ? null : "audio/vnd.dts";
                                } else {
                                    str = "audio/ac3";
                                }
                                if (str != null) {
                                    int iZzk2 = zzenVar.zzk();
                                    int iZzi2 = zzenVar.zzi();
                                    zzenVar.zzM(6);
                                    int iZzn = zzex.zzn(zzenVar.zzk(), ByteOrder.LITTLE_ENDIAN);
                                    int iZzk3 = zzenVar.zza() > 0 ? zzenVar.zzk() : 0;
                                    zzx zzxVar = new zzx();
                                    zzxVar.zzah(str);
                                    zzxVar.zzD(iZzk2);
                                    zzxVar.zzai(iZzi2);
                                    if (str.equals("audio/raw") && iZzn != 0) {
                                        zzxVar.zzab(iZzn);
                                    }
                                    if (str.equals("audio/mp4a-latm") && iZzk3 > 0) {
                                        byte[] bArr = new byte[iZzk3];
                                        zzenVar.zzH(bArr, 0, iZzk3);
                                        zzxVar.zzT(zzfyq.zzo(bArr));
                                    }
                                    zzafsVar = new zzafs(zzxVar.zzan());
                                } else {
                                    CoroutineAdapterKt$$ExternalSyntheticLambda0.m23m(iZzk, "Ignoring track with unsupported format tag ", "StreamFormatChunk");
                                }
                            } else {
                                zzea.zzf("StreamFormatChunk", "Ignoring strf box for unsupported track type: ".concat(zzex.zzD(iZzb)));
                            }
                            break;
                        } else {
                            zzenVar.zzM(4);
                            int iZzi3 = zzenVar.zzi();
                            int iZzi4 = zzenVar.zzi();
                            zzenVar.zzM(4);
                            int iZzi5 = zzenVar.zzi();
                            switch (iZzi5) {
                                case 808802372:
                                case 877677894:
                                case 1145656883:
                                case 1145656920:
                                case 1482049860:
                                case 1684633208:
                                case 2021026148:
                                    str2 = "video/mp4v-es";
                                    break;
                                case 826496577:
                                case 828601953:
                                case 875967048:
                                    str2 = bUqMCsuPSX.SFcHOU;
                                    break;
                                case 842289229:
                                    str2 = "video/mp42";
                                    break;
                                case 859066445:
                                    str2 = "video/mp43";
                                    break;
                                case 1196444237:
                                case 1735420525:
                                    str2 = "video/mjpeg";
                                    break;
                                default:
                                    str2 = null;
                                    break;
                            }
                            if (str2 == null) {
                                CoroutineAdapterKt$$ExternalSyntheticLambda0.m23m(iZzi5, "Ignoring track with unsupported compression ", "StreamFormatChunk");
                            } else {
                                zzx zzxVar2 = new zzx();
                                zzxVar2.zzam(iZzi3);
                                zzxVar2.zzQ(iZzi4);
                                zzxVar2.zzah(str2);
                                zzafsVar2 = new zzafs(zzxVar2.zzan());
                            }
                        }
                        zzafsVar = zzafsVar2;
                        break;
                    case 1751742049:
                        zzafsVar = zzafo.zzb(zzenVar);
                        break;
                    case 1752331379:
                        zzafsVar = zzafp.zzd(zzenVar);
                        break;
                    case 1852994675:
                        zzafsVar = zzaft.zzb(zzenVar);
                        break;
                    default:
                        zzafsVar = zzafsVar2;
                        break;
                }
            } else {
                zzafsVar = zzc(zzenVar.zzi(), zzenVar);
            }
            if (zzafsVar != null) {
                if (zzafsVar.zza() == 1752331379) {
                    iZzb = ((zzafp) zzafsVar).zzb();
                }
                zzfynVar.zzf(zzafsVar);
            }
            zzenVar.zzL(iZzc);
            zzenVar.zzK(iZzd);
        }
        return new zzafr(i, zzfynVar.zzi());
    }
}
