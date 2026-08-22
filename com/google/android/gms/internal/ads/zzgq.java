package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class zzgq implements zzgj {
    private final Context zza;
    private final List zzb = new ArrayList();
    private final zzgj zzc;
    private zzgj zzd;
    private zzgj zze;
    private zzgj zzf;
    private zzgj zzg;
    private zzgj zzh;
    private zzgj zzi;
    private zzgj zzj;
    private zzgj zzk;

    public zzgq(Context context, zzgj zzgjVar) {
        this.zza = context.getApplicationContext();
        this.zzc = zzgjVar;
    }

    private final zzgj zzg() {
        if (this.zze == null) {
            zzgb zzgbVar = new zzgb(this.zza);
            this.zze = zzgbVar;
            zzh(zzgbVar);
        }
        return this.zze;
    }

    private final void zzh(zzgj zzgjVar) {
        int i = 0;
        while (true) {
            List list = this.zzb;
            if (i >= list.size()) {
                return;
            }
            zzgjVar.zzf((zzhj) list.get(i));
            i++;
        }
    }

    private static final void zzi(zzgj zzgjVar, zzhj zzhjVar) {
        if (zzgjVar != null) {
            zzgjVar.zzf(zzhjVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzl
    public final int zza(byte[] bArr, int i, int i2) {
        zzgj zzgjVar = this.zzk;
        zzgjVar.getClass();
        return zzgjVar.zza(bArr, i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final Uri zzc() {
        zzgj zzgjVar = this.zzk;
        if (zzgjVar == null) {
            return null;
        }
        return zzgjVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final void zzd() {
        zzgj zzgjVar = this.zzk;
        if (zzgjVar != null) {
            try {
                zzgjVar.zzd();
            } finally {
                this.zzk = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final Map zze() {
        zzgj zzgjVar = this.zzk;
        return zzgjVar == null ? Collections.emptyMap() : zzgjVar.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final void zzf(zzhj zzhjVar) {
        zzhjVar.getClass();
        this.zzc.zzf(zzhjVar);
        this.zzb.add(zzhjVar);
        zzi(this.zzd, zzhjVar);
        zzi(this.zze, zzhjVar);
        zzi(this.zzf, zzhjVar);
        zzi(this.zzg, zzhjVar);
        zzi(this.zzh, zzhjVar);
        zzi(this.zzi, zzhjVar);
        zzi(this.zzj, zzhjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final long zzb(zzgo zzgoVar) {
        zzgj zzgjVar;
        zzdd.zzf(this.zzk == null);
        Uri uri = zzgoVar.zza;
        String scheme = uri.getScheme();
        String str = zzex.zza;
        String scheme2 = uri.getScheme();
        if (TextUtils.isEmpty(scheme2) || Objects.equals(scheme2, "file")) {
            String path = uri.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                if (this.zzd == null) {
                    zzgy zzgyVar = new zzgy();
                    this.zzd = zzgyVar;
                    zzh(zzgyVar);
                }
                this.zzk = this.zzd;
            } else {
                this.zzk = zzg();
            }
        } else if ("asset".equals(scheme)) {
            this.zzk = zzg();
        } else if (FirebaseAnalytics.Param.CONTENT.equals(scheme)) {
            if (this.zzf == null) {
                zzgg zzggVar = new zzgg(this.zza);
                this.zzf = zzggVar;
                zzh(zzggVar);
            }
            this.zzk = this.zzf;
        } else if ("rtmp".equals(scheme)) {
            if (this.zzg == null) {
                try {
                    zzgj zzgjVar2 = (zzgj) Class.forName("androidx.media3.datasource.rtmp.RtmpDataSource").getConstructor(null).newInstance(null);
                    this.zzg = zzgjVar2;
                    zzh(zzgjVar2);
                } catch (ClassNotFoundException unused) {
                    zzea.zzf("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
                } catch (Exception e) {
                    throw new RuntimeException("Error instantiating RTMP extension", e);
                }
                if (this.zzg == null) {
                    this.zzg = this.zzc;
                }
            }
            this.zzk = this.zzg;
        } else if ("udp".equals(scheme)) {
            if (this.zzh == null) {
                zzhl zzhlVar = new zzhl(2000);
                this.zzh = zzhlVar;
                zzh(zzhlVar);
            }
            this.zzk = this.zzh;
        } else if (eoBKjVuj.FABhHCgAlTLJ.equals(scheme)) {
            if (this.zzi == null) {
                zzgh zzghVar = new zzgh();
                this.zzi = zzghVar;
                zzh(zzghVar);
            }
            this.zzk = this.zzi;
        } else {
            if ("rawresource".equals(scheme) || "android.resource".equals(scheme)) {
                if (this.zzj == null) {
                    zzhh zzhhVar = new zzhh(this.zza);
                    this.zzj = zzhhVar;
                    zzh(zzhhVar);
                }
                zzgjVar = this.zzj;
            } else {
                zzgjVar = this.zzc;
            }
            this.zzk = zzgjVar;
        }
        return this.zzk.zzb(zzgoVar);
    }
}
