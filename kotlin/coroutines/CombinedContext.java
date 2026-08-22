package kotlin.coroutines;

import java.io.Serializable;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$IntRef;
import okhttp3.Headers;

/* JADX INFO: loaded from: classes3.dex */
public final class CombinedContext implements CoroutineContext, Serializable {
    public final CoroutineContext.Element element;
    public final CoroutineContext left;

    public final class Serialized implements Serializable {
        private static final long serialVersionUID = 0;
        public final CoroutineContext[] elements;

        public Serialized(CoroutineContext[] coroutineContextArr) {
            this.elements = coroutineContextArr;
        }

        private final Object readResolve() {
            CoroutineContext coroutineContextPlus = EmptyCoroutineContext.INSTANCE;
            for (CoroutineContext coroutineContext : this.elements) {
                coroutineContextPlus = coroutineContextPlus.plus(coroutineContext);
            }
            return coroutineContextPlus;
        }
    }

    /* JADX INFO: renamed from: kotlin.coroutines.CombinedContext$writeReplace$1 */
    public final class AnonymousClass1 extends Lambda implements Function2 {
        public final /* synthetic */ CoroutineContext[] $elements;
        public final /* synthetic */ Ref$IntRef $index;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1() {
            super(2);
            coroutineContextArr = coroutineContextArr;
            ref$IntRef = ref$IntRef;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Intrinsics.checkNotNullParameter((Unit) obj, "<anonymous parameter 0>");
            Ref$IntRef ref$IntRef = ref$IntRef;
            int i = ref$IntRef.element;
            ref$IntRef.element = i + 1;
            coroutineContextArr[i] = (CoroutineContext.Element) obj2;
            return Unit.INSTANCE;
        }
    }

    public CombinedContext(CoroutineContext.Element element, CoroutineContext left) {
        Intrinsics.checkNotNullParameter(left, "left");
        this.left = left;
        this.element = element;
    }

    private final Object writeReplace() {
        int size = size();
        CoroutineContext[] coroutineContextArr = new CoroutineContext[size];
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        fold(Unit.INSTANCE, new Function2() { // from class: kotlin.coroutines.CombinedContext.writeReplace.1
            public final /* synthetic */ CoroutineContext[] $elements;
            public final /* synthetic */ Ref$IntRef $index;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1() {
                super(2);
                coroutineContextArr = coroutineContextArr;
                ref$IntRef = ref$IntRef;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Intrinsics.checkNotNullParameter((Unit) obj, "<anonymous parameter 0>");
                Ref$IntRef ref$IntRef2 = ref$IntRef;
                int i = ref$IntRef2.element;
                ref$IntRef2.element = i + 1;
                coroutineContextArr[i] = (CoroutineContext.Element) obj2;
                return Unit.INSTANCE;
            }
        });
        if (ref$IntRef.element == size) {
            return new Serialized(coroutineContextArr);
        }
        throw new IllegalStateException("Check failed.");
    }

    public final boolean equals(Object obj) {
        boolean zAreEqual;
        if (this != obj) {
            if (!(obj instanceof CombinedContext)) {
                return false;
            }
            CombinedContext combinedContext = (CombinedContext) obj;
            if (combinedContext.size() != size()) {
                return false;
            }
            CombinedContext combinedContext2 = this;
            while (true) {
                CoroutineContext.Element element = combinedContext2.element;
                if (!Intrinsics.areEqual(combinedContext.get(element.getKey()), element)) {
                    zAreEqual = false;
                    break;
                }
                CoroutineContext coroutineContext = combinedContext2.left;
                if (!(coroutineContext instanceof CombinedContext)) {
                    Intrinsics.checkNotNull(coroutineContext, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                    CoroutineContext.Element element2 = (CoroutineContext.Element) coroutineContext;
                    zAreEqual = Intrinsics.areEqual(combinedContext.get(element2.getKey()), element2);
                    break;
                }
                combinedContext2 = (CombinedContext) coroutineContext;
            }
            if (!zAreEqual) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final Object fold(Object obj, Function2 function2) {
        return function2.invoke(this.left.fold(obj, function2), this.element);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        CombinedContext combinedContext = this;
        while (true) {
            CoroutineContext.Element element = combinedContext.element.get(key);
            if (element != null) {
                return element;
            }
            CoroutineContext coroutineContext = combinedContext.left;
            if (!(coroutineContext instanceof CombinedContext)) {
                return coroutineContext.get(key);
            }
            combinedContext = (CombinedContext) coroutineContext;
        }
    }

    public final int hashCode() {
        return this.element.hashCode() + this.left.hashCode();
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        CoroutineContext.Element element = this.element;
        CoroutineContext.Element element2 = element.get(key);
        CoroutineContext coroutineContext = this.left;
        if (element2 != null) {
            return coroutineContext;
        }
        CoroutineContext coroutineContextMinusKey = coroutineContext.minusKey(key);
        if (coroutineContextMinusKey == coroutineContext) {
            return this;
        }
        return coroutineContextMinusKey == EmptyCoroutineContext.INSTANCE ? element : new CombinedContext(element, coroutineContextMinusKey);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext coroutineContext) {
        return Headers.Companion.plus(this, coroutineContext);
    }

    public final int size() {
        int i = 2;
        CombinedContext combinedContext = this;
        while (true) {
            CoroutineContext coroutineContext = combinedContext.left;
            combinedContext = coroutineContext instanceof CombinedContext ? (CombinedContext) coroutineContext : null;
            if (combinedContext == null) {
                return i;
            }
            i++;
        }
    }

    public final String toString() {
        return "[" + ((String) fold("", CoroutineContext.AnonymousClass1.INSTANCE$1)) + ']';
    }
}
