package com.mycomp.common.adapter;

import com.google.common.collect.Lists;

import java.util.List;

public interface ModelAdapter<I, O>  {
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

    default List<I> toModel(List<O> entities) {
        if (null == entities) {
            return Lists.newArrayList();
        }

        return Lists.transform(entities, this::toModel);
    }

    O toEntityMinimal(I model);

    O toEntity(I model);

    I toModel(O entity);
}
