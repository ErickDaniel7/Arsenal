package com.example.aplicativopontodevenda.model;

public class PagamentoModel {
    private int id;
    private int id_pedido;
    private double valor_pago;
    private String metodo_pagamento;

    public PagamentoModel() {
    }

    public PagamentoModel(int id, int id_pedido, double valor_pago, String metodo_pagamento) {
        this.id = id;
        this.id_pedido = id_pedido;
        this.valor_pago = valor_pago;
        this.metodo_pagamento = metodo_pagamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public double getValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(double valor_pago) {
        this.valor_pago = valor_pago;
    }

    public String getMetodo_pagamento() {
        return metodo_pagamento;
    }

    public void setMetodo_pagamento(String metodo_pagamento) {
        this.metodo_pagamento = metodo_pagamento;
    }
}

