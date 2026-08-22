package com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1;

import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface BallDataOrBuilder extends MessageOrBuilder {
    BallPhysData getBallPhysData();

    BallPhysDataOrBuilder getBallPhysDataOrBuilder();

    BallState getBallState();

    int getBallStateValue();

    boolean hasBallPhysData();
}
