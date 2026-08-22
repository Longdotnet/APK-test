package com.daerisoft.thespikerm;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SuncyanNet$$ExternalSyntheticLambda8 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ String f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ SuncyanNet$$ExternalSyntheticLambda8(String str, int i, int i2) {
        this.$r8$classId = i2;
        this.f$0 = str;
        this.f$1 = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                SuncyanNet.lambda$GameLogToProtobufBase64WithCompressAsync$2(this.f$0, this.f$1);
                break;
            default:
                SuncyanNet.lambda$Base64ProtobufToGameLogAsync$3(this.f$0, this.f$1);
                break;
        }
    }
}
