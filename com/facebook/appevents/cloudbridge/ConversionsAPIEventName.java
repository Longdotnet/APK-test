package com.facebook.appevents.cloudbridge;

import java.util.Arrays;
import okhttp3.internal.concurrent.onZL.mnwSv;

/* JADX INFO: loaded from: classes2.dex */
public enum ConversionsAPIEventName {
    UNLOCKED_ACHIEVEMENT("AchievementUnlocked"),
    ACTIVATED_APP("ActivateApp"),
    ADDED_PAYMENT_INFO("AddPaymentInfo"),
    ADDED_TO_CART("AddToCart"),
    ADDED_TO_WISHLIST("AddToWishlist"),
    COMPLETED_REGISTRATION("CompleteRegistration"),
    VIEWED_CONTENT("ViewContent"),
    INITIATED_CHECKOUT(mnwSv.iHC),
    ACHIEVED_LEVEL("LevelAchieved"),
    PURCHASED("Purchase"),
    RATED("Rate"),
    SEARCHED("Search"),
    SPENT_CREDITS("SpentCredits"),
    COMPLETED_TUTORIAL("TutorialCompletion");

    public final String rawValue;

    ConversionsAPIEventName(String str) {
        this.rawValue = str;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static ConversionsAPIEventName[] valuesCustom() {
        return (ConversionsAPIEventName[]) Arrays.copyOf(values(), 14);
    }
}
