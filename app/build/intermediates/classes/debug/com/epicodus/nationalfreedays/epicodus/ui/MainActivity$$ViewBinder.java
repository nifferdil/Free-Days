// Generated code from Butter Knife. Do not modify!
package com.epicodus.nationalfreedays.epicodus.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MainActivity$$ViewBinder<T extends com.epicodus.nationalfreedays.epicodus.ui.MainActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492947, "field 'mDaysButton'");
    target.mDaysButton = finder.castView(view, 2131492947, "field 'mDaysButton'");
    view = finder.findRequiredView(source, 2131492957, "field 'mAddFreeDayButton'");
    target.mAddFreeDayButton = finder.castView(view, 2131492957, "field 'mAddFreeDayButton'");
  }

  @Override public void unbind(T target) {
    target.mDaysButton = null;
    target.mAddFreeDayButton = null;
  }
}
