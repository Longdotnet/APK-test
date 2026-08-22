package com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface ActionLogOrBuilder extends MessageOrBuilder {
    ActionCommonData getActionCommon();

    ActionCommonDataOrBuilder getActionCommonOrBuilder();

    ActionData getActionData();

    ActionDataOrBuilder getActionDataOrBuilder();

    String getActionLogType();

    ByteString getActionLogTypeBytes();

    boolean hasActionCommon();

    boolean hasActionData();
}
