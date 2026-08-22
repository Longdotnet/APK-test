package kotlin.sequences;

import androidx.activity.result.ActivityResultRegistry$generateRandomNumber$1;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class GeneratorSequence implements Sequence {
    public final /* synthetic */ int $r8$classId;
    public final Object getNextValue;

    /* JADX INFO: renamed from: kotlin.sequences.GeneratorSequence$iterator$1, reason: invalid class name */
    public final class AnonymousClass1 implements Iterator, KMappedMarker {
        public Object nextItem;
        public int nextState = -2;

        public AnonymousClass1() {
        }

        public final void calcNext() {
            Object objInvoke;
            int i = this.nextState;
            GeneratorSequence generatorSequence = GeneratorSequence.this;
            if (i == -2) {
                generatorSequence.getClass();
                objInvoke = ActivityResultRegistry$generateRandomNumber$1.INSTANCE.invoke();
            } else {
                SequencesKt__SequencesKt$generateSequence$1 sequencesKt__SequencesKt$generateSequence$1 = (SequencesKt__SequencesKt$generateSequence$1) generatorSequence.getNextValue;
                Object obj = this.nextItem;
                Intrinsics.checkNotNull(obj);
                objInvoke = sequencesKt__SequencesKt$generateSequence$1.invoke(obj);
            }
            this.nextItem = objInvoke;
            this.nextState = 1;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.nextState < 0) {
                calcNext();
            }
            return this.nextState == 1;
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (this.nextState < 0) {
                calcNext();
            }
            if (this.nextState == 0) {
                throw new NoSuchElementException();
            }
            Object obj = this.nextItem;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
            this.nextState = -1;
            return obj;
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public /* synthetic */ GeneratorSequence(Object obj, int i) {
        this.$r8$classId = i;
        this.getNextValue = obj;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        switch (this.$r8$classId) {
            case 0:
                return new AnonymousClass1();
            case 1:
                return ((List) this.getNextValue).iterator();
            default:
                return (Iterator) this.getNextValue;
        }
    }
}
