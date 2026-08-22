package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.internal.ads.zzgxh;
import com.google.android.gms.internal.ads.zzgxi;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzgxi<MessageType extends zzgxi<MessageType, BuilderType>, BuilderType extends zzgxh<MessageType, BuilderType>> implements zzhas {
    protected int zzq = 0;

    public static <T> void zzaQ(Iterable<T> iterable, List<? super T> list) {
        zzgxh.zzbd(iterable, list);
    }

    public static void zzaR(zzgxz zzgxzVar) {
        if (!zzgxzVar.zzp()) {
            throw new IllegalArgumentException("Byte string is not UTF-8.");
        }
    }

    private String zzdI(String str) {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m("Serializing ", getClass().getName(), " to a ", str, " threw an IOException (should never happen).");
    }

    public int zzaL() {
        throw new UnsupportedOperationException();
    }

    public int zzaM(zzhbl zzhblVar) {
        return zzaL();
    }

    @Override // com.google.android.gms.internal.ads.zzhas
    public zzgxz zzaN() {
        try {
            int iZzaY = zzaY();
            zzgxz zzgxzVar = zzgxz.zzb;
            byte[] bArr = new byte[iZzaY];
            int i = zzgym.zzf;
            zzgyi zzgyiVar = new zzgyi(bArr, 0, iZzaY);
            zzcZ(zzgyiVar);
            zzgyiVar.zzF();
            return new zzgxw(bArr);
        } catch (IOException e) {
            throw new RuntimeException(zzdI("ByteString"), e);
        }
    }

    public zzhax zzaO() {
        throw new UnsupportedOperationException("mutableCopy() is not implemented.");
    }

    public zzhbw zzaP() {
        return new zzhbw(this);
    }

    public void zzaS(int i) {
        throw new UnsupportedOperationException();
    }

    public void zzaT(OutputStream outputStream) {
        int iZzaY = zzaY();
        zzgyk zzgykVar = new zzgyk(outputStream, zzgym.zzB(zzgym.zzD(iZzaY) + iZzaY));
        zzgykVar.zzu(iZzaY);
        zzcZ(zzgykVar);
        zzgykVar.zzK();
    }

    public void zzaU(OutputStream outputStream) {
        zzgyk zzgykVar = new zzgyk(outputStream, zzgym.zzB(zzaY()));
        zzcZ(zzgykVar);
        zzgykVar.zzK();
    }

    public byte[] zzaV() {
        try {
            int iZzaY = zzaY();
            byte[] bArr = new byte[iZzaY];
            int i = zzgym.zzf;
            zzgyi zzgyiVar = new zzgyi(bArr, 0, iZzaY);
            zzcZ(zzgyiVar);
            zzgyiVar.zzF();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException(zzdI("byte array"), e);
        }
    }
}
