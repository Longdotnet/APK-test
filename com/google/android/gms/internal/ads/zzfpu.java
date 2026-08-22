package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Hex;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzfpu {
    private final zzays zza;
    private final File zzb;
    private final File zzc;
    private final File zzd;
    private byte[] zze;

    public zzfpu(zzays zzaysVar, File file, File file2, File file3) {
        this.zza = zzaysVar;
        this.zzb = file;
        this.zzc = file3;
        this.zzd = file2;
    }

    public final zzays zza() {
        return this.zza;
    }

    public final File zzb() {
        return this.zzc;
    }

    public final File zzc() {
        return this.zzb;
    }

    public final boolean zzd(long j) {
        return this.zza.zzb() - (System.currentTimeMillis() / 1000) < 3600;
    }

    public final byte[] zze() throws Throwable {
        FileInputStream fileInputStream;
        byte[] bArrZzA;
        FileInputStream fileInputStream2 = null;
        if (this.zze == null) {
            try {
                fileInputStream = new FileInputStream(this.zzd);
                try {
                    zzgxz zzgxzVar = zzgxz.zzb;
                    ArrayList arrayList = new ArrayList();
                    int iMin = 256;
                    while (true) {
                        byte[] bArr = new byte[iMin];
                        int i = 0;
                        while (i < iMin) {
                            int i2 = fileInputStream.read(bArr, i, iMin - i);
                            if (i2 == -1) {
                                break;
                            }
                            i += i2;
                        }
                        zzgxz zzgxzVarZzv = i == 0 ? null : zzgxz.zzv(bArr, 0, i);
                        if (zzgxzVarZzv == null) {
                            break;
                        }
                        arrayList.add(zzgxzVarZzv);
                        iMin = Math.min(iMin + iMin, 8192);
                    }
                    bArrZzA = zzgxz.zzu(arrayList).zzA();
                    Hex.closeQuietly(fileInputStream);
                } catch (IOException unused) {
                    Hex.closeQuietly(fileInputStream);
                    bArrZzA = null;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    Hex.closeQuietly(fileInputStream2);
                    throw th;
                }
            } catch (IOException unused2) {
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
            this.zze = bArrZzA;
        }
        byte[] bArr2 = this.zze;
        if (bArr2 == null) {
            return null;
        }
        return Arrays.copyOf(bArr2, bArr2.length);
    }
}
