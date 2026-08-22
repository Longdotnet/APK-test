package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzajn {
    private static final zzfwe zza = zzfwe.zzb(zzfva.zzc(':'));
    private static final zzfwe zzb = zzfwe.zzb(zzfva.zzc('*'));
    private final List zzc = new ArrayList();
    private int zzd = 0;
    private int zze;

    public final int zza(zzadw zzadwVar, zzaer zzaerVar, List list) throws zzaz {
        byte b;
        char c;
        int i = this.zzd;
        if (i == 0) {
            long jZzd = zzadwVar.zzd();
            zzaerVar.zza = (jZzd == -1 || jZzd < 8) ? 0L : jZzd - 8;
            this.zzd = 1;
            return 1;
        }
        int i2 = 2;
        if (i != 1) {
            short s = 2817;
            short s2 = 2816;
            short s3 = 2192;
            if (i != 2) {
                long jZzf = zzadwVar.zzf();
                int iZzd = (int) ((zzadwVar.zzd() - zzadwVar.zzf()) - ((long) this.zze));
                zzen zzenVar = new zzen(iZzd);
                zzadwVar.zzi(zzenVar.zzN(), 0, iZzd);
                int i3 = 0;
                while (true) {
                    List list2 = this.zzc;
                    if (i3 >= list2.size()) {
                        zzaerVar.zza = 0L;
                        return 1;
                    }
                    zzajm zzajmVar = (zzajm) list2.get(i3);
                    zzenVar.zzL((int) (zzajmVar.zza - jZzf));
                    zzenVar.zzM(4);
                    int iZzi = zzenVar.zzi();
                    Charset charset = StandardCharsets.UTF_8;
                    switch (zzenVar.zzB(iZzi, charset)) {
                        case "SlowMotion_Data":
                            b = 0;
                            break;
                        case "Super_SlowMotion_Edit_Data":
                            b = 3;
                            break;
                        case "Super_SlowMotion_Data":
                            b = 1;
                            break;
                        case "Super_SlowMotion_Deflickering_On":
                            b = 4;
                            break;
                        case "Super_SlowMotion_BGM":
                            b = 2;
                            break;
                        default:
                            b = -1;
                            break;
                    }
                    if (b == 0) {
                        c = 2192;
                    } else if (b == 1) {
                        c = 2816;
                    } else if (b == 2) {
                        c = 2817;
                    } else if (b == 3) {
                        c = 2819;
                    } else {
                        if (b != 4) {
                            throw zzaz.zza("Invalid SEF name", null);
                        }
                        c = 2820;
                    }
                    int i4 = zzajmVar.zzb - (iZzi + 8);
                    if (c == 2192) {
                        ArrayList arrayList = new ArrayList();
                        List listZzf = zzb.zzf(zzenVar.zzB(i4, charset));
                        for (int i5 = 0; i5 < listZzf.size(); i5++) {
                            List listZzf2 = zza.zzf((CharSequence) listZzf.get(i5));
                            if (listZzf2.size() != 3) {
                                throw zzaz.zza(null, null);
                            }
                            try {
                                arrayList.add(new zzahn(Long.parseLong((String) listZzf2.get(0)), Long.parseLong((String) listZzf2.get(1)), 1 << (Integer.parseInt((String) listZzf2.get(2)) - 1)));
                            } catch (NumberFormatException e) {
                                throw zzaz.zza(null, e);
                            }
                        }
                        list.add(new zzaho(arrayList));
                    } else if (c != 2816 && c != 2817 && c != 2819 && c != 2820) {
                        throw new IllegalStateException();
                    }
                    i3++;
                }
            } else {
                long jZzd2 = zzadwVar.zzd();
                int i6 = this.zze - 20;
                zzen zzenVar2 = new zzen(i6);
                zzadwVar.zzi(zzenVar2.zzN(), 0, i6);
                int i7 = 0;
                while (i7 < i6 / 12) {
                    zzenVar2.zzM(i2);
                    short sZzD = zzenVar2.zzD();
                    if (sZzD == s3 || sZzD == s2 || sZzD == s || sZzD == 2819 || sZzD == 2820) {
                        this.zzc.add(new zzajm(sZzD, (jZzd2 - ((long) this.zze)) - ((long) zzenVar2.zzi()), zzenVar2.zzi()));
                    } else {
                        zzenVar2.zzM(8);
                    }
                    i7++;
                    i6 = i6;
                    i2 = 2;
                    s = 2817;
                    s2 = 2816;
                    s3 = 2192;
                }
                List list3 = this.zzc;
                if (list3.isEmpty()) {
                    zzaerVar.zza = 0L;
                } else {
                    this.zzd = 3;
                    zzaerVar.zza = ((zzajm) list3.get(0)).zza;
                }
            }
        } else {
            zzen zzenVar3 = new zzen(8);
            zzadwVar.zzi(zzenVar3.zzN(), 0, 8);
            this.zze = zzenVar3.zzi() + 8;
            if (zzenVar3.zzg() != 1397048916) {
                zzaerVar.zza = 0L;
            } else {
                zzaerVar.zza = zzadwVar.zzf() - ((long) (this.zze - 12));
                this.zzd = 2;
            }
        }
        return 1;
    }

    public final void zzb() {
        this.zzc.clear();
        this.zzd = 0;
    }
}
