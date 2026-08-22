package com.facebook.appevents.ml;

import com.daerisoft.thespikerm.GamepadHandler_API19;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.android.finsky.externalreferrer.jUdg.RDFWIi;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;

/* JADX INFO: loaded from: classes2.dex */
public final class Model {
    public static final HashMap mapping = MapsKt__MapsKt.hashMapOf(new Pair("embedding.weight", "embed.weight"), new Pair("dense1.weight", "fc1.weight"), new Pair("dense2.weight", "fc2.weight"), new Pair("dense3.weight", "fc3.weight"), new Pair("dense1.bias", RDFWIi.DChAJKe), new Pair("dense2.bias", "fc2.bias"), new Pair("dense3.bias", "fc3.bias"));
    public final MTensor convs0Bias;
    public final MTensor convs0Weight;
    public final MTensor convs1Bias;
    public final MTensor convs1Weight;
    public final MTensor convs2Bias;
    public final MTensor convs2Weight;
    public final MTensor embedding;
    public final MTensor fc1Bias;
    public final MTensor fc1Weight;
    public final MTensor fc2Bias;
    public final MTensor fc2Weight;
    public final HashMap finalWeights;

    public Model(HashMap map) {
        Object obj = map.get("embed.weight");
        if (obj == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.embedding = (MTensor) obj;
        Object obj2 = map.get("convs.0.weight");
        if (obj2 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.convs0Weight = MediaType.Companion.transpose3D((MTensor) obj2);
        Object obj3 = map.get("convs.1.weight");
        if (obj3 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.convs1Weight = MediaType.Companion.transpose3D((MTensor) obj3);
        Object obj4 = map.get("convs.2.weight");
        if (obj4 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.convs2Weight = MediaType.Companion.transpose3D((MTensor) obj4);
        Object obj5 = map.get("convs.0.bias");
        if (obj5 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.convs0Bias = (MTensor) obj5;
        Object obj6 = map.get("convs.1.bias");
        if (obj6 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.convs1Bias = (MTensor) obj6;
        Object obj7 = map.get("convs.2.bias");
        if (obj7 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.convs2Bias = (MTensor) obj7;
        Object obj8 = map.get("fc1.weight");
        if (obj8 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.fc1Weight = MediaType.Companion.transpose2D((MTensor) obj8);
        Object obj9 = map.get("fc2.weight");
        if (obj9 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.fc2Weight = MediaType.Companion.transpose2D((MTensor) obj9);
        Object obj10 = map.get("fc1.bias");
        if (obj10 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.fc1Bias = (MTensor) obj10;
        Object obj11 = map.get("fc2.bias");
        if (obj11 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.fc2Bias = (MTensor) obj11;
        this.finalWeights = new HashMap();
        for (String str : GamepadHandler_API19.setOf(ModelManager.Task.MTML_INTEGRITY_DETECT.toKey(), ModelManager.Task.MTML_APP_EVENT_PREDICTION.toKey())) {
            String strStringPlus = Intrinsics.stringPlus(".weight", str);
            String strStringPlus2 = Intrinsics.stringPlus(".bias", str);
            MTensor mTensor = (MTensor) map.get(strStringPlus);
            MTensor mTensor2 = (MTensor) map.get(strStringPlus2);
            if (mTensor != null) {
                this.finalWeights.put(strStringPlus, MediaType.Companion.transpose2D(mTensor));
            }
            if (mTensor2 != null) {
                this.finalWeights.put(strStringPlus2, mTensor2);
            }
        }
    }

    public final MTensor predictOnMTML(MTensor mTensor, String[] strArr, String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            MTensor mTensorConv1D = MediaType.Companion.conv1D(MediaType.Companion.embedding(strArr, this.embedding), this.convs0Weight);
            MediaType.Companion.addmv(mTensorConv1D, this.convs0Bias);
            MediaType.Companion.relu(mTensorConv1D);
            MTensor mTensorConv1D2 = MediaType.Companion.conv1D(mTensorConv1D, this.convs1Weight);
            MediaType.Companion.addmv(mTensorConv1D2, this.convs1Bias);
            MediaType.Companion.relu(mTensorConv1D2);
            MTensor mTensorMaxPool1D = MediaType.Companion.maxPool1D(mTensorConv1D2, 2);
            MTensor mTensorConv1D3 = MediaType.Companion.conv1D(mTensorMaxPool1D, this.convs2Weight);
            MediaType.Companion.addmv(mTensorConv1D3, this.convs2Bias);
            MediaType.Companion.relu(mTensorConv1D3);
            MTensor mTensorMaxPool1D2 = MediaType.Companion.maxPool1D(mTensorConv1D, mTensorConv1D.shape[1]);
            MTensor mTensorMaxPool1D3 = MediaType.Companion.maxPool1D(mTensorMaxPool1D, mTensorMaxPool1D.shape[1]);
            MTensor mTensorMaxPool1D4 = MediaType.Companion.maxPool1D(mTensorConv1D3, mTensorConv1D3.shape[1]);
            MediaType.Companion.flatten(mTensorMaxPool1D2);
            MediaType.Companion.flatten(mTensorMaxPool1D3);
            MediaType.Companion.flatten(mTensorMaxPool1D4);
            MTensor mTensorDense = MediaType.Companion.dense(MediaType.Companion.concatenate(new MTensor[]{mTensorMaxPool1D2, mTensorMaxPool1D3, mTensorMaxPool1D4, mTensor}), this.fc1Weight, this.fc1Bias);
            MediaType.Companion.relu(mTensorDense);
            MTensor mTensorDense2 = MediaType.Companion.dense(mTensorDense, this.fc2Weight, this.fc2Bias);
            MediaType.Companion.relu(mTensorDense2);
            HashMap map = this.finalWeights;
            MTensor mTensor2 = (MTensor) map.get(Intrinsics.stringPlus(".weight", str));
            MTensor mTensor3 = (MTensor) map.get(Intrinsics.stringPlus(".bias", str));
            if (mTensor2 != null && mTensor3 != null) {
                MTensor mTensorDense3 = MediaType.Companion.dense(mTensorDense2, mTensor2, mTensor3);
                MediaType.Companion.softmax(mTensorDense3);
                return mTensorDense3;
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return null;
        }
    }
}
