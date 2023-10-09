package com.fullstack.s3.shared.mapper;

import java.util.List;

public interface EntityToDto<E, O> {

  O toDto(E entity);

  E toEntity(O toDto);


  List<O> toDto(List<E> entity);

  List<E> toEntity(List<O> toDto);


}
