package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzru extends zztp implements zzlb {
    private final Context zzb;
    private final zzqg zzc;
    private final zzqo zzd;
    private final zztb zze;
    private int zzf;
    private boolean zzg;
    private boolean zzh;
    private zzz zzi;
    private zzz zzj;
    private long zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private int zzo;
    private boolean zzp;
    private long zzq;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzru(Context context, zztd zztdVar, zztr zztrVar, boolean z, Handler handler, zzqh zzqhVar, zzqo zzqoVar) {
        super(1, zztdVar, zztrVar, false, 44100.0f);
        zztb zztbVar = Build.VERSION.SDK_INT >= 35 ? new zztb(zzta.zza) : null;
        this.zzb = context.getApplicationContext();
        this.zzd = zzqoVar;
        this.zze = zztbVar;
        this.zzo = -1000;
        this.zzc = new zzqg(handler, zzqhVar);
        this.zzq = -9223372036854775807L;
        zzqoVar.zzr(new zzrs(this, null));
    }

    private final int zzba(zzti zztiVar, zzz zzzVar) {
        int i;
        if (!"OMX.google.raw.decoder".equals(zztiVar.zza) || (i = Build.VERSION.SDK_INT) >= 24 || (i == 23 && zzex.zzN(this.zzb))) {
            return zzzVar.zzp;
        }
        return -1;
    }

    private static List zzbb(zztr zztrVar, zzz zzzVar, boolean z, zzqo zzqoVar) {
        zzti zztiVarZza;
        if (zzzVar.zzo == null) {
            return zzfyq.zzn();
        }
        return (!zzqoVar.zzB(zzzVar) || (zztiVarZza = zzuc.zza()) == null) ? zzuc.zze(zztrVar, zzzVar, false, false) : zzfyq.zzo(zztiVarZza);
    }

    private final void zzbc() {
        long jZzc = this.zzd.zzc(zzX());
        if (jZzc != Long.MIN_VALUE) {
            if (!this.zzl) {
                jZzc = Math.max(this.zzk, jZzc);
            }
            this.zzk = jZzc;
            this.zzl = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zztp, com.google.android.gms.internal.ads.zzic
    public final void zzA(long j, boolean z) {
        super.zzA(j, z);
        this.zzd.zzg();
        this.zzk = j;
        this.zzq = -9223372036854775807L;
        this.zzn = false;
        this.zzl = true;
    }

    @Override // com.google.android.gms.internal.ads.zzic
    public final void zzB() {
        zztb zztbVar;
        this.zzd.zzl();
        if (Build.VERSION.SDK_INT < 35 || (zztbVar = this.zze) == null) {
            return;
        }
        zztbVar.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zztp, com.google.android.gms.internal.ads.zzic
    public final void zzD() {
        this.zzn = false;
        this.zzq = -9223372036854775807L;
        try {
            super.zzD();
            if (this.zzm) {
            }
        } finally {
            if (this.zzm) {
                this.zzm = false;
                this.zzd.zzm();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzic
    public final void zzE() {
        this.zzd.zzj();
        this.zzp = true;
    }

    @Override // com.google.android.gms.internal.ads.zzic
    public final void zzF() {
        zzbc();
        this.zzp = false;
        this.zzd.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzma, com.google.android.gms.internal.ads.zzmd
    public final String zzV() {
        return "MediaCodecAudioRenderer";
    }

    @Override // com.google.android.gms.internal.ads.zztp, com.google.android.gms.internal.ads.zzma
    public final boolean zzX() {
        return super.zzX() && this.zzd.zzA();
    }

    @Override // com.google.android.gms.internal.ads.zztp, com.google.android.gms.internal.ads.zzma
    public final boolean zzY() {
        return this.zzd.zzz() || super.zzY();
    }

    @Override // com.google.android.gms.internal.ads.zzlb
    public final long zza() {
        if (zzcU() == 2) {
            zzbc();
        }
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final float zzaa(float f, zzz zzzVar, zzz[] zzzVarArr) {
        int iMax = -1;
        for (zzz zzzVar2 : zzzVarArr) {
            int i = zzzVar2.zzH;
            if (i != -1) {
                iMax = Math.max(iMax, i);
            }
        }
        if (iMax == -1) {
            return -1.0f;
        }
        return iMax * f;
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final int zzab(zztr zztrVar, zzz zzzVar) {
        int i;
        boolean z;
        String str = zzzVar.zzo;
        if (!zzay.zzh(str)) {
            return 128;
        }
        int i2 = zzzVar.zzN;
        boolean zZzaY = zztp.zzaY(zzzVar);
        int i3 = 1;
        if (!zZzaY || (i2 != 0 && zzuc.zza() == null)) {
            i = 0;
        } else {
            zzqo zzqoVar = this.zzd;
            zzps zzpsVarZze = zzqoVar.zze(zzzVar);
            if (zzpsVarZze.zzb) {
                i = true != zzpsVarZze.zzc ? 512 : 1536;
                if (zzpsVarZze.zzd) {
                    i |= 2048;
                }
            } else {
                i = 0;
            }
            if (zzqoVar.zzB(zzzVar)) {
                return i | 172;
            }
        }
        if (!"audio/raw".equals(str) || this.zzd.zzB(zzzVar)) {
            zzqo zzqoVar2 = this.zzd;
            if (zzqoVar2.zzB(zzex.zzA(2, zzzVar.zzG, zzzVar.zzH))) {
                List listZzbb = zzbb(zztrVar, zzzVar, false, zzqoVar2);
                if (!listZzbb.isEmpty()) {
                    if (zZzaY) {
                        zzti zztiVar = (zzti) listZzbb.get(0);
                        boolean zZzf = zztiVar.zzf(zzzVar);
                        if (!zZzf) {
                            int i4 = 1;
                            while (true) {
                                if (i4 >= listZzbb.size()) {
                                    z = true;
                                    break;
                                }
                                zzti zztiVar2 = (zzti) listZzbb.get(i4);
                                if (zztiVar2.zzf(zzzVar)) {
                                    z = false;
                                    zZzf = true;
                                    zztiVar = zztiVar2;
                                    break;
                                }
                                i4++;
                            }
                        } else {
                            z = true;
                            break;
                        }
                        int i5 = true != zZzf ? 3 : 4;
                        int i6 = 8;
                        if (zZzf && zztiVar.zzg(zzzVar)) {
                            i6 = 16;
                        }
                        return i5 | i6 | 32 | (true != zztiVar.zzg ? 0 : 64) | (true != z ? 0 : 128) | i;
                    }
                    i3 = 2;
                }
            }
        }
        return i3 | 128;
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final long zzac(long j, long j2, boolean z) {
        if (this.zzq != -9223372036854775807L) {
            long jZzb = this.zzd.zzb();
            if (jZzb != -9223372036854775807L) {
                long jMin = (long) ((Math.min(jZzb, this.zzq - j) / (zzc() != null ? zzc().zzb : 1.0f)) / 2.0f);
                if (this.zzp) {
                    jMin -= zzex.zzs(zzcX().zzb()) - j2;
                }
                return Math.max(10000L, jMin);
            }
        }
        return 10000L;
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final zzie zzad(zzti zztiVar, zzz zzzVar, zzz zzzVar2) {
        int i;
        int i2;
        zzie zzieVarZzc = zztiVar.zzc(zzzVar, zzzVar2);
        int i3 = zzieVarZzc.zze;
        if (zzaS(zzzVar2)) {
            i3 |= 32768;
        }
        if (zzba(zztiVar, zzzVar2) > this.zzf) {
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
        zzz zzzVar = zzkvVar.zza;
        zzzVar.getClass();
        this.zzi = zzzVar;
        zzie zzieVarZzae = super.zzae(zzkvVar);
        this.zzc.zzw(zzzVar, zzieVarZzae);
        return zzieVarZzae;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x005e  */
    /* JADX WARN: Code duplicated, block: B:43:0x00cd  */
    @Override // com.google.android.gms.internal.ads.zztp
    public final zztc zzaj(zzti zztiVar, zzz zzzVar, MediaCrypto mediaCrypto, float f) {
        boolean z;
        zzz[] zzzVarArrZzU = zzU();
        int length = zzzVarArrZzU.length;
        int iZzba = zzba(zztiVar, zzzVar);
        if (length != 1) {
            for (zzz zzzVar2 : zzzVarArrZzU) {
                if (zztiVar.zzc(zzzVar, zzzVar2).zzd != 0) {
                    iZzba = Math.max(iZzba, zzba(zztiVar, zzzVar2));
                }
            }
        }
        this.zzf = iZzba;
        String str = zztiVar.zza;
        int i = Build.VERSION.SDK_INT;
        if (i < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(Build.MANUFACTURER)) {
            String str2 = Build.DEVICE;
            if (str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte")) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        this.zzg = z;
        this.zzh = str.equals("OMX.google.opus.decoder") || str.equals("c2.android.opus.decoder") || str.equals("OMX.google.vorbis.decoder") || str.equals("c2.android.vorbis.decoder");
        String str3 = zztiVar.zzc;
        int i2 = this.zzf;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str3);
        int i3 = zzzVar.zzG;
        mediaFormat.setInteger("channel-count", i3);
        int i4 = zzzVar.zzH;
        mediaFormat.setInteger("sample-rate", i4);
        zzed.zzb(mediaFormat, zzzVar.zzr);
        zzed.zza(mediaFormat, "max-input-size", i2);
        mediaFormat.setInteger("priority", 0);
        if (f != -1.0f) {
            if (i == 23) {
                String str4 = Build.MODEL;
                if (!"ZTE B2017G".equals(str4) && !"AXON 7 mini".equals(str4)) {
                    mediaFormat.setFloat("operating-rate", f);
                }
            } else {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        String str5 = zzzVar.zzo;
        if ("audio/ac4".equals(str5)) {
            Pair pairZza = zzdk.zza(zzzVar);
            if (pairZza != null) {
                zzed.zza(mediaFormat, "profile", ((Integer) pairZza.first).intValue());
                zzed.zza(mediaFormat, FirebaseAnalytics.Param.LEVEL, ((Integer) pairZza.second).intValue());
            }
            if (i <= 28) {
                mediaFormat.setInteger("ac4-is-sync", 1);
            }
        }
        if (i >= 24 && this.zzd.zza(zzex.zzA(4, i3, i4)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        if (i >= 32) {
            mediaFormat.setInteger("max-output-channel-count", 99);
        }
        if (i >= 35) {
            mediaFormat.setInteger("importance", Math.max(0, -this.zzo));
        }
        this.zzj = (!"audio/raw".equals(zztiVar.zzb) || "audio/raw".equals(str5)) ? null : zzzVar;
        return zztc.zza(zztiVar, mediaFormat, zzzVar, null, this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final List zzak(zztr zztrVar, zzz zzzVar, boolean z) {
        return zzuc.zzf(zzbb(zztrVar, zzzVar, false, this.zzd), zzzVar);
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final void zzan(zzhs zzhsVar) {
        zzz zzzVar;
        if (Build.VERSION.SDK_INT < 29 || (zzzVar = zzhsVar.zza) == null || !Objects.equals(zzzVar.zzo, "audio/opus") || !zzaR()) {
            return;
        }
        ByteBuffer byteBuffer = zzhsVar.zzf;
        byteBuffer.getClass();
        zzz zzzVar2 = zzhsVar.zza;
        zzzVar2.getClass();
        int i = zzzVar2.zzJ;
        if (byteBuffer.remaining() == 8) {
            this.zzd.zzs(i, (int) ((byteBuffer.order(ByteOrder.LITTLE_ENDIAN).getLong() * 48000) / 1000000000));
        }
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final void zzao(Exception exc) {
        zzea.zzd("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.zzc.zzn(exc);
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final void zzap(String str, zztc zztcVar, long j, long j2) {
        this.zzc.zzs(str, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final void zzaq(String str) {
        this.zzc.zzt(str);
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final void zzar(zzz zzzVar, MediaFormat mediaFormat) throws zzin {
        int iZzn;
        int i;
        zzz zzzVar2 = this.zzj;
        int[] iArr = null;
        boolean z = true;
        if (zzzVar2 != null) {
            zzzVar = zzzVar2;
        } else if (zzaF() != null) {
            mediaFormat.getClass();
            if ("audio/raw".equals(zzzVar.zzo)) {
                iZzn = zzzVar.zzI;
            } else if (Build.VERSION.SDK_INT < 24 || !mediaFormat.containsKey("pcm-encoding")) {
                iZzn = mediaFormat.containsKey("v-bits-per-sample") ? zzex.zzn(mediaFormat.getInteger("v-bits-per-sample"), ByteOrder.LITTLE_ENDIAN) : 2;
            } else {
                iZzn = mediaFormat.getInteger("pcm-encoding");
            }
            zzx zzxVar = new zzx();
            zzxVar.zzah("audio/raw");
            zzxVar.zzab(iZzn);
            zzxVar.zzM(zzzVar.zzJ);
            zzxVar.zzN(zzzVar.zzK);
            zzxVar.zzaa(zzzVar.zzl);
            zzxVar.zzS(zzzVar.zza);
            zzxVar.zzU(zzzVar.zzb);
            zzxVar.zzV(zzzVar.zzc);
            zzxVar.zzW(zzzVar.zzd);
            zzxVar.zzaj(zzzVar.zze);
            zzxVar.zzaf(zzzVar.zzf);
            zzxVar.zzD(mediaFormat.getInteger("channel-count"));
            zzxVar.zzai(mediaFormat.getInteger("sample-rate"));
            zzz zzzVarZzan = zzxVar.zzan();
            if (this.zzg && zzzVarZzan.zzG == 6 && (i = zzzVar.zzG) < 6) {
                iArr = new int[i];
                for (int i2 = 0; i2 < i; i2++) {
                    iArr[i2] = i2;
                }
            } else if (this.zzh) {
                int i3 = zzzVarZzan.zzG;
                if (i3 == 3) {
                    iArr = new int[]{0, 2, 1};
                } else if (i3 == 5) {
                    iArr = new int[]{0, 2, 1, 3, 4};
                } else if (i3 == 6) {
                    iArr = new int[]{0, 2, 1, 5, 3, 4};
                } else if (i3 == 7) {
                    iArr = new int[]{0, 2, 1, 6, 5, 3, 4};
                } else if (i3 == 8) {
                    iArr = new int[]{0, 2, 1, 7, 5, 6, 3, 4};
                }
            }
            zzzVar = zzzVarZzan;
        }
        try {
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 29) {
                if (zzaR()) {
                    zzo();
                }
                if (i4 < 29) {
                    z = false;
                }
                zzdd.zzf(z);
            }
            this.zzd.zzf(zzzVar, 0, iArr);
        } catch (zzqj e) {
            throw zzk(e, e.zza, false, 5001);
        }
    }

    public final void zzas() {
        this.zzl = true;
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final void zzat() {
        this.zzd.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final void zzau() throws zzin {
        try {
            this.zzd.zzk();
            if (zzaz() != -9223372036854775807L) {
                this.zzq = zzaz();
            }
        } catch (zzqn e) {
            throw zzk(e, e.zzc, e.zzb, true != zzaR() ? 5002 : 5003);
        }
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final boolean zzav(long j, long j2, zztf zztfVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzz zzzVar) throws zzin {
        byteBuffer.getClass();
        this.zzq = -9223372036854775807L;
        if (this.zzj != null && (i2 & 2) != 0) {
            zztfVar.getClass();
            zztfVar.zzo(i, false);
            return true;
        }
        if (z) {
            if (zztfVar != null) {
                zztfVar.zzo(i, false);
            }
            ((zztp) this).zza.zzf += i3;
            this.zzd.zzh();
            return true;
        }
        try {
            if (!this.zzd.zzy(byteBuffer, j3, i3)) {
                this.zzq = j3;
                return false;
            }
            if (zztfVar != null) {
                zztfVar.zzo(i, false);
            }
            ((zztp) this).zza.zze += i3;
            return true;
        } catch (zzqk e) {
            zzz zzzVar2 = this.zzi;
            if (zzaR()) {
                zzo();
            }
            throw zzk(e, zzzVar2, e.zzb, 5001);
        } catch (zzqn e2) {
            if (zzaR()) {
                zzo();
            }
            throw zzk(e2, zzzVar, e2.zzb, 5002);
        }
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final boolean zzaw(zzz zzzVar) {
        zzo();
        return this.zzd.zzB(zzzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzlb
    public final zzbb zzc() {
        return this.zzd.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzlb
    public final void zzg(zzbb zzbbVar) {
        this.zzd.zzt(zzbbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzlb
    public final boolean zzj() {
        boolean z = this.zzn;
        this.zzn = false;
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzic, com.google.android.gms.internal.ads.zzma
    public final zzlb zzm() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zztp, com.google.android.gms.internal.ads.zzic, com.google.android.gms.internal.ads.zzlv
    public final void zzv(int i, Object obj) {
        zztb zztbVar;
        if (i == 2) {
            zzqo zzqoVar = this.zzd;
            obj.getClass();
            zzqoVar.zzx(((Float) obj).floatValue());
            return;
        }
        if (i == 3) {
            zze zzeVar = (zze) obj;
            zzqo zzqoVar2 = this.zzd;
            zzeVar.getClass();
            zzqoVar2.zzn(zzeVar);
            return;
        }
        if (i == 6) {
            zzf zzfVar = (zzf) obj;
            zzqo zzqoVar3 = this.zzd;
            zzfVar.getClass();
            zzqoVar3.zzp(zzfVar);
            return;
        }
        if (i == 12) {
            this.zzd.zzv((AudioDeviceInfo) obj);
            return;
        }
        if (i == 16) {
            obj.getClass();
            this.zzo = ((Integer) obj).intValue();
            zztf zztfVarZzaF = zzaF();
            if (zztfVarZzaF == null || Build.VERSION.SDK_INT < 35) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("importance", Math.max(0, -this.zzo));
            zztfVarZzaF.zzq(bundle);
            return;
        }
        if (i == 9) {
            zzqo zzqoVar4 = this.zzd;
            obj.getClass();
            zzqoVar4.zzw(((Boolean) obj).booleanValue());
        } else {
            if (i != 10) {
                super.zzv(i, obj);
                return;
            }
            obj.getClass();
            int iIntValue = ((Integer) obj).intValue();
            this.zzd.zzo(iIntValue);
            if (Build.VERSION.SDK_INT < 35 || (zztbVar = this.zze) == null) {
                return;
            }
            zztbVar.zzd(iIntValue);
        }
    }

    @Override // com.google.android.gms.internal.ads.zztp, com.google.android.gms.internal.ads.zzic
    public final void zzy() {
        this.zzm = true;
        this.zzi = null;
        this.zzq = -9223372036854775807L;
        try {
            this.zzd.zzg();
            super.zzy();
        } catch (Throwable th) {
            super.zzy();
            throw th;
        } finally {
            this.zzc.zzu(((zztp) this).zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zztp, com.google.android.gms.internal.ads.zzic
    public final void zzz(boolean z, boolean z2) {
        super.zzz(z, z2);
        this.zzc.zzv(((zztp) this).zza);
        zzo();
        zzqo zzqoVar = this.zzd;
        zzqoVar.zzu(zzp());
        zzqoVar.zzq(zzcX());
    }
}
