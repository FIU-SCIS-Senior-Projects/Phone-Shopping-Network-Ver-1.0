package com.socialmobile.phoneshopping.fragments;

import android.support.v4.app.Fragment;

import com.socialmobile.phoneshopping.model.ActionResult;
import com.socialmobile.phoneshopping.model.DefaultActionResult;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */


public abstract class FragmentBase<T> extends Fragment {

    protected ActionListener<T> mActionCallback;
    private int mActionId;

    public ActionListener<T> getActionCallback() {
        return mActionCallback;
    }

    public void setActionCallback(final int pActionId, final ActionListener<T> pActionCallback) {
        mActionId = pActionId;
        mActionCallback = pActionCallback;
    }

    public interface ActionListener<T> {
        void onActionPerformed(final int pId, final ActionResult<T> pResult);
    }

    protected void sendActionResult(final T pResultObject) {
        mActionCallback.onActionPerformed(mActionId, DefaultActionResult.of(pResultObject));
    }
}
