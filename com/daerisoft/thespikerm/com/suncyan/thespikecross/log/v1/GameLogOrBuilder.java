package com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface GameLogOrBuilder extends MessageOrBuilder {
    ActionLog getActionLog();

    ActionLogOrBuilder getActionLogOrBuilder();

    String getCategory();

    ByteString getCategoryBytes();

    GameLog.DataCase getDataCase();

    int getElapsedTime();

    int getFrame();

    PointLog getPointLog();

    PointLogOrBuilder getPointLogOrBuilder();

    boolean hasActionLog();

    boolean hasPointLog();
}
