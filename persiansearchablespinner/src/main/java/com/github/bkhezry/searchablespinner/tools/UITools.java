package com.github.bkhezry.searchablespinner.tools;

import android.content.Context;
import android.os.Build;

public class UITools {

  private UITools() {
  }

  public static int dpToPx(Context context, float dp) {
    final float scale = context.getResources().getDisplayMetrics().density;
    return Math.round(dp * scale);
  }

  public static boolean isLollipopOrHigher() {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
  }
}
