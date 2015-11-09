// Generated code from Butter Knife. Do not modify!
package com.epicodus.nationalfreedays.epicodus.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class FreeDaysActivity$$ViewBinder<T extends com.epicodus.nationalfreedays.epicodus.ui.FreeDaysActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492950, "field 'mNameLabel'");
    target.mNameLabel = finder.castView(view, 2131492950, "field 'mNameLabel'");
    view = finder.findRequiredView(source, 2131492951, "field 'mDateLabel'");
    target.mDateLabel = finder.castView(view, 2131492951, "field 'mDateLabel'");
    view = finder.findRequiredView(source, 2131492952, "field 'mDescriptionLabel'");
    target.mDescriptionLabel = finder.castView(view, 2131492952, "field 'mDescriptionLabel'");
    view = finder.findRequiredView(source, 2131492953, "field 'mWebsiteLabel'");
    target.mWebsiteLabel = finder.castView(view, 2131492953, "field 'mWebsiteLabel'");
    view = finder.findRequiredView(source, 2131492948, "field 'mNextButton'");
    target.mNextButton = finder.castView(view, 2131492948, "field 'mNextButton'");
    view = finder.findRequiredView(source, 2131492949, "field 'mAddNote'");
    target.mAddNote = finder.castView(view, 2131492949, "field 'mAddNote'");
  }

  @Override public void unbind(T target) {
    target.mNameLabel = null;
    target.mDateLabel = null;
    target.mDescriptionLabel = null;
    target.mWebsiteLabel = null;
    target.mNextButton = null;
    target.mAddNote = null;
  }
}
