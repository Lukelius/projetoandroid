// Generated by view binder compiler. Do not edit!
package com.example.projeto.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.projeto.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityVaccineBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final AutoCompleteTextView Vacina;

  @NonNull
  public final AutoCompleteTextView agendaVacina;

  @NonNull
  public final TextView agendamento;

  @NonNull
  public final Button buttonAgendarVacina;

  @NonNull
  public final ImageView imageView4;

  @NonNull
  public final AutoCompleteTextView petChoice;

  @NonNull
  public final TextView vaccineTxT;

  private ActivityVaccineBinding(@NonNull FrameLayout rootView,
      @NonNull AutoCompleteTextView Vacina, @NonNull AutoCompleteTextView agendaVacina,
      @NonNull TextView agendamento, @NonNull Button buttonAgendarVacina,
      @NonNull ImageView imageView4, @NonNull AutoCompleteTextView petChoice,
      @NonNull TextView vaccineTxT) {
    this.rootView = rootView;
    this.Vacina = Vacina;
    this.agendaVacina = agendaVacina;
    this.agendamento = agendamento;
    this.buttonAgendarVacina = buttonAgendarVacina;
    this.imageView4 = imageView4;
    this.petChoice = petChoice;
    this.vaccineTxT = vaccineTxT;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityVaccineBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityVaccineBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_vaccine, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityVaccineBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Vacina;
      AutoCompleteTextView Vacina = ViewBindings.findChildViewById(rootView, id);
      if (Vacina == null) {
        break missingId;
      }

      id = R.id.agendaVacina;
      AutoCompleteTextView agendaVacina = ViewBindings.findChildViewById(rootView, id);
      if (agendaVacina == null) {
        break missingId;
      }

      id = R.id.agendamento;
      TextView agendamento = ViewBindings.findChildViewById(rootView, id);
      if (agendamento == null) {
        break missingId;
      }

      id = R.id.buttonAgendarVacina;
      Button buttonAgendarVacina = ViewBindings.findChildViewById(rootView, id);
      if (buttonAgendarVacina == null) {
        break missingId;
      }

      id = R.id.imageView4;
      ImageView imageView4 = ViewBindings.findChildViewById(rootView, id);
      if (imageView4 == null) {
        break missingId;
      }

      id = R.id.petChoice;
      AutoCompleteTextView petChoice = ViewBindings.findChildViewById(rootView, id);
      if (petChoice == null) {
        break missingId;
      }

      id = R.id.vaccineTxT;
      TextView vaccineTxT = ViewBindings.findChildViewById(rootView, id);
      if (vaccineTxT == null) {
        break missingId;
      }

      return new ActivityVaccineBinding((FrameLayout) rootView, Vacina, agendaVacina, agendamento,
          buttonAgendarVacina, imageView4, petChoice, vaccineTxT);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
