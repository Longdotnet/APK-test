package com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1;

import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface ActionDataOrBuilder extends MessageOrBuilder {
    ActionData.ActionDetailCase getActionDetailCase();

    Blocking getBlocking();

    BlockingOrBuilder getBlockingOrBuilder();

    Receive getReceive();

    ReceiveOrBuilder getReceiveOrBuilder();

    Serve getServe();

    ServeOrBuilder getServeOrBuilder();

    Sliding getSliding();

    SlidingOrBuilder getSlidingOrBuilder();

    Spike getSpike();

    SpikeOrBuilder getSpikeOrBuilder();

    Toss getToss();

    TossOrBuilder getTossOrBuilder();

    boolean hasBlocking();

    boolean hasReceive();

    boolean hasServe();

    boolean hasSliding();

    boolean hasSpike();

    boolean hasToss();
}
