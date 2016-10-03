package com.socialmobile.phoneshopping.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;

import com.socialmobile.phoneshopping.R;

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
        return inflater.inflate(R.layout.accept_tnc, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        WebView tncView = (WebView) view.findViewById(R.id.tnc_web_view);
        tncView.loadUrl("http://www.google.com");

        Button acceptButton = (Button) view.findViewById(R.id.tnc_accept_btn);
        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onTNCActionPerformed(AcceptTNCResult.ACCEPT);
            }
        });

        Button rejectButton = (Button) view.findViewById(R.id.tnc_reject_btn);
        rejectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onTNCActionPerformed(AcceptTNCResult.REJECT);
            }
        });
    }
}
