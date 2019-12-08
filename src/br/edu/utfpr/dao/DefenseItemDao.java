package br.edu.utfpr.dao;

import br.edu.utfpr.entity.DefenseItem;
import br.edu.utfpr.enumeration.Gear;
import br.edu.utfpr.enumeration.Job;
import br.edu.utfpr.enumeration.Rarity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;

public class DefenseItemDao extends AbstractDao<DefenseItem> {

    private final String INSERT = "INSERT INTO defenseitem(name, defense, gear, description, job, rarity) VALUES(?, ?, ?, ?, ?, ?);";
    private PreparedStatement pstm;
    private ResultSet rs;

    @Override
    public boolean insert(DefenseItem defenseItem) {
        boolean state;
        super.openConnection();
        try {
            pstm = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, defenseItem.getName());
            pstm.setInt(2, defenseItem.getDefense());
            pstm.setString(3, defenseItem.getGear().getDescription());
            pstm.setString(4, defenseItem.getDescription());
            pstm.setString(5, defenseItem.getJob().getDescription());
            pstm.setString(6, defenseItem.getRarity().getDescription());
            pstm.executeUpdate();

            rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                defenseItem.setId(rs.getInt(1));
            }
            state = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            state = false;
        } finally {
            super.closeConnection();
        }
        return state;
    }

    @Override
    public boolean delete(int id) {
        super.openConnection();
        try {
            pstm = connection.prepareStatement("DELETE FROM defenseItem WHERE ID = ?");
            pstm.setInt(1, id);
            return pstm.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not possible to delete: " + ex.getMessage());
            return false;
        } finally {
            super.closeConnection();
        }
    }

    @Override
    public boolean update(DefenseItem defenseItem) {
        super.openConnection();
        try {
            pstm = connection.prepareStatement("UPDATE defenseitem SET name = ?, defense = ?, gear = ?, description = ?, job = ?, rarity = ? WHERE id = ?");
            pstm.setString(1, defenseItem.getName());
            pstm.setInt(2, defenseItem.getDefense());
            pstm.setString(3, defenseItem.getGear().getDescription());
            pstm.setString(4, defenseItem.getDescription());
            pstm.setString(5, defenseItem.getJob().getDescription());
            pstm.setString(6, defenseItem.getRarity().getDescription());
            pstm.setInt(7, defenseItem.getId());

            return pstm.executeUpdate() != 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not possible to update: " + ex.getMessage());
            return false;
        }
    }

    public DefenseItem getDefenseItemById(int index) {
        DefenseItem defenseItem = new DefenseItem();
        super.openConnection();
        try {
            pstm = connection.prepareCall("SELECT * FROM defenseitem WHERE id = ?");
            pstm.setInt(1, index);
            rs = pstm.executeQuery();
            while (rs.next()) {
                defenseItem.setId(rs.getInt("id"));
                defenseItem.setName(rs.getString("name"));
                defenseItem.setDefense(rs.getInt("defense"));
                defenseItem.setGear(Gear.valueOf(rs.getString("gear").toUpperCase()));
                defenseItem.setDescription(rs.getString("description"));
                defenseItem.setJob(Job.valueOf(rs.getString("job").toUpperCase()));
                defenseItem.setRarity(Rarity.valueOf(rs.getString("rarity").toUpperCase()));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return defenseItem;
    }

    public DefenseItem getDefenseItemByCharId(int index) {
        DefenseItem defenseItem = new DefenseItem();
        super.openConnection();
        try {
            pstm = connection.prepareCall("SELECT defenseitem.* FROM defenseitem JOIN character ON (character.iddefense = defenseitem.id) WHERE character.id = ?");
            pstm.setInt(1, index);
            rs = pstm.executeQuery();
            while (rs.next()) {
                defenseItem.setId(rs.getInt("id"));
                defenseItem.setName(rs.getString("name"));
                defenseItem.setDefense(rs.getInt("defense"));
                defenseItem.setGear(Gear.valueOf(rs.getString("gear").toUpperCase()));
                defenseItem.setDescription(rs.getString("description"));
                defenseItem.setJob(Job.valueOf(rs.getString("job").toUpperCase()));
                defenseItem.setRarity(Rarity.valueOf(rs.getString("rarity").toUpperCase()));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return defenseItem;
    }

    public Vector<String> getDI(String query) {
        Vector<String> defenseItemList = new Vector<>();
        super.openConnection();
        try {
            if(!query.isEmpty()){
                pstm = connection.prepareStatement("SELECT name FROM defenseitem where job = ?");
                pstm.setString(1, query);
            } else {
                pstm = connection.prepareStatement("SELECT name FROM defenseitem");
            }          
            rs = pstm.executeQuery();
            while (rs.next()) {
                defenseItemList.add(rs.getString("name"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not possible to select: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return defenseItemList;
    }

    public boolean getBoundedItem(int index) {
        super.openConnection();
        try {
            pstm = connection.prepareCall("select idDefense from character join defenseitem on (defenseitem.id = character.idDefense) where idDefense = ?");
            pstm.setInt(1, index);
            System.out.println("select idDefense from character join defenseitem on (defenseitem.id = character.idDefense) where idDefense = " + index);
            rs = pstm.executeQuery();
            if (rs.next()) { //possui tuplas
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro:" + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return false;
    }

    public boolean getDefenseItemByName(String nome) {
        super.openConnection();
        try {
            pstm = connection.prepareCall("SELECT name FROM defenseitem WHERE name = ?");
            pstm.setString(1, nome);
            rs = pstm.executeQuery();
            if (rs.next()) {
                return rs.getString("name").equals(nome);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro:" + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return false;
    }

    public DefenseItem getDefItem(String nome) {
        super.openConnection();
        DefenseItem defenseItem = new DefenseItem();
        try {
            pstm = connection.prepareCall("SELECT * FROM defenseItem WHERE name = ?");
            pstm.setString(1, nome);
            rs = pstm.executeQuery();
            if (rs.next()) {
                defenseItem.setId(rs.getInt("id"));
                defenseItem.setName(rs.getString("name"));
                defenseItem.setDefense(rs.getInt("defense"));
                defenseItem.setGear(Gear.valueOf(rs.getString("gear").toUpperCase()));
                defenseItem.setDescription(rs.getString("description"));
                defenseItem.setJob(Job.valueOf(rs.getString("job").toUpperCase()));
                defenseItem.setRarity(Rarity.valueOf(rs.getString("rarity").toUpperCase()));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro:" + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return defenseItem;
    }

    public int getCount() {
        super.openConnection();
        try {
            pstm = connection.prepareCall("SELECT count(*) FROM defenseitem");
            rs = pstm.executeQuery();
            if (rs.next()) {
                return rs.getInt("count");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro:" + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return 0;
    }

    public List<DefenseItem> getDefenseItems() {
        List<DefenseItem> defenseItemList = new ArrayList<>();
        super.openConnection();
        try {
            pstm = connection.prepareStatement("SELECT * FROM defenseItem");
            rs = pstm.executeQuery();
            while (rs.next()) {
                DefenseItem defenseItem = new DefenseItem();
                defenseItem.setId(rs.getInt("id"));
                defenseItem.setName(rs.getString("name"));
                defenseItem.setDefense(rs.getInt("defense"));
                defenseItem.setGear(Gear.valueOf(rs.getString("gear").toUpperCase()));
                defenseItem.setDescription(rs.getString("description"));
                defenseItem.setJob(Job.valueOf(rs.getString("job").toUpperCase()));
                defenseItem.setRarity(Rarity.valueOf(rs.getString("rarity").toUpperCase()));
                defenseItemList.add(defenseItem);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not possible to select: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return defenseItemList;
    }

    public List<DefenseItem> search(String field, String query, int index, int value) {
        List<DefenseItem> defenseItemList = new ArrayList<>();
        super.openConnection();
        try {
            if (index == 0) {
                pstm = connection.prepareCall("SELECT * FROM defenseitem WHERE " + field + " = ?");
                if (value == 1) {
                    pstm.setInt(1, Integer.parseInt(query));
                } else {
                    pstm.setString(1, query);
                }
            } else if (index == 1) {
                pstm = connection.prepareCall("SELECT * FROM defenseitem WHERE upper(" + field + "::varchar) like ? ");
                pstm.setString(1, '%' + (query + '%').toUpperCase());
            } else if (index == 2) {
                pstm = connection.prepareCall("SELECT * FROM defenseitem WHERE upper(" + field + "::varchar) like ? ");
                pstm.setString(1, (query + '%').toUpperCase());
            } else {
                pstm = connection.prepareCall("SELECT * FROM defenseitem WHERE upper(" + field + "::varchar) like ? ");
                pstm.setString(1, ('%' + query).toUpperCase());
            }
            rs = pstm.executeQuery();
            while (rs.next()) {
                DefenseItem defenseItem = new DefenseItem();
                defenseItem.setId(rs.getInt("id"));
                defenseItem.setName(rs.getString("name"));
                defenseItem.setDefense(rs.getInt("defense"));
                defenseItem.setGear(Gear.valueOf(rs.getString("gear").toUpperCase()));
                defenseItem.setDescription(rs.getString("description"));
                defenseItem.setJob(Job.valueOf(rs.getString("job").toUpperCase()));
                defenseItem.setRarity(Rarity.valueOf(rs.getString("rarity").toUpperCase()));
                defenseItemList.add(defenseItem);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not possible to select: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return defenseItemList;
    }

    public List<DefenseItem> searchFilter(ArrayList<String> sql) {
        List<DefenseItem> defenseItems = new ArrayList<>();
        String query = "";
        super.openConnection();
        try {
            for (String s : sql) {
                query += s + ",";
            }
            if (query.endsWith(",")) {
                query = query.substring(0, query.length() - 1);
            }

            pstm = connection.prepareCall("SELECT " + query + " FROM defenseitem");
            System.out.println("SELECT " + query + " FROM defenseitem");
            rs = pstm.executeQuery();
            while (rs.next()) {
                DefenseItem defenseItem = new DefenseItem();
                if (sql.contains("Id")) {
                    defenseItem.setId(rs.getInt("id"));
                }
                if (sql.contains("Name")) {
                    defenseItem.setName(rs.getString("name"));
                }
                if (sql.contains("Defense")) {
                    defenseItem.setDefense(rs.getInt("defense"));
                }
                if (sql.contains("Gear")) {
                    defenseItem.setGear(Gear.valueOf(rs.getString("gear").toUpperCase()));
                }
                if (sql.contains("Description")) {
                    defenseItem.setDescription(rs.getString("description"));
                }
                if (sql.contains("Job")) {
                    defenseItem.setJob(Job.valueOf(rs.getString("job").toUpperCase()));
                }
                if (sql.contains("Rarity")) {
                    defenseItem.setRarity(Rarity.valueOf(rs.getString("rarity").toUpperCase()));
                }
                defenseItems.add(defenseItem);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not possible to select: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return defenseItems;
    }

    public List<DefenseItem> searchFill(HashMap<String, String> sql) {
        List<DefenseItem> defenseItemList = new ArrayList<>();
        String where = "";
        super.openConnection();
        try {
            int i = 0;
            int count = 0;
            for (HashMap.Entry<String, String> entry : sql.entrySet()) {
                if (entry.getKey().equals("Id") || entry.getKey().equals("Name") || entry.getKey().equals("Defense") || entry.getKey().equals("Gear")
                        || entry.getKey().equals("Description") || entry.getKey().equals("Job") || entry.getKey().equals("Rarity")) {
                    where += entry.getKey() + " = ? AND ";
                    count++;
                }
                i++;
            }
            if (where.endsWith("AND ") && count > 0) {
                where = where.substring(0, where.length() - 4);
            }

            //System.out.println("Query: " + query + " Where: " + where);
            if (count > 0) {
                pstm = connection.prepareCall("SELECT * FROM defenseitem WHERE " + where);
                i = 1;
                for (HashMap.Entry<String, String> entry : sql.entrySet()) {
                    if (entry.getKey().equals("Id") || entry.getKey().equals("Defense")) {
                        pstm.setInt(i, Integer.parseInt(entry.getValue()));
                    } else {
                        pstm.setString(i, entry.getValue());
                    }
                    i++;
                }
            } else {
                pstm = connection.prepareCall("SELECT * FROM defenseitem");
            }

            rs = pstm.executeQuery();
            while (rs.next()) {
                DefenseItem defenseItem = new DefenseItem();
                defenseItem.setId(rs.getInt("id"));
                defenseItem.setName(rs.getString("name"));
                defenseItem.setDefense(rs.getInt("defense"));
                defenseItem.setGear(Gear.valueOf(rs.getString("gear").toUpperCase()));
                defenseItem.setDescription(rs.getString("description"));
                defenseItem.setJob(Job.valueOf(rs.getString("job").toUpperCase()));
                defenseItem.setRarity(Rarity.valueOf(rs.getString("rarity").toUpperCase()));
                defenseItemList.add(defenseItem);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not possible to select: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return defenseItemList;
    }
}
