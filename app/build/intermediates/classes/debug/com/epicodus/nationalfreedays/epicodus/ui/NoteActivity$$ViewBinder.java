// Generated code from Butter Knife. Do not modify!
package com.epicodus.nationalfreedays.epicodus.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class NoteActivity$$ViewBinder<T extends com.epicodus.nationalfreedays.epicodus.ui.NoteActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492962, "field 'mNewCategoryButton'");
    target.mNewCategoryButton = finder.castView(view, 2131492962, "field 'mNewCategoryButton'");
    view = finder.findRequiredView(source, 2131492945, "field 'mNewCategoryText'");
    target.mNewCategoryText = finder.castView(view, 2131492945, "field 'mNewCategoryText'");
  }

  @Override public void unbind(T target) {
    target.mNewCategoryButton = null;
    target.mNewCategoryText = null;
  }
}
