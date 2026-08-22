package com.google.android.gms.internal.ads;

import androidx.sqlite.db.framework.VERT.YcVWhnLsj;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcca {
    public final boolean zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final boolean zzi;
    public final boolean zzj;
    public final boolean zzk;
    public final boolean zzl;
    public final long zzm;
    public final long zzn;

    private static final boolean zza(JSONObject jSONObject, String str, zzbcv zzbcvVar) {
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbcvVar)).booleanValue();
        if (jSONObject == null) {
            return zBooleanValue;
        }
        try {
            return jSONObject.getBoolean(str);
        } catch (JSONException unused) {
            return zBooleanValue;
        }
    }

    private static final int zzb(JSONObject jSONObject, String str, zzbcv zzbcvVar) {
        if (jSONObject != null) {
            try {
                return jSONObject.getInt(str);
            } catch (JSONException unused) {
            }
        }
        return ((Integer) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbcvVar)).intValue();
    }

    private static final long zzc(JSONObject jSONObject, String str, zzbcv zzbcvVar) {
        if (jSONObject != null) {
            try {
                return jSONObject.getLong(str);
            } catch (JSONException unused) {
            }
        }
        return ((Long) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbcvVar)).longValue();
    }

    public zzcca(String str) {
        JSONObject jSONObject = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
            }
        }
        this.zza = zza(jSONObject, "aggressive_media_codec_release", zzbde.zzaa);
        this.zzb = zzb(jSONObject, "byte_buffer_precache_limit", zzbde.zzk);
        this.zzc = zzb(jSONObject, "exo_cache_buffer_size", zzbde.zzu);
        this.zzd = zzb(jSONObject, "exo_connect_timeout_millis", zzbde.zzg);
        zzbcv zzbcvVar = zzbde.zzf;
        if (jSONObject != null) {
            try {
                jSONObject.getString("exo_player_version");
            } catch (JSONException unused2) {
            }
        }
        this.zze = zzb(jSONObject, "exo_read_timeout_millis", zzbde.zzh);
        this.zzf = zzb(jSONObject, "load_check_interval_bytes", zzbde.zzi);
        this.zzg = zzb(jSONObject, YcVWhnLsj.DqTqIPUM, zzbde.zzj);
        this.zzh = zzb(jSONObject, "socket_receive_buffer_size", zzbde.zzl);
        this.zzi = zza(jSONObject, "use_cache_data_source", zzbde.zzeC);
        zzb(jSONObject, "min_retry_count", zzbde.zzm);
        this.zzj = zza(jSONObject, "treat_load_exception_as_non_fatal", zzbde.zzo);
        this.zzk = zza(jSONObject, "enable_multiple_video_playback", zzbde.zzcd);
        this.zzl = zza(jSONObject, "use_range_http_data_source", zzbde.zzcf);
        this.zzm = zzc(jSONObject, "range_http_data_source_high_water_mark", zzbde.zzcg);
        this.zzn = zzc(jSONObject, "range_http_data_source_low_water_mark", zzbde.zzch);
    }
}
