package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
final class zzauq implements Runnable {
    private zzauq() {
        throw null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CountDownLatch countDownLatch;
        try {
            zzaus.zzd = MessageDigest.getInstance("MD5");
            countDownLatch = zzaus.zzb;
        } catch (NoSuchAlgorithmException unused) {
            countDownLatch = zzaus.zzb;
        } catch (Throwable th) {
            zzaus.zzb.countDown();
            throw th;
        }
        countDownLatch.countDown();
    }

    public /* synthetic */ zzauq(zzaur zzaurVar) {
    }
}
