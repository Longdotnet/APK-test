package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SuspendLambda extends ContinuationImpl implements FunctionBase {
    public final int arity;

    public SuspendLambda(Continuation continuation) {
        super(continuation);
        this.arity = 2;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public final int getArity() {
        return this.arity;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl
    public final String toString() {
        if (this.completion != null) {
            return super.toString();
        }
        Reflection.factory.getClass();
        String string = getClass().getGenericInterfaces()[0].toString();
        if (string.startsWith("kotlin.jvm.functions.")) {
            string = string.substring(21);
        }
        Intrinsics.checkNotNullExpressionValue(string, "renderLambdaToString(this)");
        return string;
    }
}
