package androidx.emoji2.text;

import android.content.pm.PackageManager;
import android.content.pm.Signature;
import androidx.work.InputMergerFactory$1;

/* JADX INFO: loaded from: classes.dex */
public final class DefaultEmojiCompatConfig$DefaultEmojiCompatConfigHelper_API28 extends InputMergerFactory$1 {
    @Override // androidx.work.InputMergerFactory$1
    public final Signature[] getSigningSignatures(PackageManager packageManager, String str) {
        return packageManager.getPackageInfo(str, 64).signatures;
    }
}
