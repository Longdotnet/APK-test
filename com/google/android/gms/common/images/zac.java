package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.SystemClock;
import com.google.android.gms.common.internal.zzah;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
public final class zac implements Runnable {
    public final /* synthetic */ ImageManager zaa;
    public final Uri zab;
    public final Bitmap zac;
    public final CountDownLatch zad;

    public zac(ImageManager imageManager, Uri uri, Bitmap bitmap, CountDownLatch countDownLatch) {
        this.zaa = imageManager;
        this.zab = uri;
        this.zac = bitmap;
        this.zad = countDownLatch;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzah.checkMainThread("OnBitmapLoadedRunnable must be executed in the main thread");
        ImageManager.ImageReceiver imageReceiver = (ImageManager.ImageReceiver) this.zaa.zai.remove(this.zab);
        if (imageReceiver != null) {
            ArrayList arrayList = imageReceiver.zac;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zaf zafVar = (zaf) arrayList.get(i);
                Bitmap bitmap = this.zac;
                if (bitmap != null) {
                    Context context = this.zaa.zad;
                    zafVar.getClass();
                    zafVar.zaa(new BitmapDrawable(context.getResources(), bitmap), true);
                } else {
                    this.zaa.zaj.put(this.zab, Long.valueOf(SystemClock.elapsedRealtime()));
                    Context context2 = this.zaa.zad;
                    zafVar.zaa(null, false);
                }
                if (!(zafVar instanceof zaf)) {
                    this.zaa.zah.remove(zafVar);
                }
            }
        }
        this.zad.countDown();
        synchronized (ImageManager.zaa) {
            ImageManager.zab.remove(this.zab);
        }
    }
}
