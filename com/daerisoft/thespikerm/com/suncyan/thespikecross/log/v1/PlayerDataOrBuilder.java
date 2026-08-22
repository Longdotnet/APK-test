package com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1;

import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface PlayerDataOrBuilder extends MessageOrBuilder {
    boolean getIsEpd();

    boolean getIsOnFloor();

    boolean getIsSlide();

    int getPlayerId();

    PlayerPhysData getPlayerPhysData();

    PlayerPhysDataOrBuilder getPlayerPhysDataOrBuilder();

    PlayerStatusData getPlayerStatusData();

    PlayerStatusDataOrBuilder getPlayerStatusDataOrBuilder();

    int getPlayerTeam();

    int getUserPlayerId();

    boolean hasPlayerPhysData();

    boolean hasPlayerStatusData();
}
