package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class zzgnz {
    public static final zzgxe zza = zzgxe.zzb(new byte[0]);

    public static final zzgxe zza(int i) {
        return zzgxe.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(i).array());
    }

    public static final zzgxe zzb(int i) {
        return zzgxe.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(i).array());
    }
}
