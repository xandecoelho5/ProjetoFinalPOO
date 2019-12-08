package br.edu.utfpr.model;

import br.edu.utfpr.dao.AttackItemDao;
import br.edu.utfpr.dao.DefenseItemDao;
import br.edu.utfpr.entity.AttackItem;
import br.edu.utfpr.entity.Character;
import br.edu.utfpr.entity.DefenseItem;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CharacterModel extends AbstractTableModel {

    private final List<br.edu.utfpr.entity.Character> characterList;
   /* private final List<AttackItem> attackItemList;
    private final List<DefenseItem> defenseItemList;*/
    private final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final String[] columns = new String[]{"Id", "Data", "Nickname", "Sex", "Hp", "Attack", "Defense", "Speed", "Job", "idAttack", "idDefense"};
    private ArrayList<String> cols = new ArrayList<>();

    private final int ID = 0;
    private final int DATA = 1;
    private final int NICKNAME = 2;
    private final int SEX = 3;
    private final int HP = 4;
    private final int ATTACK = 5;
    private final int DEFENSE = 6;
    private final int SPEED = 7;
    private final int JOB = 8;
    private final int IDATTACK = 9;
    private final int IDDEFENSE = 10;

    public CharacterModel(List<Character> characterList) {
        this.characterList = characterList;
       /* this.attackItemList = (ArrayList)new AttackItemDao().getAttackItems();
        this.defenseItemList = (ArrayList)new DefenseItemDao().getDefenseItems();*/
    }

    public CharacterModel(List<Character> characterList, ArrayList<String> cols) {
        this.characterList = characterList;
        this.cols = cols;
    }

    @Override
    public int getRowCount() {
        return characterList.size();
    }

    @Override
    public int getColumnCount() {
        return cols.size() > 0 ? cols.size() : columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Character character = characterList.get(rowIndex);
        if (cols.size() > 0) {
            switch (cols.get(columnIndex)) {
                case "Id":
                    return character.getId();
                case "Data":
                    return character.getDate();//.format(format)
                case "Nickname":
                    return character.getNickname();
                case "Sex":
                    return character.getSex();
                case "Hp":
                    return character.getHp();
                case "Attack":
                    return character.getAttack();
                case "Defense":
                    return character.getDefense();
                case "Speed":
                    return character.getSpeed();
                case "Job":
                    return character.getJob();
                case "IdAttack":
                    return character.getAttackItem().getName();
                case "IdDefense":
                    return character.getDefenseItem().getName();
                default:
                    break;
            }
        } else {
            switch (columnIndex) {
                case ID:
                    return character.getId();
                case DATA:
                    return character.getDate();//.format(format)
                case NICKNAME:
                    return character.getNickname();
                case SEX:
                    return character.getSex();
                case HP:
                    return character.getHp();
                case ATTACK:
                    return character.getAttack();
                case DEFENSE:
                    return character.getDefense();
                case SPEED:
                    return character.getSpeed();
                case JOB:
                    return character.getJob();
                case IDATTACK:
                    return character.getAttackItem().getName();
                case IDDEFENSE:
                    return character.getDefenseItem().getName();
                default:
                    break;
            }
        }
        return character; //rows and columns
    }

    public String[] getColumns() {
        return columns;
    }

    public void insertModel(Character character) {
        characterList.add(character);
        int lastIndex = getRowCount() - 1; //
        fireTableRowsInserted(lastIndex, lastIndex); // notificar a table que ela sofreu uma alteração (INSERT), (notificar apenas o que foi inserido)
    }

    public void deleteModel(int rowIndex) {
        characterList.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex); // notificar a table que ela sofreu uma alteração (INSERT), (notificar apenas o que foi inserido)
    }

    public void updateModel(Character character, int rowIndex) {
        characterList.set(rowIndex, character);
        fireTableRowsUpdated(rowIndex, rowIndex);
    }

    @Override
    public String getColumnName(int columnIndex) {
        return cols.size()>0 ? cols.get(columnIndex) : columns[columnIndex];
    }
}
