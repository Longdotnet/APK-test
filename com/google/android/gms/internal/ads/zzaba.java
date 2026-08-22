package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import android.util.Pair;
import android.view.Surface;
import androidx.lifecycle.hSi.sgtsHsWT;
import androidx.loader.app.gv.DYYbQc;
import com.daerisoft.thespikerm.GooglePlayBillingEnums;
import com.google.android.finsky.externalreferrer.jUdg.RDFWIi;
import com.google.android.gms.common.util.concurrent.dN.MnHfHMYQDPUO;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import com.google.firebase.analytics.connector.pDv.PZmDzEagKNdW;
import com.google.gson.yWTz.kBfGXgdfpo;
import com.google.protobuf.DescriptorProtos;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.PriorityQueue;
import kotlin.coroutines.jvm.internal.DEXi.JuorMn;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaba extends zztp implements zzabr {
    private static final int[] zzb = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private static boolean zzc;
    private static boolean zzd;
    private int zzA;
    private int zzB;
    private zzmh zzC;
    private boolean zzD;
    private long zzE;
    private int zzF;
    private long zzG;
    private zzcd zzH;
    private zzcd zzI;
    private int zzJ;
    private int zzK;
    private zzabp zzL;
    private long zzM;
    private long zzN;
    private boolean zzO;
    private final Context zze;
    private final boolean zzf;
    private final zzaci zzg;
    private final boolean zzh;
    private final zzabs zzi;
    private final zzabq zzj;
    private final PriorityQueue zzk;
    private zzaaz zzl;
    private boolean zzm;
    private boolean zzn;
    private zzaco zzo;
    private boolean zzp;
    private int zzq;
    private List zzr;
    private Surface zzs;
    private zzabd zzt;
    private zzeo zzu;
    private boolean zzv;
    private int zzw;
    private int zzx;
    private long zzy;
    private int zzz;

    public zzaba(zzaay zzaayVar) {
        super(2, zzaayVar.zzd, zzaayVar.zzc, false, 30.0f);
        Context applicationContext = zzaayVar.zza.getApplicationContext();
        this.zze = applicationContext;
        this.zzo = null;
        this.zzg = new zzaci(zzaayVar.zze, zzaayVar.zzf);
        this.zzf = this.zzo == null;
        this.zzi = new zzabs(applicationContext, this, 0L);
        this.zzj = new zzabq();
        this.zzh = "NVIDIA".equals(Build.MANUFACTURER);
        this.zzu = zzeo.zza;
        this.zzw = 1;
        this.zzx = 0;
        this.zzH = zzcd.zza;
        this.zzK = 0;
        this.zzI = null;
        this.zzJ = -1000;
        this.zzM = -9223372036854775807L;
        this.zzN = -9223372036854775807L;
        this.zzk = new PriorityQueue();
        this.zzC = null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:19:0x0041  */
    public static int zzaf(zzti zztiVar, zzz zzzVar) {
        int i = zzzVar.zzv;
        int i2 = zzzVar.zzw;
        if (i != -1 && i2 != -1) {
            String str = zzzVar.zzo;
            str.getClass();
            if ("video/dolby-vision".equals(str)) {
                int i3 = zzuc.zza;
                Pair pairZza = zzdk.zza(zzzVar);
                if (pairZza == null) {
                    str = "video/hevc";
                } else {
                    int iIntValue = ((Integer) pairZza.first).intValue();
                    if (iIntValue == 512 || iIntValue == 1 || iIntValue == 2) {
                        str = "video/avc";
                    } else if (iIntValue == 1024) {
                        str = "video/av01";
                    } else {
                        str = "video/hevc";
                    }
                }
            }
            int i4 = 4;
            switch (str) {
                case "video/3gpp":
                case "video/mp4v-es":
                case "video/av01":
                case "video/x-vnd.on2.vp8":
                    return ((i * i2) * 3) / i4;
                case "video/hevc":
                    return Math.max(2097152, ((i * i2) * 3) / 4);
                case "video/avc":
                    String str2 = Build.MODEL;
                    if (!"BRAVIA 4K 2015".equals(str2) && (!"Amazon".equals(Build.MANUFACTURER) || (!"KFSOWI".equals(str2) && (!"AFTS".equals(str2) || !zztiVar.zzf)))) {
                        String str3 = zzex.zza;
                        return ((((i2 + 15) / 16) * ((i + 15) / 16)) * 768) / 4;
                    }
                    break;
                case "video/x-vnd.on2.vp9":
                    i4 = 8;
                    return ((i * i2) * 3) / i4;
            }
        }
        return -1;
    }

    public static int zzag(zzti zztiVar, zzz zzzVar) {
        int i = zzzVar.zzp;
        if (i == -1) {
            return zzaf(zztiVar, zzzVar);
        }
        List list = zzzVar.zzr;
        int size = list.size();
        int length = 0;
        for (int i2 = 0; i2 < size; i2++) {
            length += ((byte[]) list.get(i2)).length;
        }
        return i + length;
    }

    public static final boolean zzbf(zzti zztiVar) {
        return Build.VERSION.SDK_INT >= 35 && zztiVar.zzh;
    }

    private final Surface zzbg(zzti zztiVar) {
        zzaco zzacoVar = this.zzo;
        if (zzacoVar != null) {
            return zzacoVar.zzb();
        }
        Surface surface = this.zzs;
        if (surface != null) {
            return surface;
        }
        if (zzbf(zztiVar)) {
            return null;
        }
        zzdd.zzf(zzbd(zztiVar));
        zzabd zzabdVar = this.zzt;
        if (zzabdVar != null) {
            if (zzabdVar.zza != zztiVar.zzf) {
                zzbl();
            }
        }
        if (this.zzt == null) {
            this.zzt = zzabd.zza(this.zze, zztiVar.zzf);
        }
        return this.zzt;
    }

    private static List zzbh(Context context, zztr zztrVar, zzz zzzVar, boolean z, boolean z2) {
        String str = zzzVar.zzo;
        if (str == null) {
            return zzfyq.zzn();
        }
        if (Build.VERSION.SDK_INT >= 26 && "video/dolby-vision".equals(str) && !zzaax.zza(context)) {
            List listZzc = zzuc.zzc(zztrVar, zzzVar, z, z2);
            if (!listZzc.isEmpty()) {
                return listZzc;
            }
        }
        return zzuc.zze(zztrVar, zzzVar, z, z2);
    }

    private final void zzbi() {
        zzcd zzcdVar = this.zzI;
        if (zzcdVar != null) {
            this.zzg.zzt(zzcdVar);
        }
    }

    private final void zzbj(long j, long j2, zzz zzzVar) {
        zzabp zzabpVar = this.zzL;
        if (zzabpVar != null) {
            zzabpVar.zzcT(j, j2, zzzVar, zzaC());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbk() {
        this.zzg.zzq(this.zzs);
        this.zzv = true;
    }

    private final void zzbl() {
        zzabd zzabdVar = this.zzt;
        if (zzabdVar != null) {
            zzabdVar.release();
            this.zzt = null;
        }
    }

    private final void zzbm(Object obj) throws zzin {
        Surface surface = obj instanceof Surface ? (Surface) obj : null;
        if (this.zzs == surface) {
            if (surface != null) {
                zzbi();
                Surface surface2 = this.zzs;
                if (surface2 == null || !this.zzv) {
                    return;
                }
                this.zzg.zzq(surface2);
                return;
            }
            return;
        }
        this.zzs = surface;
        if (this.zzo == null) {
            this.zzi.zzk(surface);
        }
        this.zzv = false;
        int iZzcU = zzcU();
        zztf zztfVarZzaF = zzaF();
        if (zztfVarZzaF != null && this.zzo == null) {
            zzti zztiVarZzaH = zzaH();
            zztiVarZzaH.getClass();
            if (!zzbn(zztiVarZzaH) || this.zzm) {
                zzaM();
                zzaJ();
            } else {
                Surface surfaceZzbg = zzbg(zztiVarZzaH);
                if (surfaceZzbg != null) {
                    zztfVarZzaF.zzp(surfaceZzbg);
                } else {
                    if (Build.VERSION.SDK_INT < 35) {
                        throw new IllegalStateException();
                    }
                    zztfVarZzaF.zzi();
                }
            }
        }
        if (surface != null) {
            zzbi();
        } else {
            this.zzI = null;
            zzaco zzacoVar = this.zzo;
            if (zzacoVar != null) {
                zzacoVar.zzi();
            }
        }
        if (iZzcU == 2) {
            zzaco zzacoVar2 = this.zzo;
            if (zzacoVar2 != null) {
                zzacoVar2.zzk(true);
            } else {
                this.zzi.zzc(true);
            }
        }
    }

    private final boolean zzbn(zzti zztiVar) {
        if (this.zzo != null) {
            return true;
        }
        Surface surface = this.zzs;
        return (surface != null && surface.isValid()) || zzbf(zztiVar) || zzbd(zztiVar);
    }

    private final boolean zzbo(zzhs zzhsVar) {
        return zzhsVar.zze < zzcW();
    }

    @Override // com.google.android.gms.internal.ads.zztp, com.google.android.gms.internal.ads.zzic
    public final void zzA(long j, boolean z) {
        zzaco zzacoVar = this.zzo;
        if (zzacoVar != null && !z) {
            zzacoVar.zzj(true);
        }
        super.zzA(j, z);
        if (this.zzo == null) {
            this.zzi.zzg();
        }
        if (z) {
            zzaco zzacoVar2 = this.zzo;
            if (zzacoVar2 != null) {
                zzacoVar2.zzk(false);
            } else {
                this.zzi.zzc(false);
            }
        }
        this.zzA = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzic
    public final void zzB() {
        zzaco zzacoVar = this.zzo;
        if (zzacoVar == null || !this.zzf) {
            return;
        }
        zzacoVar.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zztp, com.google.android.gms.internal.ads.zzic
    public final void zzD() {
        try {
            super.zzD();
        } finally {
            this.zzp = false;
            this.zzM = -9223372036854775807L;
            zzbl();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzic
    public final void zzE() {
        this.zzz = 0;
        this.zzy = zzcX().zzb();
        this.zzE = 0L;
        this.zzF = 0;
        zzaco zzacoVar = this.zzo;
        if (zzacoVar != null) {
            zzacoVar.zzx();
        } else {
            this.zzi.zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzic
    public final void zzF() {
        if (this.zzz > 0) {
            long jZzb = zzcX().zzb();
            this.zzg.zzn(this.zzz, jZzb - this.zzy);
            this.zzz = 0;
            this.zzy = jZzb;
        }
        int i = this.zzF;
        if (i != 0) {
            this.zzg.zzr(this.zzE, i);
            this.zzE = 0L;
            this.zzF = 0;
        }
        zzaco zzacoVar = this.zzo;
        if (zzacoVar != null) {
            zzacoVar.zzy();
        } else {
            this.zzi.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zztp, com.google.android.gms.internal.ads.zzic
    public final void zzG(zzz[] zzzVarArr, long j, long j2, zzvh zzvhVar) {
        super.zzG(zzzVarArr, j, j2, zzvhVar);
        zzbl zzblVarZzi = zzi();
        if (zzblVarZzi.zzo()) {
            this.zzN = -9223372036854775807L;
        } else {
            this.zzN = zzblVarZzi.zzn(zzvhVar.zza, new zzbj()).zzd;
        }
    }

    @Override // com.google.android.gms.internal.ads.zztp, com.google.android.gms.internal.ads.zzic, com.google.android.gms.internal.ads.zzma
    public final void zzN(float f, float f2) throws zzin {
        super.zzN(f, f2);
        zzaco zzacoVar = this.zzo;
        if (zzacoVar != null) {
            zzacoVar.zzt(f);
        } else {
            this.zzi.zzl(f);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzma, com.google.android.gms.internal.ads.zzmd
    public final String zzV() {
        return "MediaCodecVideoRenderer";
    }

    @Override // com.google.android.gms.internal.ads.zztp, com.google.android.gms.internal.ads.zzma
    public final void zzW(long j, long j2) throws zzin {
        zzaco zzacoVar = this.zzo;
        if (zzacoVar != null) {
            try {
                zzacoVar.zzo(j, j2);
            } catch (zzacn e) {
                throw zzk(e, e.zza, false, 7001);
            }
        }
        super.zzW(j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zztp, com.google.android.gms.internal.ads.zzma
    public final boolean zzX() {
        if (!super.zzX()) {
            return false;
        }
        zzaco zzacoVar = this.zzo;
        return zzacoVar == null || zzacoVar.zzB();
    }

    @Override // com.google.android.gms.internal.ads.zztp, com.google.android.gms.internal.ads.zzma
    public final boolean zzY() {
        boolean zZzY = super.zzY();
        zzaco zzacoVar = this.zzo;
        if (zzacoVar != null) {
            return zzacoVar.zzD(zZzY);
        }
        if (zZzY && zzaF() == null) {
            return true;
        }
        return this.zzi.zzm(zZzY);
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final zzth zzaG(Throwable th, zzti zztiVar) {
        return new zzaau(th, zztiVar, this.zzs);
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final void zzaK(long j) {
        super.zzaK(j);
        this.zzB--;
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final void zzaL(zzhs zzhsVar) {
        int iZzay = zzay(zzhsVar);
        if (Build.VERSION.SDK_INT < 34 || (iZzay & 32) == 0) {
            this.zzB++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final void zzaN() {
        super.zzaN();
        this.zzk.clear();
        this.zzB = 0;
        this.zzD = false;
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final boolean zzaT(zzz zzzVar) throws zzin {
        zzaco zzacoVar = this.zzo;
        if (zzacoVar == null || zzacoVar.zzC()) {
            return true;
        }
        try {
            zzacoVar.zzA(zzzVar);
            return true;
        } catch (zzacn e) {
            throw zzk(e, zzzVar, false, 7000);
        }
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final boolean zzaU(zzhs zzhsVar) {
        boolean z = false;
        if (!zzR() && !zzhsVar.zzh() && this.zzN != -9223372036854775807L) {
            if (this.zzN - (zzhsVar.zze - zzaA()) > 100000 && zzbo(zzhsVar)) {
                if (zzhsVar.zze()) {
                    return false;
                }
                if (zzhsVar.zzi()) {
                    zzhsVar.zzb();
                    z = true;
                }
                if (z) {
                    ((zztp) this).zza.zzd++;
                }
            }
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final boolean zzaV() {
        return this.zzC == null || this.zzD || zzaQ() || zzaz() != -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final boolean zzaW(zzti zztiVar) {
        return zzbn(zztiVar);
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final boolean zzaX() {
        zzti zztiVarZzaH = zzaH();
        if (this.zzo != null && zztiVarZzaH != null) {
            String str = zztiVarZzaH.zza;
            if (str.equals("c2.mtk.avc.decoder") || str.equals("c2.mtk.hevc.decoder")) {
                return true;
            }
        }
        return super.zzaX();
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final float zzaa(float f, zzz zzzVar, zzz[] zzzVarArr) {
        zzti zztiVarZzaH;
        float fMax = -1.0f;
        for (zzz zzzVar2 : zzzVarArr) {
            float f2 = zzzVar2.zzz;
            if (f2 != -1.0f) {
                fMax = Math.max(fMax, f2);
            }
        }
        float f3 = fMax == -1.0f ? -1.0f : fMax * f;
        if (this.zzC == null || (zztiVarZzaH = zzaH()) == null) {
            return f3;
        }
        float fZza = zztiVarZzaH.zza(zzzVar.zzv, zzzVar.zzw);
        return f3 != -1.0f ? Math.max(f3, fZza) : fZza;
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final int zzab(zztr zztrVar, zzz zzzVar) {
        boolean z;
        String str = zzzVar.zzo;
        if (!zzay.zzj(str)) {
            return 128;
        }
        Context context = this.zze;
        int i = 0;
        boolean z2 = zzzVar.zzs != null;
        List listZzbh = zzbh(context, zztrVar, zzzVar, z2, false);
        if (z2 && listZzbh.isEmpty()) {
            listZzbh = zzbh(context, zztrVar, zzzVar, false, false);
        }
        if (listZzbh.isEmpty()) {
            return 129;
        }
        if (!zztp.zzaY(zzzVar)) {
            return 130;
        }
        zzti zztiVar = (zzti) listZzbh.get(0);
        boolean zZzf = zztiVar.zzf(zzzVar);
        if (!zZzf) {
            int i2 = 1;
            while (true) {
                if (i2 >= listZzbh.size()) {
                    z = true;
                    break;
                }
                zzti zztiVar2 = (zzti) listZzbh.get(i2);
                if (zztiVar2.zzf(zzzVar)) {
                    zZzf = true;
                    z = false;
                    zztiVar = zztiVar2;
                    break;
                }
                i2++;
            }
        } else {
            z = true;
            break;
        }
        int i3 = true != zZzf ? 3 : 4;
        int i4 = true != zztiVar.zzg(zzzVar) ? 8 : 16;
        int i5 = true != zztiVar.zzg ? 0 : 64;
        int i6 = true != z ? 0 : 128;
        if (Build.VERSION.SDK_INT >= 26 && "video/dolby-vision".equals(str) && !zzaax.zza(context)) {
            i6 = 256;
        }
        if (zZzf) {
            List listZzbh2 = zzbh(context, zztrVar, zzzVar, z2, true);
            if (!listZzbh2.isEmpty()) {
                zzti zztiVar3 = (zzti) zzuc.zzf(listZzbh2, zzzVar).get(0);
                if (zztiVar3.zzf(zzzVar) && zztiVar3.zzg(zzzVar)) {
                    i = 32;
                }
            }
        }
        return i6 | i3 | i4 | i | i5;
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final zzie zzad(zzti zztiVar, zzz zzzVar, zzz zzzVar2) {
        int i;
        int i2;
        zzie zzieVarZzc = zztiVar.zzc(zzzVar, zzzVar2);
        int i3 = zzieVarZzc.zze;
        zzaaz zzaazVar = this.zzl;
        zzaazVar.getClass();
        if (zzzVar2.zzv > zzaazVar.zza || zzzVar2.zzw > zzaazVar.zzb) {
            i3 |= 256;
        }
        if (zzag(zztiVar, zzzVar2) > zzaazVar.zzc) {
            i3 |= 64;
        }
        String str = zztiVar.zza;
        if (i3 != 0) {
            i2 = i3;
            i = 0;
        } else {
            i = zzieVarZzc.zzd;
            i2 = 0;
        }
        return new zzie(str, zzzVar, zzzVar2, i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final zzie zzae(zzkv zzkvVar) {
        zzie zzieVarZzae = super.zzae(zzkvVar);
        zzz zzzVar = zzkvVar.zza;
        zzzVar.getClass();
        this.zzg.zzp(zzzVar, zzieVarZzae);
        return zzieVarZzae;
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final zztc zzaj(zzti zztiVar, zzz zzzVar, MediaCrypto mediaCrypto, float f) {
        int i;
        int i2;
        zzaaz zzaazVar;
        Point pointZzb;
        int i3;
        zzz[] zzzVarArr;
        byte b;
        boolean z;
        int iZzaf;
        zzz[] zzzVarArrZzU = zzU();
        int length = zzzVarArrZzU.length;
        int iZzag = zzag(zztiVar, zzzVar);
        int i4 = zzzVar.zzw;
        int i5 = zzzVar.zzv;
        if (length == 1) {
            if (iZzag != -1 && (iZzaf = zzaf(zztiVar, zzzVar)) != -1) {
                iZzag = Math.min((int) (iZzag * 1.5f), iZzaf);
            }
            zzaazVar = new zzaaz(i5, i4, iZzag);
            i = i4;
            i2 = i5;
        } else {
            int iMax = i4;
            int iMax2 = i5;
            int i6 = 0;
            boolean z2 = false;
            while (i6 < length) {
                zzz zzzVarZzan = zzzVarArrZzU[i6];
                zzk zzkVar = zzzVar.zzE;
                if (zzkVar != null && zzzVarZzan.zzE == null) {
                    zzx zzxVarZzb = zzzVarZzan.zzb();
                    zzxVarZzb.zzF(zzkVar);
                    zzzVarZzan = zzxVarZzb.zzan();
                }
                if (zztiVar.zzc(zzzVar, zzzVarZzan).zzd != 0) {
                    int i7 = zzzVarZzan.zzv;
                    b = -1;
                    if (i7 != -1) {
                        zzzVarArr = zzzVarArrZzU;
                        if (zzzVarZzan.zzw != -1) {
                            z = false;
                        }
                        z2 |= z;
                        iMax2 = Math.max(iMax2, i7);
                        iMax = Math.max(iMax, zzzVarZzan.zzw);
                        iZzag = Math.max(iZzag, zzag(zztiVar, zzzVarZzan));
                    } else {
                        zzzVarArr = zzzVarArrZzU;
                    }
                    z = true;
                    z2 |= z;
                    iMax2 = Math.max(iMax2, i7);
                    iMax = Math.max(iMax, zzzVarZzan.zzw);
                    iZzag = Math.max(iZzag, zzag(zztiVar, zzzVarZzan));
                } else {
                    zzzVarArr = zzzVarArrZzU;
                    b = -1;
                }
                i6++;
                zzzVarArrZzU = zzzVarArr;
            }
            if (z2) {
                zzea.zzf("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + iMax2 + "x" + iMax);
                boolean z3 = i4 > i5;
                int i8 = z3 ? i4 : i5;
                int i9 = true != z3 ? i4 : i5;
                int[] iArr = zzb;
                int i10 = 0;
                while (true) {
                    if (i10 < 9) {
                        float f2 = i9;
                        i = i4;
                        float f3 = i8;
                        i2 = i5;
                        int i11 = iArr[i10];
                        int[] iArr2 = iArr;
                        float f4 = i11;
                        if (i11 > i8 && (i3 = (int) ((f2 / f3) * f4)) > i9) {
                            int i12 = true != z3 ? i11 : i3;
                            if (true != z3) {
                                i11 = i3;
                            }
                            pointZzb = zztiVar.zzb(i12, i11);
                            float f5 = zzzVar.zzz;
                            if (pointZzb != null) {
                                if (zztiVar.zzh(pointZzb.x, pointZzb.y, f5)) {
                                    break;
                                }
                            }
                            i10++;
                            i4 = i;
                            i5 = i2;
                            iArr = iArr2;
                            z3 = z3;
                        }
                    } else {
                        i = i4;
                        i2 = i5;
                    }
                    pointZzb = null;
                    break;
                }
                if (pointZzb != null) {
                    iMax2 = Math.max(iMax2, pointZzb.x);
                    iMax = Math.max(iMax, pointZzb.y);
                    zzx zzxVarZzb2 = zzzVar.zzb();
                    zzxVarZzb2.zzam(iMax2);
                    zzxVarZzb2.zzQ(iMax);
                    iZzag = Math.max(iZzag, zzaf(zztiVar, zzxVarZzb2.zzan()));
                    zzea.zzf("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + iMax2 + "x" + iMax);
                }
            } else {
                i = i4;
                i2 = i5;
            }
            zzaazVar = new zzaaz(iMax2, iMax, iZzag);
        }
        String str = zztiVar.zzc;
        this.zzl = zzaazVar;
        boolean z4 = this.zzh;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", i2);
        mediaFormat.setInteger("height", i);
        zzed.zzb(mediaFormat, zzzVar.zzr);
        float f6 = zzzVar.zzz;
        if (f6 != -1.0f) {
            mediaFormat.setFloat("frame-rate", f6);
        }
        zzed.zza(mediaFormat, "rotation-degrees", zzzVar.zzA);
        zzk zzkVar2 = zzzVar.zzE;
        if (zzkVar2 != null) {
            zzed.zza(mediaFormat, "color-transfer", zzkVar2.zzd);
            zzed.zza(mediaFormat, "color-standard", zzkVar2.zzb);
            zzed.zza(mediaFormat, "color-range", zzkVar2.zzc);
            byte[] bArr = zzkVar2.zze;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        if ("video/dolby-vision".equals(zzzVar.zzo)) {
            int i13 = zzuc.zza;
            Pair pairZza = zzdk.zza(zzzVar);
            if (pairZza != null) {
                zzed.zza(mediaFormat, "profile", ((Integer) pairZza.first).intValue());
            }
        }
        mediaFormat.setInteger("max-width", zzaazVar.zza);
        mediaFormat.setInteger("max-height", zzaazVar.zzb);
        zzed.zza(mediaFormat, "max-input-size", zzaazVar.zzc);
        mediaFormat.setInteger("priority", 0);
        if (f != -1.0f) {
            mediaFormat.setFloat("operating-rate", f);
        }
        if (z4) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (Build.VERSION.SDK_INT >= 35) {
            mediaFormat.setInteger("importance", Math.max(0, -this.zzJ));
        }
        Surface surfaceZzbg = zzbg(zztiVar);
        if (this.zzo != null && !zzex.zzL(this.zze)) {
            mediaFormat.setInteger("allow-frame-drop", 0);
        }
        return zztc.zzb(zztiVar, mediaFormat, zzzVar, surfaceZzbg, null);
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final List zzak(zztr zztrVar, zzz zzzVar, boolean z) {
        return zzuc.zzf(zzbh(this.zze, zztrVar, zzzVar, false, false), zzzVar);
    }

    public final void zzam(zztf zztfVar, int i, long j, long j2) {
        Trace.beginSection("releaseOutputBuffer");
        zztfVar.zzn(i, j2);
        Trace.endSection();
        ((zztp) this).zza.zze++;
        this.zzA = 0;
        if (this.zzo == null) {
            zzcd zzcdVar = this.zzH;
            if (!zzcdVar.equals(zzcd.zza) && !zzcdVar.equals(this.zzI)) {
                this.zzI = zzcdVar;
                this.zzg.zzt(zzcdVar);
            }
            if (!this.zzi.zzn() || this.zzs == null) {
                return;
            }
            zzbk();
        }
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final void zzan(zzhs zzhsVar) {
        if (this.zzn) {
            ByteBuffer byteBuffer = zzhsVar.zzf;
            byteBuffer.getClass();
            if (byteBuffer.remaining() >= 7) {
                byte b = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                byteBuffer.position(0);
                if (b == -75 && s == 60 && s2 == 1 && b2 == 4) {
                    if (b3 == 0 || b3 == 1) {
                        byte[] bArr = new byte[byteBuffer.remaining()];
                        byteBuffer.get(bArr);
                        byteBuffer.position(0);
                        zztf zztfVarZzaF = zzaF();
                        zztfVarZzaF.getClass();
                        Bundle bundle = new Bundle();
                        bundle.putByteArray("hdr10-plus-info", bArr);
                        zztfVarZzaF.zzq(bundle);
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final void zzao(Exception exc) {
        zzea.zzd("MediaCodecVideoRenderer", "Video codec error", exc);
        this.zzg.zzs(exc);
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final void zzap(String str, zztc zztcVar, long j, long j2) {
        this.zzg.zzk(str, j, j2);
        this.zzm = zzbe(str);
        zzti zztiVarZzaH = zzaH();
        zztiVarZzaH.getClass();
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 29 && "video/x-vnd.on2.vp9".equals(zztiVarZzaH.zzb)) {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : zztiVarZzaH.zzi()) {
                if (codecProfileLevel.profile == 16384) {
                    z = true;
                    break;
                }
            }
        }
        this.zzn = z;
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final void zzaq(String str) {
        this.zzg.zzl(str);
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final void zzar(zzz zzzVar, MediaFormat mediaFormat) {
        zztf zztfVarZzaF = zzaF();
        if (zztfVarZzaF != null) {
            zztfVarZzaF.zzr(this.zzw);
        }
        mediaFormat.getClass();
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        int integer = z ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
        int integer2 = z ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
        float f = zzzVar.zzB;
        int i = zzzVar.zzA;
        if (i == 90 || i == 270) {
            f = 1.0f / f;
            int i2 = integer2;
            integer2 = integer;
            integer = i2;
        }
        this.zzH = new zzcd(integer, integer2, f);
        zzaco zzacoVar = this.zzo;
        if (zzacoVar == null || !this.zzO) {
            this.zzi.zzj(zzzVar.zzz);
        } else {
            zzx zzxVarZzb = zzzVar.zzb();
            zzxVarZzb.zzam(integer);
            zzxVarZzb.zzQ(integer2);
            zzxVarZzb.zzad(f);
            zzz zzzVarZzan = zzxVarZzb.zzan();
            int i3 = this.zzq;
            List listZzn = this.zzr;
            if (listZzn == null) {
                listZzn = zzfyq.zzn();
            }
            zzacoVar.zzl(1, zzzVarZzan, zzaB(), i3, listZzn);
            this.zzq = 2;
        }
        this.zzO = false;
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final void zzat() {
        zzaco zzacoVar = this.zzo;
        if (zzacoVar != null) {
            zzacoVar.zzw();
            long jZzaB = this.zzM;
            if (jZzaB == -9223372036854775807L) {
                jZzaB = zzaB();
                this.zzM = jZzaB;
            }
            this.zzo.zzp(-jZzaB);
        } else {
            this.zzi.zzf(2);
        }
        this.zzO = true;
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final void zzau() {
        zzaco zzacoVar = this.zzo;
        if (zzacoVar != null) {
            zzacoVar.zzw();
        }
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final boolean zzav(long j, long j2, zztf zztfVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzz zzzVar) {
        zztfVar.getClass();
        long jZzaA = j3 - zzaA();
        int i4 = 0;
        while (true) {
            PriorityQueue priorityQueue = this.zzk;
            Long l = (Long) priorityQueue.peek();
            if (l == null || l.longValue() >= j3) {
                break;
            }
            priorityQueue.poll();
            i4++;
        }
        zzba(i4, 0);
        zzaco zzacoVar = this.zzo;
        if (zzacoVar != null) {
            if (!z || z2) {
                return zzacoVar.zzz(j3, new zzaaw(this, zztfVar, i, jZzaA));
            }
            zzas(zztfVar, i, jZzaA);
            return true;
        }
        zzabs zzabsVar = this.zzi;
        long jZzaB = zzaB();
        zzabq zzabqVar = this.zzj;
        int iZza = zzabsVar.zza(j3, j, j2, jZzaB, z, z2, zzabqVar);
        if (iZza == 0) {
            long jZzc = zzcX().zzc();
            zzbj(jZzaA, jZzc, zzzVar);
            zzam(zztfVar, i, jZzaA, jZzc);
            zzbb(zzabqVar.zzc());
            return true;
        }
        if (iZza == 1) {
            long jZzd = zzabqVar.zzd();
            long jZzc2 = zzabqVar.zzc();
            if (jZzd == this.zzG) {
                zzas(zztfVar, i, jZzaA);
            } else {
                zzbj(jZzaA, jZzd, zzzVar);
                zzam(zztfVar, i, jZzaA, jZzd);
            }
            zzbb(jZzc2);
            this.zzG = jZzd;
            return true;
        }
        if (iZza != 2) {
            if (iZza != 3) {
                return false;
            }
            zzas(zztfVar, i, jZzaA);
            zzbb(zzabqVar.zzc());
            return true;
        }
        Trace.beginSection("dropVideoBuffer");
        zztfVar.zzo(i, false);
        Trace.endSection();
        zzba(0, 1);
        zzbb(zzabqVar.zzc());
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final int zzay(zzhs zzhsVar) {
        return (Build.VERSION.SDK_INT < 34 || this.zzC == null || !zzbo(zzhsVar)) ? 0 : 32;
    }

    public final void zzba(int i, int i2) {
        zzid zzidVar = ((zztp) this).zza;
        zzidVar.zzh += i;
        int i3 = i + i2;
        zzidVar.zzg += i3;
        this.zzz += i3;
        int i4 = this.zzA + i3;
        this.zzA = i4;
        zzidVar.zzi = Math.max(i4, zzidVar.zzi);
    }

    public final void zzbb(long j) {
        zzid zzidVar = ((zztp) this).zza;
        zzidVar.zzk += j;
        zzidVar.zzl++;
        this.zzE += j;
        this.zzF++;
    }

    @Override // com.google.android.gms.internal.ads.zzabr
    public final boolean zzbc(long j, long j2, long j3, boolean z, boolean z2) throws zzin {
        int iZzd;
        if (this.zzo != null && this.zzf) {
            j2 -= -this.zzM;
        }
        if (j >= -500000 || z || (iZzd = zzd(j2)) == 0) {
            return false;
        }
        if (z2) {
            zzid zzidVar = ((zztp) this).zza;
            int i = zzidVar.zzd + iZzd;
            zzidVar.zzd = i;
            zzidVar.zzf += this.zzB;
            zzidVar.zzd = this.zzk.size() + i;
        } else {
            ((zztp) this).zza.zzj++;
            zzba(this.zzk.size() + iZzd, this.zzB);
        }
        zzaP();
        zzaco zzacoVar = this.zzo;
        if (zzacoVar != null) {
            zzacoVar.zzj(false);
        }
        return true;
    }

    public final boolean zzbd(zzti zztiVar) {
        if (zzbe(zztiVar.zza)) {
            return false;
        }
        return !zztiVar.zzf || zzabd.zzb(this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzic, com.google.android.gms.internal.ads.zzma
    public final void zzu() {
        zzaco zzacoVar = this.zzo;
        if (zzacoVar == null) {
            this.zzi.zzb();
            return;
        }
        int i = this.zzq;
        if (i == 0 || i == 1) {
            this.zzq = 0;
        } else {
            zzacoVar.zzh();
        }
    }

    @Override // com.google.android.gms.internal.ads.zztp, com.google.android.gms.internal.ads.zzic, com.google.android.gms.internal.ads.zzlv
    public final void zzv(int i, Object obj) throws zzin {
        if (i == 1) {
            zzbm(obj);
            return;
        }
        if (i == 7) {
            obj.getClass();
            zzabp zzabpVar = (zzabp) obj;
            this.zzL = zzabpVar;
            zzaco zzacoVar = this.zzo;
            if (zzacoVar != null) {
                zzacoVar.zzv(zzabpVar);
                return;
            }
            return;
        }
        if (i == 10) {
            obj.getClass();
            int iIntValue = ((Integer) obj).intValue();
            if (this.zzK != iIntValue) {
                this.zzK = iIntValue;
                return;
            }
            return;
        }
        if (i == 4) {
            obj.getClass();
            int iIntValue2 = ((Integer) obj).intValue();
            this.zzw = iIntValue2;
            zztf zztfVarZzaF = zzaF();
            if (zztfVarZzaF != null) {
                zztfVarZzaF.zzr(iIntValue2);
                return;
            }
            return;
        }
        if (i == 5) {
            obj.getClass();
            int iIntValue3 = ((Integer) obj).intValue();
            this.zzx = iIntValue3;
            zzaco zzacoVar2 = this.zzo;
            if (zzacoVar2 != null) {
                zzacoVar2.zzq(iIntValue3);
                return;
            } else {
                this.zzi.zzh(iIntValue3);
                return;
            }
        }
        if (i == 13) {
            obj.getClass();
            List list = (List) obj;
            if (list.equals(zzbz.zza)) {
                zzaco zzacoVar3 = this.zzo;
                if (zzacoVar3 == null || !zzacoVar3.zzC()) {
                    return;
                }
                zzacoVar3.zzm();
                return;
            }
            this.zzr = list;
            zzaco zzacoVar4 = this.zzo;
            if (zzacoVar4 != null) {
                zzacoVar4.zzu(list);
                return;
            }
            return;
        }
        if (i == 14) {
            obj.getClass();
            zzeo zzeoVar = (zzeo) obj;
            if (zzeoVar.zzb() == 0 || zzeoVar.zza() == 0) {
                return;
            }
            this.zzu = zzeoVar;
            zzaco zzacoVar5 = this.zzo;
            if (zzacoVar5 != null) {
                Surface surface = this.zzs;
                zzdd.zzb(surface);
                zzacoVar5.zzs(surface, zzeoVar);
                return;
            }
            return;
        }
        switch (i) {
            case 16:
                obj.getClass();
                this.zzJ = ((Integer) obj).intValue();
                zztf zztfVarZzaF2 = zzaF();
                if (zztfVarZzaF2 != null && Build.VERSION.SDK_INT >= 35) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("importance", Math.max(0, -this.zzJ));
                    zztfVarZzaF2.zzq(bundle);
                    break;
                }
                break;
            case 17:
                Surface surface2 = this.zzs;
                zzbm(null);
                obj.getClass();
                ((zzaba) obj).zzv(1, surface2);
                break;
            case 18:
                boolean z = this.zzC != null;
                zzmh zzmhVar = (zzmh) obj;
                this.zzC = zzmhVar;
                if (z != (zzmhVar != null)) {
                    zzaZ();
                }
                break;
            default:
                super.zzv(i, obj);
                break;
        }
    }

    @Override // com.google.android.gms.internal.ads.zztp, com.google.android.gms.internal.ads.zzic
    public final void zzy() {
        this.zzI = null;
        this.zzN = -9223372036854775807L;
        this.zzv = false;
        this.zzD = true;
        try {
            super.zzy();
        } finally {
            zzaci zzaciVar = this.zzg;
            zzaciVar.zzm(((zztp) this).zza);
            zzaciVar.zzt(zzcd.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zztp, com.google.android.gms.internal.ads.zzic
    public final void zzz(boolean z, boolean z2) {
        super.zzz(z, z2);
        zzo();
        this.zzg.zzo(((zztp) this).zza);
        if (!this.zzp) {
            if (this.zzr != null && this.zzo == null) {
                zzabh zzabhVar = new zzabh(this.zze, this.zzi);
                zzabhVar.zze(true);
                zzabhVar.zzd(zzcX());
                zzabo zzaboVarZzf = zzabhVar.zzf();
                zzaboVarZzf.zzt(1);
                this.zzo = zzaboVarZzf.zze(0);
            }
            this.zzp = true;
        }
        int i = !z2 ? 1 : 0;
        zzaco zzacoVar = this.zzo;
        if (zzacoVar == null) {
            zzabs zzabsVar = this.zzi;
            zzabsVar.zzi(zzcX());
            zzabsVar.zzf(i);
            return;
        }
        zzacoVar.zzr(new zzaav(this), zzgef.zzc());
        zzabp zzabpVar = this.zzL;
        if (zzabpVar != null) {
            this.zzo.zzv(zzabpVar);
        }
        if (this.zzs != null && !this.zzu.equals(zzeo.zza)) {
            this.zzo.zzs(this.zzs, this.zzu);
        }
        this.zzo.zzq(this.zzx);
        this.zzo.zzt(zzax());
        List list = this.zzr;
        if (list != null) {
            this.zzo.zzu(list);
        }
        this.zzq = i;
        zzaI();
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0147  */
    /* JADX WARN: Code duplicated, block: B:102:0x014b  */
    /* JADX WARN: Code duplicated, block: B:104:0x0153  */
    /* JADX WARN: Code duplicated, block: B:105:0x0157  */
    /* JADX WARN: Code duplicated, block: B:107:0x015f  */
    /* JADX WARN: Code duplicated, block: B:108:0x0163  */
    /* JADX WARN: Code duplicated, block: B:110:0x016b  */
    /* JADX WARN: Code duplicated, block: B:111:0x016f  */
    /* JADX WARN: Code duplicated, block: B:113:0x0177  */
    /* JADX WARN: Code duplicated, block: B:114:0x017b  */
    /* JADX WARN: Code duplicated, block: B:116:0x0183  */
    /* JADX WARN: Code duplicated, block: B:117:0x0187  */
    /* JADX WARN: Code duplicated, block: B:119:0x018f  */
    /* JADX WARN: Code duplicated, block: B:120:0x0193  */
    /* JADX WARN: Code duplicated, block: B:122:0x019b  */
    /* JADX WARN: Code duplicated, block: B:123:0x019f  */
    /* JADX WARN: Code duplicated, block: B:125:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:126:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:128:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:129:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:131:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:132:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:134:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:135:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:137:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:138:0x01db  */
    /* JADX WARN: Code duplicated, block: B:140:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:141:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:143:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:144:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:146:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:147:0x0200  */
    /* JADX WARN: Code duplicated, block: B:149:0x0208  */
    /* JADX WARN: Code duplicated, block: B:150:0x020c  */
    /* JADX WARN: Code duplicated, block: B:152:0x0214  */
    /* JADX WARN: Code duplicated, block: B:153:0x0218  */
    /* JADX WARN: Code duplicated, block: B:155:0x0220  */
    /* JADX WARN: Code duplicated, block: B:156:0x0224  */
    /* JADX WARN: Code duplicated, block: B:158:0x022c  */
    /* JADX WARN: Code duplicated, block: B:159:0x0230  */
    /* JADX WARN: Code duplicated, block: B:161:0x0238  */
    /* JADX WARN: Code duplicated, block: B:162:0x023c  */
    /* JADX WARN: Code duplicated, block: B:164:0x0244  */
    /* JADX WARN: Code duplicated, block: B:165:0x0248  */
    /* JADX WARN: Code duplicated, block: B:167:0x0250  */
    /* JADX WARN: Code duplicated, block: B:168:0x0254  */
    /* JADX WARN: Code duplicated, block: B:170:0x025c  */
    /* JADX WARN: Code duplicated, block: B:171:0x0260  */
    /* JADX WARN: Code duplicated, block: B:173:0x0268  */
    /* JADX WARN: Code duplicated, block: B:174:0x026c  */
    /* JADX WARN: Code duplicated, block: B:176:0x0274  */
    /* JADX WARN: Code duplicated, block: B:177:0x0278  */
    /* JADX WARN: Code duplicated, block: B:179:0x0280  */
    /* JADX WARN: Code duplicated, block: B:180:0x0284  */
    /* JADX WARN: Code duplicated, block: B:182:0x028c  */
    /* JADX WARN: Code duplicated, block: B:183:0x0290  */
    /* JADX WARN: Code duplicated, block: B:185:0x0298  */
    /* JADX WARN: Code duplicated, block: B:186:0x029c  */
    /* JADX WARN: Code duplicated, block: B:188:0x02a4  */
    /* JADX WARN: Code duplicated, block: B:189:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:191:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:192:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:194:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:195:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:197:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:198:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:200:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:201:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:203:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:204:0x02e4  */
    /* JADX WARN: Code duplicated, block: B:206:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:207:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:209:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:210:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:212:0x0303  */
    /* JADX WARN: Code duplicated, block: B:213:0x0307  */
    /* JADX WARN: Code duplicated, block: B:215:0x030f  */
    /* JADX WARN: Code duplicated, block: B:216:0x0313  */
    /* JADX WARN: Code duplicated, block: B:218:0x031b  */
    /* JADX WARN: Code duplicated, block: B:219:0x031f  */
    /* JADX WARN: Code duplicated, block: B:221:0x0327  */
    /* JADX WARN: Code duplicated, block: B:222:0x032b  */
    /* JADX WARN: Code duplicated, block: B:224:0x0333  */
    /* JADX WARN: Code duplicated, block: B:225:0x0337  */
    /* JADX WARN: Code duplicated, block: B:227:0x033f  */
    /* JADX WARN: Code duplicated, block: B:228:0x0343  */
    /* JADX WARN: Code duplicated, block: B:230:0x034b  */
    /* JADX WARN: Code duplicated, block: B:231:0x034f  */
    /* JADX WARN: Code duplicated, block: B:233:0x0357  */
    /* JADX WARN: Code duplicated, block: B:234:0x035b  */
    /* JADX WARN: Code duplicated, block: B:236:0x0364  */
    /* JADX WARN: Code duplicated, block: B:237:0x0368  */
    /* JADX WARN: Code duplicated, block: B:239:0x0370  */
    /* JADX WARN: Code duplicated, block: B:240:0x0374  */
    /* JADX WARN: Code duplicated, block: B:242:0x037c  */
    /* JADX WARN: Code duplicated, block: B:243:0x0380  */
    /* JADX WARN: Code duplicated, block: B:245:0x0388  */
    /* JADX WARN: Code duplicated, block: B:246:0x038c  */
    /* JADX WARN: Code duplicated, block: B:248:0x0394  */
    /* JADX WARN: Code duplicated, block: B:249:0x0398  */
    /* JADX WARN: Code duplicated, block: B:251:0x03a0  */
    /* JADX WARN: Code duplicated, block: B:252:0x03a4  */
    /* JADX WARN: Code duplicated, block: B:254:0x03ac  */
    /* JADX WARN: Code duplicated, block: B:255:0x03b0  */
    /* JADX WARN: Code duplicated, block: B:257:0x03b8  */
    /* JADX WARN: Code duplicated, block: B:258:0x03bb  */
    /* JADX WARN: Code duplicated, block: B:260:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:261:0x03c7  */
    /* JADX WARN: Code duplicated, block: B:263:0x03cf  */
    /* JADX WARN: Code duplicated, block: B:264:0x03d2  */
    /* JADX WARN: Code duplicated, block: B:266:0x03db  */
    /* JADX WARN: Code duplicated, block: B:267:0x03de  */
    /* JADX WARN: Code duplicated, block: B:269:0x03e6  */
    /* JADX WARN: Code duplicated, block: B:270:0x03ea  */
    /* JADX WARN: Code duplicated, block: B:272:0x03f3  */
    /* JADX WARN: Code duplicated, block: B:273:0x03f7  */
    /* JADX WARN: Code duplicated, block: B:275:0x03ff  */
    /* JADX WARN: Code duplicated, block: B:276:0x0403  */
    /* JADX WARN: Code duplicated, block: B:278:0x040b  */
    /* JADX WARN: Code duplicated, block: B:279:0x040f  */
    /* JADX WARN: Code duplicated, block: B:281:0x0417  */
    /* JADX WARN: Code duplicated, block: B:282:0x041b  */
    /* JADX WARN: Code duplicated, block: B:284:0x0423  */
    /* JADX WARN: Code duplicated, block: B:285:0x0427  */
    /* JADX WARN: Code duplicated, block: B:287:0x042f  */
    /* JADX WARN: Code duplicated, block: B:288:0x0433  */
    /* JADX WARN: Code duplicated, block: B:290:0x043b  */
    /* JADX WARN: Code duplicated, block: B:291:0x043f  */
    /* JADX WARN: Code duplicated, block: B:293:0x0447  */
    /* JADX WARN: Code duplicated, block: B:294:0x044b  */
    /* JADX WARN: Code duplicated, block: B:296:0x0453  */
    /* JADX WARN: Code duplicated, block: B:297:0x0457  */
    /* JADX WARN: Code duplicated, block: B:299:0x045f  */
    /* JADX WARN: Code duplicated, block: B:300:0x0463  */
    /* JADX WARN: Code duplicated, block: B:302:0x046b  */
    /* JADX WARN: Code duplicated, block: B:303:0x046f  */
    /* JADX WARN: Code duplicated, block: B:305:0x0477  */
    /* JADX WARN: Code duplicated, block: B:306:0x047b  */
    /* JADX WARN: Code duplicated, block: B:308:0x0483  */
    /* JADX WARN: Code duplicated, block: B:309:0x0487  */
    /* JADX WARN: Code duplicated, block: B:311:0x048f  */
    /* JADX WARN: Code duplicated, block: B:312:0x0493  */
    /* JADX WARN: Code duplicated, block: B:314:0x049b  */
    /* JADX WARN: Code duplicated, block: B:315:0x049e  */
    /* JADX WARN: Code duplicated, block: B:317:0x04a6  */
    /* JADX WARN: Code duplicated, block: B:318:0x04a9  */
    /* JADX WARN: Code duplicated, block: B:320:0x04b1  */
    /* JADX WARN: Code duplicated, block: B:321:0x04b4  */
    /* JADX WARN: Code duplicated, block: B:323:0x04bc  */
    /* JADX WARN: Code duplicated, block: B:324:0x04c0  */
    /* JADX WARN: Code duplicated, block: B:327:0x04ca  */
    /* JADX WARN: Code duplicated, block: B:329:0x04d2  */
    /* JADX WARN: Code duplicated, block: B:330:0x04d5  */
    /* JADX WARN: Code duplicated, block: B:332:0x04dd  */
    /* JADX WARN: Code duplicated, block: B:333:0x04e0  */
    /* JADX WARN: Code duplicated, block: B:335:0x04e8  */
    /* JADX WARN: Code duplicated, block: B:336:0x04ec  */
    /* JADX WARN: Code duplicated, block: B:338:0x04f4  */
    /* JADX WARN: Code duplicated, block: B:339:0x04f8  */
    /* JADX WARN: Code duplicated, block: B:341:0x0500  */
    /* JADX WARN: Code duplicated, block: B:342:0x0504  */
    /* JADX WARN: Code duplicated, block: B:344:0x050d  */
    /* JADX WARN: Code duplicated, block: B:345:0x0511  */
    /* JADX WARN: Code duplicated, block: B:347:0x0519  */
    /* JADX WARN: Code duplicated, block: B:348:0x051d  */
    /* JADX WARN: Code duplicated, block: B:350:0x0525  */
    /* JADX WARN: Code duplicated, block: B:351:0x0529  */
    /* JADX WARN: Code duplicated, block: B:353:0x0531  */
    /* JADX WARN: Code duplicated, block: B:354:0x0535  */
    /* JADX WARN: Code duplicated, block: B:356:0x053d  */
    /* JADX WARN: Code duplicated, block: B:357:0x0541  */
    /* JADX WARN: Code duplicated, block: B:359:0x0549  */
    /* JADX WARN: Code duplicated, block: B:360:0x054d  */
    /* JADX WARN: Code duplicated, block: B:362:0x0555  */
    /* JADX WARN: Code duplicated, block: B:363:0x0559  */
    /* JADX WARN: Code duplicated, block: B:365:0x0561  */
    /* JADX WARN: Code duplicated, block: B:366:0x0565  */
    /* JADX WARN: Code duplicated, block: B:368:0x056d  */
    /* JADX WARN: Code duplicated, block: B:369:0x0571  */
    /* JADX WARN: Code duplicated, block: B:371:0x0579  */
    /* JADX WARN: Code duplicated, block: B:372:0x057d  */
    /* JADX WARN: Code duplicated, block: B:374:0x0585  */
    /* JADX WARN: Code duplicated, block: B:375:0x0589  */
    /* JADX WARN: Code duplicated, block: B:377:0x0591  */
    /* JADX WARN: Code duplicated, block: B:378:0x0595  */
    /* JADX WARN: Code duplicated, block: B:380:0x059d  */
    /* JADX WARN: Code duplicated, block: B:381:0x05a1  */
    /* JADX WARN: Code duplicated, block: B:383:0x05a9  */
    /* JADX WARN: Code duplicated, block: B:384:0x05ad  */
    /* JADX WARN: Code duplicated, block: B:386:0x05b5  */
    /* JADX WARN: Code duplicated, block: B:387:0x05b9  */
    /* JADX WARN: Code duplicated, block: B:389:0x05c1  */
    /* JADX WARN: Code duplicated, block: B:390:0x05c5  */
    /* JADX WARN: Code duplicated, block: B:392:0x05cd  */
    /* JADX WARN: Code duplicated, block: B:393:0x05d1  */
    /* JADX WARN: Code duplicated, block: B:395:0x05d9  */
    /* JADX WARN: Code duplicated, block: B:396:0x05dd  */
    /* JADX WARN: Code duplicated, block: B:398:0x05e5  */
    /* JADX WARN: Code duplicated, block: B:399:0x05e9  */
    /* JADX WARN: Code duplicated, block: B:401:0x05f1  */
    /* JADX WARN: Code duplicated, block: B:402:0x05f5  */
    /* JADX WARN: Code duplicated, block: B:404:0x05fd  */
    /* JADX WARN: Code duplicated, block: B:405:0x0601  */
    /* JADX WARN: Code duplicated, block: B:407:0x0609  */
    /* JADX WARN: Code duplicated, block: B:408:0x060d  */
    /* JADX WARN: Code duplicated, block: B:410:0x0615  */
    /* JADX WARN: Code duplicated, block: B:411:0x0619  */
    /* JADX WARN: Code duplicated, block: B:413:0x0621  */
    /* JADX WARN: Code duplicated, block: B:414:0x0625  */
    /* JADX WARN: Code duplicated, block: B:416:0x062d  */
    /* JADX WARN: Code duplicated, block: B:417:0x0631  */
    /* JADX WARN: Code duplicated, block: B:419:0x0639  */
    /* JADX WARN: Code duplicated, block: B:41:0x0080 A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:420:0x063d  */
    /* JADX WARN: Code duplicated, block: B:422:0x0646  */
    /* JADX WARN: Code duplicated, block: B:423:0x064a  */
    /* JADX WARN: Code duplicated, block: B:425:0x0652  */
    /* JADX WARN: Code duplicated, block: B:426:0x0656  */
    /* JADX WARN: Code duplicated, block: B:428:0x065e  */
    /* JADX WARN: Code duplicated, block: B:429:0x0661  */
    /* JADX WARN: Code duplicated, block: B:431:0x0669  */
    /* JADX WARN: Code duplicated, block: B:432:0x066c  */
    /* JADX WARN: Code duplicated, block: B:434:0x0674  */
    /* JADX WARN: Code duplicated, block: B:435:0x0678  */
    /* JADX WARN: Code duplicated, block: B:437:0x0680  */
    /* JADX WARN: Code duplicated, block: B:438:0x0684  */
    /* JADX WARN: Code duplicated, block: B:440:0x068c  */
    /* JADX WARN: Code duplicated, block: B:441:0x0690  */
    /* JADX WARN: Code duplicated, block: B:443:0x0698  */
    /* JADX WARN: Code duplicated, block: B:444:0x069c  */
    /* JADX WARN: Code duplicated, block: B:446:0x06a4  */
    /* JADX WARN: Code duplicated, block: B:447:0x06a8  */
    /* JADX WARN: Code duplicated, block: B:449:0x06b0  */
    /* JADX WARN: Code duplicated, block: B:44:0x0086  */
    /* JADX WARN: Code duplicated, block: B:450:0x06b4  */
    /* JADX WARN: Code duplicated, block: B:452:0x06bc  */
    /* JADX WARN: Code duplicated, block: B:453:0x06c0  */
    /* JADX WARN: Code duplicated, block: B:455:0x06c8  */
    /* JADX WARN: Code duplicated, block: B:456:0x06cc  */
    /* JADX WARN: Code duplicated, block: B:458:0x06d4  */
    /* JADX WARN: Code duplicated, block: B:459:0x06d8  */
    /* JADX WARN: Code duplicated, block: B:461:0x06e0  */
    /* JADX WARN: Code duplicated, block: B:462:0x06e4  */
    /* JADX WARN: Code duplicated, block: B:464:0x06ec  */
    /* JADX WARN: Code duplicated, block: B:465:0x06f0  */
    /* JADX WARN: Code duplicated, block: B:467:0x06f8  */
    /* JADX WARN: Code duplicated, block: B:468:0x06fc  */
    /* JADX WARN: Code duplicated, block: B:470:0x0704  */
    /* JADX WARN: Code duplicated, block: B:471:0x0708  */
    /* JADX WARN: Code duplicated, block: B:473:0x0710  */
    /* JADX WARN: Code duplicated, block: B:474:0x0714  */
    /* JADX WARN: Code duplicated, block: B:476:0x071c  */
    /* JADX WARN: Code duplicated, block: B:477:0x0720  */
    /* JADX WARN: Code duplicated, block: B:479:0x0728  */
    /* JADX WARN: Code duplicated, block: B:480:0x072c  */
    /* JADX WARN: Code duplicated, block: B:482:0x0734  */
    /* JADX WARN: Code duplicated, block: B:483:0x0737  */
    /* JADX WARN: Code duplicated, block: B:485:0x073f  */
    /* JADX WARN: Code duplicated, block: B:486:0x0742  */
    /* JADX WARN: Code duplicated, block: B:488:0x074b  */
    /* JADX WARN: Code duplicated, block: B:489:0x074e  */
    /* JADX WARN: Code duplicated, block: B:491:0x0756  */
    /* JADX WARN: Code duplicated, block: B:492:0x0759  */
    /* JADX WARN: Code duplicated, block: B:494:0x0761  */
    /* JADX WARN: Code duplicated, block: B:495:0x0764  */
    /* JADX WARN: Code duplicated, block: B:497:0x076c  */
    /* JADX WARN: Code duplicated, block: B:498:0x076f  */
    /* JADX WARN: Code duplicated, block: B:49:0x0095 A[Catch: all -> 0x0083, TRY_LEAVE, TryCatch #0 {, blocks: (B:7:0x000f, B:9:0x0013, B:11:0x0021, B:516:0x07a8, B:46:0x008a, B:49:0x0095, B:84:0x0104, B:509:0x0794, B:517:0x07ac), top: B:522:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:500:0x0777  */
    /* JADX WARN: Code duplicated, block: B:501:0x077a  */
    /* JADX WARN: Code duplicated, block: B:503:0x0782  */
    /* JADX WARN: Code duplicated, block: B:504:0x0785  */
    /* JADX WARN: Code duplicated, block: B:506:0x078d  */
    /* JADX WARN: Code duplicated, block: B:507:0x0790  */
    /* JADX WARN: Code duplicated, block: B:509:0x0794 A[Catch: all -> 0x0083, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:7:0x000f, B:9:0x0013, B:11:0x0021, B:516:0x07a8, B:46:0x008a, B:49:0x0095, B:84:0x0104, B:509:0x0794, B:517:0x07ac), top: B:522:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:513:0x079e  */
    /* JADX WARN: Code duplicated, block: B:532:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:533:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:534:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:535:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:536:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:537:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:538:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:539:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:540:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:541:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:542:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:543:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:544:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:545:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:546:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:547:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:548:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:549:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:550:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:551:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:552:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:553:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:554:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:555:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:556:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:557:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:558:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:559:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:560:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:561:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:562:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:563:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:564:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:565:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:566:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:567:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:568:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:569:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:570:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:571:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:572:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:573:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:574:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:575:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:576:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:577:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:578:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:579:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:580:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:581:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:582:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:583:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:584:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:585:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:586:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:587:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:588:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:589:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:590:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:591:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:592:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:593:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:594:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:595:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:596:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:597:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:598:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:599:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:600:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:601:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:602:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:603:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:604:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:605:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:606:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:607:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:608:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:609:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:610:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:611:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:612:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:613:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:614:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:615:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:616:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:617:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:618:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:619:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:0x00be  */
    /* JADX WARN: Code duplicated, block: B:620:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:621:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:622:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:623:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:624:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:625:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:626:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:627:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:628:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:629:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:630:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:631:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:632:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:633:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:634:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:635:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:636:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:637:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:638:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:639:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:640:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:641:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:642:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:643:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:644:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:645:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:646:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:647:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:648:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:649:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:650:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:651:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:652:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:653:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:654:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:655:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:656:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:657:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:658:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:659:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:660:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:661:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:662:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:663:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:664:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:665:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:666:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:667:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:668:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:669:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:670:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:671:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:672:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:673:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:674:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:675:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:676:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:677:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:678:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:679:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:680:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:70:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:71:0x00de  */
    /* JADX WARN: Code duplicated, block: B:73:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:74:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:76:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:77:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:79:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:80:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:82:0x0100  */
    /* JADX WARN: Code duplicated, block: B:84:0x0104 A[Catch: all -> 0x0083, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:7:0x000f, B:9:0x0013, B:11:0x0021, B:516:0x07a8, B:46:0x008a, B:49:0x0095, B:84:0x0104, B:509:0x0794, B:517:0x07ac), top: B:522:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:87:0x010f  */
    /* JADX WARN: Code duplicated, block: B:89:0x0117  */
    /* JADX WARN: Code duplicated, block: B:90:0x011b  */
    /* JADX WARN: Code duplicated, block: B:92:0x0123  */
    /* JADX WARN: Code duplicated, block: B:93:0x0127  */
    /* JADX WARN: Code duplicated, block: B:95:0x012f  */
    /* JADX WARN: Code duplicated, block: B:96:0x0133  */
    /* JADX WARN: Code duplicated, block: B:98:0x013b  */
    /* JADX WARN: Code duplicated, block: B:99:0x013f  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final boolean zzbe(String str) {
        String str2;
        byte b;
        String str3;
        byte b2;
        boolean z = false;
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (zzaba.class) {
            if (!zzc) {
                int i = Build.VERSION.SDK_INT;
                byte b3 = 28;
                if (i <= 28) {
                    String str4 = Build.DEVICE;
                    switch (str4.hashCode()) {
                        case -1339091551:
                            b2 = !str4.equals("dangal") ? (byte) -1 : (byte) 1;
                            break;
                        case -1220081023:
                            b2 = !str4.equals("dangalFHD") ? (byte) -1 : (byte) 3;
                            break;
                        case -1220066608:
                            b2 = !str4.equals("dangalUHD") ? (byte) -1 : (byte) 2;
                            break;
                        case -1012436106:
                            b2 = !str4.equals("oneday") ? (byte) -1 : (byte) 7;
                            break;
                        case -760312546:
                            b2 = !str4.equals("aquaman") ? (byte) -1 : (byte) 0;
                            break;
                        case -64886864:
                            b2 = !str4.equals("magnolia") ? (byte) -1 : (byte) 4;
                            break;
                        case 3415681:
                            b2 = !str4.equals("once") ? (byte) -1 : (byte) 6;
                            break;
                        case 825323514:
                            b2 = !str4.equals("machuca") ? (byte) -1 : (byte) 5;
                            break;
                        default:
                            b2 = -1;
                            break;
                    }
                    switch (b2) {
                        default:
                            if (i <= 27 || !"HWEML".equals(Build.DEVICE)) {
                                str2 = Build.MODEL;
                                switch (str2.hashCode()) {
                                    case -349662828:
                                        if (!str2.equals("AFTJMST12")) {
                                            b = -1;
                                        } else {
                                            b = 6;
                                        }
                                        break;
                                    case -321033677:
                                        if (!str2.equals("AFTKMST12")) {
                                            b = -1;
                                        } else {
                                            b = 7;
                                        }
                                        break;
                                    case 2006354:
                                        if (!str2.equals("AFTA")) {
                                            b = -1;
                                        } else {
                                            b = 0;
                                        }
                                        break;
                                    case 2006367:
                                        if (!str2.equals("AFTN")) {
                                            b = -1;
                                        } else {
                                            b = 1;
                                        }
                                        break;
                                    case 2006371:
                                        if (!str2.equals("AFTR")) {
                                            b = -1;
                                        } else {
                                            b = 2;
                                        }
                                        break;
                                    case 1785421873:
                                        if (!str2.equals("AFTEU011")) {
                                            b = -1;
                                        } else {
                                            b = 3;
                                        }
                                        break;
                                    case 1785421876:
                                        if (!str2.equals("AFTEU014")) {
                                            b = -1;
                                        } else {
                                            b = 4;
                                        }
                                        break;
                                    case 1798172390:
                                        if (!str2.equals("AFTSO001")) {
                                            b = -1;
                                        } else {
                                            b = 8;
                                        }
                                        break;
                                    case 2119412532:
                                        if (!str2.equals("AFTEUFF014")) {
                                            b = -1;
                                        } else {
                                            b = 5;
                                        }
                                        break;
                                    default:
                                        b = -1;
                                        break;
                                }
                                switch (b) {
                                    default:
                                        if (i <= 26) {
                                            str3 = Build.DEVICE;
                                            switch (str3.hashCode()) {
                                                case -2144781245:
                                                    if (!str3.equals("GIONEE_SWW1609")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 54;
                                                    }
                                                    break;
                                                case -2144781185:
                                                    if (!str3.equals("GIONEE_SWW1627")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 55;
                                                    }
                                                    break;
                                                case -2144781160:
                                                    if (!str3.equals("GIONEE_SWW1631")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 56;
                                                    }
                                                    break;
                                                case -2097309513:
                                                    if (!str3.equals("K50a40")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 74;
                                                    }
                                                    break;
                                                case -2022874474:
                                                    if (!str3.equals("CP8676_I02")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 22;
                                                    }
                                                    break;
                                                case -1978993182:
                                                    if (!str3.equals("NX541J")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 89;
                                                    }
                                                    break;
                                                case -1978990237:
                                                    if (!str3.equals(oKjScaD.SRSgPqw)) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 90;
                                                    }
                                                    break;
                                                case -1936688988:
                                                    if (!str3.equals("PGN528")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 101;
                                                    }
                                                    break;
                                                case -1936688066:
                                                    if (!str3.equals("PGN610")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 102;
                                                    }
                                                    break;
                                                case -1936688065:
                                                    if (!str3.equals("PGN611")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 103;
                                                    }
                                                    break;
                                                case -1931988508:
                                                    if (!str3.equals("AquaPowerM")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 13;
                                                    }
                                                    break;
                                                case -1885099851:
                                                    if (!str3.equals("RAIJIN")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 116;
                                                    }
                                                    break;
                                                case -1696512866:
                                                    if (!str3.equals("XT1663")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 137;
                                                    }
                                                    break;
                                                case -1680025915:
                                                    if (!str3.equals("ComioS1")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 21;
                                                    }
                                                    break;
                                                case -1615810839:
                                                    if (!str3.equals("Phantom6")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 104;
                                                    }
                                                    break;
                                                case -1600724499:
                                                    if (!str3.equals("pacificrim")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 95;
                                                    }
                                                    break;
                                                case -1554255044:
                                                    if (!str3.equals("vernee_M5")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 130;
                                                    }
                                                    break;
                                                case -1481772737:
                                                    if (!str3.equals("panell_dl")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 97;
                                                    }
                                                    break;
                                                case -1481772730:
                                                    if (!str3.equals("panell_ds")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 98;
                                                    }
                                                    break;
                                                case -1481772729:
                                                    if (!str3.equals("panell_dt")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 99;
                                                    }
                                                    break;
                                                case -1320080169:
                                                    if (!str3.equals("GiONEE_GBL7319")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 52;
                                                    }
                                                    break;
                                                case -1217592143:
                                                    if (!str3.equals("BRAVIA_ATV2")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 18;
                                                    }
                                                    break;
                                                case -1180384755:
                                                    if (!str3.equals("iris60")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 70;
                                                    }
                                                    break;
                                                case -1139198265:
                                                    if (!str3.equals("Slate_Pro")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 118;
                                                    }
                                                    break;
                                                case -1052835013:
                                                    if (!str3.equals("namath")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 87;
                                                    }
                                                    break;
                                                case -993250464:
                                                    if (!str3.equals("A10-70F")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 5;
                                                    }
                                                    break;
                                                case -993250458:
                                                    if (!str3.equals("A10-70L")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 6;
                                                    }
                                                    break;
                                                case -965403638:
                                                    if (!str3.equals("s905x018")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 120;
                                                    }
                                                    break;
                                                case -958336948:
                                                    if (!str3.equals(PZmDzEagKNdW.OgdrJXzS)) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 34;
                                                    }
                                                    break;
                                                case -879245230:
                                                    if (!str3.equals("tcl_eu")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 126;
                                                    }
                                                    break;
                                                case -842500323:
                                                    if (!str3.equals("nicklaus_f")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 88;
                                                    }
                                                    break;
                                                case -821392978:
                                                    if (!str3.equals("A7000-a")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 9;
                                                    }
                                                    break;
                                                case -797483286:
                                                    if (!str3.equals("SVP-DTV15")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 119;
                                                    }
                                                    break;
                                                case -794946968:
                                                    if (!str3.equals("watson")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 131;
                                                    }
                                                    break;
                                                case -788334647:
                                                    if (!str3.equals("whyred")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 132;
                                                    }
                                                    break;
                                                case -782144577:
                                                    if (!str3.equals("OnePlus5T")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 91;
                                                    }
                                                    break;
                                                case -575125681:
                                                    if (!str3.equals("GiONEE_CBL7513")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 51;
                                                    }
                                                    break;
                                                case -521118391:
                                                    if (!str3.equals("GIONEE_GBL7360")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 53;
                                                    }
                                                    break;
                                                case -430914369:
                                                    if (!str3.equals("Pixi4-7_3G")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 105;
                                                    }
                                                    break;
                                                case -290434366:
                                                    if (!str3.equals("taido_row")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 121;
                                                    }
                                                    break;
                                                case -282781963:
                                                    if (!str3.equals("BLACK-1X")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 17;
                                                    }
                                                    break;
                                                case -277133239:
                                                    if (!str3.equals("Z12_PRO")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 138;
                                                    }
                                                    break;
                                                case -173639913:
                                                    if (!str3.equals("ELUGA_A3_Pro")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 31;
                                                    }
                                                    break;
                                                case -56598463:
                                                    if (!str3.equals("woods_fn")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 134;
                                                    }
                                                    break;
                                                case 2126:
                                                    if (!str3.equals("C1")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 20;
                                                    }
                                                    break;
                                                case 2564:
                                                    if (!str3.equals("Q5")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 113;
                                                    }
                                                    break;
                                                case 2715:
                                                    if (!str3.equals("V1")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 127;
                                                    }
                                                    break;
                                                case 2719:
                                                    if (!str3.equals("V5")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 129;
                                                    }
                                                    break;
                                                case 3091:
                                                    if (!str3.equals("b5")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 16;
                                                    }
                                                    break;
                                                case 3483:
                                                    if (!str3.equals("mh")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 84;
                                                    }
                                                    break;
                                                case 73405:
                                                    if (!str3.equals("JGZ")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 73;
                                                    }
                                                    break;
                                                case 75537:
                                                    if (!str3.equals("M04")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 79;
                                                    }
                                                    break;
                                                case 75739:
                                                    if (!str3.equals("M5c")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 80;
                                                    }
                                                    break;
                                                case 76779:
                                                    if (!str3.equals("MX6")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 86;
                                                    }
                                                    break;
                                                case 78669:
                                                    if (!str3.equals(sgtsHsWT.vdseziVRSlQLBj)) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 94;
                                                    }
                                                    break;
                                                case 79305:
                                                    if (!str3.equals("PLE")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 107;
                                                    }
                                                    break;
                                                case 80618:
                                                    if (!str3.equals("QX1")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 115;
                                                    }
                                                    break;
                                                case 88274:
                                                    if (!str3.equals("Z80")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 139;
                                                    }
                                                    break;
                                                case 98846:
                                                    if (!str3.equals("cv1")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 26;
                                                    }
                                                    break;
                                                case 98848:
                                                    if (!str3.equals("cv3")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 27;
                                                    }
                                                    break;
                                                case 99329:
                                                    if (!str3.equals("deb")) {
                                                        b3 = -1;
                                                    }
                                                    break;
                                                case 101481:
                                                    if (!str3.equals("flo")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 49;
                                                    }
                                                    break;
                                                case 1513190:
                                                    if (!str3.equals("1601")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 0;
                                                    }
                                                    break;
                                                case 1514184:
                                                    if (!str3.equals("1713")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 1;
                                                    }
                                                    break;
                                                case 1514185:
                                                    if (!str3.equals("1714")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 2;
                                                    }
                                                    break;
                                                case 2133089:
                                                    if (!str3.equals("F01H")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 36;
                                                    }
                                                    break;
                                                case 2133091:
                                                    if (!str3.equals("F01J")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 37;
                                                    }
                                                    break;
                                                case 2133120:
                                                    if (!str3.equals("F02H")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 38;
                                                    }
                                                    break;
                                                case 2133151:
                                                    if (!str3.equals("F03H")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 39;
                                                    }
                                                    break;
                                                case 2133182:
                                                    if (!str3.equals("F04H")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 40;
                                                    }
                                                    break;
                                                case 2133184:
                                                    if (!str3.equals("F04J")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 41;
                                                    }
                                                    break;
                                                case 2436959:
                                                    if (!str3.equals("P681")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 93;
                                                    }
                                                    break;
                                                case 2463773:
                                                    if (!str3.equals("Q350")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 109;
                                                    }
                                                    break;
                                                case 2464648:
                                                    if (!str3.equals("Q427")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 111;
                                                    }
                                                    break;
                                                case 2689555:
                                                    if (!str3.equals("XE2X")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 136;
                                                    }
                                                    break;
                                                case 3154429:
                                                    if (!str3.equals("fugu")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 50;
                                                    }
                                                    break;
                                                case 3284551:
                                                    if (!str3.equals("kate")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 75;
                                                    }
                                                    break;
                                                case 3351335:
                                                    if (!str3.equals("mido")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 85;
                                                    }
                                                    break;
                                                case 3386211:
                                                    if (!str3.equals(MnHfHMYQDPUO.VKMsUuqz)) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 92;
                                                    }
                                                    break;
                                                case 41325051:
                                                    if (!str3.equals("MEIZU_M5")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 83;
                                                    }
                                                    break;
                                                case 51349633:
                                                    if (!str3.equals(RDFWIi.GAYHqTY)) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 3;
                                                    }
                                                    break;
                                                case 51350594:
                                                    if (!str3.equals("602LV")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 4;
                                                    }
                                                    break;
                                                case 55178625:
                                                    if (!str3.equals("Aura_Note_2")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 15;
                                                    }
                                                    break;
                                                case 61542055:
                                                    if (!str3.equals("A1601")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 7;
                                                    }
                                                    break;
                                                case 65355429:
                                                    if (!str3.equals("E5643")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 30;
                                                    }
                                                    break;
                                                case 66214468:
                                                    if (!str3.equals("F3111")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 42;
                                                    }
                                                    break;
                                                case 66214470:
                                                    if (!str3.equals("F3113")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 43;
                                                    }
                                                    break;
                                                case 66214473:
                                                    if (!str3.equals("F3116")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 44;
                                                    }
                                                    break;
                                                case 66215429:
                                                    if (!str3.equals("F3211")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 45;
                                                    }
                                                    break;
                                                case 66215431:
                                                    if (!str3.equals("F3213")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 46;
                                                    }
                                                    break;
                                                case 66215433:
                                                    if (!str3.equals(JuorMn.wDWQWJESUQtkQ)) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 47;
                                                    }
                                                    break;
                                                case 66216390:
                                                    if (!str3.equals("F3311")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 48;
                                                    }
                                                    break;
                                                case 76402249:
                                                    if (!str3.equals("PRO7S")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 108;
                                                    }
                                                    break;
                                                case 76404105:
                                                    if (!str3.equals("Q4260")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 110;
                                                    }
                                                    break;
                                                case 76404911:
                                                    if (!str3.equals("Q4310")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 112;
                                                    }
                                                    break;
                                                case 80963634:
                                                    if (!str3.equals("V23GB")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 128;
                                                    }
                                                    break;
                                                case 82882791:
                                                    if (!str3.equals("X3_HK")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 135;
                                                    }
                                                    break;
                                                case 98715550:
                                                    if (!str3.equals("i9031")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 67;
                                                    }
                                                    break;
                                                case 101370885:
                                                    if (!str3.equals("l5460")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 76;
                                                    }
                                                    break;
                                                case 102844228:
                                                    if (!str3.equals("le_x6")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 77;
                                                    }
                                                    break;
                                                case 165221241:
                                                    if (!str3.equals("A2016a40")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 8;
                                                    }
                                                    break;
                                                case 182191441:
                                                    if (!str3.equals("CPY83_I00")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 25;
                                                    }
                                                    break;
                                                case 245388979:
                                                    if (!str3.equals("marino_f")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 82;
                                                    }
                                                    break;
                                                case 287431619:
                                                    if (!str3.equals("griffin")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 60;
                                                    }
                                                    break;
                                                case 307593612:
                                                    if (!str3.equals("A7010a48")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 11;
                                                    }
                                                    break;
                                                case 308517133:
                                                    if (!str3.equals("A7020a48")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 12;
                                                    }
                                                    break;
                                                case 316215098:
                                                    if (!str3.equals("TB3-730F")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 122;
                                                    }
                                                    break;
                                                case 316215116:
                                                    if (!str3.equals("TB3-730X")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 123;
                                                    }
                                                    break;
                                                case 316246811:
                                                    if (!str3.equals("TB3-850F")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 124;
                                                    }
                                                    break;
                                                case 316246818:
                                                    if (!str3.equals("TB3-850M")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 125;
                                                    }
                                                    break;
                                                case 407160593:
                                                    if (!str3.equals("Pixi5-10_4G")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 106;
                                                    }
                                                    break;
                                                case 507412548:
                                                    if (!str3.equals("QM16XE_U")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 114;
                                                    }
                                                    break;
                                                case 793982701:
                                                    if (!str3.equals("GIONEE_WBL5708")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 57;
                                                    }
                                                    break;
                                                case 794038622:
                                                    if (!str3.equals("GIONEE_WBL7365")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 58;
                                                    }
                                                    break;
                                                case 794040393:
                                                    if (!str3.equals("GIONEE_WBL7519")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 59;
                                                    }
                                                    break;
                                                case 835649806:
                                                    if (!str3.equals("manning")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 81;
                                                    }
                                                    break;
                                                case 917340916:
                                                    if (!str3.equals("A7000plus")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 10;
                                                    }
                                                    break;
                                                case 958008161:
                                                    if (!str3.equals("j2xlteins")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 72;
                                                    }
                                                    break;
                                                case 1060579533:
                                                    if (!str3.equals("panell_d")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 96;
                                                    }
                                                    break;
                                                case 1150207623:
                                                    if (!str3.equals("LS-5017")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 78;
                                                    }
                                                    break;
                                                case 1176899427:
                                                    if (!str3.equals("itel_S41")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 71;
                                                    }
                                                    break;
                                                case 1280332038:
                                                    if (!str3.equals("hwALE-H")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 62;
                                                    }
                                                    break;
                                                case 1306947716:
                                                    if (!str3.equals(DYYbQc.umvG)) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 35;
                                                    }
                                                    break;
                                                case 1349174697:
                                                    if (!str3.equals("htc_e56ml_dtul")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 61;
                                                    }
                                                    break;
                                                case 1522194893:
                                                    if (!str3.equals("woods_f")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 133;
                                                    }
                                                    break;
                                                case 1691543273:
                                                    if (!str3.equals("CPH1609")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 23;
                                                    }
                                                    break;
                                                case 1691544261:
                                                    if (!str3.equals("CPH1715")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 24;
                                                    }
                                                    break;
                                                case 1709443163:
                                                    if (!str3.equals("iball8735_9806")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 68;
                                                    }
                                                    break;
                                                case 1865889110:
                                                    if (!str3.equals("santoni")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 117;
                                                    }
                                                    break;
                                                case 1906253259:
                                                    if (!str3.equals("PB2-670M")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 100;
                                                    }
                                                    break;
                                                case 1977196784:
                                                    if (!str3.equals("Infinix-X572")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 69;
                                                    }
                                                    break;
                                                case 2006372676:
                                                    if (!str3.equals("BRAVIA_ATV3_4K")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 19;
                                                    }
                                                    break;
                                                case 2019281702:
                                                    if (!str3.equals("DM-01K")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 29;
                                                    }
                                                    break;
                                                case 2029784656:
                                                    if (!str3.equals("HWBLN-H")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 63;
                                                    }
                                                    break;
                                                case 2030379515:
                                                    if (!str3.equals("HWCAM-H")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 64;
                                                    }
                                                    break;
                                                case 2033393791:
                                                    if (!str3.equals("ASUS_X00AD_2")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 14;
                                                    }
                                                    break;
                                                case 2047190025:
                                                    if (!str3.equals("ELUGA_Note")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 32;
                                                    }
                                                    break;
                                                case 2047252157:
                                                    if (!str3.equals("ELUGA_Prim")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 33;
                                                    }
                                                    break;
                                                case 2048319463:
                                                    if (!str3.equals("HWVNS-H")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 65;
                                                    }
                                                    break;
                                                case 2048855701:
                                                    if (!str3.equals("HWWAS-H")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 66;
                                                    }
                                                    break;
                                                default:
                                                    b3 = -1;
                                                    break;
                                            }
                                            switch (b3) {
                                                default:
                                                    if (str2.hashCode() == -594534941 && str2.equals("JSN-L21")) {
                                                    }
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
                                                case 34:
                                                case DescriptorProtos.MethodOptions.FEATURES_FIELD_NUMBER /* 35 */:
                                                case DescriptorProtos.FileOptions.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                                                case DescriptorProtos.FileOptions.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                                                case 38:
                                                case DescriptorProtos.FileOptions.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                                                case DescriptorProtos.FileOptions.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                                                case DescriptorProtos.FileOptions.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                                                case 42:
                                                case 43:
                                                case DescriptorProtos.FileOptions.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                                                case DescriptorProtos.FileOptions.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                                                case 46:
                                                case 47:
                                                case 48:
                                                case 49:
                                                case 50:
                                                case 51:
                                                case 52:
                                                case 53:
                                                case 54:
                                                case 55:
                                                case 56:
                                                case 57:
                                                case 58:
                                                case 59:
                                                case 60:
                                                case 61:
                                                case 62:
                                                case 63:
                                                case 64:
                                                case 65:
                                                case GooglePlayBillingEnums.EVENT_OTHER_WEB_IAP /* 66 */:
                                                case 67:
                                                case 68:
                                                case 69:
                                                case 70:
                                                case 71:
                                                case 72:
                                                case 73:
                                                case 74:
                                                case 75:
                                                case 76:
                                                case 77:
                                                case 78:
                                                case 79:
                                                case 80:
                                                case 81:
                                                case 82:
                                                case 83:
                                                case 84:
                                                case 85:
                                                case ModuleDescriptor.MODULE_VERSION /* 86 */:
                                                case 87:
                                                case 88:
                                                case 89:
                                                case 90:
                                                case 91:
                                                case 92:
                                                case 93:
                                                case 94:
                                                case 95:
                                                case 96:
                                                case 97:
                                                case 98:
                                                case TOSS_VERYHIGH_VALUE:
                                                case TOSS_SODAM_VALUE:
                                                case 101:
                                                case TOSS_OPEN_MASKED_SOLHWA_VALUE:
                                                case TOSS_OPEN_BALANCED_VALUE:
                                                case TOSS_FIXED_LOW_FOR_BEGINNER_VALUE:
                                                case TOSS_NETUPOPEN_VALUE:
                                                case TOSS_NETUPC_VALUE:
                                                case TOSS_SPOTLIGHT_VALUE:
                                                case TOSS_FIXED_MED_FOR_BEGINNER_VALUE:
                                                case 109:
                                                case 110:
                                                case 111:
                                                case 112:
                                                case 113:
                                                case 114:
                                                case 115:
                                                case 116:
                                                case 117:
                                                case 118:
                                                case 119:
                                                case 120:
                                                case 121:
                                                case 122:
                                                case 123:
                                                case 124:
                                                case 125:
                                                case 126:
                                                case 127:
                                                case 128:
                                                case 129:
                                                case 130:
                                                case 131:
                                                case 132:
                                                case 133:
                                                case 134:
                                                case 135:
                                                case 136:
                                                case 137:
                                                case 138:
                                                case 139:
                                                    z = true;
                                                    break;
                                            }
                                        }
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                        z = true;
                                        break;
                                }
                            }
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                            z = true;
                            break;
                    }
                } else if (i <= 27) {
                    str2 = Build.MODEL;
                    switch (str2.hashCode()) {
                        case -349662828:
                            if (!str2.equals("AFTJMST12")) {
                                b = -1;
                            } else {
                                b = 6;
                            }
                            break;
                        case -321033677:
                            if (!str2.equals("AFTKMST12")) {
                                b = -1;
                            } else {
                                b = 7;
                            }
                            break;
                        case 2006354:
                            if (!str2.equals("AFTA")) {
                                b = -1;
                            } else {
                                b = 0;
                            }
                            break;
                        case 2006367:
                            if (!str2.equals("AFTN")) {
                                b = -1;
                            } else {
                                b = 1;
                            }
                            break;
                        case 2006371:
                            if (!str2.equals("AFTR")) {
                                b = -1;
                            } else {
                                b = 2;
                            }
                            break;
                        case 1785421873:
                            if (!str2.equals("AFTEU011")) {
                                b = -1;
                            } else {
                                b = 3;
                            }
                            break;
                        case 1785421876:
                            if (!str2.equals("AFTEU014")) {
                                b = -1;
                            } else {
                                b = 4;
                            }
                            break;
                        case 1798172390:
                            if (!str2.equals("AFTSO001")) {
                                b = -1;
                            } else {
                                b = 8;
                            }
                            break;
                        case 2119412532:
                            if (!str2.equals("AFTEUFF014")) {
                                b = -1;
                            } else {
                                b = 5;
                            }
                            break;
                        default:
                            b = -1;
                            break;
                    }
                    switch (b) {
                        default:
                            if (i <= 26) {
                                str3 = Build.DEVICE;
                                switch (str3.hashCode()) {
                                    case -2144781245:
                                        if (!str3.equals("GIONEE_SWW1609")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 54;
                                        }
                                        break;
                                    case -2144781185:
                                        if (!str3.equals("GIONEE_SWW1627")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 55;
                                        }
                                        break;
                                    case -2144781160:
                                        if (!str3.equals("GIONEE_SWW1631")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 56;
                                        }
                                        break;
                                    case -2097309513:
                                        if (!str3.equals("K50a40")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 74;
                                        }
                                        break;
                                    case -2022874474:
                                        if (!str3.equals("CP8676_I02")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 22;
                                        }
                                        break;
                                    case -1978993182:
                                        if (!str3.equals("NX541J")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 89;
                                        }
                                        break;
                                    case -1978990237:
                                        if (!str3.equals(oKjScaD.SRSgPqw)) {
                                            b3 = -1;
                                        } else {
                                            b3 = 90;
                                        }
                                        break;
                                    case -1936688988:
                                        if (!str3.equals("PGN528")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 101;
                                        }
                                        break;
                                    case -1936688066:
                                        if (!str3.equals("PGN610")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 102;
                                        }
                                        break;
                                    case -1936688065:
                                        if (!str3.equals("PGN611")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 103;
                                        }
                                        break;
                                    case -1931988508:
                                        if (!str3.equals("AquaPowerM")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 13;
                                        }
                                        break;
                                    case -1885099851:
                                        if (!str3.equals("RAIJIN")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 116;
                                        }
                                        break;
                                    case -1696512866:
                                        if (!str3.equals("XT1663")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 137;
                                        }
                                        break;
                                    case -1680025915:
                                        if (!str3.equals("ComioS1")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 21;
                                        }
                                        break;
                                    case -1615810839:
                                        if (!str3.equals("Phantom6")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 104;
                                        }
                                        break;
                                    case -1600724499:
                                        if (!str3.equals("pacificrim")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 95;
                                        }
                                        break;
                                    case -1554255044:
                                        if (!str3.equals("vernee_M5")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 130;
                                        }
                                        break;
                                    case -1481772737:
                                        if (!str3.equals("panell_dl")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 97;
                                        }
                                        break;
                                    case -1481772730:
                                        if (!str3.equals("panell_ds")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 98;
                                        }
                                        break;
                                    case -1481772729:
                                        if (!str3.equals("panell_dt")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 99;
                                        }
                                        break;
                                    case -1320080169:
                                        if (!str3.equals("GiONEE_GBL7319")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 52;
                                        }
                                        break;
                                    case -1217592143:
                                        if (!str3.equals("BRAVIA_ATV2")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 18;
                                        }
                                        break;
                                    case -1180384755:
                                        if (!str3.equals("iris60")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 70;
                                        }
                                        break;
                                    case -1139198265:
                                        if (!str3.equals("Slate_Pro")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 118;
                                        }
                                        break;
                                    case -1052835013:
                                        if (!str3.equals("namath")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 87;
                                        }
                                        break;
                                    case -993250464:
                                        if (!str3.equals("A10-70F")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 5;
                                        }
                                        break;
                                    case -993250458:
                                        if (!str3.equals("A10-70L")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 6;
                                        }
                                        break;
                                    case -965403638:
                                        if (!str3.equals("s905x018")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 120;
                                        }
                                        break;
                                    case -958336948:
                                        if (!str3.equals(PZmDzEagKNdW.OgdrJXzS)) {
                                            b3 = -1;
                                        } else {
                                            b3 = 34;
                                        }
                                        break;
                                    case -879245230:
                                        if (!str3.equals("tcl_eu")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 126;
                                        }
                                        break;
                                    case -842500323:
                                        if (!str3.equals("nicklaus_f")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 88;
                                        }
                                        break;
                                    case -821392978:
                                        if (!str3.equals("A7000-a")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 9;
                                        }
                                        break;
                                    case -797483286:
                                        if (!str3.equals("SVP-DTV15")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 119;
                                        }
                                        break;
                                    case -794946968:
                                        if (!str3.equals("watson")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 131;
                                        }
                                        break;
                                    case -788334647:
                                        if (!str3.equals("whyred")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 132;
                                        }
                                        break;
                                    case -782144577:
                                        if (!str3.equals("OnePlus5T")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 91;
                                        }
                                        break;
                                    case -575125681:
                                        if (!str3.equals("GiONEE_CBL7513")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 51;
                                        }
                                        break;
                                    case -521118391:
                                        if (!str3.equals("GIONEE_GBL7360")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 53;
                                        }
                                        break;
                                    case -430914369:
                                        if (!str3.equals("Pixi4-7_3G")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 105;
                                        }
                                        break;
                                    case -290434366:
                                        if (!str3.equals("taido_row")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 121;
                                        }
                                        break;
                                    case -282781963:
                                        if (!str3.equals("BLACK-1X")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 17;
                                        }
                                        break;
                                    case -277133239:
                                        if (!str3.equals("Z12_PRO")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 138;
                                        }
                                        break;
                                    case -173639913:
                                        if (!str3.equals("ELUGA_A3_Pro")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 31;
                                        }
                                        break;
                                    case -56598463:
                                        if (!str3.equals("woods_fn")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 134;
                                        }
                                        break;
                                    case 2126:
                                        if (!str3.equals("C1")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 20;
                                        }
                                        break;
                                    case 2564:
                                        if (!str3.equals("Q5")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 113;
                                        }
                                        break;
                                    case 2715:
                                        if (!str3.equals("V1")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 127;
                                        }
                                        break;
                                    case 2719:
                                        if (!str3.equals("V5")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 129;
                                        }
                                        break;
                                    case 3091:
                                        if (!str3.equals("b5")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 16;
                                        }
                                        break;
                                    case 3483:
                                        if (!str3.equals("mh")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 84;
                                        }
                                        break;
                                    case 73405:
                                        if (!str3.equals("JGZ")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 73;
                                        }
                                        break;
                                    case 75537:
                                        if (!str3.equals("M04")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 79;
                                        }
                                        break;
                                    case 75739:
                                        if (!str3.equals("M5c")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 80;
                                        }
                                        break;
                                    case 76779:
                                        if (!str3.equals("MX6")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 86;
                                        }
                                        break;
                                    case 78669:
                                        if (!str3.equals(sgtsHsWT.vdseziVRSlQLBj)) {
                                            b3 = -1;
                                        } else {
                                            b3 = 94;
                                        }
                                        break;
                                    case 79305:
                                        if (!str3.equals("PLE")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 107;
                                        }
                                        break;
                                    case 80618:
                                        if (!str3.equals("QX1")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 115;
                                        }
                                        break;
                                    case 88274:
                                        if (!str3.equals("Z80")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 139;
                                        }
                                        break;
                                    case 98846:
                                        if (!str3.equals("cv1")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 26;
                                        }
                                        break;
                                    case 98848:
                                        if (!str3.equals("cv3")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 27;
                                        }
                                        break;
                                    case 99329:
                                        if (!str3.equals("deb")) {
                                            b3 = -1;
                                        }
                                        break;
                                    case 101481:
                                        if (!str3.equals("flo")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 49;
                                        }
                                        break;
                                    case 1513190:
                                        if (!str3.equals("1601")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 0;
                                        }
                                        break;
                                    case 1514184:
                                        if (!str3.equals("1713")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 1;
                                        }
                                        break;
                                    case 1514185:
                                        if (!str3.equals("1714")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 2;
                                        }
                                        break;
                                    case 2133089:
                                        if (!str3.equals("F01H")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 36;
                                        }
                                        break;
                                    case 2133091:
                                        if (!str3.equals("F01J")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 37;
                                        }
                                        break;
                                    case 2133120:
                                        if (!str3.equals("F02H")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 38;
                                        }
                                        break;
                                    case 2133151:
                                        if (!str3.equals("F03H")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 39;
                                        }
                                        break;
                                    case 2133182:
                                        if (!str3.equals("F04H")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 40;
                                        }
                                        break;
                                    case 2133184:
                                        if (!str3.equals("F04J")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 41;
                                        }
                                        break;
                                    case 2436959:
                                        if (!str3.equals("P681")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 93;
                                        }
                                        break;
                                    case 2463773:
                                        if (!str3.equals("Q350")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 109;
                                        }
                                        break;
                                    case 2464648:
                                        if (!str3.equals("Q427")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 111;
                                        }
                                        break;
                                    case 2689555:
                                        if (!str3.equals("XE2X")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 136;
                                        }
                                        break;
                                    case 3154429:
                                        if (!str3.equals("fugu")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 50;
                                        }
                                        break;
                                    case 3284551:
                                        if (!str3.equals("kate")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 75;
                                        }
                                        break;
                                    case 3351335:
                                        if (!str3.equals("mido")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 85;
                                        }
                                        break;
                                    case 3386211:
                                        if (!str3.equals(MnHfHMYQDPUO.VKMsUuqz)) {
                                            b3 = -1;
                                        } else {
                                            b3 = 92;
                                        }
                                        break;
                                    case 41325051:
                                        if (!str3.equals("MEIZU_M5")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 83;
                                        }
                                        break;
                                    case 51349633:
                                        if (!str3.equals(RDFWIi.GAYHqTY)) {
                                            b3 = -1;
                                        } else {
                                            b3 = 3;
                                        }
                                        break;
                                    case 51350594:
                                        if (!str3.equals("602LV")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 4;
                                        }
                                        break;
                                    case 55178625:
                                        if (!str3.equals("Aura_Note_2")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 15;
                                        }
                                        break;
                                    case 61542055:
                                        if (!str3.equals("A1601")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 7;
                                        }
                                        break;
                                    case 65355429:
                                        if (!str3.equals("E5643")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 30;
                                        }
                                        break;
                                    case 66214468:
                                        if (!str3.equals("F3111")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 42;
                                        }
                                        break;
                                    case 66214470:
                                        if (!str3.equals("F3113")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 43;
                                        }
                                        break;
                                    case 66214473:
                                        if (!str3.equals("F3116")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 44;
                                        }
                                        break;
                                    case 66215429:
                                        if (!str3.equals("F3211")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 45;
                                        }
                                        break;
                                    case 66215431:
                                        if (!str3.equals("F3213")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 46;
                                        }
                                        break;
                                    case 66215433:
                                        if (!str3.equals(JuorMn.wDWQWJESUQtkQ)) {
                                            b3 = -1;
                                        } else {
                                            b3 = 47;
                                        }
                                        break;
                                    case 66216390:
                                        if (!str3.equals("F3311")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 48;
                                        }
                                        break;
                                    case 76402249:
                                        if (!str3.equals("PRO7S")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 108;
                                        }
                                        break;
                                    case 76404105:
                                        if (!str3.equals("Q4260")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 110;
                                        }
                                        break;
                                    case 76404911:
                                        if (!str3.equals("Q4310")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 112;
                                        }
                                        break;
                                    case 80963634:
                                        if (!str3.equals("V23GB")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 128;
                                        }
                                        break;
                                    case 82882791:
                                        if (!str3.equals("X3_HK")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 135;
                                        }
                                        break;
                                    case 98715550:
                                        if (!str3.equals("i9031")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 67;
                                        }
                                        break;
                                    case 101370885:
                                        if (!str3.equals("l5460")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 76;
                                        }
                                        break;
                                    case 102844228:
                                        if (!str3.equals("le_x6")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 77;
                                        }
                                        break;
                                    case 165221241:
                                        if (!str3.equals("A2016a40")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 8;
                                        }
                                        break;
                                    case 182191441:
                                        if (!str3.equals("CPY83_I00")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 25;
                                        }
                                        break;
                                    case 245388979:
                                        if (!str3.equals("marino_f")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 82;
                                        }
                                        break;
                                    case 287431619:
                                        if (!str3.equals("griffin")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 60;
                                        }
                                        break;
                                    case 307593612:
                                        if (!str3.equals("A7010a48")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 11;
                                        }
                                        break;
                                    case 308517133:
                                        if (!str3.equals("A7020a48")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 12;
                                        }
                                        break;
                                    case 316215098:
                                        if (!str3.equals("TB3-730F")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 122;
                                        }
                                        break;
                                    case 316215116:
                                        if (!str3.equals("TB3-730X")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 123;
                                        }
                                        break;
                                    case 316246811:
                                        if (!str3.equals("TB3-850F")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 124;
                                        }
                                        break;
                                    case 316246818:
                                        if (!str3.equals("TB3-850M")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 125;
                                        }
                                        break;
                                    case 407160593:
                                        if (!str3.equals("Pixi5-10_4G")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 106;
                                        }
                                        break;
                                    case 507412548:
                                        if (!str3.equals("QM16XE_U")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 114;
                                        }
                                        break;
                                    case 793982701:
                                        if (!str3.equals("GIONEE_WBL5708")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 57;
                                        }
                                        break;
                                    case 794038622:
                                        if (!str3.equals("GIONEE_WBL7365")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 58;
                                        }
                                        break;
                                    case 794040393:
                                        if (!str3.equals("GIONEE_WBL7519")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 59;
                                        }
                                        break;
                                    case 835649806:
                                        if (!str3.equals("manning")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 81;
                                        }
                                        break;
                                    case 917340916:
                                        if (!str3.equals("A7000plus")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 10;
                                        }
                                        break;
                                    case 958008161:
                                        if (!str3.equals("j2xlteins")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 72;
                                        }
                                        break;
                                    case 1060579533:
                                        if (!str3.equals("panell_d")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 96;
                                        }
                                        break;
                                    case 1150207623:
                                        if (!str3.equals("LS-5017")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 78;
                                        }
                                        break;
                                    case 1176899427:
                                        if (!str3.equals("itel_S41")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 71;
                                        }
                                        break;
                                    case 1280332038:
                                        if (!str3.equals("hwALE-H")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 62;
                                        }
                                        break;
                                    case 1306947716:
                                        if (!str3.equals(DYYbQc.umvG)) {
                                            b3 = -1;
                                        } else {
                                            b3 = 35;
                                        }
                                        break;
                                    case 1349174697:
                                        if (!str3.equals("htc_e56ml_dtul")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 61;
                                        }
                                        break;
                                    case 1522194893:
                                        if (!str3.equals("woods_f")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 133;
                                        }
                                        break;
                                    case 1691543273:
                                        if (!str3.equals("CPH1609")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 23;
                                        }
                                        break;
                                    case 1691544261:
                                        if (!str3.equals("CPH1715")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 24;
                                        }
                                        break;
                                    case 1709443163:
                                        if (!str3.equals("iball8735_9806")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 68;
                                        }
                                        break;
                                    case 1865889110:
                                        if (!str3.equals("santoni")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 117;
                                        }
                                        break;
                                    case 1906253259:
                                        if (!str3.equals("PB2-670M")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 100;
                                        }
                                        break;
                                    case 1977196784:
                                        if (!str3.equals("Infinix-X572")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 69;
                                        }
                                        break;
                                    case 2006372676:
                                        if (!str3.equals("BRAVIA_ATV3_4K")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 19;
                                        }
                                        break;
                                    case 2019281702:
                                        if (!str3.equals("DM-01K")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 29;
                                        }
                                        break;
                                    case 2029784656:
                                        if (!str3.equals("HWBLN-H")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 63;
                                        }
                                        break;
                                    case 2030379515:
                                        if (!str3.equals("HWCAM-H")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 64;
                                        }
                                        break;
                                    case 2033393791:
                                        if (!str3.equals("ASUS_X00AD_2")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 14;
                                        }
                                        break;
                                    case 2047190025:
                                        if (!str3.equals("ELUGA_Note")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 32;
                                        }
                                        break;
                                    case 2047252157:
                                        if (!str3.equals("ELUGA_Prim")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 33;
                                        }
                                        break;
                                    case 2048319463:
                                        if (!str3.equals("HWVNS-H")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 65;
                                        }
                                        break;
                                    case 2048855701:
                                        if (!str3.equals("HWWAS-H")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 66;
                                        }
                                        break;
                                    default:
                                        b3 = -1;
                                        break;
                                }
                                switch (b3) {
                                    default:
                                        if (str2.hashCode() == -594534941) {
                                            break;
                                        }
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
                                    case 34:
                                    case DescriptorProtos.MethodOptions.FEATURES_FIELD_NUMBER /* 35 */:
                                    case DescriptorProtos.FileOptions.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                                    case DescriptorProtos.FileOptions.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                                    case 38:
                                    case DescriptorProtos.FileOptions.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                                    case DescriptorProtos.FileOptions.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                                    case DescriptorProtos.FileOptions.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                                    case 42:
                                    case 43:
                                    case DescriptorProtos.FileOptions.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                                    case DescriptorProtos.FileOptions.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                                    case 46:
                                    case 47:
                                    case 48:
                                    case 49:
                                    case 50:
                                    case 51:
                                    case 52:
                                    case 53:
                                    case 54:
                                    case 55:
                                    case 56:
                                    case 57:
                                    case 58:
                                    case 59:
                                    case 60:
                                    case 61:
                                    case 62:
                                    case 63:
                                    case 64:
                                    case 65:
                                    case GooglePlayBillingEnums.EVENT_OTHER_WEB_IAP /* 66 */:
                                    case 67:
                                    case 68:
                                    case 69:
                                    case 70:
                                    case 71:
                                    case 72:
                                    case 73:
                                    case 74:
                                    case 75:
                                    case 76:
                                    case 77:
                                    case 78:
                                    case 79:
                                    case 80:
                                    case 81:
                                    case 82:
                                    case 83:
                                    case 84:
                                    case 85:
                                    case ModuleDescriptor.MODULE_VERSION /* 86 */:
                                    case 87:
                                    case 88:
                                    case 89:
                                    case 90:
                                    case 91:
                                    case 92:
                                    case 93:
                                    case 94:
                                    case 95:
                                    case 96:
                                    case 97:
                                    case 98:
                                    case TOSS_VERYHIGH_VALUE:
                                    case TOSS_SODAM_VALUE:
                                    case 101:
                                    case TOSS_OPEN_MASKED_SOLHWA_VALUE:
                                    case TOSS_OPEN_BALANCED_VALUE:
                                    case TOSS_FIXED_LOW_FOR_BEGINNER_VALUE:
                                    case TOSS_NETUPOPEN_VALUE:
                                    case TOSS_NETUPC_VALUE:
                                    case TOSS_SPOTLIGHT_VALUE:
                                    case TOSS_FIXED_MED_FOR_BEGINNER_VALUE:
                                    case 109:
                                    case 110:
                                    case 111:
                                    case 112:
                                    case 113:
                                    case 114:
                                    case 115:
                                    case 116:
                                    case 117:
                                    case 118:
                                    case 119:
                                    case 120:
                                    case 121:
                                    case 122:
                                    case 123:
                                    case 124:
                                    case 125:
                                    case 126:
                                    case 127:
                                    case 128:
                                    case 129:
                                    case 130:
                                    case 131:
                                    case 132:
                                    case 133:
                                    case 134:
                                    case 135:
                                    case 136:
                                    case 137:
                                    case 138:
                                    case 139:
                                        z = true;
                                        break;
                                }
                            }
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                            z = true;
                            break;
                    }
                } else {
                    str2 = Build.MODEL;
                    switch (str2.hashCode()) {
                        case -349662828:
                            if (!str2.equals("AFTJMST12")) {
                                b = -1;
                            } else {
                                b = 6;
                            }
                            break;
                        case -321033677:
                            if (!str2.equals("AFTKMST12")) {
                                b = -1;
                            } else {
                                b = 7;
                            }
                            break;
                        case 2006354:
                            if (!str2.equals("AFTA")) {
                                b = -1;
                            } else {
                                b = 0;
                            }
                            break;
                        case 2006367:
                            if (!str2.equals("AFTN")) {
                                b = -1;
                            } else {
                                b = 1;
                            }
                            break;
                        case 2006371:
                            if (!str2.equals("AFTR")) {
                                b = -1;
                            } else {
                                b = 2;
                            }
                            break;
                        case 1785421873:
                            if (!str2.equals("AFTEU011")) {
                                b = -1;
                            } else {
                                b = 3;
                            }
                            break;
                        case 1785421876:
                            if (!str2.equals("AFTEU014")) {
                                b = -1;
                            } else {
                                b = 4;
                            }
                            break;
                        case 1798172390:
                            if (!str2.equals("AFTSO001")) {
                                b = -1;
                            } else {
                                b = 8;
                            }
                            break;
                        case 2119412532:
                            if (!str2.equals("AFTEUFF014")) {
                                b = -1;
                            } else {
                                b = 5;
                            }
                            break;
                        default:
                            b = -1;
                            break;
                    }
                    switch (b) {
                        default:
                            if (i <= 26) {
                                str3 = Build.DEVICE;
                                switch (str3.hashCode()) {
                                    case -2144781245:
                                        if (!str3.equals("GIONEE_SWW1609")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 54;
                                        }
                                        break;
                                    case -2144781185:
                                        if (!str3.equals("GIONEE_SWW1627")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 55;
                                        }
                                        break;
                                    case -2144781160:
                                        if (!str3.equals("GIONEE_SWW1631")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 56;
                                        }
                                        break;
                                    case -2097309513:
                                        if (!str3.equals("K50a40")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 74;
                                        }
                                        break;
                                    case -2022874474:
                                        if (!str3.equals("CP8676_I02")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 22;
                                        }
                                        break;
                                    case -1978993182:
                                        if (!str3.equals("NX541J")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 89;
                                        }
                                        break;
                                    case -1978990237:
                                        if (!str3.equals(oKjScaD.SRSgPqw)) {
                                            b3 = -1;
                                        } else {
                                            b3 = 90;
                                        }
                                        break;
                                    case -1936688988:
                                        if (!str3.equals("PGN528")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 101;
                                        }
                                        break;
                                    case -1936688066:
                                        if (!str3.equals("PGN610")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 102;
                                        }
                                        break;
                                    case -1936688065:
                                        if (!str3.equals("PGN611")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 103;
                                        }
                                        break;
                                    case -1931988508:
                                        if (!str3.equals("AquaPowerM")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 13;
                                        }
                                        break;
                                    case -1885099851:
                                        if (!str3.equals("RAIJIN")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 116;
                                        }
                                        break;
                                    case -1696512866:
                                        if (!str3.equals("XT1663")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 137;
                                        }
                                        break;
                                    case -1680025915:
                                        if (!str3.equals("ComioS1")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 21;
                                        }
                                        break;
                                    case -1615810839:
                                        if (!str3.equals("Phantom6")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 104;
                                        }
                                        break;
                                    case -1600724499:
                                        if (!str3.equals("pacificrim")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 95;
                                        }
                                        break;
                                    case -1554255044:
                                        if (!str3.equals("vernee_M5")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 130;
                                        }
                                        break;
                                    case -1481772737:
                                        if (!str3.equals("panell_dl")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 97;
                                        }
                                        break;
                                    case -1481772730:
                                        if (!str3.equals("panell_ds")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 98;
                                        }
                                        break;
                                    case -1481772729:
                                        if (!str3.equals("panell_dt")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 99;
                                        }
                                        break;
                                    case -1320080169:
                                        if (!str3.equals("GiONEE_GBL7319")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 52;
                                        }
                                        break;
                                    case -1217592143:
                                        if (!str3.equals("BRAVIA_ATV2")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 18;
                                        }
                                        break;
                                    case -1180384755:
                                        if (!str3.equals("iris60")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 70;
                                        }
                                        break;
                                    case -1139198265:
                                        if (!str3.equals("Slate_Pro")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 118;
                                        }
                                        break;
                                    case -1052835013:
                                        if (!str3.equals("namath")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 87;
                                        }
                                        break;
                                    case -993250464:
                                        if (!str3.equals("A10-70F")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 5;
                                        }
                                        break;
                                    case -993250458:
                                        if (!str3.equals("A10-70L")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 6;
                                        }
                                        break;
                                    case -965403638:
                                        if (!str3.equals("s905x018")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 120;
                                        }
                                        break;
                                    case -958336948:
                                        if (!str3.equals(PZmDzEagKNdW.OgdrJXzS)) {
                                            b3 = -1;
                                        } else {
                                            b3 = 34;
                                        }
                                        break;
                                    case -879245230:
                                        if (!str3.equals("tcl_eu")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 126;
                                        }
                                        break;
                                    case -842500323:
                                        if (!str3.equals("nicklaus_f")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 88;
                                        }
                                        break;
                                    case -821392978:
                                        if (!str3.equals("A7000-a")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 9;
                                        }
                                        break;
                                    case -797483286:
                                        if (!str3.equals("SVP-DTV15")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 119;
                                        }
                                        break;
                                    case -794946968:
                                        if (!str3.equals("watson")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 131;
                                        }
                                        break;
                                    case -788334647:
                                        if (!str3.equals("whyred")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 132;
                                        }
                                        break;
                                    case -782144577:
                                        if (!str3.equals("OnePlus5T")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 91;
                                        }
                                        break;
                                    case -575125681:
                                        if (!str3.equals("GiONEE_CBL7513")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 51;
                                        }
                                        break;
                                    case -521118391:
                                        if (!str3.equals("GIONEE_GBL7360")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 53;
                                        }
                                        break;
                                    case -430914369:
                                        if (!str3.equals("Pixi4-7_3G")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 105;
                                        }
                                        break;
                                    case -290434366:
                                        if (!str3.equals("taido_row")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 121;
                                        }
                                        break;
                                    case -282781963:
                                        if (!str3.equals("BLACK-1X")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 17;
                                        }
                                        break;
                                    case -277133239:
                                        if (!str3.equals("Z12_PRO")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 138;
                                        }
                                        break;
                                    case -173639913:
                                        if (!str3.equals("ELUGA_A3_Pro")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 31;
                                        }
                                        break;
                                    case -56598463:
                                        if (!str3.equals("woods_fn")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 134;
                                        }
                                        break;
                                    case 2126:
                                        if (!str3.equals("C1")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 20;
                                        }
                                        break;
                                    case 2564:
                                        if (!str3.equals("Q5")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 113;
                                        }
                                        break;
                                    case 2715:
                                        if (!str3.equals("V1")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 127;
                                        }
                                        break;
                                    case 2719:
                                        if (!str3.equals("V5")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 129;
                                        }
                                        break;
                                    case 3091:
                                        if (!str3.equals("b5")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 16;
                                        }
                                        break;
                                    case 3483:
                                        if (!str3.equals("mh")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 84;
                                        }
                                        break;
                                    case 73405:
                                        if (!str3.equals("JGZ")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 73;
                                        }
                                        break;
                                    case 75537:
                                        if (!str3.equals("M04")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 79;
                                        }
                                        break;
                                    case 75739:
                                        if (!str3.equals("M5c")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 80;
                                        }
                                        break;
                                    case 76779:
                                        if (!str3.equals("MX6")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 86;
                                        }
                                        break;
                                    case 78669:
                                        if (!str3.equals(sgtsHsWT.vdseziVRSlQLBj)) {
                                            b3 = -1;
                                        } else {
                                            b3 = 94;
                                        }
                                        break;
                                    case 79305:
                                        if (!str3.equals("PLE")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 107;
                                        }
                                        break;
                                    case 80618:
                                        if (!str3.equals("QX1")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 115;
                                        }
                                        break;
                                    case 88274:
                                        if (!str3.equals("Z80")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 139;
                                        }
                                        break;
                                    case 98846:
                                        if (!str3.equals("cv1")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 26;
                                        }
                                        break;
                                    case 98848:
                                        if (!str3.equals("cv3")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 27;
                                        }
                                        break;
                                    case 99329:
                                        if (!str3.equals("deb")) {
                                            b3 = -1;
                                        }
                                        break;
                                    case 101481:
                                        if (!str3.equals("flo")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 49;
                                        }
                                        break;
                                    case 1513190:
                                        if (!str3.equals("1601")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 0;
                                        }
                                        break;
                                    case 1514184:
                                        if (!str3.equals("1713")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 1;
                                        }
                                        break;
                                    case 1514185:
                                        if (!str3.equals("1714")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 2;
                                        }
                                        break;
                                    case 2133089:
                                        if (!str3.equals("F01H")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 36;
                                        }
                                        break;
                                    case 2133091:
                                        if (!str3.equals("F01J")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 37;
                                        }
                                        break;
                                    case 2133120:
                                        if (!str3.equals("F02H")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 38;
                                        }
                                        break;
                                    case 2133151:
                                        if (!str3.equals("F03H")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 39;
                                        }
                                        break;
                                    case 2133182:
                                        if (!str3.equals("F04H")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 40;
                                        }
                                        break;
                                    case 2133184:
                                        if (!str3.equals("F04J")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 41;
                                        }
                                        break;
                                    case 2436959:
                                        if (!str3.equals("P681")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 93;
                                        }
                                        break;
                                    case 2463773:
                                        if (!str3.equals("Q350")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 109;
                                        }
                                        break;
                                    case 2464648:
                                        if (!str3.equals("Q427")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 111;
                                        }
                                        break;
                                    case 2689555:
                                        if (!str3.equals("XE2X")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 136;
                                        }
                                        break;
                                    case 3154429:
                                        if (!str3.equals("fugu")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 50;
                                        }
                                        break;
                                    case 3284551:
                                        if (!str3.equals("kate")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 75;
                                        }
                                        break;
                                    case 3351335:
                                        if (!str3.equals("mido")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 85;
                                        }
                                        break;
                                    case 3386211:
                                        if (!str3.equals(MnHfHMYQDPUO.VKMsUuqz)) {
                                            b3 = -1;
                                        } else {
                                            b3 = 92;
                                        }
                                        break;
                                    case 41325051:
                                        if (!str3.equals("MEIZU_M5")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 83;
                                        }
                                        break;
                                    case 51349633:
                                        if (!str3.equals(RDFWIi.GAYHqTY)) {
                                            b3 = -1;
                                        } else {
                                            b3 = 3;
                                        }
                                        break;
                                    case 51350594:
                                        if (!str3.equals("602LV")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 4;
                                        }
                                        break;
                                    case 55178625:
                                        if (!str3.equals("Aura_Note_2")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 15;
                                        }
                                        break;
                                    case 61542055:
                                        if (!str3.equals("A1601")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 7;
                                        }
                                        break;
                                    case 65355429:
                                        if (!str3.equals("E5643")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 30;
                                        }
                                        break;
                                    case 66214468:
                                        if (!str3.equals("F3111")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 42;
                                        }
                                        break;
                                    case 66214470:
                                        if (!str3.equals("F3113")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 43;
                                        }
                                        break;
                                    case 66214473:
                                        if (!str3.equals("F3116")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 44;
                                        }
                                        break;
                                    case 66215429:
                                        if (!str3.equals("F3211")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 45;
                                        }
                                        break;
                                    case 66215431:
                                        if (!str3.equals("F3213")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 46;
                                        }
                                        break;
                                    case 66215433:
                                        if (!str3.equals(JuorMn.wDWQWJESUQtkQ)) {
                                            b3 = -1;
                                        } else {
                                            b3 = 47;
                                        }
                                        break;
                                    case 66216390:
                                        if (!str3.equals("F3311")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 48;
                                        }
                                        break;
                                    case 76402249:
                                        if (!str3.equals("PRO7S")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 108;
                                        }
                                        break;
                                    case 76404105:
                                        if (!str3.equals("Q4260")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 110;
                                        }
                                        break;
                                    case 76404911:
                                        if (!str3.equals("Q4310")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 112;
                                        }
                                        break;
                                    case 80963634:
                                        if (!str3.equals("V23GB")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 128;
                                        }
                                        break;
                                    case 82882791:
                                        if (!str3.equals("X3_HK")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 135;
                                        }
                                        break;
                                    case 98715550:
                                        if (!str3.equals("i9031")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 67;
                                        }
                                        break;
                                    case 101370885:
                                        if (!str3.equals("l5460")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 76;
                                        }
                                        break;
                                    case 102844228:
                                        if (!str3.equals("le_x6")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 77;
                                        }
                                        break;
                                    case 165221241:
                                        if (!str3.equals("A2016a40")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 8;
                                        }
                                        break;
                                    case 182191441:
                                        if (!str3.equals("CPY83_I00")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 25;
                                        }
                                        break;
                                    case 245388979:
                                        if (!str3.equals("marino_f")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 82;
                                        }
                                        break;
                                    case 287431619:
                                        if (!str3.equals("griffin")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 60;
                                        }
                                        break;
                                    case 307593612:
                                        if (!str3.equals("A7010a48")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 11;
                                        }
                                        break;
                                    case 308517133:
                                        if (!str3.equals("A7020a48")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 12;
                                        }
                                        break;
                                    case 316215098:
                                        if (!str3.equals("TB3-730F")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 122;
                                        }
                                        break;
                                    case 316215116:
                                        if (!str3.equals("TB3-730X")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 123;
                                        }
                                        break;
                                    case 316246811:
                                        if (!str3.equals("TB3-850F")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 124;
                                        }
                                        break;
                                    case 316246818:
                                        if (!str3.equals("TB3-850M")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 125;
                                        }
                                        break;
                                    case 407160593:
                                        if (!str3.equals("Pixi5-10_4G")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 106;
                                        }
                                        break;
                                    case 507412548:
                                        if (!str3.equals("QM16XE_U")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 114;
                                        }
                                        break;
                                    case 793982701:
                                        if (!str3.equals("GIONEE_WBL5708")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 57;
                                        }
                                        break;
                                    case 794038622:
                                        if (!str3.equals("GIONEE_WBL7365")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 58;
                                        }
                                        break;
                                    case 794040393:
                                        if (!str3.equals("GIONEE_WBL7519")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 59;
                                        }
                                        break;
                                    case 835649806:
                                        if (!str3.equals("manning")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 81;
                                        }
                                        break;
                                    case 917340916:
                                        if (!str3.equals("A7000plus")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 10;
                                        }
                                        break;
                                    case 958008161:
                                        if (!str3.equals("j2xlteins")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 72;
                                        }
                                        break;
                                    case 1060579533:
                                        if (!str3.equals("panell_d")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 96;
                                        }
                                        break;
                                    case 1150207623:
                                        if (!str3.equals("LS-5017")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 78;
                                        }
                                        break;
                                    case 1176899427:
                                        if (!str3.equals("itel_S41")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 71;
                                        }
                                        break;
                                    case 1280332038:
                                        if (!str3.equals("hwALE-H")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 62;
                                        }
                                        break;
                                    case 1306947716:
                                        if (!str3.equals(DYYbQc.umvG)) {
                                            b3 = -1;
                                        } else {
                                            b3 = 35;
                                        }
                                        break;
                                    case 1349174697:
                                        if (!str3.equals("htc_e56ml_dtul")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 61;
                                        }
                                        break;
                                    case 1522194893:
                                        if (!str3.equals("woods_f")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 133;
                                        }
                                        break;
                                    case 1691543273:
                                        if (!str3.equals("CPH1609")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 23;
                                        }
                                        break;
                                    case 1691544261:
                                        if (!str3.equals("CPH1715")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 24;
                                        }
                                        break;
                                    case 1709443163:
                                        if (!str3.equals("iball8735_9806")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 68;
                                        }
                                        break;
                                    case 1865889110:
                                        if (!str3.equals("santoni")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 117;
                                        }
                                        break;
                                    case 1906253259:
                                        if (!str3.equals("PB2-670M")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 100;
                                        }
                                        break;
                                    case 1977196784:
                                        if (!str3.equals("Infinix-X572")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 69;
                                        }
                                        break;
                                    case 2006372676:
                                        if (!str3.equals("BRAVIA_ATV3_4K")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 19;
                                        }
                                        break;
                                    case 2019281702:
                                        if (!str3.equals("DM-01K")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 29;
                                        }
                                        break;
                                    case 2029784656:
                                        if (!str3.equals("HWBLN-H")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 63;
                                        }
                                        break;
                                    case 2030379515:
                                        if (!str3.equals("HWCAM-H")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 64;
                                        }
                                        break;
                                    case 2033393791:
                                        if (!str3.equals("ASUS_X00AD_2")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 14;
                                        }
                                        break;
                                    case 2047190025:
                                        if (!str3.equals("ELUGA_Note")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 32;
                                        }
                                        break;
                                    case 2047252157:
                                        if (!str3.equals("ELUGA_Prim")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 33;
                                        }
                                        break;
                                    case 2048319463:
                                        if (!str3.equals("HWVNS-H")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 65;
                                        }
                                        break;
                                    case 2048855701:
                                        if (!str3.equals("HWWAS-H")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 66;
                                        }
                                        break;
                                    default:
                                        b3 = -1;
                                        break;
                                }
                                switch (b3) {
                                    default:
                                        if (str2.hashCode() == -594534941) {
                                            break;
                                        }
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
                                    case 34:
                                    case DescriptorProtos.MethodOptions.FEATURES_FIELD_NUMBER /* 35 */:
                                    case DescriptorProtos.FileOptions.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                                    case DescriptorProtos.FileOptions.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                                    case 38:
                                    case DescriptorProtos.FileOptions.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                                    case DescriptorProtos.FileOptions.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                                    case DescriptorProtos.FileOptions.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                                    case 42:
                                    case 43:
                                    case DescriptorProtos.FileOptions.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                                    case DescriptorProtos.FileOptions.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                                    case 46:
                                    case 47:
                                    case 48:
                                    case 49:
                                    case 50:
                                    case 51:
                                    case 52:
                                    case 53:
                                    case 54:
                                    case 55:
                                    case 56:
                                    case 57:
                                    case 58:
                                    case 59:
                                    case 60:
                                    case 61:
                                    case 62:
                                    case 63:
                                    case 64:
                                    case 65:
                                    case GooglePlayBillingEnums.EVENT_OTHER_WEB_IAP /* 66 */:
                                    case 67:
                                    case 68:
                                    case 69:
                                    case 70:
                                    case 71:
                                    case 72:
                                    case 73:
                                    case 74:
                                    case 75:
                                    case 76:
                                    case 77:
                                    case 78:
                                    case 79:
                                    case 80:
                                    case 81:
                                    case 82:
                                    case 83:
                                    case 84:
                                    case 85:
                                    case ModuleDescriptor.MODULE_VERSION /* 86 */:
                                    case 87:
                                    case 88:
                                    case 89:
                                    case 90:
                                    case 91:
                                    case 92:
                                    case 93:
                                    case 94:
                                    case 95:
                                    case 96:
                                    case 97:
                                    case 98:
                                    case TOSS_VERYHIGH_VALUE:
                                    case TOSS_SODAM_VALUE:
                                    case 101:
                                    case TOSS_OPEN_MASKED_SOLHWA_VALUE:
                                    case TOSS_OPEN_BALANCED_VALUE:
                                    case TOSS_FIXED_LOW_FOR_BEGINNER_VALUE:
                                    case TOSS_NETUPOPEN_VALUE:
                                    case TOSS_NETUPC_VALUE:
                                    case TOSS_SPOTLIGHT_VALUE:
                                    case TOSS_FIXED_MED_FOR_BEGINNER_VALUE:
                                    case 109:
                                    case 110:
                                    case 111:
                                    case 112:
                                    case 113:
                                    case 114:
                                    case 115:
                                    case 116:
                                    case 117:
                                    case 118:
                                    case 119:
                                    case 120:
                                    case 121:
                                    case 122:
                                    case 123:
                                    case 124:
                                    case 125:
                                    case 126:
                                    case 127:
                                    case 128:
                                    case 129:
                                    case 130:
                                    case 131:
                                    case 132:
                                    case 133:
                                    case 134:
                                    case 135:
                                    case 136:
                                    case 137:
                                    case 138:
                                    case 139:
                                        z = true;
                                        break;
                                }
                            }
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                            z = true;
                            break;
                    }
                }
                zzd = z;
                zzc = true;
            }
        }
        return zzd;
    }

    public final void zzas(zztf zztfVar, int i, long j) {
        Trace.beginSection(kBfGXgdfpo.SYmaoqVVWRL);
        zztfVar.zzo(i, false);
        Trace.endSection();
        ((zztp) this).zza.zzf++;
    }
}
