package kotlin.jvm.internal;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Lambda implements FunctionBase, Serializable {
    public final int arity;

    public Lambda(int i) {
        this.arity = i;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public final int getArity() {
        return this.arity;
    }

    public final String toString() {
        Reflection.factory.getClass();
        String string = getClass().getGenericInterfaces()[0].toString();
        if (string.startsWith("kotlin.jvm.functions.")) {
            string = string.substring(21);
        }
        Intrinsics.checkNotNullExpressionValue(string, "renderLambdaToString(this)");
        return string;
    }
}
