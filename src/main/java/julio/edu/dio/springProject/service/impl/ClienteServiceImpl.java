package julio.edu.dio.springProject.service.impl;

import julio.edu.dio.springProject.model.Cliente;
import julio.edu.dio.springProject.model.Endereco;
import julio.edu.dio.springProject.repository.ClienteRepository;
import julio.edu.dio.springProject.repository.EnderecoRepository;
import julio.edu.dio.springProject.service.ClienteService;
import julio.edu.dio.springProject.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElseThrow();
    }

    @Override
    public Cliente adicionar(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = resgatarSalvarEnderecoDb(cep);

        cliente.setEndereco(endereco);
        return clienteRepository.save(cliente);
    }


    @Override
    public Cliente atualizar(Long id, Cliente cliente) {
        //verificando se cliente existe no banco de dados
        clienteRepository.findById(id).orElseThrow();

        String cep = cliente.getEndereco().getCep();
        Endereco endereco = resgatarSalvarEnderecoDb(cep);

        cliente.setEndereco(endereco);
        return clienteRepository.save(cliente);
    }

    @Override
    public void remover(Long id) {
        clienteRepository.deleteById(id);
    }

    private Endereco resgatarSalvarEnderecoDb(String cep) {
        return enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.retornarEndereco(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
    }
}
