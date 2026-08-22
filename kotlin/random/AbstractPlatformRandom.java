package kotlin.random;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractPlatformRandom extends Random {
    public abstract java.util.Random getImpl();

    @Override // kotlin.random.Random
    public final int nextInt() {
        return getImpl().nextInt();
    }

    @Override // kotlin.random.Random
    public final int nextInt$1() {
        return getImpl().nextInt(2147418112);
    }
}
