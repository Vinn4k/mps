package com.vinne.solutions.Mps.util;

import com.vinne.solutions.Mps.infra.model.Category;
import com.vinne.solutions.Mps.infra.model.UserModel;
import loja.v1.model.CategoryRepresentation;
import lombok.experimental.UtilityClass;
import org.jeasy.random.EasyRandom;

@UtilityClass
public class LojaUtils {

    public static CategoryRepresentation categoryRepresentationMock(){
        return new EasyRandom().nextObject(CategoryRepresentation.class);
    }

    public static UserModel userMock(){
        return new EasyRandom().nextObject(UserModel.class);
    }

    public static Category categoryDomainMock(){
        return new EasyRandom().nextObject(Category.class);
    }
}
