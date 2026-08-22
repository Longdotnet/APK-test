package com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Struct;
import com.google.protobuf.StructOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface GameLogDatasetOrBuilder extends MessageOrBuilder {
    String getClientVersion();

    ByteString getClientVersionBytes();

    long getEndAt();

    int getLength();

    GameLog getLogs(int i);

    int getLogsCount();

    List<GameLog> getLogsList();

    GameLogOrBuilder getLogsOrBuilder(int i);

    List<? extends GameLogOrBuilder> getLogsOrBuilderList();

    Struct getMeta();

    StructOrBuilder getMetaOrBuilder();

    int getStageId();

    long getStartAt();

    String getVersion();

    ByteString getVersionBytes();

    boolean hasMeta();
}
