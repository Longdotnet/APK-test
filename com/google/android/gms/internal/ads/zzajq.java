package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzajq {
    public final boolean zza;
    public final String zzb;
    public final zzafa zzc;
    public final int zzd;
    public final byte[] zze;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:27:0x0051  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public zzajq(boolean z, String str, int i, byte[] bArr, int i2, int i3, byte[] bArr2) {
        byte b = 0;
        int i4 = 1;
        zzdd.zzd((i == 0) ^ (bArr2 == null));
        this.zza = z;
        this.zzb = str;
        this.zzd = i;
        this.zze = bArr2;
        if (str != null) {
            switch (str.hashCode()) {
                case 3046605:
                    if (!str.equals("cbc1")) {
                        b = -1;
                    } else {
                        b = 2;
                    }
                    break;
                case 3046671:
                    if (!str.equals("cbcs")) {
                        b = -1;
                    } else {
                        b = 3;
                    }
                    break;
                case 3049879:
                    if (!str.equals("cenc")) {
                        b = -1;
                    }
                    break;
                case 3049895:
                    if (!str.equals("cens")) {
                        b = -1;
                    } else {
                        b = 1;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            if (b != 0 && b != 1) {
                if (b == 2 || b == 3) {
                    i4 = 2;
                } else {
                    zzea.zzf("TrackEncryptionBox", "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.");
                }
            }
        }
        this.zzc = new zzafa(i4, bArr, i2, i3);
    }
}
