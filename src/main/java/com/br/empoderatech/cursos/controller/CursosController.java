package com.br.empoderatech.cursos.controller;

import com.br.empoderatech.cursos.domain.Cursos;
import com.br.empoderatech.cursos.domain.dtos.CursosDTO;
import com.br.empoderatech.cursos.services.CursosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")
public class CursosController {

    @Autowired
    private CursosService cursosService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cursos createCurso(@RequestBody CursosDTO dto) {
        return cursosService.createCurso(dto);
    }

    @GetMapping("/buscar")
    public Optional<Cursos> findByName(@RequestParam String nome) {
        return cursosService.findByName(nome);
    }

    @GetMapping("/disponiveis")
    public List<Cursos> cursosDisponiveis() {
        return cursosService.cursosDisponiveis();
    }

    @PutMapping("/{id}")
    public Cursos updateCurso(@PathVariable Long id, @RequestBody CursosDTO dto) {
        return cursosService.updateCurso(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCurso(@PathVariable Long id) {
        cursosService.deleteCurso(id);
    }

}
