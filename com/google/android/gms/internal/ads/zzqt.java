package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzqt extends zzco {
    private int[] zzd;
    private int[] zze;

    /* JADX WARN: Code duplicated, block: B:26:0x006a  */
    /* JADX WARN: Code duplicated, block: B:28:0x0072  */
    /* JADX WARN: Code duplicated, block: B:29:0x0074  */
    /* JADX WARN: Code duplicated, block: B:32:0x0086  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:42:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:45:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:47:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:50:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:52:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:56:0x0109  */
    @Override // com.google.android.gms.internal.ads.zzcn
    public final void zze(ByteBuffer byteBuffer) {
        ByteOrder byteOrderOrder;
        ByteOrder byteOrder;
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        int i5;
        int[] iArr = this.zze;
        iArr.getClass();
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        ByteBuffer byteBufferZzj = zzj(((iLimit - iPosition) / this.zzb.zze) * this.zzc.zze);
        while (iPosition < iLimit) {
            for (int i6 : iArr) {
                int iZzk = (zzex.zzk(this.zzb.zzd) * i6) + iPosition;
                int i7 = this.zzb.zzd;
                if (i7 == 2) {
                    byteBufferZzj.putShort(byteBuffer.getShort(iZzk));
                } else if (i7 == 3) {
                    byteBufferZzj.put(byteBuffer.get(iZzk));
                } else if (i7 == 4) {
                    byteBufferZzj.putFloat(byteBuffer.getFloat(iZzk));
                } else if (i7 == 21) {
                    byteOrderOrder = byteBuffer.order();
                    byteOrder = ByteOrder.BIG_ENDIAN;
                    if (byteOrderOrder == byteOrder) {
                        i = iZzk;
                    } else {
                        i = iZzk + 2;
                    }
                    byte b = byteBuffer.get(i);
                    byte b2 = byteBuffer.get(iZzk + 1);
                    if (byteBuffer.order() == byteOrder) {
                        iZzk += 2;
                    }
                    i2 = ((b << 24) & (-16777216)) | ((b2 << 16) & 16711680) | ((byteBuffer.get(iZzk) << 8) & 65280);
                    i3 = i2 >> 8;
                    if ((i3 & (-16777216)) != 0 || (i3 & (-8388608)) == -8388608) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zzdd.zze(z, "Value out of range of 24-bit integer: ".concat(String.valueOf(Integer.toHexString(i3))));
                    zzdd.zzd(byteBufferZzj.remaining() >= 3);
                    if (byteBufferZzj.order() == byteOrder) {
                        i4 = (i2 >> 24) & 255;
                    } else {
                        i4 = i3 & 255;
                    }
                    byte b3 = (byte) i4;
                    int i8 = (i2 >> 16) & 255;
                    if (byteBufferZzj.order() == byteOrder) {
                        i5 = i3 & 255;
                    } else {
                        i5 = (i2 >> 24) & 255;
                    }
                    byteBufferZzj.put(b3).put((byte) i8).put((byte) i5);
                } else {
                    if (i7 != 22) {
                        if (i7 == 268435456) {
                            byteBufferZzj.putShort(byteBuffer.getShort(iZzk));
                        } else if (i7 == 1342177280) {
                            byteOrderOrder = byteBuffer.order();
                            byteOrder = ByteOrder.BIG_ENDIAN;
                            if (byteOrderOrder == byteOrder) {
                                i = iZzk;
                            } else {
                                i = iZzk + 2;
                            }
                            byte b4 = byteBuffer.get(i);
                            byte b5 = byteBuffer.get(iZzk + 1);
                            if (byteBuffer.order() == byteOrder) {
                                iZzk += 2;
                            }
                            i2 = ((b4 << 24) & (-16777216)) | ((b5 << 16) & 16711680) | ((byteBuffer.get(iZzk) << 8) & 65280);
                            i3 = i2 >> 8;
                            if ((i3 & (-16777216)) != 0) {
                                z = true;
                            } else {
                                z = true;
                            }
                            zzdd.zze(z, "Value out of range of 24-bit integer: ".concat(String.valueOf(Integer.toHexString(i3))));
                            zzdd.zzd(byteBufferZzj.remaining() >= 3);
                            if (byteBufferZzj.order() == byteOrder) {
                                i4 = (i2 >> 24) & 255;
                            } else {
                                i4 = i3 & 255;
                            }
                            byte b6 = (byte) i4;
                            int i9 = (i2 >> 16) & 255;
                            if (byteBufferZzj.order() == byteOrder) {
                                i5 = i3 & 255;
                            } else {
                                i5 = (i2 >> 24) & 255;
                            }
                            byteBufferZzj.put(b6).put((byte) i9).put((byte) i5);
                        } else if (i7 != 1610612736) {
                            throw new IllegalStateException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i7, "Unexpected encoding: "));
                        }
                    }
                    byteBufferZzj.putInt(byteBuffer.getInt(iZzk));
                }
            }
            iPosition += this.zzb.zze;
        }
        byteBuffer.position(iLimit);
        byteBufferZzj.flip();
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final zzcl zzi(zzcl zzclVar) throws zzcm {
        int[] iArr = this.zzd;
        if (iArr == null) {
            return zzcl.zza;
        }
        int i = zzclVar.zzd;
        if (!zzex.zzK(i)) {
            throw new zzcm("Unhandled input format:", zzclVar);
        }
        int i2 = zzclVar.zzc;
        boolean z = i2 != iArr.length;
        int i3 = 0;
        while (true) {
            int length = iArr.length;
            if (i3 >= length) {
                return z ? new zzcl(zzclVar.zzb, length, i) : zzcl.zza;
            }
            int i4 = iArr[i3];
            if (i4 >= i2) {
                throw new zzcm(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Channel map (", Arrays.toString(iArr), ") trying to access non-existent input channel."), zzclVar);
            }
            z |= i4 != i3;
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void zzk() {
        this.zze = this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void zzm() {
        this.zze = null;
        this.zzd = null;
    }

    public final void zzo(int[] iArr) {
        this.zzd = iArr;
    }
}
