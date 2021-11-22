package com.mycomp.business.krishi.api.adapter;

import com.google.common.collect.Lists;

import java.util.List;

public interface ModelAdaptor<I, O>  {
    default List<O> toEntityMinimal(List<I> models) {
        if (null == models) {
            return Lists.newArrayList();
        }
        return Lists.transform(models, this::toEntityMinimal);
    }

    default List<O> toEntity(List<I> models) {
        if (null == models) {
            return Lists.newArrayList();
        }
        return Lists.transform(models, this::toEntity);
    }

    default List<I> toServiceModel(List<O> entities) {
        if (null == entities) {
            return Lists.newArrayList();
        }

        return Lists.transform(entities, this::toServiceModel);
    }

    O toEntityMinimal(I model);

    O toEntity(I model);

    I toServiceModel(O entity);
}
