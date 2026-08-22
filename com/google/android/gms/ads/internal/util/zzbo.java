package com.google.android.gms.ads.internal.util;

import android.content.Context;
import androidx.room.RoomOpenHelper;
import com.google.android.gms.ads.internal.util.client.zzl;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.internal.ads.zzapl;
import com.google.android.gms.internal.ads.zzaqg;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzbde;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Dispatcher;

/* JADX INFO: loaded from: classes.dex */
public final class zzbo {
    public static zzaqg zza;
    public static final Object zzb = new Object();

    public zzbo(Context context) {
        context = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        synchronized (zzb) {
            try {
                if (zza == null) {
                    zzbde.zza(context);
                    zza = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzeJ)).booleanValue() ? zzaz.zzb(context) : zzark.zza(context, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zzbk zzb(int i, String str, HashMap map, byte[] bArr) {
        zzbk zzbkVar = new zzbk();
        RoomOpenHelper roomOpenHelper = new RoomOpenHelper(this, str, zzbkVar);
        zzl zzlVar = new zzl();
        zzbj zzbjVar = new zzbj(this, i, str, zzbkVar, roomOpenHelper, bArr, map, zzlVar);
        if (zzl.zzk()) {
            try {
                Map mapZzl = zzbjVar.zzl();
                byte[] bArr2 = bArr == null ? null : bArr;
                if (zzl.zzk()) {
                    zzlVar.zzn("onNetworkRequest", new Dispatcher(str, "GET", mapZzl, bArr2));
                }
            } catch (zzapl e) {
                String message = e.getMessage();
                int i2 = zze.$r8$clinit;
                zzo.zzj(message);
            }
        }
        zza.zza(zzbjVar);
        return zzbkVar;
    }
}
