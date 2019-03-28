package com.example.readingdemo.testPicker;

import android.view.Gravity;
import com.example.readingdemo.R;

/**
 * Created by yuzhiqi on 2019/03/25
 *
 * @author 于治麒 yuzhiqi@bytedance.com
 */
public class PickerViewAnimateUtil {

    private static final int INVALID = -1;
    /**
     * Get default animation resource when not defined by the user
     *
     * @param gravity       the gravity of the dialog
     * @param isInAnimation determine if is in or out animation. true when is is
     * @return the id of the animation resource
     */
    public static int getAnimationResource(int gravity, boolean isInAnimation) {
        switch (gravity) {
            case Gravity.BOTTOM:
                return isInAnimation ? R.anim.pickerview_slide_in_bottom : R.anim.pickerview_slide_out_bottom;
        }
        return INVALID;
    }
}
