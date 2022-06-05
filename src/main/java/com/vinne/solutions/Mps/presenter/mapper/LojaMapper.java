package com.vinne.solutions.Mps.presenter.mapper;

import com.vinne.solutions.Mps.infra.model.Category;
import loja.v1.model.CategoryRepresentation;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface LojaMapper {

	Category paraCategoriaDomain(CategoryRepresentation source);

}
