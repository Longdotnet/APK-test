package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgzb;
import com.google.android.gms.internal.ads.zzgzh;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class zzgzb<MessageType extends zzgzh<MessageType, BuilderType>, BuilderType extends zzgzb<MessageType, BuilderType>> extends zzgxh<MessageType, BuilderType> {
    protected MessageType zza;
    private final MessageType zzb;

    public zzgzb(MessageType messagetype) {
        this.zzb = messagetype;
        if (messagetype.zzcd()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = (MessageType) zza();
    }

    private MessageType zza() {
        return (MessageType) this.zzb.zzbj();
    }

    private static <MessageType> void zzb(MessageType messagetype, MessageType messagetype2) {
        zzhbc.zza().zzb(messagetype.getClass()).zzg(messagetype, messagetype2);
    }

    @Override // com.google.android.gms.internal.ads.zzgxh
    public /* bridge */ /* synthetic */ zzgxh zzaD(zzgxi zzgxiVar) {
        zzbi((zzgzh) zzgxiVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgxh
    /* JADX INFO: renamed from: zzaK */
    public /* bridge */ /* synthetic */ zzgxh zzaW(zzgyf zzgyfVar, zzgyr zzgyrVar) throws IOException {
        zzbk(zzgyfVar, zzgyrVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgxh
    /* JADX INFO: renamed from: zzaN */
    public /* bridge */ /* synthetic */ zzgxh zzaZ(byte[] bArr, int i, int i2) throws zzgzw {
        zzbl(bArr, i, i2);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgxh
    /* JADX INFO: renamed from: zzaO */
    public /* bridge */ /* synthetic */ zzgxh zzba(byte[] bArr, int i, int i2, zzgyr zzgyrVar) throws zzgzw {
        zzbm(bArr, i, i2, zzgyrVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgxh
    public /* bridge */ /* synthetic */ zzhar zzaW(zzgyf zzgyfVar, zzgyr zzgyrVar) throws IOException {
        zzbk(zzgyfVar, zzgyrVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgxh
    public /* bridge */ /* synthetic */ zzhar zzaZ(byte[] bArr, int i, int i2) throws zzgzw {
        zzbl(bArr, i, i2);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgxh
    public /* bridge */ /* synthetic */ zzhar zzba(byte[] bArr, int i, int i2, zzgyr zzgyrVar) throws zzgzw {
        zzbm(bArr, i, i2, zzgyrVar);
        return this;
    }

    public final BuilderType zzbg() {
        if (this.zzb.zzcd()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = (MessageType) zza();
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgxh
    /* JADX INFO: renamed from: zzbh, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public BuilderType zzaC() {
        BuilderType buildertype = (BuilderType) zzbt().zzcY();
        buildertype.zza = (MessageType) zzbs();
        return buildertype;
    }

    public BuilderType zzbi(MessageType messagetype) {
        zzbj(messagetype);
        return this;
    }

    public BuilderType zzbj(MessageType messagetype) {
        if (zzbt().equals(messagetype)) {
            return this;
        }
        zzbu();
        zzb(this.zza, messagetype);
        return this;
    }

    public BuilderType zzbk(zzgyf zzgyfVar, zzgyr zzgyrVar) throws IOException {
        zzbu();
        try {
            zzhbc.zza().zzb(this.zza.getClass()).zzh(this.zza, zzgyg.zzq(zzgyfVar), zzgyrVar);
            return this;
        } catch (RuntimeException e) {
            if (e.getCause() instanceof IOException) {
                throw ((IOException) e.getCause());
            }
            throw e;
        }
    }

    public BuilderType zzbl(byte[] bArr, int i, int i2) throws zzgzw {
        int i3 = zzgyr.zzb;
        int i4 = zzhbc.zza;
        zzbm(bArr, i, i2, zzgyr.zza);
        return this;
    }

    public BuilderType zzbm(byte[] bArr, int i, int i2, zzgyr zzgyrVar) throws zzgzw {
        zzbu();
        try {
            zzhbc.zza().zzb(this.zza.getClass()).zzi(this.zza, bArr, i, i + i2, new zzgxn(zzgyrVar));
            return this;
        } catch (zzgzw e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    /* JADX INFO: renamed from: zzbn */
    public final MessageType zzbr() {
        MessageType messagetype = (MessageType) zzbs();
        if (messagetype.zzbw()) {
            return messagetype;
        }
        throw zzgxh.zzbb(messagetype);
    }

    @Override // com.google.android.gms.internal.ads.zzhar
    /* JADX INFO: renamed from: zzbo */
    public MessageType zzbs() {
        if (!this.zza.zzcd()) {
            return this.zza;
        }
        this.zza.zzbU();
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzhat
    /* JADX INFO: renamed from: zzbp */
    public MessageType zzbt() {
        return this.zzb;
    }

    public /* bridge */ /* synthetic */ zzhar zzbq() {
        zzbg();
        return this;
    }

    public final void zzbu() {
        if (this.zza.zzcd()) {
            return;
        }
        zzbv();
    }

    public void zzbv() {
        MessageType messagetype = (MessageType) zza();
        zzb(messagetype, this.zza);
        this.zza = messagetype;
    }

    @Override // com.google.android.gms.internal.ads.zzhat
    public final boolean zzbw() {
        return zzgzh.zzk(this.zza, false);
    }
}
