package com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1;

import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface PreviousLogOrBuilder extends MessageOrBuilder {
    BallData getBallData();

    BallDataOrBuilder getBallDataOrBuilder();

    float getEnemyHp();

    PlayerData getLastTouchPlayerData();

    PlayerDataOrBuilder getLastTouchPlayerDataOrBuilder();

    float getTeamHp();

    PlayerData getTriggerPlayerData();

    PlayerDataOrBuilder getTriggerPlayerDataOrBuilder();

    boolean hasBallData();

    boolean hasLastTouchPlayerData();

    boolean hasTriggerPlayerData();
}
