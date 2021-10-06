package com.example.projetospring.util;

import com.example.projetospring.model.ContasAPagar;

public class ContasAPagarCreator {

    public static ContasAPagar creataContasAPagarToBeSaved() {
        ContasAPagar contasAPagar = new ContasAPagar(null, "Luz", 305.78, "Despesa com moradia");
        return contasAPagar;
    }

    public static ContasAPagar createValidContasAPagar() {
        ContasAPagar contasAPagar = new ContasAPagar(1L, "Luz", 305.78, "Despesa com moradia");
        return contasAPagar;
    }

    public static ContasAPagar createValidUpdatedContasAPagar() {
        ContasAPagar contasAPagar = new ContasAPagar(1L, "Energia", 305.78, "Despesa com moradia");
        return contasAPagar;
    }
}
