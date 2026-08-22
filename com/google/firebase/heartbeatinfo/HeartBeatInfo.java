package com.google.firebase.heartbeatinfo;

/* JADX INFO: loaded from: classes.dex */
public interface HeartBeatInfo {

    /* JADX INFO: loaded from: classes2.dex */
    public enum HeartBeat {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);

        private final int code;

        HeartBeat(int i) {
            this.code = i;
        }

        public int getCode() {
            return this.code;
        }
    }

    HeartBeat getHeartBeatCode(String str);
}
