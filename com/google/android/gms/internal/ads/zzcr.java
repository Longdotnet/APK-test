package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class zzcr extends zzco {
    /* JADX WARN: Code duplicated, block: B:15:0x0032  */
    @Override // com.google.android.gms.internal.ads.zzcn
    public final void zze(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i = iLimit - iPosition;
        int i2 = this.zzb.zzd;
        if (i2 == 3) {
            i += i;
        } else if (i2 == 4) {
            i /= 2;
        } else {
            if (i2 != 21) {
                if (i2 == 22) {
                    i /= 2;
                } else if (i2 != 268435456) {
                    if (i2 != 1342177280) {
                        if (i2 != 1610612736) {
                            throw new IllegalStateException();
                        }
                        i /= 2;
                    }
                }
            }
            i /= 3;
            i += i;
        }
        ByteBuffer byteBufferZzj = zzj(i);
        int i3 = this.zzb.zzd;
        if (i3 == 3) {
            while (iPosition < iLimit) {
                byteBufferZzj.put((byte) 0);
                byteBufferZzj.put((byte) ((byteBuffer.get(iPosition) & 255) - 128));
                iPosition++;
            }
        } else if (i3 == 4) {
            while (iPosition < iLimit) {
                float f = byteBuffer.getFloat(iPosition);
                String str = zzex.zza;
                short sMax = (short) (Math.max(-1.0f, Math.min(f, 1.0f)) * 32767.0f);
                byteBufferZzj.put((byte) (sMax & 255));
                byteBufferZzj.put((byte) ((sMax >> 8) & 255));
                iPosition += 4;
            }
        } else if (i3 == 21) {
            while (iPosition < iLimit) {
                byteBufferZzj.put(byteBuffer.get(iPosition + 1));
                byteBufferZzj.put(byteBuffer.get(iPosition + 2));
                iPosition += 3;
            }
        } else if (i3 == 22) {
            while (iPosition < iLimit) {
                byteBufferZzj.put(byteBuffer.get(iPosition + 2));
                byteBufferZzj.put(byteBuffer.get(iPosition + 3));
                iPosition += 4;
            }
        } else if (i3 == 268435456) {
            while (iPosition < iLimit) {
                byteBufferZzj.put(byteBuffer.get(iPosition + 1));
                byteBufferZzj.put(byteBuffer.get(iPosition));
                iPosition += 2;
            }
        } else if (i3 == 1342177280) {
            while (iPosition < iLimit) {
                byteBufferZzj.put(byteBuffer.get(iPosition + 1));
                byteBufferZzj.put(byteBuffer.get(iPosition));
                iPosition += 3;
            }
        } else {
            if (i3 != 1610612736) {
                throw new IllegalStateException();
            }
            while (iPosition < iLimit) {
                byteBufferZzj.put(byteBuffer.get(iPosition + 1));
                byteBufferZzj.put(byteBuffer.get(iPosition));
                iPosition += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        byteBufferZzj.flip();
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final zzcl zzi(zzcl zzclVar) throws zzcm {
        int i = zzclVar.zzd;
        if (i != 3) {
            if (i == 2) {
                return zzcl.zza;
            }
            if (i != 268435456 && i != 21 && i != 1342177280 && i != 22 && i != 1610612736 && i != 4) {
                throw new zzcm("Unhandled input format:", zzclVar);
            }
        }
        return new zzcl(zzclVar.zzb, zzclVar.zzc, 2);
    }
}
