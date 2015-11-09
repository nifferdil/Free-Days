// Generated code from Butter Knife. Do not modify!
package com.epicodus.nationalfreedays.epicodus.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class CategoryActivity$$ViewBinder<T extends com.epicodus.nationalfreedays.epicodus.ui.CategoryActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492945, "field 'mNewNoteButton'");
    target.mNewNoteButton = finder.castView(view, 2131492945, "field 'mNewNoteButton'");
    view = finder.findRequiredView(source, 2131492946, "field 'mDaysButton'");
    target.mDaysButton = finder.castView(view, 2131492946, "field 'mDaysButton'");
    view = finder.findRequiredView(source, 2131492944, "field 'mNewNoteText'");
    target.mNewNoteText = finder.castView(view, 2131492944, "field 'mNewNoteText'");
  }

  @Override public void unbind(T target) {
    target.mNewNoteButton = null;
    target.mDaysButton = null;
    target.mNewNoteText = null;
  }
}
