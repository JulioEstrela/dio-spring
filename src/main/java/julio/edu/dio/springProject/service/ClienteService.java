package julio.edu.dio.springProject.service;

import julio.edu.dio.springProject.model.Cliente;

public interface ClienteService {
    Iterable<Cliente> buscarTodos();
    Cliente buscarPorId(Long id);

    Cliente adicionar(Cliente cliente);
    Cliente atualizar(Long id, Cliente cliente);
    void remover(Long id);
}
