package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.facebook.AccessTokenCache;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.internal.util.client.zzl;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.ads.zza;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzc extends zzb {
    public final /* synthetic */ int $r8$classId = 0;
    public final Object zza;

    public zzc(Context context) {
        this.zza = context;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0080  */
    @Override // com.google.android.gms.ads.internal.util.zzb
    public final void zza() {
        BitmapDrawable bitmapDrawable;
        boolean isAdIdFakeForDebugLogging = false;
        switch (this.$r8$classId) {
            case 0:
                try {
                    isAdIdFakeForDebugLogging = AdvertisingIdClient.getIsAdIdFakeForDebugLogging((Context) this.zza);
                    break;
                } catch (GooglePlayServicesNotAvailableException | IOException | IllegalStateException e) {
                    int i = zze.$r8$clinit;
                    zzo.zzh("Fail to get isAdIdFakeForDebugLogging", e);
                }
                synchronized (zzl.zzb) {
                    zzl.zzc = true;
                    zzl.zzd = isAdIdFakeForDebugLogging;
                    break;
                }
                int i2 = zze.$r8$clinit;
                zzo.zzj("Update ad debug logging enablement as " + isAdIdFakeForDebugLogging);
                return;
            default:
                AccessTokenCache accessTokenCache = com.google.android.gms.ads.internal.zzv.zza.zzy;
                com.google.android.gms.ads.internal.overlay.zzm zzmVar = (com.google.android.gms.ads.internal.overlay.zzm) this.zza;
                Bitmap bitmap = (Bitmap) ((ConcurrentHashMap) accessTokenCache.sharedPreferences).get(Integer.valueOf(zzmVar.zzc.zzo.zzf));
                if (bitmap != null) {
                    com.google.android.gms.ads.internal.zzl zzlVar = zzmVar.zzc.zzo;
                    boolean z = zzlVar.zzd;
                    Activity activity = zzmVar.zzb;
                    if (z) {
                        float f = zzlVar.zze;
                        if (f <= 0.0f || f > 25.0f) {
                            bitmapDrawable = new BitmapDrawable(activity.getResources(), bitmap);
                        } else {
                            try {
                                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), false);
                                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateScaledBitmap);
                                RenderScript renderScriptCreate = RenderScript.create(activity);
                                ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
                                Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateScaledBitmap);
                                Allocation allocationCreateFromBitmap2 = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateBitmap);
                                scriptIntrinsicBlurCreate.setRadius(f);
                                scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
                                scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap2);
                                allocationCreateFromBitmap2.copyTo(bitmapCreateBitmap);
                                bitmapDrawable = new BitmapDrawable(activity.getResources(), bitmapCreateBitmap);
                            } catch (RuntimeException unused) {
                                bitmapDrawable = new BitmapDrawable(activity.getResources(), bitmap);
                            }
                        }
                        break;
                    } else {
                        bitmapDrawable = new BitmapDrawable(activity.getResources(), bitmap);
                    }
                    zzs.zza.post(new zza(this, bitmapDrawable, 20));
                    return;
                }
                return;
        }
    }

    public /* synthetic */ zzc(com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        Objects.requireNonNull(zzmVar);
        this.zza = zzmVar;
    }
}
