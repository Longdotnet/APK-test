package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzamw implements zzaom {
    private final List zza;

    public zzamw(int i, List list) {
        this.zza = list;
    }

    private final zzaod zzc(zzaol zzaolVar) {
        return new zzaod(zze(zzaolVar), "video/mp2t");
    }

    private final zzaor zzd(zzaol zzaolVar) {
        return new zzaor(zze(zzaolVar), "video/mp2t");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v4 */
    private final List zze(zzaol zzaolVar) {
        String str;
        int i;
        List listSingletonList;
        zzen zzenVar = new zzen(zzaolVar.zze);
        ArrayList arrayList = this.zza;
        while (zzenVar.zza() > 0) {
            int iZzm = zzenVar.zzm();
            int iZzc = zzenVar.zzc() + zzenVar.zzm();
            if (iZzm == 134) {
                arrayList = new ArrayList();
                int iZzm2 = zzenVar.zzm() & 31;
                for (int i2 = 0; i2 < iZzm2; i2++) {
                    String strZzB = zzenVar.zzB(3, StandardCharsets.UTF_8);
                    int iZzm3 = zzenVar.zzm();
                    boolean z = (iZzm3 & 128) != 0;
                    if (z) {
                        i = iZzm3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    byte bZzm = (byte) zzenVar.zzm();
                    zzenVar.zzM(1);
                    if (z) {
                        int i3 = bZzm & 64;
                        int i4 = zzdk.zza;
                        listSingletonList = Collections.singletonList(i3 != 0 ? new byte[]{1} : new byte[]{0});
                    } else {
                        listSingletonList = null;
                    }
                    zzx zzxVar = new zzx();
                    zzxVar.zzah(str);
                    zzxVar.zzW(strZzB);
                    zzxVar.zzB(i);
                    zzxVar.zzT(listSingletonList);
                    arrayList.add(zzxVar.zzan());
                }
            }
            zzenVar.zzL(iZzc);
            arrayList = arrayList;
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzaom
    public final SparseArray zza() {
        return new SparseArray();
    }

    @Override // com.google.android.gms.internal.ads.zzaom
    public final zzaoo zzb(int i, zzaol zzaolVar) {
        if (i != 2) {
            if (i == 3 || i == 4) {
                return new zzant(new zzanl(zzaolVar.zzb, zzaolVar.zza(), "video/mp2t"));
            }
            if (i == 21) {
                return new zzant(new zzanj("video/mp2t"));
            }
            if (i == 27) {
                return new zzant(new zzang(zzc(zzaolVar), false, false, "video/mp2t"));
            }
            if (i == 36) {
                return new zzant(new zzani(zzc(zzaolVar), "video/mp2t"));
            }
            if (i == 45) {
                return new zzant(new zzanm("video/mp2t"));
            }
            if (i == 89) {
                return new zzant(new zzamy(zzaolVar.zzd, "video/mp2t"));
            }
            if (i == 172) {
                return new zzant(new zzamt(zzaolVar.zzb, zzaolVar.zza(), "video/mp2t"));
            }
            if (i == 257) {
                return new zzaob(new zzans("application/vnd.dvb.ait", "video/mp2t"));
            }
            if (i != 128) {
                if (i != 129) {
                    if (i != 138) {
                        if (i == 139) {
                            return new zzant(new zzamx(zzaolVar.zzb, zzaolVar.zza(), 5408, "video/mp2t"));
                        }
                        switch (i) {
                            case 15:
                                return new zzant(new zzamv(false, zzaolVar.zzb, zzaolVar.zza(), "video/mp2t"));
                            case 16:
                                return new zzant(new zzane(zzd(zzaolVar), "video/mp2t"));
                            case 17:
                                return new zzant(new zzank(zzaolVar.zzb, zzaolVar.zza(), "video/mp2t"));
                            default:
                                switch (i) {
                                    case 134:
                                        return new zzaob(new zzans("application/x-scte35", "video/mp2t"));
                                    case 135:
                                        break;
                                    case 136:
                                        break;
                                    default:
                                        return null;
                                }
                                break;
                        }
                    }
                    return new zzant(new zzamx(zzaolVar.zzb, zzaolVar.zza(), 4096, "video/mp2t"));
                }
                return new zzant(new zzamr(zzaolVar.zzb, zzaolVar.zza(), "video/mp2t"));
            }
        }
        return new zzant(new zzanb(zzd(zzaolVar), "video/mp2t"));
    }

    public zzamw() {
        this(0);
    }

    public zzamw(int i) {
        this.zza = zzfyq.zzn();
    }
}
