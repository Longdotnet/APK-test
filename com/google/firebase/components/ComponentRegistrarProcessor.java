package com.google.firebase.components;

import androidx.core.view.DifferentialMotionFlingController$$ExternalSyntheticLambda0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ComponentRegistrarProcessor {
    public static final ComponentRegistrarProcessor NOOP = new DifferentialMotionFlingController$$ExternalSyntheticLambda0(25);

    List<Component<?>> processRegistrar(ComponentRegistrar componentRegistrar);
}
