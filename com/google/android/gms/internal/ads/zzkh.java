package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.firebase.analytics.connector.pDv.PZmDzEagKNdW;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
final class zzkh extends zzg implements zziy {
    public static final /* synthetic */ int zzd = 0;
    private final zzdi zzA;
    private int zzB;
    private int zzC;
    private boolean zzD;
    private zzmh zzE;
    private zzmi zzF;
    private zzix zzG;
    private zzbd zzH;
    private zzat zzI;
    private Object zzJ;
    private Surface zzK;
    private int zzL;
    private zzeo zzM;
    private zze zzN;
    private float zzO;
    private boolean zzP;
    private boolean zzQ;
    private boolean zzR;
    private int zzS;
    private zzat zzT;
    private zzls zzU;
    private int zzV;
    private long zzW;
    private final zzjj zzX;
    private zzxc zzY;
    final zzze zzb;
    final zzbd zzc;
    private final zzdm zze = new zzdm(zzdj.zza);
    private final Context zzf;
    private final zzbh zzg;
    private final zzma[] zzh;
    private final zzma[] zzi;
    private final zzzd zzj;
    private final zzdt zzk;
    private final zzkt zzl;
    private final zzdz zzm;
    private final CopyOnWriteArraySet zzn;
    private final zzbj zzo;
    private final List zzp;
    private final boolean zzq;
    private final zzmo zzr;
    private final Looper zzs;
    private final zzzl zzt;
    private final zzdj zzu;
    private final zzkd zzv;
    private final zzke zzw;
    private final zzmm zzx;
    private final zzmn zzy;
    private final long zzz;

    static {
        zzaq.zzb("media3.exoplayer");
    }

    public zzkh(zziw zziwVar, zzbh zzbhVar) {
        zziw zziwVar2;
        zzdj zzdjVar;
        try {
            zzea.zze("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.8.0-alpha01] [" + zzex.zza + "]");
            this.zzf = zziwVar.zza.getApplicationContext();
            this.zzr = (zzmo) zziwVar.zzh.apply(zziwVar.zzb);
            this.zzS = zziwVar.zzj;
            this.zzN = zziwVar.zzk;
            this.zzL = zziwVar.zzl;
            this.zzP = false;
            this.zzz = zziwVar.zzq;
            zzkd zzkdVar = new zzkd(this, null);
            this.zzv = zzkdVar;
            this.zzw = new zzke(null);
            zzma[] zzmaVarArrZzac = zzceo.zzac(((zzip) zziwVar.zzc).zza.zza, new Handler(zziwVar.zzi), zzkdVar, zzkdVar, zzkdVar, zzkdVar);
            this.zzh = zzmaVarArrZzac;
            int length = zzmaVarArrZzac.length;
            this.zzi = new zzma[2];
            int i = 0;
            while (true) {
                zzma[] zzmaVarArr = this.zzi;
                int length2 = zzmaVarArr.length;
                if (i >= 2) {
                    break;
                }
                zzma zzmaVar = this.zzh[i];
                zzmaVarArr[i] = null;
                i++;
            }
            zzzd zzzdVar = (zzzd) zziwVar.zze.zza();
            this.zzj = zzzdVar;
            zziw.zza(((zziq) zziwVar.zzd).zza);
            zzzp zzzpVarZzh = zzzp.zzh(((zzit) zziwVar.zzg).zza);
            this.zzt = zzzpVarZzh;
            this.zzq = zziwVar.zzm;
            this.zzF = zziwVar.zzn;
            this.zzE = zziwVar.zzo;
            Looper looper = zziwVar.zzi;
            this.zzs = looper;
            zzdj zzdjVar2 = zziwVar.zzb;
            this.zzu = zzdjVar2;
            this.zzg = zzbhVar;
            zzdz zzdzVar = new zzdz(looper, zzdjVar2, new zzdx(this) { // from class: com.google.android.gms.internal.ads.zzji
                @Override // com.google.android.gms.internal.ads.zzdx
                public final void zza(Object obj, zzv zzvVar) {
                }
            });
            this.zzm = zzdzVar;
            CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
            this.zzn = copyOnWriteArraySet;
            this.zzp = new ArrayList();
            this.zzY = new zzxc(0);
            this.zzG = zzix.zza;
            int length3 = this.zzh.length;
            zzze zzzeVar = new zzze(new zzme[2], new zzyw[2], zzbt.zza, null);
            this.zzb = zzzeVar;
            this.zzo = new zzbj();
            zzbc zzbcVar = new zzbc();
            zzbcVar.zzc(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 35, 22, 24, 27, 28, 32);
            zzzdVar.zzn();
            zzbcVar.zzd(29, true);
            zzbcVar.zzd(23, false);
            zzbcVar.zzd(25, false);
            zzbcVar.zzd(33, false);
            zzbcVar.zzd(26, false);
            zzbcVar.zzd(34, false);
            zzbd zzbdVarZze = zzbcVar.zze();
            this.zzc = zzbdVarZze;
            zzbc zzbcVar2 = new zzbc();
            zzbcVar2.zzb(zzbdVarZze);
            zzbcVar2.zza(4);
            zzbcVar2.zza(10);
            this.zzH = zzbcVar2.zze();
            this.zzk = zzdjVar2.zzd(looper, null);
            zzjj zzjjVar = new zzjj(this);
            this.zzX = zzjjVar;
            this.zzU = zzls.zzh(zzzeVar);
            this.zzr.zzT(zzbhVar, looper);
            final zzph zzphVar = new zzph(zziwVar.zzt);
            zzkt zzktVar = new zzkt(this.zzf, this.zzh, this.zzi, zzzdVar, zzzeVar, (zzkx) zziwVar.zzf.zza(), zzzpVarZzh, 0, false, this.zzr, this.zzF, zziwVar.zzu, zziwVar.zzp, false, false, looper, zzdjVar2, zzjjVar, zzphVar, null, this.zzG, this.zzw);
            this.zzl = zzktVar;
            Looper looperZze = zzktVar.zze();
            this.zzO = 1.0f;
            zzat zzatVar = zzat.zza;
            this.zzI = zzatVar;
            this.zzT = zzatVar;
            this.zzV = -1;
            int i2 = zzcw.zza;
            this.zzQ = true;
            zzmo zzmoVar = this.zzr;
            if (zzmoVar == null) {
                throw null;
            }
            zzdzVar.zzb(zzmoVar);
            zzzpVarZzh.zzf(new Handler(looper), this.zzr);
            copyOnWriteArraySet.add(this.zzv);
            if (Build.VERSION.SDK_INT >= 31) {
                final Context context = this.zzf;
                zziwVar2 = zziwVar;
                final boolean z = zziwVar2.zzr;
                zzdjVar = zzdjVar2;
                zzdjVar.zzd(zzktVar.zze(), null).zzi(new Runnable() { // from class: com.google.android.gms.internal.ads.zzjx
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzpd zzpdVarZzb = zzpd.zzb(context);
                        if (zzpdVarZzb == null) {
                            zzea.zzf("ExoPlayerImpl", "MediaMetricsService unavailable.");
                            return;
                        }
                        if (z) {
                            this.zzz(zzpdVarZzb);
                        }
                        zzphVar.zzb(zzpdVarZzb.zza());
                    }
                });
            } else {
                zziwVar2 = zziwVar;
                zzdjVar = zzdjVar2;
            }
            zzdi zzdiVar = new zzdi(0, looperZze, looper, zzdjVar, new zzjk(this));
            this.zzA = zzdiVar;
            zzdiVar.zzd(new Runnable() { // from class: com.google.android.gms.internal.ads.zzjl
                @Override // java.lang.Runnable
                public final void run() {
                    zzkh.zzJ(this.zza);
                }
            });
            new zzhx(zziwVar2.zza, looperZze, zziwVar2.zzi, this.zzv, zzdjVar);
            this.zzx = new zzmm(zziwVar2.zza, looperZze, zzdjVar);
            this.zzy = new zzmn(zziwVar2.zza, looperZze, zzdjVar);
            int i3 = zzo.zza;
            zzcd zzcdVar = zzcd.zza;
            this.zzM = zzeo.zza;
            zzktVar.zzs(this.zzE);
            zzktVar.zzq(this.zzN, false);
            zzad(1, 3, this.zzN);
            zzad(2, 4, Integer.valueOf(this.zzL));
            zzad(2, 5, 0);
            zzad(1, 9, Boolean.valueOf(this.zzP));
            zzad(6, 8, this.zzw);
            zzad(-1, 16, Integer.valueOf(this.zzS));
            this.zze.zzf();
        } catch (Throwable th) {
            this.zze.zzf();
            throw th;
        }
    }

    public static /* synthetic */ void zzJ(zzkh zzkhVar) {
        String str = zzex.zza;
        zzkhVar.zzA.zze(Integer.valueOf(zzcj.zzc(zzkhVar.zzf).generateAudioSessionId()));
    }

    public static /* synthetic */ void zzK(zzkh zzkhVar, zzkq zzkqVar) {
        boolean z;
        long j;
        int i = zzkhVar.zzB - zzkqVar.zzb;
        zzkhVar.zzB = i;
        boolean z2 = true;
        if (zzkqVar.zzc) {
            zzkhVar.zzC = zzkqVar.zzd;
            zzkhVar.zzD = true;
        }
        if (i == 0) {
            zzbl zzblVar = zzkqVar.zza.zza;
            if (!zzkhVar.zzU.zza.zzo() && zzblVar.zzo()) {
                zzkhVar.zzV = -1;
                zzkhVar.zzW = 0L;
            }
            if (!zzblVar.zzo()) {
                List listZzw = ((zzly) zzblVar).zzw();
                int size = listZzw.size();
                List list = zzkhVar.zzp;
                zzdd.zzf(size == list.size());
                for (int i2 = 0; i2 < listZzw.size(); i2++) {
                    ((zzkf) list.get(i2)).zzc((zzbl) listZzw.get(i2));
                }
            }
            long j2 = -9223372036854775807L;
            if (zzkhVar.zzD) {
                if (zzkqVar.zza.zzb.equals(zzkhVar.zzU.zzb) && zzkqVar.zza.zzd == zzkhVar.zzU.zzs) {
                    z2 = false;
                }
                if (z2) {
                    if (zzblVar.zzo() || zzkqVar.zza.zzb.zzb()) {
                        j = zzkqVar.zza.zzd;
                    } else {
                        zzls zzlsVar = zzkqVar.zza;
                        zzvh zzvhVar = zzlsVar.zzb;
                        j = zzlsVar.zzd;
                        zzkhVar.zzW(zzblVar, zzvhVar, j);
                    }
                    z = z2;
                    j2 = j;
                } else {
                    z = z2;
                }
            } else {
                z = false;
            }
            zzkhVar.zzD = false;
            zzkhVar.zzag(zzkqVar.zza, 1, z, zzkhVar.zzC, j2, -1, false);
        }
    }

    public static /* synthetic */ void zzL(zzkh zzkhVar, int i, final int i2) {
        zzkhVar.zzai();
        Integer numValueOf = Integer.valueOf(i2);
        zzkhVar.zzad(1, 10, numValueOf);
        zzkhVar.zzad(2, 10, numValueOf);
        zzdw zzdwVar = new zzdw() { // from class: com.google.android.gms.internal.ads.zzjm
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
                int i3 = zzkh.zzd;
                ((zzbe) obj).zza(i2);
            }
        };
        zzdz zzdzVar = zzkhVar.zzm;
        zzdzVar.zzd(21, zzdwVar);
        zzdzVar.zzc();
    }

    public static /* bridge */ /* synthetic */ void zzP(zzkh zzkhVar, SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        zzkhVar.zzae(surface);
        zzkhVar.zzK = surface;
    }

    private final int zzS(zzls zzlsVar) {
        zzbl zzblVar = zzlsVar.zza;
        return zzblVar.zzo() ? this.zzV : zzblVar.zzn(zzlsVar.zzb.zza, this.zzo).zzc;
    }

    private final long zzT(zzls zzlsVar) {
        zzvh zzvhVar = zzlsVar.zzb;
        if (!zzvhVar.zzb()) {
            return zzex.zzv(zzU(zzlsVar));
        }
        zzbl zzblVar = zzlsVar.zza;
        zzblVar.zzn(zzvhVar.zza, this.zzo);
        long j = zzlsVar.zzc;
        if (j != -9223372036854775807L) {
            return zzex.zzv(0L) + zzex.zzv(j);
        }
        long j2 = zzblVar.zze(zzS(zzlsVar), this.zza, 0L).zzl;
        return zzex.zzv(0L);
    }

    private final long zzU(zzls zzlsVar) {
        zzbl zzblVar = zzlsVar.zza;
        if (zzblVar.zzo()) {
            return zzex.zzs(this.zzW);
        }
        long j = zzlsVar.zzs;
        zzvh zzvhVar = zzlsVar.zzb;
        if (zzvhVar.zzb()) {
            return j;
        }
        zzW(zzblVar, zzvhVar, j);
        return j;
    }

    private static long zzV(zzls zzlsVar) {
        zzbk zzbkVar = new zzbk();
        zzbj zzbjVar = new zzbj();
        zzbl zzblVar = zzlsVar.zza;
        zzblVar.zzn(zzlsVar.zzb.zza, zzbjVar);
        long j = zzlsVar.zzc;
        if (j != -9223372036854775807L) {
            return j;
        }
        long j2 = zzblVar.zze(zzbjVar.zzc, zzbkVar, 0L).zzl;
        return 0L;
    }

    private final long zzW(zzbl zzblVar, zzvh zzvhVar, long j) {
        zzblVar.zzn(zzvhVar.zza, this.zzo);
        return j;
    }

    private final Pair zzX(zzbl zzblVar, int i, long j) {
        if (zzblVar.zzo()) {
            this.zzV = i;
            if (j == -9223372036854775807L) {
                j = 0;
            }
            this.zzW = j;
            return null;
        }
        if (i == -1 || i >= zzblVar.zzc()) {
            i = zzblVar.zzg(false);
            long j2 = zzblVar.zze(i, this.zza, 0L).zzl;
            j = zzex.zzv(0L);
        }
        return zzblVar.zzl(this.zza, this.zzo, i, zzex.zzs(j));
    }

    private static zzls zzY(zzls zzlsVar, int i) {
        zzls zzlsVarZzf = zzlsVar.zzf(i);
        return (i == 1 || i == 4) ? zzlsVarZzf.zza(false) : zzlsVarZzf;
    }

    private final zzls zzZ(zzls zzlsVar, zzbl zzblVar, Pair pair) {
        zzdd.zzd(zzblVar.zzo() || pair != null);
        zzbl zzblVar2 = zzlsVar.zza;
        long jZzT = zzT(zzlsVar);
        zzls zzlsVarZzg = zzlsVar.zzg(zzblVar);
        if (zzblVar.zzo()) {
            zzvh zzvhVarZzi = zzls.zzi();
            long jZzs = zzex.zzs(this.zzW);
            zzls zzlsVarZzb = zzlsVarZzg.zzc(zzvhVarZzi, jZzs, jZzs, jZzs, 0L, zzxk.zza, this.zzb, zzfyq.zzn()).zzb(zzvhVarZzi);
            zzlsVarZzb.zzq = zzlsVarZzb.zzs;
            return zzlsVarZzb;
        }
        zzvh zzvhVar = zzlsVarZzg.zzb;
        Object obj = zzvhVar.zza;
        String str = zzex.zza;
        boolean zEquals = obj.equals(pair.first);
        zzvh zzvhVar2 = !zEquals ? new zzvh(pair.first, -1L) : zzvhVar;
        long jLongValue = ((Long) pair.second).longValue();
        long jZzs2 = zzex.zzs(jZzT);
        if (!zzblVar2.zzo()) {
            zzblVar2.zzn(obj, this.zzo);
        }
        if (!zEquals || jLongValue < jZzs2) {
            zzvh zzvhVar3 = zzvhVar2;
            zzdd.zzf(!zzvhVar3.zzb());
            zzls zzlsVarZzb2 = zzlsVarZzg.zzc(zzvhVar3, jLongValue, jLongValue, jLongValue, 0L, !zEquals ? zzxk.zza : zzlsVarZzg.zzh, !zEquals ? this.zzb : zzlsVarZzg.zzi, !zEquals ? zzfyq.zzn() : zzlsVarZzg.zzj).zzb(zzvhVar3);
            zzlsVarZzb2.zzq = jLongValue;
            return zzlsVarZzb2;
        }
        if (jLongValue != jZzs2) {
            zzvh zzvhVar4 = zzvhVar2;
            zzdd.zzf(!zzvhVar4.zzb());
            long jMax = Math.max(0L, zzlsVarZzg.zzr - (jLongValue - jZzs2));
            long j = zzlsVarZzg.zzq;
            if (zzlsVarZzg.zzk.equals(zzvhVar)) {
                j = jLongValue + jMax;
            }
            zzls zzlsVarZzc = zzlsVarZzg.zzc(zzvhVar4, jLongValue, jLongValue, jLongValue, jMax, zzlsVarZzg.zzh, zzlsVarZzg.zzi, zzlsVarZzg.zzj);
            zzlsVarZzc.zzq = j;
            return zzlsVarZzc;
        }
        int iZza = zzblVar.zza(zzlsVarZzg.zzk.zza);
        if (iZza != -1) {
            zzbj zzbjVar = this.zzo;
            if (zzblVar.zzd(iZza, zzbjVar, false).zzc == zzblVar.zzn(zzvhVar2.zza, zzbjVar).zzc) {
                return zzlsVarZzg;
            }
        }
        Object obj2 = zzvhVar2.zza;
        zzbj zzbjVar2 = this.zzo;
        zzblVar.zzn(obj2, zzbjVar2);
        long jZzf = zzvhVar2.zzb() ? zzbjVar2.zzf(zzvhVar2.zzb, zzvhVar2.zzc) : zzbjVar2.zzd;
        zzls zzlsVarZzb3 = zzlsVarZzg.zzc(zzvhVar2, zzlsVarZzg.zzs, zzlsVarZzg.zzs, zzlsVarZzg.zzd, jZzf - zzlsVarZzg.zzs, zzlsVarZzg.zzh, zzlsVarZzg.zzi, zzlsVarZzg.zzj).zzb(zzvhVar2);
        zzlsVarZzb3.zzq = jZzf;
        return zzlsVarZzb3;
    }

    private final zzlw zzaa(zzlv zzlvVar) {
        int iZzS = zzS(this.zzU);
        zzbl zzblVar = this.zzU.zza;
        if (iZzS == -1) {
            iZzS = 0;
        }
        zzdj zzdjVar = this.zzu;
        zzkt zzktVar = this.zzl;
        return new zzlw(zzktVar, zzlvVar, zzblVar, iZzS, zzdjVar, zzktVar.zze());
    }

    public final /* synthetic */ void zzab(final zzkq zzkqVar) {
        this.zzk.zzi(new Runnable() { // from class: com.google.android.gms.internal.ads.zzjo
            @Override // java.lang.Runnable
            public final void run() {
                zzkh.zzK(this.zza, zzkqVar);
            }
        });
    }

    public final void zzac(final int i, final int i2) {
        if (i == this.zzM.zzb() && i2 == this.zzM.zza()) {
            return;
        }
        this.zzM = new zzeo(i, i2);
        zzdz zzdzVar = this.zzm;
        zzdzVar.zzd(24, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjf
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
                int i3 = zzkh.zzd;
                ((zzbe) obj).zzp(i, i2);
            }
        });
        zzdzVar.zzc();
        zzad(2, 14, new zzeo(i, i2));
    }

    private final void zzad(int i, int i2, Object obj) {
        zzma[] zzmaVarArr = this.zzh;
        int length = zzmaVarArr.length;
        for (int i3 = 0; i3 < 2; i3++) {
            zzma zzmaVar = zzmaVarArr[i3];
            if (i == -1 || zzmaVar.zzb() == i) {
                zzlw zzlwVarZzaa = zzaa(zzmaVar);
                zzlwVarZzaa.zzf(i2);
                zzlwVarZzaa.zze(obj);
                zzlwVarZzaa.zzd();
            }
        }
        zzma[] zzmaVarArr2 = this.zzi;
        int length2 = zzmaVarArr2.length;
        for (int i4 = 0; i4 < 2; i4++) {
            zzma zzmaVar2 = zzmaVarArr2[i4];
            if (zzmaVar2 != null && (i == -1 || zzmaVar2.zzb() == i)) {
                zzlw zzlwVarZzaa2 = zzaa(zzmaVar2);
                zzlwVarZzaa2.zzf(i2);
                zzlwVarZzaa2.zze(obj);
                zzlwVarZzaa2.zzd();
            }
        }
    }

    public final void zzae(Object obj) {
        Object obj2 = this.zzJ;
        boolean z = false;
        if (obj2 != null && obj2 != obj) {
            z = true;
        }
        boolean zZzx = this.zzl.zzx(obj, z ? this.zzz : -9223372036854775807L);
        if (z) {
            Object obj3 = this.zzJ;
            Surface surface = this.zzK;
            if (obj3 == surface) {
                surface.release();
                this.zzK = null;
            }
        }
        this.zzJ = obj;
        if (zZzx) {
            return;
        }
        zzaf(zzin.zzd(new zzku(3), 1003));
    }

    private final void zzaf(zzin zzinVar) {
        zzls zzlsVar = this.zzU;
        zzls zzlsVarZzb = zzlsVar.zzb(zzlsVar.zzb);
        zzlsVarZzb.zzq = zzlsVarZzb.zzs;
        zzlsVarZzb.zzr = 0L;
        zzls zzlsVarZzY = zzY(zzlsVarZzb, 1);
        if (zzinVar != null) {
            zzlsVarZzY = zzlsVarZzY.zze(zzinVar);
        }
        this.zzB++;
        this.zzl.zzu();
        zzag(zzlsVarZzY, 0, false, 5, -9223372036854775807L, -1, false);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0292  */
    /* JADX WARN: Code duplicated, block: B:102:0x029f  */
    /* JADX WARN: Code duplicated, block: B:104:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:106:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:109:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:111:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:114:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:116:0x030b  */
    /* JADX WARN: Code duplicated, block: B:118:0x031b  */
    /* JADX WARN: Code duplicated, block: B:121:0x032a  */
    /* JADX WARN: Code duplicated, block: B:124:0x0338  */
    /* JADX WARN: Code duplicated, block: B:129:0x034b  */
    /* JADX WARN: Code duplicated, block: B:132:0x035c  */
    /* JADX WARN: Code duplicated, block: B:135:0x0371  */
    /* JADX WARN: Code duplicated, block: B:138:0x0387  */
    /* JADX WARN: Code duplicated, block: B:144:0x03bc  */
    /* JADX WARN: Code duplicated, block: B:147:0x03c7  */
    /* JADX WARN: Code duplicated, block: B:148:0x03cc  */
    /* JADX WARN: Code duplicated, block: B:150:0x03de  */
    /* JADX WARN: Code duplicated, block: B:151:0x03e1  */
    /* JADX WARN: Code duplicated, block: B:154:0x03ed  */
    /* JADX WARN: Code duplicated, block: B:155:0x03ef  */
    /* JADX WARN: Code duplicated, block: B:157:0x03ff  */
    /* JADX WARN: Code duplicated, block: B:160:0x040a  */
    /* JADX WARN: Code duplicated, block: B:162:0x041c  */
    /* JADX WARN: Code duplicated, block: B:164:0x0420  */
    /* JADX WARN: Code duplicated, block: B:167:0x042d  */
    /* JADX WARN: Code duplicated, block: B:170:0x043d  */
    /* JADX WARN: Code duplicated, block: B:173:0x0456 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:175:0x045a  */
    /* JADX WARN: Code duplicated, block: B:178:0x0460 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:181:0x0465  */
    /* JADX WARN: Code duplicated, block: B:184:0x046c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:188:0x0473  */
    /* JADX WARN: Code duplicated, block: B:194:0x047f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:196:0x0483  */
    /* JADX WARN: Code duplicated, block: B:199:0x048b A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:203:0x0492  */
    /* JADX WARN: Code duplicated, block: B:208:0x04a3 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:211:0x04a9  */
    /* JADX WARN: Code duplicated, block: B:214:0x04b0 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:217:0x04b6  */
    /* JADX WARN: Code duplicated, block: B:220:0x04c7  */
    /* JADX WARN: Code duplicated, block: B:38:0x00df  */
    /* JADX WARN: Code duplicated, block: B:40:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:41:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:43:0x0100  */
    /* JADX WARN: Code duplicated, block: B:47:0x010d  */
    /* JADX WARN: Code duplicated, block: B:50:0x011c  */
    /* JADX WARN: Code duplicated, block: B:53:0x0129 A[LOOP:1: B:51:0x0123->B:53:0x0129, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:58:0x0148  */
    /* JADX WARN: Code duplicated, block: B:59:0x014b  */
    /* JADX WARN: Code duplicated, block: B:62:0x0176  */
    /* JADX WARN: Code duplicated, block: B:63:0x0178  */
    /* JADX WARN: Code duplicated, block: B:66:0x017f  */
    /* JADX WARN: Code duplicated, block: B:67:0x0181  */
    /* JADX WARN: Code duplicated, block: B:70:0x0186  */
    /* JADX WARN: Code duplicated, block: B:73:0x018f  */
    /* JADX WARN: Code duplicated, block: B:74:0x0191  */
    /* JADX WARN: Code duplicated, block: B:76:0x0194  */
    /* JADX WARN: Code duplicated, block: B:78:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:80:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:81:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:83:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:85:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:86:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:88:0x0200  */
    /* JADX WARN: Code duplicated, block: B:90:0x0208  */
    /* JADX WARN: Code duplicated, block: B:91:0x020b  */
    /* JADX WARN: Code duplicated, block: B:93:0x0213  */
    /* JADX WARN: Code duplicated, block: B:94:0x021a  */
    /* JADX WARN: Code duplicated, block: B:97:0x0246  */
    /* JADX WARN: Code duplicated, block: B:98:0x0277  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.google.android.gms.internal.ads.zzbl] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v9, types: [com.google.android.gms.internal.ads.zzbl] */
    /* JADX WARN: Type inference failed for: r8v28, types: [com.google.android.gms.internal.ads.zzbc] */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v20, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void zzag(final zzls zzlsVar, final int i, boolean z, int i2, long j, int i3, boolean z2) {
        int i4;
        boolean z3;
        Pair pair;
        boolean z4;
        boolean z5;
        int i5;
        Pair pair2;
        boolean zBooleanValue;
        final int iIntValue;
        final zzap zzapVar;
        zzar zzarVarZza;
        List list;
        int i6;
        zzav zzavVar;
        int i7;
        zzbl zzblVarZzo;
        zzat zzatVarZzw;
        boolean zEquals;
        boolean z6;
        boolean z7;
        boolean z8;
        zzin zzinVar;
        zzin zzinVar2;
        zzze zzzeVar;
        zzze zzzeVar2;
        zzbd zzbdVar;
        zzg zzgVar;
        zzbl zzblVarZzo2;
        boolean z9;
        zzbl zzblVarZzo3;
        ?? r13;
        int iZzk;
        int i8;
        boolean z10;
        ?? Zzo;
        int iZze;
        ?? r6;
        zzbl zzblVarZzo4;
        long j2;
        ?? r12;
        zzbl zzblVarZzo5;
        ?? r9;
        boolean zZzo;
        ?? r2;
        ?? r3;
        ?? r4;
        ?? r5;
        ?? r10;
        ?? r11;
        ?? r14;
        zzbd zzbdVarZze;
        zzdz zzdzVar;
        zzbj zzbjVar;
        int i9;
        Object obj;
        zzap zzapVar2;
        Object obj2;
        int i10;
        long jZzV;
        long jZzV2;
        int iZze2;
        Object obj3;
        zzap zzapVar3;
        Object obj4;
        int i11;
        long jZzv;
        long jZzv2;
        zzvh zzvhVar;
        final int i12 = i2;
        zzls zzlsVar2 = this.zzU;
        this.zzU = zzlsVar;
        ?? r7 = zzlsVar2.zza;
        zzbl zzblVar = zzlsVar.zza;
        boolean zEquals2 = r7.equals(zzblVar);
        if (!zzblVar.zzo() || !r7.zzo()) {
            if (zzblVar.zzo() != r7.zzo()) {
                pair2 = new Pair(Boolean.TRUE, 3);
            } else {
                zzvh zzvhVar2 = zzlsVar2.zzb;
                Object obj5 = zzvhVar2.zza;
                zzbj zzbjVar2 = this.zzo;
                int i13 = r7.zzn(obj5, zzbjVar2).zzc;
                zzbk zzbkVar = this.zza;
                Object obj6 = r7.zze(i13, zzbkVar, 0L).zzb;
                zzvh zzvhVar3 = zzlsVar.zzb;
                if (obj6.equals(zzblVar.zze(zzblVar.zzn(zzvhVar3.zza, zzbjVar2).zzc, zzbkVar, 0L).zzb)) {
                    if (!z) {
                        i4 = i12;
                        z3 = false;
                    } else if (i12 != 0) {
                        i4 = i12;
                        z3 = true;
                    } else if (zzvhVar2.zzd < zzvhVar3.zzd) {
                        pair = new Pair(Boolean.TRUE, 0);
                        i12 = 0;
                        z4 = true;
                    } else {
                        z3 = true;
                        i4 = 0;
                    }
                    pair = new Pair(Boolean.FALSE, -1);
                    int i14 = i4;
                    z4 = z3;
                    i12 = i14;
                } else {
                    if (z) {
                        if (i12 == 0) {
                            i12 = 0;
                            z4 = true;
                            i5 = 1;
                        } else {
                            z4 = true;
                            z5 = true;
                        }
                        pair = new Pair(Boolean.TRUE, Integer.valueOf(i5));
                    } else {
                        z4 = false;
                        z5 = false;
                    }
                    if (z4 && i12 == 1) {
                        z4 = z5;
                        i5 = 2;
                    } else {
                        if (zEquals2) {
                            throw new IllegalStateException();
                        }
                        i5 = 3;
                    }
                    pair = new Pair(Boolean.TRUE, Integer.valueOf(i5));
                }
            }
            zBooleanValue = ((Boolean) pair.first).booleanValue();
            iIntValue = ((Integer) pair.second).intValue();
            if (zBooleanValue) {
                if (zzblVar.zzo()) {
                    zzapVar = null;
                } else {
                    zzapVar = zzblVar.zze(zzblVar.zzn(zzlsVar.zzb.zza, this.zzo).zzc, this.zza, 0L).zzd;
                }
                this.zzT = zzat.zza;
            } else {
                zzapVar = null;
            }
            if (zBooleanValue || !zzlsVar2.zzj.equals(zzlsVar.zzj)) {
                zzarVarZza = this.zzT.zza();
                list = zzlsVar.zzj;
                for (i6 = 0; i6 < list.size(); i6++) {
                    zzavVar = (zzav) list.get(i6);
                    for (i7 = 0; i7 < zzavVar.zza(); i7++) {
                        zzavVar.zzb(i7).zza(zzarVarZza);
                    }
                }
                this.zzT = zzarVarZza.zzw();
            }
            zzblVarZzo = zzo();
            if (zzblVarZzo.zzo()) {
                zzatVarZzw = this.zzT;
            } else {
                zzap zzapVar4 = zzblVarZzo.zze(zze(), this.zza, 0L).zzd;
                zzar zzarVarZza2 = this.zzT.zza();
                zzarVarZza2.zzb(zzapVar4.zzd);
                zzatVarZzw = zzarVarZza2.zzw();
            }
            zEquals = zzatVarZzw.equals(this.zzI);
            this.zzI = zzatVarZzw;
            if (zzlsVar2.zzl != zzlsVar.zzl) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (zzlsVar2.zze != zzlsVar.zze) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7 || z6) {
                zzah();
            }
            if (zzlsVar2.zzg != zzlsVar.zzg) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (!zEquals2) {
                this.zzm.zzd(0, new zzdw() { // from class: com.google.android.gms.internal.ads.zziz
                    @Override // com.google.android.gms.internal.ads.zzdw
                    public final void zza(Object obj7) {
                        int i15 = zzkh.zzd;
                        ((zzbe) obj7).zzq(zzlsVar.zza, i);
                    }
                });
            }
            if (z4) {
                zzbjVar = new zzbj();
                if (r7.zzo()) {
                    i9 = i3;
                    obj = null;
                    zzapVar2 = null;
                    obj2 = null;
                    i10 = -1;
                } else {
                    Object obj7 = zzlsVar2.zzb.zza;
                    r7.zzn(obj7, zzbjVar);
                    int i15 = zzbjVar.zzc;
                    int iZza = r7.zza(obj7);
                    zzbk zzbkVar2 = this.zza;
                    obj = r7.zze(i15, zzbkVar2, 0L).zzb;
                    zzapVar2 = zzbkVar2.zzd;
                    obj2 = obj7;
                    i9 = i15;
                    i10 = iZza;
                }
                if (i12 == 0) {
                    zzvhVar = zzlsVar2.zzb;
                    if (zzvhVar.zzb()) {
                        jZzV = zzbjVar.zzf(zzvhVar.zzb, zzvhVar.zzc);
                        jZzV2 = zzV(zzlsVar2);
                    } else {
                        if (zzvhVar.zze != -1) {
                            jZzV = zzV(this.zzU);
                        } else {
                            jZzV = zzbjVar.zzd;
                        }
                        jZzV2 = jZzV;
                    }
                } else if (zzlsVar2.zzb.zzb()) {
                    jZzV = zzlsVar2.zzs;
                    jZzV2 = zzV(zzlsVar2);
                } else {
                    jZzV = zzlsVar2.zzs;
                    jZzV2 = jZzV;
                }
                String str = zzex.zza;
                zzvh zzvhVar4 = zzlsVar2.zzb;
                final zzbf zzbfVar = new zzbf(obj, i9, zzapVar2, obj2, i10, zzex.zzv(jZzV), zzex.zzv(jZzV2), zzvhVar4.zzb, zzvhVar4.zzc);
                iZze2 = zze();
                if (this.zzU.zza.zzo()) {
                    obj3 = null;
                    zzapVar3 = null;
                    obj4 = null;
                    i11 = -1;
                } else {
                    zzls zzlsVar3 = this.zzU;
                    Object obj8 = zzlsVar3.zzb.zza;
                    zzlsVar3.zza.zzn(obj8, this.zzo);
                    int iZza2 = this.zzU.zza.zza(obj8);
                    zzbl zzblVar2 = this.zzU.zza;
                    zzbk zzbkVar3 = this.zza;
                    i11 = iZza2;
                    obj3 = zzblVar2.zze(iZze2, zzbkVar3, 0L).zzb;
                    zzapVar3 = zzbkVar3.zzd;
                    obj4 = obj8;
                }
                jZzv = zzex.zzv(j);
                if (this.zzU.zzb.zzb()) {
                    jZzv2 = zzex.zzv(zzV(this.zzU));
                } else {
                    jZzv2 = jZzv;
                }
                zzvh zzvhVar5 = this.zzU.zzb;
                final zzbf zzbfVar2 = new zzbf(obj3, iZze2, zzapVar3, obj4, i11, jZzv, jZzv2, zzvhVar5.zzb, zzvhVar5.zzc);
                this.zzm.zzd(11, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjs
                    @Override // com.google.android.gms.internal.ads.zzdw
                    public final void zza(Object obj9) {
                        int i16 = zzkh.zzd;
                        ((zzbe) obj9).zzn(zzbfVar, zzbfVar2, i12);
                    }
                });
            } else {
                z6 = z6;
                zEquals = zEquals;
                z7 = z7;
                z8 = z8;
            }
            if (zBooleanValue) {
                this.zzm.zzd(1, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjt
                    @Override // com.google.android.gms.internal.ads.zzdw
                    public final void zza(Object obj9) {
                        int i16 = zzkh.zzd;
                        ((zzbe) obj9).zze(zzapVar, iIntValue);
                    }
                });
            }
            zzinVar = zzlsVar2.zzf;
            zzinVar2 = zzlsVar.zzf;
            if (zzinVar != zzinVar2) {
                zzdzVar = this.zzm;
                zzdzVar.zzd(10, new zzdw() { // from class: com.google.android.gms.internal.ads.zzju
                    @Override // com.google.android.gms.internal.ads.zzdw
                    public final void zza(Object obj9) {
                        int i16 = zzkh.zzd;
                        ((zzbe) obj9).zzl(zzlsVar.zzf);
                    }
                });
                if (zzinVar2 != null) {
                    zzdzVar.zzd(10, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjv
                        @Override // com.google.android.gms.internal.ads.zzdw
                        public final void zza(Object obj9) {
                            int i16 = zzkh.zzd;
                            ((zzbe) obj9).zzk(zzlsVar.zzf);
                        }
                    });
                }
            }
            zzzeVar = zzlsVar2.zzi;
            zzzeVar2 = zzlsVar.zzi;
            if (zzzeVar != zzzeVar2) {
                this.zzj.zzp(zzzeVar2.zze);
                this.zzm.zzd(2, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjw
                    @Override // com.google.android.gms.internal.ads.zzdw
                    public final void zza(Object obj9) {
                        int i16 = zzkh.zzd;
                        ((zzbe) obj9).zzr(zzlsVar.zzi.zzd);
                    }
                });
            }
            if (!zEquals) {
                final zzat zzatVar = this.zzI;
                this.zzm.zzd(14, new zzdw() { // from class: com.google.android.gms.internal.ads.zzja
                    @Override // com.google.android.gms.internal.ads.zzdw
                    public final void zza(Object obj9) {
                        int i16 = zzkh.zzd;
                        ((zzbe) obj9).zzf(zzatVar);
                    }
                });
            }
            if (z8) {
                this.zzm.zzd(3, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjb
                    @Override // com.google.android.gms.internal.ads.zzdw
                    public final void zza(Object obj9) {
                        int i16 = zzkh.zzd;
                        ((zzbe) obj9).zzc(zzlsVar.zzg);
                    }
                });
            }
            if (z7 || z6) {
                this.zzm.zzd(-1, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjc
                    @Override // com.google.android.gms.internal.ads.zzdw
                    public final void zza(Object obj9) {
                        int i16 = zzkh.zzd;
                        zzls zzlsVar4 = zzlsVar;
                        ((zzbe) obj9).zzm(zzlsVar4.zzl, zzlsVar4.zze);
                    }
                });
            }
            if (z7) {
                this.zzm.zzd(4, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjd
                    @Override // com.google.android.gms.internal.ads.zzdw
                    public final void zza(Object obj9) {
                        int i16 = zzkh.zzd;
                        ((zzbe) obj9).zzi(zzlsVar.zze);
                    }
                });
            }
            if (z6 || zzlsVar2.zzm != zzlsVar.zzm) {
                this.zzm.zzd(5, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjh
                    @Override // com.google.android.gms.internal.ads.zzdw
                    public final void zza(Object obj9) {
                        int i16 = zzkh.zzd;
                        zzls zzlsVar4 = zzlsVar;
                        ((zzbe) obj9).zzg(zzlsVar4.zzl, zzlsVar4.zzm);
                    }
                });
            }
            if (zzlsVar2.zzn != zzlsVar.zzn) {
                this.zzm.zzd(6, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjn
                    @Override // com.google.android.gms.internal.ads.zzdw
                    public final void zza(Object obj9) {
                        int i16 = zzkh.zzd;
                        ((zzbe) obj9).zzj(zzlsVar.zzn);
                    }
                });
            }
            if (zzlsVar2.zzj() != zzlsVar.zzj()) {
                this.zzm.zzd(7, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjq
                    @Override // com.google.android.gms.internal.ads.zzdw
                    public final void zza(Object obj9) {
                        int i16 = zzkh.zzd;
                        ((zzbe) obj9).zzd(zzlsVar.zzj());
                    }
                });
            }
            if (!zzlsVar2.zzo.equals(zzlsVar.zzo)) {
                this.zzm.zzd(12, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjr
                    @Override // com.google.android.gms.internal.ads.zzdw
                    public final void zza(Object obj9) {
                        int i16 = zzkh.zzd;
                        ((zzbe) obj9).zzh(zzlsVar.zzo);
                    }
                });
            }
            zzbdVar = this.zzH;
            zzbh zzbhVar = this.zzg;
            zzbd zzbdVar2 = this.zzc;
            String str2 = zzex.zza;
            boolean zZzx = zzbhVar.zzx();
            zzgVar = (zzg) zzbhVar;
            zzblVarZzo2 = zzgVar.zzo();
            if (zzblVarZzo2.zzo() && zzblVarZzo2.zze(zzgVar.zze(), zzgVar.zza, 0L).zzh) {
                z9 = true;
            } else {
                z9 = false;
            }
            zzblVarZzo3 = zzgVar.zzo();
            if (zzblVarZzo3.zzo()) {
                i8 = -1;
                r13 = 0;
                z10 = false;
            } else {
                int iZze3 = zzgVar.zze();
                zzgVar.zzi();
                zzgVar.zzw();
                r13 = 0;
                r13 = 0;
                iZzk = zzblVarZzo3.zzk(iZze3, 0, false);
                i8 = -1;
                if (iZzk != -1) {
                    z10 = true;
                } else {
                    z10 = false;
                }
            }
            Zzo = zzgVar.zzo();
            if (Zzo.zzo()) {
                r6 = r13;
            } else {
                iZze = zzgVar.zze();
                zzgVar.zzi();
                zzgVar.zzw();
                if (Zzo.zzj(iZze, r13, r13) != i8) {
                    r6 = 1;
                } else {
                    r6 = r13;
                }
            }
            zzblVarZzo4 = zzgVar.zzo();
            if (!zzblVarZzo4.zzo()) {
                j2 = 0;
                if (zzblVarZzo4.zze(zzgVar.zze(), zzgVar.zza, 0L).zzb()) {
                    r12 = 1;
                }
                zzblVarZzo5 = zzgVar.zzo();
                if (zzblVarZzo5.zzo() && zzblVarZzo5.zze(zzgVar.zze(), zzgVar.zza, j2).zzi) {
                    r9 = 1;
                } else {
                    r9 = r13;
                }
                zZzo = zzbhVar.zzo().zzo();
                ?? zzbcVar = new zzbc();
                zzbcVar.zzb(zzbdVar2);
                boolean z11 = !zZzx;
                zzbcVar.zzd(4, z11);
                if (z9 || zZzx) {
                    r2 = r13;
                } else {
                    r2 = 1;
                }
                zzbcVar.zzd(5, r2);
                if (z10 || zZzx) {
                    r3 = r13;
                } else {
                    r3 = 1;
                }
                zzbcVar.zzd(6, r3);
                if (!zZzo || (!(z10 || r12 == 0 || z9) || zZzx)) {
                    r4 = r13;
                } else {
                    r4 = 1;
                }
                zzbcVar.zzd(7, r4);
                if (r6 != 0 || zZzx) {
                    r5 = r13;
                } else {
                    r5 = 1;
                }
                zzbcVar.zzd(8, r5);
                if (!zZzo || ((r6 == 0 && (r12 == 0 || r9 == 0)) || zZzx)) {
                    r10 = r13;
                } else {
                    r10 = 1;
                }
                zzbcVar.zzd(9, r10);
                zzbcVar.zzd(10, z11);
                if (z9 || zZzx) {
                    r11 = r13;
                } else {
                    r11 = 1;
                }
                zzbcVar.zzd(11, r11);
                if (z9 || zZzx) {
                    r14 = r13;
                } else {
                    r14 = 1;
                }
                zzbcVar.zzd(12, r14);
                zzbdVarZze = zzbcVar.zze();
                this.zzH = zzbdVarZze;
                if (!zzbdVarZze.equals(zzbdVar)) {
                    this.zzm.zzd(13, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjp
                        @Override // com.google.android.gms.internal.ads.zzdw
                        public final void zza(Object obj9) {
                            ((zzbe) obj9).zzb(this.zza.zzH);
                        }
                    });
                }
                this.zzm.zzc();
            }
            j2 = 0;
            r12 = r13;
            zzblVarZzo5 = zzgVar.zzo();
            if (zzblVarZzo5.zzo()) {
                r9 = r13;
            } else {
                r9 = r13;
            }
            zZzo = zzbhVar.zzo().zzo();
            ?? zzbcVar2 = new zzbc();
            zzbcVar2.zzb(zzbdVar2);
            boolean z12 = !zZzx;
            zzbcVar2.zzd(4, z12);
            if (z9) {
                r2 = r13;
            } else {
                r2 = r13;
            }
            zzbcVar2.zzd(5, r2);
            if (z10) {
                r3 = r13;
            } else {
                r3 = r13;
            }
            zzbcVar2.zzd(6, r3);
            if (zZzo) {
                r4 = r13;
            } else {
                r4 = r13;
            }
            zzbcVar2.zzd(7, r4);
            if (r6 != 0) {
                r5 = r13;
            } else {
                r5 = r13;
            }
            zzbcVar2.zzd(8, r5);
            if (zZzo) {
                r10 = r13;
            } else {
                r10 = r13;
            }
            zzbcVar2.zzd(9, r10);
            zzbcVar2.zzd(10, z12);
            if (z9) {
                r11 = r13;
            } else {
                r11 = r13;
            }
            zzbcVar2.zzd(11, r11);
            if (z9) {
                r14 = r13;
            } else {
                r14 = r13;
            }
            zzbcVar2.zzd(12, r14);
            zzbdVarZze = zzbcVar2.zze();
            this.zzH = zzbdVarZze;
            if (!zzbdVarZze.equals(zzbdVar)) {
                this.zzm.zzd(13, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjp
                    @Override // com.google.android.gms.internal.ads.zzdw
                    public final void zza(Object obj9) {
                        ((zzbe) obj9).zzb(this.zza.zzH);
                    }
                });
            }
            this.zzm.zzc();
        }
        pair2 = new Pair(Boolean.FALSE, -1);
        pair = pair2;
        z4 = z;
        zBooleanValue = ((Boolean) pair.first).booleanValue();
        iIntValue = ((Integer) pair.second).intValue();
        if (zBooleanValue) {
            if (zzblVar.zzo()) {
                zzapVar = zzblVar.zze(zzblVar.zzn(zzlsVar.zzb.zza, this.zzo).zzc, this.zza, 0L).zzd;
            } else {
                zzapVar = null;
            }
            this.zzT = zzat.zza;
        } else {
            zzapVar = null;
        }
        if (zBooleanValue) {
            zzarVarZza = this.zzT.zza();
            list = zzlsVar.zzj;
            while (i6 < list.size()) {
                zzavVar = (zzav) list.get(i6);
                while (i7 < zzavVar.zza()) {
                    zzavVar.zzb(i7).zza(zzarVarZza);
                }
            }
            this.zzT = zzarVarZza.zzw();
        } else {
            zzarVarZza = this.zzT.zza();
            list = zzlsVar.zzj;
            while (i6 < list.size()) {
                zzavVar = (zzav) list.get(i6);
                while (i7 < zzavVar.zza()) {
                    zzavVar.zzb(i7).zza(zzarVarZza);
                }
            }
            this.zzT = zzarVarZza.zzw();
        }
        zzblVarZzo = zzo();
        if (zzblVarZzo.zzo()) {
            zzatVarZzw = this.zzT;
        } else {
            zzap zzapVar5 = zzblVarZzo.zze(zze(), this.zza, 0L).zzd;
            zzar zzarVarZza3 = this.zzT.zza();
            zzarVarZza3.zzb(zzapVar5.zzd);
            zzatVarZzw = zzarVarZza3.zzw();
        }
        zEquals = zzatVarZzw.equals(this.zzI);
        this.zzI = zzatVarZzw;
        if (zzlsVar2.zzl != zzlsVar.zzl) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (zzlsVar2.zze != zzlsVar.zze) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            zzah();
        } else {
            zzah();
        }
        if (zzlsVar2.zzg != zzlsVar.zzg) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (!zEquals2) {
            this.zzm.zzd(0, new zzdw() { // from class: com.google.android.gms.internal.ads.zziz
                @Override // com.google.android.gms.internal.ads.zzdw
                public final void zza(Object obj9) {
                    int i16 = zzkh.zzd;
                    ((zzbe) obj9).zzq(zzlsVar.zza, i);
                }
            });
        }
        if (z4) {
            zzbjVar = new zzbj();
            if (r7.zzo()) {
                Object obj9 = zzlsVar2.zzb.zza;
                r7.zzn(obj9, zzbjVar);
                int i16 = zzbjVar.zzc;
                int iZza3 = r7.zza(obj9);
                zzbk zzbkVar4 = this.zza;
                obj = r7.zze(i16, zzbkVar4, 0L).zzb;
                zzapVar2 = zzbkVar4.zzd;
                obj2 = obj9;
                i9 = i16;
                i10 = iZza3;
            } else {
                i9 = i3;
                obj = null;
                zzapVar2 = null;
                obj2 = null;
                i10 = -1;
            }
            if (i12 == 0) {
                zzvhVar = zzlsVar2.zzb;
                if (zzvhVar.zzb()) {
                    jZzV = zzbjVar.zzf(zzvhVar.zzb, zzvhVar.zzc);
                    jZzV2 = zzV(zzlsVar2);
                } else {
                    if (zzvhVar.zze != -1) {
                        jZzV = zzV(this.zzU);
                    } else {
                        jZzV = zzbjVar.zzd;
                    }
                    jZzV2 = jZzV;
                }
            } else if (zzlsVar2.zzb.zzb()) {
                jZzV = zzlsVar2.zzs;
                jZzV2 = zzV(zzlsVar2);
            } else {
                jZzV = zzlsVar2.zzs;
                jZzV2 = jZzV;
            }
            String str3 = zzex.zza;
            zzvh zzvhVar6 = zzlsVar2.zzb;
            final zzbf zzbfVar3 = new zzbf(obj, i9, zzapVar2, obj2, i10, zzex.zzv(jZzV), zzex.zzv(jZzV2), zzvhVar6.zzb, zzvhVar6.zzc);
            iZze2 = zze();
            if (this.zzU.zza.zzo()) {
                zzls zzlsVar4 = this.zzU;
                Object obj10 = zzlsVar4.zzb.zza;
                zzlsVar4.zza.zzn(obj10, this.zzo);
                int iZza4 = this.zzU.zza.zza(obj10);
                zzbl zzblVar3 = this.zzU.zza;
                zzbk zzbkVar5 = this.zza;
                i11 = iZza4;
                obj3 = zzblVar3.zze(iZze2, zzbkVar5, 0L).zzb;
                zzapVar3 = zzbkVar5.zzd;
                obj4 = obj10;
            } else {
                obj3 = null;
                zzapVar3 = null;
                obj4 = null;
                i11 = -1;
            }
            jZzv = zzex.zzv(j);
            if (this.zzU.zzb.zzb()) {
                jZzv2 = zzex.zzv(zzV(this.zzU));
            } else {
                jZzv2 = jZzv;
            }
            zzvh zzvhVar7 = this.zzU.zzb;
            final zzbf zzbfVar4 = new zzbf(obj3, iZze2, zzapVar3, obj4, i11, jZzv, jZzv2, zzvhVar7.zzb, zzvhVar7.zzc);
            this.zzm.zzd(11, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjs
                @Override // com.google.android.gms.internal.ads.zzdw
                public final void zza(Object obj11) {
                    int i17 = zzkh.zzd;
                    ((zzbe) obj11).zzn(zzbfVar3, zzbfVar4, i12);
                }
            });
        } else {
            z6 = z6;
            zEquals = zEquals;
            z7 = z7;
            z8 = z8;
        }
        if (zBooleanValue) {
            this.zzm.zzd(1, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjt
                @Override // com.google.android.gms.internal.ads.zzdw
                public final void zza(Object obj11) {
                    int i17 = zzkh.zzd;
                    ((zzbe) obj11).zze(zzapVar, iIntValue);
                }
            });
        }
        zzinVar = zzlsVar2.zzf;
        zzinVar2 = zzlsVar.zzf;
        if (zzinVar != zzinVar2) {
            zzdzVar = this.zzm;
            zzdzVar.zzd(10, new zzdw() { // from class: com.google.android.gms.internal.ads.zzju
                @Override // com.google.android.gms.internal.ads.zzdw
                public final void zza(Object obj11) {
                    int i17 = zzkh.zzd;
                    ((zzbe) obj11).zzl(zzlsVar.zzf);
                }
            });
            if (zzinVar2 != null) {
                zzdzVar.zzd(10, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjv
                    @Override // com.google.android.gms.internal.ads.zzdw
                    public final void zza(Object obj11) {
                        int i17 = zzkh.zzd;
                        ((zzbe) obj11).zzk(zzlsVar.zzf);
                    }
                });
            }
        }
        zzzeVar = zzlsVar2.zzi;
        zzzeVar2 = zzlsVar.zzi;
        if (zzzeVar != zzzeVar2) {
            this.zzj.zzp(zzzeVar2.zze);
            this.zzm.zzd(2, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjw
                @Override // com.google.android.gms.internal.ads.zzdw
                public final void zza(Object obj11) {
                    int i17 = zzkh.zzd;
                    ((zzbe) obj11).zzr(zzlsVar.zzi.zzd);
                }
            });
        }
        if (!zEquals) {
            final zzat zzatVar2 = this.zzI;
            this.zzm.zzd(14, new zzdw() { // from class: com.google.android.gms.internal.ads.zzja
                @Override // com.google.android.gms.internal.ads.zzdw
                public final void zza(Object obj11) {
                    int i17 = zzkh.zzd;
                    ((zzbe) obj11).zzf(zzatVar2);
                }
            });
        }
        if (z8) {
            this.zzm.zzd(3, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjb
                @Override // com.google.android.gms.internal.ads.zzdw
                public final void zza(Object obj11) {
                    int i17 = zzkh.zzd;
                    ((zzbe) obj11).zzc(zzlsVar.zzg);
                }
            });
        }
        if (z7) {
            this.zzm.zzd(-1, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjc
                @Override // com.google.android.gms.internal.ads.zzdw
                public final void zza(Object obj11) {
                    int i17 = zzkh.zzd;
                    zzls zzlsVar5 = zzlsVar;
                    ((zzbe) obj11).zzm(zzlsVar5.zzl, zzlsVar5.zze);
                }
            });
        } else {
            this.zzm.zzd(-1, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjc
                @Override // com.google.android.gms.internal.ads.zzdw
                public final void zza(Object obj11) {
                    int i17 = zzkh.zzd;
                    zzls zzlsVar5 = zzlsVar;
                    ((zzbe) obj11).zzm(zzlsVar5.zzl, zzlsVar5.zze);
                }
            });
        }
        if (z7) {
            this.zzm.zzd(4, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjd
                @Override // com.google.android.gms.internal.ads.zzdw
                public final void zza(Object obj11) {
                    int i17 = zzkh.zzd;
                    ((zzbe) obj11).zzi(zzlsVar.zze);
                }
            });
        }
        if (z6) {
            this.zzm.zzd(5, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjh
                @Override // com.google.android.gms.internal.ads.zzdw
                public final void zza(Object obj11) {
                    int i17 = zzkh.zzd;
                    zzls zzlsVar5 = zzlsVar;
                    ((zzbe) obj11).zzg(zzlsVar5.zzl, zzlsVar5.zzm);
                }
            });
        } else {
            this.zzm.zzd(5, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjh
                @Override // com.google.android.gms.internal.ads.zzdw
                public final void zza(Object obj11) {
                    int i17 = zzkh.zzd;
                    zzls zzlsVar5 = zzlsVar;
                    ((zzbe) obj11).zzg(zzlsVar5.zzl, zzlsVar5.zzm);
                }
            });
        }
        if (zzlsVar2.zzn != zzlsVar.zzn) {
            this.zzm.zzd(6, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjn
                @Override // com.google.android.gms.internal.ads.zzdw
                public final void zza(Object obj11) {
                    int i17 = zzkh.zzd;
                    ((zzbe) obj11).zzj(zzlsVar.zzn);
                }
            });
        }
        if (zzlsVar2.zzj() != zzlsVar.zzj()) {
            this.zzm.zzd(7, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjq
                @Override // com.google.android.gms.internal.ads.zzdw
                public final void zza(Object obj11) {
                    int i17 = zzkh.zzd;
                    ((zzbe) obj11).zzd(zzlsVar.zzj());
                }
            });
        }
        if (!zzlsVar2.zzo.equals(zzlsVar.zzo)) {
            this.zzm.zzd(12, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjr
                @Override // com.google.android.gms.internal.ads.zzdw
                public final void zza(Object obj11) {
                    int i17 = zzkh.zzd;
                    ((zzbe) obj11).zzh(zzlsVar.zzo);
                }
            });
        }
        zzbdVar = this.zzH;
        zzbh zzbhVar2 = this.zzg;
        zzbd zzbdVar3 = this.zzc;
        String str4 = zzex.zza;
        boolean zZzx2 = zzbhVar2.zzx();
        zzgVar = (zzg) zzbhVar2;
        zzblVarZzo2 = zzgVar.zzo();
        if (zzblVarZzo2.zzo()) {
            z9 = false;
        } else {
            z9 = false;
        }
        zzblVarZzo3 = zzgVar.zzo();
        if (zzblVarZzo3.zzo()) {
            i8 = -1;
            r13 = 0;
            z10 = false;
        } else {
            int iZze4 = zzgVar.zze();
            zzgVar.zzi();
            zzgVar.zzw();
            r13 = 0;
            r13 = 0;
            iZzk = zzblVarZzo3.zzk(iZze4, 0, false);
            i8 = -1;
            if (iZzk != -1) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        Zzo = zzgVar.zzo();
        if (Zzo.zzo()) {
            r6 = r13;
        } else {
            iZze = zzgVar.zze();
            zzgVar.zzi();
            zzgVar.zzw();
            if (Zzo.zzj(iZze, r13, r13) != i8) {
                r6 = 1;
            } else {
                r6 = r13;
            }
        }
        zzblVarZzo4 = zzgVar.zzo();
        if (!zzblVarZzo4.zzo()) {
            j2 = 0;
            if (zzblVarZzo4.zze(zzgVar.zze(), zzgVar.zza, 0L).zzb()) {
                r12 = 1;
            }
            zzblVarZzo5 = zzgVar.zzo();
            if (zzblVarZzo5.zzo()) {
                r9 = r13;
            } else {
                r9 = r13;
            }
            zZzo = zzbhVar2.zzo().zzo();
            ?? zzbcVar3 = new zzbc();
            zzbcVar3.zzb(zzbdVar3);
            boolean z13 = !zZzx2;
            zzbcVar3.zzd(4, z13);
            if (z9) {
                r2 = r13;
            } else {
                r2 = r13;
            }
            zzbcVar3.zzd(5, r2);
            if (z10) {
                r3 = r13;
            } else {
                r3 = r13;
            }
            zzbcVar3.zzd(6, r3);
            if (zZzo) {
                r4 = r13;
            } else {
                r4 = r13;
            }
            zzbcVar3.zzd(7, r4);
            if (r6 != 0) {
                r5 = r13;
            } else {
                r5 = r13;
            }
            zzbcVar3.zzd(8, r5);
            if (zZzo) {
                r10 = r13;
            } else {
                r10 = r13;
            }
            zzbcVar3.zzd(9, r10);
            zzbcVar3.zzd(10, z13);
            if (z9) {
                r11 = r13;
            } else {
                r11 = r13;
            }
            zzbcVar3.zzd(11, r11);
            if (z9) {
                r14 = r13;
            } else {
                r14 = r13;
            }
            zzbcVar3.zzd(12, r14);
            zzbdVarZze = zzbcVar3.zze();
            this.zzH = zzbdVarZze;
            if (!zzbdVarZze.equals(zzbdVar)) {
                this.zzm.zzd(13, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjp
                    @Override // com.google.android.gms.internal.ads.zzdw
                    public final void zza(Object obj11) {
                        ((zzbe) obj11).zzb(this.zza.zzH);
                    }
                });
            }
            this.zzm.zzc();
        }
        j2 = 0;
        r12 = r13;
        zzblVarZzo5 = zzgVar.zzo();
        if (zzblVarZzo5.zzo()) {
            r9 = r13;
        } else {
            r9 = r13;
        }
        zZzo = zzbhVar2.zzo().zzo();
        ?? zzbcVar4 = new zzbc();
        zzbcVar4.zzb(zzbdVar3);
        boolean z14 = !zZzx2;
        zzbcVar4.zzd(4, z14);
        if (z9) {
            r2 = r13;
        } else {
            r2 = r13;
        }
        zzbcVar4.zzd(5, r2);
        if (z10) {
            r3 = r13;
        } else {
            r3 = r13;
        }
        zzbcVar4.zzd(6, r3);
        if (zZzo) {
            r4 = r13;
        } else {
            r4 = r13;
        }
        zzbcVar4.zzd(7, r4);
        if (r6 != 0) {
            r5 = r13;
        } else {
            r5 = r13;
        }
        zzbcVar4.zzd(8, r5);
        if (zZzo) {
            r10 = r13;
        } else {
            r10 = r13;
        }
        zzbcVar4.zzd(9, r10);
        zzbcVar4.zzd(10, z14);
        if (z9) {
            r11 = r13;
        } else {
            r11 = r13;
        }
        zzbcVar4.zzd(11, r11);
        if (z9) {
            r14 = r13;
        } else {
            r14 = r13;
        }
        zzbcVar4.zzd(12, r14);
        zzbdVarZze = zzbcVar4.zze();
        this.zzH = zzbdVarZze;
        if (!zzbdVarZze.equals(zzbdVar)) {
            this.zzm.zzd(13, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjp
                @Override // com.google.android.gms.internal.ads.zzdw
                public final void zza(Object obj11) {
                    ((zzbe) obj11).zzb(this.zza.zzH);
                }
            });
        }
        this.zzm.zzc();
    }

    private final void zzah() {
        int iZzg = zzg();
        if (iZzg != 2 && iZzg != 3) {
            this.zzx.zza(false);
            this.zzy.zza(false);
        } else {
            zzai();
            boolean z = this.zzU.zzp;
            this.zzx.zza(zzv());
            this.zzy.zza(zzv());
        }
    }

    private final void zzai() {
        this.zze.zzb();
        Looper looper = this.zzs;
        if (Thread.currentThread() != looper.getThread()) {
            String name = Thread.currentThread().getName();
            String name2 = looper.getThread().getName();
            String str = zzex.zza;
            Locale locale = Locale.US;
            String strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m("Player is accessed on the wrong thread.\nCurrent thread: '", name, "'\nExpected thread: '", name2, "'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread");
            if (this.zzQ) {
                throw new IllegalStateException(strM);
            }
            zzea.zzg("ExoPlayerImpl", strM, this.zzR ? null : new IllegalStateException());
            this.zzR = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zziy
    public final void zzB(zzmr zzmrVar) {
        zzai();
        this.zzr.zzS(zzmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zziy
    public final void zzC(zzvj zzvjVar) {
        zzai();
        List listSingletonList = Collections.singletonList(zzvjVar);
        zzai();
        zzai();
        zzS(this.zzU);
        zzl();
        this.zzB++;
        List list = this.zzp;
        if (!list.isEmpty()) {
            int size = list.size();
            for (int i = size - 1; i >= 0; i--) {
                list.remove(i);
            }
            this.zzY = this.zzY.zzh(0, size);
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < listSingletonList.size(); i2++) {
            zzlp zzlpVar = new zzlp((zzvj) listSingletonList.get(i2), this.zzq);
            arrayList.add(zzlpVar);
            list.add(i2, new zzkf(zzlpVar.zzb, zzlpVar.zza));
        }
        this.zzY = this.zzY.zzg(0, arrayList.size());
        zzly zzlyVar = new zzly(list, this.zzY);
        if (!zzlyVar.zzo() && zzlyVar.zzc() < 0) {
            throw new zzaa(zzlyVar, -1, -9223372036854775807L);
        }
        int iZzg = zzlyVar.zzg(false);
        zzls zzlsVarZzZ = zzZ(this.zzU, zzlyVar, zzX(zzlyVar, iZzg, -9223372036854775807L));
        int i3 = zzlsVarZzZ.zze;
        if (iZzg != -1 && i3 != 1) {
            i3 = 4;
            if (!zzlyVar.zzo() && iZzg < zzlyVar.zzc()) {
                i3 = 2;
            }
        }
        zzls zzlsVarZzY = zzY(zzlsVarZzZ, i3);
        this.zzl.zzy(arrayList, iZzg, zzex.zzs(-9223372036854775807L), this.zzY);
        zzag(zzlsVarZzY, 0, (this.zzU.zzb.zza.equals(zzlsVarZzY.zzb.zza) || this.zzU.zza.zzo()) ? false : true, 4, zzU(zzlsVarZzY), -1, false);
    }

    public final zzin zzF() {
        zzai();
        return this.zzU.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzg
    public final void zzb(int i, long j, int i2, boolean z) {
        zzai();
        if (i == -1) {
            return;
        }
        zzdd.zzd(i >= 0);
        zzbl zzblVar = this.zzU.zza;
        if (zzblVar.zzo() || i < zzblVar.zzc()) {
            this.zzr.zzv();
            this.zzB++;
            if (zzx()) {
                zzea.zzf("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                zzkq zzkqVar = new zzkq(this.zzU);
                zzkqVar.zza(1);
                this.zzX.zza.zzab(zzkqVar);
                return;
            }
            zzls zzlsVarZzY = this.zzU;
            int i3 = zzlsVarZzY.zze;
            if (i3 == 3 || (i3 == 4 && !zzblVar.zzo())) {
                zzlsVarZzY = zzY(this.zzU, 2);
            }
            int iZze = zze();
            zzls zzlsVarZzZ = zzZ(zzlsVarZzY, zzblVar, zzX(zzblVar, i, j));
            this.zzl.zzo(zzblVar, i, zzex.zzs(j));
            zzag(zzlsVarZzZ, 0, true, 1, zzU(zzlsVarZzZ), iZze, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final int zzc() {
        zzai();
        if (zzx()) {
            return this.zzU.zzb.zzb;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final int zzd() {
        zzai();
        if (zzx()) {
            return this.zzU.zzb.zzc;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final int zze() {
        zzai();
        int iZzS = zzS(this.zzU);
        if (iZzS == -1) {
            return 0;
        }
        return iZzS;
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final int zzf() {
        zzai();
        if (this.zzU.zza.zzo()) {
            return 0;
        }
        zzls zzlsVar = this.zzU;
        return zzlsVar.zza.zza(zzlsVar.zzb.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final int zzg() {
        zzai();
        return this.zzU.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final int zzh() {
        zzai();
        return this.zzU.zzn;
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final int zzi() {
        zzai();
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final long zzj() {
        zzai();
        if (zzx()) {
            zzls zzlsVar = this.zzU;
            return zzlsVar.zzk.equals(zzlsVar.zzb) ? zzex.zzv(this.zzU.zzq) : zzm();
        }
        zzai();
        if (this.zzU.zza.zzo()) {
            return this.zzW;
        }
        zzls zzlsVar2 = this.zzU;
        long j = 0;
        if (zzlsVar2.zzk.zzd != zzlsVar2.zzb.zzd) {
            return zzex.zzv(zzlsVar2.zza.zze(zze(), this.zza, 0L).zzm);
        }
        long j2 = zzlsVar2.zzq;
        if (this.zzU.zzk.zzb()) {
            zzls zzlsVar3 = this.zzU;
            zzlsVar3.zza.zzn(zzlsVar3.zzk.zza, this.zzo).zzg(this.zzU.zzk.zzb);
        } else {
            j = j2;
        }
        zzls zzlsVar4 = this.zzU;
        zzW(zzlsVar4.zza, zzlsVar4.zzk, j);
        return zzex.zzv(j);
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final long zzk() {
        zzai();
        return zzT(this.zzU);
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final long zzl() {
        zzai();
        return zzex.zzv(zzU(this.zzU));
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final long zzm() {
        zzai();
        if (!zzx()) {
            zzbl zzblVarZzo = zzo();
            if (zzblVarZzo.zzo()) {
                return -9223372036854775807L;
            }
            return zzex.zzv(zzblVarZzo.zze(zze(), this.zza, 0L).zzm);
        }
        zzls zzlsVar = this.zzU;
        zzvh zzvhVar = zzlsVar.zzb;
        zzbl zzblVar = zzlsVar.zza;
        Object obj = zzvhVar.zza;
        zzbj zzbjVar = this.zzo;
        zzblVar.zzn(obj, zzbjVar);
        return zzex.zzv(zzbjVar.zzf(zzvhVar.zzb, zzvhVar.zzc));
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final long zzn() {
        zzai();
        return zzex.zzv(this.zzU.zzr);
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final zzbl zzo() {
        zzai();
        return this.zzU.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final zzbt zzp() {
        zzai();
        return this.zzU.zzi.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final void zzq() {
        zzai();
        zzls zzlsVar = this.zzU;
        if (zzlsVar.zze != 1) {
            return;
        }
        zzls zzlsVarZze = zzlsVar.zze(null);
        zzls zzlsVarZzY = zzY(zzlsVarZze, true != zzlsVarZze.zza.zzo() ? 2 : 4);
        this.zzB++;
        this.zzl.zzn();
        zzag(zzlsVarZzY, 1, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final void zzr(boolean z) {
        zzai();
        zzls zzlsVar = this.zzU;
        int i = zzlsVar.zzn;
        int i2 = 0;
        if (i == 1) {
            if (z) {
                i = 1;
            } else {
                i = 1;
                i2 = 1;
            }
        }
        if (zzlsVar.zzl == z && i == i2 && zzlsVar.zzm == 1) {
            return;
        }
        this.zzB++;
        zzls zzlsVarZzd = zzlsVar.zzd(z, 1, i2);
        this.zzl.zzr(z, 1, i2);
        zzag(zzlsVarZzd, 0, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final void zzs(Surface surface) {
        zzai();
        zzae(surface);
        int i = surface == null ? 0 : -1;
        zzac(i, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final void zzt(float f) {
        zzai();
        String str = zzex.zza;
        final float fMax = Math.max(0.0f, Math.min(f, 1.0f));
        if (this.zzO == fMax) {
            return;
        }
        this.zzO = fMax;
        this.zzl.zzt(fMax);
        zzdz zzdzVar = this.zzm;
        zzdzVar.zzd(22, new zzdw() { // from class: com.google.android.gms.internal.ads.zzje
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
                int i = zzkh.zzd;
                ((zzbe) obj).zzt(fMax);
            }
        });
        zzdzVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final void zzu() {
        zzai();
        zzaf(null);
        new zzcw(zzfyq.zzn(), this.zzU.zzs);
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final boolean zzv() {
        zzai();
        return this.zzU.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final boolean zzw() {
        zzai();
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final boolean zzx() {
        zzai();
        return this.zzU.zzb.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zziy
    public final int zzy() {
        zzai();
        int length = this.zzh.length;
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.zziy
    public final void zzz(zzmr zzmrVar) {
        this.zzr.zzu(zzmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zziy
    public final void zzA() {
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str = zzex.zza;
        String strZza = zzaq.zza();
        StringBuilder sbM22m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m22m("Release ", hexString, " [AndroidXMedia3/1.8.0-alpha01] [", str, PZmDzEagKNdW.eDdnWDkSsZHrj);
        sbM22m.append(strZza);
        sbM22m.append("]");
        zzea.zze("ExoPlayerImpl", sbM22m.toString());
        zzai();
        this.zzx.zza(false);
        this.zzy.zza(false);
        if (!this.zzl.zzw()) {
            zzdz zzdzVar = this.zzm;
            zzdzVar.zzd(10, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjg
                @Override // com.google.android.gms.internal.ads.zzdw
                public final void zza(Object obj) {
                    int i = zzkh.zzd;
                    ((zzbe) obj).zzk(zzin.zzd(new zzku(1), 1003));
                }
            });
            zzdzVar.zzc();
        }
        this.zzm.zze();
        this.zzk.zzf(null);
        zzzl zzzlVar = this.zzt;
        zzmo zzmoVar = this.zzr;
        zzzlVar.zzg(zzmoVar);
        zzls zzlsVar = this.zzU;
        boolean z = zzlsVar.zzp;
        zzls zzlsVarZzY = zzY(zzlsVar, 1);
        this.zzU = zzlsVarZzY;
        zzls zzlsVarZzb = zzlsVarZzY.zzb(zzlsVarZzY.zzb);
        this.zzU = zzlsVarZzb;
        zzlsVarZzb.zzq = zzlsVarZzb.zzs;
        this.zzU.zzr = 0L;
        zzmoVar.zzR();
        Surface surface = this.zzK;
        if (surface != null) {
            surface.release();
            this.zzK = null;
        }
        int i = zzcw.zza;
    }
}
