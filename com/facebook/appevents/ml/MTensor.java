package com.facebook.appevents.ml;

/* JADX INFO: loaded from: classes.dex */
public final class MTensor {
    public int capacity;
    public float[] data;
    public int[] shape;

    public MTensor(int[] iArr) {
        this.shape = iArr;
        int iAccess$getCapacity = Utils.access$getCapacity(iArr);
        this.capacity = iAccess$getCapacity;
        this.data = new float[iAccess$getCapacity];
    }
}
