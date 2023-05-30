package com.example.countries;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;


public class DialogBox extends DialogFragment {

    private DialogBoxListener listener;
    private DataViewModel mViewModel;
    private EditText editname;
    private String continent;

    public DialogBox() {
        // Empty constructor required for DialogFragment
    }

    public DialogBox(String Continent, DataViewModel mymodel){      //gets values if a record is clicked on
        continent = Continent;
        mViewModel = mymodel;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = LayoutInflater.from(requireActivity());
        View myView = inflater.inflate(R.layout.fragment_dialog_box, null);

        editname = (EditText) myView.findViewById(R.id.NameField);
        editname.requestFocus();
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(requireActivity(), androidx.appcompat.R.style.ThemeOverlay_AppCompat_Dialog));
        builder.setView(myView).setTitle("Country");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                String Name = editname.getText().toString();            //gets dialog box values
                mViewModel.add(Name, continent);
                dismiss();
            }
        });
        builder.setCancelable(true);

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {         //when cancel button is pressed to stop editing
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dismiss();
            }
        });

        Dialog dialog = builder.create();
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        return dialog;
    }


    public interface DialogBoxListener {
        void onFinishEditDialog(String inputText);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (DialogBoxListener) requireActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(requireActivity().toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}