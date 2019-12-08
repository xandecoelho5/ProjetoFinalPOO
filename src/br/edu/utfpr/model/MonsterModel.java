package br.edu.utfpr.model;

import br.edu.utfpr.entity.Monster;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class MonsterModel extends AbstractTableModel {

    private final List<Monster> monsterList;
    private final String[] columns = new String[]{"Id", "Name", "Hp", "Attack", "Defense", "Speed", "Race", "Type"};
    private ArrayList<String> cols = new ArrayList<>();

    private final int ID = 0;
    private final int NAME = 1;
    private final int HP = 2;
    private final int ATTACK = 3;
    private final int DEFENSE = 4;
    private final int SPEED = 5;
    private final int RACE = 6;
    private final int TYPE = 7;

    public MonsterModel(List<Monster> monsterList) {
        this.monsterList = monsterList;
    }

    public MonsterModel(List<Monster> monsterList, ArrayList<String> cols) {
        this.monsterList = monsterList;
        this.cols = cols;
    }

    @Override
    public int getRowCount() {
        return monsterList.size();
    }

    @Override
    public int getColumnCount() {
        return cols.size() > 0 ? cols.size() : columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Monster monster = monsterList.get(rowIndex);
        if (cols.size() > 0) {
            switch (cols.get(columnIndex)) {
                case "Id":
                    return monster.getId();
                case "Name":
                    return monster.getName();//.format(format)
                case "Hp":
                    return monster.getHp();
                case "Attack":
                    return monster.getAttack();
                case "Defense":
                    return monster.getDefense();
                case "Speed":
                    return monster.getSpeed();
                case "Race":
                    return monster.getRace();
                case "Type":
                    return monster.getType();
                default:
                    break;
            }
        } else {
            switch (columnIndex) {
                case ID:
                    return monster.getId();
                case NAME:
                    return monster.getName();
                case HP:
                    return monster.getHp();
                case ATTACK:
                    return monster.getAttack();
                case DEFENSE:
                    return monster.getDefense();
                case SPEED:
                    return monster.getSpeed();
                case RACE:
                    return monster.getRace();
                case TYPE:
                    return monster.getType();
                default:
                    break;
            }
        }
        return monster; //rows and columns
    }

    public String[] getColumns() {
        return columns;
    }

    public void insertModel(Monster monster) {
        monsterList.add(monster);
        int lastIndex = getRowCount() - 1; //
        fireTableRowsInserted(lastIndex, lastIndex); // notificar a table que ela sofreu uma alteração (INSERT), (notificar apenas o que foi inserido)
    }

    public void deleteModel(int rowIndex) {
        monsterList.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex); // notificar a table que ela sofreu uma alteração (INSERT), (notificar apenas o que foi inserido)
    }

    public void updateModel(Monster monster, int rowIndex) {
        monsterList.set(rowIndex, monster);
        fireTableRowsUpdated(rowIndex, rowIndex);
    }

    @Override
    public String getColumnName(int columnIndex) {
        return cols.size()>0 ? cols.get(columnIndex) : columns[columnIndex];
    }
}
