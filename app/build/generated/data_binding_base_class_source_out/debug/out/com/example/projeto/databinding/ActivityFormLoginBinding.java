// Generated by view binder compiler. Do not edit!
package com.example.projeto.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.projeto.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityFormLoginBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ProgressBar barra;

  @NonNull
  public final AppCompatButton buttonEntrar;

  @NonNull
  public final TextView cadastrar;

  @NonNull
  public final View components;

  @NonNull
  public final ConstraintLayout container;

  @NonNull
  public final EditText email;

  @NonNull
  public final ImageView logo;

  @NonNull
  public final EditText senha;

  private ActivityFormLoginBinding(@NonNull ConstraintLayout rootView, @NonNull ProgressBar barra,
      @NonNull AppCompatButton buttonEntrar, @NonNull TextView cadastrar, @NonNull View components,
      @NonNull ConstraintLayout container, @NonNull EditText email, @NonNull ImageView logo,
      @NonNull EditText senha) {
    this.rootView = rootView;
    this.barra = barra;
    this.buttonEntrar = buttonEntrar;
    this.cadastrar = cadastrar;
    this.components = components;
    this.container = container;
    this.email = email;
    this.logo = logo;
    this.senha = senha;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityFormLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityFormLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_form_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityFormLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.barra;
      ProgressBar barra = ViewBindings.findChildViewById(rootView, id);
      if (barra == null) {
        break missingId;
      }

      id = R.id.button_entrar;
      AppCompatButton buttonEntrar = ViewBindings.findChildViewById(rootView, id);
      if (buttonEntrar == null) {
        break missingId;
      }

      id = R.id.cadastrar;
      TextView cadastrar = ViewBindings.findChildViewById(rootView, id);
      if (cadastrar == null) {
        break missingId;
      }

      id = R.id.components;
      View components = ViewBindings.findChildViewById(rootView, id);
      if (components == null) {
        break missingId;
      }

      ConstraintLayout container = (ConstraintLayout) rootView;

      id = R.id.email;
      EditText email = ViewBindings.findChildViewById(rootView, id);
      if (email == null) {
        break missingId;
      }

      id = R.id.logo;
      ImageView logo = ViewBindings.findChildViewById(rootView, id);
      if (logo == null) {
        break missingId;
      }

      id = R.id.senha;
      EditText senha = ViewBindings.findChildViewById(rootView, id);
      if (senha == null) {
        break missingId;
      }

      return new ActivityFormLoginBinding((ConstraintLayout) rootView, barra, buttonEntrar,
          cadastrar, components, container, email, logo, senha);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}