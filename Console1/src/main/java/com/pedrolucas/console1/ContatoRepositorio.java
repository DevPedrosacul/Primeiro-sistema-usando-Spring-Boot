package com.pedrolucas.console1;

import com.pedrolucas.console1.entidades.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepositorio  extends JpaRepository<Contato, Long> {
}


