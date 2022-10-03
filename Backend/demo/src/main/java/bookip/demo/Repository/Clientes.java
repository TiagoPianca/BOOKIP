package bookip.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bookip.demo.models.clientes;

public interface Clientes extends JpaRepository<clientes, Long> {
    
}
