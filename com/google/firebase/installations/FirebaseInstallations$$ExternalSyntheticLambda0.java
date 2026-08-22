package com.google.firebase.installations;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FirebaseInstallations$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ FirebaseInstallations f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ FirebaseInstallations$$ExternalSyntheticLambda0(FirebaseInstallations firebaseInstallations, boolean z, int i) {
        this.$r8$classId = i;
        this.f$0 = firebaseInstallations;
        this.f$1 = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.lambda$doRegistrationOrRefresh$3(this.f$1);
                break;
            default:
                this.f$0.lambda$getToken$2(this.f$1);
                break;
        }
    }
}
