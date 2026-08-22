package com.google.android.gms.measurement.internal;

import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;
import com.google.android.gms.internal.measurement.zzek;
import com.google.android.gms.internal.measurement.zzer;
import com.google.android.gms.internal.measurement.zzet;
import com.google.android.gms.internal.measurement.zzey;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzfx;
import com.google.android.gms.internal.measurement.zznz;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzx {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ zzaa zza;
    public final String zzb;
    public final int zzc;
    public Boolean zzd;
    public Boolean zze;
    public Long zzf;
    public Long zzg;
    public final com.google.android.gms.internal.measurement.zzkf zzh;

    public zzx(zzaa zzaaVar, String str, int i, com.google.android.gms.internal.measurement.zzkf zzkfVar, int i2) {
        this.$r8$classId = i2;
        this.zza = zzaaVar;
        this.zzb = str;
        this.zzc = i;
        this.zzh = zzkfVar;
    }

    public static Boolean zze(BigDecimal bigDecimal, zzer zzerVar, double d) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        com.google.android.gms.common.internal.zzah.checkNotNull(zzerVar);
        if (zzerVar.zzg()) {
            if (zzerVar.zzm() != 1) {
                if (zzerVar.zzm() == 5) {
                    if (!zzerVar.zzk() || !zzerVar.zzj()) {
                        return null;
                    }
                } else if (!zzerVar.zzh()) {
                    return null;
                }
                int iZzm = zzerVar.zzm();
                if (zzerVar.zzm() == 5) {
                    if (zzen.zzx(zzerVar.zze()) && zzen.zzx(zzerVar.zzd())) {
                        try {
                            BigDecimal bigDecimal5 = new BigDecimal(zzerVar.zze());
                            bigDecimal4 = new BigDecimal(zzerVar.zzd());
                            bigDecimal3 = bigDecimal5;
                            bigDecimal2 = null;
                        } catch (NumberFormatException unused) {
                        }
                    }
                    return null;
                }
                if (!zzen.zzx(zzerVar.zzc())) {
                    return null;
                }
                try {
                    bigDecimal2 = new BigDecimal(zzerVar.zzc());
                    bigDecimal3 = null;
                    bigDecimal4 = null;
                } catch (NumberFormatException unused2) {
                }
                if (iZzm == 5) {
                    if (bigDecimal3 == null) {
                        return null;
                    }
                } else if (bigDecimal2 == null) {
                    return null;
                }
                int i = iZzm - 1;
                if (i == 1) {
                    if (bigDecimal2 == null) {
                        return null;
                    }
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) < 0);
                }
                if (i == 2) {
                    if (bigDecimal2 == null) {
                        return null;
                    }
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) > 0);
                }
                if (i != 3) {
                    if (i == 4 && bigDecimal3 != null) {
                        return Boolean.valueOf(bigDecimal.compareTo(bigDecimal3) >= 0 && bigDecimal.compareTo(bigDecimal4) <= 0);
                    }
                    return null;
                }
                if (bigDecimal2 == null) {
                    return null;
                }
                if (d != 0.0d) {
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2.subtract(new BigDecimal(d).multiply(new BigDecimal(2)))) > 0 && bigDecimal.compareTo(bigDecimal2.add(new BigDecimal(d).multiply(new BigDecimal(2)))) < 0);
                }
                return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == 0);
            }
        }
        return null;
    }

    public static Boolean zzf(String str, zzey zzeyVar, zzeh zzehVar) {
        List listZze;
        com.google.android.gms.common.internal.zzah.checkNotNull(zzeyVar);
        if (str == null || !zzeyVar.zzi() || zzeyVar.zzj() == 1) {
            return null;
        }
        if (zzeyVar.zzj() == 7) {
            if (zzeyVar.zza() == 0) {
                return null;
            }
        } else if (!zzeyVar.zzh()) {
            return null;
        }
        int iZzj = zzeyVar.zzj();
        boolean zZzf = zzeyVar.zzf();
        String strZzd = (zZzf || iZzj == 2 || iZzj == 7) ? zzeyVar.zzd() : zzeyVar.zzd().toUpperCase(Locale.ENGLISH);
        if (zzeyVar.zza() == 0) {
            listZze = null;
        } else {
            listZze = zzeyVar.zze();
            if (!zZzf) {
                ArrayList arrayList = new ArrayList(listZze.size());
                Iterator it = listZze.iterator();
                while (it.hasNext()) {
                    arrayList.add(((String) it.next()).toUpperCase(Locale.ENGLISH));
                }
                listZze = Collections.unmodifiableList(arrayList);
            }
        }
        String str2 = iZzj == 2 ? strZzd : null;
        if (iZzj == 7) {
            if (listZze == null || listZze.isEmpty()) {
                return null;
            }
        } else if (strZzd == null) {
            return null;
        }
        if (!zZzf && iZzj != 2) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (iZzj - 1) {
            case 1:
                if (str2 == null) {
                    return null;
                }
                try {
                    return Boolean.valueOf(Pattern.compile(str2, true != zZzf ? 66 : 0).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (zzehVar == null) {
                        return null;
                    }
                    zzehVar.zzg.zzb(str2, "Invalid regular expression in REGEXP audience filter. expression");
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(strZzd));
            case 3:
                return Boolean.valueOf(str.endsWith(strZzd));
            case 4:
                return Boolean.valueOf(str.contains(strZzd));
            case 5:
                return Boolean.valueOf(str.equals(strZzd));
            case 6:
                if (listZze == null) {
                    return null;
                }
                return Boolean.valueOf(listZze.contains(str));
            default:
                return null;
        }
    }

    public static Boolean zzh(long j, zzer zzerVar) {
        try {
            return zze(new BigDecimal(j), zzerVar, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Boolean zzj(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    /* JADX WARN: Code duplicated, block: B:103:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:106:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:114:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:120:0x0303  */
    /* JADX WARN: Code duplicated, block: B:125:0x0311  */
    /* JADX WARN: Code duplicated, block: B:127:0x0317  */
    /* JADX WARN: Code duplicated, block: B:128:0x0327  */
    /* JADX WARN: Code duplicated, block: B:130:0x032d  */
    /* JADX WARN: Code duplicated, block: B:132:0x0335  */
    /* JADX WARN: Code duplicated, block: B:134:0x033f  */
    /* JADX WARN: Code duplicated, block: B:138:0x0350  */
    /* JADX WARN: Code duplicated, block: B:144:0x038f A[EDGE_INSN: B:144:0x038f->B:147:0x03c6 BREAK  A[LOOP:1: B:56:0x017e->B:61:0x01a7]] */
    /* JADX WARN: Code duplicated, block: B:145:0x03aa  */
    /* JADX WARN: Code duplicated, block: B:182:0x0341 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:187:0x01af A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:188:0x0194 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:189:0x023e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:190:0x01d2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:191:0x01f0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:192:0x01d8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:193:0x020e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:194:0x01f6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:195:0x0220 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:197:0x01bc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:201:0x02c4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:202:0x028e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:203:0x02a6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:204:0x02c0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:205:0x03c4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:206:0x026b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:207:0x0288 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:208:0x030d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:209:0x02ce A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:210:0x02a6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:211:0x0309 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:212:0x0373 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:213:0x0359 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:214:0x02a6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:215:0x0356 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:216:0x02c8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:217:0x038d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:219:0x0246 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:220:0x0246 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:221:0x0246 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x0171  */
    /* JADX WARN: Code duplicated, block: B:58:0x0184  */
    /* JADX WARN: Code duplicated, block: B:61:0x01a7 A[LOOP:1: B:56:0x017e->B:61:0x01a7, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:65:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:71:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:72:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:78:0x0200  */
    /* JADX WARN: Code duplicated, block: B:79:0x0209  */
    /* JADX WARN: Code duplicated, block: B:83:0x0214  */
    /* JADX WARN: Code duplicated, block: B:88:0x024c  */
    /* JADX WARN: Code duplicated, block: B:93:0x0260  */
    /* JADX WARN: Code duplicated, block: B:97:0x027f  */
    public boolean zzd(Long l, Long l2, zzft zzftVar, long j, zzas zzasVar, boolean z) {
        HashSet hashSet;
        Iterator it;
        ArrayMap arrayMap;
        Iterator it2;
        Iterator it3;
        Boolean bool;
        com.google.android.gms.internal.measurement.zzem zzemVar;
        boolean z2;
        String strZze;
        Object orDefault;
        Boolean boolZzh;
        Boolean boolZze;
        String str;
        zzer zzerVarZzc;
        Boolean boolZze2;
        zzfx zzfxVar;
        Long lValueOf;
        Double dValueOf;
        com.google.android.gms.internal.measurement.zzem zzemVar2;
        zznz.zzc();
        zzaa zzaaVar = this.zza;
        zzag zzagVar = ((zzfr) zzaaVar.mBuilder).zzk;
        zzdt zzdtVar = zzdu.zzW;
        String str2 = this.zzb;
        boolean zZzs = zzagVar.zzs(str2, zzdtVar);
        zzek zzekVar = (zzek) this.zzh;
        long j2 = zzekVar.zzn() ? zzasVar.zze : j;
        zzfr zzfrVar = (zzfr) zzaaVar.mBuilder;
        zzeh zzehVar = zzfrVar.zzm;
        zzfr.zzR(zzehVar);
        boolean zIsLoggable = Log.isLoggable(zzehVar.zzq(), 2);
        int i = this.zzc;
        if (zIsLoggable) {
            zzeh zzehVar2 = zzfrVar.zzm;
            zzfr.zzR(zzehVar2);
            zzehVar2.zzl.zzd("Evaluating filter. audience, filter, event", Integer.valueOf(i), zzekVar.zzp() ? Integer.valueOf(zzekVar.zzb()) : null, zzfrVar.zzq.zzd(zzekVar.zzg()));
            zzeh zzehVar3 = zzfrVar.zzm;
            zzfr.zzR(zzehVar3);
            zzen zzenVar = zzaaVar.zzf.zzi;
            zzkt.zzal(zzenVar);
            StringBuilder sb = new StringBuilder();
            sb.append("\nevent_filter {\n");
            if (zzekVar.zzp()) {
                zzen.zzI(sb, 0, "filter_id", Integer.valueOf(zzekVar.zzb()));
            }
            zzen.zzI(sb, 0, "event_name", ((zzfr) zzenVar.mBuilder).zzq.zzd(zzekVar.zzg()));
            String strZzG = zzen.zzG(zzekVar.zzk(), zzekVar.zzm(), zzekVar.zzn());
            if (!strZzG.isEmpty()) {
                zzen.zzI(sb, 0, "filter_type", strZzG);
            }
            if (zzekVar.zzo()) {
                zzen.zzJ(sb, 1, "event_count_filter", zzekVar.zzf());
            }
            if (zzekVar.zza() > 0) {
                sb.append("  filters {\n");
                Iterator it4 = zzekVar.zzh().iterator();
                while (it4.hasNext()) {
                    zzenVar.zzE(sb, 2, (com.google.android.gms.internal.measurement.zzem) it4.next());
                }
            }
            zzen.zzF(sb, 1);
            sb.append("}\n}\n");
            zzehVar3.zzl.zzb(sb.toString(), "Filter definition");
        }
        if (!zzekVar.zzp() || zzekVar.zzb() > 256) {
            zzeh zzehVar4 = zzfrVar.zzm;
            zzfr.zzR(zzehVar4);
            zzehVar4.zzg.zzc(zzeh.zzn(str2), "Invalid event filter ID. appId, id", String.valueOf(zzekVar.zzp() ? Integer.valueOf(zzekVar.zzb()) : null));
            return false;
        }
        boolean z3 = zzekVar.zzk() || zzekVar.zzm() || zzekVar.zzn();
        if (z && !z3) {
            zzeh zzehVar5 = zzfrVar.zzm;
            zzfr.zzR(zzehVar5);
            zzehVar5.zzl.zzc(Integer.valueOf(i), "Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", zzekVar.zzp() ? Integer.valueOf(zzekVar.zzb()) : null);
            return true;
        }
        String strZzh = zzftVar.zzh();
        if (!zzekVar.zzo()) {
            hashSet = new HashSet();
            it = zzekVar.zzh().iterator();
            while (true) {
                if (it.hasNext()) {
                    arrayMap = new ArrayMap();
                    it2 = zzftVar.zzi().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            it3 = zzekVar.zzh().iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    bool = Boolean.TRUE;
                                    break;
                                }
                                zzemVar = (com.google.android.gms.internal.measurement.zzem) it3.next();
                                if (zzemVar.zzh() || !zzemVar.zzg()) {
                                    z2 = false;
                                } else {
                                    z2 = true;
                                }
                                strZze = zzemVar.zze();
                                if (strZze.isEmpty()) {
                                    orDefault = arrayMap.getOrDefault(strZze, null);
                                    if (orDefault instanceof Long) {
                                        if (orDefault instanceof Double) {
                                            if (orDefault instanceof String) {
                                                if (orDefault == null) {
                                                    zzeh zzehVar6 = zzfrVar.zzm;
                                                    zzfr.zzR(zzehVar6);
                                                    zzehVar6.zzg.zzc(zzfrVar.zzq.zzd(strZzh), "Unknown param type. event, param", zzfrVar.zzq.zze(strZze));
                                                    bool = null;
                                                    break;
                                                }
                                                zzeh zzehVar7 = zzfrVar.zzm;
                                                zzfr.zzR(zzehVar7);
                                                zzehVar7.zzl.zzc(zzfrVar.zzq.zzd(strZzh), "Missing param for filter. event, param", zzfrVar.zzq.zze(strZze));
                                                bool = Boolean.FALSE;
                                                break;
                                            }
                                            if (zzemVar.zzk()) {
                                                if (zzemVar.zzi()) {
                                                    str = (String) orDefault;
                                                    if (zzen.zzx(str)) {
                                                        zzerVarZzc = zzemVar.zzc();
                                                        if (zzen.zzx(str)) {
                                                            try {
                                                                boolZze2 = zze(new BigDecimal(str), zzerVarZzc, 0.0d);
                                                            } catch (NumberFormatException unused) {
                                                                boolZze2 = null;
                                                            }
                                                        } else {
                                                            boolZze2 = null;
                                                        }
                                                    } else {
                                                        zzeh zzehVar8 = zzfrVar.zzm;
                                                        zzfr.zzR(zzehVar8);
                                                        zzehVar8.zzg.zzc(zzfrVar.zzq.zzd(strZzh), "Invalid param value for number filter. event, param", zzfrVar.zzq.zze(strZze));
                                                    }
                                                } else {
                                                    zzeh zzehVar9 = zzfrVar.zzm;
                                                    zzfr.zzR(zzehVar9);
                                                    zzehVar9.zzg.zzc(zzfrVar.zzq.zzd(strZzh), "No filter for String param. event, param", zzfrVar.zzq.zze(strZze));
                                                }
                                                bool = null;
                                                break;
                                            }
                                            zzey zzeyVarZzd = zzemVar.zzd();
                                            zzeh zzehVar10 = zzfrVar.zzm;
                                            zzfr.zzR(zzehVar10);
                                            boolZze2 = zzf((String) orDefault, zzeyVarZzd, zzehVar10);
                                            if (boolZze2 == null) {
                                                bool = null;
                                                break;
                                            }
                                            if (boolZze2.booleanValue() == z2) {
                                                bool = Boolean.FALSE;
                                                break;
                                            }
                                        } else {
                                            if (zzemVar.zzi()) {
                                                double dDoubleValue = ((Double) orDefault).doubleValue();
                                                try {
                                                    boolZze = zze(new BigDecimal(dDoubleValue), zzemVar.zzc(), Math.ulp(dDoubleValue));
                                                } catch (NumberFormatException unused2) {
                                                    boolZze = null;
                                                }
                                                if (boolZze == null) {
                                                    if (boolZze.booleanValue() == z2) {
                                                        bool = Boolean.FALSE;
                                                        break;
                                                    }
                                                }
                                            } else {
                                                zzeh zzehVar11 = zzfrVar.zzm;
                                                zzfr.zzR(zzehVar11);
                                                zzehVar11.zzg.zzc(zzfrVar.zzq.zzd(strZzh), "No number filter for double param. event, param", zzfrVar.zzq.zze(strZze));
                                            }
                                            bool = null;
                                            break;
                                        }
                                    } else {
                                        if (zzemVar.zzi()) {
                                            boolZzh = zzh(((Long) orDefault).longValue(), zzemVar.zzc());
                                            if (boolZzh == null) {
                                                if (boolZzh.booleanValue() == z2) {
                                                    bool = Boolean.FALSE;
                                                    break;
                                                }
                                            }
                                        } else {
                                            zzeh zzehVar12 = zzfrVar.zzm;
                                            zzfr.zzR(zzehVar12);
                                            zzehVar12.zzg.zzc(zzfrVar.zzq.zzd(strZzh), "No number filter for long param. event, param", zzfrVar.zzq.zze(strZze));
                                        }
                                        bool = null;
                                        break;
                                    }
                                } else {
                                    zzeh zzehVar13 = zzfrVar.zzm;
                                    zzfr.zzR(zzehVar13);
                                    zzehVar13.zzg.zzb(zzfrVar.zzq.zzd(strZzh), "Event has empty param name. event");
                                }
                            }
                        } else {
                            zzfxVar = (zzfx) it2.next();
                            if (!hashSet.contains(zzfxVar.zzg())) {
                                if (zzfxVar.zzw()) {
                                    String strZzg = zzfxVar.zzg();
                                    if (zzfxVar.zzw()) {
                                        lValueOf = Long.valueOf(zzfxVar.zzd());
                                    } else {
                                        lValueOf = null;
                                    }
                                    arrayMap.put(strZzg, lValueOf);
                                } else if (zzfxVar.zzu()) {
                                    String strZzg2 = zzfxVar.zzg();
                                    if (zzfxVar.zzu()) {
                                        dValueOf = Double.valueOf(zzfxVar.zza());
                                    } else {
                                        dValueOf = null;
                                    }
                                    arrayMap.put(strZzg2, dValueOf);
                                } else if (zzfxVar.zzy()) {
                                    arrayMap.put(zzfxVar.zzg(), zzfxVar.zzh());
                                } else {
                                    zzeh zzehVar14 = zzfrVar.zzm;
                                    zzfr.zzR(zzehVar14);
                                    zzehVar14.zzg.zzc(zzfrVar.zzq.zzd(strZzh), "Unknown value for param. event, param", zzfrVar.zzq.zze(zzfxVar.zzg()));
                                }
                            }
                        }
                    }
                } else {
                    zzemVar2 = (com.google.android.gms.internal.measurement.zzem) it.next();
                    if (zzemVar2.zze().isEmpty()) {
                        zzeh zzehVar15 = zzfrVar.zzm;
                        zzfr.zzR(zzehVar15);
                        zzehVar15.zzg.zzb(zzfrVar.zzq.zzd(strZzh), "null or empty param name in filter. event");
                    } else {
                        hashSet.add(zzemVar2.zze());
                    }
                }
                bool = null;
                break;
            }
        }
        Boolean boolZzh2 = zzh(j2, zzekVar.zzf());
        if (boolZzh2 == null) {
            bool = null;
            break;
        }
        if (boolZzh2.booleanValue()) {
            hashSet = new HashSet();
            it = zzekVar.zzh().iterator();
            while (true) {
                if (it.hasNext()) {
                    arrayMap = new ArrayMap();
                    it2 = zzftVar.zzi().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            it3 = zzekVar.zzh().iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    bool = Boolean.TRUE;
                                    break;
                                }
                                zzemVar = (com.google.android.gms.internal.measurement.zzem) it3.next();
                                if (zzemVar.zzh()) {
                                    z2 = false;
                                } else {
                                    z2 = false;
                                }
                                strZze = zzemVar.zze();
                                if (strZze.isEmpty()) {
                                    orDefault = arrayMap.getOrDefault(strZze, null);
                                    if (orDefault instanceof Long) {
                                        if (orDefault instanceof Double) {
                                            if (orDefault instanceof String) {
                                                if (orDefault == null) {
                                                    zzeh zzehVar16 = zzfrVar.zzm;
                                                    zzfr.zzR(zzehVar16);
                                                    zzehVar16.zzg.zzc(zzfrVar.zzq.zzd(strZzh), "Unknown param type. event, param", zzfrVar.zzq.zze(strZze));
                                                    bool = null;
                                                    break;
                                                }
                                                zzeh zzehVar17 = zzfrVar.zzm;
                                                zzfr.zzR(zzehVar17);
                                                zzehVar17.zzl.zzc(zzfrVar.zzq.zzd(strZzh), "Missing param for filter. event, param", zzfrVar.zzq.zze(strZze));
                                                bool = Boolean.FALSE;
                                                break;
                                            }
                                            if (zzemVar.zzk()) {
                                                if (zzemVar.zzi()) {
                                                    str = (String) orDefault;
                                                    if (zzen.zzx(str)) {
                                                        zzerVarZzc = zzemVar.zzc();
                                                        if (zzen.zzx(str)) {
                                                            boolZze2 = null;
                                                        } else {
                                                            boolZze2 = zze(new BigDecimal(str), zzerVarZzc, 0.0d);
                                                        }
                                                    } else {
                                                        zzeh zzehVar18 = zzfrVar.zzm;
                                                        zzfr.zzR(zzehVar18);
                                                        zzehVar18.zzg.zzc(zzfrVar.zzq.zzd(strZzh), "Invalid param value for number filter. event, param", zzfrVar.zzq.zze(strZze));
                                                    }
                                                } else {
                                                    zzeh zzehVar19 = zzfrVar.zzm;
                                                    zzfr.zzR(zzehVar19);
                                                    zzehVar19.zzg.zzc(zzfrVar.zzq.zzd(strZzh), "No filter for String param. event, param", zzfrVar.zzq.zze(strZze));
                                                }
                                                bool = null;
                                                break;
                                            }
                                            zzey zzeyVarZzd2 = zzemVar.zzd();
                                            zzeh zzehVar110 = zzfrVar.zzm;
                                            zzfr.zzR(zzehVar110);
                                            boolZze2 = zzf((String) orDefault, zzeyVarZzd2, zzehVar110);
                                            if (boolZze2 == null) {
                                                bool = null;
                                                break;
                                            }
                                            if (boolZze2.booleanValue() == z2) {
                                                bool = Boolean.FALSE;
                                                break;
                                            }
                                        } else {
                                            if (zzemVar.zzi()) {
                                                zzeh zzehVar111 = zzfrVar.zzm;
                                                zzfr.zzR(zzehVar111);
                                                zzehVar111.zzg.zzc(zzfrVar.zzq.zzd(strZzh), "No number filter for double param. event, param", zzfrVar.zzq.zze(strZze));
                                            } else {
                                                double dDoubleValue2 = ((Double) orDefault).doubleValue();
                                                boolZze = zze(new BigDecimal(dDoubleValue2), zzemVar.zzc(), Math.ulp(dDoubleValue2));
                                                if (boolZze == null) {
                                                    if (boolZze.booleanValue() == z2) {
                                                        bool = Boolean.FALSE;
                                                        break;
                                                    }
                                                }
                                            }
                                            bool = null;
                                            break;
                                        }
                                    } else {
                                        if (zzemVar.zzi()) {
                                            zzeh zzehVar112 = zzfrVar.zzm;
                                            zzfr.zzR(zzehVar112);
                                            zzehVar112.zzg.zzc(zzfrVar.zzq.zzd(strZzh), "No number filter for long param. event, param", zzfrVar.zzq.zze(strZze));
                                        } else {
                                            boolZzh = zzh(((Long) orDefault).longValue(), zzemVar.zzc());
                                            if (boolZzh == null) {
                                                if (boolZzh.booleanValue() == z2) {
                                                    bool = Boolean.FALSE;
                                                    break;
                                                }
                                            }
                                        }
                                        bool = null;
                                        break;
                                    }
                                } else {
                                    zzeh zzehVar113 = zzfrVar.zzm;
                                    zzfr.zzR(zzehVar113);
                                    zzehVar113.zzg.zzb(zzfrVar.zzq.zzd(strZzh), "Event has empty param name. event");
                                }
                            }
                        } else {
                            zzfxVar = (zzfx) it2.next();
                            if (!hashSet.contains(zzfxVar.zzg())) {
                                if (zzfxVar.zzw()) {
                                    String strZzg3 = zzfxVar.zzg();
                                    if (zzfxVar.zzw()) {
                                        lValueOf = Long.valueOf(zzfxVar.zzd());
                                    } else {
                                        lValueOf = null;
                                    }
                                    arrayMap.put(strZzg3, lValueOf);
                                } else if (zzfxVar.zzu()) {
                                    String strZzg4 = zzfxVar.zzg();
                                    if (zzfxVar.zzu()) {
                                        dValueOf = Double.valueOf(zzfxVar.zza());
                                    } else {
                                        dValueOf = null;
                                    }
                                    arrayMap.put(strZzg4, dValueOf);
                                } else if (zzfxVar.zzy()) {
                                    arrayMap.put(zzfxVar.zzg(), zzfxVar.zzh());
                                } else {
                                    zzeh zzehVar114 = zzfrVar.zzm;
                                    zzfr.zzR(zzehVar114);
                                    zzehVar114.zzg.zzc(zzfrVar.zzq.zzd(strZzh), "Unknown value for param. event, param", zzfrVar.zzq.zze(zzfxVar.zzg()));
                                }
                            }
                        }
                    }
                } else {
                    zzemVar2 = (com.google.android.gms.internal.measurement.zzem) it.next();
                    if (zzemVar2.zze().isEmpty()) {
                        zzeh zzehVar115 = zzfrVar.zzm;
                        zzfr.zzR(zzehVar115);
                        zzehVar115.zzg.zzb(zzfrVar.zzq.zzd(strZzh), "null or empty param name in filter. event");
                    } else {
                        hashSet.add(zzemVar2.zze());
                    }
                }
                bool = null;
                break;
            }
        }
        bool = Boolean.FALSE;
        zzeh zzehVar20 = zzfrVar.zzm;
        zzfr.zzR(zzehVar20);
        zzehVar20.zzl.zzb(bool == null ? "null" : bool, "Event filter result");
        if (bool == null) {
            return false;
        }
        Boolean bool2 = Boolean.TRUE;
        this.zzd = bool2;
        if (!bool.booleanValue()) {
            return true;
        }
        this.zze = bool2;
        if (z3 && zzftVar.zzu()) {
            Long lValueOf2 = Long.valueOf(zzftVar.zzd());
            if (zzekVar.zzm()) {
                if (zZzs && zzekVar.zzo()) {
                    lValueOf2 = l;
                }
                this.zzg = lValueOf2;
            } else {
                if (zZzs && zzekVar.zzo()) {
                    lValueOf2 = l2;
                }
                this.zzf = lValueOf2;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public boolean zzd(Long l, Long l2, com.google.android.gms.internal.measurement.zzgm zzgmVar, boolean z) {
        zznz.zzc();
        zzaa zzaaVar = this.zza;
        boolean zZzs = ((zzfr) zzaaVar.mBuilder).zzk.zzs(this.zzb, zzdu.zzU);
        zzet zzetVar = (zzet) this.zzh;
        boolean zZzg = zzetVar.zzg();
        boolean zZzh = zzetVar.zzh();
        boolean zZzi = zzetVar.zzi();
        byte b = zZzg || zZzh || zZzi;
        Boolean boolZzj = null;
        boolZze = null;
        Boolean boolZze = null;
        boolZzj = null;
        boolZzj = null;
        boolZzj = null;
        Boolean boolZze2 = null;
        boolZzj = null;
        zzfr zzfrVar = (zzfr) zzaaVar.mBuilder;
        if (z && b == false) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzl.zzc(Integer.valueOf(this.zzc), eoBKjVuj.RklK, zzetVar.zzj() ? Integer.valueOf(zzetVar.zza()) : null);
            return true;
        }
        com.google.android.gms.internal.measurement.zzem zzemVarZzb = zzetVar.zzb();
        boolean zZzg2 = zzemVarZzb.zzg();
        if (zzgmVar.zzr()) {
            if (!zzemVarZzb.zzi()) {
                zzeh zzehVar2 = zzfrVar.zzm;
                zzfr.zzR(zzehVar2);
                zzehVar2.zzg.zzb(zzfrVar.zzq.zzf(zzgmVar.zzf()), "No number filter for long property. property");
            } else {
                boolZzj = zzj(zzh(zzgmVar.zzb(), zzemVarZzb.zzc()), zZzg2);
            }
        } else if (zzgmVar.zzq()) {
            if (!zzemVarZzb.zzi()) {
                zzeh zzehVar3 = zzfrVar.zzm;
                zzfr.zzR(zzehVar3);
                zzehVar3.zzg.zzb(zzfrVar.zzq.zzf(zzgmVar.zzf()), "No number filter for double property. property");
            } else {
                double dZza = zzgmVar.zza();
                try {
                    boolZze = zze(new BigDecimal(dZza), zzemVarZzb.zzc(), Math.ulp(dZza));
                } catch (NumberFormatException unused) {
                }
                boolZzj = zzj(boolZze, zZzg2);
            }
        } else if (zzgmVar.zzt()) {
            if (!zzemVarZzb.zzk()) {
                if (!zzemVarZzb.zzi()) {
                    zzeh zzehVar4 = zzfrVar.zzm;
                    zzfr.zzR(zzehVar4);
                    zzehVar4.zzg.zzb(zzfrVar.zzq.zzf(zzgmVar.zzf()), "No string or number filter defined. property");
                } else if (zzen.zzx(zzgmVar.zzg())) {
                    String strZzg = zzgmVar.zzg();
                    zzer zzerVarZzc = zzemVarZzb.zzc();
                    if (zzen.zzx(strZzg)) {
                        try {
                            boolZze2 = zze(new BigDecimal(strZzg), zzerVarZzc, 0.0d);
                        } catch (NumberFormatException unused2) {
                        }
                    }
                    boolZzj = zzj(boolZze2, zZzg2);
                } else {
                    zzeh zzehVar5 = zzfrVar.zzm;
                    zzfr.zzR(zzehVar5);
                    zzehVar5.zzg.zzc(zzfrVar.zzq.zzf(zzgmVar.zzf()), "Invalid user property value for Numeric number filter. property, value", zzgmVar.zzg());
                }
            } else {
                String strZzg2 = zzgmVar.zzg();
                zzey zzeyVarZzd = zzemVarZzb.zzd();
                zzeh zzehVar6 = zzfrVar.zzm;
                zzfr.zzR(zzehVar6);
                boolZzj = zzj(zzf(strZzg2, zzeyVarZzd, zzehVar6), zZzg2);
            }
        } else {
            zzeh zzehVar7 = zzfrVar.zzm;
            zzfr.zzR(zzehVar7);
            zzehVar7.zzg.zzb(zzfrVar.zzq.zzf(zzgmVar.zzf()), "User property has no value, property");
        }
        zzeh zzehVar8 = zzfrVar.zzm;
        zzfr.zzR(zzehVar8);
        zzehVar8.zzl.zzb(boolZzj == null ? "null" : boolZzj, "Property filter result");
        if (boolZzj == null) {
            return false;
        }
        this.zzd = Boolean.TRUE;
        if (zZzi && !boolZzj.booleanValue()) {
            return true;
        }
        if (!z || zzetVar.zzg()) {
            this.zze = boolZzj;
        }
        if (boolZzj.booleanValue() && b != false && zzgmVar.zzs()) {
            long jZzc = zzgmVar.zzc();
            if (l != null) {
                jZzc = l.longValue();
            }
            if (zZzs && zzetVar.zzg() && !zzetVar.zzh() && l2 != null) {
                jZzc = l2.longValue();
            }
            if (zzetVar.zzh()) {
                this.zzg = Long.valueOf(jZzc);
            } else {
                this.zzf = Long.valueOf(jZzc);
            }
        }
        return true;
    }
}
