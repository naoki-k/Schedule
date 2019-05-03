package com.example.workspace.schedule.presentation.home.plans;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.arch.lifecycle.ViewModelProvider;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.workspace.schedule.R;
import com.example.workspace.schedule.databinding.DialogNewPlanBinding;
import com.example.workspace.schedule.presentation.home.HomeActivity;

import java.util.Calendar;

public class NewPlanDialogFragment extends DialogFragment implements NewPlanView {
    private DialogNewPlanBinding binding;
    private NewPlanViewModel viewModel;
    private PlanCardsViewGroup viewGroup;

    private EditText titleEditText;
    private EditText startTimeEditText;
    private EditText endTimeEditText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_new_plan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = DialogNewPlanBinding.bind(view);
        viewModel = new NewPlanViewModel(this);
        binding.setViewModel(viewModel);

        titleEditText = binding.titleField;
        startTimeEditText = binding.startTimeField;
        startTimeEditText.setTag(startTimeEditText.getKeyListener());
        startTimeEditText.setKeyListener(null);
        endTimeEditText = binding.endTimeField;
        endTimeEditText.setTag(endTimeEditText.getKeyListener());
        endTimeEditText.setKeyListener(null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Dialog dialog = getDialog();
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int dialogWidth = (int) (metrics.widthPixels * 0.8);
        int dialogHeight = (int) (metrics.heightPixels * 0.5);

        lp.width = dialogWidth;
        lp.height = dialogHeight;
        dialog.getWindow().setAttributes(lp);
    }

    @Nullable
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Dialog dialog = new Dialog(getActivity(), R.style.NoDimDialogFragmentStyle);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        return dialog;
    }

    @Override
    public void onCloseClicked(View view) {
        dismiss();
    }

    @Override
    public void onOKClicked(View view) {
        PlanCardView card = new PlanCardView(getContext());
        card.setParams(titleEditText.getText().toString(), startTimeEditText.getText().toString(), endTimeEditText.getText().toString());
        HomeActivity collingActivity = (HomeActivity) getActivity();
        collingActivity.onDialogFragmentResult(card);
        dismiss();
    }

    @Override
    public void onStartTimeClicked(View view) {
        showTimePickerDialog(startTimeEditText);
    }

    @Override
    public void onEndTimeClicked(View view) {
        showTimePickerDialog(endTimeEditText);
    }

    private void showTimePickerDialog(final EditText editText) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        TimePickerDialog dialog = new TimePickerDialog(
                getContext(),
                android.R.style.Theme_Holo_Light_Dialog,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        editText.setText(String.format("%02d:%02d", hourOfDay, minute));
                    }
                },
                hour, minute, true);
        dialog.show();
    }
}
