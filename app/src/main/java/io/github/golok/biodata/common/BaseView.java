package io.github.golok.biodata.common;

public interface BaseView<T extends BasePresenter> {
    void setPresenter(T presenter);
}
