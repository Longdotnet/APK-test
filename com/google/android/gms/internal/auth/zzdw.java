package com.google.android.gms.internal.auth;

import com.google.android.gms.measurement.internal.RVw.ZRqOdXiy;

/* JADX INFO: loaded from: classes2.dex */
final class zzdw extends zzdz {
    private final int zzc;

    public zzdw(byte[] bArr, int i, int i2) {
        super(bArr);
        zzeb.zzi(0, i2, bArr.length);
        this.zzc = i2;
    }

    @Override // com.google.android.gms.internal.auth.zzdz, com.google.android.gms.internal.auth.zzeb
    public final byte zzb(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.auth.zzdz
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.auth.zzdz, com.google.android.gms.internal.auth.zzeb
    public final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.auth.zzdz, com.google.android.gms.internal.auth.zzeb
    public final byte zza(int i) {
        int i2 = this.zzc;
        if (((i2 - (i + 1)) | i) >= 0) {
            return this.zza[i];
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append(ZRqOdXiy.zEXzmyaxcFJabq);
            sb.append(i);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(i2);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }
}
