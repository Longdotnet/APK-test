package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzzp implements zzzl, zzhj {
    public static final zzfyq zza = zzfyq.zzr(4300000L, 3200000L, 2400000L, 1700000L, 860000L);
    public static final zzfyq zzb = zzfyq.zzr(1500000L, 980000L, 750000L, 520000L, 290000L);
    public static final zzfyq zzc = zzfyq.zzr(2000000L, 1300000L, 1000000L, 860000L, 610000L);
    public static final zzfyq zzd = zzfyq.zzr(2500000L, 1700000L, 1200000L, 970000L, 680000L);
    public static final zzfyq zze = zzfyq.zzr(4700000L, 2800000L, 2100000L, 1700000L, 980000L);
    public static final zzfyq zzf = zzfyq.zzr(2700000L, 2000000L, 1600000L, 1300000L, 1000000L);
    private static zzzp zzg;
    private final Context zzh;
    private final zzfyt zzi;
    private final zzzj zzj;
    private final zzaaf zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;
    private long zzr;
    private int zzs;
    private String zzt;

    public /* synthetic */ zzzp(Context context, Map map, int i, zzdj zzdjVar, boolean z, zzzo zzzoVar) {
        this.zzh = context == null ? null : context.getApplicationContext();
        this.zzi = zzfyt.zzc(map);
        this.zzj = new zzzj();
        this.zzk = new zzaaf(2000);
        if (context == null) {
            this.zzs = 0;
            this.zzq = 1000000L;
            return;
        }
        zzel zzelVarZzb = zzel.zzb(context);
        int iZza = zzelVarZzb.zza();
        this.zzs = iZza;
        this.zzq = zzj(iZza);
        zzelVarZzb.zzf(new zzzn(this), zzde.zza());
    }

    public static synchronized zzzp zzh(Context context) {
        try {
            if (zzg == null) {
                Context applicationContext = context == null ? null : context.getApplicationContext();
                zzdj zzdjVar = zzdj.zza;
                HashMap map = new HashMap(8);
                map.put(0, 1000000L);
                map.put(2, -9223372036854775807L);
                map.put(3, -9223372036854775807L);
                map.put(4, -9223372036854775807L);
                map.put(5, -9223372036854775807L);
                map.put(10, -9223372036854775807L);
                map.put(9, -9223372036854775807L);
                map.put(7, -9223372036854775807L);
                zzg = new zzzp(applicationContext, map, 2000, zzdjVar, true, null);
            }
        } catch (Throwable th) {
            throw th;
        }
        return zzg;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x009b  */
    private final long zzj(int i) {
        long jLongValue;
        zzfyt zzfytVar = this.zzi;
        Long lValueOf = (Long) zzfytVar.get(Integer.valueOf(i));
        if (lValueOf == null) {
            lValueOf = (Long) zzfytVar.get(0);
        } else if (lValueOf.longValue() == -9223372036854775807L) {
            int[] iArrZzn = zzn(zzfwg.zzc(this.zzt));
            if (i == 2) {
                jLongValue = ((Long) zza.get(iArrZzn[0])).longValue();
            } else if (i == 3) {
                jLongValue = ((Long) zzb.get(iArrZzn[1])).longValue();
            } else if (i == 4) {
                jLongValue = ((Long) zzc.get(iArrZzn[2])).longValue();
            } else if (i == 5) {
                jLongValue = ((Long) zzd.get(iArrZzn[3])).longValue();
            } else if (i == 7) {
                jLongValue = ((Long) zza.get(iArrZzn[0])).longValue();
            } else if (i != 9) {
                jLongValue = i != 10 ? 1000000L : ((Long) zze.get(iArrZzn[4])).longValue();
            } else {
                jLongValue = ((Long) zzf.get(iArrZzn[5])).longValue();
            }
            lValueOf = Long.valueOf(jLongValue);
        }
        if (lValueOf == null) {
            lValueOf = 1000000L;
        }
        return lValueOf.longValue();
    }

    private final void zzk(int i, long j, long j2) {
        int i2;
        long j3;
        if (i == 0) {
            if (j != 0) {
                j3 = j;
            } else if (j2 == this.zzr) {
                return;
            } else {
                j3 = 0;
            }
            i2 = 0;
        } else {
            i2 = i;
            j3 = j;
        }
        this.zzr = j2;
        this.zzj.zzb(i2, j3, j2);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x003c A[Catch: all -> 0x000a, TryCatch #0 {all -> 0x000a, blocks: (B:3:0x0001, B:5:0x0005, B:10:0x000d, B:16:0x0019, B:18:0x001d, B:20:0x0023, B:22:0x002d, B:24:0x0037, B:26:0x0048, B:25:0x003c, B:27:0x004a, B:29:0x0058, B:32:0x0061), top: B:39:0x0001 }] */
    public final synchronized void zzl(int i) {
        String strZzb;
        TelephonyManager telephonyManager;
        try {
            if (this.zzs != i || this.zzt == null) {
                this.zzs = i;
                if (i != 1 && i != 0 && i != 8) {
                    if (this.zzt == null) {
                        Context context = this.zzh;
                        String str = zzex.zza;
                        if (context == null || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
                            strZzb = zzfuv.zzb(Locale.getDefault().getCountry());
                        } else {
                            String networkCountryIso = telephonyManager.getNetworkCountryIso();
                            if (TextUtils.isEmpty(networkCountryIso)) {
                                strZzb = zzfuv.zzb(Locale.getDefault().getCountry());
                            } else {
                                strZzb = zzfuv.zzb(networkCountryIso);
                            }
                        }
                        this.zzt = strZzb;
                    }
                    this.zzq = zzj(i);
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    zzk(this.zzl > 0 ? (int) (jElapsedRealtime - this.zzm) : 0, this.zzn, this.zzq);
                    this.zzm = jElapsedRealtime;
                    this.zzn = 0L;
                    this.zzp = 0L;
                    this.zzo = 0L;
                    this.zzk.zzc();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private static boolean zzm(zzgo zzgoVar, boolean z) {
        return z && !zzgoVar.zzb(8);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0146, code lost:
    
        if (r3.equals("YE") != false) goto L827;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x015e, code lost:
    
        if (r3.equals("WS") != false) goto L398;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0168, code lost:
    
        if (r3.equals("WF") != false) goto L457;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0172, code lost:
    
        if (r3.equals("VU") != false) goto L540;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x01a6, code lost:
    
        if (r3.equals("VE") != false) goto L827;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x01b0, code lost:
    
        if (r3.equals("VC") != false) goto L885;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x01ba, code lost:
    
        if (r3.equals("VA") != false) goto L893;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x01fc, code lost:
    
        if (r3.equals("UA") != false) goto L815;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0222, code lost:
    
        if (r3.equals("TV") != false) goto L457;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x023b, code lost:
    
        if (r3.equals(com.google.android.gms.common.stats.ZnFR.FKidOcdAYt.YPmadLlMSfwctO) != false) goto L889;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0261, code lost:
    
        if (r3.equals("TM") != false) goto L457;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x026b, code lost:
    
        if (r3.equals("TL") != false) goto L784;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0275, code lost:
    
        if (r3.equals("TJ") != false) goto L744;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x027f, code lost:
    
        if (r3.equals("TH") != false) goto L804;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x0297, code lost:
    
        if (r3.equals("TD") != false) goto L839;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x02af, code lost:
    
        if (r3.equals("SZ") != false) goto L866;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x02ba, code lost:
    
        if (r3.equals(com.google.android.gms.signin.internal.FVfQ.GsPcpBmONXh.nGqswqfoaE) != false) goto L839;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x02c4, code lost:
    
        if (r3.equals("SX") != false) goto L885;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x02ea, code lost:
    
        if (r3.equals("SS") != false) goto L656;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x031e, code lost:
    
        if (r3.equals("SM") != false) goto L893;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x0328, code lost:
    
        if (r3.equals("SL") != false) goto L851;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x0340, code lost:
    
        if (r3.equals("SJ") != false) goto L708;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x034a, code lost:
    
        if (r3.equals("SI") != false) goto L835;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x0355, code lost:
    
        if (r3.equals(kotlinx.coroutines.internal.Jbo.ygoi.FjkNBFPFLzhefrl) != false) goto L728;
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x036e, code lost:
    
        if (r3.equals("SE") != false) goto L736;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x0378, code lost:
    
        if (r3.equals("SD") != false) goto L839;
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x0382, code lost:
    
        if (r3.equals("SC") != false) goto L728;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003f, code lost:
    
        if (r3.equals("CI") != false) goto L862;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x038d, code lost:
    
        if (r3.equals(androidx.sqlite.db.framework.VERT.YcVWhnLsj.hFKOhEyw) != false) goto L272;
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x0394, code lost:
    
        return new int[]{4, 2, 4, 3, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x03fd, code lost:
    
        if (r3.equals("PY") != false) goto L435;
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x0415, code lost:
    
        if (r3.equals("PT") != false) goto L835;
     */
    /* JADX WARN: Code restructure failed: missing block: B:321:0x043b, code lost:
    
        if (r3.equals("PM") != false) goto L893;
     */
    /* JADX WARN: Code restructure failed: missing block: B:336:0x046f, code lost:
    
        if (r3.equals("PG") != false) goto L497;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0057, code lost:
    
        if (r3.equals("CG") != false) goto L732;
     */
    /* JADX WARN: Code restructure failed: missing block: B:347:0x0495, code lost:
    
        if (r3.equals("PA") != false) goto L901;
     */
    /* JADX WARN: Code restructure failed: missing block: B:358:0x04bc, code lost:
    
        if (r3.equals("NU") != false) goto L728;
     */
    /* JADX WARN: Code restructure failed: missing block: B:361:0x04c6, code lost:
    
        if (r3.equals("NR") != false) goto L784;
     */
    /* JADX WARN: Code restructure failed: missing block: B:376:0x04fa, code lost:
    
        if (r3.equals("NI") != false) goto L788;
     */
    /* JADX WARN: Code restructure failed: missing block: B:383:0x0512, code lost:
    
        if (r3.equals("NF") != false) goto L708;
     */
    /* JADX WARN: Code restructure failed: missing block: B:386:0x051c, code lost:
    
        if (r3.equals("NE") != false) goto L827;
     */
    /* JADX WARN: Code restructure failed: missing block: B:389:0x0526, code lost:
    
        if (r3.equals("NC") != false) goto L390;
     */
    /* JADX WARN: Code restructure failed: missing block: B:391:0x052d, code lost:
    
        return new int[]{2, 3, 3, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:397:0x0542, code lost:
    
        if (r3.equals("MZ") != false) goto L398;
     */
    /* JADX WARN: Code restructure failed: missing block: B:399:0x0549, code lost:
    
        return new int[]{3, 1, 2, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:421:0x0597, code lost:
    
        if (r3.equals(com.google.android.gms.ads.jY.UUFMQdNK.rBfTrrsjIylF) != false) goto L736;
     */
    /* JADX WARN: Code restructure failed: missing block: B:424:0x05a1, code lost:
    
        if (r3.equals("MS") != false) goto L893;
     */
    /* JADX WARN: Code restructure failed: missing block: B:427:0x05ab, code lost:
    
        if (r3.equals("MR") != false) goto L800;
     */
    /* JADX WARN: Code restructure failed: missing block: B:434:0x05c3, code lost:
    
        if (r3.equals("MP") != false) goto L435;
     */
    /* JADX WARN: Code restructure failed: missing block: B:436:0x05ca, code lost:
    
        return new int[]{1, 2, 2, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:446:0x05ed, code lost:
    
        if (r3.equals("MM") != false) goto L504;
     */
    /* JADX WARN: Code restructure failed: missing block: B:449:0x05f7, code lost:
    
        if (r3.equals("ML") != false) goto L811;
     */
    /* JADX WARN: Code restructure failed: missing block: B:456:0x060f, code lost:
    
        if (r3.equals("MH") != false) goto L457;
     */
    /* JADX WARN: Code restructure failed: missing block: B:458:0x0616, code lost:
    
        return new int[]{4, 2, 2, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:460:0x061d, code lost:
    
        if (r3.equals("MG") != false) goto L732;
     */
    /* JADX WARN: Code restructure failed: missing block: B:475:0x0651, code lost:
    
        if (r3.equals("MC") != false) goto L660;
     */
    /* JADX WARN: Code restructure failed: missing block: B:482:0x0669, code lost:
    
        if (r3.equals("LY") != false) goto L851;
     */
    /* JADX WARN: Code restructure failed: missing block: B:485:0x0674, code lost:
    
        if (r3.equals(androidx.loader.app.gv.DYYbQc.TxOGHAtc) != false) goto L736;
     */
    /* JADX WARN: Code restructure failed: missing block: B:496:0x069a, code lost:
    
        if (r3.equals("LS") != false) goto L497;
     */
    /* JADX WARN: Code restructure failed: missing block: B:498:0x06a1, code lost:
    
        return new int[]{4, 3, 3, 3, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:500:0x06a8, code lost:
    
        if (r3.equals("LR") != false) goto L748;
     */
    /* JADX WARN: Code restructure failed: missing block: B:503:0x06b2, code lost:
    
        if (r3.equals("LK") != false) goto L504;
     */
    /* JADX WARN: Code restructure failed: missing block: B:505:0x06b9, code lost:
    
        return new int[]{3, 2, 3, 3, 4, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:507:0x06c0, code lost:
    
        if (r3.equals("LI") != false) goto L893;
     */
    /* JADX WARN: Code restructure failed: missing block: B:526:0x0702, code lost:
    
        if (r3.equals("KY") != false) goto L885;
     */
    /* JADX WARN: Code restructure failed: missing block: B:529:0x070d, code lost:
    
        if (r3.equals(com.google.gson.yWTz.kBfGXgdfpo.HISEIqAvKfpqHU) != false) goto L617;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0099, code lost:
    
        if (r3.equals("BQ") != false) goto L885;
     */
    /* JADX WARN: Code restructure failed: missing block: B:536:0x0726, code lost:
    
        if (r3.equals("KN") != false) goto L885;
     */
    /* JADX WARN: Code restructure failed: missing block: B:539:0x0730, code lost:
    
        if (r3.equals("KM") != false) goto L540;
     */
    /* JADX WARN: Code restructure failed: missing block: B:541:0x0737, code lost:
    
        return new int[]{4, 3, 3, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:543:0x073e, code lost:
    
        if (r3.equals("KI") != false) goto L784;
     */
    /* JADX WARN: Code restructure failed: missing block: B:562:0x0780, code lost:
    
        if (r3.equals("JO") != false) goto L889;
     */
    /* JADX WARN: Code restructure failed: missing block: B:569:0x0798, code lost:
    
        if (r3.equals("JE") != false) goto L664;
     */
    /* JADX WARN: Code restructure failed: missing block: B:576:0x07b0, code lost:
    
        if (r3.equals("IS") != false) goto L736;
     */
    /* JADX WARN: Code restructure failed: missing block: B:595:0x07f2, code lost:
    
        if (r3.equals("IM") != false) goto L664;
     */
    /* JADX WARN: Code restructure failed: missing block: B:610:0x0826, code lost:
    
        if (r3.equals("HU") != false) goto L736;
     */
    /* JADX WARN: Code restructure failed: missing block: B:613:0x0830, code lost:
    
        if (r3.equals("HT") != false) goto L827;
     */
    /* JADX WARN: Code restructure failed: missing block: B:616:0x083a, code lost:
    
        if (r3.equals("HR") != false) goto L617;
     */
    /* JADX WARN: Code restructure failed: missing block: B:618:0x0841, code lost:
    
        return new int[]{1, 0, 0, 0, 0, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:644:0x089c, code lost:
    
        if (r3.equals("GQ") != false) goto L827;
     */
    /* JADX WARN: Code restructure failed: missing block: B:655:0x08c2, code lost:
    
        if (r3.equals("GM") != false) goto L656;
     */
    /* JADX WARN: Code restructure failed: missing block: B:657:0x08c9, code lost:
    
        return new int[]{4, 3, 2, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:659:0x08d0, code lost:
    
        if (r3.equals("GL") != false) goto L660;
     */
    /* JADX WARN: Code restructure failed: missing block: B:661:0x08d7, code lost:
    
        return new int[]{1, 2, 2, 0, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:663:0x08de, code lost:
    
        if (r3.equals("GI") != false) goto L664;
     */
    /* JADX WARN: Code restructure failed: missing block: B:665:0x08e5, code lost:
    
        return new int[]{0, 2, 0, 1, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00cd, code lost:
    
        if (r3.equals("BL") != false) goto L435;
     */
    /* JADX WARN: Code restructure failed: missing block: B:707:0x0978, code lost:
    
        if (r3.equals("FK") != false) goto L708;
     */
    /* JADX WARN: Code restructure failed: missing block: B:709:0x097f, code lost:
    
        return new int[]{3, 2, 2, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:727:0x09be, code lost:
    
        if (r3.equals("ER") != false) goto L728;
     */
    /* JADX WARN: Code restructure failed: missing block: B:729:0x09c5, code lost:
    
        return new int[]{4, 2, 2, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:731:0x09cc, code lost:
    
        if (r3.equals("EG") != false) goto L732;
     */
    /* JADX WARN: Code restructure failed: missing block: B:733:0x09d3, code lost:
    
        return new int[]{3, 4, 3, 3, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:735:0x09da, code lost:
    
        if (r3.equals("EE") != false) goto L736;
     */
    /* JADX WARN: Code restructure failed: missing block: B:737:0x09e1, code lost:
    
        return new int[]{0, 0, 0, 0, 0, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:743:0x09f6, code lost:
    
        if (r3.equals("DZ") != false) goto L744;
     */
    /* JADX WARN: Code restructure failed: missing block: B:745:0x09fd, code lost:
    
        return new int[]{3, 3, 4, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:747:0x0a04, code lost:
    
        if (r3.equals("DO") != false) goto L748;
     */
    /* JADX WARN: Code restructure failed: missing block: B:749:0x0a0b, code lost:
    
        return new int[]{3, 4, 4, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00e5, code lost:
    
        if (r3.equals("AT") != false) goto L736;
     */
    /* JADX WARN: Code restructure failed: missing block: B:751:0x0a12, code lost:
    
        if (r3.equals("DM") != false) goto L885;
     */
    /* JADX WARN: Code restructure failed: missing block: B:758:0x0a2a, code lost:
    
        if (r3.equals("DJ") != false) goto L851;
     */
    /* JADX WARN: Code restructure failed: missing block: B:773:0x0a5e, code lost:
    
        if (r3.equals("CX") != false) goto L893;
     */
    /* JADX WARN: Code restructure failed: missing block: B:776:0x0a68, code lost:
    
        if (r3.equals("CW") != false) goto L885;
     */
    /* JADX WARN: Code restructure failed: missing block: B:783:0x0a80, code lost:
    
        if (r3.equals("CU") != false) goto L784;
     */
    /* JADX WARN: Code restructure failed: missing block: B:785:0x0a87, code lost:
    
        return new int[]{4, 2, 4, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:787:0x0a8e, code lost:
    
        if (r3.equals("CR") != false) goto L788;
     */
    /* JADX WARN: Code restructure failed: missing block: B:789:0x0a95, code lost:
    
        return new int[]{2, 4, 4, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:799:0x0ab8, code lost:
    
        if (r3.equals("CM") != false) goto L800;
     */
    /* JADX WARN: Code restructure failed: missing block: B:801:0x0abf, code lost:
    
        return new int[]{4, 3, 3, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:803:0x0ac6, code lost:
    
        if (r3.equals("CL") != false) goto L804;
     */
    /* JADX WARN: Code restructure failed: missing block: B:805:0x0acd, code lost:
    
        return new int[]{0, 1, 2, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:807:0x0ad4, code lost:
    
        if (r3.equals("CK") != false) goto L877;
     */
    /* JADX WARN: Code restructure failed: missing block: B:810:0x0ade, code lost:
    
        if (r3.equals("CD") != false) goto L811;
     */
    /* JADX WARN: Code restructure failed: missing block: B:812:0x0ae5, code lost:
    
        return new int[]{3, 3, 2, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:814:0x0aec, code lost:
    
        if (r3.equals("CA") != false) goto L815;
     */
    /* JADX WARN: Code restructure failed: missing block: B:816:0x0af3, code lost:
    
        return new int[]{0, 2, 1, 2, 3, 3};
     */
    /* JADX WARN: Code restructure failed: missing block: B:826:0x0b16, code lost:
    
        if (r3.equals("BI") != false) goto L827;
     */
    /* JADX WARN: Code restructure failed: missing block: B:828:0x0b1d, code lost:
    
        return new int[]{4, 4, 4, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:834:0x0b32, code lost:
    
        if (r3.equals("BG") != false) goto L835;
     */
    /* JADX WARN: Code restructure failed: missing block: B:836:0x0b39, code lost:
    
        return new int[]{0, 0, 0, 0, 1, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:838:0x0b40, code lost:
    
        if (r3.equals("BF") != false) goto L839;
     */
    /* JADX WARN: Code restructure failed: missing block: B:840:0x0b47, code lost:
    
        return new int[]{4, 3, 4, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:850:0x0b6a, code lost:
    
        if (r3.equals("AZ") != false) goto L851;
     */
    /* JADX WARN: Code restructure failed: missing block: B:852:0x0b71, code lost:
    
        return new int[]{4, 2, 3, 3, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:858:0x0b86, code lost:
    
        if (r3.equals("AI") != false) goto L885;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x010c, code lost:
    
        if (r3.equals(com.google.android.gms.ads.jY.UUFMQdNK.LAr) != false) goto L728;
     */
    /* JADX WARN: Code restructure failed: missing block: B:861:0x0b8f, code lost:
    
        if (r3.equals("AG") != false) goto L862;
     */
    /* JADX WARN: Code restructure failed: missing block: B:863:0x0b96, code lost:
    
        return new int[]{2, 4, 3, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:865:0x0b9d, code lost:
    
        if (r3.equals("AF") != false) goto L866;
     */
    /* JADX WARN: Code restructure failed: missing block: B:867:0x0ba4, code lost:
    
        return new int[]{4, 4, 3, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:873:0x0bb9, code lost:
    
        if (r3.equals("AD") != false) goto L885;
     */
    /* JADX WARN: Code restructure failed: missing block: B:876:0x0bc2, code lost:
    
        if (r3.equals("BZ") != false) goto L877;
     */
    /* JADX WARN: Code restructure failed: missing block: B:878:0x0bc9, code lost:
    
        return new int[]{2, 2, 2, 1, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:884:0x0bdf, code lost:
    
        if (r3.equals("BB") != false) goto L885;
     */
    /* JADX WARN: Code restructure failed: missing block: B:886:0x0be6, code lost:
    
        return new int[]{1, 2, 0, 0, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:888:0x0bed, code lost:
    
        if (r3.equals("BA") != false) goto L889;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0116, code lost:
    
        if (r3.equals("ZW") != false) goto L272;
     */
    /* JADX WARN: Code restructure failed: missing block: B:890:0x0bf4, code lost:
    
        return new int[]{1, 1, 1, 1, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:892:0x0bfb, code lost:
    
        if (r3.equals("AX") != false) goto L893;
     */
    /* JADX WARN: Code restructure failed: missing block: B:894:0x0c02, code lost:
    
        return new int[]{0, 2, 2, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:900:0x0c17, code lost:
    
        if (r3.equals("AM") != false) goto L901;
     */
    /* JADX WARN: Code restructure failed: missing block: B:902:0x0c1e, code lost:
    
        return new int[]{2, 3, 2, 3, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x013c, code lost:
    
        if (r3.equals("YT") != false) goto L390;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int[] zzn(java.lang.String r3) {
        /*
            Method dump skipped, instruction units count: 6684
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzzp.zzn(java.lang.String):int[]");
    }

    @Override // com.google.android.gms.internal.ads.zzhj
    public final synchronized void zza(zzgj zzgjVar, zzgo zzgoVar, boolean z, int i) {
        if (zzm(zzgoVar, z)) {
            this.zzn += (long) i;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhj
    public final synchronized void zzb(zzgj zzgjVar, zzgo zzgoVar, boolean z) {
        try {
            if (zzm(zzgoVar, z)) {
                zzdd.zzf(this.zzl > 0);
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                int i = (int) (jElapsedRealtime - this.zzm);
                this.zzo += (long) i;
                long j = this.zzp;
                long j2 = this.zzn;
                this.zzp = j + j2;
                if (i > 0) {
                    zzaaf zzaafVar = this.zzk;
                    zzaafVar.zzb((int) Math.sqrt(j2), (j2 * 8000.0f) / i);
                    if (this.zzo >= 2000 || this.zzp >= 524288) {
                        this.zzq = (long) zzaafVar.zza(0.5f);
                    }
                    zzk(i, this.zzn, this.zzq);
                    this.zzm = jElapsedRealtime;
                    this.zzn = 0L;
                }
                this.zzl--;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhj
    public final void zzc(zzgj zzgjVar, zzgo zzgoVar, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzhj
    public final synchronized void zzd(zzgj zzgjVar, zzgo zzgoVar, boolean z) {
        try {
            if (zzm(zzgoVar, z)) {
                if (this.zzl == 0) {
                    this.zzm = SystemClock.elapsedRealtime();
                }
                this.zzl++;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzl
    public final zzhj zze() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzzl
    public final void zzf(Handler handler, zzzk zzzkVar) {
        zzzkVar.getClass();
        this.zzj.zza(handler, zzzkVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzl
    public final void zzg(zzzk zzzkVar) {
        this.zzj.zzc(zzzkVar);
    }
}
