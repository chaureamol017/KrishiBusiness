package com.mycomp.business.krishi.api.adapter;

import com.google.common.collect.Lists;

import java.util.List;

public interface WebAdaptor<I, O>  {
    default List<O> toServiceModel(List<I> requests) {
        if (null == requests) {
            return Lists.newArrayList();
        }
        return Lists.transform(requests, this::toServiceModel);
    }

    default List<I> toWebModel(List<O> models) {
        if (null == models) {
            return Lists.newArrayList();
        }

        return Lists.transform(models, this::toWebModel);
    }

    O toServiceModel(I model);

    I toWebModel(O entity);
}
