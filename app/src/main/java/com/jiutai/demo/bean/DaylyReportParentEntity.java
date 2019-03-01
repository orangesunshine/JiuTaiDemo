package com.jiutai.demo.bean;

import java.util.List;

public class DaylyReportParentEntity {
    private String dayTime;
    private int noteCount;
    private int consumeRmb;
    private float profitLoss;
    private List<DaylyReportSubEntity> mSubs;

    public String getDayTime() {
        return dayTime;
    }

    public void setDayTime(String dayTime) {
        this.dayTime = dayTime;
    }

    public int getNoteCount() {
        return noteCount;
    }

    public void setNoteCount(int noteCount) {
        this.noteCount = noteCount;
    }

    public int getConsumeRmb() {
        return consumeRmb;
    }

    public void setConsumeRmb(int consumeRmb) {
        this.consumeRmb = consumeRmb;
    }

    public float getProfitLoss() {
        return profitLoss;
    }

    public void setProfitLoss(float profitLoss) {
        this.profitLoss = profitLoss;
    }

    public List<DaylyReportSubEntity> getmSubs() {
        return mSubs;
    }

    public void setmSubs(List<DaylyReportSubEntity> mSubs) {
        this.mSubs = mSubs;
    }

    public DaylyReportParentEntity(String dayTime, int noteCount, int consumeRmb, float profitLoss, List<DaylyReportSubEntity> mSubs) {
        this.dayTime = dayTime;
        this.noteCount = noteCount;
        this.consumeRmb = consumeRmb;
        this.profitLoss = profitLoss;
        this.mSubs = mSubs;
    }

    public static class DaylyReportSubEntity
    {
        private String LotteryName;
        private float profitLoss;
        private int winNoteCount;
        private int rebate;

        public String getLotteryName() {
            return LotteryName;
        }

        public void setLotteryName(String lotteryName) {
            LotteryName = lotteryName;
        }

        public float getProfitLoss() {
            return profitLoss;
        }

        public void setProfitLoss(float profitLoss) {
            this.profitLoss = profitLoss;
        }

        public int getWinNoteCount() {
            return winNoteCount;
        }

        public void setWinNoteCount(int winNoteCount) {
            this.winNoteCount = winNoteCount;
        }

        public int getRebate() {
            return rebate;
        }

        public void setRebate(int rebate) {
            this.rebate = rebate;
        }

        public DaylyReportSubEntity(String lotteryName, float profitLoss, int winNoteCount, int rebate) {
            LotteryName = lotteryName;
            this.profitLoss = profitLoss;
            this.winNoteCount = winNoteCount;
            this.rebate = rebate;
        }
    }
}
