package com.google.android.gms.internal.ads;

import androidx.work.impl.constraints.controllers.pST.ehgOP;
import java.io.EOFException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzarm implements zzarn {
    private static final Logger zzb = Logger.getLogger(zzarm.class.getName());
    final ThreadLocal zza = new zzarl(this);

    public abstract zzarq zza(String str, byte[] bArr, String str2);

    @Override // com.google.android.gms.internal.ads.zzarn
    public final zzarq zzb(zzhgd zzhgdVar, zzarr zzarrVar) throws EOFException {
        int iZza;
        long jZzc;
        String strZza;
        long jZzb = zzhgdVar.zzb();
        ThreadLocal threadLocal = this.zza;
        ((ByteBuffer) threadLocal.get()).rewind().limit(8);
        do {
            iZza = zzhgdVar.zza((ByteBuffer) threadLocal.get());
            if (iZza == 8) {
                ((ByteBuffer) threadLocal.get()).rewind();
                long jZze = zzarp.zze((ByteBuffer) threadLocal.get());
                byte[] bArr = null;
                if (jZze < 8 && jZze > 1) {
                    Logger logger = zzb;
                    Level level = Level.SEVERE;
                    StringBuilder sb = new StringBuilder(80);
                    sb.append("Plausibility check failed: size < 8 (size = ");
                    sb.append(jZze);
                    sb.append(ehgOP.hbd);
                    logger.logp(level, "com.coremedia.iso.AbstractBoxParser", "parseBox", sb.toString());
                    return null;
                }
                byte[] bArr2 = new byte[4];
                ((ByteBuffer) threadLocal.get()).get(bArr2);
                try {
                    String str = new String(bArr2, "ISO-8859-1");
                    if (jZze == 1) {
                        ThreadLocal threadLocal2 = this.zza;
                        ((ByteBuffer) threadLocal2.get()).limit(16);
                        zzhgdVar.zza((ByteBuffer) threadLocal2.get());
                        ((ByteBuffer) threadLocal2.get()).position(8);
                        jZzc = zzarp.zzf((ByteBuffer) threadLocal2.get()) - 16;
                    } else if (jZze == 0) {
                        jZzc = zzhgdVar.zzc() - zzhgdVar.zzb();
                    } else {
                        jZzc = jZze - 8;
                    }
                    if ("uuid".equals(str)) {
                        ThreadLocal threadLocal3 = this.zza;
                        ((ByteBuffer) threadLocal3.get()).limit(((ByteBuffer) threadLocal3.get()).limit() + 16);
                        zzhgdVar.zza((ByteBuffer) threadLocal3.get());
                        bArr = new byte[16];
                        for (int iPosition = ((ByteBuffer) threadLocal3.get()).position() - 16; iPosition < ((ByteBuffer) threadLocal3.get()).position(); iPosition++) {
                            bArr[iPosition - (((ByteBuffer) threadLocal3.get()).position() - 16)] = ((ByteBuffer) threadLocal3.get()).get(iPosition);
                        }
                        jZzc -= 16;
                    }
                    long j = jZzc;
                    if (zzarrVar instanceof zzarq) {
                        strZza = ((zzarq) zzarrVar).zza();
                    } else {
                        strZza = "";
                    }
                    zzarq zzarqVarZza = zza(str, bArr, strZza);
                    ThreadLocal threadLocal4 = this.zza;
                    ((ByteBuffer) threadLocal4.get()).rewind();
                    zzarqVarZza.zzb(zzhgdVar, (ByteBuffer) threadLocal4.get(), j, this);
                    return zzarqVarZza;
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
            }
        } while (iZza >= 0);
        zzhgdVar.zze(jZzb);
        throw new EOFException();
    }
}
