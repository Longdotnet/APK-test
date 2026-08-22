package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.work.impl.constraints.controllers.pST.ehgOP;
import com.facebook.GraphRequest;
import com.google.android.gms.appset.vSSa.iafHZUfOuHNwvy;
import com.google.gson.yWTz.kBfGXgdfpo;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcbf extends zzcbh implements TextureView.SurfaceTextureListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener {
    private static final Map zzc;
    private final zzccb zzd;
    private final zzccc zze;
    private final boolean zzf;
    private final zzdsj zzg;
    private int zzh;
    private int zzi;
    private MediaPlayer zzj;
    private Uri zzk;
    private int zzl;
    private int zzm;
    private int zzn;
    private zzcbz zzo;
    private final boolean zzp;
    private int zzq;
    private zzcbg zzr;
    private boolean zzs;
    private Integer zzt;

    static {
        HashMap map = new HashMap();
        zzc = map;
        map.put(-1004, "MEDIA_ERROR_IO");
        map.put(-1007, "MEDIA_ERROR_MALFORMED");
        map.put(-1010, "MEDIA_ERROR_UNSUPPORTED");
        map.put(-110, "MEDIA_ERROR_TIMED_OUT");
        map.put(3, "MEDIA_INFO_VIDEO_RENDERING_START");
        map.put(100, "MEDIA_ERROR_SERVER_DIED");
        map.put(1, "MEDIA_ERROR_UNKNOWN");
        map.put(1, "MEDIA_INFO_UNKNOWN");
        map.put(700, "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        map.put(701, "MEDIA_INFO_BUFFERING_START");
        map.put(702, "MEDIA_INFO_BUFFERING_END");
        map.put(800, "MEDIA_INFO_BAD_INTERLEAVING");
        map.put(801, "MEDIA_INFO_NOT_SEEKABLE");
        map.put(802, "MEDIA_INFO_METADATA_UPDATE");
        map.put(901, "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
        map.put(902, "MEDIA_INFO_SUBTITLE_TIMED_OUT");
    }

    public zzcbf(Context context, zzccb zzccbVar, boolean z, boolean z2, zzcca zzccaVar, zzccc zzcccVar, zzdsj zzdsjVar) {
        super(context);
        this.zzh = 0;
        this.zzi = 0;
        this.zzs = false;
        this.zzt = null;
        this.zzd = zzccbVar;
        this.zze = zzcccVar;
        this.zzp = z;
        this.zzf = z2;
        zzcccVar.zza(this);
        this.zzg = zzdsjVar;
    }

    private final void zzD() {
        zzdsj zzdsjVar;
        com.google.android.gms.ads.internal.util.zze.zza("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.zzk == null || surfaceTexture == null) {
            return;
        }
        zzE(false);
        try {
            com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
            GraphRequest.Companion companion = zzvVar.zzv;
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.zzj = mediaPlayer;
            mediaPlayer.setOnBufferingUpdateListener(this);
            this.zzj.setOnCompletionListener(this);
            this.zzj.setOnErrorListener(this);
            this.zzj.setOnInfoListener(this);
            this.zzj.setOnPreparedListener(this);
            this.zzj.setOnVideoSizeChangedListener(this);
            this.zzn = 0;
            if (this.zzp) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zznF)).booleanValue() && (zzdsjVar = this.zzg) != null) {
                    zzdsi zzdsiVarZza = zzdsjVar.zza();
                    zzdsiVarZza.zzb("action", "svp_ampv");
                    zzdsiVarZza.zzj();
                }
                zzcbz zzcbzVar = new zzcbz(getContext());
                this.zzo = zzcbzVar;
                zzcbzVar.zzd(surfaceTexture, getWidth(), getHeight());
                zzcbz zzcbzVar2 = this.zzo;
                zzcbzVar2.start();
                SurfaceTexture surfaceTextureZzb = zzcbzVar2.zzb();
                if (surfaceTextureZzb != null) {
                    surfaceTexture = surfaceTextureZzb;
                } else {
                    this.zzo.zze();
                    this.zzo = null;
                }
            }
            this.zzj.setDataSource(getContext(), this.zzk);
            GraphRequest.Companion companion2 = zzvVar.zzw;
            this.zzj.setSurface(new Surface(surfaceTexture));
            this.zzj.setAudioStreamType(3);
            this.zzj.setScreenOnWhilePlaying(true);
            this.zzj.prepareAsync();
            zzF(1);
        } catch (IOException e) {
            e = e;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to initialize MediaPlayer at ".concat(String.valueOf(this.zzk)), e);
            onError(this.zzj, 1, 0);
        } catch (IllegalArgumentException e2) {
            e = e2;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to initialize MediaPlayer at ".concat(String.valueOf(this.zzk)), e);
            onError(this.zzj, 1, 0);
        } catch (IllegalStateException e3) {
            e = e3;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to initialize MediaPlayer at ".concat(String.valueOf(this.zzk)), e);
            onError(this.zzj, 1, 0);
        }
    }

    private final void zzE(boolean z) {
        com.google.android.gms.ads.internal.util.zze.zza("AdMediaPlayerView release");
        zzcbz zzcbzVar = this.zzo;
        if (zzcbzVar != null) {
            zzcbzVar.zze();
            this.zzo = null;
        }
        MediaPlayer mediaPlayer = this.zzj;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.zzj.release();
            this.zzj = null;
            zzF(0);
            if (z) {
                this.zzi = 0;
            }
        }
    }

    private final void zzF(int i) {
        if (i == 3) {
            this.zze.zzc();
            this.zzb.zzb();
        } else if (this.zzh == 3) {
            this.zze.zze();
            this.zzb.zzc();
        }
        this.zzh = i;
    }

    private final void zzG(float f) {
        MediaPlayer mediaPlayer = this.zzj;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setVolume(f, f);
            } catch (IllegalStateException unused) {
            }
        } else {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
        }
    }

    private final boolean zzH() {
        int i;
        return (this.zzj == null || (i = this.zzh) == -1 || i == 0 || i == 1) ? false : true;
    }

    public static /* synthetic */ void zzk(zzcbf zzcbfVar, int i) {
        zzcbg zzcbgVar = zzcbfVar.zzr;
        if (zzcbgVar != null) {
            zzcbgVar.onWindowVisibilityChanged(i);
        }
    }

    public static void zzm(zzcbf zzcbfVar, MediaPlayer mediaPlayer) {
        MediaFormat format;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcc)).booleanValue() || zzcbfVar.zzd == null || mediaPlayer == null) {
            return;
        }
        try {
            MediaPlayer.TrackInfo[] trackInfo = mediaPlayer.getTrackInfo();
            if (trackInfo != null) {
                HashMap map = new HashMap();
                for (MediaPlayer.TrackInfo trackInfo2 : trackInfo) {
                    if (trackInfo2 != null) {
                        int trackType = trackInfo2.getTrackType();
                        if (trackType == 1) {
                            MediaFormat format2 = trackInfo2.getFormat();
                            if (format2 != null) {
                                if (format2.containsKey("frame-rate")) {
                                    try {
                                        map.put("frameRate", String.valueOf(format2.getFloat("frame-rate")));
                                    } catch (ClassCastException unused) {
                                        map.put("frameRate", String.valueOf(format2.getInteger("frame-rate")));
                                    }
                                }
                                if (format2.containsKey("bitrate")) {
                                    Integer numValueOf = Integer.valueOf(format2.getInteger("bitrate"));
                                    zzcbfVar.zzt = numValueOf;
                                    map.put("bitRate", String.valueOf(numValueOf));
                                }
                                if (format2.containsKey("width") && format2.containsKey("height")) {
                                    map.put("resolution", format2.getInteger("width") + "x" + format2.getInteger("height"));
                                }
                                if (format2.containsKey("mime")) {
                                    map.put("videoMime", format2.getString("mime"));
                                }
                                if (Build.VERSION.SDK_INT >= 30 && format2.containsKey("codecs-string")) {
                                    map.put("videoCodec", format2.getString("codecs-string"));
                                }
                            }
                        } else if (trackType == 2 && (format = trackInfo2.getFormat()) != null) {
                            if (format.containsKey("mime")) {
                                map.put("audioMime", format.getString("mime"));
                            }
                            if (Build.VERSION.SDK_INT >= 30 && format.containsKey("codecs-string")) {
                                map.put("audioCodec", format.getString("codecs-string"));
                            }
                        }
                    }
                }
                if (map.isEmpty()) {
                    return;
                }
                zzcbfVar.zzd.zzd("onMetadataEvent", map);
            }
        } catch (RuntimeException e) {
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "AdMediaPlayerView.reportMetadata");
        }
    }

    @Override // android.view.TextureView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        setSurfaceTextureListener(this);
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.zzn = i;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        com.google.android.gms.ads.internal.util.zze.zza("AdMediaPlayerView completion");
        zzF(5);
        this.zzi = 5;
        com.google.android.gms.ads.internal.util.zzs.zza.post(new zzcay(this));
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        Map map = zzc;
        com.google.android.gms.ads.internal.util.zze.zza("AdMediaPlayerView MediaPlayer info: " + ((String) map.get(Integer.valueOf(i))) + ":" + ((String) map.get(Integer.valueOf(i2))));
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0047  */
    /* JADX WARN: Code duplicated, block: B:26:0x0054 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:27:0x0056  */
    /* JADX WARN: Code duplicated, block: B:32:0x0064  */
    /* JADX WARN: Code duplicated, block: B:36:0x0070  */
    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int defaultSize = View.getDefaultSize(this.zzl, i);
        int defaultSize2 = View.getDefaultSize(this.zzm, i2);
        if (this.zzl > 0 && this.zzm > 0 && this.zzo == null) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            if (mode != 1073741824) {
                if (mode == 1073741824) {
                    i6 = (this.zzm * size) / this.zzl;
                    if (mode2 == Integer.MIN_VALUE || i6 <= size2) {
                        defaultSize2 = i6;
                        defaultSize = size;
                    }
                    defaultSize = size;
                    defaultSize2 = size2;
                } else {
                    if (mode2 == 1073741824) {
                        i5 = (this.zzl * size2) / this.zzm;
                        if (mode != Integer.MIN_VALUE && i5 > size) {
                            defaultSize = size;
                        }
                        defaultSize2 = size2;
                    } else {
                        i3 = this.zzl;
                        i4 = this.zzm;
                        if (mode2 == Integer.MIN_VALUE || i4 <= size2) {
                            i5 = i3;
                            size2 = i4;
                        } else {
                            i5 = (size2 * i3) / i4;
                        }
                        if (mode == Integer.MIN_VALUE && i5 > size) {
                            defaultSize2 = (i4 * size) / i3;
                            defaultSize = size;
                        }
                    }
                    defaultSize = i5;
                    defaultSize2 = size2;
                }
            } else if (mode2 == 1073741824) {
                int i7 = this.zzl;
                int i8 = i7 * size2;
                int i9 = this.zzm;
                int i10 = size * i9;
                if (i8 < i10) {
                    defaultSize = i8 / i9;
                } else {
                    if (i8 > i10) {
                        defaultSize2 = i10 / i7;
                        defaultSize = size;
                    }
                    defaultSize = size;
                }
                defaultSize2 = size2;
            } else {
                mode = 1073741824;
                if (mode == 1073741824) {
                    i6 = (this.zzm * size) / this.zzl;
                    if (mode2 == Integer.MIN_VALUE) {
                    }
                    defaultSize2 = i6;
                    defaultSize = size;
                } else {
                    if (mode2 == 1073741824) {
                        i5 = (this.zzl * size2) / this.zzm;
                        if (mode != Integer.MIN_VALUE) {
                        }
                    } else {
                        i3 = this.zzl;
                        i4 = this.zzm;
                        if (mode2 == Integer.MIN_VALUE) {
                            i5 = i3;
                            size2 = i4;
                        } else {
                            i5 = i3;
                            size2 = i4;
                        }
                        if (mode == Integer.MIN_VALUE) {
                            defaultSize2 = (i4 * size) / i3;
                            defaultSize = size;
                        }
                    }
                    defaultSize = i5;
                    defaultSize2 = size2;
                }
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
        zzcbz zzcbzVar = this.zzo;
        if (zzcbzVar != null) {
            zzcbzVar.zzc(defaultSize, defaultSize2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        com.google.android.gms.ads.internal.util.zze.zza("AdMediaPlayerView surface created");
        zzD();
        com.google.android.gms.ads.internal.util.zzs.zza.post(new zzcba(this));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        com.google.android.gms.ads.internal.util.zze.zza("AdMediaPlayerView surface destroyed");
        MediaPlayer mediaPlayer = this.zzj;
        if (mediaPlayer != null && this.zzq == 0) {
            this.zzq = mediaPlayer.getCurrentPosition();
        }
        zzcbz zzcbzVar = this.zzo;
        if (zzcbzVar != null) {
            zzcbzVar.zze();
        }
        com.google.android.gms.ads.internal.util.zzs.zza.post(new zzcbc(this));
        zzE(true);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        com.google.android.gms.ads.internal.util.zze.zza("AdMediaPlayerView surface changed");
        int i3 = this.zzi;
        boolean z = false;
        if (this.zzl == i && this.zzm == i2) {
            z = true;
        }
        if (this.zzj != null && i3 == 3 && z) {
            int i4 = this.zzq;
            if (i4 != 0) {
                zzq(i4);
            }
            zzp();
        }
        zzcbz zzcbzVar = this.zzo;
        if (zzcbzVar != null) {
            zzcbzVar.zzc(i, i2);
        }
        com.google.android.gms.ads.internal.util.zzs.zza.post(new zzcbb(this, i, i2));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zze.zzf(this);
        this.zza.zza(surfaceTexture, this.zzr);
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        com.google.android.gms.ads.internal.util.zze.zza("AdMediaPlayerView size changed: " + i + " x " + i2);
        this.zzl = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        this.zzm = videoHeight;
        if (this.zzl == 0 || videoHeight == 0) {
            return;
        }
        requestLayout();
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(final int i) {
        com.google.android.gms.ads.internal.util.zze.zza("AdMediaPlayerView window visibility changed to " + i);
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcaw
            @Override // java.lang.Runnable
            public final void run() {
                zzcbf.zzk(this.zza, i);
            }
        });
        super.onWindowVisibilityChanged(i);
    }

    @Override // android.view.View
    public final String toString() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzcbf.class.getName(), "@", Integer.toHexString(hashCode()));
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final int zza() {
        if (zzH()) {
            return this.zzj.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final int zzb() {
        if (Build.VERSION.SDK_INT < 26 || !zzH()) {
            return -1;
        }
        return this.zzj.getMetrics().getInt("android.media.mediaplayer.dropped");
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final int zzc() {
        if (zzH()) {
            return this.zzj.getDuration();
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final int zzd() {
        MediaPlayer mediaPlayer = this.zzj;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final int zze() {
        MediaPlayer mediaPlayer = this.zzj;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final long zzf() {
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final long zzg() {
        if (this.zzt != null) {
            return (zzh() * ((long) this.zzn)) / 100;
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final long zzh() {
        if (this.zzt != null) {
            return ((long) zzc()) * ((long) this.zzt.intValue());
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final String zzj() {
        return "MediaPlayer".concat(true != this.zzp ? "" : iafHZUfOuHNwvy.ujkJpRTraz);
    }

    @Override // com.google.android.gms.internal.ads.zzcbh, com.google.android.gms.internal.ads.zzcce
    public final void zzn() {
        zzG(this.zzb.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final void zzo() {
        com.google.android.gms.ads.internal.util.zze.zza("AdMediaPlayerView pause");
        if (zzH() && this.zzj.isPlaying()) {
            this.zzj.pause();
            zzF(4);
            com.google.android.gms.ads.internal.util.zzs.zza.post(new zzcbe(this));
        }
        this.zzi = 4;
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final void zzp() {
        com.google.android.gms.ads.internal.util.zze.zza("AdMediaPlayerView play");
        if (zzH()) {
            this.zzj.start();
            zzF(3);
            this.zza.zzb();
            com.google.android.gms.ads.internal.util.zzs.zza.post(new zzcbd(this));
        }
        this.zzi = 3;
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final void zzq(int i) {
        com.google.android.gms.ads.internal.util.zze.zza("AdMediaPlayerView seek " + i);
        if (!zzH()) {
            this.zzq = i;
        } else {
            this.zzj.seekTo(i);
            this.zzq = 0;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final void zzr(zzcbg zzcbgVar) {
        this.zzr = zzcbgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final void zzs(String str) {
        Uri uri = Uri.parse(str);
        zzbbo zzbboVarZza = zzbbo.zza(uri);
        if (zzbboVarZza == null || zzbboVarZza.zza != null) {
            if (zzbboVarZza != null) {
                uri = Uri.parse(zzbboVarZza.zza);
            }
            this.zzk = uri;
            this.zzq = 0;
            zzD();
            requestLayout();
            invalidate();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final void zzt() {
        com.google.android.gms.ads.internal.util.zze.zza("AdMediaPlayerView stop");
        MediaPlayer mediaPlayer = this.zzj;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.zzj.release();
            this.zzj = null;
            zzF(0);
            this.zzi = 0;
        }
        this.zze.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final void zzu(float f, float f2) {
        zzcbz zzcbzVar = this.zzo;
        if (zzcbzVar != null) {
            zzcbzVar.zzf(f, f2);
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        Map map = zzc;
        String str = (String) map.get(Integer.valueOf(i));
        String str2 = (String) map.get(Integer.valueOf(i2));
        String strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(ehgOP.JypuJgTW, str, ":", str2);
        int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzj(strM);
        zzF(-1);
        this.zzi = -1;
        com.google.android.gms.ads.internal.util.zzs.zza.post(new zzcaz(this, str, str2));
        return true;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        com.google.android.gms.ads.internal.util.zze.zza("AdMediaPlayerView prepared");
        zzF(2);
        this.zze.zzb();
        com.google.android.gms.ads.internal.util.zzs.zza.post(new zzcax(this, mediaPlayer));
        this.zzl = mediaPlayer.getVideoWidth();
        this.zzm = mediaPlayer.getVideoHeight();
        int i = this.zzq;
        if (i != 0) {
            zzq(i);
        }
        if (this.zzf && zzH() && this.zzj.getCurrentPosition() > 0 && this.zzi != 3) {
            com.google.android.gms.ads.internal.util.zze.zza("AdMediaPlayerView nudging MediaPlayer");
            zzG(0.0f);
            this.zzj.start();
            int currentPosition = this.zzj.getCurrentPosition();
            com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            while (zzH() && this.zzj.getCurrentPosition() == currentPosition) {
                com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                if (System.currentTimeMillis() - jCurrentTimeMillis > 250) {
                    break;
                }
            }
            this.zzj.pause();
            zzn();
        }
        com.google.android.gms.ads.internal.util.client.zzo.zzi("AdMediaPlayerView stream dimensions: " + this.zzl + kBfGXgdfpo.VFp + this.zzm);
        if (this.zzi == 3) {
            zzp();
        }
        zzn();
    }
}
