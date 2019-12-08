package br.edu.utfpr.model;

import br.edu.utfpr.entity.AttackItem;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class AttackItemModel extends AbstractTableModel {

    private final List<AttackItem> attackItemList;
    private final String[] columns = new String[]{"Id", "Name", "Attack", "Speed", "Description", "Job", "Rarity"}; //para tables fixas
    private ArrayList<String> cols = new ArrayList<>(); //para tables dinamicas

    private final int ID = 0;
    private final int NAME = 1;
    private final int ATTACK = 2;
    private final int SPEED = 3;
    private final int DESCRIPTION = 4;
    private final int JOB = 5;
    private final int RARITY = 6;

    public AttackItemModel(List<AttackItem> attackItemList) {
        this.attackItemList = attackItemList;
    }

    public AttackItemModel(List<AttackItem> attackItemList, ArrayList<String> cols) { //SÓ VAI RECEBER ESSE COSNTRUTOR QUANDO HOUVER QUANTIDADE DIFERENTE DO MAX DE COLUNAS
        this.attackItemList = attackItemList;
        this.cols = cols;
    }

    @Override
    public int getRowCount() {
        return attackItemList.size();
    }

    @Override
    public int getColumnCount() {
        return cols.size() > 0 ? cols.size() : columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {//se > 0  então fazer table dinamica se não estática dinamicamente xd
        AttackItem attackItem = attackItemList.get(rowIndex);
        if (cols.size() > 0) {
            switch (cols.get(columnIndex)) {
                case "Id":
                    return attackItem.getId();
                case "Name":
                    return attackItem.getName();
                case "Attack":
                    return attackItem.getAttack();
                case "Speed":
                    return attackItem.getSpeed();
                case "Description":
                    return attackItem.getDescription();
                case "Job":
                    return attackItem.getJob();
                case "Rarity":
                    return attackItem.getRarity();
                default:
                    break;
            }
        } else {
            switch (columnIndex) {
                case ID:
                    return attackItem.getId();
                case NAME:
                    return attackItem.getName();
                case ATTACK:
                    return attackItem.getAttack();
                case SPEED:
                    return attackItem.getSpeed();
                case DESCRIPTION:
                    return attackItem.getDescription();
                case JOB:
                    return attackItem.getJob();
                case RARITY:
                    return attackItem.getRarity();
                default:
                    break;
            }
        }
        return attackItem; //rows and columns
    }

    public String[] getColumns() {
        return columns;
    }

    public void insertModel(AttackItem attackItem) {
        attackItemList.add(attackItem);
        int lastIndex = getRowCount() - 1; //
        fireTableRowsInserted(lastIndex, lastIndex); // notificar a table que ela sofreu uma alteração (INSERT), (notificar apenas o que foi inserido)
    }

    public void deleteModel(int rowIndex) {
        attackItemList.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex); // notificar a table que ela sofreu uma alteração (INSERT), (notificar apenas o que foi inserido)
    }

    public void updateModel(AttackItem attackItem, int rowIndex) {
        attackItemList.set(rowIndex, attackItem);
        fireTableRowsUpdated(rowIndex, rowIndex);
    }

    @Override
    public String getColumnName(int columnIndex) {
        return cols.size() > 0 ? cols.get(columnIndex) : columns[columnIndex];
    }
}
