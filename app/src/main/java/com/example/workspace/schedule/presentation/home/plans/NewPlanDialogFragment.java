package com.example.workspace.schedule.presentation.home.plans;

import android.app.Dialog;
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

import com.example.workspace.schedule.R;
import com.example.workspace.schedule.databinding.DialogNewPlanBinding;
import com.example.workspace.schedule.presentation.home.HomeActivity;

public class NewPlanDialogFragment extends DialogFragment implements NewPlanView {
    private DialogNewPlanBinding binding;
    private NewPlanViewModel viewModel;
    private PlanCardsViewGroup viewGroup;

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
        card.setParams("Sample", "01:00", "02:00");
        HomeActivity collingActivity = (HomeActivity) getActivity();
        collingActivity.onDialogFragmentResult(card);
        dismiss();
    }
}
