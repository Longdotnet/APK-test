package com.google.android.gms.internal.play_billing;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.internal.play_billing.zzax;
import com.google.android.gms.internal.play_billing.zzay;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzay<MessageType extends zzay<MessageType, BuilderType>, BuilderType extends zzax<MessageType, BuilderType>> implements zzec {
    protected int zza = 0;

    public int zza(zzeo zzeoVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzec
    public final zzbq zzb() {
        try {
            int iZzf = zzf();
            zzbq zzbqVar = zzbq.zzb;
            byte[] bArr = new byte[iZzf];
            zzby zzbyVarZzy = zzby.zzy(bArr, 0, iZzf);
            zze(zzbyVarZzy);
            zzbyVarZzy.zzz();
            return new zzbn(bArr);
        } catch (IOException e) {
            throw new RuntimeException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Serializing ", getClass().getName(), " to a ByteString threw an IOException (should never happen)."), e);
        }
    }

    public final byte[] zzc() {
        try {
            int iZzf = zzf();
            byte[] bArr = new byte[iZzf];
            zzby zzbyVarZzy = zzby.zzy(bArr, 0, iZzf);
            zze(zzbyVarZzy);
            zzbyVarZzy.zzz();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Serializing ", getClass().getName(), " to a byte array threw an IOException (should never happen)."), e);
        }
    }
}
