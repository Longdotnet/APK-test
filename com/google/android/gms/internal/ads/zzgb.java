package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class zzgb extends zzgc {
    private final AssetManager zza;
    private Uri zzb;
    private InputStream zzc;
    private long zzd;
    private boolean zze;

    public zzgb(Context context) {
        super(false);
        this.zza = context.getAssets();
    }

    @Override // com.google.android.gms.internal.ads.zzl
    public final int zza(byte[] bArr, int i, int i2) throws zzga {
        if (i2 == 0) {
            return 0;
        }
        long j = this.zzd;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new zzga(e, 2000);
            }
        }
        InputStream inputStream = this.zzc;
        String str = zzex.zza;
        int i3 = inputStream.read(bArr, i, i2);
        if (i3 == -1) {
            return -1;
        }
        long j2 = this.zzd;
        if (j2 != -1) {
            this.zzd = j2 - ((long) i3);
        }
        zzg(i3);
        return i3;
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final long zzb(zzgo zzgoVar) throws zzga {
        try {
            Uri uri = zzgoVar.zza;
            this.zzb = uri;
            String path = uri.getPath();
            if (path == null) {
                throw null;
            }
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            zzi(zzgoVar);
            InputStream inputStreamOpen = this.zza.open(path, 1);
            this.zzc = inputStreamOpen;
            long j = zzgoVar.zze;
            if (inputStreamOpen.skip(j) < j) {
                throw new zzga(null, 2008);
            }
            long j2 = zzgoVar.zzf;
            if (j2 != -1) {
                this.zzd = j2;
            } else {
                long jAvailable = this.zzc.available();
                this.zzd = jAvailable;
                if (jAvailable == 2147483647L) {
                    this.zzd = -1L;
                }
            }
            this.zze = true;
            zzj(zzgoVar);
            return this.zzd;
        } catch (zzga e) {
            throw e;
        } catch (IOException e2) {
            throw new zzga(e2, true != (e2 instanceof FileNotFoundException) ? 2000 : 2005);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final Uri zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final void zzd() {
        this.zzb = null;
        try {
            try {
                InputStream inputStream = this.zzc;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.zzc = null;
                if (this.zze) {
                    this.zze = false;
                    zzh();
                }
            } catch (IOException e) {
                throw new zzga(e, 2000);
            }
        } catch (Throwable th) {
            this.zzc = null;
            if (this.zze) {
                this.zze = false;
                zzh();
            }
            throw th;
        }
    }
}
