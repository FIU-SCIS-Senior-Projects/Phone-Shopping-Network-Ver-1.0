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
    private static String data = "<html>\n" +
            "<head>\n" +
            "<title>Phone Shopping</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "<div style=\"max-width: 400px; margin: 10 auto;\">\n" +
            "    <h1 style=\"width: 100%; margin: 20px 0 40px 0;\"><span style=\"margin: 0 auto;\">Phone Shopping App</span></h1>\n" +
            "    <div>To use this application you mucs accept the <a href=\"#\">terms and conditions</a> and <a href=\"#\">privacy policy</a> of <b>Social Mobile USA</b></div>\n" +
            "</div>\n" +
            "</body>\n" +
            "</html>";

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
        tncView.loadData(data, "text/html", "UTF-8");
//        tncView.loadUrl("http://www.google.com");

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
