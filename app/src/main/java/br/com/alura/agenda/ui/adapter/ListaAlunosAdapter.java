package br.com.alura.agenda.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.agenda.model.Aluno;
import missing.namespace.R;

public class ListaAlunosAdapter extends BaseAdapter {

    private final List<Aluno> alunos = new ArrayList<>();
    private final Context context;

    public ListaAlunosAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Aluno getItem(int posicao) {
        return alunos.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return alunos.get(posicao).getId();
    }

    @Override
    public View getView(int posicao, View view, ViewGroup viewGroup) {
        View viewCriada = criarView(viewGroup);
        Aluno alunoDevolvido = alunos.get(posicao);
        vincula(alunoDevolvido, viewCriada);
        return viewCriada;
    }

    private void vincula(Aluno aluno, View viewCriada) {
        TextView nomeAluno = viewCriada.findViewById(R.id.item_aluno_nome);
        nomeAluno.setText(aluno.getNome());
        TextView telefone = viewCriada.findViewById(R.id.item_aluno_telefone);
        telefone.setText(aluno.getTelefone());
    }

    private View criarView(ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.item_aluno, viewGroup, false);
    }


    private void clear() {
        alunos.clear();
    }

    private void addAll(List<Aluno> todosAlunos) {
        this.alunos.addAll(todosAlunos);
    }

    public void remove(Aluno aluno) {
        alunos.remove(aluno);
        notifyDataSetChanged();
    }

    public void atualiza(List<Aluno> alunos){
        this.alunos.clear();
        this.alunos.addAll(alunos);
        notifyDataSetChanged();
    }
}
