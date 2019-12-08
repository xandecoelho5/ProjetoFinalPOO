package br.edu.utfpr.model;

import br.edu.utfpr.entity.Monster;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class StatsModel extends AbstractTableModel {

    private ArrayList<br.edu.utfpr.entity.Character> charList = new ArrayList<>();
    private ArrayList<Monster> monsterList = new ArrayList<>();
    private final String[] columns = new String[]{"Hp", "Attack", "Defense", "Speed"};

    private final int HP = 0;
    private final int ATTACK = 1;
    private final int DEFENSE = 2;
    private final int SPEED = 3;
    
    public StatsModel(ArrayList<br.edu.utfpr.entity.Character> charList) { // NÃO SABIA OUTRO CONSTRUTOR NO MOMENTO DE MODO Q EU PUDESSE APENAS ALTERAR DE CHAR PRA MONSTRO
        this.charList = charList;    
    }
    
    public StatsModel(ArrayList<Monster> monsterList, boolean value) { //VALOR BOOLEAN APENAS DE ENFEITE PRA DIFERENCIAR DO OUTRO COSNTRUTOR;
        this.monsterList = monsterList;       
    }
    
    @Override
    public int getRowCount() {
        return charList.size()>0 ? charList.size() : monsterList.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) { //VERIFICA QUAL LISTA TEM CONTEÚDO INSERIDO, caso mosnter então mostra status do mosntro, se n, mostra do char;
        if(monsterList.size()>0){ //list.getClass().equals(Monster.class)
            Monster monster = monsterList.get(rowIndex);
            switch (columnIndex) {
                case HP:
                    return monster.getHp();
                case ATTACK:
                    return monster.getAttack();
                case DEFENSE:
                    return monster.getDefense();
                case SPEED:
                    return monster.getSpeed();
                default:
                    break;
            }
            return monster;
        } else if(charList.size()>0) { //list.getClass().equals(br.edu.utfpr.entity.Character.class)
            br.edu.utfpr.entity.Character character = charList.get(rowIndex); 
            switch (columnIndex) {
                case HP:
                    return character.getHp();
                case ATTACK:
                    return character.getAttack();
                case DEFENSE:
                    return character.getDefense();
                case SPEED:
                    return character.getSpeed();
                default:
                    break;
            }
            return character;
        }
        return null; //rows and columns
    }

    public String[] getColumns() {
        return columns;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }
}
