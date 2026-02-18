package com.ecommerce.cliente_service.service;

import com.ecommerce.cliente_service.exception.ClienteNotFoundException;
import com.ecommerce.cliente_service.model.Cliente;
import com.ecommerce.cliente_service.model.dto.ClienteMapper;
import com.ecommerce.cliente_service.model.dto.ClienteRequest;
import com.ecommerce.cliente_service.model.dto.ClienteResponse;
import com.ecommerce.cliente_service.repository.ClienteRepository;
import io.micrometer.common.util.StringUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public @Nullable String addCliente(@Valid ClienteRequest request) {
        var cliente = clienteRepository.save(clienteMapper.toCliente(request));
        return cliente.getId();
    }

    public void updateCliente(ClienteRequest request) {
        var cliente = this.clienteRepository.findById(request.id())
                .orElseThrow(() -> new ClienteNotFoundException(
                        String.format("Erro ao atualizar cliente. Nenhum cliente encontrado para o ID: %s", request.id())
                ));
        mergeCliente(cliente, request);
        this.clienteRepository.save(cliente);
    }

    //programação defensiva
    private void mergeCliente(Cliente cliente, ClienteRequest request) {
        if (StringUtils.isNotBlank(request.nome())) {
            cliente.setNome(request.nome());
        }
        if (StringUtils.isNotBlank(request.sobrenome())) {
            cliente.setSobrenome(request.sobrenome());
        }
        if (StringUtils.isNotBlank(request.email())) {
            cliente.setEmail(request.email());
        }
        if (request.endereco() != null) {
            cliente.setEndereco(request.endereco());
        }
    }

    public List<ClienteResponse> findAllClientes() {
        return this.clienteRepository.findAll()
                .stream()
                .map(this.clienteMapper::fromCliente)
                .collect(Collectors.toList());
    }

    public ClienteResponse findById(String id) {
        return this.clienteRepository.findById(id)
                .map(clienteMapper::fromCliente)
                .orElseThrow(() -> new ClienteNotFoundException(String.format("Nenhum cliente encontrado para o id: %s", id)));
    }

    public void deleteCliente(String id) {
        this.clienteRepository.deleteById(id);
    }
}
