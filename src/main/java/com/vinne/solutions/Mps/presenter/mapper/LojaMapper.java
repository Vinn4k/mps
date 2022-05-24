package com.vinne.solutions.Mps.presenter.mapper;

import com.vinne.solutions.Mps.domain.usercases.Category;
import loja.v1.model.CategoryRepresentation;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface LojaMapper {

	Category paraCategoriaDomain(CategoryRepresentation source);
}
