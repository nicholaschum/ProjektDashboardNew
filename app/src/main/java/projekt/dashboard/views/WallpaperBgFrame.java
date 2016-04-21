package projekt.dashboard.views;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import projekt.dashboard.util.WallpaperUtils;

/**
 * @author Aidan Follestad (afollestad)
 */
public class WallpaperBgFrame extends LinearLayout {

    private WallpaperUtils.Wallpaper mWallpaper;

    public WallpaperBgFrame(Context context) {
        super(context);
    }

    public WallpaperBgFrame(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WallpaperBgFrame(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setWallpaper(WallpaperUtils.Wallpaper wallpaper) {
        mWallpaper = wallpaper;
    }

    @Override
    public void setBackgroundColor(@ColorInt int color) {
        setBackgroundColor(color, true);
    }

    public void setBackgroundColor(@ColorInt int color, boolean cache) {
        super.setBackgroundColor(color);
        ViewGroup parent = (ViewGroup) getParent();
        CardView card = (CardView) parent.getParent();
        card.setCardBackgroundColor(color);
        if (cache && mWallpaper != null)
            mWallpaper.setPaletteBgColor(color);
    }
}
