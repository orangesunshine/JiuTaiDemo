package com.jiutai.demo.bean;

public class ReportEntity {
    private String role;
    private int noteCount;
    private float profitOrLoss;//盈亏
    private float lotteryBetting;//彩票投注
    private float win;//中奖
    private float rebate;//返点

    public ReportEntity() {
    }

    public ReportEntity(String role, int noteCount, float profitOrLoss, float lotteryBetting, float win, float rebate) {
        this.role = role;
        this.noteCount = noteCount;
        this.profitOrLoss = profitOrLoss;
        this.lotteryBetting = lotteryBetting;
        this.win = win;
        this.rebate = rebate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getNoteCount() {
        return noteCount;
    }

    public void setNoteCount(int noteCount) {
        this.noteCount = noteCount;
    }

    public float getProfitOrLoss() {
        return profitOrLoss;
    }

    public void setProfitOrLoss(float profitOrLoss) {
        this.profitOrLoss = profitOrLoss;
    }

    public float getLotteryBetting() {
        return lotteryBetting;
    }

    public void setLotteryBetting(float lotteryBetting) {
        this.lotteryBetting = lotteryBetting;
    }

    public float getWin() {
        return win;
    }

    public void setWin(float win) {
        this.win = win;
    }

    public float getRebate() {
        return rebate;
    }

    public void setRebate(float rebate) {
        this.rebate = rebate;
    }

    @Override
    public String toString() {
        return "ReportEntity{" +
                "role='" + role + '\'' +
                ", noteCount=" + noteCount +
                ", profitOrLoss=" + profitOrLoss +
                ", lotteryBetting=" + lotteryBetting +
                ", win=" + win +
                ", rebate=" + rebate +
                '}';
    }
}
