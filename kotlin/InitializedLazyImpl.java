package kotlin;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public final class InitializedLazyImpl implements Lazy, Serializable {
    public final /* synthetic */ int $r8$classId = 1;
    public Object value;

    public /* synthetic */ InitializedLazyImpl() {
    }

    @Override // kotlin.Lazy
    public Object getValue() {
        return this.value;
    }

    public final String toString() {
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return String.valueOf(this.value);
    }

    public InitializedLazyImpl(Object obj) {
        this.value = obj;
    }
}
