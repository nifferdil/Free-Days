// Generated code from Butter Knife. Do not modify!
package com.epicodus.nationalfreedays.epicodus.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class RegisterActivity$$ViewBinder<T extends com.epicodus.nationalfreedays.epicodus.ui.RegisterActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492963, "field 'mLoginButton'");
    target.mLoginButton = finder.castView(view, 2131492963, "field 'mLoginButton'");
    view = finder.findRequiredView(source, 2131492964, "field 'mUserName'");
    target.mUserName = finder.castView(view, 2131492964, "field 'mUserName'");
  }

  @Override public void unbind(T target) {
    target.mLoginButton = null;
    target.mUserName = null;
  }
}
