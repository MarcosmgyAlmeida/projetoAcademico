package br.com.marcosAlmeida.projetoAcademico;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class projetoAcademico {
    String[] alunos = new String[10];
    @GetMapping("alunos/listar")
    public String [] alunos() {

        return alunos;
    }

    @GetMapping("alunos/incluir/{nomeDoAluno}")
    public String incluirAluno(@PathVariable("nomeDoAluno") String nomeDoAluno){
        String fraseRetorno = "";
        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i] == null) {
                alunos[i] = nomeDoAluno;
                fraseRetorno = nomeDoAluno+ " Incluído com sucesso";
                break;

            } else  if (alunos[i] != null) {
                fraseRetorno = "Espaço insuficiene";
            }
        }
        return fraseRetorno;
    }
    @GetMapping("alunos/excluir/{nomeDoAluno}")
    public String excluirAluno(@PathVariable("nomeDoAluno") String nomeDoAluno){
        String fraseRetorno = "";
        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i] != null && alunos[i].equals(nomeDoAluno)) {
                alunos[i] = null;
                fraseRetorno = nomeDoAluno + " excluído com sucesso";
                break;
            }
        }
        return fraseRetorno;
    }
    @GetMapping("alunos/substituir/{alunoAntigo}/{alunoNovo}")
    public String substituirAluno(@PathVariable("alunoAntigo") String alunoAntigo, @PathVariable("alunoNovo") String alunoNovo){
        String fraseRetorno = "";
        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i] != null && alunos[i].equals((alunoAntigo))) {
                alunos[i] = alunoNovo;
                fraseRetorno = alunoNovo+ " substituido para " + alunoNovo;
                break;

            }

        }
        return fraseRetorno;
    }
}
