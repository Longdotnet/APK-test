package com.google.android.gms.internal.ads;

import androidx.core.internal.view.Oteb.nYVxXTZQ;
import com.google.android.gms.ads.rewarded.zQ.yzwzcWHcnH;

/* JADX INFO: loaded from: classes2.dex */
final class zzajf {
    private static int zzb(zzen zzenVar) {
        int iZzg = zzenVar.zzg();
        if (zzenVar.zzg() == 1684108385) {
            zzenVar.zzM(8);
            int i = iZzg - 16;
            if (i == 1) {
                return zzenVar.zzm();
            }
            if (i == 2) {
                return zzenVar.zzq();
            }
            if (i == 3) {
                return zzenVar.zzo();
            }
            if (i == 4 && (zzenVar.zzf() & 128) == 0) {
                return zzenVar.zzp();
            }
        }
        zzea.zzf("MetadataUtil", "Failed to parse data atom to int");
        return -1;
    }

    private static zzahf zzc(int i, String str, zzen zzenVar, boolean z, boolean z2) {
        int iZzb = zzb(zzenVar);
        if (z2) {
            iZzb = Math.min(1, iZzb);
        }
        if (iZzb >= 0) {
            return z ? new zzahk(str, null, zzfyq.zzo(Integer.toString(iZzb))) : new zzaha("und", str, Integer.toString(iZzb));
        }
        zzea.zzf("MetadataUtil", "Failed to parse uint8 attribute: ".concat(zzff.zze(i)));
        return null;
    }

    private static zzahk zzd(int i, String str, zzen zzenVar) {
        int iZzg = zzenVar.zzg();
        if (zzenVar.zzg() == 1684108385 && iZzg >= 22) {
            zzenVar.zzM(10);
            int iZzq = zzenVar.zzq();
            if (iZzq > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(iZzq);
                String string = sb.toString();
                int iZzq2 = zzenVar.zzq();
                if (iZzq2 > 0) {
                    string = string + "/" + iZzq2;
                }
                return new zzahk(str, null, zzfyq.zzo(string));
            }
        }
        zzea.zzf("MetadataUtil", "Failed to parse index/count attribute: ".concat(zzff.zze(i)));
        return null;
    }

    private static zzahk zze(int i, String str, zzen zzenVar) {
        int iZzg = zzenVar.zzg();
        if (zzenVar.zzg() == 1684108385) {
            zzenVar.zzM(8);
            return new zzahk(str, null, zzfyq.zzo(zzenVar.zzA(iZzg - 16)));
        }
        zzea.zzf("MetadataUtil", "Failed to parse text attribute: ".concat(zzff.zze(i)));
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:128:0x0262 A[Catch: all -> 0x0053, TryCatch #0 {all -> 0x0053, blocks: (B:9:0x003c, B:11:0x0047, B:14:0x0056, B:17:0x0062, B:20:0x006f, B:23:0x007e, B:26:0x008b, B:29:0x0099, B:31:0x00a3, B:39:0x00c0, B:40:0x00d1, B:41:0x00e4, B:44:0x00f0, B:47:0x00fd, B:50:0x010a, B:53:0x0117, B:56:0x0124, B:59:0x0131, B:62:0x013e, B:64:0x0148, B:66:0x0152, B:68:0x015c, B:72:0x016d, B:74:0x0173, B:76:0x0187, B:77:0x018e, B:79:0x0195, B:84:0x01a0, B:90:0x01ad, B:128:0x0262, B:91:0x01c2, B:93:0x01c9, B:95:0x01d3, B:96:0x01e7, B:109:0x0213, B:112:0x0220, B:115:0x022d, B:118:0x0239, B:121:0x0245, B:124:0x0251, B:127:0x025b, B:129:0x0276, B:130:0x027d), top: B:135:0x002e }] */
    /* JADX WARN: Instruction removed from duplicated block: B:128:0x0262, please report this as an issue */
    public static zzau zza(zzen zzenVar) {
        String str;
        String str2 = nYVxXTZQ.zMQnBWOILsoBg;
        int iZzg = zzenVar.zzg() + zzenVar.zzc();
        int iZzg2 = zzenVar.zzg();
        int i = (iZzg2 >> 24) & 255;
        zzau zzauVarZze = null;
        try {
            if (i == 169 || i == 253) {
                int i2 = iZzg2 & 16777215;
                if (i2 == 6516084) {
                    int iZzg3 = zzenVar.zzg();
                    if (zzenVar.zzg() == 1684108385) {
                        zzenVar.zzM(8);
                        String strZzA = zzenVar.zzA(iZzg3 - 16);
                        zzauVarZze = new zzaha("und", strZzA, strZzA);
                    } else {
                        zzea.zzf("MetadataUtil", "Failed to parse comment attribute: ".concat(zzff.zze(iZzg2)));
                    }
                } else if (i2 == 7233901 || i2 == 7631467) {
                    zzauVarZze = zze(iZzg2, "TIT2", zzenVar);
                } else if (i2 == 6516589 || i2 == 7828084) {
                    zzauVarZze = zze(iZzg2, "TCOM", zzenVar);
                } else if (i2 == 6578553) {
                    zzauVarZze = zze(iZzg2, "TDRC", zzenVar);
                } else if (i2 == 4280916) {
                    zzauVarZze = zze(iZzg2, yzwzcWHcnH.oCSrhaEXTeDfH, zzenVar);
                } else if (i2 == 7630703) {
                    zzauVarZze = zze(iZzg2, "TSSE", zzenVar);
                } else if (i2 == 6384738) {
                    zzauVarZze = zze(iZzg2, "TALB", zzenVar);
                } else if (i2 == 7108978) {
                    zzauVarZze = zze(iZzg2, "USLT", zzenVar);
                } else if (i2 == 6776174) {
                    zzauVarZze = zze(iZzg2, "TCON", zzenVar);
                } else if (i2 == 6779504) {
                    zzauVarZze = zze(iZzg2, "TIT1", zzenVar);
                } else {
                    zzea.zzb("MetadataUtil", "Skipped unknown metadata entry: " + zzff.zze(iZzg2));
                }
            } else if (iZzg2 == 1735291493) {
                String strZza = zzahg.zza(zzb(zzenVar) - 1);
                if (strZza != null) {
                    zzauVarZze = new zzahk("TCON", null, zzfyq.zzo(strZza));
                } else {
                    zzea.zzf("MetadataUtil", "Failed to parse standard genre code");
                }
            } else if (iZzg2 == 1684632427) {
                zzauVarZze = zzd(1684632427, "TPOS", zzenVar);
            } else if (iZzg2 == 1953655662) {
                zzauVarZze = zzd(1953655662, "TRCK", zzenVar);
            } else if (iZzg2 == 1953329263) {
                zzauVarZze = zzc(1953329263, "TBPM", zzenVar, true, false);
            } else if (iZzg2 == 1668311404) {
                zzauVarZze = zzc(1668311404, "TCMP", zzenVar, true, true);
            } else if (iZzg2 == 1668249202) {
                int iZzg4 = zzenVar.zzg();
                if (zzenVar.zzg() == 1684108385) {
                    int iZzg5 = zzenVar.zzg();
                    int i3 = zzaix.zza;
                    int i4 = iZzg5 & 16777215;
                    if (i4 == 13) {
                        str = "image/jpeg";
                    } else if (i4 == 14) {
                        str = "image/png";
                        i4 = 14;
                    } else {
                        str = null;
                    }
                    if (str == null) {
                        zzea.zzf("MetadataUtil", str2 + i4);
                    } else {
                        zzenVar.zzM(4);
                        int i5 = iZzg4 - 16;
                        byte[] bArr = new byte[i5];
                        zzenVar.zzH(bArr, 0, i5);
                        zzauVarZze = new zzagw(str, null, 3, bArr);
                    }
                } else {
                    zzea.zzf("MetadataUtil", "Failed to parse cover art attribute");
                }
            } else if (iZzg2 == 1631670868) {
                zzauVarZze = zze(1631670868, "TPE2", zzenVar);
            } else if (iZzg2 == 1936682605) {
                zzauVarZze = zze(1936682605, "TSOT", zzenVar);
            } else if (iZzg2 == 1936679276) {
                zzauVarZze = zze(1936679276, "TSOA", zzenVar);
            } else if (iZzg2 == 1936679282) {
                zzauVarZze = zze(1936679282, "TSOP", zzenVar);
            } else if (iZzg2 == 1936679265) {
                zzauVarZze = zze(1936679265, "TSO2", zzenVar);
            } else if (iZzg2 == 1936679791) {
                zzauVarZze = zze(1936679791, "TSOC", zzenVar);
            } else if (iZzg2 == 1920233063) {
                zzauVarZze = zzc(1920233063, "ITUNESADVISORY", zzenVar, false, false);
            } else if (iZzg2 == 1885823344) {
                zzauVarZze = zzc(1885823344, "ITUNESGAPLESS", zzenVar, false, true);
            } else if (iZzg2 == 1936683886) {
                zzauVarZze = zze(1936683886, "TVSHOWSORT", zzenVar);
            } else if (iZzg2 == 1953919848) {
                zzauVarZze = zze(1953919848, "TVSHOW", zzenVar);
            } else if (iZzg2 == 757935405) {
                String strZzA2 = null;
                String strZzA3 = null;
                int i6 = -1;
                int i7 = -1;
                while (zzenVar.zzc() < iZzg) {
                    int iZzc = zzenVar.zzc();
                    int iZzg6 = zzenVar.zzg();
                    int iZzg7 = zzenVar.zzg();
                    zzenVar.zzM(4);
                    if (iZzg7 == 1835360622) {
                        strZzA2 = zzenVar.zzA(iZzg6 - 12);
                    } else {
                        int i8 = iZzg6 - 12;
                        if (iZzg7 == 1851878757) {
                            strZzA3 = zzenVar.zzA(i8);
                        } else {
                            if (iZzg7 == 1684108385) {
                                i7 = iZzg6;
                            }
                            if (iZzg7 == 1684108385) {
                                i6 = iZzc;
                            }
                            zzenVar.zzM(i8);
                        }
                    }
                }
                if (strZzA2 != null && strZzA3 != null && i6 != -1) {
                    zzenVar.zzL(i6);
                    zzenVar.zzM(16);
                    zzauVarZze = new zzahh(strZzA2, strZzA3, zzenVar.zzA(i7 - 16));
                }
            } else {
                zzea.zzb("MetadataUtil", "Skipped unknown metadata entry: " + zzff.zze(iZzg2));
            }
            zzenVar.zzL(iZzg);
            return zzauVarZze;
        } catch (Throwable th) {
            zzenVar.zzL(iZzg);
            throw th;
        }
    }
}
