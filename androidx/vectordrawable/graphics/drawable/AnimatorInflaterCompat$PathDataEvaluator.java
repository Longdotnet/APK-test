package androidx.vectordrawable.graphics.drawable;

import android.animation.TypeEvaluator;
import androidx.core.graphics.PathParser$PathDataNode;
import androidx.work.WorkContinuation;

/* JADX INFO: loaded from: classes.dex */
public final class AnimatorInflaterCompat$PathDataEvaluator implements TypeEvaluator {
    public PathParser$PathDataNode[] mNodeArray;

    @Override // android.animation.TypeEvaluator
    public final Object evaluate(float f, Object obj, Object obj2) {
        PathParser$PathDataNode[] pathParser$PathDataNodeArr = (PathParser$PathDataNode[]) obj;
        PathParser$PathDataNode[] pathParser$PathDataNodeArr2 = (PathParser$PathDataNode[]) obj2;
        if (!WorkContinuation.canMorph(pathParser$PathDataNodeArr, pathParser$PathDataNodeArr2)) {
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
        if (!WorkContinuation.canMorph(this.mNodeArray, pathParser$PathDataNodeArr)) {
            this.mNodeArray = WorkContinuation.deepCopyNodes(pathParser$PathDataNodeArr);
        }
        for (int i = 0; i < pathParser$PathDataNodeArr.length; i++) {
            PathParser$PathDataNode pathParser$PathDataNode = this.mNodeArray[i];
            PathParser$PathDataNode pathParser$PathDataNode2 = pathParser$PathDataNodeArr[i];
            PathParser$PathDataNode pathParser$PathDataNode3 = pathParser$PathDataNodeArr2[i];
            pathParser$PathDataNode.getClass();
            pathParser$PathDataNode.mType = pathParser$PathDataNode2.mType;
            int i2 = 0;
            while (true) {
                float[] fArr = pathParser$PathDataNode2.mParams;
                if (i2 < fArr.length) {
                    pathParser$PathDataNode.mParams[i2] = (pathParser$PathDataNode3.mParams[i2] * f) + ((1.0f - f) * fArr[i2]);
                    i2++;
                }
            }
        }
        return this.mNodeArray;
    }
}
