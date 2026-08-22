package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.login.vu.dLDI;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcdc implements zzbkf {
    @Override // com.google.android.gms.internal.ads.zzbkf
    public final void zza(Object obj, Map map) {
        String str = dLDI.TdsvKYtXBhbi;
        zzccb zzccbVar = (zzccb) obj;
        zzcgi zzcgiVarZzq = zzccbVar.zzq();
        if (zzcgiVarZzq == null) {
            try {
                zzcgi zzcgiVar = new zzcgi(zzccbVar, Float.parseFloat((String) map.get("duration")), "1".equals(map.get("customControlsAllowed")), "1".equals(map.get("clickToExpandAllowed")));
                zzccbVar.zzC(zzcgiVar);
                zzcgiVarZzq = zzcgiVar;
            } catch (NullPointerException e) {
                e = e;
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to parse videoMeta message.", e);
                com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "VideoMetaGmsgHandler.onGmsg");
                return;
            } catch (NumberFormatException e2) {
                e = e2;
                int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to parse videoMeta message.", e);
                com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "VideoMetaGmsgHandler.onGmsg");
                return;
            }
        }
        float f = Float.parseFloat((String) map.get("duration"));
        boolean zEquals = "1".equals(map.get("muted"));
        float f2 = Float.parseFloat((String) map.get("currentTime"));
        int i3 = Integer.parseInt((String) map.get("playbackState"));
        if (i3 < 0 || i3 > 3) {
            i3 = 0;
        }
        String str2 = (String) map.get("aspectRatio");
        float f3 = TextUtils.isEmpty(str2) ? 0.0f : Float.parseFloat(str2);
        if (com.google.android.gms.ads.internal.util.client.zzo.zzm(3)) {
            com.google.android.gms.ads.internal.util.client.zzo.zze(str + f2 + " , duration : " + f + " , isMuted : " + zEquals + " , playbackState : " + i3 + " , aspectRatio : " + str2);
        }
        zzcgiVarZzq.zzr(f2, f, i3, zEquals, f3);
    }
}
