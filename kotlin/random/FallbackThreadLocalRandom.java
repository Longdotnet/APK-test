package kotlin.random;

import com.google.android.gms.dynamite.zzd;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class FallbackThreadLocalRandom extends AbstractPlatformRandom {
    public final zzd implStorage = new zzd(1);

    @Override // kotlin.random.AbstractPlatformRandom
    public final java.util.Random getImpl() {
        Object obj = this.implStorage.get();
        Intrinsics.checkNotNullExpressionValue(obj, "implStorage.get()");
        return (java.util.Random) obj;
    }
}
