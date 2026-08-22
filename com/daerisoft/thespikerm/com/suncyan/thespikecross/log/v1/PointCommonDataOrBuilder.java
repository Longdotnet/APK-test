package com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1;

import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface PointCommonDataOrBuilder extends MessageOrBuilder {
    int getContinuousServeAce();

    LeftTeamData getLeftTeamData();

    LeftTeamDataOrBuilder getLeftTeamDataOrBuilder();

    PlayerData getPointPlayerData();

    PlayerDataOrBuilder getPointPlayerDataOrBuilder();

    PointType getPointType();

    int getPointTypeValue();

    RightTeamData getRightTeamData();

    RightTeamDataOrBuilder getRightTeamDataOrBuilder();

    int getTotalTouchCount();

    boolean hasLeftTeamData();

    boolean hasPointPlayerData();

    boolean hasRightTeamData();
}
