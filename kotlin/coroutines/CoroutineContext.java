package kotlin.coroutines;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
public interface CoroutineContext {

    public interface Element extends CoroutineContext {
        Key getKey();
    }

    public interface Key {
    }

    /* JADX INFO: renamed from: kotlin.coroutines.CoroutineContext$plus$1 */
    public final class AnonymousClass1 extends Lambda implements Function2 {
        public final /* synthetic */ int $r8$classId;
        public static final AnonymousClass1 INSTANCE$1 = new AnonymousClass1(2, 1);
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1(2, 0);

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(int i, int i2) {
            super(i);
            this.$r8$classId = i2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            CombinedContext combinedContext;
            switch (this.$r8$classId) {
                case 0:
                    CoroutineContext acc = (CoroutineContext) obj;
                    Element element = (Element) obj2;
                    Intrinsics.checkNotNullParameter(acc, "acc");
                    CoroutineContext coroutineContextMinusKey = acc.minusKey(element.getKey());
                    EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
                    if (coroutineContextMinusKey == emptyCoroutineContext) {
                        return element;
                    }
                    ContinuationInterceptor.Key key = ContinuationInterceptor.Key.$$INSTANCE;
                    ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContextMinusKey.get(key);
                    if (continuationInterceptor == null) {
                        combinedContext = new CombinedContext(element, coroutineContextMinusKey);
                    } else {
                        CoroutineContext coroutineContextMinusKey2 = coroutineContextMinusKey.minusKey(key);
                        if (coroutineContextMinusKey2 == emptyCoroutineContext) {
                            return new CombinedContext(continuationInterceptor, element);
                        }
                        combinedContext = new CombinedContext(continuationInterceptor, new CombinedContext(element, coroutineContextMinusKey2));
                    }
                    return combinedContext;
                default:
                    String acc2 = (String) obj;
                    Element element2 = (Element) obj2;
                    Intrinsics.checkNotNullParameter(acc2, "acc");
                    if (acc2.length() == 0) {
                        return element2.toString();
                    }
                    return acc2 + ", " + element2;
            }
        }
    }

    Object fold(Object obj, Function2 function2);

    Element get(Key key);

    CoroutineContext minusKey(Key key);

    CoroutineContext plus(CoroutineContext coroutineContext);
}
