package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import androidx.core.text.jp.CyjpdoedCdLTIO;
import com.google.android.gms.internal.common.Ko.TSDAbK;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zztp extends zzic {
    private static final byte[] zzb = {0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, -65, 28, 49, -61, 39, 93, 120};
    private zzti zzA;
    private int zzB;
    private boolean zzC;
    private boolean zzD;
    private boolean zzE;
    private boolean zzF;
    private boolean zzG;
    private long zzH;
    private boolean zzI;
    private long zzJ;
    private int zzK;
    private int zzL;
    private ByteBuffer zzM;
    private boolean zzN;
    private boolean zzO;
    private boolean zzP;
    private boolean zzQ;
    private boolean zzR;
    private boolean zzS;
    private int zzT;
    private int zzU;
    private int zzV;
    private boolean zzW;
    private boolean zzX;
    private boolean zzY;
    private long zzZ;
    protected zzid zza;
    private long zzaa;
    private boolean zzab;
    private boolean zzac;
    private boolean zzad;
    private zztn zzae;
    private long zzaf;
    private boolean zzag;
    private boolean zzah;
    private boolean zzai;
    private long zzaj;
    private long zzak;
    private zzsi zzal;
    private zzsi zzam;
    private final zztd zzc;
    private final zztr zzd;
    private final float zze;
    private final zzhs zzf;
    private final zzhs zzg;
    private final zzhs zzh;
    private final zzsw zzi;
    private final MediaCodec.BufferInfo zzj;
    private final ArrayDeque zzk;
    private final zzrv zzl;
    private zzz zzm;
    private zzz zzn;
    private zzlz zzo;
    private MediaCrypto zzp;
    private long zzq;
    private float zzr;
    private float zzs;
    private zztf zzt;
    private zzz zzu;
    private MediaFormat zzv;
    private boolean zzw;
    private float zzx;
    private ArrayDeque zzy;
    private zztl zzz;

    public zztp(int i, zztd zztdVar, zztr zztrVar, boolean z, float f) {
        super(i);
        this.zzc = zztdVar;
        zztrVar.getClass();
        this.zzd = zztrVar;
        this.zze = f;
        this.zzf = new zzhs(0, 0);
        this.zzg = new zzhs(0, 0);
        this.zzh = new zzhs(2, 0);
        zzsw zzswVar = new zzsw();
        this.zzi = zzswVar;
        this.zzj = new MediaCodec.BufferInfo();
        this.zzr = 1.0f;
        this.zzs = 1.0f;
        this.zzq = -9223372036854775807L;
        this.zzk = new ArrayDeque();
        this.zzae = zztn.zza;
        zzswVar.zzj(0);
        zzswVar.zzc.order(ByteOrder.nativeOrder());
        this.zzl = new zzrv();
        this.zzx = -1.0f;
        this.zzB = 0;
        this.zzT = 0;
        this.zzK = -1;
        this.zzL = -1;
        this.zzJ = -9223372036854775807L;
        this.zzZ = -9223372036854775807L;
        this.zzaa = -9223372036854775807L;
        this.zzaf = -9223372036854775807L;
        this.zzH = -9223372036854775807L;
        this.zzU = 0;
        this.zzV = 0;
        this.zza = new zzid();
        this.zzaj = -9223372036854775807L;
        this.zzak = -9223372036854775807L;
    }

    public static boolean zzaY(zzz zzzVar) {
        return zzzVar.zzN == 0;
    }

    private final void zzaf() {
        this.zzP = false;
        zzal();
    }

    private final void zzag() throws zzin {
        if (this.zzW) {
            this.zzU = 1;
            this.zzV = 3;
        } else {
            zzaM();
            zzaJ();
        }
    }

    private final void zzah() {
        try {
            zztf zztfVar = this.zzt;
            zzdd.zzb(zztfVar);
            zztfVar.zzj();
        } finally {
            zzaN();
        }
    }

    private final void zzai() throws zzin {
        int i = this.zzV;
        if (i == 1) {
            zzah();
            return;
        }
        if (i == 2) {
            zzah();
            zzbc();
        } else if (i != 3) {
            this.zzac = true;
            zzau();
        } else {
            zzaM();
            zzaJ();
        }
    }

    private final void zzal() {
        zzam();
        this.zzR = false;
        this.zzi.zzb();
        this.zzh.zzb();
        this.zzQ = false;
        this.zzl.zzb();
    }

    private final void zzam() {
        this.zzZ = -9223372036854775807L;
        this.zzaa = -9223372036854775807L;
        this.zzaf = -9223372036854775807L;
    }

    private final void zzas() {
        this.zzK = -1;
        this.zzg.zzc = null;
    }

    private final void zzba() {
        this.zzL = -1;
        this.zzM = null;
    }

    private final void zzbb(zztn zztnVar) {
        this.zzae = zztnVar;
        if (zztnVar.zzd != -9223372036854775807L) {
            this.zzag = true;
        }
    }

    private final void zzbc() {
        zzsi zzsiVar = this.zzam;
        zzsiVar.getClass();
        this.zzal = zzsiVar;
        this.zzU = 0;
        this.zzV = 0;
    }

    private final boolean zzbd() {
        if (this.zzW) {
            this.zzU = 1;
            if (this.zzD) {
                this.zzV = 3;
                return false;
            }
            this.zzV = 2;
        } else {
            zzbc();
        }
        return true;
    }

    private final boolean zzbe() {
        if (this.zzt == null) {
            return false;
        }
        if (zzaX()) {
            zzaM();
            return true;
        }
        if (zzaV()) {
            zzah();
            return false;
        }
        long j = this.zzak;
        if (j == -9223372036854775807L || zzcW() > j || this.zzaf >= j) {
            return false;
        }
        this.zzai = true;
        this.zzak = -9223372036854775807L;
        return false;
    }

    private final boolean zzbf() {
        return this.zzL >= 0;
    }

    private final boolean zzbh(int i) throws zzin {
        zzkv zzkvVarZzl = zzl();
        zzhs zzhsVar = this.zzf;
        zzhsVar.zzb();
        int iZzcV = zzcV(zzkvVarZzl, zzhsVar, i | 4);
        if (iZzcV == -5) {
            zzae(zzkvVarZzl);
            return true;
        }
        if (iZzcV != -4 || !zzhsVar.zzf()) {
            return false;
        }
        this.zzab = true;
        zzai();
        return false;
    }

    private final boolean zzbi(long j) {
        return this.zzq == -9223372036854775807L || zzcX().zzb() - j < this.zzq;
    }

    private final boolean zzbj(zzz zzzVar) throws zzin {
        if (this.zzt != null && this.zzV != 3 && zzcU() != 0) {
            float f = this.zzs;
            zzzVar.getClass();
            float fZzaa = zzaa(f, zzzVar, zzU());
            float f2 = this.zzx;
            if (f2 != fZzaa) {
                if (fZzaa == -1.0f) {
                    zzag();
                    return false;
                }
                if (f2 != -1.0f || fZzaa > this.zze) {
                    Bundle bundle = new Bundle();
                    bundle.putFloat("operating-rate", fZzaa);
                    zztf zztfVar = this.zzt;
                    zztfVar.getClass();
                    zztfVar.zzq(bundle);
                    this.zzx = fZzaa;
                }
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzic
    public void zzA(long j, boolean z) {
        this.zzab = false;
        this.zzac = false;
        if (this.zzP) {
            zzal();
        } else {
            zzaP();
        }
        zzet zzetVar = this.zzae.zze;
        if (zzetVar.zza() > 0) {
            this.zzad = true;
        }
        zzetVar.zze();
        this.zzk.clear();
    }

    @Override // com.google.android.gms.internal.ads.zzic
    public void zzD() {
        try {
            zzaf();
            zzaM();
        } finally {
            this.zzam = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003d, code lost:
    
        if (r7 >= r5) goto L16;
     */
    @Override // com.google.android.gms.internal.ads.zzic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void zzG(com.google.android.gms.internal.ads.zzz[] r13, long r14, long r16, com.google.android.gms.internal.ads.zzvh r18) {
        /*
            r12 = this;
            r0 = r12
            com.google.android.gms.internal.ads.zztn r1 = r0.zzae
            long r1 = r1.zzd
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L27
            com.google.android.gms.internal.ads.zztn r1 = new com.google.android.gms.internal.ads.zztn
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5 = r1
            r8 = r14
            r10 = r16
            r5.<init>(r6, r8, r10)
            r12.zzbb(r1)
            boolean r1 = r0.zzah
            if (r1 == 0) goto L5b
            r12.zzat()
            return
        L27:
            java.util.ArrayDeque r1 = r0.zzk
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L5c
            long r5 = r0.zzZ
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 == 0) goto L3f
            long r7 = r0.zzaf
            int r2 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r2 == 0) goto L5c
            int r2 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r2 < 0) goto L5c
        L3f:
            com.google.android.gms.internal.ads.zztn r1 = new com.google.android.gms.internal.ads.zztn
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5 = r1
            r8 = r14
            r10 = r16
            r5.<init>(r6, r8, r10)
            r12.zzbb(r1)
            com.google.android.gms.internal.ads.zztn r1 = r0.zzae
            long r1 = r1.zzd
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L5b
            r12.zzat()
        L5b:
            return
        L5c:
            com.google.android.gms.internal.ads.zztn r9 = new com.google.android.gms.internal.ads.zztn
            long r3 = r0.zzZ
            r2 = r9
            r5 = r14
            r7 = r16
            r2.<init>(r3, r5, r7)
            r1.add(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztp.zzG(com.google.android.gms.internal.ads.zzz[], long, long, com.google.android.gms.internal.ads.zzvh):void");
    }

    @Override // com.google.android.gms.internal.ads.zzic, com.google.android.gms.internal.ads.zzma
    public void zzN(float f, float f2) throws zzin {
        this.zzr = f;
        this.zzs = f2;
        zzbj(this.zzu);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 16511. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    @Override // com.google.android.gms.internal.ads.zzma
    public void zzW(long r27, long r29) throws com.google.android.gms.internal.ads.zzin {
        /*
            Method dump skipped, instruction units count: 1651
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztp.zzW(long, long):void");
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public boolean zzX() {
        return this.zzac;
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public boolean zzY() {
        if (this.zzm == null) {
            return false;
        }
        if (zzT() || zzbf()) {
            return true;
        }
        return this.zzJ != -9223372036854775807L && zzcX().zzb() < this.zzJ;
    }

    @Override // com.google.android.gms.internal.ads.zzmd
    public final int zzZ(zzz zzzVar) throws zzin {
        try {
            return zzab(this.zzd, zzzVar);
        } catch (zztw e) {
            throw zzk(e, zzzVar, false, 4002);
        }
    }

    public final long zzaA() {
        return this.zzae.zzd;
    }

    public final long zzaB() {
        return this.zzae.zzc;
    }

    public final MediaFormat zzaC() {
        return this.zzv;
    }

    public final zzlz zzaE() {
        return this.zzo;
    }

    public final zztf zzaF() {
        return this.zzt;
    }

    public zzth zzaG(Throwable th, zzti zztiVar) {
        return new zzth(th, zztiVar);
    }

    public final zzti zzaH() {
        return this.zzA;
    }

    public final void zzaI() {
        this.zzah = true;
    }

    public void zzaK(long j) {
        this.zzaf = j;
        while (true) {
            ArrayDeque arrayDeque = this.zzk;
            if (arrayDeque.isEmpty() || j < ((zztn) arrayDeque.peek()).zzb) {
                return;
            }
            zztn zztnVar = (zztn) arrayDeque.poll();
            zztnVar.getClass();
            zzbb(zztnVar);
            zzat();
        }
    }

    public void zzaL(zzhs zzhsVar) {
    }

    public final void zzaM() {
        try {
            zztf zztfVar = this.zzt;
            if (zztfVar != null) {
                zztfVar.zzm();
                this.zza.zzb++;
                zzti zztiVar = this.zzA;
                if (zztiVar == null) {
                    throw null;
                }
                zzaq(zztiVar.zza);
            }
            this.zzt = null;
            this.zzp = null;
            this.zzal = null;
            zzaO();
        } catch (Throwable th) {
            this.zzt = null;
            this.zzp = null;
            this.zzal = null;
            zzaO();
            throw th;
        }
    }

    public void zzaN() {
        zzas();
        zzba();
        zzam();
        this.zzJ = -9223372036854775807L;
        this.zzX = false;
        this.zzH = -9223372036854775807L;
        this.zzW = false;
        this.zzE = false;
        this.zzF = false;
        this.zzN = false;
        this.zzO = false;
        this.zzU = 0;
        this.zzV = 0;
        this.zzT = this.zzS ? 1 : 0;
        this.zzai = false;
        this.zzaj = -9223372036854775807L;
        this.zzak = -9223372036854775807L;
    }

    public final void zzaO() {
        zzaN();
        this.zzy = null;
        this.zzA = null;
        this.zzu = null;
        this.zzv = null;
        this.zzw = false;
        this.zzY = false;
        this.zzx = -1.0f;
        this.zzB = 0;
        this.zzC = false;
        this.zzD = false;
        this.zzG = false;
        this.zzI = false;
        this.zzS = false;
        this.zzT = 0;
    }

    public final boolean zzaP() throws zzin {
        boolean zZzbe = zzbe();
        if (zZzbe) {
            zzaJ();
        }
        return zZzbe;
    }

    public final boolean zzaQ() {
        return this.zzai;
    }

    public final boolean zzaR() {
        return this.zzP;
    }

    public final boolean zzaS(zzz zzzVar) {
        return this.zzam == null && zzaw(zzzVar);
    }

    public boolean zzaT(zzz zzzVar) {
        return true;
    }

    public boolean zzaU(zzhs zzhsVar) {
        return false;
    }

    public boolean zzaV() {
        return true;
    }

    public boolean zzaW(zzti zztiVar) {
        return true;
    }

    public boolean zzaX() {
        int i = this.zzV;
        if (i == 3 || ((this.zzC && !this.zzY) || (this.zzD && this.zzX))) {
            return true;
        }
        if (i != 2) {
            return false;
        }
        try {
            zzbc();
            return false;
        } catch (zzin e) {
            zzea.zzg("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e);
            return true;
        }
    }

    public final boolean zzaZ() {
        return zzbj(this.zzu);
    }

    public float zzaa(float f, zzz zzzVar, zzz[] zzzVarArr) {
        throw null;
    }

    public abstract int zzab(zztr zztrVar, zzz zzzVar);

    public long zzac(long j, long j2, boolean z) {
        return 10000L;
    }

    public zzie zzad(zzti zztiVar, zzz zzzVar, zzz zzzVar2) {
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0075  */
    /* JADX WARN: Code duplicated, block: B:36:0x0082  */
    public zzie zzae(zzkv zzkvVar) {
        int i;
        boolean z = true;
        this.zzad = true;
        zzz zzzVarZzan = zzkvVar.zza;
        zzzVarZzan.getClass();
        String str = zzzVarZzan.zzo;
        if (str == null) {
            throw zzk(new IllegalArgumentException("Sample MIME type is null."), zzzVarZzan, false, 4005);
        }
        if ((str.equals(TSDAbK.hukJYOTNVGg) || str.equals("video/x-vnd.on2.vp9")) && !zzzVarZzan.zzr.isEmpty()) {
            zzx zzxVarZzb = zzzVarZzan.zzb();
            zzxVarZzb.zzT(null);
            zzzVarZzan = zzxVarZzb.zzan();
        }
        zzz zzzVar = zzzVarZzan;
        this.zzam = zzkvVar.zzb;
        this.zzm = zzzVar;
        if (this.zzP) {
            this.zzR = true;
            return null;
        }
        zztf zztfVar = this.zzt;
        if (zztfVar == null) {
            this.zzy = null;
            zzaJ();
            return null;
        }
        zzti zztiVar = this.zzA;
        zztiVar.getClass();
        zzz zzzVar2 = this.zzu;
        zzzVar2.getClass();
        zzsi zzsiVar = this.zzal;
        zzsi zzsiVar2 = this.zzam;
        if (zzsiVar != zzsiVar2) {
            zzag();
            return new zzie(zztiVar.zza, zzzVar2, zzzVar, 0, 128);
        }
        boolean z2 = zzsiVar2 != zzsiVar;
        zzie zzieVarZzad = zzad(zztiVar, zzzVar2, zzzVar);
        int i2 = zzieVarZzad.zzd;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (zzbj(zzzVar)) {
                        this.zzu = zzzVar;
                        if (z2 && !zzbd()) {
                            i = 2;
                        }
                    } else {
                        i = 16;
                    }
                } else if (zzbj(zzzVar)) {
                    this.zzS = true;
                    this.zzT = 1;
                    int i3 = this.zzB;
                    if (i3 != 2 && (i3 != 1 || zzzVar.zzv != zzzVar2.zzv || zzzVar.zzw != zzzVar2.zzw)) {
                        z = false;
                    }
                    this.zzE = z;
                    this.zzu = zzzVar;
                    if (z2 && !zzbd()) {
                        i = 2;
                    }
                } else {
                    i = 16;
                }
            } else if (zzbj(zzzVar)) {
                this.zzu = zzzVar;
                if (z2) {
                    if (!zzbd()) {
                        i = 2;
                    }
                } else if (this.zzW) {
                    this.zzU = 1;
                    if (this.zzD) {
                        this.zzV = 3;
                        i = 2;
                    } else {
                        this.zzV = 1;
                    }
                }
            } else {
                i = 16;
            }
            return (i2 != 0 || (this.zzt == zztfVar && this.zzV != 3)) ? zzieVarZzad : new zzie(zztiVar.zza, zzzVar2, zzzVar, 0, i);
        }
        zzag();
        i = 0;
        if (i2 != 0) {
        }
    }

    public abstract zztc zzaj(zzti zztiVar, zzz zzzVar, MediaCrypto mediaCrypto, float f);

    public abstract List zzak(zztr zztrVar, zzz zzzVar, boolean z);

    public void zzan(zzhs zzhsVar) {
        throw null;
    }

    public void zzao(Exception exc) {
        throw null;
    }

    public void zzap(String str, zztc zztcVar, long j, long j2) {
        throw null;
    }

    public void zzaq(String str) {
        throw null;
    }

    public void zzar(zzz zzzVar, MediaFormat mediaFormat) {
        throw null;
    }

    public void zzat() {
    }

    public void zzau() {
        throw null;
    }

    public abstract boolean zzav(long j, long j2, zztf zztfVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzz zzzVar);

    public boolean zzaw(zzz zzzVar) {
        return false;
    }

    public final float zzax() {
        return this.zzr;
    }

    public int zzay(zzhs zzhsVar) {
        return 0;
    }

    public final long zzaz() {
        return this.zzaa;
    }

    @Override // com.google.android.gms.internal.ads.zzic, com.google.android.gms.internal.ads.zzmd
    public final int zze() {
        return 8;
    }

    @Override // com.google.android.gms.internal.ads.zzic, com.google.android.gms.internal.ads.zzma
    public final long zzf(long j, long j2) {
        return zzac(j, j2, this.zzI);
    }

    @Override // com.google.android.gms.internal.ads.zzic, com.google.android.gms.internal.ads.zzlv
    public void zzv(int i, Object obj) {
        if (i == 11) {
            zzlz zzlzVar = (zzlz) obj;
            zzlzVar.getClass();
            this.zzo = zzlzVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzic
    public void zzy() {
        this.zzm = null;
        zzbb(zztn.zza);
        this.zzk.clear();
        if (this.zzP) {
            zzaf();
        } else {
            zzbe();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzic
    public void zzz(boolean z, boolean z2) {
        this.zza = new zzid();
    }

    private final boolean zzbg(long j, long j2) {
        if (j2 >= j) {
            return false;
        }
        zzz zzzVar = this.zzn;
        if (zzzVar == null || !Objects.equals(zzzVar.zzo, CyjpdoedCdLTIO.mAPkElaomzi)) {
            return true;
        }
        return !zzaeq.zzf(j, j2);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 16451. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public final void zzaJ() throws com.google.android.gms.internal.ads.zzin {
        /*
            Method dump skipped, instruction units count: 1645
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztp.zzaJ():void");
    }
}
