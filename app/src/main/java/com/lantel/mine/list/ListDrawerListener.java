package com.lantel.mine.list;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;

public class ListDrawerListener extends DrawerLayout.SimpleDrawerListener {
    @Override
    public void onDrawerOpened(View drawerView) {
        super.onDrawerOpened(drawerView);
    }

    @Override
    public void onDrawerClosed(View drawerView) {
        super.onDrawerClosed(drawerView);
    }

   /* *//**
     * 当抽屉被滑动的时候调用此方法
     * arg1 表示 滑动的幅度（0-1）
     *//*
    @Override
    public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

    }

    *//**
     * 当一个抽屉被完全打开的时候被调用
     *//*
    @Override
    public void onDrawerOpened(@NonNull View drawerView) {

    }

    *//**
     * 当一个抽屉被完全关闭的时候被调用
     *//*
    @Override
    public void onDrawerClosed(@NonNull View drawerView) {

    }

    *//**
     * 当抽屉滑动状态改变的时候被调用
     * 状态值是STATE_IDLE（闲置--0）, STATE_DRAGGING（拖拽的--1）, STATE_SETTLING（固定--2）中之一。
     * 抽屉打开的时候，点击抽屉，drawer的状态就会变成STATE_DRAGGING，然后变成STATE_IDLE
     *//*
    @Override
    public void onDrawerStateChanged(int newState) {

    }*/
}
