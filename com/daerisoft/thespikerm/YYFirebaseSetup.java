package com.daerisoft.thespikerm;

import android.app.Activity;
import androidx.core.provider.RequestExecutor$DefaultThreadFactory;
import com.yoyogames.runner.RunnerJNILib;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class YYFirebaseSetup extends RunnerSocial {
    public static final int EVENT_OTHER_SOCIAL = 70;
    public static Activity activity = RunnerActivity.CurrentActivity;
    public ExecutorService executorService;
    public int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
    public int KEEP_ALIVE_TIME = 250;
    public TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.MILLISECONDS;
    public BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue();

    public YYFirebaseSetup() {
        int i = this.NUMBER_OF_CORES;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i * 2, this.KEEP_ALIVE_TIME, this.KEEP_ALIVE_TIME_UNIT, this.taskQueue, new RequestExecutor$DefaultThreadFactory(1));
        this.executorService = threadPoolExecutor;
        threadPoolExecutor.execute(new RunnerJNILib.AnonymousClass1(9));
    }
}
