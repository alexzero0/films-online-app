// Generated by view binder compiler. Do not edit!
package com.example.myapptwo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import com.example.myapptwo.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentGalleryBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout mainFilmG;

  @NonNull
  public final RecyclerView myrecyclegal;

  @NonNull
  public final SwipeRefreshLayout swipeToRefreshgalG;

  private FragmentGalleryBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout mainFilmG, @NonNull RecyclerView myrecyclegal,
      @NonNull SwipeRefreshLayout swipeToRefreshgalG) {
    this.rootView = rootView;
    this.mainFilmG = mainFilmG;
    this.myrecyclegal = myrecyclegal;
    this.swipeToRefreshgalG = swipeToRefreshgalG;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentGalleryBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentGalleryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_gallery, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentGalleryBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      ConstraintLayout mainFilmG = (ConstraintLayout) rootView;

      id = R.id.myrecyclegal;
      RecyclerView myrecyclegal = rootView.findViewById(id);
      if (myrecyclegal == null) {
        break missingId;
      }

      id = R.id.swipeToRefreshgalG;
      SwipeRefreshLayout swipeToRefreshgalG = rootView.findViewById(id);
      if (swipeToRefreshgalG == null) {
        break missingId;
      }

      return new FragmentGalleryBinding((ConstraintLayout) rootView, mainFilmG, myrecyclegal,
          swipeToRefreshgalG);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
