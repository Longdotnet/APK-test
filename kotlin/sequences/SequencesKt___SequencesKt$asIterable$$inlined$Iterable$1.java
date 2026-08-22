package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.DelimitedRangesSequence;
import kotlin.text.DelimitedRangesSequence.AnonymousClass1;

/* JADX INFO: loaded from: classes3.dex */
public final class SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1 implements Iterable, KMappedMarker {
    public final /* synthetic */ DelimitedRangesSequence $this_asIterable$inlined;

    public SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1(DelimitedRangesSequence delimitedRangesSequence) {
        this.$this_asIterable$inlined = delimitedRangesSequence;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.$this_asIterable$inlined.new AnonymousClass1();
    }
}
