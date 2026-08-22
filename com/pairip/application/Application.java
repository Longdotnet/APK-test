package com.pairip.application;

import android.content.Context;
import com.daerisoft.thespikerm.RunnerApplication;
import com.pairip.SignatureCheck;
import com.pairip.VMRunner;
import com.pairip.licensecheck.LicenseClient;

/* JADX INFO: loaded from: classes2.dex */
public class Application extends RunnerApplication {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.daerisoft.thespikerm.RunnerApplication, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        VMRunner.setContext(context);
        SignatureCheck.verifyIntegrity(context);
        LicenseClient.checkLicense(context);
        super.attachBaseContext(context);
    }
}
