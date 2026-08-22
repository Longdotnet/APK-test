package com.daerisoft.thespikerm;

import android.view.View;
import com.yoyogames.runner.RunnerJNILib;

/* JADX INFO: loaded from: classes.dex */
public final class FirebaseAuthentication_tools$3$1 implements View.OnClickListener {
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int iJCreateDsMap = RunnerJNILib.jCreateDsMap(null, null, null);
        RunnerJNILib.DsMapAddString(iJCreateDsMap, "type", "FirebaseAuthentication_Tools_WebView_onUserClose");
        RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 70);
    }
}
