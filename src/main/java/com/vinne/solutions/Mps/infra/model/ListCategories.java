package com.vinne.solutions.Mps.infra.model;

import loja.v1.model.CategoryRepresentation;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class ListCategories {

    private List<CategoryRepresentation> categories;
}
