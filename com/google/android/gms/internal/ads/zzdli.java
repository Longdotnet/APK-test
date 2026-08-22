package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Looper;
import android.os.SystemClock;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzdli {
    private final com.google.android.gms.ads.internal.util.zzbo zza;
    private final Clock zzb;
    private final Executor zzc;

    public zzdli(com.google.android.gms.ads.internal.util.zzbo zzboVar, Clock clock, Executor executor) {
        this.zza = zzboVar;
        this.zzb = clock;
        this.zzc = executor;
    }

    public static Bitmap zza(zzdli zzdliVar, double d, boolean z, zzapz zzapzVar) {
        byte[] bArr = zzapzVar.zzb;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = (int) (d * 160.0d);
        if (!z) {
            options.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        zzbcv zzbcvVar = zzbde.zzgs;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            options.inJustDecodeBounds = true;
            zzdliVar.zzc(bArr, options);
            options.inJustDecodeBounds = false;
            int i = options.outWidth * options.outHeight;
            if (i > 0) {
                options.inSampleSize = 1 << ((33 - Integer.numberOfLeadingZeros((i - 1) / ((Integer) zzbdVar.zzd.zzb(zzbde.zzgt)).intValue())) / 2);
            }
        }
        return zzdliVar.zzc(bArr, options);
    }

    private final Bitmap zzc(byte[] bArr, BitmapFactory.Options options) {
        ((DefaultClock) this.zzb).getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        if (bitmapDecodeByteArray != null) {
            long j = jElapsedRealtime2 - jElapsedRealtime;
            int width = bitmapDecodeByteArray.getWidth();
            int height = bitmapDecodeByteArray.getHeight();
            int allocationByteCount = bitmapDecodeByteArray.getAllocationByteCount();
            boolean z = Looper.getMainLooper().getThread() == Thread.currentThread();
            StringBuilder sbM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m("Decoded image w: ", width, " h:", height, " bytes: ");
            sbM.append(allocationByteCount);
            sbM.append(" time: ");
            sbM.append(j);
            sbM.append(" on ui thread: ");
            sbM.append(z);
            com.google.android.gms.ads.internal.util.zze.zza(sbM.toString());
        }
        return bitmapDecodeByteArray;
    }

    public final ListenableFuture zzb(String str, final double d, final boolean z) {
        this.zza.getClass();
        zzcak zzcakVar = new zzcak();
        com.google.android.gms.ads.internal.util.zzbo.zza.zza(new com.google.android.gms.ads.internal.util.zzbm(str, zzcakVar));
        return zzgdn.zzm(zzcakVar, new zzfve() { // from class: com.google.android.gms.internal.ads.zzdlh
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                return zzdli.zza(this.zza, d, z, (zzapz) obj);
            }
        }, this.zzc);
    }
}
