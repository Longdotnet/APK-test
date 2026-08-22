package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.DeniedByServerException;
import android.media.MediaCodec;
import android.media.MediaDrm;
import android.media.MediaDrmResetException;
import android.media.NotProvisionedException;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.NetworkEvent;
import android.media.metrics.PlaybackErrorEvent;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.PlaybackStateEvent;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.util.Pair;
import androidx.core.view.ContentInfoCompat$$ExternalSyntheticApiModelOutline0;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzpd implements zzmr, zzpe {
    private boolean zzA;
    private final Context zza;
    private final zzpf zzc;
    private final PlaybackSession zzd;
    private String zzj;
    private PlaybackMetrics.Builder zzk;
    private int zzl;
    private zzba zzo;
    private zzpc zzp;
    private zzpc zzq;
    private zzpc zzr;
    private zzz zzs;
    private zzz zzt;
    private zzz zzu;
    private boolean zzv;
    private boolean zzw;
    private int zzx;
    private int zzy;
    private int zzz;
    private final Executor zzb = zzde.zza();
    private final zzbk zzf = new zzbk();
    private final zzbj zzg = new zzbj();
    private final HashMap zzi = new HashMap();
    private final HashMap zzh = new HashMap();
    private final long zze = SystemClock.elapsedRealtime();
    private int zzm = 0;
    private int zzn = 0;

    private zzpd(Context context, PlaybackSession playbackSession) {
        this.zza = context.getApplicationContext();
        this.zzd = playbackSession;
        zzow zzowVar = new zzow(zzow.zza);
        this.zzc = zzowVar;
        zzowVar.zzh(this);
    }

    private final void zzA(zzbl zzblVar, zzvh zzvhVar) {
        int iZza;
        PlaybackMetrics.Builder builder = this.zzk;
        if (zzvhVar == null || (iZza = zzblVar.zza(zzvhVar.zza)) == -1) {
            return;
        }
        zzbj zzbjVar = this.zzg;
        int i = 0;
        zzblVar.zzd(iZza, zzbjVar, false);
        zzbk zzbkVar = this.zzf;
        zzblVar.zze(zzbjVar.zzc, zzbkVar, 0L);
        zzak zzakVar = zzbkVar.zzd.zzb;
        if (zzakVar != null) {
            int iZzo = zzex.zzo(zzakVar.zza);
            if (iZzo == 0) {
                i = 3;
            } else if (iZzo != 1) {
                i = iZzo != 2 ? 1 : 4;
            } else {
                i = 5;
            }
        }
        builder.setStreamType(i);
        long j = zzbkVar.zzm;
        if (j != -9223372036854775807L && !zzbkVar.zzk && !zzbkVar.zzi && !zzbkVar.zzb()) {
            builder.setMediaDurationMillis(zzex.zzv(j));
        }
        builder.setPlaybackType(true != zzbkVar.zzb() ? 1 : 2);
        this.zzA = true;
    }

    private final void zzB(long j, zzz zzzVar, int i) {
        if (Objects.equals(this.zzs, zzzVar)) {
            return;
        }
        int i2 = this.zzs == null ? 1 : 0;
        this.zzs = zzzVar;
        zzC(1, j, zzzVar, i2);
    }

    private final void zzC(int i, long j, zzz zzzVar, int i2) {
        TrackChangeEvent.Builder timeSinceCreatedMillis = zzpd$$ExternalSyntheticApiModelOutline4.m(i).setTimeSinceCreatedMillis(j - this.zze);
        if (zzzVar != null) {
            timeSinceCreatedMillis.setTrackState(1);
            timeSinceCreatedMillis.setTrackChangeReason(i2 != 1 ? 1 : 2);
            String str = zzzVar.zzn;
            if (str != null) {
                timeSinceCreatedMillis.setContainerMimeType(str);
            }
            String str2 = zzzVar.zzo;
            if (str2 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str2);
            }
            String str3 = zzzVar.zzk;
            if (str3 != null) {
                timeSinceCreatedMillis.setCodecName(str3);
            }
            int i3 = zzzVar.zzj;
            if (i3 != -1) {
                timeSinceCreatedMillis.setBitrate(i3);
            }
            int i4 = zzzVar.zzv;
            if (i4 != -1) {
                timeSinceCreatedMillis.setWidth(i4);
            }
            int i5 = zzzVar.zzw;
            if (i5 != -1) {
                timeSinceCreatedMillis.setHeight(i5);
            }
            int i6 = zzzVar.zzG;
            if (i6 != -1) {
                timeSinceCreatedMillis.setChannelCount(i6);
            }
            int i7 = zzzVar.zzH;
            if (i7 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i7);
            }
            String str4 = zzzVar.zzd;
            if (str4 != null) {
                String str5 = zzex.zza;
                String[] strArrSplit = str4.split("-", -1);
                Pair pairCreate = Pair.create(strArrSplit[0], strArrSplit.length >= 2 ? strArrSplit[1] : null);
                timeSinceCreatedMillis.setLanguage((String) pairCreate.first);
                Object obj = pairCreate.second;
                if (obj != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) obj);
                }
            }
            float f = zzzVar.zzz;
            if (f != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.zzA = true;
        final TrackChangeEvent trackChangeEventBuild = timeSinceCreatedMillis.build();
        this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzox
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzd.reportTrackChangeEvent(trackChangeEventBuild);
            }
        });
    }

    private final boolean zzD(zzpc zzpcVar) {
        if (zzpcVar != null) {
            return zzpcVar.zzc.equals(this.zzc.zze());
        }
        return false;
    }

    public static zzpd zzb(Context context) {
        MediaMetricsManager mediaMetricsManagerM = zzpd$$ExternalSyntheticApiModelOutline2.m(context.getSystemService("media_metrics"));
        if (mediaMetricsManagerM == null) {
            return null;
        }
        return new zzpd(context, mediaMetricsManagerM.createPlaybackSession());
    }

    private static int zzw(int i) {
        switch (zzex.zzl(i)) {
            case 6002:
                return 24;
            case 6003:
                return 28;
            case 6004:
                return 25;
            case 6005:
                return 26;
            default:
                return 27;
        }
    }

    private final void zzx() {
        PlaybackMetrics.Builder builder = this.zzk;
        if (builder != null && this.zzA) {
            builder.setAudioUnderrunCount(this.zzz);
            this.zzk.setVideoFramesDropped(this.zzx);
            this.zzk.setVideoFramesPlayed(this.zzy);
            Long l = (Long) this.zzh.get(this.zzj);
            this.zzk.setNetworkTransferDurationMillis(l == null ? 0L : l.longValue());
            Long l2 = (Long) this.zzi.get(this.zzj);
            this.zzk.setNetworkBytesRead(l2 == null ? 0L : l2.longValue());
            this.zzk.setStreamSource((l2 == null || l2.longValue() <= 0) ? 0 : 1);
            final PlaybackMetrics playbackMetricsBuild = this.zzk.build();
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpa
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzd.reportPlaybackMetrics(playbackMetricsBuild);
                }
            });
        }
        this.zzk = null;
        this.zzj = null;
        this.zzz = 0;
        this.zzx = 0;
        this.zzy = 0;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzA = false;
    }

    private final void zzy(long j, zzz zzzVar, int i) {
        if (Objects.equals(this.zzt, zzzVar)) {
            return;
        }
        int i2 = this.zzt == null ? 1 : 0;
        this.zzt = zzzVar;
        zzC(0, j, zzzVar, i2);
    }

    private final void zzz(long j, zzz zzzVar, int i) {
        if (Objects.equals(this.zzu, zzzVar)) {
            return;
        }
        int i2 = this.zzu == null ? 1 : 0;
        this.zzu = zzzVar;
        zzC(2, j, zzzVar, i2);
    }

    public final LogSessionId zza() {
        return this.zzd.getSessionId();
    }

    @Override // com.google.android.gms.internal.ads.zzmr
    public final /* synthetic */ void zze(zzmp zzmpVar, zzz zzzVar, zzie zzieVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzmr
    public final void zzf(zzmp zzmpVar, int i, long j, long j2) {
        zzvh zzvhVar = zzmpVar.zzd;
        if (zzvhVar != null) {
            String strZzf = this.zzc.zzf(zzmpVar.zzb, zzvhVar);
            HashMap map = this.zzi;
            Long l = (Long) map.get(strZzf);
            HashMap map2 = this.zzh;
            Long l2 = (Long) map2.get(strZzf);
            map.put(strZzf, Long.valueOf((l == null ? 0L : l.longValue()) + j));
            map2.put(strZzf, Long.valueOf((l2 != null ? l2.longValue() : 0L) + ((long) i)));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmr
    public final void zzg(zzmp zzmpVar, zzvd zzvdVar) {
        zzvh zzvhVar = zzmpVar.zzd;
        if (zzvhVar == null) {
            return;
        }
        zzz zzzVar = zzvdVar.zzb;
        zzzVar.getClass();
        zzpc zzpcVar = new zzpc(zzzVar, 0, this.zzc.zzf(zzmpVar.zzb, zzvhVar));
        int i = zzvdVar.zza;
        if (i != 0) {
            if (i == 1) {
                this.zzq = zzpcVar;
                return;
            } else if (i != 2) {
                if (i != 3) {
                    return;
                }
                this.zzr = zzpcVar;
                return;
            }
        }
        this.zzp = zzpcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzmr
    public final /* synthetic */ void zzh(zzmp zzmpVar, int i, long j) {
    }

    /* JADX WARN: Code duplicated, block: B:102:0x016c  */
    /* JADX WARN: Code duplicated, block: B:137:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:140:0x01f4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:141:0x01f6 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:145:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:146:0x020a  */
    /* JADX WARN: Code duplicated, block: B:148:0x0210  */
    /* JADX WARN: Code duplicated, block: B:149:0x0216  */
    /* JADX WARN: Code duplicated, block: B:151:0x021a  */
    /* JADX WARN: Code duplicated, block: B:152:0x021d  */
    /* JADX WARN: Code duplicated, block: B:154:0x0221  */
    /* JADX WARN: Code duplicated, block: B:155:0x0229  */
    /* JADX WARN: Code duplicated, block: B:157:0x022d  */
    /* JADX WARN: Code duplicated, block: B:158:0x0235  */
    /* JADX WARN: Code duplicated, block: B:160:0x0239  */
    /* JADX WARN: Code duplicated, block: B:161:0x0245  */
    /* JADX WARN: Code duplicated, block: B:171:0x0292  */
    /* JADX WARN: Code duplicated, block: B:173:0x0297  */
    /* JADX WARN: Code duplicated, block: B:175:0x029c  */
    @Override // com.google.android.gms.internal.ads.zzmr
    public final void zzi(zzbh zzbhVar, zzmq zzmqVar) {
        int i;
        int i2;
        int iZzw;
        int i3;
        int errorCode;
        int iZzm;
        zzs zzsVar;
        int i4;
        int i5;
        if (zzmqVar.zzb() == 0) {
            return;
        }
        for (int i6 = 0; i6 < zzmqVar.zzb(); i6++) {
            int iZza = zzmqVar.zza(i6);
            zzmp zzmpVarZzc = zzmqVar.zzc(iZza);
            if (iZza == 0) {
                this.zzc.zzk(zzmpVarZzc);
            } else if (iZza == 11) {
                this.zzc.zzj(zzmpVarZzc, this.zzl);
            } else {
                this.zzc.zzi(zzmpVarZzc);
            }
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (zzmqVar.zzd(0)) {
            zzmp zzmpVarZzc2 = zzmqVar.zzc(0);
            if (this.zzk != null) {
                zzA(zzmpVarZzc2.zzb, zzmpVarZzc2.zzd);
            }
        }
        if (zzmqVar.zzd(2) && this.zzk != null) {
            zzfyq zzfyqVarZza = zzbhVar.zzp().zza();
            int size = zzfyqVarZza.size();
            int i7 = 0;
            loop1: while (true) {
                if (i7 >= size) {
                    zzsVar = null;
                    break;
                }
                zzbs zzbsVar = (zzbs) zzfyqVarZza.get(i7);
                int i8 = 0;
                while (true) {
                    i5 = i7 + 1;
                    if (i8 < zzbsVar.zza) {
                        if (zzbsVar.zzd(i8) && (zzsVar = zzbsVar.zzb(i8).zzs) != null) {
                            break loop1;
                        } else {
                            i8++;
                        }
                    }
                }
                i7 = i5;
            }
            if (zzsVar != null) {
                PlaybackMetrics.Builder builder = this.zzk;
                String str = zzex.zza;
                PlaybackMetrics.Builder builderM14m = ContentInfoCompat$$ExternalSyntheticApiModelOutline0.m14m((Object) builder);
                int i9 = 0;
                while (true) {
                    if (i9 >= zzsVar.zzb) {
                        i4 = 1;
                        break;
                    }
                    UUID uuid = zzsVar.zza(i9).zza;
                    if (uuid.equals(zzh.zzd)) {
                        i4 = 3;
                        break;
                    } else if (uuid.equals(zzh.zze)) {
                        i4 = 2;
                        break;
                    } else {
                        if (uuid.equals(zzh.zzc)) {
                            i4 = 6;
                            break;
                        }
                        i9++;
                    }
                }
                builderM14m.setDrmType(i4);
            }
        }
        if (zzmqVar.zzd(1011)) {
            this.zzz++;
        }
        zzba zzbaVar = this.zzo;
        if (zzbaVar != null) {
            Context context = this.zza;
            int i10 = zzbaVar.zza;
            if (i10 == 1001) {
                i3 = 20;
            } else {
                zzin zzinVar = (zzin) zzbaVar;
                boolean z = zzinVar.zzc == 1;
                int i11 = zzinVar.zzg;
                Throwable cause = zzbaVar.getCause();
                cause.getClass();
                if (cause instanceof IOException) {
                    if (cause instanceof zzhc) {
                        iZzm = ((zzhc) cause).zzc;
                        i3 = 5;
                    } else if ((cause instanceof zzhb) || (cause instanceof zzaz)) {
                        iZzm = 0;
                        i3 = 11;
                    } else {
                        boolean z2 = cause instanceof zzha;
                        if (z2 || (cause instanceof zzhk)) {
                            if (zzel.zzb(context).zza() == 1) {
                                iZzm = 0;
                                i3 = 3;
                            } else {
                                Throwable cause2 = cause.getCause();
                                if (cause2 instanceof UnknownHostException) {
                                    iZzm = 0;
                                    i3 = 6;
                                } else if (cause2 instanceof SocketTimeoutException) {
                                    iZzm = 0;
                                    i3 = 7;
                                } else if (z2 && ((zzha) cause).zzb == 1) {
                                    iZzm = 0;
                                    i3 = 4;
                                } else {
                                    iZzm = 0;
                                    i3 = 8;
                                }
                            }
                        } else if (i10 == 1002) {
                            i3 = 21;
                        } else if (cause instanceof zzsa) {
                            Throwable cause3 = cause.getCause();
                            cause3.getClass();
                            if (cause3 instanceof MediaDrm.MediaDrmStateException) {
                                errorCode = zzex.zzm(((MediaDrm.MediaDrmStateException) cause3).getDiagnosticInfo());
                                iZzw = zzw(errorCode);
                                int i12 = iZzw;
                                iZzm = errorCode;
                                i3 = i12;
                            } else if (cause3 instanceof MediaDrmResetException) {
                                i3 = 27;
                            } else if (cause3 instanceof NotProvisionedException) {
                                i3 = 24;
                            } else if (cause3 instanceof DeniedByServerException) {
                                i3 = 29;
                            } else if (cause3 instanceof zzsk) {
                                iZzm = 0;
                                i3 = 23;
                            } else {
                                i3 = cause3 instanceof zzrz ? 28 : 30;
                            }
                        } else if ((cause instanceof zzgx) && (cause.getCause() instanceof FileNotFoundException)) {
                            Throwable cause4 = cause.getCause();
                            cause4.getClass();
                            Throwable cause5 = cause4.getCause();
                            if ((cause5 instanceof ErrnoException) && ((ErrnoException) cause5).errno == OsConstants.EACCES) {
                                i3 = 32;
                            } else {
                                iZzm = 0;
                                i3 = 31;
                            }
                        } else {
                            iZzm = 0;
                            i3 = 9;
                        }
                    }
                } else if (z) {
                    i3 = 35;
                    if (i11 != 0 && i11 != 1) {
                        if (!z && i11 == 3) {
                            i3 = 15;
                        } else if (!z && i11 == 2) {
                            iZzm = 0;
                            i3 = 23;
                        } else if (cause instanceof zztl) {
                            iZzm = zzex.zzm(((zztl) cause).zzd);
                            i3 = 13;
                        } else {
                            iZzw = 14;
                            if (cause instanceof zzth) {
                                errorCode = ((zzth) cause).zza;
                            } else if (cause instanceof OutOfMemoryError) {
                                i3 = 14;
                            } else if (cause instanceof zzqk) {
                                errorCode = ((zzqk) cause).zza;
                                iZzw = 17;
                            } else if (cause instanceof zzqn) {
                                errorCode = ((zzqn) cause).zza;
                                iZzw = 18;
                            } else if (cause instanceof MediaCodec.CryptoException) {
                                errorCode = ((MediaCodec.CryptoException) cause).getErrorCode();
                                iZzw = zzw(errorCode);
                            } else {
                                i3 = 22;
                            }
                            int i13 = iZzw;
                            iZzm = errorCode;
                            i3 = i13;
                        }
                    }
                } else if (!z) {
                    if (!z) {
                    }
                    if (cause instanceof zztl) {
                        iZzm = zzex.zzm(((zztl) cause).zzd);
                        i3 = 13;
                    } else {
                        iZzw = 14;
                        if (cause instanceof zzth) {
                            errorCode = ((zzth) cause).zza;
                        } else if (cause instanceof OutOfMemoryError) {
                            i3 = 14;
                        } else if (cause instanceof zzqk) {
                            errorCode = ((zzqk) cause).zza;
                            iZzw = 17;
                        } else if (cause instanceof zzqn) {
                            errorCode = ((zzqn) cause).zza;
                            iZzw = 18;
                        } else if (cause instanceof MediaCodec.CryptoException) {
                            errorCode = ((MediaCodec.CryptoException) cause).getErrorCode();
                            iZzw = zzw(errorCode);
                        } else {
                            i3 = 22;
                        }
                        int i14 = iZzw;
                        iZzm = errorCode;
                        i3 = i14;
                    }
                } else {
                    if (!z) {
                    }
                    if (cause instanceof zztl) {
                        iZzm = zzex.zzm(((zztl) cause).zzd);
                        i3 = 13;
                    } else {
                        iZzw = 14;
                        if (cause instanceof zzth) {
                            errorCode = ((zzth) cause).zza;
                        } else if (cause instanceof OutOfMemoryError) {
                            i3 = 14;
                        } else if (cause instanceof zzqk) {
                            errorCode = ((zzqk) cause).zza;
                            iZzw = 17;
                        } else if (cause instanceof zzqn) {
                            errorCode = ((zzqn) cause).zza;
                            iZzw = 18;
                        } else if (cause instanceof MediaCodec.CryptoException) {
                            errorCode = ((MediaCodec.CryptoException) cause).getErrorCode();
                            iZzw = zzw(errorCode);
                        } else {
                            i3 = 22;
                        }
                        int i15 = iZzw;
                        iZzm = errorCode;
                        i3 = i15;
                    }
                }
                final PlaybackErrorEvent playbackErrorEventBuild = zzpd$$ExternalSyntheticApiModelOutline4.m82m().setTimeSinceCreatedMillis(jElapsedRealtime - this.zze).setErrorCode(i3).setSubErrorCode(iZzm).setException(zzbaVar).build();
                this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzoz
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzd.reportPlaybackErrorEvent(playbackErrorEventBuild);
                    }
                });
                this.zzA = true;
                this.zzo = null;
            }
            iZzm = 0;
            final PlaybackErrorEvent playbackErrorEventBuild2 = zzpd$$ExternalSyntheticApiModelOutline4.m82m().setTimeSinceCreatedMillis(jElapsedRealtime - this.zze).setErrorCode(i3).setSubErrorCode(iZzm).setException(zzbaVar).build();
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzoz
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzd.reportPlaybackErrorEvent(playbackErrorEventBuild2);
                }
            });
            this.zzA = true;
            this.zzo = null;
        }
        if (zzmqVar.zzd(2)) {
            zzbt zzbtVarZzp = zzbhVar.zzp();
            boolean zZzb = zzbtVarZzp.zzb(2);
            boolean zZzb2 = zzbtVarZzp.zzb(1);
            boolean zZzb3 = zzbtVarZzp.zzb(3);
            if (zZzb || zZzb2) {
                if (!zZzb) {
                    zzB(jElapsedRealtime, null, 0);
                }
                if (!zZzb2) {
                    zzy(jElapsedRealtime, null, 0);
                }
                if (!zZzb3) {
                    zzz(jElapsedRealtime, null, 0);
                }
            } else if (zZzb3) {
                zZzb3 = true;
                if (!zZzb) {
                    zzB(jElapsedRealtime, null, 0);
                }
                if (!zZzb2) {
                    zzy(jElapsedRealtime, null, 0);
                }
                if (!zZzb3) {
                    zzz(jElapsedRealtime, null, 0);
                }
            }
        }
        if (zzD(this.zzp)) {
            zzz zzzVar = this.zzp.zza;
            if (zzzVar.zzw != -1) {
                zzB(jElapsedRealtime, zzzVar, 0);
                this.zzp = null;
            }
        }
        if (zzD(this.zzq)) {
            zzy(jElapsedRealtime, this.zzq.zza, 0);
            this.zzq = null;
        }
        if (zzD(this.zzr)) {
            zzz(jElapsedRealtime, this.zzr.zza, 0);
            this.zzr = null;
        }
        switch (zzel.zzb(this.zza).zza()) {
            case 0:
                i = 0;
                break;
            case 1:
                i = 9;
                break;
            case 2:
                i = 2;
                break;
            case 3:
                i = 4;
                break;
            case 4:
                i = 5;
                break;
            case 5:
                i = 6;
                break;
            case 6:
            case 8:
            default:
                i = 1;
                break;
            case 7:
                i = 3;
                break;
            case 9:
                i = 8;
                break;
            case 10:
                i = 7;
                break;
        }
        if (i != this.zzn) {
            this.zzn = i;
            final NetworkEvent networkEventBuild = zzpd$$ExternalSyntheticApiModelOutline4.m81m().setNetworkType(i).setTimeSinceCreatedMillis(jElapsedRealtime - this.zze).build();
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzoy
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzd.reportNetworkEvent(networkEventBuild);
                }
            });
        }
        if (zzbhVar.zzg() != 2) {
            this.zzv = false;
        }
        if (((zzmk) zzbhVar).zzD() == null) {
            this.zzw = false;
        } else if (zzmqVar.zzd(10)) {
            this.zzw = true;
        }
        int iZzg = zzbhVar.zzg();
        if (this.zzv) {
            i2 = 5;
        } else if (this.zzw) {
            i2 = 13;
        } else {
            i2 = 4;
            if (iZzg == 4) {
                i2 = 11;
            } else if (iZzg == 2) {
                int i16 = this.zzm;
                if (i16 == 0 || i16 == 2 || i16 == 12) {
                    i2 = 2;
                } else if (zzbhVar.zzv()) {
                    i2 = zzbhVar.zzh() != 0 ? 10 : 6;
                } else {
                    i2 = 7;
                }
            } else if (iZzg != 3) {
                i2 = (iZzg != 1 || this.zzm == 0) ? this.zzm : 12;
            } else if (zzbhVar.zzv()) {
                i2 = zzbhVar.zzh() != 0 ? 9 : 3;
            }
        }
        if (this.zzm != i2) {
            this.zzm = i2;
            this.zzA = true;
            final PlaybackStateEvent playbackStateEventBuild = zzpd$$ExternalSyntheticApiModelOutline4.m84m().setState(this.zzm).setTimeSinceCreatedMillis(jElapsedRealtime - this.zze).build();
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpb
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzd.reportPlaybackStateEvent(playbackStateEventBuild);
                }
            });
        }
        if (zzmqVar.zzd(1028)) {
            this.zzc.zzg(zzmqVar.zzc(1028));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmr
    public final void zzj(zzmp zzmpVar, zzuy zzuyVar, zzvd zzvdVar, IOException iOException, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzmr
    public final /* synthetic */ void zzk(zzmp zzmpVar, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzmr
    public final void zzl(zzmp zzmpVar, zzba zzbaVar) {
        this.zzo = zzbaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzmr
    public final void zzm(zzmp zzmpVar, zzbf zzbfVar, zzbf zzbfVar2, int i) {
        if (i == 1) {
            this.zzv = true;
            i = 1;
        }
        this.zzl = i;
    }

    @Override // com.google.android.gms.internal.ads.zzmr
    public final /* synthetic */ void zzn(zzmp zzmpVar, Object obj, long j) {
    }

    @Override // com.google.android.gms.internal.ads.zzmr
    public final void zzo(zzmp zzmpVar, zzid zzidVar) {
        this.zzx += zzidVar.zzg;
        this.zzy += zzidVar.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzmr
    public final /* synthetic */ void zzp(zzmp zzmpVar, zzz zzzVar, zzie zzieVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzmr
    public final void zzq(zzmp zzmpVar, zzcd zzcdVar) {
        zzpc zzpcVar = this.zzp;
        if (zzpcVar != null) {
            zzz zzzVar = zzpcVar.zza;
            if (zzzVar.zzw == -1) {
                zzx zzxVarZzb = zzzVar.zzb();
                zzxVarZzb.zzam(zzcdVar.zzb);
                zzxVarZzb.zzQ(zzcdVar.zzc);
                this.zzp = new zzpc(zzxVarZzb.zzan(), 0, zzpcVar.zzc);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    public final void zzu(zzmp zzmpVar, String str) {
        zzvh zzvhVar = zzmpVar.zzd;
        if (zzvhVar == null || !zzvhVar.zzb()) {
            zzx();
            this.zzj = str;
            this.zzk = zzpd$$ExternalSyntheticApiModelOutline4.m83m().setPlayerName("AndroidXMedia3").setPlayerVersion("1.8.0-alpha01");
            zzA(zzmpVar.zzb, zzvhVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    public final void zzv(zzmp zzmpVar, String str, boolean z) {
        zzvh zzvhVar = zzmpVar.zzd;
        if ((zzvhVar == null || !zzvhVar.zzb()) && str.equals(this.zzj)) {
            zzx();
        }
        this.zzh.remove(str);
        this.zzi.remove(str);
    }
}
