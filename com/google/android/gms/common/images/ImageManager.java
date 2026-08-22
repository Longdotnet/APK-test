package com.google.android.gms.common.images;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import androidx.work.impl.WorkerWrapper;
import com.google.android.gms.internal.base.zam;
import com.google.android.gms.internal.base.zat;
import com.google.android.gms.internal.base.zau;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class ImageManager {
    public static final Object zaa = new Object();
    public static final HashSet zab = new HashSet();
    public static ImageManager zac;
    public final Context zad;
    public final zau zae = new zau(Looper.getMainLooper());
    public final ExecutorService zaf = zat.zaa().zab(4, 2);
    public final HashMap zah;
    public final HashMap zai;
    public final HashMap zaj;

    final class ImageReceiver extends ResultReceiver {
        public final Uri zab;
        public final ArrayList zac;

        public ImageReceiver(Uri uri) {
            super(new zau(Looper.getMainLooper()));
            this.zab = uri;
            this.zac = new ArrayList();
        }

        @Override // android.os.ResultReceiver
        public final void onReceiveResult(int i, Bundle bundle) {
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
            ImageManager imageManager = ImageManager.this;
            imageManager.zaf.execute(new WorkerWrapper.AnonymousClass1(imageManager, this.zab, parcelFileDescriptor, 15));
        }

        public final void zad() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.setPackage("com.google.android.gms");
            intent.putExtra("com.google.android.gms.extras.uri", this.zab);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            ImageManager.this.zad.sendBroadcast(intent);
        }
    }

    public ImageManager(Activity activity) {
        this.zad = activity.getApplicationContext();
        new zam();
        this.zah = new HashMap();
        this.zai = new HashMap();
        this.zaj = new HashMap();
    }
}
