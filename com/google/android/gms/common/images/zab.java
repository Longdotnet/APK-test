package com.google.android.gms.common.images;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import com.google.android.gms.common.images.ImageManager.ImageReceiver;
import com.google.android.gms.common.internal.zzah;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class zab implements Runnable {
    public final /* synthetic */ ImageManager zaa;
    public final zaf zab;

    public zab(ImageManager imageManager, zaf zafVar) {
        this.zaa = imageManager;
        this.zab = zafVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzah.checkMainThread("LoadImageRunnable must be executed on the main thread");
        ImageManager.ImageReceiver imageReceiver = (ImageManager.ImageReceiver) this.zaa.zah.get(this.zab);
        if (imageReceiver != null) {
            ImageManager imageManager = this.zaa;
            imageManager.zah.remove(this.zab);
            zaf zafVar = this.zab;
            zzah.checkMainThread("ImageReceiver.removeImageRequest() must be called in the main thread");
            imageReceiver.zac.remove(zafVar);
        }
        zaf zafVar2 = this.zab;
        zad zadVar = zafVar2.zaa;
        Uri uri = zadVar.zaa;
        if (uri == null) {
            Context context = this.zaa.zad;
            zafVar2.zaa(null, false);
            return;
        }
        Long l = (Long) this.zaa.zaj.get(uri);
        if (l != null) {
            if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                zaf zafVar3 = this.zab;
                Context context2 = this.zaa.zad;
                zafVar3.zaa(null, false);
                return;
            } else {
                ImageManager imageManager2 = this.zaa;
                imageManager2.zaj.remove(zadVar.zaa);
            }
        }
        ImageManager imageManager3 = this.zaa;
        ImageManager.ImageReceiver imageReceiver2 = (ImageManager.ImageReceiver) imageManager3.zai.get(zadVar.zaa);
        if (imageReceiver2 == null) {
            ImageManager.ImageReceiver imageReceiver3 = this.zaa.new ImageReceiver(zadVar.zaa);
            ImageManager imageManager4 = this.zaa;
            imageManager4.zai.put(zadVar.zaa, imageReceiver3);
            imageReceiver2 = imageReceiver3;
        }
        zaf zafVar4 = this.zab;
        zzah.checkMainThread("ImageReceiver.addImageRequest() must be called in the main thread");
        imageReceiver2.zac.add(zafVar4);
        synchronized (ImageManager.zaa) {
            try {
                HashSet hashSet = ImageManager.zab;
                if (!hashSet.contains(zadVar.zaa)) {
                    hashSet.add(zadVar.zaa);
                    imageReceiver2.zad();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
