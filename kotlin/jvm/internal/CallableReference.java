package kotlin.jvm.internal;

import java.io.Serializable;
import kotlin.reflect.KCallable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CallableReference implements KCallable, Serializable {
    public final boolean isTopLevel;
    public final String name;
    public final Class owner;
    public final Object receiver;
    public transient KCallable reflected;
    public final String signature;

    public CallableReference(Object obj, Class cls, String str, String str2, boolean z) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z;
    }

    public final ClassBasedDeclarationContainer getOwner() {
        Class cls = this.owner;
        if (this.isTopLevel) {
            Reflection.factory.getClass();
            return new PackageReference(cls);
        }
        Reflection.factory.getClass();
        return new ClassReference(cls);
    }
}
