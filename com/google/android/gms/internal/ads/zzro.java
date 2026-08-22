package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioTrack;
import android.media.metrics.LogSessionId;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzro implements zzqo {
    private static final Object zza = new Object();
    private static ScheduledExecutorService zzb;
    private static int zzc;
    private zzrf zzA;
    private zzbb zzB;
    private boolean zzC;
    private long zzD;
    private long zzE;
    private long zzF;
    private long zzG;
    private int zzH;
    private boolean zzI;
    private boolean zzJ;
    private long zzK;
    private float zzL;
    private ByteBuffer zzM;
    private int zzN;
    private ByteBuffer zzO;
    private boolean zzP;
    private boolean zzQ;
    private boolean zzR;
    private boolean zzS;
    private int zzT;
    private zzf zzU;
    private zzpp zzV;
    private long zzW;
    private boolean zzX;
    private boolean zzY;
    private Looper zzZ;
    private long zzaa;
    private long zzab;
    private Handler zzac;
    private Context zzad;
    private boolean zzae;
    private final zzre zzaf;
    private final zzqu zzag;
    private final Context zzd;
    private final zzqt zze;
    private final zzry zzf;
    private final zzcr zzg;
    private final zzrx zzh;
    private final zzfyq zzi;
    private final zzqs zzj;
    private final ArrayDeque zzk;
    private zzrm zzl;
    private final zzri zzm;
    private final zzri zzn;
    private final int zzo;
    private zzph zzp;
    private zzql zzq;
    private zzrd zzr;
    private zzrd zzs;
    private zzck zzt;
    private AudioTrack zzu;
    private zzpj zzv;
    private zzpo zzw;
    private zzrh zzx;
    private zze zzy;
    private zzrf zzz;

    public /* synthetic */ zzro(zzrc zzrcVar, zzrn zzrnVar) {
        int deviceId;
        zzrn zzrnVar2 = null;
        Context applicationContext = zzrcVar.zza == null ? null : zzrcVar.zza.getApplicationContext();
        this.zzd = applicationContext;
        this.zzy = zze.zza;
        this.zzv = applicationContext != null ? null : zzrcVar.zzb;
        this.zzaf = zzrcVar.zzf;
        zzqu zzquVar = zzrcVar.zzg;
        zzquVar.getClass();
        this.zzag = zzquVar;
        this.zzj = new zzqs(new zzrj(this, zzrnVar2));
        zzqt zzqtVar = new zzqt();
        this.zze = zzqtVar;
        zzry zzryVar = new zzry();
        this.zzf = zzryVar;
        this.zzg = new zzcr();
        this.zzh = new zzrx();
        this.zzi = zzfyq.zzp(zzryVar, zzqtVar);
        this.zzL = 1.0f;
        this.zzT = 0;
        this.zzU = new zzf(0, 0.0f);
        zzbb zzbbVar = zzbb.zza;
        this.zzA = new zzrf(zzbbVar, 0L, 0L, null);
        this.zzB = zzbbVar;
        this.zzC = false;
        this.zzk = new ArrayDeque();
        this.zzm = new zzri();
        this.zzn = new zzri();
        int i = -1;
        if (Build.VERSION.SDK_INT >= 34 && zzrcVar.zza != null && (deviceId = zzrcVar.zza.getDeviceId()) != 0 && deviceId != -1) {
            i = deviceId;
        }
        this.zzo = i;
        this.zzae = true;
    }

    public static /* synthetic */ void zzH(zzro zzroVar) {
        if (zzroVar.zzab >= 300000) {
            ((zzrs) zzroVar.zzq).zza.zzn = true;
            zzroVar.zzab = 0L;
        }
    }

    public static /* synthetic */ void zzJ(AudioTrack audioTrack, final zzql zzqlVar, Handler handler, final zzqi zzqiVar) {
        try {
            audioTrack.flush();
            audioTrack.release();
            if (zzqlVar != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqx
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((zzrs) zzqlVar).zza.zzc.zzr(zzqiVar);
                    }
                });
            }
            synchronized (zza) {
                try {
                    int i = zzc - 1;
                    zzc = i;
                    if (i == 0) {
                        zzb.shutdown();
                        zzb = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            if (zzqlVar != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqx
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((zzrs) zzqlVar).zza.zzc.zzr(zzqiVar);
                    }
                });
            }
            synchronized (zza) {
                try {
                    int i2 = zzc - 1;
                    zzc = i2;
                    if (i2 == 0) {
                        zzb.shutdown();
                        zzb = null;
                    }
                    throw th2;
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }
    }

    public static /* bridge */ /* synthetic */ boolean zzM() {
        boolean z;
        synchronized (zza) {
            z = zzc > 0;
        }
        return z;
    }

    public final long zzN() {
        zzrd zzrdVar = this.zzs;
        return zzrdVar.zzc == 0 ? this.zzD / ((long) zzrdVar.zzb) : this.zzE;
    }

    public final long zzO() {
        zzrd zzrdVar = this.zzs;
        if (zzrdVar.zzc != 0) {
            return this.zzG;
        }
        long j = this.zzF;
        long j2 = zzrdVar.zzd;
        String str = zzex.zza;
        return ((j + j2) - 1) / j2;
    }

    private final AudioTrack zzP(zzrd zzrdVar) throws zzqk {
        Context context;
        try {
            int i = this.zzT;
            int i2 = this.zzo;
            Context context2 = null;
            if (i2 != -1 && (context = this.zzd) != null && Build.VERSION.SDK_INT >= 34) {
                if (this.zzad == null) {
                    this.zzad = context.createDeviceContext(i2);
                }
                context2 = this.zzad;
                i = 0;
            }
            return zzae(zzrdVar.zza(), this.zzy, i, zzrdVar.zza, context2);
        } catch (zzqk e) {
            zzql zzqlVar = this.zzq;
            if (zzqlVar != null) {
                zzqlVar.zza(e);
            }
            throw e;
        }
    }

    private final void zzQ(long j) {
        zzbb zzbbVar;
        boolean z;
        if (zzad()) {
            zzre zzreVar = this.zzaf;
            zzbbVar = this.zzB;
            zzreVar.zzc(zzbbVar);
        } else {
            zzbbVar = zzbb.zza;
        }
        zzbb zzbbVar2 = zzbbVar;
        this.zzB = zzbbVar2;
        if (zzad()) {
            zzre zzreVar2 = this.zzaf;
            z = this.zzC;
            zzreVar2.zzd(z);
        } else {
            z = false;
        }
        this.zzC = z;
        this.zzk.add(new zzrf(zzbbVar2, Math.max(0L, j), zzex.zzt(zzO(), this.zzs.zze), null));
        zzZ();
        zzql zzqlVar = this.zzq;
        if (zzqlVar != null) {
            ((zzrs) zzqlVar).zza.zzc.zzy(this.zzC);
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004a  */
    private final void zzR(long j) throws zzqn {
        zzql zzqlVar;
        if (this.zzO == null) {
            return;
        }
        zzri zzriVar = this.zzn;
        if (zzriVar.zzc()) {
            return;
        }
        int iRemaining = this.zzO.remaining();
        boolean z = true;
        int iWrite = this.zzu.write(this.zzO, iRemaining, 1);
        this.zzW = SystemClock.elapsedRealtime();
        if (iWrite >= 0) {
            zzriVar.zza();
            if (zzac(this.zzu)) {
                if (this.zzG > 0) {
                    this.zzY = false;
                }
                if (this.zzS && (zzqlVar = this.zzq) != null && iWrite < iRemaining) {
                }
            }
            int i = this.zzs.zzc;
            if (i == 0) {
                this.zzF += (long) iWrite;
            }
            if (iWrite == iRemaining) {
                if (i != 0) {
                    zzdd.zzf(this.zzO == this.zzM);
                    this.zzG = (((long) this.zzH) * ((long) this.zzN)) + this.zzG;
                }
                this.zzO = null;
                return;
            }
            return;
        }
        if ((Build.VERSION.SDK_INT < 24 || iWrite != -6) && iWrite != -32) {
            z = false;
        } else if (zzO() <= 0) {
            if (zzac(this.zzu)) {
                zzS();
            } else {
                z = false;
            }
        }
        zzqn zzqnVar = new zzqn(iWrite, this.zzs.zza, z);
        zzql zzqlVar2 = this.zzq;
        if (zzqlVar2 != null) {
            zzqlVar2.zza(zzqnVar);
        }
        if (!zzqnVar.zzb || this.zzd == null) {
            zzriVar.zzb(zzqnVar);
            return;
        }
        zzpj zzpjVar = zzpj.zza;
        this.zzv = zzpjVar;
        this.zzw.zzg(zzpjVar);
        throw zzqnVar;
    }

    private final void zzS() {
        if (this.zzs.zzc == 1) {
            this.zzX = true;
        }
    }

    private final void zzT() {
        Context context;
        if (this.zzw == null && (context = this.zzd) != null) {
            this.zzZ = Looper.myLooper();
            zzpo zzpoVar = new zzpo(context, new zzqy(this), this.zzy, this.zzV);
            this.zzw = zzpoVar;
            this.zzv = zzpoVar.zzc();
        }
        this.zzv.getClass();
    }

    private final void zzU() {
        if (this.zzQ) {
            return;
        }
        this.zzQ = true;
        this.zzj.zzb(zzO());
        if (zzac(this.zzu)) {
            this.zzR = false;
        }
        this.zzu.stop();
    }

    private final void zzV(long j) throws zzqn {
        zzR(j);
        if (this.zzO != null) {
            return;
        }
        if (!this.zzt.zzh()) {
            ByteBuffer byteBuffer = this.zzM;
            if (byteBuffer != null) {
                zzX(byteBuffer);
                zzR(j);
                return;
            }
            return;
        }
        while (!this.zzt.zzg()) {
            do {
                ByteBuffer byteBufferZzb = this.zzt.zzb();
                if (byteBufferZzb.hasRemaining()) {
                    zzX(byteBufferZzb);
                    zzR(j);
                } else {
                    ByteBuffer byteBuffer2 = this.zzM;
                    if (byteBuffer2 == null || !byteBuffer2.hasRemaining()) {
                        return;
                    } else {
                        this.zzt.zze(this.zzM);
                    }
                }
            } while (this.zzO == null);
            return;
        }
    }

    private final void zzW(zzbb zzbbVar) {
        zzrf zzrfVar = new zzrf(zzbbVar, -9223372036854775807L, -9223372036854775807L, null);
        if (zzab()) {
            this.zzz = zzrfVar;
        } else {
            this.zzA = zzrfVar;
        }
    }

    /* JADX WARN: Code duplicated, block: B:45:0x013f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:46:0x0141 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:47:0x0143  */
    /* JADX WARN: Code duplicated, block: B:49:0x0147  */
    /* JADX WARN: Code duplicated, block: B:51:0x014b  */
    /* JADX WARN: Code duplicated, block: B:53:0x014f  */
    /* JADX WARN: Code duplicated, block: B:55:0x0153  */
    /* JADX WARN: Code duplicated, block: B:57:0x0157  */
    /* JADX WARN: Code duplicated, block: B:60:0x0175  */
    /* JADX WARN: Code duplicated, block: B:61:0x0188  */
    /* JADX WARN: Code duplicated, block: B:62:0x0195  */
    /* JADX WARN: Code duplicated, block: B:63:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:64:0x01bf A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:65:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:66:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:67:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:68:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:73:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:79:0x016f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x01ed A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x004b A[SYNTHETIC] */
    private final void zzX(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        int i;
        int i2;
        int i3;
        int i4;
        float f;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        zzdd.zzf(this.zzO == null);
        if (byteBuffer.hasRemaining()) {
            if (this.zzs.zzc == 0) {
                int iZzp = (int) zzex.zzp(zzex.zzs(20L), this.zzs.zze);
                long jZzO = zzO();
                long j = iZzp;
                if (jZzO < j) {
                    zzrd zzrdVar = this.zzs;
                    int i12 = zzrdVar.zzg;
                    int i13 = zzrdVar.zzd;
                    ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(byteBuffer.remaining()).order(ByteOrder.nativeOrder());
                    int iPosition = byteBuffer.position();
                    int i14 = (int) jZzO;
                    while (byteBuffer.hasRemaining() && i14 < iZzp) {
                        if (i12 != 2) {
                            if (i12 == 3) {
                                i3 = (byteBuffer.get() & 255) << 24;
                            } else if (i12 != 4) {
                                if (i12 != 21) {
                                    if (i12 == 22) {
                                        i8 = byteBuffer.get() & 255;
                                        i9 = (byteBuffer.get() & 255) << 8;
                                        i10 = (byteBuffer.get() & 255) << 16;
                                        i11 = (byteBuffer.get() & 255) << 24;
                                    } else if (i12 == 268435456) {
                                        i = (byteBuffer.get() & 255) << 24;
                                        i2 = (byteBuffer.get() & 255) << 16;
                                    } else if (i12 == 1342177280) {
                                        i5 = (byteBuffer.get() & 255) << 24;
                                        i6 = (byteBuffer.get() & 255) << 16;
                                        i7 = (byteBuffer.get() & 255) << 8;
                                    } else {
                                        if (i12 != 1610612736) {
                                            throw new IllegalStateException();
                                        }
                                        i8 = (byteBuffer.get() & 255) << 24;
                                        i9 = (byteBuffer.get() & 255) << 16;
                                        i10 = (byteBuffer.get() & 255) << 8;
                                        i11 = byteBuffer.get() & 255;
                                    }
                                    i3 = i8 | i9 | i10 | i11;
                                } else {
                                    i5 = (byteBuffer.get() & 255) << 8;
                                    i6 = (byteBuffer.get() & 255) << 16;
                                    i7 = (byteBuffer.get() & 255) << 24;
                                }
                                i3 = i5 | i6 | i7;
                            } else {
                                float fMax = Math.max(-1.0f, Math.min(byteBuffer.getFloat(), 1.0f));
                                if (fMax < 0.0f) {
                                    fMax = -fMax;
                                    f = -2.1474836E9f;
                                } else {
                                    f = 2.1474836E9f;
                                }
                                i3 = (int) (fMax * f);
                            }
                            i4 = (int) ((((long) i3) * ((long) i14)) / j);
                            if (i12 != 2) {
                                byteBufferOrder.put((byte) (i4 >> 16));
                                byteBufferOrder.put((byte) (i4 >> 24));
                            } else if (i12 != 3) {
                                byteBufferOrder.put((byte) (i4 >> 24));
                            } else if (i12 != 4) {
                                if (i12 != 21) {
                                    byteBufferOrder.put((byte) (i4 >> 8));
                                    byteBufferOrder.put((byte) (i4 >> 16));
                                    byteBufferOrder.put((byte) (i4 >> 24));
                                } else if (i12 != 22) {
                                    byteBufferOrder.put((byte) i4);
                                    byteBufferOrder.put((byte) (i4 >> 8));
                                    byteBufferOrder.put((byte) (i4 >> 16));
                                    byteBufferOrder.put((byte) (i4 >> 24));
                                } else if (i12 != 268435456) {
                                    byteBufferOrder.put((byte) (i4 >> 24));
                                    byteBufferOrder.put((byte) (i4 >> 16));
                                } else if (i12 != 1342177280) {
                                    byteBufferOrder.put((byte) (i4 >> 24));
                                    byteBufferOrder.put((byte) (i4 >> 16));
                                    byteBufferOrder.put((byte) (i4 >> 8));
                                } else {
                                    if (i12 == 1610612736) {
                                        throw new IllegalStateException();
                                    }
                                    byteBufferOrder.put((byte) (i4 >> 24));
                                    byteBufferOrder.put((byte) (i4 >> 16));
                                    byteBufferOrder.put((byte) (i4 >> 8));
                                    byteBufferOrder.put((byte) i4);
                                }
                            } else if (i4 < 0) {
                                byteBufferOrder.putFloat((-i4) / (-2.1474836E9f));
                            } else {
                                byteBufferOrder.putFloat(i4 / 2.1474836E9f);
                            }
                            if (byteBuffer.position() == iPosition + i13) {
                                i14++;
                                iPosition = byteBuffer.position();
                            }
                        } else {
                            i = (byteBuffer.get() & 255) << 16;
                            i2 = (byteBuffer.get() & 255) << 24;
                        }
                        i3 = i | i2;
                        i4 = (int) ((((long) i3) * ((long) i14)) / j);
                        if (i12 != 2) {
                            byteBufferOrder.put((byte) (i4 >> 16));
                            byteBufferOrder.put((byte) (i4 >> 24));
                        } else if (i12 != 3) {
                            byteBufferOrder.put((byte) (i4 >> 24));
                        } else if (i12 != 4) {
                            if (i12 != 21) {
                                byteBufferOrder.put((byte) (i4 >> 8));
                                byteBufferOrder.put((byte) (i4 >> 16));
                                byteBufferOrder.put((byte) (i4 >> 24));
                            } else if (i12 != 22) {
                                byteBufferOrder.put((byte) i4);
                                byteBufferOrder.put((byte) (i4 >> 8));
                                byteBufferOrder.put((byte) (i4 >> 16));
                                byteBufferOrder.put((byte) (i4 >> 24));
                            } else if (i12 != 268435456) {
                                byteBufferOrder.put((byte) (i4 >> 24));
                                byteBufferOrder.put((byte) (i4 >> 16));
                            } else if (i12 != 1342177280) {
                                byteBufferOrder.put((byte) (i4 >> 24));
                                byteBufferOrder.put((byte) (i4 >> 16));
                                byteBufferOrder.put((byte) (i4 >> 8));
                            } else {
                                if (i12 == 1610612736) {
                                    throw new IllegalStateException();
                                }
                                byteBufferOrder.put((byte) (i4 >> 24));
                                byteBufferOrder.put((byte) (i4 >> 16));
                                byteBufferOrder.put((byte) (i4 >> 8));
                                byteBufferOrder.put((byte) i4);
                            }
                        } else if (i4 < 0) {
                            byteBufferOrder.putFloat((-i4) / (-2.1474836E9f));
                        } else {
                            byteBufferOrder.putFloat(i4 / 2.1474836E9f);
                        }
                        if (byteBuffer.position() == iPosition + i13) {
                            i14++;
                            iPosition = byteBuffer.position();
                        }
                    }
                    byteBufferOrder.put(byteBuffer);
                    byteBufferOrder.flip();
                    byteBuffer2 = byteBufferOrder;
                } else {
                    byteBuffer2 = byteBuffer;
                }
            } else {
                byteBuffer2 = byteBuffer;
            }
            this.zzO = byteBuffer2;
        }
    }

    private final void zzY() {
        if (zzab()) {
            this.zzu.setVolume(this.zzL);
        }
    }

    private final void zzZ() {
        zzck zzckVar = this.zzs.zzi;
        this.zzt = zzckVar;
        zzckVar.zzc();
    }

    private final boolean zzaa() throws zzqn {
        if (!this.zzt.zzh()) {
            zzR(Long.MIN_VALUE);
            return this.zzO == null;
        }
        this.zzt.zzd();
        zzV(Long.MIN_VALUE);
        if (!this.zzt.zzg()) {
            return false;
        }
        ByteBuffer byteBuffer = this.zzO;
        return byteBuffer == null || !byteBuffer.hasRemaining();
    }

    private final boolean zzab() {
        return this.zzu != null;
    }

    private static boolean zzac(AudioTrack audioTrack) {
        return Build.VERSION.SDK_INT >= 29 && audioTrack.isOffloadedPlayback();
    }

    private final boolean zzad() {
        zzrd zzrdVar = this.zzs;
        if (zzrdVar.zzc != 0) {
            return false;
        }
        int i = zzrdVar.zza.zzI;
        return true;
    }

    private static final AudioTrack zzae(zzqi zzqiVar, zze zzeVar, int i, zzz zzzVar, Context context) throws zzqk {
        try {
            AudioTrack.Builder sessionId = new AudioTrack.Builder().setAudioAttributes(zzeVar.zza().zza).setAudioFormat(zzex.zzx(zzqiVar.zzb, zzqiVar.zzc, zzqiVar.zza)).setTransferMode(1).setBufferSizeInBytes(zzqiVar.zze).setSessionId(i);
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                sessionId.setOffloadedPlayback(zzqiVar.zzd);
            }
            if (i2 >= 34 && context != null) {
                sessionId.setContext(context);
            }
            AudioTrack audioTrackBuild = sessionId.build();
            int state = audioTrackBuild.getState();
            if (state == 1) {
                return audioTrackBuild;
            }
            try {
                audioTrackBuild.release();
            } catch (Exception unused) {
            }
            throw new zzqk(state, zzqiVar.zzb, zzqiVar.zzc, zzqiVar.zza, zzqiVar.zze, zzzVar, zzqiVar.zzd, null);
        } catch (IllegalArgumentException e) {
            e = e;
            throw new zzqk(0, zzqiVar.zzb, zzqiVar.zzc, zzqiVar.zza, zzqiVar.zze, zzzVar, zzqiVar.zzd, e);
        } catch (UnsupportedOperationException e2) {
            e = e2;
            throw new zzqk(0, zzqiVar.zzb, zzqiVar.zzc, zzqiVar.zza, zzqiVar.zze, zzzVar, zzqiVar.zzd, e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final boolean zzA() {
        if (zzab()) {
            return this.zzP && !zzz();
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final boolean zzB(zzz zzzVar) {
        return zza(zzzVar) != 0;
    }

    public final void zzK(zzpj zzpjVar) {
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.zzZ;
        if (looper != looperMyLooper) {
            throw new IllegalStateException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m("Current looper (", looperMyLooper != null ? looperMyLooper.getThread().getName() : "null", ") is not the playback looper (", looper == null ? "null" : looper.getThread().getName(), ")"));
        }
        zzpj zzpjVar2 = this.zzv;
        if (zzpjVar2 == null || zzpjVar.equals(zzpjVar2)) {
            return;
        }
        this.zzv = zzpjVar;
        zzql zzqlVar = this.zzq;
        if (zzqlVar != null) {
            ((zzrs) zzqlVar).zza.zzC();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final int zza(zzz zzzVar) {
        zzT();
        if (!"audio/raw".equals(zzzVar.zzo)) {
            return this.zzv.zzb(zzzVar, this.zzy) != null ? 2 : 0;
        }
        int i = zzzVar.zzI;
        if (zzex.zzK(i)) {
            return i != 2 ? 1 : 2;
        }
        CoroutineAdapterKt$$ExternalSyntheticLambda0.m23m(i, "Invalid PCM encoding: ", "DefaultAudioSink");
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final long zzb() {
        if (!zzab()) {
            return -9223372036854775807L;
        }
        AudioTrack audioTrack = this.zzu;
        zzrd zzrdVar = this.zzs;
        if (zzrdVar.zzc == 0) {
            return zzex.zzt(audioTrack.getBufferSizeInFrames(), zzrdVar.zze);
        }
        long bufferSizeInFrames = audioTrack.getBufferSizeInFrames();
        int iZza = zzadz.zza(zzrdVar.zzg);
        zzdd.zzf(iZza != -2147483647);
        return zzex.zzu(bufferSizeInFrames, 1000000L, iZza, RoundingMode.DOWN);
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final long zzc(boolean z) {
        ArrayDeque arrayDeque;
        long j;
        if (!zzab() || this.zzJ) {
            return Long.MIN_VALUE;
        }
        long jMin = Math.min(this.zzj.zza(), zzex.zzt(zzO(), this.zzs.zze));
        while (true) {
            arrayDeque = this.zzk;
            if (arrayDeque.isEmpty() || jMin < ((zzrf) arrayDeque.getFirst()).zzc) {
                break;
            }
            this.zzA = (zzrf) arrayDeque.remove();
        }
        zzrf zzrfVar = this.zzA;
        long j2 = jMin - zzrfVar.zzc;
        long jZzq = zzex.zzq(j2, zzrfVar.zza.zzb);
        if (arrayDeque.isEmpty()) {
            long jZza = this.zzaf.zza(j2);
            zzrf zzrfVar2 = this.zzA;
            j = zzrfVar2.zzb + jZza;
            zzrfVar2.zzd = jZza - jZzq;
        } else {
            zzrf zzrfVar3 = this.zzA;
            j = zzrfVar3.zzb + jZzq + zzrfVar3.zzd;
        }
        long jZzb = this.zzaf.zzb();
        long jZzt = zzex.zzt(jZzb, this.zzs.zze) + j;
        long j3 = this.zzaa;
        if (jZzb > j3) {
            long jZzt2 = zzex.zzt(jZzb - j3, this.zzs.zze);
            this.zzaa = jZzb;
            this.zzab += jZzt2;
            if (this.zzac == null) {
                this.zzac = new Handler(Looper.myLooper());
            }
            this.zzac.removeCallbacksAndMessages(null);
            this.zzac.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqw
                @Override // java.lang.Runnable
                public final void run() {
                    zzro.zzH(this.zza);
                }
            }, 100L);
        }
        return jZzt;
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final zzbb zzd() {
        return this.zzB;
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final zzps zze(zzz zzzVar) {
        return this.zzX ? zzps.zza : this.zzag.zza(zzzVar, this.zzy);
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final void zzf(zzz zzzVar, int i, int[] iArr) throws zzqj {
        zzck zzckVar;
        int iZzk;
        int i2;
        int iIntValue;
        int i3;
        int i4;
        int iZzk2;
        zzT();
        if ("audio/raw".equals(zzzVar.zzo)) {
            int i5 = zzzVar.zzI;
            zzdd.zzd(zzex.zzK(i5));
            int i6 = zzzVar.zzG;
            iZzk2 = zzex.zzk(i5) * i6;
            zzfyn zzfynVar = new zzfyn();
            zzfynVar.zzh(this.zzi);
            zzfynVar.zzf(this.zzg);
            zzfynVar.zzg(this.zzaf.zze());
            zzck zzckVar2 = new zzck(zzfynVar.zzi());
            if (zzckVar2.equals(this.zzt)) {
                zzckVar2 = this.zzt;
            }
            this.zzf.zzq(zzzVar.zzJ, zzzVar.zzK);
            this.zze.zzo(iArr);
            try {
                zzcl zzclVarZza = zzckVar2.zza(new zzcl(zzzVar.zzH, i6, i5));
                int i7 = zzclVarZza.zzd;
                int i8 = zzclVarZza.zzb;
                int i9 = zzclVarZza.zzc;
                i3 = i7;
                i2 = i8;
                zzckVar = zzckVar2;
                iIntValue = zzex.zzi(i9);
                iZzk = zzex.zzk(i7) * i9;
                i4 = 0;
            } catch (zzcm e) {
                throw new zzqj(e, zzzVar);
            }
        } else {
            zzck zzckVar3 = new zzck(zzfyq.zzn());
            int i10 = zzzVar.zzH;
            zzps zzpsVar = zzps.zza;
            Pair pairZzb = this.zzv.zzb(zzzVar, this.zzy);
            if (pairZzb == null) {
                throw new zzqj("Unable to configure passthrough for: ".concat(String.valueOf(zzzVar)), zzzVar);
            }
            int iIntValue2 = ((Integer) pairZzb.first).intValue();
            zzckVar = zzckVar3;
            iZzk = -1;
            i2 = i10;
            iIntValue = ((Integer) pairZzb.second).intValue();
            i3 = iIntValue2;
            i4 = 2;
            iZzk2 = -1;
        }
        if (i3 == 0) {
            throw new zzqj("Invalid output encoding (mode=" + i4 + ") for: " + String.valueOf(zzzVar), zzzVar);
        }
        if (iIntValue == 0) {
            throw new zzqj("Invalid output channel config (mode=" + i4 + ") for: " + String.valueOf(zzzVar), zzzVar);
        }
        int i11 = zzzVar.zzj;
        if ("audio/vnd.dts.hd;profile=lbr".equals(zzzVar.zzo) && i11 == -1) {
            i11 = 768000;
        }
        int i12 = i11;
        int minBufferSize = AudioTrack.getMinBufferSize(i2, iIntValue, i3);
        zzdd.zzf(minBufferSize != -2);
        int i13 = iZzk != -1 ? iZzk : 1;
        int iMax = (((Math.max(minBufferSize, zzrq.zzb(minBufferSize, i3, i4, i13, i2, i12)) + i13) - 1) / i13) * i13;
        this.zzX = false;
        zzrd zzrdVar = new zzrd(zzzVar, iZzk2, i4, iZzk, i2, iIntValue, i3, iMax, zzckVar, false, false, false);
        if (zzab()) {
            this.zzr = zzrdVar;
        } else {
            this.zzs = zzrdVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final void zzg() {
        zzrh zzrhVar;
        if (zzab()) {
            this.zzD = 0L;
            this.zzE = 0L;
            this.zzF = 0L;
            this.zzG = 0L;
            this.zzY = false;
            this.zzH = 0;
            this.zzA = new zzrf(this.zzB, 0L, 0L, null);
            this.zzK = 0L;
            this.zzz = null;
            this.zzk.clear();
            this.zzM = null;
            this.zzN = 0;
            this.zzO = null;
            this.zzQ = false;
            this.zzP = false;
            this.zzR = false;
            this.zzf.zzp();
            zzZ();
            zzqs zzqsVar = this.zzj;
            if (zzqsVar.zzh()) {
                this.zzu.pause();
            }
            if (zzac(this.zzu)) {
                zzrm zzrmVar = this.zzl;
                zzrmVar.getClass();
                zzrmVar.zzb(this.zzu);
            }
            final zzqi zzqiVarZza = this.zzs.zza();
            zzrd zzrdVar = this.zzr;
            if (zzrdVar != null) {
                this.zzs = zzrdVar;
                this.zzr = null;
            }
            zzqsVar.zzc();
            if (Build.VERSION.SDK_INT >= 24 && (zzrhVar = this.zzx) != null) {
                zzrhVar.zzb();
                this.zzx = null;
            }
            final AudioTrack audioTrack = this.zzu;
            final zzql zzqlVar = this.zzq;
            final Handler handler = new Handler(Looper.myLooper());
            synchronized (zza) {
                try {
                    if (zzb == null) {
                        String str = zzex.zza;
                        final String str2 = "ExoPlayer:AudioTrackReleaseThread";
                        zzb = Executors.newSingleThreadScheduledExecutor(new ThreadFactory(str2) { // from class: com.google.android.gms.internal.ads.zzew
                            public final /* synthetic */ String zza = "ExoPlayer:AudioTrackReleaseThread";

                            @Override // java.util.concurrent.ThreadFactory
                            public final Thread newThread(Runnable runnable) {
                                String str3 = zzex.zza;
                                return new Thread(runnable, this.zza);
                            }
                        });
                    }
                    zzc++;
                    zzb.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqv
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzro.zzJ(audioTrack, zzqlVar, handler, zzqiVarZza);
                        }
                    }, 20L, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.zzu = null;
        }
        this.zzn.zza();
        this.zzm.zza();
        this.zzaa = 0L;
        this.zzab = 0L;
        Handler handler2 = this.zzac;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final void zzh() {
        this.zzI = true;
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final void zzi() {
        this.zzS = false;
        if (zzab()) {
            if (this.zzj.zzk() || zzac(this.zzu)) {
                this.zzu.pause();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final void zzj() {
        this.zzS = true;
        if (zzab()) {
            this.zzj.zzf();
            this.zzu.play();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final void zzk() {
        if (!this.zzP && zzab() && zzaa()) {
            zzU();
            this.zzP = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final void zzl() {
        zzpo zzpoVar = this.zzw;
        if (zzpoVar != null) {
            zzpoVar.zzj();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final void zzm() {
        zzg();
        zzfyq zzfyqVar = this.zzi;
        int size = zzfyqVar.size();
        for (int i = 0; i < size; i++) {
            ((zzcn) zzfyqVar.get(i)).zzf();
        }
        this.zzg.zzf();
        this.zzh.zzf();
        zzck zzckVar = this.zzt;
        if (zzckVar != null) {
            zzckVar.zzf();
        }
        this.zzS = false;
        this.zzX = false;
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final void zzn(zze zzeVar) {
        if (this.zzy.equals(zzeVar)) {
            return;
        }
        this.zzy = zzeVar;
        zzpo zzpoVar = this.zzw;
        if (zzpoVar != null) {
            zzpoVar.zzh(zzeVar);
        }
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final void zzo(int i) {
        if (this.zzT != i) {
            this.zzT = i;
            zzg();
            zzql zzqlVar = this.zzq;
            if (zzqlVar != null) {
                if (Build.VERSION.SDK_INT >= 35) {
                    zzru zzruVar = ((zzrs) zzqlVar).zza;
                    if (zzruVar.zze != null) {
                        zzruVar.zze.zzd(i);
                    }
                }
                ((zzrs) zzqlVar).zza.zzc.zzo(i);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final void zzp(zzf zzfVar) {
        if (this.zzU.equals(zzfVar)) {
            return;
        }
        if (this.zzu != null) {
            int i = this.zzU.zza;
        }
        this.zzU = zzfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final void zzq(zzdj zzdjVar) {
        this.zzj.zze(zzdjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final void zzr(zzql zzqlVar) {
        this.zzq = zzqlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final void zzs(int i, int i2) {
        AudioTrack audioTrack = this.zzu;
        if (audioTrack != null) {
            zzac(audioTrack);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final void zzt(zzbb zzbbVar) {
        float f = zzbbVar.zzb;
        String str = zzex.zza;
        this.zzB = new zzbb(Math.max(0.1f, Math.min(f, 8.0f)), Math.max(0.1f, Math.min(zzbbVar.zzc, 8.0f)));
        zzW(zzbbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final void zzu(zzph zzphVar) {
        this.zzp = zzphVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final void zzv(AudioDeviceInfo audioDeviceInfo) {
        this.zzV = audioDeviceInfo == null ? null : new zzpp(audioDeviceInfo);
        zzpo zzpoVar = this.zzw;
        if (zzpoVar != null) {
            zzpoVar.zzi(audioDeviceInfo);
        }
        AudioTrack audioTrack = this.zzu;
        if (audioTrack != null) {
            zzqz.zza(audioTrack, this.zzV);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final void zzw(boolean z) {
        this.zzC = z;
        zzW(this.zzB);
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final void zzx(float f) {
        if (this.zzL != f) {
            this.zzL = f;
            zzY();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:132:0x0259  */
    /* JADX WARN: Code duplicated, block: B:133:0x025b  */
    /* JADX WARN: Code duplicated, block: B:136:0x0269  */
    /* JADX WARN: Code duplicated, block: B:139:0x0274  */
    /* JADX WARN: Code duplicated, block: B:141:0x027d  */
    /* JADX WARN: Code duplicated, block: B:142:0x0281  */
    /* JADX WARN: Code duplicated, block: B:144:0x028b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:145:0x028d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:146:0x028f  */
    /* JADX WARN: Code duplicated, block: B:148:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:150:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:151:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:153:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:215:? A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzqo
    public final boolean zzy(ByteBuffer byteBuffer, long j, int i) throws zzqn, zzqk {
        AudioTrack audioTrackZzP;
        zzpo zzpoVar;
        zzph zzphVar;
        boolean z;
        int iZzb;
        int iPosition;
        byte b;
        int i2;
        int i3;
        int i4;
        byte b2;
        int i5;
        int i6;
        ByteBuffer byteBuffer2 = this.zzM;
        zzdd.zzd(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (this.zzr != null) {
            if (!zzaa()) {
                return false;
            }
            zzrd zzrdVar = this.zzr;
            zzrd zzrdVar2 = this.zzs;
            if (zzrdVar2.zzc == zzrdVar.zzc && zzrdVar2.zzg == zzrdVar.zzg && zzrdVar2.zze == zzrdVar.zze && zzrdVar2.zzf == zzrdVar.zzf && zzrdVar2.zzd == zzrdVar.zzd) {
                this.zzs = zzrdVar;
                this.zzr = null;
                AudioTrack audioTrack = this.zzu;
                if (audioTrack != null && zzac(audioTrack)) {
                    boolean z2 = this.zzs.zzk;
                }
            } else {
                zzU();
                if (zzz()) {
                    return false;
                }
                zzg();
            }
            zzQ(j);
        }
        if (!zzab()) {
            try {
                if (this.zzm.zzc()) {
                    return false;
                }
                try {
                    zzrd zzrdVar3 = this.zzs;
                    if (zzrdVar3 == null) {
                        throw null;
                    }
                    audioTrackZzP = zzP(zzrdVar3);
                    this.zzu = audioTrackZzP;
                    if (zzac(audioTrackZzP)) {
                        AudioTrack audioTrack2 = this.zzu;
                        if (this.zzl == null) {
                            this.zzl = new zzrm(this);
                        }
                        this.zzl.zza(audioTrack2);
                        boolean z3 = this.zzs.zzk;
                    }
                    int i7 = Build.VERSION.SDK_INT;
                    if (i7 >= 31 && (zzphVar = this.zzp) != null) {
                        AudioTrack audioTrack3 = this.zzu;
                        LogSessionId logSessionIdZza = zzphVar.zza();
                        if (!logSessionIdZza.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                            audioTrack3.setLogSessionId(logSessionIdZza);
                        }
                    }
                    this.zzT = this.zzu.getAudioSessionId();
                    zzqs zzqsVar = this.zzj;
                    AudioTrack audioTrack4 = this.zzu;
                    zzrd zzrdVar4 = this.zzs;
                    zzqsVar.zzd(audioTrack4, zzrdVar4.zzc == 2, zzrdVar4.zzg, zzrdVar4.zzd, zzrdVar4.zzh, this.zzae);
                    zzY();
                    int i8 = this.zzU.zza;
                    zzpp zzppVar = this.zzV;
                    if (zzppVar != null) {
                        zzqz.zza(this.zzu, zzppVar);
                        zzpo zzpoVar2 = this.zzw;
                        if (zzpoVar2 != null) {
                            zzpoVar2.zzi(this.zzV.zza);
                        }
                    }
                    if (i7 >= 24 && (zzpoVar = this.zzw) != null) {
                        this.zzx = new zzrh(this.zzu, zzpoVar);
                    }
                    this.zzJ = true;
                    zzql zzqlVar = this.zzq;
                    if (zzqlVar != null) {
                        ((zzrs) zzqlVar).zza.zzc.zzq(this.zzs.zza());
                    }
                } catch (zzqk e) {
                    zzrd zzrdVar5 = this.zzs;
                    if (zzrdVar5.zzh > 1000000) {
                        zzrd zzrdVar6 = new zzrd(zzrdVar5.zza, zzrdVar5.zzb, zzrdVar5.zzc, zzrdVar5.zzd, zzrdVar5.zze, zzrdVar5.zzf, zzrdVar5.zzg, 1000000, zzrdVar5.zzi, false, false, false);
                        try {
                            audioTrackZzP = zzP(zzrdVar6);
                            this.zzs = zzrdVar6;
                        } catch (zzqk e2) {
                            e.addSuppressed(e2);
                            zzS();
                            throw e;
                        }
                    }
                    zzS();
                    throw e;
                }
            } catch (zzqk e3) {
                if (e3.zzb) {
                    throw e3;
                }
                this.zzm.zzb(e3);
                return false;
            }
        }
        this.zzm.zza();
        if (this.zzJ) {
            this.zzK = Math.max(0L, j);
            this.zzI = false;
            this.zzJ = false;
            zzQ(j);
            if (this.zzS) {
                zzj();
            }
        }
        zzqs zzqsVar2 = this.zzj;
        zzqsVar2.zzj(zzO());
        if (this.zzM == null) {
            zzdd.zzd(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            zzrd zzrdVar7 = this.zzs;
            if (zzrdVar7.zzc != 0 && this.zzH == 0) {
                int i9 = zzrdVar7.zzg;
                if (i9 == 20) {
                    z = true;
                    iZzb = zzaeq.zzb(byteBuffer);
                } else if (i9 != 30) {
                    switch (i9) {
                        case 5:
                        case 6:
                            iZzb = zzacu.zza(byteBuffer);
                            z = true;
                            break;
                        case 7:
                        case 8:
                            if (byteBuffer.getInt(0) == -233094848) {
                                z = true;
                                iZzb = 1024;
                            } else {
                                if (byteBuffer.getInt(0) == -398277519) {
                                    iZzb = 1024;
                                } else if (byteBuffer.getInt(0) != 622876772) {
                                    iPosition = byteBuffer.position();
                                    b = byteBuffer.get(iPosition);
                                    if (b != -2) {
                                        if (b != -1) {
                                            if (b != 31) {
                                                i4 = (byteBuffer.get(iPosition + 4) & 1) << 6;
                                                i5 = byteBuffer.get(iPosition + 5) & 252;
                                                i3 = 2;
                                            } else {
                                                i3 = 2;
                                                i4 = (byteBuffer.get(iPosition + 5) & 7) << 4;
                                                b2 = byteBuffer.get(iPosition + 6);
                                            }
                                            i2 = (i5 >> i3) | i4;
                                            z = true;
                                        } else {
                                            i3 = 2;
                                            i4 = (byteBuffer.get(iPosition + 4) & 7) << 4;
                                            b2 = byteBuffer.get(iPosition + 7);
                                        }
                                        i5 = b2 & 60;
                                        i2 = (i5 >> i3) | i4;
                                        z = true;
                                    } else {
                                        z = true;
                                        i2 = ((byteBuffer.get(iPosition + 5) & 1) << 6) | ((byteBuffer.get(iPosition + 4) & 252) >> 2);
                                    }
                                    iZzb = (i2 + (z ? 1 : 0)) * 32;
                                } else {
                                    iZzb = 4096;
                                }
                                z = true;
                            }
                            break;
                        case 9:
                            iZzb = zzaeo.zzc(zzex.zzj(byteBuffer, byteBuffer.position()));
                            if (iZzb == -1) {
                                throw new IllegalArgumentException();
                            }
                            z = true;
                            break;
                        case 10:
                            iZzb = 1024;
                            z = true;
                            break;
                        case 11:
                        case 12:
                            iZzb = 2048;
                            z = true;
                            break;
                        default:
                            switch (i9) {
                                case 14:
                                    int iPosition2 = byteBuffer.position();
                                    int iLimit = byteBuffer.limit() - 10;
                                    int i10 = iPosition2;
                                    while (true) {
                                        if (i10 > iLimit) {
                                            i6 = -1;
                                        } else if ((zzex.zzj(byteBuffer, i10 + 4) & (-2)) == -126718022) {
                                            i6 = i10 - iPosition2;
                                        } else {
                                            i10++;
                                        }
                                    }
                                    if (i6 != -1) {
                                        iZzb = (40 << ((byteBuffer.get((byteBuffer.position() + i6) + ((byteBuffer.get((byteBuffer.position() + i6) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7)) * 16;
                                    } else {
                                        iZzb = 0;
                                    }
                                    break;
                                case 15:
                                    iZzb = 512;
                                    break;
                                case 16:
                                    iZzb = 1024;
                                    break;
                                case 17:
                                    byte[] bArr = new byte[16];
                                    int iPosition3 = byteBuffer.position();
                                    byteBuffer.get(bArr);
                                    byteBuffer.position(iPosition3);
                                    iZzb = zzacy.zzb(new zzem(bArr, 16)).zzc;
                                    break;
                                case 18:
                                    iZzb = zzacu.zza(byteBuffer);
                                    break;
                                default:
                                    throw new IllegalStateException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i9, "Unexpected audio encoding: "));
                            }
                            z = true;
                            break;
                    }
                } else if (byteBuffer.getInt(0) == -233094848) {
                    if (byteBuffer.getInt(0) == -398277519) {
                        iZzb = 1024;
                    } else if (byteBuffer.getInt(0) != 622876772) {
                        iZzb = 4096;
                    } else {
                        iPosition = byteBuffer.position();
                        b = byteBuffer.get(iPosition);
                        if (b != -2) {
                            if (b != -1) {
                                if (b != 31) {
                                    i4 = (byteBuffer.get(iPosition + 4) & 1) << 6;
                                    i5 = byteBuffer.get(iPosition + 5) & 252;
                                    i3 = 2;
                                } else {
                                    i3 = 2;
                                    i4 = (byteBuffer.get(iPosition + 5) & 7) << 4;
                                    b2 = byteBuffer.get(iPosition + 6);
                                }
                                i2 = (i5 >> i3) | i4;
                                z = true;
                            } else {
                                i3 = 2;
                                i4 = (byteBuffer.get(iPosition + 4) & 7) << 4;
                                b2 = byteBuffer.get(iPosition + 7);
                            }
                            i5 = b2 & 60;
                            i2 = (i5 >> i3) | i4;
                            z = true;
                        } else {
                            z = true;
                            i2 = ((byteBuffer.get(iPosition + 5) & 1) << 6) | ((byteBuffer.get(iPosition + 4) & 252) >> 2);
                        }
                        iZzb = (i2 + (z ? 1 : 0)) * 32;
                    }
                    z = true;
                } else {
                    z = true;
                    iZzb = 1024;
                }
                this.zzH = iZzb;
                if (iZzb == 0) {
                    return z;
                }
            }
            if (this.zzz != null) {
                if (!zzaa()) {
                    return false;
                }
                zzQ(j);
                this.zzz = null;
            }
            long jZzt = zzex.zzt(zzN() - this.zzf.zzo(), this.zzs.zza.zzH) + this.zzK;
            if (!this.zzI && Math.abs(jZzt - j) > 200000) {
                zzql zzqlVar2 = this.zzq;
                if (zzqlVar2 != null) {
                    zzqlVar2.zza(new zzqm(j, jZzt));
                }
                this.zzI = true;
            }
            if (this.zzI) {
                if (!zzaa()) {
                    return false;
                }
                long j2 = j - jZzt;
                this.zzK += j2;
                this.zzI = false;
                zzQ(j);
                zzql zzqlVar3 = this.zzq;
                if (zzqlVar3 != null && j2 != 0) {
                    ((zzrs) zzqlVar3).zza.zzas();
                }
            }
            if (this.zzs.zzc == 0) {
                this.zzD += (long) byteBuffer.remaining();
            } else {
                this.zzE = (((long) this.zzH) * ((long) i)) + this.zzE;
            }
            this.zzM = byteBuffer;
            this.zzN = i;
        }
        zzV(j);
        if (!this.zzM.hasRemaining()) {
            this.zzM = null;
            this.zzN = 0;
            return true;
        }
        if (!zzqsVar2.zzi(zzO())) {
            return false;
        }
        zzea.zzf("DefaultAudioSink", "Resetting stalled audio track");
        zzg();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final boolean zzz() {
        if (zzab()) {
            return !(Build.VERSION.SDK_INT >= 29 && this.zzu.isOffloadedPlayback() && this.zzR) && this.zzj.zzg(zzO());
        }
        return false;
    }
}
