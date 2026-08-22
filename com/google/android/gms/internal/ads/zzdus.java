package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.util.Base64;
import androidx.work.impl.WorkDatabase;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.ByteArrayOutputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzdus {
    private final Context zza;
    private final ApplicationInfo zzb;
    private final int zzc;
    private final int zzd;
    private String zze = "";

    public zzdus(Context context) {
        this.zza = context;
        this.zzb = context.getApplicationInfo();
        zzbcv zzbcvVar = zzbde.zzjC;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        this.zzc = ((Integer) zzbdVar.zzd.zzb(zzbcvVar)).intValue();
        this.zzd = ((Integer) zzbdVar.zzd.zzb(zzbde.zzjD)).intValue();
    }

    public final JSONObject zza() {
        String strZzq;
        String strEncodeToString;
        JSONObject jSONObject = new JSONObject();
        try {
            Context context = this.zza;
            String str = this.zzb.packageName;
            com.google.android.gms.ads.internal.util.zzf zzfVar = com.google.android.gms.ads.internal.util.zzs.zza;
            jSONObject.put("name", Wrappers.packageManager(context).getApplicationLabel(str));
        } catch (PackageManager.NameNotFoundException unused) {
        }
        jSONObject.put("packageName", this.zzb.packageName);
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
        Drawable applicationIcon = null;
        try {
            strZzq = com.google.android.gms.ads.internal.util.zzs.zzq(this.zza);
        } catch (RemoteException unused2) {
            strZzq = null;
        }
        jSONObject.put("adMobAppId", strZzq);
        if (this.zze.isEmpty()) {
            try {
                WorkDatabase.AnonymousClass1 anonymousClass1PackageManager = Wrappers.packageManager(this.zza);
                String str2 = this.zzb.packageName;
                Context context2 = anonymousClass1PackageManager.val$context;
                ApplicationInfo applicationInfo = context2.getPackageManager().getApplicationInfo(str2, 0);
                context2.getPackageManager().getApplicationLabel(applicationInfo);
                applicationIcon = context2.getPackageManager().getApplicationIcon(applicationInfo);
            } catch (PackageManager.NameNotFoundException unused3) {
            }
            if (applicationIcon == null) {
                strEncodeToString = "";
            } else {
                int i = this.zzc;
                int i2 = this.zzd;
                applicationIcon.setBounds(0, 0, i, i2);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                applicationIcon.draw(new Canvas(bitmapCreateBitmap));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
            }
            this.zze = strEncodeToString;
        }
        if (!this.zze.isEmpty()) {
            jSONObject.put("icon", this.zze);
            jSONObject.put("iconWidthPx", this.zzc);
            jSONObject.put("iconHeightPx", this.zzd);
        }
        return jSONObject;
    }
}
