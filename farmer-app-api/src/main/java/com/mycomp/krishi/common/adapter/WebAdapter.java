package com.mycomp.krishi.common.adapter;

import com.google.common.collect.Lists;

import java.util.List;

public interface WebAdapter<I, R, M>  {
    default List<M> toModel(List<I> requests) {
        if (null == requests) {
            return Lists.newArrayList();
        }
        return Lists.transform(requests, this::toModel);
    }

    default List<R> toWeb(List<M> models) {
        if (null == models) {
            return Lists.newArrayList();
        }
        return Lists.transform(models, this::toWeb);
    }

    M toModel(I model);

    R toWeb(M entity);
}
