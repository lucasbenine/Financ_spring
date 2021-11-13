package com.example.projetospring.util;

import com.example.projetospring.model.ContasAPagar;

public class ContasAPagarCreator {

    public static ContasAPagar creataContasAPagarToBeSaved() {
        ContasAPagar contasAPagar = new ContasAPagar("Luz", 305.78, "Despesa com moradia");
        return contasAPagar;
    }

    public static ContasAPagar createValidContasAPagar() {
        ContasAPagar contasAPagar = new ContasAPagar("Luz", 305.78, "Despesa com moradia");
        return contasAPagar;
    }

    public static ContasAPagar createValidUpdatedContasAPagar() {
        ContasAPagar contasAPagar = new ContasAPagar("Energia", 305.78, "Despesa com moradia");
        return contasAPagar;
    }
}
