package com.google.android.gms.common.images;

import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.util.Log;
import com.daerisoft.thespikerm.GooglePlayBillingService;
import com.daerisoft.thespikerm.YYGooglePlayServices;
import com.daerisoft.thespikerm.YYGooglePlayServices$Obj_UriToPath$1;
import com.google.android.gms.common.internal.zzah;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.yoyogames.runner.RunnerJNILib;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zaf {
    public final zad zaa;
    public final WeakReference zac;

    public zaf(YYGooglePlayServices$Obj_UriToPath$1.AnonymousClass1 anonymousClass1, Uri uri) {
        this.zaa = new zad(uri);
        this.zac = new WeakReference(anonymousClass1);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zaf)) {
            return false;
        }
        zaf zafVar = (zaf) obj;
        YYGooglePlayServices$Obj_UriToPath$1.AnonymousClass1 anonymousClass1 = (YYGooglePlayServices$Obj_UriToPath$1.AnonymousClass1) this.zac.get();
        YYGooglePlayServices$Obj_UriToPath$1.AnonymousClass1 anonymousClass2 = (YYGooglePlayServices$Obj_UriToPath$1.AnonymousClass1) zafVar.zac.get();
        return anonymousClass2 != null && anonymousClass1 != null && zzah.equal(anonymousClass2, anonymousClass1) && zzah.equal(zafVar.zaa, this.zaa);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zaa});
    }

    public final void zaa(BitmapDrawable bitmapDrawable, boolean z) {
        YYGooglePlayServices$Obj_UriToPath$1.AnonymousClass1 anonymousClass1 = (YYGooglePlayServices$Obj_UriToPath$1.AnonymousClass1) this.zac.get();
        if (anonymousClass1 != null) {
            YYGooglePlayServices$Obj_UriToPath$1 yYGooglePlayServices$Obj_UriToPath$1 = YYGooglePlayServices$Obj_UriToPath$1.this;
            try {
                int iJCreateDsMap = RunnerJNILib.jCreateDsMap(null, null, null);
                RunnerJNILib.DsMapAddString(iJCreateDsMap, "type", "GooglePlayServices_UriToPath");
                RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "ind", yYGooglePlayServices$Obj_UriToPath$1.val$ind);
                if (z) {
                    Bitmap bitmap = bitmapDrawable.getBitmap();
                    File dir = new ContextWrapper(YYGooglePlayServices.activity.getApplicationContext()).getDir("profile", 0);
                    if (!dir.exists()) {
                        dir.mkdir();
                    }
                    File file = new File(dir, "thumbnail" + String.valueOf(yYGooglePlayServices$Obj_UriToPath$1.val$ind) + ".png");
                    String path = file.getPath();
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                    fileOutputStream.close();
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap, FirebaseAnalytics.Param.SUCCESS, 1.0d);
                    RunnerJNILib.DsMapAddString(iJCreateDsMap, "path", path);
                } else {
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap, FirebaseAnalytics.Param.SUCCESS, 0.0d);
                }
                RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 70);
            } catch (Exception e) {
                Log.e(GooglePlayBillingService.TAG, "URI2PATH failed: " + e.getMessage());
                int iJCreateDsMap2 = RunnerJNILib.jCreateDsMap(null, null, null);
                RunnerJNILib.DsMapAddString(iJCreateDsMap2, "type", "GooglePlayServices_UriToPath");
                RunnerJNILib.DsMapAddDouble(iJCreateDsMap2, "ind", yYGooglePlayServices$Obj_UriToPath$1.val$ind);
                RunnerJNILib.DsMapAddDouble(iJCreateDsMap2, FirebaseAnalytics.Param.SUCCESS, 0.0d);
                RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap2, 70);
            }
        }
    }
}
