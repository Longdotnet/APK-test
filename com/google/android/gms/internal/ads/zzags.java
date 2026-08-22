package com.google.android.gms.internal.ads;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzags {
    private final ByteArrayOutputStream zza;
    private final DataOutputStream zzb;

    public zzags() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.zza = byteArrayOutputStream;
        this.zzb = new DataOutputStream(byteArrayOutputStream);
    }

    private static void zzb(DataOutputStream dataOutputStream, String str) throws IOException {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    public final byte[] zza(zzagr zzagrVar) {
        ByteArrayOutputStream byteArrayOutputStream = this.zza;
        byteArrayOutputStream.reset();
        try {
            DataOutputStream dataOutputStream = this.zzb;
            zzb(dataOutputStream, zzagrVar.zza);
            zzb(dataOutputStream, zzagrVar.zzb);
            dataOutputStream.writeLong(zzagrVar.zzc);
            dataOutputStream.writeLong(zzagrVar.zzd);
            dataOutputStream.write(zzagrVar.zze);
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
