// Generated by view binder compiler. Do not edit!
package com.example.myapptwo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.example.myapptwo.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CustomViewBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView imagePoster;

  @NonNull
  public final TextView nameFilm;

  @NonNull
  public final TextView nameStile;

  @NonNull
  public final TextView nameYear;

  private CustomViewBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView imagePoster,
      @NonNull TextView nameFilm, @NonNull TextView nameStile, @NonNull TextView nameYear) {
    this.rootView = rootView;
    this.imagePoster = imagePoster;
    this.nameFilm = nameFilm;
    this.nameStile = nameStile;
    this.nameYear = nameYear;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static CustomViewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CustomViewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.custom_view, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CustomViewBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imagePoster;
      ImageView imagePoster = rootView.findViewById(id);
      if (imagePoster == null) {
        break missingId;
      }

      id = R.id.nameFilm;
      TextView nameFilm = rootView.findViewById(id);
      if (nameFilm == null) {
        break missingId;
      }

      id = R.id.nameStile;
      TextView nameStile = rootView.findViewById(id);
      if (nameStile == null) {
        break missingId;
      }

      id = R.id.nameYear;
      TextView nameYear = rootView.findViewById(id);
      if (nameYear == null) {
        break missingId;
      }

      return new CustomViewBinding((ConstraintLayout) rootView, imagePoster, nameFilm, nameStile,
          nameYear);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
