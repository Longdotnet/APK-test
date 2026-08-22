package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.Build;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
final class zzqs {
    private long zzA;
    private long zzB;
    private long zzC;
    private long zzD;
    private boolean zzE;
    private long zzF;
    private zzdj zzG;
    boolean zza;
    private final zzqr zzb;
    private final long[] zzc;
    private AudioTrack zzd;
    private int zze;
    private zzqq zzf;
    private int zzg;
    private long zzh;
    private float zzi;
    private boolean zzj;
    private long zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private Method zzo;
    private long zzp;
    private boolean zzq;
    private boolean zzr;
    private long zzs;
    private long zzt;
    private long zzu;
    private long zzv;
    private int zzw;
    private int zzx;
    private long zzy;
    private long zzz;

    public zzqs(zzqr zzqrVar) {
        this.zzb = zzqrVar;
        try {
            this.zzo = AudioTrack.class.getMethod("getLatency", null);
        } catch (NoSuchMethodException unused) {
        }
        this.zzc = new long[10];
        this.zzD = -9223372036854775807L;
        this.zzC = -9223372036854775807L;
        this.zzG = zzdj.zza;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0065  */
    private final long zzl() {
        if (this.zzy != -9223372036854775807L) {
            return Math.min(this.zzB, zzo());
        }
        long jZzb = this.zzG.zzb();
        if (jZzb - this.zzt >= 5) {
            AudioTrack audioTrack = this.zzd;
            audioTrack.getClass();
            int playState = audioTrack.getPlayState();
            if (playState != 1) {
                long playbackHeadPosition = ((long) audioTrack.getPlaybackHeadPosition()) & 4294967295L;
                if (Build.VERSION.SDK_INT > 29) {
                    if (this.zzu > playbackHeadPosition) {
                        this.zzv++;
                    }
                    this.zzu = playbackHeadPosition;
                } else {
                    if (playbackHeadPosition == 0) {
                        if (this.zzu <= 0 || playState != 3) {
                            playbackHeadPosition = 0;
                        } else if (this.zzz == -9223372036854775807L) {
                            this.zzz = jZzb;
                        }
                    }
                    this.zzz = -9223372036854775807L;
                    if (this.zzu > playbackHeadPosition) {
                        this.zzv++;
                    }
                    this.zzu = playbackHeadPosition;
                }
            }
            this.zzt = jZzb;
        }
        return this.zzu + this.zzF + (this.zzv << 32);
    }

    private final long zzm(long j) {
        long jZzq;
        if (this.zzx == 0) {
            jZzq = this.zzy != -9223372036854775807L ? zzex.zzt(zzo(), this.zzg) : zzn();
        } else {
            jZzq = zzex.zzq(j + this.zzm, this.zzi);
        }
        long jMax = Math.max(0L, jZzq - this.zzp);
        return this.zzy != -9223372036854775807L ? Math.min(zzex.zzt(this.zzB, this.zzg), jMax) : jMax;
    }

    private final long zzn() {
        return zzex.zzt(zzl(), this.zzg);
    }

    private final long zzo() {
        AudioTrack audioTrack = this.zzd;
        audioTrack.getClass();
        if (audioTrack.getPlayState() == 2) {
            return this.zzA;
        }
        return this.zzA + zzex.zzp(zzex.zzq(zzex.zzs(this.zzG.zzb()) - this.zzy, this.zzi), this.zzg);
    }

    private final void zzp() {
        this.zzm = 0L;
        this.zzx = 0;
        this.zzw = 0;
        this.zzn = 0L;
        this.zzC = -9223372036854775807L;
        this.zzD = -9223372036854775807L;
        this.zzj = false;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0079 A[Catch: Exception -> 0x00a2, TryCatch #0 {Exception -> 0x00a2, blocks: (B:23:0x0075, B:25:0x0079, B:27:0x0099, B:28:0x00a1), top: B:66:0x0075 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0099 A[Catch: Exception -> 0x00a2, TryCatch #0 {Exception -> 0x00a2, blocks: (B:23:0x0075, B:25:0x0079, B:27:0x0099, B:28:0x00a1), top: B:66:0x0075 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x00a1 A[Catch: Exception -> 0x00a2, TRY_LEAVE, TryCatch #0 {Exception -> 0x00a2, blocks: (B:23:0x0075, B:25:0x0079, B:27:0x0099, B:28:0x00a1), top: B:66:0x0075 }] */
    public final long zza() {
        Method method;
        AudioTrack audioTrack;
        long jMax;
        AudioTrack audioTrack2 = this.zzd;
        audioTrack2.getClass();
        if (audioTrack2.getPlayState() == 3) {
            long jZzc = this.zzG.zzc() / 1000;
            if (jZzc - this.zzn >= 30000) {
                long jZzn = zzn();
                if (jZzn != 0) {
                    long[] jArr = this.zzc;
                    jArr[this.zzw] = zzex.zzr(jZzn, this.zzi) - jZzc;
                    this.zzw = (this.zzw + 1) % 10;
                    int i = this.zzx;
                    if (i < 10) {
                        this.zzx = i + 1;
                    }
                    this.zzn = jZzc;
                    this.zzm = 0L;
                    int i2 = 0;
                    while (true) {
                        int i3 = this.zzx;
                        if (i2 >= i3) {
                            break;
                        }
                        this.zzm = (jArr[i2] / ((long) i3)) + this.zzm;
                        i2++;
                    }
                    if (this.zzr && (method = this.zzo) != null && jZzc - this.zzs >= 500000) {
                        try {
                            audioTrack = this.zzd;
                            if (audioTrack != null) {
                                throw null;
                            }
                            Integer num = (Integer) method.invoke(audioTrack, null);
                            String str = zzex.zza;
                            long jIntValue = (((long) num.intValue()) * 1000) - this.zzh;
                            this.zzp = jIntValue;
                            jMax = Math.max(jIntValue, 0L);
                            this.zzp = jMax;
                            if (jMax > 5000000) {
                                this.zzb.zza(jMax);
                                this.zzp = 0L;
                            }
                            this.zzs = jZzc;
                        } catch (Exception unused) {
                            this.zzo = null;
                        }
                    }
                    zzqq zzqqVar = this.zzf;
                    zzqqVar.getClass();
                    zzqqVar.zzb(jZzc, this.zzi, zzm(jZzc));
                }
            } else {
                if (this.zzr) {
                    audioTrack = this.zzd;
                    if (audioTrack != null) {
                        throw null;
                    }
                    Integer num2 = (Integer) method.invoke(audioTrack, null);
                    String str2 = zzex.zza;
                    long jIntValue2 = (((long) num2.intValue()) * 1000) - this.zzh;
                    this.zzp = jIntValue2;
                    jMax = Math.max(jIntValue2, 0L);
                    this.zzp = jMax;
                    if (jMax > 5000000) {
                        this.zzb.zza(jMax);
                        this.zzp = 0L;
                    }
                    this.zzs = jZzc;
                }
                zzqq zzqqVar2 = this.zzf;
                zzqqVar2.getClass();
                zzqqVar2.zzb(jZzc, this.zzi, zzm(jZzc));
            }
        }
        long jZzc2 = this.zzG.zzc() / 1000;
        zzqq zzqqVar3 = this.zzf;
        zzqqVar3.getClass();
        boolean zZzd = zzqqVar3.zzd();
        long jZza = zZzd ? zzqqVar3.zza(jZzc2, this.zzi) : zzm(jZzc2);
        if (audioTrack2.getPlayState() == 3) {
            if (this.zza) {
                long j = this.zzk;
                if (j != -9223372036854775807L && jZza >= j && (zZzd || !zzqqVar3.zze())) {
                    long jZza2 = this.zzG.zza() - zzex.zzv(zzex.zzr(jZza - j, this.zzi));
                    this.zzk = -9223372036854775807L;
                    this.zzb.zzb(jZza2);
                }
            }
            long j2 = this.zzD;
            if (j2 != -9223372036854775807L) {
                long j3 = jZza - this.zzC;
                long jZzq = zzex.zzq(jZzc2 - j2, this.zzi);
                long j4 = this.zzC + jZzq;
                long jAbs = Math.abs(j4 - jZza);
                if (j3 != 0 && jAbs < 1000000) {
                    long j5 = (jZzq * 10) / 100;
                    jZza = Math.max(j4 - j5, Math.min(jZza, j4 + j5));
                }
            }
            if (!this.zza && !this.zzj) {
                long j6 = this.zzC;
                if (j6 != -9223372036854775807L && jZza > j6) {
                    this.zzj = true;
                    String str3 = zzex.zza;
                    this.zzb.zzb(this.zzG.zza() - zzex.zzv(zzex.zzr(zzex.zzv(jZza - j6), this.zzi)));
                }
            }
            this.zzD = jZzc2;
            this.zzC = jZza;
        }
        return jZza;
    }

    public final void zzb(long j) {
        this.zzA = zzl();
        this.zzy = zzex.zzs(this.zzG.zzb());
        this.zzB = j;
    }

    public final void zzc() {
        zzp();
        this.zzd = null;
        this.zzf = null;
    }

    public final void zzd(AudioTrack audioTrack, boolean z, int i, int i2, int i3, boolean z2) {
        this.zzd = audioTrack;
        this.zze = i3;
        this.zzf = new zzqq(audioTrack, this.zzb);
        this.zzg = audioTrack.getSampleRate();
        boolean zZzK = zzex.zzK(i);
        this.zzr = zZzK;
        this.zzh = zZzK ? zzex.zzt(i3 / i2, this.zzg) : -9223372036854775807L;
        this.zzu = 0L;
        this.zzv = 0L;
        this.zzE = false;
        this.zzF = 0L;
        this.zzq = false;
        this.zzy = -9223372036854775807L;
        this.zzz = -9223372036854775807L;
        this.zzs = 0L;
        this.zzp = 0L;
        this.zzi = 1.0f;
        this.zzl = 0;
        this.zzk = -9223372036854775807L;
        this.zza = z2;
    }

    public final void zze(zzdj zzdjVar) {
        this.zzG = zzdjVar;
    }

    public final void zzf() {
        if (this.zzy != -9223372036854775807L) {
            this.zzy = zzex.zzs(this.zzG.zzb());
        }
        this.zzk = zzn();
        zzqq zzqqVar = this.zzf;
        zzqqVar.getClass();
        zzqqVar.zzc();
    }

    public final boolean zzg(long j) {
        return j > zzex.zzp(zza(), this.zzg);
    }

    public final boolean zzh() {
        AudioTrack audioTrack = this.zzd;
        audioTrack.getClass();
        return audioTrack.getPlayState() == 3;
    }

    public final boolean zzi(long j) {
        return this.zzz != -9223372036854775807L && j > 0 && this.zzG.zzb() - this.zzz >= 200;
    }

    public final boolean zzj(long j) {
        AudioTrack audioTrack = this.zzd;
        audioTrack.getClass();
        int playState = audioTrack.getPlayState();
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 24) {
            AudioTrack audioTrack2 = this.zzd;
            audioTrack2.getClass();
            int underrunCount = audioTrack2.getUnderrunCount();
            z = underrunCount > this.zzl;
            this.zzl = underrunCount;
        } else {
            boolean z2 = this.zzq;
            boolean zZzg = zzg(j);
            this.zzq = zZzg;
            if (z2 && !zZzg && playState != 1) {
                z = true;
            }
        }
        if (z) {
            this.zzb.zze(this.zze, zzex.zzv(this.zzh));
        }
        return true;
    }

    public final boolean zzk() {
        zzp();
        if (this.zzy != -9223372036854775807L) {
            this.zzA = zzl();
            return false;
        }
        zzqq zzqqVar = this.zzf;
        zzqqVar.getClass();
        zzqqVar.zzc();
        return true;
    }
}
