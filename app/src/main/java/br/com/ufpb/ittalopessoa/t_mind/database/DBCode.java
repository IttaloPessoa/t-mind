package br.com.ufpb.ittalopessoa.t_mind.database;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ittalo Pessoa on 06/05/2016.
 */
public class DBCode {


    public List<String> createTables() {

        List<String> tables = new ArrayList<>();

        tables.add("usuario(id integer primary key autoincrement," +
                "user varchar, senha varchar, nome varchar, sobrenome varchar)");

        tables.add("pergunta(id integer primary key autoincrement," +
                "texto varchar, tipo varchar, nivel vachar)");

        tables.add("resposta(_id integer primary key autoincrement," +
                "texto varchar, status varchar, idPergunta integer," +
                "FOREIGN KEY (idPergunta) REFERENCES pergunta(id))");
        return tables;

    }

    public List<String> inserirTables(){
        List<String> inserts = new ArrayList<>();
        //Questão 01 - Básico/Objetiva
        inserts.add("pergunta (id, texto, tipo, nivel) VALUES (1,'Considerando que cada letra pode assumir um determinado valor. Qual o será o valor final de “c” no problema a seguir?\n" +
                "a = 3\n" +
                "b = 5\n" +
                "a = b - a\n" +
                "c = a + b','objetiva','facil')");

        inserts.add("resposta (texto, status, idPergunta) VALUES ('c = 9', 'false', 1)");
        inserts.add("resposta (texto, status, idPergunta) VALUES ('c = 8', 'true', 1)");
        inserts.add("resposta (texto, status, idPergunta) VALUES ('c = 10', 'false', 1)");
        inserts.add("resposta (texto, status, idPergunta) VALUES ('c = 5', 'false', 1)");

        //Questão 02 - Básico/Aberta
        inserts.add("pergunta (id, texto, tipo, nivel) VALUES (2,'Considerando que cada letra pode assumir um determinado valor. Qual o será o valor final de “d” no problema a seguir?\n" +
                "a = 1\n" +
                "b = 6\n" +
                "c = b + a\n" +
                "d = a + b * c','aberta','facil')");
        inserts.add("resposta (texto, status, idPergunta) VALUES ('43', 'true', 2)");

        //Questão 03 Básico/Objetiva

        inserts.add("pergunta (id, texto, tipo, nivel) VALUES (3,'Qual a saída para o problema abaixo?\n" +
                "a = 16\n" +
                "b = 50\n" +
                "c = b - a\n" +
                "d = c\n" +
                "a = b\n" +
                "c = c - (a + b)','objetiva','facil')");

        inserts.add("resposta (texto, status, idPergunta) VALUES ('c = 66', 'false', 3)");
        inserts.add("resposta (texto, status, idPergunta) VALUES ('c = -66', 'true', 3)");
        inserts.add("resposta (texto, status, idPergunta) VALUES ('c = 36', 'false', 3)");
        inserts.add("resposta (texto, status, idPergunta) VALUES ('c = -36', 'false', 3)");

        //Questão 04 Intermediário/Aberta
        inserts.add("pergunta (id, texto, tipo, nivel) VALUES (4,'Com base no exemplo a seguir, qual será o valor final armazenado em resultado?\n" +
                "numero1 = 0\n" +
                "numero2 = -1\n" +
                "se numero1 for maior que número 2, resultado é -1\n" +
                "caso contrário, resultado é 0','aberta','intermediario')");

        inserts.add("resposta (texto, status, idPergunta) VALUES ('-1', 'true', 4)");

        // Questão 05 Díficil/Objetiva
        inserts.add("pergunta (id, texto, tipo, nivel) VALUES (5,'Com base no exemplo a seguir, qual será o valor final armazenado em resultado?\n" +
                "numero1 = 2.3\n" +
                "numero2 = 3/2\n" +
                "numero3 = 4/2\n" +
                "se numero1 for maior que número2 e numéro 3, resultado é 2.3 \n" +
                "se numero1 for menor que número2 e maior numéro3, resultado é 2 \n" +
                "se numero2 for maior que número1 e menor que número3, resulado é 1 \n" +
                "se numero3 for maior que número1 e maior que número2, resulado é 0 \n" +
                "caso contrário, resultado é 0','objetiva','dificil')");

        inserts.add("resposta (texto, status, idPergunta) VALUES ('resultado = 0', 'false', 5)");
        inserts.add("resposta (texto, status, idPergunta) VALUES ('resultado = 1', 'false', 5)");
        inserts.add("resposta (texto, status, idPergunta) VALUES ('resultado = 2.3', 'false', 5)");
        inserts.add("resposta (texto, status, idPergunta) VALUES ('resultado = 2', 'false', 5)");


        //Questão 06 Intermediário/Aberta
        inserts.add("pergunta (id, texto, tipo, nivel) VALUES (6,'Ajude a Roberta informando qual será sua média bimestral em Geografia com a seguinte situação:\n" +
                "nota1 = 9,3\n" +
                "nota2 = 7.7\n" +
                "nota3 = 7\n" +
                "nota3 = 7\n" +
                "media = (nota1+nota2+nota3)/3','aberta','intermediario')");

        inserts.add("resposta (texto, status, idPergunta) VALUES ('8', 'true', 6)");

        //Questão 07 Intermediário/Objetiva

        inserts.add("pergunta (id, texto, tipo, nivel) VALUES (7,'Com os números e o esquema a seguir, quais números podemos afirmar que são múltiplos de 3? \n" +
                "valores = 17, 3, 41, 4, 5, 62\n" +
                "múltiplo (qualquer valor/3,onde o resto da divisão é zero)','objetiva,'intermediario')");

        inserts.add("resposta (texto, status, idPergunta) VALUES ('todos', 'false', 7)");
        inserts.add("resposta (texto, status, idPergunta) VALUES ('3', 'true', 7)");
        inserts.add("resposta (texto, status, idPergunta) VALUES ('17 e 5', 'false', 7)");
        inserts.add("resposta (texto, status, idPergunta) VALUES ('62', 'false', 7)");

        //Questão 08 Difícil/Objetiva

        inserts.add("pergunta (id, texto, tipo, nivel) VALUES (8,'Considerando que cada letra pode assumir um determinado valor. Qual(s) linha apresentam erro? \n" +
                "linha 1: a = 3\n" +
                "linha 2: b = 1\n" +
                "linha 3: d = 3-a\n" +
                "linha 4: c = a/d\n" +
                "linha 5: e = c-a','objetiva,'dificil')");

        inserts.add("resposta (texto, status, idPergunta) VALUES ('linha 1', 'false', 8)");
        inserts.add("resposta (texto, status, idPergunta) VALUES ('linha 3', 'false', 7)");
        inserts.add("resposta (texto, status, idPergunta) VALUES ('linha 4', 'true', 8)");
        inserts.add("resposta (texto, status, idPergunta) VALUES ('linha 5', 'false', 8)");



















        return inserts;
    }


}