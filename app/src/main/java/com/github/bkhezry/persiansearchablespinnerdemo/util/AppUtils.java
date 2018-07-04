package com.github.bkhezry.persiansearchablespinnerdemo.util;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.github.bkhezry.searchablespinner.tools.UITools;

public class AppUtils {

  public static TextDrawable getTextDrawable(Context context, String displayName, Typeface typeface) {
    TextDrawable drawable = null;
    if (!TextUtils.isEmpty(displayName)) {
      int color2 = ColorGenerator.MATERIAL.getColor(displayName);
      drawable = TextDrawable.builder()
        .beginConfig()
        .useFont(typeface)
        .width(UITools.dpToPx(context, 32))
        .height(UITools.dpToPx(context, 32))
        .textColor(Color.WHITE)
        .toUpperCase()
        .endConfig()
        .round()
        .build(displayName.substring(0, 1), color2);
    } else {
      drawable = TextDrawable.builder()
        .beginConfig()
        .useFont(typeface)
        .width(UITools.dpToPx(context, 32))
        .height(UITools.dpToPx(context, 32))
        .endConfig()
        .round()
        .build("?", Color.GRAY);
    }
    return drawable;
  }
}
