package com.socialmobile.phoneshopping.model;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */


public final class DefaultActionResult<T> implements ActionResult<T> {

    private final T mResult;

    private DefaultActionResult(final T pResult) {
        mResult = pResult;
    }

    public static <T>DefaultActionResult<T> of(final T pResult) {
        return new DefaultActionResult<>(pResult);
    }

    public static <T> DefaultActionResult<T> empty() {
        return new DefaultActionResult<>(null);
    }


    @Override
    public T get() {
        return mResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DefaultActionResult<T> that = (DefaultActionResult<T>) o;

        return mResult.equals(that.mResult);

    }

    @Override
    public int hashCode() {
        return mResult.hashCode();
    }
}
