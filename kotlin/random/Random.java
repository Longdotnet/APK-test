package kotlin.random;

import java.io.Serializable;
import kotlin.internal.PlatformImplementationsKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Random {
    public static final Default Default = new Default();
    public static final Random defaultRandom = PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();

    public final class Default extends Random implements Serializable {

        public final class Serialized implements Serializable {
            public static final Serialized INSTANCE = new Serialized();
            private static final long serialVersionUID = 0;

            private final Object readResolve() {
                return Random.Default;
            }
        }

        private final Object writeReplace() {
            return Serialized.INSTANCE;
        }

        @Override // kotlin.random.Random
        public final int nextInt() {
            return Random.defaultRandom.nextInt();
        }

        @Override // kotlin.random.Random
        public final int nextInt$1() {
            return Random.defaultRandom.nextInt$1();
        }
    }

    public abstract int nextInt();

    public abstract int nextInt$1();
}
