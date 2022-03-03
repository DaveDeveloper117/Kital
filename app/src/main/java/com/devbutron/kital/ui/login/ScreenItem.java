package com.devbutron.kital.ui.login;

public class ScreenItem {

    String Title,Description;
    int ScreenImg, ScreenIcon;

    public ScreenItem(String title, String description, int screenImg, int screenIcon) {
        Title = title;
        Description = description;
        ScreenImg = screenImg;
        ScreenIcon = screenIcon;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setScreenImg(int screenImg) {
        ScreenImg = screenImg;
    }

    public void setScreenIcon(int screenIcon){
        ScreenIcon = screenIcon;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public int getScreenImg() {
        return ScreenImg;
    }

    public int getScreenIcon() {
        return ScreenIcon;
    }
}
