package com.socialmobile.phoneshopping.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 *
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
public class TNCFragment extends Fragment {

    private ActionListener mCallback;

    public enum AcceptTNCResult {
        ACCEPT,
        REJECT
    }

    public interface ActionListener {
        void onTNCActionPerformed(final AcceptTNCResult pResult);
    }

    public ActionListener getCallback() {
        return mCallback;
    }

    public void setCallback(ActionListener mCallback) {
        this.mCallback = mCallback;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(android.R.layout.accept_tnc, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button acceptButton = getActivity().findViewById(android.R.id.tnc_accept_btn);
        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onTNCActionPerformed(AcceptTNCResult.ACCEPT);
            }
        });

        Button rejectButton = getActivity().findViewById(android.R.id.tnc_reject_btn);
        rejectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onTNCActionPerformed(AcceptTNCResult.REJECT);
            }
        });
    }
}
