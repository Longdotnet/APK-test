package com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1;

import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface ActionCommonDataOrBuilder extends MessageOrBuilder {
    AfterLog getAfterLog();

    AfterLogOrBuilder getAfterLogOrBuilder();

    PreviousLog getPreviousLog();

    PreviousLogOrBuilder getPreviousLogOrBuilder();

    int getTriggerTouchCount();

    boolean hasAfterLog();

    boolean hasPreviousLog();
}
