package com.daerisoft.thespikerm;

import android.app.Activity;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.images.zab;
import com.google.android.gms.common.images.zaf;
import com.google.android.gms.common.internal.zzah;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.yoyogames.runner.RunnerJNILib;

/* JADX INFO: loaded from: classes.dex */
public final class YYGooglePlayServices$Obj_UriToPath$1 implements Runnable {
    public final /* synthetic */ double val$ind;
    public final /* synthetic */ String val$uriString;

    /* JADX INFO: renamed from: com.daerisoft.thespikerm.YYGooglePlayServices$Obj_UriToPath$1$1 */
    public final class AnonymousClass1 {
        public AnonymousClass1() {
        }
    }

    public YYGooglePlayServices$Obj_UriToPath$1(String str, double d) {
        this.val$uriString = str;
        this.val$ind = d;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Uri uri = Uri.parse(this.val$uriString);
        try {
            new ImageView(YYGooglePlayServices.activity);
            Activity activity = YYGooglePlayServices.activity;
            if (ImageManager.zac == null) {
                ImageManager.zac = new ImageManager(activity);
            }
            ImageManager imageManager = ImageManager.zac;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1();
            imageManager.getClass();
            zaf zafVar = new zaf(anonymousClass1, uri);
            zzah.checkMainThread("ImageManager.loadImage() must be called in the main thread");
            new zab(imageManager, zafVar).run();
        } catch (Exception e) {
            Log.e(GooglePlayBillingService.TAG, "URI2PATH failed: " + e.getMessage());
            int iJCreateDsMap = RunnerJNILib.jCreateDsMap(null, null, null);
            RunnerJNILib.DsMapAddString(iJCreateDsMap, "type", "GooglePlayServices_UriToPath");
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "ind", this.val$ind);
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap, FirebaseAnalytics.Param.SUCCESS, 0.0d);
            RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 70);
        }
    }
}
