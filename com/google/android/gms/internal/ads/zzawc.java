package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public final class zzawc {
    private static Cipher zza;
    private static final Object zzb = new Object();
    private static final Object zzc = new Object();

    public zzawc(SecureRandom secureRandom) {
    }

    private static final Cipher zzc() {
        Cipher cipher;
        synchronized (zzc) {
            try {
                if (zza == null) {
                    zza = Cipher.getInstance("AES/CBC/PKCS5Padding");
                }
                cipher = zza;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cipher;
    }

    public final String zza(byte[] bArr, byte[] bArr2) throws zzawb {
        byte[] bArrDoFinal;
        byte[] iv;
        int length = bArr.length;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            synchronized (zzb) {
                zzc().init(1, secretKeySpec, (SecureRandom) null);
                bArrDoFinal = zzc().doFinal(bArr2);
                iv = zzc().getIV();
            }
            int length2 = bArrDoFinal.length + iv.length;
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length2);
            byteBufferAllocate.put(iv).put(bArrDoFinal);
            byteBufferAllocate.flip();
            byte[] bArr3 = new byte[length2];
            byteBufferAllocate.get(bArr3);
            return zzaul.zza(bArr3, false);
        } catch (InvalidKeyException e) {
            throw new zzawb(this, e);
        } catch (NoSuchAlgorithmException e2) {
            throw new zzawb(this, e2);
        } catch (BadPaddingException e3) {
            throw new zzawb(this, e3);
        } catch (IllegalBlockSizeException e4) {
            throw new zzawb(this, e4);
        } catch (NoSuchPaddingException e5) {
            throw new zzawb(this, e5);
        }
    }

    public final byte[] zzb(byte[] bArr, String str) throws zzawb {
        byte[] bArrDoFinal;
        int length = bArr.length;
        try {
            byte[] bArrZzb = zzaul.zzb(str, false);
            int length2 = bArrZzb.length;
            if (length2 <= 16) {
                throw new zzawb(this);
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length2);
            byteBufferAllocate.put(bArrZzb);
            byteBufferAllocate.flip();
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[length2 - 16];
            byteBufferAllocate.get(bArr2);
            byteBufferAllocate.get(bArr3);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            synchronized (zzb) {
                zzc().init(2, secretKeySpec, new IvParameterSpec(bArr2));
                bArrDoFinal = zzc().doFinal(bArr3);
            }
            return bArrDoFinal;
        } catch (IllegalArgumentException e) {
            throw new zzawb(this, e);
        } catch (InvalidAlgorithmParameterException e2) {
            throw new zzawb(this, e2);
        } catch (InvalidKeyException e3) {
            throw new zzawb(this, e3);
        } catch (NoSuchAlgorithmException e4) {
            throw new zzawb(this, e4);
        } catch (BadPaddingException e5) {
            throw new zzawb(this, e5);
        } catch (IllegalBlockSizeException e6) {
            throw new zzawb(this, e6);
        } catch (NoSuchPaddingException e7) {
            throw new zzawb(this, e7);
        }
    }
}
