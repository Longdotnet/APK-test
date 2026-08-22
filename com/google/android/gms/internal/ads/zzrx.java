package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class zzrx extends zzco {
    private static final int zzd = Float.floatToIntBits(Float.NaN);

    private static void zzo(int i, ByteBuffer byteBuffer) {
        int iFloatToIntBits = Float.floatToIntBits((float) (((double) i) * 4.656612875245797E-10d));
        if (iFloatToIntBits == zzd) {
            iFloatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(iFloatToIntBits);
    }

    @Override // com.google.android.gms.internal.ads.zzcn
    public final void zze(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferZzj;
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i = iLimit - iPosition;
        int i2 = this.zzb.zzd;
        if (i2 == 21) {
            byteBufferZzj = zzj((i / 3) * 4);
            while (iPosition < iLimit) {
                zzo(((byteBuffer.get(iPosition) & 255) << 8) | ((byteBuffer.get(iPosition + 1) & 255) << 16) | ((byteBuffer.get(iPosition + 2) & 255) << 24), byteBufferZzj);
                iPosition += 3;
            }
        } else if (i2 == 22) {
            byteBufferZzj = zzj(i);
            while (iPosition < iLimit) {
                int i3 = byteBuffer.get(iPosition) & 255;
                int i4 = (byteBuffer.get(iPosition + 1) & 255) << 8;
                zzo(i3 | i4 | ((byteBuffer.get(iPosition + 2) & 255) << 16) | ((byteBuffer.get(iPosition + 3) & 255) << 24), byteBufferZzj);
                iPosition += 4;
            }
        } else if (i2 == 1342177280) {
            byteBufferZzj = zzj((i / 3) * 4);
            while (iPosition < iLimit) {
                zzo(((byteBuffer.get(iPosition + 2) & 255) << 8) | ((byteBuffer.get(iPosition + 1) & 255) << 16) | ((byteBuffer.get(iPosition) & 255) << 24), byteBufferZzj);
                iPosition += 3;
            }
        } else {
            if (i2 != 1610612736) {
                throw new IllegalStateException();
            }
            byteBufferZzj = zzj(i);
            while (iPosition < iLimit) {
                int i5 = byteBuffer.get(iPosition + 3) & 255;
                int i6 = (byteBuffer.get(iPosition + 2) & 255) << 8;
                zzo(i5 | i6 | ((byteBuffer.get(iPosition + 1) & 255) << 16) | ((byteBuffer.get(iPosition) & 255) << 24), byteBufferZzj);
                iPosition += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        byteBufferZzj.flip();
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final zzcl zzi(zzcl zzclVar) throws zzcm {
        int i = zzclVar.zzd;
        String str = zzex.zza;
        if (i == 21 || i == 1342177280 || i == 22 || i == 1610612736) {
            return new zzcl(zzclVar.zzb, zzclVar.zzc, 4);
        }
        if (i == 4) {
            return zzcl.zza;
        }
        throw new zzcm("Unhandled input format:", zzclVar);
    }
}
