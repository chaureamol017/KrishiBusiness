package com.mycomp.common.adapter;

import com.google.common.collect.Lists;

import java.util.List;

public interface WebAdapter<I, O>  {
    default List<O> toModel(List<I> requests) {
        if (null == requests) {
            return Lists.newArrayList();
        }
        return Lists.transform(requests, this::toModel);
    }

    default List<I> toWeb(List<O> models) {
        if (null == models) {
            return Lists.newArrayList();
        }

        return Lists.transform(models, this::toWeb);
    }

    O toModel(I model);

    I toWeb(O entity);
}
