package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.internal.p002firebaseauthapi.zzabl;
import com.google.android.gms.internal.p002firebaseauthapi.zzabm;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzabm<MessageType extends zzabm<MessageType, BuilderType>, BuilderType extends zzabl<MessageType, BuilderType>> implements zzaek {
    protected int zza = 0;

    public int zzn(zzaew zzaewVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaek
    public final zzacc zzo() {
        try {
            int iZzs = zzs();
            zzacc zzaccVar = zzacc.zzb;
            byte[] bArr = new byte[iZzs];
            zzacn zzacnVarZzG = zzacn.zzG(bArr);
            zzI(zzacnVarZzG);
            zzacnVarZzG.zzI();
            return new zzabz(bArr);
        } catch (IOException e) {
            throw new RuntimeException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Serializing ", getClass().getName(), " to a ByteString threw an IOException (should never happen)."), e);
        }
    }

    public final void zzp(OutputStream outputStream) {
        zzacn zzacnVarZzH = zzacn.zzH(outputStream, zzacn.zzB(zzs()));
        zzI(zzacnVarZzH);
        zzacnVarZzH.zzN();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaek
    public final byte[] zzq() {
        try {
            byte[] bArr = new byte[zzs()];
            zzacn zzacnVarZzG = zzacn.zzG(bArr);
            zzI(zzacnVarZzG);
            zzacnVarZzG.zzI();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Serializing ", getClass().getName(), " to a byte array threw an IOException (should never happen)."), e);
        }
    }
}
