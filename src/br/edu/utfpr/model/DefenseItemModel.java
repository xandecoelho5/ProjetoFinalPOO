package br.edu.utfpr.model;

import br.edu.utfpr.entity.DefenseItem;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class DefenseItemModel extends AbstractTableModel {

    private final List<DefenseItem> defenseItemList;
    private final String[] columns = new String[]{"Id", "Name", "Defense", "Gear", "Description", "Job", "Rarity"};
    private ArrayList<String> cols = new ArrayList<>();

    private final int ID = 0;
    private final int NAME = 1;
    private final int DEFENSE = 2;
    private final int GEAR = 3;
    private final int DESCRIPTION = 4;
    private final int JOB = 5;
    private final int RARITY = 6;

    public DefenseItemModel(List<DefenseItem> defenseItemList) {
        this.defenseItemList = defenseItemList;
    }

    public DefenseItemModel(List<DefenseItem> defenseItemList, ArrayList<String> cols) {
        this.defenseItemList = defenseItemList;
        this.cols = cols;
    }

    @Override
    public int getRowCount() {
        return defenseItemList.size();
    }

    @Override
    public int getColumnCount() {
        return cols.size() > 0 ? cols.size() : columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DefenseItem defenseItem = defenseItemList.get(rowIndex);
        if (cols.size() > 0) {
            switch (cols.get(columnIndex)) {
                case "Id":
                    return defenseItem.getId();
                case "Name":
                    return defenseItem.getName();
                case "Defense":
                    return defenseItem.getDefense();
                case "Gear":
                    return defenseItem.getGear();
                case "Description":
                    return defenseItem.getDescription();
                case "Job":
                    return defenseItem.getJob();
                case "Rarity":
                    return defenseItem.getRarity();
                default:
                    break;
            }
        } else {
            switch (columnIndex) {
                case ID:
                    return defenseItem.getId();
                case NAME:
                    return defenseItem.getName();
                case DEFENSE:
                    return defenseItem.getDefense();
                case GEAR:
                    return defenseItem.getGear();
                case DESCRIPTION:
                    return defenseItem.getDescription();
                case JOB:
                    return defenseItem.getJob();
                case RARITY:
                    return defenseItem.getRarity();
                default:
                    break;
            }
        }

        return defenseItem; //rows and columns
    }

    public String[] getColumns() {
        return columns;
    }

    public void insertModel(DefenseItem defenseItem) {
        defenseItemList.add(defenseItem);
        int lastIndex = getRowCount() - 1; //
        fireTableRowsInserted(lastIndex, lastIndex); // notificar a table que ela sofreu uma alteração (INSERT), (notificar apenas o que foi inserido)
    }

    public void deleteModel(int rowIndex) {
        defenseItemList.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex); // notificar a table que ela sofreu uma alteração (INSERT), (notificar apenas o que foi inserido)
    }

    public void updateModel(DefenseItem defenseItem, int rowIndex) {
        defenseItemList.set(rowIndex, defenseItem);
        fireTableRowsUpdated(rowIndex, rowIndex);
    }

    @Override
    public String getColumnName(int columnIndex) {
        return cols.size() > 0 ? cols.get(columnIndex) : columns[columnIndex];
    }
}
