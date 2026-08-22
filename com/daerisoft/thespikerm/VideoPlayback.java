package com.daerisoft.thespikerm;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.sqlite.db.framework.VERT.YcVWhnLsj;
import com.yoyogames.runner.RunnerJNILib;

/* JADX INFO: loaded from: classes2.dex */
public final class VideoPlayback extends RunnerSocial implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    public static AssetManager mAssetManager;
    public static Context mContext;
    public static boolean mInitialised;
    public static MediaPlayer mMediaPlayer;
    public static TextureView mTextureView;
    public boolean Looping;
    public int VideoPlayback_Status;
    public int player_status;
    public double volume;

    public static String getInfo(int i) {
        if (i == 1) {
            return YcVWhnLsj.YDBYY;
        }
        if (i == 3) {
            return "MEDIA_INFO_VIDEO_RENDERING_START";
        }
        if (i == 901) {
            return "MEDIA_INFO_UNSUPPORTED_SUBTITLE";
        }
        if (i == 902) {
            return "MEDIA_INFO_SUBTITLE_TIMED_OUT";
        }
        switch (i) {
            case 700:
                return "MEDIA_INFO_VIDEO_TRACK_LAGGING";
            case 701:
                return "MEDIA_INFO_BUFFERING_START";
            case 702:
                return "MEDIA_INFO_BUFFERING_END";
            default:
                switch (i) {
                    case 800:
                        return "MEDIA_INFO_BAD_INTERLEAVING";
                    case 801:
                        return "MEDIA_INFO_NOT_SEEKABLE";
                    case 802:
                        return "MEDIA_INFO_METADATA_UPDATE";
                    default:
                        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "UNKNOWN: ");
                }
        }
    }

    public final void VideoPlayback_Close() {
        if (mInitialised) {
            this.player_status = 0;
            this.VideoPlayback_Status = -2;
            mContext = null;
            mInitialised = false;
            mMediaPlayer.stop();
            mMediaPlayer.release();
            mTextureView = null;
            int iJCreateDsMap = RunnerJNILib.jCreateDsMap(null, null, null);
            RunnerJNILib.DsMapAddString(iJCreateDsMap, "type", "video_end");
            RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 70);
        }
    }

    public final void VideoPlayback_Resume() {
        if (mInitialised) {
            try {
                mMediaPlayer.start();
                this.player_status = 2;
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        VideoPlayback_Close();
        int iJCreateDsMap = RunnerJNILib.jCreateDsMap(null, null, null);
        RunnerJNILib.DsMapAddString(iJCreateDsMap, "type", "video_end");
        RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 70);
        this.VideoPlayback_Status = -2;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.VideoPlayback_Status = -1;
        Log.i(GooglePlayBillingService.TAG, "VideoPlayback onError: " + getInfo(i) + " Extra: " + i2);
        return false;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        Log.i(GooglePlayBillingService.TAG, "VideoPlayback: onInfo: " + getInfo(i) + " Extra: " + i2);
        return false;
    }

    @Override // com.daerisoft.thespikerm.RunnerSocial
    public final void onPause() {
        if (mInitialised) {
            try {
                mMediaPlayer.pause();
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        mMediaPlayer.start();
        this.VideoPlayback_Status = 0;
        this.player_status = 2;
        mInitialised = true;
        if (this.Looping) {
            try {
                this.Looping = true;
                mMediaPlayer.setLooping(true);
            } catch (Exception unused) {
            }
        }
        double d = this.volume;
        this.volume = d;
        if (mInitialised) {
            float f = (float) d;
            mMediaPlayer.setVolume(f, f);
        }
        int iJCreateDsMap = RunnerJNILib.jCreateDsMap(null, null, null);
        RunnerJNILib.DsMapAddString(iJCreateDsMap, "type", "video_start");
        RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 70);
    }

    @Override // com.daerisoft.thespikerm.RunnerSocial
    public final void onResume() {
        if (mInitialised && this.player_status == 2) {
            VideoPlayback_Resume();
        }
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public final void onSeekComplete(MediaPlayer mediaPlayer) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        mMediaPlayer.setSurface(new Surface(surfaceTexture));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        Log.i(GooglePlayBillingService.TAG, "VideoPlayback onSurfaceTextureSizeChanged with width " + i + " height " + i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        Log.d(GooglePlayBillingService.TAG, "VideoPlayback: onVideoSizeChanged: " + i + "," + i2);
    }
}
