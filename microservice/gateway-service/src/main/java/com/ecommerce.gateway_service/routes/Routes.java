package com.ecommerce.gateway_service.routes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.filter.LoadBalancerFilterFunctions.lb;
import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;

@Configuration
public class Routes {

    @Bean
    public RouterFunction<ServerResponse> clienteServiceRoute() {
        return route("cliente_service")
                .route(
                        RequestPredicates.path("/api/v1/clientes/**"),
                        http()
                )
                .filter(lb("CLIENTE-SERVICE"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> produtoServiceRoute() {
        return route("produto_service")
                .route(
                        RequestPredicates.path("/api/v1/produtos/**"),
                        http()
                )
                .filter(lb("PRODUTO-SERVICE"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> pedidoServiceRoute() {
        return route("pedido_service")
                .route(
                        RequestPredicates.path("/api/v1/pedidos/**"),
                        http()
                )
                .filter(lb("PEDIDO-SERVICE"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> pagamentoServiceRoute() {
        return route("pagamento_service")
                .route(
                        RequestPredicates.path("/api/v1/pagamentos/**"),
                        http()
                )
                .filter(lb("PAGAMENTO-SERVICE"))
                .build();
    }
}